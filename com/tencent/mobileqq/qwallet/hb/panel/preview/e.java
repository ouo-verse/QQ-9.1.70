package com.tencent.mobileqq.qwallet.hb.panel.preview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\n\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000eH\u0016R\u0016\u0010\u001c\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R$\u0010'\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/preview/e;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "Lcom/tencent/mobileqq/qwallet/hb/panel/preview/h;", "", "u0", "", "list", "Lkotlin/Function0;", "callback", "m0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "", "dataIndex", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "t0", "holder", "position", "s0", "getItemCount", "p0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "curPagePosition", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "r0", "()Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "pageChangeCallback", "<set-?>", "D", "q0", "()I", "listSize", "E", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "()V", UserInfo.SEX_FEMALE, "c", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class e extends ListAdapter<RedPackSkin$RecommendSkin, h> {

    @NotNull
    private static final b G = new b();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ViewPager2.OnPageChangeCallback pageChangeCallback;

    /* renamed from: D, reason: from kotlin metadata */
    private int listSize;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int curPagePosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/preview/e$a", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "positionStart", "itemCount", "", "payload", "", "onItemRangeChanged", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
            Boolean bool;
            super.onItemRangeChanged(positionStart, itemCount, payload);
            QLog.d("SkinPreviewPagerAdapter", 1, "onItemRangeChanged: " + positionStart + ", " + itemCount + ", " + payload);
            if (payload instanceof Boolean) {
                bool = (Boolean) payload;
            } else {
                bool = null;
            }
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                e.this.u0();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/preview/e$b", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", "oldItem", "newItem", "", "b", "a", "c", "(Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;)Ljava/lang/Boolean;", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends DiffUtil.ItemCallback<RedPackSkin$RecommendSkin> {
        b() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull RedPackSkin$RecommendSkin oldItem, @NotNull RedPackSkin$RecommendSkin newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return RedPackSkinExt.j(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull RedPackSkin$RecommendSkin oldItem, @NotNull RedPackSkin$RecommendSkin newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return RedPackSkinExt.i(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @NotNull
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean getChangePayload(@NotNull RedPackSkin$RecommendSkin oldItem, @NotNull RedPackSkin$RecommendSkin newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Boolean.TRUE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/panel/preview/e$d", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            e.this.curPagePosition = position;
            e.this.u0();
        }
    }

    public e() {
        super(G);
        registerAdapterDataObserver(new a());
        this.curPagePosition = -1;
        this.pageChangeCallback = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u0() {
        int coerceAtMost;
        final int coerceAtLeast;
        int coerceAtMost2;
        final int coerceAtLeast2;
        int i3 = this.curPagePosition;
        if (i3 != -1) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 - 1, getNUM_BACKGOURND_ICON());
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtMost, 0);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost((getNUM_BACKGOURND_ICON() - coerceAtLeast) + 1, 3);
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(coerceAtMost2, 1);
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.v0(e.this, coerceAtLeast, coerceAtLeast2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(e this$0, int i3, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.notifyItemRangeChanged(i3, i16);
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        int i3 = this.listSize;
        if (i3 >= 3) {
            return Integer.MAX_VALUE;
        }
        return i3;
    }

    public final void m0(@NotNull List<RedPackSkin$RecommendSkin> list, @NotNull final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.listSize = list.size();
        submitList(list, new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.d
            @Override // java.lang.Runnable
            public final void run() {
                e.n0(Function0.this);
            }
        });
    }

    public final int o0(int dataIndex) {
        int i3 = this.listSize;
        if (i3 >= 3) {
            dataIndex += i3 * (LockFreeTaskQueueCore.MAX_CAPACITY_MASK / i3);
        }
        QLog.d("SkinPreviewPagerAdapter", 1, "calculateInitPosition: iniPagePos " + dataIndex);
        return dataIndex;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.setClipChildren(false);
        this.recyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    @NotNull
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public RedPackSkin$RecommendSkin getItem(int position) {
        Object item = super.getItem(position % this.listSize);
        Intrinsics.checkNotNullExpressionValue(item, "super.getItem(listPos)");
        return (RedPackSkin$RecommendSkin) item;
    }

    /* renamed from: q0, reason: from getter */
    public final int getListSize() {
        return this.listSize;
    }

    @NotNull
    /* renamed from: r0, reason: from getter */
    public final ViewPager2.OnPageChangeCallback getPageChangeCallback() {
        return this.pageChangeCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull h holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l(getItem(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public h onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hk7, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new h(view);
    }
}
