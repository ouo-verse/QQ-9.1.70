package com.tencent.mobileqq.weather.adapter;

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
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/n;", "Lcom/tencent/biz/richframework/preload/recyclerview/RFWAbsLoadMoreAdapter;", "", "i0", "", "j0", "k0", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateViewHolder", "holder", "position", "onBindViewHolder", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "Lcom/tencent/mobileqq/weather/adapter/n$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/weather/adapter/n$b;", "loadMoreViewHolder", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "b", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class n extends RFWAbsLoadMoreAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String D;

    @NotNull
    private static final String E;

    @NotNull
    private static final String F;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b loadMoreViewHolder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/n$a;", "", "", "LOAD_TEXT_FINISH", "Ljava/lang/String;", "LOAD_TEXT_LOADING", "LOAD_TEXT_NO_DATA", "TAG", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.adapter.n$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/weather/adapter/n$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ProgressBar;", "E", "Landroid/widget/ProgressBar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ProgressBar;", "mProgressbar", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "mProgressInfo", "Landroid/view/View;", "v", "<init>", "(Landroid/view/View;)V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
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
            View findViewById = v3.findViewById(R.id.f166127ys1);
            Intrinsics.checkNotNullExpressionValue(findViewById, "v.findViewById(R.id.load_progress_bar)");
            this.mProgressbar = (ProgressBar) findViewById;
            View findViewById2 = v3.findViewById(R.id.kbr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "v.findViewById(R.id.tv_tips)");
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17951);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        D = "\u6b63\u5728\u62fc\u547d\u52a0\u8f7d\u66f4\u591a...";
        E = "\u52a0\u8f7d\u5b8c\u6210";
        F = "\u6ca1\u6709\u66f4\u591a...";
    }

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void i0() {
        b bVar;
        View view;
        if (com.tencent.mobileqq.weather.util.b.g() && (bVar = this.loadMoreViewHolder) != null && (view = bVar.itemView) != null) {
            view.setBackgroundColor(-16777216);
        }
    }

    private final String j0() {
        return D;
    }

    private final String k0() {
        return E;
    }

    private final String l0() {
        return F;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.RFWAbsLoadMoreAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onBindViewHolder(holder, position);
        QLog.d("WeatherMainLoadMoreAdapter", 1, "onBindViewHolder   | holder = " + holder + " | position = " + position + " | hashcode = " + hashCode());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        QLog.d("WeatherMainLoadMoreAdapter", 1, "onCreateViewHolder  hashcode = " + hashCode());
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.h7b, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026ad_footer, parent, false)");
        b bVar = new b(inflate);
        this.loadMoreViewHolder = bVar;
        View view = bVar.itemView;
        if (view != null) {
            view.setVisibility(4);
        }
        i0();
        b bVar2 = this.loadMoreViewHolder;
        Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type com.tencent.mobileqq.weather.adapter.WeatherMainLoadMoreAdapter.LoadMoreViewHolder");
        return bVar2;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        ProgressBar progressBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, hasMore);
            return;
        }
        QLog.d("WeatherMainLoadMoreAdapter", 1, "onLoadMoreEnd  |  hasMore = " + hasMore + " |  hashcode = " + hashCode());
        b bVar = this.loadMoreViewHolder;
        if (bVar == null) {
            QLog.d("WeatherMainLoadMoreAdapter", 1, "onLoadMoreEnd  loadMoreViewHolder == null");
            return;
        }
        TextView textView = null;
        if (bVar != null) {
            progressBar = bVar.m();
        } else {
            progressBar = null;
        }
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (hasMore) {
            b bVar2 = this.loadMoreViewHolder;
            if (bVar2 != null) {
                textView = bVar2.l();
            }
            if (textView != null) {
                textView.setText(k0());
                return;
            }
            return;
        }
        b bVar3 = this.loadMoreViewHolder;
        if (bVar3 != null) {
            textView = bVar3.l();
        }
        if (textView != null) {
            textView.setText(l0());
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        View view;
        ProgressBar progressBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QLog.d("WeatherMainLoadMoreAdapter", 1, "onLoadMoreStart  hashcode = " + hashCode());
        if (this.loadMoreViewHolder == null) {
            QLog.d("WeatherMainLoadMoreAdapter", 1, "onLoadMoreStart  loadMoreViewHolder == null");
            return;
        }
        if (com.tencent.mobileqq.weather.util.g.f313646a.J()) {
            QLog.d("WeatherMainLoadMoreAdapter", 1, "onLoadMoreStart return: study mode");
            return;
        }
        b bVar = this.loadMoreViewHolder;
        TextView textView = null;
        if (bVar != null) {
            view = bVar.itemView;
        } else {
            view = null;
        }
        if (view != null) {
            view.setVisibility(0);
        }
        b bVar2 = this.loadMoreViewHolder;
        if (bVar2 != null) {
            progressBar = bVar2.m();
        } else {
            progressBar = null;
        }
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        b bVar3 = this.loadMoreViewHolder;
        if (bVar3 != null) {
            textView = bVar3.l();
        }
        if (textView != null) {
            textView.setText(j0());
        }
    }
}
