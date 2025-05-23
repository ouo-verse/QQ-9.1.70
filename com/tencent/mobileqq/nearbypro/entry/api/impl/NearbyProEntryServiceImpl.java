package com.tencent.mobileqq.nearbypro.entry.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.lite.IZPlanFilamentSwitch;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/entry/api/impl/NearbyProEntryServiceImpl;", "Lcom/tencent/mobileqq/nearbypro/entry/api/INearbyProEntryService;", "Lcom/tencent/common/config/pad/DeviceType;", "deviceType", "", "isDeviceTypeSupported", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "isShowNearbyProEntry", "<init>", "()V", "Companion", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearbyProEntryServiceImpl implements INearbyProEntryService {

    @NotNull
    private static final String TAG = "NearbyProEntryServiceImpl";

    private final boolean isDeviceTypeSupported(DeviceType deviceType) {
        return true;
    }

    @Override // com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryService
    public boolean isShowNearbyProEntry() {
        boolean z16;
        DeviceType deviceType = PadUtil.a(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(deviceType, "deviceType");
        boolean isDeviceTypeSupported = isDeviceTypeSupported(deviceType);
        boolean enableZPlanFilamentBase = ((IZPlanFilamentSwitch) QRoute.api(IZPlanFilamentSwitch.class)).enableZPlanFilamentBase();
        if (isDeviceTypeSupported && enableZPlanFilamentBase) {
            z16 = true;
        } else {
            z16 = false;
        }
        ga2.a c16 = j.c();
        if (c16.isColorLevel()) {
            c16.e(TAG, "isShowNearbyProEntry: " + z16 + ", deviceType: " + deviceType + ", isDeviceTypeSupported: " + isDeviceTypeSupported + ", isFilamentBaseOn: " + enableZPlanFilamentBase);
        }
        return z16;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
    }
}
