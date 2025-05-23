package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;
import org.apache.commons.io.TaggedIOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TaggedInputStream extends ProxyInputStream {
    private final Serializable tag;

    public TaggedInputStream(InputStream inputStream) {
        super(inputStream);
        this.tag = UUID.randomUUID();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream
    protected void handleIOException(IOException iOException) throws IOException {
        throw new TaggedIOException(iOException, this.tag);
    }

    public boolean isCauseOf(Throwable th5) {
        return TaggedIOException.isTaggedWith(th5, this.tag);
    }

    public void throwIfCauseOf(Throwable th5) throws IOException {
        TaggedIOException.throwCauseIfTaggedWith(th5, this.tag);
    }
}
