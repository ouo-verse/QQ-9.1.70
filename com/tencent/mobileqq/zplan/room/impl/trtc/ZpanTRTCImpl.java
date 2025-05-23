package com.tencent.mobileqq.zplan.room.impl.trtc;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.view.Surface;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.avbiz.IModule;
import com.tencent.liteav.trtc.TrtcCloudJni;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zplan.room.impl.meeting.QQMeetingScreenCapturePermissionFragment;
import com.tencent.mobileqq.zplan.room.impl.trtc.ZpanTRTCImpl;
import com.tencent.mobileqq.zplan.room.impl.trtc.ZplanTRTCEnvManager;
import com.tencent.mobileqq.zplan.room.impl.utils.SignUtils;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robolectric.a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.sqshow.zootopia.data.ErrorMessage;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.util.QQToastUtil;
import gk3.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import mqq.app.IPermissionRequester;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 v2\u00020\u0001:\u0002wOB\u0007\u00a2\u0006\u0004\bt\u0010uJ\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010 \u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010!\u001a\u00020\nH\u0016J\u0012\u0010\"\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\u001a\u0010%\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J6\u0010.\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u00032\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010\bH\u0016J6\u0010/\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u00032\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010\bH\u0016J&\u00102\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u00032\b\u00101\u001a\u0004\u0018\u0001002\b\u0010-\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u00103\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u00104\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0012H\u0016J\u0010\u00106\u001a\u00020\n2\u0006\u00105\u001a\u00020\u0012H\u0016J\u001a\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010:\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0012H\u0016J\b\u0010;\u001a\u00020\u0019H\u0016J\u0010\u0010<\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010@\u001a\u00020\n2\u0006\u0010=\u001a\u00020\u00122\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010A\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010C\u001a\u00020BH\u0016J\b\u0010D\u001a\u00020\nH\u0016J\u0010\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020\u0012H\u0016J\u0010\u0010G\u001a\u00020\n2\u0006\u00107\u001a\u00020\u0019H\u0016J\u0010\u0010I\u001a\u00020\n2\u0006\u0010\t\u001a\u00020HH\u0016J\u0010\u0010J\u001a\u00020\n2\u0006\u0010\t\u001a\u00020HH\u0016J\u0010\u0010L\u001a\u00020\n2\u0006\u0010\t\u001a\u00020KH\u0016J\u0010\u0010M\u001a\u00020\n2\u0006\u0010\t\u001a\u00020KH\u0016R\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001f\u0010[\u001a\u00060VR\u00020\u00008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00030`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010f\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010gR\u0016\u0010j\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010eR\u0016\u0010l\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010eR\u0016\u0010n\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010mR\u0016\u0010p\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010mR\u0018\u0010s\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010r\u00a8\u0006x"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl;", "Lgk3/b;", "Ljava/util/ArrayList;", "", "h1", "Lmqq/app/IPermissionRequester;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "permissionList", "Lgk3/b$a;", "listener", "", "l1", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "", "m1", HippyControllerProps.STRING, "k1", "f1", "", "j1", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i1", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/a;", "params", "N", "", "sdkAppId", "sdkUserSig", "y", "exitRoom", "destroy", tl.h.F, "o1", "stopLocalAudio", "p", "c0", "isEnable", "v", "mute", "v0", "userId", "Landroid/view/Surface;", "surface", "width", "height", "callback", "r", "H", "Lcom/tencent/rtmp/ui/TXCloudVideoView;", "remoteView", "t", "stopPlayScreenCapture", "muteAllRemoteAudio", "isAnchor", "switchRole", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "z0", "useSpeakerphone", V2TXLiveDefInner.TXLivePropertyKey.kV2SetAudioRoute, "X", ICustomDataEditor.NUMBER_PARAM_1, "success", "Landroid/content/Intent;", "mediaProjectionIntent", "R0", "k", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVideoEncParam;", "y0", "stopScreenCapture", "enable", "enableAudioEarMonitoring", "setAudioPlayoutVolume", "Lcom/tencent/trtc/TRTCCloudListener;", ReportConstant.COSTREPORT_PREFIX, "m0", "Lcom/tencent/avbiz/IModule$FocusChangeListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "f0", "Lcom/tencent/trtc/TRTCCloud;", "b", "Lcom/tencent/trtc/TRTCCloud;", "trtcCloud", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/c;", "c", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/c;", "listenerProxy", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$b;", "d", "Lkotlin/Lazy;", "g1", "()Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$b;", "internalListener", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/RoomState;", "e", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/RoomState;", "roomState", "Ljava/util/LinkedList;", "f", "Ljava/util/LinkedList;", "anchorUserIdList", "g", "I", "roomVolume", "Ljava/lang/String;", "currentRoomID", "i", "currentRole", "j", "curOutputDevice", "Z", "isScreenCaptureRunning", "l", "waitingScreenCaptureResult", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lgk3/b$a;", "tempRequestScreencaptureListener", "<init>", "()V", DomainData.DOMAIN_NAME, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZpanTRTCImpl implements gk3.b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TRTCCloud trtcCloud;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.room.impl.trtc.c listenerProxy = new com.tencent.mobileqq.zplan.room.impl.trtc.c();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy internalListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoomState roomState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final LinkedList<String> anchorUserIdList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int roomVolume;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String currentRoomID;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentRole;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int curOutputDevice;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isScreenCaptureRunning;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private volatile boolean waitingScreenCaptureResult;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private b.a tempRequestScreencaptureListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016J\"\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$j", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "deniedPermissions", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class j extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.a f335283b;

        j(b.a aVar) {
            this.f335283b = aVar;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            ZpanTRTCImpl.this.k1("allGranted");
            b.a aVar = this.f335283b;
            if (aVar != null) {
                b.a.C10382a.a(aVar, true, null, 2, null);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            super.onDenied(permissions, results);
            ZpanTRTCImpl.this.k1("onDenied : " + permissions);
            b.a aVar = this.f335283b;
            if (aVar != null) {
                aVar.a(false, ZplanTRTCError.REQUEST_PERMISSION_FAILED.convertToErrorMessage());
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog dialog, List<String> deniedPermissions) {
            super.onDialogShow(dialog, deniedPermissions);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$m", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class m implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f335292b;

        m(String str) {
            this.f335292b = str;
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            TRTCCloud tRTCCloud = ZpanTRTCImpl.this.trtcCloud;
            if (tRTCCloud != null) {
                tRTCCloud.stopRemoteView(this.f335292b, 0);
            }
        }
    }

    public ZpanTRTCImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.zplan.room.impl.trtc.ZpanTRTCImpl$internalListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZpanTRTCImpl.b invoke() {
                return new ZpanTRTCImpl.b();
            }
        });
        this.internalListener = lazy;
        this.roomState = RoomState.NOT_READY;
        this.anchorUserIdList = new LinkedList<>();
        this.roomVolume = -1;
        this.currentRole = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(b.a listener) {
        if (this.trtcCloud != null) {
            if (listener != null) {
                b.a.C10382a.a(listener, true, null, 2, null);
                return;
            }
            return;
        }
        synchronized (TRTCCloud.class) {
            try {
                k1("createInstance If need");
                TRTCCloud sharedInstance = TRTCCloud.sharedInstance(MobileQQ.sMobileQQ.getApplicationContext());
                this.trtcCloud = sharedInstance;
                if (sharedInstance != null) {
                    sharedInstance.enableAudioVolumeEvaluation(500, false);
                    TRTCCloud.setLogLevel(2);
                    sharedInstance.setListener(this.listenerProxy);
                    s(g1());
                    this.roomState = RoomState.NOT_READY;
                }
                if (listener != null) {
                    b.a.C10382a.a(listener, true, null, 2, null);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                if (listener != null) {
                    listener.a(false, ZplanTRTCError.INIT_TRTC_FAILED.convertToErrorMessage());
                }
                QLog.e("ZplanTrtcManager", 1, "faile to create Instance => ", th5);
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    private final b g1() {
        return (b) this.internalListener.getValue();
    }

    private final ArrayList<String> h1() {
        ArrayList<String> arrayListOf;
        if (MobileQQ.sMobileQQ.checkSelfPermission(QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
            return null;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQPermissionConstants.Permission.RECORD_AUDIO);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j1() {
        RoomState roomState = this.roomState;
        return roomState == RoomState.CONNECTION_RECOVERY || roomState == RoomState.ENTER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k1(String string) {
        QLog.i("ZplanTrtcManager", 1, string);
    }

    private final void l1(IPermissionRequester activity, ArrayList<String> permissionList, b.a listener) {
        i iVar = new i(listener, this);
        Object[] array = permissionList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        activity.requestPermissions(iVar, 10, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    private final void m1(ZootopiaUEActivity activity, List<String> permissionList, b.a listener) {
        QQPermission a16 = activity.getPermissionHelper().a(activity, new BusinessConfig(QQPermissionConstants.Business.ID.ZPLAN_GAME, QQPermissionConstants.Business.SCENE.ZPLAN_GAME));
        if (a16 == null) {
            return;
        }
        QLog.d("ZplanTrtcManager", 1, "request Mic: trtc impl: " + permissionList);
        Object[] array = permissionList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.requestPermissions((String[]) array, 2, new j(listener));
    }

    @Override // gk3.b
    public void H(String userId, Surface surface, int width, int height, b.a callback) {
        k1("updateScreenCaptureSurface userId:" + userId + " width:" + width + " height:" + height);
        try {
            Object b16 = com.tencent.robolectric.a.b(this.trtcCloud, "e");
            Intrinsics.checkNotNullExpressionValue(b16, "getField<TrtcCloudJni>(trtcCloud, \"e\")");
            TrtcCloudJni trtcCloudJni = (TrtcCloudJni) b16;
            Long l3 = (Long) com.tencent.robolectric.a.b(trtcCloudJni, "mNativeTrtcCloudJni");
            if (l3 != null && l3.longValue() == 0) {
                return;
            }
            com.tencent.robolectric.a.a(TrtcCloudJni.class, "nativeUpdateRemoteView", new a.b(Long.TYPE, l3), new a.b(String.class, userId), new a.b(Integer.TYPE, 0), new a.b(DisplayTarget.class, new DisplayTarget(surface)));
            if (callback != null) {
                callback.a(true, null);
            }
        } catch (Exception e16) {
            QLog.e("ZplanTrtcManager", 1, "updateScreenCaptureSurface ", e16);
            if (callback != null) {
                callback.a(false, new ErrorMessage(-1, e16.getMessage()));
            }
        }
    }

    @Override // gk3.b
    public void N(final ZPlanTRTCRoomParam params, final b.a listener) {
        Intrinsics.checkNotNullParameter(params, "params");
        k1("eneterRoom " + params);
        if (Intrinsics.areEqual(params.getRoomId(), this.currentRoomID) && j1()) {
            QLog.e("ZplanTrtcManager", 1, "It's already in the room");
            if (listener != null) {
                listener.a(true, new ErrorMessage(99999, ""));
                return;
            }
            return;
        }
        i1(new b.a() { // from class: com.tencent.mobileqq.zplan.room.impl.trtc.ZpanTRTCImpl$enterRoom$1
            @Override // gk3.b.a
            public void a(boolean isSuccess, ErrorMessage errorMessage) {
                if (!isSuccess) {
                    b.a aVar = b.a.this;
                    if (aVar != null) {
                        aVar.a(false, errorMessage);
                        return;
                    }
                    return;
                }
                SignUtils signUtils = SignUtils.f335313a;
                String selfUserId = params.getSelfUserId();
                final b.a aVar2 = b.a.this;
                final ZpanTRTCImpl zpanTRTCImpl = this;
                final ZPlanTRTCRoomParam zPlanTRTCRoomParam = params;
                signUtils.f(selfUserId, new Function1<Pair<? extends String, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.trtc.ZpanTRTCImpl$enterRoom$1$onComplete$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends String> pair) {
                        invoke2((Pair<String, String>) pair);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Pair<String, String> pair) {
                        if (pair != null) {
                            TRTCCloud tRTCCloud = zpanTRTCImpl.trtcCloud;
                            if (tRTCCloud != null) {
                                ZpanTRTCImpl zpanTRTCImpl2 = zpanTRTCImpl;
                                ZPlanTRTCRoomParam zPlanTRTCRoomParam2 = zPlanTRTCRoomParam;
                                b.a aVar3 = b.a.this;
                                tRTCCloud.setDefaultStreamRecvMode(true, true);
                                zpanTRTCImpl2.roomVolume = -1;
                                if (!zpanTRTCImpl2.j1()) {
                                    tRTCCloud.enterRoom(zPlanTRTCRoomParam2.e(pair), zPlanTRTCRoomParam2.getRoomType());
                                } else {
                                    tRTCCloud.switchRoom(zPlanTRTCRoomParam2.g(pair));
                                }
                                zpanTRTCImpl2.currentRoomID = zPlanTRTCRoomParam2.getRoomId();
                                QLog.i("ZplanTrtcManager", 1, "call enter Room success -> " + pair + ", roomState : " + zpanTRTCImpl2.roomState);
                                zpanTRTCImpl2.currentRole = zPlanTRTCRoomParam2.getIsAnchor() ? 20 : 21;
                                if (aVar3 != null) {
                                    b.a.C10382a.a(aVar3, true, null, 2, null);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        QLog.e("ZplanTrtcManager", 1, "get sign failed ");
                        b.a aVar4 = b.a.this;
                        if (aVar4 != null) {
                            aVar4.a(false, ZplanTRTCError.REQUEST_SIGN_FAILED.convertToErrorMessage());
                        }
                    }
                });
            }
        });
    }

    @Override // gk3.b
    public void R0(boolean success, Intent mediaProjectionIntent) {
        QLog.i("ZplanTrtcManager", 1, "requestScreenCapturePermissionResult onStartResult:" + success + " ");
        this.waitingScreenCaptureResult = false;
        if (success && mediaProjectionIntent != null) {
            TRTCCloudDef.TRTCVideoEncParam y06 = y0();
            TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams = new TRTCCloudDef.TRTCScreenShareParams();
            Object systemService = MobileQQ.sMobileQQ.getApplicationContext().getSystemService("media_projection");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
            tRTCScreenShareParams.mediaProjection = ((MediaProjectionManager) systemService).getMediaProjection(-1, mediaProjectionIntent);
            TRTCCloud tRTCCloud = this.trtcCloud;
            if (tRTCCloud != null) {
                tRTCCloud.startScreenCapture(0, y06, tRTCScreenShareParams);
            }
            b.a aVar = this.tempRequestScreencaptureListener;
            if (aVar != null) {
                aVar.a(true, null);
            }
        } else {
            b.a aVar2 = this.tempRequestScreencaptureListener;
            if (aVar2 != null) {
                aVar2.a(false, null);
            }
        }
        this.tempRequestScreencaptureListener = null;
    }

    @Override // gk3.b
    /* renamed from: X, reason: from getter */
    public int getCurOutputDevice() {
        return this.curOutputDevice;
    }

    @Override // gk3.b
    public void c0() {
        k1("handleOutSpeaking ~");
        stopLocalAudio();
        switchRole(false);
    }

    @Override // gk3.b
    public void destroy() {
        k1("destroy");
        if (this.trtcCloud != null) {
            m0(g1());
            TRTCCloud tRTCCloud = this.trtcCloud;
            if (tRTCCloud != null) {
                tRTCCloud.setListener(null);
            }
            this.trtcCloud = null;
        }
        this.listenerProxy.N();
        TRTCCloud.destroySharedInstance();
        ZplanTRTCEnvManager.INSTANCE.a().b();
    }

    @Override // gk3.b
    public void enableAudioEarMonitoring(boolean enable) {
        QLog.i("ZplanTrtcManager", 1, "enableAudioEarMonitoring enable:" + enable);
        TRTCCloud tRTCCloud = this.trtcCloud;
        if (tRTCCloud != null) {
            tRTCCloud.enableAudioEarMonitoring(enable);
        }
    }

    @Override // gk3.b
    public void exitRoom() {
        k1("exitroom");
        this.anchorUserIdList.clear();
        this.currentRoomID = null;
        this.roomVolume = -1;
        this.currentRole = -1;
        TRTCCloud tRTCCloud = this.trtcCloud;
        if (tRTCCloud != null) {
            tRTCCloud.exitRoom();
        }
        this.curOutputDevice = 0;
    }

    @Override // gk3.b
    public void f0(IModule.FocusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZplanTRTCEnvManager.INSTANCE.a().m(listener);
    }

    @Override // gk3.b
    public void h(b.a listener) {
        ArrayList<String> h16 = h1();
        if (h16 != null && !h16.isEmpty()) {
            ComponentCallbacks2 topActivity = Foreground.getTopActivity();
            if (topActivity == null) {
                QLog.e("ZplanTrtcManager", 1, "fail to get activity");
                if (listener != null) {
                    b.a.C10382a.a(listener, false, null, 2, null);
                    return;
                }
                return;
            }
            if (topActivity instanceof ZootopiaUEActivity) {
                m1((ZootopiaUEActivity) topActivity, h16, listener);
                return;
            } else if (topActivity instanceof IPermissionRequester) {
                l1((IPermissionRequester) topActivity, h16, listener);
                return;
            } else {
                if (listener != null) {
                    listener.a(false, ZplanTRTCError.REQUEST_PERMISSION_FAILED.convertToErrorMessage());
                    return;
                }
                return;
            }
        }
        QLog.i("ZplanTrtcManager", 1, "permission granted");
        if (listener != null) {
            b.a.C10382a.a(listener, true, null, 2, null);
        }
    }

    public void i1(b.a listener) {
        k1("initTRTCManager if Need");
        ZplanTRTCEnvManager.INSTANCE.a().h(new e(listener));
    }

    @Override // gk3.b
    public void m0(TRTCCloudListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listenerProxy.O(listener);
    }

    @Override // gk3.b
    public void muteAllRemoteAudio(boolean mute) {
        k1("muteAllRemoteAudio : " + mute);
        TRTCCloud tRTCCloud = this.trtcCloud;
        if (tRTCCloud != null) {
            tRTCCloud.muteAllRemoteAudio(mute);
        }
    }

    public final void n1(b.a listener) {
        QLog.i("ZplanTrtcManager", 1, "requestScreenCapturePermission ");
        if (!this.waitingScreenCaptureResult && !this.isScreenCaptureRunning) {
            if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
                QPublicFragmentActivity.start(BaseApplication.context, QQMeetingScreenCapturePermissionFragment.class);
            } else {
                QPublicFragmentActivity.start(BaseApplication.context, QQMeetingScreenCapturePermissionFragment.class);
            }
            this.tempRequestScreencaptureListener = listener;
            return;
        }
        if (listener != null) {
            listener.a(false, new ErrorMessage(-1, "waitingScreenCaptureResult:" + this.waitingScreenCaptureResult + "  isScreenCaptureRunning:" + this.isScreenCaptureRunning));
        }
        QQToastUtil.showQQToastInUiThread(0, "\u6b63\u5728\u5f55\u5c4f\u4e2d");
    }

    public void o1(b.a listener) {
        k1("startLocalAudio");
        i1(new l(listener, this));
    }

    @Override // gk3.b
    public void p(b.a listener) {
        k1("handle In Speaking ~");
        i1(new d(listener));
    }

    @Override // gk3.b
    public void q(b.a listener) {
        k1("preInitTRTC if Need");
        ZplanTRTCEnvManager.INSTANCE.a().i(new h(listener));
    }

    @Override // gk3.b
    public void r(String userId, Surface surface, int width, int height, b.a callback) {
        k1("playScreenCaptureWithSurface userId:" + userId + " width:" + width + " height:" + height);
        try {
            Object b16 = com.tencent.robolectric.a.b(this.trtcCloud, "e");
            Intrinsics.checkNotNullExpressionValue(b16, "getField<TrtcCloudJni>(trtcCloud, \"e\")");
            com.tencent.robolectric.a.a(TrtcCloudJni.class, "nativeStartRemoteView", new a.b(Long.TYPE, (Long) com.tencent.robolectric.a.b((TrtcCloudJni) b16, "mNativeTrtcCloudJni")), new a.b(String.class, userId), new a.b(Integer.TYPE, 0), new a.b(DisplayTarget.class, new DisplayTarget(surface)));
            if (callback != null) {
                callback.a(true, null);
            }
        } catch (Exception e16) {
            QLog.e("ZplanTrtcManager", 1, "playScreenCaptureWithSurface ", e16);
            if (callback != null) {
                callback.a(false, new ErrorMessage(-1, e16.getMessage()));
            }
        }
    }

    @Override // gk3.b
    public void s(TRTCCloudListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listenerProxy.M(listener);
    }

    @Override // gk3.b
    public void setAudioPlayoutVolume(int volume) {
        QLog.i("ZplanTrtcManager", 1, "setAudioPlayoutVolume " + volume + " ");
        TRTCCloud tRTCCloud = this.trtcCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setAudioPlayoutVolume(volume);
        }
        this.roomVolume = volume;
        for (String str : this.anchorUserIdList) {
            TRTCCloud tRTCCloud2 = this.trtcCloud;
            if (tRTCCloud2 != null) {
                tRTCCloud2.setRemoteAudioVolume(str, volume);
            }
        }
    }

    @Override // gk3.b
    public void setAudioRoute(boolean useSpeakerphone) {
        QLog.i("ZplanTrtcManager", 1, "setAudioRoute useSpeakerphone\uff1a" + useSpeakerphone);
        int i3 = !useSpeakerphone ? 1 : 0;
        this.curOutputDevice = i3;
        TRTCCloud tRTCCloud = this.trtcCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setAudioRoute(i3);
        }
    }

    @Override // gk3.b
    public void stopLocalAudio() {
        k1("stopLocalAudio");
        b.C10383b.b(this, true, null, 2, null);
        TRTCCloud tRTCCloud = this.trtcCloud;
        if (tRTCCloud != null) {
            tRTCCloud.stopLocalAudio();
        }
    }

    @Override // gk3.b
    public void stopPlayScreenCapture(String userId) {
        k1("stopPlayScreenCapture");
        i1(new m(userId));
    }

    @Override // gk3.b
    public void t(String userId, TXCloudVideoView remoteView, b.a callback) {
        k1("playScreenCapture userId:" + userId + " remoteView:" + remoteView);
        if ((userId == null || userId.length() == 0) || remoteView == null) {
            return;
        }
        i1(new g(callback, this, userId, remoteView));
    }

    @Override // gk3.b
    public void v(boolean isEnable, b.a listener) {
        k1("setSelfMicEnable " + isEnable);
        if (isEnable) {
            o1(listener);
        } else {
            v0(true, listener);
        }
    }

    @Override // gk3.b
    public void v0(boolean mute, b.a listener) {
        k1("muteLocalAudio " + mute);
        if (!mute) {
            if (this.currentRole == 20) {
                i1(new f(listener, this));
                return;
            } else {
                if (listener != null) {
                    listener.a(false, ZplanTRTCError.OPEN_MIC_FAILED.convertToErrorMessage());
                    return;
                }
                return;
            }
        }
        TRTCCloud tRTCCloud = this.trtcCloud;
        if (tRTCCloud != null) {
            tRTCCloud.muteLocalAudio(true);
        }
        if (listener != null) {
            b.a.C10382a.a(listener, true, null, 2, null);
        }
    }

    @Override // gk3.b
    public void y(int sdkAppId, String sdkUserSig, ZPlanTRTCRoomParam params, b.a listener) {
        Intrinsics.checkNotNullParameter(sdkUserSig, "sdkUserSig");
        Intrinsics.checkNotNullParameter(params, "params");
        k1("eneterRoom sdkAppId:" + sdkAppId + " sdkUserSig:" + sdkUserSig + " " + params + " ");
        if (Intrinsics.areEqual(params.getRoomId(), this.currentRoomID) && j1()) {
            QLog.e("ZplanTrtcManager", 1, "It's already in the room");
            if (listener != null) {
                listener.a(true, new ErrorMessage(99999, ""));
                return;
            }
            return;
        }
        i1(new c(listener, this, params, sdkAppId, sdkUserSig));
    }

    @Override // gk3.b
    public TRTCCloudDef.TRTCVideoEncParam y0() {
        TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
        tRTCVideoEncParam.videoResolution = 112;
        tRTCVideoEncParam.videoResolutionMode = BaseApplication.getContext().getResources().getConfiguration().orientation == 2 ? 1 : 0;
        tRTCVideoEncParam.videoFps = 10;
        tRTCVideoEncParam.enableAdjustRes = false;
        tRTCVideoEncParam.videoBitrate = 1500;
        TRTCCloud tRTCCloud = this.trtcCloud;
        if (tRTCCloud != null) {
            tRTCCloud.setVideoEncoderParam(tRTCVideoEncParam);
        }
        return tRTCVideoEncParam;
    }

    @Override // gk3.b
    public void z(IModule.FocusChangeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ZplanTRTCEnvManager.INSTANCE.a().j(listener);
    }

    @Override // gk3.b
    public void z0(int volume, b.a listener) {
        QLog.i("ZplanTrtcManager", 1, "setAudioCaptureVolumd " + volume);
        i1(new k(volume, listener));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$b;", "Lcom/tencent/trtc/TRTCCloudListener;", "", "result", "", "onEnterRoom", "", "reason", "onExitRoom", "onConnectionLost", "onConnectionRecovery", "onTryToReconnect", "", "userId", "onRemoteUserEnterRoom", "onRemoteUserLeaveRoom", "<init>", "(Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class b extends TRTCCloudListener {
        public b() {
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onConnectionLost() {
            ZpanTRTCImpl.this.roomState = RoomState.CONNECTION_LOST;
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onConnectionRecovery() {
            ZpanTRTCImpl.this.roomState = RoomState.CONNECTION_RECOVERY;
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onEnterRoom(long result) {
            RoomState roomState;
            ZpanTRTCImpl zpanTRTCImpl = ZpanTRTCImpl.this;
            if (result > 0) {
                roomState = RoomState.ENTER;
            } else {
                roomState = RoomState.NOT_READY;
            }
            zpanTRTCImpl.roomState = roomState;
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onExitRoom(int reason) {
            ZpanTRTCImpl.this.roomState = RoomState.EXIT;
            ZpanTRTCImpl.this.k1("exitroom by onExitRoom callback reason:" + reason);
            ZpanTRTCImpl.this.exitRoom();
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onTryToReconnect() {
            ZpanTRTCImpl.this.roomState = RoomState.TRY_TO_RECONNECTION;
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onRemoteUserEnterRoom(String userId) {
            TRTCCloud tRTCCloud;
            if (userId != null) {
                ZpanTRTCImpl zpanTRTCImpl = ZpanTRTCImpl.this;
                zpanTRTCImpl.anchorUserIdList.add(userId);
                if (zpanTRTCImpl.roomVolume <= 0 || (tRTCCloud = zpanTRTCImpl.trtcCloud) == null) {
                    return;
                }
                tRTCCloud.setRemoteAudioVolume(userId, zpanTRTCImpl.roomVolume);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onRemoteUserLeaveRoom(String userId, int reason) {
            if (userId != null) {
                ZpanTRTCImpl.this.anchorUserIdList.remove(userId);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$c", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a f335258a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZpanTRTCImpl f335259b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanTRTCRoomParam f335260c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f335261d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f335262e;

        c(b.a aVar, ZpanTRTCImpl zpanTRTCImpl, ZPlanTRTCRoomParam zPlanTRTCRoomParam, int i3, String str) {
            this.f335258a = aVar;
            this.f335259b = zpanTRTCImpl;
            this.f335260c = zPlanTRTCRoomParam;
            this.f335261d = i3;
            this.f335262e = str;
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (isSuccess) {
                TRTCCloud tRTCCloud = this.f335259b.trtcCloud;
                if (tRTCCloud != null) {
                    ZpanTRTCImpl zpanTRTCImpl = this.f335259b;
                    ZPlanTRTCRoomParam zPlanTRTCRoomParam = this.f335260c;
                    int i3 = this.f335261d;
                    String str = this.f335262e;
                    b.a aVar = this.f335258a;
                    tRTCCloud.setDefaultStreamRecvMode(true, true);
                    zpanTRTCImpl.roomVolume = -1;
                    if (!zpanTRTCImpl.j1()) {
                        tRTCCloud.enterRoom(zPlanTRTCRoomParam.d(i3, str), zPlanTRTCRoomParam.getRoomType());
                    } else {
                        tRTCCloud.switchRoom(zPlanTRTCRoomParam.f(str));
                    }
                    zpanTRTCImpl.currentRoomID = zPlanTRTCRoomParam.getRoomId();
                    QLog.i("ZplanTrtcManager", 1, "call enter Room success ->  sdkAppId:" + i3 + " sdkUserSig:" + str + " roomState : " + zpanTRTCImpl.roomState);
                    zpanTRTCImpl.currentRole = zPlanTRTCRoomParam.getIsAnchor() ? 20 : 21;
                    if (aVar != null) {
                        b.a.C10382a.a(aVar, true, null, 2, null);
                        return;
                    }
                    return;
                }
                return;
            }
            b.a aVar2 = this.f335258a;
            if (aVar2 != null) {
                aVar2.a(false, errorMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$d", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.a f335264b;

        d(b.a aVar) {
            this.f335264b = aVar;
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (isSuccess) {
                ZpanTRTCImpl.this.switchRole(true);
                b.a aVar = this.f335264b;
                if (aVar != null) {
                    b.a.C10382a.a(aVar, true, null, 2, null);
                    return;
                }
                return;
            }
            b.a aVar2 = this.f335264b;
            if (aVar2 != null) {
                aVar2.a(false, errorMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$e", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager$b;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements ZplanTRTCEnvManager.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.a f335266b;

        e(b.a aVar) {
            this.f335266b = aVar;
        }

        @Override // com.tencent.mobileqq.zplan.room.impl.trtc.ZplanTRTCEnvManager.b
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (isSuccess) {
                ZpanTRTCImpl.this.f1(this.f335266b);
                return;
            }
            ZpanTRTCImpl.this.k1("load so fail =>");
            b.a aVar = this.f335266b;
            if (aVar != null) {
                aVar.a(false, errorMessage);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$f", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a f335270a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZpanTRTCImpl f335271b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$f$a", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZpanTRTCImpl f335272a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b.a f335273b;

            a(ZpanTRTCImpl zpanTRTCImpl, b.a aVar) {
                this.f335272a = zpanTRTCImpl;
                this.f335273b = aVar;
            }

            @Override // gk3.b.a
            public void a(boolean isSuccess, ErrorMessage errorMessage) {
                this.f335272a.k1("mute mic success");
                TRTCCloud tRTCCloud = this.f335272a.trtcCloud;
                if (tRTCCloud != null) {
                    tRTCCloud.muteLocalAudio(false);
                }
                b.a aVar = this.f335273b;
                if (aVar != null) {
                    aVar.a(isSuccess, errorMessage);
                }
            }
        }

        f(b.a aVar, ZpanTRTCImpl zpanTRTCImpl) {
            this.f335270a = aVar;
            this.f335271b = zpanTRTCImpl;
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (!isSuccess) {
                b.a aVar = this.f335270a;
                if (aVar != null) {
                    aVar.a(false, errorMessage);
                    return;
                }
                return;
            }
            ZpanTRTCImpl zpanTRTCImpl = this.f335271b;
            zpanTRTCImpl.h(new a(zpanTRTCImpl, this.f335270a));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$h", "Lcom/tencent/mobileqq/zplan/room/impl/trtc/ZplanTRTCEnvManager$b;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class h implements ZplanTRTCEnvManager.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.a f335279b;

        h(b.a aVar) {
            this.f335279b = aVar;
        }

        @Override // com.tencent.mobileqq.zplan.room.impl.trtc.ZplanTRTCEnvManager.b
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (isSuccess) {
                ZpanTRTCImpl.this.f1(this.f335279b);
                return;
            }
            ZpanTRTCImpl.this.k1("load so fail =>");
            b.a aVar = this.f335279b;
            if (aVar != null) {
                aVar.a(false, errorMessage);
            }
        }
    }

    @Override // gk3.b
    public void k(b.a listener) {
        QLog.i("ZplanTrtcManager", 1, "openScreenCapture ");
        n1(listener);
    }

    @Override // gk3.b
    public void stopScreenCapture() {
        QLog.i("ZplanTrtcManager", 1, "stopScreenCapture");
        TRTCCloud tRTCCloud = this.trtcCloud;
        if (tRTCCloud != null) {
            tRTCCloud.stopScreenCapture();
        }
        this.waitingScreenCaptureResult = false;
        this.isScreenCaptureRunning = false;
        this.tempRequestScreencaptureListener = null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$g", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class g implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a f335274a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZpanTRTCImpl f335275b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f335276c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TXCloudVideoView f335277d;

        g(b.a aVar, ZpanTRTCImpl zpanTRTCImpl, String str, TXCloudVideoView tXCloudVideoView) {
            this.f335274a = aVar;
            this.f335275b = zpanTRTCImpl;
            this.f335276c = str;
            this.f335277d = tXCloudVideoView;
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            b.a aVar;
            if (!isSuccess && (aVar = this.f335274a) != null) {
                aVar.a(false, errorMessage);
            }
            TRTCCloud tRTCCloud = this.f335275b.trtcCloud;
            if (tRTCCloud != null) {
                tRTCCloud.startRemoteView(this.f335276c, 0, this.f335277d);
            }
            b.a aVar2 = this.f335274a;
            if (aVar2 != null) {
                b.a.C10382a.a(aVar2, true, null, 2, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$k", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class k implements b.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f335285b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ b.a f335286c;

        k(int i3, b.a aVar) {
            this.f335285b = i3;
            this.f335286c = aVar;
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (isSuccess) {
                TRTCCloud tRTCCloud = ZpanTRTCImpl.this.trtcCloud;
                if (tRTCCloud != null) {
                    tRTCCloud.setAudioCaptureVolume(this.f335285b);
                }
                b.a aVar = this.f335286c;
                if (aVar != null) {
                    b.a.C10382a.a(aVar, true, null, 2, null);
                    return;
                }
                return;
            }
            b.a aVar2 = this.f335286c;
            if (aVar2 != null) {
                aVar2.a(false, errorMessage);
            }
            QLog.e("ZplanTrtcManager", 1, "fail to set CaptureVolume =>");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$l", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class l implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.a f335287a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZpanTRTCImpl f335288b;

        l(b.a aVar, ZpanTRTCImpl zpanTRTCImpl) {
            this.f335287a = aVar;
            this.f335288b = zpanTRTCImpl;
        }

        @Override // gk3.b.a
        public void a(boolean isSuccess, ErrorMessage errorMessage) {
            if (!isSuccess) {
                QLog.e("ZplanTrtcManager", 1, "trtc env is not ready~");
                b.a aVar = this.f335287a;
                if (aVar != null) {
                    aVar.a(false, errorMessage);
                    return;
                }
                return;
            }
            ZpanTRTCImpl zpanTRTCImpl = this.f335288b;
            zpanTRTCImpl.h(new a(zpanTRTCImpl, this.f335287a));
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$l$a", "Lgk3/b$a;", "", "isSuccess", "Lcom/tencent/sqshow/zootopia/data/a;", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZpanTRTCImpl f335289a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b.a f335290b;

            a(ZpanTRTCImpl zpanTRTCImpl, b.a aVar) {
                this.f335289a = zpanTRTCImpl;
                this.f335290b = aVar;
            }

            @Override // gk3.b.a
            public void a(boolean isSuccess, ErrorMessage errorMessage) {
                if (isSuccess || t74.h.b()) {
                    this.f335289a.switchRole(true);
                    b.C10383b.b(this.f335289a, false, null, 2, null);
                    TRTCCloud tRTCCloud = this.f335289a.trtcCloud;
                    if (tRTCCloud != null) {
                        tRTCCloud.startLocalAudio(2);
                    }
                }
                QLog.i("ZplanTrtcManager", 1, "start local audio");
                b.a aVar = this.f335290b;
                if (aVar != null) {
                    b.a.C10382a.a(aVar, isSuccess, null, 2, null);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ3\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\f\u0010\u000b\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/trtc/ZpanTRTCImpl$i", "Lmqq/app/QQPermissionCallback;", "", "reqeustCode", "", "", "permissions", "", "reuslts", "", "grant", "(I[Ljava/lang/String;[I)V", "deny", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class i implements QQPermissionCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b.a f335280d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZpanTRTCImpl f335281e;

        i(b.a aVar, ZpanTRTCImpl zpanTRTCImpl) {
            this.f335280d = aVar;
            this.f335281e = zpanTRTCImpl;
        }

        @Override // mqq.app.QQPermissionCallback
        public void deny(int reqeustCode, String[] permissions, int[] reuslts) {
            b.a aVar;
            if (10 == reqeustCode && (aVar = this.f335280d) != null) {
                b.a.C10382a.a(aVar, false, null, 2, null);
            }
            this.f335281e.k1("request permission fail => " + reqeustCode + ", permissions: " + permissions + ", result: " + reuslts);
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int reqeustCode, String[] permissions, int[] reuslts) {
            b.a aVar;
            if (10 == reqeustCode && (aVar = this.f335280d) != null) {
                b.a.C10382a.a(aVar, true, null, 2, null);
            }
            this.f335281e.k1("request success => " + reqeustCode + ", permissions: " + permissions + ", result: " + reuslts);
        }
    }

    @Override // gk3.b
    public void switchRole(boolean isAnchor) {
        int i3 = isAnchor ? 20 : 21;
        k1("switchRole " + isAnchor + " & " + (i3 == this.currentRole));
        if (i3 != this.currentRole) {
            this.currentRole = i3;
            TRTCCloud tRTCCloud = this.trtcCloud;
            if (tRTCCloud != null) {
                tRTCCloud.switchRole(i3);
            }
        }
    }
}
