package com.tencent.weiyun.uploader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.module.SpeedFilter;
import com.tencent.weiyun.uploader.module.XpConfig;
import com.tencent.weiyun.uploader.module.XpLog;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import com.tencent.weiyun.uploader.xplatform.UploadSDKContext;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.ILog;
import com.tencent.weiyun.utils.MultiHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Uploader implements IUploader, Handler.Callback, UploadSDKContext.IUploadSDKCallback {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_NATIVE_START = 2020;
    private static final int MSG_NATIVE_STOP = 2021;
    private static final int MSG_NATIVE_STOP_ALL = 2022;
    private final MultiHashMap<String, UploadRequest> mPendingRequests;
    private final Map<String, SpeedFilter> mSpeedFilters;
    private final Handler mStartHandler;
    private final Handler mStopHandler;
    private final DualHashMap<String, String> mTasks;
    private final UploadContext mUploadContext;

    public Uploader(Context context, String str, IReporter iReporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, iReporter);
            return;
        }
        this.mPendingRequests = new MultiHashMap<>();
        this.mTasks = new DualHashMap<>();
        this.mSpeedFilters = new HashMap();
        UploadNative uploadNative = UploadNative.getInstance();
        uploadNative.init(XpConfig.getCachePath(), "Android", Integer.toString(Build.VERSION.SDK_INT), XpConfig.getVersion(), XpConfig.getQUA(), XpConfig.isRdm(), new UploadSDKContext(this));
        this.mUploadContext = new UploadContext(context, str, uploadNative, iReporter);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(str + "_start");
        baseHandlerThread.start();
        this.mStartHandler = new Handler(baseHandlerThread.getLooper(), this);
        BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread(str + "_stop");
        baseHandlerThread2.start();
        this.mStopHandler = new Handler(baseHandlerThread2.getLooper(), this);
    }

    private boolean addPendingRequest(String str, UploadRequest uploadRequest) {
        boolean z16;
        boolean z17 = false;
        if (TextUtils.isEmpty(str) || uploadRequest == null) {
            return false;
        }
        synchronized (this.mPendingRequests) {
            Collection collection = (Collection) this.mPendingRequests.get(str);
            if (collection != null && collection.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.mPendingRequests.add(str, uploadRequest);
            if (!z16) {
                z17 = true;
            }
        }
        return z17;
    }

    private Collection<UploadRequest> collectPendingRequest(String str, boolean z16) {
        HashSet hashSet = new HashSet();
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        synchronized (this.mPendingRequests) {
            HashSet hashSet2 = (HashSet) (z16 ? this.mPendingRequests.remove(str) : this.mPendingRequests.get(str));
            if (hashSet2 != null) {
                hashSet.addAll(hashSet2);
            }
        }
        return hashSet;
    }

    public static void init(IConfig iConfig, ILog iLog) {
        XpConfig.setConfig(iConfig);
        XpLog.setLog(iLog);
    }

    private void notifyCanceled(Collection<UploadRequest> collection) {
        if (collection == null) {
            return;
        }
        for (UploadRequest uploadRequest : collection) {
            if (uploadRequest != null && uploadRequest.listener() != null) {
                uploadRequest.listener().onUploadCanceled(uploadRequest);
            }
        }
    }

    private void notifyFinished(Collection<UploadRequest> collection, int i3, String str) {
        boolean z16;
        if (collection == null) {
            return;
        }
        for (UploadRequest uploadRequest : collection) {
            if (uploadRequest != null && uploadRequest.listener() != null) {
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                uploadRequest.listener().onUploadFinished(uploadRequest, z16, new UploadResponse.Builder().request(uploadRequest).code(i3).errMsg(str).build());
            }
        }
    }

    private void notifyProgress(Collection<UploadRequest> collection, long j3, float f16, long j16, long j17, long j18) {
        if (collection == null) {
            return;
        }
        for (UploadRequest uploadRequest : collection) {
            if (uploadRequest != null && uploadRequest.listener() != null) {
                uploadRequest.listener().onUploadProgress(uploadRequest, j3, f16, j16, j17, j18);
            }
        }
    }

    private boolean removePendingRequest(String str, UploadRequest uploadRequest, Collection<UploadRequest> collection) {
        boolean z16;
        boolean z17 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.mPendingRequests) {
            if (uploadRequest != null) {
                if (this.mPendingRequests.remove(str, uploadRequest) && collection != null) {
                    collection.clear();
                    collection.add(uploadRequest);
                }
            } else {
                Collection<? extends UploadRequest> collection2 = (Collection) this.mPendingRequests.remove(str);
                if (collection2 != null && collection != null) {
                    collection.clear();
                    collection.addAll(collection2);
                }
            }
            Collection collection3 = (Collection) this.mPendingRequests.get(str);
            if (collection3 != null && collection3.size() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                z17 = true;
            }
        }
        return z17;
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public String[] calSliceSha1(String str, UploadNative.CanceledFlag canceledFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String[]) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) canceledFlag);
        }
        return this.mUploadContext.xpUploader().calSliceSha1(str, canceledFlag);
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public final void cancel(UploadRequest uploadRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) uploadRequest);
            return;
        }
        if (uploadRequest == null) {
            return;
        }
        XpLog.i("prepare to cancel:" + uploadRequest.path() + ", requestKey=" + uploadRequest.requestKey() + ", listener=" + uploadRequest.listener());
        Message.obtain(this.mStopHandler, 2021, uploadRequest).sendToTarget();
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public final void cancelAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        XpLog.i("prepare to cancel all from uploader-" + this.mUploadContext.tag());
        Message.obtain(this.mStopHandler, 2022).sendToTarget();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ArrayList arrayList;
        String removeByKey;
        boolean containsKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 2020) {
            Object obj = message.obj;
            if (obj instanceof UploadRequest) {
                UploadRequest uploadRequest = (UploadRequest) obj;
                String requestKey = uploadRequest.requestKey();
                Collection<UploadRequest> collectPendingRequest = collectPendingRequest(requestKey, false);
                if (!collectPendingRequest.isEmpty()) {
                    if (!collectPendingRequest.contains(uploadRequest)) {
                        uploadRequest = collectPendingRequest.iterator().next();
                    }
                    if (uploadRequest != null) {
                        synchronized (this.mTasks) {
                            containsKey = this.mTasks.containsKey(requestKey);
                        }
                        if (!containsKey) {
                            String createUploadTask = this.mUploadContext.xpUploader().createUploadTask(uploadRequest.uin(), uploadRequest.path(), uploadRequest.size(), uploadRequest.checkKey(), uploadRequest.serverName(), uploadRequest.serverIp(), uploadRequest.serverPort(), uploadRequest.channelCount(), uploadRequest.sliceSha(), uploadRequest.statisticTimes());
                            XpLog.i("createUploadTask: path=" + uploadRequest.path() + ", size=" + uploadRequest.size() + ", sha=" + uploadRequest.sha());
                            if (!collectPendingRequest(requestKey, false).isEmpty() && !TextUtils.isEmpty(createUploadTask)) {
                                synchronized (this.mTasks) {
                                    this.mTasks.put(requestKey, createUploadTask);
                                }
                                synchronized (this.mSpeedFilters) {
                                    this.mSpeedFilters.put(createUploadTask, new SpeedFilter());
                                }
                                this.mUploadContext.xpUploader().startTask(createUploadTask);
                            }
                        }
                    }
                }
            }
        } else if (i3 == 2021) {
            Object obj2 = message.obj;
            if (obj2 instanceof UploadRequest) {
                UploadRequest uploadRequest2 = (UploadRequest) obj2;
                ArrayList arrayList2 = new ArrayList();
                if (removePendingRequest(uploadRequest2.requestKey(), uploadRequest2, arrayList2)) {
                    synchronized (this.mTasks) {
                        removeByKey = this.mTasks.removeByKey(uploadRequest2.requestKey());
                    }
                    if (removeByKey != null) {
                        this.mUploadContext.xpUploader().stopTask(removeByKey);
                        synchronized (this.mSpeedFilters) {
                            this.mSpeedFilters.remove(removeByKey);
                        }
                    }
                }
                notifyCanceled(arrayList2);
            }
        } else if (i3 == 2022) {
            Collection<UploadRequest> collectPendingRequest2 = collectPendingRequest(true);
            synchronized (this.mTasks) {
                arrayList = new ArrayList(this.mTasks.values());
                this.mTasks.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mUploadContext.xpUploader().stopTask((String) it.next());
            }
            synchronized (this.mSpeedFilters) {
                this.mSpeedFilters.clear();
            }
            notifyCanceled(collectPendingRequest2);
        }
        return true;
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void reportError(long j3, String str, String str2, String str3, int i3, boolean z16, long j16, long j17, long j18, boolean z17, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Boolean.valueOf(z17), Integer.valueOf(i16));
        } else {
            this.mUploadContext.xpUploader().reportError(j3, str, str2, str3, i3, z16, j16, j17, j18, z17, i16);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void setHttpProxy(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2, str3);
        } else {
            this.mUploadContext.xpUploader().setHttpProxy(str, i3, str2, str3);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void setIpConfig(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        } else {
            this.mUploadContext.xpUploader().setIpConfig(str, str2);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void setNetType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mUploadContext.xpUploader().setNetType(i3);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void setReporter(IReporter iReporter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iReporter);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void speedDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.mUploadContext.xpUploader().speedDown();
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void trialSpeedUp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mUploadContext.xpUploader().trialSpeedUp(i3);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public final boolean upload(UploadRequest uploadRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uploadRequest)).booleanValue();
        }
        if (uploadRequest == null) {
            XpLog.w("Unsupported request.");
            return false;
        }
        XpLog.i("prepare to upload:" + uploadRequest.path() + ", requestKey=" + uploadRequest.requestKey() + ", listener=" + uploadRequest.listener());
        if (addPendingRequest(uploadRequest.requestKey(), uploadRequest)) {
            Message.obtain(this.mStartHandler, 2020, uploadRequest).sendToTarget();
            return true;
        }
        return true;
    }

    @Override // com.tencent.weiyun.uploader.xplatform.UploadSDKContext.IUploadSDKCallback
    public void uploadCancelled(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.weiyun.uploader.xplatform.UploadSDKContext.IUploadSDKCallback
    public void uploadFinish(String str, int i3, String str2) {
        String removeByValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), str2);
            return;
        }
        synchronized (this.mTasks) {
            removeByValue = this.mTasks.removeByValue(str);
        }
        synchronized (this.mSpeedFilters) {
            this.mSpeedFilters.remove(str);
        }
        if (removeByValue != null) {
            Collection<UploadRequest> collectPendingRequest = collectPendingRequest(removeByValue, true);
            IReporter reporter = this.mUploadContext.reporter();
            if (reporter != null && !collectPendingRequest.isEmpty()) {
                reporter.handleReport(new UploadResponse.Builder().request(collectPendingRequest.iterator().next()).code(i3).errMsg(str2).build());
            }
            notifyFinished(collectPendingRequest, i3, str2);
        }
    }

    @Override // com.tencent.weiyun.uploader.xplatform.UploadSDKContext.IUploadSDKCallback
    public void uploadProgress(String str, long j3, long j16, long j17, long j18, long j19) {
        SpeedFilter speedFilter;
        long[] updateSpeed;
        String byValue;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19));
            return;
        }
        synchronized (this.mSpeedFilters) {
            speedFilter = this.mSpeedFilters.get(str);
        }
        if (speedFilter == null) {
            updateSpeed = new long[]{j17, j18, j19};
        } else {
            updateSpeed = speedFilter.updateSpeed(j17, j18, j19);
        }
        synchronized (this.mTasks) {
            byValue = this.mTasks.getByValue(str);
        }
        if (byValue != null) {
            Collection<UploadRequest> collectPendingRequest = collectPendingRequest(byValue, false);
            if (j3 == 0) {
                f16 = 1.0f;
            } else {
                f16 = ((float) j16) / ((float) j3);
            }
            notifyProgress(collectPendingRequest, j3, f16, updateSpeed[0], updateSpeed[1], updateSpeed[2]);
        }
    }

    @Override // com.tencent.weiyun.uploader.IUploader
    public void vipSpeedUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mUploadContext.xpUploader().vipSpeedUp();
        }
    }

    private Collection<UploadRequest> collectPendingRequest(boolean z16) {
        HashSet hashSet = new HashSet();
        synchronized (this.mPendingRequests) {
            Iterator<Map.Entry<String, UploadRequest>> it = this.mPendingRequests.entrySet().iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next().getValue();
                if (collection != null) {
                    hashSet.addAll(collection);
                }
                if (z16) {
                    it.remove();
                }
            }
        }
        return hashSet;
    }
}
