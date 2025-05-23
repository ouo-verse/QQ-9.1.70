package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.MusicDotBarView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.videocut.utils.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u001b\u001f\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,B\u001b\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u00a2\u0006\u0004\b+\u0010/B#\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u00100\u001a\u00020\u0003\u00a2\u0006\u0004\b+\u00101J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0014\u0010\u000f\u001a\u00020\b2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0015R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0017j\b\u0012\u0004\u0012\u00020\u0006`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/MusicDotBarView;", "Landroid/view/View;", "Lf63/b;", "", "e", "", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/b;", "list", "", "f", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Lf63/a;", "controller", ReportConstant.COSTREPORT_PREFIX, "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "dotPaint", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/a;", "musicDotBarViewController", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "musicDotList", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/MusicDotBarView$a", h.F, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/MusicDotBarView$a;", "listener", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/MusicDotBarView$b", "i", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/MusicDotBarView$b;", "onScrollGestureListener", "Landroid/view/GestureDetector;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "getScrollGestureDetector", "()Landroid/view/GestureDetector;", "scrollGestureDetector", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MusicDotBarView extends View implements f63.b {

    @NotNull
    public Map<Integer, View> C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint dotPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a musicDotBarViewController;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MusicDotModel> musicDotList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a listener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b onScrollGestureListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scrollGestureDetector;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/MusicDotBarView$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "e1", "e2", "", "velocityX", "velocityY", "onFling", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NotNull MotionEvent e16) {
            FlingHelper i3;
            Intrinsics.checkNotNullParameter(e16, "e");
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a aVar = MusicDotBarView.this.musicDotBarViewController;
            if (aVar != null && (i3 = aVar.i()) != null) {
                i3.g();
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            FlingHelper i3;
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a aVar = MusicDotBarView.this.musicDotBarViewController;
            if (aVar != null && (i3 = aVar.i()) != null) {
                i3.f(-((int) velocityX), MusicDotBarView.this.getScrollX(), MusicDotBarView.this.e(), MusicDotBarView.this.listener);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
            FlingHelper i3;
            Intrinsics.checkNotNullParameter(e16, "e1");
            Intrinsics.checkNotNullParameter(e26, "e2");
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a aVar = MusicDotBarView.this.musicDotBarViewController;
            if (aVar != null && (i3 = aVar.i()) != null) {
                i3.g();
            }
            int scrollX = MusicDotBarView.this.getScrollX() + ((int) distanceX);
            if (scrollX < 0) {
                scrollX = 0;
            } else if (scrollX > MusicDotBarView.this.e()) {
                scrollX = MusicDotBarView.this.e();
            }
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a aVar2 = MusicDotBarView.this.musicDotBarViewController;
            if (aVar2 != null) {
                aVar2.r(scrollX);
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MusicDotBarView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int e() {
        i63.b m3;
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a aVar = this.musicDotBarViewController;
        if (aVar != null && (m3 = aVar.m()) != null) {
            return m3.d();
        }
        return 0;
    }

    public final void f(@NotNull List<MusicDotModel> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.musicDotList.clear();
        this.musicDotList.addAll(list);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        float[] floatArray;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a aVar = this.musicDotBarViewController;
        if (aVar == null) {
            return;
        }
        float height = getHeight() / 2.0f;
        ArrayList arrayList = new ArrayList();
        int panelStartOffset = aVar.h().getLayoutConfig().getPanelStartOffset();
        Iterator<T> it = this.musicDotList.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(aVar.m().y(((MusicDotModel) it.next()).getDotTimeUs()) + panelStartOffset));
            arrayList.add(Float.valueOf(height));
        }
        floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList);
        canvas.drawPoints(floatArray, this.dotPaint);
    }

    @Override // f63.b
    public void s(@NotNull f63.a<?> controller) {
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a aVar;
        Intrinsics.checkNotNullParameter(controller, "controller");
        if (controller instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a) {
            aVar = (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a) controller;
        } else {
            aVar = null;
        }
        this.musicDotBarViewController = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MusicDotBarView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicDotBarView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.C = new LinkedHashMap();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(e.f384236a.a(4.0f));
        paint.setColor(-1);
        this.dotPaint = paint;
        this.musicDotList = new ArrayList<>();
        this.listener = new a();
        this.onScrollGestureListener = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.MusicDotBarView$scrollGestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GestureDetector invoke() {
                MusicDotBarView.b bVar;
                Context context2 = MusicDotBarView.this.getContext();
                bVar = MusicDotBarView.this.onScrollGestureListener;
                return new GestureDetector(context2, bVar);
            }
        });
        this.scrollGestureDetector = lazy;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/musicdot/MusicDotBarView$a", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$a;", "", "xPos", "", "b", "", "cancel", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements FlingHelper.a {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void b(int xPos) {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.musicdot.a aVar = MusicDotBarView.this.musicDotBarViewController;
            if (aVar != null) {
                aVar.r(xPos);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void a(int xPos, boolean cancel) {
        }
    }
}
