package com.tencent.mobileqq.wink.picker.qcircle.part;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalImageForFaceDetectViewModel;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalMediaViewModel;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.QQToastUtil;
import ha3.PhotoFace;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0010\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\f\u0010\r\u001a\u00020\u0002*\u00020\u0000H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0017\u0010\u001b\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0016\u0010!\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerTopDetectFacePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "I9", "O9", "initViewModel", "N9", "S9", "P9", "Landroid/view/View$OnClickListener;", "confirmListener", "R9", "V9", "J9", "", "getLogTag", "", "isPartEnable", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStop", "onPartDestroy", "d", "Z", MiniGamePAHippyBaseFragment.KEY_THEME, "()Z", "e", "isFromMagicAvatar", "f", "Landroid/view/View;", "topBanner", tl.h.F, "isNeedShowToast", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "i", "Lkotlin/Lazy;", "K9", "()Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingDialog", "<init>", "(ZZ)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaPickerTopDetectFacePart extends Part {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isNightMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isFromMagicAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View topBanner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isNeedShowToast;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingDialog;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/part/QCircleMediaPickerTopDetectFacePart$a;", "", "", "a", "", "MMKV_KEY_FIRST_GUIDE_SET", "Ljava/lang/String;", "MMKV_KEY_FIRST_SHOW_GUIDE", "MMKV_KEY_OPEN_FACE_DETECT", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTopDetectFacePart$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            if (((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).isExperiment("exp_xsj_fbq_aiface_cluster_v2") && Intrinsics.areEqual(WinkContext.INSTANCE.d().k().a(), "QCIRCLE")) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    public QCircleMediaPickerTopDetectFacePart(boolean z16, boolean z17) {
        Lazy lazy;
        this.isNightMode = z16;
        this.isFromMagicAvatar = z17;
        lazy = LazyKt__LazyJVMKt.lazy(new QCircleMediaPickerTopDetectFacePart$loadingDialog$2(this));
        this.loadingDialog = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment;
        uq3.k.a().j("mmkv_key_open_face_detect", false);
        Fragment hostFragment = getHostFragment();
        WinkLocalImageForFaceDetectViewModel winkLocalImageForFaceDetectViewModel = null;
        if (hostFragment instanceof WinkMediaPickerMainBaseFragment) {
            winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment;
        } else {
            winkMediaPickerMainBaseFragment = null;
        }
        if (winkMediaPickerMainBaseFragment != null) {
            WinkLocalMediaViewModel localMediaViewModel = winkMediaPickerMainBaseFragment.getLocalMediaViewModel();
            if (localMediaViewModel instanceof WinkLocalImageForFaceDetectViewModel) {
                winkLocalImageForFaceDetectViewModel = (WinkLocalImageForFaceDetectViewModel) localMediaViewModel;
            }
            if (winkLocalImageForFaceDetectViewModel != null) {
                winkLocalImageForFaceDetectViewModel.v2(true);
                winkLocalImageForFaceDetectViewModel.z2();
            }
        }
    }

    private final void J9(QCircleMediaPickerTopDetectFacePart qCircleMediaPickerTopDetectFacePart) {
        WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment;
        Fragment hostFragment = qCircleMediaPickerTopDetectFacePart.getHostFragment();
        WinkLocalImageForFaceDetectViewModel winkLocalImageForFaceDetectViewModel = null;
        if (hostFragment instanceof WinkMediaPickerMainBaseFragment) {
            winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment;
        } else {
            winkMediaPickerMainBaseFragment = null;
        }
        if (winkMediaPickerMainBaseFragment != null) {
            WinkLocalMediaViewModel localMediaViewModel = winkMediaPickerMainBaseFragment.getLocalMediaViewModel();
            if (localMediaViewModel instanceof WinkLocalImageForFaceDetectViewModel) {
                winkLocalImageForFaceDetectViewModel = (WinkLocalImageForFaceDetectViewModel) localMediaViewModel;
            }
            if (winkLocalImageForFaceDetectViewModel != null) {
                winkLocalImageForFaceDetectViewModel.x2(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QCircleCommonLoadingDialog K9() {
        Object value = this.loadingDialog.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingDialog>(...)");
        return (QCircleCommonLoadingDialog) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9() {
        WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment;
        AppBarLayout Xh;
        Fragment hostFragment = getHostFragment();
        View view = null;
        if (hostFragment instanceof WinkMediaPickerMainBaseFragment) {
            winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment;
        } else {
            winkMediaPickerMainBaseFragment = null;
        }
        if (winkMediaPickerMainBaseFragment != null && (Xh = winkMediaPickerMainBaseFragment.Xh()) != null) {
            View view2 = this.topBanner;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBanner");
            } else {
                view = view2;
            }
            Xh.removeView(view);
        }
    }

    private final void O9() {
        uq3.k.b().j("mmkv_key_first_guide_set", true);
        uq3.k.a().j("mmkv_key_open_face_detect", true);
        V9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9() {
        R9(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QCircleMediaPickerTopDetectFacePart.Q9(QCircleMediaPickerTopDetectFacePart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(QCircleMediaPickerTopDetectFacePart this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9();
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        if (this$0.isFromMagicAvatar) {
            str = WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_PAGE;
        } else {
            str = "pg_xsj_choose_media_new_page";
        }
        com.tencent.mobileqq.wink.report.a.b(aVar, WinkDaTongReportConstant.ElementId.EM_XSJ_PORTRAIT_SET_POP_BUTTON, "ev_xsj_abnormal_clck", str, null, 8, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void R9(View.OnClickListener confirmListener) {
        String str;
        String str2;
        if (this.isNightMode) {
            str = "https://qq-video.cdn-go.cn/android/latest/darkmode/9110/portraitgather/qvideo_skin_bg_portraitgather_dialog.png";
        } else {
            str = "https://qq-video.cdn-go.cn/android/latest/defaultmode/9110/portraitgather/qvideo_skin_bg_portraitgather_dialog.png";
        }
        com.tencent.mobileqq.wink.view.u.f327143a.h(getContext(), str, null, confirmListener).show();
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        if (this.isFromMagicAvatar) {
            str2 = WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_PAGE;
        } else {
            str2 = "pg_xsj_choose_media_new_page";
        }
        com.tencent.mobileqq.wink.report.a.b(aVar, WinkDaTongReportConstant.ElementId.EM_XSJ_PORTRAIT_SET_POP_BUTTON, "ev_xsj_abnormal_imp", str2, null, 8, null);
    }

    private final void S9() {
        final WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment;
        View view;
        Fragment hostFragment = getHostFragment();
        View view2 = null;
        if (hostFragment instanceof WinkMediaPickerMainBaseFragment) {
            winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment;
        } else {
            winkMediaPickerMainBaseFragment = null;
        }
        if (winkMediaPickerMainBaseFragment != null) {
            AppBarLayout Xh = winkMediaPickerMainBaseFragment.Xh();
            if (Xh != null) {
                Xh.removeAllViews();
            }
            View inflate = LayoutInflater.from(winkMediaPickerMainBaseFragment.getContext()).inflate(R.layout.g4d, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ermission_settings, null)");
            this.topBanner = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBanner");
                inflate = null;
            }
            AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, ViewExKt.d(48));
            layoutParams.g(1);
            inflate.setLayoutParams(layoutParams);
            View view3 = this.topBanner;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBanner");
                view3 = null;
            }
            TextView textView = (TextView) view3.findViewById(R.id.t4_);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    QCircleMediaPickerTopDetectFacePart.U9(QCircleMediaPickerTopDetectFacePart.this, view4);
                }
            });
            com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
            Intrinsics.checkNotNullExpressionValue(textView, "this");
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
            com.tencent.mobileqq.wink.report.a.d(aVar, textView, WinkDaTongReportConstant.ElementId.EM_XSJ_PORTRAIT_SET_BAR_BUTTON, null, exposurePolicy, null, null, null, 116, null);
            View view4 = this.topBanner;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBanner");
                view4 = null;
            }
            ImageView imageView = (ImageView) view4.findViewById(R.id.t3s);
            VideoReport.setPageId(imageView, "pg_xsj_choose_media_new_page");
            Intrinsics.checkNotNullExpressionValue(imageView, "this");
            com.tencent.mobileqq.wink.report.a.d(aVar, imageView, WinkDaTongReportConstant.ElementId.EM_XSJ_PORTRAIT_SET_CLOSE_BUTTON, null, exposurePolicy, null, null, null, 116, null);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    QCircleMediaPickerTopDetectFacePart.T9(WinkMediaPickerMainBaseFragment.this, this, view5);
                }
            });
            View view5 = this.topBanner;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBanner");
                view = null;
            } else {
                view = view5;
            }
            com.tencent.mobileqq.wink.report.a.d(aVar, view, WinkDaTongReportConstant.ElementId.EM_XSJ_PORTRAIT_SET_GUIDE_BAR, ClickPolicy.REPORT_NONE, null, null, null, null, 120, null);
            AppBarLayout Xh2 = winkMediaPickerMainBaseFragment.Xh();
            if (Xh2 != null) {
                View view6 = this.topBanner;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topBanner");
                } else {
                    view2 = view6;
                }
                Xh2.addView(view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(WinkMediaPickerMainBaseFragment this_apply, QCircleMediaPickerTopDetectFacePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppBarLayout Xh = this_apply.Xh();
        if (Xh != null) {
            View view2 = this$0.topBanner;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topBanner");
                view2 = null;
            }
            Xh.removeView(view2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(QCircleMediaPickerTopDetectFacePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (uq3.k.b().c("mmkv_key_first_guide_set", false)) {
            uq3.k.a().j("mmkv_key_open_face_detect", true);
            this$0.V9();
        } else {
            this$0.P9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V9() {
        WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment;
        Fragment hostFragment = getHostFragment();
        WinkLocalImageForFaceDetectViewModel winkLocalImageForFaceDetectViewModel = null;
        if (hostFragment instanceof WinkMediaPickerMainBaseFragment) {
            winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment;
        } else {
            winkMediaPickerMainBaseFragment = null;
        }
        if (winkMediaPickerMainBaseFragment != null) {
            WinkLocalMediaViewModel localMediaViewModel = winkMediaPickerMainBaseFragment.getLocalMediaViewModel();
            if (localMediaViewModel instanceof WinkLocalImageForFaceDetectViewModel) {
                winkLocalImageForFaceDetectViewModel = (WinkLocalImageForFaceDetectViewModel) localMediaViewModel;
            }
            if (winkLocalImageForFaceDetectViewModel != null) {
                K9().show();
                this.isNeedShowToast = true;
                winkLocalImageForFaceDetectViewModel.v2(false);
                winkLocalImageForFaceDetectViewModel.y2();
            }
        }
    }

    private final void initViewModel() {
        WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment;
        WinkLocalImageForFaceDetectViewModel winkLocalImageForFaceDetectViewModel;
        Fragment hostFragment = getHostFragment();
        final WinkLocalImageForFaceDetectViewModel winkLocalImageForFaceDetectViewModel2 = null;
        if (hostFragment instanceof WinkMediaPickerMainBaseFragment) {
            winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment;
        } else {
            winkMediaPickerMainBaseFragment = null;
        }
        if (winkMediaPickerMainBaseFragment != null) {
            WinkLocalMediaViewModel localMediaViewModel = winkMediaPickerMainBaseFragment.getLocalMediaViewModel();
            if (localMediaViewModel instanceof WinkLocalImageForFaceDetectViewModel) {
                winkLocalImageForFaceDetectViewModel = (WinkLocalImageForFaceDetectViewModel) localMediaViewModel;
            } else {
                winkLocalImageForFaceDetectViewModel = null;
            }
            if (winkLocalImageForFaceDetectViewModel != null) {
                winkLocalImageForFaceDetectViewModel.w2(this.isFromMagicAvatar);
            }
            WinkLocalMediaViewModel localMediaViewModel2 = winkMediaPickerMainBaseFragment.getLocalMediaViewModel();
            if (localMediaViewModel2 instanceof WinkLocalImageForFaceDetectViewModel) {
                winkLocalImageForFaceDetectViewModel2 = (WinkLocalImageForFaceDetectViewModel) localMediaViewModel2;
            }
            if (winkLocalImageForFaceDetectViewModel2 != null) {
                LiveData<List<PhotoFace>> e26 = winkLocalImageForFaceDetectViewModel2.e2();
                LifecycleOwner viewLifecycleOwner = winkMediaPickerMainBaseFragment.getViewLifecycleOwner();
                final Function1<List<? extends PhotoFace>, Unit> function1 = new Function1<List<? extends PhotoFace>, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTopDetectFacePart$initViewModel$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends PhotoFace> list) {
                        invoke2((List<PhotoFace>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<PhotoFace> it) {
                        w53.b.f("QCircleMediaPickerTopDetectFacePart", "[observe] FromDb list:" + it.size());
                        WinkLocalImageForFaceDetectViewModel winkLocalImageForFaceDetectViewModel3 = WinkLocalImageForFaceDetectViewModel.this;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        winkLocalImageForFaceDetectViewModel3.u2(it);
                        WinkLocalImageForFaceDetectViewModel.this.T1();
                    }
                };
                e26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.s
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QCircleMediaPickerTopDetectFacePart.L9(Function1.this, obj);
                    }
                });
                LiveData<UIStateData<List<LocalMediaInfo>>> k26 = winkLocalImageForFaceDetectViewModel2.k2();
                LifecycleOwner viewLifecycleOwner2 = winkMediaPickerMainBaseFragment.getViewLifecycleOwner();
                final Function1<UIStateData<List<LocalMediaInfo>>, Unit> function12 = new Function1<UIStateData<List<LocalMediaInfo>>, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.QCircleMediaPickerTopDetectFacePart$initViewModel$1$1$2
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
                        List<LocalMediaInfo> data;
                        QCircleCommonLoadingDialog K9;
                        QCircleCommonLoadingDialog K92;
                        boolean z16;
                        List<LocalMediaInfo> data2;
                        w53.b.f("QCircleMediaPickerTopDetectFacePart", "[observe] From imageLiveData:" + ((uIStateData == null || (data2 = uIStateData.getData()) == null) ? 0 : data2.size()));
                        if (uq3.k.a().c("mmkv_key_open_face_detect", false)) {
                            K9 = QCircleMediaPickerTopDetectFacePart.this.K9();
                            if (K9.isShowing()) {
                                QCircleMediaPickerTopDetectFacePart.this.N9();
                                K92 = QCircleMediaPickerTopDetectFacePart.this.K9();
                                K92.dismiss();
                                z16 = QCircleMediaPickerTopDetectFacePart.this.isNeedShowToast;
                                if (z16) {
                                    QQToastUtil.showQQToast(2, "\u5df2\u8bbe\u7f6e\u4e3a\u300c\u4ec5\u663e\u793a\u4eba\u50cf\u56fe\u7247\u300d");
                                    return;
                                }
                                return;
                            }
                            if (uIStateData.getState() == 0) {
                                QCircleMediaPickerTopDetectFacePart.this.N9();
                                return;
                            }
                            return;
                        }
                        boolean c16 = uq3.k.b().c("mmkv_key_first_show_guide", true);
                        int size = (uIStateData == null || (data = uIStateData.getData()) == null) ? 0 : data.size();
                        w53.b.a("QCircleMediaPickerTopDetectFacePart", "[observe] isFirstShow:" + c16);
                        if (size != 0 && c16) {
                            uq3.k.b().j("mmkv_key_first_show_guide", false);
                            QCircleMediaPickerTopDetectFacePart.this.P9();
                        }
                        if (uIStateData.getState() == 0) {
                            QCircleMediaPickerTopDetectFacePart.this.N9();
                        }
                    }
                };
                k26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qcircle.part.t
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        QCircleMediaPickerTopDetectFacePart.M9(Function1.this, obj);
                    }
                });
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "QCircleMediaPickerTopDetectFacePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return INSTANCE.a();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        boolean c16 = uq3.k.a().c("mmkv_key_open_face_detect", false);
        w53.b.a("QCircleMediaPickerTopDetectFacePart", "onInitView... hasOpenFaceDetection:" + c16);
        S9();
        if (c16) {
            K9().show();
        }
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        w53.b.a("QCircleMediaPickerTopDetectFacePart", "onPartDestroy...");
        J9(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        w53.b.a("QCircleMediaPickerTopDetectFacePart", "onPartStop...");
    }

    public /* synthetic */ QCircleMediaPickerTopDetectFacePart(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? false : z17);
    }
}
