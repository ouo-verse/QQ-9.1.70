package com.tencent.qqnt.aio.assistedchat.servlet;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/servlet/c;", "Lmqq/app/MSFServlet;", "", "a", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "<init>", "()V", "d", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/servlet/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.servlet.c$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60091);
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

    private final String a() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return new Regex("[^(0-9A-Za-z)]").replace(uuid, "");
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent request, @Nullable FromServiceMsg response) {
        boolean z16;
        byte[] bArr;
        BusinessObserver observer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) response);
            return;
        }
        if (request != null && response != null) {
            String stringExtra = request.getStringExtra("cmd");
            if (stringExtra != null && stringExtra.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                QLog.w("AssistedChatServlet", 1, "onReceive cmd is null");
                return;
            }
            QLog.i("AssistedChatServlet", 1, "onReceive cmd=" + stringExtra + " failCode=" + response.getBusinessFailCode() + " failMsg=" + response.getBusinessFailMsg() + " trpcRspRetCode=" + response.getTrpcRspRetCode());
            NewIntent newIntent = null;
            if (response.isSuccess() && response.getWupBuffer() != null) {
                bArr = fh.a(response.getWupBuffer());
            } else {
                bArr = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("cmd", stringExtra);
            bundle.putInt("code", response.getBusinessFailCode());
            String businessFailMsg = response.getBusinessFailMsg();
            if (businessFailMsg == null) {
                businessFailMsg = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(businessFailMsg, "response.businessFailMsg ?: \"\"");
            }
            bundle.putString("msg", businessFailMsg);
            if (bArr != null) {
                bundle.putByteArray("rspBody", bArr);
            }
            if (request instanceof NewIntent) {
                newIntent = (NewIntent) request;
            }
            if (newIntent != null && (observer = newIntent.getObserver()) != null) {
                observer.onReceive(0, response.isSuccess(), bundle);
                return;
            }
            return;
        }
        QLog.w("AssistedChatServlet", 1, "onReceive request or response is null");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent request, @Nullable Packet packet) {
        String str;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request, (Object) packet);
            return;
        }
        byte[] bArr = null;
        if (request != null) {
            str = request.getStringExtra("cmd");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("AssistedChatServlet", 1, "onSend cmd is null");
            return;
        }
        if (request != null) {
            bArr = request.getByteArrayExtra("reqBody");
        }
        if (packet != null) {
            packet.setSSOCommand(str);
            String a16 = a();
            packet.setTraceInfo(a16);
            if (bArr != null) {
                packet.putSendData(fh.b(bArr));
            }
            QLog.i("AssistedChatServlet", 1, "onSend cmd=" + str + " traceInfo=" + a16);
        }
    }
}
