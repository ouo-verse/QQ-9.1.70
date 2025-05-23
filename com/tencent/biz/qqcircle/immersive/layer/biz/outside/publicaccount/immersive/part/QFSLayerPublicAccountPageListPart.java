package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.QFSPublicAccountLayerPageListViewModel;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.model.QFSPublicAccountStaggeredItemCommentHelper;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerPositiveActionCollector;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.b;
import com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0018\u0010\n\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0018\u00010\u0007H\u0002J\u0014\u0010\u000e\u001a\u00020\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0014J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/immersive/part/QFSLayerPublicAccountPageListPart;", "Lcom/tencent/biz/qqcircle/immersive/layer/base/QFSLayerBaseMiddleListPart;", "", com.tencent.luggage.wxa.c8.c.G, "", "S9", "Q9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "listUIStateData", "", "U9", "", "X9", "V9", "P9", "getLogTag", "getViewModelKey", "getFeedSourceType", "notifyCurrentFeedChange", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "Lcom/tencent/richframework/data/idata/IDataDisplaySurface;", "getViewModelSurface", "Lcom/tencent/biz/qqcircle/immersive/layer/base/e;", "H9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "enableProtocolCache", WebViewPlugin.KEY_REQUEST, "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getInitBean", "isContainerOnScreen", "onPartDestroy", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;", "layerBean", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/immersive/QFSPublicAccountLayerPageListViewModel;", "e", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/immersive/QFSPublicAccountLayerPageListViewModel;", "defaultViewModel", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/b;", "f", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/repo/b;", "positiveActionCollector", "<init>", "(Lcom/tencent/biz/qqcircle/beans/QCircleLayerBean;)V", tl.h.F, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSLayerPublicAccountPageListPart extends QFSLayerBaseMiddleListPart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleLayerBean layerBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QFSPublicAccountLayerPageListViewModel defaultViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.b positiveActionCollector;

    public QFSLayerPublicAccountPageListPart(@NotNull QCircleLayerBean layerBean) {
        Intrinsics.checkNotNullParameter(layerBean, "layerBean");
        this.layerBean = layerBean;
        this.positiveActionCollector = new com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.b();
    }

    private final void P9() {
        m mVar = this.mLayerPageAdapter;
        if (mVar != null && mVar.getDataList() != null) {
            for (e30.b bVar : this.mLayerPageAdapter.getDataList()) {
                if (bVar.g() != null && bVar.g().type.get() == 2) {
                    w20.a.j().t(bVar.g().f398449id.get(), 0);
                }
            }
        }
    }

    private final int Q9() {
        QCircleExtraTypeInfo qCircleExtraTypeInfo;
        QCircleInitBean qCircleInitBean = QCirclePluginUtil.getQCircleInitBean(getContext());
        if (qCircleInitBean != null) {
            qCircleExtraTypeInfo = qCircleInitBean.getExtraTypeInfo();
        } else {
            qCircleExtraTypeInfo = null;
        }
        if (qCircleExtraTypeInfo == null) {
            return 0;
        }
        int i3 = qCircleInitBean.getExtraTypeInfo().sourceType;
        QLog.d(getTAG(), 1, "getPanelSource  source = " + i3);
        if (i3 != 60) {
            if (i3 != 1002) {
                return 0;
            }
            return 10;
        }
        return 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QFSLayerPublicAccountPageListPart this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.U9(uIStateData)) {
            this$0.Q9(uIStateData);
        }
    }

    private final void S9(int pos) {
        Object orNull;
        if (pos == 0 && getFeedList() != null) {
            List<e30.b> feedList = getFeedList();
            Intrinsics.checkNotNullExpressionValue(feedList, "feedList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(feedList, pos);
            e30.b bVar = (e30.b) orNull;
            if (bVar == null) {
                return;
            }
            QFSPublicAccountStaggeredItemCommentHelper qFSPublicAccountStaggeredItemCommentHelper = QFSPublicAccountStaggeredItemCommentHelper.f86870a;
            if (!qFSPublicAccountStaggeredItemCommentHelper.f(this.layerBean, bVar)) {
                QLog.i(getTAG(), 2, "Needn't auto open panel.");
                return;
            }
            final QFSCommentInfo a16 = qFSPublicAccountStaggeredItemCommentHelper.a(bVar, Q9());
            if (a16 == null) {
                QLog.e(getTAG(), 2, "buildCommentInfo invalid.");
                return;
            }
            QCircleInitBean.QCircleActionBean actionBean = this.layerBean.getActionBean();
            if (actionBean != null) {
                actionBean.mShowCommentPanel = false;
            }
            QLog.i(getTAG(), 1, "Ready send comment_panel_show msg.");
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.b
                @Override // java.lang.Runnable
                public final void run() {
                    QFSLayerPublicAccountPageListPart.T9(QFSLayerPublicAccountPageListPart.this, a16);
                }
            }, uq3.c.I0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(QFSLayerPublicAccountPageListPart this$0, QFSCommentInfo qFSCommentInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("comment_panel_show", qFSCommentInfo);
    }

    private final boolean U9(UIStateData<List<e30.b>> listUIStateData) {
        boolean z16;
        List<e30.b> mutableList;
        if (listUIStateData == null || listUIStateData.getState() != 8) {
            return false;
        }
        int pos = listUIStateData.getPos();
        List<e30.b> data = listUIStateData.getData();
        String str = null;
        if (this.mCurrentFeedPos < pos) {
            List<e30.b> list = data;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                List<e30.b> oldList = getFeedList();
                Intrinsics.checkNotNullExpressionValue(oldList, "oldList");
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) oldList);
                mutableList.addAll(pos, list);
                QLog.i("QFSPublicAccountPositiveAction_ListPart", 1, "forceInsert succeed, toBeInsertData=" + X9(data) + " old=" + X9(oldList) + " new=" + X9(mutableList) + " ");
                this.mLayerPageAdapter.I0(mutableList, false, null);
                return true;
            }
        }
        if (data != null) {
            str = X9(data);
        }
        QLog.i("QFSPublicAccountPositiveAction_ListPart", 1, "ignore this force insert, toBeInsertData=" + str);
        return true;
    }

    private final void V9() {
        this.mLayerPageContainer.setActionDownEventListener(new QFSPageTurnContainer.g() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.c
            @Override // com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.g
            public final boolean a() {
                boolean W9;
                W9 = QFSLayerPublicAccountPageListPart.W9(QFSLayerPublicAccountPageListPart.this);
                return W9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean W9(QFSLayerPublicAccountPageListPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("layer_notify_part_action_down", null);
        return false;
    }

    private final String X9(List<e30.b> list) {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<e30.b, CharSequence>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.QFSLayerPublicAccountPageListPart$toPrintText$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@Nullable e30.b bVar) {
                FeedCloudMeta$StFeed g16;
                PBStringField pBStringField;
                String str = (bVar == null || (g16 = bVar.g()) == null || (pBStringField = g16.f398449id) == null) ? null : pBStringField.get();
                return str == null ? "" : str;
            }
        }, 31, null);
        return joinToString$default;
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart
    @NotNull
    protected com.tencent.biz.qqcircle.immersive.layer.base.e H9() {
        QFSPublicAccountLayerPageListViewModel qFSPublicAccountLayerPageListViewModel = this.defaultViewModel;
        if (qFSPublicAccountLayerPageListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultViewModel");
            return null;
        }
        return qFSPublicAccountLayerPageListViewModel;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.c
    public int getFeedSourceType() {
        if (com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.f(getMInitBean())) {
            return 82;
        }
        return super.getFeedSourceType();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    @NotNull
    /* renamed from: getInitBean */
    public QCircleInitBean getMInitBean() {
        return this.layerBean;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPublicAccountPageListPart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    @NotNull
    public String getViewModelKey() {
        return "QFSLayerPublicAccountPageListPart" + hashCode();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    @NotNull
    protected IDataDisplaySurface<e30.b> getViewModelSurface() {
        ViewModel viewModel = getViewModel(QFSPublicAccountLayerPageListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QFSPublicAc\u2026istViewModel::class.java)");
        QFSPublicAccountLayerPageListViewModel qFSPublicAccountLayerPageListViewModel = (QFSPublicAccountLayerPageListViewModel) viewModel;
        this.defaultViewModel = qFSPublicAccountLayerPageListViewModel;
        if (qFSPublicAccountLayerPageListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultViewModel");
            qFSPublicAccountLayerPageListViewModel = null;
        }
        qFSPublicAccountLayerPageListViewModel.j().observe(getHostFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSLayerPublicAccountPageListPart.R9(QFSLayerPublicAccountPageListPart.this, (UIStateData) obj);
            }
        });
        I9();
        QFSPublicAccountLayerPageListViewModel qFSPublicAccountLayerPageListViewModel2 = this.defaultViewModel;
        if (qFSPublicAccountLayerPageListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultViewModel");
            return null;
        }
        return qFSPublicAccountLayerPageListViewModel2;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, t40.a
    public boolean isContainerOnScreen() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void notifyCurrentFeedChange(int pos) {
        Object orNull;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        super.notifyCurrentFeedChange(pos);
        List<e30.b> feedList = getFeedList();
        Intrinsics.checkNotNullExpressionValue(feedList, "feedList");
        orNull = CollectionsKt___CollectionsKt.getOrNull(feedList, this.mCurrentFeedPos);
        e30.b bVar = (e30.b) orNull;
        if (bVar != null) {
            feedCloudMeta$StFeed = bVar.g();
        } else {
            feedCloudMeta$StFeed = null;
        }
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        this.positiveActionCollector.h(feedCloudMeta$StFeed, this.mCurrentFeedPos);
        S9(pos);
    }

    @Override // com.tencent.biz.qqcircle.immersive.layer.base.QFSLayerBaseMiddleListPart, com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        V9();
        E9();
        boolean b16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.c.b(getMInitBean());
        QLog.d(getTAG(), 1, "initFetch needAutoRefresh=" + b16);
        if (b16) {
            this.mLayerPageContainer.g();
        } else {
            requestData(true, false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        P9();
        QFSPublicAccountStaggerPositiveActionCollector.f86891a.d(getMInitBean());
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.positiveActionCollector.f();
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart, com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        this.positiveActionCollector.e(new Function1<b.PositiveAction, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.immersive.part.QFSLayerPublicAccountPageListPart$onPartResume$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b.PositiveAction positiveAction) {
                invoke2(positiveAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull b.PositiveAction positiveAction) {
                m mVar;
                int collectionSizeOrDefault;
                QFSPublicAccountLayerPageListViewModel qFSPublicAccountLayerPageListViewModel;
                Intrinsics.checkNotNullParameter(positiveAction, "positiveAction");
                mVar = ((QFSLayerBasePart) QFSLayerPublicAccountPageListPart.this).mLayerPageAdapter;
                List<e30.b> dataList = mVar.getDataList();
                Intrinsics.checkNotNullExpressionValue(dataList, "mLayerPageAdapter.dataList");
                List<e30.b> list = dataList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((e30.b) it.next()).g().f398449id.get());
                }
                qFSPublicAccountLayerPageListViewModel = QFSLayerPublicAccountPageListPart.this.defaultViewModel;
                if (qFSPublicAccountLayerPageListViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defaultViewModel");
                    qFSPublicAccountLayerPageListViewModel = null;
                }
                qFSPublicAccountLayerPageListViewModel.A2(positiveAction.getActionType(), positiveAction.getPos(), positiveAction.getFeed(), arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart
    public void requestData(boolean isLoadMore, boolean enableProtocolCache) {
        String tag = getTAG();
        QFSPublicAccountLayerPageListViewModel qFSPublicAccountLayerPageListViewModel = this.defaultViewModel;
        QFSPublicAccountLayerPageListViewModel qFSPublicAccountLayerPageListViewModel2 = null;
        if (qFSPublicAccountLayerPageListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultViewModel");
            qFSPublicAccountLayerPageListViewModel = null;
        }
        QLog.d(tag, 1, "requestData  isLoadMore: " + isLoadMore + ", enableProtocolCache: " + enableProtocolCache + ", attachInfo: " + qFSPublicAccountLayerPageListViewModel.P1().getStringAttachInfo());
        QFSPublicAccountLayerPageListViewModel qFSPublicAccountLayerPageListViewModel3 = this.defaultViewModel;
        if (qFSPublicAccountLayerPageListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultViewModel");
        } else {
            qFSPublicAccountLayerPageListViewModel2 = qFSPublicAccountLayerPageListViewModel3;
        }
        qFSPublicAccountLayerPageListViewModel2.y2(this.layerBean, !isLoadMore);
    }
}
