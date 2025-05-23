package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.lang.Exception;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends Exception> implements Decoder<I, O, E> {
    private int availableInputBufferCount;
    private final I[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final O[] availableOutputBuffers;
    private final Thread decodeThread;
    private I dequeuedInputBuffer;
    private E exception;
    private boolean flushed;
    private final Object lock = new Object();
    private final LinkedList<I> queuedInputBuffers = new LinkedList<>();
    private final LinkedList<O> queuedOutputBuffers = new LinkedList<>();
    private boolean released;
    private int skippedOutputBufferCount;

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.availableInputBuffers = iArr;
        this.availableInputBufferCount = iArr.length;
        for (int i3 = 0; i3 < this.availableInputBufferCount; i3++) {
            this.availableInputBuffers[i3] = createInputBuffer();
        }
        this.availableOutputBuffers = oArr;
        this.availableOutputBufferCount = oArr.length;
        for (int i16 = 0; i16 < this.availableOutputBufferCount; i16++) {
            this.availableOutputBuffers[i16] = createOutputBuffer();
        }
        BaseThread baseThread = new BaseThread() { // from class: com.google.android.exoplayer2.decoder.SimpleDecoder.1
            @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
            public void run() {
                SimpleDecoder.this.run();
            }
        };
        this.decodeThread = baseThread;
        baseThread.start();
    }

    private boolean canDecodeBuffer() {
        if (!this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0) {
            return true;
        }
        return false;
    }

    private boolean decode() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.released && !canDecodeBuffer()) {
                LockMethodProxy.wait(this.lock);
            }
            if (this.released) {
                return false;
            }
            I removeFirst = this.queuedInputBuffers.removeFirst();
            O[] oArr = this.availableOutputBuffers;
            int i3 = this.availableOutputBufferCount - 1;
            this.availableOutputBufferCount = i3;
            O o16 = oArr[i3];
            boolean z16 = this.flushed;
            this.flushed = false;
            if (removeFirst.isEndOfStream()) {
                o16.addFlag(4);
            } else {
                if (removeFirst.isDecodeOnly()) {
                    o16.addFlag(Integer.MIN_VALUE);
                }
                try {
                    this.exception = decode(removeFirst, o16, z16);
                } catch (OutOfMemoryError e16) {
                    this.exception = createUnexpectedDecodeException(e16);
                } catch (RuntimeException e17) {
                    this.exception = createUnexpectedDecodeException(e17);
                }
                if (this.exception != null) {
                    synchronized (this.lock) {
                    }
                    return false;
                }
            }
            synchronized (this.lock) {
                if (this.flushed) {
                    releaseOutputBufferInternal(o16);
                } else if (o16.isDecodeOnly()) {
                    this.skippedOutputBufferCount++;
                    releaseOutputBufferInternal(o16);
                } else {
                    o16.skippedOutputBufferCount = this.skippedOutputBufferCount;
                    this.skippedOutputBufferCount = 0;
                    this.queuedOutputBuffers.addLast(o16);
                }
                releaseInputBufferInternal(removeFirst);
            }
            return true;
        }
    }

    private void maybeNotifyDecodeLoop() {
        if (canDecodeBuffer()) {
            this.lock.notify();
        }
    }

    private void maybeThrowException() throws Exception {
        E e16 = this.exception;
        if (e16 == null) {
        } else {
            throw e16;
        }
    }

    private void releaseInputBufferInternal(I i3) {
        i3.clear();
        I[] iArr = this.availableInputBuffers;
        int i16 = this.availableInputBufferCount;
        this.availableInputBufferCount = i16 + 1;
        iArr[i16] = i3;
    }

    private void releaseOutputBufferInternal(O o16) {
        o16.clear();
        O[] oArr = this.availableOutputBuffers;
        int i3 = this.availableOutputBufferCount;
        this.availableOutputBufferCount = i3 + 1;
        oArr[i3] = o16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void run() {
        do {
            try {
            } catch (InterruptedException e16) {
                throw new IllegalStateException(e16);
            }
        } while (decode());
    }

    protected abstract I createInputBuffer();

    protected abstract O createOutputBuffer();

    protected abstract E createUnexpectedDecodeException(Throwable th5);

    protected abstract E decode(I i3, O o16, boolean z16);

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void flush() {
        synchronized (this.lock) {
            this.flushed = true;
            this.skippedOutputBufferCount = 0;
            I i3 = this.dequeuedInputBuffer;
            if (i3 != null) {
                releaseInputBufferInternal(i3);
                this.dequeuedInputBuffer = null;
            }
            while (!this.queuedInputBuffers.isEmpty()) {
                releaseInputBufferInternal(this.queuedInputBuffers.removeFirst());
            }
            while (!this.queuedOutputBuffers.isEmpty()) {
                releaseOutputBufferInternal(this.queuedOutputBuffers.removeFirst());
            }
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseOutputBuffer(O o16) {
        synchronized (this.lock) {
            releaseOutputBufferInternal(o16);
            maybeNotifyDecodeLoop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setInitialInputBufferSize(int i3) {
        boolean z16;
        if (this.availableInputBufferCount == this.availableInputBuffers.length) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        for (I i16 : this.availableInputBuffers) {
            i16.ensureSpaceForWrite(i3);
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final I dequeueInputBuffer() throws Exception {
        I i3;
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkState(this.dequeuedInputBuffer == null);
            int i16 = this.availableInputBufferCount;
            if (i16 == 0) {
                i3 = null;
            } else {
                I[] iArr = this.availableInputBuffers;
                int i17 = i16 - 1;
                this.availableInputBufferCount = i17;
                i3 = iArr[i17];
            }
            this.dequeuedInputBuffer = i3;
        }
        return i3;
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final O dequeueOutputBuffer() throws Exception {
        synchronized (this.lock) {
            maybeThrowException();
            if (this.queuedOutputBuffers.isEmpty()) {
                return null;
            }
            return this.queuedOutputBuffers.removeFirst();
        }
    }

    @Override // com.google.android.exoplayer2.decoder.Decoder
    public final void queueInputBuffer(I i3) throws Exception {
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkArgument(i3 == this.dequeuedInputBuffer);
            this.queuedInputBuffers.addLast(i3);
            maybeNotifyDecodeLoop();
            this.dequeuedInputBuffer = null;
        }
    }
}
