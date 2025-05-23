package com.tencent.sqshow.zootopia.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001a\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005\u001a\"\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b\u001a\u0012\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b\u001a-\u0010\u0013\u001a\u00020\u0003\"\b\b\u0000\u0010\u000f*\u00020\u000e*\u00020\u00002\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0010\u00a2\u0006\u0002\b\u0011\u001a\u0014\u0010\u0017\u001a\u00020\u0003*\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0015\u00a8\u0006\u0018"}, d2 = {"Landroid/view/View;", "Landroid/view/View$OnClickListener;", "l", "", "d", "", "timeGap", "e", "", "key", "f", "", "expendSize", "b", "Landroid/view/ViewGroup$LayoutParams;", "T", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", tl.h.F, "Landroidx/viewpager2/widget/ViewPager2;", "", "enable", "g", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class aa {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/utils/aa$a", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f373245d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f373246e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f373247f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f373248h;

        a(String str, long j3, View view, View.OnClickListener onClickListener) {
            this.f373245d = str;
            this.f373246e = j3;
            this.f373247f = view;
            this.f373248h = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            if (h.c(this.f373245d, this.f373246e)) {
                QLog.w("DoubleClick", 2, "double clicked! view:" + this.f373247f + " key:" + this.f373245d);
                return;
            }
            this.f373248h.onClick(v3);
        }
    }

    public static final void b(final View view, final int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view2 = (View) parent;
        view2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.utils.z
            @Override // java.lang.Runnable
            public final void run() {
                aa.c(view, i3, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View this_expendTouchArea, int i3, View parentView) {
        Intrinsics.checkNotNullParameter(this_expendTouchArea, "$this_expendTouchArea");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Rect rect = new Rect();
        this_expendTouchArea.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i3;
        rect.left -= i3;
        rect.right += i3;
        parentView.setTouchDelegate(new TouchDelegate(rect, this_expendTouchArea));
    }

    public static final void d(View view, View.OnClickListener l3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(l3, "l");
        e(view, l3, 500L);
    }

    public static final void e(View view, View.OnClickListener l3, long j3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(l3, "l");
        f(view, l3, j3, "default");
    }

    public static final void f(View view, View.OnClickListener l3, long j3, String key) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(l3, "l");
        Intrinsics.checkNotNullParameter(key, "key");
        view.setOnClickListener(new a(key, j3, view, l3));
    }

    public static final <T extends ViewGroup.LayoutParams> void h(View view, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type T of com.tencent.sqshow.zootopia.utils.ViewExKt.updateLayoutParams");
        block.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void g(ViewPager2 viewPager2, boolean z16) {
        if (viewPager2 == null) {
            return;
        }
        int childCount = viewPager2.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewPager2.getChildAt(i3);
            if (childAt instanceof RecyclerView) {
                RecyclerView.ItemAnimator itemAnimator = ((RecyclerView) childAt).getItemAnimator();
                Intrinsics.checkNotNull(itemAnimator, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
                ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(z16);
                return;
            }
        }
    }
}
