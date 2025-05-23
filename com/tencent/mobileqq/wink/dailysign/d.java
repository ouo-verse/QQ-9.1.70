package com.tencent.mobileqq.wink.dailysign;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.dailysign.DailySignFragment;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*JB\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0007H\u0002J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\tR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/d;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", "view", "", "eid", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extParams", "", "B9", "Lcom/tencent/mobileqq/wink/dailysign/DailySignFragment$b;", "nextButtonClickListener", "H9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "enable", "I9", "G9", "Landroid/widget/Button;", "d", "Landroid/widget/Button;", "nextBtn", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", "autoBackPickChange", "f", "imagePicker", "Landroidx/constraintlayout/widget/ConstraintLayout;", tl.h.F, "Landroidx/constraintlayout/widget/ConstraintLayout;", "bottomContainer", "i", "Lcom/tencent/mobileqq/wink/dailysign/DailySignFragment$b;", "onNextButtonClickListener", "Lcom/tencent/mobileqq/wink/dailysign/DailySignViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/dailysign/DailySignViewModel;", "dailySignViewModel", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Button nextBtn;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FrameLayout autoBackPickChange;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private FrameLayout imagePicker;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout bottomContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private DailySignFragment.b onNextButtonClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private DailySignViewModel dailySignViewModel;

    private final void B9(View view, String eid, HashMap<String, String> extParams) {
        VideoReport.setElementId(view, eid);
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (extParams != null) {
            buildElementParams.putAll(extParams);
        }
        VideoReport.setElementParams(view, buildElementParams);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void C9(d dVar, View view, String str, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            hashMap = null;
        }
        dVar.B9(view, str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.picker.f fVar = com.tencent.mobileqq.wink.picker.f.f324854a;
        Activity activity = this$0.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Fragment hostFragment = this$0.getHostFragment();
        String traceId = WinkContext.INSTANCE.d().getTraceId();
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.i(TabType.ONLY_IMAGE);
        aVar.f(true);
        aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
        aVar.e(100);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wink.picker.f.b(fVar, activity, hostFragment, 100, traceId, aVar.a(), null, 32, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.autoBackPickChange;
        DailySignViewModel dailySignViewModel = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout = null;
        }
        VideoReport.setElementId(frameLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_HANDPICKED_BACKGROUND);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        DailySignViewModel dailySignViewModel2 = this$0.dailySignViewModel;
        if (dailySignViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailySignViewModel");
            dailySignViewModel2 = null;
        }
        map.put("xsj_background_id", dailySignViewModel2.c2());
        map.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_HANDPICKED_BACKGROUND);
        map.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_DAILY_SIGNIN_PAGE);
        DailySignFragment.Companion companion = DailySignFragment.INSTANCE;
        DailySignViewModel dailySignViewModel3 = this$0.dailySignViewModel;
        if (dailySignViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailySignViewModel");
            dailySignViewModel3 = null;
        }
        map.putAll(companion.a(dailySignViewModel3.q2()));
        FrameLayout frameLayout2 = this$0.autoBackPickChange;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout2 = null;
        }
        VideoReport.setElementParams(frameLayout2, map);
        FrameLayout frameLayout3 = this$0.autoBackPickChange;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout3 = null;
        }
        VideoReport.setElementClickPolicy(frameLayout3, ClickPolicy.REPORT_NONE);
        FrameLayout frameLayout4 = this$0.autoBackPickChange;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout4 = null;
        }
        VideoReport.setElementExposePolicy(frameLayout4, ExposurePolicy.REPORT_NONE);
        FrameLayout frameLayout5 = this$0.autoBackPickChange;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout5 = null;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", frameLayout5, map);
        DailySignViewModel dailySignViewModel4 = this$0.dailySignViewModel;
        if (dailySignViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailySignViewModel");
        } else {
            dailySignViewModel = dailySignViewModel4;
        }
        dailySignViewModel.D2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DailySignFragment.b bVar = this$0.onNextButtonClickListener;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onNextButtonClickListener");
            bVar = null;
        }
        bVar.a();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void G9() {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        FrameLayout frameLayout = null;
        if (this.dailySignViewModel != null) {
            Intrinsics.checkNotNullExpressionValue(params, "params");
            DailySignViewModel dailySignViewModel = this.dailySignViewModel;
            if (dailySignViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dailySignViewModel");
                dailySignViewModel = null;
            }
            params.put("xsj_background_id", dailySignViewModel.c2());
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_HANDPICKED_BACKGROUND);
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_DAILY_SIGNIN_PAGE);
        FrameLayout frameLayout2 = this.autoBackPickChange;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout2 = null;
        }
        VideoReport.setElementId(frameLayout2, WinkDaTongReportConstant.ElementId.EM_XSJ_HANDPICKED_BACKGROUND);
        FrameLayout frameLayout3 = this.autoBackPickChange;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout3 = null;
        }
        VideoReport.setElementParams(frameLayout3, params);
        FrameLayout frameLayout4 = this.autoBackPickChange;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout4 = null;
        }
        VideoReport.setElementClickPolicy(frameLayout4, ClickPolicy.REPORT_NONE);
        FrameLayout frameLayout5 = this.autoBackPickChange;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout5 = null;
        }
        VideoReport.setElementExposePolicy(frameLayout5, ExposurePolicy.REPORT_NONE);
        FrameLayout frameLayout6 = this.autoBackPickChange;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
        } else {
            frameLayout = frameLayout6;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", frameLayout, params);
    }

    public final void H9(@NotNull DailySignFragment.b nextButtonClickListener) {
        Intrinsics.checkNotNullParameter(nextButtonClickListener, "nextButtonClickListener");
        this.onNextButtonClickListener = nextButtonClickListener;
    }

    public final void I9(boolean enable) {
        int i3;
        if (enable) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        ConstraintLayout constraintLayout = this.bottomContainer;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomContainer");
            constraintLayout = null;
        }
        constraintLayout.setVisibility(i3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Button button;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        ViewModel viewModel = getViewModel(DailySignViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(DailySignViewModel::class.java)");
        this.dailySignViewModel = (DailySignViewModel) viewModel;
        View findViewById = rootView.findViewById(R.id.f124677k0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026t_video_fragment_confirm)");
        this.nextBtn = (Button) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f124647jx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.wink_text_video_album)");
        this.imagePicker = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f122597ed);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.wink_daily_sign_bottom)");
        this.bottomContainer = (ConstraintLayout) findViewById3;
        FrameLayout frameLayout2 = this.imagePicker;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imagePicker");
            frameLayout2 = null;
        }
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.D9(d.this, view);
            }
        });
        View findViewById4 = rootView.findViewById(R.id.f124657jy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ink_text_video_change_bg)");
        FrameLayout frameLayout3 = (FrameLayout) findViewById4;
        this.autoBackPickChange = frameLayout3;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoBackPickChange");
            frameLayout3 = null;
        }
        frameLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.E9(d.this, view);
            }
        });
        Button button2 = this.nextBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.dailysign.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.F9(d.this, view);
            }
        });
        Button button3 = this.nextBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
            button = null;
        } else {
            button = button3;
        }
        C9(this, button, WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON, null, 4, null);
        FrameLayout frameLayout4 = this.imagePicker;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imagePicker");
            frameLayout = null;
        } else {
            frameLayout = frameLayout4;
        }
        C9(this, frameLayout, WinkDaTongReportConstant.ElementId.EM_XSJ_CUSTOMIZE_BACKGROUND, null, 4, null);
    }
}
