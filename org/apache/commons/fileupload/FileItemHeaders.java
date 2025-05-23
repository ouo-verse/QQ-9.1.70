package org.apache.commons.fileupload;

import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface FileItemHeaders {
    String getHeader(String str);

    Iterator<String> getHeaderNames();

    Iterator<String> getHeaders(String str);
}
