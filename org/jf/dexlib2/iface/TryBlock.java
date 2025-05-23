package org.jf.dexlib2.iface;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.ExceptionHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface TryBlock<EH extends ExceptionHandler> {
    boolean equals(@Nullable Object obj);

    int getCodeUnitCount();

    @Nonnull
    List<? extends EH> getExceptionHandlers();

    int getStartCodeAddress();
}
