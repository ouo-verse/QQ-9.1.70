package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.io.FileUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -2132740084016138541L;
    private final boolean acceptOlder;
    private final long cutoff;

    public AgeFileFilter(long j3) {
        this(j3, true);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean isFileNewer = FileUtils.isFileNewer(file, this.cutoff);
        if (this.acceptOlder) {
            if (!isFileNewer) {
                return true;
            }
            return false;
        }
        return isFileNewer;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        String str;
        if (this.acceptOlder) {
            str = "<=";
        } else {
            str = ">";
        }
        return super.toString() + "(" + str + this.cutoff + ")";
    }

    public AgeFileFilter(long j3, boolean z16) {
        this.acceptOlder = z16;
        this.cutoff = j3;
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z16) {
        this(date.getTime(), z16);
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z16) {
        this(file.lastModified(), z16);
    }
}
