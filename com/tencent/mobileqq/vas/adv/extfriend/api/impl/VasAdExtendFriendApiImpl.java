package com.tencent.mobileqq.vas.adv.extfriend.api.impl;

import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.adv.extfriend.api.IVasAdExtendFriendApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/extfriend/api/impl/VasAdExtendFriendApiImpl;", "Lcom/tencent/mobileqq/vas/adv/extfriend/api/IVasAdExtendFriendApi;", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtDeviceInfo", "Lcom/tencent/mobileqq/vas/adv/common/pb/vac_adv_get$VacFeedsAdvMetaReq;", "generateVacFeedsAdvMetaReq", "deviceInfo", "setParamsToDeviceInfo", "getDeviceInfo", "", "initDeviceInfo", "", "getDeviceInfoByteArray", "<init>", "()V", "Companion", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdExtendFriendApiImpl implements IVasAdExtendFriendApi {

    @NotNull
    private static final String MAC = "35e972";

    private final vac_adv_get.VacFeedsAdvMetaReq generateVacFeedsAdvMetaReq(qq_ad_get.QQAdGet.DeviceInfo gdtDeviceInfo) {
        vac_adv_get.VacFeedsAdvMetaReq vacFeedsAdvMetaReq = new vac_adv_get.VacFeedsAdvMetaReq();
        if (gdtDeviceInfo != null) {
            vacFeedsAdvMetaReq.device_info.set(gdtDeviceInfo);
        }
        return vacFeedsAdvMetaReq;
    }

    private final qq_ad_get.QQAdGet.DeviceInfo getDeviceInfo() {
        return VasAdvSupport.INSTANCE.a().getDeviceInfo();
    }

    private final qq_ad_get.QQAdGet.DeviceInfo setParamsToDeviceInfo(qq_ad_get.QQAdGet.DeviceInfo deviceInfo) {
        if (deviceInfo != null) {
            deviceInfo.mac.set(MAC);
            deviceInfo.imei.set(MAC);
            return deviceInfo;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.adv.extfriend.api.IVasAdExtendFriendApi
    @NotNull
    public byte[] getDeviceInfoByteArray() {
        byte[] byteArray = generateVacFeedsAdvMetaReq(setParamsToDeviceInfo(getDeviceInfo())).toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "generateVacFeedsAdvMetaR\u2026DeviceInfo).toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.vas.adv.extfriend.api.IVasAdExtendFriendApi
    public void initDeviceInfo() {
        VasAdvSupport.INSTANCE.a().m();
    }
}
