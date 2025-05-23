package com.tencent.mobileqq.remoteweb;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.log.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u0000 M2\u00020\u0001:\u0001NB\u000f\u0012\u0006\u0010J\u001a\u00020\u0007\u00a2\u0006\u0004\bK\u0010LJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ&\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00072\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010!J\u0016\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u001aJ\u0016\u0010&\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00072\u0006\u0010%\u001a\u00020\tJ\u000e\u0010'\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\"\u0010(\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040!J0\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010,\u001a\u00020\u0002J@\u0010.\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*2\u0006\u0010 \u001a\u00020\u00072\b\b\u0002\u0010,\u001a\u00020\u00022\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010!J8\u00103\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010*2\b\b\u0002\u00100\u001a\u00020\f2\b\b\u0002\u00101\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u000102J$\u00106\u001a\u0002052\b\u00104\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001d078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R$\u0010A\u001a\u00020;2\u0006\u0010<\u001a\u00020;8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R$\u0010F\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER$\u0010I\u001a\u00020;2\u0006\u0010<\u001a\u00020;8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bG\u0010>\u001a\u0004\bH\u0010@\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCServer;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "ipcBundle", "", "N", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "uniqueKey", "", "I", "params", "", "callbackId", "L", "M", "O", "P", "a0", "c0", "e0", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "g0", "Landroid/view/MotionEvent;", WebRTCSDK.PRIVILEGE_TOUCH, "i0", "Lcom/tencent/mobileqq/remoteweb/a;", "callback", "w", "webPageId", "Lkotlin/Function1;", BdhLogUtil.LogTag.Tag_Conn, "event", "G", "isVisible", "U", "f0", HippyTKDListViewAdapter.X, "url", "Landroid/view/Surface;", "surface", "bundle", "h0", BdhLogUtil.LogTag.Tag_Req, "newSurface", "newWidth", "newHeight", "Leipc/EIPCResultCallback;", "j0", "action", "Leipc/EIPCResult;", "onCall", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "statusUpdateList", "", "<set-?>", "e", "J", "getBindStartTime", "()J", "bindStartTime", "f", "Z", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Z", "isRemoteRender", tl.h.F, "K", "webRenderStartTime", "name", "<init>", "(Ljava/lang/String;)V", "i", "a", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class RemoteWebRenderIPCServer extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final Lazy<RemoteWebRenderIPCServer> f281136m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<a> statusUpdateList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long bindStartTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isRemoteRender;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long webRenderStartTime;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCServer$a;", "", "Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCServer;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/remoteweb/RemoteWebRenderIPCServer;", "sInstance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final RemoteWebRenderIPCServer b() {
            return (RemoteWebRenderIPCServer) RemoteWebRenderIPCServer.f281136m.getValue();
        }

        @JvmStatic
        @NotNull
        public final RemoteWebRenderIPCServer a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RemoteWebRenderIPCServer) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return b();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/remoteweb/RemoteWebRenderIPCServer$b", "Leipc/EIPCOnGetConnectionListener;", "Leipc/EIPCConnection;", "conn", "", "onConnectBind", "onConnectUnbind", "webview_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements EIPCOnGetConnectionListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RemoteWebRenderIPCServer.this);
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectBind(@Nullable EIPCConnection conn) {
            String str;
            boolean contains$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) conn);
                return;
            }
            boolean z16 = false;
            if (conn != null && (str = conn.procName) != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "tool", false, 2, (Object) null);
                if (contains$default) {
                    z16 = true;
                }
            }
            if (z16) {
                com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[onConnectBind] procName " + conn.procName);
                RemoteWebRenderIPCServer.this.a0();
            }
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(@Nullable EIPCConnection conn) {
            String str;
            boolean contains$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) conn);
                return;
            }
            boolean z16 = false;
            if (conn != null && (str = conn.procName) != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "tool", false, 2, (Object) null);
                if (contains$default) {
                    z16 = true;
                }
            }
            if (z16) {
                com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                String str2 = "[onConnectUnbind] procName " + conn.procName;
                if (str2 instanceof String) {
                    bVar.a().add(str2);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCServer", 1, (String) it.next(), null);
                }
                RemoteWebRenderIPCServer.this.A();
            }
        }
    }

    static {
        Lazy<RemoteWebRenderIPCServer> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39612);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) RemoteWebRenderIPCServer$Companion$sInstance$2.INSTANCE);
        f281136m = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteWebRenderIPCServer(@NotNull String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) name);
        } else {
            this.statusUpdateList = new CopyOnWriteArrayList<>();
            e0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.x
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCServer.B(RemoteWebRenderIPCServer.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(RemoteWebRenderIPCServer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac acVar = ac.f281144a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        boolean a16 = acVar.a(context);
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[checkIfConnectionBroken] isServiceRunning " + a16 + ", toolExits " + isProcessRunning);
        if (!a16 || !isProcessRunning) {
            this$0.c0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void D(RemoteWebRenderIPCServer remoteWebRenderIPCServer, String str, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        remoteWebRenderIPCServer.C(str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final Function1 function1, final EIPCResult eIPCResult) {
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "destroyRemoteWebView result " + eIPCResult.code + ", error: " + eIPCResult.f396321e);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.p
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCServer.F(Function1.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(Function1 function1, EIPCResult eIPCResult) {
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(eIPCResult.isSuccess()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(EIPCResult eIPCResult) {
        Integer num;
        boolean z16 = false;
        if (eIPCResult != null && eIPCResult.isSuccess()) {
            z16 = true;
        }
        if (!z16) {
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            a.b bVar = new a.b();
            if (eIPCResult != null) {
                num = Integer.valueOf(eIPCResult.code);
            } else {
                num = null;
            }
            String str = "[dispatchTouEvent] code " + num;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCServer", 1, (String) it.next(), null);
            }
        }
    }

    private final boolean I(String uniqueKey) {
        Boolean bool;
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool");
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        aVar.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[doCheckClientConnect] try get connection for key " + uniqueKey + " toolExits " + isProcessRunning);
        boolean z16 = false;
        if (!isProcessRunning) {
            return false;
        }
        EIPCConnection clientConnection = QIPCServerHelper.getInstance().getServer().getClientConnection("com.tencent.mobileqq:tool", 1);
        a.InterfaceC7984a a16 = aVar.a();
        if (clientConnection != null) {
            bool = Boolean.valueOf(clientConnection.isAvailable());
        } else {
            bool = null;
        }
        a16.d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[doCheckClientConnect] clientConnection: " + bool);
        if (clientConnection != null && clientConnection.isAvailable()) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("key_web_page_id", uniqueKey);
                Unit unit = Unit.INSTANCE;
                EIPCResult callModule = clientConnection.callModule("WebRemoteRenderIPClient", "action_client_check_if_attach", bundle);
                if (callModule != null) {
                    if (callModule.isSuccess()) {
                        z16 = true;
                    }
                }
            } catch (Throwable th5) {
                com.tencent.mobileqq.log.a aVar2 = com.tencent.mobileqq.log.a.f241755a;
                a.b bVar = new a.b();
                String str = "[checkIfAttach] callModule throwable " + th5;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCServer", 1, (String) it.next(), null);
                }
            }
            com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[doCheckClientConnect] result " + z16);
        }
        return z16;
    }

    @JvmStatic
    @NotNull
    public static final RemoteWebRenderIPCServer J() {
        return INSTANCE.a();
    }

    private final void L(Bundle params, int callbackId) {
        int i3 = params.getInt("key_error_code", 0);
        String str = "";
        String string = params.getString("key_error_msg", "");
        if (string == null) {
            string = "";
        }
        String string2 = params.getString("key_web_page_id", "");
        if (string2 != null) {
            str = string2;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "handleError, error " + i3 + ", msg " + string);
        if (i3 != 0) {
            Iterator<T> it = this.statusUpdateList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onFailed(str, i3, string);
            }
        }
    }

    private final void M(Bundle params, int callbackId) {
        long currentTimeMillis = System.currentTimeMillis() - params.getLong("key_time_start_time");
        com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
        if (QLog.isDevelopLevel()) {
            Log.d("RemoteWeb.RemoteWebRenderIPCServer", "receive heart beat! " + params.getInt("key_heart_beat_index") + ",ipcCost=" + currentTimeMillis);
        }
        callbackResult(callbackId, EIPCResult.createResult(0, new Bundle()));
    }

    private final void N(Bundle ipcBundle) {
        ComponentName component;
        String className;
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[handleStartActivityFromRemoteWeb] ");
        Intent intent = (Intent) ipcBundle.getParcelable("key_activity_intent");
        if (intent != null && (component = intent.getComponent()) != null && (className = component.getClassName()) != null) {
            Bundle bundle = ipcBundle.getBundle("key_activity_bundle");
            if (bundle == null) {
                bundle = new Bundle();
            }
            ComponentName componentName = new ComponentName(QBaseActivity.sTopActivity, className);
            Intent intent2 = new Intent();
            intent2.setComponent(componentName);
            intent2.putExtras(intent);
            intent2.addFlags(402653184);
            intent2.removeExtra("key_enable_remote_web_render");
            intent2.removeExtra("key_activity_intent");
            intent2.removeExtra("key_activity_bundle");
            QBaseActivity.sTopActivity.startActivity(intent2, bundle);
        }
    }

    private final void O(Bundle params) {
        RemoteWebTimeCost a16 = RemoteWebTimeCost.INSTANCE.a(params.getInt("key_time_cost_type"));
        long j3 = params.getLong("key_time_start_time");
        String str = "";
        String string = params.getString("key_web_page_id", "");
        if (string != null) {
            str = string;
        }
        long j16 = j3 - this.webRenderStartTime;
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "sendTimeCost, from_click_to_" + a16 + ContainerUtils.KEY_VALUE_DELIMITER + j16 + ", ipcCost=" + (System.currentTimeMillis() - j3));
        Iterator<T> it = this.statusUpdateList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onReportTimeCost(str, a16, j3);
        }
    }

    private final void P(Bundle params, int callbackId) {
        RemoteWebViewEvent a16 = RemoteWebViewEvent.INSTANCE.a(params.getInt("key_web_event", -1));
        String str = "";
        String string = params.getString("key_web_page_id", "");
        if (string != null) {
            str = string;
        }
        if (a16 == RemoteWebViewEvent.ON_PAGE_SCROLL_EVENT) {
            com.tencent.mobileqq.log.a aVar = com.tencent.mobileqq.log.a.f241755a;
            if (QLog.isDevelopLevel()) {
                Log.d("RemoteWeb.RemoteWebRenderIPCServer", "handleWebEvent: " + a16 + " callbackId " + callbackId);
            }
        } else {
            com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "handleWebEvent: " + a16 + " callbackId " + callbackId);
        }
        for (a aVar2 : this.statusUpdateList) {
            aVar2.onWebViewEvent(str, a16);
            aVar2.onWebViewEvent(str, a16, params);
        }
    }

    public static /* synthetic */ void S(RemoteWebRenderIPCServer remoteWebRenderIPCServer, String str, Surface surface, String str2, Bundle bundle, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            bundle = new Bundle();
        }
        Bundle bundle2 = bundle;
        if ((i3 & 16) != 0) {
            function1 = null;
        }
        remoteWebRenderIPCServer.R(str, surface, str2, bundle2, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(Function1 function1, EIPCResult eIPCResult) {
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "loadUrl result " + eIPCResult.code + ", error: " + eIPCResult.f396321e);
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(eIPCResult.isSuccess()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(EIPCResult eIPCResult) {
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "notifyWebForeground result " + eIPCResult.code + ", error: " + eIPCResult.f396321e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(RemoteWebRenderIPCServer this$0, Bundle ipcBundle, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ipcBundle, "$ipcBundle");
        this$0.L(ipcBundle, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(RemoteWebRenderIPCServer this$0, Bundle ipcBundle, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ipcBundle, "$ipcBundle");
        this$0.P(ipcBundle, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(RemoteWebRenderIPCServer this$0, Bundle ipcBundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ipcBundle, "$ipcBundle");
        this$0.O(ipcBundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(RemoteWebRenderIPCServer this$0, Bundle ipcBundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ipcBundle, "$ipcBundle");
        this$0.N(ipcBundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.n
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCServer.b0(RemoteWebRenderIPCServer.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(RemoteWebRenderIPCServer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isRemoteRender) {
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[onConnectBind]");
        this$0.bindStartTime = System.currentTimeMillis();
        this$0.isRemoteRender = true;
        Iterator<T> it = this$0.statusUpdateList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onServiceConnected();
        }
    }

    private final void c0() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.r
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCServer.d0(RemoteWebRenderIPCServer.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(RemoteWebRenderIPCServer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isRemoteRender) {
            return;
        }
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[onConnectUnbind]");
        this$0.isRemoteRender = false;
        long currentTimeMillis = System.currentTimeMillis() - this$0.bindStartTime;
        Iterator<T> it = this$0.statusUpdateList.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onServiceDisconnected(currentTimeMillis);
        }
    }

    private final void e0() {
        QIPCServerHelper.getInstance().getServer().addListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(Context context, Intent intent) {
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[startRemoteWebActivity]");
        QRoute.createNavigator(context, RouterConstants.UI_ROUTE_TRANSLUCENT_BROWSER).withBoolean("key_enable_remote_web_render", true).withAll(intent.getExtras()).request();
    }

    private final MotionEvent i0(MotionEvent touch) {
        int pointerCount = touch.getPointerCount();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            touch.getPointerProperties(i3, pointerProperties);
            arrayList.add(new MotionEvent.PointerProperties(pointerProperties));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i16 = 0; i16 < pointerCount; i16++) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            touch.getPointerCoords(i16, pointerCoords);
            arrayList2.add(new MotionEvent.PointerCoords(pointerCoords));
        }
        long downTime = touch.getDownTime();
        long eventTime = touch.getEventTime();
        int action = touch.getAction();
        int pointerCount2 = touch.getPointerCount();
        Object[] array = arrayList.toArray(new MotionEvent.PointerProperties[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        MotionEvent.PointerProperties[] pointerPropertiesArr = (MotionEvent.PointerProperties[]) array;
        Object[] array2 = arrayList2.toArray(new MotionEvent.PointerCoords[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        MotionEvent obtain = MotionEvent.obtain(downTime, eventTime, action, pointerCount2, pointerPropertiesArr, (MotionEvent.PointerCoords[]) array2, touch.getMetaState(), touch.getButtonState(), touch.getXPrecision(), touch.getYPrecision(), touch.getDeviceId(), touch.getEdgeFlags(), touch.getSource(), touch.getFlags());
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain(\n            touc\u2026    touch.flags\n        )");
        return obtain;
    }

    public static /* synthetic */ void k0(RemoteWebRenderIPCServer remoteWebRenderIPCServer, String str, Surface surface, int i3, int i16, EIPCResultCallback eIPCResultCallback, int i17, Object obj) {
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
            eIPCResultCallback = null;
        }
        remoteWebRenderIPCServer.j0(str, surface, i18, i19, eIPCResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(final EIPCResultCallback eIPCResultCallback, final EIPCResult eIPCResult) {
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "updateSurface result " + eIPCResult.code + ", error: " + eIPCResult.f396321e);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.q
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCServer.m0(EIPCResultCallback.this, eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(EIPCResultCallback eIPCResultCallback, EIPCResult eIPCResult) {
        if (eIPCResultCallback != null) {
            eIPCResultCallback.onCallback(eIPCResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(RemoteWebRenderIPCServer this$0, String uniqueKey, final Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uniqueKey, "$uniqueKey");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        final boolean I = this$0.I(uniqueKey);
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[checkIfAttach] uniqueKey " + uniqueKey + ", isAttach " + I);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.o
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCServer.z(Function1.this, I);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1 callback, boolean z16) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.valueOf(z16));
    }

    public final void C(@NotNull String webPageId, @Nullable final Function1<? super Boolean, Unit> callback) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) webPageId, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        if (webPageId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_web_page_id", webPageId);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WebRemoteRenderIPClient", "action_client_destroy_web_view", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.remoteweb.v
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                RemoteWebRenderIPCServer.E(Function1.this, eIPCResult);
            }
        });
    }

    public final void G(@NotNull String webPageId, @NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) webPageId, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(event, "event");
        MotionEvent i06 = i0(event);
        Bundle bundle = new Bundle();
        bundle.putString("key_web_page_id", webPageId);
        bundle.putParcelable("key_surface_touch_event", i06);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WebRemoteRenderIPClient", "action_client_dispatch_touch_event", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.remoteweb.w
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                RemoteWebRenderIPCServer.H(eIPCResult);
            }
        });
    }

    public final long K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.webRenderStartTime;
    }

    public final boolean Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isRemoteRender;
    }

    public final void R(@NotNull String url, @NotNull Surface surface, @NotNull String webPageId, @NotNull Bundle bundle, @Nullable final Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, url, surface, webPageId, bundle, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "loadUrl webPageId " + webPageId + ", url " + url);
        Bundle bundle2 = new Bundle();
        bundle2.putAll(bundle);
        bundle2.putString("key_remote_web_url", url);
        bundle2.putString("key_web_page_id", webPageId);
        bundle2.putParcelable("key_surface", surface);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WebRemoteRenderIPClient", "action_client_load_url", bundle2, new EIPCResultCallback() { // from class: com.tencent.mobileqq.remoteweb.y
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                RemoteWebRenderIPCServer.T(Function1.this, eIPCResult);
            }
        });
    }

    public final void U(@NotNull String webPageId, boolean isVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, webPageId, Boolean.valueOf(isVisible));
            return;
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "notifyWebForeground " + webPageId + " " + isVisible);
        Bundle bundle = new Bundle();
        bundle.putString("key_web_page_id", webPageId);
        bundle.putBoolean("key_app_foreground", isVisible);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WebRemoteRenderIPClient", "action_client_notify_app_foreground", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.remoteweb.aa
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                RemoteWebRenderIPCServer.V(eIPCResult);
            }
        });
    }

    public final void f0(@NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.statusUpdateList.contains(callback)) {
            this.statusUpdateList.remove(callback);
        }
    }

    public final void h0(@NotNull final String url, @NotNull final Surface surface, @NotNull final String webPageId, @NotNull final Context context, @NotNull final Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, url, surface, webPageId, context, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(surface, "surface");
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        com.tencent.mobileqq.log.a.f241755a.a().d("RemoteWeb.RemoteWebRenderIPCServer", 1, "[startRemoteWebView] isRemoteRender " + Q() + ", url: " + url);
        x(webPageId, new Function1<Boolean, Unit>(url, surface, webPageId, bundle, context) { // from class: com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCServer$startRemoteWebView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Bundle $bundle;
            final /* synthetic */ Context $context;
            final /* synthetic */ Surface $surface;
            final /* synthetic */ String $url;
            final /* synthetic */ String $webPageId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$url = url;
                this.$surface = surface;
                this.$webPageId = webPageId;
                this.$bundle = bundle;
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RemoteWebRenderIPCServer.this, url, surface, webPageId, bundle, context);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    return;
                }
                if (z16) {
                    RemoteWebRenderIPCServer.S(RemoteWebRenderIPCServer.this, this.$url, this.$surface, this.$webPageId, this.$bundle, null, 16, null);
                    return;
                }
                RemoteWebRenderIPCServer.this.webRenderStartTime = System.currentTimeMillis();
                Intent intent = new Intent();
                intent.putExtra("key_remote_web_url", this.$url);
                intent.putExtra("key_click_start", RemoteWebRenderIPCServer.this.K());
                intent.putExtra("key_surface", this.$surface);
                intent.putExtra("key_web_page_id", this.$webPageId);
                intent.putExtra("key_enable_remote_web_render", true);
                intent.putExtras(this.$bundle);
                RemoteWebRenderIPCServer.this.g0(this.$context, intent);
            }
        });
    }

    public final void j0(@NotNull String webPageId, @Nullable Surface newSurface, int newWidth, int newHeight, @Nullable final EIPCResultCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, webPageId, newSurface, Integer.valueOf(newWidth), Integer.valueOf(newHeight), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(webPageId, "webPageId");
        a.InterfaceC7984a a16 = com.tencent.mobileqq.log.a.f241755a.a();
        if (newSurface != null) {
            z16 = true;
        }
        a16.d("RemoteWeb.RemoteWebRenderIPCServer", 1, "updateSurface webPageId " + webPageId + ", newSurface " + z16);
        if (!QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:tool")) {
            a.b bVar = new a.b();
            bVar.a().add("toolExits false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.log.a.f241755a.a().e("RemoteWeb.RemoteWebRenderIPCServer", 1, (String) it.next(), null);
            }
            EIPCResult createResult = EIPCResult.createResult(-1, new Bundle());
            if (callback != null) {
                callback.onCallback(createResult);
                return;
            }
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_web_page_id", webPageId);
        if (newSurface != null) {
            bundle.putParcelable("key_surface", newSurface);
        }
        if (newWidth != 0) {
            bundle.putInt("key_web_view_width", newWidth);
        }
        if (newHeight != 0) {
            bundle.putInt("key_web_view_height", newHeight);
        }
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:tool", "WebRemoteRenderIPClient", "action_client_update_surface", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.remoteweb.z
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                RemoteWebRenderIPCServer.l0(EIPCResultCallback.this, eIPCResult);
            }
        });
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable String action, @Nullable final Bundle params, final int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 15, this, action, params, Integer.valueOf(callbackId));
        }
        if (params == null) {
            params = new Bundle();
        }
        this.isRemoteRender = true;
        if (action != null) {
            switch (action.hashCode()) {
                case -1682543513:
                    if (action.equals("action_server_notify_error_code")) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.l
                            @Override // java.lang.Runnable
                            public final void run() {
                                RemoteWebRenderIPCServer.W(RemoteWebRenderIPCServer.this, params, callbackId);
                            }
                        });
                        break;
                    }
                    break;
                case -670860205:
                    if (action.equals("action_server_send_heart_beat")) {
                        M(params, callbackId);
                        break;
                    }
                    break;
                case 257306407:
                    if (action.equals("action_server_report_time_cost")) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.t
                            @Override // java.lang.Runnable
                            public final void run() {
                                RemoteWebRenderIPCServer.Y(RemoteWebRenderIPCServer.this, params);
                            }
                        });
                        break;
                    }
                    break;
                case 308961388:
                    if (action.equals("action_server_update_web_event")) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.s
                            @Override // java.lang.Runnable
                            public final void run() {
                                RemoteWebRenderIPCServer.X(RemoteWebRenderIPCServer.this, params, callbackId);
                            }
                        });
                        break;
                    }
                    break;
                case 2057777535:
                    if (action.equals("action_server_start_activity")) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.u
                            @Override // java.lang.Runnable
                            public final void run() {
                                RemoteWebRenderIPCServer.Z(RemoteWebRenderIPCServer.this, params);
                            }
                        });
                        break;
                    }
                    break;
            }
        }
        EIPCResult UNKNOW_RESULT = EIPCResult.UNKNOW_RESULT;
        Intrinsics.checkNotNullExpressionValue(UNKNOW_RESULT, "UNKNOW_RESULT");
        return UNKNOW_RESULT;
    }

    public final void w(@NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.statusUpdateList.contains(callback)) {
            this.statusUpdateList.add(callback);
        }
    }

    public final void x(@NotNull final String uniqueKey, @NotNull final Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) uniqueKey, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.remoteweb.m
            @Override // java.lang.Runnable
            public final void run() {
                RemoteWebRenderIPCServer.y(RemoteWebRenderIPCServer.this, uniqueKey, callback);
            }
        }, 16, null, false);
    }
}
