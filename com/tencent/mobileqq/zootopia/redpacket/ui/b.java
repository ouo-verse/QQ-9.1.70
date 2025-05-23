package com.tencent.mobileqq.zootopia.redpacket.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.falco.utils.UIUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003123B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00030!j\b\u0012\u0004\u0012\u00020\u0003`\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/ui/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/b$a;", "Lhd3/a;", "data", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/b$c;", "holder", "", "k0", "j0", "l0", "", "datas", "setData", "r0", "", "position", "getItemViewType", "Lcom/tencent/mobileqq/zootopia/redpacket/a;", "itemListener", "p0", "Lhd3/c;", "style", "q0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "m0", "getItemCount", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "dataList", BdhLogUtil.LogTag.Tag_Conn, "Lhd3/c;", "D", "Lcom/tencent/mobileqq/zootopia/redpacket/a;", "Lid3/d;", "E", "Lid3/d;", "reporter", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.zootopia.redpacket.a itemListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<hd3.a> dataList = new ArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    private hd3.c style = new hd3.c();

    /* renamed from: E, reason: from kotlin metadata */
    private final id3.d reporter = new id3.d(null, 1, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/ui/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0006\u00a2\u0006\u0004\b#\u0010$J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\nR\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/ui/b$c;", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/b$a;", "", "color", "", "r", "Landroid/view/View;", "E", "Landroid/view/View;", "o", "()Landroid/view/View;", "content", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "Landroid/widget/ImageView;", "p", "()Landroid/widget/ImageView;", "displayView", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "chooseBox", "H", "l", "checkedView", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/TextView;", "nameView", "", "J", "Z", "isLoadChooseBox", "itemView", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends a {

        /* renamed from: E, reason: from kotlin metadata */
        private final View content;

        /* renamed from: F, reason: from kotlin metadata */
        private final ImageView displayView;

        /* renamed from: G, reason: from kotlin metadata */
        private final ImageView chooseBox;

        /* renamed from: H, reason: from kotlin metadata */
        private final View checkedView;

        /* renamed from: I, reason: from kotlin metadata */
        private final TextView nameView;

        /* renamed from: J, reason: from kotlin metadata */
        private boolean isLoadChooseBox;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.f163344pm3);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.content)");
            this.content = findViewById;
            View findViewById2 = itemView.findViewById(R.id.qgs);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.redPacket)");
            this.displayView = (ImageView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.pjl);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.chooseBox)");
            this.chooseBox = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.pjf);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.checked)");
            this.checkedView = findViewById4;
            View findViewById5 = itemView.findViewById(R.id.qgu);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.redPacketName)");
            this.nameView = (TextView) findViewById5;
        }

        /* renamed from: l, reason: from getter */
        public final View getCheckedView() {
            return this.checkedView;
        }

        /* renamed from: m, reason: from getter */
        public final ImageView getChooseBox() {
            return this.chooseBox;
        }

        /* renamed from: o, reason: from getter */
        public final View getContent() {
            return this.content;
        }

        /* renamed from: p, reason: from getter */
        public final ImageView getDisplayView() {
            return this.displayView;
        }

        /* renamed from: q, reason: from getter */
        public final TextView getNameView() {
            return this.nameView;
        }

        public final void r(String color) {
            Intrinsics.checkNotNullParameter(color, "color");
            if (this.isLoadChooseBox) {
                return;
            }
            this.isLoadChooseBox = true;
            com.tencent.mobileqq.zootopia.redpacket.j.f329071a.f(this.chooseBox, R.drawable.f159789i84, color);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zootopia/redpacket/ui/b$d", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecyclerView.LayoutManager f329106b;

        d(RecyclerView.LayoutManager layoutManager) {
            this.f329106b = layoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            if (b.this.getItemViewType(position) == 1) {
                return ((GridLayoutManager) this.f329106b).getSpanCount();
            }
            return 1;
        }
    }

    private final void j0(hd3.a data, c holder) {
        if (data.getIsChecked()) {
            holder.r(this.style.getChooseBoxColor());
            holder.getChooseBox().setVisibility(0);
            holder.getCheckedView().setVisibility(0);
        } else {
            holder.getChooseBox().setVisibility(4);
            holder.getCheckedView().setVisibility(4);
        }
    }

    private final void k0(hd3.a data, c holder) {
        com.tencent.mobileqq.zootopia.redpacket.j.f329071a.e(holder.getDisplayView(), com.tencent.mobileqq.zootopia.redpacket.i.f329070a.g(data.getId()), Integer.valueOf(UIUtil.dp2px(holder.getDisplayView().getContext(), 108.0f)), Integer.valueOf(UIUtil.dp2px(holder.getDisplayView().getContext(), 162.0f)));
    }

    private final void l0(hd3.a data, c holder) {
        holder.getNameView().setText(data.getTitle());
        com.tencent.mobileqq.zootopia.redpacket.j.f329071a.g(holder.getNameView(), this.style.getTitleColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(b this$0, hd3.a data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        com.tencent.mobileqq.zootopia.redpacket.a aVar = this$0.itemListener;
        if (aVar != null) {
            aVar.a(data);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
        hd3.a aVar = (hd3.a) orNull;
        return (aVar == null || !aVar.getIsFooter()) ? 0 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Object orNull;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (getItemViewType(position) != 1 && (holder instanceof c)) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.dataList, position);
            final hd3.a aVar = (hd3.a) orNull;
            if (aVar == null) {
                return;
            }
            c cVar = (c) holder;
            k0(aVar, cVar);
            j0(aVar, cVar);
            l0(aVar, cVar);
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.n0(b.this, aVar, view);
                }
            });
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_hongbao_cover_id", Integer.valueOf(aVar.getId())));
            id3.d dVar = this.reporter;
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            id3.d.i(dVar, view, "em_zplan_hongbao_cover_choosed", mutableMapOf, true, true, null, false, false, 224, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.d37, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            c cVar = new c(view);
            aw.r(cVar.getCheckedView());
            aw.r(cVar.getContent());
            aw.r(cVar.getDisplayView());
            aw.r(cVar.getChooseBox());
            aw.r(cVar.getNameView());
            return cVar;
        }
        int dp2px = UIUtil.dp2px(parent.getContext(), 60.0f);
        View view2 = new View(parent.getContext());
        view2.setLayoutParams(new ViewGroup.LayoutParams(-1, dp2px));
        return new a(view2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new d(layoutManager));
        }
    }

    public final void p0(com.tencent.mobileqq.zootopia.redpacket.a itemListener) {
        Intrinsics.checkNotNullParameter(itemListener, "itemListener");
        this.itemListener = itemListener;
    }

    public final void q0(hd3.c style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.style = style;
    }

    public final void r0(hd3.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int indexOf = this.dataList.indexOf(data);
        if (indexOf >= 0) {
            notifyItemChanged(indexOf);
        }
    }

    public final void setData(List<hd3.a> datas) {
        Intrinsics.checkNotNullParameter(datas, "datas");
        this.dataList.clear();
        this.dataList.addAll(datas);
        ArrayList<hd3.a> arrayList = this.dataList;
        hd3.a aVar = new hd3.a();
        aVar.l(true);
        arrayList.add(aVar);
        notifyDataSetChanged();
    }
}
