package com.tencent.mobileqq.icgame.room.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\r\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J$\u0010\u0015\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/player/ICGameMiniSdkLiveView;", "Lcom/tencent/mobileqq/icgame/room/player/ICGameLiveView;", "", "url", "", "a", "Lcom/tencent/mobileqq/icgame/room/player/k;", "player", "setVideoPlayer", "play", "pause", "resume", "stop", "", "degree", "setVideoRotation", "Landroid/view/View;", "child", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "N", "Landroid/view/View;", "liveView", "P", "Lcom/tencent/mobileqq/icgame/room/player/k;", "videoPlayer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ICGameMiniSdkLiveView extends ICGameLiveView {

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View liveView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private k videoPlayer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ICGameMiniSdkLiveView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.icgame.room.player.j
    public void a(@Nullable String url) {
        k kVar = this.videoPlayer;
        if (kVar != null) {
            kVar.b(url);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int index, @Nullable ViewGroup.LayoutParams params) {
        super.addView(child, index, params);
        this.liveView = child;
    }

    @Override // com.tencent.mobileqq.icgame.room.player.ICGameLiveView, com.tencent.mobileqq.icgame.room.player.j
    public void pause(@Nullable String url) {
        super.pause(url);
        k kVar = this.videoPlayer;
        if (kVar != null) {
            kVar.pause(url);
        }
    }

    @Override // com.tencent.mobileqq.icgame.room.player.ICGameLiveView, com.tencent.mobileqq.icgame.room.player.j
    public void play(@Nullable String url) {
        super.play(url);
        gv0.b bVar = gv0.b.f403419a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (bVar.a(context)) {
            k kVar = this.videoPlayer;
            if (kVar != null) {
                kVar.a(url, this.liveView);
                return;
            }
            return;
        }
        k kVar2 = this.videoPlayer;
        if (kVar2 != null) {
            kVar2.pause(url);
        }
    }

    @Override // com.tencent.mobileqq.icgame.room.player.ICGameLiveView, com.tencent.mobileqq.icgame.room.player.j
    public void resume(@Nullable String url) {
        k kVar;
        super.resume(url);
        gv0.b bVar = gv0.b.f403419a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (bVar.a(context) && (kVar = this.videoPlayer) != null) {
            kVar.resume(url);
        }
    }

    @Override // com.tencent.mobileqq.icgame.room.player.ICGameLiveView, com.tencent.mobileqq.icgame.room.player.j
    public void setVideoPlayer(@NotNull k player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.videoPlayer = player;
    }

    @Override // com.tencent.mobileqq.icgame.room.player.ICGameLiveView, com.tencent.mobileqq.icgame.room.player.j
    public void setVideoRotation(int degree) {
        super.setVideoRotation(degree);
        k kVar = this.videoPlayer;
        if (kVar != null) {
            kVar.setVideoRotation(degree);
        }
    }

    @Override // com.tencent.mobileqq.icgame.room.player.ICGameLiveView, com.tencent.mobileqq.icgame.room.player.j
    public void stop(@Nullable String url) {
        super.stop(url);
        k kVar = this.videoPlayer;
        if (kVar != null) {
            kVar.stop(url);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ICGameMiniSdkLiveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ICGameMiniSdkLiveView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ICGameMiniSdkLiveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
