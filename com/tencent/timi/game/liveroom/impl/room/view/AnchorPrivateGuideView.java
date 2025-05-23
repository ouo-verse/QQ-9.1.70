package com.tencent.timi.game.liveroom.impl.room.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001-B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u001c\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006."}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorPrivateGuideView;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorPrivateGuideView$a;", "listener", "setGuideViewFinishListener", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "setPrivateBtnRect", "", "d", "Ljava/lang/String;", "tag", "Lnr2/m;", "e", "Lnr2/m;", "binding", "Landroid/graphics/PorterDuffXfermode;", "f", "Landroid/graphics/PorterDuffXfermode;", FileReaderHelper.PDF_EXT, "Landroid/graphics/Paint;", tl.h.F, "Landroid/graphics/Paint;", "paint", "", "i", "I", "colorBg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Rect;", "privateBtnRect", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorPrivateGuideView$a;", "guideViewFinishListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorPrivateGuideView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a guideViewFinishListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nr2.m binding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PorterDuffXfermode pdf;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int colorBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Rect privateBtnRect;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorPrivateGuideView$a;", "", "", "onFinish", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void onFinish();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/AnchorPrivateGuideView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            AnchorPrivateGuideView.this.setAlpha(1.0f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorPrivateGuideView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AnchorPrivateGuideView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(8);
        a aVar = this$0.guideViewFinishListener;
        if (aVar != null) {
            aVar.onFinish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AnchorPrivateGuideView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.tag, 2, "AnchorPrivateGuideView ignore click");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final AnchorPrivateGuideView this$0, Rect rect) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rect, "$rect");
        this$0.privateBtnRect = rect;
        float centerX = rect.centerX();
        float centerY = rect.centerY();
        Rect rect2 = new Rect();
        View view = this$0.binding.f421094c;
        Intrinsics.checkNotNullExpressionValue(view, "binding.eyePos");
        rect2.left = fh4.g.g(view);
        View view2 = this$0.binding.f421094c;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.eyePos");
        rect2.top = fh4.g.i(view2);
        rect2.right = rect2.left + this$0.binding.f421094c.getWidth();
        rect2.bottom = rect2.top + this$0.binding.f421094c.getHeight();
        this$0.binding.f421095d.setTranslationX(centerX - rect2.centerX());
        this$0.binding.f421095d.setTranslationY(centerY - rect2.centerY());
        this$0.postInvalidate();
        this$0.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.k
            @Override // java.lang.Runnable
            public final void run() {
                AnchorPrivateGuideView.h(AnchorPrivateGuideView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AnchorPrivateGuideView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPropertyAnimator alpha = this$0.animate().alpha(1.0f);
        alpha.setDuration(200L);
        alpha.setListener(new b());
        alpha.start();
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (this.privateBtnRect != null) {
            if (canvas != null) {
                canvas.drawARGB(204, 0, 0, 0);
            }
            this.paint.setXfermode(this.pdf);
            if (canvas != null) {
                canvas.drawCircle(r0.centerX(), r0.centerY(), this.binding.f421094c.getWidth() / 2.0f, this.paint);
            }
            this.paint.setXfermode(null);
        }
    }

    public final void setGuideViewFinishListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.guideViewFinishListener = listener;
    }

    public final void setPrivateBtnRect(@NotNull final Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        setAlpha(0.0f);
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.h
            @Override // java.lang.Runnable
            public final void run() {
                AnchorPrivateGuideView.g(AnchorPrivateGuideView.this, rect);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorPrivateGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnchorPrivateGuideView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorPrivateGuideView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tag = "AnchorPrivateGuideView";
        nr2.m g16 = nr2.m.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        Paint paint = new Paint();
        this.paint = paint;
        this.colorBg = Color.argb(204, 0, 0, 0);
        this.pdf = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        setWillNotDraw(false);
        paint.setAntiAlias(true);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        setLayerType(1, null);
        g16.f421093b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorPrivateGuideView.e(AnchorPrivateGuideView.this, view);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorPrivateGuideView.f(AnchorPrivateGuideView.this, view);
            }
        });
    }
}
