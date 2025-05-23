package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RedirectOverflowException extends LookupFailedException {
    private final int maxRedirects;

    @Deprecated
    public RedirectOverflowException(String str) {
        super(str);
        this.maxRedirects = 0;
    }

    public int getMaxRedirects() {
        return this.maxRedirects;
    }

    public RedirectOverflowException(int i3) {
        super("Refusing to follow more than " + i3 + " redirects");
        this.maxRedirects = i3;
    }
}
