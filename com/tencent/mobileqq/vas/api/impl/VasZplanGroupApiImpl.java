package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.api.IVasZplanGroupApi;
import com.tencent.mobileqq.vas.data.SmallHomeGroupSettingData;
import com.tencent.mobileqq.vas.data.VasTroopSmallHomeInfo;
import com.tencent.mobileqq.vas.group.SmallHomeGroupSettingFragment;
import com.tencent.mobileqq.vas.hippy.api.ZplanVasRankHippyFragment;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.vas.utils.ZplanVasSmallHomeUtils;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi;
import com.tencent.mobileqq.zootopia.api.IZootopiaResidenceAuthApi;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0016H\u0016J$\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\n0\u0016H\u0016J&\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0014\u0010\u0017\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\n0\u0016H\u0016J2\u0010!\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001d2\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\n0\u001fH\u0016J \u0010\"\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001bH\u0016R\u0016\u0010&\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasZplanGroupApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasZplanGroupApi;", "", "isOpenSmallHomeLimit", "Landroid/content/Context;", "context", "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "openHippyInfo", "Lcom/tencent/mobileqq/vas/transit/VisitorInfo;", "visitorInfo", "", "openHippyPageInner", "Lcom/tencent/sqshow/zootopia/mapstatus/MapStatus;", "mapStatus", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "checkResidenceAuth", "handleDownloadStatus", "", "groupId", "Lkotlin/Function1;", "callback", "getSmallHomeNickEntrance", "Lcom/tencent/mobileqq/vas/data/g;", "getSmallHomeTopEntrance", "Lcom/tencent/mobileqq/vas/data/SmallHomeGroupSettingData;", "getSmallHomeGroupSetting", "", "currentState", "Lkotlin/Function2;", "", "setSmallHomeGroupSetting", "openSmallHomeTransitPage", "openHippyRankPage", "data", "openSmallHomeGroupSettingPage", "lastOpenTime", "J", "limitLock", "Z", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasZplanGroupApiImpl implements IVasZplanGroupApi {
    private static final String TAG = "VasZplanGroupApiImpl";
    private long lastOpenTime;
    private boolean limitLock;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f308553a;

        static {
            int[] iArr = new int[MapStatus.values().length];
            try {
                iArr[MapStatus.MAP_STATUS_DOWNLOAD_COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f308553a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkResidenceAuth(final Context context, final MapStatus mapStatus, final TransitPageInfo info, final ZootopiaSource source) {
        QLog.i(TAG, 1, "checkResidenceAuth");
        String uin = info.getMasterInfo().getUin();
        if (uin == null || uin.length() == 0) {
            QLog.e(TAG, 1, "checkResidenceAuth, uin err");
            com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xhl, "empty uin");
        } else {
            ((IZootopiaResidenceAuthApi) QRoute.api(IZootopiaResidenceAuthApi.class)).checkResidenceVisitAuth(uin, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasZplanGroupApiImpl$checkResidenceAuth$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, String str) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                    VasZplanGroupApiImpl.this.limitLock = false;
                    if (z16) {
                        VasZplanGroupApiImpl.this.handleDownloadStatus(context, mapStatus, info, source);
                    } else {
                        ZplanVasSmallHomeUtils.f311238a.j(context, info, source);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDownloadStatus(final Context context, MapStatus mapStatus, final TransitPageInfo info, final ZootopiaSource source) {
        QLog.i(TAG, 1, "handleDownloadStatus");
        String uin = info.getMasterInfo().getUin();
        if (uin == null || uin.length() == 0) {
            QLog.e(TAG, 1, "handleDownloadStatus, uin err");
            com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xhl, "empty uin");
            return;
        }
        if (b.f308553a[mapStatus.ordinal()] == 1) {
            if (info.getConfig().getNeedTransitPageWhenReady() == 1) {
                ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).showSmallHomeTransitPanel(context, info, source);
                return;
            } else {
                ZplanVasSmallHomeUtils.f311238a.c(context, uin, info, source);
                return;
            }
        }
        if (source.getMainSource().getValue() == Source.ProfileEntry.getValue() && Intrinsics.areEqual(source.getSubSource(), "em_zplan_manage_xiaowo")) {
            ((com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class)).T(AdMetricID.Click.SUCCESS, true, source, k33.a.f411513a.a(info.getExtInfo().getUeExtras(), uin), new Function1<EnterModCheckResult, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasZplanGroupApiImpl$handleDownloadStatus$1
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
                public final void invoke2(EnterModCheckResult it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isPassed() || it.getProcessInner()) {
                        return;
                    }
                    ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).showSmallHomeTransitPanel(context, info, source);
                }
            });
        } else {
            ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).showSmallHomeTransitPanel(context, info, source);
        }
    }

    private final boolean isOpenSmallHomeLimit() {
        return this.limitLock || System.currentTimeMillis() - this.lastOpenTime <= 1000;
    }

    private final void openHippyPageInner(Context context, OpenHippyInfo openHippyInfo, VisitorInfo visitorInfo) {
        Bundle bundle = openHippyInfo.toBundle();
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        if (context instanceof FragmentActivity) {
            ZplanVasRankHippyFragment a16 = ZplanVasRankHippyFragment.INSTANCE.a(visitorInfo);
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("params", bundle);
            Bundle arguments = a16.getArguments();
            if (arguments != null) {
                arguments.putAll(bundle2);
            }
            QRouteApi api = QRoute.api(IZootopiaC2CApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaC2CApi::class.java)");
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.supportFragmentManager");
            IZootopiaC2CApi.a.a((IZootopiaC2CApi) api, supportFragmentManager, com.tencent.sqshow.zootopia.utils.i.b(650), a16, false, 8, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanGroupApi
    public void getSmallHomeGroupSetting(long groupId, Function1<? super SmallHomeGroupSettingData, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        z23.d dVar = new z23.d();
        if (appInterface != null) {
            dVar.a(appInterface, groupId, (r12 & 4) != 0 ? 4 : 0, callback);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanGroupApi
    public void getSmallHomeNickEntrance(long groupId, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        z23.d dVar = new z23.d();
        if (appInterface != null) {
            z23.d.d(dVar, appInterface, groupId, 0, callback, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanGroupApi
    public void getSmallHomeTopEntrance(long groupId, Function1<? super VasTroopSmallHomeInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        z23.d dVar = new z23.d();
        if (appInterface != null) {
            z23.d.f(dVar, appInterface, groupId, 0, callback, 4, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanGroupApi
    public void openHippyRankPage(Context context, VisitorInfo visitorInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(visitorInfo, "visitorInfo");
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_ZPLAN_VAS_SMALL_HOME;
        openHippyInfo.framework = "react";
        openHippyInfo.processName = "main";
        openHippyInfo.domain = "vip.qq.com";
        openHippyInfo.fragmentClass = ZplanVasRankHippyFragment.class;
        openHippyInfo.url = com.tencent.mobileqq.vas.hippy.e.f309495a.a(visitorInfo);
        openHippyInfo.updateJsBundleType = 1;
        openHippyInfo.isCustomNightMode = true;
        openHippyPageInner(context, openHippyInfo, visitorInfo);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanGroupApi
    public void openSmallHomeGroupSettingPage(Context context, SmallHomeGroupSettingData data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intent intent = new Intent();
        intent.putExtra("data", data);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, SmallHomeGroupSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanGroupApi
    public void openSmallHomeTransitPage(final Context context, final TransitPageInfo info, final ZootopiaSource source) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        if (QLog.isColorLevel()) {
            str = info.toString();
        } else {
            str = "--";
        }
        QLog.i(TAG, 1, "visitSmallHome, info: " + str);
        IVasZplanApi iVasZplanApi = (IVasZplanApi) QRoute.api(IVasZplanApi.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(200001L);
        iVasZplanApi.addWhiteList(arrayList, "smallHome");
        if (!TransitPageInfo.INSTANCE.a(info)) {
            QLog.e(TAG, 1, "openSmallHomeTransitPage inValidate err");
            com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xhl, "invalidData");
        } else if (isOpenSmallHomeLimit()) {
            QLog.e(TAG, 1, "open small home limit");
            com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xka, "invalidData");
        } else {
            this.limitLock = true;
            this.lastOpenTime = System.currentTimeMillis();
            info.getExtInfo().setSource(source);
            ZplanVasSmallHomeUtils.f311238a.e(context, info, source, new Function2<Boolean, MapStatus, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasZplanGroupApiImpl$openSmallHomeTransitPage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, MapStatus mapStatus) {
                    invoke(bool.booleanValue(), mapStatus);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, MapStatus mapStatus) {
                    Intrinsics.checkNotNullParameter(mapStatus, "mapStatus");
                    if (z16) {
                        VasZplanGroupApiImpl.this.checkResidenceAuth(context, mapStatus, info, source);
                        return;
                    }
                    VasZplanGroupApiImpl.this.limitLock = false;
                    QLog.e("VasZplanGroupApiImpl", 1, "checkResidenceWhiteList result is false");
                    if (mapStatus == MapStatus.MAP_STATUS_INIT) {
                        ZplanVasSmallHomeUtils.f311238a.h(context);
                    } else {
                        ZplanVasSmallHomeUtils.f311238a.f(context, source);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanGroupApi
    public void setSmallHomeGroupSetting(long groupId, int currentState, Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        z23.d dVar = new z23.d();
        if (appInterface != null) {
            z23.d.i(dVar, appInterface, groupId, currentState, 0, callback, 8, null);
        }
    }
}
