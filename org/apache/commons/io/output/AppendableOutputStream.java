package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.Appendable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class AppendableOutputStream<T extends Appendable> extends OutputStream {
    private final T appendable;

    public AppendableOutputStream(T t16) {
        this.appendable = t16;
    }

    public T getAppendable() {
        return this.appendable;
    }

    @Override // java.io.OutputStream
    public void write(int i3) throws IOException {
        this.appendable.append((char) i3);
    }
}
