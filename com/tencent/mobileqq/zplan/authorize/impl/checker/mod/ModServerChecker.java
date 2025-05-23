package com.tencent.mobileqq.zplan.authorize.impl.checker.mod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.protobuf.nano.MessageNano;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.ipc.ab;
import com.tencent.mobileqq.zootopia.ipc.ac;
import com.tencent.mobileqq.zootopia.utils.k;
import com.tencent.mobileqq.zplan.authorize.api.CommonModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.fragment.MinorsFragment;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanUEShowDialogEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.QQDeviceInfo;
import java.util.ArrayList;
import java.util.Map;
import k74.i;
import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mc3.InsExeExtParam;
import mqq.app.Foreground;
import qv4.at;
import qv4.bs;
import qv4.h;
import qv4.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010,\u001a\u00020\u000e\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J:\u0010\u0010\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0002J.\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J&\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J&\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J&\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J8\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0018\u001a\u00020\u000eH\u0002J\u001e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J&\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0011H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0007H\u0002J\u0018\u0010&\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$H\u0002J&\u0010'\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0016J\b\u0010)\u001a\u00020(H\u0016R\u0014\u0010,\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/ModServerChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "getOpenIdCallback", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "needReAuth", "u", "Lqv4/j;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "errCode", "t", "w", "needProcessReAuth", "y", HippyTKDListViewAdapter.X, "E", BdhLogUtil.LogTag.Tag_Conn, "Lqv4/i;", "r", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "B", UserInfo.SEX_FEMALE, "rsp", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "b", "d", "Z", "isCloudGame", "<init>", "(Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ModServerChecker extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isCloudGame;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/ModServerChecker$b", "Llc3/a;", "", "mapId", "", "exitCode", "", "msg", "", "e", "from", "url", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends lc3.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f331421b;

        b(Activity activity) {
            this.f331421b = activity;
        }

        @Override // lc3.a
        public void d(long from, int mapId, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            ModServerChecker.this.e("onMinorsJumpToUrl: mapId=" + mapId + ", from=" + from);
        }

        @Override // lc3.a
        public void e(int mapId, long exitCode, String msg2) {
            ModServerChecker.this.e("onMinorsLoginInterrupt: mapId=" + mapId + ", exitCode=" + exitCode + ", msg=" + msg2);
            Activity activity = this.f331421b;
            if (activity instanceof ZootopiaUEActivity) {
                activity.finish();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/ModServerChecker$c", "Llc3/b;", "", "mapId", "", "exitCode", "", "msg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements lc3.b {
        c() {
        }

        @Override // lc3.b
        public void a(int mapId, long exitCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ModServerChecker.this.f("exitGame: mapId=" + mapId);
        }
    }

    public ModServerChecker(boolean z16) {
        this.isCloudGame = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(EnterModCheckResult lastCheckResult, j result, EnterModCheckRequest request, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        if (lastCheckResult.getEnterParamsAfterCheck() == null) {
            lastCheckResult.setEnterParamsAfterCheck(request.getEnterParams());
        }
        ZootopiaEnterParams enterParamsAfterCheck = lastCheckResult.getEnterParamsAfterCheck();
        if (enterParamsAfterCheck != null) {
            enterParamsAfterCheck.setLoadingParams(ZootopiaMapLoadingParams.INSTANCE.a(result.f430177k));
        }
        ZootopiaEnterParams enterParamsAfterCheck2 = lastCheckResult.getEnterParamsAfterCheck();
        if (enterParamsAfterCheck2 != null) {
            String str = result.f430169c;
            Intrinsics.checkNotNullExpressionValue(str, "result.mapVersion");
            enterParamsAfterCheck2.setVersion(str);
        }
        ArrayList arrayList = new ArrayList();
        nw4.f[] fVarArr = result.f430175i;
        Intrinsics.checkNotNullExpressionValue(fVarArr, "result.infoList");
        for (nw4.f fVar : fVarArr) {
            byte[] infoByteArray = MessageNano.toByteArray(fVar);
            Intrinsics.checkNotNullExpressionValue(infoByteArray, "infoByteArray");
            arrayList.add(infoByteArray);
        }
        ZootopiaEnterParams enterParamsAfterCheck3 = lastCheckResult.getEnterParamsAfterCheck();
        if (enterParamsAfterCheck3 != null) {
            String str2 = result.f430173g;
            Intrinsics.checkNotNullExpressionValue(str2, "result.downText");
            String str3 = result.f430174h;
            Intrinsics.checkNotNullExpressionValue(str3, "result.loadingText");
            String str4 = result.f430176j;
            Intrinsics.checkNotNullExpressionValue(str4, "result.newGuideUrl");
            enterParamsAfterCheck3.setCommonModCheckResult(new CommonModCheckResult(str2, str3, str4, arrayList));
        }
        ZootopiaEnterParams enterParamsAfterCheck4 = lastCheckResult.getEnterParamsAfterCheck();
        if (enterParamsAfterCheck4 != null) {
            enterParamsAfterCheck4.setNeedMinorsHeartBeat(result.f430167a.f430180c);
        }
        d(request, lastCheckResult, callback);
    }

    private final boolean B(ZootopiaEnterParams enterParams) {
        return ZPlanFeatureSwitch.f369852a.V1() && enterParams.getMapId() == 200001;
    }

    private final boolean D(j rsp, ZootopiaSource source) {
        boolean isBlank;
        h hVar = rsp.f430168b;
        at atVar = rsp.f430177k;
        boolean z16 = atVar != null && atVar.f430007b == 1;
        if (!this.isCloudGame && z16) {
            int i3 = hVar.f430157b;
            if (i3 == 0) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                String str = hVar.f430156a;
                Intrinsics.checkNotNullExpressionValue(str, "ntf.msg");
                simpleEventBus.dispatchEvent(new ZPlanUEShowDialogEvent("", str, "\u786e\u8ba4", "", null, hVar.f430158c, 1), true);
            } else if (i3 == 1) {
                SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
                String str2 = hVar.f430156a;
                Intrinsics.checkNotNullExpressionValue(str2, "ntf.msg");
                simpleEventBus2.dispatchEvent(new ZPlanUEShowDialogEvent("", str2, "\u786e\u8ba4", "\u53d6\u6d88", null, hVar.f430158c, 1), true);
            }
            return true;
        }
        if (!TextUtils.isEmpty(hVar.f430156a)) {
            String str3 = hVar.f430156a;
            Intrinsics.checkNotNullExpressionValue(str3, "ntf.msg");
            i(str3);
        }
        String str4 = hVar.f430158c;
        Intrinsics.checkNotNullExpressionValue(str4, "ntf.scheme");
        isBlank = StringsKt__StringsJVMKt.isBlank(str4);
        if (!(!isBlank)) {
            return false;
        }
        String str5 = hVar.f430158c;
        Intrinsics.checkNotNullExpressionValue(str5, "ntf.scheme");
        c(str5, source);
        return true;
    }

    private final void E(EnterModCheckRequest request, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        f("reAuthAndDoLoginCheck");
        d dVar = new d(lastCheckResult, callback, request);
        if (B(request.getEnterParams())) {
            f("reAuthSilence");
            ((ac) i.INSTANCE.a(ac.class)).reAuthOpenIdSilent(dVar);
        } else {
            f("reAuthNormal");
            ((ac) i.INSTANCE.a(ac.class)).reAuthOpenId(request.getSource(), String.valueOf(request.getEnterParams().getMapId()), dVar);
        }
    }

    private final void F() {
        f("showQQUpgradeDialog");
        final Activity topActivity = Foreground.getTopActivity();
        if (topActivity.isFinishing()) {
            return;
        }
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.ModServerChecker$showQQUpgradeDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                k kVar = new k();
                Activity activity = topActivity;
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                kVar.d(activity, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.ModServerChecker$showQQUpgradeDialog$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        if (Foreground.getTopActivity() instanceof ZootopiaUEActivity) {
                            Foreground.getTopActivity().finish();
                        }
                    }
                });
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0099, code lost:
    
        r8 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final qv4.i r(EnterModCheckRequest request, ZootopiaOpenIdResult result) {
        Long longOrNull;
        qv4.i iVar = new qv4.i();
        bs bsVar = new bs();
        iVar.f430159a = bsVar;
        bsVar.f430115a = request.getEnterParams().getMapId();
        iVar.f430159a.f430116b = request.getEnterParams().getVersion();
        iVar.f430163e = QQDeviceInfo.getQIMEI();
        iVar.f430160b = result.getOpenId();
        iVar.f430161c = result.getAccessToken();
        Map<String, Object> ueParams = request.getEnterParams().getUeParams();
        Object obj = ueParams != null ? ueParams.get("serverExtraInfo") : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        iVar.f430166h = str;
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
            iVar.f430164f = longValue;
        }
        if (this.isCloudGame) {
            iVar.f430165g = 1;
        }
        return iVar;
    }

    private final void s(EnterModCheckRequest request, ab getOpenIdCallback) {
        if (B(request.getEnterParams())) {
            f("AuthSilence");
            ((ac) i.INSTANCE.a(ac.class)).getOpenIdInfoSilent(getOpenIdCallback);
        } else {
            f("AuthNormal");
            ((ac) i.INSTANCE.a(ac.class)).getOpenIdInfo(request.getSource(), String.valueOf(request.getEnterParams().getMapId()), getOpenIdCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int errCode, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        f("check handleGetOpenIdError errCode:" + errCode);
        if (errCode != -1007 && errCode != -1002) {
            i("\u83b7\u53d6\u9274\u6743\u5931\u8d25");
        }
        lastCheckResult.setResultCode(11);
        lastCheckResult.setProcessInner(true);
        callback.b(lastCheckResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean w(j result, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        qv4.k kVar = result.f430167a;
        boolean z16 = kVar != null && kVar.f430178a == 0;
        boolean z17 = kVar != null && kVar.f430179b == 0;
        boolean z18 = !this.isCloudGame || (kVar != null && kVar.f430182e == 1);
        f("handleModInfoResult mapVersionCheckPassed=" + z16 + ",  qqVersionCheckPassed=" + z17);
        if (!z16) {
            lastCheckResult.setModUpdateInfo(result.f430170d);
            ZootopiaEnterParams enterParamsAfterCheck = lastCheckResult.getEnterParamsAfterCheck();
            if (enterParamsAfterCheck != null) {
                enterParamsAfterCheck.setProgress(Float.valueOf(0.0f));
            }
            f("updateInfo = " + result.f430170d);
            lastCheckResult.setProcessInner(false);
            lastCheckResult.setResultCode(5);
            callback.b(lastCheckResult);
            return true;
        }
        if (z17) {
            if (z18) {
                return false;
            }
            qv4.k kVar2 = result.f430167a;
            lastCheckResult.setCloudServerStatus(kVar2 != null ? kVar2.f430182e : 0);
            lastCheckResult.setResultCode(23);
            lastCheckResult.setProcessInner(false);
            callback.b(lastCheckResult);
            return true;
        }
        qv4.k kVar3 = result.f430167a;
        if (kVar3 != null && kVar3.f430179b == 1) {
            F();
        } else if (result.f430168b != null) {
            lastCheckResult.setProcessInner(D(result, lastCheckResult.getSource()));
        } else {
            lastCheckResult.setProcessInner(false);
        }
        lastCheckResult.setResultCode(6);
        callback.b(lastCheckResult);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        f("check onResultFailure");
        lastCheckResult.setResultCode(10);
        callback.b(lastCheckResult);
        lastCheckResult.setProcessInner(true);
        h(R.string.xbn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r0 == false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean y(j result, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback, EnterModCheckRequest request, boolean needProcessReAuth) {
        boolean z16;
        boolean z17;
        qv4.k kVar = result.f430167a;
        boolean z18 = !kVar.f430181d;
        if (kVar != null) {
            if (kVar.f430180c) {
                xu4.a[] aVarArr = result.f430171e;
                if (aVarArr != null) {
                    if (!(aVarArr.length == 0)) {
                        z17 = false;
                    }
                }
                z17 = true;
            }
            z16 = true;
            f("check onResultSuccess authCheckPassed=" + z18 + " minorCheckPassed=" + z16 + " needReAuth = " + needProcessReAuth);
            if (!z18) {
                if (z16) {
                    return false;
                }
                C(request, result);
                lastCheckResult.setResultCode(15);
                lastCheckResult.setProcessInner(true);
                callback.b(lastCheckResult);
                return true;
            }
            if (needProcessReAuth) {
                callback.a(lastCheckResult);
                E(request, lastCheckResult, callback);
            } else {
                CommonExKt.m("\u767b\u5f55\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                lastCheckResult.setResultCode(13);
                lastCheckResult.setProcessInner(true);
                callback.b(lastCheckResult);
            }
            return true;
        }
        z16 = false;
        f("check onResultSuccess authCheckPassed=" + z18 + " minorCheckPassed=" + z16 + " needReAuth = " + needProcessReAuth);
        if (!z18) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean z(j result, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        h hVar = result.f430168b;
        boolean z16 = hVar == null || TextUtils.isEmpty(hVar.f430156a);
        f("handleDialogResult othersErrorCheckPassed=" + z16);
        if (z16) {
            return false;
        }
        lastCheckResult.setProcessInner(D(result, lastCheckResult.getSource()));
        lastCheckResult.setResultCode(14);
        callback.b(lastCheckResult);
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "ModServerChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void a(EnterModCheckRequest request, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        f("check mapId = " + request.getEnterParams().getMapId() + " mapName = " + request.getEnterParams().getName());
        s(request, new a(lastCheckResult, callback, request));
    }

    private final void C(EnterModCheckRequest request, j result) {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && Foreground.isCurrentProcessForeground()) {
            GameJudgeParams gameJudgeParams = new GameJudgeParams(request.getEnterParams().getMapId(), request.getEnterParams().getOpenId(), request.getEnterParams().getAccessToken(), new c(), new b(topActivity), ZootopiaSource.INSTANCE.j(request.getSource()), topActivity);
            oc3.b bVar = oc3.b.f422445a;
            String str = result.f430172f;
            if (str == null) {
                str = "";
            }
            InsExeExtParam insExeExtParam = new InsExeExtParam(str);
            xu4.a[] aVarArr = result.f430171e;
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
        bundle.putByteArray("enter_mod_rsp", MessageNano.toByteArray(result));
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, MinorsFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(ZootopiaOpenIdResult result, final EnterModCheckResult lastCheckResult, final com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback, final EnterModCheckRequest request, final boolean needReAuth) {
        if (result == null) {
            lastCheckResult.setResultCode(12);
            f("check onOpenIdResult null result");
            i("\u83b7\u53d6\u9274\u6743\u5931\u8d25");
            lastCheckResult.setProcessInner(true);
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
        final qv4.i r16 = r(request, result);
        ZootopiaDownloadManagerIpc.f328013a.i(request.getEnterParams().getMapId(), new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.mod.ModServerChecker$handleGetOpenIdResult$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/ModServerChecker$handleGetOpenIdResult$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/j;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements com.tencent.mobileqq.zootopia.api.e<j> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ModServerChecker f331427d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ EnterModCheckResult f331428e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f331429f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ EnterModCheckRequest f331430h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ boolean f331431i;

                a(ModServerChecker modServerChecker, EnterModCheckResult enterModCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar, EnterModCheckRequest enterModCheckRequest, boolean z16) {
                    this.f331427d = modServerChecker;
                    this.f331428e = enterModCheckResult;
                    this.f331429f = aVar;
                    this.f331430h = enterModCheckRequest;
                    this.f331431i = z16;
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(j result) {
                    boolean w3;
                    boolean y16;
                    boolean z16;
                    Intrinsics.checkNotNullParameter(result, "result");
                    w3 = this.f331427d.w(result, this.f331428e, this.f331429f);
                    if (w3) {
                        return;
                    }
                    y16 = this.f331427d.y(result, this.f331428e, this.f331429f, this.f331430h, this.f331431i);
                    if (y16) {
                        return;
                    }
                    z16 = this.f331427d.z(result, this.f331428e, this.f331429f);
                    if (z16) {
                        return;
                    }
                    this.f331427d.A(this.f331428e, result, this.f331430h, this.f331429f);
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    this.f331427d.f("handleGetOpenIdResult onResultFailure error:" + error + " message:" + message);
                    this.f331427d.x(this.f331428e, this.f331429f);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                invoke2(zootopiaResData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaResData zootopiaResData) {
                if (zootopiaResData != null && zootopiaResData.getDownloadStatus() == 5) {
                    qv4.i.this.f430159a.f430116b = zootopiaResData.getVersion();
                }
                oe3.a.b(oe3.a.f422578a, qv4.i.this, new a(this, lastCheckResult, callback, request, needReAuth), 0, 4, null);
            }
        });
    }

    static /* synthetic */ void v(ModServerChecker modServerChecker, ZootopiaOpenIdResult zootopiaOpenIdResult, EnterModCheckResult enterModCheckResult, com.tencent.mobileqq.zplan.authorize.api.a aVar, EnterModCheckRequest enterModCheckRequest, boolean z16, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = true;
        }
        modServerChecker.u(zootopiaOpenIdResult, enterModCheckResult, aVar, enterModCheckRequest, z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/ModServerChecker$a", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements ab {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EnterModCheckResult f331417b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f331418c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EnterModCheckRequest f331419d;

        a(EnterModCheckResult enterModCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar, EnterModCheckRequest enterModCheckRequest) {
            this.f331417b = enterModCheckResult;
            this.f331418c = aVar;
            this.f331419d = enterModCheckRequest;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            ModServerChecker.v(ModServerChecker.this, result, this.f331417b, this.f331418c, this.f331419d, false, 16, null);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            ModServerChecker.this.t(errCode, this.f331417b, this.f331418c);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/authorize/impl/checker/mod/ModServerChecker$d", "Lcom/tencent/mobileqq/zootopia/ipc/ab;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements ab {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EnterModCheckResult f331424b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f331425c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ EnterModCheckRequest f331426d;

        d(EnterModCheckResult enterModCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar, EnterModCheckRequest enterModCheckRequest) {
            this.f331424b = enterModCheckResult;
            this.f331425c = aVar;
            this.f331426d = enterModCheckRequest;
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void a(ZootopiaOpenIdResult result) {
            ModServerChecker.this.u(result, this.f331424b, this.f331425c, this.f331426d, false);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void b(int errCode, String errMsg) {
            ModServerChecker.this.t(errCode, this.f331424b, this.f331425c);
        }

        @Override // com.tencent.mobileqq.zootopia.ipc.ab
        public void c() {
        }
    }
}
