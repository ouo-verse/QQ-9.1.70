package com.tencent.mobileqq.selectfriend.part.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.ForwardSelectionRecentFriendGridAdapter;
import com.tencent.mobileqq.adapter.n;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000278B-\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b4\u00105J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0013\u00103\u001a\u0004\u0018\u0001008F\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/h;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/selectfriend/part/adapter/h$b;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentForwardList", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "k0", "holder", "position", "j0", "getItemCount", "", "getItemId", "", "isMultiSelect", "l0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "Landroid/os/Bundle;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "mFsForwardData", "Lcom/tencent/mobileqq/adapter/n$c;", "D", "Lcom/tencent/mobileqq/adapter/n$c;", "mForwardRecentListAdapterCallback", "E", "Ljava/util/List;", "mRecentForwardList", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/selectfriend/part/adapter/h$b;", "mRecentForwardViewHolder", "Lcom/tencent/mobileqq/adapter/ForwardSelectionRecentFriendGridAdapter;", "G", "Lcom/tencent/mobileqq/adapter/ForwardSelectionRecentFriendGridAdapter;", "mRecentFriendGridAdapter", "H", "Z", "mIsMultiSelect", "Lcom/tencent/widget/HorizontalListView;", "i0", "()Lcom/tencent/widget/HorizontalListView;", "horizontalListView", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;Lcom/tencent/mobileqq/adapter/n$c;)V", "I", "a", "b", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class h extends RecyclerView.Adapter<b> {

    /* renamed from: C, reason: from kotlin metadata */
    private final FSForwardData<Bundle> mFsForwardData;

    /* renamed from: D, reason: from kotlin metadata */
    private n.c mForwardRecentListAdapterCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private List<RecentUser> mRecentForwardList = new ArrayList();

    /* renamed from: F, reason: from kotlin metadata */
    private b mRecentForwardViewHolder;

    /* renamed from: G, reason: from kotlin metadata */
    private ForwardSelectionRecentFriendGridAdapter mRecentFriendGridAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsMultiSelect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/part/adapter/h$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/TextView;", "setTvLeftContent", "(Landroid/widget/TextView;)V", "tvLeftContent", "Lcom/tencent/widget/HorizontalListView;", UserInfo.SEX_FEMALE, "Lcom/tencent/widget/HorizontalListView;", "l", "()Lcom/tencent/widget/HorizontalListView;", "setRecentForwardList", "(Lcom/tencent/widget/HorizontalListView;)V", "recentForwardList", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private TextView tvLeftContent;

        /* renamed from: F, reason: from kotlin metadata */
        private HorizontalListView recentForwardList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.ota);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_divider)");
            this.tvLeftContent = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f163192ot1);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.hlv_recent_forward)");
            this.recentForwardList = (HorizontalListView) findViewById2;
        }

        /* renamed from: l, reason: from getter */
        public final HorizontalListView getRecentForwardList() {
            return this.recentForwardList;
        }

        /* renamed from: m, reason: from getter */
        public final TextView getTvLeftContent() {
            return this.tvLeftContent;
        }
    }

    public h(Context context, FSForwardData<Bundle> fSForwardData, n.c cVar) {
        this.mContext = context;
        this.mFsForwardData = fSForwardData;
        this.mForwardRecentListAdapterCallback = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public final HorizontalListView i0() {
        b bVar = this.mRecentForwardViewHolder;
        if (bVar == null) {
            return null;
        }
        Intrinsics.checkNotNull(bVar);
        return bVar.getRecentForwardList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b holder, int position) {
        Context context;
        Intrinsics.checkNotNullParameter(holder, "holder");
        TextView tvLeftContent = holder.getTvLeftContent();
        Context context2 = this.mContext;
        Intrinsics.checkNotNull(context2);
        tvLeftContent.setText(context2.getResources().getString(R.string.x49));
        if (this.mForwardRecentListAdapterCallback != null && (context = this.mContext) != null && (context instanceof AppActivity)) {
            AppRuntime appRuntime = ((AppActivity) context).getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            if (this.mRecentFriendGridAdapter == null) {
                ForwardSelectionRecentFriendGridAdapter forwardSelectionRecentFriendGridAdapter = new ForwardSelectionRecentFriendGridAdapter(this.mContext, qQAppInterface, holder.getRecentForwardList(), this.mRecentForwardList, this.mForwardRecentListAdapterCallback);
                this.mRecentFriendGridAdapter = forwardSelectionRecentFriendGridAdapter;
                forwardSelectionRecentFriendGridAdapter.g(this.mIsMultiSelect);
            }
            holder.getRecentForwardList().setAdapter((ListAdapter) this.mRecentFriendGridAdapter);
            return;
        }
        com.tencent.xaction.log.b.a("ForwardFriend.RecentForwardAdapter", 2, "null == mForwardRecentListAdapterCallback || null == mContext || (!(mContext instanceof AppActivity))");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cyl, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026      false\n            )");
        b bVar = new b(inflate);
        this.mRecentForwardViewHolder = bVar;
        Intrinsics.checkNotNull(bVar);
        return bVar;
    }

    public final void l0(boolean isMultiSelect) {
        this.mIsMultiSelect = isMultiSelect;
        ForwardSelectionRecentFriendGridAdapter forwardSelectionRecentFriendGridAdapter = this.mRecentFriendGridAdapter;
        if (forwardSelectionRecentFriendGridAdapter != null) {
            forwardSelectionRecentFriendGridAdapter.g(isMultiSelect);
        }
    }

    public final void m0(List<RecentUser> recentForwardList) {
        Intrinsics.checkNotNullParameter(recentForwardList, "recentForwardList");
        this.mRecentForwardList = recentForwardList;
    }
}
