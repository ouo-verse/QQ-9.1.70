package com.android.vending.expansion.zipfile;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, a> f31271a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public HashMap<File, ZipFile> f31272b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    ByteBuffer f31273c = ByteBuffer.allocate(4);

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final File f31274a;

        /* renamed from: b, reason: collision with root package name */
        public final String f31275b;

        /* renamed from: c, reason: collision with root package name */
        public final String f31276c;

        /* renamed from: d, reason: collision with root package name */
        public long f31277d;

        /* renamed from: e, reason: collision with root package name */
        public int f31278e;

        /* renamed from: f, reason: collision with root package name */
        public long f31279f;

        /* renamed from: g, reason: collision with root package name */
        public long f31280g;

        /* renamed from: h, reason: collision with root package name */
        public long f31281h;

        /* renamed from: i, reason: collision with root package name */
        public long f31282i;

        /* renamed from: j, reason: collision with root package name */
        public long f31283j = -1;

        public a(String str, File file, String str2) {
            this.f31275b = str2;
            this.f31276c = str;
            this.f31274a = file;
        }

        public AssetFileDescriptor a() {
            if (this.f31278e == 0) {
                try {
                    return new AssetFileDescriptor(ParcelFileDescriptor.open(this.f31274a, 268435456), b(), this.f31282i);
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                    return null;
                }
            }
            return null;
        }

        public long b() {
            return this.f31283j;
        }

        public String c() {
            return this.f31276c;
        }

        public void d(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer) throws IOException {
            long j3 = this.f31277d;
            try {
                randomAccessFile.seek(j3);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) == 67324752) {
                    this.f31283j = j3 + 30 + (byteBuffer.getShort(26) & 65535) + (byteBuffer.getShort(28) & 65535);
                } else {
                    Log.w("zipro", "didn't find signature at start of lfh");
                    throw new IOException();
                }
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
            } catch (IOException e17) {
                e17.printStackTrace();
            }
        }
    }

    public b(String str) throws IOException {
        a(str);
    }

    private static int d(RandomAccessFile randomAccessFile) throws EOFException, IOException {
        return e(randomAccessFile.readInt());
    }

    private static int e(int i3) {
        return ((i3 & 255) << 24) + ((65280 & i3) << 8) + ((16711680 & i3) >>> 8) + ((i3 >>> 24) & 255);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) throws IOException {
        String str2 = str;
        File file = new File(str2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = randomAccessFile.length();
        if (length >= 22) {
            long j3 = 65557;
            if (65557 > length) {
                j3 = length;
            }
            randomAccessFile.seek(0L);
            int d16 = d(randomAccessFile);
            if (d16 != 101010256) {
                if (d16 == 67324752) {
                    randomAccessFile.seek(length - j3);
                    ByteBuffer allocate = ByteBuffer.allocate((int) j3);
                    byte[] array = allocate.array();
                    randomAccessFile.readFully(array);
                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                    int length2 = array.length - 22;
                    while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != 101010256)) {
                        length2--;
                    }
                    if (length2 < 0) {
                        Log.d("zipro", "Zip: EOCD not found, " + str2 + " is not zip");
                    }
                    short s16 = allocate.getShort(length2 + 8);
                    long j16 = allocate.getInt(length2 + 12) & 4294967295L;
                    long j17 = allocate.getInt(length2 + 16) & 4294967295L;
                    if (j17 + j16 <= length) {
                        if (s16 != 0) {
                            MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, j17, j16);
                            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                            map.order(byteOrder);
                            short s17 = 65535;
                            byte[] bArr = new byte[65535];
                            ByteBuffer allocate2 = ByteBuffer.allocate(30);
                            allocate2.order(byteOrder);
                            int i3 = 0;
                            int i16 = 0;
                            int i17 = 0;
                            while (i16 < s16) {
                                if (map.getInt(i17) == 33639248) {
                                    int i18 = map.getShort(i17 + 28) & s17;
                                    int i19 = map.getShort(i17 + 30) & s17;
                                    int i26 = map.getShort(i17 + 32) & s17;
                                    map.position(i17 + 46);
                                    map.get(bArr, i3, i18);
                                    map.position(i3);
                                    String str3 = new String(bArr, i3, i18);
                                    a aVar = new a(str2, file, str3);
                                    aVar.f31278e = map.getShort(i17 + 10) & 65535;
                                    aVar.f31279f = map.getInt(i17 + 12) & 4294967295L;
                                    aVar.f31280g = map.getLong(i17 + 16) & 4294967295L;
                                    aVar.f31281h = map.getLong(i17 + 20) & 4294967295L;
                                    aVar.f31282i = map.getLong(i17 + 24) & 4294967295L;
                                    aVar.f31277d = map.getInt(i17 + 42) & 4294967295L;
                                    allocate2.clear();
                                    aVar.d(randomAccessFile, allocate2);
                                    this.f31271a.put(str3, aVar);
                                    i17 += i18 + 46 + i19 + i26;
                                    i16++;
                                    str2 = str;
                                    s17 = 65535;
                                    file = file;
                                    i3 = 0;
                                } else {
                                    Log.w("zipro", "Missed a central dir sig (at " + i17 + ")");
                                    throw new IOException();
                                }
                            }
                            return;
                        }
                        Log.w("zipro", "empty archive?");
                        throw new IOException();
                    }
                    Log.w("zipro", "bad offsets (dir " + j17 + ", size " + j16 + ", eocd " + length2 + ")");
                    throw new IOException();
                }
                Log.v("zipro", "Not a Zip archive");
                throw new IOException();
            }
            Log.i("zipro", "Found Zip archive, but it looks empty");
            throw new IOException();
        }
        throw new IOException();
    }

    public a[] b() {
        Collection<a> values = this.f31271a.values();
        return (a[]) values.toArray(new a[values.size()]);
    }

    public AssetFileDescriptor c(String str) {
        a aVar = this.f31271a.get(str);
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }
}
