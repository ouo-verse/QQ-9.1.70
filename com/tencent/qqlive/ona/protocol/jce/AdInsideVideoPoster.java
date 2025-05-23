package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes22.dex */
public final class AdInsideVideoPoster extends JceStruct {
    public int actionButtonType;
    public AdAdvertiserInfo advertiserInfo;
    public AdAction buttonAction;
    public int countDownViewType;
    public AppDownloadChannelInfo downloadChannelInfo;
    public boolean enableScreenClick;
    public AdLongVideoInfo longVideoInfo;
    public boolean muted;
    public RewardSkipVideoAdInfo rewardSkipVideoAdInfo;
    public int skipAdDuration;
    public String skipAdSubtitle;
    public String skipAdtitle;
    public int skipType;
    public AdInsideVideoTitle titleInfo;
    public String trueViewSkipAdTitle;
    static AdInsideVideoTitle cache_titleInfo = new AdInsideVideoTitle();
    static AdAction cache_buttonAction = new AdAction();
    static AdLongVideoInfo cache_longVideoInfo = new AdLongVideoInfo();
    static AdAdvertiserInfo cache_advertiserInfo = new AdAdvertiserInfo();
    static AppDownloadChannelInfo cache_downloadChannelInfo = new AppDownloadChannelInfo();
    static RewardSkipVideoAdInfo cache_rewardSkipVideoAdInfo = new RewardSkipVideoAdInfo();
    static int cache_skipType = 0;
    static int cache_countDownViewType = 0;

    public AdInsideVideoPoster() {
        this.enableScreenClick = false;
        this.skipAdDuration = 0;
        this.skipAdtitle = "";
        this.skipAdSubtitle = "";
        this.actionButtonType = 0;
        this.titleInfo = null;
        this.buttonAction = null;
        this.longVideoInfo = null;
        this.muted = false;
        this.advertiserInfo = null;
        this.downloadChannelInfo = null;
        this.rewardSkipVideoAdInfo = null;
        this.skipType = 0;
        this.trueViewSkipAdTitle = "";
        this.countDownViewType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.enableScreenClick = jceInputStream.read(this.enableScreenClick, 0, false);
        this.skipAdDuration = jceInputStream.read(this.skipAdDuration, 1, false);
        this.skipAdtitle = jceInputStream.readString(2, false);
        this.skipAdSubtitle = jceInputStream.readString(3, false);
        this.actionButtonType = jceInputStream.read(this.actionButtonType, 4, false);
        this.titleInfo = (AdInsideVideoTitle) jceInputStream.read((JceStruct) cache_titleInfo, 5, false);
        this.buttonAction = (AdAction) jceInputStream.read((JceStruct) cache_buttonAction, 6, false);
        this.longVideoInfo = (AdLongVideoInfo) jceInputStream.read((JceStruct) cache_longVideoInfo, 7, false);
        this.muted = jceInputStream.read(this.muted, 8, false);
        this.advertiserInfo = (AdAdvertiserInfo) jceInputStream.read((JceStruct) cache_advertiserInfo, 9, false);
        this.downloadChannelInfo = (AppDownloadChannelInfo) jceInputStream.read((JceStruct) cache_downloadChannelInfo, 10, false);
        this.rewardSkipVideoAdInfo = (RewardSkipVideoAdInfo) jceInputStream.read((JceStruct) cache_rewardSkipVideoAdInfo, 11, false);
        this.skipType = jceInputStream.read(this.skipType, 12, false);
        this.trueViewSkipAdTitle = jceInputStream.readString(13, false);
        this.countDownViewType = jceInputStream.read(this.countDownViewType, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.enableScreenClick, 0);
        jceOutputStream.write(this.skipAdDuration, 1);
        String str = this.skipAdtitle;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.skipAdSubtitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.actionButtonType, 4);
        AdInsideVideoTitle adInsideVideoTitle = this.titleInfo;
        if (adInsideVideoTitle != null) {
            jceOutputStream.write((JceStruct) adInsideVideoTitle, 5);
        }
        AdAction adAction = this.buttonAction;
        if (adAction != null) {
            jceOutputStream.write((JceStruct) adAction, 6);
        }
        AdLongVideoInfo adLongVideoInfo = this.longVideoInfo;
        if (adLongVideoInfo != null) {
            jceOutputStream.write((JceStruct) adLongVideoInfo, 7);
        }
        jceOutputStream.write(this.muted, 8);
        AdAdvertiserInfo adAdvertiserInfo = this.advertiserInfo;
        if (adAdvertiserInfo != null) {
            jceOutputStream.write((JceStruct) adAdvertiserInfo, 9);
        }
        AppDownloadChannelInfo appDownloadChannelInfo = this.downloadChannelInfo;
        if (appDownloadChannelInfo != null) {
            jceOutputStream.write((JceStruct) appDownloadChannelInfo, 10);
        }
        RewardSkipVideoAdInfo rewardSkipVideoAdInfo = this.rewardSkipVideoAdInfo;
        if (rewardSkipVideoAdInfo != null) {
            jceOutputStream.write((JceStruct) rewardSkipVideoAdInfo, 11);
        }
        jceOutputStream.write(this.skipType, 12);
        String str3 = this.trueViewSkipAdTitle;
        if (str3 != null) {
            jceOutputStream.write(str3, 13);
        }
        jceOutputStream.write(this.countDownViewType, 14);
    }

    public AdInsideVideoPoster(boolean z16, int i3, String str, String str2, int i16, AdInsideVideoTitle adInsideVideoTitle, AdAction adAction, AdLongVideoInfo adLongVideoInfo, boolean z17, AdAdvertiserInfo adAdvertiserInfo, AppDownloadChannelInfo appDownloadChannelInfo, RewardSkipVideoAdInfo rewardSkipVideoAdInfo, int i17, String str3, int i18) {
        this.enableScreenClick = z16;
        this.skipAdDuration = i3;
        this.skipAdtitle = str;
        this.skipAdSubtitle = str2;
        this.actionButtonType = i16;
        this.titleInfo = adInsideVideoTitle;
        this.buttonAction = adAction;
        this.longVideoInfo = adLongVideoInfo;
        this.muted = z17;
        this.advertiserInfo = adAdvertiserInfo;
        this.downloadChannelInfo = appDownloadChannelInfo;
        this.rewardSkipVideoAdInfo = rewardSkipVideoAdInfo;
        this.skipType = i17;
        this.trueViewSkipAdTitle = str3;
        this.countDownViewType = i18;
    }
}
