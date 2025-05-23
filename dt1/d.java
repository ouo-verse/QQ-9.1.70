package dt1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006 "}, d2 = {"Ldt1/d;", "Let1/d;", "Landroid/view/View;", "view", "", h.F, "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/View$OnClickListener;", "emptyListener", "buttonListener", "k", "a", "b", "", "Z", "mIsImmersiveAnimLocked", "Landroid/view/GestureDetector;", "Landroid/view/GestureDetector;", "emptyDetector", "c", "buttonDetector", "d", "Landroid/view/View$OnClickListener;", "onChildViewEmptyClickHandler", "e", "onChildViewButtonClickHandler", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements et1.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mIsImmersiveAnimLocked;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetector emptyDetector;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetector buttonDetector;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener onChildViewEmptyClickHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View.OnClickListener onChildViewButtonClickHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"dt1/d$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
            View.OnClickListener onClickListener;
            if (!d.this.mIsImmersiveAnimLocked && (onClickListener = d.this.onChildViewButtonClickHandler) != null) {
                onClickListener.onClick(null);
            }
            return super.onSingleTapConfirmed(e16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"dt1/d$c", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onSingleTapConfirmed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
            View.OnClickListener onClickListener;
            if (!d.this.mIsImmersiveAnimLocked && (onClickListener = d.this.onChildViewEmptyClickHandler) != null) {
                onClickListener.onClick(null);
            }
            return super.onSingleTapConfirmed(e16);
        }
    }

    public d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.emptyDetector = new GestureDetector(context, new c());
        this.buttonDetector = new GestureDetector(context, new b());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void h(View view) {
        if (view.hasOnClickListeners()) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: dt1.b
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean i3;
                    i3 = d.i(d.this, view2, motionEvent);
                    return i3;
                }
            });
        } else {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: dt1.c
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean j3;
                    j3 = d.j(d.this, view2, motionEvent);
                    return j3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(d this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.buttonDetector.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(d this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.emptyDetector.onTouchEvent(motionEvent);
    }

    @Override // et1.d
    public void a() {
        this.mIsImmersiveAnimLocked = true;
    }

    @Override // et1.d
    public void b() {
        this.mIsImmersiveAnimLocked = false;
    }

    public final void k(@NotNull ViewGroup viewGroup, @Nullable View.OnClickListener emptyListener, @Nullable View.OnClickListener buttonListener) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        this.onChildViewButtonClickHandler = buttonListener;
        this.onChildViewEmptyClickHandler = emptyListener;
        h(viewGroup);
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View view = viewGroup.getChildAt(i3);
            if (view instanceof ViewGroup) {
                k((ViewGroup) view, emptyListener, buttonListener);
            } else {
                Intrinsics.checkNotNullExpressionValue(view, "view");
                h(view);
            }
        }
    }
}
