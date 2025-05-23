package com.tencent.now.linkpkanchorplay.rankpkhistory.view;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import g55.at;
import g55.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001>B/\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006?"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryPage;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "J0", "", "G0", "H0", "Lg55/u;", "rsp", "K0", "", "roomId", "", "extra", "E0", "d", "J", "F0", "()J", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData;", "e", "Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData;", "getTabData", "()Lcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData;", "tabData", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lwm3/a;", h.F, "Lwm3/a;", "rankPKHistoryViewModel", "Landroidx/recyclerview/widget/RecyclerView;", "i", "Landroidx/recyclerview/widget/RecyclerView;", "pkHistoryRv", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "tipsEmptyListView", "Lvm3/b;", BdhLogUtil.LogTag.Tag_Conn, "Lvm3/b;", "rankPKHistoryTabViewAdapter", "", "Lg55/at;", "D", "Ljava/util/List;", "historyList", "E", "Ljava/lang/String;", UserInfo.SEX_FEMALE, "Z", "hasMore", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;JLcom/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryTitleTabData;Landroidx/lifecycle/LifecycleOwner;Lwm3/a;)V", "G", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class RankPKHistoryPage extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private vm3.b rankPKHistoryTabViewAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<at> historyList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String extra;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasMore;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RankPKHistoryTitleTabData tabData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wm3.a rankPKHistoryViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecyclerView pkHistoryRv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView tipsEmptyListView;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/now/linkpkanchorplay/rankpkhistory/view/RankPKHistoryPage$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            if (RankPKHistoryPage.this.G0() && RankPKHistoryPage.this.hasMore) {
                RankPKHistoryPage rankPKHistoryPage = RankPKHistoryPage.this;
                rankPKHistoryPage.E0(rankPKHistoryPage.getRoomId(), RankPKHistoryPage.this.extra);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankPKHistoryPage(@NotNull Context context, long j3, @NotNull RankPKHistoryTitleTabData tabData, @NotNull LifecycleOwner lifecycleOwner, @NotNull wm3.a rankPKHistoryViewModel) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(tabData, "tabData");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(rankPKHistoryViewModel, "rankPKHistoryViewModel");
        this.roomId = j3;
        this.tabData = tabData;
        this.lifecycleOwner = lifecycleOwner;
        this.rankPKHistoryViewModel = rankPKHistoryViewModel;
        this.rankPKHistoryTabViewAdapter = new vm3.b(tabData.getPkType());
        this.historyList = new ArrayList();
        this.extra = "";
        View.inflate(context, R.layout.hml, this);
        View findViewById = findViewById(R.id.f97875lk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tips_empty_history_view)");
        this.tipsEmptyListView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f70413ld);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.rank_pk_history_page_rv)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.pkHistoryRv = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        E0(j3, this.extra);
        H0();
        J0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(long roomId, String extra) {
        LogUtil.i("RankPKHistoryPage", "getRankPKHistory, roomId:" + roomId + ", this:" + hashCode(), new Object[0]);
        this.rankPKHistoryViewModel.N1(roomId, extra, this.tabData.getPkType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean G0() {
        if (this.rankPKHistoryTabViewAdapter.getItemCount() > 0 && this.pkHistoryRv.computeVerticalScrollExtent() + this.pkHistoryRv.computeVerticalScrollOffset() >= this.pkHistoryRv.computeVerticalScrollRange()) {
            return true;
        }
        return false;
    }

    private final void H0() {
        this.rankPKHistoryViewModel.O1(this.tabData.getPkType()).observe(this.lifecycleOwner, new Observer() { // from class: com.tencent.now.linkpkanchorplay.rankpkhistory.view.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RankPKHistoryPage.I0(RankPKHistoryPage.this, (u) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I0(RankPKHistoryPage this$0, u it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.K0(it);
    }

    private final void J0() {
        this.pkHistoryRv.addOnScrollListener(new b());
    }

    private final void K0(u rsp) {
        String str = rsp.f401398e;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.extra");
        this.extra = str;
        this.hasMore = rsp.f401396c;
        List<at> list = this.historyList;
        at[] atVarArr = rsp.f401395b;
        Intrinsics.checkNotNullExpressionValue(atVarArr, "rsp.pkList");
        CollectionsKt__MutableCollectionsKt.addAll(list, atVarArr);
        if (this.historyList.size() == 0) {
            this.tipsEmptyListView.setVisibility(0);
            return;
        }
        this.tipsEmptyListView.setVisibility(8);
        if (this.pkHistoryRv.getAdapter() == null) {
            this.rankPKHistoryTabViewAdapter.setData(this.historyList);
            this.pkHistoryRv.setAdapter(this.rankPKHistoryTabViewAdapter);
        } else {
            this.rankPKHistoryTabViewAdapter.notifyDataSetChanged();
        }
    }

    /* renamed from: F0, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }
}
