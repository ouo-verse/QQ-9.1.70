package hj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hj.b;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0005H\u0016R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lhj/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lhj/b$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "", "show", "", "k0", "holder", "position", "i0", "getItemCount", "", "getItemId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "showManual", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean showManual;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.showManual ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.n(this.showManual);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cjt, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026      false\n            )");
        a aVar = new a(inflate);
        aVar.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        aVar.itemView.setVisibility(8);
        return aVar;
    }

    public final void k0(boolean show) {
        this.showManual = show;
        notifyDataSetChanged();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lhj/b$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "show", "", DomainData.DOMAIN_NAME, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "tvManualText", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView tvManualText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(final View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.nj9);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_manual_text)");
            TextView textView = (TextView) findViewById;
            this.tvManualText = textView;
            textView.setOnClickListener(new View.OnClickListener() { // from class: hj.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.a.m(itemView, view);
                }
            });
            fo.c.n(this.tvManualText, "em_bas_learn_more_about_text_chains");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(View itemView, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(itemView, "$itemView");
            if (!com.qzone.reborn.util.e.b("QZIntimateManageBottomManualAdapterHalfScreen", 500L)) {
                i.q(itemView.getContext(), com.qzone.reborn.configx.g.f53821a.h().C());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void n(boolean show) {
            if (show) {
                this.tvManualText.setVisibility(0);
                this.itemView.setVisibility(0);
            } else {
                this.tvManualText.setVisibility(8);
                this.itemView.setVisibility(8);
            }
        }
    }
}
