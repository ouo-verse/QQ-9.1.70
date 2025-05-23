package com.tencent.mobileqq.qwallet.impl.servlet;

import com.qq.taf.jce.JceStruct;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 32\u00020\u0001:\u00014BA\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0010\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010$\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qwallet/impl/servlet/QWalletCommonRequest;", "Ljava/io/Serializable;", "", "toString", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "Lcom/qq/taf/jce/JceStruct;", "decodeResponse", "", "cmdType", "I", "getCmdType", "()I", "req", "Lcom/qq/taf/jce/JceStruct;", "getReq", "()Lcom/qq/taf/jce/JceStruct;", "Ljava/lang/Class;", "rspClazz", "Ljava/lang/Class;", "ssoCommand", "Ljava/lang/String;", "getSsoCommand", "()Ljava/lang/String;", "funcName", "getFuncName", "servantName", "getServantName", "", "timeoutMs", "J", "getTimeoutMs", "()J", "setTimeoutMs", "(J)V", "", "callbackOnSubThread", "Z", "getCallbackOnSubThread", "()Z", "setCallbackOnSubThread", "(Z)V", "Lcom/tencent/mobileqq/qwallet/impl/servlet/a;", "decorator", "Lcom/tencent/mobileqq/qwallet/impl/servlet/a;", "getDecorator", "()Lcom/tencent/mobileqq/qwallet/impl/servlet/a;", "setDecorator", "(Lcom/tencent/mobileqq/qwallet/impl/servlet/a;)V", "<init>", "(ILcom/qq/taf/jce/JceStruct;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class QWalletCommonRequest implements Serializable {

    @NotNull
    public static final String TAG = "QWalletCommonRequest";
    private boolean callbackOnSubThread;
    private final int cmdType;

    @Nullable
    private a decorator;

    @NotNull
    private final String funcName;

    @NotNull
    private final JceStruct req;

    @Nullable
    private final Class<? extends JceStruct> rspClazz;

    @NotNull
    private final String servantName;

    @NotNull
    private final String ssoCommand;
    private long timeoutMs;

    public QWalletCommonRequest(int i3, @NotNull JceStruct req, @Nullable Class<? extends JceStruct> cls, @NotNull String ssoCommand, @NotNull String funcName, @NotNull String servantName) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(ssoCommand, "ssoCommand");
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(servantName, "servantName");
        this.cmdType = i3;
        this.req = req;
        this.rspClazz = cls;
        this.ssoCommand = ssoCommand;
        this.funcName = funcName;
        this.servantName = servantName;
        this.timeoutMs = 30000L;
    }

    @Nullable
    public JceStruct decodeResponse(@NotNull FromServiceMsg response) {
        JceStruct jceStruct;
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            byte[] wupBuffer = response.getWupBuffer();
            Class<? extends JceStruct> cls = this.rspClazz;
            if (cls != null) {
                jceStruct = cls.newInstance();
            } else {
                jceStruct = null;
            }
            return (JceStruct) Packet.decodePacket(wupBuffer, "rsp", jceStruct);
        } catch (IllegalAccessException e16) {
            QLog.w(TAG, 1, "onReceive, decode " + this.rspClazz + " fail, ", e16);
            return null;
        } catch (InstantiationException e17) {
            QLog.w(TAG, 1, "onReceive, decode " + this.rspClazz + " fail, ", e17);
            return null;
        }
    }

    public final boolean getCallbackOnSubThread() {
        return this.callbackOnSubThread;
    }

    public final int getCmdType() {
        return this.cmdType;
    }

    @Nullable
    public final a getDecorator() {
        return null;
    }

    @NotNull
    public final String getFuncName() {
        return this.funcName;
    }

    @NotNull
    public final JceStruct getReq() {
        return this.req;
    }

    @NotNull
    public final String getServantName() {
        return this.servantName;
    }

    @NotNull
    public final String getSsoCommand() {
        return this.ssoCommand;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final void setCallbackOnSubThread(boolean z16) {
        this.callbackOnSubThread = z16;
    }

    public final void setTimeoutMs(long j3) {
        this.timeoutMs = j3;
    }

    @NotNull
    public String toString() {
        return this.req.getClass().getSimpleName() + "|" + this.req;
    }

    public final void setDecorator(@Nullable a aVar) {
    }
}
