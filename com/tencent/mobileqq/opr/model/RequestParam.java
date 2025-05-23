package com.tencent.mobileqq.opr.model;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NativeProxy(allFields = true, allMethods = true)
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/opr/model/RequestParam;", "", "cmd", "", "req", "", "reqClass", "rspClass", "oidbCmdId", "", "oidbServiceType", "(Ljava/lang/String;[BLjava/lang/String;Ljava/lang/String;II)V", "getCmd", "()Ljava/lang/String;", "getOidbCmdId", "()I", "getOidbServiceType", "getReq", "()[B", "getReqClass", "getRspClass", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class RequestParam {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String cmd;
    private final int oidbCmdId;
    private final int oidbServiceType;

    @NotNull
    private final byte[] req;

    @NotNull
    private final String reqClass;

    @NotNull
    private final String rspClass;

    public RequestParam(@NotNull String cmd, @NotNull byte[] req, @NotNull String reqClass, @NotNull String rspClass, int i3, int i16) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(reqClass, "reqClass");
        Intrinsics.checkNotNullParameter(rspClass, "rspClass");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cmd, req, reqClass, rspClass, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.cmd = cmd;
        this.req = req;
        this.reqClass = reqClass;
        this.rspClass = rspClass;
        this.oidbCmdId = i3;
        this.oidbServiceType = i16;
    }

    public static /* synthetic */ RequestParam copy$default(RequestParam requestParam, String str, byte[] bArr, String str2, String str3, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = requestParam.cmd;
        }
        if ((i17 & 2) != 0) {
            bArr = requestParam.req;
        }
        byte[] bArr2 = bArr;
        if ((i17 & 4) != 0) {
            str2 = requestParam.reqClass;
        }
        String str4 = str2;
        if ((i17 & 8) != 0) {
            str3 = requestParam.rspClass;
        }
        String str5 = str3;
        if ((i17 & 16) != 0) {
            i3 = requestParam.oidbCmdId;
        }
        int i18 = i3;
        if ((i17 & 32) != 0) {
            i16 = requestParam.oidbServiceType;
        }
        return requestParam.copy(str, bArr2, str4, str5, i18, i16);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.cmd;
    }

    @NotNull
    public final byte[] component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (byte[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.req;
    }

    @NotNull
    public final String component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.reqClass;
    }

    @NotNull
    public final String component4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.rspClass;
    }

    public final int component5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.oidbCmdId;
    }

    public final int component6() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.oidbServiceType;
    }

    @NotNull
    public final RequestParam copy(@NotNull String cmd, @NotNull byte[] req, @NotNull String reqClass, @NotNull String rspClass, int oidbCmdId, int oidbServiceType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (RequestParam) iPatchRedirector.redirect((short) 15, this, cmd, req, reqClass, rspClass, Integer.valueOf(oidbCmdId), Integer.valueOf(oidbServiceType));
        }
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(reqClass, "reqClass");
        Intrinsics.checkNotNullParameter(rspClass, "rspClass");
        return new RequestParam(cmd, req, reqClass, rspClass, oidbCmdId, oidbServiceType);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestParam)) {
            return false;
        }
        RequestParam requestParam = (RequestParam) other;
        if (Intrinsics.areEqual(this.cmd, requestParam.cmd) && Intrinsics.areEqual(this.req, requestParam.req) && Intrinsics.areEqual(this.reqClass, requestParam.reqClass) && Intrinsics.areEqual(this.rspClass, requestParam.rspClass) && this.oidbCmdId == requestParam.oidbCmdId && this.oidbServiceType == requestParam.oidbServiceType) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.cmd;
    }

    public final int getOidbCmdId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.oidbCmdId;
    }

    public final int getOidbServiceType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.oidbServiceType;
    }

    @NotNull
    public final byte[] getReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.req;
    }

    @NotNull
    public final String getReqClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.reqClass;
    }

    @NotNull
    public final String getRspClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.rspClass;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return (((((((((this.cmd.hashCode() * 31) + Arrays.hashCode(this.req)) * 31) + this.reqClass.hashCode()) * 31) + this.rspClass.hashCode()) * 31) + this.oidbCmdId) * 31) + this.oidbServiceType;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "RequestParam(cmd=" + this.cmd + ", req=" + Arrays.toString(this.req) + ", reqClass=" + this.reqClass + ", rspClass=" + this.rspClass + ", oidbCmdId=" + this.oidbCmdId + ", oidbServiceType=" + this.oidbServiceType + ')';
    }

    public /* synthetic */ RequestParam(String str, byte[] bArr, String str2, String str3, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bArr, str2, str3, (i17 & 16) != 0 ? 0 : i3, (i17 & 32) != 0 ? 0 : i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, bArr, str2, str3, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
    }
}
