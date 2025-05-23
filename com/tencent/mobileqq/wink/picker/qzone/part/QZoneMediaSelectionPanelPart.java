package com.tencent.mobileqq.wink.picker.qzone.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkQZoneMediaListFragment;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPreviewFragment;
import com.tencent.mobileqq.wink.picker.qzone.viewmodel.QZoneMediaPickerViewModelProviderKt;
import com.tencent.mobileqq.wink.picker.qzone.viewmodel.QZoneSelectedMediaViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/part/QZoneMediaSelectionPanelPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "I9", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getLogTag", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "d", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "qZoneInitBean", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "previewView", "f", "nextStepBtn", tl.h.F, "Landroid/view/View;", "videoTemplateBtn", "i", "mediaSelectionPanelPart", "Lcom/tencent/mobileqq/wink/picker/qzone/viewmodel/QZoneSelectedMediaViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "H9", "()Lcom/tencent/mobileqq/wink/picker/qzone/viewmodel/QZoneSelectedMediaViewModel;", "qZoneSelectedMediaViewModel", "<init>", "(Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneMediaSelectionPanelPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QZoneInitBean qZoneInitBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView previewView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView nextStepBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View videoTemplateBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mediaSelectionPanelPart;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qZoneSelectedMediaViewModel;

    public QZoneMediaSelectionPanelPart(@NotNull QZoneInitBean qZoneInitBean) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(qZoneInitBean, "qZoneInitBean");
        this.qZoneInitBean = qZoneInitBean;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QZoneSelectedMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaSelectionPanelPart$qZoneSelectedMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QZoneSelectedMediaViewModel invoke() {
                QZoneInitBean qZoneInitBean2;
                WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(QZoneMediaSelectionPanelPart.this);
                Intrinsics.checkNotNull(b16);
                qZoneInitBean2 = QZoneMediaSelectionPanelPart.this.qZoneInitBean;
                return QZoneMediaPickerViewModelProviderKt.getWinkQZoneSelectedViewModel(b16, qZoneInitBean2);
            }
        });
        this.qZoneSelectedMediaViewModel = lazy;
    }

    private final QZoneSelectedMediaViewModel H9() {
        return (QZoneSelectedMediaViewModel) this.qZoneSelectedMediaViewModel.getValue();
    }

    private final void I9() {
        H9().getVideoTempBtnStatusLiveData().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneMediaSelectionPanelPart.K9(QZoneMediaSelectionPanelPart.this, (com.tencent.mobileqq.wink.picker.qzone.f) obj);
            }
        });
        H9().getNextStepBtnStatusLiveData().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneMediaSelectionPanelPart.L9(QZoneMediaSelectionPanelPart.this, (com.tencent.mobileqq.wink.picker.qzone.f) obj);
            }
        });
        H9().getNextBtnTextLiveData().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneMediaSelectionPanelPart.J9(QZoneMediaSelectionPanelPart.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QZoneMediaSelectionPanelPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.nextStepBtn;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K9(QZoneMediaSelectionPanelPart this$0, com.tencent.mobileqq.wink.picker.qzone.f fVar) {
        View view;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int type = fVar.getType();
        if (type != 4) {
            if (type == 6 && (view = this$0.videoTemplateBtn) != null) {
                view.setVisibility(0);
                return;
            }
            return;
        }
        View view2 = this$0.videoTemplateBtn;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(QZoneMediaSelectionPanelPart this$0, com.tencent.mobileqq.wink.picker.qzone.f fVar) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int type = fVar.getType();
        if (type != 3) {
            if (type == 5 && (textView = this$0.nextStepBtn) != null) {
                textView.setEnabled(true);
                return;
            }
            return;
        }
        TextView textView2 = this$0.nextStepBtn;
        if (textView2 != null) {
            textView2.setEnabled(false);
        }
    }

    private final void M9() {
        H9().getBtnVisibilityLiveData().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneMediaSelectionPanelPart.N9(QZoneMediaSelectionPanelPart.this, (com.tencent.mobileqq.wink.picker.qzone.f) obj);
            }
        });
        H9().getPanelVisibleLiveData().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneMediaSelectionPanelPart.O9(QZoneMediaSelectionPanelPart.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QZoneMediaSelectionPanelPart this$0, com.tencent.mobileqq.wink.picker.qzone.f fVar) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int type = fVar.getType();
        if (type != 1) {
            if (type == 2) {
                View view = this$0.videoTemplateBtn;
                if (view != null) {
                    layoutParams = view.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                if (layoutParams2 != null) {
                    layoutParams2.addRule(11);
                }
                if (layoutParams2 != null) {
                    layoutParams2.setMarginEnd(ImmersiveUtils.dpToPx(16.0f));
                }
                View view2 = this$0.videoTemplateBtn;
                if (view2 != null) {
                    view2.setLayoutParams(layoutParams2);
                }
                View view3 = this$0.videoTemplateBtn;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                TextView textView = this$0.nextStepBtn;
                if (textView != null) {
                    textView.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        TextView textView2 = this$0.nextStepBtn;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        View view4 = this$0.videoTemplateBtn;
        if (view4 != null) {
            view4.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(QZoneMediaSelectionPanelPart this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View findViewById = this$0.getPartRootView().findViewById(R.id.yzh);
        this$0.mediaSelectionPanelPart = findViewById;
        if (findViewById != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue() && findViewById.getVisibility() == 8) {
                findViewById.setVisibility(0);
            } else if (!it.booleanValue() && findViewById.getVisibility() != 8) {
                findViewById.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(QZoneMediaSelectionPanelPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this$0);
        if (b16 != null) {
            WinkMediaPickerMainBaseFragment.ei(b16, true, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QZoneMediaSelectionPanelPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this$0);
        if (b16 != null) {
            WinkMediaPickerMainBaseFragment.ii(b16, true, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(QZoneMediaSelectionPanelPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        URLDrawable.resume();
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this$0);
        if (b16 != null) {
            WinkSelectedMediaViewModel j3 = com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(b16);
            if (this$0.getHostFragment() instanceof WinkQZoneMediaListFragment) {
                com.tencent.mobileqq.wink.picker.core.c.f324480a.i(QZoneMediaPreviewFragment.INSTANCE.a(j3.getSelectedMedia(), 0, b16.Nh().getQZoneMediaType(), false, this$0.qZoneInitBean.getEnableEdit()));
            } else {
                com.tencent.mobileqq.wink.picker.core.c.f324480a.i(QZoneMediaPreviewFragment.INSTANCE.a(j3.getSelectedMedia(), 0, MediaType.LOCAL_ALL, false, this$0.qZoneInitBean.getEnableEdit()));
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMediaSelectionPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        TextView textView;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.nextStepBtn = (TextView) rootView.findViewById(R.id.zqm);
        this.videoTemplateBtn = rootView.findViewById(R.id.f1172070t);
        this.previewView = (TextView) rootView.findViewById(R.id.x_m);
        if (!this.qZoneInitBean.getEnableEdit() && (textView = this.previewView) != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.nextStepBtn;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneMediaSelectionPanelPart.P9(QZoneMediaSelectionPanelPart.this, view);
                }
            });
        }
        View view = this.videoTemplateBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZoneMediaSelectionPanelPart.Q9(QZoneMediaSelectionPanelPart.this, view2);
                }
            });
        }
        TextView textView3 = this.previewView;
        if (textView3 != null) {
            textView3.setText(textView3.getContext().getResources().getString(R.string.f216135xh));
            textView3.setTextSize(16.0f);
            VideoReport.setElementId(textView3, WinkDaTongReportConstant.ElementId.EM_BAS_PREVIEW);
            VideoReport.setElementClickPolicy(textView3, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(textView3, ExposurePolicy.REPORT_ALL);
        }
        TextView textView4 = this.previewView;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.part.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZoneMediaSelectionPanelPart.R9(QZoneMediaSelectionPanelPart.this, view2);
                }
            });
        }
        I9();
        M9();
        WinkMediaPickerMainBaseFragment<?> b16 = com.tencent.mobileqq.wink.picker.core.ktx.a.b(this);
        if (b16 != null) {
            WinkSelectedMediaViewModel j3 = com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(b16);
            H9().observeSelectedMediaChanged(j3.getAlreadySelectedMediaCount(), j3.Z1());
        }
    }
}
