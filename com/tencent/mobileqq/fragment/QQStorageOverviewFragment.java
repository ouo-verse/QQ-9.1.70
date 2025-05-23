package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.en;
import com.tencent.mobileqq.activity.lastclean.LastCleanMMKVHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi;
import com.tencent.mobileqq.app.message.messageclean.NTScanSpaceManager;
import com.tencent.mobileqq.app.message.messageclean.be;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.LoadingCircleProgress;
import com.tencent.mobileqq.widget.StorageCircleProgress;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u0093\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0094\u0001B\t\u00a2\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J$\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J,\u0010\u001f\u001a\u00020\u001c2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0013H\u0002J&\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u001a\u0010,\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0006\u0010-\u001a\u00020\u0006J\u0006\u0010.\u001a\u00020\u0006J\u0006\u0010/\u001a\u00020\u0006J\u0006\u00100\u001a\u00020\u0006J\b\u00101\u001a\u00020\u0006H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\"\u00108\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u000106H\u0016J\u0012\u0010:\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010;\u001a\u00020\u000bH\u0016J\b\u0010<\u001a\u00020\u000bH\u0016R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010BR\u0016\u0010Y\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010BR\u0016\u0010[\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010TR\u0016\u0010]\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010TR\u0016\u0010_\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b^\u0010TR\u0016\u0010a\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010TR\u0016\u0010c\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bb\u0010TR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010TR\u0016\u0010k\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bj\u0010TR\u0016\u0010m\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bl\u0010TR\u0016\u0010o\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010TR\u0016\u0010q\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bp\u0010fR\u0016\u0010s\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\br\u0010fR\u0016\u0010v\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010x\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010uR\u0018\u0010|\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010\u0084\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001c\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008e\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010tR\u0018\u0010\u0090\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010t\u00a8\u0006\u0095\u0001"}, d2 = {"Lcom/tencent/mobileqq/fragment/QQStorageOverviewFragment;", "Lcom/tencent/mobileqq/fragment/PublicBaseFragment;", "Lcom/tencent/mobileqq/activity/en;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "Gh", "Ph", "Lcom/tencent/mobileqq/app/message/messageclean/be;", "storageSize", "", "timeout", "Oh", "", "size", "", "Fh", "Th", "", "clearBtnVisibility", "Qh", "", "progress", "Jh", "Landroid/util/Pair;", "pair", "proportion", "Landroid/text/SpannableStringBuilder;", "Dh", "bold", "Eh", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "startTime", "Rh", "scanStatus", "Kh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Uh", "Mh", "Nh", "Lh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackPressed", "onBackEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "v", NodeProps.ON_CLICK, "needImmersive", "needStatusTrans", "Lcom/tencent/mobileqq/widget/BounceScrollView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/BounceScrollView;", "scrollView", "D", "Landroid/view/View;", "layoutCurrentProgress", "E", "vContainer", "Lcom/tencent/mobileqq/widget/LoadingCircleProgress;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/LoadingCircleProgress;", "progressBarScan", "G", "progressBarScanShader", "Lcom/tencent/mobileqq/widget/StorageCircleProgress;", "H", "Lcom/tencent/mobileqq/widget/StorageCircleProgress;", "storageInfoBar", "I", "storageShaderBar", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "tvCurrentProgress", "K", "layoutStorageOverview", "L", "flBack", "M", "qqStoragePercent", "N", "qqStorageSize", "P", "qqStorageManage", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "tvClearCache", BdhLogUtil.LogTag.Tag_Req, "tvClearLoading", "Landroid/widget/ImageView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/ImageView;", "ivClearLoading", "T", "tvChatSize", "U", "tvCacheSize", "V", "tvOtherSize", "W", "tvLoading", "X", "ivOtherAppTips", "Y", "ivRestSizeTips", "Z", "Ljava/lang/String;", "scanProgressText", "a0", "qqStoragePercentText", "Lcom/tencent/mobileqq/app/QQAppInterface;", "b0", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/widget/ActionSheet;", "c0", "Lcom/tencent/widget/ActionSheet;", "clearCacheSheet", "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager;", "d0", "Lcom/tencent/mobileqq/app/message/messageclean/NTScanSpaceManager;", "scanSpaceManager", "Lcom/tencent/mobileqq/app/message/messageclean/ad;", "e0", "Lcom/tencent/mobileqq/app/message/messageclean/ad;", "scanSpaceListener", "Lcom/tencent/mobileqq/fragment/overview/b;", "f0", "Lcom/tencent/mobileqq/fragment/overview/b;", "loadingTextAnimator", "g0", "isDestroy", "h0", "isFirstInit", "<init>", "()V", "i0", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQStorageOverviewFragment extends PublicBaseFragment implements en, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private BounceScrollView scrollView;

    /* renamed from: D, reason: from kotlin metadata */
    private View layoutCurrentProgress;

    /* renamed from: E, reason: from kotlin metadata */
    private View vContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private LoadingCircleProgress progressBarScan;

    /* renamed from: G, reason: from kotlin metadata */
    private LoadingCircleProgress progressBarScanShader;

    /* renamed from: H, reason: from kotlin metadata */
    private StorageCircleProgress storageInfoBar;

    /* renamed from: I, reason: from kotlin metadata */
    private StorageCircleProgress storageShaderBar;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView tvCurrentProgress;

    /* renamed from: K, reason: from kotlin metadata */
    private View layoutStorageOverview;

    /* renamed from: L, reason: from kotlin metadata */
    private View flBack;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView qqStoragePercent;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView qqStorageSize;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView qqStorageManage;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView tvClearCache;

    /* renamed from: R, reason: from kotlin metadata */
    private TextView tvClearLoading;

    /* renamed from: S, reason: from kotlin metadata */
    private ImageView ivClearLoading;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView tvChatSize;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView tvCacheSize;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView tvOtherSize;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView tvLoading;

    /* renamed from: X, reason: from kotlin metadata */
    private ImageView ivOtherAppTips;

    /* renamed from: Y, reason: from kotlin metadata */
    private ImageView ivRestSizeTips;

    /* renamed from: Z, reason: from kotlin metadata */
    private String scanProgressText;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String qqStoragePercentText;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQAppInterface app;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ActionSheet clearCacheSheet;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private NTScanSpaceManager scanSpaceManager;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.app.message.messageclean.ad scanSpaceListener;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.fragment.overview.b loadingTextAnimator;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstInit;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/fragment/QQStorageOverviewFragment$a;", "", "", "INVALID_TIMEOUT_SIZE", "Ljava/lang/String;", "", "REQUEST_MESSAGE_IMPORT", "I", "REQUEST_STORAGE_MANAGER", "SCAN_STATUS_COMPLETE", "SCAN_STATUS_NOT_COMPLETE", "SCAN_STATUS_NOT_NEED_CALCULATE", "SCAN_STATUS_TIMEOUT", "TAG", "USE_NEW_STORAGE_STYLE", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.fragment.QQStorageOverviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/fragment/QQStorageOverviewFragment$b", "Lcom/tencent/mobileqq/app/message/messageclean/ad;", "", "B0", "", "progress", "O1", "Lcom/tencent/mobileqq/app/message/messageclean/be;", "storageSize", "", "timeout", "U0", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.mobileqq.app.message.messageclean.ad {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStorageOverviewFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ad
        public void B0() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QLog.d("QQStorageOverviewFragment", 1, "onScanStart() isDestroy:" + QQStorageOverviewFragment.this.isDestroy);
                if (!QQStorageOverviewFragment.this.isDestroy) {
                    QQStorageOverviewFragment.this.Jh(0.0f);
                    BounceScrollView bounceScrollView = QQStorageOverviewFragment.this.scrollView;
                    if (bounceScrollView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                        bounceScrollView = null;
                    }
                    bounceScrollView.setOverScrollMode(2);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ad
        public void O1(float progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Float.valueOf(progress));
            } else if (!QQStorageOverviewFragment.this.isDestroy) {
                QQStorageOverviewFragment.this.Jh(progress);
            }
        }

        @Override // com.tencent.mobileqq.app.message.messageclean.ad
        public void U0(@NotNull be storageSize, boolean timeout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, storageSize, Boolean.valueOf(timeout));
                return;
            }
            Intrinsics.checkNotNullParameter(storageSize, "storageSize");
            com.tencent.mobileqq.fragment.overview.b bVar = QQStorageOverviewFragment.this.loadingTextAnimator;
            if (bVar != null) {
                bVar.d();
            }
            QLog.d("QQStorageOverviewFragment", 1, "onScanFinish(), storageSize:" + storageSize + ", isDestroy:" + QQStorageOverviewFragment.this.isDestroy + ", timeout:" + timeout);
            if (!QQStorageOverviewFragment.this.isDestroy) {
                QQStorageOverviewFragment.this.Oh(storageSize, timeout);
                BounceScrollView bounceScrollView = QQStorageOverviewFragment.this.scrollView;
                if (bounceScrollView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scrollView");
                    bounceScrollView = null;
                }
                bounceScrollView.setOverScrollMode(0);
                if (timeout) {
                    i3 = 4;
                }
                QQStorageOverviewFragment.this.Kh(i3);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58256);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQStorageOverviewFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isFirstInit = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(final QQStorageOverviewFragment this$0, final long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IStorageFileHelperApi) QRoute.api(IStorageFileHelperApi.class)).clearCache();
        com.tencent.mobileqq.app.message.messageclean.q.a(this$0.app, this$0, new Runnable() { // from class: com.tencent.mobileqq.fragment.ac
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOverviewFragment.Ch(QQStorageOverviewFragment.this, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(QQStorageOverviewFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rh(j3);
    }

    private final SpannableStringBuilder Dh(Pair<String, String> pair, float proportion) {
        return Eh(pair, proportion, false);
    }

    private final SpannableStringBuilder Eh(Pair<String, String> pair, float proportion, boolean bold) {
        Object obj = pair.first;
        Object obj2 = pair.second;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(obj);
        sb5.append(obj2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb5.toString());
        spannableStringBuilder.setSpan(new RelativeSizeSpan(proportion), 0, ((String) pair.first).length(), 18);
        if (bold) {
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, ((String) pair.first).length(), 18);
        }
        return spannableStringBuilder;
    }

    private final String Fh(long size, boolean timeout) {
        String result;
        if (timeout) {
            result = "-1";
        } else {
            result = com.tencent.mobileqq.app.message.messageclean.q.e(size);
        }
        QLog.d("QQStorageOverviewFragment", 1, "getReportSize size: " + size + ", timeout: " + timeout + ", result: " + result);
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return result;
    }

    private final void Gh(View view) {
        View findViewById = view.findViewById(R.id.k9d);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tv_loading)");
        this.tvLoading = (TextView) findViewById;
        String string = getResources().getString(R.string.zgy);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026_current_space_tips2_max)");
        TextView textView = this.tvLoading;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvLoading");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        TextView textView3 = this.tvLoading;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvLoading");
            textView3 = null;
        }
        layoutParams.width = (int) textView3.getPaint().measureText(string);
        TextView textView4 = this.tvLoading;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvLoading");
        } else {
            textView2 = textView4;
        }
        textView2.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(QQStorageOverviewFragment this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.clearCache();
            ReportController.y(this$0.app, "0X800C1B7");
            ActionSheet actionSheet = this$0.clearCacheSheet;
            Intrinsics.checkNotNull(actionSheet);
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(QQStorageOverviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Lh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(float progress) {
        LoadingCircleProgress loadingCircleProgress = this.progressBarScan;
        String str = null;
        if (loadingCircleProgress == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBarScan");
            loadingCircleProgress = null;
        }
        loadingCircleProgress.setLoadingProgress(progress);
        LoadingCircleProgress loadingCircleProgress2 = this.progressBarScanShader;
        if (loadingCircleProgress2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBarScanShader");
            loadingCircleProgress2 = null;
        }
        loadingCircleProgress2.setLoadingProgress(progress);
        TextView textView = this.tvCurrentProgress;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvCurrentProgress");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = this.scanProgressText;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanProgressText");
        } else {
            str = str2;
        }
        String format = String.format(str, Arrays.copyOf(new Object[]{((int) progress) + "%"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh(int scanStatus) {
        QQAppInterface qQAppInterface = this.app;
        String valueOf = String.valueOf(scanStatus);
        NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
        if (nTScanSpaceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            nTScanSpaceManager = null;
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800C1AD", "0X800C1AD", 0, 0, valueOf, "", String.valueOf(nTScanSpaceManager.W()), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(be storageSize, boolean timeout) {
        Jh(100.0f);
        View view = this.layoutCurrentProgress;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutCurrentProgress");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.layoutStorageOverview;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutStorageOverview");
        } else {
            view2 = view3;
        }
        view2.setVisibility(0);
        Th(storageSize);
        ReportController.o(this.app, "dc00898", "", "", "0X800C1AE", "0X800C1AE", 0, 0, Fh(storageSize.l(), timeout), Fh(storageSize.b(), timeout), Fh(storageSize.a(), timeout), Fh(storageSize.j(), timeout));
        ReportController.o(this.app, "dc00898", "", "", "0X800C1AF", "0X800C1AF", 0, 0, "", "", String.valueOf((((float) storageSize.l()) * 100.0f) / ((float) storageSize.f())), "");
    }

    private final void Ph() {
        if (this.loadingTextAnimator == null) {
            this.loadingTextAnimator = new com.tencent.mobileqq.fragment.overview.b();
        }
        if (this.scanSpaceListener == null) {
            this.scanSpaceListener = new b();
        }
        NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
        NTScanSpaceManager nTScanSpaceManager2 = null;
        if (nTScanSpaceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            nTScanSpaceManager = null;
        }
        nTScanSpaceManager.q0(this.scanSpaceListener);
        NTScanSpaceManager nTScanSpaceManager3 = this.scanSpaceManager;
        if (nTScanSpaceManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
        } else {
            nTScanSpaceManager2 = nTScanSpaceManager3;
        }
        nTScanSpaceManager2.y0(false);
        String string = getResources().getString(R.string.zgx);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026late_current_space_tips2)");
        com.tencent.mobileqq.fragment.overview.b bVar = this.loadingTextAnimator;
        if (bVar != null) {
            bVar.b(string, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.fragment.QQStorageOverviewFragment$startScan$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQStorageOverviewFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String text) {
                    TextView textView;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) text);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(text, "text");
                    textView = QQStorageOverviewFragment.this.tvLoading;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvLoading");
                        textView = null;
                    }
                    textView.setText(text);
                }
            });
        }
    }

    private final void Qh(int clearBtnVisibility) {
        int i3;
        if (clearBtnVisibility == 0) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        if (i3 == 0) {
            ReportController.y(this.app, "0X800C1B9");
        } else {
            ReportController.y(this.app, "0X800C1BA");
        }
        ImageView imageView = this.ivClearLoading;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClearLoading");
            imageView = null;
        }
        imageView.setVisibility(i3);
        TextView textView2 = this.tvClearLoading;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvClearLoading");
            textView2 = null;
        }
        textView2.setVisibility(i3);
        TextView textView3 = this.tvClearCache;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvClearCache");
        } else {
            textView = textView3;
        }
        textView.setVisibility(clearBtnVisibility);
    }

    private final void Rh(final long startTime) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.fragment.ad
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOverviewFragment.Sh(QQStorageOverviewFragment.this, startTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(QQStorageOverviewFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isDestroy) {
            QLog.d("QQStorageOverviewFragment", 1, "updateDelCacheSuccessUi but activity is destroyed");
            return;
        }
        NTScanSpaceManager nTScanSpaceManager = this$0.scanSpaceManager;
        NTScanSpaceManager nTScanSpaceManager2 = null;
        if (nTScanSpaceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            nTScanSpaceManager = null;
        }
        nTScanSpaceManager.V().p();
        NTScanSpaceManager nTScanSpaceManager3 = this$0.scanSpaceManager;
        if (nTScanSpaceManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
        } else {
            nTScanSpaceManager2 = nTScanSpaceManager3;
        }
        be V = nTScanSpaceManager2.V();
        Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
        this$0.Th(V);
        this$0.Qh(0);
        ReportController.o(this$0.app, "dc00898", "", "", "0X800C1B8", "0X800C1B8", 0, 0, String.valueOf(System.currentTimeMillis() - j3), "", "", "");
    }

    private final void Th(be storageSize) {
        float l3 = (((float) storageSize.l()) * 100.0f) / ((float) storageSize.f());
        float i3 = (((float) storageSize.i()) * 100.0f) / ((float) storageSize.f());
        StorageCircleProgress storageCircleProgress = this.storageInfoBar;
        TextView textView = null;
        if (storageCircleProgress == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageInfoBar");
            storageCircleProgress = null;
        }
        storageCircleProgress.b(0, i3, getResources().getColor(R.color.cso));
        StorageCircleProgress storageCircleProgress2 = this.storageShaderBar;
        if (storageCircleProgress2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageShaderBar");
            storageCircleProgress2 = null;
        }
        storageCircleProgress2.b(0, i3, getResources().getColor(R.color.csp));
        StorageCircleProgress storageCircleProgress3 = this.storageInfoBar;
        if (storageCircleProgress3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageInfoBar");
            storageCircleProgress3 = null;
        }
        storageCircleProgress3.b(1, l3, getResources().getColor(R.color.csm));
        StorageCircleProgress storageCircleProgress4 = this.storageShaderBar;
        if (storageCircleProgress4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageShaderBar");
            storageCircleProgress4 = null;
        }
        storageCircleProgress4.b(1, l3, getResources().getColor(R.color.csn));
        Pair<String, String> qqTotalSizePair = com.tencent.mobileqq.app.message.messageclean.q.d(storageSize.l());
        TextView textView2 = this.qqStorageSize;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqStorageSize");
            textView2 = null;
        }
        Intrinsics.checkNotNullExpressionValue(qqTotalSizePair, "qqTotalSizePair");
        textView2.setText(Eh(qqTotalSizePair, 1.5f, true));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(l3)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        TextView textView3 = this.qqStoragePercent;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqStoragePercent");
            textView3 = null;
        }
        String str = this.qqStoragePercentText;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqStoragePercentText");
            str = null;
        }
        String format2 = String.format(str, Arrays.copyOf(new Object[]{format}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        textView3.setText(format2);
        Pair<String, String> chatRecordSizePair = com.tencent.mobileqq.app.message.messageclean.q.d(storageSize.b());
        TextView textView4 = this.tvChatSize;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvChatSize");
            textView4 = null;
        }
        Intrinsics.checkNotNullExpressionValue(chatRecordSizePair, "chatRecordSizePair");
        textView4.setText(Dh(chatRecordSizePair, 2.0f));
        Pair<String, String> cacheSizePair = com.tencent.mobileqq.app.message.messageclean.q.d(storageSize.a());
        TextView textView5 = this.tvCacheSize;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvCacheSize");
            textView5 = null;
        }
        Intrinsics.checkNotNullExpressionValue(cacheSizePair, "cacheSizePair");
        textView5.setText(Dh(cacheSizePair, 2.0f));
        String c16 = com.tencent.mobileqq.app.message.messageclean.q.c(storageSize.j());
        TextView textView6 = this.tvOtherSize;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvOtherSize");
        } else {
            textView = textView6;
        }
        String string = getString(R.string.f228156sz);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.space_other_data_size)");
        String format3 = String.format(string, Arrays.copyOf(new Object[]{c16}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
        textView.setText(format3);
    }

    private final void clearCache() {
        Qh(8);
        final long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.app.message.messageclean.q.b(this.app, this);
        String str = null;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.ab
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOverviewFragment.Bh(QQStorageOverviewFragment.this, currentTimeMillis);
            }
        }, 64, null, false);
        LastCleanMMKVHelper lastCleanMMKVHelper = LastCleanMMKVHelper.f183341a;
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            str = qQAppInterface.getCurrentAccountUin();
        }
        lastCleanMMKVHelper.f(str);
    }

    public final void Lh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int screenHeight = ViewUtils.getScreenHeight();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            screenHeight -= ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        View view = this.layoutCurrentProgress;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutCurrentProgress");
            view = null;
        }
        view.getLayoutParams().height = screenHeight;
        if (this.isFirstInit) {
            View view3 = this.layoutCurrentProgress;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutCurrentProgress");
            } else {
                view2 = view3;
            }
            view2.setVisibility(0);
            this.isFirstInit = false;
        }
    }

    public final void Mh() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QQTheme.isNowThemeIsNight()) {
            i3 = R.drawable.ky8;
        } else {
            i3 = R.drawable.ky7;
        }
        TextView textView = this.qqStorageManage;
        Drawable drawable = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqStorageManage");
            textView = null;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            drawable = activity.getDrawable(i3);
        }
        textView.setBackgroundDrawable(drawable);
    }

    public final void Nh() {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        boolean z16 = !QQTheme.isNowThemeIsNight();
        FragmentActivity activity = getActivity();
        BounceScrollView bounceScrollView = null;
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        ImmersiveUtils.setStatusTextColor(z16, window);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            BounceScrollView bounceScrollView2 = this.scrollView;
            if (bounceScrollView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scrollView");
            } else {
                bounceScrollView = bounceScrollView2;
            }
            bounceScrollView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
        }
    }

    public final void Uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!FontSettingManager.isFontSizeLarge()) {
            return;
        }
        int i3 = (int) ((FontSettingManager.systemMetrics.density * 45) + 0.5f);
        ImageView imageView = this.ivOtherAppTips;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivOtherAppTips");
            imageView = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
        ImageView imageView3 = this.ivRestSizeTips;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivRestSizeTips");
        } else {
            imageView2 = imageView3;
        }
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = i3;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001) {
            NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
            if (nTScanSpaceManager == null) {
                QLog.d("QQStorageOverviewFragment", 1, "onActivityResult() scanSpaceManager not isInitialized");
                return;
            }
            NTScanSpaceManager nTScanSpaceManager2 = null;
            if (nTScanSpaceManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
                nTScanSpaceManager = null;
            }
            boolean h16 = nTScanSpaceManager.V().h();
            NTScanSpaceManager nTScanSpaceManager3 = this.scanSpaceManager;
            if (nTScanSpaceManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
                nTScanSpaceManager3 = null;
            }
            QLog.d("QQStorageOverviewFragment", 1, "onActivityResult() needUpdateUi:" + h16 + ", storageSize:" + nTScanSpaceManager3.V());
            NTScanSpaceManager nTScanSpaceManager4 = this.scanSpaceManager;
            if (nTScanSpaceManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
                nTScanSpaceManager4 = null;
            }
            if (nTScanSpaceManager4.V().h()) {
                NTScanSpaceManager nTScanSpaceManager5 = this.scanSpaceManager;
                if (nTScanSpaceManager5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
                    nTScanSpaceManager5 = null;
                }
                be V = nTScanSpaceManager5.V();
                Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
                Th(V);
                NTScanSpaceManager nTScanSpaceManager6 = this.scanSpaceManager;
                if (nTScanSpaceManager6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
                } else {
                    nTScanSpaceManager2 = nTScanSpaceManager6;
                }
                nTScanSpaceManager2.V().x(false);
            }
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
        if (nTScanSpaceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            nTScanSpaceManager = null;
        }
        if (nTScanSpaceManager.b0()) {
            Kh(1);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.activity.en
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        NTScanSpaceManager nTScanSpaceManager = this.scanSpaceManager;
        if (nTScanSpaceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            nTScanSpaceManager = null;
        }
        if (nTScanSpaceManager.b0()) {
            Kh(1);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.f109196f6) {
                PublicFragmentActivity.startForResult(getActivity(), null, QQStorageManageFragment.class, 1001);
                ReportController.y(this.app, "0X800C1B0");
            } else if (num != null && num.intValue() == R.id.v7g) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else if (num != null && num.intValue() == R.id.f1067469j) {
                if (this.clearCacheSheet == null) {
                    this.clearCacheSheet = (ActionSheet) ActionSheetHelper.createDialog(getActivity(), null);
                }
                ActionSheet actionSheet = this.clearCacheSheet;
                if (actionSheet == null) {
                    QLog.d("QQStorageOverviewFragment", 1, "click clear cache, action sheet is null");
                    clearCache();
                } else {
                    Intrinsics.checkNotNull(actionSheet);
                    actionSheet.setMainTitle(R.string.f228686ue);
                    ActionSheet actionSheet2 = this.clearCacheSheet;
                    Intrinsics.checkNotNull(actionSheet2);
                    actionSheet2.addButton(R.string.f228676ud, 3, 0);
                    ActionSheet actionSheet3 = this.clearCacheSheet;
                    Intrinsics.checkNotNull(actionSheet3);
                    actionSheet3.addCancelButton(R.string.cancel);
                    ActionSheet actionSheet4 = this.clearCacheSheet;
                    Intrinsics.checkNotNull(actionSheet4);
                    actionSheet4.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.fragment.z
                        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                        public final void onClick(View view, int i3) {
                            QQStorageOverviewFragment.Hh(QQStorageOverviewFragment.this, view, i3);
                        }
                    });
                    ActionSheet actionSheet5 = this.clearCacheSheet;
                    Intrinsics.checkNotNull(actionSheet5);
                    actionSheet5.show();
                    ReportController.y(this.app, "0X800C1B6");
                }
                ReportController.y(this.app, "0X800C1B5");
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.h59, container, false);
            AppInterface appInterface = getBaseActivity().getAppInterface();
            Intrinsics.checkNotNull(appInterface, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            this.app = (QQAppInterface) appInterface;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        this.isDestroy = true;
        com.tencent.mobileqq.fragment.overview.b bVar = this.loadingTextAnimator;
        if (bVar != null) {
            bVar.d();
        }
        com.tencent.mobileqq.app.message.messageclean.ad adVar = this.scanSpaceListener;
        NTScanSpaceManager nTScanSpaceManager = null;
        if (adVar != null) {
            NTScanSpaceManager nTScanSpaceManager2 = this.scanSpaceManager;
            if (nTScanSpaceManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
                nTScanSpaceManager2 = null;
            }
            nTScanSpaceManager2.A0(adVar);
        }
        NTScanSpaceManager nTScanSpaceManager3 = this.scanSpaceManager;
        if (nTScanSpaceManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
        } else {
            nTScanSpaceManager = nTScanSpaceManager3;
        }
        nTScanSpaceManager.J();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.iig);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.scroll_view)");
        this.scrollView = (BounceScrollView) findViewById;
        View findViewById2 = view.findViewById(R.id.ydw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.layout_current_progress)");
        this.layoutCurrentProgress = findViewById2;
        View findViewById3 = view.findViewById(R.id.f116106xu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.v_container)");
        this.vContainer = findViewById3;
        View findViewById4 = view.findViewById(R.id.f28510j5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.progress_bar_scan)");
        this.progressBarScan = (LoadingCircleProgress) findViewById4;
        View findViewById5 = view.findViewById(R.id.f28520j6);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.progress_bar_scan_shader)");
        this.progressBarScanShader = (LoadingCircleProgress) findViewById5;
        View findViewById6 = view.findViewById(R.id.f107186_q);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.tv_current_progress)");
        this.tvCurrentProgress = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.yfm);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.layout_storage_overview)");
        this.layoutStorageOverview = findViewById7;
        View findViewById8 = view.findViewById(R.id.uac);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.cp_storage_info)");
        this.storageInfoBar = (StorageCircleProgress) findViewById8;
        View findViewById9 = view.findViewById(R.id.uad);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.cp_storage_shader)");
        this.storageShaderBar = (StorageCircleProgress) findViewById9;
        View findViewById10 = view.findViewById(R.id.f110276i3);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.tv_qq_storage_size)");
        this.qqStorageSize = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.f110266i2);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.tv_qq_storage_percent)");
        this.qqStoragePercent = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.f109196f6);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.tv_manage_qq_storage)");
        TextView textView = (TextView) findViewById12;
        this.qqStorageManage = textView;
        BounceScrollView bounceScrollView = null;
        NTScanSpaceManager nTScanSpaceManager = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqStorageManage");
            textView = null;
        }
        textView.setOnClickListener(this);
        View findViewById13 = view.findViewById(R.id.f1067469j);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "view.findViewById(R.id.tv_clear_cache)");
        TextView textView2 = (TextView) findViewById13;
        this.tvClearCache = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvClearCache");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        View findViewById14 = view.findViewById(R.id.f1067569k);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "view.findViewById(R.id.tv_clear_loading)");
        this.tvClearLoading = (TextView) findViewById14;
        View findViewById15 = view.findViewById(R.id.y1h);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "view.findViewById(R.id.iv_clear_loading)");
        ImageView imageView = (ImageView) findViewById15;
        this.ivClearLoading = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClearLoading");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.f160545jt);
        View findViewById16 = view.findViewById(R.id.y88);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "view.findViewById(R.id.iv_rest_size_tip)");
        this.ivRestSizeTips = (ImageView) findViewById16;
        View findViewById17 = view.findViewById(R.id.y6p);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "view.findViewById(R.id.iv_other_app_tip)");
        this.ivOtherAppTips = (ImageView) findViewById17;
        View findViewById18 = view.findViewById(R.id.f1066969e);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "view.findViewById(R.id.tv_chat_size)");
        this.tvChatSize = (TextView) findViewById18;
        View findViewById19 = view.findViewById(R.id.f1064168n);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "view.findViewById(R.id.tv_cache_size)");
        this.tvCacheSize = (TextView) findViewById19;
        View findViewById20 = view.findViewById(R.id.f109836gw);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "view.findViewById(R.id.tv_other_size)");
        this.tvOtherSize = (TextView) findViewById20;
        View findViewById21 = view.findViewById(R.id.v7g);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "view.findViewById(R.id.fl_back)");
        this.flBack = findViewById21;
        if (findViewById21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flBack");
            findViewById21 = null;
        }
        findViewById21.setOnClickListener(this);
        Gh(view);
        String string = getResources().getString(R.string.f170653xj);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026te_current_progress_text)");
        this.scanProgressText = string;
        String string2 = getResources().getString(R.string.f228916v1);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.storage_qq_percent)");
        this.qqStoragePercentText = string2;
        Nh();
        Mh();
        Uh();
        NTScanSpaceManager S = NTScanSpaceManager.S();
        Intrinsics.checkNotNullExpressionValue(S, "getInstance()");
        this.scanSpaceManager = S;
        if (S == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            S = null;
        }
        if (S.X()) {
            NTScanSpaceManager nTScanSpaceManager2 = this.scanSpaceManager;
            if (nTScanSpaceManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
                nTScanSpaceManager2 = null;
            }
            be V = nTScanSpaceManager2.V();
            Intrinsics.checkNotNullExpressionValue(V, "scanSpaceManager.storageSize");
            NTScanSpaceManager nTScanSpaceManager3 = this.scanSpaceManager;
            if (nTScanSpaceManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
                nTScanSpaceManager3 = null;
            }
            Oh(V, nTScanSpaceManager3.f0());
            NTScanSpaceManager nTScanSpaceManager4 = this.scanSpaceManager;
            if (nTScanSpaceManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanSpaceManager");
            } else {
                nTScanSpaceManager = nTScanSpaceManager4;
            }
            if (nTScanSpaceManager.f0()) {
                i3 = 4;
            }
            Kh(i3);
            return;
        }
        BounceScrollView bounceScrollView2 = this.scrollView;
        if (bounceScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        } else {
            bounceScrollView = bounceScrollView2;
        }
        bounceScrollView.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.aa
            @Override // java.lang.Runnable
            public final void run() {
                QQStorageOverviewFragment.Ih(QQStorageOverviewFragment.this);
            }
        });
        Ph();
    }
}
