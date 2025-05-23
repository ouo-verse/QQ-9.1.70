package com.tencent.mobileqq.zplan.utils.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.utils.api.IZPlanFilamentCrashUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ6\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/impl/ZPlanFilamentCrashUtilImpl;", "Lcom/tencent/mobileqq/zplan/utils/api/IZPlanFilamentCrashUtil;", "", "crashType", "crashAddress", "crashStack", "", "nativeSICODE", "", "crashTime", "", "handleNativeCrash", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFilamentCrashUtilImpl implements IZPlanFilamentCrashUtil {
    public static final String TAG = "ZPlanFilamentCrashUtilImpl";

    @Override // com.tencent.mobileqq.zplan.utils.api.IZPlanFilamentCrashUtil
    public void handleNativeCrash(String crashType, String crashAddress, String crashStack, int nativeSICODE, long crashTime) {
        QLog.e(TAG, 1, "crash: crashType: " + crashType + ", nativeSICODE: " + nativeSICODE + ", crashTime: " + crashTime + ", crashAddress: " + crashAddress + ", crashStack: " + crashStack);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("filament_native_crash", true);
    }
}
