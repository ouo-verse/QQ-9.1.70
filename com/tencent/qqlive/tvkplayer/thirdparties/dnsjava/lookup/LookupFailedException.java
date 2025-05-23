package com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.lookup;

import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.Name;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LookupFailedException extends RuntimeException {
    private final Name name;
    private final int type;

    public LookupFailedException() {
        this((String) null, (Throwable) null);
    }

    public Name getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public LookupFailedException(String str) {
        this(str, (Throwable) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LookupFailedException(String str, Throwable th5) {
        super(str, th5);
        this.name = null;
        this.type = 0;
    }

    public LookupFailedException(Name name, int i3) {
        this.name = name;
        this.type = i3;
    }
}
