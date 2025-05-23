package com.tencent.qqnt.base.lifecycle.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0017\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u000b\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u0013\u0010\u001bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\u001a\"\u0004\b\u0010\u0010\u001b\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/base/lifecycle/data/b;", "", "", "d", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "module", "b", "getTag", "tag", "c", "I", "getId", "()I", "id", "J", "getOnCreateCost", "()J", "(J)V", "onCreateCost", "e", "getOnStartCost", "onStartCost", "f", "getOnResumeCost", "onResumeCost", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJJJ)V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String module;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int id;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long onCreateCost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long onStartCost;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long onResumeCost;

    public b(@NotNull String module, @NotNull String tag, int i3, long j3, long j16, long j17) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(tag, "tag");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, module, tag, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        this.module = module;
        this.tag = tag;
        this.id = i3;
        this.onCreateCost = j3;
        this.onStartCost = j16;
        this.onResumeCost = j17;
    }

    public final void a(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            this.onCreateCost = j3;
        }
    }

    public final void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
        } else {
            this.onResumeCost = j3;
        }
    }

    public final void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, j3);
        } else {
            this.onStartCost = j3;
        }
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.onCreateCost + this.onStartCost + this.onResumeCost;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (Intrinsics.areEqual(this.module, bVar.module) && Intrinsics.areEqual(this.tag, bVar.tag) && this.id == bVar.id && this.onCreateCost == bVar.onCreateCost && this.onStartCost == bVar.onStartCost && this.onResumeCost == bVar.onResumeCost) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return (((((((((this.module.hashCode() * 31) + this.tag.hashCode()) * 31) + this.id) * 31) + androidx.fragment.app.a.a(this.onCreateCost)) * 31) + androidx.fragment.app.a.a(this.onStartCost)) * 31) + androidx.fragment.app.a.a(this.onResumeCost);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "ObserverCostData(module='" + this.module + "', tag='" + this.tag + "', id=" + this.id + ", onCreateCost=" + this.onCreateCost + ", onStartCost=" + this.onStartCost + ", onResumeCost=" + this.onResumeCost + ", totalCost=" + d() + ")";
    }

    public /* synthetic */ b(String str, String str2, int i3, long j3, long j16, long j17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i3, (i16 & 8) != 0 ? -1L : j3, (i16 & 16) != 0 ? -1L : j16, (i16 & 32) != 0 ? -1L : j17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, str2, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
