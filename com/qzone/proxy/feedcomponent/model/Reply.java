package com.qzone.proxy.feedcomponent.model;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.text.font.FontManager;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Reply implements SmartParcelable {
    public static final String KEY_SUPER_FONT_INFO = "sparkle_json";

    @NeedParcel
    public AudioInfo audioInfo;
    public String clientKey;

    @NeedParcel
    public String content;

    @NeedParcel
    public int date;

    @NeedParcel
    public Map<String, String> extendInfo;

    @NeedParcel
    public boolean isCanJubao;
    public boolean isDeleted;

    @NeedParcel
    public boolean isFake;
    public boolean isTempData;

    @NeedParcel
    public boolean isliked;

    @NeedParcel
    public ArrayList<CellLikeInfo.LikeMan> likeMen;

    @NeedParcel
    public int likeNum;

    @NeedParcel
    public String refer;
    public Integer replyAreaCacheKey;

    @NeedParcel
    public String replyLikeKey;
    public int screenWidth;

    @NeedParcel
    public boolean showLikeIcon;

    @NeedParcel
    public User targetUser;
    public String uinKey;

    @NeedParcel
    public User user;

    @NeedParcel
    public String replyId = "";

    @NeedParcel
    public String fakeUinKey = "";

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
}
