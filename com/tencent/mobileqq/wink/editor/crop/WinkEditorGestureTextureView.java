package com.tencent.mobileqq.wink.editor.crop;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u0001:\u0003/01B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u00a2\u0006\u0004\b'\u0010+B#\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010,\u001a\u00020\u0007\u00a2\u0006\u0004\b'\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001e\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorGestureTextureView;", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropTextureView;", "", "X", "", "scaleEnabled", "setScaleEnabled", "", "doubleTapScaleSteps", "setDoubleTapScaleSteps", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "", "W", "Y", "Landroid/view/ScaleGestureDetector;", "a0", "Landroid/view/ScaleGestureDetector;", "mScaleDetector", "Landroid/view/GestureDetector;", "b0", "Landroid/view/GestureDetector;", "mGestureDetector", "c0", UserInfo.SEX_FEMALE, "mMidPntX", "d0", "mMidPntY", "e0", "Z", "mIsScaleEnabled", "f0", "I", "mDoubleTapScaleSteps", "g0", "isTouchReleased", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i0", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorGestureTextureView extends WinkEditorCropTextureView {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ScaleGestureDetector mScaleDetector;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GestureDetector mGestureDetector;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private float mMidPntX;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private float mMidPntY;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsScaleEnabled;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private int mDoubleTapScaleSteps;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isTouchReleased;

    /* renamed from: h0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f319806h0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorGestureTextureView$b;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDoubleTap", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "<init>", "(Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorGestureTextureView;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            WinkEditorGestureTextureView winkEditorGestureTextureView = WinkEditorGestureTextureView.this;
            winkEditorGestureTextureView.S(winkEditorGestureTextureView.W(), e16.getX(), e16.getY(), 200L);
            return super.onDoubleTap(e16);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
            float f16;
            float f17;
            float f18;
            float f19;
            Intrinsics.checkNotNullParameter(e16, "e1");
            Intrinsics.checkNotNullParameter(e26, "e2");
            RectF c16 = WinkEditorGestureTextureView.this.c();
            if (distanceX >= 0.0f) {
                if (c16.right - distanceX < WinkEditorGestureTextureView.this.getMCropRect().left) {
                    f16 = c16.right;
                    f17 = WinkEditorGestureTextureView.this.getMCropRect().left;
                    distanceX = f16 - f17;
                }
            } else if (c16.left - distanceX > WinkEditorGestureTextureView.this.getMCropRect().right) {
                f16 = c16.left;
                f17 = WinkEditorGestureTextureView.this.getMCropRect().right;
                distanceX = f16 - f17;
            }
            if (distanceY >= 0.0f) {
                if (c16.bottom - distanceY < WinkEditorGestureTextureView.this.getMCropRect().top) {
                    f18 = c16.bottom;
                    f19 = WinkEditorGestureTextureView.this.getMCropRect().top;
                    distanceY = f18 - f19;
                }
            } else if (c16.top - distanceY > WinkEditorGestureTextureView.this.getMCropRect().bottom) {
                f18 = c16.top;
                f19 = WinkEditorGestureTextureView.this.getMCropRect().bottom;
                distanceY = f18 - f19;
            }
            WinkEditorGestureTextureView.this.s(-distanceX, -distanceY);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorGestureTextureView$c;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "Landroid/view/ScaleGestureDetector;", "detector", "", "onScale", "<init>", "(Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorGestureTextureView;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(@NotNull ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            WinkEditorGestureTextureView.this.r(detector.getScaleFactor(), WinkEditorGestureTextureView.this.mMidPntX, WinkEditorGestureTextureView.this.mMidPntY);
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorGestureTextureView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void X() {
        this.mGestureDetector = new GestureDetector(getContext(), new b(), null, true);
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new c());
    }

    public final float W() {
        return e() * ((float) Math.pow(getMMaxScale() / getMMinScale(), 1.0f / this.mDoubleTapScaleSteps));
    }

    /* renamed from: Y, reason: from getter */
    public final boolean getIsTouchReleased() {
        return this.isTouchReleased;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        boolean z16;
        ScaleGestureDetector scaleGestureDetector;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isTouchReleased = z16;
        if ((event.getAction() & 255) == 0) {
            B();
        }
        if (event.getPointerCount() > 1) {
            float f16 = 2;
            this.mMidPntX = (event.getX(0) + event.getX(1)) / f16;
            this.mMidPntY = (event.getY(0) + event.getY(1)) / f16;
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(event);
        }
        if (this.mIsScaleEnabled && (scaleGestureDetector = this.mScaleDetector) != null) {
            scaleGestureDetector.onTouchEvent(event);
        }
        if ((event.getAction() & 255) == 1) {
            setImageToWrapCropBounds();
        }
        return true;
    }

    public final void setDoubleTapScaleSteps(int doubleTapScaleSteps) {
        this.mDoubleTapScaleSteps = doubleTapScaleSteps;
    }

    public final void setScaleEnabled(boolean scaleEnabled) {
        this.mIsScaleEnabled = scaleEnabled;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkEditorGestureTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorGestureTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f319806h0 = new LinkedHashMap();
        this.mIsScaleEnabled = true;
        this.mDoubleTapScaleSteps = 5;
        this.isTouchReleased = true;
        X();
    }
}
