package fu0;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e implements BaseAnchorInfo {

    /* renamed from: a, reason: collision with root package name */
    public long f400636a;

    /* renamed from: b, reason: collision with root package name */
    public String f400637b;

    /* renamed from: c, reason: collision with root package name */
    public String f400638c;

    /* renamed from: d, reason: collision with root package name */
    public String f400639d;

    /* renamed from: e, reason: collision with root package name */
    public long f400640e;

    /* renamed from: f, reason: collision with root package name */
    public long f400641f;

    /* renamed from: g, reason: collision with root package name */
    public int f400642g;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    public int f400643h;

    /* renamed from: i, reason: collision with root package name */
    @Deprecated
    public String f400644i;

    public e(QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo) {
        if (qQLiveAnchorDataUserInfo != null) {
            this.f400636a = qQLiveAnchorDataUserInfo.f271213id;
            this.f400637b = qQLiveAnchorDataUserInfo.nickName;
            this.f400638c = qQLiveAnchorDataUserInfo.avatarUrl;
            this.f400639d = qQLiveAnchorDataUserInfo.businessUid;
            this.f400640e = qQLiveAnchorDataUserInfo.explicitId;
            this.f400641f = qQLiveAnchorDataUserInfo.tinyId;
            this.f400642g = qQLiveAnchorDataUserInfo.initialClientType;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo
    public long getAnchorUid() {
        return this.f400636a;
    }

    public e(LiveAnchorInfo liveAnchorInfo) {
        if (liveAnchorInfo != null) {
            this.f400636a = liveAnchorInfo.uid;
            this.f400637b = liveAnchorInfo.nickName;
            this.f400638c = liveAnchorInfo.headUrl;
            this.f400639d = liveAnchorInfo.businessUid;
            this.f400640e = liveAnchorInfo.explicitId;
            this.f400641f = liveAnchorInfo.imsdkTinyId;
            this.f400642g = liveAnchorInfo.initialClientType;
            this.f400643h = liveAnchorInfo.sex;
            this.f400644i = liveAnchorInfo.wechatPub;
        }
    }
}
