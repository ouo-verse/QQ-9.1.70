package com.tencent.mobileqq.tofumsg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.activity.aio.q;
import com.tencent.mobileqq.aio.msg.ah;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.oidb.cmd0xf7e.oidb_cmd0xf7e$LastTofu;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.onlinestatus.v;
import com.tencent.mobileqq.onlinestatus.view.aj;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tofumsg.NewTofuManager;
import com.tencent.mobileqq.tofumsg.manager.factory.TofuManagerFactory;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class NewTofuManager implements b, com.tencent.mobileqq.beancurd.a {
    static IPatchRedirector $redirector_;
    private static boolean E;
    private static boolean F;
    private volatile boolean C;
    private AIOParam D;

    /* renamed from: d, reason: collision with root package name */
    private j f293229d;

    /* renamed from: e, reason: collision with root package name */
    private final CopyOnWriteArrayList<NewBeancurdMsg> f293230e;

    /* renamed from: f, reason: collision with root package name */
    private String f293231f;

    /* renamed from: h, reason: collision with root package name */
    private CopyOnWriteArrayList<com.tencent.mobileqq.beancurd.b> f293232h;

    /* renamed from: i, reason: collision with root package name */
    private IOnlineStatusService.AIOStatusPopupDialogListener f293233i;

    /* renamed from: m, reason: collision with root package name */
    private volatile v f293234m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.tofumsg.NewTofuManager$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOParam f293235d;

        AnonymousClass1(AIOParam aIOParam) {
            this.f293235d = aIOParam;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTofuManager.this, (Object) aIOParam);
            }
        }

        private boolean b(String str) {
            if (NewTofuManager.this.D != null && !TextUtils.isEmpty(str)) {
                AIOParam aIOParam = NewTofuManager.this.D;
                AIOParam aIOParam2 = this.f293235d;
                if (aIOParam != aIOParam2) {
                    QLog.i("TOFU::NewTofuManager", 1, "checkAIOExist:: mAioParam != taskAIOParam, return");
                    return false;
                }
                String b16 = su3.c.b(aIOParam2);
                if (TextUtils.equals(b16, str)) {
                    return true;
                }
                QLog.i("TOFU::NewTofuManager", 1, "checkAIOExist:: taskUin:" + StringUtil.getSimpleUinForPrint(b16) + " != curUin:" + StringUtil.getSimpleUinForPrint(str) + ", return");
                return false;
            }
            QLog.i("TOFU::NewTofuManager", 1, "checkAIOExist:: mAioParam | mCurFriendUin is null, return");
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(sr2.a aVar) {
            if (!b(NewTofuManager.this.f293231f)) {
                QLog.i("TOFU::NewTofuManager", 1, "iGetManagerCallback:: reInvoke checkAIOExist, but aio illegal, return");
                NewTofuManager.this.b();
                return;
            }
            QLog.i("TOFU::NewTofuManager", 1, "iGetManagerCallback:: task check finish, taskUin = " + StringUtil.getSimpleUinForPrint(NewTofuManager.this.f293231f) + ", tofuManager:" + aVar);
            if (aVar != null) {
                aVar.e();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!b(NewTofuManager.this.f293231f)) {
                QLog.i("TOFU::NewTofuManager", 1, "invoke checkAIOExist, but aio illegal, return");
                NewTofuManager.this.b();
            } else {
                Iterator<sr2.a> it = TofuManagerFactory.f293297a.j().iterator();
                while (it.hasNext()) {
                    it.next().b();
                }
                TofuManagerFactory.f293297a.m(this.f293235d, new com.tencent.mobileqq.tofumsg.manager.factory.c() { // from class: com.tencent.mobileqq.tofumsg.g
                    @Override // com.tencent.mobileqq.tofumsg.manager.factory.c
                    public final void a(sr2.a aVar) {
                        NewTofuManager.AnonymousClass1.this.c(aVar);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements IOnlineStatusService.AIOStatusPopupDialogListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTofuManager.this);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService.AIOStatusPopupDialogListener
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                QLog.i("TOFU::NewTofuManager", 1, "the online status half panel --- dismiss");
                NewTofuManager.this.J(true);
            }
        }

        @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService.AIOStatusPopupDialogListener
        public void onShow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.i("TOFU::NewTofuManager", 1, "the online status half panel --- show");
                NewTofuManager.this.J(false);
            }
        }
    }

    public NewTofuManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f293232h = new CopyOnWriteArrayList<>();
        this.C = false;
        this.f293230e = new CopyOnWriteArrayList<>();
    }

    private void A() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.f293230e);
        this.f293230e.clear();
        ThreadManagerV2.excute(new Runnable(copyOnWriteArrayList) { // from class: com.tencent.mobileqq.tofumsg.NewTofuManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f293236d;

            {
                this.f293236d = copyOnWriteArrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTofuManager.this, (Object) copyOnWriteArrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int size = this.f293236d.size();
                for (int i3 = 0; i3 < size; i3++) {
                    NewBeancurdMsg newBeancurdMsg = (NewBeancurdMsg) this.f293236d.get(i3);
                    if (newBeancurdMsg != null) {
                        NewBeancurdMsg.ExtraTofuInfo parseToGetPushInfo = NewBeancurdMsg.ExtraTofuInfo.parseToGetPushInfo(newBeancurdMsg.pushInfoString);
                        if (i3 == size - 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (parseToGetPushInfo.checkIsPushTofu()) {
                            NewTofuManager.this.I(newBeancurdMsg, TofuLimitMsgForPush.create(newBeancurdMsg), "push", z16);
                        } else if (!parseToGetPushInfo.checkIsSogouTofu()) {
                            NewTofuManager.this.I(newBeancurdMsg, TofuLimitMsg.create(newBeancurdMsg), "common", z16);
                        } else {
                            QLog.i("TOFU::NewTofuManager", 1, "moveCacheMsgToMsgList:: tofu is sogou channel, next directly\uff1b newBeancurdMsg=" + newBeancurdMsg);
                        }
                    }
                }
            }
        }, 32, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends TofuLimitMsg> void I(NewBeancurdMsg newBeancurdMsg, T t16, String str, boolean z16) {
        sr2.a l3 = TofuManagerFactory.f293297a.l(str);
        if (l3 == null) {
            QLog.i("TOFU::NewTofuManager", 1, "solveCacheForChannel:: channelManager=" + str + " is null, return!!!\uff1bnewBeancurdMsg=" + newBeancurdMsg);
            return;
        }
        if (z16) {
            l3.i(newBeancurdMsg);
        } else {
            l3.c(t16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("TOFU::NewTofuManager", 1, "switchAvatarAnimation:: appRuntime is null, return!!!");
            return;
        }
        Iterator<com.tencent.mobileqq.beancurd.b> it = this.f293232h.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.beancurd.b next = it.next();
            aj ajVar = next.b().get();
            if (ajVar == null) {
                this.f293232h.remove(next);
            } else {
                try {
                    boolean e16 = next.e();
                    QLog.d("TOFU::NewTofuManager", 1, "isAvatarViewLoaded\uff1a" + e16 + "\uff0c start\uff1a" + z16);
                    if (z16) {
                        boolean isAIODialogNotShowing = ((IOnlineStatusService) peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).isAIODialogNotShowing();
                        QLog.d("TOFU::NewTofuManager", 1, "isAIODialogNotShowing\uff1a" + isAIODialogNotShowing);
                        if (!isAIODialogNotShowing) {
                            QLog.d("TOFU::NewTofuManager", 1, "online half panel is showing, do nothing");
                        } else if (!e16) {
                            ajVar.b(next.c(), next.d(), next.a(), new aj.LoadOption(null, true));
                            next.f(true);
                        } else {
                            ajVar.c(true);
                        }
                    } else if (next.e()) {
                        ajVar.stopAnimation();
                    }
                } catch (Exception e17) {
                    QLog.d("TOFU::NewTofuManager", 1, "avatarView startAnimation exception:", e17);
                }
            }
        }
    }

    private void K(String str) {
        if (!g4()) {
            QLog.i("TOFU::NewTofuManager", 1, "trigToGetAvatarStatusInfo:::Inner::: but NewYearTofuSwitch is closed, return");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("TOFU::NewTofuManager", 1, "trigToGetAvatarStatusInfoInner:: appRuntime is null, return!!!");
            return;
        }
        this.f293234m = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getAvatarStatusInfo(peekAppRuntime, str);
        QLog.i("TOFU::NewTofuManager", 1, "trigToGetAvatarStatusInfo:::Inner::: get statusInfo is:" + this.f293234m);
    }

    private void o(String str) {
        if (com.tencent.mobileqq.tofumsg.a.c()) {
            E = true;
        } else {
            E = be.g(str);
        }
    }

    private void p() {
        F = ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("tofu_msg_delete_manage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(boolean z16) {
        QLog.i("TOFU::NewTofuManager", 1, "deleteTofuMsg:: delete oidb_cmd0xf7e.LastTofu list tofu in NT db suc=" + z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(List list, sr2.a aVar, String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            oidb_cmd0xf7e$LastTofu oidb_cmd0xf7e_lasttofu = (oidb_cmd0xf7e$LastTofu) it.next();
            int i3 = (int) oidb_cmd0xf7e_lasttofu.delete_flag.get();
            if (i3 == 2 || i3 == 3) {
                copyOnWriteArrayList.add(oidb_cmd0xf7e_lasttofu.string_busi_uuid.get());
                QLog.i("TOFU::NewTofuManager", 1, "deleteTofuMsg:: add msg to needDeleteMsgList:" + oidb_cmd0xf7e_lasttofu);
            }
        }
        aVar.d(str, copyOnWriteArrayList, new com.tencent.mobileqq.tofumsg.manager.factory.b() { // from class: com.tencent.mobileqq.tofumsg.e
            @Override // com.tencent.mobileqq.tofumsg.manager.factory.b
            public final void onResult(boolean z16) {
                NewTofuManager.w(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(HashMap hashMap, r81.a aVar, int i3, String str, ArrayList arrayList) {
        QLog.i("TOFU::NewTofuManager", 1, "getShowingTofuMsgId:: result:" + i3 + ", errMsg:" + str);
        if (i3 == 0 && arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ah ahVar = new ah((MsgRecord) it.next());
                if (ahVar.m2() != null) {
                    hashMap.put(ahVar.m2(), Long.valueOf(ahVar.n2()));
                }
            }
        }
        QLog.d("TOFU::NewTofuManager", 1, "getShowingTofuMsgId:: invoke callback, showingHashMap:" + hashMap);
        aVar.onResult(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit z(ec2.b bVar, Boolean bool, com.tencent.mobileqq.onlinestatus.model.f fVar) {
        QLog.i("TOFU::NewTofuManager", 1, "[updateFriendAvatarSwitch]: updateFriendSwitch result is " + bool + " remoteSwitch is " + fVar);
        if (bVar != null) {
            bVar.a(bool.booleanValue(), fVar);
            return null;
        }
        return null;
    }

    public void B(AIOParam aIOParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aIOParam);
            return;
        }
        this.D = aIOParam;
        String b16 = su3.c.b(aIOParam);
        QLog.i("TOFU::NewTofuManager", 1, "onAIOCreate\uff0cuin is:" + StringUtil.getSimpleUinForPrint(b16));
        if (TextUtils.isEmpty(b16)) {
            return;
        }
        this.f293231f = b16;
        if (!TextUtils.isEmpty(b16)) {
            this.C = true;
            o(b16);
            K(b16);
            p();
        }
        Iterator<sr2.a> it = TofuManagerFactory.f293297a.j().iterator();
        while (it.hasNext()) {
            it.next().aioCreate(aIOParam);
        }
    }

    public void C(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        if (com.tencent.mobileqq.tofumsg.a.c()) {
            b();
            return;
        }
        QLog.i("TOFU::NewTofuManager", 1, "onAIODelayLoad\uff0cuin is:" + StringUtil.getSimpleUinForPrint(str));
        ThreadManagerV2.excute(new AnonymousClass1(this.D), 16, null, false);
    }

    @Override // com.tencent.mobileqq.tofumsg.b
    public void C3(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        if (!g4()) {
            QLog.i("TOFU::NewTofuManager", 1, "trigToGetAvatarStatusInfo::: but NewYearTofuSwitch is closed, return");
            return;
        }
        if (TextUtils.isEmpty(this.f293231f)) {
            QLog.i("TOFU::NewTofuManager", 1, "trigToGetAvatarStatusInfo::: but curFriendUin is empty, return");
            return;
        }
        if (!TextUtils.equals(this.f293231f, str)) {
            QLog.i("TOFU::NewTofuManager", 1, "trigToGetAvatarStatusInfo::: curSession's curFriendUin is not equal param friendUin, return");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("TOFU::NewTofuManager", 1, "trigToGetAvatarStatusInfo:: appRuntime is null, return!!!");
            return;
        }
        this.f293234m = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getAvatarStatusInfo(peekAppRuntime, this.f293231f);
        QLog.i("TOFU::NewTofuManager", 1, "trigToGetAvatarStatusInfo::: get statusInfo is:" + this.f293234m);
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.i("TOFU::NewTofuManager", 1, "onAIODestroy, uin is:" + StringUtil.getSimpleUinForPrint(this.f293231f));
        this.D = null;
        this.f293231f = "";
        A();
        H();
        Iterator<sr2.a> it = TofuManagerFactory.f293297a.j().iterator();
        while (it.hasNext()) {
            it.next().aioDestroy();
        }
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else if (g4()) {
            J(true);
        }
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else if (g4()) {
            J(false);
        }
    }

    public void G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
            return;
        }
        if (com.tencent.mobileqq.tofumsg.a.c()) {
            b();
            return;
        }
        QLog.i("TOFU::NewTofuManager", 1, "openAIOFromSogouButAIOOpened:: mCurUin:" + StringUtil.getSimpleUinForPrint(this.f293231f) + ", params uin:" + StringUtil.getSimpleUinForPrint(str));
        if (TextUtils.equals(this.f293231f, str)) {
            sr2.a l3 = TofuManagerFactory.f293297a.l("sogou");
            if (l3 == null) {
                QLog.i("TOFU::NewTofuManager", 1, "openAIOFromSogouButAIOOpened:: sogouManager is null, return!!!");
            } else {
                l3.e();
            }
        }
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (g4()) {
            Iterator<com.tencent.mobileqq.beancurd.b> it = this.f293232h.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.beancurd.b next = it.next();
                aj ajVar = next.b().get();
                if (ajVar == null) {
                    this.f293232h.remove(next);
                } else {
                    ajVar.release();
                }
            }
            QLog.d("TOFU::NewTofuManager", 1, "avatarStatusViewWrapperList.size:" + this.f293232h.size());
            this.f293232h.clear();
            this.f293234m = new v(-1, "", -1);
        }
    }

    @Override // com.tencent.mobileqq.tofumsg.b
    public void S1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(this.f293231f)) {
            E = false;
            QLog.d("TOFU::NewTofuManager", 1, "curFriendUin is null, enableNewYearTofu set to false, return");
        } else {
            if (TextUtils.equals(this.f293231f, str)) {
                if (com.tencent.mobileqq.tofumsg.a.c()) {
                    E = true;
                    return;
                } else {
                    E = be.g(str);
                    return;
                }
            }
            QLog.d("TOFU::NewTofuManager", 1, "curSession's curFriendUin is not equal param friendUin, do not update enableNewYearTofu");
        }
    }

    @Override // com.tencent.mobileqq.tofumsg.b
    public boolean W1(TofuLimitMsg tofuLimitMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) tofuLimitMsg)).booleanValue();
        }
        n();
        if ((NetConnInfoCenter.getServerTime() * 1000) - tofuLimitMsg.insertMsgTime < this.f293229d.f293262h) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.beancurd.a
    public void a(String str, final r81.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("TOFU::NewTofuManager", 1, "getShowingTofuMsgId:: uin is empty, return");
            aVar.onResult(new HashMap<>());
        }
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin)) {
            QLog.i("TOFU::NewTofuManager", 1, "getShowingTofuMsgId:: uidFromUin is empty, return");
            aVar.onResult(new HashMap<>());
        }
        final HashMap hashMap = new HashMap();
        TofuManagerFactory.f293297a.n(1, uidFromUin, 3, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.tofumsg.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str2, ArrayList arrayList) {
                NewTofuManager.y(hashMap, aVar, i3, str2, arrayList);
            }
        });
    }

    @Override // com.tencent.mobileqq.beancurd.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            m.d();
        }
    }

    @Override // com.tencent.mobileqq.beancurd.a
    public void c(final List<oidb_cmd0xf7e$LastTofu> list, final String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, list, str, str2);
            return;
        }
        QLog.i("TOFU::NewTofuManager", 1, "deleteTofuMsg:: mEnableTofuMsgDelete:" + F);
        if (!F) {
            return;
        }
        if (list != null && !list.isEmpty()) {
            if (TextUtils.isEmpty(str2)) {
                QLog.i("TOFU::NewTofuManager", 1, "deleteTofuMsg:: channel is empty, return!!!");
                return;
            }
            final sr2.a l3 = TofuManagerFactory.f293297a.l(str2);
            if (l3 == null) {
                QLog.i("TOFU::NewTofuManager", 1, "deleteTofuMsg:: manager is null, return!!!");
                return;
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.tofumsg.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewTofuManager.x(list, l3, str);
                    }
                }, 32, null, false);
                return;
            }
        }
        QLog.i("TOFU::NewTofuManager", 1, "deleteTofuMsg:: tofuList is empty, return!!!");
    }

    @Override // com.tencent.mobileqq.beancurd.a
    public void d(NewBeancurdMsg newBeancurdMsg, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) newBeancurdMsg, (Object) str);
            return;
        }
        if (com.tencent.mobileqq.tofumsg.a.c()) {
            b();
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i("TOFU::NewTofuManager", 1, "channel is empty, return!!!" + newBeancurdMsg);
            return;
        }
        sr2.a l3 = TofuManagerFactory.f293297a.l(str);
        if (l3 == null) {
            QLog.i("TOFU::NewTofuManager", 1, "manager is null, return!!!" + newBeancurdMsg);
            return;
        }
        synchronized (q.class) {
            l3.f(newBeancurdMsg);
        }
    }

    @Override // com.tencent.mobileqq.tofumsg.b
    public boolean e3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return F;
    }

    @Override // com.tencent.mobileqq.tofumsg.b
    public boolean g4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return E;
    }

    @Override // com.tencent.mobileqq.tofumsg.b
    public void h2(final ec2.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) bVar);
            return;
        }
        if (!this.C) {
            if (bVar != null) {
                bVar.a(false, null);
                return;
            }
            return;
        }
        this.C = false;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && !TextUtils.isEmpty(this.f293231f)) {
            ((IOnlineStatusAvatarSwitchService) peekAppRuntime.getRuntimeService(IOnlineStatusAvatarSwitchService.class, "")).updateFriendSwitchStatus(this.f293231f, new Function2() { // from class: com.tencent.mobileqq.tofumsg.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit z16;
                    z16 = NewTofuManager.z(ec2.b.this, (Boolean) obj, (com.tencent.mobileqq.onlinestatus.model.f) obj2);
                    return z16;
                }
            });
            return;
        }
        QLog.e("TOFU::NewTofuManager", 1, "[updateFriendAvatarSwitch]: data invalid");
        if (bVar != null) {
            bVar.a(false, null);
        }
    }

    public void m(@NonNull NewBeancurdMsg newBeancurdMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) newBeancurdMsg);
        } else {
            this.f293230e.add(newBeancurdMsg);
        }
    }

    public synchronized void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (this.f293229d == null) {
                this.f293229d = (j) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101424");
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        n();
        return this.f293229d.f293260e;
    }

    public v r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (v) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.f293234m;
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        n();
        return this.f293229d.f293259d;
    }

    @Override // com.tencent.mobileqq.tofumsg.b
    public void saveAvatarStatusView(AppRuntime appRuntime, com.tencent.mobileqq.beancurd.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) appRuntime, (Object) bVar);
            return;
        }
        this.f293232h.add(bVar);
        if (this.f293233i == null) {
            this.f293233i = new a();
            ((IOnlineStatusService) appRuntime.getRuntimeService(IOnlineStatusService.class, "")).setAIOStatusPopupDialogListener(this.f293233i);
        }
    }

    public CopyOnWriteArrayList<NewBeancurdMsg> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.f293230e;
    }

    public j u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (j) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        n();
        return this.f293229d;
    }

    public boolean v(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, j3)).booleanValue();
        }
        n();
        if ((NetConnInfoCenter.getServerTime() - j3) * 1000 < this.f293229d.f293261f) {
            return true;
        }
        return false;
    }
}
