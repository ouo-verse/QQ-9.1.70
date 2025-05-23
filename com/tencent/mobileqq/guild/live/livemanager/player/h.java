package com.tencent.mobileqq.guild.live.livemanager.player;

import android.os.Handler;
import android.os.Looper;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.guild.config.z;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002#$B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0017\u001a\u00020\u00162\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J0\u0010!\u001a\u00020 2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\u001a\u0010(\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u001c\u0010.\u001a\n ,*\u0004\u0018\u00010+0+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010-R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u00103R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u00106R0\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020&08j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020&`98\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/player/h;", "Lcom/tencent/mobileqq/guild/live/livemanager/player/l;", "Lcom/tencent/mobileqq/guild/live/livemanager/player/k;", "Lcom/tencent/mobileqq/guild/live/livemanager/player/h$b;", "info", "", "t", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "playerTag", "", "streamUrl", "", "isUseTexture", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "i", ReportConstant.COSTREPORT_PREFIX, "j", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/superplayer/api/SuperPlayerOption;", "k", DomainData.DOMAIN_NAME, "r", "playTag", "", "o", "p", "scaleType", "isMute", "Landroid/view/View;", "c", "isLoop", "a", "b", "e", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "listener", "d", "f", "g", "Lcom/tencent/qphone/base/util/BaseApplication;", "kotlin.jvm.PlatformType", "Lcom/tencent/qphone/base/util/BaseApplication;", "context", "Landroid/util/ArrayMap;", "Landroid/util/ArrayMap;", "playerInfoCache", "Lcom/tencent/mobileqq/guild/live/livemanager/player/i;", "Lcom/tencent/mobileqq/guild/live/livemanager/player/i;", "playerOption", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "playerListeners", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h implements l, k {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final vs1.a<ISuperPlayer> f226888g = new vs1.a<>(3);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BaseApplication context = BaseApplication.context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayMap<GuildLivePlayerTag, GuildLivePlayerInfo> playerInfoCache = new ArrayMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i playerOption = new i();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<GuildLivePlayerTag, j> playerListeners = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\n\u0010\u0013R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/player/h$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "a", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "b", "()Lcom/tencent/superplayer/view/ISPlayerVideoView;", "e", "(Lcom/tencent/superplayer/view/ISPlayerVideoView;)V", "playerVideoView", "Lcom/tencent/superplayer/api/ISuperPlayer;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "()Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "streamUrl", "d", "Z", "()Z", "setUseTexture", "(Z)V", "isUseTexture", "<init>", "(Lcom/tencent/superplayer/view/ISPlayerVideoView;Lcom/tencent/superplayer/api/ISuperPlayer;Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.livemanager.player.h$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class GuildLivePlayerInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private ISPlayerVideoView playerVideoView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ISuperPlayer player;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String streamUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isUseTexture;

        public GuildLivePlayerInfo(@NotNull ISPlayerVideoView playerVideoView, @NotNull ISuperPlayer player, @NotNull String streamUrl, boolean z16) {
            Intrinsics.checkNotNullParameter(playerVideoView, "playerVideoView");
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
            this.playerVideoView = playerVideoView;
            this.player = player;
            this.streamUrl = streamUrl;
            this.isUseTexture = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ISuperPlayer getPlayer() {
            return this.player;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final ISPlayerVideoView getPlayerVideoView() {
            return this.playerVideoView;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getStreamUrl() {
            return this.streamUrl;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsUseTexture() {
            return this.isUseTexture;
        }

        public final void e(@NotNull ISPlayerVideoView iSPlayerVideoView) {
            Intrinsics.checkNotNullParameter(iSPlayerVideoView, "<set-?>");
            this.playerVideoView = iSPlayerVideoView;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildLivePlayerInfo)) {
                return false;
            }
            GuildLivePlayerInfo guildLivePlayerInfo = (GuildLivePlayerInfo) other;
            if (Intrinsics.areEqual(this.playerVideoView, guildLivePlayerInfo.playerVideoView) && Intrinsics.areEqual(this.player, guildLivePlayerInfo.player) && Intrinsics.areEqual(this.streamUrl, guildLivePlayerInfo.streamUrl) && this.isUseTexture == guildLivePlayerInfo.isUseTexture) {
                return true;
            }
            return false;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.streamUrl = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.playerVideoView.hashCode() * 31) + this.player.hashCode()) * 31) + this.streamUrl.hashCode()) * 31;
            boolean z16 = this.isUseTexture;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "GuildLivePlayerInfo(playerVideoView=" + this.playerVideoView + ", player=" + this.player + ", streamUrl=" + this.streamUrl + ", isUseTexture=" + this.isUseTexture + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/live/livemanager/player/h$c", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "", "onFirstFrameCome", "", "width", "height", "onVideoSizeChanged", "onError", "onCurrentLoopEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements j {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildLivePlayerTag f226899e;

        c(GuildLivePlayerTag guildLivePlayerTag) {
            this.f226899e = guildLivePlayerTag;
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onCurrentLoopEnd() {
            j jVar = (j) h.this.playerListeners.get(this.f226899e);
            if (jVar != null) {
                jVar.onCurrentLoopEnd();
            }
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onError() {
            j jVar = (j) h.this.playerListeners.get(this.f226899e);
            if (jVar != null) {
                jVar.onError();
            }
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onFirstFrameCome() {
            j jVar = (j) h.this.playerListeners.get(this.f226899e);
            if (jVar != null) {
                jVar.onFirstFrameCome();
            }
        }

        @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
        public void onVideoSizeChanged(int width, int height) {
            j jVar = (j) h.this.playerListeners.get(this.f226899e);
            if (jVar != null) {
                jVar.onVideoSizeChanged(width, height);
            }
        }
    }

    private final void i(ISuperPlayer player, GuildLivePlayerTag playerTag) {
        g gVar = new g(playerTag, this, new c(playerTag), false, 8, null);
        QLog.i(n(), 1, "addPlayerListener[" + gVar.hashCode() + "]");
        player.setOnVideoPreparedListener(gVar);
        player.setOnInfoListener(gVar);
        player.setOnErrorListener(gVar);
        player.setOnDefinitionInfoListener(gVar);
        player.setOnTVideoNetInfoUpdateListener(gVar);
        player.setOnVideoSizeChangedListener(gVar);
        player.setOnSeekCompleteListener(gVar);
    }

    private final void j(ISuperPlayer player) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_BUFFER_PACKET_TOTAL_DURATION_MS, this.playerOption.getMaxBufferDuration()));
        arrayList.add(TPOptionalParam.buildInt(TPOptionalID.OPTIONAL_ID_BEFORE_INT_REDUCE_LIVE_LATENCY_ACTION, this.playerOption.getLatencyStrategy()));
        if (this.playerOption.getLatencyStrategy() == 1) {
            arrayList.add(TPOptionalParam.buildFloat(TPOptionalID.OPTIONAL_ID_BEFORE_FLOAT_REDUCE_LATENCY_SPEED_UP_RATE, this.playerOption.getSpeedUpRate()));
        }
        player.setPlayerOptionalParamList(arrayList);
    }

    private final SuperPlayerOption k(String streamUrl) {
        boolean startsWith$default;
        boolean contains$default;
        SuperPlayerOption option = SuperPlayerOption.obtain();
        if (streamUrl != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(streamUrl, "http", false, 2, null);
            if (startsWith$default) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) streamUrl, (CharSequence) "flv", false, 2, (Object) null);
                if (contains$default) {
                    if (z.f216289a.e()) {
                        option.enableDownloadProxy = Boolean.TRUE;
                        SuperPlayerDownOption superPlayerDownOption = option.superPlayerDownOption;
                        superPlayerDownOption.quicEnableMode = 2;
                        superPlayerDownOption.enableQuicPlaintext = true;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("Referer", "https://qun.qq.com");
                    option.httpHeader = hashMap;
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(option, "option");
        return option;
    }

    private final void l(GuildLivePlayerTag playerTag, String streamUrl, boolean isUseTexture) {
        ISPlayerVideoView playerVideoView = SuperPlayerFactory.createPlayerVideoView(this.context.getApplicationContext(), isUseTexture);
        ISuperPlayer player = f226888g.a();
        if (player != null) {
            QLog.i(n(), 1, "createPlayer, from cache.");
            player.updatePlayerSceneId(playerTag.getPlayerSceneId());
            player.updatePlayerVideoView(playerVideoView);
        } else {
            QLog.i(n(), 1, "createPlayer, from create.");
            player = SuperPlayerFactory.createMediaPlayer(this.context.getApplicationContext(), playerTag.getPlayerSceneId(), playerVideoView);
        }
        Intrinsics.checkNotNullExpressionValue(player, "player");
        i(player, playerTag);
        Intrinsics.checkNotNullExpressionValue(player, "player");
        j(player);
        ArrayMap<GuildLivePlayerTag, GuildLivePlayerInfo> arrayMap = this.playerInfoCache;
        Intrinsics.checkNotNullExpressionValue(playerVideoView, "playerVideoView");
        Intrinsics.checkNotNullExpressionValue(player, "player");
        arrayMap.put(playerTag, new GuildLivePlayerInfo(playerVideoView, player, streamUrl, isUseTexture));
    }

    private final int m(String streamUrl) {
        boolean startsWith$default;
        boolean contains$default;
        if (streamUrl != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(streamUrl, "http", false, 2, null);
            if (startsWith$default) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) streamUrl, (CharSequence) "flv", false, 2, (Object) null);
                if (contains$default) {
                    return 202;
                }
            }
        }
        return 203;
    }

    private final String n() {
        return "QGL.PL.GuildLivePlayerManager" + hashCode();
    }

    private final void q(GuildLivePlayerTag playerTag, String streamUrl) {
        GuildLivePlayerInfo guildLivePlayerInfo = this.playerInfoCache.get(playerTag);
        if (guildLivePlayerInfo != null) {
            QLog.i(n(), 1, "openMediaPlayer. " + playerTag);
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(streamUrl, m(streamUrl), (String) null);
            guildLivePlayerInfo.f(streamUrl);
            guildLivePlayerInfo.getPlayer().openMediaPlayer(this.context.getApplicationContext(), createVideoInfoForUrl, 0L, k(streamUrl));
        }
    }

    private final void s(ISuperPlayer player) {
        player.setOnVideoPreparedListener(null);
        player.setOnInfoListener(null);
        player.setOnErrorListener(null);
        player.setOnDefinitionInfoListener(null);
        player.setOnTVideoNetInfoUpdateListener(null);
        player.setOnVideoSizeChangedListener(null);
        player.setOnSeekCompleteListener(null);
    }

    private final void t(GuildLivePlayerInfo info) {
        ViewGroup viewGroup;
        info.getPlayer().stop();
        info.getPlayer().reset();
        if (!f226888g.d(info.getPlayer())) {
            info.getPlayer().release();
        }
        s(info.getPlayer());
        Object playerVideoView = info.getPlayerVideoView();
        Intrinsics.checkNotNull(playerVideoView, "null cannot be cast to non-null type android.view.View");
        ViewParent parent = ((View) playerVideoView).getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            Object playerVideoView2 = info.getPlayerVideoView();
            Intrinsics.checkNotNull(playerVideoView2, "null cannot be cast to non-null type android.view.View");
            viewGroup.removeView((View) playerVideoView2);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.l
    public void a(boolean isLoop, @NotNull GuildLivePlayerTag playerTag) {
        ISuperPlayer player;
        Intrinsics.checkNotNullParameter(playerTag, "playerTag");
        GuildLivePlayerInfo guildLivePlayerInfo = this.playerInfoCache.get(playerTag);
        if (guildLivePlayerInfo != null && (player = guildLivePlayerInfo.getPlayer()) != null) {
            player.setLoopback(isLoop);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.l
    public void b(@NotNull GuildLivePlayerTag playerTag) {
        Intrinsics.checkNotNullParameter(playerTag, "playerTag");
        QLog.i(n(), 1, "stopAndRelease, " + playerTag + ", contains cache=" + this.playerInfoCache.containsKey(playerTag));
        playerTag.setId("");
        GuildLivePlayerInfo guildLivePlayerInfo = this.playerInfoCache.get(playerTag);
        if (guildLivePlayerInfo != null) {
            t(guildLivePlayerInfo);
        }
        this.playerInfoCache.remove(playerTag);
        this.playerListeners.remove(playerTag);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.live.livemanager.player.l
    @NotNull
    public View c(@NotNull String streamUrl, @NotNull GuildLivePlayerTag playerTag, int scaleType, boolean isMute, boolean isUseTexture) {
        Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
        Intrinsics.checkNotNullParameter(playerTag, "playerTag");
        QLog.i(n(), 1, "createAndPlay, " + playerTag + ", mute: " + isMute + ", isUseTexture: " + isUseTexture);
        GuildLivePlayerInfo guildLivePlayerInfo = this.playerInfoCache.get(playerTag);
        Unit unit = null;
        ViewGroup viewGroup = null;
        if (guildLivePlayerInfo != null) {
            if (guildLivePlayerInfo.getIsUseTexture() == isUseTexture && Intrinsics.areEqual(guildLivePlayerInfo.getStreamUrl(), streamUrl) && guildLivePlayerInfo.getPlayer().isPlaying()) {
                QLog.i(n(), 1, "streamUrl equals, ignore.");
                ISPlayerVideoView playerVideoView = guildLivePlayerInfo.getPlayerVideoView();
                Intrinsics.checkNotNull(playerVideoView, "null cannot be cast to non-null type android.view.View");
                return (View) playerVideoView;
            }
            QLog.i(n(), 1, "createAndPlay, reset.");
            try {
                ISPlayerVideoView playerVideoView2 = guildLivePlayerInfo.getPlayerVideoView();
                Intrinsics.checkNotNull(playerVideoView2, "null cannot be cast to non-null type android.view.View");
                ViewParent parent = ((View) playerVideoView2).getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                }
                if (viewGroup != null) {
                    ISPlayerVideoView playerVideoView3 = guildLivePlayerInfo.getPlayerVideoView();
                    Intrinsics.checkNotNull(playerVideoView3, "null cannot be cast to non-null type android.view.View");
                    viewGroup.removeView((View) playerVideoView3);
                }
            } catch (Throwable th5) {
                QLog.i(n(), 1, "removeView fail, err msg:" + th5.getMessage());
            }
            guildLivePlayerInfo.getPlayer().stop();
            guildLivePlayerInfo.getPlayer().reset();
            guildLivePlayerInfo.getPlayer().setOutputMute(isMute);
            j(guildLivePlayerInfo.getPlayer());
            ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(this.context.getApplicationContext(), isUseTexture);
            Intrinsics.checkNotNullExpressionValue(createPlayerVideoView, "createPlayerVideoView(co\u2026ionContext, isUseTexture)");
            guildLivePlayerInfo.e(createPlayerVideoView);
            guildLivePlayerInfo.getPlayer().updatePlayerVideoView(guildLivePlayerInfo.getPlayerVideoView());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            l(playerTag, streamUrl, isUseTexture);
        }
        GuildLivePlayerInfo guildLivePlayerInfo2 = this.playerInfoCache.get(playerTag);
        if (guildLivePlayerInfo2 != null) {
            guildLivePlayerInfo2.getPlayerVideoView().setXYaxis(scaleType);
            guildLivePlayerInfo2.getPlayer().setOutputMute(isMute);
            q(playerTag, streamUrl);
            ISPlayerVideoView playerVideoView4 = guildLivePlayerInfo2.getPlayerVideoView();
            Intrinsics.checkNotNull(playerVideoView4, "null cannot be cast to non-null type android.view.View");
            return (View) playerVideoView4;
        }
        throw new IllegalArgumentException(("create " + playerTag + " player fail, please check it.").toString());
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.l
    public void d(@NotNull GuildLivePlayerTag playerTag, @Nullable j listener) {
        Intrinsics.checkNotNullParameter(playerTag, "playerTag");
        if (listener == null) {
            this.playerListeners.remove(playerTag);
        } else {
            this.playerListeners.put(playerTag, listener);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.l
    public void e() {
        int collectionSizeOrDefault;
        String n3 = n();
        Set<GuildLivePlayerTag> keySet = this.playerInfoCache.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "playerInfoCache.keys");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = keySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((GuildLivePlayerTag) it.next()).getStr());
        }
        QLog.i(n3, 1, "stopAndReleaseAll. contains cache=" + arrayList);
        this.handler.removeCallbacksAndMessages(null);
        Set<GuildLivePlayerTag> keySet2 = this.playerInfoCache.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet2, "playerInfoCache.keys");
        Iterator<T> it5 = keySet2.iterator();
        while (it5.hasNext()) {
            ((GuildLivePlayerTag) it5.next()).setId("");
        }
        Collection<GuildLivePlayerInfo> values = this.playerInfoCache.values();
        Intrinsics.checkNotNullExpressionValue(values, "playerInfoCache.values");
        for (GuildLivePlayerInfo it6 : values) {
            Intrinsics.checkNotNullExpressionValue(it6, "it");
            t(it6);
        }
        this.playerInfoCache.clear();
        this.playerListeners.clear();
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.l
    public boolean f(@NotNull GuildLivePlayerTag playerTag) {
        ISPlayerVideoView playerVideoView;
        Intrinsics.checkNotNullParameter(playerTag, "playerTag");
        GuildLivePlayerInfo guildLivePlayerInfo = this.playerInfoCache.get(playerTag);
        if (guildLivePlayerInfo != null && (playerVideoView = guildLivePlayerInfo.getPlayerVideoView()) != null) {
            return playerVideoView.disableViewCallback();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.l
    public boolean g(@NotNull GuildLivePlayerTag playerTag) {
        ISPlayerVideoView playerVideoView;
        Intrinsics.checkNotNullParameter(playerTag, "playerTag");
        GuildLivePlayerInfo guildLivePlayerInfo = this.playerInfoCache.get(playerTag);
        if (guildLivePlayerInfo != null && (playerVideoView = guildLivePlayerInfo.getPlayerVideoView()) != null) {
            return playerVideoView.enableViewCallback();
        }
        return false;
    }

    public long o(@NotNull GuildLivePlayerTag playTag) {
        long j3;
        ISuperPlayer player;
        Intrinsics.checkNotNullParameter(playTag, "playTag");
        GuildLivePlayerInfo guildLivePlayerInfo = this.playerInfoCache.get(playTag);
        if (guildLivePlayerInfo != null && (player = guildLivePlayerInfo.getPlayer()) != null) {
            j3 = player.getCurrentPositionMs();
        } else {
            j3 = 0;
        }
        Logger logger = Logger.f235387a;
        String n3 = n();
        if (QLog.isDevelopLevel()) {
            Log.d(n3, "[getPlayerCurPositionMs] " + playTag + ", res:" + j3);
        }
        return j3;
    }

    public long p(@NotNull GuildLivePlayerTag playTag) {
        long j3;
        ISuperPlayer player;
        Intrinsics.checkNotNullParameter(playTag, "playTag");
        GuildLivePlayerInfo guildLivePlayerInfo = this.playerInfoCache.get(playTag);
        if (guildLivePlayerInfo != null && (player = guildLivePlayerInfo.getPlayer()) != null) {
            j3 = player.getDurationMs();
        } else {
            j3 = 0;
        }
        Logger logger = Logger.f235387a;
        String n3 = n();
        if (QLog.isDevelopLevel()) {
            Log.d(n3, "[getVideoDurationMs] " + playTag + ", res:" + j3);
        }
        return j3;
    }

    public void r(@NotNull GuildLivePlayerTag playerTag) {
        ISuperPlayer player;
        Intrinsics.checkNotNullParameter(playerTag, "playerTag");
        GuildLivePlayerInfo guildLivePlayerInfo = this.playerInfoCache.get(playerTag);
        if (guildLivePlayerInfo != null && (player = guildLivePlayerInfo.getPlayer()) != null) {
            player.pause();
        }
    }
}
