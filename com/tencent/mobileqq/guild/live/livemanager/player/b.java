package com.tencent.mobileqq.guild.live.livemanager.player;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private long f226871a;

    /* renamed from: b, reason: collision with root package name */
    private long f226872b;

    /* renamed from: c, reason: collision with root package name */
    private int f226873c;

    /* renamed from: d, reason: collision with root package name */
    private int f226874d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f226875e = false;

    private void a(IGProChannelInfo iGProChannelInfo, ILiveRoom iLiveRoom, boolean z16, boolean z17, int i3, long j3, long j16, double d16) {
        Object obj;
        Object obj2;
        String guildId;
        long liveRoomId;
        HashMap hashMap = new HashMap();
        String str = "1";
        if (z16) {
            obj = "1";
        } else {
            obj = "0";
        }
        if (z17) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        hashMap.put("live_is_use_quic_flv_url", obj);
        hashMap.put("live_is_use_local_dns", obj2);
        ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(GuildHistogramScene.GUILD_LIVE_PLAY_BLOCK_RATE, hashMap, d16);
        if (d16 <= 20.0d) {
            return;
        }
        String str2 = "";
        if (iGProChannelInfo == null) {
            guildId = "";
        } else {
            guildId = iGProChannelInfo.getGuildId();
        }
        if (iGProChannelInfo != null) {
            str2 = iGProChannelInfo.getChannelUin();
        }
        long j17 = 0;
        if (iGProChannelInfo == null) {
            liveRoomId = 0;
        } else {
            liveRoomId = iGProChannelInfo.getLiveRoomId();
        }
        if (liveRoomId == 0 && iLiveRoom.isAnchorRoom() && iLiveRoom.getRoomInfo() != null) {
            liveRoomId = iLiveRoom.getRoomInfo().getRoomId();
        }
        boolean isAnchorRoom = iLiveRoom.isAnchorRoom();
        if (iLiveRoom.getAnchorInfo() != null) {
            j17 = iLiveRoom.getAnchorInfo().getAnchorUid();
        }
        if (!isAnchorRoom) {
            str = "0";
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("guild_id", guildId);
        hashMap2.put("channel_id", str2);
        hashMap2.put(AudienceReportConst.ROOM_ID, String.valueOf(liveRoomId));
        hashMap2.put("anchor_uid", String.valueOf(j17));
        hashMap2.put("role", str);
        hashMap2.put("live_is_use_quic_flv_url", obj);
        hashMap2.put("block_count", String.valueOf(i3));
        hashMap2.put("block_time", String.valueOf(j3));
        hashMap2.put("watch_time", String.valueOf(j16));
        hashMap2.put("block_rate", String.valueOf(d16));
        com.tencent.mobileqq.guild.performance.report.j.a("gpro_quality_time_cost_living_play_block", hashMap2);
    }

    public void b() {
        this.f226871a = System.currentTimeMillis();
        this.f226875e = true;
    }

    public void c() {
        this.f226872b = System.currentTimeMillis();
    }

    public void d() {
        this.f226874d = (int) (this.f226874d + (System.currentTimeMillis() - this.f226872b));
        this.f226873c++;
    }

    public void e(IGProChannelInfo iGProChannelInfo, ILiveRoom iLiveRoom, boolean z16, boolean z17) {
        if (!this.f226875e) {
            return;
        }
        this.f226875e = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f226871a;
        int i3 = this.f226874d;
        a(iGProChannelInfo, iLiveRoom, z16, z17, this.f226873c, i3, currentTimeMillis, (i3 * 100.0d) / currentTimeMillis);
        this.f226874d = 0;
        this.f226873c = 0;
        this.f226871a = 0L;
        this.f226872b = 0L;
    }
}
