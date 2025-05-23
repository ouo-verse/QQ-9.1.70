package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j3) {
        this(j3, true);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean z16;
        if (file.length() < this.size) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.acceptLarger) {
            if (!z16) {
                return true;
            }
            return false;
        }
        return z16;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        String str;
        if (this.acceptLarger) {
            str = ">=";
        } else {
            str = "<";
        }
        return super.toString() + "(" + str + this.size + ")";
    }

    public SizeFileFilter(long j3, boolean z16) {
        if (j3 >= 0) {
            this.size = j3;
            this.acceptLarger = z16;
            return;
        }
        throw new IllegalArgumentException("The size must be non-negative");
    }
}
