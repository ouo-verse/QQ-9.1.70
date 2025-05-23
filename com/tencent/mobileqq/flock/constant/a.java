package com.tencent.mobileqq.flock.constant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vfs.IVFSAssistantApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/flock/constant/a;", "", "", "b", "Ljava/lang/String;", "FLOCK_PRIVATE_ROOT_PATH", "c", "getFLOCK_FILE_PRIVATE_ROOT_PATH", "()Ljava/lang/String;", "FLOCK_FILE_PRIVATE_ROOT_PATH", "d", "a", "FLOCK_DOWNLOAD_ROOT_PATH", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f210005a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String FLOCK_PRIVATE_ROOT_PATH;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String FLOCK_FILE_PRIVATE_ROOT_PATH;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String FLOCK_DOWNLOAD_ROOT_PATH;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24767);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f210005a = new a();
        String sDKPrivatePath = ((IVFSAssistantApi) QRoute.api(IVFSAssistantApi.class)).getSDKPrivatePath("flock/");
        Intrinsics.checkNotNullExpressionValue(sDKPrivatePath, "api(IVFSAssistantApi::cl\u2026tSDKPrivatePath(\"flock/\")");
        FLOCK_PRIVATE_ROOT_PATH = sDKPrivatePath;
        String str = sDKPrivatePath + ProtocolDownloaderConstants.FILE_PREFIX;
        FLOCK_FILE_PRIVATE_ROOT_PATH = str;
        FLOCK_DOWNLOAD_ROOT_PATH = str + "download/";
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return FLOCK_DOWNLOAD_ROOT_PATH;
    }
}
