package com.google.android.exoplayer2.decoder;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class Buffer {
    private int flags;

    public final void addFlag(int i3) {
        this.flags = i3 | this.flags;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int i3) {
        this.flags = (~i3) & this.flags;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getFlag(int i3) {
        if ((this.flags & i3) == i3) {
            return true;
        }
        return false;
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i3) {
        this.flags = i3;
    }
}
