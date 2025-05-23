package com.tencent.gamecenter.wadl.api.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.api.IQQGameDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.api.IQQResDownloadService;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.biz.entity.GameNoticeInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.util.i;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import jl0.b;
import jl0.c;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g extends c.a implements ServiceConnection, IBinder.DeathRecipient, Handler.Callback {
    private static final byte[] K = new byte[0];
    private static final byte[] L = new byte[0];
    private static g M;
    private Handler C;
    private WadlProxyServiceMonitor D;

    /* renamed from: d, reason: collision with root package name */
    private int f106662d;

    /* renamed from: i, reason: collision with root package name */
    private jl0.b f106666i;

    /* renamed from: e, reason: collision with root package name */
    private boolean f106663e = false;

    /* renamed from: f, reason: collision with root package name */
    private final int f106664f = 100;

    /* renamed from: h, reason: collision with root package name */
    private final int f106665h = 5000;
    private volatile AtomicBoolean E = new AtomicBoolean(false);
    private volatile AtomicBoolean F = new AtomicBoolean(false);
    private int G = 0;
    private long J = 0;

    /* renamed from: m, reason: collision with root package name */
    private List<WadlRequest> f106667m = new ArrayList();
    private HashSet<String> H = new HashSet<>();
    private HashSet<String> I = new HashSet<>();

    g() {
        this.H.add(WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION);
        this.H.add(WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION);
        this.H.add(WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION);
        this.H.add(WadlProxyConsts.REMOTE_CMD_APP_DELETE_ACTION);
        this.H.add(WadlProxyConsts.REMOTE_CMD_APP_INSTALL_ACTION);
        this.H.add(WadlProxyConsts.REMOTE_CMD_APP_QUERY_VIA_ACTION);
        this.H.add(WadlProxyConsts.REMOTE_CMD_APP_DELETE_ALL_ACTION);
        this.H.add(WadlProxyConsts.REMOTE_CMD_APP_QUERY_ID_ACTION);
        this.H.add(WadlProxyConsts.REMOTE_CMD_SET_SPEED_BUFFER);
        this.H.add(WadlProxyConsts.REMOTE_CMD_SYNC_TASK_DATA);
        this.I.add(WadlProxyConsts.REMOTE_CMD_APP_DELETE_ALL_ACTION);
        this.I.add(WadlProxyConsts.REMOTE_CMD_SYNC_TASK_DATA);
        this.C = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        if (MobileQQ.sProcessId == 1) {
            this.D = new WadlProxyServiceMonitor(this);
        }
        GameCenterReceiver.registerReceiver();
    }

    private void B1(Bundle bundle) {
        IQQGameNoticeService iQQGameNoticeService;
        GameNoticeInfo gameNoticeInfo = (GameNoticeInfo) bundle.getParcelable(WadlProxyConsts.PARAM_NOTICE_INFO);
        QLog.i("Wadl_WadlProxyServiceManager", 1, "onNoticeAdd " + gameNoticeInfo);
        if (MobileQQ.sProcessId == 1 && (iQQGameNoticeService = (IQQGameNoticeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameNoticeService.class, "")) != null) {
            iQQGameNoticeService.onNoticeAdd(gameNoticeInfo);
        }
    }

    private void N1(Bundle bundle) {
        IQQGameNoticeService iQQGameNoticeService;
        String string = bundle.getString("appId");
        QLog.i("Wadl_WadlProxyServiceManager", 1, "onNoticeDelete appId=" + string);
        if (MobileQQ.sProcessId == 1 && (iQQGameNoticeService = (IQQGameNoticeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameNoticeService.class, "")) != null) {
            iQQGameNoticeService.onNoticeDelete(string);
        }
    }

    private boolean Q0(String str) {
        if (this.I.contains(str)) {
            Iterator<WadlRequest> it = this.f106667m.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().f106594e)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private void S1(Bundle bundle) {
        ArrayList<WadlResult> parcelableArrayList = bundle.getParcelableArrayList("query_result");
        int i3 = bundle.getInt("businessId");
        boolean z16 = bundle.getBoolean(WadlProxyConsts.PARAM_IS_PRELOAD);
        QLog.i("Wadl_WadlProxyServiceManager", 1, "onQueryAllTaskCallback params=" + bundle);
        if (parcelableArrayList == null) {
            parcelableArrayList = new ArrayList<>();
        }
        if (z16 && !parcelableArrayList.isEmpty()) {
            QLog.i("Wadl_WadlProxyServiceManager", 1, "onQueryAllTaskCallback hit GameServicePreload");
            com.tencent.mobileqq.perf.process.foregroud.b.f257916a.i(WadlProxyConsts.WADL_PROCESS_PRELOAD_ENTRY);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    QLog.w("Wadl_WadlProxyServiceManager", 2, "onQueryAllTaskCallback businessId invalid! businessId=" + i3);
                    return;
                }
                ((IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI)).onQueryCallback(parcelableArrayList);
                return;
            }
            ((IQQResDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQResDownloadService.class, ProcessConstant.MULTI)).onQueryCallback(parcelableArrayList);
            return;
        }
        ((IQQGameDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI)).onQueryCallback(parcelableArrayList);
    }

    private void U1(Bundle bundle) {
        ArrayList<WadlResult> parcelableArrayList = bundle.getParcelableArrayList("query_result");
        QLog.i("Wadl_WadlProxyServiceManager", 1, "onQueryCallbackByAppid params:" + bundle.toString());
        ((IQQGameDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI)).onQueryCallback(parcelableArrayList);
    }

    private void W1(Bundle bundle) {
        ArrayList<WadlResult> parcelableArrayList = bundle.getParcelableArrayList("query_result");
        QLog.i("Wadl_WadlProxyServiceManager", 1, "onQueryCallbackByVia params:" + bundle.toString());
        ((IQQGameDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI)).onQueryCallbackByVia(parcelableArrayList);
    }

    public static g Z() {
        if (M == null) {
            synchronized (K) {
                if (M == null) {
                    M = new g();
                }
            }
        }
        return M;
    }

    private void Z2() {
        if (!h1() && !this.f106667m.isEmpty()) {
            int i3 = this.f106662d;
            if (i3 < 2) {
                this.f106662d = i3 + 1;
                QLog.i("Wadl_WadlProxyServiceManager", 1, "retryStartService...serviceStartCount=" + this.f106662d);
                g4(3);
                return;
            }
            new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setPageId(WadlProxyConsts.PAGE_ID_DOWNLOAD).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setModuleType(WadlProxyConsts.BUSINESS_ID_DOWNLOAD).setBussinessId("1").setOperId(WadlProxyConsts.OPER_ID_SERVICE_START_FAIL).setOperType("555").setExt(48, "service start fail").report();
            synchronized (this.f106667m) {
                Iterator<WadlRequest> it = this.f106667m.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION.equals(it.next().f106594e)) {
                        QLog.i("Wadl_WadlProxyServiceManager", 1, "retryStartService: has download cmd when start failed");
                        this.f106663e = true;
                        break;
                    }
                }
                this.f106667m.clear();
            }
            this.f106662d = 0;
            QLog.w("Wadl_WadlProxyServiceManager", 1, "retryStartService...clear cache msg");
        }
    }

    private void j2(Bundle bundle) {
        WadlResult wadlResult = (WadlResult) bundle.getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_RESULT);
        if (QLog.isColorLevel()) {
            QLog.i("Wadl_WadlProxyServiceManager", 2, "onWadlTaskStatusChanged " + wadlResult);
        }
        if (wadlResult != null) {
            int i3 = wadlResult.businessId;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        QLog.w("Wadl_WadlProxyServiceManager", 2, "downloadActionCallback businessId invalid! wadlResult=" + wadlResult);
                        return;
                    }
                    ((IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI)).onWadlTaskStatusChanged(wadlResult);
                    return;
                }
                ((IQQResDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQResDownloadService.class, ProcessConstant.MULTI)).onWadlTaskStatusChanged(wadlResult);
                return;
            }
            ((IQQGameDownloadService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDownloadService.class, ProcessConstant.MULTI)).onWadlTaskStatusChanged(wadlResult);
        }
    }

    private boolean p4(WadlRequest... wadlRequestArr) {
        boolean z16;
        if (wadlRequestArr == null || wadlRequestArr.length < 1) {
            return false;
        }
        synchronized (this.f106667m) {
            z16 = false;
            for (WadlRequest wadlRequest : wadlRequestArr) {
                if (!TextUtils.isEmpty(wadlRequest.f106594e) && !Q0(wadlRequest.f106594e)) {
                    if (b1(wadlRequest)) {
                        QLog.i("Wadl_WadlProxyServiceManager", 1, "storeCmdToCache cmd=" + wadlRequest.f106594e + " isHitPreload");
                        com.tencent.mobileqq.perf.process.foregroud.b.f257916a.i(WadlProxyConsts.WADL_PROCESS_PRELOAD_ENTRY);
                    }
                    if (this.f106667m.size() > 100) {
                        QLog.w("Wadl_WadlProxyServiceManager", 1, "storeCmdToCache there must be an error too many unproceed message!");
                        this.f106667m.clear();
                    }
                    this.f106667m.add(wadlRequest);
                    z16 = true;
                }
            }
        }
        return z16;
    }

    private void s1(WadlRequest wadlRequest) {
        if (!WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION.equals(wadlRequest.f106594e)) {
            return;
        }
        WadlParams wadlParams = (WadlParams) wadlRequest.f106596h.getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
        QLog.i("Wadl_WadlProxyServiceManager", 1, "onAfterSendRequest wadlParams=" + wadlParams);
        Bundle bundle = new Bundle();
        bundle.putParcelable(GameCenterReceiver.KEY_WADL_PARAMS, wadlParams);
        i.m(10, bundle);
    }

    private void x() {
        if (!this.C.hasMessages(2)) {
            this.C.obtainMessage(2).sendToTarget();
        }
    }

    private void z1(Bundle bundle) {
        IQQGameNoticeService iQQGameNoticeService;
        WadlResult wadlResult = (WadlResult) bundle.getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_RESULT);
        QLog.i("Wadl_WadlProxyServiceManager", 1, "onInstallStart wadlResult=" + wadlResult);
        if (MobileQQ.sProcessId == 1 && (iQQGameNoticeService = (IQQGameNoticeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameNoticeService.class, "")) != null) {
            iQQGameNoticeService.onInstallStart(wadlResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C3() {
        if (QLog.isColorLevel()) {
            QLog.i("Wadl_WadlProxyServiceManager", 1, "resetDiedCount");
        }
        this.G = 0;
        WadlProxyServiceMonitor wadlProxyServiceMonitor = this.D;
        if (wadlProxyServiceMonitor != null) {
            wadlProxyServiceMonitor.q(1.0f, false);
        }
    }

    public void E3() {
        boolean z16 = true;
        QLog.i("Wadl_WadlProxyServiceManager", 1, "sendAsynRemoteCommandMessage mWadlService=" + this.f106666i + ",mServiceConnecting=" + this.F + ",mCacheMsg size=" + this.f106667m.size());
        if (h1() && !this.f106667m.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            synchronized (this.f106667m) {
                while (true) {
                    if (!this.f106667m.isEmpty()) {
                        WadlRequest remove = this.f106667m.remove(0);
                        if (remove != null) {
                            QLog.i("Wadl_WadlProxyServiceManager", 1, "sendAsynRemoteCommandMessage cmd=" + remove.f106594e + ",mWadlService=" + this.f106666i);
                            try {
                                if (remove.f106596h == null) {
                                    remove.f106596h = new Bundle();
                                }
                                remove.f106596h.setClassLoader(getClass().getClassLoader());
                                synchronized (L) {
                                    jl0.b bVar = this.f106666i;
                                    if (bVar != null) {
                                        bVar.e2(remove);
                                        s1(remove);
                                    }
                                }
                            } catch (Exception e16) {
                                if (e16 instanceof DeadObjectException) {
                                    arrayList.add(remove);
                                    QLog.i("Wadl_WadlProxyServiceManager", 1, "remote service is dead", e16);
                                    break;
                                }
                            } catch (OutOfMemoryError e17) {
                                QLog.e("Wadl_WadlProxyServiceManager", 1, "sendAsynRemoteCommandMessage fail, oom", e17);
                            }
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
            }
            if (z16) {
                int size = arrayList.size();
                if (size > 0) {
                    p4((WadlRequest[]) arrayList.toArray(new WadlRequest[size]));
                }
                synchronized (L) {
                    this.f106666i = null;
                }
            }
        }
    }

    @Override // jl0.c
    public void a(String str, Bundle bundle) throws RemoteException {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        if (WadlProxyConsts.REVERSE_ACTION_CMD.equals(str)) {
            Message obtainMessage = this.C.obtainMessage();
            obtainMessage.what = 3;
            if (bundle != null) {
                obtainMessage.setData(bundle);
            }
            this.C.sendMessage(obtainMessage);
            QLog.i("Wadl_WadlProxyServiceManager", 1, "transferAsync from Service cmd=" + str);
            return;
        }
        if (this.D != null) {
            if (WadlProxyConsts.REVERSE_HEART_CMD.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i("Wadl_WadlProxyServiceManager", 1, "transferAsync from Service cmd=" + str + ",processName=" + MobileQQ.processName);
                }
                Message obtainMessage2 = this.C.obtainMessage();
                obtainMessage2.what = 4;
                this.C.sendMessage(obtainMessage2);
                return;
            }
            if (WadlProxyConsts.REVERSE_STOP_MONITOR_CMD.equals(str)) {
                QLog.i("Wadl_WadlProxyServiceManager", 1, "transferAsync from Service cmd=" + str + ",processName=" + MobileQQ.processName);
                Message obtainMessage3 = this.C.obtainMessage();
                obtainMessage3.what = 5;
                this.C.sendMessage(obtainMessage3);
                return;
            }
            if (WadlProxyConsts.REVERSE_START_MONITOR_CMD.equals(str)) {
                QLog.i("Wadl_WadlProxyServiceManager", 1, "transferAsync from Service cmd=" + str + ",processName=" + MobileQQ.processName);
                if (!this.C.hasMessages(6)) {
                    this.C.obtainMessage(6).sendToTarget();
                }
            }
        }
    }

    protected boolean b1(WadlRequest wadlRequest) {
        if (this.H.contains(wadlRequest.f106594e)) {
            return true;
        }
        if (WadlProxyConsts.REMOTE_CMD_QUERY_TASK.equals(wadlRequest.f106594e)) {
            Bundle bundle = wadlRequest.f106596h;
            if (bundle == null || !bundle.getBoolean(WadlProxyConsts.PARAM_IS_PRELOAD)) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        if (this.D != null) {
            this.G++;
            QLog.e("Wadl_WadlProxyServiceManager", 1, "binderDied, diedCount=" + this.G);
            int i3 = this.G;
            if (i3 > 9) {
                this.D.s();
            } else if (i3 > 6) {
                this.D.q(2.0f, true);
            } else if (i3 > 3) {
                this.D.q(1.5f, true);
            } else {
                this.D.q(1.0f, true);
            }
            if (this.D.o()) {
                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_ATTA_05076).setOperId(WadlProxyConsts.OPER_ID_PROCESS_MONITOR).setOperType("444").setExt(48, "service dlied").report();
            }
        }
        try {
            synchronized (L) {
                jl0.b bVar = this.f106666i;
                if (bVar != null) {
                    bVar.asBinder().unlinkToDeath(this, 0);
                    this.f106666i = null;
                }
            }
            this.F.set(false);
        } catch (Exception e16) {
            QLog.e("Wadl_WadlProxyServiceManager", 1, "binderDied exception", e16);
        }
    }

    public void destroy() {
        QLog.i("Wadl_WadlProxyServiceManager", 1, "destroy isDestroy=" + this.E.get() + ",processName=" + MobileQQ.processName);
        if (this.E.getAndSet(true)) {
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            GameCenterReceiver.unRegisterReceiver();
        }
        WadlProxyServiceMonitor wadlProxyServiceMonitor = this.D;
        if (wadlProxyServiceMonitor != null) {
            wadlProxyServiceMonitor.s();
        }
        this.C.removeCallbacksAndMessages(null);
        try {
            synchronized (this.f106667m) {
                this.f106667m.clear();
            }
            QLog.i("Wadl_WadlProxyServiceManager", 1, "destroy clear cache");
        } catch (Exception e16) {
            QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy clear cache exception", e16);
        }
        synchronized (L) {
            jl0.b bVar = this.f106666i;
            if (bVar != null) {
                try {
                    bVar.asBinder().unlinkToDeath(this, 0);
                    QLog.i("Wadl_WadlProxyServiceManager", 1, "destroy unlinkToDeath success");
                } catch (Exception e17) {
                    QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy unlinkToDeath exception", e17);
                }
                WadlProxyService.j(this);
                try {
                    this.f106666i.L(this);
                    QLog.i("Wadl_WadlProxyServiceManager", 1, "destroy unregisterCallback success");
                } catch (RemoteException e18) {
                    QLog.e("Wadl_WadlProxyServiceManager", 1, "destroy unregisterCallback exception", e18);
                }
            }
        }
        synchronized (K) {
            M = null;
        }
    }

    public void e3(WadlRequest wadlRequest) {
        if (wadlRequest != null && !TextUtils.isEmpty(wadlRequest.f106594e)) {
            if (!h1()) {
                g4(0);
            }
            if (p4(wadlRequest)) {
                QLog.i("Wadl_WadlProxyServiceManager", 1, "postRemoteNotify wadlRequest=" + wadlRequest);
                x();
                return;
            }
            return;
        }
        QLog.w("Wadl_WadlProxyServiceManager", 1, "postRemoteNotify params invalid, wadlRequest=" + wadlRequest);
    }

    public void g4(int i3) {
        QLog.i("Wadl_WadlProxyServiceManager", 1, "startWadlService from=" + i3);
        if (!this.C.hasMessages(1)) {
            Message obtainMessage = this.C.obtainMessage(1);
            obtainMessage.arg1 = i3;
            obtainMessage.sendToTarget();
        }
    }

    public boolean h1() {
        if (this.f106666i != null && !this.F.get()) {
            return true;
        }
        return false;
    }

    public void h2(Bundle bundle) {
        String string = bundle.getString(WadlProxyConsts.REVERSE_ACTION_CMD_NAME);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (WadlProxyConsts.REMOTE_REVERSE_START_SERVICE.equals(string)) {
            g4(0);
            return;
        }
        if (WadlProxyConsts.REMOTE_REVERSE_STATE_CHANGED.equals(string)) {
            j2(bundle);
            return;
        }
        if (WadlProxyConsts.REMOTE_REVERSE_ONQUERY_ALL_TASK.equals(string)) {
            S1(bundle);
            return;
        }
        if (WadlProxyConsts.REMOTE_REVERSE_ONQUERY_RESULT.equals(string)) {
            U1(bundle);
            return;
        }
        if (WadlProxyConsts.REMOTE_REVERSE_ONQUERY_VIA_RESULT.equals(string)) {
            W1(bundle);
            return;
        }
        if (WadlProxyConsts.REMOTE_REVERSE_ON_NOTICE_ADD.equals(string)) {
            B1(bundle);
            return;
        }
        if (WadlProxyConsts.REMOTE_REVERSE_ON_NOTICE_DELETE.equals(string)) {
            N1(bundle);
        } else if (WadlProxyConsts.REMOTE_REVERSE_ON_INSTALL_START.equals(string)) {
            z1(bundle);
        } else {
            QLog.w("Wadl_WadlProxyServiceManager", 1, "onRemoteReverseInvoke unknow invokeCmd");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
    
        return false;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                u0(message.arg1);
                break;
            case 2:
                E3();
                break;
            case 3:
                h2(message.getData());
                break;
            case 4:
                WadlProxyServiceMonitor wadlProxyServiceMonitor = this.D;
                if (wadlProxyServiceMonitor != null) {
                    wadlProxyServiceMonitor.p();
                    break;
                }
                break;
            case 5:
                WadlProxyServiceMonitor wadlProxyServiceMonitor2 = this.D;
                if (wadlProxyServiceMonitor2 != null) {
                    wadlProxyServiceMonitor2.s();
                    break;
                }
                break;
            case 6:
                if (this.D != null) {
                    if (this.E.get()) {
                        this.D.s();
                        break;
                    } else {
                        this.D.r();
                        break;
                    }
                }
                break;
            case 7:
                this.F.set(false);
                QLog.i("Wadl_WadlProxyServiceManager", 1, "reset mServiceConnecting");
                Z2();
                break;
        }
    }

    public boolean o0() {
        return this.f106663e;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        QLog.i("Wadl_WadlProxyServiceManager", 1, "onServiceConnected success, componentName=" + componentName + ",processName=" + MobileQQ.processName + ",service=" + iBinder);
        this.f106662d = 0;
        this.f106663e = false;
        try {
            this.F.set(false);
            if (this.E.get()) {
                QLog.w("Wadl_WadlProxyServiceManager", 1, "onServiceConnected,but this is destroy");
                return;
            }
            if (iBinder != null) {
                this.f106666i = b.a.j(iBinder);
            }
            synchronized (L) {
                jl0.b bVar = this.f106666i;
                if (bVar == null) {
                    QLog.w("Wadl_WadlProxyServiceManager", 1, "onServiceConnected,but asInterface fail");
                    return;
                }
                bVar.s3(this);
                this.f106666i.asBinder().linkToDeath(this, 0);
                x();
                if (MobileQQ.sProcessId != 1) {
                    i.m(11, null);
                }
            }
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        QLog.i("Wadl_WadlProxyServiceManager", 1, "onServiceDisconnected processName=" + MobileQQ.processName);
        synchronized (L) {
            this.f106666i = null;
        }
        this.F.set(false);
        this.f106662d = 0;
    }

    public void q3() {
        if (h1()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.J > 30000) {
            this.J = currentTimeMillis;
            g4(4);
        }
    }

    protected void u0(int i3) {
        if (this.f106666i != null) {
            QLog.w("Wadl_WadlProxyServiceManager", 1, "innerStartService mWadlService is working");
            x();
            return;
        }
        if (!this.F.getAndSet(true)) {
            try {
                QLog.i("Wadl_WadlProxyServiceManager", 1, "innerStartService bindWadlService from=" + i3 + ",processName=" + MobileQQ.processName);
                WadlProxyService.b(this);
                if (i3 == 1) {
                    new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_ATTA_05076).setOperId(WadlProxyConsts.OPER_ID_PROCESS_MONITOR).setOperType("999").setExt(48, "service dlied").report();
                }
            } catch (Throwable th5) {
                QLog.e("Wadl_WadlProxyServiceManager", 1, "innerStartService fail", th5);
                this.F.set(false);
            }
            if (this.F.get()) {
                this.C.removeMessages(7);
                this.C.sendEmptyMessageDelayed(7, 5000L);
                return;
            }
            return;
        }
        QLog.i("Wadl_WadlProxyServiceManager", 1, "innerStartService is connecting mWadlService:" + this.f106666i);
    }
}
