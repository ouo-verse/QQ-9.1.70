package org.apache.commons.fileupload;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface FileItemIterator {
    boolean hasNext() throws FileUploadException, IOException;

    FileItemStream next() throws FileUploadException, IOException;
}
