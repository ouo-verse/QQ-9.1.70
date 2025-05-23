package com.tencent.mobileqq.opr.helper.sr.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/sr/model/SrStatus;", "", "success", "", "errorCode", "", "errorMessage", "", "(Ljava/lang/String;IZJLjava/lang/String;)V", "getErrorCode", "()J", "getErrorMessage", "()Ljava/lang/String;", "getSuccess", "()Z", "Success", "SuccessFromCache", "GetInputBitmapFail", "GetSrInstanceFail", "DoSrFail", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class SrStatus {
    private static final /* synthetic */ SrStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final SrStatus DoSrFail;
    public static final SrStatus GetInputBitmapFail;
    public static final SrStatus GetSrInstanceFail;
    public static final SrStatus Success;
    public static final SrStatus SuccessFromCache;
    private final long errorCode;

    @Nullable
    private final String errorMessage;
    private final boolean success;

    private static final /* synthetic */ SrStatus[] $values() {
        return new SrStatus[]{Success, SuccessFromCache, GetInputBitmapFail, GetSrInstanceFail, DoSrFail};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10319);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        Success = new SrStatus("Success", 0, true, 0L, null, 4, null);
        SuccessFromCache = new SrStatus("SuccessFromCache", 1, true, 1L, null, 4, null);
        GetInputBitmapFail = new SrStatus("GetInputBitmapFail", 2, false, 2L, "get input bitmap fail");
        GetSrInstanceFail = new SrStatus("GetSrInstanceFail", 3, false, 3L, "get superResolution instance fail");
        DoSrFail = new SrStatus("DoSrFail", 4, false, 4L, "do superResolution fail");
        $VALUES = $values();
    }

    SrStatus(String str, int i3, boolean z16, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), str2);
            return;
        }
        this.success = z16;
        this.errorCode = j3;
        this.errorMessage = str2;
    }

    public static SrStatus valueOf(String str) {
        return (SrStatus) Enum.valueOf(SrStatus.class, str);
    }

    public static SrStatus[] values() {
        return (SrStatus[]) $VALUES.clone();
    }

    public final long getErrorCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.errorCode;
    }

    @Nullable
    public final String getErrorMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.errorMessage;
    }

    public final boolean getSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.success;
    }

    /* synthetic */ SrStatus(String str, int i3, boolean z16, long j3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, z16, j3, (i16 & 4) != 0 ? null : str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), str2, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
