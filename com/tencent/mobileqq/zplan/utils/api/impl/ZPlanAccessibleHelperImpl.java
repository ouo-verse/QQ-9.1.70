package com.tencent.mobileqq.zplan.utils.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.servlet.e;
import com.tencent.mobileqq.zplan.servlet.o;
import com.tencent.mobileqq.zplan.utils.ZPlanSmallHomeCache;
import com.tencent.mobileqq.zplan.utils.af;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk3.c;
import nk3.m;
import uk3.g;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010\u000b\u001a\u00020\n2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J0\u0010\u0019\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0012\u0010\u001e\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0010H\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0010H\u0016J\u0018\u0010\"\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020#H\u0016J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000eH\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/impl/ZPlanAccessibleHelperImpl;", "Lcom/tencent/mobileqq/zplan/utils/api/IZPlanAccessibleHelper;", "", "isZPlanEnable", "", "", "uins", "appids", "Lnk3/m;", "callback", "", "getZPlanWhiteListFromNet", "scene", "uin", "", "getZplanAccessible", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "getZplanAccessibleDetail", "getZplanAccessibleDetailFromCacheOnly", "isZPlanAccessible", "", "appIds", "", "fromScene", "Lnk3/c;", "addZPlanWhiteList", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "forceUpload", "uploadPhoneType", "refreshAccessibleRegularly", "updateAllSceneAccessible", "detailResult", "updateCache", "isZplanAccessibleWithoutSetting", "Lnk3/o;", "getZplanSmallHomeAccessible", "enableZPlanNativeAppFilament", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanAccessibleHelperImpl implements IZPlanAccessibleHelper {
    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public void addZPlanWhiteList(long uin, List<Long> appIds, String fromScene, c callback) {
        Intrinsics.checkNotNullParameter(appIds, "appIds");
        Intrinsics.checkNotNullParameter(fromScene, "fromScene");
        e.f335403a.b(uin, appIds, fromScene, callback);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public boolean enableZPlanNativeAppFilament(int scene) {
        return com.tencent.mobileqq.zplan.lite.util.e.f333809a.n(scene);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public void getZPlanWhiteListFromNet(List<Long> uins, List<Long> appids, m callback) {
        Intrinsics.checkNotNullParameter(uins, "uins");
        Intrinsics.checkNotNullParameter(appids, "appids");
        o.f335425a.e(uins, appids, callback);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public int getZplanAccessible(long scene, long uin) {
        return af.f335758a.f(scene, uin);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public AccessibleDetail getZplanAccessibleDetail(long scene, long uin) {
        return g.f439121a.g(scene, uin);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public AccessibleDetail getZplanAccessibleDetailFromCacheOnly(long scene, long uin) {
        return g.f439121a.h(scene, uin);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public void getZplanSmallHomeAccessible(long uin, nk3.o callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZPlanSmallHomeCache.f335745a.f(uin, callback);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public boolean isZPlanAccessible(long scene, long uin) {
        return af.f335758a.e(scene, uin);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public boolean isZPlanEnable() {
        return g.f439121a.i();
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public boolean isZplanAccessibleWithoutSetting(long scene, long uin) {
        return g.f439121a.j(scene, uin);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public void refreshAccessibleRegularly(AppInterface appRuntime) {
        g.f439121a.k(appRuntime);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public void updateAllSceneAccessible(AppInterface appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        g.f439121a.m(appRuntime);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public void updateCache(AccessibleDetail detailResult) {
        Intrinsics.checkNotNullParameter(detailResult, "detailResult");
        g.f439121a.o(detailResult);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public void uploadPhoneType(AppInterface appRuntime, boolean forceUpload) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        g.f439121a.p(appRuntime, forceUpload);
    }

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper
    public void updateCache(long uin, AccessibleDetail detailResult) {
        Intrinsics.checkNotNullParameter(detailResult, "detailResult");
        g.f439121a.n(uin, detailResult);
    }
}
