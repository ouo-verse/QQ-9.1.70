package com.tencent.mobileqq.zplan.card.impl.view.stagger.view;

import android.content.Context;
import android.graphics.Rect;
import android.widget.LinearLayout;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import zf3.StaggerLabelItemData;
import zf3.a;
import zf3.b;
import zf3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u00012\u00020\u0002:\u0001\u001cB\u000f\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u001c\u0010\u0015\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJ\u000e\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019J \u0010\u001c\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u001d\u001a\u00020\u0003J\u0016\u0010\u001f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0003R$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00050 j\b\u0012\u0004\u0012\u00020\u0005`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\"R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010$R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\t0 j\b\u0012\u0004\u0012\u00020\t`!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\"R\u0018\u0010(\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerItemLabelContainer;", "Landroid/widget/LinearLayout;", "Lzf3/b;", "", c.G, "Lzf3/f;", "itemData", "Lyf3/a;", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/mobileqq/zplan/card/impl/view/stagger/view/StaggerLabelItemView;", "d", "", "newData", "", "c", "data", "", "g", h.F, "selectedView", "b", "f", "Lzf3/a;", "observer", "setObserver", "Lzf3/c;", "scroller", "setScroller", "a", "e", "selectedPos", "setSelectedItem", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mData", "I", "mSelectedItem", "mItemViews", "Lzf3/a;", "mObserver", "i", "Lzf3/c;", "mScroller", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class StaggerItemLabelContainer extends LinearLayout implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<StaggerLabelItemData> mData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mSelectedItem;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<StaggerLabelItemView> mItemViews;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private a mObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private zf3.c mScroller;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StaggerItemLabelContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = new ArrayList<>();
        this.mItemViews = new ArrayList<>();
        setOrientation(0);
    }

    private final void b(StaggerLabelItemView selectedView) {
        zf3.c cVar;
        int k3 = d.f452428a.k();
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        int[] iArr = new int[2];
        selectedView.getLocationInWindow(iArr);
        int i3 = 0;
        int i16 = iArr[0];
        int width = selectedView.getWidth() + i16;
        QLog.i("StaggerItemLabelContainer_", 1, "autoScrollCheck selfRect:" + rect + ", itemPos.x:" + iArr[0] + ", itemWidth:" + selectedView.getWidth());
        int i17 = rect.left;
        if (i16 < i17) {
            i3 = (i17 - i16) * (-1);
        } else {
            int i18 = rect.right;
            if (width > i18 - k3) {
                i3 = width - (i18 - k3);
            }
        }
        if (i3 == 0 || (cVar = this.mScroller) == null) {
            return;
        }
        cVar.h(i3);
    }

    private final boolean c(List<StaggerLabelItemData> newData) {
        if (this.mData.size() != newData.size()) {
            return true;
        }
        int size = this.mData.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(this.mData.get(i3), newData.get(i3))) {
                return true;
            }
        }
        return false;
    }

    private final StaggerLabelItemView d(int pos, StaggerLabelItemData itemData, yf3.a card) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        StaggerLabelItemView staggerLabelItemView = new StaggerLabelItemView(context);
        staggerLabelItemView.b(pos, pos == this.mSelectedItem, itemData, this, card);
        d dVar = d.f452428a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, dVar.s());
        if (pos != 0) {
            layoutParams.leftMargin = i.b(5);
        }
        if (pos == this.mData.size() - 1) {
            layoutParams.rightMargin = i.b(5) + dVar.k();
        }
        addView(staggerLabelItemView, layoutParams);
        return staggerLabelItemView;
    }

    private final void g(yf3.a card, int pos, StaggerLabelItemData data) {
        this.mSelectedItem = pos;
        h(card);
        a aVar = this.mObserver;
        if (aVar != null) {
            aVar.g(this.mSelectedItem, data.a());
        }
    }

    private final void h(yf3.a card) {
        if (this.mData.size() != this.mItemViews.size()) {
            QLog.e("StaggerItemLabelContainer_", 1, "updateItemViews data no match!");
            return;
        }
        Iterator<StaggerLabelItemData> it = this.mData.iterator();
        StaggerLabelItemView staggerLabelItemView = null;
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            StaggerLabelItemData next = it.next();
            boolean z16 = this.mSelectedItem == i3;
            this.mItemViews.get(i3).b(i3, z16, next, this, card);
            if (z16) {
                staggerLabelItemView = this.mItemViews.get(i3);
            }
            i3 = i16;
        }
        if (staggerLabelItemView != null) {
            b(staggerLabelItemView);
        }
    }

    @Override // zf3.b
    public void a(yf3.a card, int pos, StaggerLabelItemData data) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(data, "data");
        g(card, pos, data);
    }

    /* renamed from: e, reason: from getter */
    public final int getMSelectedItem() {
        return this.mSelectedItem;
    }

    public final void f(yf3.a card, List<StaggerLabelItemData> data) {
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(data, "data");
        if (!c(data)) {
            QLog.i("StaggerItemLabelContainer_", 1, "refreshData data same!");
            return;
        }
        this.mData.clear();
        this.mData.addAll(data);
        int i3 = 0;
        this.mSelectedItem = 0;
        this.mItemViews.clear();
        removeAllViews();
        Iterator<StaggerLabelItemData> it = this.mData.iterator();
        while (it.hasNext()) {
            this.mItemViews.add(d(i3, it.next(), card));
            i3++;
        }
    }

    public final void setObserver(a observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mObserver = observer;
    }

    public final void setScroller(zf3.c scroller) {
        Intrinsics.checkNotNullParameter(scroller, "scroller");
        this.mScroller = scroller;
    }

    public final void setSelectedItem(yf3.a card, int selectedPos) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (selectedPos < 0 || selectedPos >= this.mData.size()) {
            return;
        }
        StaggerLabelItemData staggerLabelItemData = this.mData.get(selectedPos);
        Intrinsics.checkNotNullExpressionValue(staggerLabelItemData, "mData[selectedPos]");
        g(card, selectedPos, staggerLabelItemData);
    }
}
