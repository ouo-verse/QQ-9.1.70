package com.tencent.mobileqq.qqvideoedit.editor.crop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u0003456B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-B\u001b\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b,\u00100B#\b\u0016\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00101\u001a\u00020\u0007\u00a2\u0006\u0004\b,\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0014\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010!R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorGestureTextureView;", "Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorCropTextureView;", "", "O", "", "scaleEnabled", "setScaleEnabled", "", "doubleTapScaleSteps", "setDoubleTapScaleSteps", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "", "N", "P", "Lkotlin/Function0;", "onSingleTapUpListener", "setSingleTapUpListener", "Landroid/view/ScaleGestureDetector;", "U", "Landroid/view/ScaleGestureDetector;", "mScaleDetector", "Landroid/view/GestureDetector;", "V", "Landroid/view/GestureDetector;", "mGestureDetector", "W", UserInfo.SEX_FEMALE, "mMidPntX", "a0", "mMidPntY", "b0", "Z", "mIsScaleEnabled", "c0", "I", "mDoubleTapScaleSteps", "d0", "isTouchReleased", "e0", "Lkotlin/jvm/functions/Function0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f0", "a", "b", "c", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class VideoEditorGestureTextureView extends VideoEditorCropTextureView {

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ScaleGestureDetector mScaleDetector;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private GestureDetector mGestureDetector;

    /* renamed from: W, reason: from kotlin metadata */
    private float mMidPntX;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private float mMidPntY;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsScaleEnabled;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int mDoubleTapScaleSteps;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isTouchReleased;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Boolean> onSingleTapUpListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorGestureTextureView$b;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapUp", "onDoubleTap", "e1", "e2", "", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorGestureTextureView;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(e16, "e");
            VideoEditorGestureTextureView videoEditorGestureTextureView = VideoEditorGestureTextureView.this;
            videoEditorGestureTextureView.I(videoEditorGestureTextureView.N(), e16.getX(), e16.getY(), 200L);
            return super.onDoubleTap(e16);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
            Intrinsics.checkNotNullParameter(e16, "e1");
            Intrinsics.checkNotNullParameter(e26, "e2");
            VideoEditorGestureTextureView.this.s(-distanceX, -distanceY);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            Function0 function0 = VideoEditorGestureTextureView.this.onSingleTapUpListener;
            if (function0 == null || !((Boolean) function0.invoke()).booleanValue()) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorGestureTextureView$c;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "Landroid/view/ScaleGestureDetector;", "detector", "", "onScale", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/crop/VideoEditorGestureTextureView;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(@NotNull ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            VideoEditorGestureTextureView.this.r(detector.getScaleFactor(), VideoEditorGestureTextureView.this.mMidPntX, VideoEditorGestureTextureView.this.mMidPntY);
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorGestureTextureView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void O() {
        this.mGestureDetector = new GestureDetector(getContext(), new b(), null, true);
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new c());
    }

    public final float N() {
        return e() * ((float) Math.pow(getMMaxScale() / getMMinScale(), 1.0f / this.mDoubleTapScaleSteps));
    }

    /* renamed from: P, reason: from getter */
    public final boolean getIsTouchReleased() {
        return this.isTouchReleased;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isTouchReleased = z16;
        if ((event.getAction() & 255) == 0) {
            y();
        }
        if (event.getPointerCount() > 1) {
            float f16 = 2;
            this.mMidPntX = (event.getX(0) + event.getX(1)) / f16;
            this.mMidPntY = (event.getY(0) + event.getY(1)) / f16;
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        Intrinsics.checkNotNull(gestureDetector);
        gestureDetector.onTouchEvent(event);
        if (this.mIsScaleEnabled) {
            ScaleGestureDetector scaleGestureDetector = this.mScaleDetector;
            Intrinsics.checkNotNull(scaleGestureDetector);
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

    public final void setSingleTapUpListener(@NotNull Function0<Boolean> onSingleTapUpListener) {
        Intrinsics.checkNotNullParameter(onSingleTapUpListener, "onSingleTapUpListener");
        this.onSingleTapUpListener = onSingleTapUpListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoEditorGestureTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoEditorGestureTextureView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsScaleEnabled = true;
        this.mDoubleTapScaleSteps = 5;
        this.isTouchReleased = true;
        O();
    }
}
