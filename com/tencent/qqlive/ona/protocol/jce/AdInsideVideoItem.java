package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdInsideVideoItem extends JceStruct {
    static AdCustomActionButtonInfo cache_actionButtonInfo;
    static AdFormInfo cache_formInfo;
    static AdInteractionInfo cache_interactionInfo;
    static AdMaxViewItem cache_maxViewItem;
    static AdcPoster cache_posterItem;
    static AdInsideVideoVibrateInfo cache_vibrateInfo;
    static int cache_videoAdType;
    public AdCustomActionButtonInfo actionButtonInfo;
    public int adSubType;
    public int bannerType;
    public AdInSideExtraReportItem extraReportItem;
    public AdFormInfo formInfo;
    public AdInteractionInfo interactionInfo;
    public AdLinkInfo linkInfo;
    public AdMaxViewItem maxViewItem;
    public AdOrderItem orderItem;
    public AdcPoster posterItem;
    public AdRichMediaItem richMediaItem;
    public AdShareItem shareItem;
    public int skipType;
    public AdSpeechInfo speechInfo;
    public ArrayList<AdTimeRange> timeRange;
    public AdInsideVideoVibrateInfo vibrateInfo;
    public int videoAdType;
    public AdVideoItem videoItem;
    public AdInsideVideoPoster videoPoster;
    static AdOrderItem cache_orderItem = new AdOrderItem();
    static AdVideoItem cache_videoItem = new AdVideoItem();
    static AdInsideVideoPoster cache_videoPoster = new AdInsideVideoPoster();
    static AdShareItem cache_shareItem = new AdShareItem();
    static AdSpeechInfo cache_speechInfo = new AdSpeechInfo();
    static AdLinkInfo cache_linkInfo = new AdLinkInfo();
    static AdRichMediaItem cache_richMediaItem = new AdRichMediaItem();
    static AdInSideExtraReportItem cache_extraReportItem = new AdInSideExtraReportItem();
    static ArrayList<AdTimeRange> cache_timeRange = new ArrayList<>();

    static {
        cache_timeRange.add(new AdTimeRange());
        cache_formInfo = new AdFormInfo();
        cache_maxViewItem = new AdMaxViewItem();
        cache_interactionInfo = new AdInteractionInfo();
        cache_videoAdType = 0;
        cache_posterItem = new AdcPoster();
        cache_vibrateInfo = new AdInsideVideoVibrateInfo();
        cache_actionButtonInfo = new AdCustomActionButtonInfo();
    }

    public AdInsideVideoItem() {
        this.adSubType = 0;
        this.orderItem = null;
        this.videoItem = null;
        this.videoPoster = null;
        this.shareItem = null;
        this.speechInfo = null;
        this.linkInfo = null;
        this.richMediaItem = null;
        this.extraReportItem = null;
        this.timeRange = null;
        this.formInfo = null;
        this.bannerType = 0;
        this.maxViewItem = null;
        this.skipType = 0;
        this.interactionInfo = null;
        this.videoAdType = 0;
        this.posterItem = null;
        this.vibrateInfo = null;
        this.actionButtonInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.adSubType = jceInputStream.read(this.adSubType, 0, false);
        this.orderItem = (AdOrderItem) jceInputStream.read((JceStruct) cache_orderItem, 1, false);
        this.videoItem = (AdVideoItem) jceInputStream.read((JceStruct) cache_videoItem, 2, false);
        this.videoPoster = (AdInsideVideoPoster) jceInputStream.read((JceStruct) cache_videoPoster, 3, false);
        this.shareItem = (AdShareItem) jceInputStream.read((JceStruct) cache_shareItem, 4, false);
        this.speechInfo = (AdSpeechInfo) jceInputStream.read((JceStruct) cache_speechInfo, 5, false);
        this.linkInfo = (AdLinkInfo) jceInputStream.read((JceStruct) cache_linkInfo, 6, false);
        this.richMediaItem = (AdRichMediaItem) jceInputStream.read((JceStruct) cache_richMediaItem, 7, false);
        this.extraReportItem = (AdInSideExtraReportItem) jceInputStream.read((JceStruct) cache_extraReportItem, 8, false);
        this.timeRange = (ArrayList) jceInputStream.read((JceInputStream) cache_timeRange, 9, false);
        this.formInfo = (AdFormInfo) jceInputStream.read((JceStruct) cache_formInfo, 10, false);
        this.bannerType = jceInputStream.read(this.bannerType, 11, false);
        this.maxViewItem = (AdMaxViewItem) jceInputStream.read((JceStruct) cache_maxViewItem, 12, false);
        this.skipType = jceInputStream.read(this.skipType, 13, false);
        this.interactionInfo = (AdInteractionInfo) jceInputStream.read((JceStruct) cache_interactionInfo, 14, false);
        this.videoAdType = jceInputStream.read(this.videoAdType, 15, false);
        this.posterItem = (AdcPoster) jceInputStream.read((JceStruct) cache_posterItem, 16, false);
        this.vibrateInfo = (AdInsideVideoVibrateInfo) jceInputStream.read((JceStruct) cache_vibrateInfo, 17, false);
        this.actionButtonInfo = (AdCustomActionButtonInfo) jceInputStream.read((JceStruct) cache_actionButtonInfo, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.adSubType, 0);
        AdOrderItem adOrderItem = this.orderItem;
        if (adOrderItem != null) {
            jceOutputStream.write((JceStruct) adOrderItem, 1);
        }
        AdVideoItem adVideoItem = this.videoItem;
        if (adVideoItem != null) {
            jceOutputStream.write((JceStruct) adVideoItem, 2);
        }
        AdInsideVideoPoster adInsideVideoPoster = this.videoPoster;
        if (adInsideVideoPoster != null) {
            jceOutputStream.write((JceStruct) adInsideVideoPoster, 3);
        }
        AdShareItem adShareItem = this.shareItem;
        if (adShareItem != null) {
            jceOutputStream.write((JceStruct) adShareItem, 4);
        }
        AdSpeechInfo adSpeechInfo = this.speechInfo;
        if (adSpeechInfo != null) {
            jceOutputStream.write((JceStruct) adSpeechInfo, 5);
        }
        AdLinkInfo adLinkInfo = this.linkInfo;
        if (adLinkInfo != null) {
            jceOutputStream.write((JceStruct) adLinkInfo, 6);
        }
        AdRichMediaItem adRichMediaItem = this.richMediaItem;
        if (adRichMediaItem != null) {
            jceOutputStream.write((JceStruct) adRichMediaItem, 7);
        }
        AdInSideExtraReportItem adInSideExtraReportItem = this.extraReportItem;
        if (adInSideExtraReportItem != null) {
            jceOutputStream.write((JceStruct) adInSideExtraReportItem, 8);
        }
        ArrayList<AdTimeRange> arrayList = this.timeRange;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 9);
        }
        AdFormInfo adFormInfo = this.formInfo;
        if (adFormInfo != null) {
            jceOutputStream.write((JceStruct) adFormInfo, 10);
        }
        jceOutputStream.write(this.bannerType, 11);
        AdMaxViewItem adMaxViewItem = this.maxViewItem;
        if (adMaxViewItem != null) {
            jceOutputStream.write((JceStruct) adMaxViewItem, 12);
        }
        jceOutputStream.write(this.skipType, 13);
        AdInteractionInfo adInteractionInfo = this.interactionInfo;
        if (adInteractionInfo != null) {
            jceOutputStream.write((JceStruct) adInteractionInfo, 14);
        }
        jceOutputStream.write(this.videoAdType, 15);
        AdcPoster adcPoster = this.posterItem;
        if (adcPoster != null) {
            jceOutputStream.write((JceStruct) adcPoster, 16);
        }
        AdInsideVideoVibrateInfo adInsideVideoVibrateInfo = this.vibrateInfo;
        if (adInsideVideoVibrateInfo != null) {
            jceOutputStream.write((JceStruct) adInsideVideoVibrateInfo, 17);
        }
        AdCustomActionButtonInfo adCustomActionButtonInfo = this.actionButtonInfo;
        if (adCustomActionButtonInfo != null) {
            jceOutputStream.write((JceStruct) adCustomActionButtonInfo, 18);
        }
    }

    public AdInsideVideoItem(int i3, AdOrderItem adOrderItem, AdVideoItem adVideoItem, AdInsideVideoPoster adInsideVideoPoster, AdShareItem adShareItem, AdSpeechInfo adSpeechInfo, AdLinkInfo adLinkInfo, AdRichMediaItem adRichMediaItem, AdInSideExtraReportItem adInSideExtraReportItem, ArrayList<AdTimeRange> arrayList, AdFormInfo adFormInfo, int i16, AdMaxViewItem adMaxViewItem, int i17, AdInteractionInfo adInteractionInfo, int i18, AdcPoster adcPoster, AdInsideVideoVibrateInfo adInsideVideoVibrateInfo, AdCustomActionButtonInfo adCustomActionButtonInfo) {
        this.adSubType = i3;
        this.orderItem = adOrderItem;
        this.videoItem = adVideoItem;
        this.videoPoster = adInsideVideoPoster;
        this.shareItem = adShareItem;
        this.speechInfo = adSpeechInfo;
        this.linkInfo = adLinkInfo;
        this.richMediaItem = adRichMediaItem;
        this.extraReportItem = adInSideExtraReportItem;
        this.timeRange = arrayList;
        this.formInfo = adFormInfo;
        this.bannerType = i16;
        this.maxViewItem = adMaxViewItem;
        this.skipType = i17;
        this.interactionInfo = adInteractionInfo;
        this.videoAdType = i18;
        this.posterItem = adcPoster;
        this.vibrateInfo = adInsideVideoVibrateInfo;
        this.actionButtonInfo = adCustomActionButtonInfo;
    }
}
