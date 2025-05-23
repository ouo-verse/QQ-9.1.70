package com.tencent.qqnt.kernel.msf;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.internel.KLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MSFServlet;
import mqq.app.MainService;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u001c\u0010\u000f\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/kernel/msf/d;", "Lmqq/app/MSFServlet;", "", "a", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "Lmqq/app/Packet;", "packet", "", "onSend", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "msg", "sendToMSF", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "onReceive", "<init>", "()V", "d", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/kernel/msf/d$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "", "UINTYPE_NOLOGIN", "B", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.msf.d$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54625);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length + 4);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            try {
                dataOutputStream.writeInt(bArr.length + 4);
                dataOutputStream.write(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                    KLog.g(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"io failed"}, null, 4, null);
                }
                try {
                    dataOutputStream.close();
                } catch (IOException unused2) {
                    KLog.g(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"io failed"}, null, 4, null);
                }
                return byteArray;
            } catch (IOException e16) {
                e16.printStackTrace();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused3) {
                    KLog.g(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"io failed"}, null, 4, null);
                }
                try {
                    dataOutputStream.close();
                    return null;
                } catch (IOException unused4) {
                    KLog.g(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"io failed"}, null, 4, null);
                    return null;
                }
            }
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused5) {
                KLog.g(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"io failed"}, null, 4, null);
            }
            try {
                dataOutputStream.close();
                throw th5;
            } catch (IOException unused6) {
                KLog.g(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"io failed"}, null, 4, null);
                throw th5;
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(@Nullable Intent request, @Nullable FromServiceMsg response) {
        String str;
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) request, (Object) response);
            return;
        }
        if (request != null) {
            str = request.getStringExtra("cmd");
        } else {
            str = null;
        }
        QLog.d(MSFServlet.TAG, 1, "onReceive cmd: " + str);
        int i3 = 0;
        if (request != null && response != null) {
            Bundle extras = request.getExtras();
            if (extras != null) {
                String it = extras.getString("cmd");
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    KLog.i(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"onReceive cmd= " + it}, null, 4, null);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                    it = "";
                }
                if (unit == null) {
                    return;
                }
                if (response.getResultCode() == 1000) {
                    extras.putString("data_error_msg", "");
                } else {
                    extras.putString("data_error_msg", response.getBusinessFailMsg());
                    KLog.i(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"onReceive error: cmd=" + ((Object) it) + " response result=" + response.getResultCode() + " errMsg=" + response.getBusinessFailMsg()}, null, 4, null);
                    i3 = response.getResultCode();
                }
                byte[] wupBuffer = response.getWupBuffer();
                Intrinsics.checkNotNullExpressionValue(wupBuffer, "response.wupBuffer");
                extras.putByteArray("bytes_bodybuffer", a.b(wupBuffer, null, 1, null));
                extras.putInt("result", i3);
                extras.putInt("trpc_result", response.getTrpcRspRetCode());
                extras.putInt("trpc_func_result", response.getTrpcRspFuncRetCode());
                extras.putParcelable("from_service_msg_info", response);
                extras.putSerializable("trans_info", response.getTransInfo());
                notifyObserver(request, 0, response.isSuccess(), extras, null);
                return;
            }
            return;
        }
        KLog.g(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"onReceive null "}, null, 4, null);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(@Nullable Intent request, @Nullable Packet packet) {
        String stringExtra;
        byte[] a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request, (Object) packet);
            return;
        }
        if (request != null && (stringExtra = request.getStringExtra("cmd")) != null) {
            KLog.c(KLog.f359087a, "KernelECDHServlet-MSF", new Object[]{"onSend cmd=" + stringExtra + " reqAccType=" + request.getIntExtra("req_target_account_type", 0)}, null, 4, null);
            Intrinsics.checkNotNullExpressionValue(stringExtra, "req.getStringExtra(KServ\u2026)\n            } ?: return");
            byte[] byteArrayExtra = request.getByteArrayExtra("data");
            long longExtra = request.getLongExtra("timeout", 30000L);
            Serializable serializableExtra = request.getSerializableExtra("trans_info");
            Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
            HashMap<String, String> hashMap = (HashMap) serializableExtra;
            if (packet != null) {
                packet.setSSOCommand(stringExtra);
                if (byteArrayExtra != null && (a16 = a(byteArrayExtra)) != null) {
                    packet.putSendData(a16);
                }
                packet.setTimeout(longExtra);
                packet.setTransInfo(hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(@Nullable Intent request, @Nullable ToServiceMsg msg2) {
        String str;
        Integer num;
        String stringExtra;
        String stringExtra2;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) request, (Object) msg2);
            return;
        }
        boolean z17 = true;
        Integer num2 = null;
        if (request != null && (stringExtra2 = request.getStringExtra("trace_info")) != null) {
            if (stringExtra2.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                stringExtra2 = null;
            }
            if (stringExtra2 != null && msg2 != null) {
                msg2.setTraceInfo(stringExtra2);
            }
        }
        if (request != null) {
            str = request.getStringExtra("cmd");
        } else {
            str = null;
        }
        if (str != null && Intrinsics.areEqual(BaseConstants.CMD_MSG_PBSENDMSG, str) && msg2 != null) {
            msg2.addAttribute("normal_msg", Boolean.TRUE);
        }
        if (request != null) {
            num = Integer.valueOf(request.getIntExtra("req_target_account_type", 0));
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            if (msg2 != null) {
                msg2.addAttribute(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG, 32);
            }
            if (msg2 != null) {
                msg2.addAttribute(MainService.UIN_NOT_MATCH_TAG, "1");
            }
        }
        if (msg2 != null) {
            msg2.setUin("");
        }
        if (request != null && (stringExtra = request.getStringExtra("extra_uin")) != null && msg2 != null) {
            msg2.setUin(stringExtra);
        }
        byte b16 = 4;
        if (request != null) {
            b16 = request.getByteExtra("extra_uin_type", (byte) 4);
        }
        if (msg2 != null) {
            msg2.setUinType(b16);
        }
        QLog.d(MSFServlet.TAG, 1, "uinType = " + ((int) b16));
        if (msg2 != null) {
            if (request != null) {
                num2 = Integer.valueOf(request.getIntExtra("resend_num", 0));
            }
            Intrinsics.checkNotNull(num2);
            if (num2.intValue() <= 0) {
                z17 = false;
            }
            msg2.setIsSupportRetry(z17);
        }
        super.sendToMSF(request, msg2);
    }
}
