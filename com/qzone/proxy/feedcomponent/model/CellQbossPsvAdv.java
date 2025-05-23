package com.qzone.proxy.feedcomponent.model;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import java.util.Map;

/* loaded from: classes39.dex */
public class CellQbossPsvAdv implements SmartParcelable {
    static final String BUTTON_TAB = "qbossadv_button";
    static final String SUMMARY_TAB = "qbossadv_summary";
    static final String TITLE_TAB = "qbossadv_title";

    @NeedParcel
    public PictureItem backgd_picdata;

    @NeedParcel
    public Map<String, String> extendinfo;

    @NeedParcel
    public PictureItem float_picdata;
    FeedPictureInfo mFeedBackgdPicInfo;
    FeedPictureInfo mFeedPicInfo;
    FeedPictureInfo mFloatPicInfo;

    @NeedParcel
    public PictureItem picdata;
    public String uniButton;
    public String uniSummary;
    public String uniTitle;

    @NeedParcel
    public int mediatype = 0;

    @NeedParcel
    public String title = "";

    @NeedParcel
    public String summary = "";

    @NeedParcel
    public long countDownTime = 0;

    @NeedParcel
    public int psvAdvType = 0;

    @NeedParcel
    public int markType = 0;

    @NeedParcel
    public String btnText = "";

    @NeedParcel
    public int actiontype = 0;

    @NeedParcel
    public String actionurl = "";

    public void calBackgdPictureInfo() {
        FeedPictureInfo feedPictureInfo;
        if (getBackgd_picdata() != null) {
            PictureItem backgd_picdata = getBackgd_picdata();
            feedPictureInfo = calculateFeedPictureInfo(backgd_picdata);
            if (feedPictureInfo != null) {
                feedPictureInfo.q(new NormalFeedImageProcessor(com.qzone.adapter.feedcomponent.b.f41877x, com.qzone.adapter.feedcomponent.b.f41878y, backgd_picdata.pivotXRate, backgd_picdata.pivotYRate));
            }
        } else {
            feedPictureInfo = null;
        }
        this.mFeedBackgdPicInfo = feedPictureInfo;
    }

    public void calFloatPictureInfo() {
        FeedPictureInfo feedPictureInfo;
        if (getFloat_picdata() != null) {
            PictureItem float_picdata = getFloat_picdata();
            feedPictureInfo = calculateFeedPictureInfo(float_picdata);
            if (feedPictureInfo != null) {
                feedPictureInfo.q(new NormalFeedImageProcessor(com.qzone.adapter.feedcomponent.b.f41879z, com.qzone.adapter.feedcomponent.b.A, float_picdata.pivotXRate, float_picdata.pivotYRate));
            }
        } else {
            feedPictureInfo = null;
        }
        this.mFloatPicInfo = feedPictureInfo;
    }

    public void calPictureInfo() {
        FeedPictureInfo feedPictureInfo;
        if (getPicdata() != null) {
            int i3 = com.qzone.adapter.feedcomponent.b.f41876w;
            PictureItem picdata = getPicdata();
            feedPictureInfo = calculateFeedPictureInfo(picdata);
            if (feedPictureInfo != null) {
                feedPictureInfo.q(new NormalFeedImageProcessor(i3, i3, picdata.pivotXRate, picdata.pivotYRate));
                if (getPicdata().type == 1) {
                    feedPictureInfo.f50238a = FeedPictureInfo.ImageType.IMAGE_GIF;
                    feedPictureInfo.f50243f = true;
                    feedPictureInfo.f50240c = feedPictureInfo.f50239b;
                } else {
                    feedPictureInfo.f50238a = FeedPictureInfo.ImageType.NORMAL;
                    feedPictureInfo.f50243f = false;
                    feedPictureInfo.f50241d = feedPictureInfo.f50239b;
                }
            }
        } else {
            feedPictureInfo = null;
        }
        this.mFeedPicInfo = feedPictureInfo;
    }

    public void calucateText(String str) {
        this.uniSummary = str + SUMMARY_TAB + this.summary;
        this.uniTitle = str + TITLE_TAB + this.title;
        this.uniButton = str + BUTTON_TAB + this.btnText;
    }

    public int getActiontype() {
        return this.actiontype;
    }

    public String getActionurl() {
        return this.actionurl;
    }

    public FeedPictureInfo getBackgdPictureInfo() {
        calBackgdPictureInfo();
        return this.mFeedBackgdPicInfo;
    }

    public PictureItem getBackgd_picdata() {
        return this.backgd_picdata;
    }

    public String getBtnText() {
        return this.btnText;
    }

