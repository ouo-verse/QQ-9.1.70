package jg4;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h implements BaseAnchorInfo {

    /* renamed from: a, reason: collision with root package name */
    public long f409907a;

    /* renamed from: b, reason: collision with root package name */
    public String f409908b;

    /* renamed from: c, reason: collision with root package name */
    public String f409909c;

    /* renamed from: d, reason: collision with root package name */
    public String f409910d;

    /* renamed from: e, reason: collision with root package name */
    public long f409911e;

    /* renamed from: f, reason: collision with root package name */
    public long f409912f;

    /* renamed from: g, reason: collision with root package name */
    public int f409913g;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public int f409914h;

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public String f409915i;

    public h(QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo) {
        if (qQLiveAnchorDataUserInfo != null) {
            this.f409907a = qQLiveAnchorDataUserInfo.f271213id;
            this.f409908b = qQLiveAnchorDataUserInfo.nickName;
            this.f409909c = qQLiveAnchorDataUserInfo.avatarUrl;
            this.f409910d = qQLiveAnchorDataUserInfo.businessUid;
            this.f409911e = qQLiveAnchorDataUserInfo.explicitId;
            this.f409912f = qQLiveAnchorDataUserInfo.tinyId;
            this.f409913g = qQLiveAnchorDataUserInfo.initialClientType;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo
    public long getAnchorUid() {
        return this.f409907a;
    }

    public h(LiveAnchorInfo liveAnchorInfo) {
        if (liveAnchorInfo != null) {
            this.f409907a = liveAnchorInfo.uid;
            this.f409908b = liveAnchorInfo.nickName;
            this.f409909c = liveAnchorInfo.headUrl;
            this.f409910d = liveAnchorInfo.businessUid;
            this.f409911e = liveAnchorInfo.explicitId;
            this.f409912f = liveAnchorInfo.imsdkTinyId;
            this.f409913g = liveAnchorInfo.initialClientType;
            this.f409914h = liveAnchorInfo.sex;
            this.f409915i = liveAnchorInfo.wechatPub;
        }
    }
}
