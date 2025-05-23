package com.tencent.mobileqq.zplan.authorize.impl.checker.mod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.protobuf.nano.MessageNano;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.ipc.ab;
import com.tencent.mobileqq.zootopia.ipc.ac;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.QQDeviceInfo;
import java.util.Map;
import k74.i;
import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mc3.InsExeExtParam;
import mqq.app.Foreground;
import qv4.au;
import qv4.av;
import qv4.bs;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J:\u0010\u0010\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002J&\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J8\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0002J\u001e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J&\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001fH\u0016J&\u0010!\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/d;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "getOpenIdCallback", "", "p", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "needReAuth", "r", "", "errCode", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lqv4/av;", "needProcessReAuth", "u", "t", HippyTKDListViewAdapter.X, "w", "Lqv4/au;", "o", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "v", "", "b", DomainData.DOMAIN_NAME, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/d$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/av;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<av> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EnterModCheckResult f331448e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f331449f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ EnterModCheckRequest f331450h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f331451i;

        b(EnterModCheckResult enterModCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar, EnterModCheckRequest enterModCheckRequest, boolean z16) {
            this.f331448e = enterModCheckResult;
            this.f331449f = aVar;
            this.f331450h = enterModCheckRequest;
            this.f331451i = z16;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(av result) {
            Intrinsics.checkNotNullParameter(result, "result");
            d.this.u(result, this.f331448e, this.f331449f, this.f331450h, this.f331451i);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            d.this.f("handleGetOpenIdResult onResultFailure error:" + error + " message:" + message);
            d.this.t(this.f331448e, this.f331449f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/d$c", "Llc3/a;", "", "mapId", "", "exitCode", "", "msg", "", "e", "from", "url", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends lc3.a {
        c() {
        }

        @Override // lc3.a
        public void d(long from, int mapId, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            d.this.e("onMinorsJumpToUrl: mapId=" + mapId + ", from=" + from);
        }

        @Override // lc3.a
        public void e(int mapId, long exitCode, String msg2) {
            d.this.e("onMinorsLoginInterrupt: mapId=" + mapId + ", exitCode=" + exitCode + ", msg=" + msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/d$d", "Llc3/b;", "", "mapId", "", "exitCode", "", "msg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.d$d, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9149d implements lc3.b {
        C9149d() {
        }

        @Override // lc3.b
        public void a(int mapId, long exitCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            d.this.f("exitGame: mapId=" + mapId);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0099, code lost:
    
        r8 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final au o(EnterModCheckRequest request, ZootopiaOpenIdResult result) {
        Long longOrNull;
        au auVar = new au();
        bs bsVar = new bs();
        auVar.f430008a = bsVar;
        bsVar.f430115a = request.getEnterParams().getMapId();
        auVar.f430008a.f430116b = request.getEnterParams().getVersion();
        auVar.f430012e = QQDeviceInfo.getQIMEI();
        auVar.f430009b = result.getOpenId();
        auVar.f430010c = result.getAccessToken();
        Map<String, Object> ueParams = request.getEnterParams().getUeParams();
        Object obj = ueParams != null ? ueParams.get("serverExtraInfo") : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        auVar.f430014g = str;
        Map<String, Object> ueParams2 = request.getEnterParams().getUeParams();
        Object obj2 = ueParams2 != null ? ueParams2.get("VisitUin") : null;
        Long l3 = obj2 instanceof Long ? (Long) obj2 : null;
        long longValue = l3 != null ? l3.longValue() : 0L;
        if (longValue == 0) {
            Map<String, Object> ueParams3 = request.getEnterParams().getUeParams();
            Object obj3 = ueParams3 != null ? ueParams3.get("VisitUin") : null;
            String str2 = obj3 instanceof String ? (String) obj3 : null;
            longValue = (str2 == null || longOrNull == null) ? 0L : longOrNull.longValue();
        }
        if (longValue != 0) {
            auVar.f430013f = longValue;
        }
        return auVar;
    }

    private final void p(EnterModCheckRequest request, ab getOpenIdCallback) {
        if (v(request.getEnterParams())) {
            f("AuthSilence");
            ((ac) i.INSTANCE.a(ac.class)).getOpenIdInfoSilent(getOpenIdCallback);
        } else {
            f("AuthNormal");
            ((ac) i.INSTANCE.a(ac.class)).getOpenIdInfo(request.getSource(), String.valueOf(request.getEnterParams().getMapId()), getOpenIdCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(int errCode, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        f("check handleGetOpenIdError errCode:" + errCode);
        if (errCode != -1007 && errCode != -1002) {
            i("\u83b7\u53d6\u9274\u6743\u5931\u8d25");
        }
        lastCheckResult.setResultCode(11);
        callback.b(lastCheckResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        f("check onResultFailure");
        lastCheckResult.setResultCode(10);
        callback.b(lastCheckResult);
        h(R.string.xbn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u(av result, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback, EnterModCheckRequest request, boolean needProcessReAuth) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = !result.f430016b;
        if (result.f430015a) {
            xu4.a[] aVarArr = result.f430017c;
            if (aVarArr != null) {
                if (!(aVarArr.length == 0)) {
                    z18 = false;
                    if (!z18) {
                        z16 = false;
                        String str = result.f430018d;
                        z17 = str != null || str.length() == 0;
                        boolean z26 = result.f430019e == 0;
                        f("check onResultSuccess authCheckPassed=" + z19 + " minorCheckPassed=" + z16 + " toastCheckPassed=" + z17 + " loginCheckPassed=" + z26 + ", needReAuth = " + needProcessReAuth);
                        if (!z19 && z16 && z17 && z26) {
                            if (lastCheckResult.getEnterParamsAfterCheck() == null) {
                                lastCheckResult.setEnterParamsAfterCheck(request.getEnterParams());
                            }
                            ZootopiaEnterParams enterParamsAfterCheck = lastCheckResult.getEnterParamsAfterCheck();
                            Intrinsics.checkNotNull(enterParamsAfterCheck);
                            enterParamsAfterCheck.setNeedMinorsHeartBeat(result.f430015a);
                            d(request, lastCheckResult, callback);
                            return;
                        }
                        if (!z17) {
                            String str2 = result.f430018d;
                            Intrinsics.checkNotNullExpressionValue(str2, "result.toast");
                            i(str2);
                        }
                        if (z19) {
                            if (needProcessReAuth) {
                                callback.a(lastCheckResult);
                                x(request, lastCheckResult, callback);
                                return;
                            } else {
                                CommonExKt.m("\u767b\u5f55\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                                lastCheckResult.setResultCode(13);
                                callback.b(lastCheckResult);
                                return;
                            }
                        }
                        if (!z16) {
                            w(request, result);
                            lastCheckResult.setResultCode(15);
                            callback.b(lastCheckResult);
                            return;
                        } else if (!z26) {
                            lastCheckResult.setResultCode(9);
                            callback.b(lastCheckResult);
                            return;
                        } else if (!z17) {
                            lastCheckResult.setResultCode(14);
                            callback.b(lastCheckResult);
                            return;
                        } else {
                            d(request, lastCheckResult, callback);
                            return;
                        }
                    }
                }
            }
            z18 = true;
            if (!z18) {
            }
        }
        z16 = true;
        String str3 = result.f430018d;
        if (str3 != null) {
        }
        if (result.f430019e == 0) {
        }
        f("check onResultSuccess authCheckPassed=" + z19 + " minorCheckPassed=" + z16 + " toastCheckPassed=" + z17 + " loginCheckPassed=" + z26 + ", needReAuth = " + needProcessReAuth);
        if (!z19) {
        }
        if (!z17) {
        }
        if (z19) {
        }
    }

    private final boolean v(ZootopiaEnterParams enterParams) {
        return ZPlanFeatureSwitch.f369852a.V1() && enterParams.getMapId() == 200001;
    }

    private final void x(EnterModCheckRequest request, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        f("reAuthAndDoLoginCheck");
        e eVar = new e(lastCheckResult, callback, request);
        if (v(request.getEnterParams())) {
            f("reAuthSilence");
            ((ac) i.INSTANCE.a(ac.class)).reAuthOpenIdSilent(eVar);
        } else {
            f("reAuthNormal");
            ((ac) i.INSTANCE.a(ac.class)).reAuthOpenId(request.getSource(), String.valueOf(request.getEnterParams().getMapId()), eVar);
        }
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "ModLoginChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void a(EnterModCheckRequest request, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        f("check mapId = " + request.getEnterParams().getMapId() + " mapName = " + request.getEnterParams().getName());
        p(request, new a(lastCheckResult, callback, request));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(ZootopiaOpenIdResult result, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback, EnterModCheckRequest request, boolean needReAuth) {
        if (result == null) {
            lastCheckResult.setResultCode(12);
            f("check onOpenIdResult null result");
            callback.b(lastCheckResult);
            return;
        }
        ZootopiaEnterParams enterParamsAfterCheck = lastCheckResult.getEnterParamsAfterCheck();
        if (enterParamsAfterCheck != null) {
            enterParamsAfterCheck.setOpenId(result.getOpenId());
        }
        ZootopiaEnterParams enterParamsAfterCheck2 = lastCheckResult.getEnterParamsAfterCheck();
        if (enterParamsAfterCheck2 != null) {
            enterParamsAfterCheck2.setAccessToken(result.getAccessToken());
        }
        f("check onOpenIdResult success");
        oe3.a.f(oe3.a.f422578a, o(request, result), new b(lastCheckResult, callback, request, needReAuth), 0, 4, null);
    }

    private final void w(EnterModCheckRequest request, av result) {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && Foreground.isCurrentProcessForeground()) {
            GameJudgeParams gameJudgeParams = new GameJudgeParams(request.getEnterParams().getMapId(), request.getEnterParams().getOpenId(), request.getEnterParams().getAccessToken(), new C9149d(), new c(), ZootopiaSource.INSTANCE.j(request.getSource()), topActivity);
            oc3.b bVar = oc3.b.f422445a;
            String str = result.f430020f;
            if (str == null) {
                str = "";
            }
            InsExeExtParam insExeExtParam = new InsExeExtParam(str);
            xu4.a[] aVarArr = result.f430017c;
            Intrinsics.checkNotNullExpressionValue(aVarArr, "result.instructions");
            bVar.a(1L, insExeExtParam, gameJudgeParams, aVarArr);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ZootopiaSource.KEY_FRAGMENT_SOURCE, new FragmentSource(Source.UnSet, request.getSource()));
        bundle.putInt(VRReportDefine$ReportParam.AD_MOD_ID, request.getEnterParams().getMapId());
        bundle.putString("open_id", request.getEnterParams().getOpenId());
        bundle.putString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, request.getEnterParams().getAccessToken());
        bundle.putByteArray("mod_login_rsp", MessageNano.toByteArray(result));
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, MinorsFragment.class);
    }

    static /* synthetic */ void s(d dVar, ZootopiaOpenIdResult zootopiaOpenIdResult, EnterModCheckResult enterModCheckResult, com.tencent.mobileqq.zplan.authorize.api.a aVar, EnterModCheckRequest enterModCheckRequest, boolean z16, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = true;
        }
        dVar.r(zootopiaOpenIdResult, enterModCheckResult, aVar, enterModCheckRequest, z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/d$a", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements ab {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EnterModCheckResult f331444b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f331445c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EnterModCheckRequest f331446d;

        a(EnterModCheckResult enterModCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar, EnterModCheckRequest enterModCheckRequest) {
            this.f331444b = enterModCheckResult;
            this.f331445c = aVar;
            this.f331446d = enterModCheckRequest;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            d.s(d.this, result, this.f331444b, this.f331445c, this.f331446d, false, 16, null);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            d.this.q(errCode, this.f331444b, this.f331445c);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/d$e", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements ab {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EnterModCheckResult f331455b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f331456c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EnterModCheckRequest f331457d;

        e(EnterModCheckResult enterModCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar, EnterModCheckRequest enterModCheckRequest) {
            this.f331455b = enterModCheckResult;
            this.f331456c = aVar;
            this.f331457d = enterModCheckRequest;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            d.this.r(result, this.f331455b, this.f331456c, this.f331457d, false);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            d.this.q(errCode, this.f331455b, this.f331456c);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
        }
    }
}
