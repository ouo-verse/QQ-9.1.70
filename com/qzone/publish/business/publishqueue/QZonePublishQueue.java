package com.qzone.publish.business.publishqueue;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.qzone.app.QZoneAppInterface;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.event.EventCenter;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.publish.business.process.base.QZoneProcessType;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.business.task.QZoneQunUploadPicTask;
import com.qzone.publish.business.task.QZoneUploadAlbumVideoTask;
import com.qzone.publish.business.task.QZoneUploadPicTask;
import com.qzone.publish.service.RemoteVideoServiceHandler;
import com.qzone.reborn.repair.bean.QZonePhotoUploadStatusEvent;
import com.qzone.util.ToastUtil;
import com.qzone.util.al;
import com.qzone.util.j;
import com.qzone.util.l;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vip.TMSManager;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import common.config.service.QzoneConfig;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class QZonePublishQueue implements Handler.Callback, NetworkState.NetworkStateListener, com.qzone.publish.business.publishqueue.a {
    private static int D = 10;
    private static final al<QZonePublishQueue, Void> E = new a();
    public static boolean F = false;

    /* renamed from: h, reason: collision with root package name */
    private QQCustomDialog f51091h;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<WeakReference<com.qzone.publish.business.publishqueue.b>> f51089e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f51090f = false;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f51092i = new Runnable() { // from class: com.qzone.publish.business.publishqueue.QZonePublishQueue.4
        @Override // java.lang.Runnable
        public void run() {
            QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "checkRetryForOffline");
            QZonePublishQueue.this.Z();
            QZonePublishQueue.this.J();
        }
    };

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f51093m = new Runnable() { // from class: com.qzone.publish.business.publishqueue.QZonePublishQueue.5
        @Override // java.lang.Runnable
        public void run() {
            CopyOnWriteArrayList<IQueueTask> a16;
            if ((QZonePublishQueue.this.f51091h == null || !QZonePublishQueue.this.f51091h.isShowing()) && (a16 = QZonePublishQueue.this.a()) != null) {
                int size = a16.size();
                QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "checkRetryForOffline2Normarl taskList size:" + size);
                for (int i3 = 0; i3 < size; i3++) {
                    IQueueTask iQueueTask = a16.get(i3);
                    if (QZonePublishQueue.this.H(iQueueTask) && QZonePublishQueue.this.I(iQueueTask) && !QZonePublishQueue.this.h(iQueueTask, true)) {
                        QZonePublishQueue.this.j(iQueueTask);
                    }
                }
            }
        }
    };
    private Runnable C = new Runnable() { // from class: com.qzone.publish.business.publishqueue.QZonePublishQueue.6
        @Override // java.lang.Runnable
        public void run() {
            CopyOnWriteArrayList<IQueueTask> a16;
            if (NetworkState.isWifiConn() && (a16 = QZonePublishQueue.this.a()) != null) {
                int size = a16.size();
                QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "checkRetry taskList size:" + size);
                for (int i3 = 0; i3 < size; i3++) {
                    IQueueTask iQueueTask = a16.get(i3);
                    if (QZonePublishQueue.this.H(iQueueTask) && QZonePublishQueue.this.I(iQueueTask) && !QZonePublishQueue.this.h(iQueueTask, true)) {
                        QZonePublishQueue.this.j(iQueueTask);
                    }
                }
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private Handler f51088d = new Handler(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.RealTimeThread).getLooper(), this);

    /* loaded from: classes39.dex */
    class a extends al<QZonePublishQueue, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZonePublishQueue a(Void r102) {
            RFWLog.i("[upload2_outbox_QZonePublishQueue]", RFWLog.USR, "initPublishQueue,  uin=" + LoginData.getInstance().getUinString());
            if (!UploadServiceBuilder.getInstance().isInitialized()) {
                UploadEnv uploadEnv = new UploadEnv();
                UploadServiceBuilder.init(BaseApplication.getContext(), new r7.b(), new r7.d(), new r7.e(), uploadEnv, uploadEnv, null);
                RFWLog.i("[upload2_outbox_QZonePublishQueue]", RFWLog.USR, "initPublishQueue,  again init UploadService");
            }
            return new QZonePublishQueue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            RFWLog.i("[upload2_outbox_QZonePublishQueue]", RFWLog.USR, "initBroadcastReceiver receive query");
            QZonePublishQueue.this.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (QZonePublishQueue.this.f51088d != null) {
                QZonePublishQueue.this.f51088d.removeCallbacks(QZonePublishQueue.this.f51093m);
                QZonePublishQueue.this.f51088d.postDelayed(QZonePublishQueue.this.f51093m, 5000L);
                QZonePublishQueue.this.f51090f = false;
            }
        }
    }

    QZonePublishQueue() {
        NetworkState.addListener(this);
        G();
    }

    private void G() {
        if (MobileQQ.sProcessId == 2) {
            BaseApplicationImpl.getApplication().registerReceiver(new b(), new IntentFilter(QzoneFrame.QZONE_PUBLISH_QUEUE_NOTIFY_FROM_QUERY));
        }
    }

    private void K(IQueueTask iQueueTask) {
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
                ToastUtil.g(l.a(R.string.s59), 0);
            }
            if (QLog.isColorLevel()) {
                QLog.w("[upload2_outbox_QZonePublishQueue]", 2, "troopAlbumReceiver" + y());
            }
            BaseApplication.getContext().sendBroadcast(intent);
        }
    }

    private void L(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        iQueueTask.resetTraceId();
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "onAddTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        WinkPublishQualityReportData.Builder ext1 = new WinkPublishQualityReportData.Builder().eventId(eo.d.f396882b).ext1(iQueueTask.getClientKey());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(iQueueTask.getRetryNum());
        sb5.append("");
        eo.d.b(ext1.ext2(sb5.toString()).ext3(iQueueTask.getExactType() + "").ext4(eo.d.f396889i).traceId(iQueueTask.getTraceId()).getReportData());
        f.d().a(iQueueTask);
        if (!NetworkState.isNetSupport()) {
            iQueueTask.setState(6);
        }
        Z();
        K(iQueueTask);
        J();
    }

    private void M(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "onCompleteTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        f.d().b(iQueueTask, message.arg1 == 1);
        QZoneQueueTask qZoneQueueTask = iQueueTask instanceof QZoneQueueTask ? (QZoneQueueTask) iQueueTask : null;
        K(iQueueTask);
        u(iQueueTask, qZoneQueueTask, message.arg1 == 1);
        d(iQueueTask);
        Z();
        J();
    }

    private void N(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "onPauseTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        f.d().o(iQueueTask);
    }

    private void O(Message message) {
        String str;
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        if (iQueueTask.getState() == 2 && iQueueTask.getResultCode() != 0) {
            str = eo.d.f396885e;
        } else {
            str = eo.d.f396886f;
        }
        eo.d.b(new WinkPublishQualityReportData.Builder().eventId(str).ext1(iQueueTask.getClientKey()).ext2(iQueueTask.getRetryNum() + "").ext3(iQueueTask.getExactType() + "").ext4(eo.d.f396889i).traceId(iQueueTask.getTraceId()).getReportData());
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "onRemoveTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        f.d().p(iQueueTask);
        if (iQueueTask.isVideoTask()) {
            j.b().e(iQueueTask.getCommentUniKey());
        }
        Z();
        K(iQueueTask);
        J();
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            le.b.f414397d.e(iQueueTask.getClientKey());
        } else {
            EventCenter.getInstance().post("WriteOperation", 13, iQueueTask);
        }
    }

    private void P() {
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "onResetTask task size:" + A());
        f.d().q();
    }

    private void Q() {
        if (f.d().r()) {
            this.f51088d.removeCallbacks(this.C);
            this.f51088d.postDelayed(this.C, 3000L);
            this.f51088d.removeCallbacks(this.f51092i);
            this.f51088d.postDelayed(this.f51092i, 5000L);
        }
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "onRestore taskList size:" + A());
        J();
    }

    private void R(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        if (iQueueTask.getState() == 2 && iQueueTask.getResultCode() != 0) {
            iQueueTask.resetTraceId();
            eo.d.b(new WinkPublishQualityReportData.Builder().eventId(eo.d.f396884d).ext1(iQueueTask.getClientKey()).ext2(iQueueTask.getRetryNum() + "").ext3(iQueueTask.getExactType() + "").ext4(eo.d.f396889i).traceId(iQueueTask.getTraceId()).getReportData());
        }
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "onResumeTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType() + ",old task status:" + iQueueTask.getState());
        f.d().s(iQueueTask);
        Z();
        J();
    }

    private void S(Message message) {
        IQueueTask iQueueTask = (IQueueTask) message.obj;
        if (iQueueTask == null) {
            return;
        }
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "onUpdateTask id:" + iQueueTask.getTaskId() + ", type:" + iQueueTask.getExactType());
        f.d().v(iQueueTask);
    }

    private void T() {
        QZLog.i("[upload2_outbox_QZonePublishQueue]", "outboxStateChange LEAVE_WIFI_CHECK_SIZE  = " + QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_LEAVE_WIFI_CHECK_SIZE, 10));
        if (A() > 0) {
            if (x() >= r0 * 1024 * 1024) {
                this.f51088d.removeCallbacks(this.f51093m);
                QZLog.i("[upload2_outbox_QZonePublishQueue]", "outboxStateChange leave size bigger than threshold, pauseAllUploadTask --- ");
                UploadServiceBuilder.getInstance().pauseAllTask();
                f.d().n();
                if (QZoneAppInterface.isRunningForeground()) {
                    if (!this.f51090f) {
                        b0(BaseActivity.getTopActivity());
                    } else {
                        this.f51088d.removeCallbacks(this.f51093m);
                        this.f51088d.postDelayed(this.f51093m, 5000L);
                    }
                    F = false;
                } else {
                    F = true;
                }
                J();
                ClickReport.q("313", "6", "7", true);
                return;
            }
            QZLog.i("[upload2_outbox_QZonePublishQueue]", "outboxStateChange leave size smaller than threshold, restart upload tasks after 5s --- ");
            this.f51088d.removeCallbacks(this.f51093m);
            this.f51088d.postDelayed(this.f51093m, 5000L);
            this.f51090f = false;
        }
    }

    private boolean X(int i3) {
        if (i3 != 0 && i3 != -3000 && i3 != -5000 && i3 != 35000 && i3 != 301002 && i3 != 301013 && i3 != 1000004) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Z() {
        return f.d().t();
    }

    private boolean a0() {
        return true;
    }

    private List<com.qzone.publish.business.publishqueue.b> s() {
        ArrayList arrayList;
        synchronized (this.f51089e) {
            arrayList = null;
            if (this.f51089e.size() > 0) {
                ArrayList arrayList2 = new ArrayList();
                Iterator<WeakReference<com.qzone.publish.business.publishqueue.b>> it = this.f51089e.iterator();
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

    private void u(IQueueTask iQueueTask, QZoneQueueTask qZoneQueueTask, boolean z16) {
        String str;
        WinkPublishQualityReportData.Builder traceId = new WinkPublishQualityReportData.Builder().eventId(eo.d.f396883c).ext1(iQueueTask.getClientKey()).ext2(iQueueTask.getRetryNum() + "").ext3(iQueueTask.getExactType() + "").ext4(eo.d.f396889i).traceId(iQueueTask.getTraceId());
        if (z16) {
            str = "0";
        } else {
            str = iQueueTask.getResultCode() + "";
        }
        WinkPublishQualityReportData.Builder retCode = traceId.retCode(str);
        com.qzone.publish.business.model.a reportInfo = qZoneQueueTask != null ? qZoneQueueTask.getReportInfo() : null;
        if (reportInfo != null) {
            reportInfo.f51013d = System.currentTimeMillis();
            JSONObject c16 = reportInfo.c();
            if (c16 != null) {
                retCode.attachInfo(c16.toString());
            }
            QZoneProcessType breakTaskProcessType = qZoneQueueTask.getBreakTaskProcessType();
            if (breakTaskProcessType != null && !z16) {
                retCode.desc(breakTaskProcessType.convertErrorDesc(iQueueTask.getResultMsg()));
            } else {
                retCode.desc(iQueueTask.getResultMsg());
            }
        } else {
            retCode.desc(iQueueTask.getResultMsg());
        }
        eo.d.b(retCode.getReportData());
    }

    public static QZonePublishQueue w() {
        return E.get(null);
    }

    private long x() {
        return f.d().e();
    }

    private int y() {
        return f.d().f();
    }

    public int A() {
        return f.d().i();
    }

    public List<IQueueTask> B(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f.d().k(str);
    }

    public IQueueTask C() {
        CopyOnWriteArrayList<IQueueTask> a16 = a();
        if (a16 != null && a16.size() > 0) {
            for (IQueueTask iQueueTask : a16) {
                if (iQueueTask != null && iQueueTask.getExactType() == 14) {
                    return iQueueTask;
                }
            }
        }
        return null;
    }

    public int D(String str) {
        CopyOnWriteArrayList<IQueueTask> a16 = a();
        int i3 = 0;
        if (a16 != null && a16.size() > 0) {
            for (IQueueTask iQueueTask : a16) {
                if (iQueueTask != null && (iQueueTask instanceof QZoneQunUploadPicTask)) {
                    QZoneQunUploadPicTask qZoneQunUploadPicTask = (QZoneQunUploadPicTask) iQueueTask;
                    if (qZoneQunUploadPicTask.getAlbumId() != null && str != null && str.equals(qZoneQunUploadPicTask.getAlbumId())) {
                        i3++;
                    }
                }
            }
        }
        return i3;
    }

    public boolean E() {
        return f.d().l();
    }

    public boolean F() {
        return f.d().m();
    }

    public void J() {
        if (a0()) {
            Intent intent = new Intent();
            intent.setAction(QzoneFrame.QZONE_PUBLISH_QUEUE_NOTIFY);
            int A = w().A();
            boolean F2 = w().F();
            boolean E2 = w().E();
            QLog.i("qzone_publish", 1, "QZonePublishQueue sendBroadcast, size: " + A + ", hasRunningTask: " + F2 + ", hasOfflineWaittingTask: " + E2);
            intent.putExtra("size", A);
            intent.putExtra("hasRunningTask", F2);
            intent.putExtra("hasOfflineWaittingTask", E2);
            BaseApplicationImpl.getApplication().sendBroadcast(intent);
        }
        List<com.qzone.publish.business.publishqueue.b> s16 = s();
        if (s16 != null) {
            for (com.qzone.publish.business.publishqueue.b bVar : s16) {
                if (bVar != null) {
                    bVar.onQueueChanged();
                }
            }
        }
    }

    public void V() {
        Message obtain = Message.obtain();
        obtain.what = 7;
        this.f51088d.sendMessage(obtain);
    }

    public void W() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.f51088d.sendMessage(obtain);
    }

    public void Y(String str, String str2, String str3) {
        CopyOnWriteArrayList<IQueueTask> a16 = a();
        if (a16 == null || a16.size() <= 0) {
            return;
        }
        Iterator<IQueueTask> it = a16.iterator();
        while (it.hasNext()) {
            IQueueTask next = it.next();
            if (next instanceof QZoneUploadPicTask) {
                QZoneUploadPicTask qZoneUploadPicTask = (QZoneUploadPicTask) next;
                if (qZoneUploadPicTask.getAlbumId().equals(str) && qZoneUploadPicTask.getState() == 2 && (qZoneUploadPicTask.getResultCode() == -207 || (qZoneUploadPicTask.getResultMsg().contains("-207") && qZoneUploadPicTask.getResultCode() == -2000))) {
                    qZoneUploadPicTask.albumsId = str2;
                    qZoneUploadPicTask.albumname = str3;
                    j(qZoneUploadPicTask);
                }
            } else if (next instanceof QZoneQunUploadPicTask) {
                QZoneQunUploadPicTask qZoneQunUploadPicTask = (QZoneQunUploadPicTask) next;
                if (qZoneQunUploadPicTask.getAlbumId().equals(str) && qZoneQunUploadPicTask.mState == 2 && (qZoneQunUploadPicTask.getResultCode() == -207 || (qZoneQunUploadPicTask.getResultMsg().contains("-207") && qZoneQunUploadPicTask.getResultCode() == -2000))) {
                    qZoneQunUploadPicTask.albumsId = str2;
                    qZoneQunUploadPicTask.albumname = str3;
                    j(qZoneQunUploadPicTask);
                }
            } else if (next instanceof QZoneUploadAlbumVideoTask) {
                QZoneUploadAlbumVideoTask qZoneUploadAlbumVideoTask = (QZoneUploadAlbumVideoTask) next;
                if (qZoneUploadAlbumVideoTask.sAlbumID.equals(str)) {
                    qZoneUploadAlbumVideoTask.sAlbumID = str2;
                    qZoneUploadAlbumVideoTask.sAlbumName = str3;
                    j(qZoneUploadAlbumVideoTask);
                }
            }
        }
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public CopyOnWriteArrayList<IQueueTask> a() {
        return f.d().j();
    }

    public void c0() {
        if (RemoteVideoServiceHandler.j().k()) {
            Message obtain = Message.obtain();
            obtain.what = 1003;
            RemoteVideoServiceHandler.j().n(obtain);
        }
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void d(IQueueTask iQueueTask) {
        List<com.qzone.publish.business.publishqueue.b> s16 = s();
        if (s16 != null) {
            for (com.qzone.publish.business.publishqueue.b bVar : s16) {
                if (bVar != null) {
                    bVar.H(iQueueTask);
                }
            }
        }
        if (iQueueTask == null || iQueueTask.getState() != 3) {
            return;
        }
        QZonePhotoUploadStatusEvent qZonePhotoUploadStatusEvent = new QZonePhotoUploadStatusEvent();
        qZonePhotoUploadStatusEvent.setTaskId(iQueueTask.getTaskId());
        qZonePhotoUploadStatusEvent.setCacheKey(iQueueTask.getCommentUniKey());
        qZonePhotoUploadStatusEvent.setState(iQueueTask.getState());
        qZonePhotoUploadStatusEvent.setPhotoSource(iQueueTask.getPhotoSource());
        com.qzone.publish.business.task.c info = iQueueTask.getInfo();
        if (info != null) {
            qZonePhotoUploadStatusEvent.setProgress(info.f51190f);
        }
        SimpleEventBus.getInstance().dispatchEvent(qZonePhotoUploadStatusEvent, true);
    }

    public void d0() {
        if (RemoteVideoServiceHandler.j().k()) {
            Message obtain = Message.obtain();
            obtain.what = 1002;
            RemoteVideoServiceHandler.j().n(obtain);
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
                L(message);
                return false;
            case 2:
                R(message);
                return false;
            case 3:
                N(message);
                return false;
            case 4:
                O(message);
                return false;
            case 5:
                Q();
                return false;
            case 6:
                M(message);
                return false;
            case 7:
                P();
                return false;
            case 8:
                S(message);
                return false;
            default:
                return false;
        }
    }

    public boolean t(IQueueTask iQueueTask) {
        return f.d().c(iQueueTask);
    }

    public int[] v(String str) {
        int[] iArr = new int[2];
        Iterator<IQueueTask> it = a().iterator();
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            IQueueTask next = it.next();
            if (next instanceof QZoneUploadPicTask) {
                QZoneUploadPicTask qZoneUploadPicTask = (QZoneUploadPicTask) next;
                if (qZoneUploadPicTask.getAlbumId().equals(str)) {
                    if (qZoneUploadPicTask.mState == 2) {
                        if (qZoneUploadPicTask.getResultCode() != -207) {
                            if (qZoneUploadPicTask.getResultMsg().contains("-207") && qZoneUploadPicTask.getResultCode() == -2000) {
                            }
                        }
                        i3++;
                    }
                }
            } else if (next instanceof QZoneQunUploadPicTask) {
                QZoneQunUploadPicTask qZoneQunUploadPicTask = (QZoneQunUploadPicTask) next;
                if (qZoneQunUploadPicTask.getAlbumId().equals(str)) {
                    if (qZoneQunUploadPicTask.mState == 2) {
                        if (qZoneQunUploadPicTask.getResultCode() != -207) {
                            if (qZoneQunUploadPicTask.getResultMsg().contains("-207") && qZoneQunUploadPicTask.getResultCode() == -2000) {
                            }
                        }
                        i3++;
                    }
                }
            } else if ((next instanceof QZoneUploadAlbumVideoTask) && ((QZoneUploadAlbumVideoTask) next).sAlbumID.equals(str)) {
                i16++;
            }
        }
        iArr[0] = i3;
        iArr[1] = i16;
        return iArr;
    }

    public IQueueTask z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f.d().h(str);
    }

    public void U(com.qzone.publish.business.publishqueue.b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f51089e) {
            Iterator<WeakReference<com.qzone.publish.business.publishqueue.b>> it = this.f51089e.iterator();
            while (it.hasNext()) {
                WeakReference<com.qzone.publish.business.publishqueue.b> next = it.next();
                com.qzone.publish.business.publishqueue.b bVar2 = next == null ? null : next.get();
                if (bVar2 == null) {
                    it.remove();
                } else if (bVar2 == bVar) {
                    it.remove();
                }
            }
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
        this.f51088d.sendMessage(obtain);
    }

    public void b0(Context context) {
        if (context == null) {
            return;
        }
        QQCustomDialog qQCustomDialog = this.f51091h;
        if ((qQCustomDialog == null || !qQCustomDialog.isShowing()) && !this.f51090f) {
            this.f51090f = true;
            this.f51091h = new com.qzone.component.e().f(context, 230, QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTitleUploadConfirm", "\u7ee7\u7eed\u4e0a\u4f20\u786e\u8ba4"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogMessageTrafficTips", "\u975eWiFi\u7f51\u7edc\uff0c\u7ee7\u7eed\u53d1\u8868\u5c06\u4f1a\u4f7f\u7528\u624b\u673a\u6d41\u91cf"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogTrafficUpload", "\u6d41\u91cf\u4e0a\u4f20"), QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogWifiUpload", "WiFi\u4e0a\u4f20"), new c(), null);
            QZLog.d("[upload2_outbox_QZonePublishQueue]", 2, "showLeaveWifiDialog");
        }
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void c(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = iQueueTask;
        this.f51088d.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void g(IQueueTask iQueueTask, boolean z16) {
        if (iQueueTask == null) {
            QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "completeTask null");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.arg1 = z16 ? 1 : 0;
        obtain.obj = iQueueTask;
        this.f51088d.sendMessage(obtain);
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public void i(com.qzone.publish.business.publishqueue.b bVar) {
        if (bVar == null) {
            return;
        }
        synchronized (this.f51089e) {
            Iterator<WeakReference<com.qzone.publish.business.publishqueue.b>> it = this.f51089e.iterator();
            while (it.hasNext()) {
                com.qzone.publish.business.publishqueue.b bVar2 = it.next().get();
                if (bVar2 == null) {
                    it.remove();
                } else if (bVar2 == bVar) {
                    return;
                }
            }
            this.f51089e.add(new WeakReference<>(bVar));
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
        this.f51088d.sendMessage(obtain);
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        if (z16 && NetworkState.isWifiConn()) {
            F = false;
            this.f51090f = false;
            QQCustomDialog qQCustomDialog = this.f51091h;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f51091h.dismiss();
                this.f51091h = null;
            }
            this.f51088d.removeCallbacks(this.f51093m);
            this.f51088d.postDelayed(this.f51093m, 10000L);
        }
        boolean h16 = TMSManager.e().h();
        if (QZLog.isColorLevel()) {
            QZLog.d("[upload2_outbox_QZonePublishQueue]", 2, "isKingCard:", Boolean.valueOf(h16));
        }
        if (!z16 || NetworkState.isWifiConn() || h16) {
            return;
        }
        T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return false;
        }
        D = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_RECONNECTION_TIMES, D);
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "needRetry  taskId=" + iQueueTask.getTaskId() + "state=" + iQueueTask.getState() + "resultCode=" + iQueueTask.getResultCode() + "retryNum=" + iQueueTask.getRetryNum() + "maxRetryNum=" + D);
        return iQueueTask.getState() == 2 && X(iQueueTask.getResultCode()) && iQueueTask.getRetryNum() < D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return false;
        }
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_RECONNECTION_TIMES, Integer.MAX_VALUE);
        long config2 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_PUBLISH_QUEUE_RECONNECTION_DAYS, 7) * 86400;
        QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "needToReconnection  taskId=" + iQueueTask.getTaskId() + "retryNum=" + iQueueTask.getRetryNum() + "times=" + config + "days=");
        return iQueueTask.getRetryNum() < config && System.currentTimeMillis() - iQueueTask.getTimeStamp() < config2;
    }

    @Override // com.qzone.publish.business.publishqueue.a
    public boolean f(IQueueTask iQueueTask) {
        boolean z16 = false;
        if (iQueueTask == null) {
            return false;
        }
        if (t(iQueueTask)) {
            if (iQueueTask.getState() != 2 && iQueueTask.getState() != 0 && iQueueTask.getState() != 5 && iQueueTask.getState() != 6 && !iQueueTask.cancel()) {
                QZLog.i("[upload2_outbox_QZonePublishQueue]", 1, "removeTask cancel fail");
                return false;
            }
            z16 = true;
        }
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = iQueueTask;
        this.f51088d.sendMessage(obtain);
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
                        J();
                    }
                    QZLog.d("[upload2_outbox_QZonePublishQueue]", 1, "this task is beSafetyStriked(). task.mResultCode = " + iQueueTask.getResultCode() + ",errorCode = " + config);
                    return true;
                }
            }
        }
        return false;
    }

    public void r(IQueueTask iQueueTask) {
        if (iQueueTask == null) {
            return;
        }
        iQueueTask.setState(2);
        b(iQueueTask);
    }
}
