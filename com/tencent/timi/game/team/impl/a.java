package com.tencent.timi.game.team.impl;

import ag4.h;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import com.tencent.timi.game.room.impl.util.YoloRoomFloatViewUtil;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.team.impl.floating.TeamFloatingView;
import com.tencent.timi.game.team.impl.main.TeamConfigDialog;
import com.tencent.timi.game.team.impl.team.gift.GiftJoinTeamDialog;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.g;
import com.tencent.timi.game.utils.l;
import fm4.TeamCreatePageParam;
import fm4.j;
import fm4.m;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$ShareGameTeamInfoRsp;
import trpc.yes.common.PremadesTeamServerOuterClass$YesGamePremadesTeamInfo;
import trpc.yes.common.UserProxyCmdOuterClass$GetArkMsgBodyRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetTeamConfigRsp;
import trpc.yes.common.YoloRoomOuterClass$QQLiveRoomConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloCommonGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloGameDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloGameRoomParams;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomParams;
import um4.k;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements sm4.a {

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.team.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C9970a implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379379a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f379380b;

        C9970a(IResultListener iResultListener, boolean z16) {
            this.f379379a = iResultListener;
            this.f379380b = z16;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
            IResultListener iResultListener = this.f379379a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomInfo);
            }
            a.this.U2(this.f379380b, yoloRoomOuterClass$YoloRoomInfo, 1);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            IResultListener iResultListener = this.f379379a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class b extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.room.impl.util.d f379382a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f379383b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f379384c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.room.impl.util.c f379385d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IResultListener f379386e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.timi.game.team.impl.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public class C9971a implements IResultListener<PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp> {
            C9971a() {
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp) {
                b bVar = b.this;
                a.this.U3(premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp, bVar.f379383b, bVar.f379384c, bVar.f379382a, bVar.f379385d, bVar.f379386e);
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int i3, String str) {
                com.tencent.timi.game.ui.widget.f.c("\u52a0\u5165\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002");
                l.i("TeamServiceImpl", "batchSmobaConfig failed: errorCode == " + i3 + ",errorMessage == " + str);
            }
        }

        b(com.tencent.timi.game.room.impl.util.d dVar, Activity activity, boolean z16, com.tencent.timi.game.room.impl.util.c cVar, IResultListener iResultListener) {
            this.f379382a = dVar;
            this.f379383b = activity;
            this.f379384c = z16;
            this.f379385d = cVar;
            this.f379386e = iResultListener;
        }

        private void d() {
            YoloRoomUtil.u(this.f379382a.f379324a, new C9971a());
        }

        @Override // fm4.m, fm4.i
        public void a(String str) {
            IResultListener iResultListener = this.f379386e;
            if (iResultListener != null) {
                iResultListener.onError(-1244, "");
            }
            YoloRoomUtil.l0(str, this.f379382a, this.f379385d);
        }

        @Override // fm4.i
        public void b(boolean z16) {
            l.i("TeamServiceImpl", "enterYoloRoom " + this.f379382a.f379324a + " - checkSuccess");
            com.tencent.timi.game.room.impl.util.d dVar = this.f379382a;
            if (dVar.f379328e != 1) {
                a.this.X3(null, this.f379383b, this.f379384c, dVar, this.f379385d, this.f379386e);
            } else {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class c implements IResultListener<YoloRoomOuterClass$YoloRoomInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379389a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GiftJoinTeamDialog f379390b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f379391c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f379392d;

        c(IResultListener iResultListener, GiftJoinTeamDialog giftJoinTeamDialog, Activity activity, boolean z16) {
            this.f379389a = iResultListener;
            this.f379390b = giftJoinTeamDialog;
            this.f379391c = activity;
            this.f379392d = z16;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
            IResultListener iResultListener = this.f379389a;
            if (iResultListener != null) {
                iResultListener.onSuccess(yoloRoomOuterClass$YoloRoomInfo);
            }
            GiftJoinTeamDialog giftJoinTeamDialog = this.f379390b;
            if (giftJoinTeamDialog != null) {
                giftJoinTeamDialog.dismiss();
            }
            a.W3(this.f379391c);
            a.this.U2(this.f379392d, yoloRoomOuterClass$YoloRoomInfo, 2);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
            IResultListener iResultListener = this.f379389a;
            if (iResultListener != null) {
                iResultListener.onError(i3, str);
            }
            if (i3 == -11008) {
                a.this.a4(true);
                GiftJoinTeamDialog giftJoinTeamDialog = this.f379390b;
                if (giftJoinTeamDialog != null) {
                    giftJoinTeamDialog.dismiss();
                    return;
                }
                return;
            }
            GiftJoinTeamDialog giftJoinTeamDialog2 = this.f379390b;
            if (giftJoinTeamDialog2 != null) {
                giftJoinTeamDialog2.dismiss();
            }
            a.W3(this.f379391c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class d implements GiftJoinTeamDialog.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PremadesTeamServerOuterClass$YesGamePremadesTeamInfo f379394a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f379395b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f379396c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.room.impl.util.d f379397d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.room.impl.util.c f379398e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IResultListener f379399f;

        d(PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo, Activity activity, boolean z16, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar, IResultListener iResultListener) {
            this.f379394a = premadesTeamServerOuterClass$YesGamePremadesTeamInfo;
            this.f379395b = activity;
            this.f379396c = z16;
            this.f379397d = dVar;
            this.f379398e = cVar;
            this.f379399f = iResultListener;
        }

        @Override // com.tencent.timi.game.team.impl.team.gift.GiftJoinTeamDialog.e
        public void a(GiftJoinTeamDialog giftJoinTeamDialog, int i3) {
            a.R3(i3, this.f379394a);
            a.this.X3(giftJoinTeamDialog, this.f379395b, this.f379396c, this.f379397d, this.f379398e, this.f379399f);
        }

        @Override // com.tencent.timi.game.team.impl.team.gift.GiftJoinTeamDialog.e
        public void b(GiftJoinTeamDialog giftJoinTeamDialog) {
            giftJoinTeamDialog.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class e implements pl4.d<PremadesTeamServerOuterClass$ShareGameTeamInfoRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f379401a;

        e(IResultListener iResultListener) {
            this.f379401a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable @org.jetbrains.annotations.Nullable PremadesTeamServerOuterClass$ShareGameTeamInfoRsp premadesTeamServerOuterClass$ShareGameTeamInfoRsp, @Nullable @org.jetbrains.annotations.Nullable FromServiceMsg fromServiceMsg) {
            l.e("TeamServiceImpl", "share battle result fail, timiErrCode[" + i16 + "], timiDisplayErrMsg[" + str2 + "]");
            if (!TextUtils.isEmpty(str2)) {
                com.tencent.timi.game.ui.widget.f.d(true, str2);
            }
            IResultListener iResultListener = this.f379401a;
            if (iResultListener != null) {
                iResultListener.onError(i16, str2);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(PremadesTeamServerOuterClass$ShareGameTeamInfoRsp premadesTeamServerOuterClass$ShareGameTeamInfoRsp, FromServiceMsg fromServiceMsg) {
            QQToast.makeText(BaseApplication.getContext(), 5, "\u5206\u4eab\u8f66\u961f\u6210\u529f", 0).show();
            IResultListener iResultListener = this.f379401a;
            if (iResultListener != null) {
                iResultListener.onSuccess(Boolean.TRUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class f implements IQQGiftRechargeCallback {
        f() {
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public Map<String, String> a() {
            return null;
        }

        @Override // com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback
        public void b(boolean z16, int i3, String str) {
            l.e("Gift_Recharge", "result == " + z16 + ",errCode == " + i3 + ",errMsg == " + str);
        }
    }

    public static boolean D(int i3) {
        return ((h) mm4.b.b(h.class)).D(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void R3(int i3, PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo) {
        um4.h.f439233a = premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config.gift_id.get();
        um4.h.f439234b = premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config.gift_num.get();
        um4.h.f439235c = i3;
    }

    public static boolean S3(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
        boolean z16 = false;
        if (yoloRoomOuterClass$YoloRoomInfo == null || !yoloRoomOuterClass$YoloRoomInfo.room_id.has() || !yoloRoomOuterClass$YoloRoomInfo.room_type.has()) {
            return false;
        }
        YoloRoomManager j3 = com.tencent.timi.game.room.impl.d.g().j(yoloRoomOuterClass$YoloRoomInfo.room_id.get());
        if (j3 != null && j3.I1()) {
            z16 = true;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("forceRefreshFloatBall, isShowFloatingView = ");
        sb5.append(!z16);
        l.i("TeamServiceImpl", sb5.toString());
        if (!z16) {
            YoloRoomFloatViewUtil.g(yoloRoomOuterClass$YoloRoomInfo.room_id.get(), yoloRoomOuterClass$YoloRoomInfo.room_type.get(), yoloRoomOuterClass$YoloRoomInfo);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U3(PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp, Activity activity, boolean z16, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        if (premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp.team_list.get().isEmpty()) {
            return;
        }
        List<PremadesTeamServerOuterClass$YesGamePremadesTeamInfo> list = premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp.team_list.get();
        if (!list.isEmpty()) {
            PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo = list.get(0);
            if (activity == null) {
                return;
            }
            YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig = premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config;
            if (yoloRoomOuterClass$YoloGiftConfig != null && yoloRoomOuterClass$YoloGiftConfig.gift_num.get() != 0) {
                Y3(premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp, premadesTeamServerOuterClass$YesGamePremadesTeamInfo, activity, z16, dVar, cVar, iResultListener);
                return;
            } else {
                X3(null, activity, z16, dVar, cVar, iResultListener);
                return;
            }
        }
        com.tencent.timi.game.ui.widget.f.c("\u52a0\u5165\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002");
        l.i("TeamServiceImpl", "batchSmobaConfig failed: result list is empty");
    }

    private static boolean V3() {
        boolean c16 = g.c(MobileQQ.sMobileQQ);
        l.i("TeamServiceImpl", "hasFloatWindowPermission = " + c16);
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W3(Activity activity) {
        if ((activity instanceof TimiGameBaseActivity) && !activity.isFinishing()) {
            ((TimiGameBaseActivity) activity).hideLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X3(GiftJoinTeamDialog giftJoinTeamDialog, Activity activity, boolean z16, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        if (giftJoinTeamDialog != null) {
            giftJoinTeamDialog.showLoadingView();
        }
        Z3(activity);
        ((qo4.a) mm4.b.b(qo4.a.class)).i1(activity, dVar, cVar, new c(iResultListener, giftJoinTeamDialog, activity, z16));
    }

    private void Y3(PremadesTeamServerOuterClass$BatchGetGameTeamInfoRsp premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp, PremadesTeamServerOuterClass$YesGamePremadesTeamInfo premadesTeamServerOuterClass$YesGamePremadesTeamInfo, Activity activity, boolean z16, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        GiftJoinTeamDialog giftJoinTeamDialog = new GiftJoinTeamDialog(activity, premadesTeamServerOuterClass$YesGamePremadesTeamInfo.gift_config, premadesTeamServerOuterClass$BatchGetGameTeamInfoRsp);
        giftJoinTeamDialog.s0(new d(premadesTeamServerOuterClass$YesGamePremadesTeamInfo, activity, z16, dVar, cVar, iResultListener));
        giftJoinTeamDialog.show();
    }

    private static void Z3(Activity activity) {
        if ((activity instanceof TimiGameBaseActivity) && !activity.isFinishing()) {
            ((TimiGameBaseActivity) activity).showLoadingView();
        }
    }

    @Override // sm4.a
    public void L2(Context context, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i3) {
        TeamActivity.h3(context, yoloRoomOuterClass$YoloRoomInfo, i3);
    }

    public YesGameInfoOuterClass$GetTeamConfigRsp T3(int i3) {
        String f16 = rm4.a.f("team_config_" + i3, "");
        if (TextUtils.isEmpty(f16)) {
            return null;
        }
        try {
            return new YesGameInfoOuterClass$GetTeamConfigRsp().mergeFrom(Base64.decode(f16, 2));
        } catch (Exception e16) {
            l.f("TeamServiceImpl", "getTeamConfigCache error ", e16);
            return null;
        }
    }

    @Override // sm4.a
    public void U2(boolean z16, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i3) {
        if (!z16 && V3()) {
            if (yoloRoomOuterClass$YoloRoomInfo != null) {
                S3(yoloRoomOuterClass$YoloRoomInfo);
            }
        } else {
            Context b16 = vf4.a.b();
            if (b16 == null) {
                b16 = eh4.a.b();
            }
            q0(b16, yoloRoomOuterClass$YoloRoomInfo, i3);
        }
    }

    @Override // sm4.a
    public void Y2(boolean z16, Activity activity, com.tencent.timi.game.room.impl.util.d dVar, com.tencent.timi.game.room.impl.util.c cVar, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        j c16;
        if (cVar.f379322a > 0) {
            c16 = j.d(dVar, cVar);
        } else {
            c16 = j.c(dVar);
        }
        YoloRoomUtil.G(activity, c16, new b(dVar, activity, z16, cVar, iResultListener));
    }

    @Override // sm4.a
    public Dialog Z0(Activity activity, List<Long> list, String str, int i3) {
        an4.c cVar = new an4.c(activity, list, str, i3);
        cVar.show();
        return cVar;
    }

    @Override // sm4.a
    public void a0(int i3, int i16, long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, IResultListener<UserProxyCmdOuterClass$GetArkMsgBodyRsp> iResultListener) {
        bn4.b.f28699a.a(i3, i16, j3, commonOuterClass$QQUserId, iResultListener);
    }

    @Override // sm4.a
    public boolean a2(long j3) {
        return ll4.b.a(((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).R(), ((ll4.a) mm4.b.b(ll4.a.class)).E());
    }

    public void a4(boolean z16) {
        k kVar = k.f439239a;
        kVar.c();
        nh2.c d16 = kVar.d();
        if (d16 == null) {
            l.e("Gift_Recharge", "recharge error: GiftSDK is null");
            return;
        }
        IQQGiftRechargeModule f16 = d16.f();
        if (f16 == null) {
            l.e("Gift_Recharge", "recharge error: rechargeModule is null");
        } else {
            f16.I(vf4.a.b(), 3, z16, new f());
        }
    }

    @Override // sm4.a
    public void g2(int i3, IResultListener<YesGameInfoOuterClass$GetTeamConfigRsp> iResultListener) {
        l.i("TeamServiceImpl", "requestTeamCreateConfigRsp - " + i3);
        zm4.a.a(i3, iResultListener);
    }

    @Override // sm4.a
    public void j1(Activity activity, int i3, int i16, int i17, long j3, fm4.c cVar, @Nullable fm4.h hVar, TeamCreatePageParam teamCreatePageParam) {
        com.tencent.timi.game.team.impl.main.e.j(activity, i3, i16, i17, j3, cVar, hVar, 0L, null, "", teamCreatePageParam);
    }

    @Override // sm4.a
    public void k1(Activity activity, com.tencent.timi.game.team.impl.main.d dVar, TeamConfigDialog.c cVar) {
        TeamConfigDialog.H0(activity, dVar, cVar).show();
    }

    @Override // sm4.a
    public void k3(Activity activity, String str) {
        an4.a.f26353a.i(activity, str);
    }

    @Override // sm4.a
    public void m1(IResultListener<Boolean> iResultListener) {
        YoloRoomOuterClass$YoloRoomInfo z16 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
        if (z16 == null) {
            return;
        }
        int t26 = ((fm4.g) mm4.b.b(fm4.g.class)).t2(z16);
        String X0 = ((h) mm4.b.b(h.class)).X0(t26);
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null && I0.getMYesGameId() == t26) {
            ((pl4.c) mm4.b.b(pl4.c.class)).F1(xm4.a.INSTANCE.a(I0.getMQQUserId(), z16.room_id.get(), I0.getMRoomIdFromServer(), t26), PremadesTeamServerOuterClass$ShareGameTeamInfoRsp.class, new e(iResultListener));
            return;
        }
        String str = "\u76ee\u524d\u4e0d\u5728" + X0 + "\u4ea4\u53cb\u5927\u5385\u65e0\u6cd5\u5206\u4eab\u54e6";
        com.tencent.timi.game.ui.widget.f.c(str);
        if (iResultListener != null) {
            iResultListener.onError(-1, str);
        }
    }

    @Override // sm4.a
    public void m3(boolean z16, YoloRoomOuterClass$YoloRoomParams yoloRoomOuterClass$YoloRoomParams, YoloRoomOuterClass$YoloGameRoomParams yoloRoomOuterClass$YoloGameRoomParams, IResultListener<YoloRoomOuterClass$YoloRoomInfo> iResultListener) {
        ((qo4.a) mm4.b.b(qo4.a.class)).r3(yoloRoomOuterClass$YoloRoomParams, yoloRoomOuterClass$YoloGameRoomParams, new C9970a(iResultListener, z16));
    }

    @Override // sm4.a
    public boolean n1() {
        YoloRoomOuterClass$YoloRoomInfo z16 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
        if (z16 != null) {
            YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig = z16.game_data_info.common_game_data_info.gift_config.get();
            if (yoloRoomOuterClass$YoloGiftConfig.gift_num.get() > 0 && yoloRoomOuterClass$YoloGiftConfig.gift_id.get() != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // sm4.a
    public uh4.d p(long j3) {
        TeamFloatingView teamFloatingView = new TeamFloatingView(BaseApplication.context);
        teamFloatingView.F(j3);
        return teamFloatingView;
    }

    @Override // sm4.a
    public void p0(int i3, IResultListener<YesGameInfoOuterClass$GetTeamConfigRsp> iResultListener) {
        YesGameInfoOuterClass$GetTeamConfigRsp T3 = T3(i3);
        if (T3 != null) {
            if (iResultListener != null) {
                iResultListener.onSuccess(T3);
                return;
            }
            return;
        }
        g2(i3, iResultListener);
    }

    @Override // sm4.a
    public boolean q0(Context context, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, int i3) {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("launchRoomMainPage - ");
        sb5.append(context);
        sb5.append(" - ");
        sb5.append(yoloRoomOuterClass$YoloRoomInfo);
        sb5.append(" - ");
        if (yoloRoomOuterClass$YoloRoomInfo != null) {
            obj = Long.valueOf(yoloRoomOuterClass$YoloRoomInfo.room_id.get());
        } else {
            obj = "null";
        }
        sb5.append(obj);
        l.i("TeamServiceImpl", sb5.toString());
        if (context == null || yoloRoomOuterClass$YoloRoomInfo == null || !yoloRoomOuterClass$YoloRoomInfo.room_id.has() || !yoloRoomOuterClass$YoloRoomInfo.room_type.has()) {
            return false;
        }
        if (D(yoloRoomOuterClass$YoloRoomInfo.room_type.get())) {
            ((sm4.a) mm4.b.b(sm4.a.class)).L2(context, yoloRoomOuterClass$YoloRoomInfo, i3);
            return true;
        }
        return true;
    }

    @Override // sm4.a
    public boolean r2(int i3) {
        boolean z16;
        if (((fm4.g) mm4.b.b(fm4.g.class)).j0(((fm4.g) mm4.b.b(fm4.g.class)).J(i3)) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        l.i("TeamServiceImpl", "isInSmobaTeam " + z16);
        return z16;
    }

    @Override // sm4.a
    public void u3(Context context) {
        TeamActivity.Y2();
    }

    @Override // sm4.a
    public boolean x0(CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j3) {
        return ll4.b.a(((fm4.g) mm4.b.b(fm4.g.class)).K0(j3).R(), commonOuterClass$QQUserId);
    }

    @Override // sm4.a
    public void x2(int i3, YesGameInfoOuterClass$GetTeamConfigRsp yesGameInfoOuterClass$GetTeamConfigRsp) {
        if (yesGameInfoOuterClass$GetTeamConfigRsp != null) {
            rm4.a.k("team_config_" + i3, Base64.encodeToString(yesGameInfoOuterClass$GetTeamConfigRsp.toByteArray(), 2));
        }
    }

    @Override // sm4.a
    public boolean y3() {
        YoloRoomOuterClass$YoloGameDataInfo yoloRoomOuterClass$YoloGameDataInfo;
        YoloRoomOuterClass$YoloCommonGameDataInfo yoloRoomOuterClass$YoloCommonGameDataInfo;
        YoloRoomOuterClass$QQLiveRoomConfig yoloRoomOuterClass$QQLiveRoomConfig;
        YoloRoomOuterClass$YoloRoomInfo z16 = ((fm4.g) mm4.b.b(fm4.g.class)).z1();
        if (z16 == null || (yoloRoomOuterClass$YoloGameDataInfo = z16.game_data_info) == null || (yoloRoomOuterClass$YoloCommonGameDataInfo = yoloRoomOuterClass$YoloGameDataInfo.common_game_data_info) == null || (yoloRoomOuterClass$QQLiveRoomConfig = yoloRoomOuterClass$YoloCommonGameDataInfo.qq_live_room_config) == null || yoloRoomOuterClass$QQLiveRoomConfig.live_uid.get() <= 0) {
            return false;
        }
        return true;
    }

    @Override // sm4.a
    public void z3(Activity activity, int i3, long j3, long j16, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, fm4.c cVar) {
        int i16;
        YoloRoomOuterClass$YoloRoomInfo a16 = ((fm4.g) mm4.b.b(fm4.g.class)).a1(i3);
        if (a16 != null) {
            com.tencent.timi.game.team.impl.main.g.b(a16, j16, commonOuterClass$QQUserId, str);
            return;
        }
        if (cVar != null) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        com.tencent.timi.game.team.impl.main.e.j(activity, i3, i16, 1, j3, cVar, null, j16, commonOuterClass$QQUserId, str, new TeamCreatePageParam());
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(Context context) {
    }
}
