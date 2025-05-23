package com.tencent.biz.qqcircle.immersive.personal.bean;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k extends e {

    /* renamed from: e, reason: collision with root package name */
    protected String f88482e;

    /* renamed from: f, reason: collision with root package name */
    protected FeedCloudMeta$StFeed f88483f;

    /* renamed from: g, reason: collision with root package name */
    protected int f88484g;

    /* renamed from: h, reason: collision with root package name */
    protected String f88485h;

    /* renamed from: i, reason: collision with root package name */
    private String f88486i;

    /* renamed from: j, reason: collision with root package name */
    private int f88487j;

    /* renamed from: k, reason: collision with root package name */
    private long f88488k;

    /* renamed from: l, reason: collision with root package name */
    private List<DraftBean> f88489l;

    /* renamed from: m, reason: collision with root package name */
    private String f88490m;

    /* renamed from: n, reason: collision with root package name */
    private int f88491n;

    /* renamed from: o, reason: collision with root package name */
    private int f88492o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f88493p;

    public k(String str, e30.b bVar, int i3) {
        super(bVar);
        this.f88485h = "";
        this.f88486i = "";
        this.f88492o = AudienceReportConst.EVENT_ID_ENTER_ROOM_SUCCESS;
        this.f88493p = false;
        this.f88482e = str;
        if (bVar == null) {
            return;
        }
        FeedCloudMeta$StFeed g16 = bVar.g();
        this.f88483f = g16;
        if (g16 != null) {
            this.f88485h = g16.f398449id.get();
            this.f88484g = this.f88483f.type.get();
            this.f88486i = this.f88483f.right.iconUrl.get();
            this.f88491n = i3;
            this.f88493p = this.f88483f.opMask2.get().contains(20);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.bean.e
    public FeedCloudMeta$StFeed b() {
        return this.f88483f;
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.bean.e
    public String d() {
        return this.f88485h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f88483f != null && this.f88485h.equals(kVar.f88485h) && this.f88483f.commentCount.get() == kVar.f88483f.commentCount.get() && this.f88483f.likeInfo.count.get() == kVar.f88483f.likeInfo.count.get() && this.f88483f.likeInfo.status.get() == kVar.f88483f.likeInfo.status.get() && a().equals(kVar.a())) {
            return true;
        }
        return false;
    }

    public List<DraftBean> i() {
        return this.f88489l;
    }

    public int j() {
        return this.f88487j;
    }

    public String k() {
        return this.f88490m;
    }

    public int l() {
        return this.f88484g;
    }

    public int m() {
        return this.f88492o;
    }

    public String n() {
        return this.f88482e;
    }

    public String o() {
        return this.f88486i;
    }

    public int p() {
        return this.f88491n;
    }

    public boolean q() {
        return this.f88493p;
    }

    public void r(String str) {
        this.f88490m = str;
    }

    public void s(boolean z16) {
        this.f88493p = z16;
    }

    public String toString() {
        return "QFSPersonalFeedInfo{ownerUin='" + this.f88482e + "', coverUrl='" + a() + "', draftCount=" + this.f88487j + ", createTime=" + this.f88488k + ", sourceType=" + this.f88491n + ", itemType=" + this.f88492o + ", draftBeanList=" + this.f88489l + ", draftGuideInfo=" + this.f88490m + '}';
    }

    public k(String str, e30.b bVar, int i3, int i16) {
        this(str, bVar, i3);
        this.f88492o = i16;
    }
}
