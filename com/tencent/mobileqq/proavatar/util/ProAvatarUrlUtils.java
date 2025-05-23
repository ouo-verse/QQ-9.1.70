package com.tencent.mobileqq.proavatar.util;

import android.net.Uri;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001b\u0010\r\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u0007\u001a\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/proavatar/util/ProAvatarUrlUtils;", "", "", "originUrl", "a", "Lcom/tencent/mobileqq/avatar/api/IQQAvatarUtilApi;", "b", "Lkotlin/Lazy;", "c", "()Lcom/tencent/mobileqq/avatar/api/IQQAvatarUtilApi;", "qqAvatarUtilApi", "", "()Z", "ipv6Pre", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProAvatarUrlUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ProAvatarUrlUtils f259699a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy qqAvatarUtilApi;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy ipv6Pre;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18275);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f259699a = new ProAvatarUrlUtils();
        lazy = LazyKt__LazyJVMKt.lazy(ProAvatarUrlUtils$qqAvatarUtilApi$2.INSTANCE);
        qqAvatarUtilApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ProAvatarUrlUtils$ipv6Pre$2.INSTANCE);
        ipv6Pre = lazy2;
    }

    ProAvatarUrlUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b() {
        return ((Boolean) ipv6Pre.getValue()).booleanValue();
    }

    private final IQQAvatarUtilApi c() {
        return (IQQAvatarUtilApi) qqAvatarUtilApi.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(@NotNull String originUrl) {
        boolean z16;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) originUrl);
        }
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Uri parse = Uri.parse(originUrl);
        String host = parse.getHost();
        boolean z17 = false;
        if (host != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(host);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return originUrl;
                }
                String ip5 = c().getIp(host, !b());
                if (ip5 == null || ip5.length() == 0) {
                    z17 = true;
                }
                if (z17) {
                    return originUrl;
                }
                Uri.Builder buildUpon = parse.buildUpon();
                buildUpon.authority(ip5);
                String uri = buildUpon.build().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "builder.build().toString()");
                return uri;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
