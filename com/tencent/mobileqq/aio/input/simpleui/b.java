package com.tencent.mobileqq.aio.input.simpleui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.AIOInputSendBtn;
import com.tencent.mobileqq.aio.input.simpleui.InputSimpleUIState;
import com.tencent.mobileqq.aio.input.simpleui.d;
import com.tencent.mobileqq.aio.input.simpleui.e;
import com.tencent.mobileqq.aio.utils.f;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.api.IAudioRecordTouchEventApi;
import com.tencent.qqnt.aio.utils.ae;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00dd\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\b\u0005*\u0001~\u0018\u0000 \u00112$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u00020\u0007:\u0001?B\u0010\u0012\u0006\u0010O\u001a\u00020\u0004\u00a2\u0006\u0005\b\u0081\u0001\u0010NJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\t\u001a\u00020 H\u0002J \u0010%\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rH\u0002J(\u0010)\u001a\u00020\n2\u0006\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0002J\b\u0010*\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\nH\u0002J\u0010\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020,H\u0002J\u0012\u00101\u001a\u00020\n2\b\b\u0002\u00100\u001a\u00020/H\u0002J\b\u00102\u001a\u00020\nH\u0002J\u0010\u00103\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020,H\u0002J\u0010\u00104\u001a\u00020\n2\u0006\u0010$\u001a\u00020\rH\u0002J$\u00109\u001a\u00020\n*\u00020,2\u0006\u00105\u001a\u00020&2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206H\u0002J\u0010\u0010;\u001a\u00020\n2\u0006\u0010:\u001a\u00020\u0005H\u0016J\u0010\u0010>\u001a\u00020\n2\u0006\u0010=\u001a\u00020<H\u0016J\b\u0010?\u001a\u00020\nH\u0016J\u0018\u0010B\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030A\u0018\u00010@H\u0016J\u0010\u0010C\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010D\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020,H\u0016J\u0012\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010F\u001a\u00020EH\u0016J\b\u0010I\u001a\u00020\nH\u0016R\"\u0010O\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010:\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010[R\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010[R\u0016\u0010^\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010[R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010lR\u0016\u0010p\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010oR\u0018\u0010r\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010qR\u0016\u0010t\u001a\u00020k8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bs\u0010lR\u0018\u0010v\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010qR\u0016\u0010x\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010wR\u0016\u0010z\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u00101R\u0016\u0010|\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010{R\u0016\u0010}\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010{R\u0015\u0010\u0080\u0001\u001a\u00020~8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u007f\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/mobileqq/aio/input/simpleui/b;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/aio/input/simpleui/InputSimpleUIState$UpdateSimpleUIState;", "state", "", ReportConstant.COSTREPORT_PREFIX, "r", "", "isShowSimpleUI", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "isSimpleMode", BdhLogUtil.LogTag.Tag_Req, "u", "B", "v", h.F, "forceShowFunBtn", "N", "y", "Lcom/tencent/mobileqq/aio/input/simpleui/InputSimpleUIState$UpdateIconState;", "O", BdhLogUtil.LogTag.Tag_Conn, "isFunSelect", "l", "P", "L", "Lcom/tencent/mobileqq/aio/input/simpleui/InputSimpleUIState$ModeCompatState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/input/simpleui/InputSimpleUIState$ModeCompatState$a;", "isFullScreenMode", "isGagMode", DomainData.DOMAIN_NAME, "", "inputVisibilityHint", "inputHeightHint", "w", "t", "H", "Landroid/view/View;", "button", "j", "", "delay", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "k", "o", "newVisibility", "", HippyHeaderListViewController.VIEW_TAG, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "binding", HippyTKDListViewAdapter.X, "Lcom/tencent/mvi/api/help/b;", "reuseParam", "d", "a", "", "Ljava/lang/Class;", "getObserverStates", "p", NodeProps.ON_CLICK, "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/aio/input/adorn/b;", "i", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "G", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "Luu3/a;", "f", "Luu3/a;", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "inputRoot", "Landroid/widget/ImageButton;", "Landroid/widget/ImageButton;", "pttBtn", "emoBtn", "funBtn", "Landroid/widget/Button;", "D", "Landroid/widget/Button;", "sendBtn", "Landroid/widget/EditText;", "E", "Landroid/widget/EditText;", "input", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "tvPressToRecord", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "funBtnLayout", "Landroidx/constraintlayout/widget/Barrier;", "Landroidx/constraintlayout/widget/Barrier;", "barrier", "Landroid/view/View;", "plusRedView", "J", "emoBtnLayout", "K", "emoRedView", "Ljava/lang/String;", "peerUid", "M", "chatType", "Z", "isSimpleUIAddedInLayout", "isInManualLayoutStack", "com/tencent/mobileqq/aio/input/simpleui/b$c", "Lcom/tencent/mobileqq/aio/input/simpleui/b$c;", "widgetCreator", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a>, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private ImageButton funBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private Button sendBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private EditText input;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView tvPressToRecord;

    /* renamed from: G, reason: from kotlin metadata */
    private FrameLayout funBtnLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private Barrier barrier;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View plusRedView;

    /* renamed from: J, reason: from kotlin metadata */
    private FrameLayout emoBtnLayout;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View emoRedView;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private String peerUid;

    /* renamed from: M, reason: from kotlin metadata */
    private int chatType;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isSimpleUIAddedInLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isInManualLayoutStack;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final c widgetCreator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private uu3.a binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup inputRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageButton pttBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageButton emoBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/input/simpleui/b$a;", "", "", "EMO_BTN_MARGIN_BOTTOM_DP", "I", "EMO_BTN_MARGIN_RIGHT_DP", "FUN_BTN_MARGIN_BOTTOM_DP", "FUN_BTN_MARGIN_RIGHT_DP", "PRESS_TO_RECORD_MARGIN_LEFT_DP", "PRESS_TO_RECORD_MARGIN_RIGHT_DP", "PRESS_TO_RECORD_MAX_LINE", "PRESS_TO_RECORD_MIN_HEIGHT_DP", "PRESS_TO_RECORD_PADDING_LEFT_DP", "PRESS_TO_RECORD_PADDING_TOP_DP", "", "PRESS_TO_RECORD_TEXT_SIZE_SP", UserInfo.SEX_FEMALE, "PTT_BTN_BOTTOM_MARGIN_DP", "PTT_BTN_LEFT_MARGIN_DP", "ROTATION_ANIM_DEGREE", "", "ROTATION_ANIM_DURATION", "J", "", "ROTATION_PROPERTY_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.simpleui.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/input/simpleui/b$b", "Lcom/tencent/mobileqq/aio/input/h;", "", "oldVisibility", "newVisibility", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.simpleui.b$b, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7285b implements com.tencent.mobileqq.aio.input.h {
        static IPatchRedirector $redirector_;

        C7285b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.input.h
        public void a(int oldVisibility, int newVisibility) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(oldVisibility), Integer.valueOf(newVisibility));
                return;
            }
            if (newVisibility == 8) {
                EditText editText = b.this.input;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("input");
                    editText = null;
                }
                Editable editableText = editText.getEditableText();
                if (editableText == null || editableText.length() == 0) {
                    z16 = true;
                }
                if (!z16) {
                    QLog.i("InputSimpleUIVB", 1, "[onVisibilityChange]: " + QLog.getStackTraceString(new Throwable("sendBtn is gone but editText is not empty")));
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0002R\u0011\u0010\u0019\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/aio/input/simpleui/b$c", "", "Landroid/content/Context;", "context", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageButton;", "e", "Landroid/view/ViewGroup$LayoutParams;", "j", "i", "a", h.F, "Landroid/widget/TextView;", "g", "c", "Landroid/widget/FrameLayout;", "d", "f", "Landroidx/constraintlayout/widget/Barrier;", "b", "", "k", "()I", "inputMinHeight", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        private final ConstraintLayout.LayoutParams a() {
            return new ConstraintLayout.LayoutParams(-2, -2);
        }

        private final ImageButton e(Context context) {
            ImageButton imageButton = new ImageButton(context);
            imageButton.setId(R.id.fun_btn);
            imageButton.setBackgroundResource(R.drawable.qui_add_circle_aio_oversized_icon_aio_toolbar_normal);
            imageButton.setVisibility(8);
            return imageButton;
        }

        private final ViewGroup.LayoutParams i(Context context) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.act);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
            layoutParams.rightMargin = bVar.b(12);
            layoutParams.bottomMargin = bVar.b(4);
            return layoutParams;
        }

        private final ViewGroup.LayoutParams j(Context context) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.act);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
            layoutParams.rightMargin = bVar.b(16);
            layoutParams.bottomMargin = bVar.b(4);
            return layoutParams;
        }

        private final ConstraintLayout.LayoutParams l(Context context) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
            int dimension = (int) context.getResources().getDimension(R.dimen.act);
            ((ViewGroup.MarginLayoutParams) layoutParams).width = dimension;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = dimension;
            layoutParams.bottomToBottom = 0;
            layoutParams.leftToLeft = 0;
            com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bVar.a(14.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bVar.a(4.0f);
            layoutParams.validate();
            return layoutParams;
        }

        private final ConstraintLayout.LayoutParams m() {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
            com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bVar.b(16);
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bVar.b(12);
            layoutParams.leftToRight = R.id.f28760jt;
            layoutParams.bottomToBottom = 0;
            layoutParams.rightToLeft = R.id.sha;
            layoutParams.validate();
            return layoutParams;
        }

        @NotNull
        public final Barrier b(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (Barrier) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Barrier barrier = new Barrier(context);
            barrier.setId(R.id.t4q);
            barrier.setType(5);
            barrier.setReferencedIds(new int[]{R.id.sht, R.id.send_btn});
            barrier.setLayoutParams(a());
            return barrier;
        }

        @NotNull
        public final ImageButton c(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ImageButton) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            ImageButton imageButton = new ImageButton(context);
            imageButton.setId(R.id.emo_btn);
            imageButton.setBackgroundResource(R.drawable.j6a);
            imageButton.setVisibility(8);
            return imageButton;
        }

        @NotNull
        public final FrameLayout d(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (FrameLayout) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.sha);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.bottomToBottom = 0;
            layoutParams.leftToRight = R.id.input;
            layoutParams.rightToLeft = R.id.t4q;
            layoutParams.validate();
            frameLayout.setLayoutParams(layoutParams);
            frameLayout.addView(c(context), i(context));
            return frameLayout;
        }

        @NotNull
        public final FrameLayout f(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (FrameLayout) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.sht);
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
            layoutParams.bottomToBottom = 0;
            layoutParams.rightToRight = 0;
            layoutParams.validate();
            frameLayout.setLayoutParams(layoutParams);
            frameLayout.addView(e(context), j(context));
            return frameLayout;
        }

        @NotNull
        public final TextView g(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (TextView) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = new TextView(context);
            textView.setId(R.id.f110076hj);
            textView.setBackgroundResource(R.drawable.j5r);
            textView.setFocusable(true);
            textView.setFocusableInTouchMode(true);
            textView.setGravity(17);
            textView.setIncludeFontPadding(true);
            textView.setMaxLines(1);
            com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
            textView.setMinHeight(bVar.b(36));
            textView.setPadding(bVar.b(11), bVar.b(6), bVar.b(11), bVar.b(6));
            textView.setText(R.string.z78);
            textView.setTextColor(context.getColorStateList(R.color.skin_input_theme_version2));
            textView.setTextSize(2, 17.0f);
            textView.setVisibility(8);
            textView.setLayoutParams(m());
            return textView;
        }

        @NotNull
        public final ImageButton h(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ImageButton) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            ImageButton imageButton = new ImageButton(context);
            imageButton.setId(R.id.f28760jt);
            imageButton.setBackgroundResource(R.drawable.j8g);
            imageButton.setVisibility(8);
            imageButton.setLayoutParams(l(context));
            return imageButton;
        }

        public final int k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Context context = b.this.context;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context = null;
                }
                return context.getResources().getDimensionPixelSize(R.dimen.cjj);
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56974);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.peerUid = "";
        this.widgetCreator = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        EditText editText = this.input;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("input");
            editText = null;
        }
        editText.requestFocus();
        Context context = this.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        EditText editText3 = this.input;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("input");
        } else {
            editText2 = editText3;
        }
        inputMethodManager.showSoftInput(editText2, 0);
    }

    private final void B() {
        this.isSimpleUIAddedInLayout = false;
        View[] viewArr = new View[4];
        TextView textView = this.tvPressToRecord;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPressToRecord");
            textView = null;
        }
        viewArr[0] = textView;
        FrameLayout frameLayout = this.emoBtnLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoBtnLayout");
            frameLayout = null;
        }
        viewArr[1] = frameLayout;
        ImageButton imageButton = this.pttBtn;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
            imageButton = null;
        }
        viewArr[2] = imageButton;
        FrameLayout frameLayout2 = this.funBtnLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtnLayout");
            frameLayout2 = null;
        }
        viewArr[3] = frameLayout2;
        for (int i3 = 0; i3 < 4; i3++) {
            View view = viewArr[i3];
            uu3.a aVar = this.binding;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar = null;
            }
            aVar.getRoot().removeView(view);
        }
    }

    private final void C() {
        ImageButton imageButton = this.pttBtn;
        ImageButton imageButton2 = null;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
            imageButton = null;
        }
        imageButton.setSelected(false);
        ImageButton imageButton3 = this.emoBtn;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
            imageButton3 = null;
        }
        imageButton3.setSelected(false);
        ImageButton imageButton4 = this.funBtn;
        if (imageButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
            imageButton4 = null;
        }
        imageButton4.setSelected(false);
        ImageButton imageButton5 = this.funBtn;
        if (imageButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
        } else {
            imageButton2 = imageButton5;
        }
        imageButton2.setRotation(0.0f);
    }

    private final void H() {
        N(true);
        TextView textView = this.tvPressToRecord;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPressToRecord");
            textView = null;
        }
        textView.setVisibility(0);
        j(textView);
        O(new InputSimpleUIState.UpdateIconState(true, false, false, true));
    }

    private final void I(long delay) {
        ViewGroup viewGroup = this.inputRoot;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputRoot");
            viewGroup = null;
        }
        if (viewGroup.getVisibility() == 0) {
            EditText editText = this.input;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("input");
                editText = null;
            }
            if (editText.getVisibility() == 0) {
                if (delay > 0) {
                    ViewGroup viewGroup3 = this.inputRoot;
                    if (viewGroup3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("inputRoot");
                    } else {
                        viewGroup2 = viewGroup3;
                    }
                    viewGroup2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.input.simpleui.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.A();
                        }
                    }, delay);
                    return;
                }
                A();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("InputSimpleUIVB", 2, "realShowSoftInput input is invisible");
        }
    }

    static /* synthetic */ void K(b bVar, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        bVar.I(j3);
    }

    private final void L() {
        boolean z16;
        if (!f.f194152a.a(this.chatType)) {
            return;
        }
        EditText editText = this.input;
        ImageButton imageButton = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("input");
            editText = null;
        }
        Editable editableText = editText.getEditableText();
        if (editableText != null && editableText.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        if (this.emoRedView == null) {
            ae aeVar = ae.f352281b;
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            ImageButton imageButton2 = this.emoBtn;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
                imageButton2 = null;
            }
            this.emoRedView = aeVar.i(context, imageButton2);
        }
        if (QLog.isColorLevel()) {
            QLog.i("InputSimpleUIVB", 1, "fetch simple emo icon red dot");
        }
        View view = this.emoRedView;
        if (view != null) {
            ImageButton imageButton3 = this.emoBtn;
            if (imageButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
                imageButton3 = null;
            }
            view.setTag(imageButton3.getTag());
            ImageButton imageButton4 = this.emoBtn;
            if (imageButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
            } else {
                imageButton = imageButton4;
            }
            view.setSelected(imageButton.isSelected());
            ae.f352281b.e(this.peerUid, this.chatType, view);
        }
    }

    private final void N(boolean forceShowFunBtn) {
        int i3;
        int i16;
        int i17;
        boolean z16;
        boolean z17 = true;
        Button button = null;
        int i18 = 0;
        if (!forceShowFunBtn) {
            EditText editText = this.input;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("input");
                editText = null;
            }
            Editable editableText = editText.getEditableText();
            if (editableText != null && editableText.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                z17 = false;
            }
        }
        Button button2 = this.sendBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            button2 = null;
        }
        if (z17) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        z(button2, i3, "sendBtn", "updateFunBtn");
        ImageButton imageButton = this.funBtn;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
            imageButton = null;
        }
        if (z17) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageButton.setVisibility(i16);
        FrameLayout frameLayout = this.funBtnLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtnLayout");
            frameLayout = null;
        }
        if (z17) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        frameLayout.setVisibility(i17);
        Button button3 = this.sendBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
        } else {
            button = button3;
        }
        if (z17) {
            i18 = 8;
        }
        button.setVisibility(i18);
        y();
    }

    private final void O(InputSimpleUIState.UpdateIconState state) {
        ImageButton imageButton = null;
        if (state.a()) {
            ImageButton imageButton2 = this.pttBtn;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
                imageButton2 = null;
            }
            imageButton2.setSelected(state.d());
        }
        ImageButton imageButton3 = this.emoBtn;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
        } else {
            imageButton = imageButton3;
        }
        imageButton.setSelected(state.b());
        l(state.c());
    }

    private final void P() {
        boolean z16;
        if (!f.f194152a.a(this.chatType)) {
            return;
        }
        EditText editText = this.input;
        ImageButton imageButton = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("input");
            editText = null;
        }
        Editable editableText = editText.getEditableText();
        if (editableText != null && editableText.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        if (this.plusRedView == null) {
            ae aeVar = ae.f352281b;
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            ImageButton imageButton2 = this.funBtn;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funBtn");
                imageButton2 = null;
            }
            this.plusRedView = aeVar.i(context, imageButton2);
        }
        if (QLog.isColorLevel()) {
            QLog.i("InputSimpleUIVB", 1, "fetch simple plus icon red dot");
        }
        View view = this.plusRedView;
        if (view != null) {
            ImageButton imageButton3 = this.funBtn;
            if (imageButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funBtn");
                imageButton3 = null;
            }
            view.setTag(imageButton3.getTag());
            ImageButton imageButton4 = this.funBtn;
            if (imageButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funBtn");
            } else {
                imageButton = imageButton4;
            }
            view.setSelected(imageButton.isSelected());
            ae.f352281b.g(this.peerUid, this.chatType, view);
        }
    }

    private final void Q(boolean isShowSimpleUI) {
        if (isShowSimpleUI) {
            u();
            R(true);
            h(true);
        } else if (this.isSimpleUIAddedInLayout) {
            R(false);
            B();
            h(false);
        }
    }

    private final void R(boolean isSimpleMode) {
        boolean z16;
        int i3;
        View view = null;
        if (isSimpleMode) {
            EditText editText = this.input;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("input");
                editText = null;
            }
            Editable editableText = editText.getEditableText();
            if (editableText != null && editableText.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            Button button = this.sendBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                button = null;
            }
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            z(button, i3, "sendBtn", "updateSimpleUI");
            ImageButton imageButton = this.pttBtn;
            if (imageButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
                imageButton = null;
            }
            imageButton.setVisibility(0);
            ImageButton imageButton2 = this.emoBtn;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
                imageButton2 = null;
            }
            imageButton2.setVisibility(0);
            if (z16) {
                ImageButton imageButton3 = this.funBtn;
                if (imageButton3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("funBtn");
                    imageButton3 = null;
                }
                imageButton3.setVisibility(0);
                FrameLayout frameLayout = this.funBtnLayout;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("funBtnLayout");
                    frameLayout = null;
                }
                frameLayout.setVisibility(0);
                Button button2 = this.sendBtn;
                if (button2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                    button2 = null;
                }
                button2.setVisibility(8);
            } else {
                ImageButton imageButton4 = this.funBtn;
                if (imageButton4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("funBtn");
                    imageButton4 = null;
                }
                imageButton4.setVisibility(8);
                FrameLayout frameLayout2 = this.funBtnLayout;
                if (frameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("funBtnLayout");
                    frameLayout2 = null;
                }
                frameLayout2.setVisibility(8);
                Button button3 = this.sendBtn;
                if (button3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                    button3 = null;
                }
                button3.setVisibility(0);
            }
            FrameLayout frameLayout3 = this.emoBtnLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoBtnLayout");
            } else {
                view = frameLayout3;
            }
            view.setVisibility(0);
            return;
        }
        Button button4 = this.sendBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            button4 = null;
        }
        z(button4, 0, "sendBtn", "updateSimpleUI");
        ImageButton imageButton5 = this.pttBtn;
        if (imageButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
            imageButton5 = null;
        }
        imageButton5.setVisibility(8);
        FrameLayout frameLayout4 = this.funBtnLayout;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtnLayout");
            frameLayout4 = null;
        }
        frameLayout4.setVisibility(8);
        FrameLayout frameLayout5 = this.emoBtnLayout;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoBtnLayout");
            frameLayout5 = null;
        }
        frameLayout5.setVisibility(8);
        Button button5 = this.sendBtn;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
        } else {
            view = button5;
        }
        view.setVisibility(0);
    }

    private final void h(boolean isSimpleMode) {
        uu3.a aVar = this.binding;
        uu3.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        ViewGroup.LayoutParams layoutParams = aVar.f440053b.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        if (isSimpleMode) {
            layoutParams2.leftToRight = R.id.f28760jt;
            layoutParams2.rightToLeft = R.id.sha;
            layoutParams2.leftToLeft = -1;
        } else {
            layoutParams2.leftToRight = -1;
            layoutParams2.rightToLeft = R.id.send_btn;
            layoutParams2.leftToLeft = 0;
        }
        uu3.a aVar3 = this.binding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.f440053b.setLayoutParams(layoutParams2);
    }

    private final void j(View button) {
        d.a aVar = new d.a(null, 1, null);
        F(aVar);
        com.tencent.aio.api.runtime.a a16 = aVar.a();
        if (a16 == null) {
            QLog.e("InputSimpleUIVB", 1, "get empty aioContext, check invoke");
            return;
        }
        try {
            ((IAudioRecordTouchEventApi) QRoute.api(IAudioRecordTouchEventApi.class)).setTouchEvent(button, a16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("InputSimpleUIVB", 2, "audio button e: " + e16);
            }
        }
    }

    private final void k(View v3) {
        if (!v3.isSelected() && v3.getId() == R.id.fun_btn) {
            F(d.i.f189921d);
        } else {
            F(d.h.f189920d);
        }
    }

    private final void l(boolean isFunSelect) {
        float f16;
        ImageButton imageButton = this.funBtn;
        ImageButton imageButton2 = null;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
            imageButton = null;
        }
        if (imageButton.isSelected() == isFunSelect) {
            return;
        }
        ImageButton imageButton3 = this.funBtn;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
            imageButton3 = null;
        }
        imageButton3.setSelected(isFunSelect);
        if (isFunSelect) {
            f16 = 45.0f;
        } else {
            f16 = 0.0f;
        }
        ImageButton imageButton4 = this.funBtn;
        if (imageButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
            imageButton4 = null;
        }
        float[] fArr = new float[2];
        ImageButton imageButton5 = this.funBtn;
        if (imageButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
        } else {
            imageButton2 = imageButton5;
        }
        fArr[0] = imageButton2.getRotation();
        fArr[1] = f16;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageButton4, BasicAnimation.KeyPath.ROTATION, fArr);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(150L);
        ofFloat.start();
    }

    private final void m(InputSimpleUIState.ModeCompatState state) {
        QLog.i("InputSimpleUIVB", 1, "handleModeCompatState: " + state);
        R(state.b() ^ true);
        InputSimpleUIState.ModeCompatState.a a16 = state.a();
        if (a16 != null) {
            n(a16, state.b(), state.c());
        }
        o(state.c());
    }

    private final void n(InputSimpleUIState.ModeCompatState.a state, boolean isFullScreenMode, boolean isGagMode) {
        if (state.b()) {
            H();
            w(isGagMode, isFullScreenMode, 4, this.widgetCreator.k());
        } else {
            t();
            w(isGagMode, isFullScreenMode, 0, -2);
        }
        if (!state.b() && state.a()) {
            K(this, 0L, 1, null);
        }
        F(new d.f(state.b()));
    }

    private final void o(boolean isGagMode) {
        View[] viewArr = new View[4];
        ImageButton imageButton = this.emoBtn;
        ImageButton imageButton2 = null;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
            imageButton = null;
        }
        viewArr[0] = imageButton;
        ImageButton imageButton3 = this.funBtn;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
            imageButton3 = null;
        }
        viewArr[1] = imageButton3;
        TextView textView = this.tvPressToRecord;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPressToRecord");
            textView = null;
        }
        viewArr[2] = textView;
        ImageButton imageButton4 = this.pttBtn;
        if (imageButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
        } else {
            imageButton2 = imageButton4;
        }
        viewArr[3] = imageButton2;
        for (int i3 = 0; i3 < 4; i3++) {
            viewArr[i3].setEnabled(!isGagMode);
        }
    }

    private final void r(InputUIState state) {
        if (state instanceof InputSimpleUIState.UpdateFunBtnState) {
            N(((InputSimpleUIState.UpdateFunBtnState) state).a());
            return;
        }
        if (state instanceof InputSimpleUIState.UpdateIconState) {
            O((InputSimpleUIState.UpdateIconState) state);
            return;
        }
        if (state instanceof InputSimpleUIState.UpdateSimplePlusRedDot) {
            P();
        } else if (state instanceof InputSimpleUIState.UpdateSimpleEmoRedDot) {
            L();
        } else if (state instanceof InputSimpleUIState.ModeCompatState) {
            m((InputSimpleUIState.ModeCompatState) state);
        }
    }

    private final void s(InputSimpleUIState.UpdateSimpleUIState state) {
        Q(state.a());
    }

    private final void t() {
        TextView textView = this.tvPressToRecord;
        ImageButton imageButton = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPressToRecord");
            textView = null;
        }
        textView.setVisibility(4);
        ((IAudioRecordTouchEventApi) QRoute.api(IAudioRecordTouchEventApi.class)).destroy();
        ImageButton imageButton2 = this.pttBtn;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
        } else {
            imageButton = imageButton2;
        }
        imageButton.setSelected(false);
    }

    private final void u() {
        if (this.isSimpleUIAddedInLayout) {
            return;
        }
        v();
        View[] viewArr = new View[4];
        TextView textView = this.tvPressToRecord;
        uu3.a aVar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPressToRecord");
            textView = null;
        }
        viewArr[0] = textView;
        FrameLayout frameLayout = this.emoBtnLayout;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoBtnLayout");
            frameLayout = null;
        }
        viewArr[1] = frameLayout;
        Barrier barrier = this.barrier;
        if (barrier == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barrier");
            barrier = null;
        }
        viewArr[2] = barrier;
        FrameLayout frameLayout2 = this.funBtnLayout;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtnLayout");
            frameLayout2 = null;
        }
        viewArr[3] = frameLayout2;
        for (int i3 = 0; i3 < 4; i3++) {
            View view = viewArr[i3];
            uu3.a aVar2 = this.binding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar2 = null;
            }
            ConstraintLayout root = aVar2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            uu3.a aVar3 = this.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                aVar3 = null;
            }
            ConstraintLayout root2 = aVar3.getRoot();
            Button button = this.sendBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                button = null;
            }
            o81.b.a(view, root, root2.indexOfChild(button));
        }
        ImageButton imageButton = this.pttBtn;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
            imageButton = null;
        }
        uu3.a aVar4 = this.binding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            aVar = aVar4;
        }
        ConstraintLayout root3 = aVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
        o81.b.a(imageButton, root3, 0);
        this.isSimpleUIAddedInLayout = true;
    }

    private final void v() {
        c cVar = this.widgetCreator;
        Context context = this.context;
        TextView textView = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        this.pttBtn = cVar.h(context);
        c cVar2 = this.widgetCreator;
        Context context2 = this.context;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context2 = null;
        }
        this.tvPressToRecord = cVar2.g(context2);
        c cVar3 = this.widgetCreator;
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context3 = null;
        }
        FrameLayout f16 = cVar3.f(context3);
        this.funBtnLayout = f16;
        if (f16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtnLayout");
            f16 = null;
        }
        View findViewById = f16.findViewById(R.id.fun_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "funBtnLayout.findViewById(R.id.fun_btn)");
        this.funBtn = (ImageButton) findViewById;
        c cVar4 = this.widgetCreator;
        Context context4 = this.context;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context4 = null;
        }
        FrameLayout d16 = cVar4.d(context4);
        this.emoBtnLayout = d16;
        if (d16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoBtnLayout");
            d16 = null;
        }
        View findViewById2 = d16.findViewById(R.id.emo_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "emoBtnLayout.findViewById(R.id.emo_btn)");
        this.emoBtn = (ImageButton) findViewById2;
        c cVar5 = this.widgetCreator;
        Context context5 = this.context;
        if (context5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context5 = null;
        }
        this.barrier = cVar5.b(context5);
        ImageButton imageButton = this.pttBtn;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
            imageButton = null;
        }
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = this.emoBtn;
        if (imageButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
            imageButton2 = null;
        }
        imageButton2.setOnClickListener(this);
        ImageButton imageButton3 = this.funBtn;
        if (imageButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
            imageButton3 = null;
        }
        imageButton3.setOnClickListener(this);
        ImageButton imageButton4 = this.pttBtn;
        if (imageButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pttBtn");
            imageButton4 = null;
        }
        imageButton4.setContentDescription(HardCodeUtil.qqStr(R.string.f7k));
        ImageButton imageButton5 = this.emoBtn;
        if (imageButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
            imageButton5 = null;
        }
        imageButton5.setContentDescription(HardCodeUtil.qqStr(R.string.f171479f73));
        ImageButton imageButton6 = this.funBtn;
        if (imageButton6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("funBtn");
            imageButton6 = null;
        }
        imageButton6.setContentDescription(HardCodeUtil.qqStr(R.string.f7g));
        TextView textView2 = this.tvPressToRecord;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvPressToRecord");
        } else {
            textView = textView2;
        }
        textView.setContentDescription(HardCodeUtil.qqStr(R.string.z78));
    }

    private final void w(boolean isGagMode, boolean isFullScreenMode, int inputVisibilityHint, int inputHeightHint) {
        if (!isGagMode) {
            EditText editText = this.input;
            EditText editText2 = null;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("input");
                editText = null;
            }
            editText.setVisibility(inputVisibilityHint);
            if (!isFullScreenMode) {
                EditText editText3 = this.input;
                if (editText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("input");
                } else {
                    editText2 = editText3;
                }
                ViewGroup.LayoutParams layoutParams = editText2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = inputHeightHint;
                }
            }
        }
    }

    private final void y() {
        uu3.a aVar = this.binding;
        uu3.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            aVar = null;
        }
        if (aVar.getRoot().isInLayout() && !this.isInManualLayoutStack) {
            QLog.i("InputSimpleUIVB", 1, "[performLayoutIfInLayoutPass]: performLayout manually");
            FrameLayout frameLayout = this.funBtnLayout;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("funBtnLayout");
                frameLayout = null;
            }
            frameLayout.requestLayout();
            Button button = this.sendBtn;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                button = null;
            }
            button.forceLayout();
            this.isInManualLayoutStack = true;
            uu3.a aVar3 = this.binding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                aVar2 = aVar3;
            }
            ConstraintLayout root = aVar2.getRoot();
            root.measure(View.MeasureSpec.makeMeasureSpec(root.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(root.getMeasuredHeight(), 1073741824));
            root.layout(root.getLeft(), root.getTop(), root.getRight(), root.getBottom());
            this.isInManualLayoutStack = false;
        }
    }

    private final void z(View view, int i3, String str, String str2) {
        int visibility = view.getVisibility();
        if (visibility != i3) {
            QLog.i("InputSimpleUIVB", 1, "view[" + str + "]: oldVisibility=" + visibility + ", newVisibility=" + i3 + ", cause: " + str2);
        }
    }

    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        c.a.b(this);
        d.b bVar = new d.b(0, null, 3, null);
        F(bVar);
        this.peerUid = bVar.b();
        this.chatType = bVar.a();
        F(d.c.f189915d);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        c.a.e(this, reuseParam);
        if (this.isSimpleUIAddedInLayout) {
            C();
        }
        Button button = this.sendBtn;
        if (button != null) {
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
                button = null;
            }
            QLog.i("InputSimpleUIVB", 1, "[onReuseView]: sendBtn.visibility=" + button.getVisibility());
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        ImageButton imageButton;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bundle) iPatchRedirector.redirect((short) 10, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof e.b) {
            e.b bVar = (e.b) stateCmd;
            ViewGroup viewGroup = this.inputRoot;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputRoot");
                viewGroup = null;
            }
            bVar.b(viewGroup);
        } else if ((stateCmd instanceof e.a) && (imageButton = this.emoBtn) != null) {
            e.a aVar = (e.a) stateCmd;
            if (imageButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoBtn");
                imageButton = null;
            }
            aVar.b(imageButton);
        }
        return null;
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{InputSimpleUIState.UpdateSimpleUIState.class, InputSimpleUIState.UpdateFunBtnState.class, InputSimpleUIState.UpdateIconState.class, InputSimpleUIState.UpdateSimplePlusRedDot.class, InputSimpleUIState.UpdateSimpleEmoRedDot.class, InputSimpleUIState.ModeCompatState.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        View view;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            k(v3);
            int id5 = v3.getId();
            if (id5 == R.id.f28760jt) {
                if (!FastClickUtils.isFastDoubleClick("InputSimpleUIVB")) {
                    F(new d.g(v3.isSelected()));
                }
            } else if (id5 == R.id.emo_btn) {
                View view2 = this.emoRedView;
                if (view2 != null) {
                    ae aeVar = ae.f352281b;
                    if (aeVar.d(view2)) {
                        aeVar.b(view2);
                        if (v3.isSelected()) {
                            QLog.i("InputSimpleUIVB", 1, "close simple emo panel");
                            L();
                        }
                    }
                }
                F(new d.C7287d(v3.isSelected()));
            } else if (id5 == R.id.fun_btn) {
                if (v3.isSelected() && (view = this.plusRedView) != null) {
                    ae aeVar2 = ae.f352281b;
                    Intrinsics.checkNotNull(view);
                    if (aeVar2.d(view)) {
                        QLog.i("InputSimpleUIVB", 1, "close simple plus panel");
                        P();
                    }
                }
                F(new d.e(v3.isSelected()));
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            if (this.tvPressToRecord == null) {
                return;
            }
            t();
        }
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof InputSimpleUIState.UpdateSimpleUIState) {
            s((InputSimpleUIState.UpdateSimpleUIState) state);
        } else if (this.isSimpleUIAddedInLayout) {
            r(state);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding.getImpl();
        ConstraintLayout root = binding.getRoot();
        this.inputRoot = root;
        AIOInputSendBtn aIOInputSendBtn = null;
        if (root == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputRoot");
            root = null;
        }
        View findViewById = root.findViewById(R.id.send_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "inputRoot.findViewById(R.id.send_btn)");
        this.sendBtn = (Button) findViewById;
        ViewGroup viewGroup = this.inputRoot;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputRoot");
            viewGroup = null;
        }
        View findViewById2 = viewGroup.findViewById(R.id.input);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "inputRoot.findViewById(R.id.input)");
        this.input = (EditText) findViewById2;
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        this.context = context;
        this.isSimpleUIAddedInLayout = false;
        TextView textView = this.sendBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sendBtn");
            textView = null;
        }
        if (textView instanceof AIOInputSendBtn) {
            aIOInputSendBtn = (AIOInputSendBtn) textView;
        }
        if (aIOInputSendBtn != null) {
            aIOInputSendBtn.setVisibilityChangeListener(new C7285b());
        }
    }
}
