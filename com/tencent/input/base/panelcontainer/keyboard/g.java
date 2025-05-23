package com.tencent.input.base.panelcontainer.keyboard;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/input/base/panelcontainer/keyboard/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mvi/log/b;", "a", "Lcom/tencent/mvi/log/b;", "()Lcom/tencent/mvi/log/b;", "mLogger", "Lpz0/a;", "b", "Lpz0/a;", "()Lpz0/a;", "mMMKVAdapter", "<init>", "(Lcom/tencent/mvi/log/b;Lpz0/a;)V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final /* data */ class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.mvi.log.b mLogger;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final pz0.a mMMKVAdapter;

    public g(@Nullable com.tencent.mvi.log.b bVar, @Nullable pz0.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) aVar);
        } else {
            this.mLogger = bVar;
            this.mMMKVAdapter = aVar;
        }
    }

    @Nullable
    public final com.tencent.mvi.log.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mvi.log.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mLogger;
    }

    @Nullable
    public final pz0.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (pz0.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mMMKVAdapter;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (Intrinsics.areEqual(this.mLogger, gVar.mLogger) && Intrinsics.areEqual(this.mMMKVAdapter, gVar.mMMKVAdapter)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        com.tencent.mvi.log.b bVar = this.mLogger;
        int i3 = 0;
        if (bVar == null) {
            hashCode = 0;
        } else {
            hashCode = bVar.hashCode();
        }
        int i16 = hashCode * 31;
        pz0.a aVar = this.mMMKVAdapter;
        if (aVar != null) {
            i3 = aVar.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "StrategyLoadData(mLogger=" + this.mLogger + ", mMMKVAdapter=" + this.mMMKVAdapter + ')';
    }
}
