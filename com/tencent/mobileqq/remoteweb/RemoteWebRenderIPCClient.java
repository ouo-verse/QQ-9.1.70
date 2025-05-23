package com.tencent.mobileqq.remoteweb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.log.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.remoteweb.view.RemoteRenderViewBuilder;
import com.tencent.mobileqq.remoteweb.view.b;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.UiThreadUtil;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001L\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002]^B\u000f\u0012\u0006\u0010Z\u001a\u00020\u0002\u00a2\u0006\u0004\b[\u0010\\J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J,\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010!\u001a\u00020\bH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\bH\u0002J\u0006\u0010$\u001a\u00020\u000bJ \u0010'\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00062\b\b\u0002\u0010&\u001a\u00020\u0002J$\u0010+\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,2\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\bJ\u000e\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200J\u0016\u00105\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u00104\u001a\u000203J$\u00106\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u00107\u001a\u00020\bJ>\u0010=\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00022\b\u00109\u001a\u0004\u0018\u0001082\b\b\u0002\u0010:\u001a\u00020\u00062\b\b\u0002\u0010;\u001a\u00020\u00062\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010<J\u000e\u0010>\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0002J\u0010\u0010@\u001a\u0004\u0018\u00010?2\u0006\u0010\u0014\u001a\u00020\u0002R\u0016\u0010B\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010\u0018R\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER$\u0010K\u001a\u0002002\u0006\u0010G\u001a\u0002008\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bH\u0010\u000f\u001a\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR \u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020?0P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR \u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020T0P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010RR\u0014\u0010Y\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010X\u00a8\u0006_"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCClient;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "action", "Landroid/os/Bundle;", "ipcBundle", "", "callbackId", "", "r", "data", "", "O", "Lcom/tencent/mobileqq/webview/swift/utils/m$a;", "callback", "J", "params", "D", "Leipc/EIPCResult;", "B", "webPageId", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, "E", "I", "G", BdhLogUtil.LogTag.Tag_Conn, "w", "v", HippyTKDListViewAdapter.X, "module", "Leipc/EIPCResultCallback;", ReportConstant.COSTREPORT_PREFIX, "Y", "a0", "d0", "M", "code", "msg", "P", "Lcom/tencent/mobileqq/remoteweb/RemoteWebViewEvent;", "event", "extra", ExifInterface.LATITUDE_SOUTH, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "W", "e0", "", "time", "N", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "type", "Z", "onCall", "register", "Landroid/view/Surface;", "surface", "width", "height", "Lkotlin/Function0;", "g0", "u", "Lcom/tencent/mobileqq/remoteweb/view/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "d", "heartBeatIndex", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "handler", "<set-?>", "f", "getWebRenderStartTime", "()J", "webRenderStartTime", "com/tencent/mobileqq/remoteweb/RemoteWebRenderIPCClient$heartBeatRunnable$1", tl.h.F, "Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCClient$heartBeatRunnable$1;", "heartBeatRunnable", "Ljava/util/concurrent/ConcurrentHashMap;", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "webRenderHolderMap", "Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCClient$WebRenderState;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "webReaderStateMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRegistered", "name", "<init>", "(Ljava/lang/String;)V", "a", "WebRenderState", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes18.dex */
public final class RemoteWebRenderIPCClient extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Lazy<RemoteWebRenderIPCClient> E;

    @Nullable
    private static Activity F;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRegistered;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int heartBeatIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long webRenderStartTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RemoteWebRenderIPCClient$heartBeatRunnable$1 heartBeatRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, com.tencent.mobileqq.remoteweb.view.b> webRenderHolderMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, WebRenderState> webReaderStateMap;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCClient$WebRenderState;", "", "(Ljava/lang/String;I)V", com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, "WAIT_FOR_X5", "SUCCESS", "DESTROY", "webview_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class WebRenderState {
        private static final /* synthetic */ WebRenderState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final WebRenderState DESTROY;
        public static final WebRenderState INIT;
        public static final WebRenderState SUCCESS;
        public static final WebRenderState WAIT_FOR_X5;

        private static final /* synthetic */ WebRenderState[] $values() {
            return new WebRenderState[]{INIT, WAIT_FOR_X5, SUCCESS, DESTROY};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39442);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            INIT = new WebRenderState(com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, 0);
            WAIT_FOR_X5 = new WebRenderState("WAIT_FOR_X5", 1);
            SUCCESS = new WebRenderState("SUCCESS", 2);
            DESTROY = new WebRenderState("DESTROY", 3);
            $VALUES = $values();
        }

        WebRenderState(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static WebRenderState valueOf(String str) {
            return (WebRenderState) Enum.valueOf(WebRenderState.class, str);
        }

        public static WebRenderState[] values() {
            return (WebRenderState[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCClient$a;", "", "Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCClient;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCClient;", "sInstance", "Landroid/app/Activity;", "sActivity", "Landroid/app/Activity;", "b", "()Landroid/app/Activity;", "setSActivity", "(Landroid/app/Activity;)V", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        private final RemoteWebRenderIPCClient c() {
            return (RemoteWebRenderIPCClient) RemoteWebRenderIPCClient.E.getValue();
        }

        @JvmStatic
        @NotNull
        public final RemoteWebRenderIPCClient a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RemoteWebRenderIPCClient) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return c();
        }

        @Nullable
        public final Activity b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return RemoteWebRenderIPCClient.F;
            }
            return (Activity) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f281134a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39453);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[WebRenderState.values().length];
            try {
                iArr[WebRenderState.DESTROY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WebRenderState.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f281134a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/remoteweb/RemoteWebRenderIPCClient$c", "Leipc/EIPCOnGetConnectionListener;", "Leipc/EIPCConnection;", "conn", "", "onConnectBind", "onConnectUnbind", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements EIPCOnGetConnectionListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(@Nullable EIPCConnection conn) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) conn);
                return;
            }
            a.InterfaceC7984a a16 = com.tencent.mobileqq.log.a.f241755a.a();
            if (conn != null) {
                str = conn.procName;
            } else {
                str = null;
            }
            a16.d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[onConnectBind] procName: " + str);
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(@Nullable EIPCConnection conn) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) conn);
                return;
            }
            a.InterfaceC7984a a16 = com.tencent.mobileqq.log.a.f241755a.a();
            if (conn != null) {
                str = conn.procName;
            } else {
                str = null;
            }
            a16.d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[onConnectUnbind] procName: " + str);
        }
    }

    static {
        Lazy<RemoteWebRenderIPCClient> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39503);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) RemoteWebRenderIPCClient$Companion$sInstance$2.INSTANCE);
        E = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient$heartBeatRunnable$1] */
    public RemoteWebRenderIPCClient(@NotNull String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) name);
            return;
        }
        this.handler = new Handler(Looper.getMainLooper());
        this.heartBeatRunnable = new Runnable() { // from class: com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient$heartBeatRunnable$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RemoteWebRenderIPCClient.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Handler handler;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    RemoteWebRenderIPCClient.this.Y();
                    handler = RemoteWebRenderIPCClient.this.handler;
                    handler.postDelayed(this, 30000L);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        };
        this.webRenderHolderMap = new ConcurrentHashMap<>();
        this.webReaderStateMap = new ConcurrentHashMap<>();
        this.isRegistered = new AtomicBoolean(false);
    }

    private final int A(String webPageId) {
        boolean z16;
        int i3;
        if (webPageId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return -1000;
        }
        if (!this.webReaderStateMap.containsKey(webPageId)) {
            return -1002;
        }
        WebRenderState webRenderState = this.webReaderStateMap.get(webPageId);
        if (webRenderState == null) {
            i3 = -1;
        } else {
            i3 = b.f281134a[webRenderState.ordinal()];
        }
        if (i3 != 1) {
            if (i3 == 2) {
                return 0;
            }
            return -1004;
        }
        return -1003;
    }

    private final EIPCResult B(Bundle params) {
        String str;
        int A;
        if (params == null || (str = params.getString("key_web_page_id")) == null) {
            str = "";
        }
        if (u(str)) {
            A = 0;
        } else {
            A = A(str);
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[handleCheckIfWebPageAttach] pageId: " + str + ", result " + A);
        EIPCResult createResult = EIPCResult.createResult(A, new Bundle());
        Intrinsics.checkNotNullExpressionValue(createResult, "createResult(code, Bundle())");
        return createResult;
    }

    private final void C(Bundle params, int callbackId) {
        String string = params.getString("key_web_page_id");
        if (string == null) {
            string = "";
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "handleDestroyWebView webPageId: " + string);
        this.webReaderStateMap.put(string, WebRenderState.DESTROY);
        if (this.webRenderHolderMap.containsKey(string)) {
            com.tencent.mobileqq.remoteweb.view.b bVar = this.webRenderHolderMap.get(string);
            if (bVar != null) {
                bVar.dismiss();
            }
            this.webRenderHolderMap.remove(string);
            e0();
        }
        callbackResult(callbackId, EIPCResult.createResult(0, new Bundle()));
    }

    private final void D(Bundle params, int callbackId) {
        int i3;
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[handleLoadUrl] ");
        String string = params.getString("key_web_page_id");
        String str = "";
        if (string == null) {
            string = "";
        }
        String string2 = params.getString("key_remote_web_url");
        if (string2 != null) {
            str = string2;
        }
        if (u(string)) {
            com.tencent.mobileqq.remoteweb.view.b bVar = this.webRenderHolderMap.get(string);
            if (bVar != null) {
                bVar.a(str, params);
            }
            i3 = 0;
        } else {
            i3 = -1002;
        }
        callbackResult(callbackId, EIPCResult.createResult(i3, new Bundle()));
    }

    private final void E(Bundle params, int callbackId) {
        RemoteBusinessEvent remoteBusinessEvent;
        if (params.containsKey("key_app_foreground") && params.containsKey("key_web_page_id")) {
            String string = params.getString("key_web_page_id");
            if (string == null) {
                string = "";
            }
            if (params.getBoolean("key_app_foreground")) {
                remoteBusinessEvent = RemoteBusinessEvent.ON_RESUME;
            } else {
                remoteBusinessEvent = RemoteBusinessEvent.ON_PAUSE;
            }
            com.tencent.mobileqq.remoteweb.view.b bVar = this.webRenderHolderMap.get(string);
            if (bVar != null) {
                b.a.a(bVar, remoteBusinessEvent, null, 2, null);
            }
            callbackResult(callbackId, EIPCResult.createResult(0, new Bundle()));
            return;
        }
        callbackResult(callbackId, EIPCResult.createResult(-1000, new Bundle()));
    }

    private final void F(Bundle params, int callbackId) {
        if (params.containsKey("key_web_view_width") && params.containsKey("key_web_view_height") && params.containsKey("key_web_page_id")) {
            String string = params.getString("key_web_page_id");
            if (string == null) {
                string = "";
            }
            int i3 = params.getInt("key_web_view_width");
            int i16 = params.getInt("key_web_view_height");
            com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[handleResizeWeb] width " + i3 + ", height " + i16);
            com.tencent.mobileqq.remoteweb.view.b bVar = this.webRenderHolderMap.get(string);
            if (bVar != null) {
                bVar.c(i3, i16);
            }
            callbackResult(callbackId, EIPCResult.createResult(0, new Bundle()));
            return;
        }
        callbackResult(callbackId, EIPCResult.createResult(-1000, new Bundle()));
    }

    private final void G(Bundle params, int callbackId) {
        final MotionEvent motionEvent;
        final String string = params.getString("key_web_page_id");
        if (string == null) {
            string = "";
        }
        Parcelable parcelable = params.getParcelable("key_surface_touch_event");
        if (parcelable instanceof MotionEvent) {
            motionEvent = (MotionEvent) parcelable;
        } else {
            motionEvent = null;
        }
        if (motionEvent != null) {
            this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.h
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteWebRenderIPCClient.H(RemoteWebRenderIPCClient.this, string, motionEvent);
                }
            });
            callbackResult(callbackId, EIPCResult.createResult(0, new Bundle()));
        } else {
            callbackResult(callbackId, EIPCResult.createResult(-1000, new Bundle()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(RemoteWebRenderIPCClient this$0, String webPageId, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(webPageId, "$webPageId");
        com.tencent.mobileqq.remoteweb.view.b bVar = this$0.webRenderHolderMap.get(webPageId);
        if (bVar != null) {
            bVar.dispatchTouchEvent(motionEvent);
        }
    }

    private final void I(Bundle params, final int callbackId) {
        Surface surface;
        boolean z16;
        String string = params.getString("key_web_page_id");
        if (string == null) {
            string = "";
        }
        String str = string;
        if (params.containsKey("key_surface")) {
            surface = (Surface) params.getParcelable("key_surface");
        } else {
            surface = null;
        }
        int i3 = params.getInt("key_web_view_width");
        int i16 = params.getInt("key_web_view_height");
        a.InterfaceC7984a a16 = com.tencent.mobileqq.log.a.f241755a.a();
        if (surface != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        a16.d("RemoteWeb.RemoteWebRenderIPCClient", 1, "handleUpdateSurface webPageId " + str + ",  newSurface " + z16);
        if (u(str)) {
            g0(str, surface, i3, i16, new Function0<Unit>(callbackId) { // from class: com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient$handleUpdateSurface$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $callbackId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callbackId = callbackId;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) RemoteWebRenderIPCClient.this, callbackId);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        RemoteWebRenderIPCClient.this.callbackResult(this.$callbackId, EIPCResult.createResult(0, new Bundle()));
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                }
            });
            return;
        }
        a.b bVar = new a.b();
        String str2 = "handleUpdateSurface currentRemoteView is null,  webPageId " + str;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCClient", 1, (String) it.next(), null);
        }
        callbackResult(callbackId, EIPCResult.createResult(-2, new Bundle()));
    }

    private final void J(final m.a callback) {
        boolean e16 = com.tencent.mobileqq.webview.swift.utils.m.e();
        boolean f16 = com.tencent.mobileqq.webview.swift.utils.m.f();
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        aVar.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[initX5Tbs] hasInitDone: " + e16 + " hasInitStarted " + f16);
        if (!e16) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (com.tencent.mobileqq.webview.swift.utils.m.f()) {
                aVar.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[initX5Tbs] wait for initAsync");
                com.tencent.mobileqq.webview.swift.utils.m.h(new m.a() { // from class: com.tencent.mobileqq.remoteweb.g
                    @Override // com.tencent.mobileqq.webview.swift.utils.m.a
                    public final void a() {
                        RemoteWebRenderIPCClient.K(currentTimeMillis, callback);
                    }
                });
                return;
            }
            aVar.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[initX5Tbs] init start!");
            com.tencent.mobileqq.webview.swift.utils.m.g();
            aVar.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[initX5Tbs] init done " + (System.currentTimeMillis() - currentTimeMillis));
            callback.a();
            return;
        }
        callback.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(long j3, final m.a callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[initX5Tbs] initAsync done " + (System.currentTimeMillis() - j3));
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.i
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCClient.L(m.a.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(m.a callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.a();
    }

    private final boolean O(Bundle data) {
        String str = "";
        String string = data.getString("key_remote_view_type", "");
        if (string != null) {
            str = string;
        }
        return !Intrinsics.areEqual(str, "NativeTencentDoc");
    }

    public static /* synthetic */ void Q(RemoteWebRenderIPCClient remoteWebRenderIPCClient, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        remoteWebRenderIPCClient.P(str, i3, str2);
    }

    public static /* synthetic */ void T(RemoteWebRenderIPCClient remoteWebRenderIPCClient, String str, RemoteWebViewEvent remoteWebViewEvent, Bundle bundle, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bundle = null;
        }
        remoteWebRenderIPCClient.S(str, remoteWebViewEvent, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(RemoteWebRenderIPCClient this$0, Bundle ipcBundle, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ipcBundle, "$ipcBundle");
        this$0.C(ipcBundle, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(RemoteWebRenderIPCClient this$0, String str, Bundle ipcBundle, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ipcBundle, "$ipcBundle");
        this$0.r(str, ipcBundle, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(RemoteWebRenderIPCClient this$0, Bundle data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[prepareCreateRemoteView] initX5 Finish");
        this$0.w(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        Bundle bundle = new Bundle();
        int i3 = this.heartBeatIndex;
        this.heartBeatIndex = i3 + 1;
        bundle.putInt("key_heart_beat_index", i3);
        bundle.putLong("key_time_start_time", System.currentTimeMillis());
        s("WebRemoteRenderIPCServer", "action_server_send_heart_beat", bundle, null);
    }

    private final void a0(Bundle data) {
        final Context applicationContext = BaseApplication.getContext().getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        boolean containsKey = data.containsKey("key_remote_service_type");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "startRemoteForegroundService enableService " + containsKey);
        if (!containsKey) {
            return;
        }
        final Intent intent = new Intent(applicationContext, (Class<?>) PreloadWebService.class);
        intent.putExtra("key_enable_remote_web_render", true);
        intent.putExtras(data);
        final String string = data.getString("key_web_page_id");
        if (string == null) {
            a.b bVar = new a.b();
            bVar.a().add("[startRemoteForegroundService] webPageId not exit!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCClient", 1, (String) it.next(), null);
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.j
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCClient.b0(applicationContext, this, string, intent);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(final Context appContext, final RemoteWebRenderIPCClient this$0, final String webPageId, final Intent serviceIntent) {
        Intrinsics.checkNotNullParameter(appContext, "$appContext");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(webPageId, "$webPageId");
        Intrinsics.checkNotNullParameter(serviceIntent, "$serviceIntent");
        final boolean a16 = ac.f281144a.a(appContext);
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[startRemoteForegroundService] isServiceRunning " + a16);
        this$0.handler.post(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.k
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCClient.c0(a16, this$0, webPageId, appContext, serviceIntent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(boolean z16, RemoteWebRenderIPCClient this$0, String webPageId, Context appContext, Intent serviceIntent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(webPageId, "$webPageId");
        Intrinsics.checkNotNullParameter(appContext, "$appContext");
        Intrinsics.checkNotNullParameter(serviceIntent, "$serviceIntent");
        if (z16) {
            this$0.d0();
        }
        if (this$0.v(webPageId)) {
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            a.b bVar = new a.b();
            String str = "[startRemoteForegroundService] webPageId " + webPageId + " has been destroyed!";
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCClient", 1, (String) it.next(), null);
            }
            Q(this$0, webPageId, -1003, null, 4, null);
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "startForegroundService ");
        appContext.startService(serviceIntent);
    }

    private final void d0() {
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "stopRemoteForegroundService");
        Context applicationContext = BaseApplication.getContext().getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        applicationContext.stopService(new Intent(applicationContext, (Class<?>) PreloadWebService.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(RemoteWebRenderIPCClient this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.webRenderHolderMap.isEmpty()) {
            this$0.x();
        }
    }

    public static /* synthetic */ void h0(RemoteWebRenderIPCClient remoteWebRenderIPCClient, String str, Surface surface, int i3, int i16, Function0 function0, int i17, Object obj) {
        int i18;
        int i19;
        if ((i17 & 4) != 0) {
            i18 = 0;
        } else {
            i18 = i3;
        }
        if ((i17 & 8) != 0) {
            i19 = 0;
        } else {
            i19 = i16;
        }
        if ((i17 & 16) != 0) {
            function0 = null;
        }
        remoteWebRenderIPCClient.g0(str, surface, i18, i19, function0);
    }

    private final void r(String action, Bundle ipcBundle, int callbackId) {
        String string = ipcBundle.getString("key_web_page_id");
        if (string == null) {
            string = "";
        }
        int A = A(string);
        if (A != 0) {
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            a.b bVar = new a.b();
            String str = "[checkParamWhenIPCCall] error " + A;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCClient", 1, (String) it.next(), null);
            }
            callbackResult(callbackId, EIPCResult.createResult(A, new Bundle()));
            return;
        }
        if (action != null) {
            switch (action.hashCode()) {
                case -1896836894:
                    if (action.equals("action_client_update_surface")) {
                        I(ipcBundle, callbackId);
                        return;
                    }
                    return;
                case -962539391:
                    if (action.equals("action_client_load_url")) {
                        D(ipcBundle, callbackId);
                        return;
                    }
                    return;
                case -847038784:
                    if (action.equals("action_client_dispatch_touch_event")) {
                        G(ipcBundle, callbackId);
                        return;
                    }
                    return;
                case -340284118:
                    if (action.equals("action_client_notify_web_resize")) {
                        F(ipcBundle, callbackId);
                        return;
                    }
                    return;
                case -17674804:
                    if (action.equals("action_client_notify_app_foreground")) {
                        E(ipcBundle, callbackId);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void s(final String module, final String action, final Bundle params, final EIPCResultCallback callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.d
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCClient.t(module, action, params, callback);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(String module, String action, Bundle bundle, EIPCResultCallback eIPCResultCallback) {
        Intrinsics.checkNotNullParameter(module, "$module");
        Intrinsics.checkNotNullParameter(action, "$action");
        QIPCClientHelper.getInstance().callServer(module, action, bundle, eIPCResultCallback);
    }

    private final boolean v(String webPageId) {
        boolean z16;
        WebRenderState webRenderState = this.webReaderStateMap.get(webPageId);
        if (webRenderState == null) {
            webRenderState = WebRenderState.INIT;
        }
        Intrinsics.checkNotNullExpressionValue(webRenderState, "webReaderStateMap[webPag\u2026d] ?: WebRenderState.INIT");
        if (webRenderState == WebRenderState.DESTROY) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[checkIfWebPageDestroy] webPageId " + webPageId + ", state " + webRenderState + ", isDestroy " + z16);
        return z16;
    }

    private final void w(Bundle data) {
        com.tencent.mobileqq.remoteweb.view.b bVar;
        String string = data.getString("key_web_page_id");
        if (string == null) {
            return;
        }
        if (v(string)) {
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            a.b bVar2 = new a.b();
            String str = "[prepareCreateRemoteView] webPageId " + string + " has destroyed!";
            if (str instanceof String) {
                bVar2.a().add(str);
            }
            Iterator<T> it = bVar2.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCClient", 1, (String) it.next(), null);
            }
            Q(this, string, -1003, null, 4, null);
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "doCreateRemoteView webPageId " + string);
        Activity activity = F;
        if (activity == null) {
            return;
        }
        if (!data.getBoolean("key_enable_multi_display", false)) {
            Iterator<Map.Entry<String, com.tencent.mobileqq.remoteweb.view.b>> it5 = this.webRenderHolderMap.entrySet().iterator();
            while (it5.hasNext()) {
                it5.next().getValue().dismiss();
            }
            this.webRenderHolderMap.clear();
        }
        if (u(string) && (bVar = this.webRenderHolderMap.get(string)) != null) {
            bVar.dismiss();
        }
        RemoteRenderViewBuilder remoteRenderViewBuilder = RemoteRenderViewBuilder.f281216a;
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "activity.applicationContext");
        com.tencent.mobileqq.remoteweb.view.b d16 = remoteRenderViewBuilder.d(applicationContext, data);
        this.webRenderHolderMap.put(string, d16);
        d16.init();
        String str2 = "";
        String string2 = data.getString("key_remote_web_url", "");
        if (string2 != null) {
            str2 = string2;
        }
        d16.a(str2, data);
        d16.show();
        this.webReaderStateMap.put(string, WebRenderState.SUCCESS);
        a0(data);
    }

    private final void x() {
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "doReleaseAll");
        d0();
        this.handler.removeCallbacksAndMessages(null);
        this.webRenderHolderMap.clear();
        F = null;
    }

    @JvmStatic
    @NotNull
    public static final RemoteWebRenderIPCClient y() {
        return INSTANCE.a();
    }

    public final boolean M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (F != null || (!this.webRenderHolderMap.isEmpty())) {
            return true;
        }
        return false;
    }

    public final void N(long time) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, time);
            return;
        }
        if (time <= 0) {
            time = System.currentTimeMillis();
        }
        this.webRenderStartTime = time;
    }

    public final void P(@NotNull String webPageId, int code, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, webPageId, Integer.valueOf(code), msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        a.b bVar = new a.b();
        String str = "notifyError code " + code + ", msg " + msg2;
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCClient", 1, (String) it.next(), null);
        }
        if (code == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_web_page_id", webPageId);
        bundle.putInt("key_error_code", code);
        bundle.putString("key_error_msg", msg2);
        s("WebRemoteRenderIPCServer", "action_server_notify_error_code", bundle, null);
    }

    @JvmOverloads
    public final void R(@NotNull String webPageId, @NotNull RemoteWebViewEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) webPageId, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(event, "event");
        T(this, webPageId, event, null, 4, null);
    }

    @JvmOverloads
    public final void S(@NotNull String webPageId, @NotNull RemoteWebViewEvent event, @Nullable Bundle extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, webPageId, event, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(event, "event");
        Bundle bundle = new Bundle();
        bundle.putString("key_web_page_id", webPageId);
        bundle.putInt("key_web_event", event.status());
        if (extra != null) {
            bundle.putAll(extra);
        }
        s("WebRemoteRenderIPCServer", "action_server_update_web_event", bundle, null);
    }

    public final void W(@NotNull Activity activity, @NotNull final Bundle data) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        F = activity;
        String string = data.getString("key_web_page_id");
        if (string == null) {
            string = "";
        }
        String str = string;
        this.webReaderStateMap.put(str, WebRenderState.INIT);
        N(data.getLong("key_click_start"));
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        aVar.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "prepareCreateRemoteView webPageId " + str + " ");
        Z(str, RemoteWebTimeCost.REMOTE_ACTIVITY_ON_CREATE);
        register();
        this.handler.postDelayed(this.heartBeatRunnable, 30000L);
        String string2 = data.getString("key_remote_web_url");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !TextUtils.isEmpty(string2)) {
            aVar.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "prepareCreateRemoteView webPageId " + str + ", url: " + string2);
            this.webReaderStateMap.put(str, WebRenderState.WAIT_FOR_X5);
            if (O(data)) {
                J(new m.a() { // from class: com.tencent.mobileqq.remoteweb.e
                    @Override // com.tencent.mobileqq.webview.swift.utils.m.a
                    public final void a() {
                        RemoteWebRenderIPCClient.X(RemoteWebRenderIPCClient.this, data);
                    }
                });
                return;
            } else {
                w(data);
                return;
            }
        }
        a.b bVar = new a.b();
        String str2 = "prepareCreateRemoteView error, webPageId " + str + ", url: " + string2;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCClient", 1, (String) it.next(), null);
        }
        Q(this, str, -1000, null, 4, null);
    }

    public final void Z(@NotNull String webPageId, @NotNull RemoteWebTimeCost type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) webPageId, (Object) type);
            return;
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(type, "type");
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.webRenderStartTime;
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "sendTimeCost, from_click_to_" + type + ContainerUtils.KEY_VALUE_DELIMITER + j3);
        Bundle bundle = new Bundle();
        bundle.putString("key_web_page_id", webPageId);
        bundle.putInt("key_time_cost_type", type.status());
        bundle.putLong("key_time_start_time", currentTimeMillis);
        s("WebRemoteRenderIPCServer", "action_server_report_time_cost", bundle, null);
    }

    public final void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "tryReleaseAll cur holder size: " + this.webRenderHolderMap.size());
        if (this.webRenderHolderMap.isEmpty()) {
            this.handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.f
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteWebRenderIPCClient.f0(RemoteWebRenderIPCClient.this);
                }
            }, 5000L);
        }
    }

    public final void g0(@NotNull String webPageId, @Nullable Surface surface, int width, int height, @Nullable final Function0<Unit> callback) {
        com.tencent.mobileqq.remoteweb.view.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, webPageId, surface, Integer.valueOf(width), Integer.valueOf(height), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        if (u(webPageId) && (bVar = this.webRenderHolderMap.get(webPageId)) != null) {
            bVar.b(surface, width, height, new Function0<Unit>(callback) { // from class: com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient$updateSurface$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function0<Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[updateSurface] ");
                    Function0<Unit> function0 = this.$callback;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
        }
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable final String action, @Nullable Bundle params, final int callbackId) {
        final Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 11, this, action, params, Integer.valueOf(callbackId));
        }
        if (params == null) {
            bundle = new Bundle();
        } else {
            bundle = params;
        }
        if (Intrinsics.areEqual(action, "action_client_destroy_web_view")) {
            this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.b
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteWebRenderIPCClient.U(RemoteWebRenderIPCClient.this, bundle, callbackId);
                }
            });
            EIPCResult createSuccessResult = EIPCResult.createSuccessResult(new Bundle());
            Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(Bundle())");
            return createSuccessResult;
        }
        if (Intrinsics.areEqual(action, "action_client_check_if_attach")) {
            return B(params);
        }
        this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.c
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCClient.V(RemoteWebRenderIPCClient.this, action, bundle, callbackId);
            }
        });
        EIPCResult UNKNOW_RESULT = EIPCResult.UNKNOW_RESULT;
        Intrinsics.checkNotNullExpressionValue(UNKNOW_RESULT, "UNKNOW_RESULT");
        return UNKNOW_RESULT;
    }

    public final void register() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCClient", 1, "[register] isRegistered " + this.isRegistered.get());
        if (!this.isRegistered.compareAndSet(false, true)) {
            return;
        }
        QIPCClientHelper.getInstance().register(this);
        QIPCClientHelper.getInstance().getClient().addListener(new c());
    }

    public final boolean u(@NotNull String webPageId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) webPageId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        return this.webRenderHolderMap.containsKey(webPageId);
    }

    @Nullable
    public final com.tencent.mobileqq.remoteweb.view.b z(@NotNull String webPageId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (com.tencent.mobileqq.remoteweb.view.b) iPatchRedirector.redirect((short) 15, (Object) this, (Object) webPageId);
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        return this.webRenderHolderMap.get(webPageId);
    }
}
