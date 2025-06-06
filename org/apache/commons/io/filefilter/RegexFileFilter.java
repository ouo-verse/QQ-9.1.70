package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.apache.commons.io.IOCase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class RegexFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 4269646126155225062L;
    private final Pattern pattern;

    public RegexFileFilter(String str) {
        if (str != null) {
            this.pattern = Pattern.compile(str);
            return;
        }
        throw new IllegalArgumentException("Pattern is missing");
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.pattern.matcher(str).matches();
    }

    public RegexFileFilter(String str, IOCase iOCase) {
        if (str != null) {
            this.pattern = Pattern.compile(str, (iOCase == null || iOCase.isCaseSensitive()) ? 0 : 2);
            return;
        }
        throw new IllegalArgumentException("Pattern is missing");
    }

    public RegexFileFilter(String str, int i3) {
        if (str != null) {
            this.pattern = Pattern.compile(str, i3);
            return;
        }
        throw new IllegalArgumentException("Pattern is missing");
    }

    public RegexFileFilter(Pattern pattern) {
        if (pattern != null) {
            this.pattern = pattern;
            return;
        }
        throw new IllegalArgumentException("Pattern is missing");
    }
}
