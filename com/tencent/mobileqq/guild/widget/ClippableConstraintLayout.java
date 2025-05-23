package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002)*B1\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u000e\u0012\b\b\u0002\u0010&\u001a\u00020\u000e\u00a2\u0006\u0004\b'\u0010(J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0014R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/view/View;", "child", "", "drawingTime", "", "drawChild", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "dispatchTouchEvent", "", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$a;", "d", "Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$a;", "z0", "()Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$a;", "clipData", "Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$b;", "e", "Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$b;", "getTouchEventListener", "()Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$b;", "setTouchEventListener", "(Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$b;)V", "touchEventListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ClippableConstraintLayout extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a clipData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b touchEventListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$b;", "", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onDispatchTouchEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void onDispatchTouchEvent(@Nullable MotionEvent ev5);

        void onInterceptTouchEvent(@Nullable MotionEvent ev5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ClippableConstraintLayout(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        b bVar = this.touchEventListener;
        if (bVar != null) {
            bVar.onDispatchTouchEvent(ev5);
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(@NotNull Canvas canvas, @NotNull View child, long drawingTime) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        if (this.clipData.getNonClipChild() != null) {
            if (!Intrinsics.areEqual(this.clipData.getNonClipChild(), child)) {
                int save = canvas.save();
                canvas.clipRect(this.clipData.getLeft() + 0, this.clipData.getTop() + 0, getWidth() - this.clipData.getRight(), getHeight() - this.clipData.getBottom());
                boolean drawChild = super.drawChild(canvas, child, drawingTime);
                canvas.restoreToCount(save);
                return drawChild;
            }
            Logger.f235387a.d().i("ClippableConstraintLayout", 1, "drawChild: nonClipChild = " + getClipData().getNonClipChild() + ", child = " + child);
        }
        return super.drawChild(canvas, child, drawingTime);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        b bVar = this.touchEventListener;
        if (bVar != null) {
            bVar.onInterceptTouchEvent(ev5);
        }
        return super.onInterceptTouchEvent(ev5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        if (AppSetting.t(BaseApplication.getContext()) && View.MeasureSpec.getMode(widthMeasureSpec) != 1073741824) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("ClippableConstraintLayout", "onMeasure(Ignore Child): width = " + size + ", height = " + size2 + ", widthMode = " + mode + ", heightMode = " + mode2);
            }
            setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(mode, size), View.MeasureSpec.makeMeasureSpec(mode2, size2));
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("ClippableConstraintLayout", "onMeasure(): width = " + size + ", height = " + size2 + ", widthMode = " + mode + ", heightMode = " + mode2);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setTouchEventListener(@Nullable b bVar) {
        this.touchEventListener = bVar;
    }

    @NotNull
    /* renamed from: z0, reason: from getter */
    public final a getClipData() {
        return this.clipData;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ClippableConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ClippableConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ClippableConstraintLayout(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ClippableConstraintLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.clipData = new a(0, 0, 0, 0, null, 31, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0014\u001a\u0004\b\r\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/ClippableConstraintLayout$a;", "", "", "a", "I", "b", "()I", "setLeft", "(I)V", "left", "e", "setTop", "top", "c", "d", "setRight", "right", "setBottom", "bottom", "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "setNonClipChild", "(Landroid/view/View;)V", "nonClipChild", "<init>", "(IIIILandroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int left;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int top;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int right;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int bottom;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private View nonClipChild;

        public a(int i3, int i16, int i17, int i18, @Nullable View view) {
            this.left = i3;
            this.top = i16;
            this.right = i17;
            this.bottom = i18;
            this.nonClipChild = view;
        }

        /* renamed from: a, reason: from getter */
        public final int getBottom() {
            return this.bottom;
        }

        /* renamed from: b, reason: from getter */
        public final int getLeft() {
            return this.left;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final View getNonClipChild() {
            return this.nonClipChild;
        }

        /* renamed from: d, reason: from getter */
        public final int getRight() {
            return this.right;
        }

        /* renamed from: e, reason: from getter */
        public final int getTop() {
            return this.top;
        }

        public /* synthetic */ a(int i3, int i16, int i17, int i18, View view, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this((i19 & 1) != 0 ? 0 : i3, (i19 & 2) != 0 ? 0 : i16, (i19 & 4) != 0 ? 0 : i17, (i19 & 8) == 0 ? i18 : 0, (i19 & 16) != 0 ? null : view);
        }
    }
}
