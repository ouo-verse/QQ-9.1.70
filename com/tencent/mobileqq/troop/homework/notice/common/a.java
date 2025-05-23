package com.tencent.mobileqq.troop.homework.notice.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/homework/notice/common/a$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/notice/common/a$a;", "mViewHolder", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends RFWAbsLoadMoreAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private C8740a mViewHolder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/common/a$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "E", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/ProgressBar;", UserInfo.SEX_FEMALE, "Landroid/widget/ProgressBar;", "l", "()Landroid/widget/ProgressBar;", "progressbar", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "getProgressInfo", "()Landroid/widget/TextView;", "progressInfo", "v", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.common.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8740a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View root;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final ProgressBar progressbar;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final TextView progressInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8740a(@NotNull View v3) {
            super(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) v3);
                return;
            }
            View findViewById = v3.findViewById(R.id.f165997lp1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(R.id.lLayout_content)");
            this.root = findViewById;
            View findViewById2 = v3.findViewById(R.id.lz7);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(R.id.pb_loading)");
            this.progressbar = (ProgressBar) findViewById2;
            View findViewById3 = v3.findViewById(R.id.kbr);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "v.findViewById(com.tence\u2026bileqq.qqui.R.id.tv_tips)");
            this.progressInfo = (TextView) findViewById3;
        }

        @NotNull
        public final TextView getProgressInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.progressInfo;
        }

        @NotNull
        public final View getRoot() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.root;
        }

        @NotNull
        public final ProgressBar l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ProgressBar) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.progressbar;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        this.context = context;
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        View inflate = LayoutInflater.from(context2).inflate(R.layout.f169066hn3, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ng_footer, parent, false)");
        C8740a c8740a = new C8740a(inflate);
        this.mViewHolder = c8740a;
        return c8740a;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, hasMore);
            return;
        }
        if (!hasMore) {
            C8740a c8740a = this.mViewHolder;
            if (c8740a != null) {
                view = c8740a.getRoot();
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        ProgressBar progressBar;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        C8740a c8740a = this.mViewHolder;
        Context context = null;
        if (c8740a != null) {
            progressBar = c8740a.l();
        } else {
            progressBar = null;
        }
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        C8740a c8740a2 = this.mViewHolder;
        if (c8740a2 != null) {
            textView = c8740a2.getProgressInfo();
        } else {
            textView = null;
        }
        if (textView != null) {
            Context context2 = this.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context = context2;
            }
            textView.setText(context.getString(R.string.enh));
        }
    }
}
