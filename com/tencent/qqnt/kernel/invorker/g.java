package com.tencent.qqnt.kernel.invorker;

import com.qq.e.comm.constants.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00022\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/g;", "", "a", "b", "c", "d", "e", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/g$b;", "", "", "extMsg", "Lcom/tencent/qqnt/kernel/invorker/g$a;", "b", "", "paras", "a", "", "SUCCESS_STATUS", "I", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.invorker.g$b, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final a a(@NotNull List<? extends Object> paras) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) paras);
            }
            Intrinsics.checkNotNullParameter(paras, "paras");
            return new a(0, "success", paras);
        }

        @NotNull
        public final a b(@NotNull String extMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) extMsg);
            }
            Intrinsics.checkNotNullParameter(extMsg, "extMsg");
            return new a(-1, "errMsg: cmd is error! " + extMsg, null, 4, null);
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/g$c;", "", "Ljava/lang/reflect/Method;", "method", "", "cmd", "", "preParas", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface c {
        @NotNull
        String a(@Nullable Method method, @NotNull String cmd, @NotNull List<? extends Object> preParas);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010\"\u001a\u00020\u0012\u0012\u0006\u0010$\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0001\u00a2\u0006\u0004\b)\u0010*J)\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096\u0001J \u0010\r\u001a\u00020\f2\b\b\u0002\u0010\n\u001a\u00020\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\t\u0010\u000e\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00d6\u0003R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\"\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010$\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0014\u001a\u0004\b#\u0010\u0016R\u0017\u0010(\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/g$d;", "Lcom/tencent/qqnt/kernel/invorker/g$c;", "Ljava/lang/reflect/Method;", "method", "", "cmd", "", "", "preParas", "a", "parasName", Constants.KEYS.PLACEMENTS, "", "b", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "description", "", "Lcom/tencent/qqnt/kernel/invorker/g$e;", "Ljava/util/List;", "g", "()Ljava/util/List;", "paras", "c", "Z", "f", "()Z", "needCmd", "d", "cmdHint", "Lcom/tencent/qqnt/kernel/invorker/g$c;", "getWorker", "()Lcom/tencent/qqnt/kernel/invorker/g$c;", "worker", "<init>", "(Ljava/lang/String;Ljava/util/List;ZLjava/lang/String;Lcom/tencent/qqnt/kernel/invorker/g$c;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class d implements c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String description;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<e> paras;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean needCmd;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String cmdHint;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final c worker;

        public d(@NotNull String description, @NotNull List<e> paras, boolean z16, @NotNull String cmdHint, @NotNull c worker) {
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(paras, "paras");
            Intrinsics.checkNotNullParameter(cmdHint, "cmdHint");
            Intrinsics.checkNotNullParameter(worker, "worker");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, description, paras, Boolean.valueOf(z16), cmdHint, worker);
                return;
            }
            this.description = description;
            this.paras = paras;
            this.needCmd = z16;
            this.cmdHint = cmdHint;
            this.worker = worker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(d dVar, String str, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = "defalut";
            }
            if ((i3 & 2) != 0) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            dVar.b(str, list);
        }

        @Override // com.tencent.qqnt.kernel.invorker.g.c
        @NotNull
        public String a(@Nullable Method method, @NotNull String cmd, @NotNull List<? extends Object> preParas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, this, method, cmd, preParas);
            }
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(preParas, "preParas");
            return this.worker.a(method, cmd, preParas);
        }

        public final void b(@NotNull String parasName, @NotNull List<? extends Object> ps5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) parasName, (Object) ps5);
                return;
            }
            Intrinsics.checkNotNullParameter(parasName, "parasName");
            Intrinsics.checkNotNullParameter(ps5, "ps");
            this.paras.add(new e(parasName, ps5));
        }

        @NotNull
        public final String d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.cmdHint;
        }

        @NotNull
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.description;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d dVar = (d) other;
            if (Intrinsics.areEqual(this.description, dVar.description) && Intrinsics.areEqual(this.paras, dVar.paras) && this.needCmd == dVar.needCmd && Intrinsics.areEqual(this.cmdHint, dVar.cmdHint) && Intrinsics.areEqual(this.worker, dVar.worker)) {
                return true;
            }
            return false;
        }

        public final boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.needCmd;
        }

        @NotNull
        public final List<e> g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.paras;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
            }
            int hashCode = ((this.description.hashCode() * 31) + this.paras.hashCode()) * 31;
            boolean z16 = this.needCmd;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return ((((hashCode + i3) * 31) + this.cmdHint.hashCode()) * 31) + this.worker.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (String) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            return "MethodInfo(description=" + this.description + ", paras=" + this.paras + ", needCmd=" + this.needCmd + ", cmdHint=" + this.cmdHint + ", worker=" + this.worker + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/g$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "paras", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String name;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Object> paras;

        public e() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return;
            }
            iPatchRedirector.redirect((short) 11, (Object) this);
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.name;
        }

        @NotNull
        public final List<Object> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.paras;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof e)) {
                return false;
            }
            e eVar = (e) other;
            if (Intrinsics.areEqual(this.name, eVar.name) && Intrinsics.areEqual(this.paras, eVar.paras)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return (this.name.hashCode() * 31) + this.paras.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.name;
        }

        public e(@NotNull String name, @NotNull List<? extends Object> paras) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(paras, "paras");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) name, (Object) paras);
            } else {
                this.name = name;
                this.paras = paras;
            }
        }

        public /* synthetic */ e(String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "default" : str, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, list, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54598);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u000e\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/kernel/invorker/g$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "result", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "", "Ljava/util/List;", "()Ljava/util/List;", "paras", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int result;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String errMsg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Object> paras;

        public a(int i3, @NotNull String errMsg, @NotNull List<? extends Object> paras) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(paras, "paras");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), errMsg, paras);
                return;
            }
            this.result = i3;
            this.errMsg = errMsg;
            this.paras = paras;
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.errMsg;
        }

        @NotNull
        public final List<Object> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.paras;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.result;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.result == aVar.result && Intrinsics.areEqual(this.errMsg, aVar.errMsg) && Intrinsics.areEqual(this.paras, aVar.paras)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return (((this.result * 31) + this.errMsg.hashCode()) * 31) + this.paras.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "CallResult(result=" + this.result + ", errMsg=" + this.errMsg + ", paras=" + this.paras + ")";
        }

        public /* synthetic */ a(int i3, String str, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, str, (i16 & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, list, Integer.valueOf(i16), defaultConstructorMarker);
        }
    }
}
