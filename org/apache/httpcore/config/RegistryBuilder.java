package org.apache.httpcore.config;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.httpcore.util.Args;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RegistryBuilder<I> {
    private final Map<String, I> items = new HashMap();

    RegistryBuilder() {
    }

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder<>();
    }

    public Registry<I> build() {
        return new Registry<>(this.items);
    }

    public RegistryBuilder<I> register(String str, I i3) {
        Args.notEmpty(str, "ID");
        Args.notNull(i3, "Item");
        this.items.put(str.toLowerCase(Locale.ROOT), i3);
        return this;
    }

    public String toString() {
        return this.items.toString();
    }
}
