package aa;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.block.aa;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b+\b\u0016\u0018\u0000 52\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b:\u0010;J,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tJ\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000eJ\b\u0010\u0016\u001a\u00020\u000bH\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\"\u0010\u001f\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00109\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Laa/c;", "", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/qzone/reborn/base/h;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "batchListAdapter", "Lcom/qzone/reborn/feedx/block/aa;", "loadMoreAdapter", "", "p", "u", "", "f", com.tencent.luggage.wxa.c8.c.G, "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "l", "b", "curPos", "e", "a", "Z", "k", "()Z", "r", "(Z)V", "isItemDecorationSetup", "Lcom/qzone/reborn/base/h;", "c", "()Lcom/qzone/reborn/base/h;", DomainData.DOMAIN_NAME, "(Lcom/qzone/reborn/base/h;)V", "Landroidx/recyclerview/widget/RecyclerView;", h.F, "()Landroidx/recyclerview/widget/RecyclerView;", "t", "(Landroidx/recyclerview/widget/RecyclerView;)V", "d", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "()Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "o", "(Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;)V", "Lcom/qzone/reborn/feedx/block/aa;", "getLoadMoreAdapter", "()Lcom/qzone/reborn/feedx/block/aa;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/qzone/reborn/feedx/block/aa;)V", "I", "g", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "headMarginLeftRight", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public class c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static int f25742h = ef.d.b(16);

    /* renamed from: i, reason: collision with root package name */
    private static int f25743i = ef.d.b(3);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isItemDecorationSetup;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public com.qzone.reborn.base.h<CommonGridItemData> batchListAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public RecyclerView recyclerView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public RFWConcatAdapter concatAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public aa loadMoreAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int headMarginLeftRight = ef.d.b(0);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Laa/c$a;", "", "", "MEDIA_ITEM_SPACE", "I", "a", "()I", "setMEDIA_ITEM_SPACE", "(I)V", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aa.c$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return c.f25743i;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"aa/c$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {
        b() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> wrappedAdapterAndPosition = c.this.d().getWrappedAdapterAndPosition(position);
            Intrinsics.checkNotNullExpressionValue(wrappedAdapterAndPosition, "concatAdapter.getWrapped\u2026pterAndPosition(position)");
            if (!(wrappedAdapterAndPosition.first instanceof com.qzone.reborn.base.h)) {
                return 3;
            }
            Integer realPosition = (Integer) wrappedAdapterAndPosition.second;
            c cVar = c.this;
            Intrinsics.checkNotNullExpressionValue(realPosition, "realPosition");
            return (cVar.j(realPosition.intValue()) || c.this.l(realPosition.intValue()) || c.this.i(realPosition.intValue())) ? 3 : 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"aa/c$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: aa.c$c, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0023c extends RecyclerView.ItemDecoration {
        C0023c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> wrappedAdapterAndPosition = c.this.d().getWrappedAdapterAndPosition(parent.getChildAdapterPosition(view));
            Intrinsics.checkNotNullExpressionValue(wrappedAdapterAndPosition, "concatAdapter.getWrapped\u2026dPosition(globalPosition)");
            Integer currentPos = (Integer) wrappedAdapterAndPosition.second;
            if (wrappedAdapterAndPosition.first instanceof com.qzone.reborn.base.h) {
                Intrinsics.checkNotNullExpressionValue(currentPos, "currentPos");
                if (currentPos.intValue() >= c.this.c().getNUM_BACKGOURND_ICON()) {
                    return;
                }
                if (!c.this.j(currentPos.intValue()) && !c.this.i(currentPos.intValue())) {
                    if (c.this.m(currentPos.intValue())) {
                        CommonGridItemData commonGridItemData = c.this.c().getItems().get(currentPos.intValue());
                        int mediaPos = commonGridItemData.getMediaPos();
                        outRect.top = 0;
                        Companion companion = c.INSTANCE;
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
                            return;
                        } else {
                            if (mediaPos >= i17) {
                                outRect.bottom = ef.d.b(4);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                outRect.set(c.this.getHeadMarginLeftRight(), 0, c.this.getHeadMarginLeftRight(), ef.d.b(12));
            }
        }
    }

    public void b() {
        SafeGridLayoutManager safeGridLayoutManager = new SafeGridLayoutManager(h().getContext(), 3);
        safeGridLayoutManager.setSpanSizeLookup(new b());
        h().setLayoutManager(safeGridLayoutManager);
    }

    public final com.qzone.reborn.base.h<CommonGridItemData> c() {
        com.qzone.reborn.base.h<CommonGridItemData> hVar = this.batchListAdapter;
        if (hVar != null) {
            return hVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("batchListAdapter");
        return null;
    }

    public final RFWConcatAdapter d() {
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter != null) {
            return rFWConcatAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
        return null;
    }

    public CommonGridItemData e(int curPos) {
        if (c().getItems().size() == 0) {
            return null;
        }
        while (-1 < curPos) {
            if (c().getItems().get(curPos).getItemType() == CommonGridItemData.ItemType.HEAD_SECTION_ITEM) {
                return c().getItems().get(curPos);
            }
            curPos--;
        }
        return null;
    }

    public int f() {
        return 0;
    }

    /* renamed from: g, reason: from getter */
    public final int getHeadMarginLeftRight() {
        return this.headMarginLeftRight;
    }

    public final RecyclerView h() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    public boolean i(int pos) {
        return pos < c().getNUM_BACKGOURND_ICON() && c().getItems().get(pos).getItemType() == CommonGridItemData.ItemType.BANNER_SECTION_ITEM;
    }

    public boolean j(int pos) {
        return pos < c().getNUM_BACKGOURND_ICON() && c().getItems().get(pos).getItemType() == CommonGridItemData.ItemType.HEAD_SECTION_ITEM;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsItemDecorationSetup() {
        return this.isItemDecorationSetup;
    }

    public final boolean l(int pos) {
        return pos == d().getNUM_BACKGOURND_ICON() - 1;
    }

    public boolean m(int pos) {
        return pos < c().getNUM_BACKGOURND_ICON() && c().getItems().get(pos).getItemType() == CommonGridItemData.ItemType.PIC_SECTION_ITEM;
    }

    public final void n(com.qzone.reborn.base.h<CommonGridItemData> hVar) {
        Intrinsics.checkNotNullParameter(hVar, "<set-?>");
        this.batchListAdapter = hVar;
    }

    public final void o(RFWConcatAdapter rFWConcatAdapter) {
        Intrinsics.checkNotNullParameter(rFWConcatAdapter, "<set-?>");
        this.concatAdapter = rFWConcatAdapter;
    }

    public final void p(RecyclerView recyclerView, RFWConcatAdapter concatAdapter, com.qzone.reborn.base.h<CommonGridItemData> batchListAdapter, aa loadMoreAdapter) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(concatAdapter, "concatAdapter");
        Intrinsics.checkNotNullParameter(batchListAdapter, "batchListAdapter");
        Intrinsics.checkNotNullParameter(loadMoreAdapter, "loadMoreAdapter");
        t(recyclerView);
        o(concatAdapter);
        n(batchListAdapter);
        s(loadMoreAdapter);
        int m3 = g.f53821a.d().m();
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycledViewPool.setMaxRecycledViews(1, m3);
        recyclerView.setRecycledViewPool(recycledViewPool);
        loadMoreAdapter.setLoadMoreStrategy(new a());
        b();
    }

    public final void q(int i3) {
        this.headMarginLeftRight = i3;
    }

    public final void r(boolean z16) {
        this.isItemDecorationSetup = z16;
    }

    public final void s(aa aaVar) {
        Intrinsics.checkNotNullParameter(aaVar, "<set-?>");
        this.loadMoreAdapter = aaVar;
    }

    public final void t(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.recyclerView = recyclerView;
    }

    public void u() {
        if (this.isItemDecorationSetup) {
            return;
        }
        this.isItemDecorationSetup = true;
        h().addItemDecoration(new C0023c());
    }
}
