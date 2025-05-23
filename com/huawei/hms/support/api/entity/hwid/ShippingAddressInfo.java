package com.huawei.hms.support.api.entity.hwid;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hihonor.honorid.core.data.UserInfo;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.hwid.as;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ShippingAddressInfo implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ShippingAddressInfo> CREATOR = new Parcelable.Creator<ShippingAddressInfo>() { // from class: com.huawei.hms.support.api.entity.hwid.ShippingAddressInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShippingAddressInfo createFromParcel(Parcel parcel) {
            return new ShippingAddressInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShippingAddressInfo[] newArray(int i3) {
            return new ShippingAddressInfo[i3];
        }
    };
    private static final String TAG = "ShippingAddressInfo";
    private Integer addressId;
    private Integer addressType;
    private String city;
    private String countryName;
    private Integer defaultAddress;
    private String detailAddress;
    private String district;
    private String firstName;
    private String lastName;
    private String lastUpdateTime;
    private String phoneNumber;
    private String postalCode;
    private String province;
    private LabelInfo selectedLabelInfo;
    private String street;
    private Long userId;

    public ShippingAddressInfo() {
        this.userId = 0L;
        this.addressId = -1;
        this.addressType = 1;
        this.defaultAddress = 0;
        this.province = "";
        this.city = "";
        this.district = "";
        this.street = "";
        this.detailAddress = "";
        this.selectedLabelInfo = new LabelInfo();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Integer getAddressId() {
        return this.addressId;
    }

    public Integer getAddressType() {
        return this.addressType;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public Integer getDefaultAddress() {
        return this.defaultAddress;
    }

    public String getDetailAddress() {
        return this.detailAddress;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getProvince() {
        return this.province;
    }

    public LabelInfo getSelectedLabelInfo() {
        return this.selectedLabelInfo;
    }

    public String getStreet() {
        return this.street;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void parseJson(JSONObject jSONObject) {
        try {
            this.userId = Long.valueOf(jSONObject.getLong("userID"));
            if (jSONObject.has("addressID")) {
                this.addressId = Integer.valueOf(jSONObject.getInt("addressID"));
            }
            this.addressType = Integer.valueOf(jSONObject.getInt("addressType"));
            this.defaultAddress = Integer.valueOf(jSONObject.getInt("defaultAddress"));
            this.firstName = jSONObject.getString(UserInfo.FIRSTNAME);
            if (jSONObject.has(UserInfo.LASTNAME)) {
                this.lastName = jSONObject.getString(UserInfo.LASTNAME);
            }
            if (jSONObject.has(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER)) {
                this.phoneNumber = jSONObject.getString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER);
            }
            this.countryName = jSONObject.getString("country");
            this.province = jSONObject.getString("province");
            this.city = jSONObject.getString("city");
            if (jSONObject.has("district")) {
                this.district = jSONObject.getString("district");
            }
            if (jSONObject.has("street")) {
                this.street = jSONObject.getString("street");
            }
            if (jSONObject.has("detailAddress")) {
                this.detailAddress = jSONObject.getString("detailAddress");
            }
            if (jSONObject.has("postalCode")) {
                this.postalCode = jSONObject.getString("postalCode");
            }
            if (jSONObject.has("label")) {
                if (this.selectedLabelInfo == null) {
                    this.selectedLabelInfo = new LabelInfo();
                }
                this.selectedLabelInfo.setLabelName(jSONObject.getString("label"));
            }
            if (jSONObject.has("labelType")) {
                if (this.selectedLabelInfo == null) {
                    this.selectedLabelInfo = new LabelInfo();
                }
                this.selectedLabelInfo.setLabelType(jSONObject.getInt("labelType"));
            }
            if (jSONObject.has(WadlProxyConsts.LAST_UPDATE_TIME)) {
                this.lastUpdateTime = jSONObject.getString(WadlProxyConsts.LAST_UPDATE_TIME);
            }
        } catch (JSONException unused) {
            as.d(TAG, "parseJson failed", true);
        }
    }

    public void setAddressId(Integer num) {
        this.addressId = num;
    }

    public void setAddressType(Integer num) {
        this.addressType = num;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setDefaultAddress(Integer num) {
        this.defaultAddress = num;
    }

    public void setDetailAddress(String str) {
        this.detailAddress = str;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setLastUpdateTime(String str) {
        this.lastUpdateTime = str;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public void setPostalCode(String str) {
        this.postalCode = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setSelectedLabelInfo(LabelInfo labelInfo) {
        this.selectedLabelInfo = labelInfo;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public void setUserId(Long l3) {
        this.userId = l3;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userID", this.userId);
            jSONObject.put("addressID", this.addressId);
            jSONObject.put("addressType", this.addressType);
            jSONObject.put("defaultAddress", this.defaultAddress);
            jSONObject.put(UserInfo.FIRSTNAME, this.firstName);
            jSONObject.put(UserInfo.LASTNAME, this.lastName);
            jSONObject.put(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, this.phoneNumber);
            jSONObject.put("country", this.countryName);
            jSONObject.put("province", this.province);
            jSONObject.put("city", this.city);
            jSONObject.put("district", this.district);
            jSONObject.put("street", this.street);
            jSONObject.put("detailAddress", this.detailAddress);
            jSONObject.put("postalCode", this.postalCode);
            LabelInfo labelInfo = this.selectedLabelInfo;
            if (labelInfo != null && -1 != labelInfo.getLabelType() && !TextUtils.isEmpty(this.selectedLabelInfo.getLabelName())) {
                jSONObject.put("label", this.selectedLabelInfo.getLabelName());
                jSONObject.put("labelType", this.selectedLabelInfo.getLabelType());
            }
            jSONObject.put(WadlProxyConsts.LAST_UPDATE_TIME, this.lastUpdateTime);
        } catch (JSONException unused) {
            as.d(TAG, "toJson failed", true);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.userId.longValue());
        parcel.writeInt(this.addressId.intValue());
        parcel.writeInt(this.addressType.intValue());
        parcel.writeInt(this.defaultAddress.intValue());
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.phoneNumber);
        parcel.writeString(this.countryName);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.district);
        parcel.writeString(this.street);
        parcel.writeString(this.detailAddress);
        parcel.writeString(this.postalCode);
        parcel.writeString(this.lastUpdateTime);
        parcel.writeParcelable(this.selectedLabelInfo, i3);
    }

    protected ShippingAddressInfo(Parcel parcel) {
        this.userId = 0L;
        this.addressId = -1;
        this.addressType = 1;
        this.defaultAddress = 0;
        this.province = "";
        this.city = "";
        this.district = "";
        this.street = "";
        this.detailAddress = "";
        this.selectedLabelInfo = new LabelInfo();
        this.userId = Long.valueOf(parcel.readLong());
        this.addressId = Integer.valueOf(parcel.readInt());
        this.addressType = Integer.valueOf(parcel.readInt());
        this.defaultAddress = Integer.valueOf(parcel.readInt());
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.phoneNumber = parcel.readString();
        this.countryName = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.district = parcel.readString();
        this.street = parcel.readString();
        this.detailAddress = parcel.readString();
        this.postalCode = parcel.readString();
        this.lastUpdateTime = parcel.readString();
        this.selectedLabelInfo = (LabelInfo) parcel.readParcelable(LabelInfo.class.getClassLoader());
    }
}
