package com.tencent.mobileqq.zplan.authorize.api;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment;
import com.tencent.mobileqq.zplan.mod.impl.ModEnterIPCImpl;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J>\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/api/CheckResultDefaultProcessor;", "", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "it", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "checkResult", "", "f", "", "mapId", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "e", "b", "ueParams", "c", "errorCode", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CheckResultDefaultProcessor {

    /* renamed from: a, reason: collision with root package name */
    public static final CheckResultDefaultProcessor f331386a = new CheckResultDefaultProcessor();

    CheckResultDefaultProcessor() {
    }

    private final boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100335", true);
    }

    private final boolean f(ZootopiaEnterParams it, EnterModCheckResult checkResult) {
        Bundle bundle = new Bundle();
        com.tencent.sqshow.zootopia.report.b.INSTANCE.c(bundle);
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("zplan_mod_start_up_skip_engine", true);
        QLog.i("CheckResultHelper", 1, "skipStartEngine:" + isSwitchOn);
        if (!isSwitchOn) {
            return false;
        }
        QLog.i(ModEnterIPCImpl.TAG, 1, "use new loading,start activity");
        ZootopiaUEActivity.Companion companion = ZootopiaUEActivity.INSTANCE;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        companion.b(context, it, checkResult.getSource(), bundle);
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0024. Please report as an issue. */
    public final boolean c(final EnterModCheckResult checkResult, final Map<String, ? extends Object> pageParams, Map<String, ? extends Object> ueParams) {
        Object obj;
        ZootopiaEnterParams enterParamsAfterCheck;
        Intrinsics.checkNotNullParameter(checkResult, "checkResult");
        if (!checkResult.isPassed() && !checkResult.getProcessInner()) {
            int resultCode = checkResult.getResultCode();
            if (resultCode != 5) {
                if (resultCode != 9) {
                    switch (resultCode) {
                        case 15:
                            break;
                        default:
                            switch (resultCode) {
                                case 22:
                                    break;
                                case 23:
                                    if (checkResult.getCloudServerStatus() == 2 && (enterParamsAfterCheck = checkResult.getEnterParamsAfterCheck()) != null) {
                                        return f331386a.e(enterParamsAfterCheck.getMapId(), checkResult, pageParams);
                                    }
                                    return false;
                                case 24:
                                case 26:
                                case 27:
                                case 28:
                                    ZootopiaEnterParams enterParamsAfterCheck2 = checkResult.getEnterParamsAfterCheck();
                                    if (enterParamsAfterCheck2 != null) {
                                        return f331386a.e(enterParamsAfterCheck2.getMapId(), checkResult, pageParams);
                                    }
                                    return false;
                                case 25:
                                    break;
                                default:
                                    return false;
                            }
                        case 16:
                        case 17:
                            final ZootopiaEnterParams enterParamsAfterCheck3 = checkResult.getEnterParamsAfterCheck();
                            if (enterParamsAfterCheck3 != null) {
                                Object obj2 = pageParams != null ? pageParams.get("openCloudWhenNotReady") : null;
                                Boolean bool = obj2 instanceof Boolean ? (Boolean) obj2 : null;
                                Object obj3 = pageParams != null ? pageParams.get("needServerFullCheck") : null;
                                Boolean bool2 = obj3 instanceof Boolean ? (Boolean) obj3 : null;
                                if (bool == null) {
                                    bool = Boolean.valueOf(f331386a.b());
                                }
                                QLog.i("CheckResultHelper", 1, "processModCheckResult 1 openCloudWhenNotReady=" + bool + " needServerFullCheck=" + bool2);
                                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                                    HashMap hashMap = new HashMap();
                                    if (ueParams != null) {
                                        hashMap.putAll(ueParams);
                                    }
                                    if (pageParams != null && (obj = pageParams.get("serverExtraInfo")) != null) {
                                        hashMap.put("serverExtraInfo", obj);
                                    }
                                    ((com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class)).T(enterParamsAfterCheck3.getMapId(), !Intrinsics.areEqual(bool2, Boolean.FALSE), checkResult.getSource(), hashMap, new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.api.CheckResultDefaultProcessor$processModCheckResult$1$3
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(EnterModCheckResult enterModCheckResult) {
                                            invoke2(enterModCheckResult);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(EnterModCheckResult cloudCheckResult) {
                                            Intrinsics.checkNotNullParameter(cloudCheckResult, "cloudCheckResult");
                                            if (cloudCheckResult.isPassed()) {
                                                return;
                                            }
                                            CheckResultDefaultProcessor.f331386a.e(ZootopiaEnterParams.this.getMapId(), checkResult, pageParams);
                                        }
                                    });
                                    return true;
                                }
                                if (checkResult.getResultCode() == 25) {
                                    CheckResultDefaultProcessor checkResultDefaultProcessor = f331386a;
                                    if (!checkResultDefaultProcessor.f(enterParamsAfterCheck3, checkResult)) {
                                        return checkResultDefaultProcessor.e(enterParamsAfterCheck3.getMapId(), checkResult, pageParams);
                                    }
                                } else {
                                    return f331386a.e(enterParamsAfterCheck3.getMapId(), checkResult, pageParams);
                                }
                            }
                            return false;
                    }
                }
                CommonExKt.m("\u4e50\u56ed\u8fdb\u5165\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5" + checkResult.getResultCode());
                return true;
            }
            ZootopiaEnterParams enterParamsAfterCheck4 = checkResult.getEnterParamsAfterCheck();
            if (enterParamsAfterCheck4 != null) {
                return f331386a.e(enterParamsAfterCheck4.getMapId(), checkResult, pageParams);
            }
            return false;
        }
        QLog.i("CheckResultHelper", 1, "processModCheckResult do not need handle");
        return false;
    }

    public final int d(int errorCode) {
        if (errorCode != 0) {
            if (errorCode != 2) {
                if (errorCode != 4) {
                    if (errorCode == 5) {
                        return 2;
                    }
                    if (errorCode == 6) {
                        return 6;
                    }
                    switch (errorCode) {
                        case 11:
                            return 13;
                        case 12:
                            return 12;
                        case 13:
                        case 14:
                        case 15:
                            return 4;
                        case 16:
                            return 9;
                        case 17:
                            return 10;
                        case 18:
                            return 5;
                        default:
                            return -1;
                    }
                }
                return 3;
            }
            return 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(int mapId, EnterModCheckResult checkResult, Map<String, ? extends Object> pageParams) {
        boolean isBlank;
        Object obj = pageParams != null ? pageParams.get("openDetailNotReady") : null;
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (!(bool != null ? bool.booleanValue() : true)) {
            QLog.i("CheckResultHelper", 1, "tryOpenDetailPageWhenMapNotReady not set");
            return false;
        }
        Object obj2 = pageParams != null ? pageParams.get("openDetailType") : null;
        Integer num = obj2 instanceof Integer ? (Integer) obj2 : null;
        if ((num != null ? num.intValue() : 0) == 1) {
            QLog.i("CheckResultHelper", 1, "openDetailType == ZootopiaConstants.VALUE_CENTER_PAGE");
            Object obj3 = pageParams != null ? pageParams.get("openDetailScheme") : null;
            String str = obj3 instanceof String ? (String) obj3 : null;
            if (str == null) {
                str = "";
            }
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (isBlank) {
                str = "mqqapi://hippy/open?bundleName=QQSmallHouseCenter&domain=vip.qq.com&isAnimated=true&pathPluginType=3&url=https%3A%2F%2Ftq-act.vip.qq.com%2Findex.bundle%2Fhippyurl%3D%252F%253Fparams%253DZnJvbT1lbV96cGxhbl9lbnRyYW5jZV9jcmVhdGVfYXZhdGFyJmZyb21DcmVhdGVSb2xlPXRydWU%3D";
            }
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            iSchemeApi.launchScheme(context, str);
            return true;
        }
        Object obj4 = pageParams != null ? pageParams.get(FavEmoConstant.ROAMING_TYPE_PANEL) : null;
        Boolean bool2 = obj4 instanceof Boolean ? (Boolean) obj4 : null;
        ZootopiaSource source = checkResult.getSource();
        Bundle bundle = new Bundle();
        bundle.putInt("mapId", mapId);
        bundle.putSerializable("detail_config", new ZootopiaDetailFragment.Config(0, false, false, bool2 != null ? bool2.booleanValue() : true, null, null, false, null, 247, null));
        QLog.i("CheckResultHelper", 1, "gotoMapDetail needDownload=" + bool2 + " source=" + source);
        IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
        BaseApplication context2 = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext()");
        iEntryApi.startDetailFragment(context2, source, bundle);
        return true;
    }
}
