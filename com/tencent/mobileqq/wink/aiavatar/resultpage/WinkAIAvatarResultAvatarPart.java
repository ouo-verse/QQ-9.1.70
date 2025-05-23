package com.tencent.mobileqq.wink.aiavatar.resultpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarGenerateBtnViewModel;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.aiavatar.resultpage.v;
import com.tencent.mobileqq.wink.aiavatar.view.WinkAIAvatarGenerateBtn;
import com.tencent.mobileqq.wink.aiavatar.view.WinkAvatarCropView;
import com.tencent.mobileqq.wink.aigc.utils.WinkMakeAIImageResponse;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.filter.LightConstants;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCStatus$GetStatusReply;

@Metadata(d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u009c\u00012\u00020\u0001:\u0002\u009d\u0001B\t\u00a2\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020!H\u0016J\"\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010)\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016J\u0014\u00101\u001a\u0004\u0018\u0001002\b\b\u0002\u0010/\u001a\u00020\u0007H\u0004J\u0012\u00103\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u0007H\u0014J\u0018\u00104\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0007H\u0004J\u0016\u00107\u001a\u00020\u00042\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001405H\u0004J\b\u00108\u001a\u00020\u0007H\u0004J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0007H\u0016J\u0012\u0010=\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010;H\u0016R$\u0010E\u001a\u0004\u0018\u00010>8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010@R$\u0010O\u001a\u0004\u0018\u00010H8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0018\u0010R\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010QR\u0018\u0010^\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010QR$\u0010f\u001a\u0004\u0018\u00010_8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010QR\u0018\u0010j\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010QR\u0018\u0010l\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010UR\u0018\u0010n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010QR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR$\u0010z\u001a\u0004\u0018\u00010s8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0018\u0010|\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010UR\u0018\u0010~\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010UR0\u0010\u0085\u0001\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R \u0010\u008a\u0001\u001a\u00020!8DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R!\u0010\u008f\u0001\u001a\u00030\u008b\u00018DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008c\u0001\u0010\u0087\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R!\u0010\u0094\u0001\u001a\u00030\u0090\u00018DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0087\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R!\u0010\u0099\u0001\u001a\u00030\u0095\u00018DX\u0084\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0087\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\u00a8\u0006\u009e\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultAvatarPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "wa", "ha", "", "T9", "ga", "pa", "ra", VasPerfReportUtils.WHILE_UPDATE_ITEM, "S9", "R9", "Ma", "Lcom/tencent/mobileqq/wink/aigc/utils/c;", "response", "Ua", "oa", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Na", "Sa", "Pa", "Qa", "Ra", "qa", "", "V9", "fromCache", "ma", LocaleUtils.L_JAPANESE, "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultViewModel;", "da", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onInitView", "ta", "sa", "initViewModel", "Ta", "ia", "forResultImage", "Landroid/graphics/Bitmap;", "Z9", "shareResultPage", "Wa", "la", "", "materials", "Ya", "U9", "success", "ea", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarCropView;", "d", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarCropView;", "getFirstCropView", "()Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarCropView;", "setFirstCropView", "(Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAvatarCropView;)V", "firstCropView", "e", "secondCropView", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "f", "Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "getGenerateBtn", "()Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;", "setGenerateBtn", "(Lcom/tencent/mobileqq/wink/aiavatar/view/WinkAIAvatarGenerateBtn;)V", "generateBtn", tl.h.F, "Landroid/view/View;", "regenerateContainer", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "generateChanceText", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "recommendStyleRecyclerView", BdhLogUtil.LogTag.Tag_Conn, "closeBtn", "D", "syncQZoneContainer", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "E", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "getSyncQZoneCheckBox", "()Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "setSyncQZoneCheckBox", "(Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;)V", "syncQZoneCheckBox", UserInfo.SEX_FEMALE, "downloadBtn", "G", "replaceBtn", "H", "paitongkuanText", "I", "shareBtn", "Landroidx/recyclerview/widget/GridLayoutManager;", "J", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a;", "K", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a;", "Y9", "()Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a;", "setRecommendStyleAdapter", "(Lcom/tencent/mobileqq/wink/aiavatar/resultpage/a;)V", "recommendStyleAdapter", "L", "otherStyleTitle", "M", "moreRecommendStyleText", "N", "Ljava/util/List;", "getCurrentRecommendStyleList", "()Ljava/util/List;", "Va", "(Ljava/util/List;)V", "currentRecommendStyleList", "P", "Lkotlin/Lazy;", "ba", "()Lcom/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultViewModel;", "resultViewModel", "Lcom/tencent/mobileqq/wink/aiavatar/resultpage/ad;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "ca", "()Lcom/tencent/mobileqq/wink/aiavatar/resultpage/ad;", "uiStateViewModel", "Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", BdhLogUtil.LogTag.Tag_Req, "W9", "()Lcom/tencent/mobileqq/wink/aiavatar/base/WinkAIAvatarGenerateBtnViewModel;", "generateBtnViewModel", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", ExifInterface.LATITUDE_SOUTH, "X9", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "<init>", "()V", "T", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkAIAvatarResultAvatarPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View closeBtn;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View syncQZoneContainer;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QUICheckBox syncQZoneCheckBox;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View downloadBtn;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View replaceBtn;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView paitongkuanText;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View shareBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private GridLayoutManager layoutManager;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private a recommendStyleAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TextView otherStyleTitle;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView moreRecommendStyleText;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private List<MetaMaterial> currentRecommendStyleList;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy resultViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy uiStateViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy generateBtnViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy qqPermission;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkAvatarCropView firstCropView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkAvatarCropView secondCropView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkAIAvatarGenerateBtn generateBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View regenerateContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView generateChanceText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recommendStyleRecyclerView;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/aiavatar/resultpage/WinkAIAvatarResultAvatarPart$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {
        b() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            a recommendStyleAdapter = WinkAIAvatarResultAvatarPart.this.getRecommendStyleAdapter();
            Intrinsics.checkNotNull(recommendStyleAdapter);
            if (position == recommendStyleAdapter.getNUM_BACKGOURND_ICON() - 1) {
                GridLayoutManager gridLayoutManager = WinkAIAvatarResultAvatarPart.this.layoutManager;
                Intrinsics.checkNotNull(gridLayoutManager);
                return gridLayoutManager.getSpanCount();
            }
            return 1;
        }
    }

    public WinkAIAvatarResultAvatarPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarResultViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$resultViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkAIAvatarResultViewModel invoke() {
                return WinkAIAvatarResultAvatarPart.this.da();
            }
        });
        this.resultViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ad>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$uiStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ad invoke() {
                return (ad) WinkAIAvatarResultAvatarPart.this.getViewModel(ad.class);
            }
        });
        this.uiStateViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkAIAvatarGenerateBtnViewModel>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$generateBtnViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkAIAvatarGenerateBtnViewModel invoke() {
                return (WinkAIAvatarGenerateBtnViewModel) WinkAIAvatarResultAvatarPart.this.getViewModel(WinkAIAvatarGenerateBtnViewModel.class);
            }
        });
        this.generateBtnViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$qqPermission$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQPermission invoke() {
                return QQPermissionFactory.getQQPermission(WinkAIAvatarResultAvatarPart.this.getHostFragment(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_TEMPLATE));
            }
        });
        this.qqPermission = lazy4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Aa(WinkAIAvatarResultAvatarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ia();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ba(WinkAIAvatarResultAvatarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.oa();
        com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.u(view, this$0.ba().x2());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ca(WinkAIAvatarResultAvatarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ga();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(WinkAIAvatarResultAvatarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ea(WinkAIAvatarResultAvatarPart this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.U9()) {
            this$0.ha();
            com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            aVar.h(it, this$0.ba().x2());
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(WinkAIAvatarResultAvatarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Na(this$0.ba().u2());
        com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.y(this$0.paitongkuanText);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ga(WinkAIAvatarResultAvatarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Sa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ha(WinkAIAvatarResultAvatarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Pa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ja(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void La(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ma() {
        String str;
        Intent intent;
        Intent intent2;
        Intent intent3 = new Intent();
        Activity activity = getActivity();
        String str2 = null;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            str = intent2.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        } else {
            str = null;
        }
        intent3.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, str);
        Activity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            str2 = intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        }
        intent3.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, str2);
        intent3.putExtra("material_id", "");
        intent3.putExtra("come_from", "2");
        com.tencent.mobileqq.wink.f.q(getContext(), intent3);
    }

    private final void Na(MetaMaterial material) {
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "launchAIAvatarMediaDetailFragment");
        if (material == null) {
            WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            winkAIAvatarUtils.F(context, "\u529f\u80fd\u6682\u672a\u4e0a\u7ebf\uff0c\u8bf7\u7559\u610f\u540e\u7eed\u66f4\u65b0");
            return;
        }
        WinkAIAvatarUtils winkAIAvatarUtils2 = WinkAIAvatarUtils.f317678a;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        winkAIAvatarUtils2.r(activity, material, "1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(WinkAIAvatarResultAvatarPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ba().i2(false, null);
    }

    private final void Pa() {
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "onGenerateChanceClick");
        WinkAIAvatarGenerateBtnViewModel W9 = W9();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        W9.W1(context);
    }

    private final void Qa() {
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "onDownloadBtnClick");
        com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.q(this.moreRecommendStyleText);
        Ma();
    }

    private final void R9() {
        ViewGroup.LayoutParams layoutParams;
        int dpToPx;
        o53.h hVar = o53.h.f422138a;
        if (hVar.z(getActivity())) {
            TextView textView = this.otherStyleTitle;
            if (textView != null) {
                layoutParams = textView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                if (ba().getIsCoupleAvatar()) {
                    if (hVar.y()) {
                        dpToPx = ImmersiveUtils.dpToPx(14.0f);
                    } else {
                        if (hVar.D(getActivity())) {
                            dpToPx = ImmersiveUtils.dpToPx(12.0f);
                        }
                        dpToPx = 0;
                    }
                } else if (hVar.y()) {
                    dpToPx = ImmersiveUtils.dpToPx(13.0f);
                } else {
                    if (hVar.D(getActivity())) {
                        dpToPx = ImmersiveUtils.dpToPx(12.0f);
                    }
                    dpToPx = 0;
                }
                ((ConstraintLayout.LayoutParams) layoutParams).setMarginStart(dpToPx);
            }
        }
    }

    private final void Ra() {
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "onReplaceBtnClick");
        if (!T9()) {
            return;
        }
        WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        winkAIAvatarUtils.p(context, ba().getSelectedStyleMaterial(), false, 101, ba().o2());
        com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.w(this.replaceBtn);
    }

    private final void S9() {
        ViewGroup.LayoutParams layoutParams;
        o53.h hVar = o53.h.f422138a;
        if (hVar.z(getActivity())) {
            RecyclerView recyclerView = this.recommendStyleRecyclerView;
            if (recyclerView != null) {
                layoutParams = recyclerView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.width = hVar.n(getActivity());
            }
        }
    }

    private final void Sa() {
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "onShareBtnClick");
        Wa(true);
        com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.B(this.shareBtn, ba().x2());
    }

    private final boolean T9() {
        if (!U9()) {
            return false;
        }
        WinkAIAvatarGenerateBtnViewModel W9 = W9();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return W9.O1(context, false, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$checkGenerateChance$1
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
                WinkAIAvatarResultAvatarPart.Xa(WinkAIAvatarResultAvatarPart.this, false, 1, null);
            }
        });
    }

    private final void Ua(WinkMakeAIImageResponse response) {
        String str;
        if (!ba().getIsCoupleAvatar()) {
            return;
        }
        boolean F2 = ba().F2();
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "selectDefaultCropView: isMale=" + F2);
        Iterator<WinkMakeAIImageResponse.Media> it = response.b().iterator();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                String gender = it.next().getGender();
                if (F2) {
                    str = LightConstants.MALE;
                } else {
                    str = LightConstants.FEMALE;
                }
                if (Intrinsics.areEqual(gender, str)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        ad ca5 = ca();
        if (i3 < 1) {
            z16 = true;
        }
        ca5.R1(z16);
    }

    private final String V9() {
        boolean z16;
        WinkMakeAIImageResponse m26 = ba().m2();
        if (m26 == null) {
            return "";
        }
        if (ba().getIsCoupleAvatar()) {
            if (m26.getShareImageUrl().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return m26.getShareImageUrl();
            }
        }
        if (!m26.b().isEmpty()) {
            return m26.b().get(0).getImageUrl();
        }
        return "https://shadow-h5-image-1251316161.file.myqcloud.com/2023-aigc/wecom-temp-143487-e5a1fb8b2f66f7d63dbf0d93f1e88b0d.png";
    }

    public static /* synthetic */ void Xa(WinkAIAvatarResultAvatarPart winkAIAvatarResultAvatarPart, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            winkAIAvatarResultAvatarPart.Wa(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shareResult");
    }

    public static /* synthetic */ Bitmap aa(WinkAIAvatarResultAvatarPart winkAIAvatarResultAvatarPart, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            return winkAIAvatarResultAvatarPart.Z9(z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getResultCropBitmap");
    }

    private final void ga() {
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "handleCloseBtnClick click");
        ba().e2();
        Activity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        if (com.tencent.mobileqq.wink.request.a.g(r0) == true) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void ha() {
        boolean z16;
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "handleDownloadBtnClick click");
        if (FastClickUtils.isFastDoubleClick("WinkAIAvatarResultSingleAvatarPartonDownloadClick")) {
            w53.b.g("WinkAIAvatarResultSingleAvatarPart", "onDownloadClick fast click");
            return;
        }
        ShadowAIGCStatus$GetStatusReply value = W9().S1().getValue();
        if (value != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            QQToast.makeText(getContext(), "\u4eca\u65e5\u56fe\u7247\u4fdd\u5b58\u6b21\u6570\u5df2\u7528\u5c3d", 0).show();
        } else {
            WinkAIAvatarResultViewModel.h2(ba(), X9(), false, null, false, 14, null);
            W9().P1();
        }
    }

    private final void ja(WinkMakeAIImageResponse response) {
        ba().S2();
        a aVar = this.recommendStyleAdapter;
        if (aVar != null) {
            aVar.o0(ba().x2());
        }
        ca().S1(new v.GenerateFailed(response.getRetCode(), response.getMsg()));
        W9().X1();
    }

    private final void ma(final WinkMakeAIImageResponse response, boolean fromCache) {
        int collectionSizeOrDefault;
        List mutableList;
        Object first;
        ba().V2(response);
        a aVar = this.recommendStyleAdapter;
        if (aVar != null) {
            aVar.o0(response.getMaterialID());
        }
        List<WinkMakeAIImageResponse.Media> b16 = response.b();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = b16.iterator();
        while (it.hasNext()) {
            arrayList.add(((WinkMakeAIImageResponse.Media) it.next()).getImageUrl());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        boolean z16 = true;
        if (ba().getIsCoupleAvatar() && mutableList.size() == 1) {
            w53.b.g("WinkAIAvatarResultSingleAvatarPart", "handleGenerateResult: CoupleAvatar imagePaths.size == 1");
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) mutableList);
            mutableList.add(first);
        }
        ad ca5 = ca();
        v.GenerateSuccess generateSuccess = new v.GenerateSuccess(mutableList);
        v value = ca().O1().getValue();
        if (value != null) {
            z16 = value.getIsFirstAvatarSelected();
        }
        generateSuccess.b(z16);
        ca5.S1(generateSuccess);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIAvatarResultAvatarPart.na(WinkAIAvatarResultAvatarPart.this, response);
            }
        });
        if (!fromCache) {
            W9().Q1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(WinkAIAvatarResultAvatarPart this$0, WinkMakeAIImageResponse response) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(response, "$response");
        this$0.Ua(response);
    }

    private final void oa() {
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "handleRegenerateClick");
        if (!T9()) {
            return;
        }
        ca().S1(v.i.f317845b);
        ba().i2(true, null);
    }

    private final void pa() {
        boolean z16;
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "handleSyncQZoneClick click");
        QUICheckBox qUICheckBox = this.syncQZoneCheckBox;
        if (qUICheckBox != null) {
            if (qUICheckBox != null) {
                z16 = qUICheckBox.isChecked();
            } else {
                z16 = false;
            }
            qUICheckBox.setChecked(!z16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean qa() {
        boolean z16;
        List<WinkMakeAIImageResponse.Media> b16;
        boolean z17;
        String shareImageUrl;
        boolean z18;
        if (ba().m2() == null) {
            return false;
        }
        WinkMakeAIImageResponse m26 = ba().m2();
        if (ba().getIsCoupleAvatar()) {
            if (m26 != null && (shareImageUrl = m26.getShareImageUrl()) != null) {
                if (shareImageUrl.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    z17 = true;
                    if (z17) {
                        return false;
                    }
                    return true;
                }
            }
            z17 = false;
            if (z17) {
            }
        } else {
            if (m26 != null && (b16 = m26.b()) != null && (!b16.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || m26.b().get(0).getImageUrl().length() <= 0) {
                return false;
            }
            return true;
        }
    }

    private final void ra() {
        RecyclerView recyclerView;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            recyclerView = (RecyclerView) partRootView.findViewById(R.id.f71493oa);
        } else {
            recyclerView = null;
        }
        this.recommendStyleRecyclerView = recyclerView;
        S9();
        boolean isCoupleAvatar = ba().getIsCoupleAvatar();
        boolean isSchemeJump = ba().getIsSchemeJump();
        a aVar = new a(isCoupleAvatar, isSchemeJump ? 1 : 0, new WinkAIAvatarResultAvatarPart$initRecommendStyleRecyclerView$1(this));
        this.recommendStyleAdapter = aVar;
        RecyclerView recyclerView2 = this.recommendStyleRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(aVar);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), WinkAIAvatarUtils.f317678a.k(ba().getIsCoupleAvatar()));
        this.layoutManager = gridLayoutManager;
        gridLayoutManager.setSpanSizeLookup(new b());
        RecyclerView recyclerView3 = this.recommendStyleRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(this.layoutManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(WinkAIAvatarResultAvatarPart this$0, WinkMakeAIImageResponse it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.Ua(it);
    }

    private final void updateView() {
        if (this.currentRecommendStyleList != null) {
            ra();
            List<MetaMaterial> list = this.currentRecommendStyleList;
            Intrinsics.checkNotNull(list);
            Ya(list);
        }
        R9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(WinkAIAvatarResultAvatarPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ba().i2(false, null);
    }

    private final void wa(View rootView) {
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn;
        WinkAvatarCropView winkAvatarCropView;
        WinkAvatarCropView winkAvatarCropView2;
        View view;
        View view2;
        View view3;
        QUICheckBox qUICheckBox;
        TextView textView;
        View view4;
        TextView textView2;
        View view5;
        TextView textView3;
        TextView textView4;
        View view6 = null;
        if (rootView != null) {
            winkAIAvatarGenerateBtn = (WinkAIAvatarGenerateBtn) rootView.findViewById(R.id.vnj);
        } else {
            winkAIAvatarGenerateBtn = null;
        }
        this.generateBtn = winkAIAvatarGenerateBtn;
        if (rootView != null) {
            winkAvatarCropView = (WinkAvatarCropView) rootView.findViewById(R.id.v6w);
        } else {
            winkAvatarCropView = null;
        }
        this.firstCropView = winkAvatarCropView;
        if (rootView != null) {
            winkAvatarCropView2 = (WinkAvatarCropView) rootView.findViewById(R.id.f81674et);
        } else {
            winkAvatarCropView2 = null;
        }
        this.secondCropView = winkAvatarCropView2;
        ra();
        ta();
        WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn2 = this.generateBtn;
        if (winkAIAvatarGenerateBtn2 != null) {
            winkAIAvatarGenerateBtn2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    WinkAIAvatarResultAvatarPart.Aa(WinkAIAvatarResultAvatarPart.this, view7);
                }
            });
        }
        if (rootView != null) {
            view = rootView.findViewById(R.id.f72453qw);
        } else {
            view = null;
        }
        this.regenerateContainer = view;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    WinkAIAvatarResultAvatarPart.Ba(WinkAIAvatarResultAvatarPart.this, view7);
                }
            });
        }
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.az7);
        } else {
            view2 = null;
        }
        this.closeBtn = view2;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    WinkAIAvatarResultAvatarPart.Ca(WinkAIAvatarResultAvatarPart.this, view7);
                }
            });
        }
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.f9144557);
        } else {
            view3 = null;
        }
        this.syncQZoneContainer = view3;
        if (rootView != null) {
            qUICheckBox = (QUICheckBox) rootView.findViewById(R.id.f9143556);
        } else {
            qUICheckBox = null;
        }
        this.syncQZoneCheckBox = qUICheckBox;
        View view7 = this.syncQZoneContainer;
        if (view7 != null) {
            view7.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    WinkAIAvatarResultAvatarPart.Da(WinkAIAvatarResultAvatarPart.this, view8);
                }
            });
        }
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f217301t);
        } else {
            textView = null;
        }
        this.otherStyleTitle = textView;
        if (rootView != null) {
            view4 = rootView.findViewById(R.id.bp5);
        } else {
            view4 = null;
        }
        this.downloadBtn = view4;
        if (view4 != null) {
            view4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    WinkAIAvatarResultAvatarPart.Ea(WinkAIAvatarResultAvatarPart.this, view8);
                }
            });
        }
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f221602z);
        } else {
            textView2 = null;
        }
        this.paitongkuanText = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    WinkAIAvatarResultAvatarPart.Fa(WinkAIAvatarResultAvatarPart.this, view8);
                }
            });
        }
        WinkAvatarCropView winkAvatarCropView3 = this.firstCropView;
        if (winkAvatarCropView3 != null) {
            winkAvatarCropView3.setResultImageOnClickListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$initView$7
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
                    if (WinkAIAvatarResultAvatarPart.this.ba().getIsCoupleAvatar()) {
                        WinkAIAvatarResultAvatarPart.this.ca().R1(true);
                    }
                }
            });
        }
        WinkAvatarCropView winkAvatarCropView4 = this.secondCropView;
        if (winkAvatarCropView4 != null) {
            winkAvatarCropView4.setResultImageOnClickListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$initView$8
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
                    if (WinkAIAvatarResultAvatarPart.this.ba().getIsCoupleAvatar()) {
                        WinkAIAvatarResultAvatarPart.this.ca().R1(false);
                    }
                }
            });
        }
        if (rootView != null) {
            view5 = rootView.findViewById(R.id.f84224lo);
        } else {
            view5 = null;
        }
        this.shareBtn = view5;
        if (view5 != null) {
            view5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    WinkAIAvatarResultAvatarPart.Ga(WinkAIAvatarResultAvatarPart.this, view8);
                }
            });
        }
        R9();
        if (rootView != null) {
            textView3 = (TextView) rootView.findViewById(R.id.vnl);
        } else {
            textView3 = null;
        }
        this.generateChanceText = textView3;
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    WinkAIAvatarResultAvatarPart.Ha(WinkAIAvatarResultAvatarPart.this, view8);
                }
            });
        }
        if (rootView != null) {
            textView4 = (TextView) rootView.findViewById(R.id.zf6);
        } else {
            textView4 = null;
        }
        this.moreRecommendStyleText = textView4;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    WinkAIAvatarResultAvatarPart.xa(WinkAIAvatarResultAvatarPart.this, view8);
                }
            });
        }
        if (rootView != null) {
            view6 = rootView.findViewById(R.id.f73053si);
        }
        this.replaceBtn = view6;
        if (view6 != null) {
            view6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view8) {
                    WinkAIAvatarResultAvatarPart.za(WinkAIAvatarResultAvatarPart.this, view8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(WinkAIAvatarResultAvatarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(WinkAIAvatarResultAvatarPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ra();
        EventCollector.getInstance().onViewClicked(view);
    }

    public void Ta(@NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        if (ca().O1().getValue() instanceof v.SchemeInit) {
            Na(material);
            return;
        }
        if (ca().P1()) {
            WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            winkAIAvatarUtils.F(context, "\u6b63\u5728\u751f\u6210\u4e2d\uff0c\u8bf7\u7b49\u5f85");
            return;
        }
        WinkMakeAIImageResponse j26 = ba().j2(material);
        if (j26 != null) {
            w53.b.f("WinkAIAvatarResultSingleAvatarPart", "onStyleItemClick: " + material.f30533id + " is in cache");
            ba().U2(material);
            a aVar = this.recommendStyleAdapter;
            if (aVar != null) {
                String str = material.f30533id;
                Intrinsics.checkNotNullExpressionValue(str, "material.id");
                aVar.o0(str);
            }
            la(j26, true);
            return;
        }
        if (!T9()) {
            return;
        }
        ba().U2(material);
        a aVar2 = this.recommendStyleAdapter;
        if (aVar2 != null) {
            String str2 = material.f30533id;
            Intrinsics.checkNotNullExpressionValue(str2, "material.id");
            aVar2.o0(str2);
        }
        ca().S1(v.i.f317845b);
        ba().i2(false, null);
    }

    protected final boolean U9() {
        if (NetworkUtil.isNetworkAvailable()) {
            return true;
        }
        w53.b.c("WinkAIAvatarResultSingleAvatarPart", "checkNetworkAvailable: network is not available");
        WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        winkAIAvatarUtils.F(context, "\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Va(@Nullable List<MetaMaterial> list) {
        this.currentRecommendStyleList = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final WinkAIAvatarGenerateBtnViewModel W9() {
        Object value = this.generateBtnViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-generateBtnViewModel>(...)");
        return (WinkAIAvatarGenerateBtnViewModel) value;
    }

    protected void Wa(boolean shareResultPage) {
        if (qa() && shareResultPage) {
            String V9 = V9();
            w53.b.f("WinkAIAvatarResultSingleAvatarPart", "shareResult Preview  " + V9);
            WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
            String A2 = ba().A2();
            boolean isCoupleAvatar = ba().getIsCoupleAvatar();
            String d26 = ba().d2();
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            winkAIAvatarUtils.E(V9, A2, isCoupleAvatar, d26, activity, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$shareResult$1
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
                    WinkAIAvatarResultAvatarPart.this.W9().c2();
                    w53.b.f("WinkAIAvatarResultSingleAvatarPart", "callback from util: share wx succeed!");
                }
            });
            return;
        }
        WinkAIAvatarUtils winkAIAvatarUtils2 = WinkAIAvatarUtils.f317678a;
        Activity activity2 = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity2, "activity");
        winkAIAvatarUtils2.C(activity2, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$shareResult$2
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
                WinkAIAvatarResultAvatarPart.this.W9().c2();
            }
        }, "");
    }

    @NotNull
    protected final QQPermission X9() {
        Object value = this.qqPermission.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-qqPermission>(...)");
        return (QQPermission) value;
    }

    @Nullable
    /* renamed from: Y9, reason: from getter */
    protected final a getRecommendStyleAdapter() {
        return this.recommendStyleAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Ya(@NotNull List<MetaMaterial> materials) {
        a aVar;
        Intrinsics.checkNotNullParameter(materials, "materials");
        a aVar2 = this.recommendStyleAdapter;
        if (aVar2 != null) {
            aVar2.p0(materials);
        }
        if (!ba().getIsSchemeJump() && (aVar = this.recommendStyleAdapter) != null) {
            aVar.o0(ba().x2());
        }
    }

    @Nullable
    protected final Bitmap Z9(boolean forResultImage) {
        boolean z16;
        WinkAvatarCropView winkAvatarCropView;
        v value = ca().O1().getValue();
        if (value != null) {
            z16 = value.getIsFirstAvatarSelected();
        } else {
            z16 = true;
        }
        if (z16) {
            winkAvatarCropView = this.firstCropView;
        } else {
            winkAvatarCropView = this.secondCropView;
        }
        if (winkAvatarCropView == null) {
            return null;
        }
        try {
            return winkAvatarCropView.C0(512, 512, false, forResultImage);
        } catch (Throwable th5) {
            w53.b.c("WinkAIAvatarResultSingleAvatarPart", "getResultCropBitmap: " + th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final WinkAIAvatarResultViewModel ba() {
        return (WinkAIAvatarResultViewModel) this.resultViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ad ca() {
        Object value = this.uiStateViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-uiStateViewModel>(...)");
        return (ad) value;
    }

    @NotNull
    public WinkAIAvatarResultViewModel da() {
        ViewModel viewModel = getViewModel(WinkAIAvatarResultViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkAIAvata\u2026ultViewModel::class.java)");
        return (WinkAIAvatarResultViewModel) viewModel;
    }

    public void ea(boolean success) {
        if (success) {
            ca().S1(v.b.f317835b);
            ba().g2(X9(), true, getActivity(), false);
        } else {
            ca().S1(v.a.f317834b);
        }
    }

    public void ia() {
        boolean z16;
        Boolean bool;
        Boolean bool2;
        w53.b.f("WinkAIAvatarResultSingleAvatarPart", "handleGenerateClick");
        Boolean bool3 = null;
        if (!(ca().O1().getValue() instanceof v.FirstGenerateFailed) && !(ca().O1().getValue() instanceof v.Init)) {
            if (ca().O1().getValue() instanceof v.SchemeInit) {
                if (ba().getIsCoupleAvatar()) {
                    ca().S1(v.c.f317836b);
                    WinkAIAvatarResultViewModel ba5 = ba();
                    Bitmap aa5 = aa(this, false, 1, null);
                    QUICheckBox qUICheckBox = this.syncQZoneCheckBox;
                    if (qUICheckBox != null) {
                        bool2 = Boolean.valueOf(qUICheckBox.isChecked());
                    } else {
                        bool2 = null;
                    }
                    ba5.T2(aa5, bool2);
                    com.tencent.mobileqq.wink.aiavatar.base.a aVar = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
                    WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn = this.generateBtn;
                    String x26 = ba().x2();
                    QUICheckBox qUICheckBox2 = this.syncQZoneCheckBox;
                    if (qUICheckBox2 != null) {
                        bool3 = Boolean.valueOf(qUICheckBox2.isChecked());
                    }
                    aVar.z(winkAIAvatarGenerateBtn, x26, bool3);
                    return;
                }
                Na(ba().u2());
                com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.o(this.generateBtn);
                return;
            }
            v.c cVar = v.c.f317836b;
            v value = ca().O1().getValue();
            if (value != null) {
                z16 = value.getIsFirstAvatarSelected();
            } else {
                z16 = true;
            }
            cVar.b(z16);
            ca().S1(cVar);
            WinkAIAvatarResultViewModel ba6 = ba();
            Bitmap aa6 = aa(this, false, 1, null);
            QUICheckBox qUICheckBox3 = this.syncQZoneCheckBox;
            if (qUICheckBox3 != null) {
                bool = Boolean.valueOf(qUICheckBox3.isChecked());
            } else {
                bool = null;
            }
            ba6.T2(aa6, bool);
            com.tencent.mobileqq.wink.aiavatar.base.a aVar2 = com.tencent.mobileqq.wink.aiavatar.base.a.f317690a;
            WinkAIAvatarGenerateBtn winkAIAvatarGenerateBtn2 = this.generateBtn;
            String x27 = ba().x2();
            QUICheckBox qUICheckBox4 = this.syncQZoneCheckBox;
            if (qUICheckBox4 != null) {
                bool3 = Boolean.valueOf(qUICheckBox4.isChecked());
            }
            aVar2.z(winkAIAvatarGenerateBtn2, x27, bool3);
            return;
        }
        if (!T9()) {
            return;
        }
        ca().S1(v.i.f317845b);
        ba().i2(false, null);
        com.tencent.mobileqq.wink.aiavatar.base.a.f317690a.j(ba().x2(), this.generateBtn);
    }

    public void initViewModel() {
        LiveData<WinkMakeAIImageResponse> p26 = ba().p2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<WinkMakeAIImageResponse, Unit> function1 = new Function1<WinkMakeAIImageResponse, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkMakeAIImageResponse winkMakeAIImageResponse) {
                invoke2(winkMakeAIImageResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WinkMakeAIImageResponse it) {
                WinkAIAvatarResultAvatarPart winkAIAvatarResultAvatarPart = WinkAIAvatarResultAvatarPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkAIAvatarResultAvatarPart.la(it, false);
            }
        };
        p26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarResultAvatarPart.Ia(Function1.this, obj);
            }
        });
        LiveData<List<MetaMaterial>> s26 = ba().s2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<List<? extends MetaMaterial>, Unit> function12 = new Function1<List<? extends MetaMaterial>, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MetaMaterial> list) {
                invoke2((List<MetaMaterial>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<MetaMaterial> it) {
                WinkAIAvatarResultAvatarPart.this.Va(it);
                WinkAIAvatarResultAvatarPart winkAIAvatarResultAvatarPart = WinkAIAvatarResultAvatarPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkAIAvatarResultAvatarPart.Ya(it);
            }
        };
        s26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarResultAvatarPart.Ja(Function1.this, obj);
            }
        });
        LiveData<Boolean> r26 = ba().r2();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                WinkAIAvatarResultAvatarPart winkAIAvatarResultAvatarPart = WinkAIAvatarResultAvatarPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                winkAIAvatarResultAvatarPart.ea(it.booleanValue());
            }
        };
        r26.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarResultAvatarPart.Ka(Function1.this, obj);
            }
        });
        LiveData<MetaCategory> z26 = ba().z2();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final WinkAIAvatarResultAvatarPart$initViewModel$4 winkAIAvatarResultAvatarPart$initViewModel$4 = new Function1<MetaCategory, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.WinkAIAvatarResultAvatarPart$initViewModel$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MetaCategory metaCategory) {
                invoke2(metaCategory);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MetaCategory metaCategory) {
                WinkAIAvatarUtils.f317678a.A(metaCategory);
            }
        };
        z26.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAIAvatarResultAvatarPart.La(Function1.this, obj);
            }
        });
        ba().P2();
        ba().R2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void la(@NotNull WinkMakeAIImageResponse response, boolean fromCache) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.getIsSuccess() && response.getRetCode() == 0 && (!response.b().isEmpty())) {
            ma(response, fromCache);
        } else {
            ja(response);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bundle bundle;
        int collectionSizeOrDefault;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == -1) {
            WinkAIAvatarResultViewModel ba5 = ba();
            ArrayList arrayList = null;
            if (data != null) {
                bundle = data.getExtras();
            } else {
                bundle = null;
            }
            ba5.J2(bundle);
            List<LocalMediaInfo> t26 = ba().t2();
            if (t26 != null) {
                List<LocalMediaInfo> list = t26;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((LocalMediaInfo) it.next()).path);
                }
            }
            ca().Q1(arrayList);
            ca().S1(v.i.f317845b);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.i
                @Override // java.lang.Runnable
                public final void run() {
                    WinkAIAvatarResultAvatarPart.Oa(WinkAIAvatarResultAvatarPart.this);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o53.h hVar = o53.h.f422138a;
        if (hVar.z(getActivity()) || hVar.w(getActivity())) {
            updateView();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        wa(rootView);
        if (!FontSettingManager.isFontSizeNormal()) {
            FontSettingManager.resetViewSize2Normal(getContext(), rootView);
        }
        initViewModel();
        sa();
    }

    public void ta() {
        ArrayList arrayList;
        boolean z16;
        boolean z17;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        if (ba().getIsSchemeJump()) {
            final WinkMakeAIImageResponse m26 = ba().m2();
            if (m26 != null) {
                List<WinkMakeAIImageResponse.Media> b16 = m26.b();
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                Iterator<T> it = b16.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((WinkMakeAIImageResponse.Media) it.next()).getImageUrl());
                }
                ca().S1(new v.SchemeInit(arrayList2));
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkAIAvatarResultAvatarPart.ua(WinkAIAvatarResultAvatarPart.this, m26);
                    }
                });
                return;
            }
            return;
        }
        List<LocalMediaInfo> t26 = ba().t2();
        String str = null;
        if (t26 != null) {
            List<LocalMediaInfo> list = t26;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                arrayList.add(((LocalMediaInfo) it5.next()).path);
            }
        } else {
            arrayList = null;
        }
        WinkAIAvatarUtils winkAIAvatarUtils = WinkAIAvatarUtils.f317678a;
        ShadowAIGCStatus$GetStatusReply h16 = winkAIAvatarUtils.h();
        boolean z18 = true;
        if (h16 != null && com.tencent.mobileqq.wink.request.a.h(h16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            ShadowAIGCStatus$GetStatusReply h17 = winkAIAvatarUtils.h();
            if (h17 != null && com.tencent.mobileqq.wink.request.a.f(h17)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                ShadowAIGCStatus$GetStatusReply h18 = winkAIAvatarUtils.h();
                if (h18 == null || !com.tencent.mobileqq.wink.request.a.j(h18)) {
                    z18 = false;
                }
                if (!z18) {
                    ca().S1(new v.FirstGenerating(arrayList, null, 2, null));
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.resultpage.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            WinkAIAvatarResultAvatarPart.va(WinkAIAvatarResultAvatarPart.this);
                        }
                    });
                    return;
                }
            }
        }
        ca().S1(new v.Init(arrayList, null, 2, null));
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ShadowAIGCStatus$GetStatusReply h19 = winkAIAvatarUtils.h();
        if (h19 != null) {
            str = com.tencent.mobileqq.wink.request.a.e(h19);
        }
        winkAIAvatarUtils.F(context, str);
    }

    public void sa() {
    }
}