    public String getButtonKey() {
        return this.uniButton;
    }

    public String getCountDownString(long j3) {
        if (j3 <= 0) {
            return "\u6b63\u5728\u8fdb\u884c\u4e2d";
        }
        int i3 = (int) j3;
        return String.format("{text:\u5012\u8ba1\u65f6 %02d:%02d:%02d,color:#FF707070}", Integer.valueOf(i3 / 3600), Integer.valueOf(((int) (j3 % 3600)) / 60), Integer.valueOf(i3 % 60));
    }

    public long getCountDownTime() {
        return this.countDownTime;
    }

    public Map<String, String> getExtendinfo() {
        return this.extendinfo;
    }

    public FeedPictureInfo getFloatPictureInfo() {
        calFloatPictureInfo();
        return this.mFloatPicInfo;
    }

    public PictureItem getFloat_picdata() {
        return this.float_picdata;
    }

    public int getMarkType() {
        return this.markType;
    }

    public int getMediatype() {
        return this.mediatype;
    }

    public PictureItem getPicdata() {
        return this.picdata;
    }

    public FeedPictureInfo getPictureInfo() {
        calPictureInfo();
        return this.mFeedPicInfo;
    }

    public int getPsvAdvType() {
        return this.psvAdvType;
    }

    public String getSummary() {
        if (this.countDownTime == 0) {
            return this.summary;
        }
        return "\u5012\u8ba1\u65f6:{Text: 00:00:00, color: #FFFFC025}";
    }

    public String getSummaryKey() {
        return this.uniSummary;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleKey() {
        return this.uniTitle;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellLeftThumb {\n");
        sb5.append("mediaType: ");
        sb5.append(this.mediatype);
        sb5.append("\n");
        if (this.picdata != null) {
            sb5.append("picdata : \n");
            sb5.append(this.picdata.toString());
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.title)) {
            sb5.append("title: ");
            sb5.append(this.title);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.summary)) {
            sb5.append("summary: ");
            sb5.append(this.summary);
            sb5.append("\n");
        }
        sb5.append("countDownTime: ");
        sb5.append(this.countDownTime);
        sb5.append("\n");
        if (this.backgd_picdata != null) {
            sb5.append("backgd_picdata : \n");
            sb5.append(this.backgd_picdata.toString());
            sb5.append("\n");
        }
        sb5.append("psvAdvType: ");
        sb5.append(this.psvAdvType);
        sb5.append("\n");
        sb5.append("markType: ");
        sb5.append(this.markType);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.btnText)) {
            sb5.append("btnText: ");
            sb5.append(this.btnText);
            sb5.append("\n");
        }
        sb5.append("actiontype: ");
        sb5.append(this.actiontype);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.actionurl)) {
            sb5.append("actionurl: ");
            sb5.append(this.actionurl);
            sb5.append("\n");
        }
        if (this.extendinfo != null) {
            sb5.append("extendinfo : \n");
            sb5.append(this.extendinfo.toString());
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    private FeedPictureInfo calculateFeedPictureInfo(PictureItem pictureItem) {
        PictureUrl pictureUrl;
        FeedPictureInfo.ImageType imageType;
        if (pictureItem == null || (pictureUrl = pictureItem.currentUrl) == null || TextUtils.isEmpty(pictureUrl.url)) {
            return null;
        }
        FeedPictureInfo.ImageType imageType2 = FeedPictureInfo.ImageType.NORMAL;
        int mediatype = getMediatype();
        if (mediatype != 1) {
            if (mediatype == 2) {
                imageType = FeedPictureInfo.ImageType.MUSIC;
            } else if (mediatype == 3) {
                imageType = FeedPictureInfo.ImageType.LEFT_THUMB_VIDEO;
            } else if (mediatype != 4) {
                if (mediatype != 5) {
                    imageType = FeedPictureInfo.ImageType.NORMAL;
                } else {
                    imageType = FeedPictureInfo.ImageType.LEFT_THUMB_AUDIO;
                }
            }
            return new FeedPictureInfo(imageType, pictureUrl, (String[]) com.qzone.proxy.feedcomponent.util.a.a(pictureItem.bigUrl.url, pictureItem.currentUrl.url));
        }
        imageType = FeedPictureInfo.ImageType.NORMAL;
        return new FeedPictureInfo(imageType, pictureUrl, (String[]) com.qzone.proxy.feedcomponent.util.a.a(pictureItem.bigUrl.url, pictureItem.currentUrl.url));
    }

    public String getCountDownString() {
        return getCountDownString(getCountDownTime() - (System.currentTimeMillis() / 1000));
    }
}
