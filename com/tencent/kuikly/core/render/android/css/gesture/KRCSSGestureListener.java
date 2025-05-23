package com.tencent.kuikly.core.render.android.css.gesture;

import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.KGestureDetector;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 K2\u00020\u0001:\u00021'B\u0011\u0012\b\u0010k\u001a\u0004\u0018\u00010i\u00a2\u0006\u0004\bl\u0010mJ\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J4\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u00112\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%J\u0010\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u0005J\u0010\u0010+\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010)J7\u00101\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00072'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0,j\u0002`/J\u000e\u00102\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0002J\u000e\u00105\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002J\u0010\u00106\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u00107\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00108\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00109\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J*\u0010>\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;H\u0016J\u0010\u0010?\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010@\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010A\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010B\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J*\u0010E\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010C\u001a\u00020;2\u0006\u0010D\u001a\u00020;H\u0016R\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020G0F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010HR\"\u0010O\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010U\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010VR\u001e\u0010Y\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010XR\"\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0F0Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010]R\"\u0010a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010J\u001a\u0004\b_\u0010L\"\u0004\b`\u0010NR$\u0010h\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010k\u001a\u0004\u0018\u00010i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010j\u00a8\u0006n"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$f;", "Landroid/view/MotionEvent;", "e", "e2", "", "o", "", "ignorePointerIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "event", "D", "action", "", h.F, "motionEvent", "", "", "", "", "j", "type", "result", "d", "f", "g", "Lcom/tencent/kuikly/core/render/android/css/gesture/a;", "gestureDetector", "y", "enable", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/kuikly/core/render/android/KGestureDetector$ScrollDirection;", "panScrollDirection", "B", "l", "v", "Lcom/tencent/kuikly/core/render/android/css/gesture/b;", "listener", "b", "w", "Landroid/view/View;", "sharePanView", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "c", "ev", DomainData.DOMAIN_NAME, "t", "onDown", "u", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e1", "", "velocityX", "velocityY", "onFling", "onSingleTapUp", "onSingleTapConfirmed", "onDoubleTap", e.a.NAME, "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "", "Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener$b;", "Ljava/util/List;", "gestureListeners", "Z", "k", "()Z", "setPanEventHappening", "(Z)V", "isPanEventHappening", "I", "getMinimumPanTouches", "()I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)V", "minimumPanTouches", "Lcom/tencent/kuikly/core/render/android/KGestureDetector$ScrollDirection;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "gestureDetectorWeakRef", "Lkotlin/Lazy;", "Lkotlin/Lazy;", "panEventListeners", "Landroid/view/MotionEvent;", "panPointDownEvent", "getForcePanEvent", "setForcePanEvent", "forcePanEvent", "i", "Landroid/view/View;", "getPanShareView", "()Landroid/view/View;", "setPanShareView", "(Landroid/view/View;)V", "panShareView", "Lcom/tencent/kuikly/core/render/android/a;", "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyContext", "<init>", "(Lcom/tencent/kuikly/core/render/android/a;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRCSSGestureListener extends KGestureDetector.f {

    /* renamed from: b, reason: from kotlin metadata */
    private boolean isPanEventHappening;

    /* renamed from: e, reason: from kotlin metadata */
    private WeakReference<a> gestureDetectorWeakRef;

    /* renamed from: f, reason: from kotlin metadata */
    private Lazy<? extends List<com.tencent.kuikly.core.render.android.css.gesture.b>> panEventListeners;

    /* renamed from: g, reason: from kotlin metadata */
    private MotionEvent panPointDownEvent;

    /* renamed from: h */
    private boolean forcePanEvent;

    /* renamed from: i, reason: from kotlin metadata */
    @Nullable
    private View panShareView;

    /* renamed from: j, reason: from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a kuiklyContext;

    /* renamed from: a, reason: from kotlin metadata */
    private final List<b> gestureListeners = new ArrayList();

    /* renamed from: c, reason: from kotlin metadata */
    private int minimumPanTouches = 1;

    /* renamed from: d, reason: from kotlin metadata */
    private KGestureDetector.ScrollDirection panScrollDirection = KGestureDetector.ScrollDirection.DIRECTION_ALL;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B8\u0012'\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0002j\u0002`\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014RC\u0010\r\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0002j\u0002`\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener$b;", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "a", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "c", "(Lkotlin/jvm/functions/Function1;)V", "callback", "", "b", "I", "()I", "type", "<init>", "(Lkotlin/jvm/functions/Function1;I)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: from kotlin metadata */
        @NotNull
        private Function1<Object, Unit> callback;

        /* renamed from: b, reason: from kotlin metadata */
        private final int type;

        public b(@NotNull Function1<Object, Unit> callback, int i3) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.callback = callback;
            this.type = i3;
        }

        @NotNull
        public final Function1<Object, Unit> a() {
            return this.callback;
        }

        /* renamed from: b, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final void c(@NotNull Function1<Object, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "<set-?>");
            this.callback = function1;
        }
    }

    public KRCSSGestureListener(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        Lazy<? extends List<com.tencent.kuikly.core.render.android.css.gesture.b>> lazy;
        this.kuiklyContext = aVar;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<List<com.tencent.kuikly.core.render.android.css.gesture.b>>() { // from class: com.tencent.kuikly.core.render.android.css.gesture.KRCSSGestureListener$panEventListeners$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<b> invoke() {
                return new ArrayList();
            }
        });
        this.panEventListeners = lazy;
    }

    private final boolean D(MotionEvent event) {
        if (!this.forcePanEvent && event.getPointerCount() < this.minimumPanTouches) {
            return false;
        }
        return true;
    }

    private final String d(int action) {
        if (action != 0) {
            if (action != 2) {
                return "end";
            }
            return "move";
        }
        return "start";
    }

    private final boolean e(int type, Map<String, ? extends Object> result) {
        for (b bVar : this.gestureListeners) {
            if (bVar.getType() == type) {
                bVar.a().invoke(result);
            }
        }
        return true;
    }

    private final void f() {
        Iterator<T> it = this.panEventListeners.getValue().iterator();
        while (it.hasNext()) {
            ((com.tencent.kuikly.core.render.android.css.gesture.b) it.next()).a();
        }
    }

    private final void g() {
        Iterator<T> it = this.panEventListeners.getValue().iterator();
        while (it.hasNext()) {
            ((com.tencent.kuikly.core.render.android.css.gesture.b) it.next()).b();
        }
    }

    private final void h(int i3, MotionEvent motionEvent, int i16) {
        Map<String, ? extends Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, motionEvent.getX()))), TuplesKt.to("y", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, motionEvent.getY()))), TuplesKt.to("state", d(i3)), TuplesKt.to("pageX", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, motionEvent.getRawX()))), TuplesKt.to("pageY", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, motionEvent.getRawY()))), TuplesKt.to("touches", j(i3, motionEvent, i16)));
        e(4, mapOf);
    }

    static /* synthetic */ void i(KRCSSGestureListener kRCSSGestureListener, int i3, MotionEvent motionEvent, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = -1;
        }
        kRCSSGestureListener.h(i3, motionEvent, i16);
    }

    private final List<Map<String, Object>> j(int action, MotionEvent motionEvent, int ignorePointerIndex) {
        a aVar;
        View v3;
        Map mapOf;
        ArrayList arrayList = new ArrayList();
        WeakReference<a> weakReference = this.gestureDetectorWeakRef;
        if (weakReference != null && (aVar = weakReference.get()) != null && (v3 = aVar.v()) != null) {
            int pointerCount = motionEvent.getPointerCount();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (i3 != ignorePointerIndex) {
                    float x16 = motionEvent.getX(i3);
                    float y16 = motionEvent.getY(i3);
                    float[] fArr = {x16, y16};
                    l01.b.i(v3, fArr);
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, x16))), TuplesKt.to("y", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, y16))), TuplesKt.to("pageX", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, fArr[0]))), TuplesKt.to("pageY", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, fArr[1]))));
                    arrayList2.add(mapOf);
                }
            }
            return arrayList2;
        }
        return arrayList;
    }

    private final boolean o(MotionEvent e16, MotionEvent e26) {
        MotionEvent motionEvent;
        MotionEvent motionEvent2 = this.panPointDownEvent;
        if (motionEvent2 != null) {
            motionEvent = motionEvent2;
        } else {
            motionEvent = e26;
        }
        i(this, 0, motionEvent, 0, 4, null);
        if (this.panPointDownEvent != null) {
            this.panPointDownEvent = null;
            return true;
        }
        return true;
    }

    private final boolean p(MotionEvent e16) {
        i(this, 1, e16, 0, 4, null);
        return false;
    }

    private final boolean q(MotionEvent motionEvent, int i3) {
        h(2, motionEvent, i3);
        return true;
    }

    static /* synthetic */ boolean r(KRCSSGestureListener kRCSSGestureListener, MotionEvent motionEvent, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        return kRCSSGestureListener.q(motionEvent, i3);
    }

    public static /* synthetic */ void x(KRCSSGestureListener kRCSSGestureListener, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        kRCSSGestureListener.w(z16);
    }

    public final void A(int i3) {
        this.minimumPanTouches = i3;
    }

    public final void B(@NotNull KGestureDetector.ScrollDirection panScrollDirection) {
        a aVar;
        Intrinsics.checkNotNullParameter(panScrollDirection, "panScrollDirection");
        this.panScrollDirection = panScrollDirection;
        WeakReference<a> weakReference = this.gestureDetectorWeakRef;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.s(panScrollDirection);
        }
    }

    public final void C(@Nullable View view) {
        this.panShareView = view;
    }

    public final void a(int type, @NotNull Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        for (b bVar : this.gestureListeners) {
            if (bVar.getType() == type) {
                bVar.c(callback);
                return;
            }
        }
        this.gestureListeners.add(new b(callback, type));
    }

    public final void b(@NotNull com.tencent.kuikly.core.render.android.css.gesture.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.panEventListeners.getValue().add(listener);
    }

    public final boolean c(int type) {
        Iterator<b> it = this.gestureListeners.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == type) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsPanEventHappening() {
        return this.isPanEventHappening;
    }

    public final boolean l() {
        if (this.minimumPanTouches != 2 && !this.forcePanEvent) {
            return false;
        }
        return true;
    }

    public final void m(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        if (this.isPanEventHappening) {
            p(e16);
        }
        this.isPanEventHappening = false;
    }

    public final boolean n(@NotNull MotionEvent ev5) {
        a aVar;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        WeakReference<a> weakReference = this.gestureDetectorWeakRef;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar.n(ev5);
        }
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.KGestureDetector.d
    public boolean onDoubleTap(@Nullable MotionEvent e16) {
        Map<String, ? extends Object> mapOf;
        Map<String, ? extends Object> mapOf2;
        if (e16 == null) {
            return false;
        }
        if (!c(2)) {
            mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getX()))), TuplesKt.to("y", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getY()))));
            return e(1, mapOf2);
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getX()))), TuplesKt.to("y", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getY()))));
        return e(2, mapOf);
    }

    @Override // com.tencent.kuikly.core.render.android.KGestureDetector.e
    public boolean onDown(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        return true;
    }

    @Override // com.tencent.kuikly.core.render.android.KGestureDetector.f, com.tencent.kuikly.core.render.android.KGestureDetector.e
    public boolean onFling(@Nullable MotionEvent e16, @NotNull MotionEvent e26, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(e26, "e2");
        if (this.isPanEventHappening) {
            f();
            return true;
        }
        return super.onFling(e16, e26, velocityX, velocityY);
    }

    @Override // com.tencent.kuikly.core.render.android.KGestureDetector.e
    public void onLongPress(@NotNull MotionEvent e16) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(e16, "e");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getX()))), TuplesKt.to("y", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getY()))), TuplesKt.to("state", d(e16.getAction())));
        e(3, mapOf);
    }

    @Override // com.tencent.kuikly.core.render.android.KGestureDetector.e
    public boolean onScroll(@Nullable MotionEvent motionEvent, @NotNull MotionEvent e26, float f16, float f17) {
        a aVar;
        Intrinsics.checkNotNullParameter(e26, "e2");
        if (!c(4) || !D(e26)) {
            return false;
        }
        if (!this.isPanEventHappening) {
            o(motionEvent, e26);
            this.isPanEventHappening = true;
            WeakReference<a> weakReference = this.gestureDetectorWeakRef;
            if (weakReference != null && (aVar = weakReference.get()) != null && !aVar.o()) {
                aVar.u(true);
            }
        }
        r(this, e26, 0, 2, null);
        return true;
    }

    @Override // com.tencent.kuikly.core.render.android.KGestureDetector.d
    public boolean onSingleTapConfirmed(@Nullable MotionEvent e16) {
        Map<String, ? extends Object> mapOf;
        if (e16 == null || !c(2)) {
            return false;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getX()))), TuplesKt.to("y", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getY()))));
        return e(1, mapOf);
    }

    @Override // com.tencent.kuikly.core.render.android.KGestureDetector.e
    public boolean onSingleTapUp(@NotNull MotionEvent e16) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(e16, "e");
        if (!c(2) && c(1)) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getX()))), TuplesKt.to("y", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(this.kuiklyContext, e16.getY()))));
            return e(1, mapOf);
        }
        return false;
    }

    public final void s(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        if (this.isPanEventHappening) {
            q(e16, e16.getActionIndex());
        }
    }

    public final void t(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        View view = this.panShareView;
        if (view != null) {
            view.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1 && actionMasked != 3) {
            if (actionMasked == 5) {
                this.panPointDownEvent = motionEvent;
            }
        } else {
            this.panPointDownEvent = null;
            this.forcePanEvent = false;
            this.panShareView = null;
        }
    }

    public final void u(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        if (this.isPanEventHappening) {
            p(e16);
            g();
        }
        this.isPanEventHappening = false;
    }

    public final void v(boolean enable) {
        a aVar;
        WeakReference<a> weakReference = this.gestureDetectorWeakRef;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.k(enable);
        }
    }

    public final void w(boolean enable) {
        this.forcePanEvent = enable;
    }

    public final void y(@NotNull a gestureDetector) {
        Intrinsics.checkNotNullParameter(gestureDetector, "gestureDetector");
        gestureDetector.s(this.panScrollDirection);
        this.gestureDetectorWeakRef = new WeakReference<>(gestureDetector);
    }

    public final void z(boolean z16) {
        a aVar;
        WeakReference<a> weakReference = this.gestureDetectorWeakRef;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.q(z16);
        }
    }
}
