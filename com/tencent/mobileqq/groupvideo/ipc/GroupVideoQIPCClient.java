package com.tencent.mobileqq.groupvideo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.groupvideo.api.GroupVideoRemoteResponse;
import com.tencent.mobileqq.groupvideo.api.IGroupVideoQIPCApi;
import com.tencent.mobileqq.groupvideo.bridgeengine.IGroupVideoNTPushListener;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import eipc.EIPCConnection;
import eipc.EIPCOnGetConnectionListener;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010'\u001a\u00020\u000b\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J$\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J4\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0010\u0010\u001f\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCClient;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "Landroid/os/Bundle;", "params", "", "callbackId", "", "j", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "", "cmd", "bundle", "p", "w", "action", "Leipc/EIPCResult;", "onCall", "ssoCmd", "ssoCmdStr", "", "data", "serializationType", "Lcom/tencent/mobileqq/groupvideo/api/a;", "callback", ReportConstant.COSTREPORT_PREFIX, "o", "y", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoNTPushListener;", "listener", "v", "d", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoNTPushListener;", "ntPushListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRegistered", "name", "<init>", "(Ljava/lang/String;)V", "f", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GroupVideoQIPCClient extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<GroupVideoQIPCClient> f213783h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGroupVideoNTPushListener ntPushListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRegistered;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCClient$a;", "", "Lcom/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCClient;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCClient;", "sInstance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.ipc.GroupVideoQIPCClient$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

        private final GroupVideoQIPCClient b() {
            return (GroupVideoQIPCClient) GroupVideoQIPCClient.f213783h.getValue();
        }

        @JvmStatic
        @NotNull
        public final GroupVideoQIPCClient a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GroupVideoQIPCClient) iPatchRedirector.redirect((short) 2, (Object) this);
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCClient$b", "Leipc/EIPCOnGetConnectionListener;", "Leipc/EIPCConnection;", "conn", "", "onConnectBind", "onConnectUnbind", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements EIPCOnGetConnectionListener {
        static IPatchRedirector $redirector_;

        b() {
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
            if (conn != null) {
                str = conn.procName;
            } else {
                str = null;
            }
            QLog.d("GroupVideoQIPCClient", 1, "[onConnectBind] procName: " + str);
        }

        @Override // eipc.EIPCOnGetConnectionListener
        public void onConnectUnbind(@Nullable EIPCConnection conn) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) conn);
                return;
            }
            if (conn != null) {
                str = conn.procName;
            } else {
                str = null;
            }
            QLog.d("GroupVideoQIPCClient", 1, "[onConnectUnbind] procName: " + str);
        }
    }

    static {
        Lazy<GroupVideoQIPCClient> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24321);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) GroupVideoQIPCClient$Companion$sInstance$2.INSTANCE);
        f213783h = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupVideoQIPCClient(@NotNull String name) {
        super(name);
        Intrinsics.checkNotNullParameter(name, "name");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) name);
        } else {
            this.isRegistered = new AtomicBoolean(false);
            m();
        }
    }

    private final void i(Bundle params, int callbackId) {
        boolean z16;
        IGroupVideoNTPushListener iGroupVideoNTPushListener;
        int i3 = params.getInt("key_cmd");
        byte[] byteArray = params.getByteArray("key_data");
        if (byteArray != null) {
            if (byteArray.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((!z16) && (iGroupVideoNTPushListener = this.ntPushListener) != null) {
                iGroupVideoNTPushListener.onReceivePushMessage(i3, byteArray);
            }
        }
    }

    private final void j(Bundle params, int callbackId) {
        com.tencent.mobileqq.groupvideo.net.e.f213814a.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GroupVideoQIPCClient this$0, Bundle ipcBundle, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ipcBundle, "$ipcBundle");
        this$0.i(ipcBundle, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GroupVideoQIPCClient this$0, Bundle ipcBundle, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ipcBundle, "$ipcBundle");
        this$0.j(ipcBundle, i3);
    }

    private final void m() {
        QLog.d("GroupVideoQIPCClient", 1, "[register] isRegistered " + this.isRegistered.get());
        if (!this.isRegistered.compareAndSet(false, true)) {
            return;
        }
        QIPCClientHelper.getInstance().register(this);
        QIPCClientHelper.getInstance().getClient().addListener(new b());
    }

    private final void n() {
        q(this, "action_register_nt_push", null, 2, null);
    }

    private final void p(final String cmd, Bundle bundle) {
        QIPCClientHelper.getInstance().callServer(IGroupVideoQIPCApi.NAME, cmd, bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.groupvideo.ipc.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GroupVideoQIPCClient.r(cmd, eIPCResult);
            }
        });
    }

    static /* synthetic */ void q(GroupVideoQIPCClient groupVideoQIPCClient, String str, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = new Bundle();
        }
        groupVideoQIPCClient.p(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(String cmd, EIPCResult result) {
        Intrinsics.checkNotNullParameter(cmd, "$cmd");
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.d("GroupVideoQIPCClient", 1, "sendCMDToServer cmd " + cmd + ", result " + result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final com.tencent.mobileqq.groupvideo.api.a aVar, EIPCResult result) {
        final GroupVideoRemoteResponse groupVideoRemoteResponse;
        Intrinsics.checkNotNullParameter(result, "result");
        Serializable serializable = result.data.getSerializable("key_result_data");
        if (serializable instanceof GroupVideoRemoteResponse) {
            groupVideoRemoteResponse = (GroupVideoRemoteResponse) serializable;
        } else {
            groupVideoRemoteResponse = null;
        }
        if (groupVideoRemoteResponse == null) {
            groupVideoRemoteResponse = new GroupVideoRemoteResponse(-1, "ipc result data is null!", null);
        }
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.ipc.f
            @Override // java.lang.Runnable
            public final void run() {
                GroupVideoQIPCClient.u(GroupVideoRemoteResponse.this, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(GroupVideoRemoteResponse remoteResponse, com.tencent.mobileqq.groupvideo.api.a aVar) {
        Intrinsics.checkNotNullParameter(remoteResponse, "$remoteResponse");
        if (remoteResponse.getCode() != 0) {
            QLog.e("GroupVideoQIPCClient", 1, "unknown Error  " + remoteResponse.getMsg());
            if (aVar != null) {
                aVar.b(remoteResponse);
                return;
            }
            return;
        }
        if (aVar != null) {
            aVar.a(remoteResponse);
        }
    }

    private final void w() {
        QIPCClientHelper.getInstance().callServer(IGroupVideoQIPCApi.NAME, "action_unregister_nt_push", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.mobileqq.groupvideo.ipc.c
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GroupVideoQIPCClient.x(eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(EIPCResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.d("GroupVideoQIPCClient", 1, "unRegisterServerNTPush result " + result);
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            q(this, "action_register_pskey_change", null, 2, null);
        }
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@Nullable String action, @Nullable final Bundle params, final int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        if (params == null) {
            params = new Bundle();
        }
        if (Intrinsics.areEqual(action, "action_send_nt_push_from_server")) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.ipc.a
                @Override // java.lang.Runnable
                public final void run() {
                    GroupVideoQIPCClient.k(GroupVideoQIPCClient.this, params, callbackId);
                }
            });
        } else if (Intrinsics.areEqual(action, "action_notify_pskey_change_from_server")) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.groupvideo.ipc.b
                @Override // java.lang.Runnable
                public final void run() {
                    GroupVideoQIPCClient.l(GroupVideoQIPCClient.this, params, callbackId);
                }
            });
        }
        EIPCResult UNKNOW_RESULT = EIPCResult.UNKNOW_RESULT;
        Intrinsics.checkNotNullExpressionValue(UNKNOW_RESULT, "UNKNOW_RESULT");
        return UNKNOW_RESULT;
    }

    public final void s(int ssoCmd, @Nullable String ssoCmdStr, @Nullable byte[] data, int serializationType, @Nullable final com.tencent.mobileqq.groupvideo.api.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(ssoCmd), ssoCmdStr, data, Integer.valueOf(serializationType), callback);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_cmd", ssoCmd);
        if (ssoCmdStr == null) {
            ssoCmdStr = "";
        }
        bundle.putString(MiniAppCmdUtil.KEY_CMD_STRING, ssoCmdStr);
        bundle.putByteArray("key_data", data);
        bundle.putInt("key_serializationType", serializationType);
        QIPCClientHelper.getInstance().callServer(IGroupVideoQIPCApi.NAME, "action_send_trpc_request", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.groupvideo.ipc.e
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GroupVideoQIPCClient.t(com.tencent.mobileqq.groupvideo.api.a.this, eIPCResult);
            }
        });
    }

    public final void v(@Nullable IGroupVideoNTPushListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
            return;
        }
        this.ntPushListener = listener;
        if (listener != null) {
            n();
        } else {
            w();
        }
    }

    public final void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            q(this, "action_unregister_pskey_change", null, 2, null);
        }
    }
}
