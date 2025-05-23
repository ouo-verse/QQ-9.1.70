package com.tencent.mobileqq.groupvideo.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.groupvideo.api.GroupVideoRemoteResponse;
import com.tencent.mobileqq.groupvideo.api.IGroupVideoQIPCApi;
import com.tencent.mobileqq.groupvideo.bridgeengine.IGroupVideoPSKeyListener;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0001\u001a\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCServer;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "", "g", tl.h.F, "k", "Landroid/os/Bundle;", "bundle", "", "callbackId", "i", "j", "cmd", "", "data", "o", "l", "", "action", "params", "Leipc/EIPCResult;", "onCall", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoPSKeyListener;", "d", "Lcom/tencent/mobileqq/groupvideo/bridgeengine/IGroupVideoPSKeyListener;", "pskeyChangeListener", "com/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCServer$c", "e", "Lcom/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCServer$c;", "ntPushListenerFromIPC", "name", "<init>", "(Ljava/lang/String;)V", "f", "a", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GroupVideoQIPCServer extends QIPCModule {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<GroupVideoQIPCServer> f213787h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGroupVideoPSKeyListener pskeyChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c ntPushListenerFromIPC;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCServer$a;", "", "Lcom/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCServer;", "b", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCServer;", "INSTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.groupvideo.ipc.GroupVideoQIPCServer$a, reason: from kotlin metadata */
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

        private final GroupVideoQIPCServer a() {
            return (GroupVideoQIPCServer) GroupVideoQIPCServer.f213787h.getValue();
        }

        @NotNull
        public final GroupVideoQIPCServer b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GroupVideoQIPCServer) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return a();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCServer$b", "Lcom/tencent/mobileqq/groupvideo/api/a;", "Lcom/tencent/mobileqq/groupvideo/api/GroupVideoRemoteResponse;", "successResponse", "", "a", "errorResponse", "b", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements com.tencent.mobileqq.groupvideo.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f213791b;

        b(int i3) {
            this.f213791b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupVideoQIPCServer.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.groupvideo.api.a
        public void a(@NotNull GroupVideoRemoteResponse successResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) successResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            if (QLog.isDevelopLevel()) {
                QLog.i(IGroupVideoQIPCApi.NAME, 4, "callbackResult onSuccess");
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_result_data", successResponse);
            GroupVideoQIPCServer.this.callbackResult(this.f213791b, EIPCResult.createSuccessResult(bundle));
        }

        @Override // com.tencent.mobileqq.groupvideo.api.a
        public void b(@NotNull GroupVideoRemoteResponse errorResponse) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errorResponse);
                return;
            }
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            QLog.e(IGroupVideoQIPCApi.NAME, 1, "callbackResult onFail");
            Bundle bundle = new Bundle();
            bundle.putSerializable("key_result_data", errorResponse);
            GroupVideoQIPCServer.this.callbackResult(this.f213791b, EIPCResult.createSuccessResult(bundle));
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/groupvideo/ipc/GroupVideoQIPCServer$c", "Lcom/tencent/mobileqq/groupvideo/api/b;", "", "cmd", "", "data", "", "onReceivePushMessage", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements com.tencent.mobileqq.groupvideo.api.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupVideoQIPCServer.this);
            }
        }

        @Override // com.tencent.mobileqq.groupvideo.api.b
        public void onReceivePushMessage(int cmd, @NotNull byte[] data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, cmd, (Object) data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                GroupVideoQIPCServer.this.o(cmd, data);
            }
        }
    }

    static {
        Lazy<GroupVideoQIPCServer> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24449);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(GroupVideoQIPCServer$Companion$INSTANCE$2.INSTANCE);
        f213787h = lazy;
    }

    public GroupVideoQIPCServer(@Nullable String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.pskeyChangeListener = new IGroupVideoPSKeyListener() { // from class: com.tencent.mobileqq.groupvideo.ipc.g
                @Override // com.tencent.mobileqq.groupvideo.bridgeengine.IGroupVideoPSKeyListener
                public final void onPSKeyChanged(List list) {
                    GroupVideoQIPCServer.n(GroupVideoQIPCServer.this, list);
                }
            };
            this.ntPushListenerFromIPC = new c();
        }
    }

    private final void g() {
        com.tencent.mobileqq.groupvideo.net.a aVar = com.tencent.mobileqq.groupvideo.net.a.f213804a;
        aVar.d();
        aVar.b(this.ntPushListenerFromIPC);
    }

    private final void h() {
        com.tencent.mobileqq.groupvideo.net.e eVar = com.tencent.mobileqq.groupvideo.net.e.f213814a;
        eVar.c();
        eVar.f(this.pskeyChangeListener);
    }

    private final void i(Bundle bundle, int callbackId) {
        byte[] byteArray = bundle.getByteArray("key_data");
        if (byteArray == null) {
            return;
        }
        com.tencent.mobileqq.groupvideo.net.d.f213812a.f(bundle.getInt("key_cmd", 0), bundle.getString(MiniAppCmdUtil.KEY_CMD_STRING, ""), byteArray, bundle.getInt("key_serializationType"), new b(callbackId));
    }

    private final void j() {
        com.tencent.mobileqq.groupvideo.net.a aVar = com.tencent.mobileqq.groupvideo.net.a.f213804a;
        aVar.e(this.ntPushListenerFromIPC);
        aVar.f();
    }

    private final void k() {
        com.tencent.mobileqq.groupvideo.net.e eVar = com.tencent.mobileqq.groupvideo.net.e.f213814a;
        eVar.h(this.pskeyChangeListener);
        eVar.g();
    }

    private final void l() {
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:troophomework", "GroupVideoQIPCClient", "action_notify_pskey_change_from_server", new Bundle(), new EIPCResultCallback() { // from class: com.tencent.mobileqq.groupvideo.ipc.h
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GroupVideoQIPCServer.m(eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(EIPCResult eIPCResult) {
        QLog.e(IGroupVideoQIPCApi.NAME, 1, "notifyPSKeyToClient result " + eIPCResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(GroupVideoQIPCServer this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int cmd, byte[] data) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("key_data", data);
        bundle.putInt("key_cmd", cmd);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:troophomework", "GroupVideoQIPCClient", "action_send_nt_push_from_server", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.groupvideo.ipc.i
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GroupVideoQIPCServer.p(eIPCResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(EIPCResult eIPCResult) {
        QLog.e(IGroupVideoQIPCApi.NAME, 1, "sendNTPush result " + eIPCResult);
    }

    @Override // eipc.EIPCModule
    @Nullable
    public EIPCResult onCall(@Nullable String action, @Nullable Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        if (params == null) {
            params = new Bundle();
        }
        QLog.d(IGroupVideoQIPCApi.NAME, 1, "onCall action " + action);
        if (action != null) {
            switch (action.hashCode()) {
                case 658146713:
                    if (action.equals("action_unregister_nt_push")) {
                        j();
                        return null;
                    }
                    return null;
                case 688189094:
                    if (action.equals("action_register_pskey_change")) {
                        h();
                        return null;
                    }
                    return null;
                case 1351374829:
                    if (action.equals("action_unregister_pskey_change")) {
                        k();
                        return null;
                    }
                    return null;
                case 1829429056:
                    if (action.equals("action_register_nt_push")) {
                        g();
                        return null;
                    }
                    return null;
                case 1892821711:
                    if (action.equals("action_send_trpc_request")) {
                        i(params, callbackId);
                        return null;
                    }
                    return null;
                default:
                    return null;
            }
        }
        return null;
    }
}
