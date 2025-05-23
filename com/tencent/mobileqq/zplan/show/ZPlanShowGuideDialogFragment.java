package com.tencent.mobileqq.zplan.show;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.api.IZPlanShowGuideApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 E2\u00020\u0001:\u0001FB\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060!\u00a2\u0006\u0004\bC\u0010DJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0002H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\b\u0010\u001c\u001a\u00020\u0006H\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0018\u00106\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u00105R\u0018\u00109\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/zplan/show/ZPlanShowGuideDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "eventKey", "", "source", "", "wh", "show", "initView", "Landroid/widget/ImageView;", "imageView", "xh", "url", "Lcom/tencent/image/URLDrawable;", "sh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Landroid/app/Dialog;", "onCreateDialog", "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "I", "getSource", "()I", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "getConfirmCallback", "()Lkotlin/jvm/functions/Function0;", "confirmCallback", "", "E", "Z", "showBubbleTip", UserInfo.SEX_FEMALE, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "mainTextView", "H", "subTextView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "button", "J", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "K", "Landroid/widget/ImageView;", "guideImageView", "Lcom/tencent/mobileqq/zplan/api/IZPlanShowGuideApi;", "L", "Lkotlin/Lazy;", "th", "()Lcom/tencent/mobileqq/zplan/api/IZPlanShowGuideApi;", "zPlanShowGuideApi", "<init>", "(ILkotlin/jvm/functions/Function0;)V", "M", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanShowGuideDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: M, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static AtomicInteger N = new AtomicInteger(0);

    /* renamed from: C, reason: from kotlin metadata */
    private final int source;

    /* renamed from: D, reason: from kotlin metadata */
    private final Function0<Unit> confirmCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean showBubbleTip;

    /* renamed from: F, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mainTextView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView subTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private QUIButton button;

    /* renamed from: J, reason: from kotlin metadata */
    private URLDrawable urlDrawable;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView guideImageView;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy zPlanShowGuideApi;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/show/ZPlanShowGuideDialogFragment$a;", "", "", "source", "Lkotlin/Function0;", "", "confirmCallback", "a", "SOURCE_CLOSE_INTIMATE_BUBBLE", "I", "SOURCE_FROM_CLICK_MSG", "SOURCE_FROM_CLICK_MSG_BUBBLE", "SOURCE_FROM_CLICK_PANEL", "SOURCE_FROM_CLICK_PANEL_BUBBLE", "SOURCE_FROM_ENTER_AIO", "SOURCE_FROM_ENTER_AIO_BUBBLE", "SOURCE_FROM_GRAY_TIP", "SOURCE_FROM_GRAY_TIP_BUBBLE", "SOURCE_FROM_UPGRADE_VIEW", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.show.ZPlanShowGuideDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int source, Function0<Unit> confirmCallback) {
            Intrinsics.checkNotNullParameter(confirmCallback, "confirmCallback");
            if (source == 1) {
                SuperQQShowGuideDialogConfig superQQShowGuideDialogConfig = SuperQQShowGuideDialogConfig.f335621a;
                if (superQQShowGuideDialogConfig.f()) {
                    new ZPlanShowGuideDialogFragment(source, confirmCallback).show();
                    superQQShowGuideDialogConfig.h();
                    return;
                }
                return;
            }
            if (source != 2 && source != 3 && source != 7) {
                if (source == 6) {
                    new ZPlanShowGuideDialogFragment(source, confirmCallback).show();
                }
            } else {
                if (SuperQQShowGuideDialogConfig.f335621a.g()) {
                    new ZPlanShowGuideDialogFragment(source, confirmCallback).show();
                    return;
                }
                com.tencent.aio.api.runtime.a onGetAIOContext = ((IZPlanShowGuideApi) QRoute.api(IZPlanShowGuideApi.class)).onGetAIOContext();
                if (onGetAIOContext != null) {
                    int i3 = 4;
                    if (source != 2) {
                        if (source == 3) {
                            i3 = 5;
                        } else if (source == 7) {
                            i3 = 9;
                        }
                    }
                    g.f335631a.i(i3, onGetAIOContext);
                }
            }
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/show/ZPlanShowGuideDialogFragment$b", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$e;", "Landroid/view/View;", "bottomSheet", "", "newState", "", "onStateChanged", "", "slideOffset", "onSlide", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends BottomSheetBehavior.e {
        b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onSlide(View bottomSheet, float slideOffset) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (QLog.isColorLevel()) {
                QLog.i("ZPlanShowGuideDialogFragment", 2, "onSlide\uff1aslideOffset = " + slideOffset);
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.e
        public void onStateChanged(View bottomSheet, int newState) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (QLog.isColorLevel()) {
                QLog.i("ZPlanShowGuideDialogFragment", 2, "onStateChanged\uff1anewState = " + newState);
            }
            if (newState == 4) {
                ZPlanShowGuideDialogFragment.this.dismiss();
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/show/ZPlanShowGuideDialogFragment$c", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f335625d;

        c(ImageView imageView) {
            this.f335625d = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            QLog.i("ZPlanShowGuideDialogFragment", 2, "setGuideImage onLoadFialed=" + cause);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
            QLog.i("ZPlanShowGuideDialogFragment", 2, "setGuideImage onLoadProgressed=" + progress);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable drawable) {
            this.f335625d.setImageDrawable(drawable);
            QLog.i("ZPlanShowGuideDialogFragment", 2, "setGuideImage download success");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
            QLog.i("ZPlanShowGuideDialogFragment", 2, "setGuideImage onLoadCanceled");
        }
    }

    public ZPlanShowGuideDialogFragment(int i3, Function0<Unit> confirmCallback) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(confirmCallback, "confirmCallback");
        this.source = i3;
        this.confirmCallback = confirmCallback;
        this.showBubbleTip = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IZPlanShowGuideApi>() { // from class: com.tencent.mobileqq.zplan.show.ZPlanShowGuideDialogFragment$zPlanShowGuideApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IZPlanShowGuideApi invoke() {
                QRouteApi api = QRoute.api(IZPlanShowGuideApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanShowGuideApi::class.java)");
                return (IZPlanShowGuideApi) api;
            }
        });
        this.zPlanShowGuideApi = lazy;
    }

    private final void initView() {
        Context context;
        TextView textView;
        View view = this.rootView;
        if (view == null) {
            return;
        }
        this.mainTextView = (TextView) view.findViewById(R.id.f163492qf0);
        this.subTextView = (TextView) view.findViewById(R.id.qez);
        this.button = (QUIButton) view.findViewById(R.id.f163493qf1);
        this.guideImageView = (ImageView) view.findViewById(R.id.pyl);
        QLog.i("ZPlanShowGuideDialogFragment", 2, "setGuideImage start");
        ImageView imageView = this.guideImageView;
        if (imageView != null) {
            xh(imageView);
        }
        QLog.i("ZPlanShowGuideDialogFragment", 2, "setGuideImage end");
        TextView textView2 = this.mainTextView;
        if (textView2 != null) {
            textView2.setText(SuperQQShowGuideDialogConfig.f335621a.d().getMainTitle());
        }
        TextView textView3 = this.subTextView;
        if (textView3 != null) {
            textView3.setText(SuperQQShowGuideDialogConfig.f335621a.d().getSubTitle());
        }
        QUIButton qUIButton = this.button;
        if (qUIButton != null) {
            qUIButton.setText(SuperQQShowGuideDialogConfig.f335621a.d().getButtonTitle());
        }
        if ((SuperQQShowGuideDialogConfig.f335621a.d().getSubTitle().length() == 0) && (textView = this.subTextView) != null) {
            textView.setVisibility(8);
        }
        if (QQTheme.isNowThemeIsNight() && (context = getContext()) != null) {
            TextView textView4 = this.mainTextView;
            if (textView4 != null) {
                textView4.setTextColor(context.getResources().getColor(R.color.f8356q));
            }
            TextView textView5 = this.subTextView;
            if (textView5 != null) {
                textView5.setTextColor(context.getResources().getColor(R.color.f8737r));
            }
        }
        QUIButton qUIButton2 = this.button;
        if (qUIButton2 != null) {
            qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.show.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ZPlanShowGuideDialogFragment.uh(ZPlanShowGuideDialogFragment.this, view2);
                }
            });
        }
    }

    private final URLDrawable sh(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, option)");
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void show() {
        com.tencent.aio.api.runtime.a onGetAIOContext = th().onGetAIOContext();
        if (onGetAIOContext != null) {
            try {
                show(onGetAIOContext.c().requireActivity().getSupportFragmentManager(), "ZPlanShowGuideDialogFragment");
                wh("imp", this.source);
            } catch (Exception e16) {
                QLog.e("ZPlanShowGuideDialogFragment", 2, "ZPlanShowGuideDialogFragment\uff1ashow error = " + e16);
            }
        }
    }

    private final IZPlanShowGuideApi th() {
        return (IZPlanShowGuideApi) this.zPlanShowGuideApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(ZPlanShowGuideDialogFragment this$0, View view) {
        com.tencent.aio.api.runtime.a onGetAIOContext;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBubbleTip = false;
        this$0.dismiss();
        this$0.confirmCallback.invoke();
        SuperQQShowGuideDialogConfig.f335621a.i();
        this$0.wh("click", this$0.source);
        int i3 = this$0.source;
        if ((i3 == 1 || i3 == 2 || i3 == 3) && (onGetAIOContext = this$0.th().onGetAIOContext()) != null) {
            g.f335631a.i(8, onGetAIOContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean vh(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
        return false;
    }

    private final void xh(ImageView imageView) {
        QLog.i("ZPlanShowGuideDialogFragment", 2, "setGuideImage enter");
        String backgroundUrl = SuperQQShowGuideDialogConfig.f335621a.d().getBackgroundUrl();
        if (backgroundUrl.length() == 0) {
            QLog.i("ZPlanShowGuideDialogFragment", 2, "setGuideImage url is Empty");
            return;
        }
        URLDrawable sh5 = sh(backgroundUrl);
        this.urlDrawable = sh5;
        if (sh5 == null) {
            return;
        }
        if (sh5.getStatus() == 1) {
            imageView.setImageDrawable(sh5);
            QLog.i("ZPlanShowGuideDialogFragment", 2, "setGuideImage cache success");
        } else {
            sh5.setURLDrawableListener(new c(imageView));
            sh5.startDownload();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        N.incrementAndGet();
        super.onCreate(savedInstanceState);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        aVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mobileqq.zplan.show.c
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                boolean vh5;
                vh5 = ZPlanShowGuideDialogFragment.vh(dialogInterface, i3, keyEvent);
                return vh5;
            }
        });
        BottomSheetBehavior<FrameLayout> behavior = aVar.getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "dialog.behavior");
        behavior.setState(3);
        behavior.setPeekHeight(0);
        behavior.setSkipCollapsed(true);
        behavior.addBottomSheetCallback(new b());
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.rootView = inflater.inflate(R.layout.dfd, container);
        initView();
        return this.rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        com.tencent.aio.api.runtime.a onGetAIOContext;
        if (this.source == 1 && this.showBubbleTip && (onGetAIOContext = th().onGetAIOContext()) != null) {
            g.f335631a.i(7, onGetAIOContext);
        }
        URLDrawable uRLDrawable = this.urlDrawable;
        if (uRLDrawable != null) {
            uRLDrawable.setURLDrawableListener(null);
        }
        this.urlDrawable = null;
        super.onDestroy();
        N.decrementAndGet();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.rootView;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(0);
        }
    }

    private final void wh(String eventKey, int source) {
        Map mapOf;
        try {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_guide_toast_source", Integer.valueOf(source)), TuplesKt.to("zplan_action_type", eventKey));
            VideoReport.reportEvent("ev_zplan_guide_toast", mapOf);
        } catch (Exception e16) {
            QLog.e("ZPlanShowGuideDialogFragment", 2, "ZPlanShowGuideDialogFragment\uff1areport error = " + e16);
        }
    }
}
