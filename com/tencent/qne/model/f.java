package com.tencent.qne.model;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.vivo.push.PushClientConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000 \u00132\u00020\u0001:\u0007\u0014\u0015\u0016\u0017\u0018\u0019\u0005BG\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qne/model/f;", "Lcom/tencent/qne/model/Backend;", "", "hardware", "", "g", "", "Ljava/util/List;", "getSupportedHardware", "()Ljava/util/List;", "supportedHardware", PushClientConstants.TAG_CLASS_NAME, "name", "Lcom/tencent/qne/model/DependencyLibrary;", "dependency", "preferredResourceSuffix", "fallbackResourceSuffix", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", h.F, "a", "b", "c", "d", "e", "f", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public abstract class f extends Backend {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> supportedHardware;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qne/model/f$a;", "", "", "Lcom/tencent/qne/model/f;", "b", "a", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.qne.model.f$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
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

        private final f b(String str) {
            boolean z16;
            boolean startsWith;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                startsWith = StringsKt__StringsJVMKt.startsWith(str, "kirin", true);
                if (startsWith) {
                    str = com.tencent.qne.model.c.a(str);
                }
                f fVar = d.f344357i;
                if (!fVar.g(str)) {
                    fVar = e.f344358i;
                    if (!fVar.g(str)) {
                        fVar = C9348f.f344359i;
                        if (!fVar.g(str)) {
                            fVar = g.f344360i;
                            if (!fVar.g(str)) {
                                fVar = c.f344356i;
                                if (!fVar.g(str)) {
                                    fVar = b.f344355i;
                                    if (!fVar.g(str)) {
                                        return null;
                                    }
                                }
                            }
                        }
                    }
                }
                return fVar;
            }
            return null;
        }

        @Nullable
        public final f a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (f) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            com.tencent.qne.util.b bVar = com.tencent.qne.util.b.f344371a;
            f b16 = b(bVar.b());
            if (b16 == null) {
                return b(bVar.a());
            }
            return b16;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qne/model/f$b;", "Lcom/tencent/qne/model/f;", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes22.dex */
    public static final class b extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        public static final b f344355i;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14858);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f344355i = new b();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        b() {
            super(r4, "HW_KIRIN", "KIRIN", r7, null, "kirin", 16, null);
            List listOf;
            List listOf2;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{com.tencent.qne.model.d.f344351c.a(), com.tencent.qne.model.e.f344352c.a()});
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(DependencyLibrary.KIRIN_COMMON);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qne/model/f$c;", "Lcom/tencent/qne/model/f;", "", "hardware", "", "g", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes22.dex */
    public static final class c extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        public static final c f344356i;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15003);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f344356i = new c();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        c() {
            super(r2, "MTK_DIMENSITY", "DIMENSITY", r5, null, "mtk_neuro_pilot", 16, null);
            List listOf;
            List listOf2;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"MT6991", "MT6989", "MT6985", "MT6983", "MT6897", "MT6896", "MT6895", "MT6893", "MT6886", "MT6877", "MT6855", "MT6891", "MT6885", "MT6883", "MT6889", "MT6877"});
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(DependencyLibrary.DIMENSITY_TFLITE);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qne.model.f
        public boolean g(@NotNull String hardware) {
            List listOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) hardware)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(hardware, "hardware");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"MT6893", "MT6891", "MT6885", "MT6883", "MT6889", "MT6877"});
            if (listOf.contains(hardware) && Build.VERSION.SDK_INT == 30) {
                return false;
            }
            return super.g(hardware);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qne/model/f$d;", "Lcom/tencent/qne/model/f;", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes22.dex */
    public static final class d extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        public static final d f344357i;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15024);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f344357i = new d();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        d() {
            super(r2, "QCOM_HTP_V69", "QUALCOMM", r5, "qcom_snpe_htp_v69", "qcom_snpe");
            List listOf;
            List listOf2;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"sm8450", "sm8475"});
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new DependencyLibrary[]{DependencyLibrary.SNPE_COMMON, DependencyLibrary.SNPE_HTP_V69});
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qne/model/f$e;", "Lcom/tencent/qne/model/f;", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes22.dex */
    public static final class e extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        public static final e f344358i;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15030);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f344358i = new e();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        e() {
            super(r2, "QCOM_HTP_V73", "QUALCOMM", r5, "qcom_snpe_htp_v73", "qcom_snpe");
            List listOf;
            List listOf2;
            listOf = CollectionsKt__CollectionsJVMKt.listOf("sm8550");
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new DependencyLibrary[]{DependencyLibrary.SNPE_COMMON, DependencyLibrary.SNPE_HTP_V73});
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qne/model/f$f;", "Lcom/tencent/qne/model/f;", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.qne.model.f$f, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9348f extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        public static final C9348f f344359i;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15122);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f344359i = new C9348f();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        C9348f() {
            super(r2, "QCOM_HTP_V75", "QUALCOMM", r5, "qcom_snpe_htp_v75", "qcom_snpe");
            List listOf;
            List listOf2;
            listOf = CollectionsKt__CollectionsJVMKt.listOf("sm8650");
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new DependencyLibrary[]{DependencyLibrary.SNPE_COMMON, DependencyLibrary.SNPE_HTP_V75});
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qne/model/f$g;", "Lcom/tencent/qne/model/f;", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes22.dex */
    public static final class g extends f {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        @NotNull
        public static final g f344360i;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15126);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f344360i = new g();
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        g() {
            super(r2, "QCOM_HTP_V79", "QUALCOMM", r5, "qcom_snpe_htp_v79", "qcom_snpe");
            List listOf;
            List listOf2;
            listOf = CollectionsKt__CollectionsJVMKt.listOf("sm8750");
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new DependencyLibrary[]{DependencyLibrary.SNPE_COMMON, DependencyLibrary.SNPE_HTP_V79});
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15132);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ f(List list, String str, String str2, List list2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, str2, list2, (i3 & 16) != 0 ? null : str3, str4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, list, str, str2, list2, str3, str4, Integer.valueOf(i3), defaultConstructorMarker);
    }

    public boolean g(@NotNull String hardware) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) hardware)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(hardware, "hardware");
        List<String> list = this.supportedHardware;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            contains = StringsKt__StringsKt.contains((CharSequence) hardware, (CharSequence) it.next(), true);
            if (contains) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull List<String> supportedHardware, @NotNull String className, @NotNull String name, @NotNull List<? extends DependencyLibrary> dependency, @Nullable String str, @NotNull String fallbackResourceSuffix) {
        super(className, name, dependency, str, fallbackResourceSuffix, null);
        Intrinsics.checkNotNullParameter(supportedHardware, "supportedHardware");
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        Intrinsics.checkNotNullParameter(fallbackResourceSuffix, "fallbackResourceSuffix");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.supportedHardware = supportedHardware;
        } else {
            iPatchRedirector.redirect((short) 1, this, supportedHardware, className, name, dependency, str, fallbackResourceSuffix);
        }
    }
}
