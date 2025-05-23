package com.tencent.richmedia.videocompress.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Pair;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends MediaCodec.Callback {

    /* renamed from: f, reason: collision with root package name */
    private static final String f365128f = "a";

    /* renamed from: a, reason: collision with root package name */
    private final Lock f365129a;

    /* renamed from: b, reason: collision with root package name */
    private final Condition f365130b;

    /* renamed from: c, reason: collision with root package name */
    private final LinkedList<Pair<Integer, MediaCodec.BufferInfo>> f365131c;

    /* renamed from: d, reason: collision with root package name */
    private final LinkedList<Pair<Integer, MediaCodec.BufferInfo>> f365132d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Exception f365133e;

    public a() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f365129a = reentrantLock;
        this.f365130b = reentrantLock.newCondition();
        this.f365131c = new LinkedList<>();
        this.f365132d = new LinkedList<>();
    }

    public Exception a() {
        return this.f365133e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        r2 = r11.f365132d.remove(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<Integer, MediaCodec.BufferInfo> b() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        if (ConvertLog.isDevLevel()) {
            ConvertLog.i(f365128f, 3, "getOutput start.");
        }
        Pair<Integer, MediaCodec.BufferInfo> pair = null;
        try {
            try {
                this.f365129a.lock();
                while (true) {
                    if (!d()) {
                        if (!this.f365132d.isEmpty()) {
                            break;
                        }
                        this.f365130b.await();
                    } else {
                        break;
                    }
                }
            } catch (Exception e16) {
                ConvertLog.e(f365128f, 1, "an exception occurred while do onOutputFormatChanged, msg : " + e16);
            }
            if (ConvertLog.isDevLevel()) {
                ConvertLog.d(f365128f, 3, "getOutput end. cost = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            return pair;
        } finally {
            this.f365129a.unlock();
        }
    }

    public Pair<Integer, MediaCodec.BufferInfo> c() throws InterruptedException {
        Pair<Integer, MediaCodec.BufferInfo> pair;
        long currentTimeMillis = System.currentTimeMillis();
        if (ConvertLog.isDevLevel()) {
            ConvertLog.i(f365128f, 3, "getWork start.");
        }
        try {
            this.f365129a.lock();
            while (true) {
                if (!d()) {
                    if (this.f365131c.isEmpty() && this.f365132d.isEmpty()) {
                        this.f365130b.await();
                    } else {
                        if (!this.f365132d.isEmpty()) {
                            pair = this.f365132d.remove(0);
                            break;
                        }
                        if (!this.f365131c.isEmpty()) {
                            pair = this.f365131c.remove(0);
                            break;
                        }
                    }
                } else {
                    pair = null;
                    break;
                }
            }
            this.f365129a.unlock();
            if (ConvertLog.isDevLevel()) {
                ConvertLog.d(f365128f, 3, "getWork end. cost = ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            return pair;
        } catch (Throwable th5) {
            this.f365129a.unlock();
            throw th5;
        }
    }

    public boolean d() {
        if (this.f365133e != null) {
            return true;
        }
        return false;
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        ConvertLog.e(f365128f, 1, "Received media codec error : " + codecException.getMessage());
        try {
            try {
                this.f365129a.lock();
                this.f365133e = codecException;
                this.f365130b.signalAll();
            } catch (Exception e16) {
                ConvertLog.e(f365128f, 1, "an exception occurred while do onError, msg : " + e16);
            }
        } finally {
            this.f365129a.unlock();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i3) {
        if (ConvertLog.isDevLevel()) {
            ConvertLog.i(f365128f, 3, "onInputBufferAvailable start. codec = ", mediaCodec.getName(), ", ", Thread.currentThread().getName());
        }
        try {
            try {
                this.f365129a.lock();
                this.f365131c.add(new Pair<>(Integer.valueOf(i3), null));
                this.f365130b.signalAll();
            } catch (Exception e16) {
                ConvertLog.e(f365128f, 1, "an exception occurred while do onInputBufferAvailable, msg : " + e16);
            }
            if (ConvertLog.isDevLevel()) {
                ConvertLog.i(f365128f, 3, "onInputBufferAvailable end. codec = ", mediaCodec.getName());
            }
        } finally {
            this.f365129a.unlock();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i3, MediaCodec.BufferInfo bufferInfo) {
        if (ConvertLog.isDevLevel()) {
            ConvertLog.i(f365128f, 3, "onOutputBufferAvailable start. codec = ", mediaCodec.getName(), ", ", Thread.currentThread().getName());
        }
        try {
            try {
                this.f365129a.lock();
                this.f365132d.add(new Pair<>(Integer.valueOf(i3), bufferInfo));
                this.f365130b.signalAll();
            } catch (Exception e16) {
                ConvertLog.e(f365128f, 1, "an exception occurred while do onOutputBufferAvailable, msg : " + e16);
            }
            if (ConvertLog.isDevLevel()) {
                ConvertLog.i(f365128f, 3, "onOutputBufferAvailable end. codec = ", mediaCodec.getName());
            }
        } finally {
            this.f365129a.unlock();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        if (ConvertLog.isColorLevel()) {
            ConvertLog.d(f365128f, 2, "Output format changed: " + mediaFormat.toString(), ",  codec = ", mediaCodec.getName());
        }
    }
}
