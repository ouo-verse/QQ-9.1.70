package org.jf.dexlib2.dexbacked;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedCatchAllExceptionHandler extends DexBackedExceptionHandler {
    private final int handlerCodeAddress;

    public DexBackedCatchAllExceptionHandler(@Nonnull DexReader dexReader) {
        this.handlerCodeAddress = dexReader.readSmallUleb128();
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    @Nullable
    public String getExceptionType() {
        return null;
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    public int getHandlerCodeAddress() {
        return this.handlerCodeAddress;
    }
}
