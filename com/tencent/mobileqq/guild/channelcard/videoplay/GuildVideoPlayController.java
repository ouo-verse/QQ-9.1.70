package com.tencent.mobileqq.guild.channelcard.videoplay;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.live.livemanager.player.j;
import com.tencent.mobileqq.guild.live.livemanager.player.l;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u001e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0002R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/channelcard/videoplay/GuildVideoPlayController;", "Lcom/tencent/mobileqq/guild/live/livemanager/player/j;", "", "onFirstFrameCome", "", "width", "height", "onVideoSizeChanged", "onError", "", "url", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "backgroundView", "c", "d", "Landroid/view/ViewGroup;", "e", "Landroid/view/View;", "f", "liveView", h.F, "Ljava/lang/String;", "Lcom/tencent/mobileqq/guild/live/livemanager/player/l;", "i", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/live/livemanager/player/l;", "livePlayerManager", "Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;", "guildLivePlayerTag", "<init>", "(Lcom/tencent/mobileqq/guild/live/livemanager/player/GuildLivePlayerTag;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildVideoPlayController implements j {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View backgroundView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View liveView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String url;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy livePlayerManager;

    public GuildVideoPlayController(@NotNull final GuildLivePlayerTag guildLivePlayerTag) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(guildLivePlayerTag, "guildLivePlayerTag");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<com.tencent.mobileqq.guild.live.livemanager.player.h>() { // from class: com.tencent.mobileqq.guild.channelcard.videoplay.GuildVideoPlayController$livePlayerManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.guild.live.livemanager.player.h invoke() {
                com.tencent.mobileqq.guild.live.livemanager.player.h hVar = new com.tencent.mobileqq.guild.live.livemanager.player.h();
                hVar.a(true, GuildLivePlayerTag.this);
                return hVar;
            }
        });
        this.livePlayerManager = lazy;
    }

    private final l b() {
        return (l) this.livePlayerManager.getValue();
    }

    public final void c(@NotNull String url, @NotNull ViewGroup container, @NotNull View backgroundView) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(backgroundView, "backgroundView");
        this.url = url;
        this.container = container;
        this.backgroundView = backgroundView;
        Logger logger = Logger.f235387a;
        logger.d().i("Guild.userl.GuildVideoPlayController", 1, "play url: " + url);
        l b16 = b();
        GuildLivePlayerTag guildLivePlayerTag = GuildLivePlayerTag.INTEREST_LABEL_CARD;
        b16.d(guildLivePlayerTag, this);
        View c16 = b().c(url, guildLivePlayerTag, 2, true, true);
        b().a(true, guildLivePlayerTag);
        this.liveView = c16;
        if (container.indexOfChild(c16) >= 0) {
            backgroundView.setVisibility(8);
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.userl.GuildVideoPlayController", 2, "[play] the same url and player video view, ignore");
                return;
            }
            return;
        }
        container.addView(c16, 0, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void d() {
        Logger.f235387a.d().i("Guild.userl.GuildVideoPlayController", 1, "stop url: " + this.url);
        View view = this.liveView;
        if (view != null) {
            ViewGroup viewGroup = this.container;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
            this.liveView = null;
        }
        l b16 = b();
        GuildLivePlayerTag guildLivePlayerTag = GuildLivePlayerTag.INTEREST_LABEL_CARD;
        b16.b(guildLivePlayerTag);
        b16.d(guildLivePlayerTag, null);
        View view2 = this.backgroundView;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        this.container = null;
        this.backgroundView = null;
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onCurrentLoopEnd() {
        j.a.a(this);
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onError() {
        Logger.f235387a.d().i("Guild.userl.GuildVideoPlayController", 1, "onError");
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onFirstFrameCome() {
        Logger.f235387a.d().i("Guild.userl.GuildVideoPlayController", 1, "onFirstFrameCome");
        View view = this.backgroundView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.livemanager.player.j
    public void onVideoSizeChanged(int width, int height) {
        Logger.f235387a.d().i("Guild.userl.GuildVideoPlayController", 1, "onVideoSizeChanged(" + width + ", " + height + ")");
    }
}
