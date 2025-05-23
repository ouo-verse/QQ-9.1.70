package com.tencent.zplan.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.zplan.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001.B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,B\u001b\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b+\u0010-J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/zplan/view/ZPlanLoadingView;", "Landroid/widget/FrameLayout;", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "b", "", "progress", "setProgressText", HippyQQPagView.FunctionName.SET_PROGRESS, "", "text", "Lcom/tencent/zplan/view/ZPlanLoadingView$a;", "listener", "setCloseListener", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "getCloseIcon", "()Landroid/widget/ImageView;", "setCloseIcon", "(Landroid/widget/ImageView;)V", "closeIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "getProgressText", "()Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "progressText", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "getLoadingText", "()Landroid/widget/RelativeLayout;", "setLoadingText", "(Landroid/widget/RelativeLayout;)V", "loadingText", h.F, "Lcom/tencent/zplan/view/ZPlanLoadingView$a;", "closeListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanLoadingView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView closeIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView progressText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RelativeLayout loadingText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private a closeListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/zplan/view/ZPlanLoadingView$a;", "", "", "onCloseClick", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public interface a {
        void onCloseClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a aVar = ZPlanLoadingView.this.closeListener;
            if (aVar != null) {
                aVar.onCloseClick();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanLoadingView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        b(null);
    }

    private final void b(AttributeSet attrs) {
        View.inflate(getContext(), R.layout.i8z, this);
        this.progressText = (TextView) findViewById(R.id.f126447os);
        this.closeIcon = (ImageView) findViewById(R.id.f126427oq);
        this.loadingText = (RelativeLayout) findViewById(R.id.f126437or);
        ImageView imageView = this.closeIcon;
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
        if (attrs == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, i.W);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026yleable.ZPlanLoadingView)");
        setBackground(obtainStyledAttributes.getDrawable(i.X));
        obtainStyledAttributes.recycle();
    }

    public final void setCloseIcon(@Nullable ImageView imageView) {
        this.closeIcon = imageView;
    }

    public final void setCloseListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.closeListener = listener;
    }

    public final void setLoadingText(@Nullable RelativeLayout relativeLayout) {
        this.loadingText = relativeLayout;
    }

    public final void setProgressText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
    }

    public final void setProgressText(@Nullable TextView textView) {
        this.progressText = textView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        b(attributeSet);
    }

    public final void setProgressText(int progress) {
        TextView textView = this.progressText;
        if (textView != null) {
            textView.setText(String.valueOf(progress));
        }
    }

    public final void setProgress(int progress) {
    }
}
