package com.tencent.biz.qqcircle.immersive.datacardcover.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.datacardcover.fragment.QFSPersonalCoverFeedFragment;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverHintView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import h40.QFSPersonalCoverFeedInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0007H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0006\u0010\u0019\u001a\u00020\u0004R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R#\u00102\u001a\n -*\u0004\u0018\u00010,0,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R#\u00107\u001a\n -*\u0004\u0018\u000103038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/part/QFSPersonalCoverHintPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getInitBean", "", "initViewModel", "I9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Le30/b;", "data", "K9", "J9", "", "errorMsg", "G9", "F9", "H9", "showLoadingView", "hideLoadingView", "L9", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "M9", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "flLoadingView", "e", "Landroid/view/View;", "loadingView", "f", "Ljava/lang/String;", "emptyText", "Landroid/view/animation/AlphaAnimation;", tl.h.F, "Landroid/view/animation/AlphaAnimation;", "loadingViewAnim", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverHintView;", "i", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverHintView;", "hintView", "Lj40/b;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "E9", "()Lj40/b;", "viewModel", "Lj40/d;", BdhLogUtil.LogTag.Tag_Conn, "D9", "()Lj40/d;", "publishViewModel", "<init>", "()V", "D", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverHintPart extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy publishViewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout flLoadingView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View loadingView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String emptyText = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AlphaAnimation loadingViewAnim;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QFSPersonalCoverHintView hintView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public QFSPersonalCoverHintPart() {
        Lazy lazy;
        Lazy lazy2;
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
        alphaAnimation.setRepeatMode(2);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setDuration(1000L);
        this.loadingViewAnim = alphaAnimation;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<j40.b>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverHintPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final j40.b invoke() {
                QFSPersonalCoverHintPart qFSPersonalCoverHintPart = QFSPersonalCoverHintPart.this;
                return (j40.b) qFSPersonalCoverHintPart.getViewModel(qFSPersonalCoverHintPart.getPartHost(), null, j40.b.class);
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<j40.d>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverHintPart$publishViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final j40.d invoke() {
                QFSPersonalCoverHintPart qFSPersonalCoverHintPart = QFSPersonalCoverHintPart.this;
                return (j40.d) qFSPersonalCoverHintPart.getViewModel(qFSPersonalCoverHintPart.getPartHost(), null, j40.d.class);
            }
        });
        this.publishViewModel = lazy2;
    }

    private final j40.d D9() {
        return (j40.d) this.publishViewModel.getValue();
    }

    private final j40.b E9() {
        return (j40.b) this.viewModel.getValue();
    }

    private final void F9() {
        QLog.d("QFSPersonalCoverHintPart", 1, "handleEmpty text = " + this.emptyText);
        QFSPersonalCoverHintView qFSPersonalCoverHintView = this.hintView;
        if (qFSPersonalCoverHintView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
            qFSPersonalCoverHintView = null;
        }
        qFSPersonalCoverHintView.B0(this.emptyText);
        hideLoadingView();
    }

    private final void G9(String errorMsg) {
        boolean z16 = true;
        QLog.d("QFSPersonalCoverHintPart", 1, "handleError, errorMsg: " + errorMsg);
        QFSPersonalCoverHintView qFSPersonalCoverHintView = this.hintView;
        if (qFSPersonalCoverHintView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
            qFSPersonalCoverHintView = null;
        }
        if (errorMsg != null && errorMsg.length() != 0) {
            z16 = false;
        }
        if (z16) {
            errorMsg = uq3.c.c4();
        }
        Intrinsics.checkNotNullExpressionValue(errorMsg, "if (errorMsg.isNullOrEmp\u2026ErrorText() else errorMsg");
        qFSPersonalCoverHintView.C0(errorMsg);
        hideLoadingView();
    }

    private final void H9() {
        QLog.d("QFSPersonalCoverHintPart", 1, "handleLoading ");
        showLoadingView();
        L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        J9();
    }

    private final void J9() {
        QLog.d("QFSPersonalCoverHintPart", 1, "handleSuccess ");
        hideLoadingView();
        L9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(UIStateData<List<e30.b>> data) {
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
        QLog.d("QFSPersonalCoverHintPart", 1, "handlerUIStateData, state: " + state + ", isLoadMore: " + isLoadMore + ", isFinish: " + isFinish + ", dataSize: " + obj);
        int state2 = data.getState();
        if (state2 != 0) {
            if (state2 != 1) {
                if (state2 != 2 && state2 != 3) {
                    if (state2 == 4) {
                        G9(data.getMsg());
                        return;
                    }
                    return;
                }
                J9();
                return;
            }
            H9();
            return;
        }
        F9();
    }

    private final void L9() {
        QFSPersonalCoverHintView qFSPersonalCoverHintView = this.hintView;
        if (qFSPersonalCoverHintView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
            qFSPersonalCoverHintView = null;
        }
        qFSPersonalCoverHintView.o0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QFSPersonalCoverHintPart this$0, HashMap hashMap, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i40.c cVar = i40.c.f407182a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        cVar.b(context, QFSPersonalCoverFeedFragment.INSTANCE.a(hashMap));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final QCircleInitBean getInitBean() {
        Serializable serializable;
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (!(serializable instanceof QCircleInitBean)) {
            return null;
        }
        return (QCircleInitBean) serializable;
    }

    private final void hideLoadingView() {
        FrameLayout frameLayout = this.flLoadingView;
        View view = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flLoadingView");
            frameLayout = null;
        }
        if (frameLayout.getVisibility() == 0) {
            FrameLayout frameLayout2 = this.flLoadingView;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flLoadingView");
                frameLayout2 = null;
            }
            frameLayout2.setVisibility(8);
            View view2 = this.loadingView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                view = view2;
            }
            view.clearAnimation();
        }
    }

    private final void initViewModel() {
        LiveData<UIStateData<List<e30.b>>> M1 = E9().M1();
        Fragment hostFragment = getHostFragment();
        final Function1<UIStateData<List<? extends e30.b>>, Unit> function1 = new Function1<UIStateData<List<? extends e30.b>>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverHintPart$initViewModel$1
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
                QFSPersonalCoverHintPart qFSPersonalCoverHintPart = QFSPersonalCoverHintPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qFSPersonalCoverHintPart.K9(it);
            }
        };
        M1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalCoverHintPart.O9(Function1.this, obj);
            }
        });
        LiveData<List<QFSPersonalCoverFeedInfo>> R1 = D9().R1();
        Fragment hostFragment2 = getHostFragment();
        final Function1<List<? extends QFSPersonalCoverFeedInfo>, Unit> function12 = new Function1<List<? extends QFSPersonalCoverFeedInfo>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.QFSPersonalCoverHintPart$initViewModel$2
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
            public final void invoke2(List<QFSPersonalCoverFeedInfo> list) {
                QFSPersonalCoverHintPart.this.I9();
            }
        };
        R1.observe(hostFragment2, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPersonalCoverHintPart.P9(Function1.this, obj);
            }
        });
    }

    private final void showLoadingView() {
        FrameLayout frameLayout = this.flLoadingView;
        View view = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flLoadingView");
            frameLayout = null;
        }
        if (frameLayout.getVisibility() == 8) {
            FrameLayout frameLayout2 = this.flLoadingView;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flLoadingView");
                frameLayout2 = null;
            }
            frameLayout2.setVisibility(0);
            View view2 = this.loadingView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingView");
            } else {
                view = view2;
            }
            view.startAnimation(this.loadingViewAnim);
        }
    }

    public final void M9() {
        final HashMap<String, String> hashMap;
        String str;
        QCircleInitBean initBean = getInitBean();
        QFSPersonalCoverHintView qFSPersonalCoverHintView = null;
        if (initBean != null) {
            hashMap = initBean.getSchemeAttrs();
        } else {
            hashMap = null;
        }
        if (hashMap != null) {
            str = hashMap.get(QCircleScheme.AttrQQPublish.BUSINESS_EMPTY_PAGE_TEXT);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.emptyText = str;
        QFSPersonalCoverHintView qFSPersonalCoverHintView2 = this.hintView;
        if (qFSPersonalCoverHintView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hintView");
        } else {
            qFSPersonalCoverHintView = qFSPersonalCoverHintView2;
        }
        qFSPersonalCoverHintView.setOnTvPushMoreClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.datacardcover.part.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPersonalCoverHintPart.N9(QFSPersonalCoverHintPart.this, hashMap, view);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPersonalCoverHintPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f41821i4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qfs_fl_loading_view)");
        this.flLoadingView = (FrameLayout) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f46341ub);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qfs_loading_view)");
        this.loadingView = findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f363614c);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.qfs_cover_hint_view)");
        this.hintView = (QFSPersonalCoverHintView) findViewById3;
        M9();
        initViewModel();
    }
}
