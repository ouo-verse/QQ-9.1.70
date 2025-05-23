package com.qzone.proxy.feedcomponent.model;

import NS_FASHION_FEEDS_TAG_PROTO.TagInfo;
import NS_MOBILE_FEEDS.stPhotoTag;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes39.dex */
public class PictureItem implements SmartParcelable {
    public static final int PICTUREITEM_TYPE_INSERT_PICTURE = 2;
    public static final int PICTUREITEM_TYPE_RAPIDCOMMENT = 1;
    private static final String TAG = "PictureItem";

    @NeedParcel
    static final String VERSION = "version_4";

    @NeedParcel
    public int albumPriv;

    @NeedParcel
    public int allowShare;

    @NeedParcel
    public String audio_summary;

    @NeedParcel
    public int commentCount;

    @NeedParcel
    public String desc;

    @NeedParcel
    public ArrayList<cooperation.qzone.model.FaceData> faceLists;

    @NeedParcel
    public int fakeLongPic;

    @NeedParcel
    public int flag;

    @NeedParcel
    public boolean isAutoPlayGif;

    @NeedParcel
    public boolean isCover;

    @NeedParcel
    public boolean isGif;

    @NeedParcel
    public int isIndependentUgc;

    @NeedParcel
    public boolean isLike;

    @NeedParcel
    public boolean isSelected;

    @NeedParcel
    public int likeCount;

    @NeedParcel
    public String likeKey;

    @NeedParcel
    public String luckyMoneyDesc;

    @NeedParcel
    public int markfaceCount;
    public String miniGameBgUrl;

    @NeedParcel
    public String missionId;

    @NeedParcel
    public long modifytime;

    @NeedParcel
    public MusicInfo musicInfo;

    @NeedParcel
    public int opsynflag;

    @NeedParcel
    public int photoOpmask;

    @NeedParcel
    public float pivotXRate;

    @NeedParcel
    public float pivotYRate;

    @NeedParcel
    public int type;

    @NeedParcel
    public long uploadTime;

    @NeedParcel
    public String uploadUid;

    @NeedParcel
    public long uploadUin;

    @NeedParcel
    public ArrayList<TagInfo> vecTagInfo;

    @NeedParcel
    public VideoInfo videodata;

    @NeedParcel
    public int videoflag;

    @NeedParcel
    public int viewCount;

    @NeedParcel
    public int piccategory = 1;

    @NeedParcel
    public String albumId = "";

    @NeedParcel
    public String picname = "";

    @NeedParcel
    public String sloc = "";

    @NeedParcel
    public String lloc = "";

    @NeedParcel
    public PictureUrl originUrl = new PictureUrl();

    @NeedParcel
    public PictureUrl bigUrl = new PictureUrl();

    @NeedParcel
    public PictureUrl downloadUrl = new PictureUrl();

    @NeedParcel
    public PictureUrl currentUrl = new PictureUrl();

    @NeedParcel
    public Map<Integer, String> busi_param = new HashMap();

    @NeedParcel
    public String clientFakeKey = "";

    @NeedParcel
    public String localFileUrl = "";

    @NeedParcel
    public int actiontype = 18;

    @NeedParcel
    public String actionurl = "";

    @NeedParcel
    public byte opmask = 7;

    @NeedParcel
    public ArrayList<stPhotoTag> photoTag = null;

