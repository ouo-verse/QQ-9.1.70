package com.tencent.mobileqq.data.troop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopMemberCard implements Serializable {
    public static final long MEMBER_DISTANCE_DEFAULT = -1;
    public static final long MEMBER_DISTANCE_UNKOWN = -1000;
    private static final long serialVersionUID = 1;
    public int age;
    public String card;
    public String colorCard;
    public int colorCardId;
    public int credit;
    public List<CustomEntry> customEntryList;
    public int gbarCount;
    public String gbarLinkUrl;
    public List<GBarInfo> gbarList;
    public String gbarTitle;
    public String honorList;
    public byte honorRichTag;
    public boolean isAllowModCard;
    public boolean isConcerned;
    public boolean isFriend;
    public boolean isSuperQQ;
    public boolean isSuperVip;
    public boolean isVip;
    public boolean isYearVip;
    public long joinTime;
    public long lastSpeak;
    public String levelName;
    public String location;
    public int mGroupType;
    public boolean mIsShield;
    public MemberGameInfo mMemberGameInfo;
    public String mPosition;
    public ArrayList<StoryInfo> mStoryInfoList;
    public String mUniqueTitle;
    public int mUniqueTitleExpire;
    public int memberRole;
    public String memberUid;
    public long memberUin;
    public String nick;
    public String phoneNumber;
    public int realLevel;
    public String remark;
    public int result;
    public int sex;
    public int titleId;
    public int vipLevel = 26;
    public long distance = -1;
    public ArrayList<String> mOrgIds = new ArrayList<>();
    public ArrayList<String> mCurrAccountOrgIds = new ArrayList<>();
    public boolean mHasStory = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class CustomEntry implements Serializable {
        private static final long serialVersionUID = 1;
        public String info;
        public boolean isClickable;
        public String label;
        public String linkUrl;
        public long reportId;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class GBarInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public int gbarId;
        public String headUrl;
        public int level;
        public String name;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class MemberGameInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public ArrayList<String> descInfo;
        public String gameBackGroundColor;
        public String gameFontColor;
        public String gameName;
        public String gameUrl;
        public String levelIcon;
        public String levelName;
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class StoryInfo implements Serializable {
        private static final long serialVersionUID = 1;
        public String mCoverUrl;
    }
}
