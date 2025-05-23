package com.qzone.personalize.model;

import NS_QMALL_COVER.BannerStyleConf;
import NS_QMALL_COVER.QzmallCustomBanner;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CustomBannerFeeData implements SmartParcelable {

    @NeedParcel
    public int iBannerConfType;

    @NeedParcel
    public int iBannerType;

    @NeedParcel
    public String strBannerUrl;

    @NeedParcel
    public String strButtonText;

    @NeedParcel
    public String strIconUrl;

    @NeedParcel
    public String strJumpUrl;

    @NeedParcel
    public String strText;

    @NeedParcel
    public String strTraceInfo;

    public CustomBannerFeeData() {
        this.iBannerType = 0;
        this.strBannerUrl = "";
        this.strJumpUrl = "";
        this.iBannerConfType = 0;
        this.strIconUrl = "";
        this.strText = "";
        this.strButtonText = "";
        this.strTraceInfo = "";
    }

    public static CustomBannerFeeData createFromJce(QzmallCustomBanner qzmallCustomBanner) {
        if (qzmallCustomBanner == null) {
            return null;
        }
        CustomBannerFeeData customBannerFeeData = new CustomBannerFeeData();
        customBannerFeeData.iBannerType = qzmallCustomBanner.iBannerType;
        customBannerFeeData.strBannerUrl = qzmallCustomBanner.strBannerUrl;
        customBannerFeeData.strJumpUrl = qzmallCustomBanner.strJumpUrl;
        customBannerFeeData.iBannerConfType = qzmallCustomBanner.iBannerConfType;
        BannerStyleConf bannerStyleConf = qzmallCustomBanner.stBannerStyle;
        if (bannerStyleConf != null) {
            customBannerFeeData.strIconUrl = bannerStyleConf.strIconUrl;
            customBannerFeeData.strText = bannerStyleConf.strText;
            customBannerFeeData.strButtonText = bannerStyleConf.strButtonText;
        }
        customBannerFeeData.strTraceInfo = qzmallCustomBanner.strQbossTraceinfo;
        return customBannerFeeData;
    }

    public CustomBannerFeeData(int i3, String str, String str2) {
        this.iBannerConfType = 0;
        this.strIconUrl = "";
        this.strText = "";
        this.strButtonText = "";
        this.strTraceInfo = "";
        this.iBannerType = i3;
        this.strBannerUrl = str;
        this.strJumpUrl = str2;
    }
}
