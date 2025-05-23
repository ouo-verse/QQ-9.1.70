package com.tencent.ecommerce.biz.orders.address;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_delivery_address.ECDeliveryAddress$Address;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\f\u0010\u0006\u001a\u00020\u0000*\u00020\u0005H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\u0000H\u0000\"\u0017\u0010\u000b\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "", "a", "Lorg/json/JSONObject;", "d", "Lcom/tencent/ecommerce/repo/proto/ecom/common_qshop_common_delivery_address/ECDeliveryAddress$Address;", "c", "e", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "b", "()Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "EMPTY_ADDRESS", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final ECAddress f103046a = new ECAddress(0, "", "", "", "", "", "", "", null, false, null, 1281, null);

    public static final String a(ECAddress eCAddress) {
        return eCAddress.province + eCAddress.city + eCAddress.district + eCAddress.street + eCAddress.detailAddress;
    }

    public static final ECAddress b() {
        return f103046a;
    }

    public static final ECAddress c(ECDeliveryAddress$Address eCDeliveryAddress$Address) {
        return new ECAddress(eCDeliveryAddress$Address.f105230id.get(), eCDeliveryAddress$Address.province.get(), eCDeliveryAddress$Address.city.get(), eCDeliveryAddress$Address.district.get(), eCDeliveryAddress$Address.street.get(), eCDeliveryAddress$Address.detail_address.get(), eCDeliveryAddress$Address.name.get(), eCDeliveryAddress$Address.mobile.get(), eCDeliveryAddress$Address.masked_mobile.get(), eCDeliveryAddress$Address.is_default.get() == 1, eCDeliveryAddress$Address.label.get());
    }

    public static final JSONObject d(ECAddress eCAddress) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", eCAddress.id);
        jSONObject.put("province", eCAddress.province);
        jSONObject.put("city", eCAddress.city);
        jSONObject.put("district", eCAddress.district);
        jSONObject.put("street", eCAddress.street);
        jSONObject.put("detail_address", eCAddress.detailAddress);
        jSONObject.put("name", eCAddress.consignee);
        jSONObject.put(DeviceType.DeviceCategory.MOBILE, eCAddress.phoneNumber);
        jSONObject.put("masked_mobile", eCAddress.maskedPhoneNumber);
        jSONObject.put("is_default", eCAddress.isDefaultAddress ? 1 : 0);
        jSONObject.put("label", eCAddress.label);
        return jSONObject;
    }

    public static final ECDeliveryAddress$Address e(ECAddress eCAddress) {
        ECDeliveryAddress$Address eCDeliveryAddress$Address = new ECDeliveryAddress$Address();
        eCDeliveryAddress$Address.f105230id.set(eCAddress.id);
        eCDeliveryAddress$Address.province.set(eCAddress.province);
        eCDeliveryAddress$Address.city.set(eCAddress.city);
        eCDeliveryAddress$Address.district.set(eCAddress.district);
        eCDeliveryAddress$Address.street.set(eCAddress.street);
        eCDeliveryAddress$Address.detail_address.set(eCAddress.detailAddress);
        eCDeliveryAddress$Address.name.set(eCAddress.consignee);
        eCDeliveryAddress$Address.mobile.set(eCAddress.phoneNumber);
        eCDeliveryAddress$Address.masked_mobile.set(eCAddress.maskedPhoneNumber);
        eCDeliveryAddress$Address.is_default.set(eCAddress.isDefaultAddress ? 1 : 0);
        eCDeliveryAddress$Address.label.set(eCAddress.label);
        return eCDeliveryAddress$Address;
    }
}
