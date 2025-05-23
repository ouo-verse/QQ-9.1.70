package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ObservableInputStream extends ProxyInputStream {
    private final List<Observer> observers;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static abstract class Observer {
        void data(int i3) throws IOException {
        }

        void data(byte[] bArr, int i3, int i16) throws IOException {
        }

        void closed() throws IOException {
        }

        void finished() throws IOException {
        }

        void error(IOException iOException) throws IOException {
            throw iOException;
        }
    }

    public ObservableInputStream(InputStream inputStream) {
        super(inputStream);
        this.observers = new ArrayList();
    }

    public void add(Observer observer) {
        this.observers.add(observer);
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
            e = null;
        } catch (IOException e16) {
            e = e16;
        }
        if (e == null) {
            noteClosed();
        } else {
            noteError(e);
        }
    }

    public void consume() throws IOException {
        do {
        } while (read(new byte[8192]) != -1);
    }

    protected List<Observer> getObservers() {
        return this.observers;
    }

    protected void noteClosed() throws IOException {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().closed();
        }
    }

    protected void noteDataByte(int i3) throws IOException {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().data(i3);
        }
    }

    protected void noteDataBytes(byte[] bArr, int i3, int i16) throws IOException {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().data(bArr, i3, i16);
        }
    }

    protected void noteError(IOException iOException) throws IOException {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().error(iOException);
        }
    }

    protected void noteFinished() throws IOException {
        Iterator<Observer> it = getObservers().iterator();
        while (it.hasNext()) {
            it.next().finished();
        }
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i3;
        try {
            i3 = super.read();
            e = null;
        } catch (IOException e16) {
            e = e16;
            i3 = 0;
        }
        if (e != null) {
            noteError(e);
        } else if (i3 == -1) {
            noteFinished();
        } else {
            noteDataByte(i3);
        }
        return i3;
    }

    public void remove(Observer observer) {
        this.observers.remove(observer);
    }

    public void removeAllObservers() {
        this.observers.clear();
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i3;
        try {
            i3 = super.read(bArr);
            e = null;
        } catch (IOException e16) {
            e = e16;
            i3 = 0;
        }
        if (e != null) {
            noteError(e);
        } else if (i3 == -1) {
            noteFinished();
        } else if (i3 > 0) {
            noteDataBytes(bArr, 0, i3);
        }
        return i3;
    }

    @Override // org.apache.commons.io.input.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i16) throws IOException {
        int i17;
        try {
            i17 = super.read(bArr, i3, i16);
            e = null;
        } catch (IOException e16) {
            e = e16;
            i17 = 0;
        }
        if (e != null) {
            noteError(e);
        } else if (i17 == -1) {
            noteFinished();
        } else if (i17 > 0) {
            noteDataBytes(bArr, i3, i17);
        }
        return i17;
    }
}
