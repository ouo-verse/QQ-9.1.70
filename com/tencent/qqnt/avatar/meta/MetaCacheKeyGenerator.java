package com.tencent.qqnt.avatar.meta;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.util.d;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ%\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a2\u0006\u0004\b\n\u0010\tR\u001b\u0010\u000f\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/MetaCacheKeyGenerator;", "", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "infoArr", "", "a", "(Lcom/tencent/qqnt/avatar/meta/b;[Lcom/tencent/qqnt/avatar/meta/info/a;)Ljava/lang/String;", "b", "", "Lkotlin/Lazy;", "c", "()Z", "useNewGeneratorKey", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MetaCacheKeyGenerator {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MetaCacheKeyGenerator f352879a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy useNewGeneratorKey;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39847);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f352879a = new MetaCacheKeyGenerator();
        lazy = LazyKt__LazyJVMKt.lazy(MetaCacheKeyGenerator$useNewGeneratorKey$2.INSTANCE);
        useNewGeneratorKey = lazy;
    }

    MetaCacheKeyGenerator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public String a(@NotNull b avatarBean, @Nullable com.tencent.qqnt.avatar.meta.info.a[] infoArr) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) avatarBean, (Object) infoArr);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        if (c()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(avatarBean.h());
            sb5.append(util.base64_pad_url);
            sb5.append(avatarBean.e());
            if (!avatarBean.n()) {
                sb5.append("_no_circle");
            }
            com.tencent.qqnt.avatar.meta.cache.b a16 = com.tencent.qqnt.avatar.meta.cache.a.f352913a.a();
            if (a16 != null) {
                str = a16.a(avatarBean, infoArr);
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                sb5.append(str);
            }
            if (infoArr != null) {
                for (com.tencent.qqnt.avatar.meta.info.a aVar : infoArr) {
                    sb5.append(aVar.c());
                }
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "ssb.toString()");
                byte[] bytes = sb6.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                messageDigest.update(bytes);
                String c16 = c.c(messageDigest.digest());
                Intrinsics.checkNotNullExpressionValue(c16, "{\n                val me\u2026t.digest())\n            }");
                return c16;
            } catch (Exception e16) {
                d.f352991a.c("MetaCacheKeyGenerator", "generate key error:", e16);
                String sb7 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb7, "{\n                ProAva\u2026.toString()\n            }");
                return sb7;
            }
        }
        return b(avatarBean, infoArr);
    }

    @NotNull
    public final String b(@NotNull b avatarBean, @Nullable com.tencent.qqnt.avatar.meta.info.a[] infoArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) avatarBean, (Object) infoArr);
        }
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(avatarBean.d());
        if (infoArr != null) {
            for (com.tencent.qqnt.avatar.meta.info.a aVar : infoArr) {
                sb5.append(aVar.c());
            }
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "ssb.toString()");
            byte[] bytes = sb6.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            String c16 = c.c(messageDigest.digest());
            Intrinsics.checkNotNullExpressionValue(c16, "{\n            val messag\u2026igest.digest())\n        }");
            return c16;
        } catch (Exception e16) {
            d.f352991a.c("MetaCacheKeyGenerator", "generate old key error:", e16);
            String sb7 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb7, "{\n            ProAvatarL\u2026 ssb.toString()\n        }");
            return sb7;
        }
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((Boolean) useNewGeneratorKey.getValue()).booleanValue();
    }
}
