package org.jf.dexlib2.writer.builder;

import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseExceptionHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BuilderExceptionHandler extends BaseExceptionHandler {

    @Nullable
    final BuilderTypeReference exceptionType;
    final int handlerCodeAddress;

    BuilderExceptionHandler(@Nullable BuilderTypeReference builderTypeReference, int i3) {
        this.exceptionType = builderTypeReference;
        this.handlerCodeAddress = i3;
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    @Nullable
    public String getExceptionType() {
        BuilderTypeReference builderTypeReference = this.exceptionType;
        if (builderTypeReference == null) {
            return null;
        }
        return builderTypeReference.getType();
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    public int getHandlerCodeAddress() {
        return this.handlerCodeAddress;
    }
}
