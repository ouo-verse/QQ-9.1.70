package com.tencent.icgame.liveroom.impl.room.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.liveroom.impl.room.view.head.AnchorTopHeadView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\r\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/live/widget/TopControllerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "roomId", "Lcom/tencent/icgame/game/liveroom/impl/room/toparea/b;", "z0", "", "isVerMode", "", "setIsVerMode", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycleOwner", "isAnchor", "A0", "release", "B0", "d", "Z", "e", "Lcom/tencent/icgame/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "f", "Lcom/tencent/icgame/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "anchorInfo", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TopControllerView extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isVerMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorTopHeadView anchorInfo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopControllerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final com.tencent.icgame.game.liveroom.impl.room.toparea.b z0(long roomId) {
        return new com.tencent.icgame.game.liveroom.impl.room.toparea.b();
    }

    public final void A0(long roomId, boolean isAnchor) {
        this.isAnchor = isAnchor;
        this.anchorInfo.setViewModel(z0(roomId));
        this.anchorInfo.D(roomId, isAnchor);
    }

    public final void B0(long roomId) {
        this.anchorInfo.E(roomId);
    }

    public final void release() {
        this.anchorInfo.M();
    }

    public final void setIsVerMode(boolean isVerMode) {
        int i3;
        this.isVerMode = isVerMode;
        if (isVerMode) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        setVisibility(i3);
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.anchorInfo.setLifecycle(owner);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopControllerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TopControllerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TopControllerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.fby, this);
        View findViewById = findViewById(R.id.sna);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.anchorInfo)");
        this.anchorInfo = (AnchorTopHeadView) findViewById;
    }
}
