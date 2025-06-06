package org.apache.commons.io.comparator;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class AbstractFileComparator implements Comparator<File> {
    public File[] sort(File... fileArr) {
        if (fileArr != null) {
            Arrays.sort(fileArr, this);
        }
        return fileArr;
    }

    public String toString() {
        return getClass().getSimpleName();
    }

    public List<File> sort(List<File> list) {
        if (list != null) {
            Collections.sort(list, this);
        }
        return list;
    }
}
