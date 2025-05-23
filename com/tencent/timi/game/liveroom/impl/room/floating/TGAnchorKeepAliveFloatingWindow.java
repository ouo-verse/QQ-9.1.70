package com.tencent.timi.game.liveroom.impl.room.floating;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uh4.c;
import uh4.d;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/floating/TGAnchorKeepAliveFloatingWindow;", "Landroid/widget/FrameLayout;", "Luh4/d;", "", "onShow", "onHide", "b", "e", "onBackground", "d", "Landroid/view/View;", "getView", "Luh4/c;", "f", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TGAnchorKeepAliveFloatingWindow extends FrameLayout implements uh4.d {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGAnchorKeepAliveFloatingWindow(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TGAnchorKeepAliveFloatingWindow this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(0);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // uh4.d
    @NotNull
    public uh4.b a() {
        return d.a.a(this);
    }

    @Override // uh4.d
    @NotNull
    public uh4.c f() {
        return new c.a().e(com.tencent.timi.game.utils.b.a(1), com.tencent.timi.game.utils.b.a(1)).d(0).b(false).f(true).a();
    }

    @Override // uh4.d
    public void setLaunchParam(@Nullable Object obj) {
        d.a.b(this, obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGAnchorKeepAliveFloatingWindow(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TGAnchorKeepAliveFloatingWindow(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGAnchorKeepAliveFloatingWindow(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.hun, this);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.floating.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TGAnchorKeepAliveFloatingWindow.g(TGAnchorKeepAliveFloatingWindow.this, view);
            }
        });
    }

    @Override // uh4.d
    public void b() {
    }

    @Override // uh4.d
    public void d() {
    }

    @Override // uh4.d
    public void e() {
    }

    @Override // uh4.d
    @NotNull
    public View getView() {
        return this;
    }

    @Override // uh4.d
    public void onBackground() {
    }

    @Override // uh4.d
    public void onHide() {
    }

    @Override // uh4.d
    public void onShow() {
    }
}
