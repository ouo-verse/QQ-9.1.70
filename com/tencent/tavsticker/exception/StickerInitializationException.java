package com.tencent.tavsticker.exception;

/* compiled from: P */
/* loaded from: classes26.dex */
public class StickerInitializationException extends Exception {
    private String message;

    public StickerInitializationException() {
        this.message = "";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public StickerInitializationException(String str) {
        super(str);
        this.message = str;
    }

    public StickerInitializationException(String str, Throwable th5) {
        super(str, th5);
        this.message = "";
    }
}
