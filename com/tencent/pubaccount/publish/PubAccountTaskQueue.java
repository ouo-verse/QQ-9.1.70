package com.tencent.pubaccount.publish;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.qzone.app.QZoneAppInterface;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.event.EventCenter;
import com.qzone.component.e;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneUploadShuoShuoTask;
import com.qzone.util.ToastUtil;
import com.qzone.util.al;
import com.qzone.util.j;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import common.config.service.QzoneConfig;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.feed.CertifiedFakeFeed;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import eipc.EIPCModule;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes34.dex */
public class PubAccountTaskQueue implements Handler.Callback, NetworkState.NetworkStateListener, com.qzone.publish.business.publishqueue.a {
    private static int D = 10;
    private static final al<PubAccountTaskQueue, Void> E = new a();
    public static boolean F = false;
    private static final long G = TimeZone.getTimeZone(DateUtil.TIME_ZONE_8).getRawOffset();

    /* renamed from: h, reason: collision with root package name */
    private QQCustomDialog f342277h;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<WeakReference<com.qzone.publish.business.publishqueue.b>> f342275e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f342276f = false;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f342278i = new Runnable() { // from class: com.tencent.pubaccount.publish.PubAccountTaskQueue.4
        @Override // java.lang.Runnable
        public void run() {
            QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "checkRetryForOffline");
            PubAccountTaskQueue.this.R();
            PubAccountTaskQueue.this.C();
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private Runnable f342279m = new Runnable() { // from class: com.tencent.pubaccount.publish.PubAccountTaskQueue.5
        @Override // java.lang.Runnable
        public void run() {
            CopyOnWriteArrayList<IQueueTask> a16;
            if ((PubAccountTaskQueue.this.f342277h == null || !PubAccountTaskQueue.this.f342277h.isShowing()) && (a16 = PubAccountTaskQueue.this.a()) != null) {
                int size = a16.size();
                QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "checkRetryForOffline2Normarl taskList size:" + size);
                for (int i3 = 0; i3 < size; i3++) {
                    IQueueTask iQueueTask = a16.get(i3);
                    if (PubAccountTaskQueue.this.A(iQueueTask) && !PubAccountTaskQueue.this.h(iQueueTask, true)) {
                        PubAccountTaskQueue.this.j(iQueueTask);
                    }
                }
            }
        }
    };
    private Runnable C = new Runnable() { // from class: com.tencent.pubaccount.publish.PubAccountTaskQueue.6
        @Override // java.lang.Runnable
        public void run() {
            CopyOnWriteArrayList<IQueueTask> a16;
            if (NetworkState.isWifiConn() && (a16 = PubAccountTaskQueue.this.a()) != null) {
                int size = a16.size();
                QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "checkRetry taskList size:" + size);
                for (int i3 = 0; i3 < size; i3++) {
                    IQueueTask iQueueTask = a16.get(i3);
                    if (PubAccountTaskQueue.this.z(iQueueTask) && PubAccountTaskQueue.this.A(iQueueTask) && !PubAccountTaskQueue.this.h(iQueueTask, true)) {
                        PubAccountTaskQueue.this.j(iQueueTask);
                    }
                }
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private Handler f342274d = new Handler(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper(), this);

    /* loaded from: classes34.dex */
    class a extends al<PubAccountTaskQueue, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PubAccountTaskQueue a(Void r16) {
            return new PubAccountTaskQueue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b extends EIPCModule {
        b(String str) {
            super(str);
        }

        @Override // eipc.EIPCModule
        public EIPCResult onCall(String str, Bundle bundle, int i3) {
            CertifiedFakeFeed createCertifiedFakeFeed;
            if (!QzoneIPCModule.ACTION_PUBLIC_ACCOUNT_GET_TASK_LIST.equalsIgnoreCase(str)) {
                return null;
            }
            Bundle bundle2 = new Bundle();
            CopyOnWriteArrayList<IQueueTask> a16 = PubAccountTaskQueue.this.a();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i16 = 0; i16 < a16.size(); i16++) {
                IQueueTask iQueueTask = a16.get(i16);
                if ((iQueueTask instanceof QZoneUploadShuoShuoTask) && (createCertifiedFakeFeed = ((QZoneUploadShuoShuoTask) iQueueTask).createCertifiedFakeFeed()) != null) {
                    arrayList.add(createCertifiedFakeFeed);
                }
            }
            bundle2.putInt("taskCount", PubAccountTaskQueue.this.w());
            bundle2.putBoolean("hasRunningTask", PubAccountTaskQueue.this.y());
            bundle2.putBoolean("hasOfflineWaitingTask", PubAccountTaskQueue.this.x());
            bundle2.putParcelableArrayList(CertifiedFakeFeed.BUNDLE_KEY_LIST, arrayList);
            callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (PubAccountTaskQueue.this.f342274d != null) {
                PubAccountTaskQueue.this.f342274d.removeCallbacks(PubAccountTaskQueue.this.f342279m);
                PubAccountTaskQueue.this.f342274d.postDelayed(PubAccountTaskQueue.this.f342279m, 5000L);
                PubAccountTaskQueue.this.f342276f = false;
            }
        }
    }

    PubAccountTaskQueue() {
        NetworkState.addListener(this);
    }

    private static void B(IQueueTask iQueueTask) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CertifiedFakeFeed.BUNDLE_KEY, new CertifiedFakeFeed.Builder().setFeedId("").setClientKey(iQueueTask.getClientKey()).build());
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_PUBLIC_ACCOUNT_FAKE_FEED_DELETE, bundle);
    }

    private void D(IQueueTask iQueueTask) {
        if (iQueueTask.isQunTask()) {
            Intent intent = new Intent();
            intent.setAction("troop_upload");
            CopyOnWriteArrayList<IQueueTask> a16 = a();
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
            Iterator<IQueueTask> it = a16.iterator();
            while (it.hasNext()) {
                IQueueTask next = it.next();
                if (next != null && next.isQunTask()) {
                    copyOnWriteArrayList2.add(next);
                }
                if (next != null && next.getState() == 2 && next.isQunTask()) {
                    copyOnWriteArrayList.add(next);
                }
            }
            intent.putExtra("count", copyOnWriteArrayList2.size());
            intent.putExtra("fail", copyOnWriteArrayList.size() > 0);
            if (copyOnWriteArrayList2.size() == 0) {
                ToastUtil.g(l.a(R.string.plg), 0);
            }
            if (QLog.isColorLevel()) {
                QLog.w("[upload_outbox_PubAccountTaskQueue]", 2, "troopAlbumReceiver" + v());
            }
            BaseApplication.getContext().sendBroadcast(intent);
        }
    }

    private void E(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "onAddTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        com.tencent.pubaccount.publish.a.d().a(iQueueTask);
        if (!NetworkState.isNetSupport()) {
            iQueueTask.setState(6);
        }
        R();
        C();
    }

    private void F(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "onCompleteTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        com.tencent.pubaccount.publish.a.d().b(iQueueTask, message.arg1 == 1);
        D(iQueueTask);
        R();
        C();
    }

    private void G(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "onPauseTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        com.tencent.pubaccount.publish.a.d().m(iQueueTask);
    }

    private void H(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "onRemoveTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        com.tencent.pubaccount.publish.a.d().n(iQueueTask);
        if (iQueueTask.isVideoTask()) {
            j.b().e(iQueueTask.getCommentUniKey());
        }
        R();
        C();
        B(iQueueTask);
        EventCenter.getInstance().post("WriteOperation", 13, iQueueTask);
    }

    private void I() {
        QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "onResetTask task size:" + w());
        com.tencent.pubaccount.publish.a.d().o();
    }

    private void J() {
        if (com.tencent.pubaccount.publish.a.d().p()) {
            this.f342274d.removeCallbacks(this.C);
            this.f342274d.postDelayed(this.C, 3000L);
            this.f342274d.removeCallbacks(this.f342278i);
            this.f342274d.postDelayed(this.f342278i, 5000L);
        }
        QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "onRestore taskList size:" + w());
        C();
        N();
    }

    private void K(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "onResumeTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        com.tencent.pubaccount.publish.a.d().q(iQueueTask);
        R();
        C();
    }

    private void L(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "onUpdateTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        com.tencent.pubaccount.publish.a.d().s(iQueueTask);
    }

    private void M() {
        QZLog.i("[upload_outbox_PubAccountTaskQueue]", "outboxStateChange LEAVE_WIFI_CHECK_SIZE  = " + QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_LEAVE_WIFI_CHECK_SIZE, 10));
        if (w() > 0) {
            if (u() >= r0 * 1024 * 1024) {
                this.f342274d.removeCallbacks(this.f342279m);
                QZLog.i("[upload_outbox_PubAccountTaskQueue]", "outboxStateChange leave size bigger than threshold, pauseAllUploadTask --- ");
                UploadServiceBuilder.getInstance().pauseAllTask();
                com.tencent.pubaccount.publish.a.d().l();
                if (QZoneAppInterface.isRunningForeground()) {
                    if (!this.f342276f) {
                        S(BaseActivity.getTopActivity());
                    } else {
                        this.f342274d.removeCallbacks(this.f342279m);
                        this.f342274d.postDelayed(this.f342279m, 5000L);
                    }
                    F = false;
                } else {
                    F = true;
                }
                C();
                return;
            }
            QZLog.i("[upload_outbox_PubAccountTaskQueue]", "outboxStateChange leave size smaller than threshold, restart upload tasks after 5s --- ");
            this.f342274d.removeCallbacks(this.f342279m);
            this.f342274d.postDelayed(this.f342279m, 5000L);
            this.f342276f = false;
        }
    }

    private void N() {
        try {
            QIPCClientHelper.getInstance().getClient().registerModule(new b(QzoneIPCModule.NAME_CLIENT_PUBACCOUNT));
        } catch (RuntimeException unused) {
        }
    }

    private boolean Q(int i3) {
        if (i3 != 0 && i3 != -3000 && i3 != -5000 && i3 != 35000 && i3 != 301002 && i3 != 301013 && i3 != 1000004) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R() {
        return com.tencent.pubaccount.publish.a.d().r();
    }

    private List<com.qzone.publish.business.publishqueue.b> r() {
        ArrayList arrayList;
        synchronized (this.f342275e) {
            arrayList = null;
            if (this.f342275e.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<WeakReference<com.qzone.publish.business.publishqueue.b>> it = this.f342275e.iterator();
                while (it.hasNext()) {
                    WeakReference<com.qzone.publish.business.publishqueue.b> next = it.next();
                    com.qzone.publish.business.publishqueue.b bVar = next == null ? null : next.get();
                    if (bVar != null) {
                        arrayList2.add(bVar);
                    }
                }
                arrayList = arrayList2;
            }
        }
        return arrayList;
    }

    public static PubAccountTaskQueue t() {
        return E.get(null);
    }

    private long u() {
        return com.tencent.pubaccount.publish.a.d().e();
    }

    private int v() {
        return com.tencent.pubaccount.publish.a.d().f();
    }

    public void C() {
        List<com.qzone.publish.business.publishqueue.b> r16 = r();
        if (r16 != null) {
            for (com.qzone.publish.business.publishqueue.b bVar : r16) {
                if (bVar != null) {
                    bVar.onQueueChanged();
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt("taskCount", w());
        bundle.putBoolean("hasRunningTask", y());
        bundle.putBoolean("hasOfflineWaitingTask", x());
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_PUBLIC_ACCOUNT_QUEUE_CHANGED, bundle);
    }

    public void O() {
        Message obtain = Message.obtain();
        obtain.what = 7;
        this.f342274d.sendMessage(obtain);
    }

    public void P() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.f342274d.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public CopyOnWriteArrayList<IQueueTask> a() {
        long currentTimeMillis = System.currentTimeMillis();
        CopyOnWriteArrayList<IQueueTask> i3 = com.tencent.pubaccount.publish.a.d().i();
        QZLog.d("[upload_outbox_PubAccountTaskQueue]", 1, "getTaskList timeCost:" + (System.currentTimeMillis() - currentTimeMillis));
        return i3;
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void d(IQueueTask iQueueTask) {
        List<com.qzone.publish.business.publishqueue.b> r16 = r();
        if (r16 != null) {
            for (com.qzone.publish.business.publishqueue.b bVar : r16) {
                if (bVar != null) {
                    bVar.H(iQueueTask);
                }
            }
        }
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public CopyOnWriteArrayList<IQueueTask> e() {
        CopyOnWriteArrayList<IQueueTask> a16 = a();
        CopyOnWriteArrayList<IQueueTask> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator<IQueueTask> it = a16.iterator();
        while (it.hasNext()) {
            IQueueTask next = it.next();
            if (next != null && next.getState() == 2) {
                copyOnWriteArrayList.add(next);
            }
        }
        return copyOnWriteArrayList;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                E(message);
                return false;
            case 2:
                K(message);
                return false;
            case 3:
                G(message);
                return false;
            case 4:
                H(message);
                return false;
            case 5:
                J();
                return false;
            case 6:
                F(message);
                return false;
            case 7:
                I();
                return false;
            case 8:
                L(message);
                return false;
            default:
                return false;
        }
    }

    public boolean s(IQueueTask iQueueTask) {
        return com.tencent.pubaccount.publish.a.d().c(iQueueTask);
    }

    public int w() {
        return com.tencent.pubaccount.publish.a.d().h();
    }

    public boolean x() {
        return com.tencent.pubaccount.publish.a.d().j();
    }

    public boolean y() {
        return com.tencent.pubaccount.publish.a.d().k();
    }

    public void S(Context context) {
        if (context == null) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.f342277h;
        if ((qQCustomDialog == null || !qQCustomDialog.isShowing()) && !this.f342276f) {
            this.f342276f = true;
            this.f342277h = new e().f(context, 230, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleUploadConfirm", "\u7ee7\u7eed\u4e0a\u4f20\u786e\u8ba4"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageTrafficTips", "\u975eWiFi\u7f51\u7edc\uff0c\u7ee7\u7eed\u53d1\u8868\u5c06\u4f1a\u4f7f\u7528\u624b\u673a\u6d41\u91cf"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficUpload", "\u6d41\u91cf\u4e0a\u4f20"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogWifiUpload", "WiFi\u4e0a\u4f20"), new c(), null);
            QZLog.d("[upload_outbox_PubAccountTaskQueue]", 2, "showLeaveWifiDialog");
        }
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void b(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return;
        }
        iQueueTask.setTime(System.currentTimeMillis());
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = iQueueTask;
        this.f342274d.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void c(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = iQueueTask;
        this.f342274d.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void g(IQueueTask iQueueTask, boolean z16) {
        if (iQueueTask == null) {
            QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "completeTask null");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.arg1 = z16 ? 1 : 0;
        obtain.obj = iQueueTask;
        this.f342274d.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void i(com.qzone.publish.business.publishqueue.b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f342275e) {
            Iterator<WeakReference<com.qzone.publish.business.publishqueue.b>> it = this.f342275e.iterator();
            while (it.hasNext()) {
                com.qzone.publish.business.publishqueue.b bVar2 = it.next().get();
                if (bVar2 == null) {
                    it.remove();
                } else if (bVar2 == bVar) {
                    return;
                }
            }
            this.f342275e.add(new WeakReference<>(bVar));
        }
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void j(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = iQueueTask;
        this.f342274d.sendMessage(obtain);
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        if (z16 && NetworkState.isWifiConn()) {
            F = false;
            this.f342276f = false;
            QQCustomDialog qQCustomDialog = this.f342277h;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f342277h.dismiss();
                this.f342277h = null;
            }
            this.f342274d.removeCallbacks(this.f342279m);
            this.f342274d.postDelayed(this.f342279m, 10000L);
        }
        boolean h16 = TMSManager.e().h();
        if (TMSManager.e().h()) {
            if (QZLog.isColorLevel()) {
                QZLog.d("[upload_outbox_PubAccountTaskQueue]", 2, "isKingCard:", Boolean.valueOf(TMSManager.e().h()));
            }
            if (!z16 || NetworkState.isWifiConn() || h16) {
                return;
            }
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return false;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_RECONNECTION_TIMES, Integer.MAX_VALUE);
        long config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_RECONNECTION_DAYS, 7) * 86400;
        if (iQueueTask.getRetryNum() < config && System.currentTimeMillis() - iQueueTask.getTimeStamp() < config2) {
            return true;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("[upload_outbox_PubAccountTaskQueue]", 1, "this task is out of date. task.retryNum = " + iQueueTask.getRetryNum() + ",task.timestamp = " + iQueueTask.getTimeStamp());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return false;
        }
        D = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_RECONNECTION_TIMES, D);
        return iQueueTask.getState() == 2 && Q(iQueueTask.getResultCode()) && iQueueTask.getRetryNum() < D;
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public boolean f(IQueueTask iQueueTask) {
        boolean z16 = false;
        if (iQueueTask == null) {
            return false;
        }
        if (s(iQueueTask)) {
            if (iQueueTask.getState() != 2 && iQueueTask.getState() != 0 && iQueueTask.getState() != 5 && iQueueTask.getState() != 6 && !iQueueTask.cancel()) {
                QZLog.i("[upload_outbox_PubAccountTaskQueue]", 1, "removeTask cancel fail");
                return false;
            }
            z16 = true;
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = iQueueTask;
        this.f342274d.sendMessage(obtain);
        return z16;
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public boolean h(IQueueTask iQueueTask, boolean z16) {
        if (iQueueTask == null) {
            return false;
        }
        String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_SAFETY_STRIKE_CODE, QzoneConfig.DefaultValue.DEFAULT_PUBLISH_QUEUE_SAFETY_STRIKE_CODE);
        if (!TextUtils.isEmpty(config)) {
            for (String str : config.split(",")) {
                if (!TextUtils.isEmpty(str) && str.equals(String.valueOf(iQueueTask.getResultCode()))) {
                    if (z16) {
                        C();
                    }
                    QZLog.d("[upload_outbox_PubAccountTaskQueue]", 1, "this task is beSafetyStriked(). task.mResultCode = " + iQueueTask.getResultCode() + ",errorCode = " + config);
                    return true;
                }
            }
        }
        return false;
    }
}
