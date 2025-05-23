package com.tencent.weiyun.transmission.upload;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionStatus;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadJobContext;
import com.tencent.weiyun.transmission.upload.processor.InfoRecorder;
import com.tencent.weiyun.transmission.upload.processor.LocalProcessor;
import com.tencent.weiyun.transmission.upload.processor.UrlFetcher;
import com.tencent.weiyun.transmission.upload.uploader.UploaderAgent;
import com.tencent.weiyun.transmission.utils.ThreadPoolWrapper;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool;
import com.tencent.weiyun.uploader.IUploader;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.IOUtils;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UploadManager implements InfoRecorder.InfoRecorderCallback, LocalProcessor.LocalProcessorCallback, UrlFetcher.UrlFetcherCallback, IUploader.IUploadListener, WeiyunTransmissionStatus.StatusChangeListener, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final AtomicInteger FLOW_ID;
    private static final int MSG_NOTIFY_JOB_ADDED = 1;
    private static final int MSG_NOTIFY_STATUS_CHANGED = 2;
    private static final String TAG = "UploadManager";
    private static final AtomicLong WORKING_ID;
    private static Singleton<UploadManager, Void> sInstance;
    private final UploadJobCounter mCounter;
    private UploadJobCounter mCustomCounter;
    private final HashSet<Long> mFailedJobs;
    private final DualHashMap<Long, String> mFlowIds;
    private final HashSet<IUploadStatusListener> mGlobalObservers;
    private final InfoRecorder mInfoRecorder;
    private final HashMap<Long, UploadJobContext> mJobs;
    private final LocalProcessor mLocalProcessor;
    private final ReleaseLooperHandler mNotifyHandler;
    private final ThreadPoolWrapper mThreadPool;
    private final UploaderAgent mUploaderAgent;
    private final UrlFetcher mUrlFetcher;
    private final HashSet<Long> mWaitNetJobs;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IUploadStatusListener {
        void onUploadJobAdded(String str, long j3);

        void onUploadStatusChanged(String str, long j3, UploadJobContext.StatusInfo statusInfo, boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
            return;
        }
        FLOW_ID = new AtomicInteger(0);
        WORKING_ID = new AtomicLong(-1L);
        sInstance = new Singleton<UploadManager, Void>() { // from class: com.tencent.weiyun.transmission.upload.UploadManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.weiyun.utils.Singleton
            public UploadManager create(Void r46) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new UploadManager(null) : (UploadManager) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
            }
        };
    }

    /* synthetic */ UploadManager(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 40)) {
            return;
        }
        iPatchRedirector.redirect((short) 40, (Object) this, (Object) anonymousClass1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0005. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void changeStatus(UploadJobContext uploadJobContext, int i3, int i16, String str) {
        boolean z16;
        boolean z17;
        if (uploadJobContext == null) {
            return;
        }
        switch (i3) {
            case 0:
                i3 = 1;
                z17 = true;
                if (z17 && !uploadJobContext.statusInfo().canRestart()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    synchronized (this.mWaitNetJobs) {
                        this.mWaitNetJobs.remove(Long.valueOf(uploadJobContext.dbId()));
                    }
                    synchronized (this.mFailedJobs) {
                        this.mFailedJobs.remove(Long.valueOf(uploadJobContext.dbId()));
                    }
                    uploadJobContext.setCanceled(false);
                }
                if (z16) {
                    int i17 = uploadJobContext.statusInfo().state;
                    uploadJobContext.statusInfo().state = i3;
                    uploadJobContext.statusInfo().errorCode = i16;
                    uploadJobContext.statusInfo().errorMsg = UploadHelper.convertErrorMessage(i16, str);
                    this.mInfoRecorder.updateInfo(uploadJobContext, true);
                    updateCounter(uploadJobContext, i17, i3);
                    TsLog.d(TAG, "changeStatus: id=" + uploadJobContext.dbId() + ", fileName=" + uploadJobContext.file().fileName + ", oldState=" + i17 + ", newState=" + i3 + ", errorCode=" + i16 + ", canceled=" + uploadJobContext.isCanceled());
                    return;
                }
                return;
            case 1:
                z17 = false;
                if (z17) {
                    break;
                }
                z16 = true;
                if (z16) {
                }
                if (z16) {
                }
                break;
            case 2:
                z16 = uploadJobContext.statusInfo().canRunning();
                if (z16) {
                }
                break;
            case 3:
                z16 = uploadJobContext.statusInfo().canRunning();
                if (z16) {
                }
                break;
            case 4:
                z16 = uploadJobContext.statusInfo().canSuspend();
                if (z16) {
                    synchronized (this.mWaitNetJobs) {
                        this.mWaitNetJobs.remove(Long.valueOf(uploadJobContext.dbId()));
                    }
                    uploadJobContext.resetRank();
                    uploadJobContext.setIgnoreNetLimit(false);
                    uploadJobContext.setCanceled(true);
                    this.mUploaderAgent.cancel(uploadJobContext.uploadRequest());
                }
                if (z16) {
                }
                break;
            case 5:
                synchronized (this.mJobs) {
                    this.mJobs.remove(Long.valueOf(uploadJobContext.dbId()));
                }
                synchronized (this.mFlowIds) {
                    this.mFlowIds.removeByKey(Long.valueOf(uploadJobContext.dbId()));
                }
                synchronized (this.mWaitNetJobs) {
                    this.mWaitNetJobs.remove(Long.valueOf(uploadJobContext.dbId()));
                }
                synchronized (this.mFailedJobs) {
                    this.mFailedJobs.remove(Long.valueOf(uploadJobContext.dbId()));
                }
                uploadJobContext.statusInfo().currSize = uploadJobContext.statusInfo().totalSize;
                uploadJobContext.statusInfo().jobContext = uploadJobContext;
                z16 = true;
                if (z16) {
                }
                break;
            case 6:
                if (i16 == 1810002) {
                    synchronized (this.mJobs) {
                        this.mJobs.remove(Long.valueOf(uploadJobContext.dbId()));
                    }
                    synchronized (this.mFlowIds) {
                        this.mFlowIds.removeByKey(Long.valueOf(uploadJobContext.dbId()));
                    }
                    synchronized (this.mWaitNetJobs) {
                        this.mWaitNetJobs.remove(Long.valueOf(uploadJobContext.dbId()));
                    }
                    synchronized (this.mFailedJobs) {
                        this.mFailedJobs.remove(Long.valueOf(uploadJobContext.dbId()));
                    }
                    uploadJobContext.resetRank();
                    uploadJobContext.setCanceled(true);
                    this.mUploaderAgent.cancel(uploadJobContext.uploadRequest());
                    i3 = 0;
                } else if (i16 != 1810003 && i16 != 1810004) {
                    synchronized (this.mFailedJobs) {
                        this.mFailedJobs.add(Long.valueOf(uploadJobContext.dbId()));
                    }
                } else {
                    uploadJobContext.resetRank();
                    synchronized (this.mWaitNetJobs) {
                        this.mWaitNetJobs.add(Long.valueOf(uploadJobContext.dbId()));
                    }
                    i3 = 1;
                    z16 = true;
                    if (z16) {
                    }
                }
                z16 = true;
                if (z16) {
                }
                break;
            default:
                z16 = true;
                if (z16) {
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatch(long j3, boolean z16) {
        WORKING_ID.compareAndSet(j3, -1L);
        if (z16) {
            this.mThreadPool.submit(new ThreadPool.Job<Void>() { // from class: com.tencent.weiyun.transmission.upload.UploadManager.6
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) UploadManager.this);
                    }
                }

                @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
                public Void run(ThreadPool.JobContext jobContext) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext);
                    }
                    if (UploadManager.WORKING_ID.get() != -1) {
                        return null;
                    }
                    ArrayList arrayList = new ArrayList();
                    synchronized (UploadManager.this.mJobs) {
                        arrayList.addAll(UploadManager.this.mJobs.values());
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    Collections.sort(arrayList);
                    UploadJobContext uploadJobContext = (UploadJobContext) arrayList.get(0);
                    if (!uploadJobContext.statusInfo().canRunning() || !UploadManager.WORKING_ID.compareAndSet(-1L, uploadJobContext.dbId())) {
                        return null;
                    }
                    UploadManager.this.mLocalProcessor.processor(uploadJobContext);
                    return null;
                }
            });
        }
    }

    public static UploadManager getInstance() {
        return sInstance.get(null);
    }

    private void handleFinished(UploadJobContext uploadJobContext, int i3, int i16, String str) {
        changeStatus(uploadJobContext, i3, i16, str);
        dispatch(uploadJobContext.dbId(), true);
    }

    private boolean isNetAvailable(boolean z16) {
        Context context = WeiyunTransmissionGlobal.getInstance().getContext();
        boolean isTranOnlyWifi = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
        if (!z16 && isTranOnlyWifi) {
            return NetworkUtils.isWifiAvailable(context);
        }
        return NetworkUtils.isNetworkAvailable(context);
    }

    private void notifyFlowId(int i3, UploadJobContext uploadJobContext) {
        if (uploadJobContext == null) {
            return;
        }
        synchronized (this.mFlowIds) {
            this.mFlowIds.put(Long.valueOf(uploadJobContext.dbId()), Integer.toString(i3));
        }
        this.mNotifyHandler.sendMessage(Message.obtain(null, 1, new Object[]{uploadJobContext.listeners(), Integer.toString(i3), Long.valueOf(uploadJobContext.dbId())}));
    }

    private void notifyProgress(UploadJobContext uploadJobContext, boolean z16) {
        if (uploadJobContext == null) {
            return;
        }
        this.mNotifyHandler.sendMessage(Message.obtain(null, 2, z16 ? 1 : 0, 0, new Object[]{uploadJobContext.listeners(), uploadJobContext.uid(), Long.valueOf(uploadJobContext.dbId()), uploadJobContext.cloneStatusInfo()}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeJobInner(long j3) {
        this.mInfoRecorder.removeInfo(j3, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean restartJobInner(long j3, boolean z16, boolean z17, boolean z18, boolean z19) {
        UploadJobContext uploadJobContext;
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null) {
            return false;
        }
        if (z16) {
            uploadJobContext.setPriority(z17);
        }
        if (z18) {
            uploadJobContext.setIgnoreNetLimit(z19);
        }
        changeStatus(uploadJobContext, 1, 0, null);
        return true;
    }

    private synchronized void startManager(String str) {
        this.mInfoRecorder.restoreInfo(str);
    }

    private synchronized void stopManager() {
        this.mLocalProcessor.cancelAll();
        this.mUrlFetcher.cancelAll();
        this.mUploaderAgent.cancelAll();
        this.mUploaderAgent.speedDown();
        synchronized (this.mJobs) {
            this.mJobs.clear();
        }
        synchronized (this.mFlowIds) {
            this.mFlowIds.clear();
        }
        synchronized (this.mWaitNetJobs) {
            this.mWaitNetJobs.clear();
        }
        synchronized (this.mFailedJobs) {
            this.mFailedJobs.clear();
        }
        this.mCounter.reset();
        UploadJobCounter uploadJobCounter = this.mCustomCounter;
        if (uploadJobCounter != null) {
            uploadJobCounter.reset();
        }
        FLOW_ID.set(0);
        WORKING_ID.set(-1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean suspendJobInner(long j3) {
        UploadJobContext uploadJobContext;
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null) {
            return false;
        }
        changeStatus(uploadJobContext, 4, 0, null);
        return true;
    }

    private void updateCounter(UploadJobContext uploadJobContext, int i3, int i16) {
        UploadJobCounter m293clone = this.mCounter.m293clone();
        UploadJobCounter update = this.mCounter.update(uploadJobContext, i3, i16);
        int i17 = m293clone.wait + m293clone.compressing + m293clone.running + m293clone.autoBackup;
        int i18 = update.wait + update.compressing + update.running + update.autoBackup;
        if (i17 <= 0 && i18 > 0) {
            UploadHelper.acquireWakeLockIfNot();
        } else if (i17 > 0 && i18 <= 0) {
            UploadHelper.releaseWakeLockIfExist();
        }
        UploadJobCounter uploadJobCounter = this.mCustomCounter;
        if (uploadJobCounter != null) {
            uploadJobCounter.update(uploadJobContext, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWaitNetJobs() {
        Context context = WeiyunTransmissionGlobal.getInstance().getContext();
        boolean isTranOnlyWifi = WeiyunTransmissionStatus.getInstance().isTranOnlyWifi();
        boolean isNetworkAvailable = NetworkUtils.isNetworkAvailable(context);
        if (!NetworkUtils.isWifiAvailable(context) && (isTranOnlyWifi || !isNetworkAvailable)) {
            synchronized (this.mJobs) {
                Iterator<Map.Entry<Long, UploadJobContext>> it = this.mJobs.entrySet().iterator();
                while (it.hasNext()) {
                    UploadJobContext value = it.next().getValue();
                    if ((!value.isIgnoreNetLimit() && isTranOnlyWifi) || !isNetworkAvailable) {
                        if (value.statusInfo().canSuspend()) {
                            value.setCanceled(true);
                            this.mUploaderAgent.cancel(value.uploadRequest());
                            changeStatus(value, 6, ErrorCode.TRAN_NETWORK_NOT_AVAILABLE, null);
                            dispatch(value.dbId(), false);
                        }
                    } else if (value.isIgnoreNetLimit() && value.statusInfo().waitingNet()) {
                        restartJobInner(value.dbId(), false, false, false, false);
                    }
                }
            }
        } else {
            ArrayList arrayList = new ArrayList();
            synchronized (this.mWaitNetJobs) {
                arrayList.addAll(this.mWaitNetJobs);
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                restartJobInner(((Long) it5.next()).longValue(), false, false, false, false);
            }
        }
        dispatch(-1L, true);
    }

    public void addGlobalObserver(IUploadStatusListener iUploadStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) iUploadStatusListener);
        } else if (iUploadStatusListener != null) {
            synchronized (this.mGlobalObservers) {
                this.mGlobalObservers.add(iUploadStatusListener);
            }
        }
    }

    public boolean addJobListener(long j3, IUploadStatusListener iUploadStatusListener) {
        UploadJobContext uploadJobContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, Long.valueOf(j3), iUploadStatusListener)).booleanValue();
        }
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null) {
            return false;
        }
        uploadJobContext.addListener(iUploadStatusListener);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String[] calSliceSha1(String str, UploadNative.CanceledFlag canceledFlag) {
        return this.mUploaderAgent.calSliceSha1(str, canceledFlag);
    }

    public boolean canRestartAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        UploadJobCounter m293clone = this.mCounter.m293clone();
        if (m293clone.failed + m293clone.suspend > 0) {
            return true;
        }
        return false;
    }

    public boolean canSuspendAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        UploadJobCounter m293clone = this.mCounter.m293clone();
        if (m293clone.wait + m293clone.compressing + m293clone.running > 0) {
            return true;
        }
        return false;
    }

    public UploadJobContext getJobContext(long j3) {
        UploadJobContext uploadJobContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (UploadJobContext) iPatchRedirector.redirect((short) 17, (Object) this, j3);
        }
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null) {
            return null;
        }
        return UploadJobContext.createInstance(uploadJobContext.uid(), uploadJobContext.file().m290clone(), uploadJobContext.statusInfo().m292clone());
    }

    public UploadJobContext.StatusInfo getJobStatus(long j3) {
        UploadJobContext uploadJobContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (UploadJobContext.StatusInfo) iPatchRedirector.redirect((short) 16, (Object) this, j3);
        }
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null) {
            return null;
        }
        return uploadJobContext.cloneStatusInfo();
    }

    public UploadJobCounter getJobsCounter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (UploadJobCounter) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.mCounter.m293clone();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 1) {
            Object[] objArr = (Object[]) message.obj;
            Set<IUploadStatusListener> set = (Set) objArr[0];
            synchronized (this.mGlobalObservers) {
                set.addAll(this.mGlobalObservers);
            }
            for (IUploadStatusListener iUploadStatusListener : set) {
                if (iUploadStatusListener != null) {
                    iUploadStatusListener.onUploadJobAdded((String) objArr[1], ((Long) objArr[2]).longValue());
                }
            }
        } else if (i3 == 2) {
            Object[] objArr2 = (Object[]) message.obj;
            Set<IUploadStatusListener> set2 = (Set) objArr2[0];
            synchronized (this.mGlobalObservers) {
                set2.addAll(this.mGlobalObservers);
            }
            for (IUploadStatusListener iUploadStatusListener2 : set2) {
                if (iUploadStatusListener2 != null) {
                    String str = (String) objArr2[1];
                    long longValue = ((Long) objArr2[2]).longValue();
                    UploadJobContext.StatusInfo statusInfo = (UploadJobContext.StatusInfo) objArr2[3];
                    if (message.arg1 == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    iUploadStatusListener2.onUploadStatusChanged(str, longValue, statusInfo, z16);
                }
            }
        }
        return true;
    }

    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        WeiyunTransmissionStatus.getInstance().addListener(5, this);
        WeiyunTransmissionStatus.getInstance().addListener(4, this);
        WeiyunTransmissionStatus.getInstance().addListener(3, this);
    }

    public void loadLibFromPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str)) {
            this.mUploaderAgent.loadLibFromPath(str);
        }
    }

    @Override // com.tencent.weiyun.transmission.upload.processor.UrlFetcher.UrlFetcherCallback
    public void onFetchError(long j3, int i3, String str) {
        UploadJobContext uploadJobContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Long.valueOf(j3), Integer.valueOf(i3), str);
            return;
        }
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null || uploadJobContext.isCanceled()) {
            return;
        }
        if (!TextUtils.isEmpty(uploadJobContext.file().coverFileId)) {
            uploadJobContext.statusInfo().fileId = uploadJobContext.file().coverFileId;
        }
        if (!NetworkUtils.isNetworkAvailable(WeiyunTransmissionGlobal.getInstance().getContext())) {
            handleFinished(uploadJobContext, 6, ErrorCode.TRAN_NETWORK_NOT_AVAILABLE, null);
        } else {
            handleFinished(uploadJobContext, 6, i3, str);
        }
    }

    @Override // com.tencent.weiyun.transmission.upload.processor.UrlFetcher.UrlFetcherCallback
    public void onFetchSuccess(long j3, UploadFile uploadFile) {
        UploadJobContext uploadJobContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Long.valueOf(j3), uploadFile);
            return;
        }
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null || uploadJobContext.isCanceled()) {
            return;
        }
        UploadFile.UploadServerInfo uploadServerInfo = uploadFile.serverInfo;
        if (uploadServerInfo == null) {
            handleFinished(uploadJobContext, 6, ErrorCode.CMD_INVALID_RSP, null);
            return;
        }
        if (!uploadServerInfo.fileExist && TextUtils.isEmpty(uploadServerInfo.serverIp) && TextUtils.isEmpty(uploadServerInfo.serverName)) {
            handleFinished(uploadJobContext, 6, ErrorCode.TRAN_UPLOAD_ADDRESS_INVALID, null);
            return;
        }
        if (!isNetAvailable(uploadJobContext.isIgnoreNetLimit())) {
            handleFinished(uploadJobContext, 6, ErrorCode.TRAN_NETWORK_NOT_AVAILABLE, null);
            return;
        }
        uploadJobContext.statisticsTimes().onFetchUrlEnd();
        if (!TextUtils.equals(uploadJobContext.file().pDirKey, uploadFile.pDirKey)) {
            uploadJobContext.file().pDirKey = uploadFile.pDirKey;
            uploadJobContext.file().pPDirKey = uploadFile.pPDirKey;
            uploadJobContext.file().pDirName = uploadFile.pDirName;
            this.mInfoRecorder.updateInfo(j3, uploadJobContext.file());
        }
        uploadJobContext.createUploadRequest(uploadServerInfo, this);
        uploadJobContext.setFileVersion(uploadServerInfo.fileVersion);
        uploadJobContext.statusInfo().fileVersion = uploadServerInfo.fileVersion;
        if (uploadServerInfo.fileExist) {
            this.mUploaderAgent.secondUpload(uploadJobContext.uploadRequest());
        } else if (IOUtils.isFileModified(uploadJobContext.file().localPath, uploadJobContext.file().lastModified)) {
            this.mLocalProcessor.processor(uploadJobContext);
        } else {
            this.mUploaderAgent.upload(uploadJobContext.uploadRequest());
        }
    }

    @Override // com.tencent.weiyun.transmission.upload.processor.InfoRecorder.InfoRecorderCallback
    public void onInfoAdded(int i3, UploadJobContext uploadJobContext) {
        UploadJobContext uploadJobContext2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3, (Object) uploadJobContext);
            return;
        }
        synchronized (this.mJobs) {
            long dbId = uploadJobContext.dbId();
            uploadJobContext2 = this.mJobs.get(Long.valueOf(dbId));
            if (uploadJobContext2 == null) {
                this.mJobs.put(Long.valueOf(dbId), uploadJobContext);
            } else if (uploadJobContext2.statusInfo().canRestart()) {
                uploadJobContext.statusInfo().state = uploadJobContext2.statusInfo().state;
                uploadJobContext.statusInfo().errorCode = uploadJobContext2.statusInfo().errorCode;
                this.mJobs.put(Long.valueOf(dbId), uploadJobContext);
            } else {
                z16 = false;
            }
            z16 = true;
        }
        notifyFlowId(i3, uploadJobContext);
        if (!z16) {
            uploadJobContext2.increaseRank();
            uploadJobContext2.setBirthTime(uploadJobContext.birthTime());
            uploadJobContext2.setPriority(uploadJobContext.isPriority());
            uploadJobContext2.setIgnoreNetLimit(uploadJobContext.isIgnoreNetLimit());
            uploadJobContext2.addListeners(uploadJobContext.listeners());
        }
        if (!z16) {
            uploadJobContext = uploadJobContext2;
        }
        changeStatus(uploadJobContext, 1, 0, null);
        dispatch(-1L, true);
    }

    @Override // com.tencent.weiyun.transmission.upload.processor.InfoRecorder.InfoRecorderCallback
    public void onInfoRemoved(long j3, boolean z16, UploadJobContext uploadJobContext) {
        UploadJobContext uploadJobContext2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Long.valueOf(j3), Boolean.valueOf(z16), uploadJobContext);
            return;
        }
        synchronized (this.mJobs) {
            uploadJobContext2 = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext2 != null) {
            handleFinished(uploadJobContext2, 6, ErrorCode.TRAN_USER_CANCELED, null);
        }
        if (uploadJobContext != null) {
            uploadJobContext.statusInfo().state = 0;
            uploadJobContext.statusInfo().errorCode = ErrorCode.TRAN_USER_CANCELED;
            notifyProgress(uploadJobContext, true);
        }
    }

    @Override // com.tencent.weiyun.transmission.upload.processor.InfoRecorder.InfoRecorderCallback
    public void onInfoRestored(String str, List<UploadJobContext> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) list);
            return;
        }
        if (TextUtils.equals(str, WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid()) && list != null && !list.isEmpty()) {
            synchronized (this.mJobs) {
                for (UploadJobContext uploadJobContext : list) {
                    long dbId = uploadJobContext.dbId();
                    int i3 = uploadJobContext.statusInfo().state;
                    uploadJobContext.statusInfo().state = 0;
                    this.mJobs.put(Long.valueOf(dbId), uploadJobContext);
                    if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 6) {
                                changeStatus(uploadJobContext, 6, uploadJobContext.statusInfo().errorCode, uploadJobContext.statusInfo().errorMsg);
                            }
                        } else {
                            changeStatus(uploadJobContext, 4, 0, null);
                        }
                    } else {
                        changeStatus(uploadJobContext, 1, 0, null);
                    }
                }
            }
            dispatch(-1L, true);
        }
    }

    @Override // com.tencent.weiyun.transmission.upload.processor.InfoRecorder.InfoRecorderCallback
    public void onInfoUpdated(long j3, boolean z16, UploadJobContext.StatusInfo statusInfo, boolean z17) {
        UploadJobContext uploadJobContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, this, Long.valueOf(j3), Boolean.valueOf(z16), statusInfo, Boolean.valueOf(z17));
            return;
        }
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null) {
            if (statusInfo == null) {
                uploadJobContext = null;
            } else {
                uploadJobContext = statusInfo.jobContext;
            }
            if (uploadJobContext == null) {
                return;
            }
        }
        notifyProgress(uploadJobContext, z17);
    }

    @Override // com.tencent.weiyun.transmission.upload.processor.LocalProcessor.LocalProcessorCallback
    public void onLocalResult(long j3, boolean z16, boolean z17) {
        UploadJobContext uploadJobContext;
        UploadType uploadType;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null || uploadJobContext.isCanceled()) {
            return;
        }
        if (z16 && z17) {
            this.mInfoRecorder.updateInfo(j3, uploadJobContext.file());
        }
        if (!z16) {
            handleFinished(uploadJobContext, 6, ErrorCode.TRAN_LOCAL_FILE_NOT_EXIST, null);
            return;
        }
        if (!z17) {
            handleFinished(uploadJobContext, 6, ErrorCode.TRAN_UPLOAD_NO_SUPPORT_DIR, null);
            return;
        }
        if (!isNetAvailable(uploadJobContext.isIgnoreNetLimit())) {
            handleFinished(uploadJobContext, 6, ErrorCode.TRAN_NETWORK_NOT_AVAILABLE, null);
            return;
        }
        UrlFetcher urlFetcher = this.mUrlFetcher;
        if (uploadJobContext.file().uploadType == null) {
            uploadType = UploadType.EXIST_RESUME_RENAME;
        } else {
            uploadType = uploadJobContext.file().uploadType;
        }
        urlFetcher.fetchUrl(uploadJobContext, uploadType.ordinal());
    }

    @Override // com.tencent.weiyun.transmission.WeiyunTransmissionStatus.StatusChangeListener
    public void onStatusChanged(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 == 5) {
                    UploadHelper.updateNetworkChange();
                    this.mUploaderAgent.setNetType(NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext()));
                } else {
                    return;
                }
            } else if (i17 == 1) {
                stopManager();
                return;
            } else {
                if (i17 == 0) {
                    startManager(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid());
                    return;
                }
                return;
            }
        }
        this.mThreadPool.submit(new ThreadPool.Job<Void>() { // from class: com.tencent.weiyun.transmission.upload.UploadManager.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadManager.this);
                }
            }

            @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
            public Void run(ThreadPool.JobContext jobContext) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Void) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) jobContext);
                }
                try {
                    LockMethodProxy.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                UploadManager.this.updateWaitNetJobs();
                return null;
            }
        });
    }

    @Override // com.tencent.weiyun.uploader.IUploader.IUploadListener
    public void onUploadCanceled(UploadRequest uploadRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) uploadRequest);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader.IUploadListener
    public void onUploadFinished(UploadRequest uploadRequest, boolean z16, UploadResponse uploadResponse) {
        UploadJobContext uploadJobContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, uploadRequest, Boolean.valueOf(z16), uploadResponse);
            return;
        }
        long parseLong = Long.parseLong((String) ((HashMap) uploadRequest.businessData()).get("db_id"));
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(parseLong));
        }
        if (uploadJobContext == null || uploadJobContext.isCanceled()) {
            return;
        }
        if (z16) {
            uploadJobContext.statusInfo().fileId = (String) ((HashMap) uploadRequest.businessData()).get("file_id");
            String str = uploadJobContext.file().compressedPath;
            if (!TextUtils.isEmpty(str)) {
                IOUtils.deleteFile(new File(str), true);
            }
            handleFinished(uploadJobContext, 5, 0, null);
            return;
        }
        int parseUploadResponse = UploadHelper.parseUploadResponse(uploadResponse);
        if (uploadJobContext.isCanceled()) {
            return;
        }
        if (UploadHelper.shouldRetry(parseUploadResponse)) {
            handleFinished(uploadJobContext, 0, parseUploadResponse, null);
        } else {
            handleFinished(uploadJobContext, 6, parseUploadResponse, null);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader.IUploadListener
    public void onUploadProgress(UploadRequest uploadRequest, long j3, float f16, long j16, long j17, long j18) {
        UploadJobContext uploadJobContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, uploadRequest, Long.valueOf(j3), Float.valueOf(f16), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
        long parseLong = Long.parseLong((String) ((HashMap) uploadRequest.businessData()).get("db_id"));
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(parseLong));
        }
        if (uploadJobContext == null || uploadJobContext.isCanceled()) {
            return;
        }
        long j19 = ((float) j3) * f16;
        uploadJobContext.statusInfo().totalSize = j3;
        UploadJobContext.StatusInfo statusInfo = uploadJobContext.statusInfo();
        if (j19 < j3) {
            j3 = j19;
        }
        statusInfo.currSize = j3;
        uploadJobContext.statusInfo().speed = j16;
        uploadJobContext.statusInfo().exSpeed = j17;
        uploadJobContext.statusInfo().adSpeed = j18;
        if (uploadJobContext.statusInfo().canRunning()) {
            changeStatus(uploadJobContext, 3, 0, null);
        }
        notifyProgress(uploadJobContext, false);
    }

    public void removeAll(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.mJobs) {
            for (Map.Entry<Long, UploadJobContext> entry : this.mJobs.entrySet()) {
                if (TextUtils.equals(str, entry.getValue().statusInfo().fileId)) {
                    arrayList.add(entry.getKey());
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeJob(((Long) it.next()).longValue());
        }
    }

    public int removeAllFailed() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        HashSet hashSet = new HashSet();
        synchronized (this.mFailedJobs) {
            size = this.mFailedJobs.size();
            hashSet.addAll(this.mFailedJobs);
        }
        if (!hashSet.isEmpty()) {
            this.mThreadPool.submit(new ThreadPool.Job<Void>(hashSet) { // from class: com.tencent.weiyun.transmission.upload.UploadManager.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ HashSet val$failedJobs;

                {
                    this.val$failedJobs = hashSet;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadManager.this, (Object) hashSet);
                    }
                }

                @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
                public Void run(ThreadPool.JobContext jobContext) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Void) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) jobContext);
                    }
                    Iterator it = this.val$failedJobs.iterator();
                    while (it.hasNext()) {
                        long longValue = ((Long) it.next()).longValue();
                        UploadManager.this.removeJobInner(longValue);
                        UploadManager.this.dispatch(longValue, false);
                    }
                    UploadManager.this.dispatch(-1L, true);
                    return null;
                }
            });
        }
        return size;
    }

    public void removeGlobalObserver(IUploadStatusListener iUploadStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) iUploadStatusListener);
        } else if (iUploadStatusListener != null) {
            synchronized (this.mGlobalObservers) {
                this.mGlobalObservers.remove(iUploadStatusListener);
            }
        }
    }

    public boolean removeJob(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? removeJobInner(j3) : ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, j3)).booleanValue();
    }

    public boolean removeJobListener(long j3, IUploadStatusListener iUploadStatusListener) {
        UploadJobContext uploadJobContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), iUploadStatusListener)).booleanValue();
        }
        synchronized (this.mJobs) {
            uploadJobContext = this.mJobs.get(Long.valueOf(j3));
        }
        if (uploadJobContext == null) {
            return false;
        }
        uploadJobContext.removeListener(iUploadStatusListener);
        return true;
    }

    public int restartAll(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, z16)).intValue();
        }
        UploadJobCounter m293clone = this.mCounter.m293clone();
        int i3 = m293clone.failed + m293clone.suspend;
        ArrayList arrayList = new ArrayList();
        synchronized (this.mJobs) {
            arrayList.addAll(this.mJobs.keySet());
        }
        if (!arrayList.isEmpty()) {
            this.mThreadPool.submit(new ThreadPool.Job<Void>(arrayList, z16) { // from class: com.tencent.weiyun.transmission.upload.UploadManager.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean val$ignoreNetType;
                final /* synthetic */ List val$restartJobs;

                {
                    this.val$restartJobs = arrayList;
                    this.val$ignoreNetType = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, UploadManager.this, arrayList, Boolean.valueOf(z16));
                    }
                }

                @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
                public Void run(ThreadPool.JobContext jobContext) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Void) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) jobContext);
                    }
                    Iterator it = this.val$restartJobs.iterator();
                    while (it.hasNext()) {
                        long longValue = ((Long) it.next()).longValue();
                        UploadManager uploadManager = UploadManager.this;
                        boolean z17 = this.val$ignoreNetType;
                        uploadManager.restartJobInner(longValue, false, false, z17, z17);
                    }
                    UploadManager.this.dispatch(-1L, true);
                    return null;
                }
            });
        }
        return i3;
    }

    public int restartAllFailed() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        HashSet hashSet = new HashSet();
        synchronized (this.mFailedJobs) {
            size = this.mFailedJobs.size();
            hashSet.addAll(this.mFailedJobs);
        }
        if (!hashSet.isEmpty()) {
            this.mThreadPool.submit(new ThreadPool.Job<Void>(hashSet) { // from class: com.tencent.weiyun.transmission.upload.UploadManager.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ HashSet val$failedJobs;

                {
                    this.val$failedJobs = hashSet;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadManager.this, (Object) hashSet);
                    }
                }

                @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
                public Void run(ThreadPool.JobContext jobContext) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Void) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) jobContext);
                    }
                    Iterator it = this.val$failedJobs.iterator();
                    while (it.hasNext()) {
                        UploadManager.this.restartJobInner(((Long) it.next()).longValue(), false, false, false, false);
                    }
                    UploadManager.this.dispatch(-1L, true);
                    return null;
                }
            });
        }
        return size;
    }

    public boolean restartJob(long j3, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18))).booleanValue();
        }
        if (!restartJobInner(j3, z16, z17, z16, z18)) {
            return false;
        }
        dispatch(-1L, true);
        return true;
    }

    public void setJobCounter(UploadJobCounter uploadJobCounter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uploadJobCounter);
        } else if (uploadJobCounter != null) {
            this.mCustomCounter = uploadJobCounter;
        }
    }

    public void setSpareUploader(IUploader iUploader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iUploader);
        } else if (iUploader != null) {
            this.mUploaderAgent.setSpareUploader(iUploader);
        }
    }

    public int suspendAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        UploadJobCounter m293clone = this.mCounter.m293clone();
        int i3 = m293clone.failed + m293clone.wait + m293clone.compressing + m293clone.running;
        ArrayList arrayList = new ArrayList();
        synchronized (this.mJobs) {
            arrayList.addAll(this.mJobs.keySet());
        }
        if (!arrayList.isEmpty()) {
            this.mThreadPool.submit(new ThreadPool.Job<Void>(arrayList) { // from class: com.tencent.weiyun.transmission.upload.UploadManager.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ List val$suspendJobs;

                {
                    this.val$suspendJobs = arrayList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UploadManager.this, (Object) arrayList);
                    }
                }

                @Override // com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job
                public Void run(ThreadPool.JobContext jobContext) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Void) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) jobContext);
                    }
                    Iterator it = this.val$suspendJobs.iterator();
                    while (it.hasNext()) {
                        long longValue = ((Long) it.next()).longValue();
                        UploadManager.this.suspendJobInner(longValue);
                        UploadManager.this.dispatch(longValue, false);
                    }
                    UploadManager.this.dispatch(-1L, true);
                    return null;
                }
            });
        }
        return i3;
    }

    public boolean suspendJob(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, j3)).booleanValue();
        }
        if (suspendJobInner(j3)) {
            dispatch(j3, true);
            return true;
        }
        return false;
    }

    public void trialSpeedUp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else if (i3 >= 0) {
            this.mUploaderAgent.trialSpeedUp(i3);
        }
    }

    public void updateIpConfig(Map<String, Map<String, Object>> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) map);
        } else {
            this.mUploaderAgent.saveDirectIpFromWns(map);
        }
    }

    public String upload(UploadFile uploadFile, boolean z16, boolean z17, IUploadStatusListener iUploadStatusListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, uploadFile, Boolean.valueOf(z16), Boolean.valueOf(z17), iUploadStatusListener);
        }
        if (uploadFile == null) {
            TsLog.w(TAG, "upload: The param file should be valid.");
            return null;
        }
        int andIncrement = FLOW_ID.getAndIncrement();
        if (TextUtils.isEmpty(uploadFile.fileName)) {
            uploadFile.fileName = IOUtils.getFileName(uploadFile.localPath);
        }
        UploadJobContext createInstance = UploadJobContext.createInstance(WeiyunTransmissionGlobal.getInstance().getHostInterface().getCurrentUid(), uploadFile, new UploadJobContext.StatusInfo());
        createInstance.setPriority(z16);
        createInstance.setIgnoreNetLimit(z17);
        createInstance.addListener(iUploadStatusListener);
        createInstance.statusInfo().filePath = uploadFile.localPath;
        createInstance.statusInfo().autoBackupFlag = uploadFile.autoBackupFlag;
        this.mInfoRecorder.addInfo(andIncrement, createInstance);
        return Integer.toString(andIncrement);
    }

    public void vipSpeedUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mUploaderAgent.vipSpeedUp();
        }
    }

    UploadManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mGlobalObservers = new HashSet<>();
        this.mJobs = new HashMap<>();
        this.mFlowIds = new DualHashMap<>();
        this.mWaitNetJobs = new HashSet<>();
        this.mFailedJobs = new HashSet<>();
        Context context = WeiyunTransmissionGlobal.getInstance().getContext();
        ReleaseLooperHandler releaseLooperHandler = new ReleaseLooperHandler("weiyun_upload_work_thread");
        this.mInfoRecorder = new InfoRecorder(this, releaseLooperHandler);
        this.mLocalProcessor = new LocalProcessor(context, this, releaseLooperHandler);
        this.mUrlFetcher = new UrlFetcher(this, releaseLooperHandler);
        UploaderAgent uploaderAgent = new UploaderAgent(context, releaseLooperHandler);
        this.mUploaderAgent = uploaderAgent;
        uploaderAgent.setNetType(NetworkUtils.getNetworkTypeDiff4G(WeiyunTransmissionGlobal.getInstance().getContext()));
        this.mCounter = new UploadJobCounter();
        this.mThreadPool = new ThreadPoolWrapper(TAG);
        ReleaseLooperHandler releaseLooperHandler2 = new ReleaseLooperHandler("weiyun_upload_notifier");
        this.mNotifyHandler = releaseLooperHandler2;
        releaseLooperHandler2.addCallback(this);
    }

    public boolean removeJob(String str) {
        Long byValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.mFlowIds) {
            byValue = this.mFlowIds.getByValue(str);
        }
        return byValue != null && removeJobInner(byValue.longValue());
    }
}
