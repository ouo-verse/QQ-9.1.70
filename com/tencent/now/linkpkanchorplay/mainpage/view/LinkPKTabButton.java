package com.tencent.now.linkpkanchorplay.mainpage.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.utils.c;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.linkpkanchorplay.mainpage.view.LinkPKTabButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import v0.a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b!\u0010%B#\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020\u0006\u00a2\u0006\u0004\b!\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\u0004H\u0014R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006*"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/view/LinkPKTabButton;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "listener", "", "setOnClickTabButtonListener", "", "src", "setImageSrc", "", "path", "setImagePath", "c", "Landroid/widget/FrameLayout$LayoutParams;", "layoutParams", "setAniViewLayoutParam", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "buttonImageView", "e", "apngAniView", "Lv0/a;", "f", "Lv0/a;", "apngListener", "Ljava/lang/Runnable;", h.F, "Ljava/lang/Runnable;", "removeAniTask", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class LinkPKTabButton extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView buttonImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView apngAniView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a apngListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable removeAniTask;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/mainpage/view/LinkPKTabButton$b", "Lv0/a;", "Landroid/graphics/drawable/Drawable;", "apngDrawable", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends a {
        b() {
        }

        @Override // v0.a
        public void a(@NotNull Drawable apngDrawable) {
            Intrinsics.checkNotNullParameter(apngDrawable, "apngDrawable");
            super.a(apngDrawable);
            LogUtil.i("LinkPKTabButton", "\u5f00\u59cb\u64ad\u653e\u52a8\u753b: w=" + apngDrawable.getIntrinsicWidth() + ", h=" + apngDrawable.getIntrinsicHeight(), new Object[0]);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkPKTabButton(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.feh, this);
        View findViewById = findViewById(R.id.tjj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(R.id.button_img_view)");
        ImageView imageView = (ImageView) findViewById;
        this.buttonImageView = imageView;
        View findViewById2 = findViewById(R.id.sqb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(R.id.apng_ani_view)");
        ImageView imageView2 = (ImageView) findViewById2;
        this.apngAniView = imageView2;
        imageView2.setVisibility(8);
        com.tencent.mobileqq.qqlive.download.a e16 = an3.a.INSTANCE.e();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        c.a(imageView, e16.a(context2));
        this.apngListener = new b();
        this.removeAniTask = new Runnable() { // from class: qm3.h
            @Override // java.lang.Runnable
            public final void run() {
                LinkPKTabButton.d(LinkPKTabButton.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LinkPKTabButton this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View.OnClickListener listener, LinkPKTabButton this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        listener.onClick(this$0);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void c() {
        this.apngAniView.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        ThreadCenter.removeDefaultUITask(this.removeAniTask);
    }

    public final void setAniViewLayoutParam(@NotNull FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.apngAniView.setLayoutParams(layoutParams);
    }

    public final void setImagePath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        c.a(this.buttonImageView, path);
    }

    public final void setImageSrc(int src) {
        this.buttonImageView.setImageResource(src);
    }

    public final void setOnClickTabButtonListener(@NotNull final View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.buttonImageView.setOnClickListener(new View.OnClickListener() { // from class: qm3.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LinkPKTabButton.e(listener, this, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkPKTabButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.feh, this);
        View findViewById = findViewById(R.id.tjj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(R.id.button_img_view)");
        ImageView imageView = (ImageView) findViewById;
        this.buttonImageView = imageView;
        View findViewById2 = findViewById(R.id.sqb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(R.id.apng_ani_view)");
        ImageView imageView2 = (ImageView) findViewById2;
        this.apngAniView = imageView2;
        imageView2.setVisibility(8);
        com.tencent.mobileqq.qqlive.download.a e16 = an3.a.INSTANCE.e();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        c.a(imageView, e16.a(context2));
        this.apngListener = new b();
        this.removeAniTask = new Runnable() { // from class: qm3.h
            @Override // java.lang.Runnable
            public final void run() {
                LinkPKTabButton.d(LinkPKTabButton.this);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkPKTabButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(getContext(), R.layout.feh, this);
        View findViewById = findViewById(R.id.tjj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<ImageView>(R.id.button_img_view)");
        ImageView imageView = (ImageView) findViewById;
        this.buttonImageView = imageView;
        View findViewById2 = findViewById(R.id.sqb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(R.id.apng_ani_view)");
        ImageView imageView2 = (ImageView) findViewById2;
        this.apngAniView = imageView2;
        imageView2.setVisibility(8);
        com.tencent.mobileqq.qqlive.download.a e16 = an3.a.INSTANCE.e();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        c.a(imageView, e16.a(context2));
        this.apngListener = new b();
        this.removeAniTask = new Runnable() { // from class: qm3.h
            @Override // java.lang.Runnable
            public final void run() {
                LinkPKTabButton.d(LinkPKTabButton.this);
            }
        };
    }
}
