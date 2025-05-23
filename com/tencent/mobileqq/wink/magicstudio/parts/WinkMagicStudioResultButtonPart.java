package com.tencent.mobileqq.wink.magicstudio.parts;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.vas.api.RemoteProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioMultiViewModel;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart;
import com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioViewModel;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.MediaType;

@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0095\u00012\u00020\u0001:\u0004\u0096\u0001\u0097\u0001B\u001d\u0012\b\u0010?\u001a\u0004\u0018\u00010<\u0012\b\u0010C\u001a\u0004\u0018\u00010@\u00a2\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u0004H\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\u001a\u00103\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u000f2\b\b\u0002\u00102\u001a\u00020\u001fH\u0002J\b\u00104\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020\u0004H\u0002J\u0012\u00106\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010;\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u001f2\b\u0010:\u001a\u0004\u0018\u000109H\u0016R\u0016\u0010?\u001a\u0004\u0018\u00010<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u0004\u0018\u00010@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010ER\u0018\u0010R\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010IR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010ER\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010UR\u0018\u0010`\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010ER\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010UR\u0018\u0010i\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010l\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010UR\u0018\u0010r\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010v\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010x\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010kR\u001b\u0010~\u001a\u00020y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R\u001f\u0010\u0083\u0001\u001a\u00020\u007f8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0080\u0001\u0010{\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R \u0010\u0088\u0001\u001a\u00030\u0084\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0085\u0001\u0010{\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\"\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u0089\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008a\u0001\u0010{\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R \u0010\u0092\u0001\u001a\u00030\u008e\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008f\u0001\u0010{\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\u00a8\u0006\u0098\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/parts/WinkMagicStudioResultButtonPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "sa", "initViewModel", "pa", "oa", "qa", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "buttonInfo", "Qa", "Ra", "Sa", "", "getPageId", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$b$a;", "event", "Da", "ma", "Ca", "La", "Ka", "", "enable", "ba", "da", "ea", "Landroid/graphics/drawable/Drawable;", "X9", "", "colorId", "strokeColorId", "Landroid/graphics/drawable/GradientDrawable;", "Y9", "ca", "aa", "show", "Pa", "Ia", "Fa", "Ba", "Ea", "Ga", "Aa", "Ha", "na", "Z9", "msg", "iconType", "Ma", "Ja", "W9", "onInitView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "d", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioStyle", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "e", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "originImage", "f", "Landroid/view/View;", "closeBtn", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "downloadBtn", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "downloadLoadingView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "regenerateContainer", BdhLogUtil.LogTag.Tag_Conn, "regenerateIcon", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "regenerateText", "E", "shareContainer", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "shareCheckbox", "G", ThirdPartyMiniPageProxy.KEY_SHARE_TEXT, "H", "divider", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "nextBtn", "J", "chanceText", "K", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "currentButtonInfo", "L", "Z", "needReportButtonExpose", "M", "errorRetryBtn", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "N", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "jumpInfo", "Lcom/tencent/mobileqq/wink/magicstudio/parts/WinkMagicStudioResultButtonPart$b;", "P", "Lcom/tencent/mobileqq/wink/magicstudio/parts/WinkMagicStudioResultButtonPart$b;", "downloadBtnInfo", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isDownloadBtnInfoInited", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Lazy;", "la", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", "resultViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", ExifInterface.LATITUDE_SOUTH, "ia", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "magicStudioViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "T", "ga", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "createViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "U", "ha", "()Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "detailPagePageViewModel", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "V", LocaleUtils.L_JAPANESE, "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "<init>", "(Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "W", "a", "b", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMagicStudioResultButtonPart extends Part {
    private static final int X = ImmersiveUtils.dpToPx(24.0f);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView regenerateIcon;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextView regenerateText;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View shareContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QUICheckBox shareCheckbox;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView shareText;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View divider;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QUIButton nextBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView chanceText;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private MagicStudioButtonInfo currentButtonInfo;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private TextView errorRetryBtn;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private JumpInfo jumpInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isDownloadBtnInfoInited;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy resultViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicStudioViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy createViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy detailPagePageViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy qqPermission;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MagicStudioPicStyle magicStudioStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final LocalMediaInfo originImage;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View closeBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView downloadBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout downloadLoadingView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View regenerateContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean needReportButtonExpose = true;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private DownloadBtnInfo downloadBtnInfo = new DownloadBtnInfo(0, null, 0, false, false, 31, null);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\"\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001a\u001a\u0004\b\t\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u0016\u0010\u001b\"\u0004\b\u001f\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/parts/WinkMagicStudioResultButtonPart$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "f", "(I)V", "haveSaved", "Ljava/lang/String;", "d", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", "residueDownloadNum", "c", "getResultType", "i", RemoteProxy.KEY_RESULT_TYPE, "Z", "()Z", "e", "(Z)V", "buttonDisabled", "g", "needShowToast", "<init>", "(ILjava/lang/String;IZZ)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class DownloadBtnInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int haveSaved;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String residueDownloadNum;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int resultType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean buttonDisabled;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean needShowToast;

        public DownloadBtnInfo() {
            this(0, null, 0, false, false, 31, null);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getButtonDisabled() {
            return this.buttonDisabled;
        }

        /* renamed from: b, reason: from getter */
        public final int getHaveSaved() {
            return this.haveSaved;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getNeedShowToast() {
            return this.needShowToast;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getResidueDownloadNum() {
            return this.residueDownloadNum;
        }

        public final void e(boolean z16) {
            this.buttonDisabled = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DownloadBtnInfo)) {
                return false;
            }
            DownloadBtnInfo downloadBtnInfo = (DownloadBtnInfo) other;
            if (this.haveSaved == downloadBtnInfo.haveSaved && Intrinsics.areEqual(this.residueDownloadNum, downloadBtnInfo.residueDownloadNum) && this.resultType == downloadBtnInfo.resultType && this.buttonDisabled == downloadBtnInfo.buttonDisabled && this.needShowToast == downloadBtnInfo.needShowToast) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            this.haveSaved = i3;
        }

        public final void g(boolean z16) {
            this.needShowToast = z16;
        }

        public final void h(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.residueDownloadNum = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.haveSaved * 31) + this.residueDownloadNum.hashCode()) * 31) + this.resultType) * 31;
            boolean z16 = this.buttonDisabled;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode + i16) * 31;
            boolean z17 = this.needShowToast;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i17 + i3;
        }

        public final void i(int i3) {
            this.resultType = i3;
        }

        @NotNull
        public String toString() {
            return "DownloadBtnInfo(haveSaved=" + this.haveSaved + ", residueDownloadNum=" + this.residueDownloadNum + ", resultType=" + this.resultType + ", buttonDisabled=" + this.buttonDisabled + ", needShowToast=" + this.needShowToast + ")";
        }

        public DownloadBtnInfo(int i3, @NotNull String residueDownloadNum, int i16, boolean z16, boolean z17) {
            Intrinsics.checkNotNullParameter(residueDownloadNum, "residueDownloadNum");
            this.haveSaved = i3;
            this.residueDownloadNum = residueDownloadNum;
            this.resultType = i16;
            this.buttonDisabled = z16;
            this.needShowToast = z17;
        }

        public /* synthetic */ DownloadBtnInfo(int i3, String str, int i16, boolean z16, boolean z17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0 : i3, (i17 & 2) != 0 ? "-1" : str, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? false : z16, (i17 & 16) != 0 ? false : z17);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/parts/WinkMagicStudioResultButtonPart$c", "Lee0/b;", "Landroid/content/Context;", "context", "", "buttonType", "sizeType", "f", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends ee0.b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int f(@Nullable Context context, int buttonType, int sizeType) {
            return ImmersiveUtils.dpToPx(14.0f);
        }
    }

    public WinkMagicStudioResultButtonPart(@Nullable MagicStudioPicStyle magicStudioPicStyle, @Nullable LocalMediaInfo localMediaInfo) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        this.magicStudioStyle = magicStudioPicStyle;
        this.originImage = localMediaInfo;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioMultiViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$resultViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MagicStudioMultiViewModel invoke() {
                return (MagicStudioMultiViewModel) WinkMagicStudioResultButtonPart.this.getViewModel(MagicStudioMultiViewModel.class);
            }
        });
        this.resultViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$magicStudioViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicStudioViewModel invoke() {
                return (MagicStudioViewModel) new ViewModelProvider(WinkMagicStudioResultButtonPart.this.getHostFragment()).get(MagicStudioViewModel.class);
            }
        });
        this.magicStudioViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioCreationViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$createViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MagicStudioCreationViewModel invoke() {
                MagicStudioCreationViewModel magicStudioCreationViewModel = (MagicStudioCreationViewModel) WinkMagicStudioResultButtonPart.this.getViewModel(MagicStudioCreationViewModel.class);
                magicStudioCreationViewModel.u3(true);
                return magicStudioCreationViewModel;
            }
        });
        this.createViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<WinkQZoneMagicStudioViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$detailPagePageViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkQZoneMagicStudioViewModel invoke() {
                ComponentCallbacks2 activity = WinkMagicStudioResultButtonPart.this.getActivity();
                if (activity instanceof FragmentActivity) {
                    return (WinkQZoneMagicStudioViewModel) new ViewModelProvider((ViewModelStoreOwner) activity).get(WinkQZoneMagicStudioViewModel.class);
                }
                return null;
            }
        });
        this.detailPagePageViewModel = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$qqPermission$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQPermission invoke() {
                return QQPermissionFactory.getQQPermission(WinkMagicStudioResultButtonPart.this.getHostFragment(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_TEMPLATE));
            }
        });
        this.qqPermission = lazy5;
    }

    private final void Aa() {
        GenerateInfo generateInfo;
        String str;
        LocalMediaInfo localMediaInfo;
        String str2;
        ArrayList<GenerateInfo> c16;
        Object firstOrNull;
        ArrayList arrayList = new ArrayList();
        JumpInfo jumpInfo = this.jumpInfo;
        if (jumpInfo != null && (c16 = jumpInfo.c()) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) c16);
            generateInfo = (GenerateInfo) firstOrNull;
        } else {
            generateInfo = null;
        }
        if (generateInfo != null) {
            str = generateInfo.getAigcImgPath();
        } else {
            str = null;
        }
        w53.b.f("WinkMagicStudioResultButtonPart", "onNextClick aigcImgPath " + str);
        if (generateInfo != null) {
            arrayList.add(TuplesKt.to(generateInfo.getAigcImgPath(), generateInfo.getMediaType()));
        }
        QUICheckBox qUICheckBox = this.shareCheckbox;
        boolean z16 = false;
        if (qUICheckBox != null && qUICheckBox.isChecked()) {
            z16 = true;
        }
        if (z16 && (localMediaInfo = this.originImage) != null && (str2 = localMediaInfo.path) != null) {
            arrayList.add(TuplesKt.to(str2, MediaType.TypeImage));
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), null, null, new WinkMagicStudioResultButtonPart$jumpToPublishPage$3(arrayList, this, null), 3, null);
    }

    private final void Ba() {
        w53.b.f("WinkMagicStudioResultButtonPart", "onCloseClick");
        View view = this.closeBtn;
        if (view != null) {
            m83.b.f416442a.u(view, this.downloadBtnInfo.getHaveSaved(), this.downloadBtnInfo.getResidueDownloadNum(), Integer.valueOf(la().getGenerateLoadStatus()));
        }
        MagicStudioCreationViewModel.s2(ga(), false, 1, null);
        WinkMagicStudioUtils.f323888a.c(getActivity(), this.magicStudioStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ca() {
        aa(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
    
        if (r0 == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Da(MagicStudioCreationViewModel.b.GotoMultiSelect event) {
        Object firstOrNull;
        boolean z16;
        String aigcImgPath;
        boolean z17;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) event.getJumpInfo().c());
        GenerateInfo generateInfo = (GenerateInfo) firstOrNull;
        if (generateInfo != null && (aigcImgPath = generateInfo.getAigcImgPath()) != null) {
            z16 = true;
            if (aigcImgPath.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = false;
        if (z16) {
            ma(event);
        } else {
            w53.b.c("WinkMagicStudioResultButtonPart", "onCreateSuccess: aigcImgPath is empty");
            aa(false);
        }
    }

    private final void Ea() {
        w53.b.f("WinkMagicStudioResultButtonPart", "onDownloadClick");
        if (FastClickUtils.isFastDoubleClick("WinkMagicStudioResultButtonPartonDownloadClick")) {
            w53.b.g("WinkMagicStudioResultButtonPart", "onDownloadClick fast click");
            return;
        }
        if (this.downloadBtnInfo.getButtonDisabled()) {
            this.downloadBtnInfo.f(1);
            this.downloadBtnInfo.i(3);
            Ja();
            Na(this, "\u6b21\u6570\u5df2\u7528\u5c3d\uff0c\u53d1\u8868\u540e\u518d\u4fdd\u5b58\u5427", 0, 2, null);
            return;
        }
        WinkMagicStudioLogicUtils.f323883a.d(ja(), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$onDownloadClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                WinkMagicStudioResultButtonPart.DownloadBtnInfo downloadBtnInfo;
                JumpInfo jumpInfo;
                JumpInfo jumpInfo2;
                MagicStudioMultiViewModel la5;
                JumpInfo jumpInfo3;
                if (z16) {
                    downloadBtnInfo = WinkMagicStudioResultButtonPart.this.downloadBtnInfo;
                    downloadBtnInfo.f(1);
                    WinkMagicStudioResultButtonPart.this.La();
                    jumpInfo = WinkMagicStudioResultButtonPart.this.jumpInfo;
                    if (jumpInfo != null) {
                        jumpInfo2 = WinkMagicStudioResultButtonPart.this.jumpInfo;
                        Intrinsics.checkNotNull(jumpInfo2);
                        if (!jumpInfo2.c().isEmpty()) {
                            WinkMagicStudioResultButtonPart.this.Ja();
                            la5 = WinkMagicStudioResultButtonPart.this.la();
                            jumpInfo3 = WinkMagicStudioResultButtonPart.this.jumpInfo;
                            Intrinsics.checkNotNull(jumpInfo3);
                            la5.p2(jumpInfo3.c());
                            return;
                        }
                    }
                    w53.b.c("WinkMagicStudioResultButtonPart", "onDownloadClick jumpInfo is null");
                    WinkMagicStudioResultButtonPart.this.Ma("\u4fdd\u5b58\u5931\u8d25", 1);
                    return;
                }
                w53.b.c("WinkMagicStudioResultButtonPart", "onDownloadClick no storage permission");
            }
        });
    }

    private final void Fa() {
        w53.b.f("WinkMagicStudioResultButtonPart", "onErrorRetryClick");
        na();
    }

    private final void Ga() {
        String str;
        ArrayList<GenerateInfo> arrayList;
        boolean z16;
        w53.b.f("WinkMagicStudioResultButtonPart", "onNextClick");
        if (FastClickUtils.isFastDoubleClick("WinkMagicStudioResultButtonPartonNextClick")) {
            w53.b.g("WinkMagicStudioResultButtonPart", "onNextClick fast click");
            return;
        }
        m83.b bVar = m83.b.f416442a;
        QUIButton qUIButton = this.nextBtn;
        MagicStudioPicStyle magicStudioPicStyle = this.magicStudioStyle;
        if (magicStudioPicStyle != null) {
            str = magicStudioPicStyle.getStyleId();
        } else {
            str = null;
        }
        int haveSaved = this.downloadBtnInfo.getHaveSaved();
        String residueDownloadNum = this.downloadBtnInfo.getResidueDownloadNum();
        int regenerateCount = ga().getRegenerateCount();
        JumpInfo jumpInfo = this.jumpInfo;
        if (jumpInfo != null) {
            arrayList = jumpInfo.c();
        } else {
            arrayList = null;
        }
        QUICheckBox qUICheckBox = this.shareCheckbox;
        if (qUICheckBox != null) {
            z16 = qUICheckBox.isChecked();
        } else {
            z16 = true;
        }
        bVar.y(qUIButton, 1, 1, str, haveSaved, residueDownloadNum, regenerateCount, arrayList, Boolean.valueOf(z16));
        Aa();
    }

    private final void Ha() {
        w53.b.f("WinkMagicStudioResultButtonPart", "onRegenerateClick");
        na();
    }

    private final void Ia() {
        boolean z16;
        w53.b.f("WinkMagicStudioResultButtonPart", "onShareClick");
        QUICheckBox qUICheckBox = this.shareCheckbox;
        if (qUICheckBox != null) {
            if (qUICheckBox != null) {
                z16 = qUICheckBox.isChecked();
            } else {
                z16 = true;
            }
            qUICheckBox.setChecked(true ^ z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ja() {
        String str;
        m83.b bVar = m83.b.f416442a;
        ImageView imageView = this.downloadBtn;
        String residueDownloadNum = this.downloadBtnInfo.getResidueDownloadNum();
        MagicStudioPicStyle magicStudioPicStyle = this.magicStudioStyle;
        if (magicStudioPicStyle != null) {
            str = magicStudioPicStyle.getMaterialId();
        } else {
            str = null;
        }
        bVar.v(imageView, residueDownloadNum, 1, 1, str);
    }

    private final void Ka() {
        String str;
        ImageView imageView = this.downloadBtn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        FrameLayout frameLayout = this.downloadLoadingView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        m83.b bVar = m83.b.f416442a;
        ImageView imageView2 = this.downloadBtn;
        String residueDownloadNum = this.downloadBtnInfo.getResidueDownloadNum();
        MagicStudioPicStyle magicStudioPicStyle = this.magicStudioStyle;
        if (magicStudioPicStyle != null) {
            str = magicStudioPicStyle.getMaterialId();
        } else {
            str = null;
        }
        bVar.w(imageView2, residueDownloadNum, 1, 1, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void La() {
        ImageView imageView = this.downloadBtn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        FrameLayout frameLayout = this.downloadLoadingView;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ma(final String msg2, final int iconType) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.h
            @Override // java.lang.Runnable
            public final void run() {
                WinkMagicStudioResultButtonPart.Oa(iconType, msg2);
            }
        });
    }

    static /* synthetic */ void Na(WinkMagicStudioResultButtonPart winkMagicStudioResultButtonPart, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        winkMagicStudioResultButtonPart.Ma(str, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(int i3, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(MobileQQ.sMobileQQ, i3, msg2, 0).show();
    }

    private final void Pa(boolean show) {
        int i3;
        boolean z16 = false;
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        if (show) {
            View view = this.shareContainer;
            if (view != null && view.getVisibility() == i3) {
                z16 = true;
            }
            if (!z16) {
                com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "dt_imp", this.shareContainer, WinkDaTongReportConstant.ElementId.EM_QZ_SHARE_ORIGINAL_PICTURE, null, null, 24, null);
            }
        }
        View view2 = this.regenerateContainer;
        if (view2 != null) {
            view2.setVisibility(i3);
        }
        View view3 = this.shareContainer;
        if (view3 != null) {
            view3.setVisibility(i3);
        }
        TextView textView = this.chanceText;
        if (textView != null) {
            textView.setVisibility(i3);
        }
        View view4 = this.divider;
        if (view4 != null) {
            view4.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qa(MagicStudioButtonInfo buttonInfo) {
        boolean z16;
        String str;
        boolean z17;
        String str2;
        String subtitleString;
        String subtitleString2;
        String str3 = "-1";
        if (!this.isDownloadBtnInfoInited) {
            DownloadBtnInfo downloadBtnInfo = this.downloadBtnInfo;
            if (buttonInfo != null && (subtitleString2 = buttonInfo.getSubtitleString()) != null) {
                str3 = subtitleString2;
            }
            downloadBtnInfo.h(str3);
            this.isDownloadBtnInfoInited = true;
            return;
        }
        DownloadBtnInfo downloadBtnInfo2 = this.downloadBtnInfo;
        if (buttonInfo != null && (subtitleString = buttonInfo.getSubtitleString()) != null) {
            str3 = subtitleString;
        }
        downloadBtnInfo2.h(str3);
        DownloadBtnInfo downloadBtnInfo3 = this.downloadBtnInfo;
        if (buttonInfo != null && buttonInfo.getActionType() == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        downloadBtnInfo3.e(z16);
        ImageView imageView = this.downloadBtn;
        if (imageView != null) {
            imageView.setEnabled(true);
        }
        if (this.downloadBtnInfo.getButtonDisabled()) {
            ImageView imageView2 = this.downloadBtn;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.l6m);
            }
        } else {
            ImageView imageView3 = this.downloadBtn;
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.l6l);
            }
        }
        if (this.downloadBtnInfo.getNeedShowToast()) {
            String str4 = null;
            if (buttonInfo != null) {
                str = buttonInfo.getSubtitleString();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                str2 = "\u5df2\u4fdd\u5b58\u5230\u672c\u5730";
            } else {
                if (buttonInfo != null) {
                    str4 = buttonInfo.getSubtitleString();
                }
                str2 = "\u5df2\u4fdd\u5b58\u5230\u672c\u5730, " + str4;
            }
            this.downloadBtnInfo.g(false);
            this.downloadBtnInfo.i(1);
            Ma(str2, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ra(MagicStudioButtonInfo buttonInfo) {
        Integer num;
        String subtitleString;
        MutableLiveData<MagicStudioButtonInfo> N1;
        this.currentButtonInfo = buttonInfo;
        if (buttonInfo != null) {
            buttonInfo.f(true);
        }
        WinkQZoneMagicStudioViewModel ha5 = ha();
        if (ha5 != null && (N1 = ha5.N1()) != null) {
            N1.postValue(this.currentButtonInfo);
        }
        MagicStudioButtonInfo magicStudioButtonInfo = this.currentButtonInfo;
        if (magicStudioButtonInfo != null && (subtitleString = magicStudioButtonInfo.getSubtitleString()) != null) {
            TextView textView = this.chanceText;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.chanceText;
            if (textView2 != null) {
                textView2.setText(subtitleString);
            }
        }
        Sa();
        if (this.needReportButtonExpose) {
            this.needReportButtonExpose = false;
            m83.b bVar = m83.b.f416442a;
            String pageId = getPageId();
            MagicStudioButtonInfo magicStudioButtonInfo2 = this.currentButtonInfo;
            if (magicStudioButtonInfo2 != null) {
                num = Integer.valueOf(magicStudioButtonInfo2.getActionType());
            } else {
                num = null;
            }
            bVar.g(pageId, num);
        }
    }

    private final void Sa() {
        MagicStudioButtonInfo magicStudioButtonInfo = this.currentButtonInfo;
        if (magicStudioButtonInfo == null) {
            return;
        }
        boolean z16 = false;
        if (magicStudioButtonInfo != null && magicStudioButtonInfo.getActionType() == 4) {
            z16 = true;
        }
        da(!z16);
    }

    private final void W9() {
        VideoReport.setElementId(this.shareContainer, WinkDaTongReportConstant.ElementId.EM_QZ_SHARE_ORIGINAL_PICTURE);
        VideoReport.setElementId(this.errorRetryBtn, WinkDaTongReportConstant.ElementId.EM_QZ_TRY_AGAIN);
        VideoReport.setElementId(this.nextBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_READY_BUTTON);
        VideoReport.setElementExposePolicy(this.errorRetryBtn, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this.errorRetryBtn, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.errorRetryBtn, ClickPolicy.REPORT_ALL);
    }

    private final Drawable X9() {
        GradientDrawable Y9 = Y9(R.color.qui_common_brand_light, R.color.qui_common_brand_light);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{Y9(R.color.qui_common_brand_light, 0), ie0.a.f().o(getContext(), R.drawable.qui_common_check_icon_secondary, R.color.qui_common_on_brand_primary, 1000)});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, layerDrawable);
        stateListDrawable.addState(new int[0], Y9);
        return stateListDrawable;
    }

    private final GradientDrawable Y9(int colorId, int strokeColorId) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ie0.a.f().h(getContext(), colorId, 1000));
        if (strokeColorId != 0) {
            gradientDrawable.setStroke(com.tencent.biz.qui.quicommon.e.a(1.0f), ie0.a.f().h(getContext(), strokeColorId, 1000));
        }
        gradientDrawable.setSize(com.tencent.biz.qui.quicommon.e.a(24.0f), com.tencent.biz.qui.quicommon.e.a(24.0f));
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z9() {
        String str;
        m83.b bVar = m83.b.f416442a;
        MagicStudioPicStyle magicStudioPicStyle = this.magicStudioStyle;
        if (magicStudioPicStyle != null) {
            str = magicStudioPicStyle.getStyleId();
        } else {
            str = null;
        }
        bVar.D(str, "3", getPageId());
        ia().T1(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aa(boolean enable) {
        da(enable);
        ea(enable);
        ca(enable);
        ba(enable);
    }

    private final void ba(boolean enable) {
        ImageView imageView = this.downloadBtn;
        if (imageView != null) {
            imageView.setEnabled(enable);
        }
        if (enable) {
            ImageView imageView2 = this.downloadBtn;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.l6l);
                return;
            }
            return;
        }
        ImageView imageView3 = this.downloadBtn;
        if (imageView3 != null) {
            imageView3.setImageResource(R.drawable.l6m);
        }
    }

    private final void ca(boolean enable) {
        QUIButton qUIButton = this.nextBtn;
        if (qUIButton != null) {
            qUIButton.setEnabled(enable);
        }
        if (enable) {
            QUIButton qUIButton2 = this.nextBtn;
            if (qUIButton2 != null) {
                qUIButton2.o();
                return;
            }
            return;
        }
        QUIButton qUIButton3 = this.nextBtn;
        if (qUIButton3 != null) {
            qUIButton3.setBackgroundDisabled();
        }
    }

    private final void da(boolean enable) {
        View view = this.regenerateContainer;
        if (view != null) {
            view.setEnabled(enable);
        }
        if (enable) {
            ImageView imageView = this.regenerateIcon;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.l6w);
            }
            TextView textView = this.regenerateText;
            if (textView != null) {
                textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
                return;
            }
            return;
        }
        ImageView imageView2 = this.regenerateIcon;
        if (imageView2 != null) {
            imageView2.setImageResource(R.drawable.l6v);
        }
        TextView textView2 = this.regenerateText;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getColor(R.color.qui_common_text_secondary_light));
        }
    }

    private final void ea(boolean enable) {
        View view = this.shareContainer;
        if (view != null) {
            view.setEnabled(enable);
        }
        QUICheckBox qUICheckBox = this.shareCheckbox;
        if (qUICheckBox != null) {
            qUICheckBox.setEnabled(enable);
        }
        if (enable) {
            TextView textView = this.shareText;
            if (textView != null) {
                textView.setTextColor(getContext().getColor(R.color.qui_common_text_primary));
            }
            TextView textView2 = this.chanceText;
            if (textView2 != null) {
                textView2.setTextColor(getContext().getColor(R.color.qui_common_text_secondary));
                return;
            }
            return;
        }
        TextView textView3 = this.shareText;
        if (textView3 != null) {
            textView3.setTextColor(getContext().getColor(R.color.qui_common_text_secondary_light));
        }
        TextView textView4 = this.chanceText;
        if (textView4 != null) {
            textView4.setTextColor(getContext().getColor(R.color.qui_common_text_secondary_light));
        }
        QUICheckBox qUICheckBox2 = this.shareCheckbox;
        if (qUICheckBox2 != null) {
            qUICheckBox2.setBackground(X9());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioCreationViewModel ga() {
        Object value = this.createViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-createViewModel>(...)");
        return (MagicStudioCreationViewModel) value;
    }

    private final String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_MAIGC_STUDIO_PICTURE_CHOOSE_PAGE;
    }

    private final WinkQZoneMagicStudioViewModel ha() {
        return (WinkQZoneMagicStudioViewModel) this.detailPagePageViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioViewModel ia() {
        return (MagicStudioViewModel) this.magicStudioViewModel.getValue();
    }

    private final void initViewModel() {
        oa();
        qa();
        pa();
    }

    private final QQPermission ja() {
        Object value = this.qqPermission.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-qqPermission>(...)");
        return (QQPermission) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioMultiViewModel la() {
        Object value = this.resultViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-resultViewModel>(...)");
        return (MagicStudioMultiViewModel) value;
    }

    private final void ma(MagicStudioCreationViewModel.b.GotoMultiSelect event) {
        aa(true);
        Pa(true);
        if (!event.getIsRegenerate()) {
            ia().T1(1);
        }
        if (event.getJumpInfo().getCgiButtonInfo() != null) {
            MagicStudioMultiViewModel la5 = la();
            MagicStudioButtonInfo cgiButtonInfo = event.getJumpInfo().getCgiButtonInfo();
            Intrinsics.checkNotNull(cgiButtonInfo);
            la5.x2(1, cgiButtonInfo);
        } else {
            la().n2(1);
        }
        la().n2(3);
        this.jumpInfo = event.getJumpInfo();
    }

    private final void na() {
        if (WinkMagicStudioLogicUtils.f323883a.p(this.regenerateContainer, this.currentButtonInfo, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$handleRegenerate$success$1
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
                MagicStudioCreationViewModel ga5;
                MagicStudioPicStyle magicStudioPicStyle;
                ga5 = WinkMagicStudioResultButtonPart.this.ga();
                magicStudioPicStyle = WinkMagicStudioResultButtonPart.this.magicStudioStyle;
                ga5.l3(magicStudioPicStyle, 1);
                WinkMagicStudioResultButtonPart.this.aa(false);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$handleRegenerate$success$2
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
                MagicStudioPicStyle magicStudioPicStyle;
                WinkMagicStudioLogicUtils winkMagicStudioLogicUtils = WinkMagicStudioLogicUtils.f323883a;
                Activity activity = WinkMagicStudioResultButtonPart.this.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                magicStudioPicStyle = WinkMagicStudioResultButtonPart.this.magicStudioStyle;
                final WinkMagicStudioResultButtonPart winkMagicStudioResultButtonPart = WinkMagicStudioResultButtonPart.this;
                winkMagicStudioLogicUtils.g(activity, magicStudioPicStyle, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$handleRegenerate$success$2.1
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
                        WinkMagicStudioResultButtonPart.this.Z9();
                    }
                });
            }
        })) {
            this.needReportButtonExpose = true;
        }
    }

    private final void oa() {
        MagicStudioCreationViewModel ga5 = ga();
        LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "hostFragment.viewLifecycleOwner");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        MagicStudioCreationViewModel.v2(ga5, viewLifecycleOwner, context, null, new Function1<MagicStudioCreationViewModel.b.GotoMultiSelect, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$initCreateViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MagicStudioCreationViewModel.b.GotoMultiSelect gotoMultiSelect) {
                invoke2(gotoMultiSelect);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MagicStudioCreationViewModel.b.GotoMultiSelect it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WinkMagicStudioResultButtonPart.this.Da(it);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.WinkMagicStudioResultButtonPart$initCreateViewModel$2
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
                WinkMagicStudioResultButtonPart.this.Ca();
            }
        }, null, null, true, true, 100, null);
    }

    private final void pa() {
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new WinkMagicStudioResultButtonPart$initMagicStudioViewModel$1(this, null));
    }

    private final void qa() {
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new WinkMagicStudioResultButtonPart$initResultViewModel$1(this, null));
        la().d2().observe(getHostFragment().getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkMagicStudioResultButtonPart.ra(WinkMagicStudioResultButtonPart.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(WinkMagicStudioResultButtonPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool == null) {
            w53.b.g("WinkMagicStudioResultButtonPart", "saveImageResult is null");
            return;
        }
        this$0.Ka();
        if (!bool.booleanValue()) {
            w53.b.c("WinkMagicStudioResultButtonPart", "saveImageResult is false");
            this$0.downloadBtnInfo.i(2);
            this$0.Ma("\u4fdd\u5b58\u5931\u8d25", 1);
            return;
        }
        this$0.ia().T1(3);
    }

    private final void sa(View rootView) {
        View view;
        ImageView imageView;
        View view2;
        ImageView imageView2;
        TextView textView;
        View view3;
        QUICheckBox qUICheckBox;
        TextView textView2;
        View view4;
        QUIButton qUIButton;
        TextView textView3;
        TextView textView4;
        FrameLayout frameLayout = null;
        if (rootView != null) {
            view = rootView.findViewById(R.id.az7);
        } else {
            view = null;
        }
        this.closeBtn = view;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    WinkMagicStudioResultButtonPart.ta(WinkMagicStudioResultButtonPart.this, view5);
                }
            });
        }
        if (rootView != null) {
            imageView = (ImageView) rootView.findViewById(R.id.bp5);
        } else {
            imageView = null;
        }
        this.downloadBtn = imageView;
        if (rootView != null) {
            view2 = rootView.findViewById(R.id.f72453qw);
        } else {
            view2 = null;
        }
        this.regenerateContainer = view2;
        if (rootView != null) {
            imageView2 = (ImageView) rootView.findViewById(R.id.f72463qx);
        } else {
            imageView2 = null;
        }
        this.regenerateIcon = imageView2;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f72473qy);
        } else {
            textView = null;
        }
        this.regenerateText = textView;
        if (textView != null) {
            textView.setText(WinkMagicStudioLogicUtils.f323883a.u());
        }
        if (rootView != null) {
            view3 = rootView.findViewById(R.id.f166868ir2);
        } else {
            view3 = null;
        }
        this.shareContainer = view3;
        if (rootView != null) {
            qUICheckBox = (QUICheckBox) rootView.findViewById(R.id.f84254lr);
        } else {
            qUICheckBox = null;
        }
        this.shareCheckbox = qUICheckBox;
        if (rootView != null) {
            textView2 = (TextView) rootView.findViewById(R.id.f84504mf);
        } else {
            textView2 = null;
        }
        this.shareText = textView2;
        if (rootView != null) {
            view4 = rootView.findViewById(R.id.bmt);
        } else {
            view4 = null;
        }
        this.divider = view4;
        if (rootView != null) {
            qUIButton = (QUIButton) rootView.findViewById(R.id.f8w);
        } else {
            qUIButton = null;
        }
        this.nextBtn = qUIButton;
        if (qUIButton != null) {
            qUIButton.setQUIButtonResHelper(new c());
        }
        if (rootView != null) {
            textView3 = (TextView) rootView.findViewById(R.id.f164763tr3);
        } else {
            textView3 = null;
        }
        this.chanceText = textView3;
        if (rootView != null) {
            textView4 = (TextView) rootView.findViewById(R.id.uwu);
        } else {
            textView4 = null;
        }
        this.errorRetryBtn = textView4;
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f165015ul3);
        }
        this.downloadLoadingView = frameLayout;
        boolean z16 = false;
        Pa(false);
        aa(false);
        FrameLayout frameLayout2 = this.downloadLoadingView;
        if (frameLayout2 != null) {
            Context context = getContext();
            int i3 = X;
            frameLayout2.addView(LoadingUtil.getLoadingView(context, i3, i3, 2));
        }
        View view5 = this.regenerateContainer;
        if (view5 != null) {
            view5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    WinkMagicStudioResultButtonPart.ua(WinkMagicStudioResultButtonPart.this, view6);
                }
            });
        }
        QUICheckBox qUICheckBox2 = this.shareCheckbox;
        if (qUICheckBox2 != null) {
            MagicStudioPicStyle magicStudioPicStyle = this.magicStudioStyle;
            if (magicStudioPicStyle != null && magicStudioPicStyle.getPublishWithOriginImage()) {
                z16 = true;
            }
            qUICheckBox2.setChecked(z16);
        }
        View view6 = this.shareContainer;
        if (view6 != null) {
            view6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    WinkMagicStudioResultButtonPart.va(WinkMagicStudioResultButtonPart.this, view7);
                }
            });
        }
        QUIButton qUIButton2 = this.nextBtn;
        if (qUIButton2 != null) {
            qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    WinkMagicStudioResultButtonPart.wa(WinkMagicStudioResultButtonPart.this, view7);
                }
            });
        }
        TextView textView5 = this.errorRetryBtn;
        if (textView5 != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    WinkMagicStudioResultButtonPart.xa(WinkMagicStudioResultButtonPart.this, view7);
                }
            });
        }
        ImageView imageView3 = this.downloadBtn;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.parts.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    WinkMagicStudioResultButtonPart.za(WinkMagicStudioResultButtonPart.this, view7);
                }
            });
        }
        W9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ta(WinkMagicStudioResultButtonPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ba();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(WinkMagicStudioResultButtonPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ha();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(WinkMagicStudioResultButtonPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ia();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(WinkMagicStudioResultButtonPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ga();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xa(WinkMagicStudioResultButtonPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void za(WinkMagicStudioResultButtonPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ea();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 52130 && resultCode == -1) {
            Z9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        sa(rootView);
        initViewModel();
        la().n2(3);
    }
}
