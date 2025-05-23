package org.jf.dexlib2.builder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseExceptionHandler;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BuilderExceptionHandler extends BaseExceptionHandler {

    @Nonnull
    protected final Label handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BuilderExceptionHandler newExceptionHandler(@Nullable final TypeReference typeReference, @Nonnull Label label) {
        if (typeReference == null) {
            return newExceptionHandler(label);
        }
        return new BuilderExceptionHandler(label) { // from class: org.jf.dexlib2.builder.BuilderExceptionHandler.1
            @Override // org.jf.dexlib2.iface.ExceptionHandler
            @Nullable
            public String getExceptionType() {
                return typeReference.getType();
            }

            @Override // org.jf.dexlib2.base.BaseExceptionHandler, org.jf.dexlib2.iface.ExceptionHandler
            @Nullable
            public TypeReference getExceptionTypeReference() {
                return typeReference;
            }

            @Override // org.jf.dexlib2.iface.ExceptionHandler
            public int getHandlerCodeAddress() {
                return this.handler.getCodeAddress();
            }
        };
    }

    @Nonnull
    public Label getHandler() {
        return this.handler;
    }

    BuilderExceptionHandler(@Nonnull Label label) {
        this.handler = label;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BuilderExceptionHandler newExceptionHandler(@Nonnull Label label) {
        return new BuilderExceptionHandler(label) { // from class: org.jf.dexlib2.builder.BuilderExceptionHandler.2
            @Override // org.jf.dexlib2.iface.ExceptionHandler
            @Nullable
            public String getExceptionType() {
                return null;
            }

            @Override // org.jf.dexlib2.iface.ExceptionHandler
            public int getHandlerCodeAddress() {
                return this.handler.getCodeAddress();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BuilderExceptionHandler newExceptionHandler(@Nullable final String str, @Nonnull Label label) {
        if (str == null) {
            return newExceptionHandler(label);
        }
        return new BuilderExceptionHandler(label) { // from class: org.jf.dexlib2.builder.BuilderExceptionHandler.3
            @Override // org.jf.dexlib2.iface.ExceptionHandler
            @Nullable
            public String getExceptionType() {
                return str;
            }

            @Override // org.jf.dexlib2.iface.ExceptionHandler
            public int getHandlerCodeAddress() {
                return this.handler.getCodeAddress();
            }
        };
    }
}
