package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProRecommendEssenceSvrRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPollingChannelState;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bi {

    /* renamed from: a, reason: collision with root package name */
    private final GProPollingChannelState f265753a;

    /* renamed from: b, reason: collision with root package name */
    private final ChannelMemberInfos f265754b;

    /* renamed from: c, reason: collision with root package name */
    private final LiveRoomInfo f265755c;

    /* renamed from: d, reason: collision with root package name */
    private final GGProRecommendEssenceSvrRsp f265756d;

    /* renamed from: e, reason: collision with root package name */
    private final GGProAppChnnPreInfo f265757e;

    /* renamed from: f, reason: collision with root package name */
    private final GProOnlineMember f265758f;

    /* renamed from: g, reason: collision with root package name */
    private final GProChannelInfo f265759g;

    public bi(GProPollingChannelState gProPollingChannelState) {
        this.f265753a = gProPollingChannelState;
        ChannelMemberInfos channelMemberInfos = new ChannelMemberInfos(d(), gProPollingChannelState.getVoiceChannelPresence());
        this.f265754b = channelMemberInfos;
        channelMemberInfos.setUpdateTime(gProPollingChannelState.getUpdateTime());
        channelMemberInfos.setSource(gProPollingChannelState.getSource());
        LiveRoomInfo liveRoomInfo = new LiveRoomInfo(gProPollingChannelState.getLiveChannelPresence());
        this.f265755c = liveRoomInfo;
        liveRoomInfo.setUpdateTime(gProPollingChannelState.getUpdateTime());
        liveRoomInfo.setSource(gProPollingChannelState.getSource());
        this.f265757e = new GGProAppChnnPreInfo(gProPollingChannelState.getAppChannelPresence());
        this.f265758f = new GProOnlineMember(d(), gProPollingChannelState.getOnlineMemberInfo());
        this.f265756d = new GGProRecommendEssenceSvrRsp(gProPollingChannelState.getRecommendEssence());
        this.f265759g = new GProChannelInfo(gProPollingChannelState.getChannelInfo());
    }

    public GGProAppChnnPreInfo a() {
        return this.f265757e;
    }

    public String b() {
        return String.valueOf(this.f265753a.getChannelId());
    }

    public GProChannelInfo c() {
        return this.f265759g;
    }

    public String d() {
        return String.valueOf(this.f265753a.getGuildId());
    }

    public LiveRoomInfo e() {
        return this.f265755c;
    }

    public GProOnlineMember f() {
        return this.f265758f;
    }

    public GGProRecommendEssenceSvrRsp g() {
        return this.f265756d;
    }

    public ChannelMemberInfos h() {
        return this.f265754b;
    }
}
