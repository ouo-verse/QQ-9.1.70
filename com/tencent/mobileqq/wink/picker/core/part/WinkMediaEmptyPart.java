package com.tencent.mobileqq.wink.picker.core.part;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.QQWinkPageSwitchEvent;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalImageForFaceDetectViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaEmptyPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "K9", "I9", "L9", "", "F9", "G9", "J9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "d", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "e", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "winkMediaViewModel", "f", "Landroid/view/View;", "emptyView", tl.h.F, "placeholderView", "<init>", "(Lcom/tencent/mobileqq/wink/picker/MediaType;Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMediaEmptyPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MediaType mediaType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseWinkMediaViewModel winkMediaViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View emptyView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View placeholderView;

    public WinkMediaEmptyPart(@NotNull MediaType mediaType, @NotNull BaseWinkMediaViewModel winkMediaViewModel) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(winkMediaViewModel, "winkMediaViewModel");
        this.mediaType = mediaType;
        this.winkMediaViewModel = winkMediaViewModel;
    }

    private final boolean F9() {
        WinkLocalImageForFaceDetectViewModel winkLocalImageForFaceDetectViewModel;
        BaseWinkMediaViewModel baseWinkMediaViewModel = this.winkMediaViewModel;
        if (baseWinkMediaViewModel instanceof WinkLocalImageForFaceDetectViewModel) {
            winkLocalImageForFaceDetectViewModel = (WinkLocalImageForFaceDetectViewModel) baseWinkMediaViewModel;
        } else {
            winkLocalImageForFaceDetectViewModel = null;
        }
        if (winkLocalImageForFaceDetectViewModel != null) {
            return winkLocalImageForFaceDetectViewModel.getIsNeedJumpToCapture();
        }
        return false;
    }

    private final boolean G9() {
        WinkLocalImageForFaceDetectViewModel winkLocalImageForFaceDetectViewModel;
        BaseWinkMediaViewModel baseWinkMediaViewModel = this.winkMediaViewModel;
        if (baseWinkMediaViewModel instanceof WinkLocalImageForFaceDetectViewModel) {
            winkLocalImageForFaceDetectViewModel = (WinkLocalImageForFaceDetectViewModel) baseWinkMediaViewModel;
        } else {
            winkLocalImageForFaceDetectViewModel = null;
        }
        if (winkLocalImageForFaceDetectViewModel != null) {
            return winkLocalImageForFaceDetectViewModel.q2();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        ViewGroup viewGroup;
        if (this.emptyView != null) {
            View partRootView = getPartRootView();
            if (partRootView instanceof ViewGroup) {
                viewGroup = (ViewGroup) partRootView;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(this.emptyView);
            }
            this.emptyView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J9() {
        ViewGroup viewGroup;
        if (this.placeholderView != null) {
            View partRootView = getPartRootView();
            if (partRootView instanceof ViewGroup) {
                viewGroup = (ViewGroup) partRootView;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(this.placeholderView);
            }
            this.placeholderView = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9() {
        ViewGroup viewGroup;
        if (this.emptyView != null) {
            return;
        }
        View view = new View(getContext());
        this.emptyView = view;
        view.setBackgroundColor(ie0.a.f().g(getContext(), R.color.qui_common_bg_bottom_light, 1000));
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        View partRootView = getPartRootView();
        if (partRootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) partRootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.addView(this.emptyView, marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L9() {
        QQWinkConfig qQWinkConfig;
        QUIEmptyState build;
        List<QQWinkPage> g16;
        if (this.placeholderView != null) {
            return;
        }
        Parcelable parcelableExtra = getActivity().getIntent().getParcelableExtra("key_qq_wink_config");
        ViewGroup viewGroup = null;
        if (parcelableExtra instanceof QQWinkConfig) {
            qQWinkConfig = (QQWinkConfig) parcelableExtra;
        } else {
            qQWinkConfig = null;
        }
        boolean z16 = false;
        if (qQWinkConfig != null && (g16 = qQWinkConfig.g()) != null && g16.contains(QQWinkPage.Capture)) {
            z16 = true;
        }
        boolean z17 = getHostFragment().getActivity() instanceof QQWinkActivity;
        QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(getContext()).setImageType(6);
        if (z16 && !z17) {
            build = imageType.setTitle("\u6682\u65f6\u6ca1\u6709\u66f4\u591a\u5185\u5bb9\u54e6\uff0c\u53bb\u8bd5\u8bd5\u62cd\u6444\u73a9\u6cd5\u5427").setButton("\u53bb\u62cd\u6444", new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkMediaEmptyPart.M9(WinkMediaEmptyPart.this, view);
                }
            }).build();
        } else if (G9()) {
            if (F9()) {
                build = imageType.setImageType(16).setTitle("\u6682\u65e0\u53ef\u7528\u7684\u4eba\u50cf\u56fe\u7247").setButton("\u62cd\u4e00\u5f20", new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.part.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WinkMediaEmptyPart.N9(view);
                    }
                }).build();
            } else {
                build = imageType.setImageType(16).setTitle("\u6682\u65e0\u53ef\u7528\u7684\u4eba\u50cf\u56fe\u7247").setDesc("\u53ef\u5230\u201c\u77ed\u89c6\u9891\u4e2a\u4eba\u4e3b\u9875-\u8bbe\u7f6e-\u76f8\u518c\u8bbe\u7f6e\u201d\n\u5173\u95ed\u300c\u4ec5\u663e\u793a\u4eba\u50cf\u300d").build();
            }
        } else {
            build = imageType.setTitle("\u6682\u65f6\u6ca1\u6709\u66f4\u591a\u5185\u5bb9\u54e6").build();
        }
        QUIEmptyState qUIEmptyState = build;
        this.placeholderView = qUIEmptyState;
        com.tencent.mobileqq.wink.picker.report.a.g(qUIEmptyState, "ev_xsj_abnormal_imp", WinkDaTongReportConstant.ElementId.EM_XSJ_NO_PIC_SHOOT_BUTTON, null, 8, null);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        View partRootView = getPartRootView();
        if (partRootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) partRootView;
        }
        if (viewGroup != null) {
            viewGroup.addView(this.placeholderView, marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(WinkMediaEmptyPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus.getInstance().dispatchEvent(new QQWinkPageSwitchEvent(QQWinkPage.Capture));
        com.tencent.mobileqq.wink.picker.report.a.g(this$0.placeholderView, "ev_xsj_abnormal_clck", WinkDaTongReportConstant.ElementId.EM_XSJ_NO_PIC_SHOOT_BUTTON, null, 8, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
        cVar.e().c(cVar.b().getBusinessRequestCode());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        K9();
        LiveData<UIStateData<List<LocalMediaInfo>>> mediaUIState = this.winkMediaViewModel.getMediaUIState(this.mediaType);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<LocalMediaInfo>>, Unit> function1 = new Function1<UIStateData<List<LocalMediaInfo>>, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.part.WinkMediaEmptyPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<LocalMediaInfo>> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<LocalMediaInfo>> uIStateData) {
                if (uIStateData.getState() != 0) {
                    WinkMediaEmptyPart.this.I9();
                } else if (uIStateData.getIsFinish()) {
                    WinkMediaEmptyPart.this.I9();
                } else {
                    WinkMediaEmptyPart.this.K9();
                }
                if (uIStateData.getState() != 0 || !uIStateData.getIsFinish()) {
                    WinkMediaEmptyPart.this.J9();
                } else {
                    WinkMediaEmptyPart.this.L9();
                }
            }
        };
        mediaUIState.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMediaEmptyPart.H9(Function1.this, obj);
            }
        });
    }
}
