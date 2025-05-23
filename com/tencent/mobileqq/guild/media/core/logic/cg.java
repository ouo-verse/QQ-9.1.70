package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.logic.s;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.media.widget.GuildMediaFacesController;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.window.GuildFloatWindowManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010'\u001a\u00020%\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u000e\u001a\u00020\u00042\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\r\u001a\u00020\fH\u0002J,\u0010\u000f\u001a\u00020\u00062\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\r\u001a\u00020\fH\u0002J$\u0010\u0010\u001a\u00020\f2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u0002J*\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J2\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J(\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J<\u0010 \u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\r\u001a\u00020\fH\u0016J8\u0010$\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\"\u001a\u00020!2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0\bj\b\u0012\u0004\u0012\u00020!`\nH\u0016R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010&R0\u0010+\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0(j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/cg;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$b;", "", "userId", "", "available", "", DomainData.DOMAIN_NAME, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$TRTCVolumeInfo;", "Lkotlin/collections/ArrayList;", "userVolumes", "", "totalVolume", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "roomId", "roomType", "reason", "msg", "d", "a", "g", "b", "f", "width", "height", tl.h.F, "errorCode", "errorMsg", "e", "c", "Lcom/tencent/mobileqq/guild/media/core/data/TRTCQuality;", "localQuality", "remoteQuality", "i", "Lcom/tencent/mobileqq/guild/media/core/f;", "Lcom/tencent/mobileqq/guild/media/core/f;", "core", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "lastUserVolumeList", "I", "lastTotalVolume", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class cg implements ITRTCAudioRoom.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f core;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, ITRTCAudioRoom.TRTCVolumeInfo> lastUserVolumeList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int lastTotalVolume;

    public cg(@NotNull com.tencent.mobileqq.guild.media.core.f core) {
        Intrinsics.checkNotNullParameter(core, "core");
        this.core = core;
        this.lastUserVolumeList = new HashMap<>();
        this.lastTotalVolume = -1;
    }

    private final boolean k(ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes, int totalVolume) {
        int i3;
        if (!com.tencent.mobileqq.guild.media.core.o.b(this.core.o0())) {
            QLog.w("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCUserVoiceVolume ignore when out room!");
            return true;
        }
        if (totalVolume != this.lastTotalVolume) {
            l(userVolumes, totalVolume);
            return false;
        }
        int size = this.lastUserVolumeList.size();
        if (userVolumes != null) {
            i3 = userVolumes.size();
        } else {
            i3 = 0;
        }
        if (size != i3) {
            l(userVolumes, totalVolume);
            return false;
        }
        if (userVolumes != null) {
            for (ITRTCAudioRoom.TRTCVolumeInfo tRTCVolumeInfo : userVolumes) {
                if (!tRTCVolumeInfo.f(this.lastUserVolumeList.get(tRTCVolumeInfo.f228504d))) {
                    l(userVolumes, totalVolume);
                    return false;
                }
            }
        }
        return true;
    }

    private final void l(ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes, int totalVolume) {
        this.lastTotalVolume = totalVolume;
        this.lastUserVolumeList.clear();
        if (userVolumes != null) {
            for (ITRTCAudioRoom.TRTCVolumeInfo tRTCVolumeInfo : userVolumes) {
                HashMap<String, ITRTCAudioRoom.TRTCVolumeInfo> hashMap = this.lastUserVolumeList;
                String str = tRTCVolumeInfo.f228504d;
                Intrinsics.checkNotNullExpressionValue(str, "userVolume.userId");
                ITRTCAudioRoom.TRTCVolumeInfo b16 = tRTCVolumeInfo.b();
                Intrinsics.checkNotNullExpressionValue(b16, "userVolume.copy()");
                hashMap.put(str, b16);
            }
        }
    }

    private final int m(ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes) {
        Object obj;
        if (userVolumes != null) {
            Iterator<T> it = userVolumes.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((ITRTCAudioRoom.TRTCVolumeInfo) obj).f228504d, this.core.getSelfUserInfo().f228093a)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ITRTCAudioRoom.TRTCVolumeInfo tRTCVolumeInfo = (ITRTCAudioRoom.TRTCVolumeInfo) obj;
            if (tRTCVolumeInfo != null) {
                return tRTCVolumeInfo.f228505e;
            }
        }
        return this.core.getSelfUserInfo().f228109q;
    }

    private final void n(String userId, boolean available) {
        this.core.l0().s(userId, available);
        this.core.l0().m("pushOnTRTCVideoAvailable", this.core.getSelfUserInfo());
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void a(@NotNull String roomId, int roomType, @Nullable String userId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (com.tencent.mobileqq.guild.media.core.o.b(this.core.o0()) && userId != null) {
            QLog.d("QGMC.TRTCPushObserverHelper", 4, "[pushOnTRTCAnchorEnter] roomId:" + roomId + " roomType:" + roomType + " userId:" + userId);
            this.core.A0().a(userId);
            return;
        }
        QLog.w("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCAnchorEnter when not in room! or userId is null");
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void b(@NotNull String roomId, int roomType, @Nullable String userId, boolean available) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (com.tencent.mobileqq.guild.media.core.o.b(this.core.o0()) && userId != null) {
            this.core.A0().e(userId, available);
            Logger logger = Logger.f235387a;
            logger.d().i("QGMC.TRTCPushObserverHelper", 1, "onTRTCAudioAvailable roomId:" + roomId + " roomType:" + roomType + " userId:" + userId + ", available:" + available + ", tid:" + Thread.currentThread().getId());
            com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
            if (selfUserInfo.R && Intrinsics.areEqual(selfUserInfo.f228093a, userId)) {
                selfUserInfo.f228108p = true;
            }
            com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(userId);
            if (g16 != null) {
                QLog.i("QGMC.TRTCPushObserverHelper", 1, "onTRTCAudioAvailable 2");
                g16.f228108p = true;
                int k3 = g16.k();
                if (QLog.isColorLevel()) {
                    logger.d().d("QGMC.TRTCPushObserverHelper", 2, "[setRemoteAudioVolume] " + userId + ", realVolume:" + k3);
                }
                this.core.y0().setRemoteAudioVolume(userId, k3);
            } else {
                int k06 = com.tencent.mobileqq.guild.util.bw.k0(userId);
                if (QLog.isColorLevel()) {
                    logger.d().d("QGMC.TRTCPushObserverHelper", 2, "[setRemoteAudioVolume] " + userId + ", cacheVolume realVolume:" + k06);
                }
                this.core.y0().setRemoteAudioVolume(userId, k06);
            }
            this.core.l0().m("pushOnTRTCAudioAvailable", this.core.getSelfUserInfo());
            if (Intrinsics.areEqual(userId, this.core.getSelfUserInfo().f228093a)) {
                this.core.l0().m("pushOnSelfTRTCAudioAvailable", this.core.getSelfUserInfo());
                return;
            }
            return;
        }
        QLog.w("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCAudioAvailable when not in room! or userId is null");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0076 A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(@NotNull String roomId, int roomType, @Nullable ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes, int totalVolume) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (this.core.v0().k().getDisConnectTRTCSeconds() > 0) {
            if (totalVolume == 0 && m(userVolumes) == 0 && this.core.v0().getUserInfoList().h() == null) {
                this.core.Q().g0(false);
            } else {
                this.core.Q().y();
            }
        } else {
            this.core.Q().y();
        }
        if (k(userVolumes, totalVolume)) {
            QLog.i("QGMC.TRTCPushObserverHelper", 2, "[pushOnTRTCUserVoiceVolume] same item. ignore");
            return;
        }
        this.core.A0().h(userVolumes);
        Iterator<com.tencent.mobileqq.guild.media.core.data.p> it = this.core.D0().f228125a.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mobileqq.guild.media.core.data.p next = it.next();
            Intrinsics.checkNotNull(userVolumes);
            Iterator<ITRTCAudioRoom.TRTCVolumeInfo> it5 = userVolumes.iterator();
            while (it5.hasNext()) {
                ITRTCAudioRoom.TRTCVolumeInfo next2 = it5.next();
                if (!Intrinsics.areEqual(next.f228093a, next2.f228504d)) {
                    String str = next2.f228504d;
                    Intrinsics.checkNotNullExpressionValue(str, "trtcVolumeInfo.userId");
                    long k3 = GuildMediaFacesController.k(Long.parseLong(str), next.f228093a);
                    String str2 = next2.f228504d;
                    Intrinsics.checkNotNullExpressionValue(str2, "trtcVolumeInfo.userId");
                    if (k3 == Long.parseLong(str2)) {
                    }
                }
                next.f228109q = next2.f228505e;
                next.D = next2.f228506f;
                if (Intrinsics.areEqual(next.f228093a, this.core.getSelfUserInfo().f228093a)) {
                    this.core.getSelfUserInfo().f228109q = next.f228109q;
                    this.core.getSelfUserInfo().D = next.D;
                }
                if (!next.f228101i && next.f228109q > 5 && !next.f228108p) {
                    next.f228101i = true;
                    next.f228108p = true;
                }
                if (z16) {
                    next.f228109q = 0;
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        if (GuildFloatWindowManager.f236656d.i() && !com.tencent.mobileqq.guild.media.core.m.a(com.tencent.mobileqq.guild.media.core.j.c())) {
            this.core.l0().q(this.core.getSelfUserInfo(), this.core.D0());
            com.tencent.mobileqq.guild.media.core.data.r D0 = this.core.D0();
            HashMap hashMap = new HashMap(D0.f228125a.size());
            int size = D0.f228125a.size();
            for (int i3 = 0; i3 < size; i3++) {
                com.tencent.mobileqq.guild.media.core.data.p pVar = D0.f228125a.get(i3);
                Intrinsics.checkNotNullExpressionValue(pVar, "userInfoList.anchors.get(i)");
                com.tencent.mobileqq.guild.media.core.data.p pVar2 = pVar;
                if (pVar2.f228109q > 0) {
                    String str3 = pVar2.f228093a;
                    Intrinsics.checkNotNullExpressionValue(str3, "userInfo.id");
                    hashMap.put(str3, pVar2);
                }
            }
            if (!hashMap.isEmpty()) {
                this.core.v0().a0().postValue(hashMap);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void d(@NotNull String roomId, int roomType, int reason, @Nullable String msg2) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        QLog.e("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCExitRoom roomId:" + roomId + " roomType:" + roomType + " reason:" + reason + ", msg:" + msg2);
        if (roomType == 0 && reason == 2) {
            this.core.isInChannel();
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void e(@NotNull String roomId, int roomType, int errorCode, @NotNull String errorMsg) {
        String str;
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        QLog.w("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCError: roomId[" + roomId + "] roomType[" + roomType + "] errCode[" + errorCode + "] errMsg[" + errorMsg + "]");
        com.tencent.mobileqq.guild.media.core.data.b.c("trtc_err", errorCode, String.valueOf(this.core.o0().getStartParams().getChannelType()));
        a.b(this.core.m0(), "audio_room_error", this.core.getGuildID(), this.core.E(), 3, com.tencent.mobileqq.guild.media.core.data.b.a(3, errorCode, errorMsg, this.core.getGuildID()), errorCode, errorMsg, null, 128, null);
        if (errorCode == -7001) {
            str = QQGuildUIUtil.r(R.string.f1498513e);
        } else {
            str = "";
        }
        this.core.D(str, "pushOnTRTCError, errorCode:" + errorCode + ", errorMsg:" + errorMsg);
        AudioNotifyHelper l06 = this.core.l0();
        String str2 = this.core.getSelfUserInfo().P;
        Intrinsics.checkNotNullExpressionValue(str2, "core.getSelfUserInfo().guildId");
        String str3 = this.core.getSelfUserInfo().Q;
        Intrinsics.checkNotNullExpressionValue(str3, "core.getSelfUserInfo().channelId");
        String a16 = com.tencent.mobileqq.guild.media.core.data.b.a(3, errorCode, errorMsg, this.core.getGuildID());
        Intrinsics.checkNotNullExpressionValue(a16, "getErrorTypeMsg(AudioRoo\u2026orMsg, core.getGuildID())");
        l06.f(str2, str3, 3, a16, errorCode, errorMsg);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void f(@NotNull String roomId, int roomType, @Nullable String userId, boolean available) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (com.tencent.mobileqq.guild.media.core.o.b(this.core.o0()) && userId != null) {
            this.core.A0().f(userId, available);
            Logger logger = Logger.f235387a;
            logger.d().i("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCVideoAvailable roomId:" + roomId + ", roomType:" + roomType + ", userId:" + userId + ", available:" + available + ", tid:" + Thread.currentThread().getId());
            com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
            if (selfUserInfo.R && Intrinsics.areEqual(selfUserInfo.f228093a, userId)) {
                selfUserInfo.f228103k = available;
                if (available) {
                    if (!selfUserInfo.f228101i) {
                        this.core.y0().a();
                    }
                    this.core.y0().b(1);
                } else {
                    this.core.y0().b(com.tencent.mobileqq.guild.util.bw.k());
                }
            }
            if (available) {
                com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.D0().g(userId);
                if (g16 != null) {
                    this.core.w0().e(g16);
                    logger.d().i("QGMC.TRTCPushObserverHelper", 1, "[pushOnTRTCVideoAvailable] update anchor info: " + this.core.w0());
                }
            } else {
                this.core.H0().n(userId);
            }
            Iterator<com.tencent.mobileqq.guild.media.core.data.p> it = this.core.D0().f228125a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.mobileqq.guild.media.core.data.p next = it.next();
                if (Intrinsics.areEqual(next.f228093a, userId)) {
                    QLog.i("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCVideoAvailable " + available);
                    next.f228103k = available;
                    break;
                }
            }
            n(userId, available);
            return;
        }
        QLog.w("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCVideoAvailable when not in room! or userId is null");
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void g(@NotNull String roomId, int roomType, @Nullable String userId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (com.tencent.mobileqq.guild.media.core.o.b(this.core.o0()) && userId != null) {
            QLog.d("QGMC.TRTCPushObserverHelper", 4, "[pushOnTRTCAnchorExit] roomId:" + roomId + " roomType:" + roomType + " userId:" + userId);
            if (Intrinsics.areEqual(userId, this.core.getSelfUserInfo().f228093a) && this.core.getSelfUserInfo().f228103k) {
                s.a.a(this.core.W(), false, false, 2, null);
            }
            this.core.A0().d(userId);
            return;
        }
        QLog.w("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCAnchorExit when not in room! or userId is null");
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void h(@NotNull String roomId, int roomType, @Nullable String userId, int width, int height) {
        boolean z16;
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (!com.tencent.mobileqq.guild.media.core.o.b(this.core.o0())) {
            QLog.w("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCVideoSizeChange when not in room! ");
            return;
        }
        Logger.f235387a.d().i("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCVideoSizeChange roomId:" + roomId + ", roomType:" + roomType + ", userId:" + userId + ", w:" + width + ", h:" + height + ", tid:" + Thread.currentThread().getId() + ", tName:" + Thread.currentThread().getName());
        if (userId != null && userId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            userId = this.core.getSelfUserInfo().f228093a;
        }
        this.core.A0().g(userId, width, height);
        com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = this.core.getSelfUserInfo();
        if (selfUserInfo.R && Intrinsics.areEqual(selfUserInfo.f228093a, userId)) {
            selfUserInfo.f228106n = width;
            selfUserInfo.f228107o = height;
        }
        for (com.tencent.mobileqq.guild.media.core.data.p pVar : this.core.D0().f228125a) {
            if (Intrinsics.areEqual(pVar.f228093a, userId) && (pVar.f228106n != width || pVar.f228107o != height)) {
                QLog.i("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCVideoSizeChange and change w&h.");
                pVar.f228106n = width;
                pVar.f228107o = height;
                us1.b H0 = this.core.H0();
                Intrinsics.checkNotNullExpressionValue(userId, "tinyId");
                H0.N(userId, width, height);
                this.core.l0().t(userId, width, height);
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void i(@NotNull String roomId, int roomType, @NotNull TRTCQuality localQuality, @NotNull ArrayList<TRTCQuality> remoteQuality) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        Intrinsics.checkNotNullParameter(localQuality, "localQuality");
        Intrinsics.checkNotNullParameter(remoteQuality, "remoteQuality");
        if (!this.core.isInChannel()) {
            QLog.w("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCNetworkQuality when not in room! ");
            return;
        }
        Logger.f235387a.d().i("QGMC.TRTCPushObserverHelper", 1, "pushOnTRTCNetworkQuality roomId:" + roomId + ", roomType:" + roomType);
        IRuntimeService runtimeService = this.core.getQQAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "runtimeService");
        ((IGPSService) runtimeService).setMyVoiceNetworkQuality(this.core.getGuildID(), this.core.E(), localQuality.getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String());
        if (Intrinsics.areEqual(this.core.o0().getSelfUserInfo().f228093a, localQuality.getUserId())) {
            this.core.o0().getSelfUserInfo().A = localQuality.getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String();
            this.core.o0().getSelfUserInfo().N.postValue(Integer.valueOf(localQuality.getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String()));
            com.tencent.mobileqq.guild.media.core.data.p g16 = this.core.o0().getUserInfoList().g(localQuality.getUserId());
            if (g16 != null) {
                g16.A = localQuality.getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String();
            }
        }
        if (Intrinsics.areEqual(this.core.o0().getScreenShareAnchorInfo().f228093a, localQuality.getUserId())) {
            this.core.o0().getScreenShareAnchorInfo().A = localQuality.getCom.tencent.hippy.qq.adapter.image.CustomImageProps.QUALITY java.lang.String();
        }
        remoteQuality.add(localQuality);
        AudioNotifyHelper l06 = this.core.l0();
        String str = this.core.getSelfUserInfo().Q;
        Intrinsics.checkNotNullExpressionValue(str, "core.getSelfUserInfo().channelId");
        l06.p(str, remoteQuality);
    }
}
