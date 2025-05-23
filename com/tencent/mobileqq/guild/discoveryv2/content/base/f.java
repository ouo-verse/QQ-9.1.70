package com.tencent.mobileqq.guild.discoveryv2.content.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqmini.sdk.widget.ToastView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001f B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f$b;", "i0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "position", "", "onBindViewHolder", "onLoadMoreStart", "getItemViewType", "", "getItemId", "", "notEnd", "onLoadMoreEnd", ToastView.ICON_LOADING, "isEnd", "", "isEndText", "j0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f$b;", "mViewHolder", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends RFWAbsLoadMoreAdapter {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mViewHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", "o", "()Landroid/view/View;", "mRootView", "Landroid/widget/ProgressBar;", UserInfo.SEX_FEMALE, "Landroid/widget/ProgressBar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ProgressBar;", "mProgressbar", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "endTextView", "v", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View mRootView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ProgressBar mProgressbar;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView endTextView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View v3) {
            super(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            View findViewById = v3.findViewById(R.id.f165997lp1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(R.id.lLayout_content)");
            this.mRootView = findViewById;
            View findViewById2 = v3.findViewById(R.id.lz7);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(com.tence\u2026uild.aio.R.id.pb_loading)");
            this.mProgressbar = (ProgressBar) findViewById2;
            View findViewById3 = v3.findViewById(R.id.kbr);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "v.findViewById(R.id.tv_tips)");
            this.endTextView = (TextView) findViewById3;
            findViewById.setVisibility(8);
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getEndTextView() {
            return this.endTextView;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ProgressBar getMProgressbar() {
            return this.mProgressbar;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final View getMRootView() {
            return this.mRootView;
        }
    }

    public f() {
        setMaxAutoLoadMoreTimes(5);
    }

    public static /* synthetic */ void k0(f fVar, boolean z16, boolean z17, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = "\u6682\u65e0\u66f4\u591a";
        }
        fVar.j0(z16, z17, str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return Reflection.getOrCreateKotlinClass(f.class).hashCode();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return h.INSTANCE.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f169066hn3, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ng_footer, parent, false)");
        b bVar = new b(inflate);
        this.mViewHolder = bVar;
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
    
        if (r6 != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j0(boolean loading, boolean isEnd, @NotNull String isEndText) {
        int i3;
        int i16;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(isEndText, "isEndText");
        setLoadState(loading, !isEnd);
        b bVar = this.mViewHolder;
        if (bVar == null) {
            return;
        }
        ProgressBar mProgressbar = bVar.getMProgressbar();
        int i17 = 8;
        if (loading) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        mProgressbar.setVisibility(i3);
        TextView endTextView = bVar.getEndTextView();
        if (isEnd) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        endTextView.setVisibility(i16);
        bVar.getEndTextView().setText(isEndText);
        View mRootView = bVar.getMRootView();
        if (isEnd) {
            CharSequence text = bVar.getEndTextView().getText();
            Intrinsics.checkNotNullExpressionValue(text, "vh.endTextView.text");
            z16 = true;
            if (text.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (!z16) {
            i17 = 0;
        }
        mRootView.setVisibility(i17);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        ViewGroup.LayoutParams layoutParams2 = holder.itemView.getLayoutParams();
        if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
            layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.setFullSpan(true);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean notEnd) {
    }
}
