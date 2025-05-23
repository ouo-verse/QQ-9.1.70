package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.utils.StringUtil;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "id")
/* loaded from: classes10.dex */
public class TroopFeedItem extends Entity {
    public static final int ABLUM_FEED_TYPE = 18;
    public static final String APPID_STORY_PGC_CONTENT = "1105527223";
    public static final String APPID_STORY_PGC_LIVE = "1105600378";
    public static final int COMMON_FEED_TYPE = 99;
    public static final int FILE_FEED_TYPE = 131;
    public static final int GAME_FEED_TYPE = 133;
    public static final int MUSIC_FEED_TYPE = 132;
    public static final int NOTES_FEED_TYPE = 19;
    public static final int PIC_FEED_TYPE = 0;
    public static final int PROCLAMATION_FEED_TYPE = 5;
    public static final int SHARE_FEED_TYPE = 4;
    public static final int VIDEO_FEED_TYPE = 10;
    public static final int VOTE_FEED_TYPE = 12;
    public String currentUin;
    public int orginType;
    public long shareExpire;
    public String shareFromUin;
    public String troopUin;
    public int type;

    /* renamed from: id, reason: collision with root package name */
    public String f203122id = "";
    public String tag = "";
    public String title = "";
    public String content = "";
    public String picPath = "";
    public String linkUrl = "";
    public String publishUin = "";
    public String feedTime = "";
    public String ex_1 = "";
    public boolean read = false;

    public boolean isStoryType() {
        if (!this.ex_1.equals(APPID_STORY_PGC_CONTENT) && !this.ex_1.equals(APPID_STORY_PGC_LIVE)) {
            return false;
        }
        return true;
    }

    public boolean isVaild() {
        if (StringUtil.isEmpty(this.tag) || StringUtil.isEmpty(this.title)) {
            return false;
        }
        int i3 = this.type;
        if ((i3 == 0 || i3 == 131) && StringUtil.isEmpty(this.content)) {
            return false;
        }
        return true;
    }
}
