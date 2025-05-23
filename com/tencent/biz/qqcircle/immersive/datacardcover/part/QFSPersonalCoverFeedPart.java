package com.tencent.biz.qqcircle.immersive.datacardcover.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverPublishingItemView;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta$StFeed;
import g40.a;
import h40.QFSPersonalCoverFeedInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u0001:\u0001:B\u000f\u0012\u0006\u00106\u001a\u00020\u0016\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u001e\u0010\u001b\u001a\u00020\u00022\u0014\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e0\u0018H\u0002J\u0018\u0010\u001d\u001a\u00020\u00022\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000eH\u0002J\u001a\u0010!\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R#\u00100\u001a\n +*\u0004\u0018\u00010*0*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R#\u00105\u001a\n +*\u0004\u0018\u000101018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104\u00a8\u0006;"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/part/QFSPersonalCoverFeedPart;", "Lcom/tencent/biz/richframework/part/BlockPart;", "", "V9", "Landroid/os/Bundle;", "K9", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "X9", "T9", "initViewModel", "Lh40/a;", "info", "N9", "", "publishData", "M9", "feedsData", "U9", "I9", "F9", "H9", "", "G9", "Lcom/tencent/richframework/data/base/UIStateData;", "Le30/b;", "data", "P9", "feedBlockData", "O9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", "mRootView", "onInitView", "onPartPause", "Lg40/a;", "d", "Lg40/a;", "adapter", "Lj40/b;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "J9", "()Lj40/b;", "feedViewModel", "Lj40/d;", "f", "L9", "()Lj40/d;", "publishViewModel", "peerBlockFindViewId", "<init>", "(I)V", tl.h.F, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverFeedPart extends BlockPart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private g40.a adapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy publishViewModel;

    public QFSPersonalCoverFeedPart(int i3) {
        super(i3, null, 2, 3);
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<j40.b>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverFeedPart$feedViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final j40.b invoke() {
                QFSPersonalCoverFeedPart qFSPersonalCoverFeedPart = QFSPersonalCoverFeedPart.this;
                return (j40.b) qFSPersonalCoverFeedPart.getViewModel(qFSPersonalCoverFeedPart.getPartHost(), null, j40.b.class);
            }
        });
        this.feedViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<j40.d>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverFeedPart$publishViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final j40.d invoke() {
                QFSPersonalCoverFeedPart qFSPersonalCoverFeedPart = QFSPersonalCoverFeedPart.this;
                return (j40.d) qFSPersonalCoverFeedPart.getViewModel(qFSPersonalCoverFeedPart.getPartHost(), null, j40.d.class);
            }
        });
        this.publishViewModel = lazy2;
    }

    private final List<QFSPersonalCoverFeedInfo> F9() {
        ArrayList arrayList = new ArrayList();
        int G9 = G9();
        g40.a aVar = this.adapter;
        g40.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        int size = aVar.getDataList().size();
        QLog.d("QFSPersonalCoverFeedPart", 1, "findFeedsData, firstFeedItemPos: " + G9 + ", adapterDataSize: " + size);
        if (G9 != -1 && G9 < size) {
            g40.a aVar3 = this.adapter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                aVar2 = aVar3;
            }
            arrayList.addAll(aVar2.getDataList().subList(G9, size));
        }
        return arrayList;
    }

    private final int G9() {
        boolean z16;
        g40.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        List<QFSPersonalCoverFeedInfo> dataList = aVar.getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "adapter.dataList");
        Iterator<QFSPersonalCoverFeedInfo> it = dataList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().getItemType() == 100001) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                i3++;
            } else {
                return i3;
            }
        }
        return -1;
    }

    private final List<QFSPersonalCoverFeedInfo> H9() {
        ArrayList arrayList = new ArrayList();
        int G9 = G9();
        g40.a aVar = this.adapter;
        g40.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        int size = aVar.getDataList().size();
        QLog.d("QFSPersonalCoverFeedPart", 1, "findPublishData, firstFeedItemPos: " + G9 + ", adapterDataSize: " + size);
        if (G9 == -1 && size > 1) {
            g40.a aVar3 = this.adapter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                aVar2 = aVar3;
            }
            arrayList.addAll(aVar2.getDataList().subList(1, size));
        } else if (G9 > 1) {
            g40.a aVar4 = this.adapter;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                aVar2 = aVar4;
            }
            arrayList.addAll(aVar2.getDataList().subList(1, G9));
        }
        return arrayList;
    }

    private final QFSPersonalCoverFeedInfo I9() {
        return QFSPersonalCoverFeedInfo.INSTANCE.c();
    }

    private final j40.b J9() {
        return (j40.b) this.feedViewModel.getValue();
    }

    private final Bundle K9() {
        Serializable serializable;
        HashMap<String, String> schemeAttrs;
        Intent intent;
        Activity activity = getActivity();
        QCircleInitBean qCircleInitBean = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QCircleInitBean) {
            qCircleInitBean = (QCircleInitBean) serializable;
        }
        Bundle bundle = new Bundle();
        if (qCircleInitBean != null && (schemeAttrs = qCircleInitBean.getSchemeAttrs()) != null) {
            bundle.putSerializable("key_bundle_common_init_bean", schemeAttrs);
        }
        return bundle;
    }

    private final j40.d L9() {
        return (j40.d) this.publishViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(List<QFSPersonalCoverFeedInfo> publishData) {
        QLog.d("QFSPersonalCoverFeedPart", 1, "handlePublishData, dataSize: " + publishData.size());
        g40.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        aVar.setDatas(U9(publishData, F9()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(QFSPersonalCoverFeedInfo info) {
        QFSPersonalCoverPublishingItemView publishingItemView;
        TaskInfo taskInfo = info.getTaskInfo();
        if (taskInfo != null) {
            long taskId = taskInfo.getTaskId();
            g40.a aVar = this.adapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                aVar = null;
            }
            a.e eVar = aVar.i0().get(Long.valueOf(taskId));
            if (eVar != null && (publishingItemView = eVar.getPublishingItemView()) != null) {
                publishingItemView.o0(info);
            }
        }
    }

    private final void O9(List<e30.b> feedBlockData) {
        if (feedBlockData == null) {
            return;
        }
        QLog.d("QFSPersonalCoverFeedPart", 1, "handleSuccess, dataSize:" + feedBlockData.size());
        ArrayList arrayList = new ArrayList();
        for (e30.b bVar : feedBlockData) {
            QFSPersonalCoverFeedInfo.Companion companion = QFSPersonalCoverFeedInfo.INSTANCE;
            FeedCloudMeta$StFeed g16 = bVar.g();
            Intrinsics.checkNotNullExpressionValue(g16, "it.sourceData");
            arrayList.add(companion.a(g16));
        }
        g40.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        aVar.setDatas(U9(H9(), arrayList));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(UIStateData<List<e30.b>> data) {
        Object obj;
        int state = data.getState();
        boolean isLoadMore = data.getIsLoadMore();
        boolean isFinish = data.getIsFinish();
        List<e30.b> data2 = data.getData();
        if (data2 != null) {
            obj = Integer.valueOf(data2.size());
        } else {
            obj = "-1";
        }
        QLog.d("QFSPersonalCoverFeedPart", 1, "handleUIStateData, state: " + state + ", isLoadMore: " + isLoadMore + ", isFinish: " + isFinish + ", dataSize: " + obj);
        boolean isFinish2 = data.getIsFinish();
        int state2 = data.getState();
        boolean z16 = false;
        if (state2 != 1) {
            if (state2 != 2) {
                if (state2 == 3) {
                    O9(data.getData());
                }
                z16 = true;
            } else {
                O9(data.getData());
            }
        }
        g40.a aVar = this.adapter;
        g40.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        aVar.getLoadInfo().setFinish(isFinish2);
        if (z16) {
            g40.a aVar3 = this.adapter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                aVar2 = aVar3;
            }
            aVar2.notifyLoadingComplete(true, isFinish2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void T9() {
        QLog.d("QFSPersonalCoverFeedPart", 1, "loadMoreData ");
        J9().O1();
    }

    private final List<QFSPersonalCoverFeedInfo> U9(List<QFSPersonalCoverFeedInfo> publishData, List<QFSPersonalCoverFeedInfo> feedsData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(I9());
        arrayList.addAll(publishData);
        arrayList.addAll(feedsData);
        return arrayList;
    }

    private final void V9() {
        g40.a aVar = new g40.a(K9());
        this.adapter = aVar;
        aVar.setOnLoadDataDelegate(new MultiViewBlock.OnLoadDataDelegate() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.d
            @Override // com.tencent.biz.richframework.part.block.MultiViewBlock.OnLoadDataDelegate
            public final void onLoadData(LoadInfo loadInfo, Object obj) {
                QFSPersonalCoverFeedPart.W9(QFSPersonalCoverFeedPart.this, loadInfo, obj);
            }
        });
        getPeerBlocks().add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(QFSPersonalCoverFeedPart this$0, LoadInfo loadInfo, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSPersonalCoverFeedPart", 1, "prepareAdapters, loadInfo: " + loadInfo);
        if (loadInfo.isInitState()) {
            this$0.X9(true);
        } else if (loadInfo.isLoadMoreState()) {
            this$0.T9();
        } else if (loadInfo.isRefreshState()) {
            this$0.X9(false);
        }
    }

    private final void X9(boolean first) {
        QLog.d("QFSPersonalCoverFeedPart", 1, "refreshData, first:" + first);
        J9().Q1(first);
    }

    private final void initViewModel() {
        LiveData<UIStateData<List<e30.b>>> M1 = J9().M1();
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<List<? extends e30.b>>, Unit> function1 = new Function1<UIStateData<List<? extends e30.b>>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverFeedPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends e30.b>> uIStateData) {
                invoke2((UIStateData<List<e30.b>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<e30.b>> it) {
                QFSPersonalCoverFeedPart qFSPersonalCoverFeedPart = QFSPersonalCoverFeedPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qFSPersonalCoverFeedPart.P9(it);
            }
        };
        M1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalCoverFeedPart.Q9(Function1.this, obj);
            }
        });
        LiveData<List<QFSPersonalCoverFeedInfo>> R1 = L9().R1();
        Fragment hostFragment2 = getHostFragment();
        final Function1<List<? extends QFSPersonalCoverFeedInfo>, Unit> function12 = new Function1<List<? extends QFSPersonalCoverFeedInfo>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverFeedPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QFSPersonalCoverFeedInfo> list) {
                invoke2((List<QFSPersonalCoverFeedInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<QFSPersonalCoverFeedInfo> it) {
                QFSPersonalCoverFeedPart qFSPersonalCoverFeedPart = QFSPersonalCoverFeedPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qFSPersonalCoverFeedPart.M9(it);
            }
        };
        R1.observe(hostFragment2, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalCoverFeedPart.R9(Function1.this, obj);
            }
        });
        LiveData<QFSPersonalCoverFeedInfo> S1 = L9().S1();
        Fragment hostFragment3 = getHostFragment();
        final Function1<QFSPersonalCoverFeedInfo, Unit> function13 = new Function1<QFSPersonalCoverFeedInfo, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverFeedPart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QFSPersonalCoverFeedInfo qFSPersonalCoverFeedInfo) {
                invoke2(qFSPersonalCoverFeedInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QFSPersonalCoverFeedInfo it) {
                QFSPersonalCoverFeedPart qFSPersonalCoverFeedPart = QFSPersonalCoverFeedPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qFSPersonalCoverFeedPart.N9(it);
            }
        };
        S1.observe(hostFragment3, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalCoverFeedPart.S9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View mRootView) {
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        super.onInitView(mRootView);
        BlockContainer blockContainer = this.mBlockContainer;
        blockContainer.setEnableRefresh(false);
        blockContainer.setEnableLoadMore(true);
        blockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        V9();
    }

    @Override // com.tencent.biz.richframework.part.BlockPart, com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        i40.b bVar = i40.b.f407181a;
        g40.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        bVar.c(aVar.getDataList().size());
    }
}
