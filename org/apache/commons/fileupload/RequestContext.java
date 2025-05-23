package org.apache.commons.fileupload;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface RequestContext {
    String getCharacterEncoding();

    @Deprecated
    int getContentLength();

    String getContentType();

    InputStream getInputStream() throws IOException;
}
