package com.qzone.proxy.feedcomponent.model;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.FeedPictureInfo;
import com.qzone.proxy.feedcomponent.text.font.FontManager;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.processor.NormalFeedImageProcessor;
import java.util.Map;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellLeftThumb implements SmartParcelable {
    public static final String KEY_SUPER_FONT_INFO = "sparkle_json";
    static final String SUMMARY_TAB = "left_summary";
    static final String TITLE_TAB = "left_title";

    @NeedParcel
    int actionType;

    @NeedParcel
    String actionUrl;

    @NeedParcel
    public Map<String, String> extendInfo;
    public Integer integerUniSummary;
    public Integer integerUniTitle;

    @NeedParcel
    public boolean isPassive;
    FeedPictureInfo mFeedPicInfo;

    @NeedParcel
    int mediaType;

    @NeedParcel
    String parsedSummary;

    @NeedParcel
    public String parsedTitle;

    @NeedParcel
    int picActionType;

    @NeedParcel
    String picActionUrl;

    @NeedParcel
    PictureItem pictureItem;

    @NeedParcel
    String postDatas;
    long qqMusicId;

    @NeedParcel
    public String remark;

    @NeedParcel
    String summary;

    @NeedParcel
    public String title;
    public String uniSummary;
    public String uniTitle;

    @NeedParcel
    boolean usePost;

    @NeedParcel
    public User user;

    @NeedParcel
    int userActionType;
    public static final int DEFAULT_LEFT_HEIGHT = com.qzone.proxy.feedcomponent.util.g.a(85.0f);
    public static final int PASSIVE_LEFT_HEIGHT = com.qzone.proxy.feedcomponent.util.g.a(50.0f);

    public static FeedPictureInfo.ImageType getImageType(CellLeftThumb cellLeftThumb) {
        FeedPictureInfo.ImageType imageType = FeedPictureInfo.ImageType.NORMAL;
        if (cellLeftThumb == null) {
            return imageType;
        }
        if (cellLeftThumb.picActionType == 24) {
            return FeedPictureInfo.ImageType.LEFT_THUMB_QQMUSIC;
        }
        if (33 == cellLeftThumb.getPicActionType()) {
            return FeedPictureInfo.ImageType.LEFT_THUMB_OUTAUDIO;
        }
        int mediaType = cellLeftThumb.getMediaType();
        if (mediaType == 1) {
            return imageType;
        }
        if (mediaType == 2) {
            return FeedPictureInfo.ImageType.MUSIC;
        }
        if (mediaType != 3) {
            return (mediaType == 4 || mediaType != 5) ? imageType : FeedPictureInfo.ImageType.LEFT_THUMB_AUDIO;
        }
        return FeedPictureInfo.ImageType.LEFT_THUMB_VIDEO;
    }

    private static String parseFontStr(String str, boolean z16) {
        int c16;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        if (str.startsWith("\uff1a")) {
            if (z16) {
                c16 = com.qzone.adapter.feedcomponent.j.c(1);
            } else {
                c16 = com.qzone.adapter.feedcomponent.j.c(2);
            }
            sb5.append("{text:\uff1a,color:");
            sb5.append(Integer.toHexString(c16));
            sb5.append(",useDefaultFont:1,useSuperFont:0}");
            sb5.append(str.substring(1));
        } else {
            sb5.append(str);
        }
        return sb5.toString();
    }

    public void calPictureInfo(boolean z16) {
        FeedPictureInfo feedPictureInfo;
        int i3;
        FeedPictureInfo.ImageType imageType;
        if (getPictureItem() != null) {
            if (z16) {
                i3 = PASSIVE_LEFT_HEIGHT;
            } else {
                i3 = DEFAULT_LEFT_HEIGHT;
            }
            PictureItem pictureItem = getPictureItem();
            PictureUrl pictureUrl = pictureItem.currentUrl;
            if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                FeedPictureInfo.ImageType imageType2 = FeedPictureInfo.ImageType.NORMAL;
                int i16 = this.picActionType;
                if (i16 == 24) {
                    imageType = FeedPictureInfo.ImageType.LEFT_THUMB_QQMUSIC;
                } else if (33 == i16) {
                    imageType = FeedPictureInfo.ImageType.LEFT_THUMB_OUTAUDIO;
                } else {
                    int mediaType = getMediaType();
                    if (mediaType != 1) {
                        if (mediaType == 2) {
                            imageType = FeedPictureInfo.ImageType.MUSIC;
                        } else if (mediaType == 3) {
                            imageType = FeedPictureInfo.ImageType.LEFT_THUMB_VIDEO;
                        } else if (mediaType != 4) {
                            if (mediaType != 5) {
                                imageType = FeedPictureInfo.ImageType.NORMAL;
                            } else {
                                imageType = FeedPictureInfo.ImageType.LEFT_THUMB_AUDIO;
                            }
                        }
                    }
                    imageType = FeedPictureInfo.ImageType.NORMAL;
                }
                feedPictureInfo = new FeedPictureInfo(imageType, pictureUrl, (String[]) com.qzone.proxy.feedcomponent.util.a.a(pictureItem.bigUrl.url, pictureItem.currentUrl.url));
                feedPictureInfo.q(new NormalFeedImageProcessor(i3, i3, pictureItem.pivotXRate, pictureItem.pivotYRate));
                feedPictureInfo.f50251n = z16;
                this.mFeedPicInfo = feedPictureInfo;
            }
        }
        feedPictureInfo = null;
        this.mFeedPicInfo = feedPictureInfo;
    }

    public void calculateMembers(boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        User user = this.user;
        if (user != null && !TextUtils.isEmpty(user.nickName)) {
            User user2 = this.user;
            sb5.append(com.qzone.proxy.feedcomponent.util.h.d(user2.uin, user2.nickName));
            if (!TextUtils.isEmpty(this.title)) {
                sb5.append("");
                sb5.append(this.title);
                this.parsedTitle = sb5.toString();
            } else if (!TextUtils.isEmpty(this.summary)) {
                sb5.append("");
                sb5.append(this.summary);
                this.parsedSummary = sb5.toString();
            } else {
                String sb6 = sb5.toString();
                this.parsedTitle = sb6;
                this.parsedSummary = sb6;
            }
        } else {
            this.parsedTitle = this.title;
            this.parsedSummary = this.summary;
        }
        calPictureInfo(z16);
    }

    public int getActionType() {
        return this.actionType;
    }

    public String getActionUrl() {
        return this.actionUrl;
    }

    public Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    public String getFontBGUrl(boolean z16) {
        Map<String, String> map = this.extendInfo;
        if (map != null && !map.isEmpty() && getFontId(z16) > 0) {
            try {
                if (this.extendInfo.containsKey("diy_font_bgurl")) {
                    return new JSONObject(this.extendInfo.get("diy_font_bgurl")).optString("strFontBgAndFile");
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public int getFontId(boolean z16) {
        Map<String, String> map = this.extendInfo;
        if (map != null && !map.isEmpty()) {
            try {
                int intValue = Integer.valueOf(this.extendInfo.get("diy_font_id")).intValue();
                if (!z16 || FontManager.isFontEnable()) {
                    return intValue;
                }
                return -1;
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public int getFontType(boolean z16) {
        Map<String, String> map = this.extendInfo;
        if (map != null && !map.isEmpty() && getFontId(z16) > 0) {
            try {
                return Integer.valueOf(this.extendInfo.get("diy_font_type")).intValue();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public String getFontUrl(boolean z16) {
        if (this.extendInfo == null || getFontId(z16) <= 0) {
            return null;
        }
        return this.extendInfo.get("diy_font_url");
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getParseSummary() {
        String str = this.parsedSummary;
        return str == null ? this.summary : str;
    }

    public String getParseTitle() {
        String str = this.parsedTitle;
        return str == null ? this.title : str;
    }

    public int getPicActionType() {
        return this.picActionType;
    }

    public String getPicActionUrl() {
        return this.picActionUrl;
    }

    public FeedPictureInfo getPictureInfo() {
        calPictureInfo(this.isPassive);
        return this.mFeedPicInfo;
    }

    public PictureItem getPictureItem() {
        return this.pictureItem;
    }

    public String getPostDatas() {
        return this.postDatas;
    }

    public long getQQMusicId() {
        return this.qqMusicId;
    }

    public String getSummary() {
        return this.summary;
    }

    public String getSummaryKey() {
        return this.uniSummary;
    }

    public QzoneSuperPersonalFontData.SuperFontInfo getSuperFontInfo(boolean z16) {
        Map<String, String> map = this.extendInfo;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = this.extendInfo.get("sparkle_json");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!z16 || FontManager.isSuperFontEnable()) {
            return QzoneSuperPersonalFontData.SuperFontInfo.fromJson(str);
        }
        return null;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTitleKey() {
        return this.uniTitle;
    }

    public User getUser() {
        return this.user;
    }

    public int getuserActionType() {
        return this.userActionType;
    }

    public boolean hasPic() {
        PictureItem pictureItem = this.pictureItem;
        return !(pictureItem == null || com.qzone.proxy.feedcomponent.util.g.d(pictureItem.currentUrl)) || this.mediaType == 5;
    }

    public boolean isUsePost() {
        return this.usePost;
    }

    public void setActionType(int i3) {
        this.actionType = i3;
    }

    public void setActionUrl(String str) {
        this.actionUrl = str;
    }

    public void setExtendInfo(Map<String, String> map) {
        this.extendInfo = map;
    }

    public void setMediaType(int i3) {
        this.mediaType = i3;
    }

    public void setPicActionType(int i3) {
        this.picActionType = i3;
    }

    public void setPicActionUrl(String str) {
        this.picActionUrl = str;
        if (this.picActionType == 24) {
            try {
                this.qqMusicId = Long.parseLong(str);
            } catch (Exception e16) {
                com.qzone.proxy.feedcomponent.b.i("CellLeftThumb", "picActionUrl parse error!" + e16);
                this.qqMusicId = 0L;
            }
        }
    }

    public void setPictureItem(PictureItem pictureItem) {
        this.pictureItem = pictureItem;
    }

    public void setPostDatas(String str) {
        this.postDatas = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUsePost(boolean z16) {
        this.usePost = z16;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setuserActionType(int i3) {
        this.userActionType = i3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellLeftThumb {\n");
        sb5.append("mediaType: ");
        sb5.append(this.mediaType);
        sb5.append("\n");
        sb5.append("actionType: ");
        sb5.append(this.actionType);
        sb5.append("\n");
        if (this.pictureItem != null) {
            sb5.append("pictureItem: ");
            sb5.append(this.pictureItem.toString());
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.summary)) {
            sb5.append("summary: ");
            sb5.append(this.summary);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.title)) {
            sb5.append("title: ");
            sb5.append(this.title);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.actionUrl)) {
            sb5.append("actionUrl: ");
            sb5.append(this.actionUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.postDatas)) {
            sb5.append("postDatas: ");
            sb5.append(this.postDatas);
            sb5.append("\n");
        }
        sb5.append("usePost: ");
        sb5.append(this.usePost);
        sb5.append("\n");
        if (this.user != null) {
            sb5.append("user: ");
            sb5.append(this.user.toString());
            sb5.append("\n");
        }
        sb5.append("qqMusicId: ");
        sb5.append(this.qqMusicId);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.parsedTitle)) {
            sb5.append("parsedTitle: ");
            sb5.append(this.parsedTitle);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.parsedSummary)) {
            sb5.append("parsedSummary: ");
            sb5.append(this.parsedSummary);
            sb5.append("\n");
        }
        if (this.mFeedPicInfo != null) {
            sb5.append("mFeedPicInfo.url: ");
            sb5.append(this.mFeedPicInfo.h());
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.uniSummary)) {
            sb5.append("uniSummary: ");
            sb5.append(this.uniSummary);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.uniTitle)) {
            sb5.append("uniTitle: ");
            sb5.append(this.uniTitle);
            sb5.append("\n");
        }
        sb5.append("picActionType: ");
        sb5.append(this.picActionType);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.picActionUrl)) {
            sb5.append("picActionUrl: ");
            sb5.append(this.picActionUrl);
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    void validateMusicID(String str) {
        try {
            this.qqMusicId = Long.parseLong(str);
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.i("CellLeftThumb", "picActionUrl parse error!" + e16);
            this.qqMusicId = 0L;
        }
    }

    public void calucateText(String str, boolean z16, boolean z17, boolean z18) {
        if (str == null) {
            com.qzone.proxy.feedcomponent.b.c("CellLeftThumb", "feedKey is null!!");
            str = "";
        }
        StringBuilder sb5 = new StringBuilder();
        User user = this.user;
        if (user != null && !TextUtils.isEmpty(user.nickName)) {
            User user2 = this.user;
            sb5.append(com.qzone.proxy.feedcomponent.util.h.d(user2.uin, user2.nickName));
            if (!TextUtils.isEmpty(this.title)) {
                sb5.append(parseFontStr(this.title, true));
                this.parsedTitle = sb5.toString();
            } else if (!TextUtils.isEmpty(this.summary)) {
                sb5.append(parseFontStr(this.summary, true));
                this.parsedSummary = sb5.toString();
            } else {
                String sb6 = sb5.toString();
                this.parsedTitle = sb6;
                this.parsedSummary = sb6;
            }
        } else {
            this.parsedTitle = this.title;
            this.parsedSummary = this.summary;
        }
        sb5.delete(0, sb5.length());
        sb5.append(str);
        if (z17) {
            sb5.append(IjkMediaPlayer.OnNativeInvokeListener.ARG_FD);
            str = sb5.toString();
        }
        sb5.append(SUMMARY_TAB);
        String sb7 = sb5.toString();
        this.uniSummary = sb7;
        this.integerUniSummary = Integer.valueOf(sb7.hashCode());
        int length = str.length() - 1;
        String sb8 = sb5.replace(length >= 0 ? length : 0, sb5.length(), TITLE_TAB).toString();
        this.uniTitle = sb8;
        this.integerUniTitle = Integer.valueOf(sb8.hashCode());
    }
}
