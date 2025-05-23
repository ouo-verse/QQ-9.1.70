package com.tencent.mobileqq.groupvideo.debug;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u00002\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "showText", "Lkotlin/Lazy;", "Lcom/tencent/mobileqq/groupvideo/debug/l;", "Lkotlin/Lazy;", "()Lkotlin/Lazy;", "envControl", "<init>", "(Ljava/lang/String;Lkotlin/Lazy;)V", "BizLoginEnv", "FastestEnv", "SandBoxPayEnv", "SealEnv", "group-video-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class EnvConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String showText;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy<l> envControl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig$BizLoginEnv;", "Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig;", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class BizLoginEnv extends EnvConfig {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final BizLoginEnv f213756c;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24002);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f213756c = new BizLoginEnv();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        BizLoginEnv() {
            super("\u4e1a\u52a1\u6d4b\u8bd5\u73af\u5883", r0);
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(AnonymousClass1.INSTANCE);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig$FastestEnv;", "Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig;", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class FastestEnv extends EnvConfig {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final FastestEnv f213757c;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24093);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f213757c = new FastestEnv();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        FastestEnv() {
            super("Fastest\u8c03\u8bd5\u5f00\u5173", r0);
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(AnonymousClass1.INSTANCE);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig$SandBoxPayEnv;", "Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig;", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class SandBoxPayEnv extends EnvConfig {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final SandBoxPayEnv f213758c;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24106);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f213758c = new SandBoxPayEnv();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        SandBoxPayEnv() {
            super("\u6c99\u7bb1\u652f\u4ed8(\u8981\u5148\u8bbe\u7f6e\u4e1a\u52a1\u6d4b\u8bd5\u73af\u5883)", r0);
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(AnonymousClass1.INSTANCE);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig$SealEnv;", "Lcom/tencent/mobileqq/groupvideo/debug/EnvConfig;", "()V", "group-video-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class SealEnv extends EnvConfig {
        static IPatchRedirector $redirector_;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public static final SealEnv f213759c;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24128);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f213759c = new SealEnv();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        SealEnv() {
            super("\u6d77\u8c79\u8c03\u8bd5\u5f00\u5173", r0);
            Lazy lazy;
            lazy = LazyKt__LazyJVMKt.lazy(AnonymousClass1.INSTANCE);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EnvConfig(@NotNull String showText, @NotNull Lazy<? extends l> envControl) {
        Intrinsics.checkNotNullParameter(showText, "showText");
        Intrinsics.checkNotNullParameter(envControl, "envControl");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) showText, (Object) envControl);
        } else {
            this.showText = showText;
            this.envControl = envControl;
        }
    }

    @NotNull
    public final Lazy<l> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Lazy) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.envControl;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.showText;
    }
}
