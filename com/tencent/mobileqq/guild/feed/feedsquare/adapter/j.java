package com.tencent.mobileqq.guild.feed.feedsquare.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001+B%\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bR\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "", "onBindViewHolder", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "hide", "show", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "type", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j$a;", "mViewHolder", "", "D", "Ljava/lang/CharSequence;", "getNoMoreTipText", "()Ljava/lang/CharSequence;", "i0", "(Ljava/lang/CharSequence;)V", "noMoreTipText", "E", "loadingTipsText", UserInfo.SEX_FEMALE, "Z", "isHidden", "tipsRes", "loadingTipRes", "<init>", "(III)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends RFWAbsLoadMoreAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a mViewHolder;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private CharSequence noMoreTipText;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final CharSequence loadingTipsText;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isHidden;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ProgressBar;", "E", "Landroid/widget/ProgressBar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ProgressBar;", "mProgressbar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "mProgressInfo", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ProgressBar mProgressbar;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView mProgressInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.lz7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(com.te\u2026uild.aio.R.id.pb_loading)");
            this.mProgressbar = (ProgressBar) findViewById;
            View findViewById2 = view.findViewById(R.id.kbr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tv_tips)");
            this.mProgressInfo = (TextView) findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getMProgressInfo() {
            return this.mProgressInfo;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ProgressBar getMProgressbar() {
            return this.mProgressbar;
        }
    }

    public j() {
        this(0, 0, 0, 7, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.type;
    }

    public final void hide() {
        View view;
        this.isHidden = true;
        a aVar = this.mViewHolder;
        if (aVar != null) {
            view = aVar.itemView;
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void i0(@Nullable CharSequence charSequence) {
        this.noMoreTipText = charSequence;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        a aVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof a) {
            aVar = (a) holder;
        } else {
            aVar = null;
        }
        this.mViewHolder = aVar;
        super.onBindViewHolder(holder, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.f169066hn3, parent, false);
        view.setVisibility(8);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        a aVar = new a(view);
        this.mViewHolder = aVar;
        CharSequence charSequence = this.loadingTipsText;
        if (charSequence != null && charSequence.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ProgressBar mProgressbar = aVar.getMProgressbar();
            ViewGroup.LayoutParams layoutParams = mProgressbar.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.rightMargin = 0;
                mProgressbar.setLayoutParams(marginLayoutParams);
                aVar.getMProgressInfo().setPadding(0, 0, 0, 0);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        }
        return aVar;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        CharSequence charSequence;
        a aVar = this.mViewHolder;
        if (aVar != null) {
            int i3 = 8;
            aVar.getMProgressbar().setVisibility(8);
            aVar.getMProgressInfo().setVisibility(0);
            TextView mProgressInfo = aVar.getMProgressInfo();
            if (hasMore) {
                charSequence = "";
            } else {
                charSequence = this.noMoreTipText;
            }
            mProgressInfo.setText(charSequence);
            View view = aVar.itemView;
            if (!this.isHidden) {
                i3 = 0;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        a aVar = this.mViewHolder;
        if (aVar != null) {
            int i3 = 0;
            aVar.getMProgressbar().setVisibility(0);
            aVar.getMProgressInfo().setText(this.loadingTipsText);
            View view = aVar.itemView;
            if (this.isHidden) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    public final void show() {
        View view;
        this.isHidden = false;
        a aVar = this.mViewHolder;
        if (aVar != null) {
            view = aVar.itemView;
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public /* synthetic */ j(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 12 : i3, (i18 & 2) != 0 ? R.string.f144670pe : i16, (i18 & 4) != 0 ? R.string.f144370ol : i17);
    }

    public j(int i3, int i16, int i17) {
        this.type = i3;
        this.noMoreTipText = HardCodeUtil.qqStr(i16);
        this.loadingTipsText = HardCodeUtil.qqStr(i17);
    }
}
