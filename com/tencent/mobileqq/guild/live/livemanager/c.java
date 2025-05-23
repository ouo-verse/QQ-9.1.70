package com.tencent.mobileqq.guild.live.livemanager;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.tencent.gamecenter.wadl.api.impl.QQGameReportServiceImpl;
import com.tencent.mobileqq.guild.live.helper.GuildTimeRecHelper;
import com.tencent.mobileqq.guild.util.timerecord.GuildLiveTimeEvent;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveAudienceTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.PlayerConfig;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.QQLiveRoomStatusInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.mobileqq.guild.live.livemanager.player.b f226794f;

    /* renamed from: k, reason: collision with root package name */
    private final ILiveRoom f226799k;

    /* renamed from: a, reason: collision with root package name */
    private final GLiveChannelCore f226789a = GLiveChannelCore.f226698a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f226790b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f226791c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f226792d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f226793e = false;

    /* renamed from: g, reason: collision with root package name */
    private final LiveRoomStatusListener f226795g = new a();

    /* renamed from: h, reason: collision with root package name */
    private final RoomAudienceInfoListener f226796h = new b();

    /* renamed from: i, reason: collision with root package name */
    private final ReceiveGiftMessageListener f226797i = new C7814c();

    /* renamed from: j, reason: collision with root package name */
    private final AudienceRoomPlayerListener f226798j = new d();

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements LiveRoomStatusListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomClose(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "onRoomClose, closeType:" + qQLiveRoomStatusInfo.closeType + " closeReason:" + qQLiveRoomStatusInfo.closeReason + " liveType:" + c.this.f226789a.s().getLiveType() + " roomId:" + qQLiveRoomStatusInfo.roomID);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomOpen(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "onRoomOpen");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomPause(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "onRoomPause");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener
        public void onRoomResume(QQLiveRoomStatusInfo qQLiveRoomStatusInfo) {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "onRoomResume");
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class b implements RoomAudienceInfoListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener
        public void onAudienceEnterRoom(LiveMessageData.SpeakerInfo speakerInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("QGL.GuildLiveRoomListenerHandler", 4, "onAudienceEnterRoom, speakId=" + speakerInfo.mSpeakId + " speakName=" + speakerInfo.mSpeakerName);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener
        public void onRecAudienceInfo(RoomAudienceInfo roomAudienceInfo) {
            if (roomAudienceInfo != null) {
                c.this.f226789a.t().o0(roomAudienceInfo.userCount);
                if (QLog.isColorLevel()) {
                    QLog.d("QGL.GuildLiveRoomListenerHandler", 4, "onRecAudienceInfo fakeTotalPeople=" + roomAudienceInfo.fakeTotalPeople + " userCount=" + roomAudienceInfo.userCount);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QGL.GuildLiveRoomListenerHandler", 2, "onRecAudienceInfo is null");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.live.livemanager.c$c, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C7814c implements ReceiveGiftMessageListener {
        C7814c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onError(int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.d("QGL.GuildLiveRoomListenerHandler", 2, "onError,", Integer.valueOf(i3), "+ msg: ", str);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener
        public void onGiftMessageReceive(GiftMessage giftMessage) {
            if (QLog.isColorLevel()) {
                QLog.d("QGL.GuildLiveRoomListenerHandler", 2, "onGiftMessageReceive," + giftMessage.toString());
            }
            c.this.q(giftMessage);
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d extends rq1.a {
        d() {
        }

        private boolean a(String str) {
            if (!TextUtils.isEmpty(str) && str.startsWith("http") && str.contains(".flv")) {
                return true;
            }
            return false;
        }

        private boolean b() {
            return com.tencent.mobileqq.guild.live.helper.a.d().e();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onError(int i3, int i16, int i17, String str) {
            QLog.e("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onError," + c.this.p() + ",errorCode:" + i17 + ",msg:" + str);
            c.this.f226789a.t().j0(Boolean.TRUE);
            HashMap hashMap = new HashMap();
            hashMap.put("module", String.valueOf(i3));
            hashMap.put(QQGameReportServiceImpl.ATTA_KEY_ERROR_TYPE, String.valueOf(i16));
            c.this.n("live_room_player_error", i17, str, hashMap);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onFirstFrameCome(long j3, long j16) {
            long e16 = s.e(j3, j16);
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onFirstFrameCome. " + j3 + ":" + j16 + ":" + e16);
            GuildTimeRecHelper.e(GuildLiveTimeEvent.START_PLAY_BETWEEN_SHOW_FIRST_FRAME, j16);
            GuildTimeRecHelper.e(GuildLiveTimeEvent.AUDIENCE_PAGE_BETWEEN_SHOW_FIRST_FRAME, j16);
            GuildTimeRecHelper.e(GuildLiveTimeEvent.ANCHOR_PAGE_BETWEEN_SHOW_FIRST_FRAME, j16);
            GuildTimeRecHelper.e(GuildLiveTimeEvent.LAUNCH_BETWEEN_SHOW_FIRST_FRAME, j16);
            long j17 = (j16 - j3) - e16;
            if (j17 < 0) {
                j17 = 0;
            }
            c.this.t(Long.valueOf(j17));
            c.this.m("live_room_player_first_frame");
            c.this.f226789a.t().k0(Boolean.TRUE);
            c.this.f226789a.t().V(Boolean.valueOf(com.tencent.mobileqq.guild.live.viewmodel.d.P1()));
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onPause() {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onPause." + c.this.p());
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onPlay() {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onPlay." + c.this.p());
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onPlayCompleted() {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onPlayCompleted." + c.this.p());
            c.this.m("live_room_player_play_complete");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onPreparing(String str, PlayerConfig playerConfig) {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onPreparing," + c.this.p() + ",url:" + str);
            c.this.f226790b = a(str);
            if (c.this.f226790b) {
                c.this.f226792d = playerConfig.isEnableDownloadProxy;
                c.this.f226793e = playerConfig.isSupportQuicFLv;
            }
            c.this.f226791c = b();
            HashMap hashMap = new HashMap();
            hashMap.put("preparing_url", str);
            c.this.n("live_room_player_on_preparing", 0, "", hashMap);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onResume() {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "onResume." + c.this.p());
            c.this.f226789a.t().j0(Boolean.FALSE);
            c.this.m("live_room_player_resume");
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onStartBuffer() {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStartBuffer." + c.this.p());
            c.this.m("live_room_player_start_buffer");
            if (c.this.f226794f != null) {
                c.this.f226794f.c();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onStopBuffer() {
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onStopBuffer." + c.this.p());
            c.this.m("live_room_player_stop_buffer");
            if (c.this.f226794f != null) {
                c.this.f226794f.d();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener
        public void onVideoSizeChanged(int i3, int i16) {
            boolean z16 = true;
            QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "AudienceRoomPlayerListener onVideoSizeChanged," + c.this.p() + ",w:" + i3 + " h:" + i16);
            tq1.b t16 = c.this.f226789a.t();
            if (i3 < i16) {
                z16 = false;
            }
            t16.w0(Boolean.valueOf(z16));
            c.this.f226789a.t().x0(i3, i16);
            HashMap hashMap = new HashMap();
            hashMap.put("video_width", String.valueOf(i3));
            hashMap.put("video_height", String.valueOf(i16));
            c.this.n("live_room_player_size_changed", 0, "", hashMap);
        }
    }

    public c(@NonNull ILiveRoom iLiveRoom) {
        this.f226799k = iLiveRoom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        n(str, 0, "", new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, int i3, String str2, Map<String, String> map) {
        long roomId;
        String valueOf;
        if (this.f226799k.getRoomInfo() == null) {
            roomId = 0;
        } else {
            roomId = this.f226799k.getRoomInfo().getRoomId();
        }
        String l3 = Long.toString(roomId);
        BaseAnchorInfo anchorInfo = this.f226799k.getAnchorInfo();
        String str3 = "";
        if (anchorInfo == null) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(anchorInfo.getAnchorUid());
        }
        LiveData<Boolean> D = this.f226789a.t().D();
        if (D != null) {
            if (((Boolean) e12.d.b(D, Boolean.FALSE)).booleanValue()) {
                str3 = "1";
            } else {
                str3 = "0";
            }
        }
        map.putAll(s(l3, str3, valueOf));
        com.tencent.mobileqq.guild.performance.report.l.g(str, map, i3, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object p() {
        ILiveRoom iLiveRoom = this.f226799k;
        if (iLiveRoom instanceof ILiveAudienceTPPlayerRoom) {
            return ((ILiveAudienceTPPlayerRoom) iLiveRoom).getDisplayView().getCurrentDisplayView();
        }
        if (iLiveRoom instanceof IQQLiveAnchorThirdPushRoom) {
            return ((IQQLiveAnchorThirdPushRoom) iLiveRoom).getDisplayView().getCurrentDisplayView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(GiftMessage giftMessage) {
        if (giftMessage == null) {
            if (QLog.isColorLevel()) {
                QLog.i("QGL.GuildLiveRoomListenerHandler", 2, "giftMessage == null");
                return;
            }
            return;
        }
        this.f226789a.t().Y(giftMessage);
    }

    private Map<String, String> s(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(AudienceReportConst.ROOM_ID, str);
        hashMap.put("role", str2);
        hashMap.put("anchor_uid", str3);
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Long l3) {
        GuildLiveTimeEvent guildLiveTimeEvent;
        String guildId;
        long liveRoomId;
        QLog.d("QGL.GuildLiveRoomListenerHandler", 4, "reportFirstFrameTimeCost:" + l3);
        if (this.f226799k.isAnchorRoom()) {
            guildLiveTimeEvent = GuildLiveTimeEvent.ANCHOR_PAGE_BETWEEN_SHOW_FIRST_FRAME;
        } else {
            guildLiveTimeEvent = GuildLiveTimeEvent.AUDIENCE_PAGE_BETWEEN_SHOW_FIRST_FRAME;
        }
        long f16 = GuildTimeRecHelper.f(guildLiveTimeEvent);
        IGProChannelInfo channelInfo = this.f226789a.s().getChannelInfo();
        String str = "";
        if (channelInfo == null) {
            guildId = "";
        } else {
            guildId = channelInfo.getGuildId();
        }
        if (channelInfo != null) {
            str = channelInfo.getChannelUin();
        }
        String str2 = str;
        if (channelInfo == null) {
            liveRoomId = 0;
        } else {
            liveRoomId = channelInfo.getLiveRoomId();
        }
        long j3 = liveRoomId;
        if (this.f226799k.isAnchorRoom() && this.f226799k.getRoomInfo() != null) {
            this.f226799k.getRoomInfo().getRoomId();
        }
        boolean isAnchorRoom = this.f226799k.isAnchorRoom();
        com.tencent.mobileqq.guild.performance.report.k.d(true);
        com.tencent.mobileqq.guild.performance.report.k.b(guildId, str2, j3, isAnchorRoom, this.f226790b, this.f226791c, this.f226792d, this.f226793e, l3.longValue(), f16);
    }

    public void o() {
        QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "destroy." + this.f226799k);
        this.f226799k.unRegisterAudienceInfoListener(this.f226796h);
        this.f226799k.unRegisterReceiveGiftMessageListener(this.f226797i);
        this.f226799k.unRegisterRoomStatusListener(this.f226795g);
        ILiveRoom iLiveRoom = this.f226799k;
        if (iLiveRoom instanceof ILiveTPPlayerRoom) {
            ((ILiveTPPlayerRoom) iLiveRoom).unRegisterRoomPlayerListener(this.f226798j);
            s.i();
        }
        this.f226794f.e(this.f226789a.s().getChannelInfo(), this.f226799k, this.f226790b, this.f226791c);
    }

    public void r() {
        QLog.i("QGL.GuildLiveRoomListenerHandler", 1, "init." + this.f226799k);
        this.f226799k.registerAudienceInfoListener(this.f226796h);
        this.f226799k.registerReceiveGiftMessageListener(this.f226797i);
        this.f226799k.registerRoomStatusListener(this.f226795g);
        ILiveRoom iLiveRoom = this.f226799k;
        if (iLiveRoom instanceof ILiveTPPlayerRoom) {
            ((ILiveTPPlayerRoom) iLiveRoom).registerRoomPlayerListener(this.f226798j);
            s.h();
        }
        com.tencent.mobileqq.guild.live.livemanager.player.b bVar = new com.tencent.mobileqq.guild.live.livemanager.player.b();
        this.f226794f = bVar;
        bVar.b();
    }
}
