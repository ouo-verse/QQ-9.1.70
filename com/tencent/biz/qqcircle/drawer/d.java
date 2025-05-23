package com.tencent.biz.qqcircle.drawer;

import feedcloud.FeedCloudMeta$StUser;
import java.util.List;
import trpcprotocol.feedcloud.sidebar.Header;
import trpcprotocol.feedcloud.sidebar.MedalInfo;
import trpcprotocol.feedcloud.sidebar.MedalWallInfo;
import trpcprotocol.feedcloud.sidebar.RedInfo;
import trpcprotocol.feedcloud.sidebar.RedType;
import trpcprotocol.feedcloud.sidebar.RocketInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Header f84390a;

    /* renamed from: b, reason: collision with root package name */
    private final FeedCloudMeta$StUser f84391b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f84392c = false;

    public d(Header header, FeedCloudMeta$StUser feedCloudMeta$StUser) {
        this.f84390a = header;
        this.f84391b = feedCloudMeta$StUser;
    }

    public boolean a() {
        Header header;
        RocketInfo rocketInfo;
        RedInfo redInfo;
        if (this.f84392c || (header = this.f84390a) == null || (rocketInfo = header.rocketInfo) == null || (redInfo = rocketInfo.redInfo) == null || redInfo.redType.getValue() != RedType.RED_TYPE_SMALL.getValue()) {
            return false;
        }
        return true;
    }

    public String b() {
        MedalWallInfo medalWallInfo;
        Header header = this.f84390a;
        if (header != null && (medalWallInfo = header.medalWall) != null) {
            return medalWallInfo.jumpURL;
        }
        return "";
    }

    public List<MedalInfo> c() {
        MedalWallInfo medalWallInfo;
        Header header = this.f84390a;
        if (header != null && (medalWallInfo = header.medalWall) != null) {
            return medalWallInfo.medalInfos;
        }
        return null;
    }

    public List<MedalInfo> d() {
        MedalWallInfo medalWallInfo;
        Header header = this.f84390a;
        if (header != null && (medalWallInfo = header.medalWall) != null) {
            return medalWallInfo.newMedalInfos;
        }
        return null;
    }

    public String e() {
        return this.f84391b.nick.get();
    }

    public long f() {
        RocketInfo rocketInfo;
        Header header = this.f84390a;
        if (header != null && (rocketInfo = header.rocketInfo) != null) {
            return rocketInfo.count;
        }
        return 0L;
    }

    public String g() {
        RocketInfo rocketInfo;
        Header header = this.f84390a;
        if (header != null && (rocketInfo = header.rocketInfo) != null) {
            return rocketInfo.url;
        }
        return "";
    }

    public FeedCloudMeta$StUser h() {
        return this.f84391b;
    }

    public boolean i() {
        MedalWallInfo medalWallInfo;
        Header header = this.f84390a;
        if (header != null && (medalWallInfo = header.medalWall) != null && medalWallInfo.needRedPoint) {
            return true;
        }
        return false;
    }

    public void j() {
        this.f84392c = true;
    }
}
