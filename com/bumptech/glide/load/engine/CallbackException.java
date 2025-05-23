package com.bumptech.glide.load.engine;

/* compiled from: P */
/* loaded from: classes.dex */
final class CallbackException extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackException(Throwable th5) {
        super("Unexpected exception thrown by non-Glide code", th5);
    }
}
