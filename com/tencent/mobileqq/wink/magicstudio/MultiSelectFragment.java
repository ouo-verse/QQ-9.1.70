package com.tencent.mobileqq.wink.magicstudio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.wink.editor.cu;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgInfo;
import com.tencent.mobileqq.wink.magicstudio.model.State;
import com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioViewModel;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.wink.magicstudio.view.MagicStudioSaveButton;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.wink.utils.ax;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00a6\u00012\u00020\u0001:\u0002\u00a7\u0001B\t\u00a2\u0006\u0006\b\u00a4\u0001\u0010\u00a5\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J/\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u000e\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\tH\u0003J\b\u0010'\u001a\u00020\tH\u0002J\b\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u000bH\u0002J\u0016\u0010-\u001a\u00020\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\u0010\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\tH\u0002J\b\u00101\u001a\u00020\tH\u0002J\u0018\u00103\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\tH\u0002R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001b\u0010?\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u00107\u001a\u0004\bB\u0010CR\u001b\u0010H\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u00107\u001a\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u00107\u001a\u0004\bK\u0010LR\u001b\u0010P\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u00107\u001a\u0004\bO\u0010LR\u001b\u0010S\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u00107\u001a\u0004\bR\u0010LR\u001b\u0010V\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u00107\u001a\u0004\bU\u0010GR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u00107\u001a\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010QR\u001b\u0010l\u001a\u00020h8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u00107\u001a\u0004\bj\u0010kR\u001b\u0010q\u001a\u00020m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u00107\u001a\u0004\bo\u0010pR\u001b\u0010v\u001a\u00020r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u00107\u001a\u0004\bt\u0010uR\u001b\u0010{\u001a\u00020w8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bx\u00107\u001a\u0004\by\u0010zR\u0018\u0010\u007f\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010QR\u0019\u0010\u0084\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010QR\u0019\u0010\u0088\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0083\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0089\u0001R\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001c\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u0019\u0010\u0098\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0083\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009e\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u0083\u0001R \u0010\u00a3\u0001\u001a\u00030\u009f\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a0\u0001\u00107\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001\u00a8\u0006\u00a8\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MultiSelectFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "onBackEvent", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Qh", "getPageId", "qi", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "li", "ki", SensorJsPlugin.SENSOR_INTERVAL_UI, "Rh", "ii", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "hi", "btnView", "si", "Th", "xi", "elementId", "Ph", "ti", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Vh", "()Landroid/widget/ImageView;", "close", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "D", "fi", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "toNextBtn", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Wh", "()Landroidx/recyclerview/widget/RecyclerView;", "imgsRecyclerView", UserInfo.SEX_FEMALE, "di", "()Landroid/view/View;", "tipsView", "Landroid/widget/TextView;", "G", "ci", "()Landroid/widget/TextView;", "selectDesc", "H", "ei", "titleText", "I", "Uh", "buttonCountText", "J", "getRoot", "root", "Landroid/widget/FrameLayout;", "K", "bi", "()Landroid/widget/FrameLayout;", "saveContainer", "L", "Landroid/widget/TextView;", "buttonRegenerate", "M", "Landroid/widget/ImageView;", "imageBtnRegenerate", "Landroid/widget/LinearLayout;", "N", "Landroid/widget/LinearLayout;", "buttonRegenerateContainer", "P", "recyclerViewMaxHeight", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "gi", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioMultiViewModel;", "vm", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", BdhLogUtil.LogTag.Tag_Req, "Yh", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "magicStudioViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", ExifInterface.LATITUDE_SOUTH, "ai", "()Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "qzoneMagicStudioViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "T", "Xh", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "magicStudioCreationViewModel", "Lcom/tencent/mobileqq/wink/magicstudio/d;", "U", "Lcom/tencent/mobileqq/wink/magicstudio/d;", "imgAdapter", "V", "listOrientation", "W", "Z", "isCollectionStyle", "X", "count", "Y", "isVertical", "Ljava/lang/String;", "reportSessionID", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "a0", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "magicStudioPicStyle", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "b0", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "uploadDialog", "Lcom/tencent/mobileqq/wink/magicstudio/view/MagicStudioSaveButton;", "c0", "Lcom/tencent/mobileqq/wink/magicstudio/view/MagicStudioSaveButton;", "saveView", "d0", "isEnableRegenerate", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "e0", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "currentButtonInfo", "f0", "needReportButtonExpose", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "g0", "Zh", "()Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "<init>", "()V", "h0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MultiSelectFragment extends QPublicBaseFragment {

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i0, reason: collision with root package name */
    private static final int f323686i0 = Color.parseColor("#000000");

    /* renamed from: j0, reason: collision with root package name */
    private static final int f323687j0 = Color.parseColor("#4D000000");

    /* renamed from: k0, reason: collision with root package name */
    private static final int f323688k0 = Color.parseColor("#FFFFFF");

    /* renamed from: l0, reason: collision with root package name */
    private static final int f323689l0 = Color.parseColor("#4DFFFFFF");

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy close;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy toNextBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy imgsRecyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy tipsView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectDesc;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy titleText;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy buttonCountText;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy root;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy saveContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView buttonRegenerate;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView imageBtnRegenerate;

    /* renamed from: N, reason: from kotlin metadata */
    private LinearLayout buttonRegenerateContainer;

    /* renamed from: P, reason: from kotlin metadata */
    private int recyclerViewMaxHeight;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicStudioViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final Lazy qzoneMagicStudioViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicStudioCreationViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private d imgAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private int listOrientation;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isCollectionStyle;

    /* renamed from: X, reason: from kotlin metadata */
    private int count;

    /* renamed from: Y, reason: from kotlin metadata */
    private boolean isVertical;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private String reportSessionID;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MagicStudioPicStyle magicStudioPicStyle;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog uploadDialog;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MagicStudioSaveButton saveView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isEnableRegenerate;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MagicStudioButtonInfo currentButtonInfo;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean needReportButtonExpose;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qqPermission;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MultiSelectFragment$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/magicstudio/MultiSelectFragment;", "a", "", "HORIZONTAL_IMAGE_MAX_HEIGHT_RATIO", UserInfo.SEX_FEMALE, "HORIZONTAL_IMAGE_MAX_HEIGHT_RATIO_REGENERATE", "", "REGENERATE_BUTTON_COLOR_DAY_DISABLE", "I", "REGENERATE_BUTTON_COLOR_DAY_ENABLE", "REGENERATE_BUTTON_COLOR_NIGHT_DISABLE", "REGENERATE_BUTTON_COLOR_NIGHT_ENABLE", "", "TAG", "Ljava/lang/String;", "VERTICAL_IMAGE_MAX_HEIGHT", "VERTICAL_IMAGE_MAX_HEIGHT_RATIO", "VERTICAL_IMAGE_MAX_HEIGHT_RATIO_REGENERATE", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final MultiSelectFragment a(@Nullable Bundle bundle) {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            MultiSelectFragment multiSelectFragment = new MultiSelectFragment();
            multiSelectFragment.setArguments(bundle2);
            return multiSelectFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/MultiSelectFragment$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (MultiSelectFragment.this.listOrientation == 0) {
                outRect.right = ViewExKt.d(11);
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (parent.getAdapter() != null && childAdapterPosition == r4.getNUM_BACKGOURND_ICON() - 1) {
                    outRect.right = ViewExKt.d(16);
                    return;
                }
                return;
            }
            outRect.bottom = ViewExKt.d(12);
        }
    }

    public MultiSelectFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$close$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) MultiSelectFragment.this.requireView().findViewById(R.id.close);
            }
        });
        this.close = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QUIButton>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$toNextBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIButton invoke() {
                return (QUIButton) MultiSelectFragment.this.requireView().findViewById(R.id.xkn);
            }
        });
        this.toNextBtn = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$imgsRecyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) MultiSelectFragment.this.requireView().findViewById(R.id.f165788xl1);
            }
        });
        this.imgsRecyclerView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$tipsView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return MultiSelectFragment.this.requireView().findViewById(R.id.jnc);
            }
        });
        this.tipsView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$selectDesc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) MultiSelectFragment.this.requireView().findViewById(R.id.f82214g_);
            }
        });
        this.selectDesc = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$titleText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) MultiSelectFragment.this.requireView().findViewById(R.id.f82204g9);
            }
        });
        this.titleText = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$buttonCountText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) MultiSelectFragment.this.requireView().findViewById(R.id.tja);
            }
        });
        this.buttonCountText = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$root$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return MultiSelectFragment.this.requireView().findViewById(R.id.root);
            }
        });
        this.root = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$saveContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) MultiSelectFragment.this.requireView().findViewById(R.id.f793749l);
            }
        });
        this.saveContainer = lazy9;
        this.recyclerViewMaxHeight = ViewUtils.getScreenHeight();
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioMultiViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicStudioMultiViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MultiSelectFragment.this).get(MagicStudioMultiViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026ltiViewModel::class.java)");
                return (MagicStudioMultiViewModel) viewModel;
            }
        });
        this.vm = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$magicStudioViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicStudioViewModel invoke() {
                return (MagicStudioViewModel) new ViewModelProvider(MultiSelectFragment.this.requireActivity()).get(MagicStudioViewModel.class);
            }
        });
        this.magicStudioViewModel = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<WinkQZoneMagicStudioViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$qzoneMagicStudioViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkQZoneMagicStudioViewModel invoke() {
                return (WinkQZoneMagicStudioViewModel) new ViewModelProvider(MultiSelectFragment.this.requireActivity()).get(WinkQZoneMagicStudioViewModel.class);
            }
        });
        this.qzoneMagicStudioViewModel = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioCreationViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$magicStudioCreationViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicStudioCreationViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MultiSelectFragment.this).get(MagicStudioCreationViewModel.class);
                MagicStudioCreationViewModel magicStudioCreationViewModel = (MagicStudioCreationViewModel) viewModel;
                magicStudioCreationViewModel.u3(true);
                magicStudioCreationViewModel.s3(false);
                magicStudioCreationViewModel.v3(true);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026generate = true\n        }");
                return magicStudioCreationViewModel;
            }
        });
        this.magicStudioCreationViewModel = lazy13;
        this.count = 1;
        this.isVertical = true;
        this.reportSessionID = "";
        this.needReportButtonExpose = true;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<QQPermission>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$qqPermission$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQPermission invoke() {
                return QQPermissionFactory.getQQPermission(MultiSelectFragment.this, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_CIRCLE_PUBLISH, QQPermissionConstants.Business.SCENE.CIRCLE_PUBLISH_TEMPLATE));
            }
        });
        this.qqPermission = lazy14;
    }

    private final void Ph(View view, String elementId) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    private final void Qh(View view) {
        String str;
        m83.b bVar = m83.b.f416442a;
        FragmentActivity activity = getActivity();
        boolean picMode = gi().getPicMode();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("aigc_img_generate_style_id")) == null) {
            str = "";
        }
        bVar.x(activity, view, picMode, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh() {
        com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.y
            @Override // java.lang.Runnable
            public final void run() {
                MultiSelectFragment.Sh(MultiSelectFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(MultiSelectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.uploadDialog;
        if (qCircleCommonLoadingDialog != null && qCircleCommonLoadingDialog.isShowing()) {
            qCircleCommonLoadingDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th() {
        String str;
        m83.b bVar = m83.b.f416442a;
        MagicStudioPicStyle magicStudioPicStyle = this.magicStudioPicStyle;
        if (magicStudioPicStyle != null) {
            str = magicStudioPicStyle.getStyleId();
        } else {
            str = null;
        }
        bVar.D(str, "3", getPageId());
        Yh().T1(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Uh() {
        Object value = this.buttonCountText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-buttonCountText>(...)");
        return (TextView) value;
    }

    private final ImageView Vh() {
        Object value = this.close.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-close>(...)");
        return (ImageView) value;
    }

    private final RecyclerView Wh() {
        Object value = this.imgsRecyclerView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imgsRecyclerView>(...)");
        return (RecyclerView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioCreationViewModel Xh() {
        return (MagicStudioCreationViewModel) this.magicStudioCreationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioViewModel Yh() {
        return (MagicStudioViewModel) this.magicStudioViewModel.getValue();
    }

    private final QQPermission Zh() {
        Object value = this.qqPermission.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-qqPermission>(...)");
        return (QQPermission) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkQZoneMagicStudioViewModel ai() {
        return (WinkQZoneMagicStudioViewModel) this.qzoneMagicStudioViewModel.getValue();
    }

    private final FrameLayout bi() {
        Object value = this.saveContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-saveContainer>(...)");
        return (FrameLayout) value;
    }

    private final TextView ci() {
        Object value = this.selectDesc.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-selectDesc>(...)");
        return (TextView) value;
    }

    private final View di() {
        Object value = this.tipsView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tipsView>(...)");
        return (View) value;
    }

    private final TextView ei() {
        Object value = this.titleText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-titleText>(...)");
        return (TextView) value;
    }

    private final QUIButton fi() {
        Object value = this.toNextBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-toNextBtn>(...)");
        return (QUIButton) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_MAIGC_STUDIO_PICTURE_CHOOSE_PAGE;
    }

    private final View getRoot() {
        Object value = this.root.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-root>(...)");
        return (View) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicStudioMultiViewModel gi() {
        return (MagicStudioMultiViewModel) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi(List<? extends LocalMediaInfo> localMediaInfos) {
        ArrayList<GenerateInfo> arrayList;
        String str;
        String str2;
        WinkMagicStudioLogicUtils winkMagicStudioLogicUtils = WinkMagicStudioLogicUtils.f323883a;
        Activity hostActivity = getHostActivity();
        boolean picMode = gi().getPicMode();
        MagicStudioPicStyle magicStudioPicStyle = this.magicStudioPicStyle;
        JumpInfo a26 = gi().a2();
        if (a26 != null) {
            arrayList = a26.c();
        } else {
            arrayList = null;
        }
        ArrayList<GenerateInfo> arrayList2 = arrayList;
        int regenerateCount = Xh().getRegenerateCount();
        String styleId = gi().getStyleId();
        if (styleId == null) {
            str = "";
        } else {
            str = styleId;
        }
        String materialId = gi().getMaterialId();
        if (materialId == null) {
            str2 = "";
        } else {
            str2 = materialId;
        }
        winkMagicStudioLogicUtils.k(localMediaInfos, hostActivity, picMode, magicStudioPicStyle, arrayList2, regenerateCount, null, str, str2);
    }

    private final void ii(View rootView) {
        gi().g2();
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new MultiSelectFragment$initObserver$1(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new MultiSelectFragment$initObserver$2(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new MultiSelectFragment$initObserver$3(this, null));
        gi().T1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.x
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MultiSelectFragment.ji(MultiSelectFragment.this, (List) obj);
            }
        });
        if (this.isEnableRegenerate) {
            MagicStudioCreationViewModel Xh = Xh();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            MagicStudioCreationViewModel.v2(Xh, this, requireActivity, rootView, new Function1<MagicStudioCreationViewModel.b.GotoMultiSelect, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$initObserver$5
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
                public final void invoke2(@NotNull MagicStudioCreationViewModel.b.GotoMultiSelect selectInfo) {
                    MagicStudioMultiViewModel gi5;
                    MagicStudioMultiViewModel gi6;
                    Intrinsics.checkNotNullParameter(selectInfo, "selectInfo");
                    if (selectInfo.getJumpInfo().getCgiButtonInfo() != null) {
                        gi6 = MultiSelectFragment.this.gi();
                        MagicStudioButtonInfo cgiButtonInfo = selectInfo.getJumpInfo().getCgiButtonInfo();
                        Intrinsics.checkNotNull(cgiButtonInfo);
                        gi6.x2(1, cgiButtonInfo);
                        return;
                    }
                    gi5 = MultiSelectFragment.this.gi();
                    gi5.n2(1);
                }
            }, null, null, null, false, false, com.tencent.luggage.wxa.ig.w.CTRL_INDEX, null);
        }
    }

    private final void initView(View rootView) {
        boolean z16;
        boolean z17;
        String str;
        String str2;
        boolean z18;
        boolean z19;
        Intent intent;
        Intent intent2;
        if (m83.c.f416444a.a() && gi().getPicMode()) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isEnableRegenerate = z16;
        Context context = getContext();
        LinearLayout linearLayout = null;
        if (context != null) {
            FragmentActivity activity = getActivity();
            if (activity != null && (intent2 = activity.getIntent()) != null) {
                str = intent2.getStringExtra("force_hide_save");
            } else {
                str = null;
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                str2 = intent.getStringExtra("taskid");
            } else {
                str2 = null;
            }
            if (str != null && str.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18 || Intrinsics.areEqual(str, "0")) {
                if (str2 != null && str2.length() != 0) {
                    z19 = false;
                } else {
                    z19 = true;
                }
                if ((!z19 && com.tencent.mobileqq.wink.utils.t.f326727a.b(str2)) || r93.h.f430993a.g()) {
                    LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
                    MagicStudioMultiViewModel gi5 = gi();
                    MagicStudioViewModel magicStudioViewModel = Yh();
                    Intrinsics.checkNotNullExpressionValue(magicStudioViewModel, "magicStudioViewModel");
                    this.saveView = new MagicStudioSaveButton(context, viewLifecycleOwner, lifecycleScope, gi5, magicStudioViewModel, Zh());
                    bi().addView(this.saveView, new ViewGroup.LayoutParams(-1, -1));
                }
            }
        }
        getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiSelectFragment.mi(view);
            }
        });
        if (gi().getIsSupportMultiSelected()) {
            ei().setText(requireContext().getResources().getString(R.string.ymu));
            ci().setText(requireContext().getResources().getString(R.string.ymv));
        } else {
            ei().setText(requireContext().getResources().getString(R.string.ymw));
            ci().setText(requireContext().getResources().getString(R.string.ymx));
        }
        Vh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiSelectFragment.ni(MultiSelectFragment.this, view);
            }
        });
        if (gi().getPicMode()) {
            MagicStudioPicStyle magicStudioPicStyle = this.magicStudioPicStyle;
            if (magicStudioPicStyle != null && magicStudioPicStyle.getUseDefaultStyleId()) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                Uh().setVisibility(0);
                Yh().T1(1);
            }
        } else {
            Uh().setVisibility(0);
        }
        fi().setText(requireContext().getResources().getString(R.string.fzq));
        fi().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiSelectFragment.oi(MultiSelectFragment.this, view);
            }
        });
        Ph(fi(), WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_READY_BUTTON);
        View findViewById = rootView.findViewById(R.id.f166168yw0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Te\u2026ic_studio_btn_regenerate)");
        this.buttonRegenerate = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f166170yw2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById<Im\u2026tudio_btn_regenerate_img)");
        this.imageBtnRegenerate = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f166169yw1);
        final LinearLayout linearLayout2 = (LinearLayout) findViewById3;
        if (this.isEnableRegenerate) {
            TextView textView = this.buttonRegenerate;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buttonRegenerate");
                textView = null;
            }
            textView.setText(WinkMagicStudioLogicUtils.f323883a.u());
            linearLayout2.setVisibility(0);
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MultiSelectFragment.pi(MultiSelectFragment.this, linearLayout2, view);
                }
            });
        }
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById<Li\u2026          }\n            }");
        this.buttonRegenerateContainer = linearLayout2;
        m83.b bVar = m83.b.f416442a;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("buttonRegenerateContainer");
        } else {
            linearLayout = linearLayout2;
        }
        bVar.r(linearLayout, this.currentButtonInfo);
        ki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(MultiSelectFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.imgAdapter;
        if (dVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            dVar.refresh(it);
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        List list = it;
        boolean z16 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it5 = list.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                } else if (((GenerateInfo) it5.next()).getIsSelected()) {
                    z16 = false;
                    break;
                }
            }
        }
        if (z16) {
            this$0.fi().setBackgroundDisabled();
        } else {
            this$0.fi().o();
        }
    }

    @SuppressLint({"WrongConstant"})
    private final void ki() {
        int d16;
        d dVar;
        boolean z16 = true;
        this.listOrientation = !this.isVertical ? 1 : 0;
        li();
        if (this.listOrientation == 0) {
            d16 = ViewExKt.d(40);
        } else {
            d16 = ViewExKt.d(17);
        }
        di().setPadding(0, 0, 0, d16);
        Wh().setLayoutManager(new LinearLayoutManager(getContext(), this.listOrientation, false));
        if (this.listOrientation != 0) {
            z16 = false;
        }
        this.imgAdapter = new d(z16, gi().getIsSupportMultiSelected(), this.recyclerViewMaxHeight, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$initRecyclerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                MagicStudioMultiViewModel gi5;
                gi5 = MultiSelectFragment.this.gi();
                gi5.l2(i3);
            }
        });
        List<GenerateInfo> value = gi().T1().getValue();
        if (value != null && (dVar = this.imgAdapter) != null) {
            dVar.refresh(value);
        }
        Wh().setAdapter(this.imgAdapter);
        Wh().addItemDecoration(new b());
    }

    private final void li() {
        float f16;
        int f17;
        float f18;
        ViewGroup.LayoutParams layoutParams = Wh().getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            com.tencent.videocut.utils.o oVar = com.tencent.videocut.utils.o.f384257a;
            Context context = Wh().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "imgsRecyclerView.context");
            int f19 = oVar.f(context);
            if (this.listOrientation == 0) {
                if (this.isEnableRegenerate) {
                    f18 = 0.42f;
                } else {
                    f18 = 0.45f;
                }
                f17 = Math.min(ViewExKt.d(LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT), (int) (f19 * f18));
            } else {
                if (this.isEnableRegenerate) {
                    f16 = 0.5f;
                } else {
                    f16 = 0.62f;
                }
                Intrinsics.checkNotNullExpressionValue(Wh().getContext(), "imgsRecyclerView.context");
                f17 = (int) (oVar.f(r4) * f16);
            }
            this.recyclerViewMaxHeight = f17;
            ((ConstraintLayout.LayoutParams) layoutParams).matchConstraintMaxHeight = f17;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(MultiSelectFragment this$0, View view) {
        FragmentActivity activity;
        FragmentManager supportFragmentManager;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        MagicStudioPicStyle magicStudioPicStyle = this$0.magicStudioPicStyle;
        boolean z16 = false;
        if (magicStudioPicStyle != null && magicStudioPicStyle.getUseDefaultStyleId()) {
            z16 = true;
        }
        if (!z16 && (activity = this$0.getActivity()) != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.popBackStack();
        }
        this$0.ti();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(MultiSelectFragment this$0, View view) {
        MagicStudioSaveButton.MagicSaveInfo magicSaveInfo;
        int i3;
        int i16;
        String str;
        int i17;
        String str2;
        ArrayList<GenerateInfo> arrayList;
        ArrayList<GenerateInfo> arrayList2;
        ArrayList<GenerateInfo> c16;
        ArrayList<GenerateInfo> i06;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w53.b.f("MultiSelectFragment", "toNextBtn checkAndJumpEditor");
        MagicStudioSaveButton magicStudioSaveButton = this$0.saveView;
        if (magicStudioSaveButton != null) {
            magicSaveInfo = magicStudioSaveButton.getSaveInfo();
        } else {
            magicSaveInfo = null;
        }
        m83.b bVar = m83.b.f416442a;
        QUIButton fi5 = this$0.fi();
        d dVar = this$0.imgAdapter;
        boolean z17 = true;
        if (dVar != null && (i06 = dVar.i0()) != null) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : i06) {
                if (((GenerateInfo) obj).getState() == State.Success) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList3.add(obj);
                }
            }
            i3 = arrayList3.size();
        } else {
            i3 = 0;
        }
        JumpInfo a26 = this$0.gi().a2();
        if (a26 != null && (c16 = a26.c()) != null) {
            i16 = c16.size();
        } else {
            i16 = 0;
        }
        Bundle arguments = this$0.getArguments();
        if (arguments == null || (str = arguments.getString("aigc_img_generate_style_id")) == null) {
            str = "";
        }
        if (magicSaveInfo != null) {
            i17 = magicSaveInfo.getHaveSaved();
        } else {
            i17 = 0;
        }
        if (magicSaveInfo == null || (str2 = magicSaveInfo.getResidueDownloadNum()) == null) {
            str2 = "-1";
        }
        String str3 = str2;
        int regenerateCount = this$0.Xh().getRegenerateCount();
        JumpInfo a27 = this$0.gi().a2();
        if (a27 != null) {
            arrayList = a27.c();
        } else {
            arrayList = null;
        }
        bVar.y(fi5, i3, i16, str, i17, str3, regenerateCount, arrayList, null);
        JumpInfo a28 = this$0.gi().a2();
        if (a28 != null) {
            arrayList2 = a28.c();
        } else {
            arrayList2 = null;
        }
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            z17 = false;
        }
        if (z17) {
            QQToast.makeText(BaseApplication.getContext(), "\u81f3\u5c11\u9009\u62e9\u4e00\u5f20\u56fe\u7247", 0).show();
            w53.b.f("MultiSelectFragment", "toNextBtn checkAndJumpEditor generateInfos empty");
        } else {
            this$0.gi().i2();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pi(MultiSelectFragment this$0, LinearLayout linearLayout, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(linearLayout, "this");
        this$0.si(linearLayout);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void qi() {
        cu.x(this.count, this.reportSessionID, 0, 4, null);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MAGIC_GALLERY_FIRST_FRAME);
        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_MAGIC_GALLERY_SELECT_TO_COMPLETE_FRAME);
    }

    @JvmStatic
    @NotNull
    public static final MultiSelectFragment ri(@Nullable Bundle bundle) {
        return INSTANCE.a(bundle);
    }

    private final void si(View btnView) {
        if (WinkMagicStudioLogicUtils.f323883a.p(btnView, this.currentButtonInfo, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$onRegenerateClick$success$1
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
                MagicStudioCreationViewModel Xh;
                MagicStudioPicStyle magicStudioPicStyle;
                int i3;
                d dVar;
                Xh = MultiSelectFragment.this.Xh();
                magicStudioPicStyle = MultiSelectFragment.this.magicStudioPicStyle;
                i3 = MultiSelectFragment.this.count;
                Xh.l3(magicStudioPicStyle, i3);
                dVar = MultiSelectFragment.this.imgAdapter;
                if (dVar == null) {
                    return;
                }
                dVar.m0(true);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$onRegenerateClick$success$2
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
                FragmentActivity requireActivity = MultiSelectFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                magicStudioPicStyle = MultiSelectFragment.this.magicStudioPicStyle;
                final MultiSelectFragment multiSelectFragment = MultiSelectFragment.this;
                winkMagicStudioLogicUtils.g(requireActivity, magicStudioPicStyle, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.MultiSelectFragment$onRegenerateClick$success$2.1
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
                        MultiSelectFragment.this.Th();
                    }
                });
            }
        })) {
            this.needReportButtonExpose = true;
        }
    }

    private final void ti() {
        MagicStudioSaveButton.MagicSaveInfo magicSaveInfo;
        int i3;
        String str;
        MagicStudioSaveButton magicStudioSaveButton = this.saveView;
        if (magicStudioSaveButton != null) {
            magicSaveInfo = magicStudioSaveButton.getSaveInfo();
        } else {
            magicSaveInfo = null;
        }
        m83.b bVar = m83.b.f416442a;
        ImageView Vh = Vh();
        if (magicSaveInfo != null) {
            i3 = magicSaveInfo.getHaveSaved();
        } else {
            i3 = 0;
        }
        if (magicSaveInfo == null || (str = magicSaveInfo.getResidueDownloadNum()) == null) {
            str = "-1";
        }
        bVar.u(Vh, i3, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ui() {
        com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.z
            @Override // java.lang.Runnable
            public final void run() {
                MultiSelectFragment.vi(MultiSelectFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(MultiSelectFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this$0.uploadDialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.dismiss();
        }
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(this$0.getContext(), R.style.f173547a45).n(false).d(new Callable() { // from class: com.tencent.mobileqq.wink.magicstudio.aa
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean wi5;
                wi5 = MultiSelectFragment.wi();
                return wi5;
            }
        }).b().p(this$0.getString(R.string.f241307ri)).a();
        this$0.uploadDialog = a16;
        if (a16 != null) {
            a16.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean wi() {
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xi() {
        MagicStudioButtonInfo magicStudioButtonInfo;
        int i3;
        if (this.isEnableRegenerate && (magicStudioButtonInfo = this.currentButtonInfo) != null) {
            boolean z16 = false;
            if (magicStudioButtonInfo != null && magicStudioButtonInfo.getActionType() == 4) {
                z16 = true;
            }
            boolean z17 = !z16;
            if (ax.a()) {
                if (z17) {
                    i3 = f323688k0;
                } else {
                    i3 = f323689l0;
                }
            } else if (z17) {
                i3 = f323686i0;
            } else {
                i3 = f323687j0;
            }
            TextView textView = this.buttonRegenerate;
            ImageView imageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("buttonRegenerate");
                textView = null;
            }
            textView.setTextColor(i3);
            Drawable drawable = AppCompatResources.getDrawable(requireContext(), R.drawable.qui_refresh);
            if (drawable != null) {
                drawable.setTint(i3);
                drawable.setTintMode(PorterDuff.Mode.SRC_IN);
                if (drawable instanceof SkinnableBitmapDrawable) {
                    drawable.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_IN));
                }
                ImageView imageView2 = this.imageBtnRegenerate;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("imageBtnRegenerate");
                } else {
                    imageView = imageView2;
                }
                imageView.setImageDrawable(drawable);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dtz;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 52130 && resultCode == -1) {
            Th();
        }
        w53.b.a("MultiSelectFragment", "onActivityResult requestCode:" + requestCode);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentManager supportFragmentManager;
        MagicStudioPicStyle magicStudioPicStyle = this.magicStudioPicStyle;
        boolean z16 = false;
        if (magicStudioPicStyle != null && magicStudioPicStyle.getUseDefaultStyleId()) {
            z16 = true;
        }
        if (z16) {
            WinkMagicStudioUtils.f323888a.c(getActivity(), this.magicStudioPicStyle);
            return true;
        }
        MagicStudioDataSource.f323652a.M().setValue(Unit.INSTANCE);
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.popBackStack();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        li();
        Wh().setAdapter(this.imgAdapter);
        d dVar = this.imgAdapter;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        boolean z16;
        boolean z17;
        int i3;
        String str;
        Serializable serializable;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo;
        String str2;
        boolean z18;
        Bundle arguments;
        super.onCreate(savedInstanceState);
        MagicStudioMultiViewModel gi5 = gi();
        Bundle arguments2 = getArguments();
        boolean z19 = false;
        if (arguments2 != null) {
            z16 = arguments2.getBoolean("aigc_img_mode");
        } else {
            z16 = false;
        }
        gi5.t2(z16);
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            z17 = arguments3.getBoolean("aigc_is_collection");
        } else {
            z17 = false;
        }
        this.isCollectionStyle = z17;
        Bundle arguments4 = getArguments();
        boolean z26 = true;
        if (arguments4 != null) {
            i3 = arguments4.getInt(QQWinkTempConstants.AIGC_COUNT);
        } else {
            i3 = 1;
        }
        this.count = i3;
        Bundle arguments5 = getArguments();
        String str3 = null;
        if (arguments5 != null) {
            str = arguments5.getString(QQWinkTempConstants.MAIGC_STUDIO_REPORT_SESSION_ID);
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.reportSessionID = str;
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            serializable = arguments6.getSerializable("magic_studio_pic_style");
        } else {
            serializable = null;
        }
        this.magicStudioPicStyle = (MagicStudioPicStyle) serializable;
        MagicStudioMultiViewModel gi6 = gi();
        Bundle arguments7 = getArguments();
        if (arguments7 != null) {
            magicStudioUploadImgInfo = (MagicStudioUploadImgInfo) arguments7.getParcelable("img_info");
        } else {
            magicStudioUploadImgInfo = null;
        }
        gi6.q2(magicStudioUploadImgInfo);
        MagicStudioMultiViewModel gi7 = gi();
        Bundle arguments8 = getArguments();
        if (arguments8 != null) {
            str2 = arguments8.getString(QQWinkConstants.MAGIC_STUDIO_STYLE_ID);
        } else {
            str2 = null;
        }
        gi7.u2(str2);
        MagicStudioMultiViewModel gi8 = gi();
        Bundle arguments9 = getArguments();
        if (arguments9 != null) {
            str3 = arguments9.getString(QQWinkConstants.MAGIC_STUDIO_MATERIAL_ID);
        }
        gi8.s2(str3);
        MagicStudioMultiViewModel gi9 = gi();
        if (!gi().getPicMode() && (gi().getPicMode() || !r93.h.f430993a.g())) {
            z18 = false;
        } else {
            z18 = true;
        }
        gi9.v2(z18);
        MagicStudioPicStyle magicStudioPicStyle = this.magicStudioPicStyle;
        if (magicStudioPicStyle != null && magicStudioPicStyle.getForceVerticalResultImage()) {
            z19 = true;
        }
        if (!z19 && (arguments = getArguments()) != null) {
            z26 = arguments.getBoolean("aigc_is_vertical");
        }
        this.isVertical = z26;
        gi().w2(this.isVertical);
        w53.b.f("MultiSelectFragment", "isImgMode \uff1a" + gi().getPicMode() + ", isCollectionStyle = " + this.isCollectionStyle + ", currentImg = " + gi().getCurrentImg());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ArrayList<GenerateInfo> arrayList;
        super.onDestroy();
        d dVar = this.imgAdapter;
        boolean z16 = false;
        if (dVar != null && dVar.getNeedReportResult()) {
            z16 = true;
        }
        if (z16) {
            m83.b bVar = m83.b.f416442a;
            JumpInfo a26 = gi().a2();
            if (a26 != null) {
                arrayList = a26.c();
            } else {
                arrayList = null;
            }
            bVar.s(arrayList, true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Zh().onRequestPermissionResult(requestCode, permissions, grantResults);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Qh(view);
        initView(view);
        ii(view);
        qi();
    }
}
