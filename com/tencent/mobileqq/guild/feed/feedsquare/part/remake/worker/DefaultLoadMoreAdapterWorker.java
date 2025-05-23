package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import androidx.core.util.Supplier;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import bk1.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareFeedListViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00190\u0018\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010#R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010 \u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultLoadMoreAdapterWorker;", "Lbk1/a$a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "", "", "isLoading", "hasMore", "", ReportConstant.COSTREPORT_PREFIX, "", "sortMode", "t", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "viewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/j;", DownloadInfo.spKey_Config, "r", "Lvi1/e;", "listUIOperationApi", tl.h.F, "d", "I", "tipsRes", "Landroidx/core/util/Supplier;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "e", "Landroidx/core/util/Supplier;", "feedListAdapterPeeker", "f", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "g", "Z", "isMember", "", "Ljava/lang/String;", "logTag", "i", "isFeedSquare", "<init>", "(ILandroidx/core/util/Supplier;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class DefaultLoadMoreAdapterWorker extends a.AbstractC0131a<com.tencent.mobileqq.guild.feed.feedsquare.adapter.j, Object> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int tipsRes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<RecyclerView.Adapter<?>> feedListAdapterPeeker;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.viewmodel.k viewModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isMember;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFeedSquare;

    public /* synthetic */ DefaultLoadMoreAdapterWorker(int i3, Supplier supplier, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? R.string.f144670pe : i3, supplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(boolean isLoading, boolean hasMore) {
        b().setLoadState(isLoading, hasMore);
        b().onLoadMoreEnd(hasMore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int sortMode) {
        boolean z16;
        if ((this.isFeedSquare && sortMode == 3) || !this.isMember) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            b().hide();
        } else {
            b().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // bk1.a.AbstractC0131a
    public void h(@NotNull vi1.e listUIOperationApi) {
        MutableLiveData<Boolean> Q1;
        Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
        super.h(listUIOperationApi);
        this.isFeedSquare = d().getVmApi() instanceof GuildFeedSquareFeedListViewModel;
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar = this.viewModel;
        if (kVar != null && (Q1 = kVar.Q1()) != null) {
            LifecycleOwner lifecycleOwner = d().getLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultLoadMoreAdapterWorker$work$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    boolean z16;
                    z16 = DefaultLoadMoreAdapterWorker.this.isMember;
                    if (Intrinsics.areEqual(Boolean.valueOf(z16), it)) {
                        return;
                    }
                    DefaultLoadMoreAdapterWorker defaultLoadMoreAdapterWorker = DefaultLoadMoreAdapterWorker.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    defaultLoadMoreAdapterWorker.isMember = it.booleanValue();
                    if (DefaultLoadMoreAdapterWorker.this.b().isLoadingMore()) {
                        return;
                    }
                    DefaultLoadMoreAdapterWorker defaultLoadMoreAdapterWorker2 = DefaultLoadMoreAdapterWorker.this;
                    defaultLoadMoreAdapterWorker2.t(defaultLoadMoreAdapterWorker2.d().getVmApi().getMSortMode());
                }
            };
            Q1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DefaultLoadMoreAdapterWorker.u(Function1.this, obj);
                }
            });
        }
        MutableLiveData<UIStateData<List<ij1.g>>> j3 = d().getVmApi().j();
        LifecycleOwner lifecycleOwner2 = d().getLifecycleOwner();
        final Function1<UIStateData<List<ij1.g>>, Unit> function12 = new Function1<UIStateData<List<ij1.g>>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultLoadMoreAdapterWorker$work$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<ij1.g>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<ij1.g>> uIStateData) {
                String str;
                Supplier supplier;
                int state = uIStateData.getState();
                if (state == 0) {
                    DefaultLoadMoreAdapterWorker.this.s(false, true ^ uIStateData.getIsFinish());
                    if (uIStateData.getIsLoadMore()) {
                        return;
                    }
                    DefaultLoadMoreAdapterWorker.this.b().hide();
                    return;
                }
                if (state == 2 || state == 3) {
                    com.tencent.mobileqq.guild.feed.feedsquare.adapter.j b16 = DefaultLoadMoreAdapterWorker.this.b();
                    DefaultLoadMoreAdapterWorker defaultLoadMoreAdapterWorker = DefaultLoadMoreAdapterWorker.this;
                    com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar = b16;
                    if (uIStateData.getIsFinish()) {
                        defaultLoadMoreAdapterWorker.t(defaultLoadMoreAdapterWorker.d().getVmApi().getMSortMode());
                    } else {
                        defaultLoadMoreAdapterWorker.b().show();
                    }
                    jVar.setMaxAutoLoadMoreTimes(3);
                    jVar.resetAutoLoadMoreTimes();
                    if (state == 2) {
                        str = DefaultLoadMoreAdapterWorker.this.logTag;
                        QLog.d(str, 1, "[FeedsLoad][work]: state:2,  block for load more");
                        DefaultLoadMoreAdapterWorker.this.s(false, false);
                        return;
                    }
                    DefaultLoadMoreAdapterWorker.this.s(false, !uIStateData.getIsFinish());
                    return;
                }
                if (state == 4) {
                    supplier = DefaultLoadMoreAdapterWorker.this.feedListAdapterPeeker;
                    RecyclerView.Adapter adapter = (RecyclerView.Adapter) supplier.get();
                    if ((adapter != null ? adapter.getNUM_BACKGOURND_ICON() : 0) == 0) {
                        DefaultLoadMoreAdapterWorker.this.b().hide();
                        return;
                    }
                    return;
                }
                if (state == 6 || state == 7 || state == 8) {
                    if (state == 8) {
                        DefaultLoadMoreAdapterWorker defaultLoadMoreAdapterWorker2 = DefaultLoadMoreAdapterWorker.this;
                        defaultLoadMoreAdapterWorker2.t(defaultLoadMoreAdapterWorker2.d().getVmApi().getMSortMode());
                    } else if (bl.b(uIStateData.getData())) {
                        DefaultLoadMoreAdapterWorker.this.b().hide();
                    }
                }
            }
        };
        j3.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DefaultLoadMoreAdapterWorker.v(Function1.this, obj);
            }
        });
    }

    public final void q(@NotNull com.tencent.mobileqq.guild.feed.viewmodel.k viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    @Override // bk1.a.AbstractC0131a
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.guild.feed.feedsquare.adapter.j f(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.j config) {
        Intrinsics.checkNotNullParameter(config, "config");
        com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar = new com.tencent.mobileqq.guild.feed.feedsquare.adapter.j(0, this.tipsRes, 0, 1, null);
        jVar.setHasStableIds(true);
        return jVar;
    }

    public DefaultLoadMoreAdapterWorker(int i3, @NotNull Supplier<RecyclerView.Adapter<?>> feedListAdapterPeeker) {
        Intrinsics.checkNotNullParameter(feedListAdapterPeeker, "feedListAdapterPeeker");
        this.tipsRes = i3;
        this.feedListAdapterPeeker = feedListAdapterPeeker;
        this.logTag = "DefaultLoadMoreAdapterWorker";
    }
}
