package com.tencent.timi.game.liveroom.impl.room.live.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.live.widget.LiveTipsView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006R\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/live/widget/LiveTipsView;", "Landroid/widget/FrameLayout;", "", "f", "Lcom/tencent/timi/game/liveroom/impl/room/live/widget/LiveTipsView$a;", "listener", "", "setListener", "g", "e", "d", "c", "Lnr2/i;", "Lnr2/i;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LiveTipsView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/live/widget/LiveTipsView$a;", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveTipsView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveTipsView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getClass();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean f() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (getChildAt(i3).getVisibility() == 0) {
                return false;
            }
        }
        return true;
    }

    public final void c() {
        this.binding.f421064b.setVisibility(8);
        this.binding.f421068f.setVisibility(8);
        if (f()) {
            setVisibility(8);
        }
    }

    public final void d() {
        this.binding.f421065c.setVisibility(8);
        this.binding.f421068f.setVisibility(8);
        if (f()) {
            setVisibility(8);
        }
    }

    public final void e() {
        this.binding.f421067e.setVisibility(8);
        this.binding.f421068f.setVisibility(8);
        if (f()) {
            setVisibility(8);
        }
    }

    public final void g() {
        setVisibility(0);
        setBackgroundResource(R.color.ajr);
        this.binding.f421068f.setVisibility(8);
        this.binding.f421067e.setVisibility(0);
        d();
        c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LiveTipsView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        i f16 = i.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        f16.f421069g.setOnClickListener(new View.OnClickListener() { // from class: sj4.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveTipsView.b(LiveTipsView.this, view);
            }
        });
    }

    public final void setListener(@Nullable a listener) {
    }
}
