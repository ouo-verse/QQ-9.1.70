package org.jf.dexlib2.rewriter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.BaseExceptionHandler;
import org.jf.dexlib2.iface.ExceptionHandler;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExceptionHandlerRewriter implements Rewriter<ExceptionHandler> {

    @Nonnull
    protected final Rewriters rewriters;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class RewrittenExceptionHandler extends BaseExceptionHandler {

        @Nonnull
        protected ExceptionHandler exceptionHandler;

        public RewrittenExceptionHandler(@Nonnull ExceptionHandler exceptionHandler) {
            this.exceptionHandler = exceptionHandler;
        }

        @Override // org.jf.dexlib2.iface.ExceptionHandler
        @Nullable
        public String getExceptionType() {
            return (String) RewriterUtils.rewriteNullable(ExceptionHandlerRewriter.this.rewriters.getTypeRewriter(), this.exceptionHandler.getExceptionType());
        }

        @Override // org.jf.dexlib2.iface.ExceptionHandler
        public int getHandlerCodeAddress() {
            return this.exceptionHandler.getHandlerCodeAddress();
        }
    }

    public ExceptionHandlerRewriter(@Nonnull Rewriters rewriters) {
        this.rewriters = rewriters;
    }

    @Override // org.jf.dexlib2.rewriter.Rewriter
    @Nonnull
    public ExceptionHandler rewrite(@Nonnull ExceptionHandler exceptionHandler) {
        return new RewrittenExceptionHandler(exceptionHandler);
    }
}
