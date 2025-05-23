package com.tencent.ecommerce.base.ktx;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a(\u0010\t\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0007\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u0000\u00a8\u0006\f"}, d2 = {"Landroid/view/View;", "", "expandWidth", "", "a", "", "delayTime", "Lkotlin/Function1;", NodeProps.ON_CLICK, "b", "Landroid/graphics/Bitmap;", "d", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ViewExtKt {
    public static final void a(final View view, final int i3) {
        Object parent = view.getParent();
        if (parent != null) {
            final View view2 = (View) parent;
            view2.post(new Runnable() { // from class: com.tencent.ecommerce.base.ktx.ViewExtKt$expandTouchArea$1
                @Override // java.lang.Runnable
                public final void run() {
                    Rect rect = new Rect();
                    view.getHitRect(rect);
                    int i16 = rect.top;
                    int i17 = i3;
                    rect.top = i16 - i17;
                    rect.bottom += i17;
                    rect.left -= i17;
                    rect.right += i17;
                    view2.setTouchDelegate(new TouchDelegate(rect, view));
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    }

    public static final void b(final View view, final long j3, final Function1<? super View, Unit> function1) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ecommerce.base.ktx.ViewExtKt$setOnClickListenerWithTrigger$1
            @Override // android.view.View.OnClickListener
            public final void onClick(final View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                Object tag = view.getTag(R.id.f163113od2);
                if (!(tag instanceof k)) {
                    tag = null;
                }
                k kVar = (k) tag;
                if (kVar == null) {
                    kVar = new k(j3);
                    view.setTag(R.id.f163113od2, kVar);
                }
                kVar.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.base.ktx.ViewExtKt$setOnClickListenerWithTrigger$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function1.invoke(view2);
                    }
                });
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
    }

    public static final Bitmap d(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Exception e16) {
            cg0.a.a("ViewExt", "toBitmap", "draw bitmap error: " + e16 + ", try use view cache");
            try {
                boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
                boolean willNotCacheDrawing = view.willNotCacheDrawing();
                view.setDrawingCacheEnabled(true);
                view.setWillNotCacheDrawing(false);
                Bitmap drawingCache = view.getDrawingCache();
                Bitmap copy = drawingCache != null ? drawingCache.copy(Bitmap.Config.ARGB_8888, false) : null;
                view.destroyDrawingCache();
                view.setWillNotCacheDrawing(willNotCacheDrawing);
                view.setDrawingCacheEnabled(isDrawingCacheEnabled);
                return copy;
            } catch (Exception e17) {
                cg0.a.a("ViewExt", "toBitmap", "view to bitmap error: " + e17);
                return null;
            }
        } catch (OutOfMemoryError e18) {
            cg0.a.a("ViewExt", "toBitmap", "OOM error: " + e18);
            return null;
        }
    }

    public static /* synthetic */ void c(View view, long j3, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 500;
        }
        b(view, j3, function1);
    }
}
