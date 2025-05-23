package com.tencent.mobileqq.guild.quicksearch.resultview.feed;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.quicksearch.model.QuickSearchSortType;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00032\u00020\u0001:\u0001\fB9\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u0017\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R#\u0010,\u001a\n (*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/SortOptionPopupWindow;", "", "Landroid/widget/PopupWindow;", "i", "", "l", "Landroid/view/View;", "anchor", "initialSelected", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "", "Lcom/tencent/mobileqq/guild/quicksearch/model/QuickSearchSortType;", "b", "Ljava/util/List;", "items", "c", "I", "initSelectedRankType", "Lkotlin/Function1;", "d", "Lkotlin/jvm/functions/Function1;", "itemClickListener", "e", "Landroid/widget/PopupWindow;", "popupWindow", "Landroid/widget/ListView;", "f", "Landroid/widget/ListView;", "listView", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/b;", "g", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/guild/quicksearch/resultview/feed/b;", "arrayAdapter", "kotlin.jvm.PlatformType", tl.h.F, "k", "()Landroid/view/View;", "popupView", "<init>", "(Landroid/content/Context;Ljava/util/List;ILkotlin/jvm/functions/Function1;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SortOptionPopupWindow {

    /* renamed from: j, reason: collision with root package name */
    private static final int f231776j = (int) cw.c(8.0f);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QuickSearchSortType> items;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int initSelectedRankType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<QuickSearchSortType, Unit> itemClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ListView listView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy arrayAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy popupView;

    /* JADX WARN: Multi-variable type inference failed */
    public SortOptionPopupWindow(@NotNull Context context, @NotNull List<? extends QuickSearchSortType> items, int i3, @NotNull Function1<? super QuickSearchSortType, Unit> itemClickListener) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.context = context;
        this.items = items;
        this.initSelectedRankType = i3;
        this.itemClickListener = itemClickListener;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.SortOptionPopupWindow$arrayAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final b invoke() {
                Context context2;
                List list;
                int i16;
                context2 = SortOptionPopupWindow.this.context;
                list = SortOptionPopupWindow.this.items;
                Object[] array = list.toArray(new QuickSearchSortType[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                QuickSearchSortType[] quickSearchSortTypeArr = (QuickSearchSortType[]) array;
                i16 = SortOptionPopupWindow.this.initSelectedRankType;
                final SortOptionPopupWindow sortOptionPopupWindow = SortOptionPopupWindow.this;
                return new b(context2, R.layout.f3k, quickSearchSortTypeArr, i16, new Function1<QuickSearchSortType, Unit>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.feed.SortOptionPopupWindow$arrayAdapter$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(QuickSearchSortType quickSearchSortType) {
                        invoke2(quickSearchSortType);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull QuickSearchSortType item) {
                        Function1 function1;
                        PopupWindow popupWindow;
                        Intrinsics.checkNotNullParameter(item, "item");
                        function1 = SortOptionPopupWindow.this.itemClickListener;
                        function1.invoke(item);
                        popupWindow = SortOptionPopupWindow.this.popupWindow;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        }
                    }
                });
            }
        });
        this.arrayAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new SortOptionPopupWindow$popupView$2(this));
        this.popupView = lazy2;
    }

    private final PopupWindow i() {
        return new PopupWindow(k(), -2, -2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b j() {
        return (b) this.arrayAdapter.getValue();
    }

    private final View k() {
        return (View) this.popupView.getValue();
    }

    private final int l() {
        int paddingTop = k().getPaddingTop();
        ListView listView = this.listView;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listView");
            listView = null;
        }
        return -(paddingTop + listView.getPaddingTop());
    }

    public final void m(@NotNull View anchor, int initialSelected) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (this.popupWindow == null) {
            this.popupWindow = i();
        }
        j().c(initialSelected);
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            if (!popupWindow.isShowing()) {
                popupWindow.showAsDropDown(anchor, 0, l());
            } else {
                popupWindow.update(anchor, 0, l(), popupWindow.getWidth(), popupWindow.getHeight());
            }
        }
    }
}
