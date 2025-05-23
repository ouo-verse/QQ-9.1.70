package com.qzone.reborn.albumx.qzonex.utils;

import aa.c;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/f;", "Laa/c;", "", com.tencent.luggage.wxa.c8.c.G, "", "y", HippyTKDListViewAdapter.X, "", "u", "f", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "curPos", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "e", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f extends aa.c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/albumx/qzonex/utils/f$a", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends GridLayoutManager.SpanSizeLookup {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            return (f.this.j(position) || f.this.l(position) || f.this.y(position) || f.this.i(position)) ? 3 : 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/qzone/reborn/albumx/qzonex/utils/f$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int x16;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (!f.this.y(childAdapterPosition) && (x16 = childAdapterPosition - f.this.x()) < f.this.c().getNUM_BACKGOURND_ICON()) {
                if (f.this.j(childAdapterPosition)) {
                    outRect.set(f.this.getHeadMarginLeftRight(), 0, f.this.getHeadMarginLeftRight(), ef.d.b(12));
                    return;
                }
                if (f.this.i(childAdapterPosition)) {
                    outRect.set(f.this.getHeadMarginLeftRight(), ef.d.b(20), f.this.getHeadMarginLeftRight(), -ef.d.b(16));
                    return;
                }
                if (f.this.m(childAdapterPosition)) {
                    CommonGridItemData commonGridItemData = f.this.c().getItems().get(x16);
                    int mediaPos = commonGridItemData.getMediaPos();
                    outRect.top = 0;
                    c.Companion companion = aa.c.INSTANCE;
                    int a16 = (int) (companion.a() / 2);
                    int i3 = mediaPos % 3;
                    if (i3 == 0) {
                        outRect.left = 0;
                        outRect.right = a16;
                    } else if (i3 == 1) {
                        outRect.left = a16;
                        outRect.right = a16;
                    } else {
                        outRect.left = a16;
                        outRect.right = 0;
                    }
                    int size = commonGridItemData.getBatchBean().getBatchInfo().j().size();
                    int i16 = size % 3;
                    if (i16 == 0) {
                        i16 = 3;
                    }
                    int i17 = size - i16;
                    if (mediaPos < i17) {
                        outRect.bottom = companion.a();
                    } else if (mediaPos >= i17) {
                        outRect.bottom = ef.d.b(4);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int x() {
        if (d().getAdapters().size() <= 2) {
            return 0;
        }
        int size = d().getAdapters().size();
        int i3 = 0;
        for (int i16 = 0; i16 < size && !(d().getAdapters().get(i16) instanceof i9.a); i16++) {
            i3 += d().getAdapters().get(i16).getNUM_BACKGOURND_ICON();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y(int pos) {
        return d().getAdapters().size() > 2 && pos < d().getAdapters().get(0).getNUM_BACKGOURND_ICON();
    }

    @Override // aa.c
    public void b() {
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(h().getContext(), 3);
        safeGridLayoutManager.setSpanSizeLookup(new a());
        h().setLayoutManager(safeGridLayoutManager);
    }

    @Override // aa.c
    public CommonGridItemData e(int curPos) {
        if (c().getItems().size() == 0) {
            return null;
        }
        if (curPos > x()) {
            curPos -= x();
        }
        while (-1 < curPos) {
            if (c().getItems().get(curPos).getItemType() == CommonGridItemData.ItemType.HEAD_SECTION_ITEM) {
                return c().getItems().get(curPos);
            }
            curPos--;
        }
        return null;
    }

    @Override // aa.c
    public int f() {
        return x();
    }

    @Override // aa.c
    public boolean i(int pos) {
        int x16 = pos - x();
        return x16 < c().getNUM_BACKGOURND_ICON() && x16 >= 0 && c().getItems().get(x16).getItemType() == CommonGridItemData.ItemType.BANNER_SECTION_ITEM;
    }

    @Override // aa.c
    public boolean j(int pos) {
        int x16 = pos - x();
        return x16 < c().getNUM_BACKGOURND_ICON() && x16 >= 0 && c().getItems().get(x16).getItemType() == CommonGridItemData.ItemType.HEAD_SECTION_ITEM;
    }

    @Override // aa.c
    public boolean m(int pos) {
        int x16 = pos - x();
        return x16 < c().getNUM_BACKGOURND_ICON() && x16 >= 0 && c().getItems().get(x16).getItemType() == CommonGridItemData.ItemType.PIC_SECTION_ITEM;
    }

    @Override // aa.c
    public void u() {
        if (getIsItemDecorationSetup()) {
            return;
        }
        r(true);
        h().addItemDecoration(new b());
    }
}
