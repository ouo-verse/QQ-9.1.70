package com.tencent.mobileqq.zplan.cc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEDownloadMaterial;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.filament.api.IZplanFilamentProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.filament.zplan.listener.GYScreenShotCallback;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.cc.FilamentCaptureFragment;
import com.tencent.mobileqq.zplan.cc.camera.CameraViewTex;
import com.tencent.mobileqq.zplan.cc.camera.Ratio;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.encrypt.Base64;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LoadingUtil;
import fg3.FaceItemData;
import java.io.ByteArrayOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import qshadow.AIFacePtaData$ZPlanV2Reply;
import qshadow.AIFacePtaData$ZPlanV2Result;
import qshadow.AIFacePtaData$ZplanFaceStyle;
import uv4.bm;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0097\u00012\u00020\u0001:\u0002\u0098\u0001B\t\u00a2\u0006\u0006\b\u0095\u0001\u0010\u0096\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\u0012\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0010H\u0002J\n\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J&\u0010.\u001a\u0004\u0018\u00010\u00022\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\b\u00100\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\u0004H\u0016R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00100K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010FR\u0016\u0010]\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010FR\u0016\u0010_\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010FR\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010o\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010y\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010bR\u0018\u0010{\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010bR\u0018\u0010~\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010}R\u0017\u0010\u0080\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u007f\u0010FR\u0018\u0010\u0082\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010FR\u0018\u0010\u0084\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010HR\u001a\u0010\u0086\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0085\u0001\u0010CR\u001a\u0010\u0088\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0087\u0001\u0010CR\u0018\u0010\u008a\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010FR\u001c\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u0090\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010FR\u0018\u0010\u0094\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u00a8\u0006\u0099\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/FilamentCaptureFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View;", "view", "", "pi", "Bi", "ki", "Lfg3/l;", "data", "", "index", "ei", "oi", "ni", WidgetCacheLunarData.JI, "", SensorJsPlugin.SENSOR_INTERVAL_UI, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Di", WidgetCacheLunarData.YI, "Landroid/content/Context;", "context", "qi", "ii", "Fi", "Gi", "hi", "Ni", "", "delay", "Li", "Ci", "H2", "applyTemplate", "Oi", "", "fi", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/zplan/cc/camera/CameraViewTex;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zplan/cc/camera/CameraViewTex;", "glSurfaceView", "Ldg3/d;", "D", "Ldg3/d;", "lightRenderer", "Lcom/tencent/mobileqq/zplan/cc/camera/a;", "E", "Lcom/tencent/mobileqq/zplan/cc/camera/a;", "mCameraManager", "Ldg3/c;", UserInfo.SEX_FEMALE, "Ldg3/c;", "filamentThumbnailRender", "G", "Ljava/lang/String;", "path", "H", "Z", "captureReady", "I", "J", "captureReadyTime", "", "[Ljava/lang/Boolean;", "captureStatus", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "K", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "mQQPermission", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "L", "Lcom/tencent/mobileqq/qqpermission/business/BusinessConfig;", "mConfig", "Lorg/libpag/PAGFile;", "M", "Lorg/libpag/PAGFile;", "captureUnreadyPag", "N", "resumed", "P", "cameraResReady", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "waitingUserSetPerm", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/FrameLayout;", "glSurfaceViewContainer", "Lcom/tencent/mobileqq/zplan/cc/c;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zplan/cc/c;", "viewModel", "Lfg3/w;", "T", "Lfg3/w;", "filamentCaptureFirstTipManager", "Lfg3/r;", "U", "Lfg3/r;", "filamentCaptureFaceManager", "Lfg3/u;", "V", "Lfg3/u;", "filamentCaptureFirstErrorManager", "Lcom/tencent/mobileqq/zplan/cc/util/b;", "W", "Lcom/tencent/mobileqq/zplan/cc/util/b;", "timeReport", "X", "contentLayout", "Y", "pagContainer", "Lorg/libpag/PAGView;", "Lorg/libpag/PAGView;", "pagView", "a0", "isCaptureFaceUIShowed", "b0", "isInScan", "c0", "gender", "d0", "selectedFaceJson", "e0", "cameraTemplateJsonPath", "f0", "enableThumbnailPreloading", "Leg3/b;", "g0", "Leg3/b;", "performanceReport", "h0", "isFirstInitCamera", "Landroid/os/Handler;", "i0", "Landroid/os/Handler;", "handler", "<init>", "()V", "j0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FilamentCaptureFragment extends Fragment {

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private CameraViewTex glSurfaceView;

    /* renamed from: D, reason: from kotlin metadata */
    private dg3.d lightRenderer;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.cc.camera.a mCameraManager;

    /* renamed from: F, reason: from kotlin metadata */
    private dg3.c filamentThumbnailRender;

    /* renamed from: G, reason: from kotlin metadata */
    private String path;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean captureReady;

    /* renamed from: I, reason: from kotlin metadata */
    private long captureReadyTime = -1;

    /* renamed from: J, reason: from kotlin metadata */
    private final Boolean[] captureStatus;

    /* renamed from: K, reason: from kotlin metadata */
    private QQPermission mQQPermission;

    /* renamed from: L, reason: from kotlin metadata */
    private final BusinessConfig mConfig;

    /* renamed from: M, reason: from kotlin metadata */
    private PAGFile captureUnreadyPag;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean resumed;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean cameraResReady;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean waitingUserSetPerm;

    /* renamed from: R, reason: from kotlin metadata */
    private FrameLayout glSurfaceViewContainer;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.cc.c viewModel;

    /* renamed from: T, reason: from kotlin metadata */
    private final fg3.w filamentCaptureFirstTipManager;

    /* renamed from: U, reason: from kotlin metadata */
    private final fg3.r filamentCaptureFaceManager;

    /* renamed from: V, reason: from kotlin metadata */
    private final fg3.u filamentCaptureFirstErrorManager;

    /* renamed from: W, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.cc.util.b timeReport;

    /* renamed from: X, reason: from kotlin metadata */
    private FrameLayout contentLayout;

    /* renamed from: Y, reason: from kotlin metadata */
    private FrameLayout pagContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private PAGView pagView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isCaptureFaceUIShowed;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean isInScan;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int gender;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String selectedFaceJson;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String cameraTemplateJsonPath;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean enableThumbnailPreloading;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private eg3.b performanceReport;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstInitCamera;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0014\u0010\u0018\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/zplan/cc/FilamentCaptureFragment;", "a", "", "AVATAR_CHARACTER", "Ljava/lang/String;", "DEFAULT_CHECK_NO_ASK", "", "DELAY", "J", "GENDER_KEY", "", "GENDER_MAN", "I", "GENDER_UNSET", "GENDER_WOMAN", "TAG", "TASK_UPDATE_STATUS", "TYPE_EMOTION", "TYPE_FACE", "TYPE_LIGHT", "ZPLAN_SOURCE", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.cc.FilamentCaptureFragment$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FilamentCaptureFragment a(Bundle bundle) {
            FilamentCaptureFragment filamentCaptureFragment = new FilamentCaptureFragment();
            filamentCaptureFragment.setArguments(bundle);
            return filamentCaptureFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$b", "Lcom/tencent/filament/zplan/listener/GYScreenShotCallback;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onScreenShot", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements GYScreenShotCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FaceItemData f332448a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FilamentCaptureFragment f332449b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f332450c;

        b(FaceItemData faceItemData, FilamentCaptureFragment filamentCaptureFragment, int i3) {
            this.f332448a = faceItemData;
            this.f332449b = filamentCaptureFragment;
            this.f332450c = i3;
        }

        @Override // com.tencent.filament.zplan.listener.GYScreenShotCallback
        public void onScreenShot(Bitmap bitmap) {
            if (bitmap == null) {
                QLog.e("ZPlanCamera_FilamentAIFace", 1, "onScreenShot bitmap is null !!!!");
                return;
            }
            QLog.d("ZPlanCamera_FilamentAIFace", 1, "onScreenShot bitmapSize:" + Integer.valueOf(bitmap.getWidth()) + ", " + Integer.valueOf(bitmap.getHeight()));
            this.f332448a.n(bitmap);
            this.f332449b.filamentCaptureFaceManager.getDataManager().u(this.f332448a, this.f332450c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$c", "Lcom/tencent/mobileqq/zplan/cc/util/d;", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "", "onFrameAvailable", "", "cameraRatio", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends com.tencent.mobileqq.zplan.cc.util.d {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(FilamentCaptureFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            dg3.d dVar = this$0.lightRenderer;
            if (dVar != null) {
                dVar.G();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(FilamentCaptureFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            dg3.d dVar = this$0.lightRenderer;
            if (dVar != null) {
                CameraViewTex cameraViewTex = this$0.glSurfaceView;
                Intrinsics.checkNotNull(cameraViewTex);
                int width = cameraViewTex.getWidth();
                CameraViewTex cameraViewTex2 = this$0.glSurfaceView;
                Intrinsics.checkNotNull(cameraViewTex2);
                dVar.L(width, cameraViewTex2.getHeight());
            }
        }

        @Override // com.tencent.mobileqq.zplan.cc.util.d, com.tencent.mobileqq.zplan.cc.camera.a.c
        public void a(float cameraRatio) {
            super.a(cameraRatio);
            CameraViewTex cameraViewTex = FilamentCaptureFragment.this.glSurfaceView;
            if (cameraViewTex != null) {
                final FilamentCaptureFragment filamentCaptureFragment = FilamentCaptureFragment.this;
                cameraViewTex.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.ae
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilamentCaptureFragment.c.f(FilamentCaptureFragment.this);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.zplan.cc.camera.a.c
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            CameraViewTex cameraViewTex = FilamentCaptureFragment.this.glSurfaceView;
            if (cameraViewTex != null) {
                final FilamentCaptureFragment filamentCaptureFragment = FilamentCaptureFragment.this;
                cameraViewTex.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.af
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilamentCaptureFragment.c.e(FilamentCaptureFragment.this);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$f", "Ldg3/f;", "", "poseValid", "expressionValid", "lightValid", "", "b", "", "size", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements dg3.f {
        f() {
        }

        @Override // dg3.f
        public void a(int size) {
            if (FilamentCaptureFragment.this.resumed && FilamentCaptureFragment.this.isCaptureFaceUIShowed) {
                FilamentCaptureFragment.this.filamentCaptureFaceManager.getDataManager().k(size);
            }
        }

        @Override // dg3.f
        public void b(boolean poseValid, boolean expressionValid, boolean lightValid) {
            if (FilamentCaptureFragment.this.resumed && FilamentCaptureFragment.this.isCaptureFaceUIShowed) {
                if (FilamentCaptureFragment.this.isFirstInitCamera) {
                    com.tencent.mobileqq.zplan.cc.util.b bVar = FilamentCaptureFragment.this.timeReport;
                    if (bVar != null) {
                        bVar.b();
                    }
                    FilamentCaptureFragment.this.isFirstInitCamera = false;
                }
                FilamentCaptureFragment.this.captureStatus[0] = Boolean.valueOf(poseValid);
                FilamentCaptureFragment.this.captureStatus[2] = Boolean.valueOf(expressionValid);
                FilamentCaptureFragment.this.captureStatus[1] = Boolean.valueOf(lightValid);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$g", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g extends QQPermission.BasePermissionsListener {
        g() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(FilamentCaptureFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.waitingUserSetPerm = true;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "request camera permission result is Granted");
            eg3.b bVar = FilamentCaptureFragment.this.performanceReport;
            if (bVar != null) {
                bVar.a("CAMERA_REQUEST_PERMISSION_END");
            }
            super.onAllGranted();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "request camera permission result is Denied");
            super.onDenied(permissions, results);
            FragmentActivity activity = FilamentCaptureFragment.this.getActivity();
            if (activity != null) {
                final FilamentCaptureFragment filamentCaptureFragment = FilamentCaptureFragment.this;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.ah
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilamentCaptureFragment.g.b(FilamentCaptureFragment.this);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$h", "Lks/a;", "", "downloadType", "", "j", "", "downloadCostMs", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements ks.a {
        h() {
        }

        @Override // ks.a
        public void a(String downloadType, long downloadCostMs) {
            Intrinsics.checkNotNullParameter(downloadType, "downloadType");
            eg3.b bVar = FilamentCaptureFragment.this.performanceReport;
            if (bVar != null) {
                bVar.i("download res " + downloadType + " cost " + downloadCostMs + " ms");
            }
            eg3.b bVar2 = FilamentCaptureFragment.this.performanceReport;
            if (bVar2 != null) {
                bVar2.k("GENERATE_THUMBNAIL_DOWNLOAD_RESOURCE_END", downloadCostMs);
            }
        }

        @Override // ks.a
        public void j(String downloadType) {
            Intrinsics.checkNotNullParameter(downloadType, "downloadType");
            eg3.b bVar = FilamentCaptureFragment.this.performanceReport;
            if (bVar != null) {
                bVar.a("GENERATE_THUMBNAIL_DOWNLOAD_RESOURCE_BEGIN");
            }
        }
    }

    public FilamentCaptureFragment() {
        Boolean bool = Boolean.FALSE;
        this.captureStatus = new Boolean[]{bool, bool, bool};
        this.mConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_ZPLAN_LIGHTAI, QQPermissionConstants.Business.SCENE.QQ_ZPLAN_LIGHTAI_CAPTURE);
        this.filamentCaptureFirstTipManager = new fg3.w();
        this.filamentCaptureFaceManager = new fg3.r();
        this.filamentCaptureFirstErrorManager = new fg3.u();
        this.timeReport = new com.tencent.mobileqq.zplan.cc.util.b();
        this.enableThumbnailPreloading = true;
        this.isFirstInitCamera = true;
        this.handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.zplan.cc.x
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean gi5;
                gi5 = FilamentCaptureFragment.gi(FilamentCaptureFragment.this, message);
                return gi5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ai(FilamentCaptureFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dg3.d dVar = this$0.lightRenderer;
        if (dVar != null) {
            dVar.b();
        }
    }

    private final void Bi(View view) {
        String str;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(SquareReportConst.Key.KEY_SOURCE)) == null) {
            str = "em_zplan_entrance_qq_main";
        }
        com.tencent.mobileqq.zplan.report.c cVar = com.tencent.mobileqq.zplan.report.c.f335070a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        Unit unit = Unit.INSTANCE;
        cVar.d(this, view, "pg_zplan_ai_sculpt", linkedHashMap);
        com.tencent.mobileqq.zplan.cc.util.b bVar = this.timeReport;
        if (bVar == null) {
            return;
        }
        bVar.c(str);
    }

    private final void Ci() {
        Boolean[] boolArr = this.captureStatus;
        Boolean bool = Boolean.FALSE;
        boolArr[0] = bool;
        boolArr[2] = bool;
        boolArr[1] = bool;
        this.captureReady = false;
        this.captureReadyTime = -1L;
    }

    private final void Di(final Activity activity) {
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "resume camera, cameraResReady = " + this.cameraResReady + ", resumed = " + this.resumed);
        if (this.cameraResReady && ui() && this.resumed) {
            ii(activity);
            qi(activity);
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "real resume camera");
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.n
                @Override // java.lang.Runnable
                public final void run() {
                    FilamentCaptureFragment.Ei(FilamentCaptureFragment.this, activity);
                }
            });
            CameraViewTex cameraViewTex = this.glSurfaceView;
            if (cameraViewTex != null) {
                cameraViewTex.onResume();
            }
            if (com.tencent.mobileqq.zplan.cc.util.f.f332559a.a()) {
                ((IZplanFilamentProvider) QRoute.api(IZplanFilamentProvider.class)).registerFilamentDownloader(new h());
            }
            this.filamentThumbnailRender = new dg3.c(ViewUtils.dip2px(90.0f), ViewUtils.dip2px(120.0f), com.tencent.mobileqq.zplan.cc.util.e.f332557a.a(IAEDownloadMaterial.FILAMENT_FACE_THUMBNAIL_RES_KEY), this.performanceReport);
            Oi(true);
            if (this.enableThumbnailPreloading) {
                dg3.c cVar = this.filamentThumbnailRender;
                if (cVar != null) {
                    cVar.g(fi());
                }
                this.enableThumbnailPreloading = false;
            }
            Fi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(FilamentCaptureFragment this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        com.tencent.mobileqq.zplan.cc.camera.a aVar = this$0.mCameraManager;
        if (aVar != null) {
            aVar.d(activity);
        }
        com.tencent.mobileqq.zplan.cc.camera.a aVar2 = this$0.mCameraManager;
        if (aVar2 != null) {
            aVar2.m();
        }
    }

    private final void Fi() {
        int i3 = 0;
        for (Object obj : this.filamentCaptureFaceManager.getDataManager().e().i0()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            FaceItemData faceItemData = (FaceItemData) obj;
            if (faceItemData.getType() == FaceItemData.INSTANCE.c()) {
                ei(faceItemData, i3);
            }
            i3 = i16;
        }
    }

    private final void Gi() {
        if (this.resumed) {
            eg3.b bVar = this.performanceReport;
            if (bVar != null) {
                bVar.a("CAMERA_CAPTURE_PREPARE_DATA_BEGIN");
            }
            CameraViewTex cameraViewTex = this.glSurfaceView;
            if (cameraViewTex != null) {
                cameraViewTex.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilamentCaptureFragment.Hi(FilamentCaptureFragment.this);
                    }
                });
            }
        }
    }

    private final void H2() {
        String[] strArr = {QQPermissionConstants.Permission.CAMERA};
        eg3.b bVar = this.performanceReport;
        if (bVar != null) {
            bVar.a("CAMERA_REQUEST_PERMISSION_BEGIN");
        }
        QQPermission qQPermission = this.mQQPermission;
        if (qQPermission != null) {
            Intrinsics.checkNotNull(qQPermission);
            qQPermission.requestPermissions(strArr, 2, new g());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hi(final FilamentCaptureFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.resumed) {
            try {
                this$0.filamentCaptureFaceManager.getDataManager().o();
                dg3.d dVar = this$0.lightRenderer;
                if (dVar != null) {
                    dVar.f(new dg3.e() { // from class: com.tencent.mobileqq.zplan.cc.q
                        @Override // dg3.e
                        public final void a(Bitmap bitmap) {
                            FilamentCaptureFragment.Ii(FilamentCaptureFragment.this, bitmap);
                        }
                    });
                }
            } catch (Exception e16) {
                QLog.e("ZPlanCamera_FilamentAIFace", 1, e16, new Object[0]);
            }
        }
    }

    public static final /* synthetic */ fg3.m Ih(FilamentCaptureFragment filamentCaptureFragment) {
        filamentCaptureFragment.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ii(final FilamentCaptureFragment this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.resumed) {
            Bitmap newBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
            bitmap.recycle();
            com.tencent.mobileqq.zplan.cc.c cVar = this$0.viewModel;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                cVar = null;
            }
            Intrinsics.checkNotNullExpressionValue(newBitmap, "newBitmap");
            Bitmap L1 = cVar.L1(newBitmap);
            if (L1 == null) {
                FragmentActivity activity = this$0.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            FilamentCaptureFragment.Ji(FilamentCaptureFragment.this);
                        }
                    });
                    return;
                }
                return;
            }
            Bitmap copy = L1.copy(Bitmap.Config.ARGB_8888, false);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            copy.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null) {
                activity2.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilamentCaptureFragment.Ki(FilamentCaptureFragment.this, byteArray);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ji(FilamentCaptureFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.captureReady = false;
        this$0.hi();
        QQToast.makeText(this$0.getContext(), 1, "\u8bc6\u522b\u5931\u8d25, \u8bf7\u91cd\u8bd5", 0).show();
        this$0.oi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ki(FilamentCaptureFragment this$0, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.zplan.cc.c cVar = null;
        fg3.r.x(this$0.filamentCaptureFaceManager, false, 1, null);
        com.tencent.mobileqq.zplan.cc.c cVar2 = this$0.viewModel;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar2 = null;
        }
        if (cVar2.getSeqId() == 0) {
            this$0.filamentCaptureFaceManager.j();
        }
        this$0.captureReady = false;
        this$0.hi();
        if (this$0.resumed) {
            com.tencent.mobileqq.zplan.cc.util.b bVar = this$0.timeReport;
            if (bVar != null) {
                bVar.d();
            }
            eg3.b bVar2 = this$0.performanceReport;
            if (bVar2 != null) {
                bVar2.a("CAMERA_CAPTURE_REQUEST_DATA_BEGIN");
            }
            com.tencent.mobileqq.zplan.cc.c cVar3 = this$0.viewModel;
            if (cVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                cVar = cVar3;
            }
            Intrinsics.checkNotNullExpressionValue(byteArray, "byteArray");
            cVar.P1(byteArray, this$0.gender);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Li(long delay) {
        if (this.handler.hasMessages(1)) {
            this.handler.removeMessages(1);
        }
        Handler handler = this.handler;
        handler.sendMessageDelayed(handler.obtainMessage(1), delay);
    }

    private final void Ni() {
        if (this.isInScan) {
            if (this.isCaptureFaceUIShowed && this.captureStatus[0].booleanValue() && this.captureStatus[1].booleanValue() && this.captureStatus[2].booleanValue()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!this.captureReady) {
                    this.captureReady = true;
                    this.captureReadyTime = currentTimeMillis;
                    PAGView pAGView = this.pagView;
                    if (pAGView != null) {
                        pAGView.setRepeatCount(1);
                        PAGView pAGView2 = this.pagView;
                        if (pAGView2 != null) {
                            pAGView2.setProgress(0.0d);
                        }
                        pAGView.play();
                    }
                }
                long j3 = this.captureReadyTime;
                if (j3 > 0 && currentTimeMillis - j3 > 2000) {
                    Gi();
                    this.isInScan = false;
                    return;
                } else {
                    Li(200L);
                    return;
                }
            }
            if (this.captureReady) {
                this.captureReady = false;
                this.captureReadyTime = -1L;
                hi();
            }
            Li(200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(boolean z16, FilamentCaptureFragment this$0) {
        dg3.d dVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && (dVar = this$0.lightRenderer) != null) {
            dVar.N(this$0.cameraTemplateJsonPath);
        }
        dg3.d dVar2 = this$0.lightRenderer;
        if (dVar2 != null) {
            dVar2.o(this$0.selectedFaceJson, this$0.gender, this$0.fi());
        }
        dg3.c cVar = this$0.filamentThumbnailRender;
        if (cVar != null) {
            cVar.i(false);
        }
        dg3.c cVar2 = this$0.filamentThumbnailRender;
        if (cVar2 != null) {
            cVar2.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei(FaceItemData data, int index) {
        PBStringField pBStringField;
        dg3.c cVar = this.filamentThumbnailRender;
        if (cVar != null) {
            String fi5 = fi();
            AIFacePtaData$ZplanFaceStyle face2 = data.getFace();
            cVar.e(fi5, (face2 == null || (pBStringField = face2.pta_data) == null) ? null : pBStringField.get(), index, new b(data, this, index));
        }
    }

    private final String fi() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getString("avatar_character");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean gi(FilamentCaptureFragment this$0, Message it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.what == 1) {
            this$0.Ni();
        }
        return true;
    }

    private final void hi() {
        FrameLayout frameLayout = this.pagContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        PAGView pAGView = this.pagView;
        if (pAGView != null) {
            pAGView.setProgress(0.0d);
        }
        PAGView pAGView2 = this.pagView;
        if (pAGView2 != null) {
            pAGView2.stop();
        }
    }

    private final void ii(Activity activity) {
        if (this.mCameraManager != null) {
            return;
        }
        com.tencent.mobileqq.zplan.cc.camera.a aVar = new com.tencent.mobileqq.zplan.cc.camera.a();
        aVar.j(activity);
        aVar.l(Ratio.RATIO_Full.value);
        aVar.i(new c());
        this.mCameraManager = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2 = this.contentLayout;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
            View p16 = this.filamentCaptureFaceManager.p(this, frameLayout2);
            if (p16 != null && (frameLayout = this.contentLayout) != null) {
                frameLayout.addView(p16);
            }
            this.isCaptureFaceUIShowed = true;
            this.isInScan = true;
            Mi(this, 0L, 1, null);
        }
    }

    private final void ki() {
        this.filamentCaptureFaceManager.t(new d());
        com.tencent.mobileqq.zplan.cc.c cVar = this.viewModel;
        com.tencent.mobileqq.zplan.cc.c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        MutableLiveData<AIFacePtaData$ZPlanV2Reply> N1 = cVar.N1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<AIFacePtaData$ZPlanV2Reply, Unit> function1 = new Function1<AIFacePtaData$ZPlanV2Reply, Unit>() { // from class: com.tencent.mobileqq.zplan.cc.FilamentCaptureFragment$initCaptureManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AIFacePtaData$ZPlanV2Reply aIFacePtaData$ZPlanV2Reply) {
                invoke2(aIFacePtaData$ZPlanV2Reply);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AIFacePtaData$ZPlanV2Reply aIFacePtaData$ZPlanV2Reply) {
                c cVar3;
                AIFacePtaData$ZPlanV2Result aIFacePtaData$ZPlanV2Result;
                PBRepeatMessageField<AIFacePtaData$ZplanFaceStyle> pBRepeatMessageField;
                eg3.b bVar = FilamentCaptureFragment.this.performanceReport;
                if (bVar != null) {
                    bVar.a("CAMERA_CAPTURE_REQUEST_DATA_END");
                }
                fg3.r rVar = FilamentCaptureFragment.this.filamentCaptureFaceManager;
                c cVar4 = null;
                List<AIFacePtaData$ZplanFaceStyle> list = (aIFacePtaData$ZPlanV2Reply == null || (aIFacePtaData$ZPlanV2Result = aIFacePtaData$ZPlanV2Reply.zplan) == null || (pBRepeatMessageField = aIFacePtaData$ZPlanV2Result.face_styles) == null) ? null : pBRepeatMessageField.get();
                cVar3 = FilamentCaptureFragment.this.viewModel;
                if (cVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    cVar4 = cVar3;
                }
                rVar.q(list, cVar4.getSeqId() - 1);
            }
        };
        N1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.cc.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FilamentCaptureFragment.li(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.zplan.cc.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar2 = cVar3;
        }
        MutableLiveData<Unit> M1 = cVar2.M1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Unit, Unit> function12 = new Function1<Unit, Unit>() { // from class: com.tencent.mobileqq.zplan.cc.FilamentCaptureFragment$initCaptureManager$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                c cVar4;
                c cVar5;
                cVar4 = FilamentCaptureFragment.this.viewModel;
                if (cVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar4 = null;
                }
                if (cVar4.getSeqId() == 0) {
                    FilamentCaptureFragment.this.oi();
                    return;
                }
                fg3.r rVar = FilamentCaptureFragment.this.filamentCaptureFaceManager;
                cVar5 = FilamentCaptureFragment.this.viewModel;
                if (cVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    cVar5 = null;
                }
                rVar.q(null, cVar5.getSeqId());
            }
        };
        M1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.zplan.cc.ac
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FilamentCaptureFragment.mi(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void pi(View view) {
        Context context = view.getContext();
        this.pagContainer = (FrameLayout) view.findViewById(R.id.qb_);
        this.captureUnreadyPag = PagViewMonitor.Load(requireActivity().getAssets(), "first_stage.pag");
        PAGView pAGView = new PAGView(context);
        FrameLayout frameLayout = this.pagContainer;
        if (frameLayout != null) {
            frameLayout.addView(pAGView, new ViewGroup.MarginLayoutParams(-1, -1));
        }
        pAGView.setComposition(this.captureUnreadyPag);
        pAGView.addListener(new e());
        this.pagView = pAGView;
    }

    private final void qi(Context context) {
        if (this.glSurfaceView != null) {
            return;
        }
        CameraViewTex cameraViewTex = new CameraViewTex(context);
        FrameLayout frameLayout = this.glSurfaceViewContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("glSurfaceViewContainer");
            frameLayout = null;
        }
        frameLayout.addView(cameraViewTex, new FrameLayout.LayoutParams(-1, -1));
        cameraViewTex.setTranslationY(-(ScreenUtils.getScreenHeight(context) * 0.2f));
        this.glSurfaceView = cameraViewTex;
        cameraViewTex.setEGLContextClientVersion(3);
        CameraViewTex cameraViewTex2 = this.glSurfaceView;
        if (cameraViewTex2 != null) {
            cameraViewTex2.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        }
        CameraViewTex cameraViewTex3 = this.glSurfaceView;
        if (cameraViewTex3 != null) {
            dg3.d dVar = new dg3.d(context, 2, this.performanceReport);
            this.lightRenderer = dVar;
            cameraViewTex3.setRenderer(dVar);
        }
        CameraViewTex cameraViewTex4 = this.glSurfaceView;
        if (cameraViewTex4 != null) {
            cameraViewTex4.setRenderMode(1);
        }
        dg3.d dVar2 = this.lightRenderer;
        if (dVar2 != null) {
            IAEResUtil iAEResUtil = (IAEResUtil) QRoute.api(IAEResUtil.class);
            AEResInfo aEResInfo = AEResInfo.LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE;
            dVar2.n(iAEResUtil.getLightBundleDir(aEResInfo), aEResInfo.agentType);
        }
        dg3.d dVar3 = this.lightRenderer;
        if (dVar3 != null) {
            dVar3.F(new dg3.g() { // from class: com.tencent.mobileqq.zplan.cc.ad
                @Override // dg3.g
                public final void a(SurfaceTexture surfaceTexture) {
                    FilamentCaptureFragment.ri(FilamentCaptureFragment.this, surfaceTexture);
                }
            });
        }
        dg3.d dVar4 = this.lightRenderer;
        if (dVar4 != null) {
            dVar4.p(new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(final FilamentCaptureFragment this$0, final SurfaceTexture surfaceTexture) {
        dg3.d dVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = this$0.resumed;
        com.tencent.mobileqq.zplan.cc.camera.a aVar = this$0.mCameraManager;
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "on surface created, resume = " + z16 + ", camera manager init = " + (aVar != null ? Boolean.valueOf(aVar.g()) : null));
        String str = this$0.path;
        if (str == null) {
            str = "";
        }
        if ((str.length() > 0) && (dVar = this$0.lightRenderer) != null) {
            dVar.j(str, com.tencent.mobileqq.zplan.cc.util.c.e(str));
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.t
                @Override // java.lang.Runnable
                public final void run() {
                    FilamentCaptureFragment.si(FilamentCaptureFragment.this, surfaceTexture);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void si(final FilamentCaptureFragment this$0, final SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.resumed) {
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "surface created called, but not resumed, ignore");
        } else {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.u
                @Override // java.lang.Runnable
                public final void run() {
                    FilamentCaptureFragment.ti(FilamentCaptureFragment.this, surfaceTexture);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(FilamentCaptureFragment this$0, SurfaceTexture surfaceTexture) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.zplan.cc.camera.a aVar = this$0.mCameraManager;
        boolean z16 = false;
        if (aVar != null && aVar.g()) {
            z16 = true;
        }
        if (z16) {
            com.tencent.mobileqq.zplan.cc.camera.a aVar2 = this$0.mCameraManager;
            if (aVar2 != null) {
                aVar2.n(surfaceTexture);
                return;
            }
            return;
        }
        com.tencent.mobileqq.zplan.cc.camera.a aVar3 = this$0.mCameraManager;
        if (aVar3 != null) {
            aVar3.k(surfaceTexture);
        }
    }

    private final boolean ui() {
        QQPermission qQPermission = this.mQQPermission;
        if (qQPermission != null) {
            Intrinsics.checkNotNull(qQPermission);
            if (qQPermission.hasPermission(QQPermissionConstants.Permission.CAMERA) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(FilamentCaptureFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("dt_clck", view, new LinkedHashMap());
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(FilamentCaptureFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        com.tencent.mobileqq.zplan.cc.util.f.f332559a.b();
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || activity.isFinishing() || this$0.isDetached()) {
            return;
        }
        this$0.cameraResReady = true;
        this$0.cameraTemplateJsonPath = com.tencent.mobileqq.zplan.cc.util.e.f332557a.a(IAEDownloadMaterial.FILAMENT_FACE_CAMERA_RES_KEY);
        if (this$0.ui()) {
            this$0.Di(activity);
        } else {
            this$0.H2();
        }
        this$0.pi(view);
        this$0.ni(view);
        this$0.ki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(FilamentCaptureFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void yi() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.v
            @Override // java.lang.Runnable
            public final void run() {
                FilamentCaptureFragment.zi(FilamentCaptureFragment.this);
            }
        });
        CameraViewTex cameraViewTex = this.glSurfaceView;
        if (cameraViewTex != null) {
            cameraViewTex.queueEvent(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.w
                @Override // java.lang.Runnable
                public final void run() {
                    FilamentCaptureFragment.Ai(FilamentCaptureFragment.this);
                }
            });
        }
        CameraViewTex cameraViewTex2 = this.glSurfaceView;
        if (cameraViewTex2 != null) {
            cameraViewTex2.onPause();
        }
        dg3.c cVar = this.filamentThumbnailRender;
        if (cVar != null) {
            cVar.h();
        }
        this.filamentThumbnailRender = null;
        dg3.d dVar = this.lightRenderer;
        if (dVar != null) {
            dVar.N(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zi(FilamentCaptureFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.zplan.cc.camera.a aVar = this$0.mCameraManager;
        if (aVar != null) {
            aVar.o();
        }
        com.tencent.mobileqq.zplan.cc.camera.a aVar2 = this$0.mCameraManager;
        if (aVar2 != null) {
            aVar2.h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onCreate start");
        ViewModel viewModel = new ViewModelProvider(requireActivity()).get(com.tencent.mobileqq.zplan.cc.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026entViewModel::class.java]");
        this.viewModel = (com.tencent.mobileqq.zplan.cc.c) viewModel;
        boolean d16 = com.tencent.mobileqq.zplan.cc.util.e.f332557a.d(2);
        this.cameraResReady = d16;
        if (!d16) {
            an.f332478a.d(null);
        }
        if (this.mQQPermission == null) {
            this.mQQPermission = QQPermissionFactory.getQQPermission(this, this.mConfig);
        }
        Bundle arguments = getArguments();
        this.gender = arguments != null ? arguments.getInt("gender_key") : 0;
        Bundle arguments2 = getArguments();
        boolean z16 = arguments2 != null ? arguments2.getBoolean("default_check_no_ask") : false;
        this.filamentCaptureFirstTipManager.f(z16);
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onCreate end isCheck = " + z16);
        eg3.b bVar = new eg3.b();
        bVar.j(getArguments());
        this.performanceReport = bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.f167441dc0, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.i("ZPlanCamera_FilamentAIFace", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.resumed = false;
        if (com.tencent.mobileqq.zplan.cc.util.f.f332559a.a()) {
            ((IZplanFilamentProvider) QRoute.api(IZplanFilamentProvider.class)).registerFilamentDownloader(null);
        }
        this.handler.removeMessages(1);
        yi();
        Ci();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onResume start");
        this.resumed = true;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Di(requireActivity);
        if (this.waitingUserSetPerm) {
            if (!ui()) {
                com.tencent.mobileqq.zplan.cc.util.m mVar = com.tencent.mobileqq.zplan.cc.util.m.f332568a;
                FragmentActivity requireActivity2 = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
                mVar.d(requireActivity2, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.cc.FilamentCaptureFragment$onResume$1
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
                        FilamentCaptureFragment.this.waitingUserSetPerm = true;
                    }
                });
            }
            this.waitingUserSetPerm = false;
        }
        Mi(this, 0L, 1, null);
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onResume end");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onViewCreated start");
        Bi(view);
        View findViewById = view.findViewById(R.id.f163322pi1);
        if (findViewById != null) {
            com.tencent.mobileqq.zplan.report.c.f335070a.b(findViewById, SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, new LinkedHashMap());
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.cc.y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FilamentCaptureFragment.vi(FilamentCaptureFragment.this, view2);
                }
            });
        }
        View findViewById2 = view.findViewById(R.id.q1c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.image_camera_container)");
        this.glSurfaceViewContainer = (FrameLayout) findViewById2;
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.z
            @Override // java.lang.Runnable
            public final void run() {
                FilamentCaptureFragment.wi(FilamentCaptureFragment.this, view);
            }
        };
        if (this.cameraResReady) {
            runnable.run();
        } else {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            com.tencent.mobileqq.zplan.cc.h hVar = new com.tencent.mobileqq.zplan.cc.h(requireContext, false, false, 2, 6, null);
            hVar.j(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.aa
                @Override // java.lang.Runnable
                public final void run() {
                    FilamentCaptureFragment.xi(FilamentCaptureFragment.this);
                }
            });
            hVar.k(runnable);
            hVar.show();
        }
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "onViewCreated end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi() {
        FrameLayout frameLayout;
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "initErrorView");
        this.filamentCaptureFirstErrorManager.e(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.cc.FilamentCaptureFragment$initErrorView$1
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
                QLog.i("ZPlanCamera_FilamentAIFace", 1, "onRetry");
                FilamentCaptureFragment.this.filamentCaptureFaceManager.r();
                FilamentCaptureFragment.this.ji();
            }
        });
        FrameLayout frameLayout2 = this.contentLayout;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
        }
        fg3.u uVar = this.filamentCaptureFirstErrorManager;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        View b16 = uVar.b(requireContext);
        if (b16 == null || (frameLayout = this.contentLayout) == null) {
            return;
        }
        frameLayout.addView(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oi(final boolean applyTemplate) {
        if (applyTemplate || this.selectedFaceJson != null) {
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.o
                @Override // java.lang.Runnable
                public final void run() {
                    FilamentCaptureFragment.Pi(applyTemplate, this);
                }
            };
            dg3.c cVar = this.filamentThumbnailRender;
            if (cVar != null) {
                cVar.d(runnable);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$d", "Lfg3/y;", "Lfg3/l;", "data", "", "index", "", "b", "a", "d", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements fg3.y {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$d$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/bm;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class b implements com.tencent.mobileqq.zootopia.api.e<bm> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ FaceItemData f332455d;

            b(FaceItemData faceItemData) {
                this.f332455d = faceItemData;
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(bm result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.d("ZPlanCamera_FilamentAIFace", 1, "onTransformFaceJson2Data onResultSuccess");
                this.f332455d.j(Base64.encode(result.f440374c));
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.e("ZPlanCamera_FilamentAIFace", 1, "onTransformFaceJson2Data error:" + error + ",msg:" + message);
            }
        }

        d() {
        }

        @Override // fg3.y
        public void a(FaceItemData data, int index) {
            com.tencent.mobileqq.zplan.cc.util.b bVar;
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "onNeedGeneratePicture index  = " + index + ", data = " + data);
            if (index == 0 && (bVar = FilamentCaptureFragment.this.timeReport) != null) {
                bVar.a();
            }
            FilamentCaptureFragment.this.ei(data, index);
        }

        @Override // fg3.y
        public void b(FaceItemData data, int index) {
            String str;
            PBStringField pBStringField;
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "onSelectPicture index  = " + index + ", data = " + data);
            FilamentCaptureFragment.Ih(FilamentCaptureFragment.this);
            FilamentCaptureFragment filamentCaptureFragment = FilamentCaptureFragment.this;
            AIFacePtaData$ZplanFaceStyle face2 = data.getFace();
            filamentCaptureFragment.selectedFaceJson = (face2 == null || (pBStringField = face2.pta_data) == null) ? null : pBStringField.get();
            if (!TextUtils.isEmpty(FilamentCaptureFragment.this.selectedFaceJson) && (str = FilamentCaptureFragment.this.selectedFaceJson) != null) {
                com.tencent.mobileqq.zplan.cc.util.q.g(FilamentCaptureFragment.this.gender, str, new b(data));
            }
            FilamentCaptureFragment.this.Oi(false);
        }

        @Override // fg3.y
        public void c(FaceItemData data) {
            AIFacePtaData$ZplanFaceStyle face2;
            Dialog showLoadingDialog;
            String data2;
            Unit unit;
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "gotoPortal");
            Dialog dialog = null;
            if (data != null && (data2 = data.getData()) != null) {
                FilamentCaptureFragment filamentCaptureFragment = FilamentCaptureFragment.this;
                ((cj3.a) k74.i.INSTANCE.a(cj3.a.class)).aiMakeFaceResult(data2);
                QLog.i("ZPlanCamera_FilamentAIFace", 1, "set ai face result successful.");
                FragmentActivity activity = filamentCaptureFragment.getActivity();
                if (activity != null) {
                    activity.finish();
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit != null) {
                    return;
                }
            }
            FilamentCaptureFragment filamentCaptureFragment2 = FilamentCaptureFragment.this;
            QLog.i("ZPlanCamera_FilamentAIFace", 1, "\u5c06\u8981\u8fdb\u884c\u6570\u636e\u8f6c\u6362\u624d\u4f1a\u8df3\u8f6c.");
            if (data != null && (face2 = data.getFace()) != null) {
                if (filamentCaptureFragment2.getActivity() != null && (showLoadingDialog = LoadingUtil.showLoadingDialog(filamentCaptureFragment2.getActivity(), "\u634f\u8138\u751f\u6548\u4e2d", false)) != null) {
                    dialog = showLoadingDialog;
                }
                if (dialog != null) {
                    dialog.show();
                }
                com.tencent.mobileqq.zplan.cc.util.q.g(filamentCaptureFragment2.gender, face2.pta_data.get(), new a(dialog, filamentCaptureFragment2));
                Unit unit2 = Unit.INSTANCE;
                return;
            }
            QLog.e("ZPlanCamera_FilamentAIFace", 1, "\u6ca1\u6709\u6709\u6548\u7684\u634f\u8138\u6570\u636e\u4f20\u51fa\uff0c\u76f4\u63a5\u7ed3\u675f\u3002");
            FragmentActivity activity2 = filamentCaptureFragment2.getActivity();
            if (activity2 != null) {
                activity2.finish();
                Unit unit3 = Unit.INSTANCE;
            }
        }

        @Override // fg3.y
        public void d() {
            if (FilamentCaptureFragment.this.filamentCaptureFaceManager.getDataManager().j()) {
                QLog.i("ZPlanCamera_FilamentAIFace", 1, "onSelectCapture capture again");
                FilamentCaptureFragment.this.timeReport = null;
                FilamentCaptureFragment.this.isInScan = true;
                FilamentCaptureFragment.this.Li(200L);
                dg3.d dVar = FilamentCaptureFragment.this.lightRenderer;
                if (dVar != null) {
                    dVar.e(false);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u000b\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$d$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/bm;", "result", "", "e", "", "error", "", "message", "onResultFailure", "", "isShowToast", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements com.tencent.mobileqq.zootopia.api.e<bm> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Dialog f332453d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ FilamentCaptureFragment f332454e;

            a(Dialog dialog, FilamentCaptureFragment filamentCaptureFragment) {
                this.f332453d = dialog;
                this.f332454e = filamentCaptureFragment;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d(Dialog dialog, FilamentCaptureFragment this$0, boolean z16) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (dialog != null) {
                    dialog.hide();
                }
                FragmentActivity activity = this$0.getActivity();
                if (activity != null) {
                    if (z16) {
                        QQToast.makeText(activity, 1, "\u7f51\u7edc\u5f02\u5e38\u8bf7\u91cd\u8bd5", 0).show();
                    }
                    activity.finish();
                }
            }

            public final void b(final boolean isShowToast) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final Dialog dialog = this.f332453d;
                final FilamentCaptureFragment filamentCaptureFragment = this.f332454e;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.cc.ag
                    @Override // java.lang.Runnable
                    public final void run() {
                        FilamentCaptureFragment.d.a.d(dialog, filamentCaptureFragment, isShowToast);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(bm result) {
                Intrinsics.checkNotNullParameter(result, "result");
                QLog.i("ZPlanCamera_FilamentAIFace", 1, "onTransformFaceJson2Data onResultSuccess");
                cj3.a aVar = (cj3.a) k74.i.INSTANCE.a(cj3.a.class);
                String encode = Base64.encode(result.f440374c);
                Intrinsics.checkNotNullExpressionValue(encode, "encode(result.data)");
                aVar.aiMakeFaceResult(encode);
                c(this, false, 1, null);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.e("ZPlanCamera_FilamentAIFace", 1, "onTransformFaceJson2Data error:" + error + ",msg:" + message);
                b(true);
            }

            public static /* synthetic */ void c(a aVar, boolean z16, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                aVar.b(z16);
            }
        }
    }

    private final void ni(View view) {
        FrameLayout frameLayout;
        this.contentLayout = (FrameLayout) view.findViewById(R.id.pm_);
        if (this.filamentCaptureFirstTipManager.i()) {
            this.isCaptureFaceUIShowed = false;
            View c16 = this.filamentCaptureFirstTipManager.c(this);
            if (c16 != null && (frameLayout = this.contentLayout) != null) {
                frameLayout.addView(c16);
            }
            this.filamentCaptureFirstTipManager.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.cc.FilamentCaptureFragment$initContentLayout$2
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
                    FilamentCaptureFragment.this.ji();
                }
            });
            return;
        }
        ji();
    }

    static /* synthetic */ void Mi(FilamentCaptureFragment filamentCaptureFragment, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        filamentCaptureFragment.Li(j3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/cc/FilamentCaptureFragment$e", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements PAGView.PAGViewListener {
        e() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView p06) {
            FrameLayout frameLayout = FilamentCaptureFragment.this.pagContainer;
            if (frameLayout == null) {
                return;
            }
            frameLayout.setVisibility(0);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView p06) {
        }
    }
}
