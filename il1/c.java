package il1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshLoadingView;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 .2\u00020\u0001:\u0002/0B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016R\u0016\u0010\u001a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lil1/c;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "Landroid/content/Context;", "context", "Landroid/view/View;", "k0", "", "s0", "o0", "p0", "q0", "", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "onBindViewHolder", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "hide", "show", "isFeedAllowSendComment", "r0", "getItemCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "Lil1/c$b;", BdhLogUtil.LogTag.Tag_Conn, "Lil1/c$b;", "mViewHolder", "D", "I", "curState", "E", "l0", "()Z", "setFeedAllowSendComment", "(Z)V", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends RFWAbsLoadMoreAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b mViewHolder;

    /* renamed from: D, reason: from kotlin metadata */
    private int curState;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isFeedAllowSendComment = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean show;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lil1/c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshLoadingView;", "E", "Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshLoadingView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/guild/discoveryv2/content/refresh/RefreshLoadingView;", "mProgressbar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "mProgressInfo", "Landroid/view/View;", "v", "<init>", "(Landroid/view/View;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final RefreshLoadingView mProgressbar;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView mProgressInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View v3) {
            super(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            View findViewById = v3.findViewById(R.id.lz7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(com.tence\u2026uild.aio.R.id.pb_loading)");
            this.mProgressbar = (RefreshLoadingView) findViewById;
            View findViewById2 = v3.findViewById(R.id.kbr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(R.id.tv_tips)");
            this.mProgressInfo = (TextView) findViewById2;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getMProgressInfo() {
            return this.mProgressInfo;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final RefreshLoadingView getMProgressbar() {
            return this.mProgressbar;
        }
    }

    public c() {
        this.mLoadMoreStrategy = new d();
    }

    private final View k0(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, bi.b(60));
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        RefreshLoadingView refreshLoadingView = new RefreshLoadingView(context);
        refreshLoadingView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(bi.b(20), bi.b(20));
        layoutParams2.gravity = 17;
        refreshLoadingView.setLayoutParams(layoutParams2);
        refreshLoadingView.setId(R.id.lz7);
        TextView textView = new TextView(context);
        textView.setText("- \u6682\u65e0\u66f4\u591a\u8bc4\u8bba -");
        textView.setTextSize(12.0f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        textView.setLayoutParams(layoutParams3);
        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_secondary));
        textView.setId(R.id.kbr);
        linearLayout.addView(refreshLoadingView);
        linearLayout.addView(textView);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(boolean z16, c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            this$0.curState = 2;
            QLog.d("CommentLoadMoreAdapter", 1, "onLoadMoreEnd...curState=2");
            this$0.o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("CommentLoadMoreAdapter", 1, "onLoadMoreStart...");
        this$0.curState = 0;
        this$0.q0();
    }

    private final void o0() {
        RefreshLoadingView refreshLoadingView;
        TextView textView;
        String str;
        RefreshLoadingView mProgressbar;
        b bVar = this.mViewHolder;
        if (bVar != null && (mProgressbar = bVar.getMProgressbar()) != null) {
            mProgressbar.d();
        }
        b bVar2 = this.mViewHolder;
        TextView textView2 = null;
        if (bVar2 != null) {
            refreshLoadingView = bVar2.getMProgressbar();
        } else {
            refreshLoadingView = null;
        }
        if (refreshLoadingView != null) {
            refreshLoadingView.setVisibility(8);
        }
        b bVar3 = this.mViewHolder;
        if (bVar3 != null) {
            textView = bVar3.getMProgressInfo();
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        b bVar4 = this.mViewHolder;
        if (bVar4 != null) {
            textView2 = bVar4.getMProgressInfo();
        }
        if (textView2 != null) {
            if (this.isFeedAllowSendComment) {
                str = "- \u6682\u65e0\u66f4\u591a\u8bc4\u8bba -";
            } else {
                str = "- \u5bf9\u65b9\u5df2\u5173\u95ed\u8bc4\u8bba\u80fd\u529b -";
            }
            textView2.setText(str);
        }
    }

    private final void p0() {
        RefreshLoadingView refreshLoadingView;
        TextView textView;
        RefreshLoadingView mProgressbar;
        b bVar = this.mViewHolder;
        if (bVar != null && (mProgressbar = bVar.getMProgressbar()) != null) {
            mProgressbar.d();
        }
        b bVar2 = this.mViewHolder;
        TextView textView2 = null;
        if (bVar2 != null) {
            refreshLoadingView = bVar2.getMProgressbar();
        } else {
            refreshLoadingView = null;
        }
        if (refreshLoadingView != null) {
            refreshLoadingView.setVisibility(8);
        }
        b bVar3 = this.mViewHolder;
        if (bVar3 != null) {
            textView = bVar3.getMProgressInfo();
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        b bVar4 = this.mViewHolder;
        if (bVar4 != null) {
            textView2 = bVar4.getMProgressInfo();
        }
        if (textView2 != null) {
            textView2.setText("");
        }
    }

    private final void q0() {
        RefreshLoadingView refreshLoadingView;
        RefreshLoadingView mProgressbar;
        b bVar = this.mViewHolder;
        TextView textView = null;
        if (bVar != null) {
            refreshLoadingView = bVar.getMProgressbar();
        } else {
            refreshLoadingView = null;
        }
        if (refreshLoadingView != null) {
            refreshLoadingView.setVisibility(0);
        }
        b bVar2 = this.mViewHolder;
        if (bVar2 != null && (mProgressbar = bVar2.getMProgressbar()) != null) {
            mProgressbar.a();
        }
        b bVar3 = this.mViewHolder;
        if (bVar3 != null) {
            textView = bVar3.getMProgressInfo();
        }
        if (textView != null) {
            textView.setText("\u6b63\u5728\u52a0\u8f7d\u66f4\u591a");
        }
    }

    private final void s0() {
        int i3 = this.curState;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    o0();
                    return;
                }
                return;
            }
            p0();
            return;
        }
        q0();
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.show ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return 8;
    }

    public final void hide() {
        if (!this.show) {
            return;
        }
        QLog.d("CommentLoadMoreAdapter", 1, "hide...");
        this.show = false;
        notifyItemRemoved(0);
    }

    /* renamed from: l0, reason: from getter */
    public final boolean getIsFeedAllowSendComment() {
        return this.isFeedAllowSendComment;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        b bVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        QLog.d("CommentLoadMoreAdapter", 1, "onBindViewHolder...");
        if (holder instanceof b) {
            bVar = (b) holder;
        } else {
            bVar = null;
        }
        this.mViewHolder = bVar;
        s0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        QLog.d("CommentLoadMoreAdapter", 1, "onCreateViewHold...");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        b bVar = new b(k0(context));
        this.mViewHolder = bVar;
        return bVar;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(final boolean hasMore) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: il1.a
            @Override // java.lang.Runnable
            public final void run() {
                c.m0(hasMore, this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: il1.b
            @Override // java.lang.Runnable
            public final void run() {
                c.n0(c.this);
            }
        });
    }

    public final void r0(boolean isFeedAllowSendComment) {
        if (this.isFeedAllowSendComment == isFeedAllowSendComment) {
            return;
        }
        this.isFeedAllowSendComment = isFeedAllowSendComment;
        if (this.show) {
            notifyItemChanged(0);
        }
    }

    public final void show() {
        if (this.show) {
            return;
        }
        QLog.d("CommentLoadMoreAdapter", 1, "show...");
        this.show = true;
        notifyItemInserted(0);
    }
}
