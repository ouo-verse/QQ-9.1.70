package com.tencent.opentelemetry.api.trace;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.internal.ReadOnlyArrayMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ArrayBasedTraceState implements TraceState {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayBasedTraceState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayBasedTraceState create(List<String> list) {
        return new AutoValue_ArrayBasedTraceState(Collections.unmodifiableList(list));
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceState
    public Map<String, String> asMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ReadOnlyArrayMap.wrap(getEntries());
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceState
    public void forEach(BiConsumer<String, String> biConsumer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) biConsumer);
            return;
        }
        if (biConsumer == null) {
            return;
        }
        List<String> entries = getEntries();
        for (int i3 = 0; i3 < entries.size(); i3 += 2) {
            biConsumer.accept(entries.get(i3), entries.get(i3 + 1));
        }
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceState
    @Nullable
    public String get(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
        if (str == null) {
            return null;
        }
        List<String> entries = getEntries();
        for (int i3 = 0; i3 < entries.size(); i3 += 2) {
            if (entries.get(i3).equals(str)) {
                return entries.get(i3 + 1);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract List<String> getEntries();

    @Override // com.tencent.opentelemetry.api.trace.TraceState
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return getEntries().isEmpty();
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceState
    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return getEntries().size() / 2;
    }

    @Override // com.tencent.opentelemetry.api.trace.TraceState
    public TraceStateBuilder toBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TraceStateBuilder) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new ArrayBasedTraceStateBuilder(this);
    }
}
