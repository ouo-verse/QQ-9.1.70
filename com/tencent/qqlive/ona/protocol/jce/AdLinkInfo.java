package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdLinkInfo extends JceStruct {
    public AdCustomActionButtonInfo actionButtonInfo;
    public int bannerDisplayTime;
    public int bannerShowTime;
    public String buttonTitle;
    public boolean enableFullBannerClick;
    public String fullScreenSubTitle;
    public String imageUrl;
    public boolean isBannerValid;
    public boolean isValid;
    public AdRewardGuideInfo rewardGuideInfo;
    public float startCount;
    public String subTitle;
    public AdTimeLineBannerInfo timeLineBannerInfo;
    public String title;
    static AdCustomActionButtonInfo cache_actionButtonInfo = new AdCustomActionButtonInfo();
    static AdTimeLineBannerInfo cache_timeLineBannerInfo = new AdTimeLineBannerInfo();
    static AdRewardGuideInfo cache_rewardGuideInfo = new AdRewardGuideInfo();

    public AdLinkInfo() {
        this.isValid = false;
        this.imageUrl = "";
        this.title = "";
        this.subTitle = "";
        this.startCount = 0.0f;
        this.buttonTitle = "";
        this.isBannerValid = false;
        this.bannerShowTime = 0;
        this.fullScreenSubTitle = "";
        this.enableFullBannerClick = true;
        this.bannerDisplayTime = 0;
        this.actionButtonInfo = null;
        this.timeLineBannerInfo = null;
        this.rewardGuideInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.isValid = jceInputStream.read(this.isValid, 0, false);
        this.imageUrl = jceInputStream.readString(1, false);
        this.title = jceInputStream.readString(2, false);
        this.subTitle = jceInputStream.readString(3, false);
        this.startCount = jceInputStream.read(this.startCount, 4, false);
        this.buttonTitle = jceInputStream.readString(5, false);
        this.isBannerValid = jceInputStream.read(this.isBannerValid, 6, false);
        this.bannerShowTime = jceInputStream.read(this.bannerShowTime, 7, false);
        this.fullScreenSubTitle = jceInputStream.readString(8, false);
        this.enableFullBannerClick = jceInputStream.read(this.enableFullBannerClick, 9, false);
        this.bannerDisplayTime = jceInputStream.read(this.bannerDisplayTime, 10, false);
        this.actionButtonInfo = (AdCustomActionButtonInfo) jceInputStream.read((JceStruct) cache_actionButtonInfo, 11, false);
        this.timeLineBannerInfo = (AdTimeLineBannerInfo) jceInputStream.read((JceStruct) cache_timeLineBannerInfo, 12, false);
        this.rewardGuideInfo = (AdRewardGuideInfo) jceInputStream.read((JceStruct) cache_rewardGuideInfo, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.isValid, 0);
        String str = this.imageUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.subTitle;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.startCount, 4);
        String str4 = this.buttonTitle;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        jceOutputStream.write(this.isBannerValid, 6);
        jceOutputStream.write(this.bannerShowTime, 7);
        String str5 = this.fullScreenSubTitle;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        jceOutputStream.write(this.enableFullBannerClick, 9);
        jceOutputStream.write(this.bannerDisplayTime, 10);
        AdCustomActionButtonInfo adCustomActionButtonInfo = this.actionButtonInfo;
        if (adCustomActionButtonInfo != null) {
            jceOutputStream.write((JceStruct) adCustomActionButtonInfo, 11);
        }
        AdTimeLineBannerInfo adTimeLineBannerInfo = this.timeLineBannerInfo;
        if (adTimeLineBannerInfo != null) {
            jceOutputStream.write((JceStruct) adTimeLineBannerInfo, 12);
        }
        AdRewardGuideInfo adRewardGuideInfo = this.rewardGuideInfo;
        if (adRewardGuideInfo != null) {
            jceOutputStream.write((JceStruct) adRewardGuideInfo, 13);
        }
    }

    public AdLinkInfo(boolean z16, String str, String str2, String str3, float f16, String str4, boolean z17, int i3, String str5, boolean z18, int i16, AdCustomActionButtonInfo adCustomActionButtonInfo, AdTimeLineBannerInfo adTimeLineBannerInfo, AdRewardGuideInfo adRewardGuideInfo) {
        this.isValid = z16;
        this.imageUrl = str;
        this.title = str2;
        this.subTitle = str3;
        this.startCount = f16;
        this.buttonTitle = str4;
        this.isBannerValid = z17;
        this.bannerShowTime = i3;
        this.fullScreenSubTitle = str5;
        this.enableFullBannerClick = z18;
        this.bannerDisplayTime = i16;
        this.actionButtonInfo = adCustomActionButtonInfo;
        this.timeLineBannerInfo = adTimeLineBannerInfo;
        this.rewardGuideInfo = adRewardGuideInfo;
    }
}
