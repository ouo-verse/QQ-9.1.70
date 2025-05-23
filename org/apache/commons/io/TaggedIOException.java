package org.apache.commons.io;

import java.io.IOException;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TaggedIOException extends IOExceptionWithCause {
    private static final long serialVersionUID = -6994123481142850163L;
    private final Serializable tag;

    public TaggedIOException(IOException iOException, Serializable serializable) {
        super(iOException.getMessage(), iOException);
        this.tag = serializable;
    }

    public static boolean isTaggedWith(Throwable th5, Object obj) {
        if (obj != null && (th5 instanceof TaggedIOException) && obj.equals(((TaggedIOException) th5).tag)) {
            return true;
        }
        return false;
    }

    public static void throwCauseIfTaggedWith(Throwable th5, Object obj) throws IOException {
        if (!isTaggedWith(th5, obj)) {
        } else {
            throw ((TaggedIOException) th5).getCause();
        }
    }

    public Serializable getTag() {
        return this.tag;
    }

    @Override // java.lang.Throwable
    public IOException getCause() {
        return (IOException) super.getCause();
    }
}
