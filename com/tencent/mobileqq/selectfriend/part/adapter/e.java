package com.tencent.mobileqq.selectfriend.part.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001f !B!\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u000f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/e;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/selectfriend/part/adapter/e$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "", "k0", "getItemCount", "", "getItemId", "Lzp2/b;", "j0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "mContext", BdhLogUtil.LogTag.Tag_Conn, "Lzp2/b;", "mRecentHeadData", "Lcom/tencent/mobileqq/selectfriend/part/adapter/e$b;", "D", "Lcom/tencent/mobileqq/selectfriend/part/adapter/e$b;", "mRecentChatHeadAdapterCallback", "<init>", "(Landroid/content/Context;Lzp2/b;Lcom/tencent/mobileqq/selectfriend/part/adapter/e$b;)V", "E", "a", "b", "c", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends RecyclerView.Adapter<c> {

    /* renamed from: C, reason: from kotlin metadata */
    private final zp2.b mRecentHeadData;

    /* renamed from: D, reason: from kotlin metadata */
    private final b mRecentChatHeadAdapterCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/e$b;", "", "", "report", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a();

        void report();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/e$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", "setTvLeftContent", "(Landroid/widget/TextView;)V", "tvLeftContent", "Landroid/widget/RelativeLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/RelativeLayout;", "l", "()Landroid/widget/RelativeLayout;", "setTipLayout", "(Landroid/widget/RelativeLayout;)V", "tipLayout", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setTipTv", "tipTv", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView tvLeftContent;

        /* renamed from: F, reason: from kotlin metadata */
        private RelativeLayout tipLayout;

        /* renamed from: G, reason: from kotlin metadata */
        private TextView tipTv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.ota);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_divider)");
            this.tvLeftContent = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f163195ot4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.rl_tips)");
            this.tipLayout = (RelativeLayout) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.otc);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_tips)");
            this.tipTv = (TextView) findViewById3;
        }

        /* renamed from: l, reason: from getter */
        public final RelativeLayout getTipLayout() {
            return this.tipLayout;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getTipTv() {
            return this.tipTv;
        }

        /* renamed from: o, reason: from getter */
        public final TextView getTvLeftContent() {
            return this.tvLeftContent;
        }
    }

    public e(Context mContext, zp2.b mRecentHeadData, b bVar) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(mRecentHeadData, "mRecentHeadData");
        this.mContext = mContext;
        this.mRecentHeadData = mRecentHeadData;
        this.mRecentChatHeadAdapterCallback = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mRecentChatHeadAdapterCallback == null || FastClickUtils.isFastDoubleClick("ForwardFriend.RecentForwardAdapter")) {
            return;
        }
        this$0.mRecentChatHeadAdapterCallback.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    /* renamed from: j0, reason: from getter */
    public final zp2.b getMRecentHeadData() {
        return this.mRecentHeadData;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        TextView tvLeftContent = holder.getTvLeftContent();
        zp2.b bVar = this.mRecentHeadData;
        tvLeftContent.setText(bVar != null ? bVar.getLeftContent() : null);
        holder.getTipLayout().setVisibility(this.mRecentHeadData.getTipLayoutVisible());
        holder.getTipTv().setVisibility(this.mRecentHeadData.getTipTvVisible());
        holder.getTipTv().setText(this.mRecentHeadData.getTipContent());
        holder.getTipTv().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.selectfriend.part.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.l0(e.this, view);
            }
        });
        b bVar2 = this.mRecentChatHeadAdapterCallback;
        if (bVar2 == null) {
            com.tencent.xaction.log.b.a("ForwardFriend.RecentForwardAdapter", 2, "null == mRecentChatHeadAdapterCallback");
        } else {
            bVar2.report();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cyj, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026      false\n            )");
        return new c(inflate);
    }
}
