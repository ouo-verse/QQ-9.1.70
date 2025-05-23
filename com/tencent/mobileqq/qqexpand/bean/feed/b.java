package com.tencent.mobileqq.qqexpand.bean.feed;

import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    public static final int FOOTER_TYPE_LOADING = 0;
    public static final int FOOTER_TYPE_LOAD_FAIL = 1;
    public static final int FOOTER_TYPE_LOAD_OVER = 2;
    public static final int TYPE_CAMPUS_VERIFY = 7;
    public static final int TYPE_EMTPY = 2;
    public static final int TYPE_FEED = 0;
    public static final int TYPE_FEED_ADV = 4;
    public static final int TYPE_FEED_BANNER = 6;
    public static final int TYPE_FOOTER = 1;
    public static final int TYPE_MINI_RECOMM = 5;
    public int clothesId;
    public int fontId;
    public int fontType;
    public boolean mAddFriendVerified;
    public int mAge;
    public AlumBasicData mAlumbasicdata;
    public int mAvailLikeCount;
    public boolean mBigVipHide;
    public int mBigVipLevel;
    public String mDeclaration;
    public int mFooterType;
    public int mGender;
    public boolean mIsMyFeed;
    public List<a> mLabelInfos;
    public boolean mLiked;
    public String mNickName;
    public int mPopularity;
    public List<C8313b> mSchoolInfos;
    public String mStrRecomTrace;
    public int mTemplateId;
    public int mType;
    public String mUin;
    public boolean mVipHide;
    public int mVipLevel;
    public int mVipType;
    public int mVoiceDuration;
    public String mVoiceUrl;
    public boolean mbAllowStrangerVote;
    public byte[] voiceCode;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f263486a;

        /* renamed from: b, reason: collision with root package name */
        public String f263487b;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqexpand.bean.feed.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8313b {

        /* renamed from: a, reason: collision with root package name */
        public String f263488a;

        /* renamed from: b, reason: collision with root package name */
        public long f263489b;

        /* renamed from: c, reason: collision with root package name */
        public String f263490c;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b) && Utils.p(((b) obj).mUin, this.mUin)) {
            return true;
        }
        return false;
    }
}
