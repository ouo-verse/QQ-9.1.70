package com.tencent.mm.vfs;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public final class FastList$Tagger {

    @Keep
    public int andTag;

    @Keep
    public int depth;

    @Keep
    public int orTag;

    @Keep
    public String path;

    @Keep
    public FastList$TaggerPattern[] patterns;

    @Keep
    public boolean skip;

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.path);
        sb5.append(" => {");
        if (this.skip) {
            sb5.append("skip}");
            return sb5.toString();
        }
        sb5.append("&:");
        sb5.append(Integer.toHexString(this.andTag));
        sb5.append(", |:");
        sb5.append(Integer.toHexString(this.orTag));
        sb5.append('}');
        if (this.depth > 0) {
            sb5.append(" [");
            sb5.append(this.depth);
            sb5.append(']');
        }
        return sb5.toString();
    }
}
