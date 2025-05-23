package com.tencent.mobileqq.troop.teamup.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter;
import com.tencent.biz.richframework.preload.recyclerview.RFWCountLoadMoreStrategy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.troop.teamup.home.data.TroopTeamUpData;
import com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0003 !\"B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bR\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/adapter/f;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "p1", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "", "isLoading", "hasMore", "", "setLoadState", "onLoadMoreStart", "onLoadMoreEnd", "position", "getItemViewType", "hide", "show", "Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM;", "getViewModel", "()Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM;", "viewModel", "Lcom/tencent/mobileqq/troop/teamup/home/adapter/f$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/teamup/home/adapter/f$b;", "mViewHolder", "<init>", "(Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM;)V", "D", "a", "b", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f extends RFWAbsLoadMoreAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b mViewHolder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopTeamUpContentListVM viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/adapter/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.home.adapter.f$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/adapter/f$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ProgressBar;", "E", "Landroid/widget/ProgressBar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ProgressBar;", "mProgressbar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "mProgressInfo", "Landroid/view/View;", "v", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ProgressBar mProgressbar;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final TextView mProgressInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View v3) {
            super(v3);
            Intrinsics.checkNotNullParameter(v3, "v");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) v3);
                return;
            }
            View findViewById = v3.findViewById(R.id.lz7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(R.id.pb_loading)");
            this.mProgressbar = (ProgressBar) findViewById;
            View findViewById2 = v3.findViewById(R.id.kbr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(com.tence\u2026bileqq.qqui.R.id.tv_tips)");
            this.mProgressInfo = (TextView) findViewById2;
        }

        @NotNull
        public final TextView l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TextView) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.mProgressInfo;
        }

        @NotNull
        public final ProgressBar m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ProgressBar) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mProgressbar;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/adapter/f$c;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWCountLoadMoreStrategy;", "", "getLinearPreloadCount", "<init>", "()V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends RFWCountLoadMoreStrategy {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/adapter/f$c$a;", "", "", "PRELOAD_COUNT", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.teamup.home.adapter.f$c$a, reason: from kotlin metadata */
        /* loaded from: classes19.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    return;
                }
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
            }

            Companion() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                    return;
                }
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55799);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.RFWCountLoadMoreStrategy
        /* renamed from: getLinearPreloadCount */
        protected int getPreloadCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return 10;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55802);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(@NotNull TroopTeamUpContentListVM viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewModel);
        } else {
            this.viewModel = viewModel;
            this.mLoadMoreStrategy = new c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, position)).intValue();
        }
        return BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD;
    }

    public final void hide() {
        View view;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        b bVar = this.mViewHolder;
        boolean z16 = false;
        if (bVar != null && (view2 = bVar.itemView) != null && view2.getVisibility() == 0) {
            z16 = true;
        }
        if (z16) {
            b bVar2 = this.mViewHolder;
            if (bVar2 != null) {
                view = bVar2.itemView;
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int p16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent, p16);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.f169066hn3, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026lse\n                    )");
        b bVar = new b(inflate);
        this.mViewHolder = bVar;
        bVar.itemView.setVisibility(8);
        return bVar;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        ProgressBar progressBar;
        TextView l3;
        TextView l16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, hasMore);
            return;
        }
        b bVar = this.mViewHolder;
        if (bVar != null) {
            progressBar = bVar.m();
        } else {
            progressBar = null;
        }
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (hasMore) {
            b bVar2 = this.mViewHolder;
            if (bVar2 != null && (l16 = bVar2.l()) != null) {
                l16.setText("");
                return;
            }
            return;
        }
        b bVar3 = this.mViewHolder;
        if (bVar3 != null && (l3 = bVar3.l()) != null) {
            l3.setText(R.string.f236267dw);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        ProgressBar progressBar;
        TextView l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        b bVar = this.mViewHolder;
        if (bVar != null) {
            progressBar = bVar.m();
        } else {
            progressBar = null;
        }
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        b bVar2 = this.mViewHolder;
        if (bVar2 != null && (l3 = bVar2.l()) != null) {
            l3.setText(R.string.f236277dx);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter
    public void setLoadState(boolean isLoading, boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isLoading), Boolean.valueOf(hasMore));
            return;
        }
        super.setLoadState(isLoading, hasMore);
        if (!hasMore) {
            onLoadMoreEnd(false);
        }
        ArrayList<TroopTeamUpData> value = this.viewModel.a2().getValue();
        if (value == null || value.isEmpty()) {
            z16 = true;
        }
        if ((!z16) && (isLoading || !hasMore)) {
            show();
        } else {
            hide();
        }
    }

    public final void show() {
        boolean z16;
        View view;
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        b bVar = this.mViewHolder;
        if (bVar != null && (view2 = bVar.itemView) != null && view2.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            b bVar2 = this.mViewHolder;
            if (bVar2 != null) {
                view = bVar2.itemView;
            } else {
                view = null;
            }
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }
}
