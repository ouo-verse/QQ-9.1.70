package com.tencent.mobileqq.guild.live.livemanager.player;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.TVideoNetInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 82\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u00019B-\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010.\u001a\u00020+\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00105\u001a\u00020\u0013\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J4\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J4\u0010\u001a\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J<\u0010\u001f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u001e\u0010\u001e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u001cj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`\u001dH\u0016J\u001c\u0010\"\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\"\u0010%\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0016J\u0012\u0010&\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/player/g;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoPreparedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnErrorListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnVideoSizeChangedListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnDefinitionInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnSeekCompleteListener;", "Lcom/tencent/superplayer/api/ISuperPlayer$OnTVideoNetInfoListener;", "Lcom/tencent/superplayer/api/ISuperPlayer;", "player", "", "onVideoPrepared", "", "what", "", "arg1", "arg2", "", "extra", "", "onInfo", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "onError", "currentDefinition", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "definitionList", "onDefinitionInfoUpdate", "Lcom/tencent/superplayer/api/TVideoNetInfo;", "videoNetInfo", "onTVideoNetInfoUpdate", "width", "height", "onVideoSizeChanged", "onSeekComplete", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "d", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "playerTag", "Lcom/tencent/mobileqq/guild/live/livemanager/player/k;", "e", "Lcom/tencent/mobileqq/guild/live/livemanager/player/k;", "retryListener", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "f", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "playerListener", tl.h.F, "Z", "defaultMute", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;Lcom/tencent/mobileqq/guild/live/livemanager/player/k;Lcom/tencent/mobileqq/guild/live/livemanager/player/j;Z)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g implements ISuperPlayer.OnVideoPreparedListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnVideoSizeChangedListener, ISuperPlayer.OnDefinitionInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnTVideoNetInfoListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildLivePlayerTag playerTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k retryListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final j playerListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean defaultMute;

    public g(@NotNull GuildLivePlayerTag playerTag, @NotNull k retryListener, @Nullable j jVar, boolean z16) {
        Intrinsics.checkNotNullParameter(playerTag, "playerTag");
        Intrinsics.checkNotNullParameter(retryListener, "retryListener");
        this.playerTag = playerTag;
        this.retryListener = retryListener;
        this.playerListener = jVar;
        this.defaultMute = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j jVar = this$0.playerListener;
        if (jVar != null) {
            jVar.onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j jVar = this$0.playerListener;
        if (jVar != null) {
            jVar.onFirstFrameCome();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j jVar = this$0.playerListener;
        if (jVar != null) {
            jVar.onCurrentLoopEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(g this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j jVar = this$0.playerListener;
        if (jVar != null) {
            jVar.onVideoSizeChanged(i3, i16);
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
    public boolean onError(@Nullable ISuperPlayer player, int module, int errorType, int errorCode, @Nullable String extraInfo) {
        QLog.e("QGL.PL.GuildLivePlayListener." + hashCode(), 1, this.playerTag.getStr() + " " + ((Object) ("onError: " + player + " module:" + module + " errorType:" + errorType + " errorCode:" + errorCode + " extraInfo:" + extraInfo)));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.livemanager.player.f
            @Override // java.lang.Runnable
            public final void run() {
                g.e(g.this);
            }
        });
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
    public boolean onInfo(@Nullable ISuperPlayer player, int what, long arg1, long arg2, @Nullable Object extra) {
        QLog.d("QGL.PL.GuildLivePlayListener." + hashCode(), 4, this.playerTag.getStr() + " " + ((Object) ("onInfo: " + player + " " + what + " " + arg1 + " " + arg2 + " " + extra)));
        if (what != 105) {
            if (what == 108) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.livemanager.player.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.g(g.this);
                    }
                });
                return false;
            }
            return false;
        }
        QLog.i("QGL.PL.GuildLivePlayListener." + hashCode(), 1, this.playerTag.getStr() + " " + ((Object) ("onFirstFrameCome, " + player)));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.livemanager.player.d
            @Override // java.lang.Runnable
            public final void run() {
                g.f(g.this);
            }
        });
        return false;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
    public void onVideoPrepared(@Nullable ISuperPlayer player) {
        QLog.i("QGL.PL.GuildLivePlayListener." + hashCode(), 1, this.playerTag.getStr() + " " + ((Object) ("onVideoPrepared. " + player + ", start play.")));
        if (player != null) {
            player.start();
        }
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(@Nullable ISuperPlayer player, final int width, final int height) {
        QLog.i("QGL.PL.GuildLivePlayListener." + hashCode(), 1, this.playerTag.getStr() + " " + ((Object) ("onVideoSizeChanged, " + player + ", " + width + " " + height)));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.live.livemanager.player.c
            @Override // java.lang.Runnable
            public final void run() {
                g.h(g.this, width, height);
            }
        });
    }

    public /* synthetic */ g(GuildLivePlayerTag guildLivePlayerTag, k kVar, j jVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildLivePlayerTag, kVar, (i3 & 4) != 0 ? null : jVar, (i3 & 8) != 0 ? false : z16);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener
    public void onSeekComplete(@Nullable ISuperPlayer player) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener
    public void onTVideoNetInfoUpdate(@Nullable ISuperPlayer player, @Nullable TVideoNetInfo videoNetInfo) {
    }

    @Override // com.tencent.superplayer.api.ISuperPlayer.OnDefinitionInfoListener
    public void onDefinitionInfoUpdate(@Nullable ISuperPlayer player, @Nullable String currentDefinition, @Nullable ArrayList<String> definitionList) {
    }
}
