package com.tencent.mobileqq.friend.servlet;

import android.os.Looper;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R&\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u001aj\b\u0012\u0004\u0012\u00020\u0006`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/friend/servlet/b;", "", "", "d", "", "cmd", "Lcom/tencent/mobileqq/friend/servlet/coder/a;", "b", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "data", "e", "f", "c", "Lcom/tencent/common/app/AppInterface;", "a", "Lcom/tencent/common/app/AppInterface;", "app", "", "I", "seq", "", "Z", "isCoderInit", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "mCoderSet", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppInterface app;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile int seq;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isCoderInit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashSet<com.tencent.mobileqq.friend.servlet.coder.a> mCoderSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/friend/servlet/b$a;", "", "", "KEY_REQUEST_TIME", "Ljava/lang/String;", "TAG", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.servlet.b$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34931);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        } else {
            this.app = app;
            this.mCoderSet = new HashSet<>();
        }
    }

    private final com.tencent.mobileqq.friend.servlet.coder.a b(String cmd) {
        if (!this.isCoderInit) {
            d();
        }
        Iterator<com.tencent.mobileqq.friend.servlet.coder.a> it = this.mCoderSet.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.friend.servlet.coder.a next = it.next();
            if (next.d(cmd)) {
                return next;
            }
        }
        return null;
    }

    private final synchronized void d() {
        QLog.d("IMCore.friend.FriendService", 1, "initJCECoder: " + this.isCoderInit);
        if (this.isCoderInit) {
            return;
        }
        this.mCoderSet.add(new com.tencent.mobileqq.friend.servlet.coder.c());
        this.mCoderSet.add(new com.tencent.mobileqq.friend.servlet.coder.b());
        this.isCoderInit = true;
    }

    private final void e(ToServiceMsg request, FromServiceMsg response, Object data) {
        this.app.getBusinessHandler(Reflection.getOrCreateKotlinClass(FriendHandler.class).getQualifiedName()).onReceive(request, response, data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void g(ToServiceMsg request, b this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String cmd = request.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendServlet", 2, "sendToService: " + cmd);
        }
        Intrinsics.checkNotNullExpressionValue(cmd, "cmd");
        com.tencent.mobileqq.friend.servlet.coder.a b16 = this$0.b(cmd);
        if (b16 != null) {
            z16 = true;
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            int i3 = this$0.seq;
            this$0.seq = i3 + 1;
            uniPacket.setRequestId(i3);
            if (b16.c(request, uniPacket)) {
                request.putWupBuffer(uniPacket.encode());
                if (!z16) {
                    request.extraData.putLong("KEY_REQUEST_TIME", System.currentTimeMillis());
                    NewIntent newIntent = new NewIntent(this$0.app.getApplication(), c.class);
                    newIntent.putExtra(ToServiceMsg.class.getSimpleName(), request);
                    this$0.app.startServlet(newIntent);
                    return;
                }
                this$0.e(request, new FromServiceMsg(request.getUin(), cmd), null);
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    public final void c(@NotNull ToServiceMsg request, @NotNull FromServiceMsg response) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) response);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccess()) {
            String serviceCmd = response.getServiceCmd();
            Intrinsics.checkNotNullExpressionValue(serviceCmd, "response.serviceCmd");
            com.tencent.mobileqq.friend.servlet.coder.a b16 = b(serviceCmd);
            if (b16 != null) {
                obj = b16.a(request, response);
                e(request, response, obj);
            } else {
                QLog.d("IMCore.friend.FriendServlet", 1, "onReceive[" + response.getServiceCmd() + "]: coder is null");
            }
        } else {
            QLog.d("IMCore.friend.FriendServlet", 1, "onReceive[" + response.getServiceCmd() + "]: response is fail");
        }
        obj = null;
        e(request, response, obj);
    }

    public final void f(@NotNull final ToServiceMsg request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.friend.servlet.a
            @Override // java.lang.Runnable
            public final void run() {
                b.g(ToServiceMsg.this, this);
            }
        };
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }
}
