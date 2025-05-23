package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.text.font.FontManager;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Comment implements SmartParcelable {
    public static final String KEY_SUPER_FONT_INFO = "sparkle_json";
    private static int POKE_LIKE_IMAGE_SIDE_LEN = com.qzone.proxy.feedcomponent.util.g.a(16.0f);
    private static final String TAG = "Comment";

    @NeedParcel
    public AudioInfo audioInfo;

    @NeedParcel
    public Map<String, byte[]> bybass_extendInfo;
    public String clientKey;

    @NeedParcel
    public String comment;
    public Integer commentAreaCacheKey;

    @NeedParcel
    public String commentLikekey;

    @NeedParcel
    public ArrayList<PictureItem> commentPictureItems;

    @NeedParcel
    public String commentid;

    @NeedParcel
    public int displayReplyNum;

    @NeedParcel
    public int displayflag;

    @NeedParcel
    public Map<String, String> extendInfo;

    @NeedParcel
    public String feedKey;
    public int feedType;
    public int floor;

    @NeedParcel
    public boolean isCanJubao;
    public boolean isDeleted;

    @NeedParcel
    public boolean isFake;
    public boolean isMyCommentPraise;

    @NeedParcel
    public boolean isNeedShrink;

    @NeedParcel
    public boolean isPrivate;

    @NeedParcel
    public boolean isStickTop;
    public boolean isTempData;

    @NeedParcel
    public boolean isliked;

    @NeedParcel
    public ArrayList<CellLikeInfo.LikeMan> likeMen;
    private int mScenario;

    @NeedParcel
    public boolean needShowPraiseButton;

    @NeedParcel
    public ArrayList<PictureItem> pictureItems;

    @NeedParcel
    public int pokeLikeCount;

    @NeedParcel
    public String pokeLikeEmotion;

    @NeedParcel
    public String refer;

    @NeedParcel
    public List<Reply> replies;

    @NeedParcel
    public int replyNum;
    public int screenWidth;

    @NeedParcel
    public int time;

    @NeedParcel
    public User user;

    @NeedParcel
    public String uniKey = "";

    @NeedParcel
    public String fakeUniKey = "";
    public String displayStr = "";

    @NeedParcel
    public int commentType = 0;
    public boolean isAbleToReply = true;
    public ArrayList<String> displayReplyStr = null;

    @NeedParcel
    public int likeNum = 0;

    public static String getPokeLikeCommentStatic(String str, String str2, int i3) {
        String imgUrlByStrEmotion;
        int i16;
        int indexOf;
        if (TextUtils.isEmpty(str2) || i3 <= 0 || (imgUrlByStrEmotion = FeedGlobalEnv.g().getImgUrlByStrEmotion(str2)) == null || str.indexOf("{img:") > -1) {
            return str;
        }
        if (!str.startsWith("<uin:") || (indexOf = str.indexOf(">")) <= -1) {
            i16 = 0;
        } else {
            i16 = indexOf + 1;
            int indexOf2 = str.indexOf("{text:");
            if (indexOf2 > -1) {
                i16 = str.substring(indexOf2).indexOf("}") + indexOf2 + 1;
            }
        }
        String format = String.format("{img:%s,combo:%s,w:%s,h:%s,pLeft:0px,pRight:6dp}", imgUrlByStrEmotion, Integer.valueOf(i3), Integer.valueOf(POKE_LIKE_IMAGE_SIDE_LEN), Integer.valueOf(POKE_LIKE_IMAGE_SIDE_LEN));
        if (i16 == 0) {
            return format + str;
        }
        return str.substring(0, i16) + format + str.substring(i16);
    }

    public QzoneBarrageEffectData.BarrageEffectInfo getBarrageEffectInfo(boolean z16) {
        byte[] bArr;
        Map<String, byte[]> map = this.bybass_extendInfo;
        if (map == null || map.isEmpty() || (bArr = this.bybass_extendInfo.get(UNIVERSAL_MALL_QUAL.value)) == null) {
            return null;
        }
        if (!z16 || FontManager.isBarrageEffectEnable()) {
            return QzoneBarrageEffectData.BarrageEffectInfo.fromFeedsJceData(bArr);
        }
        return null;
    }

    public int getFontId(boolean z16) {
        Map<String, String> map = this.extendInfo;
        if (map != null && !map.isEmpty()) {
            try {
                int intValue = Integer.valueOf(this.extendInfo.get("diy_font_id")).intValue();
                if (this.feedType != 4097 || FontManager.isFontEnable()) {
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

    public String getPokeLikeComment() {
        return getPokeLikeComment(this.comment);
    }

    public int getScenario() {
        return this.mScenario;
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

    public boolean hasCommentPictureItems() {
        ArrayList<PictureItem> arrayList = this.commentPictureItems;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean hasPokeLike() {
        return !TextUtils.isEmpty(this.pokeLikeEmotion) && this.pokeLikeCount > 0;
    }

    public void setScenario(int i3) {
        this.mScenario = i3;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Comment {");
        if (!TextUtils.isEmpty(this.commentid)) {
            sb5.append("commentid: ");
            sb5.append(this.commentid);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.comment)) {
            sb5.append("comment: ");
            sb5.append(this.comment);
            sb5.append("\n");
        }
        sb5.append("time: ");
        sb5.append(this.time);
        sb5.append(", ");
        sb5.append("replyNum: ");
        sb5.append(this.replyNum);
        sb5.append("\n");
        sb5.append("user: ");
        sb5.append(this.user);
        sb5.append("\n");
        sb5.append("isFake: ");
        sb5.append(this.isFake);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.uniKey)) {
            sb5.append("uniKey: ");
            sb5.append(this.uniKey);
            sb5.append("\n");
        }
        if (this.pictureItems != null) {
            for (int i3 = 0; i3 < this.pictureItems.size(); i3++) {
                sb5.append("pictureItems[");
                sb5.append(i3);
                sb5.append("]: ");
                sb5.append(this.pictureItems.get(i3).toString());
                sb5.append("\n");
            }
        }
        if (this.commentPictureItems != null) {
            for (int i16 = 0; i16 < this.commentPictureItems.size(); i16++) {
                sb5.append("commentPictureItems[");
                sb5.append(i16);
                sb5.append("]: ");
                sb5.append(this.commentPictureItems.get(i16).toString());
                sb5.append("\n");
            }
        }
        if (!TextUtils.isEmpty(this.refer)) {
            sb5.append("refer: ");
            sb5.append(this.uniKey);
            sb5.append("\n");
        }
        sb5.append("floor: ");
        sb5.append(this.floor);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.feedKey)) {
            sb5.append("feedKey: ");
            sb5.append(this.feedKey);
            sb5.append("\n");
        }
        sb5.append("isliked:");
        sb5.append(this.isliked);
        sb5.append("\n");
        sb5.append("likeNum:");
        sb5.append(this.likeNum);
        sb5.append("\n");
        sb5.append("commentLikekey:");
        sb5.append(this.commentLikekey);
        sb5.append("\n");
        sb5.append("clientKey:");
        sb5.append(this.clientKey);
        sb5.append("\n");
        sb5.append("}");
        return sb5.toString();
    }

    public String getPokeLikeComment(String str) {
        return getPokeLikeCommentStatic(str, this.pokeLikeEmotion, this.pokeLikeCount);
    }
}
