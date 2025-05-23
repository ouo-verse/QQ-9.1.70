package com.tencent.mobileqq.aio.input.at.common;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\u00c6\u0003J%\u0010\u000b\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001R#\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/InitIndexEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "alphabetIndex", "", "Lkotlin/Pair;", "", "", "(Ljava/util/List;)V", "getAlphabetIndex", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final /* data */ class InitIndexEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final List<Pair<String, Integer>> alphabetIndex;

    public InitIndexEvent(@NotNull List<Pair<String, Integer>> alphabetIndex) {
        Intrinsics.checkNotNullParameter(alphabetIndex, "alphabetIndex");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) alphabetIndex);
        } else {
            this.alphabetIndex = alphabetIndex;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InitIndexEvent copy$default(InitIndexEvent initIndexEvent, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = initIndexEvent.alphabetIndex;
        }
        return initIndexEvent.copy(list);
    }

    @NotNull
    public final List<Pair<String, Integer>> component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.alphabetIndex;
    }

    @NotNull
    public final InitIndexEvent copy(@NotNull List<Pair<String, Integer>> alphabetIndex) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (InitIndexEvent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) alphabetIndex);
        }
        Intrinsics.checkNotNullParameter(alphabetIndex, "alphabetIndex");
        return new InitIndexEvent(alphabetIndex);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof InitIndexEvent) && Intrinsics.areEqual(this.alphabetIndex, ((InitIndexEvent) other).alphabetIndex)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<Pair<String, Integer>> getAlphabetIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.alphabetIndex;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.alphabetIndex.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "InitIndexEvent(alphabetIndex=" + this.alphabetIndex + ")";
    }
}
