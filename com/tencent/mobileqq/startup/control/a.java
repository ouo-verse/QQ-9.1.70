package com.tencent.mobileqq.startup.control;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\n\tB\t\b\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000J\u0011\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\u0006\u0010\f\u001a\u00020\u000b\u0082\u0001\u0002\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/startup/control/a;", "", "", "a", "", "stepId", "d", "step", "e", "c", "b", "", "f", "<init>", "()V", "Lcom/tencent/mobileqq/startup/control/a$b;", "Lcom/tencent/mobileqq/startup/control/a$c;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/startup/control/a$a;", "", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.control.a$a, reason: collision with other inner class name and from kotlin metadata */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/startup/control/a$b;", "Lcom/tencent/mobileqq/startup/control/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "b", "Ljava/util/List;", "g", "()Ljava/util/List;", "steps", "c", "Z", h.F, "()Z", "isLinear", "<init>", "(Ljava/util/List;Z)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final /* data */ class b extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<a> steps;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isLinear;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull List<a> steps, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(steps, "steps");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, steps, Boolean.valueOf(z16));
            } else {
                this.steps = steps;
                this.isLinear = z16;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.steps, bVar.steps) && this.isLinear == bVar.isLinear) {
                return true;
            }
            return false;
        }

        @NotNull
        public final List<a> g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.steps;
        }

        public final boolean h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isLinear;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            int hashCode = this.steps.hashCode() * 31;
            boolean z16 = this.isLinear;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return "GroupStep(steps=" + this.steps + ", isLinear=" + this.isLinear + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/startup/control/a$c;", "Lcom/tencent/mobileqq/startup/control/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "b", "I", "g", "()I", "stepId", "<init>", "(I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final /* data */ class c extends a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int stepId;

        public c(int i3) {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.stepId = i3;
            }
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof c) && this.stepId == ((c) other).stepId) {
                return true;
            }
            return false;
        }

        public final int g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.stepId;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.stepId;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "SingleStep(stepId=" + this.stepId + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61406);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) defaultConstructorMarker);
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if ((this instanceof b) && ((b) this).h()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final a b(int stepId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (a) iPatchRedirector.redirect((short) 8, (Object) this, stepId);
        }
        return d(stepId);
    }

    @NotNull
    public final a c(@NotNull a step) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) step);
        }
        Intrinsics.checkNotNullParameter(step, "step");
        return e(step);
    }

    @NotNull
    public final a d(int stepId) {
        List mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, stepId);
        }
        if (!a()) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this, new c(stepId));
            return new b(mutableListOf, true);
        }
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.tencent.mobileqq.startup.control.StepRecord.GroupStep");
        ((b) this).g().add(new c(stepId));
        return this;
    }

    @NotNull
    public final a e(@NotNull a step) {
        List mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) step);
        }
        Intrinsics.checkNotNullParameter(step, "step");
        if (!a()) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(this, step);
            return new b(mutableListOf, true);
        }
        if (step.a()) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.tencent.mobileqq.startup.control.StepRecord.GroupStep");
            ((b) this).g().addAll(((b) step).g());
        } else {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.tencent.mobileqq.startup.control.StepRecord.GroupStep");
            ((b) this).g().add(step);
        }
        return this;
    }

    @NotNull
    public final String f() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        if (this instanceof c) {
            sb5.append(((c) this).g());
        } else if (this instanceof b) {
            b bVar = (b) this;
            if (bVar.h()) {
                str = "{";
            } else {
                str = "[";
            }
            sb5.append(str);
            Iterator<T> it = bVar.g().iterator();
            while (it.hasNext()) {
                sb5.append(((a) it.next()).f());
                sb5.append(",");
            }
            sb5.setLength(sb5.length() - 1);
            if (bVar.h()) {
                str2 = "}";
            } else {
                str2 = "]";
            }
            sb5.append(str2);
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
