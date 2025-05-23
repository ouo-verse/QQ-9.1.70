package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.guild.media.core.data.MediaRoomStatus;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.logic.EnterTrtcRoomReq;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u000241B\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0016\u0010\n\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!H\u0016J\u001a\u0010$\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u001d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020!H\u0016J\b\u0010*\u001a\u00020\u0006H\u0016J\b\u0010+\u001a\u00020\u0006H\u0016J\u0018\u0010/\u001a\u00020!2\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020-H\u0016J\u0018\u00102\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020-H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\b\u00104\u001a\u00020\u0006H\u0016J\u0016\u00106\u001a\u00020\u00062\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0012\u00108\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u000409j\b\u0012\u0004\u0012\u00020\u0004`:H\u0016J\b\u0010<\u001a\u00020-H\u0016R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010>R\u0014\u0010A\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010CR \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\r0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010F\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ag;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/n;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/d;", "", "Lcom/tencent/mobileqq/guild/media/core/data/g;", "mediaRoomParamList", "", "t", "u", "trtcRoomList", "N", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/t;", "D", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/s;", "subTRTCRoom", "J", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$a;", "callback", "I", "Lcom/tencent/mobileqq/guild/media/core/logic/l;", "req", "k", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/r;", "H", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$b;", "listener", UserInfo.SEX_FEMALE, "L", "M", "", "privateMapKey", "E", "G", "", "audioIsOpen", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "subRoomId", "f", "userId", "mute", "muteRemoteAudio", "B", "d", "roomId", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "mode", "b", "setRemoteAudioVolume", "K", "a", "trtcRoomIdList", "c", "targetRoomId", "l", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ag$a;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ag$a;", "audioPlayStrategies", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/r;", "mainTRTCRoom", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ab;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ab;", "roomProxyListener", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "subRoomMap", "<init>", "()V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ag implements n, d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private a audioPlayStrategies = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final r mainTRTCRoom = new r();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ab roomProxyListener = new ab();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, s> subRoomMap = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR3\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000e0\u001dj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000e`\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u0007\u0010\"R3\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00160\u001dj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u0016`\u001f8\u0006\u00a2\u0006\f\n\u0004\b$\u0010!\u001a\u0004\b\u000f\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ag$a;", "", "Lcom/tencent/trtc/TRTCCloud;", "trtcCloud", "", "c", "Lcom/tencent/trtc/TRTCCloudDef$TRTCNetworkQosParam;", "a", "Lcom/tencent/trtc/TRTCCloudDef$TRTCNetworkQosParam;", "getQosParam", "()Lcom/tencent/trtc/TRTCCloudDef$TRTCNetworkQosParam;", "setQosParam", "(Lcom/tencent/trtc/TRTCCloudDef$TRTCNetworkQosParam;)V", "qosParam", "", "b", "Ljava/lang/Boolean;", "getMuteAllRemoteAudio", "()Ljava/lang/Boolean;", "setMuteAllRemoteAudio", "(Ljava/lang/Boolean;)V", "muteAllRemoteAudio", "", "I", "getEnableAudioVolumeEvaluation", "()I", "setEnableAudioVolumeEvaluation", "(I)V", "enableAudioVolumeEvaluation", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "muteRemoteAudioMap", "e", "remoteAudioVolumeMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private TRTCCloudDef.TRTCNetworkQosParam qosParam;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Boolean muteAllRemoteAudio;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int enableAudioVolumeEvaluation;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HashMap<String, Boolean> muteRemoteAudioMap;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HashMap<String, Integer> remoteAudioVolumeMap;

        public a() {
            TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam = new TRTCCloudDef.TRTCNetworkQosParam();
            tRTCNetworkQosParam.preference = 1;
            this.qosParam = tRTCNetworkQosParam;
            this.enableAudioVolumeEvaluation = 600;
            this.muteRemoteAudioMap = new HashMap<>();
            this.remoteAudioVolumeMap = new HashMap<>();
        }

        @NotNull
        public final HashMap<String, Boolean> a() {
            return this.muteRemoteAudioMap;
        }

        @NotNull
        public final HashMap<String, Integer> b() {
            return this.remoteAudioVolumeMap;
        }

        public final void c(@NotNull TRTCCloud trtcCloud) {
            Intrinsics.checkNotNullParameter(trtcCloud, "trtcCloud");
            trtcCloud.setNetworkQosParam(this.qosParam);
            Boolean bool = this.muteAllRemoteAudio;
            if (bool != null) {
                trtcCloud.muteAllRemoteAudio(bool.booleanValue());
            }
            trtcCloud.enableAudioVolumeEvaluation(this.enableAudioVolumeEvaluation, true);
            for (Map.Entry<String, Boolean> entry : this.muteRemoteAudioMap.entrySet()) {
                trtcCloud.muteRemoteAudio(entry.getKey(), entry.getValue().booleanValue());
            }
            for (Map.Entry<String, Integer> entry2 : this.remoteAudioVolumeMap.entrySet()) {
                trtcCloud.setRemoteAudioVolume(entry2.getKey(), entry2.getValue().intValue());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J,\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J>\u0010\u0013\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/trtc/ag$c", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$b;", "", "roomId", "", "roomType", "userId", "", "available", "", "b", "errorCode", "errorMsg", "e", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/logic/trtc/ITRTCAudioRoom$TRTCVolumeInfo;", "Lkotlin/collections/ArrayList;", "userVolumes", "totalVolume", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ITRTCAudioRoom.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
        public /* synthetic */ void a(String str, int i3, String str2) {
            b.a(this, str, i3, str2);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
        public void b(@Nullable String roomId, int roomType, @Nullable String userId, boolean available) {
            ag.this.roomProxyListener.b(roomId, roomType, userId, available);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
        public void c(@Nullable String roomId, int roomType, @Nullable ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> userVolumes, int totalVolume) {
            ag.this.roomProxyListener.c(roomId, roomType, userVolumes, totalVolume);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
        public /* synthetic */ void d(String str, int i3, int i16, String str2) {
            b.c(this, str, i3, i16, str2);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
        public void e(@Nullable String roomId, int roomType, int errorCode, @Nullable String errorMsg) {
            ag.this.roomProxyListener.e(roomId, roomType, errorCode, errorMsg);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
        public /* synthetic */ void f(String str, int i3, String str2, boolean z16) {
            b.e(this, str, i3, str2, z16);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
        public /* synthetic */ void g(String str, int i3, String str2) {
            b.b(this, str, i3, str2);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
        public /* synthetic */ void h(String str, int i3, String str2, int i16, int i17) {
            b.f(this, str, i3, str2, i16, i17);
        }

        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
        public /* synthetic */ void i(String str, int i3, TRTCQuality tRTCQuality, ArrayList arrayList) {
            b.d(this, str, i3, tRTCQuality, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(ITRTCAudioRoom.a aVar, ag this$0, String subRoomId, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(subRoomId, "$subRoomId");
        Logger.f235387a.d().d("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "[exitSubRoom] exitRoom code " + i3 + ", msg " + str);
        if (aVar != null) {
            aVar.onCallback(i3, str);
        }
        if (i3 >= 0) {
            this$0.subRoomMap.remove(subRoomId);
            if (this$0.subRoomMap.isEmpty()) {
                this$0.roomProxyListener.l();
            }
        }
    }

    private final t D() {
        Object obj;
        if (!this.subRoomMap.isEmpty() && !this.mainTRTCRoom.getMEnableTRTCPublish()) {
            Collection<s> values = this.subRoomMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "subRoomMap.values");
            Iterator<T> it = values.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((s) obj).getMEnableTRTCPublish()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            s sVar = (s) obj;
            if (sVar == null) {
                return this.mainTRTCRoom;
            }
            return sVar;
        }
        return this.mainTRTCRoom;
    }

    private final void J(s subTRTCRoom) {
        this.roomProxyListener.m();
        subTRTCRoom.F(new c());
    }

    private final void N(List<MediaRoomStatus> trtcRoomList) {
        boolean z16;
        for (MediaRoomStatus mediaRoomStatus : trtcRoomList) {
            if (mediaRoomStatus.d()) {
                this.mainTRTCRoom.c0(mediaRoomStatus);
            } else {
                if (mediaRoomStatus.getRoomStrId().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    s sVar = this.subRoomMap.get(mediaRoomStatus.getRoomStrId());
                    if (sVar != null) {
                        sVar.c0(mediaRoomStatus);
                    }
                } else {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "[updateTRTCRoomListStatus] error " + mediaRoomStatus;
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, (String) it.next(), null);
                    }
                }
            }
        }
    }

    private final void t(List<MediaRoomStatus> mediaRoomParamList) {
        Object obj;
        String str;
        boolean z16;
        String G = G();
        String b16 = com.tencent.mobileqq.guild.media.core.m.b(com.tencent.mobileqq.guild.media.core.j.c());
        Iterator<T> it = mediaRoomParamList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MediaRoomStatus) obj).getEnableTRTCPublish()) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MediaRoomStatus mediaRoomStatus = (MediaRoomStatus) obj;
        if (mediaRoomStatus == null || (str = mediaRoomStatus.getRoomStrId()) == null) {
            str = b16;
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            b16 = str;
        }
        if (!Intrinsics.areEqual(G, b16)) {
            u();
        }
    }

    private final void u() {
        t D = D();
        if (D.getMEnableTRTCPublish()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[disableTRTCPublish] roomId[" + D.R() + "]";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, (String) it.next(), null);
            }
            D.b0();
            D.L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(ITRTCAudioRoom.a aVar, int i3, String str) {
        if (aVar != null) {
            aVar.onCallback(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(s it, int i3, String str) {
        Intrinsics.checkNotNullParameter(it, "$it");
        Logger.f235387a.d().d("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "[exitSubRoom] subRoom[" + it.R() + "] exit code " + i3 + ", msg " + str);
    }

    public void B() {
        D().B();
    }

    public final void E(@Nullable String privateMapKey) {
        if (TextUtils.isEmpty(privateMapKey)) {
            QLog.e("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "updatePrivateMapKey empty\uff0cplease check!");
        } else {
            D().E(privateMapKey);
        }
    }

    public final void F(@Nullable ITRTCAudioRoom.b listener) {
        this.roomProxyListener.t(listener);
        this.mainTRTCRoom.F(this.roomProxyListener);
        Collection<s> values = this.subRoomMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "subRoomMap.values");
        for (s it : values) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            J(it);
        }
    }

    @NotNull
    public final String G() {
        return D().R();
    }

    @NotNull
    /* renamed from: H, reason: from getter */
    public final r getMainTRTCRoom() {
        return this.mainTRTCRoom;
    }

    public final void I(@Nullable ITRTCAudioRoom.a callback) {
        QLog.i("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "exit room.");
        this.audioPlayStrategies = new a();
        Collection<s> values = this.subRoomMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "subRoomMap.values");
        for (final s sVar : values) {
            sVar.f(sVar.R(), new ITRTCAudioRoom.a() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.ad
                @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
                public final void onCallback(int i3, String str) {
                    ag.x(s.this, i3, str);
                }
            });
        }
        this.subRoomMap.clear();
        this.mainTRTCRoom.I(callback);
    }

    public void K() {
        QLog.i("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "startMicrophone.");
        D().K();
    }

    public final void L() {
        D().a0();
    }

    public final void M() {
        D().b0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.d
    public void a() {
        QLog.i("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "stopMicrophone.");
        D().a();
    }

    public void b(int mode) {
        QLog.i("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "setAudioMode " + mode);
        D().b(mode);
    }

    public void c(@NotNull List<MediaRoomStatus> trtcRoomIdList) {
        Intrinsics.checkNotNullParameter(trtcRoomIdList, "trtcRoomIdList");
        Logger logger = Logger.f235387a;
        logger.d().d("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "[updateTRTCRoomListStatus] trtcRoomIdList  " + trtcRoomIdList);
        t(trtcRoomIdList);
        N(trtcRoomIdList);
        if (this.subRoomMap.isEmpty()) {
            this.roomProxyListener.l();
        }
        logger.d().d("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "[updateTRTCRoomListStatus] enableTRTCPublish Room id: " + G());
    }

    public void d() {
        D().d();
    }

    public void f(@NotNull final String subRoomId, @Nullable final ITRTCAudioRoom.a callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(subRoomId, "subRoomId");
        if (!this.subRoomMap.isEmpty()) {
            if (subRoomId.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && this.subRoomMap.containsKey(subRoomId)) {
                Logger.f235387a.d().d("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "[exitSubRoom] subRoomId " + subRoomId + ", subRoomMap size " + this.subRoomMap.size());
                s sVar = this.subRoomMap.get(subRoomId);
                if (sVar != null) {
                    sVar.a();
                    sVar.L();
                    sVar.f(subRoomId, new ITRTCAudioRoom.a() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.ae
                        @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
                        public final void onCallback(int i3, String str) {
                            ag.C(ITRTCAudioRoom.a.this, this, subRoomId, i3, str);
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (callback != null) {
            callback.onCallback(0, "room[" + subRoomId + "] is empty!");
        }
    }

    public void i(boolean audioIsOpen) {
        QLog.d("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "enableAudioRecord " + audioIsOpen);
        D().i(audioIsOpen);
    }

    @NotNull
    public ArrayList<MediaRoomStatus> j() {
        int collectionSizeOrDefault;
        ArrayList<MediaRoomStatus> arrayList = new ArrayList<>();
        Collection<s> values = this.subRoomMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "subRoomMap.values");
        Collection<s> collection = values;
        boolean z16 = false;
        if (!collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((s) it.next()).getMEnableTRTCPublish()) {
                    z16 = true;
                    break;
                }
            }
        }
        if (!z16) {
            this.mainTRTCRoom.O();
        }
        arrayList.add(this.mainTRTCRoom.X());
        Collection<s> values2 = this.subRoomMap.values();
        Intrinsics.checkNotNullExpressionValue(values2, "subRoomMap.values");
        Collection<s> collection2 = values2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = collection2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((s) it5.next()).X());
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public final void k(@NotNull EnterTrtcRoomReq req, @Nullable ITRTCAudioRoom.a callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        getMainTRTCRoom().k(req, callback);
    }

    public void l(@Nullable String targetRoomId) {
        boolean z16;
        String G = G();
        if (targetRoomId != null && targetRoomId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !Intrinsics.areEqual(G, targetRoomId)) {
            Logger.f235387a.d().d("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "[switchRoom] targetRoomId " + targetRoomId);
            u();
            if (Intrinsics.areEqual(this.mainTRTCRoom.R(), targetRoomId)) {
                this.mainTRTCRoom.O();
                Iterator<Map.Entry<String, s>> it = this.subRoomMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().L();
                }
                return;
            }
            this.mainTRTCRoom.L();
            Iterator<Map.Entry<String, s>> it5 = this.subRoomMap.entrySet().iterator();
            while (it5.hasNext()) {
                it5.next().getValue().L();
            }
            s sVar = this.subRoomMap.get(targetRoomId);
            if (sVar != null) {
                sVar.O();
            }
        }
    }

    public void m(@NotNull EnterTrtcRoomReq req, @Nullable final ITRTCAudioRoom.a callback) {
        Intrinsics.checkNotNullParameter(req, "req");
        if (this.subRoomMap.containsKey(req.getRoomId())) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[enterSubRoom] update roomId: " + req.getRoomId() + ", enableTRTCPublish " + req.getEnableTRTCPublish();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, (String) it.next(), null);
            }
            s sVar = this.subRoomMap.get(req.getRoomId());
            if (sVar != null) {
                sVar.E(req.getPrivateMapKey());
                sVar.d0(req.getEnableTRTCPublish(), req.getIsMicInactive());
            }
            if (callback != null) {
                callback.onCallback(0, "");
                return;
            }
            return;
        }
        Logger.f235387a.d().d("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "[enterSubRoom] enterRoom roomId: " + req.getRoomId() + ", enableTRTCPublish " + req.getEnableTRTCPublish());
        s sVar2 = new s(this.mainTRTCRoom.T());
        J(sVar2);
        this.audioPlayStrategies.c(sVar2.T());
        sVar2.m(req, new ITRTCAudioRoom.a() { // from class: com.tencent.mobileqq.guild.media.core.logic.trtc.af
            @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.a
            public final void onCallback(int i3, String str2) {
                ag.v(ITRTCAudioRoom.a.this, i3, str2);
            }
        });
        this.subRoomMap.put(req.getRoomId(), sVar2);
    }

    public void muteRemoteAudio(@NotNull String userId, boolean mute) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        QLog.i("QGMC.MediaGroup.TRTCRoomRouteHelper", 1, "mute remote audio, user id:" + userId + " mute:" + mute);
        this.audioPlayStrategies.a().put(userId, Boolean.valueOf(mute));
        this.mainTRTCRoom.muteRemoteAudio(userId, mute);
        Iterator<Map.Entry<String, s>> it = this.subRoomMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().muteRemoteAudio(userId, mute);
        }
    }

    public int q() {
        return D().q();
    }

    public void setRemoteAudioVolume(@NotNull String userId, int volume) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        QLog.d("QGMC.MediaGroup.TRTCRoomRouteHelper", 4, "setRemoteAudioVolume userId:" + userId + ", volume:" + volume);
        this.audioPlayStrategies.b().put(userId, Integer.valueOf(volume));
        this.mainTRTCRoom.setRemoteAudioVolume(userId, volume);
        Collection<s> values = this.subRoomMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "subRoomMap.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((s) it.next()).setRemoteAudioVolume(userId, volume);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r0.getMEnableTRTCPublish() == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean z(@NotNull String roomId, int volume) {
        boolean z16;
        s sVar;
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (Intrinsics.areEqual(this.mainTRTCRoom.R(), roomId)) {
            return this.mainTRTCRoom.Y(volume);
        }
        s sVar2 = this.subRoomMap.get(roomId);
        if (sVar2 != null) {
            z16 = true;
        }
        z16 = false;
        if (!z16 || (sVar = this.subRoomMap.get(roomId)) == null) {
            return false;
        }
        return sVar.Y(volume);
    }
}
