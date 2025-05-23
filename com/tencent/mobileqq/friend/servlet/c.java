package com.tencent.mobileqq.friend.servlet;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/friend/servlet/c;", "Lmqq/app/MSFServlet;", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "<init>", "()V", "d", "a", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/friend/servlet/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.servlet.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34941);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent request, @NotNull FromServiceMsg response) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) response);
            return;
        }
        Intrinsics.checkNotNullParameter(response, "response");
        ToServiceMsg toServiceMsg = new ToServiceMsg("", response.getUin(), response.getServiceCmd());
        if (request != null) {
            ToServiceMsg toServiceMsg2 = (ToServiceMsg) request.getParcelableExtra(Reflection.getOrCreateKotlinClass(ToServiceMsg.class).getSimpleName());
            if (toServiceMsg2 == null) {
                toServiceMsg2 = new ToServiceMsg("", response.getUin(), response.getServiceCmd());
            }
            toServiceMsg = toServiceMsg2;
            HashMap<String, Object> hashMap = response.attributes;
            Intrinsics.checkNotNullExpressionValue(hashMap, "response.attributes");
            hashMap.put(Reflection.getOrCreateKotlinClass(FromServiceMsg.class).getSimpleName(), toServiceMsg);
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendServlet", 2, "onReceive| toMsg cmd: " + toServiceMsg.getServiceCmd());
        }
        AppRuntime appRuntime = getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) appRuntime).getBusinessHandler(Reflection.getOrCreateKotlinClass(FriendHandler.class).getQualifiedName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.friend.handler.FriendHandler");
        ((FriendHandler) businessHandler).I2().c(toServiceMsg, response);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent request, @Nullable Packet packet) {
        ToServiceMsg toServiceMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request, (Object) packet);
            return;
        }
        String str = null;
        if (request != null) {
            toServiceMsg = (ToServiceMsg) request.getParcelableExtra(Reflection.getOrCreateKotlinClass(ToServiceMsg.class).getSimpleName());
        } else {
            toServiceMsg = null;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onSend| toMsg cmd: ");
            if (toServiceMsg != null) {
                str = toServiceMsg.getServiceCmd();
            }
            sb5.append(str);
            QLog.d("IMCore.friend.FriendServlet", 2, sb5.toString());
        }
        if (toServiceMsg != null) {
            if (packet != null) {
                packet.setSSOCommand(toServiceMsg.getServiceCmd());
            }
            if (packet != null) {
                packet.putSendData(toServiceMsg.getWupBuffer());
            }
            if (packet != null) {
                packet.setTimeout(toServiceMsg.getTimeout());
            }
            if (packet != null) {
                packet.setAttributes(toServiceMsg.getAttributes());
            }
            if (!toServiceMsg.isNeedCallback() && packet != null) {
                packet.setNoResponse();
            }
        }
    }
}
