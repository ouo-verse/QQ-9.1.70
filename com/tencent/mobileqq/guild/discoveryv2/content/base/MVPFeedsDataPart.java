package com.tencent.mobileqq.guild.discoveryv2.content.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreArgs;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreState;
import com.tencent.mobileqq.guild.discoveryv2.content.model.LoadMoreType;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshArgs;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshState;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshType;
import com.tencent.mobileqq.guild.discoveryv2.content.model.k;
import com.tencent.mobileqq.guild.discoveryv2.content.part.MVPFeedsPart;
import com.tencent.mobileqq.guild.discoveryv2.content.util.ContentMessage;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.LastFetchFeedTime;
import qh1.MVPFeedsListUIState;
import qh1.MVPFeedsRefreshUIState;
import qh1.MVPFeedsUIState;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010\u001b\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0016J\u001c\u0010$\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\"H\u0016J\u001e\u0010'\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010(\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\"\u0010.\u001a\n )*\u0004\u0018\u00010\"0\"8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R \u00108\u001a\b\u0012\u0004\u0012\u0002040/8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b5\u00102\u001a\u0004\b6\u00107R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/base/MVPFeedsDataPart;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/part/MVPFeedsPart;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "K9", "F9", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/i;", "pullToRefreshArgs", "S9", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/g;", "loadMoreArgs", "Q9", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/h;", "refreshState", "R9", "O9", "Lri1/a;", "success", "P9", "", "args", "I9", "H9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/f;", "J9", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/j;", "pullToRefreshState", "T9", "", "action", "handleBroadcastMessage", "account", "onAccountChanged", "getMessage", "onPartDestroy", "kotlin.jvm.PlatformType", "e", "Ljava/lang/String;", "G9", "()Ljava/lang/String;", "TAG", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lqh1/a;", "f", "Lkotlinx/coroutines/flow/MutableStateFlow;", "lastFetchFeedsTimeFlow", "Lqh1/e;", tl.h.F, "getUiStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "uiStateFlow", "i", "Ljava/util/List;", "viewModelList", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class MVPFeedsDataPart extends MVPFeedsPart implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = getLogTag();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableStateFlow<LastFetchFeedTime> lastFetchFeedsTimeFlow = StateFlowKt.MutableStateFlow(new LastFetchFeedTime(0, 1, null));

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableStateFlow<MVPFeedsUIState> uiStateFlow = StateFlowKt.MutableStateFlow(MVPFeedsUIState.INSTANCE.a());

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> viewModelList;

    private final void F9() {
        O9();
        MVPFeedsUIState mVPFeedsUIState = (MVPFeedsUIState) this.uiStateFlow.getValue();
        if (!mVPFeedsUIState.getListState().d().isEmpty()) {
            QLog.i(this.TAG, 1, "autoRefresh doNothing " + mVPFeedsUIState.getListState().d().size());
            return;
        }
        MVPFeedsUIState mVPFeedsUIState2 = (MVPFeedsUIState) this.uiStateFlow.getValue();
        MutableStateFlow mutableStateFlow = this.uiStateFlow;
        MVPFeedsUIState c16 = MVPFeedsUIState.c(mVPFeedsUIState2, null, MVPFeedsRefreshUIState.c(mVPFeedsUIState2.getRefreshState(), null, k.b.f217043b, false, null, 13, null), null, false, 13, null);
        QLog.d(this.TAG, 4, "updateUIState " + c16);
        mutableStateFlow.setValue(c16);
        List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list = this.viewModelList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
            list = null;
        }
        for (com.tencent.mobileqq.guild.discoveryv2.content.model.f fVar : list) {
            PullToRefreshType pullToRefreshType = PullToRefreshType.TYPE_FIRST_RENDER_FETCH;
            String TAG = this.TAG;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            fVar.C(new PullToRefreshArgs(pullToRefreshType, TAG));
        }
    }

    private final void H9(Object args) {
        if (!(args instanceof ContentMessage.LoadMoreMessage)) {
            QLog.e(this.TAG, 1, "handleLoadMoreMessage args error!");
        } else {
            ContentMessage.LoadMoreMessage loadMoreMessage = (ContentMessage.LoadMoreMessage) args;
            Q9(new LoadMoreArgs(loadMoreMessage.getLoadMoreType(), loadMoreMessage.getCallSource()));
        }
    }

    private final void I9(Object args) {
        if (!(args instanceof ContentMessage.PullToRefreshMessage)) {
            QLog.e(this.TAG, 1, "handlePullToRefreshMessage args error!");
        } else {
            ContentMessage.PullToRefreshMessage pullToRefreshMessage = (ContentMessage.PullToRefreshMessage) args;
            S9(new PullToRefreshArgs(pullToRefreshMessage.getPullToRefreshType(), pullToRefreshMessage.getCallSource()));
        }
    }

    private final void K9() {
        List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list = this.viewModelList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
            list = null;
        }
        for (com.tencent.mobileqq.guild.discoveryv2.content.model.f fVar : list) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            fVar.q(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.base.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MVPFeedsDataPart.L9(MVPFeedsDataPart.this, (PullToRefreshState) obj);
                }
            });
            LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner2, "partHost.hostLifecycleOwner");
            fVar.b(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.base.j
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MVPFeedsDataPart.M9(MVPFeedsDataPart.this, (LoadMoreState) obj);
                }
            });
            LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner3, "partHost.hostLifecycleOwner");
            fVar.d(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.base.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MVPFeedsDataPart.N9(MVPFeedsDataPart.this, (Long) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(MVPFeedsDataPart this$0, PullToRefreshState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.T9(it);
        this$0.P9(it.getSuccess());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(MVPFeedsDataPart this$0, LoadMoreState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        wh1.b.f445644a.a(it.a());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.R9(it);
        this$0.P9(it.getSuccess());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(MVPFeedsDataPart this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9();
    }

    private final void O9() {
        MVPFeedsUIState mVPFeedsUIState = (MVPFeedsUIState) this.uiStateFlow.getValue();
        MutableStateFlow mutableStateFlow = this.uiStateFlow;
        MVPFeedsListUIState listState = mVPFeedsUIState.getListState();
        long seq = mVPFeedsUIState.getListState().getSeq() + 1;
        List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list = this.viewModelList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((com.tencent.mobileqq.guild.discoveryv2.content.model.f) it.next()).i());
        }
        MVPFeedsUIState c16 = MVPFeedsUIState.c(mVPFeedsUIState, null, null, MVPFeedsListUIState.c(listState, 0, arrayList, seq, 1, null), false, 11, null);
        QLog.i(this.TAG, 1, "onContentListChanged " + mVPFeedsUIState + " -> " + c16);
        String str = this.TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateUIState ");
        sb5.append(c16);
        QLog.d(str, 4, sb5.toString());
        mutableStateFlow.setValue(c16);
    }

    private final void P9(ri1.a success) {
        if (success.d()) {
            this.lastFetchFeedsTimeFlow.setValue(new LastFetchFeedTime(System.currentTimeMillis()));
        }
    }

    private final void Q9(LoadMoreArgs loadMoreArgs) {
        MVPFeedsUIState mVPFeedsUIState = (MVPFeedsUIState) this.uiStateFlow.getValue();
        QLog.i(this.TAG, 1, "onLoadMore " + loadMoreArgs);
        if (mVPFeedsUIState.getRefreshState().getLoadMoreType() == LoadMoreType.NONE && !mVPFeedsUIState.getRefreshState().getIsEnd()) {
            if (mVPFeedsUIState.getRefreshState().getRefreshType().getRefreshing()) {
                QLog.e(this.TAG, 1, "onLoadMore doNothing refreshing");
                return;
            }
            MVPFeedsUIState mVPFeedsUIState2 = (MVPFeedsUIState) this.uiStateFlow.getValue();
            MutableStateFlow mutableStateFlow = this.uiStateFlow;
            MVPFeedsUIState c16 = MVPFeedsUIState.c(mVPFeedsUIState2, null, MVPFeedsRefreshUIState.c(mVPFeedsUIState2.getRefreshState(), loadMoreArgs.getLoadMoreType(), null, false, null, 14, null), null, false, 13, null);
            QLog.d(this.TAG, 4, "updateUIState " + c16);
            mutableStateFlow.setValue(c16);
            List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list = this.viewModelList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
                list = null;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((com.tencent.mobileqq.guild.discoveryv2.content.model.f) it.next()).B(loadMoreArgs);
            }
            return;
        }
        QLog.e(this.TAG, 1, "onLoadMore doNothing loading " + mVPFeedsUIState.getRefreshState());
    }

    private final void R9(LoadMoreState refreshState) {
        List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list = this.viewModelList;
        List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
            list = null;
        }
        for (com.tencent.mobileqq.guild.discoveryv2.content.model.f fVar : list) {
            if (!fVar.l()) {
                QLog.i(this.TAG, 1, "handleLoadMoreStateChanged false " + fVar.getClass().getSimpleName());
                return;
            }
        }
        MVPFeedsUIState mVPFeedsUIState = (MVPFeedsUIState) this.uiStateFlow.getValue();
        MutableStateFlow mutableStateFlow = this.uiStateFlow;
        ri1.a success = refreshState.getSuccess();
        MVPFeedsRefreshUIState refreshState2 = mVPFeedsUIState.getRefreshState();
        LoadMoreType loadMoreType = LoadMoreType.NONE;
        boolean isEnd = refreshState.getIsEnd();
        String endMsg = refreshState.getEndMsg();
        if (endMsg == null) {
            endMsg = mVPFeedsUIState.getRefreshState().getEndMsg();
        }
        MVPFeedsRefreshUIState c16 = MVPFeedsRefreshUIState.c(refreshState2, loadMoreType, null, isEnd, endMsg, 2, null);
        MVPFeedsListUIState listState = mVPFeedsUIState.getListState();
        List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list3 = this.viewModelList;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
        } else {
            list2 = list3;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((com.tencent.mobileqq.guild.discoveryv2.content.model.f) it.next()).i());
        }
        MVPFeedsUIState c17 = MVPFeedsUIState.c(mVPFeedsUIState, success, c16, MVPFeedsListUIState.c(listState, 0, arrayList, 0L, 5, null), false, 8, null);
        QLog.d(this.TAG, 4, "updateUIState " + c17);
        mutableStateFlow.setValue(c17);
    }

    private final void S9(PullToRefreshArgs pullToRefreshArgs) {
        MVPFeedsUIState mVPFeedsUIState = (MVPFeedsUIState) this.uiStateFlow.getValue();
        QLog.i(this.TAG, 1, "onRefresh " + pullToRefreshArgs);
        if (mVPFeedsUIState.getRefreshState().getRefreshType().getRefreshing()) {
            QLog.e(this.TAG, 1, "onRefresh doNothing");
            return;
        }
        MVPFeedsUIState mVPFeedsUIState2 = (MVPFeedsUIState) this.uiStateFlow.getValue();
        MutableStateFlow mutableStateFlow = this.uiStateFlow;
        ri1.a a16 = ri1.a.a(-1);
        Intrinsics.checkNotNullExpressionValue(a16, "error(GProStateCode.TYPE_DEFAULT_VALUE)");
        MVPFeedsUIState c16 = MVPFeedsUIState.c(mVPFeedsUIState2, a16, MVPFeedsRefreshUIState.c(mVPFeedsUIState2.getRefreshState(), null, k.b.f217043b, false, null, 13, null), null, false, 12, null);
        QLog.d(this.TAG, 4, "updateUIState " + c16);
        mutableStateFlow.setValue(c16);
        List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list = this.viewModelList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.discoveryv2.content.model.f) it.next()).C(pullToRefreshArgs);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: G9, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    @NotNull
    public abstract List<com.tencent.mobileqq.guild.discoveryv2.content.model.f> J9();

    public void T9(@NotNull PullToRefreshState pullToRefreshState) {
        MVPFeedsRefreshUIState refreshState;
        int source;
        Intrinsics.checkNotNullParameter(pullToRefreshState, "pullToRefreshState");
        MVPFeedsUIState mVPFeedsUIState = (MVPFeedsUIState) this.uiStateFlow.getValue();
        boolean z16 = true;
        if (!mVPFeedsUIState.getRefreshState().getRefreshType().getRefreshing()) {
            QLog.i(this.TAG, 1, "onRefreshStateChanged do nothing " + mVPFeedsUIState);
            return;
        }
        if (!pullToRefreshState.getSuccess().d()) {
            com.tencent.mobileqq.guild.util.qqui.g.c(1, R.string.f152851ai);
        }
        MVPFeedsUIState mVPFeedsUIState2 = (MVPFeedsUIState) this.uiStateFlow.getValue();
        MutableStateFlow mutableStateFlow = this.uiStateFlow;
        boolean isCompleted = pullToRefreshState.getIsCompleted();
        ri1.a success = pullToRefreshState.getSuccess();
        if (isCompleted) {
            MVPFeedsRefreshUIState refreshState2 = mVPFeedsUIState2.getRefreshState();
            if (mVPFeedsUIState2.getListState().getSource() != 0) {
                z16 = false;
            }
            k.RefreshFinish refreshFinish = new k.RefreshFinish(z16);
            boolean isEnd = pullToRefreshState.getIsEnd();
            String endMsg = pullToRefreshState.getEndMsg();
            if (endMsg == null) {
                endMsg = mVPFeedsUIState2.getRefreshState().getEndMsg();
            }
            refreshState = MVPFeedsRefreshUIState.c(refreshState2, null, refreshFinish, isEnd, endMsg, 1, null);
        } else {
            refreshState = mVPFeedsUIState2.getRefreshState();
        }
        MVPFeedsRefreshUIState mVPFeedsRefreshUIState = refreshState;
        MVPFeedsListUIState listState = mVPFeedsUIState2.getListState();
        if (isCompleted) {
            source = 2;
        } else {
            source = mVPFeedsUIState2.getListState().getSource();
        }
        int i3 = source;
        List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list = this.viewModelList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((com.tencent.mobileqq.guild.discoveryv2.content.model.f) it.next()).i());
        }
        MVPFeedsUIState c16 = MVPFeedsUIState.c(mVPFeedsUIState2, success, mVPFeedsRefreshUIState, MVPFeedsListUIState.c(listState, i3, arrayList, 0L, 4, null), false, 8, null);
        QLog.d(this.TAG, 4, "updateUIState " + c16);
        mutableStateFlow.setValue(c16);
        View rootView = getPartRootView();
        if (rootView != null) {
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            rootView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart$onRefreshStateChanged$lambda$18$$inlined$postDelayed$1
                @Override // java.lang.Runnable
                public final void run() {
                    MVPFeedsDataPart mVPFeedsDataPart = MVPFeedsDataPart.this;
                    String TAG = mVPFeedsDataPart.getTAG();
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    mVPFeedsDataPart.broadcastMessage("message_scroll_to_top_position", new ContentMessage.ScrollToPositionMessage(0, TAG));
                }
            }, 100L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, Reflection.getOrCreateKotlinClass(MVPFeedsUIState.class).getQualifiedName())) {
            return this.uiStateFlow;
        }
        if (Intrinsics.areEqual(action, Reflection.getOrCreateKotlinClass(LastFetchFeedTime.class).getQualifiedName())) {
            return this.lastFetchFeedsTimeFlow;
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "message_pull_to_refresh")) {
            I9(args);
        } else if (Intrinsics.areEqual(action, "message_on_load_more")) {
            H9(args);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        QLog.i(this.TAG, 1, "onAccountChanged " + account);
        List<? extends com.tencent.mobileqq.guild.discoveryv2.content.model.f> list = this.viewModelList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.discoveryv2.content.model.f) it.next()).onAccountChanged(account);
        }
        MutableStateFlow mutableStateFlow = this.uiStateFlow;
        MVPFeedsUIState a16 = MVPFeedsUIState.INSTANCE.a();
        QLog.d(this.TAG, 4, "updateUIState " + a16);
        mutableStateFlow.setValue(a16);
        I9(new ContentMessage.PullToRefreshMessage(PullToRefreshType.TYPE_ACCOUNT_CHANGED_AND_SWITCH_ACCOUNT, ""));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        List<com.tencent.mobileqq.guild.discoveryv2.content.model.f> J9 = J9();
        this.viewModelList = J9;
        if (J9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelList");
            J9 = null;
        }
        Iterator<T> it = J9.iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.guild.discoveryv2.content.model.f) it.next()).D0(x9().getMessage());
        }
        K9();
        F9();
        AccountChangedNotifier.f214789d.a(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        AccountChangedNotifier.f214789d.d(this);
    }
}