    public String getBigUrlUniKey() {
        PictureUrl pictureUrl = this.bigUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            return ImageKey.getUrlKey(this.bigUrl.url, true);
        }
        return "";
    }

    public PictureUrl getCurrentUrl() {
        return this.currentUrl;
    }

    public String getDebugInfo() {
        return "albumId=" + this.albumId + "\nlloc=" + this.lloc + "\nsloc=" + this.sloc + "\ntype=" + this.type + "\ncurrentUrl.url=" + this.currentUrl.url + TokenParser.SP + "currentUrl.width=" + this.currentUrl.width + TokenParser.SP + "currentUrl.height=" + this.currentUrl.height + "\nbigUrl.url=" + this.bigUrl.url + TokenParser.SP + "bigUrl.width=" + this.bigUrl.width + TokenParser.SP + "bigUrl.height=" + this.bigUrl.height + "\noriginUrl.url=" + this.originUrl.url + TokenParser.SP + "originUrl.width=" + this.originUrl.width + TokenParser.SP + "originUrl.height=" + this.originUrl.height + "\ndownloadUrl.url=" + this.downloadUrl.url + TokenParser.SP + "photoOpmask=" + this.photoOpmask + "\nluckyMoneyDesc=" + this.luckyMoneyDesc + "\naudio_summary=" + this.audio_summary + "\nmissionId=" + this.missionId + '\n';
    }

    public PictureUrl getDownloadUrl() {
        PictureUrl pictureUrl = this.downloadUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            com.qzone.proxy.feedcomponent.b.a(TAG, "getDownloadUrl: " + this.downloadUrl);
            return this.downloadUrl;
        }
        PictureUrl picUrlDec = getPicUrlDec();
        com.qzone.proxy.feedcomponent.b.a(TAG, "getDownloadUrl, downloadUrl is null, return pic url: " + picUrlDec);
        return picUrlDec;
    }

    PictureUrl getUrlByPriority(PictureUrl[] pictureUrlArr) {
        for (PictureUrl pictureUrl : pictureUrlArr) {
            if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                return pictureUrl;
            }
        }
        return new PictureUrl();
    }

    public boolean hasQuan() {
        return (this.flag & 2) > 0;
    }

    public boolean isBallPanorama() {
        return this.flag == 32;
    }

    public boolean isChangtu() {
        return (this.flag & 1) > 0;
    }

    public boolean isCirclePanorama() {
        return this.flag == 16;
    }

    public boolean isEggPhoto() {
        return (this.flag & 4) > 0;
    }

    public boolean isFakeLongPic() {
        return (this.fakeLongPic & 1) > 0;
    }

    public boolean isGif() {
        return this.type == 2;
    }

    public boolean isGoldenCudgel() {
        return (this.flag & 1) > 0;
    }

    public boolean isVideo() {
        return this.videoflag == 1;
    }

    public void setChangtuFlag(boolean z16) {
        this.flag = ((z16 ? 1 : 0) << 0) | this.flag;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("PictureItem{");
        if (!TextUtils.isEmpty(this.albumId)) {
            sb5.append("albumId=");
            sb5.append(this.albumId);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.picname)) {
            sb5.append("picname=");
            sb5.append(this.picname);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.sloc)) {
            sb5.append("sloc=");
            sb5.append(this.sloc);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.lloc)) {
            sb5.append("lloc=");
            sb5.append(this.sloc);
            sb5.append(", ");
        }
        sb5.append("type=");
        sb5.append(this.type);
        sb5.append(", ");
        sb5.append("isAutoPlayGif=");
        sb5.append(this.isAutoPlayGif);
        sb5.append(", ");
        PictureUrl pictureUrl = this.originUrl;
        if (pictureUrl != null && pictureUrl.url != null) {
            sb5.append("originUrl=");
            sb5.append(this.originUrl.url);
            sb5.append(", ");
        }
        PictureUrl pictureUrl2 = this.bigUrl;
        if (pictureUrl2 != null && pictureUrl2.url != null) {
            sb5.append("bigUrl=");
            sb5.append(this.bigUrl.url);
            sb5.append(", ");
        }
        PictureUrl pictureUrl3 = this.currentUrl;
        if (pictureUrl3 != null && pictureUrl3.url != null) {
            sb5.append("currentUrl=");
            sb5.append(this.currentUrl.url);
            sb5.append(", ");
        }
        PictureUrl pictureUrl4 = this.downloadUrl;
        if (pictureUrl4 != null && pictureUrl4.url != null) {
            sb5.append("downloadUrl=");
            sb5.append(this.downloadUrl.url);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.clientFakeKey)) {
            sb5.append("clientFakeKey=");
            sb5.append(this.clientFakeKey);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.localFileUrl)) {
            sb5.append("localFileUrl=");
            sb5.append(this.localFileUrl);
            sb5.append(", ");
        }
        sb5.append("uploadUid=");
        sb5.append(this.uploadUid);
        sb5.append(", ");
        sb5.append("uploadUin=");
        sb5.append(this.uploadUin);
        sb5.append(", ");
        if (!TextUtils.isEmpty(this.actionurl)) {
            sb5.append("actionurl=");
            sb5.append(this.actionurl);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.missionId)) {
            sb5.append("missionId=");
            sb5.append(this.missionId);
            sb5.append(", ");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public PictureUrl getPicUrlDec() {
        return getUrlByPriority(new PictureUrl[]{this.originUrl, this.bigUrl, this.currentUrl});
    }

    public void setBallPanorama() {
        this.flag = 32;
    }

    public void setCirclePanorama() {
        this.flag = 16;
    }
}
