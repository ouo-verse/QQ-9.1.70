package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerTitleBarActionPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/widget/TextView;", "choseModeBtn", "", "J9", "Landroid/view/View;", "C9", "view", "E9", "K9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "d", "Landroid/view/View;", "titleLayoutWrapper", "", "e", "I", "titleLayoutPadding", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "f", "Lkotlin/Lazy;", "G9", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerTitleBarActionPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View titleLayoutWrapper;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int titleLayoutPadding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaViewModel;

    public QCircleMediaPickerTitleBarActionPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkSelectedMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTitleBarActionPart$selectedMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkSelectedMediaViewModel invoke() {
                WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(QCircleMediaPickerTitleBarActionPart.this);
                if (b16 != null) {
                    return com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(b16);
                }
                return null;
            }
        });
        this.selectedMediaViewModel = lazy;
    }

    private final void C9(final View choseModeBtn) {
        choseModeBtn.post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.n
            @Override // java.lang.Runnable
            public final void run() {
                QCircleMediaPickerTitleBarActionPart.D9(QCircleMediaPickerTitleBarActionPart.this, choseModeBtn);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(QCircleMediaPickerTitleBarActionPart this$0, View choseModeBtn) {
        int right;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(choseModeBtn, "$choseModeBtn");
        View view = this$0.titleLayoutWrapper;
        if (view != null && this$0.titleLayoutPadding <= (right = view.getRight() - choseModeBtn.getLeft())) {
            this$0.titleLayoutPadding = right;
            view.setPadding(right, 0, right, 0);
            view.requestLayout();
        }
    }

    private final void E9(TextView view) {
        com.tencent.mobileqq.wink.picker.report.a.b(view, WinkDaTongReportConstant.ElementId.EM_XSJ_MULT_CHOICE_BUTTON, null, null, false, 28, null);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setEventDynamicParams(view, new IDynamicParams() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.m
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map F9;
                F9 = QCircleMediaPickerTitleBarActionPart.F9(str);
                return F9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map F9(String str) {
        String str2;
        Map mutableMapOf;
        if (com.tencent.mobileqq.wink.picker.core.c.f324480a.h()) {
            str2 = "\u53d6\u6d88\u591a\u9009";
        } else {
            str2 = "\u591a\u9009";
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("xsj_item_name", str2));
        return mutableMapOf;
    }

    private final WinkSelectedMediaViewModel G9() {
        return (WinkSelectedMediaViewModel) this.selectedMediaViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(View this_run, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        com.tencent.mobileqq.wink.f.l(this_run.getContext(), "mqqapi://qcircle/openpublishdraft");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(QCircleMediaPickerTitleBarActionPart this$0, TextView this_run, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
        cVar.m();
        uq3.k.a().j(QQWinkConstants.MMKV_QCIRCLE_SINGLE_SELECT_MODE, cVar.h());
        this$0.J9(this_run);
        this$0.C9(this_run);
        WinkSelectedMediaViewModel G9 = this$0.G9();
        if (G9 != null) {
            G9.Q1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void J9(TextView choseModeBtn) {
        String str;
        if (com.tencent.mobileqq.wink.picker.core.c.f324480a.h()) {
            str = "\u591a\u9009";
        } else {
            str = "\u53d6\u6d88\u591a\u9009";
        }
        choseModeBtn.setText(str);
    }

    private final void K9() {
        boolean isInMultiWindowMode;
        if (Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = getPartHost().getHostActivity().isInMultiWindowMode();
            if (isInMultiWindowMode) {
                getPartRootView().findViewById(R.id.ul7).setVisibility(8);
            } else {
                getPartRootView().findViewById(R.id.ul7).setVisibility(0);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        K9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.titleLayoutWrapper = rootView.findViewById(R.id.f98075m4);
        final View findViewById = rootView.findViewById(R.id.ul7);
        if (findViewById != null) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QCircleMediaPickerTitleBarActionPart.H9(findViewById, view);
                }
            });
        }
        K9();
        final TextView textView = (TextView) rootView.findViewById(R.id.twi);
        if (textView != null) {
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QCircleMediaPickerTitleBarActionPart.I9(QCircleMediaPickerTitleBarActionPart.this, textView, view);
                }
            });
            J9(textView);
            C9(textView);
            E9(textView);
        }
    }
}
