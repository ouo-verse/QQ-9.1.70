package com.tencent.qqnt.kernel.msf;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.msf.sdk.CommandCallbackerInfo;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.NotifyRegisterInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.internel.KLog;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.PushExtraInfo;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.IDynamicRegisterServletCmd;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\u0017\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0013\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/kernel/msf/b;", "Lmqq/app/MSFServlet;", "Lmqq/app/IDynamicRegisterServletCmd;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "", "j", "serviceForActionRegistMessagePushProxy", "onCreate", "service", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "msg", "i", "", "", "getPreferSSOCommands", "()[Ljava/lang/String;", "Lmqq/app/Packet;", "packet", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends MSFServlet implements IDynamicRegisterServletCmd {
    static IPatchRedirector $redirector_;

    @Nullable
    private static WeakReference<IQQNTWrapperSession> C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final CopyOnWriteArraySet<String> f359145e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private static java.lang.ref.WeakReference<b> f359146f;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f359147h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f359148i;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final LinkedBlockingQueue<FromServiceMsg> f359149m;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/kernel/msf/b$a;", "", "", "d", "", "cmd", "a", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", SessionDbHelper.SESSION_ID, "e", "Ljava/util/concurrent/CopyOnWriteArraySet;", "commandSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "b", "()Ljava/util/concurrent/CopyOnWriteArraySet;", "EXTRA_ACTION", "Ljava/lang/String;", "EXTRA_APPID", "EXTRA_BROADCASTNAME", "EXTRA_CMD", "EXTRA_PROCESSNAME", "EXTRA_PUSH_CMD", "SUB_TAG", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "cacheQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "", "isKernelInit", "Z", "isMsgRegister", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/kernel/msf/b;", "servletRef", "Ljava/lang/ref/WeakReference;", "Lmqq/util/WeakReference;", "wrapperSession", "Lmqq/util/WeakReference;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.msf.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        private final void d() {
            b bVar;
            KLog.e(KLog.f359087a, "KMsgServlet-MSF", new Object[]{"KMsgServlet, setRegister"}, null, 4, null);
            b.f359147h = true;
            if (b.f359148i) {
                for (FromServiceMsg it : b.f359149m) {
                    java.lang.ref.WeakReference weakReference = b.f359146f;
                    if (weakReference != null) {
                        bVar = (b) weakReference.get();
                    } else {
                        bVar = null;
                    }
                    KLog.e(KLog.f359087a, "KMsgServlet-MSF", new Object[]{"dispatch msg, servlet=" + bVar}, null, 4, null);
                    if (bVar != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        bVar.onReceive(null, it);
                    }
                }
                b.f359149m.clear();
            }
        }

        public final void a(@NotNull String cmd) {
            b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cmd);
                return;
            }
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            KLog kLog = KLog.f359087a;
            KLog.i(kLog, "KMsgServlet-MSF", new Object[]{"registerMSFPushCmd cmd= " + cmd}, null, 4, null);
            b().add(cmd);
            if (Intrinsics.areEqual(cmd, BaseConstants.CMD_TRPC_MSG_PUSH)) {
                java.lang.ref.WeakReference weakReference = b.f359146f;
                if (weakReference != null) {
                    bVar = (b) weakReference.get();
                } else {
                    bVar = null;
                }
                if (bVar == null) {
                    KLog.e(kLog, "KMsgServlet-MSF", new Object[]{"setRegister, servlet == null"}, null, 4, null);
                }
                d();
            }
        }

        @NotNull
        public final CopyOnWriteArraySet<String> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.f359145e;
            }
            return (CopyOnWriteArraySet) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        public final void c() {
            b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            KLog.e(KLog.f359087a, "KMsgServlet-MSF", new Object[]{"KMsgServlet, setKernelInit"}, null, 4, null);
            b.f359148i = true;
            if (b.f359147h) {
                for (FromServiceMsg it : b.f359149m) {
                    java.lang.ref.WeakReference weakReference = b.f359146f;
                    if (weakReference != null) {
                        bVar = (b) weakReference.get();
                    } else {
                        bVar = null;
                    }
                    KLog.e(KLog.f359087a, "KMsgServlet-MSF", new Object[]{"dispatch msg, servlet=" + bVar}, null, 4, null);
                    if (bVar != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        bVar.onReceive(null, it);
                    }
                }
                b.f359149m.clear();
            }
        }

        public final void e(@Nullable IQQNTWrapperSession session) {
            Unit unit;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) session);
                return;
            }
            if (session != null) {
                Companion companion = b.INSTANCE;
                b.C = new WeakReference(session);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                KLog.g(KLog.f359087a, "KMsgServlet-MSF", new Object[]{"wrapper session is null!!! the create seq is error !!!"}, null, 4, null);
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54613);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        f359145e = new CopyOnWriteArraySet<>();
        f359149m = new LinkedBlockingQueue<>();
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void j(Intent request) {
        CommandCallbackerInfo commandCallbackerInfo = new CommandCallbackerInfo();
        commandCallbackerInfo.uin = getAppRuntime().getAccount();
        String[] stringArrayExtra = request.getStringArrayExtra("pushCommands");
        ArrayList<String> arrayList = new ArrayList<>();
        Intrinsics.checkNotNull(stringArrayExtra);
        for (String str : stringArrayExtra) {
            arrayList.add(str);
        }
        commandCallbackerInfo.cmds = arrayList;
        ToServiceMsg registerCmdCallMsg = getAppRuntime().getService().msfSub.getRegisterCmdCallMsg(commandCallbackerInfo);
        QLog.i("KMsgServlet-MSF", 1, "serviceForActionRegisterCommandPush, size: " + arrayList.size());
        sendToMSF(request, registerCmdCallMsg);
    }

    private final void serviceForActionRegistMessagePushProxy(Intent request) {
        int intExtra = request.getIntExtra("appid", 0);
        String stringExtra = request.getStringExtra("processName");
        String stringExtra2 = request.getStringExtra("broadcastName");
        ArrayList<String> arrayList = new ArrayList<>();
        String[] stringArrayExtra = request.getStringArrayExtra("commands");
        if (stringArrayExtra != null) {
            for (String str : stringArrayExtra) {
                arrayList.add(str);
            }
        }
        NotifyRegisterInfo notifyRegisterInfo = new NotifyRegisterInfo();
        notifyRegisterInfo.uin = getAppRuntime().getAccount();
        notifyRegisterInfo.notifyIds = new ArrayList<>();
        notifyRegisterInfo.notifyProperties = new HashMap();
        CommandCallbackerInfo commandCallbackerInfo = new CommandCallbackerInfo();
        commandCallbackerInfo.uin = getAppRuntime().getAccount();
        commandCallbackerInfo.cmds = arrayList;
        ToServiceMsg registerProxyMsg = MsfServiceSdk.get().getRegisterProxyMsg(intExtra, getAppRuntime().getAccount(), stringExtra, stringExtra2, notifyRegisterInfo, commandCallbackerInfo);
        Intrinsics.checkNotNullExpressionValue(registerProxyMsg, "get().getRegisterProxyMs\u2026dCallbackerInfo\n        )");
        QLog.i("KMsgServlet-MSF", 1, "serviceForActionRegistMessagePushProxy, size: " + arrayList.size());
        i(request, registerProxyMsg);
    }

    @Override // mqq.app.MSFServlet
    @NotNull
    public String[] getPreferSSOCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        CopyOnWriteArraySet<String> copyOnWriteArraySet = f359145e;
        copyOnWriteArraySet.add(BaseConstants.CMD_TRPC_MSG_PUSH);
        copyOnWriteArraySet.add(BaseConstants.CMD_WAKE_FROM_DS);
        Object[] array = copyOnWriteArraySet.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public final void i(@NotNull Intent request, @NotNull ToServiceMsg msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) request, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        sendToMSF(request, msg2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.onCreate();
            f359146f = new java.lang.ref.WeakReference<>(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.Servlet
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onDestroy();
            f359146f = null;
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent request, @NotNull FromServiceMsg response) {
        Integer num;
        WeakReference<IQQNTWrapperSession> weakReference;
        IQQNTWrapperSession iQQNTWrapperSession;
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) request, (Object) response);
            return;
        }
        Intrinsics.checkNotNullParameter(response, "response");
        if ((!f359147h || !f359148i) && Intrinsics.areEqual(response.getServiceCmd(), BaseConstants.CMD_TRPC_MSG_PUSH)) {
            KLog.e(KLog.f359087a, "KMsgServlet-MSF", new Object[]{"KSC: cache MsgPush"}, null, 4, null);
            f359149m.add(response);
            return;
        }
        if (request != null && (extras = request.getExtras()) != null) {
            int i3 = extras.getInt("action", 0);
            KLog.c(KLog.f359087a, "KMsgServlet-MSF", new Object[]{"KSC: register receive: actionId= " + i3}, null, 4, null);
            return;
        }
        KLog kLog = KLog.f359087a;
        Object[] objArr = new Object[1];
        int resultCode = response.getResultCode();
        String serviceCmd = response.getServiceCmd();
        int requestSsoSeq = response.getRequestSsoSeq();
        int length = response.getWupBuffer().length;
        HashMap<String, byte[]> transInfo = response.getTransInfo();
        if (transInfo != null) {
            num = Integer.valueOf(transInfo.size());
        } else {
            num = null;
        }
        objArr[0] = "KSC: resultCode= " + resultCode + ", cmd=" + serviceCmd + " requestSsoSeq=" + requestSsoSeq + " length=" + length + ", transInfoList: " + num;
        KLog.i(kLog, "KMsgServlet-MSF", objArr, null, 4, null);
        if (response.isSuccess() && (weakReference = C) != null && (iQQNTWrapperSession = weakReference.get()) != null) {
            String serviceCmd2 = response.getServiceCmd();
            byte[] wupBuffer = response.getWupBuffer();
            Intrinsics.checkNotNullExpressionValue(wupBuffer, "wupBuffer");
            String serviceCmd3 = response.getServiceCmd();
            Intrinsics.checkNotNullExpressionValue(serviceCmd3, "serviceCmd");
            byte[] a16 = a.a(wupBuffer, serviceCmd3);
            PushExtraInfo pushExtraInfo = new PushExtraInfo();
            HashMap<String, byte[]> transInfo2 = response.getTransInfo();
            if (transInfo2 != null) {
                Intrinsics.checkNotNullExpressionValue(transInfo2, "transInfo");
                for (Map.Entry<String, byte[]> entry : transInfo2.entrySet()) {
                    HashMap<String, byte[]> hashMap = pushExtraInfo.transInfoMap;
                    Intrinsics.checkNotNullExpressionValue(hashMap, "info.transInfoMap");
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Unit unit = Unit.INSTANCE;
            iQQNTWrapperSession.onMsfPush(serviceCmd2, a16, pushExtraInfo);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent request, @Nullable Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) request, (Object) packet);
        }
    }

    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(@NotNull Intent request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        super.service(request);
        int intExtra = request.getIntExtra("action", 0);
        if (intExtra != 1025) {
            if (intExtra == 1040) {
                j(request);
                return;
            }
            return;
        }
        serviceForActionRegistMessagePushProxy(request);
    }
}
