package com.tencent.mobileqq.wink.editor.aitemplate;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi;
import com.tencent.mobileqq.wink.editor.WinkImageTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.mosaic.model.MosaicData;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.mosaic.model.MosaicLinePath;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonParamEnum;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.RectF;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$GetStatusReply;

@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\b\u0018\u0000 f2\u00020\u0001:\u0002noB\u0007\u00a2\u0006\u0004\bl\u0010mJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J/\u0010\u0014\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u001e\u0010\u001d\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\fH\u0002J\b\u0010%\u001a\u00020\fH\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u001aH\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016J\b\u0010/\u001a\u00020\u000fH\u0016J\u0012\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u000100H\u0016J\"\u00107\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000f2\b\u00106\u001a\u0004\u0018\u000105H\u0016J\b\u00108\u001a\u00020\fH\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010:\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010=\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010;H\u0016R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0016\u0010U\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010g\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR \u0010k\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010j\u00a8\u0006p"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Qa", "La", "gb", "fb", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "ab", "", TVKCommonParamEnum.REQ_PARAM_KEY_RETRY, "Ma", "", "dialogTitle", "dialogMsg", "Lkotlin/Function0;", "onConfirm", "ib", "(Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;)V", "metaMaterial", "bb", "cb", "", "", "aigcImagePaths", "isRegenerate", "Za", "imagePath", "eb", "Xa", "Wa", "Ya", "mb", "Va", "Ua", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, UinConfigManager.KEY_HB, "initViewModel", "Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateUIData;", "Pa", "lb", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "oa", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onBackEvent", "onInitView", "initAfterInflation", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "uiData", "N9", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "M", "Lkotlin/Lazy;", "Oa", "()Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "qzoneTemplateViewModel", "Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateViewModel;", "N", "Na", "()Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateViewModel;", "aiTemplateViewModel", "Lcom/tencent/mobileqq/wink/editor/aitemplate/a;", "P", "Lcom/tencent/mobileqq/wink/editor/aitemplate/a;", "styleAdapter", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "materialCategory", BdhLogUtil.LogTag.Tag_Req, "shareInfoCategory", ExifInterface.LATITUDE_SOUTH, "I", "selectedIndex", "T", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "clickMaterial", "Landroid/widget/ImageView;", "U", "Landroid/widget/ImageView;", "shieldBtn", "Landroid/widget/TextView;", "V", "Landroid/widget/TextView;", "chanceText", "Landroidx/recyclerview/widget/RecyclerView;", "W", "Landroidx/recyclerview/widget/RecyclerView;", "styleRv", "X", "Z", "firstShowConfirmDialog", "", "Y", "Ljava/util/Map;", "aiResultMap", "<init>", "()V", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorAITemplateMenuPart extends WinkEditorMenuPart {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy qzoneTemplateViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy aiTemplateViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private a styleAdapter;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private MetaCategory materialCategory;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private MetaCategory shareInfoCategory;

    /* renamed from: S, reason: from kotlin metadata */
    private int selectedIndex;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial clickMaterial;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private ImageView shieldBtn;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private TextView chanceText;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private RecyclerView styleRv;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean firstShowConfirmDialog;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> aiResultMap;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateMenuPart$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int dpToPx;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildLayoutPosition(view) == 0) {
                dpToPx = ImmersiveUtils.dpToPx(17.6f);
            } else {
                dpToPx = ImmersiveUtils.dpToPx(13.2f);
            }
            outRect.left = dpToPx;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateMenuPart$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    public WinkEditorAITemplateMenuPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkQZoneTemplateLibViewModel>() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateMenuPart$qzoneTemplateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkQZoneTemplateLibViewModel invoke() {
                return (WinkQZoneTemplateLibViewModel) WinkEditorAITemplateMenuPart.this.getViewModel(WinkQZoneTemplateLibViewModel.class);
            }
        });
        this.qzoneTemplateViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkEditorAITemplateViewModel>() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateMenuPart$aiTemplateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkEditorAITemplateViewModel invoke() {
                return (WinkEditorAITemplateViewModel) WinkEditorAITemplateMenuPart.this.getViewModel(WinkEditorAITemplateViewModel.class);
            }
        });
        this.aiTemplateViewModel = lazy2;
        this.selectedIndex = -1;
        this.firstShowConfirmDialog = true;
        this.aiResultMap = new LinkedHashMap();
    }

    private final void La() {
        VideoReport.setElementId(this.shieldBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_AI_TEMPLATE_CANCEL);
        VideoReport.setElementParams(this.shieldBtn, WinkDTParamBuilder.buildElementParams());
        VideoReport.setElementExposePolicy(this.shieldBtn, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.shieldBtn, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.shieldBtn, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
    
        if (r3 == true) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Ma(boolean retry) {
        boolean z16;
        boolean z17;
        MetaMaterial metaMaterial = this.clickMaterial;
        if (metaMaterial == null) {
            w53.b.c("WinkEditorAITemplateMenuPart", "clickMaterial is null");
            return;
        }
        Map<String, String> map = this.aiResultMap;
        Intrinsics.checkNotNull(metaMaterial);
        String str = map.get(metaMaterial.f30533id);
        if (str != null) {
            z16 = true;
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (z16 && !retry) {
            eb(str);
            return;
        }
        ShadowAIGCStatus$GetStatusReply value = Na().M1().getValue();
        if (value != null && this.materialCategory != null && this.clickMaterial != null) {
            if (value.button_info.type.get() == 2) {
                QQToast.makeText(getContext(), R.string.f238857kw, 0).show();
            }
            IQQWinkMagicStudioApi iQQWinkMagicStudioApi = (IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class);
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            Fragment hostFragment = getHostFragment();
            Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
            MetaMaterial metaMaterial2 = this.clickMaterial;
            Intrinsics.checkNotNull(metaMaterial2);
            iQQWinkMagicStudioApi.handleMagicStudioStyleClickDirectly(activity, hostFragment, metaMaterial2, value, this.materialCategory, this.shareInfoCategory, Pa().getOriginalImagePath(), 1, retry, new WinkEditorAITemplateMenuPart$generateAIImage$1(this), new WinkEditorAITemplateMenuPart$generateAIImage$2(this), new WinkEditorAITemplateMenuPart$generateAIImage$3(this), new WinkEditorAITemplateMenuPart$generateAIImage$4(this));
        }
    }

    private final WinkEditorAITemplateViewModel Na() {
        Object value = this.aiTemplateViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-aiTemplateViewModel>(...)");
        return (WinkEditorAITemplateViewModel) value;
    }

    private final WinkQZoneTemplateLibViewModel Oa() {
        Object value = this.qzoneTemplateViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-qzoneTemplateViewModel>(...)");
        return (WinkQZoneTemplateLibViewModel) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkEditorAITemplateUIData Pa() {
        WinkEditUIData uiData = getUiData();
        Intrinsics.checkNotNull(uiData, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateUIData");
        return (WinkEditorAITemplateUIData) uiData;
    }

    private final void Qa(View rootView) {
        ImageView imageView = (ImageView) rootView.findViewById(R.id.y95);
        this.shieldBtn = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorAITemplateMenuPart.Ra(WinkEditorAITemplateMenuPart.this, view);
                }
            });
        }
        La();
        this.chanceText = (TextView) rootView.findViewById(R.id.f10655691);
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f7919494);
        this.styleRv = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        a aVar = new a(new WinkEditorAITemplateMenuPart$initView$2(this), new WinkEditorAITemplateMenuPart$initView$3(this));
        this.styleAdapter = aVar;
        RecyclerView recyclerView2 = this.styleRv;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(aVar);
        }
        RecyclerView recyclerView3 = this.styleRv;
        if (recyclerView3 != null) {
            recyclerView3.addItemDecoration(new b());
        }
        RecyclerView recyclerView4 = this.styleRv;
        if (recyclerView4 != null) {
            recyclerView4.addOnScrollListener(new c());
        }
        Na().N1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(WinkEditorAITemplateMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cb();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(WinkEditorAITemplateMenuPart this$0, WinkQZoneTemplateLibViewModel.CategoriesData categoriesData) {
        MetaCategory metaCategory;
        MetaCategory metaCategory2;
        boolean z16;
        ArrayList<MetaMaterial> arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ArrayList<MetaMaterial> arrayList2 = null;
        if (categoriesData != null) {
            metaCategory = categoriesData.getPicGenPicCategory();
        } else {
            metaCategory = null;
        }
        this$0.materialCategory = metaCategory;
        if (categoriesData != null) {
            metaCategory2 = categoriesData.getShareCategory();
        } else {
            metaCategory2 = null;
        }
        this$0.shareInfoCategory = metaCategory2;
        MetaCategory metaCategory3 = this$0.materialCategory;
        if (metaCategory3 != null && (arrayList = metaCategory3.materials) != null) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) arrayList, (Function1) new Function1<MetaMaterial, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateMenuPart$initViewModel$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(MetaMaterial metaMaterial) {
                    boolean z17 = false;
                    if (metaMaterial != null && com.tencent.mobileqq.wink.editor.c.E(metaMaterial)) {
                        z17 = true;
                    }
                    return Boolean.valueOf(z17);
                }
            });
        }
        a aVar = this$0.styleAdapter;
        if (aVar != null) {
            MetaCategory metaCategory4 = this$0.materialCategory;
            if (metaCategory4 != null) {
                arrayList2 = metaCategory4.materials;
            }
            aVar.n0(arrayList2);
        }
        String selectedMaterialId = this$0.Pa().getSelectedMaterialId();
        if (selectedMaterialId.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !Intrinsics.areEqual(selectedMaterialId, "EMPTY_MATERIAL_ID")) {
            this$0.aiResultMap.put(selectedMaterialId, this$0.Pa().getSelectedAIImagePath());
        }
        this$0.hb(selectedMaterialId);
        if (this$0.selectedIndex == -1) {
            this$0.lb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(WinkEditorAITemplateMenuPart this$0, ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.chanceText;
        if (textView != null) {
            textView.setText(shadowAIGCStatus$GetStatusReply.button_info.description.get());
        }
    }

    private final boolean Ua() {
        List<MediaClip> a06;
        Object firstOrNull;
        RectF rectF;
        boolean z16;
        dr H9 = H9();
        if (H9 != null && (a06 = H9.a0()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a06);
            MediaClip mediaClip = (MediaClip) firstOrNull;
            if (mediaClip == null) {
                return false;
            }
            ResourceModel resourceModel = mediaClip.resource;
            if (resourceModel != null) {
                rectF = resourceModel.picClipRect;
            } else {
                rectF = null;
            }
            if (mediaClip.matrix.isEmpty() || rectF == null) {
                return false;
            }
            float[] fArr = new float[9];
            new Matrix().getValues(fArr);
            for (int i3 = 0; i3 < 9; i3++) {
                if (fArr[i3] == mediaClip.matrix.get(i3).floatValue()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return true;
                }
            }
            if (Math.abs(rectF.bottom - com.tencent.videocut.render.extension.e.o(mediaClip).height) <= 0.1f && Math.abs(rectF.left - 0.0f) <= 0.1f && Math.abs(rectF.right - com.tencent.videocut.render.extension.e.o(mediaClip).width) <= 0.1f && Math.abs(rectF.top - 0.0f) <= 0.1f) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean Va() {
        boolean z16;
        boolean z17;
        List<MosaicData> A;
        Object firstOrNull;
        CopyOnWriteArrayList<MosaicLinePath> pathList;
        dr H9 = H9();
        if (H9 != null) {
            z16 = H9.p();
        } else {
            z16 = false;
        }
        dr H92 = H9();
        if (H92 != null && (A = H92.A()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) A);
            MosaicData mosaicData = (MosaicData) firstOrNull;
            if (mosaicData != null && (pathList = mosaicData.getPathList()) != null) {
                z17 = !pathList.isEmpty();
                boolean Ua = Ua();
                if ((z16 && !z17 && !Ua) || !this.firstShowConfirmDialog) {
                    return false;
                }
                return true;
            }
        }
        z17 = false;
        boolean Ua2 = Ua();
        if (z16) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wa() {
        w53.b.f("WinkEditorAITemplateMenuPart", "onGenerateCancel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xa() {
        w53.b.f("WinkEditorAITemplateMenuPart", "onGenerateFailed");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ya() {
        w53.b.f("WinkEditorAITemplateMenuPart", "onGenerateShare");
        Na().O1(2);
        Na().N1();
        gb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Za(List<String> aigcImagePaths, boolean isRegenerate) {
        Object first;
        Object first2;
        if (!aigcImagePaths.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) aigcImagePaths);
            w53.b.f("WinkEditorAITemplateMenuPart", "onGenerateSuccess: " + first + ", isRegenerate: " + isRegenerate);
            if (!isRegenerate) {
                Na().O1(1);
            } else {
                fb();
            }
            Na().N1();
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) aigcImagePaths);
            eb((String) first2);
            return;
        }
        w53.b.c("WinkEditorAITemplateMenuPart", "onGenerateSuccess: aigcImagePaths is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ab(MetaMaterial material) {
        this.clickMaterial = material;
        ib(null, R.string.f238827kt, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateMenuPart$onItemClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkEditorAITemplateMenuPart.this.Ma(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bb(MetaMaterial metaMaterial) {
        this.clickMaterial = metaMaterial;
        ib(null, R.string.f238827kt, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateMenuPart$onRetryClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkEditorAITemplateMenuPart.this.Ma(true);
            }
        });
    }

    private final void cb() {
        ib(null, R.string.f238837ku, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateMenuPart$onShieldClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WinkEditorAITemplateUIData Pa;
                WinkEditorAITemplateMenuPart.this.clickMaterial = null;
                WinkEditorAITemplateMenuPart winkEditorAITemplateMenuPart = WinkEditorAITemplateMenuPart.this;
                Pa = winkEditorAITemplateMenuPart.Pa();
                winkEditorAITemplateMenuPart.eb(Pa.getOriginalImagePath());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void eb(String imagePath) {
        String str;
        ArrayList<MosaicData> arrayListOf;
        List<? extends WinkStickerModel> emptyList;
        List<? extends MediaClip> listOf;
        Collection<WinkStickerModel> values;
        w53.b.f("WinkEditorAITemplateMenuPart", "replaceImage: " + imagePath);
        MetaMaterial metaMaterial = this.clickMaterial;
        if (metaMaterial != null) {
            str = metaMaterial.f30533id;
        } else {
            str = null;
        }
        if (str == null) {
            str = "EMPTY_MATERIAL_ID";
        }
        this.aiResultMap.put(str, imagePath);
        MediaClip a16 = com.tencent.videocut.render.repository.a.f384196a.a(imagePath);
        if (a16 == null) {
            w53.b.c("WinkEditorAITemplateMenuPart", "replaceImage: medaClip is null");
            return;
        }
        dr H9 = H9();
        if (H9 instanceof WinkImageTavCut) {
            WinkImageTavCut winkImageTavCut = (WinkImageTavCut) H9;
            if (winkImageTavCut.p()) {
                G9().t5(false);
                G9().c5(false);
                G9().A5(false);
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new MosaicData(new CopyOnWriteArrayList(), new CopyOnWriteArrayList(), null, 4, null));
            winkImageTavCut.I1(arrayListOf);
            Map<String, WinkStickerModel> m3 = winkImageTavCut.m();
            if (m3 == null || (values = m3.values()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList = new ArrayList<>();
                for (Object obj : values) {
                    if (((WinkStickerModel) obj).isMosaicDoodleSticker()) {
                        emptyList.add(obj);
                    }
                }
            }
            winkImageTavCut.T(emptyList);
            winkImageTavCut.D1(0, this.clickMaterial);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(a16);
            winkImageTavCut.e0(listOf);
        }
        Pa().setSelectedAIImagePath(imagePath);
        hb(str);
    }

    private final void fb() {
        Map mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.RESULTS_TYPE, 1), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.PG_ID, WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE));
        com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, WinkDaTongReportConstant.EventId.EV_QZ_AGAIN_GENERATE_RESULT, null, null, null, mutableMapOf, 14, null);
    }

    private final void gb() {
        String str;
        Map mutableMapOf;
        Pair[] pairArr = new Pair[3];
        MetaMaterial metaMaterial = this.clickMaterial;
        if (metaMaterial != null) {
            str = com.tencent.mobileqq.wink.editor.c.t(metaMaterial);
        } else {
            str = null;
        }
        pairArr[0] = TuplesKt.to("material_id", str);
        pairArr[1] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.SHARE_FROM, "1");
        pairArr[2] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.PG_ID, WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, WinkDaTongReportConstant.EventId.EV_QZ_AI_PAINT_SHARE, null, null, null, mutableMapOf, 14, null);
    }

    private final void hb(String materialId) {
        int i3;
        ArrayList<MetaMaterial> arrayList;
        Pa().setSelectedMaterialId(materialId);
        MetaCategory metaCategory = this.materialCategory;
        if (metaCategory != null && (arrayList = metaCategory.materials) != null) {
            Iterator<MetaMaterial> it = arrayList.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().f30533id, materialId)) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        i3 = -1;
        this.selectedIndex = i3;
        a aVar = this.styleAdapter;
        if (aVar != null) {
            aVar.m0(i3);
        }
        if (i3 != -1) {
            com.tencent.mobileqq.wink.utils.e.g(this.styleRv, 0, i3);
        }
        mb();
    }

    private final void ib(Integer dialogTitle, int dialogMsg, final Function0<Unit> onConfirm) {
        if (!Va()) {
            onConfirm.invoke();
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230);
        if (dialogTitle != null) {
            createCustomDialog.setTitle(dialogTitle.intValue());
        }
        createCustomDialog.setMessage(dialogMsg);
        createCustomDialog.setPositiveButton(R.string.a8j, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorAITemplateMenuPart.jb(WinkEditorAITemplateMenuPart.this, onConfirm, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorAITemplateMenuPart.kb(dialogInterface, i3);
            }
        });
        createCustomDialog.show();
    }

    private final void initViewModel() {
        Oa().N1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorAITemplateMenuPart.Sa(WinkEditorAITemplateMenuPart.this, (WinkQZoneTemplateLibViewModel.CategoriesData) obj);
            }
        });
        Na().M1().observe(getPartHost().getLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorAITemplateMenuPart.Ta(WinkEditorAITemplateMenuPart.this, (ShadowAIGCStatus$GetStatusReply) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jb(WinkEditorAITemplateMenuPart this$0, Function0 onConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        this$0.firstShowConfirmDialog = false;
        onConfirm.invoke();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r1 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void lb() {
        String str;
        List<MediaClip> a06;
        Object firstOrNull;
        WinkEditorAITemplateUIData Pa = Pa();
        dr H9 = H9();
        if (H9 != null && (a06 = H9.a0()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a06);
            MediaClip mediaClip = (MediaClip) firstOrNull;
            if (mediaClip != null) {
                ResourceModel resourceModel = mediaClip.resource;
                if (resourceModel != null) {
                    str = resourceModel.path;
                }
            }
        }
        str = "";
        Pa.setOriginalImagePath(str);
    }

    private final void mb() {
        if (this.selectedIndex == -1) {
            ImageView imageView = this.shieldBtn;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.l6x);
                return;
            }
            return;
        }
        ImageView imageView2 = this.shieldBtn;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.l6z);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.sff;
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void N9(@Nullable WinkEditUIData uiData) {
        super.N9(uiData);
        if (uiData instanceof WinkEditorAITemplateUIData) {
            O9(uiData);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.AI_TEMPLATE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        Qa(rootView);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 52130 && resultCode == -1) {
            Na().O1(2);
            gb();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            G9().l5();
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        O9(new WinkEditorAITemplateUIData(this));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kb(DialogInterface dialogInterface, int i3) {
    }
}
