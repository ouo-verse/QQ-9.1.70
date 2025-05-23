package com.tencent.mobileqq.troop.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qqexpand.utils.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.homework.logic.ModifyHWTroopIdentityHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.es;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqnt.bean.JoinTroopParam;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends QQProgressDialog implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;
    private Context R;
    private TroopManager S;
    private com.tencent.mobileqq.troop.api.handler.h T;
    private com.tencent.mobileqq.troop.api.observer.b U;
    private c V;
    private BroadcastReceiver W;
    private TroopInfoData X;
    private String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private volatile boolean f293731a0;

    /* renamed from: b0, reason: collision with root package name */
    private ModifyHWTroopIdentityHelper f293732b0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                f.this.u0(str);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if ("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION".equals(intent.getAction())) {
                switch (intent.getIntExtra("ret_action", 1000)) {
                    case 1000:
                        f fVar = f.this;
                        fVar.w0(fVar.X.troopUin, 0);
                        return;
                    case 1001:
                        f fVar2 = f.this;
                        fVar2.w0(fVar2.X.troopUin, 2);
                        return;
                    case 1002:
                        f fVar3 = f.this;
                        fVar3.w0(fVar3.X.troopUin, 2);
                        return;
                    case 1003:
                        f fVar4 = f.this;
                        fVar4.w0(fVar4.X.troopUin, 1);
                        return;
                    case 1004:
                        f fVar5 = f.this;
                        fVar5.w0(fVar5.X.troopUin, 3);
                        return;
                    default:
                        f fVar6 = f.this;
                        fVar6.w0(fVar6.X.troopUin, 2);
                        return;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void a(String str, @IntRange(from = 1, to = 4) int i3);
    }

    f(@NonNull Context context, @NonNull com.tencent.mobileqq.troop.g gVar, c cVar) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, gVar, cVar);
            return;
        }
        this.f293731a0 = false;
        TroopInfoData troopInfoData = new TroopInfoData();
        this.X = troopInfoData;
        d0(context, troopInfoData, gVar, cVar);
    }

    private void A0(boolean z16) {
        this.f293731a0 = z16;
    }

    private void B0() {
        if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "unRegisterObserver");
        }
        try {
            TroopUtils.f().removeObserver(this.U);
            Z();
            this.R.unregisterReceiver(this.W);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        } catch (Exception e16) {
            QLog.e("AddTroopUtil", 2, "unRegisterObserver error", e16);
        }
    }

    private void Z() {
        ModifyHWTroopIdentityHelper modifyHWTroopIdentityHelper = this.f293732b0;
        if (modifyHWTroopIdentityHelper != null) {
            modifyHWTroopIdentityHelper.g();
            this.f293732b0 = null;
        }
    }

    private int a0() {
        if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "doJoinTroop");
        }
        if (!NetworkUtil.isNetSupport(this.R)) {
            q0(R.string.f171137ci2, 1);
            return 2;
        }
        if (this.X.f294880pa == 34 && ((IExpandQuestionUtils) QRoute.api(IExpandQuestionUtils.class)).needAnswerQuestion(TroopUtils.f().getCurrentAccountUin())) {
            q.b(this.R).show();
            return 1;
        }
        if (this.X.cGroupOption != 1 && TextUtils.isEmpty(this.Y)) {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopInfoForJoinTroop(this.X.troopUin, "AddTroopUtil", null, true, new Function2() { // from class: com.tencent.mobileqq.troop.activity.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit l06;
                    l06 = f.this.l0((Boolean) obj, (TroopInfo) obj2);
                    return l06;
                }
            });
            return 0;
        }
        QLog.i("AddTroopUtil", 1, "[doJoinTroop] cGroupOption:" + ((int) this.X.cGroupOption) + ", mAuthKey:" + TextUtils.isEmpty(this.Y) + ", isHomework:" + this.X.isHomeworkTroop());
        if (this.X.isHomeworkTroop()) {
            f0();
            return 1;
        }
        e0();
        return 0;
    }

    private void c0() {
        Intent aliasIntent;
        if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "go2AIO");
        }
        if (this.X.f294880pa == 30) {
            aliasIntent = new Intent(this.R, (Class<?>) ChatActivity.class);
        } else {
            aliasIntent = SplashActivity.getAliasIntent(this.R);
        }
        Intent m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
        m3.putExtra("uin", this.X.troopUin);
        m3.putExtra("uintype", 1);
        m3.putExtra("uinname", this.X.newTroopName);
        m3.putExtra("key_from", es.f307750a.a(this.X.nStatOption));
        this.R.startActivity(m3);
    }

    private void d0(@NonNull Context context, @NonNull TroopInfoData troopInfoData, @NonNull com.tencent.mobileqq.troop.g gVar, c cVar) {
        QLog.d("AddTroopUtil", 2, "init");
        this.R = context;
        this.V = cVar;
        this.S = (TroopManager) TroopUtils.f().getManager(QQManagerFactory.TROOP_MANAGER);
        this.T = (com.tencent.mobileqq.troop.api.handler.h) TroopUtils.f().getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
        troopInfoData.troopUin = gVar.f296167a + "";
        troopInfoData.f294880pa = gVar.f296169c;
        troopInfoData.troopName = gVar.f296168b + "";
        if (TextUtils.isEmpty(troopInfoData.newTroopName)) {
            troopInfoData.newTroopName = troopInfoData.troopName;
        }
        this.Y = gVar.f296170d + "";
        this.Z = gVar.f296171e + "";
        this.U = new a();
        this.W = new b();
        z0();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void e0() {
        final String str = this.X.troopUin;
        QLog.i("AddTroopUtil", 1, "[joinGroup] troopUin:" + str);
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).joinGroup(new JoinTroopParam(str, this.X.getStatOption(), this.Y, this.Z), null, "AddTroopUtil", new com.tencent.qqnt.troop.d() { // from class: com.tencent.mobileqq.troop.activity.b
            @Override // com.tencent.qqnt.troop.d
            public final void a(boolean z16, int i3, String str2, com.tencent.qqnt.bean.c cVar) {
                f.this.m0(str, z16, i3, str2, cVar);
            }
        });
    }

    private void f0() {
        QLog.i("AddTroopUtil", 1, "[joinHomeworkGroup] troopUin:" + this.X.troopUin);
        if (!TextUtils.isEmpty(this.X.troopUin)) {
            setCancelable(true);
            ModifyHWTroopIdentityHelper modifyHWTroopIdentityHelper = new ModifyHWTroopIdentityHelper(this.R, this.X.troopUin, "AddTroopUtil", null, new Runnable() { // from class: com.tencent.mobileqq.troop.activity.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.n0();
                }
            }, new Function1() { // from class: com.tencent.mobileqq.troop.activity.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o06;
                    o06 = f.this.o0((String) obj);
                    return o06;
                }
            });
            this.f293732b0 = modifyHWTroopIdentityHelper;
            modifyHWTroopIdentityHelper.k(IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE, false);
            return;
        }
        w0(this.X.troopUin, 2);
    }

    private void g0() {
        QLog.i("AddTroopUtil", 1, "[joinPayGroup]");
        com.tencent.mobileqq.troop.troopnotification.utils.h.d(this.R, this.X.troopUin, "");
    }

    public static void i0(Context context, com.tencent.mobileqq.troop.g gVar, c cVar) {
        QLog.d("AddTroopUtil", 2, "joinTroop by uin");
        f fVar = new f(context, gVar, cVar);
        fVar.A0(gVar.f296172f);
        j0(fVar);
    }

    private static void j0(@NonNull f fVar) {
        fVar.setCancelable(false);
        fVar.setCanceledOnTouchOutside(false);
        fVar.setMessage(R.string.cpr);
        if (fVar.a0() == 0) {
            Context context = fVar.R;
            if (context != null) {
                if (context instanceof Activity) {
                    if (!((Activity) context).isFinishing()) {
                        fVar.show();
                        return;
                    }
                    return;
                }
                fVar.show();
                return;
            }
            QLog.e("AddTroopUtil", 2, "joinTroop show dialog fail. mContext is null!");
            return;
        }
        fVar.B0();
        fVar.w0(fVar.X.troopUin, 2);
    }

    private void k0(String str) {
        QLog.i("AddTroopUtil", 1, "[jumpJoinTroopVerify] cGroupOption:" + ((int) this.X.cGroupOption));
        TroopInfoData troopInfoData = this.X;
        if (troopInfoData.cGroupOption != 3) {
            int statOption = troopInfoData.getStatOption();
            Context context = this.R;
            TroopInfoData troopInfoData2 = this.X;
            this.R.startActivity(AddFriendLogicActivity.startJoinTroop(context, troopInfoData2.troopUin, troopInfoData2.newTroopName, troopInfoData2.cGroupOption, statOption, troopInfoData2.mStrJoinQuestion, troopInfoData2.mStrJoinAnswer, null, "", this.Y, this.Z, str));
            TroopUtils.f().removeObserver(this.U);
            return;
        }
        r0(R.string.i7i, 0);
        w0(this.X.troopUin, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit l0(Boolean bool, TroopInfo troopInfo) {
        s0(bool.booleanValue(), this.X.troopUin, troopInfo);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(String str, boolean z16, int i3, String str2, com.tencent.qqnt.bean.c cVar) {
        x0(z16, i3, str);
        if (cVar.a() != null && cVar.a().b()) {
            com.tencent.mobileqq.troop.temporaryban.c.e().g(TroopUtils.f(), this.R, cVar.a().a(), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0() {
        w0(this.X.troopUin, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit o0(String str) {
        y0(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(DialogInterface dialogInterface) {
        B0();
    }

    private void q0(int i3, int i16) {
        new QQToastNotifier(this.R).notifyUser(i3, b0(), 0, i16);
    }

    private void r0(int i3, int i16) {
        q0(i3, i16);
    }

    private void s0(boolean z16, String str, TroopInfo troopInfo) {
        if (troopInfo == null) {
            QLog.d("AddTroopUtil", 1, "[onFetchTroopInfoForJoin] troopInfo is null");
            w0(str, 2);
            return;
        }
        QLog.d("AddTroopUtil", 1, String.format("[onFetchTroopInfoForJoin] isSuccess:%s, troopUin:%s, dwGroupClassExt:%s", Boolean.valueOf(z16), str, Long.valueOf(troopInfo.dwGroupClassExt)));
        if (z16) {
            if (!TextUtils.isEmpty(troopInfo.troopname)) {
                this.X.troopName = troopInfo.troopname;
            }
            TroopInfoData troopInfoData = this.X;
            troopInfoData.dwGroupClassExt = troopInfo.dwGroupClassExt;
            short s16 = troopInfo.cGroupOption;
            troopInfoData.cGroupOption = (byte) s16;
            troopInfoData.mTroopPrivilegeFlag = (int) troopInfo.troopPrivilegeFlag;
            if (s16 == 4 || s16 == 5) {
                troopInfoData.mStrJoinQuestion = troopInfo.joinTroopQuestion;
                troopInfoData.mStrJoinAnswer = troopInfo.joinTroopAnswer;
            }
            if (troopInfo.isOnlyTroopMemberInviteOption()) {
                if (QLog.isColorLevel()) {
                    QLog.d("AddTroopUtil", 2, "troop.isOnlyTroopMemberInviteOption() true");
                }
                troopInfo.setOnlyTroopMemberInviteOption(false);
                troopInfo.cGroupOption = (short) 2;
                TroopInfoData troopInfoData2 = this.X;
                troopInfoData2.cGroupOption = (short) 2;
                troopInfoData2.isOnlyTroopMemberInvite = false;
            }
            TroopInfoData troopInfoData3 = this.X;
            if (troopInfoData3.cGroupOption == 3) {
                r0(R.string.i7i, 0);
                w0(this.X.troopUin, 2);
                return;
            }
            if (troopInfoData3.isHomeworkTroop() && this.X.cGroupOption != 3) {
                f0();
                return;
            }
            boolean hasPayPrivilege = TroopInfo.hasPayPrivilege(this.X.mTroopPrivilegeFlag, 128);
            boolean hasPayPrivilege2 = TroopInfo.hasPayPrivilege(this.X.mTroopPrivilegeFlag, 512);
            if (hasPayPrivilege && hasPayPrivilege2) {
                g0();
                w0(str, 4);
                return;
            } else {
                y0(null);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "handle0x88d return due rsp failed");
        }
        r0(R.string.he7, 1);
        w0(str, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "gotoWebInfo, url = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            QQToast.makeText(this.R, 2, R.string.f173066h23, 1).show(b0());
        } else {
            String str2 = str + "?_wv=1031&troopUin=" + this.X.troopUin + "&isVerify=0";
            Intent intent = new Intent(this.R, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str2);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, true);
            intent.putExtra("show_right_close_button", true);
            intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
            this.R.startActivity(intent);
            Context context = this.R;
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
            }
        }
        w0(this.X.troopUin, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "onJoinTroopDone: troopUin = " + str + ", ret = " + i3 + ", trace = " + Log.getStackTraceString(new RuntimeException()));
        }
        c cVar = this.V;
        if (cVar != null) {
            cVar.a(str, i3);
        }
        dismiss();
    }

    private void x0(boolean z16, int i3, String str) {
        QLog.d("AddTroopUtil", 2, String.format("[onJoinTroopRsp] isSus:%s, res:%s, troopUin = %s", Boolean.valueOf(z16), Integer.valueOf(i3), str));
        if (z16) {
            if (i3 != -2) {
                if (i3 != 0 && i3 != 1) {
                    if (i3 != 2) {
                        if (QLog.isColorLevel()) {
                            QLog.d("AddTroopUtil", 2, "onJoinTroopRsp failed");
                        }
                        r0(R.string.f171048c00, 1);
                        w0(this.X.troopUin, 2);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("AddTroopUtil", 2, "onJoinTroopRsp join forbidden");
                        }
                        r0(R.string.i7i, 1);
                        w0(this.X.troopUin, 2);
                    }
                } else {
                    QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoAIO = " + this.f293731a0);
                    if (this.f293731a0) {
                        c0();
                    }
                    TroopInfo B = this.S.B(str);
                    B.setTroopUin(str);
                    if (TextUtils.isEmpty(this.X.troopName)) {
                        B.troopname = this.X.newTroopName;
                    } else {
                        B.troopname = this.X.troopName;
                    }
                    this.S.d(B);
                    w0(this.X.troopUin, 1);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("AddTroopUtil", 2, "onJoinTroopRsp gotoWebInfo");
                }
                this.T.v(Long.parseLong(str), Long.parseLong(TroopUtils.f().getAccount()));
                return;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("AddTroopUtil", 2, "onJoinTroopRsp rsp failed");
            }
            ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed((Activity) this.R, i3);
            w0(this.X.troopUin, 2);
        }
        dismiss();
    }

    private void y0(String str) {
        QLog.i("AddTroopUtil", 1, "[realJoinGroup] cGroupOption:" + ((int) this.X.cGroupOption) + ", homeworkIntroStr:" + str);
        if (this.X.cGroupOption == 1) {
            e0();
        } else {
            k0(str);
        }
    }

    private void z0() {
        if (QLog.isColorLevel()) {
            QLog.d("AddTroopUtil", 2, "registerObserver");
        }
        TroopUtils.f().addObserver(this.U);
        this.R.registerReceiver(this.W, new IntentFilter("com.tencent.mobileqq.JoinTroopUtil.RET_ACTION"));
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.troop.activity.e
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                f.this.p0(dialogInterface);
            }
        });
    }

    public int b0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.R.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    @Override // com.tencent.mobileqq.widget.QQProgressDialog, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        boolean isShowing = isShowing();
        boolean booleanValue = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("9125_troop_join_observer_unregister", Boolean.FALSE).booleanValue();
        QLog.i("AddTroopUtil", 1, "[dismiss] isShowing = " + isShowing + ", shouldRollback = " + booleanValue);
        if (!isShowing && !booleanValue) {
            B0();
        } else {
            super.dismiss();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new ArrayList<>(Arrays.asList(AddFriendLogicActivity.AddFriendLogicActivityDestroyEvent.class));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof AddFriendLogicActivity.AddFriendLogicActivityDestroyEvent) {
            dismiss();
        }
    }
}
