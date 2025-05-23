package org.jf.dexlib2.iface;

import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.DexFile;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface MultiDexContainer<T extends DexFile> {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface DexEntry<T extends DexFile> {
        @Nonnull
        MultiDexContainer<? extends T> getContainer();

        @Nonnull
        T getDexFile();

        @Nonnull
        String getEntryName();
    }

    @Nonnull
    List<String> getDexEntryNames() throws IOException;

    @Nullable
    DexEntry<T> getEntry(@Nonnull String str) throws IOException;
}
