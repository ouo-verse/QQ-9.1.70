package com.tencent.icgame.game.base.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.game.base.ui.TimiGamePageLoadingView;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0006\u00a2\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006$"}, d2 = {"Lcom/tencent/icgame/game/base/ui/TimiGamePageLoadingView;", "Landroid/widget/FrameLayout;", "", "text", "", "setHintText", "", "textResId", "d", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "Landroid/graphics/drawable/Drawable;", "e", "Landroid/graphics/drawable/Drawable;", "getMProgressDrawable", "()Landroid/graphics/drawable/Drawable;", "setMProgressDrawable", "(Landroid/graphics/drawable/Drawable;)V", "mProgressDrawable", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "hintTxv", "Landroid/view/View;", h.F, "Landroid/view/View;", "loadingCircleView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TimiGamePageLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable mProgressDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView hintTxv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View loadingCircleView;

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
        g.h(this$0.TAG, "loading clicked!");
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setHintText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.hintTxv.setText(text);
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
        this.TAG = "ICGameGamePageLoadingView_";
        View.inflate(context, R.layout.fca, this);
        View findViewById = findViewById(R.id.x_o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.hintTxv)");
        this.hintTxv = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f166131ys4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.loadingCircleView)");
        this.loadingCircleView = findViewById2;
        setBackgroundResource(R.color.ajr);
        Drawable background = findViewById2.getBackground();
        Intrinsics.checkNotNullExpressionValue(background, "loadingCircleView.background");
        this.mProgressDrawable = background;
        setVisibility(8);
        setOnClickListener(new View.OnClickListener() { // from class: cu0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TimiGamePageLoadingView.b(TimiGamePageLoadingView.this, view);
            }
        });
    }
}
