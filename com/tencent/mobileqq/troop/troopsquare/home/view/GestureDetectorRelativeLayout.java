package com.tencent.mobileqq.troop.troopsquare.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import androidx.core.view.GestureDetectorCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.home.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010,\u001a\u00020+\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0013\u0010\u001dR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/home/view/GestureDetectorRelativeLayout;", "Landroid/widget/RelativeLayout;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "disallowIntercept", "", "requestDisallowInterceptTouchEvent", "Landroidx/core/view/GestureDetectorCompat;", "d", "Landroidx/core/view/GestureDetectorCompat;", "gestureDetector", "e", "Landroid/view/MotionEvent;", "scrollStart", "f", "Z", "hasVelocity", h.F, "Ljava/lang/Boolean;", "hasGesture", "Lcom/tencent/mobileqq/troop/troopsquare/home/e;", "<set-?>", "i", "Lcom/tencent/mobileqq/troop/troopsquare/home/e;", "()Lcom/tencent/mobileqq/troop/troopsquare/home/e;", "currentGesture", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "g", "()Ljava/util/List;", "setGestureHandlers", "(Ljava/util/List;)V", "gestureHandlers", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class GestureDetectorRelativeLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GestureDetectorCompat gestureDetector;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MotionEvent scrollStart;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasVelocity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean hasGesture;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e currentGesture;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends e> gestureHandlers;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J(\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/home/view/GestureDetectorRelativeLayout$a", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e1", "e2", "", "distanceX", "distanceY", "", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "velocityX", "velocityY", "onFling", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GestureDetectorRelativeLayout.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float velocityX, float velocityY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, e16, e26, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e1");
            Intrinsics.checkNotNullParameter(e26, "e2");
            if (Intrinsics.areEqual(GestureDetectorRelativeLayout.this.hasGesture, Boolean.FALSE)) {
                return false;
            }
            for (e eVar : GestureDetectorRelativeLayout.this.g()) {
                if (eVar.c(e16, e26, velocityX, velocityY)) {
                    GestureDetectorRelativeLayout.this.hasGesture = Boolean.TRUE;
                    GestureDetectorRelativeLayout.this.hasVelocity = true;
                    GestureDetectorRelativeLayout.this.currentGesture = eVar;
                    eVar.onFling(e16, e26, velocityX, velocityY);
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, e16, e26, Float.valueOf(distanceX), Float.valueOf(distanceY))).booleanValue();
            }
            Intrinsics.checkNotNullParameter(e16, "e1");
            Intrinsics.checkNotNullParameter(e26, "e2");
            if (Intrinsics.areEqual(GestureDetectorRelativeLayout.this.hasGesture, Boolean.FALSE)) {
                return false;
            }
            if (Intrinsics.areEqual(GestureDetectorRelativeLayout.this.hasGesture, Boolean.TRUE)) {
                e f16 = GestureDetectorRelativeLayout.this.f();
                if (f16 != null) {
                    f16.b(e16, e26);
                }
                return true;
            }
            Iterator<e> it = GestureDetectorRelativeLayout.this.g().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e next = it.next();
                if (next.a(e16, e26)) {
                    GestureDetectorRelativeLayout.this.hasGesture = Boolean.TRUE;
                    GestureDetectorRelativeLayout.this.scrollStart = e16;
                    GestureDetectorRelativeLayout.this.currentGesture = next;
                    break;
                }
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GestureDetectorRelativeLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getAction() == 0) {
            this.scrollStart = null;
            this.hasVelocity = false;
            this.hasGesture = null;
            this.currentGesture = null;
        }
        this.gestureDetector.onTouchEvent(ev5);
        super.dispatchTouchEvent(ev5);
        return true;
    }

    @Nullable
    public final e f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.currentGesture;
    }

    @NotNull
    public final List<e> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.gestureHandlers;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) ev5)).booleanValue();
        }
        if (Intrinsics.areEqual(this.hasGesture, Boolean.TRUE)) {
            return true;
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) event)).booleanValue();
        }
        if (event != null) {
            num = Integer.valueOf(event.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            if (Intrinsics.areEqual(this.hasGesture, Boolean.TRUE) && !this.hasVelocity) {
                e eVar = this.currentGesture;
                if (eVar != null) {
                    MotionEvent motionEvent = this.scrollStart;
                    Intrinsics.checkNotNull(motionEvent);
                    eVar.onFling(motionEvent, event, 0.0f, 0.0f);
                }
                this.currentGesture = null;
            }
        } else if (num != null && num.intValue() == 3 && Intrinsics.areEqual(this.hasGesture, Boolean.TRUE)) {
            e eVar2 = this.currentGesture;
            if (eVar2 != null) {
                eVar2.onCancel();
            }
            this.currentGesture = null;
        }
        return super.onTouchEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, disallowIntercept);
        } else {
            if (Intrinsics.areEqual(this.hasGesture, Boolean.TRUE)) {
                return;
            }
            this.hasGesture = Boolean.FALSE;
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    public final void setGestureHandlers(@NotNull List<? extends e> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.gestureHandlers = list;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GestureDetectorRelativeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ GestureDetectorRelativeLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GestureDetectorRelativeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<? extends e> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.gestureDetector = new GestureDetectorCompat(context, new a());
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.gestureHandlers = emptyList;
    }
}
