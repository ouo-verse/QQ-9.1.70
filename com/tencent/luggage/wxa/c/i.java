package com.tencent.luggage.wxa.c;

import com.tencent.ttpic.openapi.initializer.so.MinElf;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final int f123160a = MinElf.ELF_MAGIC;

    /* renamed from: b, reason: collision with root package name */
    public final FileChannel f123161b;

    public i(File file) {
        if (file != null && file.exists()) {
            this.f123161b = new FileInputStream(file).getChannel();
            return;
        }
        throw new IllegalArgumentException("File is null or does not exist");
    }

    public d a() {
        this.f123161b.position(0L);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (e(allocate, 0L) == 1179403647) {
            short a16 = a(allocate, 4L);
            boolean z16 = a(allocate, 5L) == 2;
            if (a16 == 1) {
                return new g(z16, this);
            }
            if (a16 == 2) {
                return new h(z16, this);
            }
            throw new IllegalStateException("Invalid class type!");
        }
        throw new IllegalArgumentException("Invalid ELF Magic!");
    }

    public int b(ByteBuffer byteBuffer, long j3) {
        a(byteBuffer, j3, 2);
        return byteBuffer.getShort() & 65535;
    }

    public long c(ByteBuffer byteBuffer, long j3) {
        a(byteBuffer, j3, 8);
        return byteBuffer.getLong();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f123161b.close();
    }

    public List d() {
        long j3;
        c a16;
        this.f123161b.position(0L);
        ArrayList arrayList = new ArrayList();
        d a17 = a();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(a17.f123144a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j16 = a17.f123149f;
        int i3 = 0;
        if (j16 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j16 = a17.a(0).f123157a;
        }
        long j17 = 0;
        while (true) {
            if (j17 >= j16) {
                j3 = 0;
                break;
            }
            e a18 = a17.a(j17);
            if (a18.f123153a == 2) {
                j3 = a18.f123154b;
                break;
            }
            j17++;
        }
        if (j3 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j18 = 0;
        do {
            a16 = a17.a(j3, i3);
            long j19 = a16.f123142a;
            if (j19 == 1) {
                arrayList2.add(Long.valueOf(a16.f123143b));
            } else if (j19 == 5) {
                j18 = a16.f123143b;
            }
            i3++;
        } while (a16.f123142a != 0);
        if (j18 != 0) {
            long a19 = a(a17, j16, j18);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(d(allocate, ((Long) it.next()).longValue() + a19));
            }
            return arrayList;
        }
        throw new IllegalStateException("String table offset not found!");
    }

    public long e(ByteBuffer byteBuffer, long j3) {
        a(byteBuffer, j3, 4);
        return byteBuffer.getInt() & 4294967295L;
    }

    public final long a(d dVar, long j3, long j16) {
        for (long j17 = 0; j17 < j3; j17++) {
            e a16 = dVar.a(j17);
            if (a16.f123153a == 1) {
                long j18 = a16.f123155c;
                if (j18 <= j16 && j16 <= a16.f123156d + j18) {
                    return (j16 - j18) + a16.f123154b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public short a(ByteBuffer byteBuffer, long j3) {
        a(byteBuffer, j3, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public void a(ByteBuffer byteBuffer, long j3, int i3) {
        byteBuffer.position(0);
        byteBuffer.limit(i3);
        long j16 = 0;
        while (j16 < i3) {
            int read = this.f123161b.read(byteBuffer, j3 + j16);
            if (read == -1) {
                throw new EOFException();
            }
            j16 += read;
        }
        byteBuffer.position(0);
    }

    public String d(ByteBuffer byteBuffer, long j3) {
        StringBuilder sb5 = new StringBuilder();
        while (true) {
            long j16 = 1 + j3;
            short a16 = a(byteBuffer, j3);
            if (a16 != 0) {
                sb5.append((char) a16);
                j3 = j16;
            } else {
                return sb5.toString();
            }
        }
    }
}
