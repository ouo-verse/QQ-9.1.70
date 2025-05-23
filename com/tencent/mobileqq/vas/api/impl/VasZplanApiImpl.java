package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.basescene.ZplanSmallHomeTransitFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mobileqq.vas.aio.VasZplanAIOConfigControl;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.group.ZplanVasSmallHomeGroupFragment;
import com.tencent.mobileqq.vas.transit.SmallHomeTransitFragment;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.model.AddWhiteListResponse;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u0019\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u001e\u0010\u001c\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasZplanApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasZplanApi;", "Lcom/tencent/mobileqq/zplan/utils/api/IZPlanAccessibleHelper;", Const.BUNDLE_KEY_REQUEST, "", "uin", "", "appIds", "", "scene", "", "requestAddWhiteList", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "openDemoFragment", "Lq03/c;", "getConfig", "Lq03/f;", "getWoTransitPageConfig", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "showSmallHomeTransitPanel", "Lcom/tencent/mobileqq/vas/aio/a;", "getAIOSmallHomeControl", "addWhiteList", "", "getDebugSsoId", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasZplanApiImpl implements IVasZplanApi {
    private static final String TAG = "VasZplanApiImpl";

    private final void requestAddWhiteList(IZPlanAccessibleHelper request, long uin, List<Long> appIds, String scene) {
        request.addZPlanWhiteList(uin, appIds, scene, new b(uin, appIds));
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanApi
    public void addWhiteList(List<Long> appIds, String scene) {
        Intrinsics.checkNotNullParameter(appIds, "appIds");
        Intrinsics.checkNotNullParameter(scene, "scene");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Long valueOf = peekAppRuntime != null ? Long.valueOf(peekAppRuntime.getLongAccountUin()) : null;
        if (valueOf == null) {
            QLog.e(TAG, 1, "addWhiteList uin is null");
            return;
        }
        QRouteApi api = QRoute.api(IZPlanAccessibleHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanAccessibleHelper::class.java)");
        IZPlanAccessibleHelper iZPlanAccessibleHelper = (IZPlanAccessibleHelper) api;
        Iterator<Long> it = appIds.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            z16 = z16 && iZPlanAccessibleHelper.isZPlanAccessible(it.next().longValue(), valueOf.longValue());
            if (!z16) {
                break;
            }
        }
        if (z16) {
            QLog.i(TAG, 1, "addWhiteList all appIds already in whiteList");
        } else {
            requestAddWhiteList(iZPlanAccessibleHelper, valueOf.longValue(), appIds, scene);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanApi
    public com.tencent.mobileqq.vas.aio.a getAIOSmallHomeControl() {
        return VasZplanAIOConfigControl.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanApi
    public q03.c getConfig() {
        return q03.i.f428160a;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanApi
    public int getDebugSsoId() {
        SSODebugUtil.isTestEnv();
        QLog.w(TAG, 1, "is not debug");
        return 0;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanApi
    public q03.f getWoTransitPageConfig() {
        return q03.i.f428160a.h();
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanApi
    public void openDemoFragment(Context context, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.vas.api.IVasZplanApi
    public void showSmallHomeTransitPanel(Context context, TransitPageInfo info, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i(TAG, 1, "showSmallHomeTransitPanel");
        if (!TransitPageInfo.INSTANCE.a(info)) {
            com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xhl, "invalid pageInfo");
            QLog.e(TAG, 1, "invalid pageInfo");
            return;
        }
        Source mainSource = source.getMainSource();
        if (mainSource != Source.AIOEntry && mainSource != Source.ProfileEntry && mainSource != Source.DynamicEntry && mainSource != Source.LebaEntry) {
            if (info.getConfig().getSinglePageMode()) {
                if (info.getConfig().getUiStyle() == 1) {
                    ZplanVasSmallHomeGroupFragment.INSTANCE.b(context, info, source);
                    return;
                } else {
                    SmallHomeTransitFragment.INSTANCE.a(context, info, null, source);
                    return;
                }
            }
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity == null) {
                QLog.e(TAG, 1, "showSmallHomeTransitPanel, context err");
                com.tencent.sqshow.zootopia.utils.v.f373305a.c(R.string.xhl, "context");
                return;
            }
            ZplanVasSmallHomeGroupFragment a16 = ZplanVasSmallHomeGroupFragment.INSTANCE.a(info, source);
            QRouteApi api = QRoute.api(IZootopiaC2CApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaC2CApi::class.java)");
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
            IZootopiaC2CApi.a.a((IZootopiaC2CApi) api, supportFragmentManager, com.tencent.sqshow.zootopia.utils.i.b(400), a16, false, 8, null);
            return;
        }
        QLog.i(TAG, 1, "showSmallHomeTransitPanel for base scene");
        ZplanSmallHomeTransitFragment.INSTANCE.a(context, info, source);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasZplanApiImpl$b", "Lnk3/c;", "Lcom/tencent/mobileqq/zplan/model/a;", NotificationCompat.CATEGORY_ERROR, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements nk3.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f308551a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List<Long> f308552b;

        b(long j3, List<Long> list) {
            this.f308551a = j3;
            this.f308552b = list;
        }

        @Override // nk3.c
        public void a(AddWhiteListResponse err) {
            if (QLog.isColorLevel()) {
                QLog.i(VasZplanApiImpl.TAG, 1, "addZPlanWhiteList uin=" + this.f308551a + " appIds=" + this.f308552b + " " + err);
            }
            boolean z16 = false;
            if (err != null && err.getErrCode() == 0) {
                z16 = true;
            }
            if (z16) {
                Iterator<Long> it = this.f308552b.iterator();
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    com.tencent.mobileqq.zplan.utils.af afVar = com.tencent.mobileqq.zplan.utils.af.f335758a;
                    AccessibleDetail b16 = afVar.b(this.f308551a, longValue);
                    if (b16 == null) {
                        QLog.i(VasZplanApiImpl.TAG, 1, "requestAddWhiteList uin=" + this.f308551a + " appId=" + longValue + " oldCache == null");
                    } else {
                        com.tencent.mobileqq.zplan.utils.af.h(afVar, this.f308551a, new AccessibleDetail(b16.getAppid(), b16.getAppidExist(), b16.getPhonePass(), 1, b16.getAppidExist() & b16.getPhonePass() & b16.getSwitchPass() & b16.settingPass, b16.getSwitchPass(), b16.getEntranceType(), b16.settingPass), false, 4, null);
                    }
                }
            }
        }
    }
}
