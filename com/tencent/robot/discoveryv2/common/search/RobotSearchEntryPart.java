package com.tencent.robot.discoveryv2.common.search;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.discoveryv2.common.search.c;
import com.tencent.robot.discoveryv2.common.search.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/discoveryv2/common/search/RobotSearchEntryPart;", "Lo34/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "H9", "F9", "", "visibility", "L9", "J9", "E9", "K9", "onInitView", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "d", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "mSearchBar", "Lcom/tencent/robot/discoveryv2/common/search/RobotSearchEntryViewModel;", "e", "Lcom/tencent/robot/discoveryv2/common/search/RobotSearchEntryViewModel;", "mViewModel", "<init>", "()V", "f", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSearchEntryPart extends o34.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUISearchBar mSearchBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RobotSearchEntryViewModel mViewModel;

    private final void E9() {
        x34.a aVar = x34.a.f447161a;
        QUISearchBar qUISearchBar = this.mSearchBar;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchBar");
            qUISearchBar = null;
        }
        aVar.a(qUISearchBar, "em_search_bar", null);
        QUISearchBar qUISearchBar2 = this.mSearchBar;
        if (qUISearchBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchBar");
            qUISearchBar2 = null;
        }
        VideoReport.reportEvent("imp", qUISearchBar2, null);
    }

    private final void F9() {
        RobotSearchEntryViewModel robotSearchEntryViewModel = (RobotSearchEntryViewModel) z9(RobotSearchEntryViewModel.class);
        this.mViewModel = robotSearchEntryViewModel;
        RobotSearchEntryViewModel robotSearchEntryViewModel2 = null;
        if (robotSearchEntryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            robotSearchEntryViewModel = null;
        }
        robotSearchEntryViewModel.Q1();
        RobotSearchEntryViewModel robotSearchEntryViewModel3 = this.mViewModel;
        if (robotSearchEntryViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        } else {
            robotSearchEntryViewModel2 = robotSearchEntryViewModel3;
        }
        MutableLiveData<d> P1 = robotSearchEntryViewModel2.P1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<d, Unit> function1 = new Function1<d, Unit>() { // from class: com.tencent.robot.discoveryv2.common.search.RobotSearchEntryPart$initSearchBarViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(d dVar) {
                if (dVar instanceof d.UpdateSearchBarVisibility) {
                    RobotSearchEntryPart.this.L9(((d.UpdateSearchBarVisibility) dVar).getVisibility());
                }
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.discoveryv2.common.search.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotSearchEntryPart.G9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void H9(View rootView) {
        View findViewById = rootView.findViewById(R.id.iir);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.search_bar)");
        QUISearchBar qUISearchBar = (QUISearchBar) findViewById;
        this.mSearchBar = qUISearchBar;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchBar");
            qUISearchBar = null;
        }
        qUISearchBar.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discoveryv2.common.search.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotSearchEntryPart.I9(RobotSearchEntryPart.this, view);
            }
        });
        qUISearchBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(RobotSearchEntryPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.J9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J9() {
        if (FastClickUtils.isFastDoubleClick("CommonSearchEntryPartonSearchBarClick")) {
            return;
        }
        K9();
        RobotSearchEntryViewModel robotSearchEntryViewModel = this.mViewModel;
        QIphoneTitleBarFragment qIphoneTitleBarFragment = null;
        if (robotSearchEntryViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            robotSearchEntryViewModel = null;
        }
        Context context = getContext();
        IPartHost partHost = getPartHost();
        if (partHost instanceof QIphoneTitleBarFragment) {
            qIphoneTitleBarFragment = (QIphoneTitleBarFragment) partHost;
        }
        robotSearchEntryViewModel.R1(new c.OnSearchBarClick(context, qIphoneTitleBarFragment));
    }

    private final void K9() {
        QUISearchBar qUISearchBar = this.mSearchBar;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchBar");
            qUISearchBar = null;
        }
        VideoReport.reportEvent("clck", qUISearchBar, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9(int visibility) {
        QUISearchBar qUISearchBar = this.mSearchBar;
        if (qUISearchBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSearchBar");
            qUISearchBar = null;
        }
        qUISearchBar.setVisibility(visibility);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        H9(rootView);
        F9();
        E9();
    }
}
