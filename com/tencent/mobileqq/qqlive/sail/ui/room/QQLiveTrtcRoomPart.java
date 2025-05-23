package com.tencent.mobileqq.qqlive.sail.ui.room;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfig;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.data.trtc.RTCCameraDefine;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.SailAnchorRoomManager;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.AvConfig;
import com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.LocationInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.RoomCoverInfo;
import com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareViewModel;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveSetAnchorLabelRequest;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u0000 T2\u00020\u0001:\u0002UVB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0013\u0010\u0013\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\f\u0010\u0016\u001a\u00020\u0006*\u00020\u0015H\u0002J\f\u0010\u0017\u001a\u00020\u0006*\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\u0016\u0010\u001f\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0012\u0010\"\u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0002J\u0013\u0010&\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u0014J\b\u0010'\u001a\u00020\u0006H\u0002J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020 H\u0002J#\u0010,\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010#2\b\u0010+\u001a\u0004\u0018\u00010 H\u0002\u00a2\u0006\u0004\b,\u0010-J\b\u0010.\u001a\u00020\u0006H\u0002R\u0016\u00101\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R#\u0010@\u001a\n ;*\u0004\u0018\u00010:0:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R#\u0010E\u001a\n ;*\u0004\u0018\u00010A0A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010=\u001a\u0004\bC\u0010DR\u0016\u0010H\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010JR\u0018\u0010Q\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010J\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveTrtcRoomPart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartStart", "onPartResume", "onPartStop", "V9", "gb", "pb", "vb", "", "fb", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "qb", "tb", "Landroid/content/Context;", "context", "ob", "nb", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "prepareResult", "eb", "", "programId", "ab", "", "errCode", "Wa", "Ra", "Sa", "eventId", "sb", "retCode", "desc", "rb", "(Ljava/lang/Long;Ljava/lang/String;)V", "ub", "e", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "room", "Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "f", "Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "liveContext", "Lcom/tencent/mobileqq/qqlive/base/permission/a;", tl.h.F, "Lcom/tencent/mobileqq/qqlive/base/permission/a;", "permissionManager", "Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "Ua", "()Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "prepareViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Va", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", BdhLogUtil.LogTag.Tag_Conn, "Z", "isPushedStream", "D", "Landroid/view/View;", "prepareRootView", "E", "livingRootView", UserInfo.SEX_FEMALE, "prepareToastTip", "G", "obsTitleView", "<init>", "()V", "H", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveTrtcRoomPart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isPushedStream;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View prepareRootView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View livingRootView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View prepareToastTip;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View obsTitleView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqlive.sail.room.d room;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QQLiveContext liveContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.permission.a permissionManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy prepareViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveTrtcRoomPart$a;", "", "", "AUTH_TOAST_DURATION", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/room/QQLiveTrtcRoomPart$b;", "", "", "a", "", "b", "J", "lastClickTime", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f273127a;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static long lastClickTime;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53035);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f273127a = new b();
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public final boolean a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastClickTime <= 2000) {
                z16 = true;
            } else {
                z16 = false;
            }
            lastClickTime = currentTimeMillis;
            return z16;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/room/QQLiveTrtcRoomPart$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f273129a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLiveTrtcRoomPart f273130b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Continuation<? super Boolean> continuation, QQLiveTrtcRoomPart qQLiveTrtcRoomPart) {
            this.f273129a = continuation;
            this.f273130b = qQLiveTrtcRoomPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) continuation, (Object) qQLiveTrtcRoomPart);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            Continuation<Boolean> continuation = this.f273129a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
                return;
            }
            super.onDenied(permissions, results);
            AegisLogger.INSTANCE.w("Open_Live|QQLiveTrtcRoomPart", "checkCameraPermission", "the camera permission was been denied");
            this.f273130b.ba("\u6388\u6743\u5931\u8d25\uff0c\u65e0\u6cd5\u8fdb\u884c\u5f00\u64ad\uff01");
            Continuation<Boolean> continuation = this.f273129a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/room/QQLiveTrtcRoomPart$d", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f273132b;

        d(Context context) {
            this.f273132b = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this, (Object) context);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAllGranted();
            QQLiveTrtcRoomPart.this.sb(QQLiveReportConstants.Event.E_START_LIVE_PERMISSION_CHECKED);
            com.tencent.mobileqq.qqlive.sail.room.l<Integer> L1 = QQLiveTrtcRoomPart.this.Ua().L1(this.f273132b);
            QQLiveTrtcRoomPart qQLiveTrtcRoomPart = QQLiveTrtcRoomPart.this;
            AegisLogger.INSTANCE.i("Open_Live|QQLiveTrtcRoomPart", "onStartLiveClick", "pre check result=" + L1.d());
            Integer d16 = L1.d();
            if (d16 != null && d16.intValue() == 0) {
                qQLiveTrtcRoomPart.nb();
                return;
            }
            if (d16 != null && d16.intValue() == 1) {
                qQLiveTrtcRoomPart.ba(L1.c());
                qQLiveTrtcRoomPart.rb(Long.valueOf(L1.b()), L1.c());
            } else if (d16 != null && d16.intValue() == 2) {
                qQLiveTrtcRoomPart.ea(L1.c());
                qQLiveTrtcRoomPart.rb(Long.valueOf(L1.b()), L1.c());
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) results);
                return;
            }
            super.onDenied(permissions, results);
            QQLiveTrtcRoomPart.this.rb(-1L, "Permission onDenied");
            QQLiveTrtcRoomPart.this.ba("\u6388\u6743\u5931\u8d25");
            AegisLogger.INSTANCE.i("Open_Live|QQLiveTrtcRoomPart", "checkAudioPermission", "the initial permission was been denied");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53070);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveTrtcRoomPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.permissionManager = new com.tencent.mobileqq.qqlive.base.permission.a();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQLivePrepareViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$prepareViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQLivePrepareViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (QQLivePrepareViewModel) QQLiveTrtcRoomPart.this.getViewModel(QQLivePrepareViewModel.class) : (QQLivePrepareViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.prepareViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveTrtcRoomPart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Ra(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        this.permissionManager.b(getHostFragment(), new c(safeContinuation, this));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sa() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.f
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveTrtcRoomPart.Ta(QQLiveTrtcRoomPart.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(QQLiveTrtcRoomPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQLivePrepareViewModel Ua() {
        return (QQLivePrepareViewModel) this.prepareViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomViewModel Va() {
        return (RoomViewModel) this.roomViewModel.getValue();
    }

    private final void Wa(long errCode) {
        Ua().c2(errCode);
        final Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.g
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveTrtcRoomPart.Xa(activity, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xa(Activity nonNullActivity, final QQLiveTrtcRoomPart this$0) {
        Intrinsics.checkNotNullParameter(nonNullActivity, "$nonNullActivity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqlive.widget.verify.l.f274086a.i(nonNullActivity, QQLiveBusinessConfig.f271165b.a(), String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()), new com.tencent.mobileqq.qqlive.widget.verify.g() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.c
            @Override // com.tencent.mobileqq.qqlive.widget.verify.g
            public final void a(int i3, String str) {
                QQLiveTrtcRoomPart.Ya(QQLiveTrtcRoomPart.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ya(QQLiveTrtcRoomPart this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AegisLogger.INSTANCE.e("Open_Live|QQLiveTrtcRoomPart", "handleFaceAuth", "code=" + i3 + ", message=" + str);
        if (i3 == 999) {
            final View view = this$0.prepareToastTip;
            if (view != null) {
                view.setVisibility(0);
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLiveTrtcRoomPart.Za(view);
                    }
                }, 5000L);
                return;
            }
            return;
        }
        LifecycleOwner lifecycleOwner = this$0.getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new QQLiveTrtcRoomPart$handleFaceAuth$1$1$2(this$0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(View this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setVisibility(4);
    }

    private final void ab(final String programId) {
        qg4.e.INSTANCE.e("\u76d1\u6d4b\u5230\u4f60\u5f53\u524d\u6b63\u5728\u76f4\u64ad\u4e2d\uff0c\u70b9\u51fb\u3010\u7acb\u5373\u524d\u5f80\u3011\u53ef\u8fdb\u5165\u76f4\u64ad\u7ba1\u7406\u9875", "\u7acb\u5373\u524d\u5f80", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQLiveTrtcRoomPart.cb(QQLiveTrtcRoomPart.this, dialogInterface, i3);
            }
        }, "\u5173\u95ed\u76f4\u64ad", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQLiveTrtcRoomPart.bb(programId, this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bb(String str, final QQLiveTrtcRoomPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HandleObsCompat.f273110a.a(str, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$handleObsLive$2$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                    return;
                }
                if (z16) {
                    return;
                }
                QQLiveTrtcRoomPart.this.ba("\u5173\u64ad\u5931\u8d25\u4e86\uff0c\u8bf7\u91cd\u8bd5");
                Activity activity = QQLiveTrtcRoomPart.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cb(QQLiveTrtcRoomPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HandleObsCompat.f273110a.b(this$0.obsTitleView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void eb(com.tencent.mobileqq.qqlive.sail.room.l<AnchorRoomInfo> prepareResult) {
        String str;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.w("Open_Live|QQLiveTrtcRoomPart", "handlePrepareError", "retCode=" + prepareResult.b() + ", errMsg=" + prepareResult.c());
        com.tencent.mobileqq.qqlive.room.prepare.i iVar = com.tencent.mobileqq.qqlive.room.prepare.i.f271952a;
        Activity activity = getActivity();
        long b16 = prepareResult.b();
        String c16 = prepareResult.c();
        if (c16 == null) {
            c16 = "";
        }
        if (iVar.b(activity, b16, c16)) {
            return;
        }
        long b17 = prepareResult.b();
        boolean z16 = true;
        if (b17 != 1004 && b17 != 1010) {
            z16 = false;
        }
        if (z16) {
            Wa(prepareResult.b());
            return;
        }
        if (b17 == 10110010) {
            ba("\u5173\u64ad\u5931\u8d25\u4e86\uff0c\u8bf7\u91cd\u8bd5");
            Activity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        if (b17 == 2003) {
            AnchorRoomInfo d16 = prepareResult.d();
            if (d16 != null) {
                str = d16.getProgramId();
            } else {
                str = null;
            }
            ab(str);
            return;
        }
        companion.w("Open_Live|QQLiveTrtcRoomPart", "handlePrepareError", "unknown error code=" + prepareResult.b());
        qg4.e.INSTANCE.e("\u52a0\u8f7d\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5", "\u786e\u5b9a", null, "", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fb(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        QQLiveContext qQLiveContext = this.liveContext;
        if (qQLiveContext == null) {
            Intrinsics.throwUninitializedPropertyAccessException("liveContext");
            qQLiveContext = null;
        }
        com.tencent.mobileqq.qqlive.context.b.c(qQLiveContext, new Function1<QQLiveResponse<LiveLoginInfo>, Unit>(safeContinuation, this) { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$login$2$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Continuation<Boolean> $it;
            final /* synthetic */ QQLiveTrtcRoomPart this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$it = safeContinuation;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) safeContinuation, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveLoginInfo> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<LiveLoginInfo> loginInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) loginInfo);
                    return;
                }
                Intrinsics.checkNotNullParameter(loginInfo, "loginInfo");
                if (loginInfo.isSuccess()) {
                    Continuation<Boolean> continuation2 = this.$it;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                    return;
                }
                AegisLogger.INSTANCE.w("Open_Live|QQLiveTrtcRoomPart", "login", "login fail retCode=" + loginInfo.getRetCode() + ", errMsg=" + loginInfo.getErrMsg());
                this.this$0.ba("\u767b\u5f55\u5931\u8d25\uff0c\u65e0\u6cd5\u8fdb\u884c\u5f00\u64ad\uff01");
                Continuation<Boolean> continuation3 = this.$it;
                Result.Companion companion2 = Result.INSTANCE;
                continuation3.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gb() {
        LiveData<Boolean> Z1 = Va().Z1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$observeViewModel$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                com.tencent.mobileqq.qqlive.sail.room.d dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                dVar = QQLiveTrtcRoomPart.this.room;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("room");
                    dVar = null;
                }
                dVar.switchCamera();
            }
        };
        Z1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveTrtcRoomPart.hb(Function1.this, obj);
            }
        });
        LiveData<Boolean> X1 = Va().X1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$observeViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                com.tencent.mobileqq.qqlive.sail.room.d dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                dVar = QQLiveTrtcRoomPart.this.room;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("room");
                    dVar = null;
                }
                RTCCameraDefine.RTCMirrorType rTCMirrorType = RTCCameraDefine.RTCMirrorType.RTC_ALL_PIPELINE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                dVar.setCameraMirror(rTCMirrorType, it.booleanValue());
            }
        };
        X1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveTrtcRoomPart.ib(Function1.this, obj);
            }
        });
        LiveData<LiveMediaConfig> U1 = Va().U1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<LiveMediaConfig, Unit> function13 = new Function1<LiveMediaConfig, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$observeViewModel$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LiveMediaConfig liveMediaConfig) {
                invoke2(liveMediaConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LiveMediaConfig liveMediaConfig) {
                com.tencent.mobileqq.qqlive.sail.room.d dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) liveMediaConfig);
                    return;
                }
                dVar = QQLiveTrtcRoomPart.this.room;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("room");
                    dVar = null;
                }
                dVar.setVideoQuality(liveMediaConfig.toTRTCVideoQualityParams());
            }
        };
        U1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveTrtcRoomPart.jb(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> W1 = Va().W1();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$observeViewModel$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                com.tencent.mobileqq.qqlive.sail.room.d dVar;
                com.tencent.mobileqq.qqlive.sail.room.d dVar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                com.tencent.mobileqq.qqlive.sail.room.d dVar3 = null;
                if (it.booleanValue()) {
                    dVar2 = QQLiveTrtcRoomPart.this.room;
                    if (dVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("room");
                    } else {
                        dVar3 = dVar2;
                    }
                    dVar3.openMic();
                    return;
                }
                dVar = QQLiveTrtcRoomPart.this.room;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("room");
                } else {
                    dVar3 = dVar;
                }
                dVar3.closeMic();
            }
        };
        W1.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveTrtcRoomPart.kb(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lb(QQLiveTrtcRoomPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        this$0.ob(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mb(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void nb() {
        long j3;
        String str;
        SettingInfo a16;
        com.tencent.mobileqq.qqlive.sail.room.d dVar = this.room;
        com.tencent.mobileqq.qqlive.sail.room.d dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("room");
            dVar = null;
        }
        AnchorRoomInfo b16 = dVar.b();
        if (!(b16 instanceof AnchorRoomInfo)) {
            b16 = null;
        }
        if (b16 != null) {
            SettingInfo r16 = b16.r();
            String value = Ua().U1().getValue();
            if (value == null) {
                value = b16.r().j();
            }
            Intrinsics.checkNotNullExpressionValue(value, "prepareViewModel.roomNam\u2026: it.settingInfo.roomName");
            LocationInfo f16 = b16.r().f();
            RoomCoverInfo value2 = Ua().N1().getValue();
            if (value2 == null) {
                value2 = b16.r().c();
            }
            Intrinsics.checkNotNullExpressionValue(value2, "prepareViewModel.coverIn\u2026 it.settingInfo.coverInfo");
            QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
            if (c16 == null || (str = c16.m()) == null) {
                str = "";
            }
            a16 = r16.a((r24 & 1) != 0 ? r16.roomType : 0, (r24 & 2) != 0 ? r16.roomName : value, (r24 & 4) != 0 ? r16.locationInfo : f16, (r24 & 8) != 0 ? r16.coverInfo : value2, (r24 & 16) != 0 ? r16.enableGif : false, (r24 & 32) != 0 ? r16.streamRecordType : 0, (r24 & 64) != 0 ? r16.styleInfo : null, (r24 & 128) != 0 ? r16.isPrivateLive : false, (r24 & 256) != 0 ? r16.source : str, (r24 & 512) != 0 ? r16.isECGoodsLive : false, (r24 & 1024) != 0 ? r16.openTabLevel : 0);
            com.tencent.mobileqq.qqlive.sail.room.d dVar3 = this.room;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("room");
                dVar3 = null;
            }
            dVar3.B(null, a16);
        }
        long G = com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
        gr4.k value3 = Ua().O1().getValue();
        if (value3 != null) {
            j3 = value3.f403137a;
        } else {
            j3 = 0;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveSetAnchorLabelRequest(G, j3), null);
        com.tencent.mobileqq.qqlive.sail.room.d dVar4 = this.room;
        if (dVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("room");
        } else {
            dVar2 = dVar4;
        }
        dVar2.f(new Function1<com.tencent.mobileqq.qqlive.sail.room.l<Boolean>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$onStartLiveCheckPass$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
            @DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$onStartLiveCheckPass$2$2", f = "QQLiveTrtcRoomPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$onStartLiveCheckPass$2$2, reason: invalid class name */
            /* loaded from: classes17.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                static IPatchRedirector $redirector_;
                int label;
                final /* synthetic */ QQLiveTrtcRoomPart this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(QQLiveTrtcRoomPart qQLiveTrtcRoomPart, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = qQLiveTrtcRoomPart;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveTrtcRoomPart, (Object) continuation);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void b(QQLiveTrtcRoomPart qQLiveTrtcRoomPart) {
                    qQLiveTrtcRoomPart.broadcastMessage("onEnterRoom", null);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
                    }
                    return new AnonymousClass2(this.this$0, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    View view;
                    View view2;
                    com.tencent.mobileqq.qqlive.sail.room.d dVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            AegisLogger.INSTANCE.i("Open_Live|QQLiveTrtcRoomPart", "onStartLiveCheckPass", "go into living mode");
                            this.this$0.isPushedStream = true;
                            view = this.this$0.prepareRootView;
                            if (view != null) {
                                view.setVisibility(8);
                            }
                            view2 = this.this$0.livingRootView;
                            if (view2 != null) {
                                view2.setVisibility(0);
                            }
                            SailAnchorRoomManager d16 = com.tencent.mobileqq.qqlive.sail.c.f272176a.d();
                            dVar = this.this$0.room;
                            if (dVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("room");
                                dVar = null;
                            }
                            d16.w(dVar);
                            final QQLiveTrtcRoomPart qQLiveTrtcRoomPart = this.this$0;
                            qQLiveTrtcRoomPart.runOnActivityUiThread(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0068: INVOKE 
                                  (r4v10 'qQLiveTrtcRoomPart' com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart)
                                  (wrap:java.lang.Runnable:0x0065: CONSTRUCTOR (r4v10 'qQLiveTrtcRoomPart' com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart A[DONT_INLINE]) A[MD:(com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart):void (m), WRAPPED] (LINE:102) call: com.tencent.mobileqq.qqlive.sail.ui.room.n.<init>(com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart):void type: CONSTRUCTOR)
                                 VIRTUAL call: com.tencent.biz.richframework.part.Part.runOnActivityUiThread(java.lang.Runnable):boolean A[MD:(java.lang.Runnable):boolean (m)] (LINE:105) in method: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$onStartLiveCheckPass$2.2.invokeSuspend(java.lang.Object):java.lang.Object, file: classes17.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mobileqq.qqlive.sail.ui.room.n, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 31 more
                                */
                            /*
                                this = this;
                                com.tencent.mobileqq.qfix.redirect.IPatchRedirector r0 = com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$onStartLiveCheckPass$2.AnonymousClass2.$redirector_
                                if (r0 == 0) goto L10
                                r1 = 2
                                boolean r2 = r0.hasPatch(r1)
                                if (r2 == 0) goto L10
                                java.lang.Object r4 = r0.redirect(r1, r3, r4)
                                return r4
                            L10:
                                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r0 = r3.label
                                if (r0 != 0) goto L6e
                                kotlin.ResultKt.throwOnFailure(r4)
                                com.tencent.qqlive.common.api.AegisLogger$Companion r4 = com.tencent.qqlive.common.api.AegisLogger.INSTANCE
                                java.lang.String r0 = "onStartLiveCheckPass"
                                java.lang.String r1 = "go into living mode"
                                java.lang.String r2 = "Open_Live|QQLiveTrtcRoomPart"
                                r4.i(r2, r0, r1)
                                com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart r4 = r3.this$0
                                r0 = 1
                                com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart.Ja(r4, r0)
                                com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart r4 = r3.this$0
                                android.view.View r4 = com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart.za(r4)
                                if (r4 != 0) goto L37
                                goto L3c
                            L37:
                                r0 = 8
                                r4.setVisibility(r0)
                            L3c:
                                com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart r4 = r3.this$0
                                android.view.View r4 = com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart.xa(r4)
                                if (r4 != 0) goto L45
                                goto L49
                            L45:
                                r0 = 0
                                r4.setVisibility(r0)
                            L49:
                                com.tencent.mobileqq.qqlive.sail.c r4 = com.tencent.mobileqq.qqlive.sail.c.f272176a
                                com.tencent.mobileqq.qqlive.sail.SailAnchorRoomManager r4 = r4.d()
                                com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart r0 = r3.this$0
                                com.tencent.mobileqq.qqlive.sail.room.d r0 = com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart.Ba(r0)
                                if (r0 != 0) goto L5e
                                java.lang.String r0 = "room"
                                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                                r0 = 0
                            L5e:
                                r4.w(r0)
                                com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart r4 = r3.this$0
                                com.tencent.mobileqq.qqlive.sail.ui.room.n r0 = new com.tencent.mobileqq.qqlive.sail.ui.room.n
                                r0.<init>(r4)
                                r4.runOnActivityUiThread(r0)
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            L6e:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r0)
                                throw r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$onStartLiveCheckPass$2.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.sail.room.l<Boolean> lVar) {
                        invoke2(lVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull com.tencent.mobileqq.qqlive.sail.room.l<Boolean> it) {
                        com.tencent.mobileqq.qqlive.sail.room.d dVar5;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(it, "it");
                        AegisLogger.INSTANCE.i("Open_Live|QQLiveTrtcRoomPart", "onStartLiveCheckPass", "pushStream result: " + it);
                        com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>(it) { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$onStartLiveCheckPass$2.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ com.tencent.mobileqq.qqlive.sail.room.l<Boolean> $it;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                                this.$it = it;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this, (Object) it);
                                }
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            @Nullable
                            public final QQLiveQualityReportData.Builder invoke() {
                                QQLiveContext qQLiveContext;
                                com.tencent.mobileqq.qqlive.sail.room.d dVar6;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (QQLiveQualityReportData.Builder) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                com.tencent.mobileqq.qqlive.sail.room.d dVar7 = null;
                                QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                                qQLiveContext = QQLiveTrtcRoomPart.this.liveContext;
                                if (qQLiveContext == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("liveContext");
                                    qQLiveContext = null;
                                }
                                QQLiveQualityReportData.Builder eventId = builder.traceId(qQLiveContext.n()).eventId(QQLiveReportConstants.Event.E_ANCHOR_PUBLISH_STREAM);
                                dVar6 = QQLiveTrtcRoomPart.this.room;
                                if (dVar6 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("room");
                                } else {
                                    dVar7 = dVar6;
                                }
                                return eventId.roomId(String.valueOf(dVar7.getRoomId())).retCode(String.valueOf(this.$it.b()));
                            }
                        });
                        QQLiveTrtcRoomPart.this.sb(QQLiveReportConstants.Event.E_SUCCESS_START_LIVE);
                        dVar5 = QQLiveTrtcRoomPart.this.room;
                        if (dVar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("room");
                            dVar5 = null;
                        }
                        tk4.a.a(dVar5.getVideoQuality(), QQLiveReportConstants.Event.E_ANCHOR_START_PUSH_ENCODE_PARAMS);
                        if (it.b() != 0) {
                            QQLiveTrtcRoomPart.this.ba(it.c());
                            return;
                        }
                        LifecycleOwner lifecycleOwner = QQLiveTrtcRoomPart.this.getPartHost().getLifecycleOwner();
                        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new AnonymousClass2(QQLiveTrtcRoomPart.this, null), 3, null);
                    }
                });
            }

            private final void ob(Context context) {
                if (b.f273127a.a()) {
                    AegisLogger.INSTANCE.i("Open_Live|QQLiveTrtcRoomPart", "Double Click");
                } else {
                    sb(QQLiveReportConstants.Event.E_BEGIN_START_LIVE);
                    this.permissionManager.a(getHostFragment(), new d(context));
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void pb() {
                LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new QQLiveTrtcRoomPart$prepare$1(this, null), 3, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void qb(com.tencent.mobileqq.qqlive.sail.room.d dVar) {
                dVar.t(null, new QQLiveTrtcRoomPart$prepareRoom$1(this, dVar));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void rb(Long retCode, String desc) {
                String str;
                AegisLogger.INSTANCE.e("Open_Live|QQLiveTrtcRoomPart", "startLiveFailReportReason", "retCode=" + retCode + ", desc=" + desc);
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                if (c16 != null) {
                    IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
                    QQLiveQualityReportData.Builder traceId = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).traceId(c16.n());
                    if (retCode != null) {
                        str = retCode.toString();
                    } else {
                        str = null;
                    }
                    iQQLiveReportApi.qualityReport(traceId.retCode(str).desc(desc).eventId(QQLiveReportConstants.Event.E_BEFORE_START_LIVE_FAIL_REASON).ext6(QQLiveReportConstants.Scene.SCENE_START_ANCHOR_LIVE));
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void sb(String eventId) {
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                if (c16 != null) {
                    ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).qualityReport(new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null).traceId(c16.n()).eventId(eventId).ext6(QQLiveReportConstants.Scene.SCENE_START_ANCHOR_LIVE).ext7(String.valueOf(System.currentTimeMillis())));
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void tb(com.tencent.mobileqq.qqlive.sail.room.d dVar) {
                dVar.v(new QQLiveTrtcRoomPart$startRoom$1(this));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void ub() {
                boolean a16;
                com.tencent.mobileqq.qqlive.sail.room.d dVar = this.room;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("room");
                    dVar = null;
                }
                AvConfig n3 = dVar.b().n();
                com.tencent.mobileqq.qqlive.sail.room.d dVar2 = this.room;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("room");
                    dVar2 = null;
                }
                boolean j3 = n3.j();
                RoomViewModel.Companion companion = RoomViewModel.INSTANCE;
                if (companion.b()) {
                    a16 = companion.c();
                } else {
                    a16 = companion.a();
                }
                dVar2.B(new AvConfig(j3, a16, n3.f(), n3.k(), n3.g(), n3.c()), null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void vb() {
                if (ht3.a.e("qqlive_trtc_qos_smooth_mode", false)) {
                    AegisLogger.INSTANCE.i("Open_Live|QQLiveTrtcRoomPart", "updateCustomTrtcConfig", "set qos preference to QQLIVE_TRTC_QOS_SMOOTH_MODE");
                    com.tencent.mobileqq.qqlive.sail.room.d dVar = this.room;
                    if (dVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("room");
                        dVar = null;
                    }
                    dVar.c(new com.tencent.mobileqq.qqlive.trtc.encoder.a(1));
                }
            }

            @Override // com.tencent.mobileqq.qqlive.sail.base.c
            public void V9() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    iPatchRedirector.redirect((short) 7, (Object) this);
                    return;
                }
                super.V9();
                AegisLogger.INSTANCE.i("Open_Live|QQLiveTrtcRoomPart", "onCloseRoom");
                if (this.isPushedStream) {
                    com.tencent.mobileqq.qqlive.report.h.c(QQLiveBusinessConfig.QQLIVE_APP_ID, QQLiveReportConstants.Event.E_EXIT_LIVE, QQLiveReportConstants.Scene.SCENE_START_ANCHOR_LIVE, null);
                    com.tencent.mobileqq.qqlive.report.h.b(new Function0<QQLiveQualityReportData.Builder>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$onExitRoom$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveTrtcRoomPart.this);
                            }
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @Nullable
                        public final QQLiveQualityReportData.Builder invoke() {
                            QQLiveContext qQLiveContext;
                            com.tencent.mobileqq.qqlive.sail.room.d dVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (QQLiveQualityReportData.Builder) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            com.tencent.mobileqq.qqlive.sail.room.d dVar2 = null;
                            QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
                            qQLiveContext = QQLiveTrtcRoomPart.this.liveContext;
                            if (qQLiveContext == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("liveContext");
                                qQLiveContext = null;
                            }
                            QQLiveQualityReportData.Builder eventId = builder.traceId(qQLiveContext.n()).eventId(QQLiveReportConstants.Event.E_ANCHOR_EXIT_ROOM_RESULT);
                            dVar = QQLiveTrtcRoomPart.this.room;
                            if (dVar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("room");
                            } else {
                                dVar2 = dVar;
                            }
                            return eventId.roomId(String.valueOf(dVar2.getRoomId())).ext6(QQLiveReportConstants.Scene.SCENE_START_ANCHOR_LIVE);
                        }
                    });
                }
                this.isPushedStream = false;
            }

            @Override // com.tencent.biz.richframework.part.Part
            public void onInitView(@Nullable View rootView) {
                View view;
                View view2;
                View view3;
                View view4;
                final View findViewById;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
                    return;
                }
                View view5 = null;
                if (rootView != null) {
                    view = rootView.findViewById(R.id.f61352xw);
                } else {
                    view = null;
                }
                if (view != null) {
                    view.setVisibility(8);
                }
                if (rootView != null && (findViewById = rootView.findViewById(R.id.f60922wq)) != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view6) {
                            QQLiveTrtcRoomPart.lb(QQLiveTrtcRoomPart.this, view6);
                        }
                    });
                    MutableLiveData<Boolean> W1 = Ua().W1();
                    LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
                    final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>(findViewById, this) { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.QQLiveTrtcRoomPart$onInitView$1$2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ View $this_apply;
                        final /* synthetic */ QQLiveTrtcRoomPart this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            this.$this_apply = findViewById;
                            this.this$0 = this;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) findViewById, (Object) this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke2(bool);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Boolean it) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                                return;
                            }
                            View view6 = this.$this_apply;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            view6.setEnabled(it.booleanValue() && this.this$0.Ua().X1());
                        }
                    };
                    W1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.e
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            QQLiveTrtcRoomPart.mb(Function1.this, obj);
                        }
                    });
                }
                if (rootView != null) {
                    view2 = rootView.findViewById(R.id.f61372xy);
                } else {
                    view2 = null;
                }
                this.prepareRootView = view2;
                if (rootView != null) {
                    view3 = rootView.findViewById(R.id.f639134t);
                } else {
                    view3 = null;
                }
                this.prepareToastTip = view3;
                if (rootView != null) {
                    view4 = rootView.findViewById(R.id.f61062x4);
                } else {
                    view4 = null;
                }
                this.livingRootView = view4;
                if (rootView != null) {
                    view5 = rootView.findViewById(R.id.f61392y0);
                }
                this.obsTitleView = view5;
                pb();
            }

            @Override // com.tencent.biz.richframework.part.Part
            public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
                    return;
                }
                QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
                if (c16 == null) {
                    AegisLogger.INSTANCE.i("Open_Live|QQLiveTrtcRoomPart", "onCreate", "liveContext is null");
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                this.liveContext = c16;
                com.tencent.mobileqq.qqlive.sail.room.f F9 = F9();
                Intrinsics.checkNotNull(F9, "null cannot be cast to non-null type com.tencent.mobileqq.qqlive.sail.room.ILiveAnchorTrtcRoom");
                this.room = (com.tencent.mobileqq.qqlive.sail.room.d) F9;
            }

            @Override // com.tencent.biz.richframework.part.Part
            public void onPartResume(@Nullable Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
                    return;
                }
                super.onPartResume(activity);
                com.tencent.mobileqq.qqlive.sail.room.d dVar = this.room;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("room");
                    dVar = null;
                }
                dVar.resume();
            }

            @Override // com.tencent.biz.richframework.part.Part
            public void onPartStart(@Nullable Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
                    return;
                }
                super.onPartStart(activity);
                com.tencent.mobileqq.qqlive.sail.room.d dVar = this.room;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("room");
                    dVar = null;
                }
                dVar.v(QQLiveTrtcRoomPart$onPartStart$1.INSTANCE);
            }

            @Override // com.tencent.biz.richframework.part.Part
            public void onPartStop(@Nullable Activity activity) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
                    return;
                }
                super.onPartStop(activity);
                com.tencent.mobileqq.qqlive.sail.room.d dVar = this.room;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("room");
                    dVar = null;
                }
                dVar.pause();
            }
        }
