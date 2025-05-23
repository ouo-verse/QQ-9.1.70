package com.tencent.mobileqq.opr.helper.repair.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/opr/helper/repair/model/OprStatus;", "", "success", "", "errorCode", "", "errorMessage", "", "(Ljava/lang/String;IZJLjava/lang/String;)V", "getErrorCode", "()J", "getErrorMessage", "()Ljava/lang/String;", "getSuccess", "()Z", "Success", "SuccessFromCache", "GetInputBitmapFail", "GetOprInstanceFail", "DoOprFail", "CheckSafetyFail", "UnsupportImage", "UploadResultFail", "opr_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class OprStatus {
    private static final /* synthetic */ OprStatus[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final OprStatus CheckSafetyFail;
    public static final OprStatus DoOprFail;
    public static final OprStatus GetInputBitmapFail;
    public static final OprStatus GetOprInstanceFail;
    public static final OprStatus Success;
    public static final OprStatus SuccessFromCache;
    public static final OprStatus UnsupportImage;
    public static final OprStatus UploadResultFail;
    private final long errorCode;

    @Nullable
    private final String errorMessage;
    private final boolean success;

    private static final /* synthetic */ OprStatus[] $values() {
        return new OprStatus[]{Success, SuccessFromCache, GetInputBitmapFail, GetOprInstanceFail, DoOprFail, CheckSafetyFail, UnsupportImage, UploadResultFail};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9743);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        Success = new OprStatus("Success", 0, true, 0L, null, 4, null);
        SuccessFromCache = new OprStatus("SuccessFromCache", 1, true, 1L, null, 4, null);
        GetInputBitmapFail = new OprStatus("GetInputBitmapFail", 2, false, 2L, "get input bitmap fail");
        GetOprInstanceFail = new OprStatus("GetOprInstanceFail", 3, false, 3L, "get opr instance fail");
        DoOprFail = new OprStatus("DoOprFail", 4, false, 4L, "do opr fail");
        CheckSafetyFail = new OprStatus("CheckSafetyFail", 5, false, 5L, "check safety fail");
        UnsupportImage = new OprStatus("UnsupportImage", 6, false, 6L, "unsupport image");
        UploadResultFail = new OprStatus("UploadResultFail", 7, false, 7L, "upload image result fail");
        $VALUES = $values();
    }

    OprStatus(String str, int i3, boolean z16, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), str2);
            return;
        }
        this.success = z16;
        this.errorCode = j3;
        this.errorMessage = str2;
    }

    public static OprStatus valueOf(String str) {
        return (OprStatus) Enum.valueOf(OprStatus.class, str);
    }

    public static OprStatus[] values() {
        return (OprStatus[]) $VALUES.clone();
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

    /* synthetic */ OprStatus(String str, int i3, boolean z16, long j3, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, z16, j3, (i16 & 4) != 0 ? null : str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j3), str2, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
