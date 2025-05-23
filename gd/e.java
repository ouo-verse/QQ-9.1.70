package gd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.util.am;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.Switch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u001e\u001f !B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u000f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\""}, d2 = {"Lgd/e;", "Lcom/tencent/biz/richframework/part/block/base/BaseListViewAdapter;", "Lhd/b;", "Landroid/view/ViewGroup;", "viewGroup", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "s0", "u0", "v0", "t0", "holder", "", com.tencent.luggage.wxa.c8.c.G, "", "l0", "q0", "m0", "o0", "Lgd/e$c;", "", "isSelected", "w0", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "viewHolder", "onBindViewHolder", "getItemViewType", "<init>", "()V", "a", "b", "c", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends BaseListViewAdapter<hd.b> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lgd/e$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "setMButtonText", "(Landroid/widget/TextView;)V", "mButtonText", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView mButtonText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.mti);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.qzone_debug_button_text)");
            this.mButtonText = (TextView) findViewById;
        }

        /* renamed from: l, reason: from getter */
        public final TextView getMButtonText() {
            return this.mButtonText;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lgd/e$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "setTvName", "(Landroid/widget/TextView;)V", "tvName", "Landroid/widget/EditText;", UserInfo.SEX_FEMALE, "Landroid/widget/EditText;", "l", "()Landroid/widget/EditText;", "setEtInput", "(Landroid/widget/EditText;)V", "etInput", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setTvConfirm", "tvConfirm", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView tvName;

        /* renamed from: F, reason: from kotlin metadata */
        private EditText etInput;

        /* renamed from: G, reason: from kotlin metadata */
        private TextView tvConfirm;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.mtm);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.qzone_debug_input_name)");
            this.tvName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.mtk);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.qzone_debug_input)");
            this.etInput = (EditText) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.mtl);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026zone_debug_input_confirm)");
            this.tvConfirm = (TextView) findViewById3;
        }

        /* renamed from: l, reason: from getter */
        public final EditText getEtInput() {
            return this.etInput;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getTvConfirm() {
            return this.tvConfirm;
        }

        /* renamed from: o, reason: from getter */
        public final TextView getTvName() {
            return this.tvName;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lgd/e$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "setMSwitchText", "(Landroid/widget/TextView;)V", "mSwitchText", "Lcom/tencent/widget/Switch;", UserInfo.SEX_FEMALE, "Lcom/tencent/widget/Switch;", "l", "()Lcom/tencent/widget/Switch;", "setMSwitchIcon", "(Lcom/tencent/widget/Switch;)V", "mSwitchIcon", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView mSwitchText;

        /* renamed from: F, reason: from kotlin metadata */
        private Switch mSwitchIcon;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.mtq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026.qzone_debug_switch_text)");
            this.mSwitchText = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.mtp);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026.qzone_debug_switch_icon)");
            this.mSwitchIcon = (Switch) findViewById2;
        }

        /* renamed from: l, reason: from getter */
        public final Switch getMSwitchIcon() {
            return this.mSwitchIcon;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getMSwitchText() {
            return this.mSwitchText;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lgd/e$d;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "setTvTextName", "(Landroid/widget/TextView;)V", "tvTextName", UserInfo.SEX_FEMALE, "o", "setTvTextValue", "tvTextValue", "G", "l", "setTvTextCopy", "tvTextCopy", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView tvTextName;

        /* renamed from: F, reason: from kotlin metadata */
        private TextView tvTextValue;

        /* renamed from: G, reason: from kotlin metadata */
        private TextView tvTextCopy;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.mts);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.qzone_debug_text_name)");
            this.tvTextName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.mtt);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.qzone_debug_text_value)");
            this.tvTextValue = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.mtr);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.qzone_debug_text_copy)");
            this.tvTextCopy = (TextView) findViewById3;
        }

        /* renamed from: l, reason: from getter */
        public final TextView getTvTextCopy() {
            return this.tvTextCopy;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getTvTextName() {
            return this.tvTextName;
        }

        /* renamed from: o, reason: from getter */
        public final TextView getTvTextValue() {
            return this.tvTextValue;
        }
    }

    private final void l0(RecyclerView.ViewHolder holder, int pos) {
        hd.b bVar = (hd.b) this.mDataList.get(pos);
        if ((holder instanceof a) && (bVar instanceof hd.a)) {
            a aVar = (a) holder;
            aVar.getMButtonText().setText(bVar.getName());
            aVar.getMButtonText().setOnClickListener(((hd.a) bVar).getOnClickListener());
        }
    }

    private final void m0(final RecyclerView.ViewHolder holder, int pos) {
        final hd.b bVar = (hd.b) this.mDataList.get(pos);
        if ((holder instanceof b) && (bVar instanceof hd.c)) {
            b bVar2 = (b) holder;
            bVar2.getTvName().setText(bVar.getName());
            bVar2.getEtInput().setHint(((hd.c) bVar).getHint());
            bVar2.getTvConfirm().setOnClickListener(new View.OnClickListener() { // from class: gd.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.n0(RecyclerView.ViewHolder.this, bVar, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(RecyclerView.ViewHolder viewHolder, hd.b bVar, View view) {
        b bVar2 = (b) viewHolder;
        String obj = bVar2.getEtInput().getText().toString();
        if (obj.length() > 0) {
            bVar2.getEtInput().getEditableText().clear();
            ((hd.c) bVar).getOnConfirmListener().a(obj);
        }
    }

    private final void o0(final RecyclerView.ViewHolder holder, int pos) {
        final hd.b bVar = (hd.b) this.mDataList.get(pos);
        if ((holder instanceof c) && (bVar instanceof hd.d)) {
            c cVar = (c) holder;
            cVar.getMSwitchText().setText(bVar.getName());
            hd.d dVar = (hd.d) bVar;
            w0(cVar, gd.a.f401926a.c(dVar.getConfigKey(), dVar.getDefaultState()));
            if (dVar.getOnCheckedChangeListener() != null) {
                cVar.getMSwitchIcon().setOnCheckedChangeListener(dVar.getOnCheckedChangeListener());
            }
            cVar.getMSwitchIcon().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: gd.c
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    e.p0(hd.b.this, this, holder, compoundButton, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(hd.b bVar, e this$0, RecyclerView.ViewHolder viewHolder, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hd.d dVar = (hd.d) bVar;
        gd.a.f401926a.e(dVar.getConfigKey(), z16);
        this$0.w0((c) viewHolder, z16);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = dVar.getOnCheckedChangeListener();
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z16);
        }
    }

    private final void q0(RecyclerView.ViewHolder holder, int pos) {
        final hd.b bVar = (hd.b) this.mDataList.get(pos);
        if ((holder instanceof d) && (bVar instanceof hd.e)) {
            d dVar = (d) holder;
            dVar.getTvTextName().setText(bVar.getName());
            dVar.getTvTextValue().setText(((hd.e) bVar).getValue());
            dVar.getTvTextCopy().setOnClickListener(new View.OnClickListener() { // from class: gd.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.r0(hd.b.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(hd.b bVar, View view) {
        am.a(((hd.e) bVar).getValue());
    }

    private final RecyclerView.ViewHolder s0(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f129556d, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context).\u2026roup, false\n            )");
        return new a(inflate);
    }

    private final RecyclerView.ViewHolder t0(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f129566e, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context).\u2026roup, false\n            )");
        return new b(inflate);
    }

    private final RecyclerView.ViewHolder u0(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f129576f, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context).\u2026roup, false\n            )");
        return new c(inflate);
    }

    private final RecyclerView.ViewHolder v0(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f129586g, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context).\u2026roup, false\n            )");
        return new d(inflate);
    }

    private final void w0(c holder, boolean isSelected) {
        Context context = holder.getMSwitchText().getContext();
        if (isSelected) {
            holder.getMSwitchText().setTextColor(context.getColor(R.color.qui_common_brand_standard));
            holder.getMSwitchText().setSelected(true);
            holder.getMSwitchIcon().setChecked(true);
        } else {
            holder.getMSwitchText().setTextColor(context.getColor(R.color.qui_common_text_secondary));
            holder.getMSwitchText().setSelected(false);
            holder.getMSwitchIcon().setChecked(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int pos) {
        return ((hd.b) this.mDataList.get(pos)).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int pos) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int itemViewType = getItemViewType(pos);
        if (itemViewType == 1) {
            l0(viewHolder, pos);
            return;
        }
        if (itemViewType == 2) {
            o0(viewHolder, pos);
        } else if (itemViewType == 3) {
            q0(viewHolder, pos);
        } else {
            if (itemViewType != 4) {
                return;
            }
            m0(viewHolder, pos);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return s0(parent);
        }
        if (viewType == 2) {
            return u0(parent);
        }
        if (viewType == 3) {
            return v0(parent);
        }
        if (viewType != 4) {
            return s0(parent);
        }
        return t0(parent);
    }
}
