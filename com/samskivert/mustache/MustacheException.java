package com.samskivert.mustache;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MustacheException extends RuntimeException {
    public MustacheException(String str) {
        super(str);
    }

    public MustacheException(Throwable th5) {
        super(th5);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Context extends MustacheException {
        public final String key;
        public final int lineNo;

        public Context(String str, String str2, int i3) {
            super(str);
            this.key = str2;
            this.lineNo = i3;
        }

        public Context(String str, String str2, int i3, Throwable th5) {
            super(str, th5);
            this.key = str2;
            this.lineNo = i3;
        }
    }

    public MustacheException(String str, Throwable th5) {
        super(str, th5);
    }
}
