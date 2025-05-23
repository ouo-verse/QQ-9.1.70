package gd1;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.msginfo.GameBasicInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f401937a;

    /* renamed from: b, reason: collision with root package name */
    public String f401938b;

    /* renamed from: c, reason: collision with root package name */
    public String f401939c;

    /* renamed from: d, reason: collision with root package name */
    public String f401940d;

    /* renamed from: e, reason: collision with root package name */
    public String f401941e;

    /* renamed from: f, reason: collision with root package name */
    public String f401942f;

    /* renamed from: g, reason: collision with root package name */
    public String f401943g;

    /* renamed from: h, reason: collision with root package name */
    public String f401944h;

    /* renamed from: i, reason: collision with root package name */
    public int f401945i;

    /* renamed from: j, reason: collision with root package name */
    public int f401946j;

    /* renamed from: k, reason: collision with root package name */
    public String f401947k;

    /* renamed from: l, reason: collision with root package name */
    public String f401948l;

    /* renamed from: m, reason: collision with root package name */
    public int f401949m;

    /* renamed from: n, reason: collision with root package name */
    public String f401950n;

    /* renamed from: o, reason: collision with root package name */
    public String f401951o;

    /* renamed from: p, reason: collision with root package name */
    public int f401952p;

    /* renamed from: q, reason: collision with root package name */
    public String f401953q;

    /* renamed from: r, reason: collision with root package name */
    public String f401954r;

    /* renamed from: s, reason: collision with root package name */
    public String f401955s;

    /* renamed from: t, reason: collision with root package name */
    public String f401956t;

    /* renamed from: u, reason: collision with root package name */
    public String f401957u;

    /* renamed from: v, reason: collision with root package name */
    public long f401958v;

    public static a b(GameBasicInfo gameBasicInfo, GameUserInfo gameUserInfo) {
        a aVar = new a();
        if (gameBasicInfo != null && gameUserInfo != null) {
            if (!TextUtils.isEmpty(gameBasicInfo.mAppId) && !TextUtils.isEmpty(gameUserInfo.mAppId)) {
                if (!gameBasicInfo.mAppId.equals(gameUserInfo.mAppId)) {
                    QLog.w("GameCenterMsg.GameDetailInfo", 1, "warning! appId should be the same!");
                    return aVar;
                }
                aVar.f401938b = gameUserInfo.mUin;
                aVar.f401937a = gameUserInfo.mRoleId;
                aVar.f401939c = gameUserInfo.mAppId;
                aVar.f401940d = gameUserInfo.mFaceUrl;
                aVar.f401945i = gameUserInfo.mSex;
                aVar.f401943g = gameUserInfo.mLevelPic;
                aVar.f401944h = gameUserInfo.mLevelText;
                aVar.f401941e = gameUserInfo.mNickInGame;
                aVar.f401942f = gameUserInfo.mPartitioName;
                aVar.f401946j = gameUserInfo.mOnlineType;
                aVar.f401949m = gameUserInfo.mSwitchInGame;
                aVar.f401950n = gameUserInfo.mOnLineDesc;
                aVar.f401953q = gameUserInfo.mVipRankUrl;
                aVar.f401954r = gameUserInfo.growthRankUrl;
                aVar.f401955s = gameUserInfo.growthRankUrlJump;
                aVar.f401956t = gameUserInfo.medalUrl;
                aVar.f401957u = gameUserInfo.medalUrlJump;
                aVar.f401947k = gameBasicInfo.mName;
                aVar.f401948l = gameBasicInfo.mIconUrl;
                aVar.f401951o = gameBasicInfo.mStartGameUrl;
                aVar.f401952p = gameBasicInfo.mMsgMaxLen;
                aVar.f401958v = gameBasicInfo.mUpdateTs;
                return aVar;
            }
            QLog.w("GameCenterMsg.GameDetailInfo", 1, "appId is empty.");
        }
        return aVar;
    }

    public String a() {
        int i3 = this.f401946j;
        if (i3 != 1) {
            if (i3 != 2) {
                return "";
            }
            return "\u6e38\u620f\u4e2d";
        }
        return "\u6e38\u620f\u5728\u7ebf";
    }

    public String toString() {
        return "GameDetailInfo{mRoleId='" + this.f401937a + "', mAppId='" + this.f401939c + "', mFaceUrl='" + this.f401940d + "', mNickInGame='" + this.f401941e + "', mPartitioName='" + this.f401942f + "', mLevelPic='" + this.f401943g + "', mLevelText='" + this.f401944h + "', mSex=" + this.f401945i + ", mOnlineType=" + this.f401946j + ", mName='" + this.f401947k + "', mIconUrl='" + this.f401948l + "', mSwitchInGame=" + this.f401949m + ", mOnLineDesc='" + this.f401950n + "', mStartGameUrl='" + this.f401951o + "', mMsgMaxLen=" + this.f401952p + ", mVipRankUrl" + this.f401953q + '}';
    }
}
