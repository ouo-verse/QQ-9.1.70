package com.tencent.mobileqq.soload.traces.base;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.traces.d;
import com.tencent.mobileqq.soload.traces.e;
import com.tencent.mobileqq.soload.traces.f;
import com.tencent.mobileqq.soload.traces.g;
import com.tencent.mobileqq.soload.traces.h;
import com.tencent.mobileqq.soload.traces.i;
import com.tencent.mobileqq.soload.traces.j;
import com.tencent.mobileqq.soload.traces.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/soload/traces/base/b;", "", "a", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/soload/traces/base/b$a;", "", "", "name", "Lcom/tencent/mobileqq/soload/traces/base/a;", "a", "<init>", "()V", "soloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.soload.traces.base.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final a a(@Nullable String name) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) name);
            }
            if (Intrinsics.areEqual(SoLoadConstants.SONAME_TPCORE_MASTER, name)) {
                return new j();
            }
            if (Intrinsics.areEqual(SoLoadConstants.SONAME_DOWNLOADPROXY, name)) {
                return new d();
            }
            if (Intrinsics.areEqual("ckguard", name)) {
                return new com.tencent.mobileqq.soload.traces.c();
            }
            if (Intrinsics.areEqual("ckeygeneratorV2", name)) {
                return new com.tencent.mobileqq.soload.traces.b();
            }
            if (Intrinsics.areEqual(SoLoadConstants.SONAME_SHARPDEC, name)) {
                return new g();
            }
            if (Intrinsics.areEqual(SoLoadConstants.SONAME_AV_HEVC_ENC, name)) {
                return new h();
            }
            if (Intrinsics.areEqual(SoLoadConstants.SONAME_AV_HEVC_DEC, name)) {
                return new f();
            }
            if (Intrinsics.areEqual(SoLoadConstants.SONAME_AV_HARDWARE_DETECT_SO, name)) {
                return new k();
            }
            if (Intrinsics.areEqual(SoLoadConstants.SONAME_AV_OLD_AVC_DEC, name)) {
                return new i();
            }
            if (Intrinsics.areEqual(SoLoadConstants.SONAME_IMSDK, name)) {
                return new e();
            }
            if (Intrinsics.areEqual(SoLoadConstants.BRICK_SO, name)) {
                return new com.tencent.mobileqq.soload.traces.a();
            }
            if (Intrinsics.areEqual(SoLoadConstants.LIBS_4_JSC, name)) {
                return new com.tencent.mobileqq.soload.traces.a();
            }
            if (Intrinsics.areEqual(SoLoadConstants.LIBS_4_CORE, name)) {
                return new com.tencent.mobileqq.soload.traces.a();
            }
            if (Intrinsics.areEqual(SoLoadConstants.APNG_SO, name)) {
                return new com.tencent.mobileqq.soload.traces.a();
            }
            if (Intrinsics.areEqual(SoLoadConstants.SONAME_QWALLET_CFTUTILS, name)) {
                return new c();
            }
            return null;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21133);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }
}
