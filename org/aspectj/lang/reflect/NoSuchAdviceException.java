package org.aspectj.lang.reflect;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NoSuchAdviceException extends Exception {
    private static final long serialVersionUID = 3256444698657634352L;
    private String name;

    public NoSuchAdviceException(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
