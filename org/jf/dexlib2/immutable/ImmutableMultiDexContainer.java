package org.jf.dexlib2.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.MultiDexContainer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableMultiDexContainer implements MultiDexContainer<ImmutableDexFile> {
    private final ImmutableMap<String, ImmutableDexEntry> entries;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class ImmutableDexEntry implements MultiDexContainer.DexEntry<ImmutableDexFile> {
        private final ImmutableDexFile dexFile;
        private final String entryName;

        protected ImmutableDexEntry(String str, ImmutableDexFile immutableDexFile) {
            this.entryName = str;
            this.dexFile = immutableDexFile;
        }

        @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
        @Nonnull
        public MultiDexContainer<? extends ImmutableDexFile> getContainer() {
            return ImmutableMultiDexContainer.this;
        }

        @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
        @Nonnull
        public String getEntryName() {
            return this.entryName;
        }

        @Override // org.jf.dexlib2.iface.MultiDexContainer.DexEntry
        @Nonnull
        public ImmutableDexFile getDexFile() {
            return this.dexFile;
        }
    }

    public ImmutableMultiDexContainer(Map<String, ImmutableDexFile> map) {
        ImmutableMap.b builder = ImmutableMap.builder();
        for (Map.Entry<String, ImmutableDexFile> entry : map.entrySet()) {
            ImmutableDexEntry immutableDexEntry = new ImmutableDexEntry(entry.getKey(), entry.getValue());
            builder.c(immutableDexEntry.getEntryName(), immutableDexEntry);
        }
        this.entries = builder.a();
    }

    @Override // org.jf.dexlib2.iface.MultiDexContainer
    @Nonnull
    public List<String> getDexEntryNames() {
        return ImmutableList.copyOf((Collection) this.entries.keySet());
    }

    @Override // org.jf.dexlib2.iface.MultiDexContainer
    @Nullable
    public MultiDexContainer.DexEntry<ImmutableDexFile> getEntry(@Nonnull String str) {
        return this.entries.get(str);
    }
}
