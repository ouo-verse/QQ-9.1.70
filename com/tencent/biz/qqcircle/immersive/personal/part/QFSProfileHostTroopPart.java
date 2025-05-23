package com.tencent.biz.qqcircle.immersive.personal.part;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QFSPersonalGroupInfoInitBean;
import com.tencent.biz.qqcircle.immersive.personal.data.QFSTroopItemInfo;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSProfileTroopViewModel;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.TroopRequestType;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.data.base.UIStateData;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u00020;\u0018\u0000 A2\u00020\u0001:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J \u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R#\u0010:\u001a\n 5*\u0004\u0018\u000104048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/part/QFSProfileHostTroopPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "J9", "Lcom/tencent/biz/qqcircle/immersive/personal/data/o;", "info", "", "position", "M9", "H9", "N9", "", "data", "Q9", "O9", "showErrorView", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "", "title", "desc", "P9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/qqcircle/beans/QFSPersonalGroupInfoInitBean;", "d", "Lcom/tencent/biz/qqcircle/beans/QFSPersonalGroupInfoInitBean;", "initBean", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "hintViewContainer", "Lcom/tencent/biz/qqcircle/widgets/QCirclePanelLoadingView;", "f", "Lcom/tencent/biz/qqcircle/widgets/QCirclePanelLoadingView;", "loadingView", "Landroidx/recyclerview/widget/RecyclerView;", tl.h.F, "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lcom/tencent/biz/qqcircle/immersive/personal/adapter/r;", "i", "Lcom/tencent/biz/qqcircle/immersive/personal/adapter/r;", "troopAdapter", "com/tencent/biz/qqcircle/immersive/personal/part/QFSProfileHostTroopPart$c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/personal/part/QFSProfileHostTroopPart$c;", "onScrollListener", "Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/QFSProfileTroopViewModel;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "I9", "()Lcom/tencent/biz/qqcircle/immersive/personal/viewmodel/QFSProfileTroopViewModel;", "viewModel", "com/tencent/biz/qqcircle/immersive/personal/part/QFSProfileHostTroopPart$b", "D", "Lcom/tencent/biz/qqcircle/immersive/personal/part/QFSProfileHostTroopPart$b;", "dataObserver", "<init>", "()V", "E", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSProfileHostTroopPart extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b dataObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPersonalGroupInfoInitBean initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout hintViewContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCirclePanelLoadingView loadingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recycleView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.personal.adapter.r troopAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c onScrollListener = new c();

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/part/QFSProfileHostTroopPart$b", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "", "fromPosition", "toPosition", "itemCount", "", "onItemRangeMoved", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends RecyclerView.AdapterDataObserver {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
            RecyclerView recyclerView;
            super.onItemRangeMoved(fromPosition, toPosition, itemCount);
            if (fromPosition == 0 && (recyclerView = QFSProfileHostTroopPart.this.recycleView) != null) {
                recyclerView.scrollToPosition(0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/personal/part/QFSProfileHostTroopPart$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    public QFSProfileHostTroopPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSProfileTroopViewModel>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSProfileHostTroopPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QFSProfileTroopViewModel invoke() {
                return (QFSProfileTroopViewModel) QFSProfileHostTroopPart.this.getViewModel(QFSProfileTroopViewModel.class);
            }
        });
        this.viewModel = lazy;
        this.dataObserver = new b();
    }

    private final void H9(QFSTroopItemInfo info) {
        info.o(!info.getIsBound());
        com.tencent.biz.qqcircle.immersive.personal.adapter.r rVar = this.troopAdapter;
        if (rVar != null) {
            rVar.r0(info);
        }
        QFSProfileTroopViewModel viewModel = I9();
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        QFSProfileTroopViewModel.a2(viewModel, info, TroopRequestType.PROFILE_HOST, null, 4, null);
    }

    private final QFSProfileTroopViewModel I9() {
        return (QFSProfileTroopViewModel) this.viewModel.getValue();
    }

    private final void J9() {
        LiveData<UIStateData<List<QFSTroopItemInfo>>> g26 = I9().g2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends QFSTroopItemInfo>>, Unit> function1 = new Function1<UIStateData<List<? extends QFSTroopItemInfo>>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSProfileHostTroopPart$initObservers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends QFSTroopItemInfo>> uIStateData) {
                invoke2((UIStateData<List<QFSTroopItemInfo>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<QFSTroopItemInfo>> uIStateData) {
                QCirclePanelLoadingView qCirclePanelLoadingView;
                int state = uIStateData.getState();
                if (state == 0) {
                    QFSProfileHostTroopPart.this.O9();
                    return;
                }
                if (state == 1) {
                    qCirclePanelLoadingView = QFSProfileHostTroopPart.this.loadingView;
                    if (qCirclePanelLoadingView != null) {
                        qCirclePanelLoadingView.n0();
                        return;
                    }
                    return;
                }
                if (state != 2 && state != 3) {
                    if (state != 4) {
                        return;
                    }
                    QFSProfileHostTroopPart.this.showErrorView();
                } else {
                    QFSProfileHostTroopPart qFSProfileHostTroopPart = QFSProfileHostTroopPart.this;
                    List<QFSTroopItemInfo> data = uIStateData.getData();
                    Intrinsics.checkNotNullExpressionValue(data, "uiState.data");
                    qFSProfileHostTroopPart.Q9(data);
                }
            }
        };
        g26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSProfileHostTroopPart.K9(Function1.this, obj);
            }
        });
        LiveData<Pair<String, QFSTroopItemInfo>> e26 = I9().e2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Pair<? extends String, ? extends QFSTroopItemInfo>, Unit> function12 = new Function1<Pair<? extends String, ? extends QFSTroopItemInfo>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.QFSProfileHostTroopPart$initObservers$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends QFSTroopItemInfo> pair) {
                invoke2((Pair<String, QFSTroopItemInfo>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, QFSTroopItemInfo> pair) {
                boolean isBlank;
                com.tencent.biz.qqcircle.immersive.personal.adapter.r rVar;
                String first = pair.getFirst();
                QLog.d("QFSProfileHostTroopPart", 1, "[doChangeTroopBound] errMsg=" + first);
                isBlank = StringsKt__StringsJVMKt.isBlank(first);
                if (!isBlank) {
                    QFSTroopItemInfo second = pair.getSecond();
                    second.o(!second.getIsBound());
                    rVar = QFSProfileHostTroopPart.this.troopAdapter;
                    if (rVar != null) {
                        rVar.r0(second);
                    }
                    QCircleToast.v(QCircleToast.f91645e, "\u7ed1\u5b9a\u5931\u8d25", 0);
                }
            }
        };
        e26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.personal.part.au
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSProfileHostTroopPart.L9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M9(QFSTroopItemInfo info, int position) {
        QLog.d("QFSProfileHostTroopPart", 1, "[onTroopItemButtonClick] name=" + info.getName() + ", id=" + info.getId() + ", position=" + position);
        if (info.getIsBound()) {
            H9(info);
        } else {
            if (I9().U1()) {
                H9(info);
                return;
            }
            String string = RFWApplication.getApplication().getString(R.string.f188393wk, Integer.valueOf(I9().getMaxAllowBindCount()));
            Intrinsics.checkNotNullExpressionValue(string, "getApplication().getStri\u2026l.getMaxAllowBindCount())");
            QCircleToast.l(QCircleToast.f91644d, string, 0, false, false);
        }
    }

    private final void N9() {
        String account;
        String str;
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean = this.initBean;
        if (qFSPersonalGroupInfoInitBean == null || (account = qFSPersonalGroupInfoInitBean.getHostUin()) == null) {
            account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        }
        String uin = account;
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean2 = this.initBean;
        if (qFSPersonalGroupInfoInitBean2 != null) {
            str = qFSPersonalGroupInfoInitBean2.getHostUin();
        } else {
            str = null;
        }
        QLog.d("QFSProfileHostTroopPart", 1, "[requestData] bean uin=" + str + ", uin=" + uin);
        QFSProfileTroopViewModel viewModel = I9();
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        QFSProfileTroopViewModel.d2(viewModel, uin, TroopRequestType.PROFILE_HOST, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9() {
        String title = com.tencent.biz.qqcircle.utils.h.a(R.string.f1928248j);
        String desc = com.tencent.biz.qqcircle.utils.h.a(R.string.f1928348k);
        Intrinsics.checkNotNullExpressionValue(title, "title");
        Intrinsics.checkNotNullExpressionValue(desc, "desc");
        P9(16, title, desc);
    }

    private final void P9(int imageType, String title, String desc) {
        QCirclePanelLoadingView qCirclePanelLoadingView = this.loadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(imageType).setTitle(title).setDesc(desc).setBackgroundColorType(0).build();
        FrameLayout frameLayout = this.hintViewContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(build);
            frameLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(List<QFSTroopItemInfo> data) {
        QLog.d("QFSProfileHostTroopPart", 1, "[showTroops] size=" + data.size());
        QCirclePanelLoadingView qCirclePanelLoadingView = this.loadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.k0();
        }
        FrameLayout frameLayout = this.hintViewContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        com.tencent.biz.qqcircle.immersive.personal.adapter.r rVar = this.troopAdapter;
        if (rVar != null) {
            rVar.setData(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorView() {
        String str;
        String str2;
        String[] f16 = cu.f(com.tencent.biz.qqcircle.utils.h.a(R.string.f184063kv), "\n");
        if (f16.length >= 2) {
            str = f16[0];
            Intrinsics.checkNotNullExpressionValue(str, "splitMsg[0]");
            str2 = f16[1];
            Intrinsics.checkNotNullExpressionValue(str2, "splitMsg[1]");
        } else {
            str = "\u65e0\u6cd5\u8fde\u63a5\u77ed\u89c6\u9891";
            str2 = "\u68c0\u67e5\u4e00\u4e0b\u7f51\u7edc\u518d\u8bd5\u5427";
        }
        P9(13, str, str2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        QCirclePanelLoadingView qCirclePanelLoadingView;
        RecyclerView recyclerView;
        Serializable serializable;
        Intent intent;
        super.onInitView(rootView);
        QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean = null;
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f487820x);
        } else {
            frameLayout = null;
        }
        this.hintViewContainer = frameLayout;
        if (rootView != null) {
            qCirclePanelLoadingView = (QCirclePanelLoadingView) rootView.findViewById(R.id.f487920y);
        } else {
            qCirclePanelLoadingView = null;
        }
        this.loadingView = qCirclePanelLoadingView;
        if (qCirclePanelLoadingView != null) {
            qCirclePanelLoadingView.setHintText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1918345v));
        }
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f487520u);
        } else {
            recyclerView = null;
        }
        this.recycleView = recyclerView;
        if (recyclerView != null) {
            com.tencent.biz.qqcircle.immersive.personal.adapter.r rVar = new com.tencent.biz.qqcircle.immersive.personal.adapter.r();
            this.troopAdapter = rVar;
            rVar.setHasStableIds(true);
            com.tencent.biz.qqcircle.immersive.personal.adapter.r rVar2 = this.troopAdapter;
            if (rVar2 != null) {
                rVar2.q0(new QFSProfileHostTroopPart$onInitView$1$1(this));
            }
            recyclerView.setAdapter(this.troopAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.addOnScrollListener(this.onScrollListener);
        }
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QFSPersonalGroupInfoInitBean) {
            qFSPersonalGroupInfoInitBean = (QFSPersonalGroupInfoInitBean) serializable;
        }
        this.initBean = qFSPersonalGroupInfoInitBean;
        J9();
        N9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        com.tencent.biz.qqcircle.immersive.personal.adapter.r rVar = this.troopAdapter;
        if (rVar != null) {
            rVar.unregisterAdapterDataObserver(this.dataObserver);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        com.tencent.biz.qqcircle.immersive.personal.adapter.r rVar = this.troopAdapter;
        if (rVar != null) {
            rVar.registerAdapterDataObserver(this.dataObserver);
        }
    }
}
