package com.tencent.mobileqq.loginregister.servlet;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.ScanQrRspInfo;
import com.tencent.qqnt.kernel.nativeinterface.ScanScene;
import com.tencent.qqnt.kernel.nativeinterface.SwitchOperation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\r\u001a\u00020\bH&J\b\u0010\u000e\u001a\u00020\bH&R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R$\u0010$\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001e\u001a\u0004\b\u000f\u0010\u001f\"\u0004\b#\u0010!R$\u0010+\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/loginregister/servlet/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanScene;", "scene", "", "qrSig", "Lf72/a;", "callback", "", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/SwitchOperation;", "opSwitch", "f", "g", tl.h.F, "a", "[B", "b", "()[B", "k", "([B)V", "", "I", "d", "()I", "l", "(I)V", "qrVerifyResult", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "setQrVerifyErrorMsg", "(Ljava/lang/String;)V", "qrVerifyErrorMsg", "j", "qrCodeStr", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrRspInfo;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrRspInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrRspInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/qqnt/kernel/nativeinterface/ScanQrRspInfo;)V", "scanQrRspInfo", "<init>", "()V", "qqlogin-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private byte[] qrSig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int qrVerifyResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String qrVerifyErrorMsg;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String qrCodeStr;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ScanQrRspInfo scanQrRspInfo;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.qrVerifyResult = -1;
        }
    }

    @Nullable
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.qrCodeStr;
    }

    @Nullable
    public final byte[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.qrSig;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.qrVerifyErrorMsg;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.qrVerifyResult;
    }

    @Nullable
    public final ScanQrRspInfo e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ScanQrRspInfo) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.scanQrRspInfo;
    }

    public abstract void f(@NotNull SwitchOperation opSwitch, @NotNull f72.a callback);

    public abstract void g();

    public abstract void h();

    public abstract void i(@NotNull ScanScene scene, @NotNull byte[] qrSig, @NotNull f72.a callback);

    public final void j(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.qrCodeStr = str;
        }
    }

    public final void k(@Nullable byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr);
        } else {
            this.qrSig = bArr;
        }
    }

    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.qrVerifyResult = i3;
        }
    }

    public final void m(@Nullable ScanQrRspInfo scanQrRspInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) scanQrRspInfo);
        } else {
            this.scanQrRspInfo = scanQrRspInfo;
        }
    }
}
