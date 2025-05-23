package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part.QQStrangerSignalPublishBottomPart;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part.QQStrangerSignalPublishPickerPart;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.part.d;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.viewmodel.QQStrangerSignalPublishViewModel;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenImmersiveFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.aio.utils.l;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR#\u0010'\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/QQStrangerSignalPublishFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "rh", "", "uh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "needStatusTrans", "needImmersive", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onFinish", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "D", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenImmersiveFloatingView;", "floatingView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;", "kotlin.jvm.PlatformType", "E", "Lkotlin/Lazy;", "sh", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/viewmodel/QQStrangerSignalPublishViewModel;", "viewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private QUSHalfScreenImmersiveFloatingView floatingView;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/signal/publish/QQStrangerSignalPublishFragment$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends e {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LayoutInflater f244879e;

        b(LayoutInflater layoutInflater) {
            this.f244879e = layoutInflater;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            return QQStrangerSignalPublishFragment.this.rh(this.f244879e);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    public QQStrangerSignalPublishFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerSignalPublishViewModel>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.QQStrangerSignalPublishFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerSignalPublishViewModel invoke() {
                return (QQStrangerSignalPublishViewModel) QQStrangerSignalPublishFragment.this.getViewModel(QQStrangerSignalPublishViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    private final QQStrangerSignalPublishViewModel sh() {
        return (QQStrangerSignalPublishViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(QQStrangerSignalPublishFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final boolean uh() {
        return FontSettingManager.getFontLevel() > 17.0f;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.floatingView;
        if (qUSHalfScreenImmersiveFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView = null;
        }
        qUSHalfScreenImmersiveFloatingView.t();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.cy7, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.rootView = viewGroup;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup = null;
        }
        View findViewById = viewGroup.findViewById(R.id.ojs);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.floating_view)");
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = (QUSHalfScreenImmersiveFloatingView) findViewById;
        this.floatingView = qUSHalfScreenImmersiveFloatingView;
        if (qUSHalfScreenImmersiveFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView = null;
        }
        qUSHalfScreenImmersiveFloatingView.setQUSDragFloatController(new b(inflater));
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.floatingView;
        if (qUSHalfScreenImmersiveFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView2 = null;
        }
        qUSHalfScreenImmersiveFloatingView2.setIsHeightWrapContent(true);
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView3 = this.floatingView;
        if (qUSHalfScreenImmersiveFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView3 = null;
        }
        qUSHalfScreenImmersiveFloatingView3.setIsContentDraggable(false);
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView4 = this.floatingView;
        if (qUSHalfScreenImmersiveFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView4 = null;
        }
        qUSHalfScreenImmersiveFloatingView4.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                QQStrangerSignalPublishFragment.th(QQStrangerSignalPublishFragment.this);
            }
        });
        ViewGroup viewGroup2 = this.rootView;
        if (viewGroup2 != null) {
            return viewGroup2;
        }
        Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        VideoReport.setPageId(view, "pg_kl_expansion_list");
        VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_NONE);
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView = this.floatingView;
        if (qUSHalfScreenImmersiveFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView = null;
        }
        VideoReport.setElementId(qUSHalfScreenImmersiveFloatingView, "em_kl_publisher_float");
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView2 = this.floatingView;
        if (qUSHalfScreenImmersiveFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView2 = null;
        }
        VideoReport.setElementExposePolicy(qUSHalfScreenImmersiveFloatingView2, ExposurePolicy.REPORT_NONE);
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView3 = this.floatingView;
        if (qUSHalfScreenImmersiveFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView3 = null;
        }
        VideoReport.setElementClickPolicy(qUSHalfScreenImmersiveFloatingView3, ClickPolicy.REPORT_NONE);
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView4 = this.floatingView;
        if (qUSHalfScreenImmersiveFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView4 = null;
        }
        VideoReport.setElementEndExposePolicy(qUSHalfScreenImmersiveFloatingView4, EndExposurePolicy.REPORT_NONE);
        QUSHalfScreenImmersiveFloatingView qUSHalfScreenImmersiveFloatingView5 = this.floatingView;
        if (qUSHalfScreenImmersiveFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenImmersiveFloatingView5 = null;
        }
        VideoReport.reportEvent("imp", qUSHalfScreenImmersiveFloatingView5, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        QQStrangerSignalPublishViewModel viewModel = sh();
        Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
        QQStrangerSignalPublishViewModel viewModel2 = sh();
        Intrinsics.checkNotNullExpressionValue(viewModel2, "viewModel");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new d(), new QQStrangerSignalPublishPickerPart(viewModel), new QQStrangerSignalPublishBottomPart(viewModel2));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View rh(LayoutInflater inflater) {
        View inflate = inflater.inflate(R.layout.cy6, (ViewGroup) null);
        if (uh()) {
            View findViewById = inflate.findViewById(R.id.opd);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = l.b(0);
                findViewById.setLayoutParams(marginLayoutParams);
            }
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026}\n            }\n        }");
        return inflate;
    }
}
