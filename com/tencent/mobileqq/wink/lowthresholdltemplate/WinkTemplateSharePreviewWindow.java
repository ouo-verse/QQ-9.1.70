package com.tencent.mobileqq.wink.lowthresholdltemplate;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.view.video.WinkPlayerContainerView;
import com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewWindow;
import com.tencent.mobileqq.wink.lowthresholdltemplate.b;
import com.tencent.mobileqq.wink.lowthresholdltemplate.p;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.publish.OneClickPublishingHelper;
import com.tencent.mobileqq.wink.utils.ar;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.IRenderTimeListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\"\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\b\u0010\"\u001a\u00020\u000eH\u0014J\u0012\u0010%\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J&\u0010*\u001a\u0004\u0018\u00010\u00142\u0006\u0010'\u001a\u00020&2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010+\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020#H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016J\b\u0010/\u001a\u00020\u0004H\u0016J\b\u00100\u001a\u00020\u0002H\u0016J\b\u00101\u001a\u00020\u0002H\u0016J\u0006\u00102\u001a\u00020\u0002J\u0006\u00103\u001a\u00020\u0002J\u000e\u00104\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0014R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010B\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010HR\u0016\u0010Y\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010LR\u0016\u0010[\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010LR\u0016\u0010]\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010PR\u0016\u0010_\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010OR\u0018\u0010b\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010OR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010k\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010SR\u0016\u0010m\u001a\u00020i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010SR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010u\u001a\u00020r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010t\u00a8\u0006x"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewWindow;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Yh", "", "selected", "Vh", "Zh", "ni", "gi", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", QQWinkConstants.COVER_PATH, "Wh", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/a;", "data", "Th", "Landroid/view/View;", "contentView", "registerDaTongReportPageId", "view", "li", "ki", WidgetCacheLunarData.JI, "ii", "mi", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getLogTag", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "outState", "onSaveInstanceState", "needStatusTrans", "needImmersive", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "initData", "initView", "ci", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "qusHalfScreenFloatingView", "Lcom/tencent/mobileqq/wink/context/p;", "D", "Lcom/tencent/mobileqq/wink/context/p;", "winkCurrentContextBuilder", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewViewModel;", "E", "Lkotlin/Lazy;", "Xh", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewViewModel;", "viewModel", UserInfo.SEX_FEMALE, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/cardview/widget/CardView;", "G", "Landroidx/cardview/widget/CardView;", "playerFrame", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "title", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "loadingBg", "Landroid/widget/CheckBox;", "J", "Landroid/widget/CheckBox;", "syncQzone", "K", "saveShare", "L", "saveShareBtn", "M", "errorRetry", "N", "toggle", "P", "isCheckSyncQzone", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "templateId", BdhLogUtil.LogTag.Tag_Req, "isVideoReady", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "loadingDialog", "", "T", "startTime", "U", "loadVideoTime", "Lcom/tencent/mobileqq/wink/editor/dr;", "V", "Lcom/tencent/mobileqq/wink/editor/dr;", "cut", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p;", "W", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p;", "winkTemplateShareConfig", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkTemplateSharePreviewWindow extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView qusHalfScreenFloatingView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.wink.context.p winkCurrentContextBuilder = new com.tencent.mobileqq.wink.context.p();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: G, reason: from kotlin metadata */
    private CardView playerFrame;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView title;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView loadingBg;

    /* renamed from: J, reason: from kotlin metadata */
    private CheckBox syncQzone;

    /* renamed from: K, reason: from kotlin metadata */
    private CardView saveShare;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView saveShareBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView errorRetry;

    /* renamed from: N, reason: from kotlin metadata */
    private ImageView toggle;

    /* renamed from: P, reason: from kotlin metadata */
    private int isCheckSyncQzone;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String templateId;

    /* renamed from: R, reason: from kotlin metadata */
    private int isVideoReady;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog loadingDialog;

    /* renamed from: T, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: U, reason: from kotlin metadata */
    private long loadVideoTime;

    /* renamed from: V, reason: from kotlin metadata */
    private dr cut;

    /* renamed from: W, reason: from kotlin metadata */
    private p winkTemplateShareConfig;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewWindow$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "defaultHeight", NodeProps.MAX_HEIGHT, "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            WinkTemplateSharePreviewWindow winkTemplateSharePreviewWindow = WinkTemplateSharePreviewWindow.this;
            View inflate = LayoutInflater.from(winkTemplateSharePreviewWindow.getContext()).inflate(R.layout.i5w, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ate_share_fragment, null)");
            winkTemplateSharePreviewWindow.rootView = inflate;
            WinkTemplateSharePreviewWindow winkTemplateSharePreviewWindow2 = WinkTemplateSharePreviewWindow.this;
            View view = winkTemplateSharePreviewWindow2.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
            winkTemplateSharePreviewWindow2.ci(view);
            WinkTemplateSharePreviewWindow.this.Zh();
            WinkTemplateSharePreviewWindow.this.gi();
            WinkTemplateSharePreviewWindow winkTemplateSharePreviewWindow3 = WinkTemplateSharePreviewWindow.this;
            View view2 = winkTemplateSharePreviewWindow3.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            winkTemplateSharePreviewWindow3.registerDaTongReportPageId(view2);
            View view3 = WinkTemplateSharePreviewWindow.this.rootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                return null;
            }
            return view3;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        /* renamed from: defaultHeight */
        public int getF57420e() {
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            p pVar = WinkTemplateSharePreviewWindow.this.winkTemplateShareConfig;
            if (pVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                pVar = null;
            }
            return pVar.e().getWindowHeight();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    public WinkTemplateSharePreviewWindow() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkTemplateSharePreviewViewModel>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewWindow$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkTemplateSharePreviewViewModel invoke() {
                WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel = (WinkTemplateSharePreviewViewModel) WinkTemplateSharePreviewWindow.this.getViewModel(WinkTemplateSharePreviewViewModel.class);
                p pVar = WinkTemplateSharePreviewWindow.this.winkTemplateShareConfig;
                if (pVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                    pVar = null;
                }
                winkTemplateSharePreviewViewModel.k2(pVar);
                return winkTemplateSharePreviewViewModel;
            }
        });
        this.viewModel = lazy;
        this.templateId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(com.tencent.mobileqq.wink.lowthresholdltemplate.a data) {
        w53.b.a(getTAG(), "buildPreview: " + data.getWinkEditDataWrapper());
        WinkEditorResourceManager.a1().i0(data.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String());
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        WinkPlayerContainerView winkPlayerContainerView = new WinkPlayerContainerView(requireContext);
        CardView cardView = this.playerFrame;
        dr drVar = null;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerFrame");
            cardView = null;
        }
        cardView.addView(winkPlayerContainerView);
        WinkVideoTavCut f16 = WinkPlayerContainerView.f(winkPlayerContainerView, data.getWinkTavCutParams(), null, null, false, null, 30, null);
        this.cut = f16;
        if (f16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cut");
            f16 = null;
        }
        f16.setAutoPlay(true);
        winkPlayerContainerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkTemplateSharePreviewWindow.Uh(WinkTemplateSharePreviewWindow.this, view);
            }
        });
        dr drVar2 = this.cut;
        if (drVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cut");
        } else {
            drVar = drVar2;
        }
        ((WinkVideoTavCut) drVar).Q2(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(WinkTemplateSharePreviewWindow this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dr drVar = this$0.cut;
        dr drVar2 = null;
        if (drVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cut");
            drVar = null;
        }
        if (drVar.isPlaying()) {
            ImageView imageView = this$0.toggle;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toggle");
                imageView = null;
            }
            imageView.setVisibility(0);
            dr drVar3 = this$0.cut;
            if (drVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cut");
            } else {
                drVar2 = drVar3;
            }
            drVar2.pause();
        } else {
            ImageView imageView2 = this$0.toggle;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toggle");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
            dr drVar4 = this$0.cut;
            if (drVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cut");
            } else {
                drVar2 = drVar4;
            }
            drVar2.play();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Vh(boolean selected) {
        Drawable drawable;
        CheckBox checkBox = this.syncQzone;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
            checkBox = null;
        }
        if (selected) {
            if (QQTheme.isNowThemeIsNight()) {
                drawable = ContextCompat.getDrawable(requireContext(), R.drawable.qvideo_skin_icon_publish_savetolocal_selected_dark);
            } else {
                drawable = ContextCompat.getDrawable(requireContext(), R.drawable.qvideo_skin_icon_publish_savetolocal_selected);
            }
        } else {
            drawable = ContextCompat.getDrawable(requireContext(), R.drawable.qvideo_skin_icon_publish_savetolocal_normal);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, ViewExKt.d(18), ViewExKt.d(18));
        } else {
            drawable = null;
        }
        checkBox.setCompoundDrawables(drawable, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Wh(WinkEditDataWrapper winkEditDataWrapper, MetaMaterial material, String coverPath) {
        boolean z16;
        boolean isBlank;
        Bundle bundle = new Bundle();
        p pVar = this.winkTemplateShareConfig;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        bundle.putBoolean(QQWinkConstants.WINK_PUBLISH_PARAM_IS_SAVE_MEDIA, pVar.c().getNeedSaveToMedia());
        p pVar3 = this.winkTemplateShareConfig;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar3 = null;
        }
        bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, pVar3.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String());
        CheckBox checkBox = this.syncQzone;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
            checkBox = null;
        }
        if (checkBox.isChecked()) {
            bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_SYNC_QZONE, "1");
        }
        com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
        com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
        p pVar4 = this.winkTemplateShareConfig;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar4 = null;
        }
        bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, pVar4.c().getTaskId());
        OneClickPublishingHelper oneClickPublishingHelper = OneClickPublishingHelper.f325628a;
        String missionId = winkEditDataWrapper.getMissionId();
        Intrinsics.checkNotNull(missionId);
        OneClickPublishingHelper.z(oneClickPublishingHelper, 0, missionId, coverPath, com.tencent.mobileqq.wink.editor.c.L0(material) + "#" + com.tencent.mobileqq.wink.editor.c.M0(material), bundle, false, 32, null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        p pVar5 = this.winkTemplateShareConfig;
        if (pVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar5 = null;
        }
        String publishingToastText = pVar5.e().getPublishingToastText();
        if (publishingToastText != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(publishingToastText);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    Context c16 = com.tencent.mobileqq.wink.b.c();
                    p pVar6 = this.winkTemplateShareConfig;
                    if (pVar6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                    } else {
                        pVar2 = pVar6;
                    }
                    QQToast.makeText(c16, 0, pVar2.e().getPublishingToastText(), 1).show();
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkTemplateSharePreviewViewModel Xh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (WinkTemplateSharePreviewViewModel) value;
    }

    private final void Yh() {
        p pVar = this.winkTemplateShareConfig;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        p.PerformanceConfig performanceConfig = pVar.getPerformanceConfig();
        if (performanceConfig != null) {
            String pKNoPublishClickCountKey = performanceConfig.getPKNoPublishClickCountKey();
            if (pKNoPublishClickCountKey != null) {
                AECameraPrefsUtil.c().i(pKNoPublishClickCountKey, AECameraPrefsUtil.c().d(pKNoPublishClickCountKey, 0, 0) + 1, 0);
            }
            String pKLastShowTimeKey = performanceConfig.getPKLastShowTimeKey();
            if (pKLastShowTimeKey != null) {
                AECameraPrefsUtil.c().j(pKLastShowTimeKey, System.currentTimeMillis(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh() {
        this.startTime = System.currentTimeMillis();
        LiveData<Result<com.tencent.mobileqq.wink.lowthresholdltemplate.a>> Z1 = Xh().Z1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends com.tencent.mobileqq.wink.lowthresholdltemplate.a>, Unit> function1 = new Function1<Result<? extends com.tencent.mobileqq.wink.lowthresholdltemplate.a>, Unit>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewWindow$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends a> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends a> it) {
                long j3;
                CheckBox checkBox;
                TextView textView;
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
                WinkTemplateSharePreviewWindow.this.isVideoReady = 1;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                boolean m483isSuccessimpl = Result.m483isSuccessimpl(it.getValue());
                CheckBox checkBox2 = null;
                if (!m483isSuccessimpl) {
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(it.getValue());
                    if (m479exceptionOrNullimpl != null) {
                        WinkTemplateSharePreviewWindow winkTemplateSharePreviewWindow = WinkTemplateSharePreviewWindow.this;
                        if (m479exceptionOrNullimpl instanceof CancellationException) {
                            return;
                        }
                        w53.b.d(winkTemplateSharePreviewWindow.getTAG(), "observa video prepare fail", m479exceptionOrNullimpl);
                        textView = winkTemplateSharePreviewWindow.errorRetry;
                        if (textView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("errorRetry");
                            textView = null;
                        }
                        textView.setVisibility(0);
                        qCircleCommonLoadingDialog = winkTemplateSharePreviewWindow.loadingDialog;
                        if (qCircleCommonLoadingDialog != null) {
                            qCircleCommonLoadingDialog.dismiss();
                        }
                    }
                } else {
                    WinkTemplateSharePreviewWindow winkTemplateSharePreviewWindow2 = WinkTemplateSharePreviewWindow.this;
                    long currentTimeMillis = System.currentTimeMillis();
                    j3 = WinkTemplateSharePreviewWindow.this.startTime;
                    winkTemplateSharePreviewWindow2.loadVideoTime = currentTimeMillis - j3;
                    WinkTemplateSharePreviewWindow.this.ii();
                    WinkTemplateSharePreviewWindow winkTemplateSharePreviewWindow3 = WinkTemplateSharePreviewWindow.this;
                    Object value = it.getValue();
                    ResultKt.throwOnFailure(value);
                    winkTemplateSharePreviewWindow3.Th((a) value);
                    WinkTemplateSharePreviewWindow winkTemplateSharePreviewWindow4 = WinkTemplateSharePreviewWindow.this;
                    Object value2 = it.getValue();
                    ResultKt.throwOnFailure(value2);
                    winkTemplateSharePreviewWindow4.templateId = ((a) value2).getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().f30533id;
                }
                checkBox = WinkTemplateSharePreviewWindow.this.syncQzone;
                if (checkBox == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
                } else {
                    checkBox2 = checkBox;
                }
                checkBox2.setEnabled(m483isSuccessimpl);
            }
        };
        Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkTemplateSharePreviewWindow.ai(Function1.this, obj);
            }
        });
        LiveData<t73.a<com.tencent.mobileqq.wink.lowthresholdltemplate.b>> a26 = Xh().a2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<t73.a<? extends com.tencent.mobileqq.wink.lowthresholdltemplate.b>, Unit> function12 = new Function1<t73.a<? extends com.tencent.mobileqq.wink.lowthresholdltemplate.b>, Unit>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewWindow$initObserve$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(t73.a<? extends b> aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(t73.a<? extends b> aVar) {
                CardView cardView;
                QCircleCommonLoadingDialog qCircleCommonLoadingDialog;
                CheckBox checkBox;
                b a16 = aVar.a();
                if (Intrinsics.areEqual(a16, b.c.f323441a)) {
                    QQToast.makeText(WinkTemplateSharePreviewWindow.this.getContext(), R.string.f238897l0, 1).show();
                    WinkTemplateSharePreviewWindow.this.ji();
                    return;
                }
                View view = null;
                if (Intrinsics.areEqual(a16, b.d.f323442a)) {
                    WinkTemplateSharePreviewWindow.this.ni();
                    qCircleCommonLoadingDialog = WinkTemplateSharePreviewWindow.this.loadingDialog;
                    if (qCircleCommonLoadingDialog != null) {
                        qCircleCommonLoadingDialog.dismiss();
                    }
                    checkBox = WinkTemplateSharePreviewWindow.this.syncQzone;
                    if (checkBox == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
                    } else {
                        view = checkBox;
                    }
                    view.setEnabled(true);
                    return;
                }
                if (Intrinsics.areEqual(a16, b.C9054b.f323440a)) {
                    dr drVar = WinkTemplateSharePreviewWindow.this.cut;
                    if (drVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cut");
                        drVar = null;
                    }
                    drVar.pause();
                    cardView = WinkTemplateSharePreviewWindow.this.saveShare;
                    if (cardView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("saveShare");
                    } else {
                        view = cardView;
                    }
                    view.setEnabled(false);
                    return;
                }
                if (a16 instanceof b.SaveShare) {
                    if (NetworkUtil.isNetSupport(WinkTemplateSharePreviewWindow.this.requireContext())) {
                        b.SaveShare saveShare = (b.SaveShare) a16;
                        WinkTemplateSharePreviewWindow.this.Wh(saveShare.getWinkEditDataWrapper(), saveShare.getMaterial(), saveShare.getCoverPath());
                    } else {
                        QQToast.makeText(WinkTemplateSharePreviewWindow.this.requireContext(), R.string.f216085xc, 1).show();
                    }
                }
            }
        };
        a26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.v
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkTemplateSharePreviewWindow.bi(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(WinkTemplateSharePreviewWindow this$0, CompoundButton view, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        p pVar = this$0.winkTemplateShareConfig;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        if (pVar.e().getSaveSyncQzoneStatus()) {
            p pVar3 = this$0.winkTemplateShareConfig;
            if (pVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            } else {
                pVar2 = pVar3;
            }
            String saveSyncQzoneStatusKey = pVar2.e().getSaveSyncQzoneStatusKey();
            if (saveSyncQzoneStatusKey != null) {
                ar.f326685a.m(saveSyncQzoneStatusKey, z16);
            }
        }
        this$0.Vh(z16);
        this$0.isCheckSyncQzone = z16 ? 1 : 0;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.li(view);
        EventCollector.getInstance().onCompoundButtonChecked(view, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(WinkTemplateSharePreviewWindow this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gi();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi(WinkTemplateSharePreviewWindow this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gi() {
        p pVar = null;
        TextView textView = null;
        if (!NetworkUtil.isNetSupport(requireContext())) {
            TextView textView2 = this.errorRetry;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorRetry");
            } else {
                textView = textView2;
            }
            textView.setVisibility(0);
            w53.b.c(QPublicBaseFragment.TAG, "preparePreview: net error");
            return;
        }
        TextView textView3 = this.errorRetry;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorRetry");
            textView3 = null;
        }
        textView3.setVisibility(8);
        QCircleCommonLoadingDialog.c p16 = new QCircleCommonLoadingDialog.c(getContext()).n(false).h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkTemplateSharePreviewWindow.hi(WinkTemplateSharePreviewWindow.this, view);
            }
        }).p(getString(R.string.f216385y6));
        p pVar2 = this.winkTemplateShareConfig;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
        } else {
            pVar = pVar2;
        }
        QCircleCommonLoadingDialog a16 = p16.j("template_share_preview" + pVar.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String()).a();
        this.loadingDialog = a16;
        if (a16 != null) {
            a16.show();
        }
        Xh().j2(false, "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(WinkTemplateSharePreviewWindow this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.loadingDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        this$0.Xh().U1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii() {
        String str;
        HashMap<String, Object> c16;
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        p pVar = this.winkTemplateShareConfig;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        p.PerformanceConfig performanceConfig = pVar.getPerformanceConfig();
        if (performanceConfig != null && (c16 = performanceConfig.c()) != null) {
            params.putAll(c16);
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_VIDEO_LOAD_LENGTH, Long.valueOf(this.loadVideoTime));
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_AVATAR_VIDEO_LOAD_FINISH);
        p pVar2 = this.winkTemplateShareConfig;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar2 = null;
        }
        p.PerformanceConfig performanceConfig2 = pVar2.getPerformanceConfig();
        if (performanceConfig2 != null) {
            str = performanceConfig2.getDTPageId();
        } else {
            str = null;
        }
        params.put("xsj_custom_pgid", str);
        VideoReport.reportEvent("ev_xsj_camera_action", null, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji() {
        String str;
        HashMap<String, Object> c16;
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        p pVar = this.winkTemplateShareConfig;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        p.PerformanceConfig performanceConfig = pVar.getPerformanceConfig();
        if (performanceConfig != null && (c16 = performanceConfig.c()) != null) {
            params.putAll(c16);
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_AVATAR_VIDEO_LOADING_TOAST);
        p pVar2 = this.winkTemplateShareConfig;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar2 = null;
        }
        p.PerformanceConfig performanceConfig2 = pVar2.getPerformanceConfig();
        if (performanceConfig2 != null) {
            str = performanceConfig2.getDTPageId();
        } else {
            str = null;
        }
        params.put("xsj_custom_pgid", str);
        VideoReport.reportEvent("ev_xsj_camera_action", null, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ki(View view) {
        String str;
        HashMap<String, Object> c16;
        Map<String, ?> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SYNC_QZONE_BUTTON_STATUS, Integer.valueOf(this.isCheckSyncQzone));
        params.put("xsj_template_id", this.templateId);
        p pVar = this.winkTemplateShareConfig;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        params.put("xsj_operation_activity_id", pVar.c().getTaskId());
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_AVATAR_VIDEO_READY, Integer.valueOf(this.isVideoReady));
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_SAVE_PUBLISH_BUTTON);
        p pVar3 = this.winkTemplateShareConfig;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar3 = null;
        }
        p.PerformanceConfig performanceConfig = pVar3.getPerformanceConfig();
        if (performanceConfig != null) {
            str = performanceConfig.getDTPageId();
        } else {
            str = null;
        }
        params.put("xsj_custom_pgid", str);
        p pVar4 = this.winkTemplateShareConfig;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
        } else {
            pVar2 = pVar4;
        }
        p.PerformanceConfig performanceConfig2 = pVar2.getPerformanceConfig();
        if (performanceConfig2 != null && (c16 = performanceConfig2.c()) != null) {
            params.putAll(c16);
        }
        com.tencent.mobileqq.wink.report.e.f326265a.q("ev_xsj_camera_action", view, WinkDaTongReportConstant.ElementId.EM_XSJ_SAVE_PUBLISH_BUTTON, params, params);
    }

    private final void li(View view) {
        HashMap<String, Object> c16;
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        p pVar = this.winkTemplateShareConfig;
        String str = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        p.PerformanceConfig performanceConfig = pVar.getPerformanceConfig();
        if (performanceConfig != null && (c16 = performanceConfig.c()) != null) {
            params.putAll(c16);
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_SYNC_QZONE_BUTTON);
        p pVar2 = this.winkTemplateShareConfig;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar2 = null;
        }
        p.PerformanceConfig performanceConfig2 = pVar2.getPerformanceConfig();
        if (performanceConfig2 != null) {
            str = performanceConfig2.getDTPageId();
        }
        params.put("xsj_custom_pgid", str);
        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_SYNC_QZONE_BUTTON_STATUS, Integer.valueOf(this.isCheckSyncQzone));
        com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "ev_xsj_abnormal_clck", view, WinkDaTongReportConstant.ElementId.EM_XSJ_SYNC_QZONE_BUTTON, params, null, 16, null);
    }

    private final void mi() {
        WinkDTParamBuilder.setDtParams(requireActivity().getIntent());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni() {
        p pVar = this.winkTemplateShareConfig;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        if (!pVar.e().getNeedHideTitle()) {
            return;
        }
        TextView textView = this.title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        if (textView.getVisibility() != 0) {
            return;
        }
        w53.b.a(QPublicBaseFragment.TAG, "timerTitle start");
        p pVar3 = this.winkTemplateShareConfig;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
        } else {
            pVar2 = pVar3;
        }
        new c(pVar2.e().getTitleValidTime()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerDaTongReportPageId(View contentView) {
        p pVar = this.winkTemplateShareConfig;
        HashMap<String, Object> hashMap = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        if (pVar.getPerformanceConfig() == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        p pVar2 = this.winkTemplateShareConfig;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar2 = null;
        }
        p.PerformanceConfig performanceConfig = pVar2.getPerformanceConfig();
        Intrinsics.checkNotNull(performanceConfig);
        VideoReport.setPageId(contentView, performanceConfig.getDTPageId());
        String c16 = WinkContext.INSTANCE.d().getDtParams().c();
        WinkDTParamBuilder winkDTParamBuilder = new WinkDTParamBuilder();
        p pVar3 = this.winkTemplateShareConfig;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar3 = null;
        }
        p.PerformanceConfig performanceConfig2 = pVar3.getPerformanceConfig();
        if (performanceConfig2 != null) {
            hashMap = performanceConfig2.e();
        }
        VideoReport.setPageParams(contentView, winkDTParamBuilder.buildPageParams(hashMap, c16));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v19, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v42 */
    /* JADX WARN: Type inference failed for: r10v43 */
    /* JADX WARN: Type inference failed for: r10v44 */
    public final void ci(@NotNull View view) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.f25850by);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.player_frame)");
        this.playerFrame = (CardView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.title)");
        this.title = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f9142555);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.sync_qzone)");
        this.syncQzone = (CheckBox) findViewById3;
        View findViewById4 = view.findViewById(R.id.f794349r);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.save_share)");
        this.saveShare = (CardView) findViewById4;
        View findViewById5 = view.findViewById(R.id.f794449s);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.save_share_btn)");
        this.saveShareBtn = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.uwl);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.errorRetry)");
        this.errorRetry = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.f99325ph);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.toggle)");
        this.toggle = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.ef9);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.loading_bg)");
        this.loadingBg = (ImageView) findViewById8;
        if (QQTheme.isNowThemeIsNight()) {
            view.setBackground(new ColorDrawable(-16777216));
        } else {
            view.setBackground(new ColorDrawable(-1));
        }
        TextView textView = this.title;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        p pVar = this.winkTemplateShareConfig;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        textView.setText(pVar.e().getTitle());
        p pVar2 = this.winkTemplateShareConfig;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar2 = null;
        }
        String placeholderImageUrl = pVar2.e().getPlaceholderImageUrl();
        if (placeholderImageUrl != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            URLDrawable drawable = URLDrawable.getDrawable(placeholderImageUrl, obtain);
            ImageView imageView = this.loadingBg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingBg");
                imageView = null;
            }
            imageView.setImageDrawable(drawable);
        }
        CardView cardView = this.saveShare;
        if (cardView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveShare");
            cardView = null;
        }
        if (!QQTheme.isNowThemeIsNight()) {
            str = "#0099ff";
        } else {
            str = "#0066cc";
        }
        cardView.setCardBackgroundColor(Color.parseColor(str));
        TextView textView3 = this.saveShareBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveShareBtn");
            textView3 = null;
        }
        Drawable drawable2 = ContextCompat.getDrawable(requireContext(), R.drawable.osi);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, ViewExKt.d(24), ViewExKt.d(24));
        } else {
            drawable2 = null;
        }
        textView3.setCompoundDrawables(drawable2, null, null, null);
        p pVar3 = this.winkTemplateShareConfig;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar3 = null;
        }
        String publishButtonText = pVar3.e().getPublishButtonText();
        if (publishButtonText != null) {
            TextView textView4 = this.saveShareBtn;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("saveShareBtn");
                textView4 = null;
            }
            textView4.setText(publishButtonText);
        }
        p pVar4 = this.winkTemplateShareConfig;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar4 = null;
        }
        boolean isSyncQzoneDefaultSelect = pVar4.e().getIsSyncQzoneDefaultSelect();
        p pVar5 = this.winkTemplateShareConfig;
        if (pVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar5 = null;
        }
        ?? r102 = isSyncQzoneDefaultSelect;
        if (pVar5.e().getSaveSyncQzoneStatus()) {
            p pVar6 = this.winkTemplateShareConfig;
            if (pVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                pVar6 = null;
            }
            String saveSyncQzoneStatusKey = pVar6.e().getSaveSyncQzoneStatusKey();
            r102 = isSyncQzoneDefaultSelect;
            if (saveSyncQzoneStatusKey != null) {
                r102 = ar.f326685a.c(saveSyncQzoneStatusKey, isSyncQzoneDefaultSelect);
            }
        }
        this.isCheckSyncQzone = r102;
        CheckBox checkBox = this.syncQzone;
        CheckBox checkBox2 = checkBox;
        if (checkBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
            checkBox2 = 0;
        }
        checkBox2.setChecked(r102);
        Vh(r102);
        Drawable drawable3 = ContextCompat.getDrawable(requireContext(), R.drawable.oeo);
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, ViewExKt.d(16), ViewExKt.d(16));
            drawable3.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
            TextView textView5 = this.errorRetry;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorRetry");
                textView5 = null;
            }
            textView5.setCompoundDrawables(drawable3, null, null, null);
            TextView textView6 = this.errorRetry;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorRetry");
                textView6 = null;
            }
            textView6.setCompoundDrawablePadding(ViewExKt.d(4));
        }
        CheckBox checkBox3 = this.syncQzone;
        if (checkBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("syncQzone");
            checkBox3 = null;
        }
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.w
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                WinkTemplateSharePreviewWindow.di(WinkTemplateSharePreviewWindow.this, compoundButton, z16);
            }
        });
        CardView cardView2 = this.saveShare;
        if (cardView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveShare");
            cardView2 = null;
        }
        cardView2.setOnClickListener(new WinkTemplateSharePreviewWindow$initTemplatePreview$7(this));
        TextView textView7 = this.errorRetry;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorRetry");
        } else {
            textView2 = textView7;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WinkTemplateSharePreviewWindow.ei(WinkTemplateSharePreviewWindow.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.e_o;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkTemplateSharePreviewWindow";
    }

    public final void initData() {
        mi();
        Yh();
    }

    public final void initView() {
        this.qusHalfScreenFloatingView = (QUSHalfScreenFloatingView) requireView().findViewById(R.id.f66743bg);
        if (QQTheme.isNowThemeIsNight()) {
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.qusHalfScreenFloatingView;
            if (qUSHalfScreenFloatingView != null) {
                qUSHalfScreenFloatingView.setThemeId(1002);
            }
        } else {
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.qusHalfScreenFloatingView;
            if (qUSHalfScreenFloatingView2 != null) {
                qUSHalfScreenFloatingView2.setThemeId(1001);
            }
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 != null) {
            qUSHalfScreenFloatingView3.r();
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 != null) {
            qUSHalfScreenFloatingView4.setQUSDragFloatController(new b());
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.qusHalfScreenFloatingView;
        if (qUSHalfScreenFloatingView5 != null) {
            qUSHalfScreenFloatingView5.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.s
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    WinkTemplateSharePreviewWindow.fi(WinkTemplateSharePreviewWindow.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        p pVar;
        super.onCreate(savedInstanceState);
        Intent intent = requireActivity().getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE);
            q qVar = new q();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Intrinsics.checkNotNull(stringExtra, "null cannot be cast to non-null type kotlin.String");
            pVar = qVar.e(requireActivity, stringExtra, intent.getExtras());
            w53.b.a(QPublicBaseFragment.TAG, stringExtra + ", " + pVar);
        } else {
            pVar = null;
        }
        if (pVar == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this.winkTemplateShareConfig = pVar;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewParent viewParent;
        View findViewById;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (findViewById = activity.findViewById(android.R.id.title)) != null) {
            viewParent = findViewById.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof FrameLayout) {
            ((FrameLayout) viewParent).setVisibility(8);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        dr drVar = this.cut;
        if (drVar != null) {
            ImageView imageView = null;
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cut");
                drVar = null;
            }
            drVar.pause();
            ImageView imageView2 = this.toggle;
            if (imageView2 != null) {
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("toggle");
                } else {
                    imageView = imageView2;
                }
                imageView.setVisibility(0);
            }
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.winkCurrentContextBuilder.a(null, requireActivity().getIntent());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        this.winkCurrentContextBuilder.c(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        this.winkCurrentContextBuilder.a(savedInstanceState, requireActivity().getIntent());
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            ImmersiveUtils.trySetImmersiveStatusBar(window);
            window.setLayout(-1, -1);
            ImmersiveUtils.clearCoverForStatus(window, true);
        }
        if (savedInstanceState == null) {
            initData();
            initView();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewWindow$c", "Landroid/os/CountDownTimer;", "", "l", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends CountDownTimer {
        c(long j3) {
            super(j3, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            w53.b.a(QPublicBaseFragment.TAG, "timerTitle end");
            TextView textView = WinkTemplateSharePreviewWindow.this.title;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("title");
                textView = null;
            }
            textView.setVisibility(8);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long l3) {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewWindow$a", "Lcom/tencent/tavcut/core/session/IRenderTimeListener;", "", "finishTimeInMs", "", "onFirstFrameTimeFinish", "frameTimeCostInMs", "renderNodeCostInMs", "currentRenderTimeInUs", "onRenderTimeCost", "onSingleFrameTimeCost", "", "a", "I", "firstTimes", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements IRenderTimeListener {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int firstTimes;

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkTemplateSharePreviewWindow this$0, ICutSession iCutSession) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WinkTemplateSharePreviewViewModel Xh = this$0.Xh();
            dr drVar = this$0.cut;
            if (drVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cut");
                drVar = null;
            }
            Xh.e2(iCutSession, ((WinkVideoTavCut) drVar).r1());
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onFirstFrameTimeFinish(long finishTimeInMs) {
            View view;
            if (this.firstTimes <= 1) {
                dr drVar = WinkTemplateSharePreviewWindow.this.cut;
                if (drVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cut");
                    drVar = null;
                }
                final ICutSession session = drVar.getSession();
                if (this.firstTimes > 0 && session != null && (view = WinkTemplateSharePreviewWindow.this.getView()) != null) {
                    final WinkTemplateSharePreviewWindow winkTemplateSharePreviewWindow = WinkTemplateSharePreviewWindow.this;
                    view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.z
                        @Override // java.lang.Runnable
                        public final void run() {
                            WinkTemplateSharePreviewWindow.a.b(WinkTemplateSharePreviewWindow.this, session);
                        }
                    }, 1000L);
                }
                this.firstTimes++;
            }
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onRenderTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }

        @Override // com.tencent.tavcut.core.session.IRenderTimeListener
        public void onSingleFrameTimeCost(long frameTimeCostInMs, long renderNodeCostInMs, long currentRenderTimeInUs) {
        }
    }
}
