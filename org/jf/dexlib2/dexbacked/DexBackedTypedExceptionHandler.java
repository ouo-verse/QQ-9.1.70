package org.jf.dexlib2.dexbacked;

import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DexBackedTypedExceptionHandler extends DexBackedExceptionHandler {

    @Nonnull
    private final DexBackedDexFile dexFile;
    private final int handlerCodeAddress;
    private final int typeId;

    public DexBackedTypedExceptionHandler(@Nonnull DexBackedDexFile dexBackedDexFile, @Nonnull DexReader dexReader) {
        this.dexFile = dexBackedDexFile;
        this.typeId = dexReader.readSmallUleb128();
        this.handlerCodeAddress = dexReader.readSmallUleb128();
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    @Nonnull
    public String getExceptionType() {
        return this.dexFile.getTypeSection().get(this.typeId);
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    public int getHandlerCodeAddress() {
        return this.handlerCodeAddress;
    }
}
