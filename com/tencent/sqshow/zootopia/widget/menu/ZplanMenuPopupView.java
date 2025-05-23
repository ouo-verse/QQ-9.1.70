package com.tencent.sqshow.zootopia.widget.menu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.widget.BubblePopupWindow;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import t74.u;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002#\u001bB\u0007\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\nJ*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004J8\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0014R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuPopupView;", "", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuPopupView$a;", "listener", "Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuLayout;", "d", "Lcom/tencent/sqshow/zootopia/widget/menu/b;", "dataItem", "", "b", "c", "Landroid/view/View;", "archer", "", HippyTKDListViewAdapter.X, "y", "i", "arrowType", "", "touchOutsideToDismiss", h.F, "f", "e", "g", "Lcom/tencent/widget/BubblePopupWindow;", "a", "Lcom/tencent/widget/BubblePopupWindow;", "mPopupWindow", "", "Ljava/util/List;", "mList", "<init>", "()V", "ArrowType", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanMenuPopupView {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private BubblePopupWindow mPopupWindow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<ZplanMenuDataItem> mList = new ArrayList();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuPopupView$ArrowType;", "", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes34.dex */
    public @interface ArrowType {
        public static final int ARROW_DOWN = 2;
        public static final int ARROW_UP = 1;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.f373418a;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuPopupView$ArrowType$a;", "", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.widget.menu.ZplanMenuPopupView$ArrowType$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f373418a = new Companion();

            Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/widget/menu/ZplanMenuPopupView$a;", "", "Landroid/view/View;", "view", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(View view);
    }

    private final ZplanMenuLayout d(Context context, a listener) {
        ZplanMenuLayout zplanMenuLayout = new ZplanMenuLayout(context);
        if (listener != null) {
            listener.a(zplanMenuLayout);
        }
        zplanMenuLayout.b(this.mList, new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.widget.menu.ZplanMenuPopupView$createMenuContentLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ZplanMenuPopupView.this.f();
            }
        });
        return zplanMenuLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ZplanMenuPopupView this$0, View archer, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(archer, "$archer");
        BubblePopupWindow bubblePopupWindow = this$0.mPopupWindow;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.showAtLocation(archer, i3, i16, true, 0, u.INSTANCE.c(archer.getContext()));
        }
    }

    public final void b(ZplanMenuDataItem dataItem) {
        Intrinsics.checkNotNullParameter(dataItem, "dataItem");
        this.mList.add(dataItem);
    }

    public final void c() {
        this.mList.clear();
    }

    public final void e() {
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
        }
        this.mList.clear();
        this.mPopupWindow = null;
    }

    public final void f() {
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        if (bubblePopupWindow != null) {
            bubblePopupWindow.dismiss();
        }
    }

    public final boolean g() {
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        if (bubblePopupWindow != null) {
            return bubblePopupWindow.isShowing();
        }
        return false;
    }

    public final void h(final View archer, final int x16, final int y16, int arrowType, boolean touchOutsideToDismiss, a listener) {
        Intrinsics.checkNotNullParameter(archer, "archer");
        if (this.mList.size() == 0) {
            return;
        }
        BubblePopupWindow bubblePopupWindow = this.mPopupWindow;
        if (bubblePopupWindow != null && bubblePopupWindow.isShowing()) {
            bubblePopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        BubblePopupWindow bubblePopupWindow2 = new BubblePopupWindow(-2, -2);
        this.mPopupWindow = bubblePopupWindow2;
        Context context = archer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "archer.context");
        bubblePopupWindow2.setContentView(d(context, listener));
        bubblePopupWindow2.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow2.setOutsideTouchable(touchOutsideToDismiss);
        bubblePopupWindow2.setKeepAbove(arrowType == 1);
        archer.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.widget.menu.d
            @Override // java.lang.Runnable
            public final void run() {
                ZplanMenuPopupView.j(ZplanMenuPopupView.this, archer, x16, y16);
            }
        });
    }

    public final void i(View archer, int x16, int y16, a listener) {
        Intrinsics.checkNotNullParameter(archer, "archer");
        h(archer, x16, y16, 2, true, listener);
    }
}
