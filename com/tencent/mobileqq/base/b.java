package com.tencent.mobileqq.base;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.HexUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/base/b;", "", "", "a", "", "b", "", "c", "d", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f200276a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f200276a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final int a() {
        return AppSetting.f();
    }

    @JvmStatic
    @NotNull
    public static final String b() {
        return String.valueOf(a());
    }

    @JvmStatic
    @NotNull
    public static final byte[] c() {
        byte[] GUID = NetConnInfoCenter.GUID;
        Intrinsics.checkNotNullExpressionValue(GUID, "GUID");
        return GUID;
    }

    @JvmStatic
    @NotNull
    public static final String d() {
        String bytes2HexStr = HexUtil.bytes2HexStr(c());
        if (bytes2HexStr == null) {
            return "";
        }
        return bytes2HexStr;
    }
}
