package com.tencent.midas.api.request;

import java.io.Serializable;

/* loaded from: classes9.dex */
public abstract class APMidasBaseRequest implements Serializable {
    public static final int MALL_TYPE_DEFAULT = 0;
    public static final int MALL_TYPE_GROUPBUY = 1;
    public static final int MALL_TYPE_VMALL = 2;
    private static final long serialVersionUID = -9123623786877679280L;
    public byte[] resData;
    public String reserv;
    public String returnUrl;
    public String offerId = "";
    public String openId = "";
    public String openKey = "";
    public String sessionId = "";
    public String sessionType = "";
    public String zoneId = "";

    /* renamed from: pf, reason: collision with root package name */
    public String f151589pf = "";
    public String pfKey = "";
    public int resId = 0;
    public String acctType = "common";
    public String saveValue = "";
    public boolean isCanChange = true;
    public int mallType = 0;
    public String h5Url = "";
    public String remark = "";
    public APMidasMPInfo mpInfo = new APMidasMPInfo();
    public APMidasExtendInfo extendInfo = new APMidasExtendInfo();
    public String mobileInfo = "";
    public String mobileInfoLen = "";

    /* loaded from: classes9.dex */
    public class APMidasExtendInfo implements Serializable {
        private static final long serialVersionUID = -5387967973327966068L;
        public String unit = "";
        public boolean isShowNum = true;
        public boolean isShowListOtherNum = true;
        public boolean isHidePrice = false;
        public String ecOfferId = null;
        public String ecSubOfferId = null;
        public String contractDomain = null;
        public String contractMethod = null;
        public String wxAppId = null;

        public APMidasExtendInfo() {
        }
    }

    /* loaded from: classes9.dex */
    public class APMidasMPInfo implements Serializable {
        private static final long serialVersionUID = 631101753621041424L;
        public String payChannel = "";
        public String discountType = "";
        public String discountUrl = "";
        public String drmInfo = "";
        public String discoutId = "";
        public String extras = "";

        public APMidasMPInfo() {
        }
    }

    public String getAcctType() {
        return this.acctType;
    }

    public String getContractDomain() {
        return this.extendInfo.contractDomain;
    }

    public String getContractMethod() {
        return this.extendInfo.contractMethod;
    }

    public String getDiscountType() {
        return this.mpInfo.discountType;
    }

    public String getDiscountUrl() {
        return this.mpInfo.discountUrl;
    }

    public String getDiscoutId() {
        return this.mpInfo.discoutId;
    }

    public String getDrmInfo() {
        return this.mpInfo.drmInfo;
    }

    public String getEcOfferId() {
        return this.extendInfo.ecOfferId;
    }

    public String getEcSubOfferId() {
        return this.extendInfo.ecSubOfferId;
    }

    public String getExtras() {
        return this.mpInfo.extras;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public boolean getHidePrice() {
        return this.extendInfo.isHidePrice;
    }

    public boolean getIsCanChange() {
        return this.isCanChange;
    }

    public int getMallType() {
        return this.mallType;
    }

    public String getMobileInfo() {
        return this.mobileInfo;
    }

    public String getMobileInfoLen() {
        return this.mobileInfoLen;
    }

    public String getOfferId() {
        return this.offerId;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getOpenKey() {
        return this.openKey;
    }

    public String getPayChannel() {
        return this.mpInfo.payChannel;
    }

    public String getPf() {
        return this.f151589pf;
    }

    public String getPfKey() {
        return this.pfKey;
    }

    public String getRemark() {
        return this.remark;
    }

    public byte[] getResData() {
        return this.resData;
    }

    public int getResId() {
        return this.resId;
    }

    public String getReserv() {
        return this.reserv;
    }

    public String getReturnUrl() {
        return this.returnUrl;
    }

    public String getSaveValue() {
        return this.saveValue;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSessionType() {
        return this.sessionType;
    }

    public boolean getShowListOtherNum() {
        return this.extendInfo.isShowListOtherNum;
    }

    public boolean getShowNum() {
        return this.extendInfo.isShowNum;
    }

    public String getUnit() {
        return this.extendInfo.unit;
    }

    public String getWxAppId() {
        return this.extendInfo.wxAppId;
    }

    public String getZoneId() {
        return this.zoneId;
    }

    public void setAcctType(String str) {
        this.acctType = str;
    }

    public void setContractDomain(String str) {
        this.extendInfo.contractDomain = str;
    }

    public void setContractMethod(String str) {
        this.extendInfo.contractMethod = str;
    }

    public void setDiscountType(String str) {
        this.mpInfo.discountType = str;
    }

    public void setDiscountUrl(String str) {
        this.mpInfo.discountUrl = str;
    }

    public void setDiscoutId(String str) {
        this.mpInfo.discoutId = str;
    }

    public void setDrmInfo(String str) {
        this.mpInfo.drmInfo = str;
    }

    public void setEcOfferId(String str) {
        this.extendInfo.ecOfferId = str;
    }

    public void setEcSubOfferId(String str) {
        this.extendInfo.ecSubOfferId = str;
    }

    public void setExtras(String str) {
        this.mpInfo.extras = str;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public void setHidePrice(boolean z16) {
        this.extendInfo.isHidePrice = z16;
    }

    public void setIsCanChange(boolean z16) {
        this.isCanChange = z16;
    }

    public void setMallType(int i3) {
        this.mallType = i3;
    }

    public void setMobileInfo(String str) {
        this.mobileInfo = str;
    }

    public void setMobileInfoLen(String str) {
        this.mobileInfoLen = str;
    }

    public void setOfferId(String str) {
        this.offerId = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public void setOpenKey(String str) {
        this.openKey = str;
    }

    public void setPayChannel(String str) {
        this.mpInfo.payChannel = str;
    }

    public void setPf(String str) {
        this.f151589pf = str;
    }

    public void setPfKey(String str) {
        this.pfKey = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setResData(byte[] bArr) {
        this.resData = bArr;
    }

    public void setResId(int i3) {
        this.resId = i3;
    }

    public void setReserv(String str) {
        this.reserv = str;
    }

    public void setReturnUrl(String str) {
        this.returnUrl = str;
    }

    public void setSaveValue(String str) {
        this.saveValue = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSessionType(String str) {
        this.sessionType = str;
    }

    public void setShowListOtherNum(boolean z16) {
        this.extendInfo.isShowListOtherNum = z16;
    }

    public void setShowNum(boolean z16) {
        this.extendInfo.isShowNum = z16;
    }

    public void setUnit(String str) {
        this.extendInfo.unit = str;
    }

    public void setWxAppId(String str) {
        this.extendInfo.wxAppId = str;
    }

    public void setZoneId(String str) {
        this.zoneId = str;
    }
}
