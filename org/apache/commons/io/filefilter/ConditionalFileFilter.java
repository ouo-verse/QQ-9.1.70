package org.apache.commons.io.filefilter;

import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ConditionalFileFilter {
    void addFileFilter(IOFileFilter iOFileFilter);

    List<IOFileFilter> getFileFilters();

    boolean removeFileFilter(IOFileFilter iOFileFilter);

    void setFileFilters(List<IOFileFilter> list);
}
