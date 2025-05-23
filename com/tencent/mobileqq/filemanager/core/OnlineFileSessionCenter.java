package com.tencent.mobileqq.filemanager.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes12.dex */
public class OnlineFileSessionCenter {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f207488a;

    /* renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f207490c;

    /* renamed from: b, reason: collision with root package name */
    LinkedHashMap<Long, OnlineFileSessionWorker> f207489b = new LinkedHashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private FMObserver f207491d = new a();

    /* renamed from: e, reason: collision with root package name */
    private UploadProgressMakeEvtPump f207492e = null;

    /* renamed from: f, reason: collision with root package name */
    Handler f207493f = null;

    /* renamed from: g, reason: collision with root package name */
    private LinkedHashMap<String, LinkedHashMap<Long, c>> f207494g = new LinkedHashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private long f207495h = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class UploadProgressMakeEvtPump {

        /* renamed from: a, reason: collision with root package name */
        private Timer f207499a = null;

        UploadProgressMakeEvtPump() {
        }

        synchronized void b() {
            if (this.f207499a != null) {
                return;
            }
            BaseTimer baseTimer = new BaseTimer();
            this.f207499a = baseTimer;
            baseTimer.schedule(new TimerTask() { // from class: com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.UploadProgressMakeEvtPump.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (UploadProgressMakeEvtPump.this.f207499a == null) {
                        return;
                    }
                    Message message = new Message();
                    message.what = 1;
                    OnlineFileSessionCenter.this.f207493f.sendMessage(message);
                }
            }, 1000L, 1000L);
            QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  progress make  start. . .");
        }

        synchronized void c() {
            Timer timer = this.f207499a;
            if (timer != null) {
                timer.cancel();
                this.f207499a = null;
            }
            QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  progress make  exit. . .");
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends FMObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void l0(long j3) {
            if (0 == j3) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] OnOnlineFileProgressDirectDone sessionid error.return");
                return;
            }
            OnlineFileSessionWorker g16 = OnlineFileSessionCenter.this.g(j3);
            if (g16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.OnOnlineFileProgressDirectDone");
                return;
            }
            g16.B();
            if (g16.v()) {
                OnlineFileSessionCenter.this.w(j3);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void m0(long j3) {
            if (0 == j3) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
                return;
            }
            OnlineFileSessionWorker g16 = OnlineFileSessionCenter.this.g(j3);
            if (g16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
                return;
            }
            g16.y();
            if (g16.v()) {
                OnlineFileSessionCenter.this.w(j3);
            }
        }

        @Override // com.tencent.mobileqq.filemanager.app.FMObserver
        protected void n0(long j3) {
            if (0 == j3) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
                return;
            }
            OnlineFileSessionWorker g16 = OnlineFileSessionCenter.this.g(j3);
            if (g16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
                return;
            }
            g16.G();
            if (g16.v()) {
                OnlineFileSessionCenter.this.w(j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            OnlineFileSessionCenter.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c {

        /* renamed from: a, reason: collision with root package name */
        int f207504a;

        /* renamed from: b, reason: collision with root package name */
        long f207505b = com.tencent.mobileqq.service.message.e.K0();

        /* renamed from: c, reason: collision with root package name */
        int f207506c;

        /* renamed from: d, reason: collision with root package name */
        String f207507d;

        /* renamed from: e, reason: collision with root package name */
        long f207508e;

        c(int i3) {
            this.f207504a = i3;
        }
    }

    public OnlineFileSessionCenter(final QQAppInterface qQAppInterface) {
        this.f207488a = qQAppInterface;
        qQAppInterface.getFileManagerNotifyCenter().addObserver(this.f207491d);
        try {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.1

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter$1$a */
                /* loaded from: classes12.dex */
                class a extends BroadcastReceiver {
                    a() {
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        String action;
                        if (intent != null && (action = intent.getAction()) != null && action.equals(QQAppInterface.QQ_ACTION_LOGOUT)) {
                            if (QLog.isColorLevel()) {
                                QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, "OLfilesession[] logout.....!");
                            }
                            OnlineFileSessionCenter.this.z();
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    OnlineFileSessionCenter.this.f207490c = new a();
                    qQAppInterface.getApp().registerReceiver(OnlineFileSessionCenter.this.f207490c, new IntentFilter(QQAppInterface.QQ_ACTION_LOGOUT));
                }
            });
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 2, e16.toString());
            }
        }
    }

    void A() {
        UploadProgressMakeEvtPump uploadProgressMakeEvtPump = this.f207492e;
        if (uploadProgressMakeEvtPump != null) {
            uploadProgressMakeEvtPump.c();
            this.f207492e = null;
            QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] stop progress make pump thread!!!");
        }
    }

    public void B(long j3) {
        OnlineFileSessionWorker onlineFileSessionWorker;
        synchronized (this) {
            onlineFileSessionWorker = this.f207489b.get(Long.valueOf(j3));
        }
        if (onlineFileSessionWorker != null) {
            onlineFileSessionWorker.W();
        }
        w(j3);
    }

    void c() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<Long, OnlineFileSessionWorker>> it = this.f207489b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, OnlineFileSessionWorker> next = it.next();
            OnlineFileSessionWorker value = next.getValue();
            value.D(currentTimeMillis);
            if (value.v()) {
                long longValue = next.getKey().longValue();
                int size = this.f207489b.size();
                it.remove();
                QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + longValue + "]. remove the worker..[" + size + " - " + this.f207489b.size() + "]");
            }
        }
        if (this.f207489b.size() == 0) {
            A();
        }
    }

    void d(String str, long j3, c cVar) {
        if (str != null && j3 > 0 && cVar != null) {
            QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]  cacheHandleBeforeRequest handleType:" + cVar.f207504a + " info_1:" + cVar.f207506c + " info_2:" + cVar.f207507d + " info_3:" + cVar.f207508e);
            LinkedHashMap<Long, c> linkedHashMap = this.f207494g.get(str);
            if (linkedHashMap == null) {
                LinkedHashMap<Long, c> linkedHashMap2 = new LinkedHashMap<>();
                linkedHashMap2.put(Long.valueOf(j3), cVar);
                this.f207494g.put(str, linkedHashMap2);
                return;
            }
            linkedHashMap.put(Long.valueOf(j3), cVar);
        }
    }

    public void e() {
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[]  clearHistory. session center stop. . .");
        z();
        QQAppInterface qQAppInterface = this.f207488a;
        if (qQAppInterface != null) {
            if (qQAppInterface.getApp() != null && this.f207490c != null) {
                try {
                    this.f207488a.getApp().unregisterReceiver(this.f207490c);
                } catch (Exception e16) {
                    QLog.d("OnlineFileSessionCenter<FileAssistant>", 1, e16, new Object[0]);
                }
                this.f207490c = null;
            }
            if (this.f207488a.getFileManagerNotifyCenter() != null && this.f207491d != null) {
                this.f207488a.getFileManagerNotifyCenter().deleteObserver(this.f207491d);
            }
        }
    }

    OnlineFileSessionWorker f(String str, long j3) {
        OnlineFileSessionWorker onlineFileSessionWorker;
        FileManagerEntity fileManagerEntity;
        if (str != null) {
            long j16 = 0;
            if (j3 > 0) {
                Iterator<OnlineFileSessionWorker> it = this.f207489b.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        onlineFileSessionWorker = it.next();
                        if (onlineFileSessionWorker != null && (fileManagerEntity = onlineFileSessionWorker.f207513d) != null && str.equalsIgnoreCase(fileManagerEntity.peerUin) && j3 == onlineFileSessionWorker.f207513d.nOLfileSessionId) {
                            break;
                        }
                    } else {
                        onlineFileSessionWorker = null;
                        break;
                    }
                }
                if (onlineFileSessionWorker == null) {
                    FileManagerEntity P = this.f207488a.getFileManagerDataCenter().P(str, j3);
                    if (P != null) {
                        long j17 = P.nSessionId;
                        onlineFileSessionWorker = new OnlineFileSessionWorker(this.f207488a, j17);
                        onlineFileSessionWorker.r(P);
                        synchronized (this) {
                            this.f207489b.put(Long.valueOf(j17), onlineFileSessionWorker);
                        }
                        j16 = j17;
                    }
                } else {
                    FileManagerEntity fileManagerEntity2 = onlineFileSessionWorker.f207513d;
                    if (fileManagerEntity2 != null) {
                        j16 = fileManagerEntity2.nSessionId;
                    }
                }
                if (this.f207488a.getFileManagerDataCenter().w(j16)) {
                    QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j16 + "] getOnlineWorker, but user had deleted it, return null");
                    if (onlineFileSessionWorker != null) {
                        onlineFileSessionWorker.W();
                        w(j16);
                    }
                    return null;
                }
                if (onlineFileSessionWorker != null) {
                    onlineFileSessionWorker.A();
                }
                y();
                return onlineFileSessionWorker;
            }
        }
        return null;
    }

    OnlineFileSessionWorker g(long j3) {
        FileManagerEntity D;
        OnlineFileSessionWorker onlineFileSessionWorker = this.f207489b.get(Long.valueOf(j3));
        if (onlineFileSessionWorker == null && (D = this.f207488a.getFileManagerDataCenter().D(j3)) != null) {
            onlineFileSessionWorker = new OnlineFileSessionWorker(this.f207488a, D.nSessionId);
            onlineFileSessionWorker.r(D);
            synchronized (this) {
                this.f207489b.put(Long.valueOf(j3), onlineFileSessionWorker);
            }
        }
        if (this.f207488a.getFileManagerDataCenter().w(j3)) {
            QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] getOnlineWorker, but user had deleted it, return null");
            if (onlineFileSessionWorker != null) {
                onlineFileSessionWorker.W();
                w(j3);
                return null;
            }
            return null;
        }
        if (onlineFileSessionWorker != null) {
            onlineFileSessionWorker.A();
        }
        y();
        return onlineFileSessionWorker;
    }

    void h(int i3) {
        Iterator<Map.Entry<Long, OnlineFileSessionWorker>> it = this.f207489b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, OnlineFileSessionWorker> next = it.next();
            OnlineFileSessionWorker value = next.getValue();
            value.E(i3);
            if (value.v()) {
                long longValue = next.getKey().longValue();
                it.remove();
                QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + longValue + "]. remove the worker....");
            }
        }
        z();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x007d. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean i(String str, long j3) {
        String str2;
        String str3;
        String str4;
        boolean z16;
        String str5;
        boolean z17;
        String str6;
        String str7;
        String str8;
        String str9;
        boolean z18;
        String str10;
        String str11;
        String str12;
        String str13;
        c cVar;
        boolean z19 = false;
        if (str != null && j3 > 0) {
            LinkedHashMap<Long, c> linkedHashMap = this.f207494g.get(str);
            if (linkedHashMap == null || (cVar = linkedHashMap.get(Long.valueOf(j3))) == null) {
                str2 = "OLfilesession[";
                str3 = " info_3:";
                str4 = " info_2:";
                z16 = true;
                str5 = "OnlineFileSessionCenter<FileAssistant>";
            } else {
                QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]  isBeHandledBeforeRequest handleType:" + cVar.f207504a + " info_1:" + cVar.f207506c + " info_2:" + cVar.f207507d + " info_3:" + cVar.f207508e);
                int i3 = cVar.f207504a;
                if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
                    str2 = "OLfilesession[";
                    str3 = " info_3:";
                    str4 = " info_2:";
                    z16 = true;
                    str5 = "OnlineFileSessionCenter<FileAssistant>";
                    l(str, j3, i3);
                } else {
                    switch (i3) {
                        case 10:
                            str2 = "OLfilesession[";
                            str3 = " info_3:";
                            str4 = " info_2:";
                            z16 = true;
                            str5 = "OnlineFileSessionCenter<FileAssistant>";
                            p(str, j3);
                            break;
                        case 11:
                            str3 = " info_3:";
                            z16 = true;
                            str2 = "OLfilesession[";
                            str4 = " info_2:";
                            str5 = "OnlineFileSessionCenter<FileAssistant>";
                            r(str, j3, cVar.f207506c, cVar.f207507d, cVar.f207508e);
                            break;
                        case 12:
                            str3 = " info_3:";
                            z16 = true;
                            s(str, j3, cVar.f207506c, cVar.f207507d);
                            str2 = "OLfilesession[";
                            z19 = true;
                            str4 = " info_2:";
                            str5 = "OnlineFileSessionCenter<FileAssistant>";
                            break;
                        default:
                            str2 = "OLfilesession[";
                            str3 = " info_3:";
                            str4 = " info_2:";
                            z16 = true;
                            str5 = "OnlineFileSessionCenter<FileAssistant>";
                            break;
                    }
                    linkedHashMap.remove(Long.valueOf(j3));
                    if (linkedHashMap.size() == 0) {
                        this.f207494g.remove(str);
                    }
                }
                z19 = z16;
                linkedHashMap.remove(Long.valueOf(j3));
                if (linkedHashMap.size() == 0) {
                }
            }
            long K0 = com.tencent.mobileqq.service.message.e.K0();
            if (K0 - this.f207495h >= 3600) {
                QLog.i(str5, z16 ? 1 : 0, "OLfilesession[]  isBeHandledBeforeRequest handleType. start clear something");
                this.f207495h = K0;
                if (this.f207494g.size() > 0) {
                    Iterator<T> it = this.f207494g.entrySet().iterator();
                    while (it.hasNext()) {
                        LinkedHashMap linkedHashMap2 = (LinkedHashMap) ((Map.Entry) it.next()).getValue();
                        if (linkedHashMap2 != null && linkedHashMap2.size() > 0) {
                            Iterator it5 = linkedHashMap2.entrySet().iterator();
                            while (it5.hasNext()) {
                                Map.Entry entry = (Map.Entry) it5.next();
                                c cVar2 = (c) entry.getValue();
                                long longValue = ((Long) entry.getKey()).longValue();
                                if (cVar2 != null) {
                                    if (K0 - cVar2.f207505b >= 7200) {
                                        StringBuilder sb5 = new StringBuilder();
                                        str13 = str2;
                                        sb5.append(str13);
                                        sb5.append(longValue);
                                        sb5.append("]  isBeHandledBeforeRequest and clear it.handleType:");
                                        sb5.append(cVar2.f207504a);
                                        sb5.append(" info_1:");
                                        sb5.append(cVar2.f207506c);
                                        str11 = str4;
                                        sb5.append(str11);
                                        sb5.append(cVar2.f207507d);
                                        str12 = str3;
                                        sb5.append(str12);
                                        sb5.append(cVar2.f207508e);
                                        str10 = str5;
                                        z18 = true;
                                        QLog.i(str10, 1, sb5.toString());
                                        it5.remove();
                                    } else {
                                        z18 = z16;
                                        str10 = str5;
                                        str11 = str4;
                                        str12 = str3;
                                        str13 = str2;
                                    }
                                } else {
                                    z18 = z16;
                                    str10 = str5;
                                    str11 = str4;
                                    str12 = str3;
                                    str13 = str2;
                                    it5.remove();
                                }
                                str5 = str10;
                                str4 = str11;
                                str3 = str12;
                                str2 = str13;
                                z16 = z18;
                            }
                            z17 = z16;
                            str6 = str5;
                            str7 = str4;
                            str8 = str3;
                            str9 = str2;
                            if (linkedHashMap2.size() == 0) {
                                it.remove();
                            }
                        } else {
                            z17 = z16 ? 1 : 0;
                            str6 = str5;
                            str7 = str4;
                            str8 = str3;
                            str9 = str2;
                            it.remove();
                        }
                        str5 = str6;
                        str4 = str7;
                        str3 = str8;
                        str2 = str9;
                        z16 = z17;
                    }
                }
            }
        }
        return z19;
    }

    public void j(String str, long j3, boolean z16) {
        if (str != null && j3 > 0) {
            OnlineFileSessionWorker f16 = f(str, j3);
            if (f16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.onAskSenderUpProgressResult");
                return;
            }
            f16.x(z16);
            if (f16.v()) {
                w(f16.f207511b);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] onAskSenderUpProgressResult sessionid error.return");
    }

    public void k(String str, long j3) {
        if (str != null && j3 > 0) {
            OnlineFileSessionWorker f16 = f(str, j3);
            if (f16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.onAskUpProgressAndSessionInvaid");
                return;
            }
            f16.z();
            if (f16.v()) {
                w(f16.f207511b);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] onAskUpProgressAndSessionInvaid sessionid error.return");
    }

    public void l(String str, long j3, int i3) {
        if (str != null && j3 > 0) {
            OnlineFileSessionWorker f16 = f(str, j3);
            if (f16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.onFileRequestBeHandledByPC");
                if (!this.f207488a.getFileManagerDataCenter().x(str, j3)) {
                    d(str, j3, new c(i3));
                    return;
                }
                return;
            }
            f16.C(i3);
            if (f16.v()) {
                w(f16.f207511b);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] onFileRequestBeHandledByPC sessionid error.return");
    }

    public void m(String str, String str2, long j3, short s16, boolean z16, com.tencent.mobileqq.filemanager.data.m mVar, long j16, int i3) {
        int i16;
        if (mVar == null) {
            QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession. request come,but session = null");
            return;
        }
        if (0 == mVar.f207826f) {
            QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "]  onFileRequestCome sessionid error.return");
            return;
        }
        if (this.f207488a.getFileManagerDataCenter().P(str, mVar.f207826f) != null) {
            QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "] request come filename:" + mVar.f207824d + ", but is repeat session and return");
            return;
        }
        if (this.f207488a.getFileManagerDataCenter().x(str, mVar.f207826f)) {
            QLog.w("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "] request come filename:" + mVar.f207824d + "but it had be deleted by user");
            return;
        }
        String makeTransFileProtocolData = TransfileUtile.makeTransFileProtocolData(TransFileUtil.getTransferFilePath(this.f207488a.getAccount(), mVar.f207824d, 0, null), mVar.f207825e, 0, false, null);
        long j17 = q.d(-1000).uniseq;
        FileManagerEntity i17 = this.f207488a.getFileManagerDataCenter().i(j17, str, 0);
        i17.uniseq = j17;
        i17.selfUin = this.f207488a.getAccount();
        i17.setCloudType(0);
        i17.fileName = mVar.f207824d;
        i17.fileSize = mVar.f207825e;
        i17.nOpType = -1;
        i17.peerNick = FileManagerUtil.getPeerNick(this.f207488a, str, null, 0);
        i17.peerType = 0;
        i17.peerUin = str;
        i17.srvTime = 1000 * j3;
        i17.status = 4;
        i17.Uuid = null;
        i17.isReaded = z16;
        i17.bSend = false;
        i17.nFileType = -1;
        i17.nOLfileSessionId = mVar.f207826f;
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + mVar.f207826f + "] - nSessionId[" + i17.nSessionId + "] request come filename:" + mVar.f207824d);
        this.f207488a.getFileManagerProxy().x(i17);
        this.f207488a.getFileManagerDataCenter().t(i17);
        this.f207488a.getFileManagerDataCenter().q(str, str2, false, mVar.f207824d, mVar.f207825e, false, 0, makeTransFileProtocolData, (long) s16, j17, i17.nSessionId, j16, j3, i3, null);
        if (QLog.isColorLevel()) {
            QLog.i("OnlineFileSessionCenter<FileAssistant>", 2, "File Coming:" + FileManagerUtil.printFileManagerEntityInfo(i17));
        }
        this.f207488a.getFileManagerNotifyCenter().c(j17, i17.nSessionId, str, 0, 17, null, 0, null);
        if (!str.equals(this.f207488a.getMessageFacade().s1())) {
            i16 = 1;
            this.f207488a.handleReceivedMessage(1, true, true);
        } else {
            i16 = 1;
        }
        OnlineFileSessionWorker onlineFileSessionWorker = new OnlineFileSessionWorker(this.f207488a, i17.nSessionId);
        onlineFileSessionWorker.r(i17);
        synchronized (this) {
            this.f207489b.put(Long.valueOf(i17.nSessionId), onlineFileSessionWorker);
        }
        onlineFileSessionWorker.A();
        if (onlineFileSessionWorker.v()) {
            w(i17.nSessionId);
        } else if (i(str, mVar.f207826f)) {
            QLog.i("OnlineFileSessionCenter<FileAssistant>", i16, "OLfilesession[" + mVar.f207826f + "] had be handled before request come");
            return;
        }
        y();
    }

    public void n(final int i3) {
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession onNeworkChanged set failed");
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter.3
                @Override // java.lang.Runnable
                public void run() {
                    OnlineFileSessionCenter.this.h(i3);
                }
            });
        } else {
            h(i3);
        }
    }

    public void o(String str, long j3, boolean z16) {
        if (str != null && j3 > 0) {
            OnlineFileSessionWorker f16 = f(str, j3);
            if (f16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.onRecvOnLineFileResult");
                return;
            }
            f16.I(z16);
            if (f16.v()) {
                w(f16.f207511b);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] onRecvOnLineFileResult sessionid error.return");
    }

    public void p(String str, long j3) {
        if (str != null && j3 > 0) {
            OnlineFileSessionWorker f16 = f(str, j3);
            if (f16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.onSenderCancelUpload");
                if (!this.f207488a.getFileManagerDataCenter().x(str, j3)) {
                    d(str, j3, new c(10));
                    return;
                }
                return;
            }
            f16.K();
            if (f16.v()) {
                w(f16.f207511b);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] onSenderCancelUpload sessionid error.return");
    }

    public void q(String str, long j3) {
        if (str != null && j3 > 0) {
            OnlineFileSessionWorker f16 = f(str, j3);
            if (f16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.onSenderReplayComeOnRecv");
                return;
            }
            f16.L();
            if (f16.v()) {
                w(f16.f207511b);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] onSenderReplayComeOnRecv sessionid error.return");
    }

    public void r(String str, long j3, int i3, String str2, long j16) {
        if (str != null && j3 > 0) {
            OnlineFileSessionWorker f16 = f(str, j3);
            if (f16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.onSenderUploadCompleted");
                if (!this.f207488a.getFileManagerDataCenter().x(str, j3)) {
                    c cVar = new c(11);
                    cVar.f207506c = i3;
                    cVar.f207507d = str2;
                    cVar.f207508e = j16;
                    d(str, j3, cVar);
                    return;
                }
                return;
            }
            if (!f16.M(i3, str2, j16)) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] upload competed. but onlineworker handle failed!!!!");
            }
            if (f16.v()) {
                w(f16.f207511b);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]onSenderUploadCompleted  sessionid error.return");
    }

    public void s(String str, long j3, int i3, String str2) {
        if (str != null && j3 > 0) {
            OnlineFileSessionWorker f16 = f(str, j3);
            if (f16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.onSenderUploadException");
                if (!this.f207488a.getFileManagerDataCenter().x(str, j3)) {
                    c cVar = new c(12);
                    cVar.f207506c = i3;
                    cVar.f207507d = str2;
                    d(str, j3, cVar);
                    return;
                }
                return;
            }
            f16.N(i3, str2);
            if (f16.v()) {
                w(f16.f207511b);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] onSenderUploadException sessionid error.return");
    }

    public void t(String str, long j3, int i3, int i16) {
        if (str != null && j3 > 0) {
            OnlineFileSessionWorker f16 = f(str, j3);
            if (f16 == null) {
                QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.onSenderUploadProgressNotify");
                return;
            }
            f16.O(i3, i16);
            if (f16.v()) {
                w(f16.f207511b);
                return;
            }
            return;
        }
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] onSenderUploadProgressNotify sessionid error.return");
    }

    public void u(long j3) {
        if (0 == j3) {
            QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] PauseTrans sessionid error.return");
            return;
        }
        OnlineFileSessionWorker g16 = g(j3);
        if (g16 == null) {
            QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.PauseTrans");
            return;
        }
        g16.F();
        if (this.f207488a.getFileManagerDataCenter().w(j3)) {
            QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] had be deleted by user. stop it");
            g16.W();
        }
        if (g16.v()) {
            w(j3);
        }
    }

    public boolean v(long j3) {
        if (0 == j3) {
            QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] recvOnLineFile sessionid error.return");
            return false;
        }
        OnlineFileSessionWorker g16 = g(j3);
        if (g16 == null) {
            QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.recvOnLineFile");
            return false;
        }
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        aVar.f209157b = "recv_file_online";
        FileManagerReporter.addData(this.f207488a.getCurrentAccountUin(), aVar);
        boolean H = g16.H();
        if (g16.v()) {
            w(j3);
        }
        return H;
    }

    void w(long j3) {
        synchronized (this) {
            this.f207489b.remove(Long.valueOf(j3));
        }
        QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. remove the worker");
    }

    public void x(long j3) {
        if (0 == j3) {
            QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "] ResumeTrans sessionid error.return");
            return;
        }
        OnlineFileSessionWorker g16 = g(j3);
        if (g16 == null) {
            QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + j3 + "]. not find worker.ResumeTrans");
            return;
        }
        g16.J();
        if (g16.v()) {
            w(j3);
        }
    }

    void y() {
        if (this.f207493f == null) {
            this.f207493f = new b(Looper.getMainLooper());
        }
        if (this.f207492e == null) {
            UploadProgressMakeEvtPump uploadProgressMakeEvtPump = new UploadProgressMakeEvtPump();
            this.f207492e = uploadProgressMakeEvtPump;
            uploadProgressMakeEvtPump.b();
            QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[] start progress make pump thread!!!");
        }
    }

    public void z() {
        A();
        Iterator<Map.Entry<Long, OnlineFileSessionWorker>> it = this.f207489b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, OnlineFileSessionWorker> next = it.next();
            next.getValue().W();
            long longValue = next.getKey().longValue();
            int size = this.f207489b.size();
            it.remove();
            QLog.i("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + longValue + "]. stop. and remove the worker..[" + size + " - " + this.f207489b.size() + "]");
        }
    }
}
