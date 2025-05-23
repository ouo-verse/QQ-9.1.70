package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/a;", "", "a", "qqavatar-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/avatar/api/a$a;", "", "", "isSuccess", "", "errCode", "", "avatarType", "", "b", "c", "a", "avatarDownloadResultTag", "Ljava/lang/String;", "avatarInfoQueryResultTag", "avatarLoadResultTag", "avatarTypeApng", "avatarTypeDefault", "avatarTypeDynamic", "avatarTypeKey", "avatarTypeStatic", "avatarUploadErrCodeKey", "<init>", "()V", "qqavatar-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.avatar.api.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a(boolean isSuccess, int errCode, @NotNull String avatarType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(isSuccess), Integer.valueOf(errCode), avatarType);
                return;
            }
            Intrinsics.checkNotNullParameter(avatarType, "avatarType");
            HashMap hashMap = new HashMap();
            hashMap.put("avatartype", avatarType);
            hashMap.put("errorCode", String.valueOf(errCode));
            com.tencent.relation.common.report.a.b("relation_avatar_download", isSuccess, hashMap);
        }

        @JvmStatic
        public final void b(boolean isSuccess, int errCode, @NotNull String avatarType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(errCode), avatarType);
                return;
            }
            Intrinsics.checkNotNullParameter(avatarType, "avatarType");
            HashMap hashMap = new HashMap();
            hashMap.put("avatartype", avatarType);
            hashMap.put("errorCode", String.valueOf(errCode));
            com.tencent.relation.common.report.a.b("relation_avatar_upload", isSuccess, hashMap);
        }

        @JvmStatic
        public final void c(boolean isSuccess, int errCode, @NotNull String avatarType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), Integer.valueOf(errCode), avatarType);
                return;
            }
            Intrinsics.checkNotNullParameter(avatarType, "avatarType");
            HashMap hashMap = new HashMap();
            hashMap.put("avatartype", avatarType);
            hashMap.put("errorCode", String.valueOf(errCode));
            com.tencent.relation.common.report.a.b("relation_avatar_request_avatarinfo", isSuccess, hashMap);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmStatic
    public static final void a(boolean z16, int i3, @NotNull String str) {
        INSTANCE.a(z16, i3, str);
    }

    @JvmStatic
    public static final void b(boolean z16, int i3, @NotNull String str) {
        INSTANCE.b(z16, i3, str);
    }

    @JvmStatic
    public static final void c(boolean z16, int i3, @NotNull String str) {
        INSTANCE.c(z16, i3, str);
    }
}
