package com.tencent.timi.game.base.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.bc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "Landroid/widget/FrameLayout;", "", "text", "", "setHintText", "", "textResId", "d", "c", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "getMProgressDrawable", "()Landroid/graphics/drawable/Drawable;", "setMProgressDrawable", "(Landroid/graphics/drawable/Drawable;)V", "mProgressDrawable", "Lnr2/bc;", "f", "Lnr2/bc;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TimiGamePageLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable mProgressDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bc binding;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGamePageLoadingView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TimiGamePageLoadingView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i(this$0.TAG, "loading clicked!");
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void c() {
        setVisibility(8);
        Object obj = this.mProgressDrawable;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.drawable.Animatable");
        ((Animatable) obj).stop();
    }

    public final void d() {
        Object obj = this.mProgressDrawable;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.drawable.Animatable");
        ((Animatable) obj).start();
        setVisibility(0);
    }

    public final void setHintText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.binding.f420978b.setText(text);
    }

    public final void setMProgressDrawable(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "<set-?>");
        this.mProgressDrawable = drawable;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGamePageLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setHintText(int textResId) {
        String string = getContext().getString(textResId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(textResId)");
        setHintText(string);
    }

    public /* synthetic */ TimiGamePageLoadingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiGamePageLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "TimiGamePageLoadingView_";
        bc f16 = bc.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setBackgroundResource(R.color.ajr);
        Drawable background = f16.f420979c.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "binding.loadingCircleView.background");
        this.mProgressDrawable = background;
        setVisibility(8);
        setOnClickListener(new View.OnClickListener() { // from class: wf4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimiGamePageLoadingView.b(TimiGamePageLoadingView.this, view);
            }
        });
    }
}
