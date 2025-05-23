package com.tencent.mobileqq.widget.gridpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B\u001b\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/widget/gridpage/QQGridIndicatorView;", "Landroid/widget/LinearLayout;", "", "count", "", "a", "setPageCount", "index", "setSelectedPage", "d", "I", "selectedIndex", "", "Landroid/view/View;", "e", "Ljava/util/List;", "indicatorViews", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQGridIndicatorView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int selectedIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends View> indicatorViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGridIndicatorView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        List<? extends View> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.indicatorViews = emptyList;
    }

    private final void a(int count) {
        int i3;
        ArrayList arrayList = new ArrayList();
        int c16 = x.c(getContext(), 6.0f);
        int c17 = x.c(getContext(), 6.0f);
        int c18 = x.c(getContext(), 8.0f);
        for (int i16 = 0; i16 < count; i16++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c16, c17);
            if (i16 != count - 1) {
                i3 = c18;
            } else {
                i3 = 0;
            }
            layoutParams.rightMargin = i3;
            View view = new View(getContext());
            view.setBackgroundResource(R.drawable.m1b);
            view.setLayoutParams(layoutParams);
            addView(view);
            arrayList.add(view);
        }
        this.indicatorViews = arrayList;
        setSelectedPage(0);
    }

    public final void setPageCount(int count) {
        int i3;
        removeAllViews();
        a(count);
        if (count > 1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
    }

    public final void setSelectedPage(int index) {
        if (index < this.indicatorViews.size() && this.selectedIndex < this.indicatorViews.size()) {
            this.indicatorViews.get(this.selectedIndex).setBackgroundResource(R.drawable.m1b);
            this.indicatorViews.get(index).setBackgroundResource(R.drawable.m1a);
            this.selectedIndex = index;
            return;
        }
        QLog.e("QQViewPagerGridPage", 1, "set select page index invalid");
    }
}
