package com.qq.taf.jce;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class JceInputStream {

    /* renamed from: bs, reason: collision with root package name */
    private ByteBuffer f40900bs;
    protected String sServerEncoding = "GBK";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class HeadData {
        public int tag;
        public byte type;

        public void clear() {
            this.type = (byte) 0;
            this.tag = 0;
        }
    }

    public JceInputStream() {
    }

    private int peakHead(HeadData headData) {
        return readHead(headData, this.f40900bs.duplicate());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] readArrayImpl(T t16, int i3, boolean z16) {
        if (skipToTag(i3)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    T[] tArr = (T[]) ((Object[]) Array.newInstance(t16.getClass(), read));
                    for (int i16 = 0; i16 < read; i16++) {
                        tArr[i16] = read((JceInputStream) t16, 0, true);
                    }
                    return tArr;
                }
                throw new JceDecodeException("size invalid: " + read);
            }
            throw new JceDecodeException("type mismatch.");
        }
        if (!z16) {
            return null;
        }
        throw new JceDecodeException("require field not exist.");
    }

    public static int readHead(HeadData headData, ByteBuffer byteBuffer) {
        byte b16 = byteBuffer.get();
        headData.type = (byte) (b16 & RegisterType.DOUBLE_HI);
        int i3 = (b16 & 240) >> 4;
        headData.tag = i3;
        if (i3 != 15) {
            return 1;
        }
        headData.tag = byteBuffer.get() & 255;
        return 2;
    }

    private void skip(int i3) {
        ByteBuffer byteBuffer = this.f40900bs;
        byteBuffer.position(byteBuffer.position() + i3);
    }

    private void skipField() {
        HeadData headData = new HeadData();
        readHead(headData);
        skipField(headData.type);
    }

    public JceStruct directRead(JceStruct jceStruct, int i3, boolean z16) {
        if (skipToTag(i3)) {
            try {
                JceStruct newInit = jceStruct.newInit();
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type == 10) {
                    newInit.readFrom(this);
                    skipToStructEnd();
                    return newInit;
                }
                throw new JceDecodeException("type mismatch.");
            } catch (Exception e16) {
                throw new JceDecodeException(e16.getMessage());
            }
        }
        if (!z16) {
            return null;
        }
        throw new JceDecodeException("require field not exist.");
    }

    public ByteBuffer getBs() {
        return this.f40900bs;
    }

    public boolean read(boolean z16, int i3, boolean z17) {
        return read((byte) 0, i3, z17) != 0;
    }

    public <T> T[] readArray(T[] tArr, int i3, boolean z16) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) readArrayImpl(tArr[0], i3, z16);
        }
        throw new JceDecodeException("unable to get type of key and value.");
    }

    public String readByteString(String str, int i3, boolean z16) {
        if (skipToTag(i3)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b16 = headData.type;
            if (b16 != 6) {
                if (b16 == 7) {
                    int i16 = this.f40900bs.getInt();
                    if (i16 <= 104857600 && i16 >= 0 && i16 <= this.f40900bs.capacity()) {
                        byte[] bArr = new byte[i16];
                        this.f40900bs.get(bArr);
                        return HexUtil.bytes2HexStr(bArr);
                    }
                    throw new JceDecodeException("String too long: " + i16);
                }
                throw new JceDecodeException("type mismatch.");
            }
            int i17 = this.f40900bs.get();
            if (i17 < 0) {
                i17 += 256;
            }
            byte[] bArr2 = new byte[i17];
            this.f40900bs.get(bArr2);
            return HexUtil.bytes2HexStr(bArr2);
        }
        if (!z16) {
            return str;
        }
        throw new JceDecodeException("require field not exist.");
    }

    public List readList(int i3, boolean z16) {
        ArrayList arrayList = new ArrayList();
        if (skipToTag(i3)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    for (int i16 = 0; i16 < read; i16++) {
                        HeadData headData2 = new HeadData();
                        readHead(headData2);
                        switch (headData2.type) {
                            case 0:
                                skip(1);
                                break;
                            case 1:
                                skip(2);
                                break;
                            case 2:
                                skip(4);
                                break;
                            case 3:
                                skip(8);
                                break;
                            case 4:
                                skip(4);
                                break;
                            case 5:
                                skip(8);
                                break;
                            case 6:
                                int i17 = this.f40900bs.get();
                                if (i17 < 0) {
                                    i17 += 256;
                                }
                                skip(i17);
                                break;
                            case 7:
                                skip(this.f40900bs.getInt());
                                break;
                            case 8:
                            case 9:
                                break;
                            case 10:
                                try {
                                    JceStruct jceStruct = (JceStruct) Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
                                    jceStruct.readFrom(this);
                                    skipToStructEnd();
                                    arrayList.add(jceStruct);
                                    break;
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                    throw new JceDecodeException("type mismatch." + e16);
                                }
                            case 11:
                            default:
                                throw new JceDecodeException("type mismatch.");
                            case 12:
                                arrayList.add(new Integer(0));
                                break;
                        }
                    }
                } else {
                    throw new JceDecodeException("size invalid: " + read);
                }
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (z16) {
            throw new JceDecodeException("require field not exist.");
        }
        return arrayList;
    }

    public <K, V> HashMap<K, V> readMap(Map<K, V> map, int i3, boolean z16) {
        return (HashMap) readMap(new HashMap(), map, i3, z16);
    }

    public String readString(int i3, boolean z16) {
        if (skipToTag(i3)) {
            HeadData headData = new HeadData();
            readHead(headData);
            byte b16 = headData.type;
            if (b16 != 6) {
                if (b16 == 7) {
                    int i16 = this.f40900bs.getInt();
                    if (i16 <= 104857600 && i16 >= 0 && i16 <= this.f40900bs.capacity()) {
                        byte[] bArr = new byte[i16];
                        this.f40900bs.get(bArr);
                        try {
                            return new String(bArr, this.sServerEncoding);
                        } catch (UnsupportedEncodingException unused) {
                            return new String(bArr);
                        }
                    }
                    throw new JceDecodeException("String too long: " + i16);
                }
                throw new JceDecodeException("type mismatch.");
            }
            int i17 = this.f40900bs.get();
            if (i17 < 0) {
                i17 += 256;
            }
            byte[] bArr2 = new byte[i17];
            this.f40900bs.get(bArr2);
            try {
                return new String(bArr2, this.sServerEncoding);
            } catch (UnsupportedEncodingException unused2) {
                return new String(bArr2);
            }
        }
        if (!z16) {
            return null;
        }
        throw new JceDecodeException("require field not exist.");
    }

    public Map<String, String> readStringMap(int i3, boolean z16) {
        HashMap hashMap = new HashMap();
        if (skipToTag(i3)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 8) {
                int read = read(0, 0, true);
                if (read >= 0) {
                    for (int i16 = 0; i16 < read; i16++) {
                        hashMap.put(readString(0, true), readString(1, true));
                    }
                } else {
                    throw new JceDecodeException("size invalid: " + read);
                }
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (z16) {
            throw new JceDecodeException("require field not exist.");
        }
        return hashMap;
    }

    public int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public void skipToStructEnd() {
        HeadData headData = new HeadData();
        do {
            readHead(headData);
            skipField(headData.type);
        } while (headData.type != 11);
    }

    public boolean skipToTag(int i3) {
        try {
            HeadData headData = new HeadData();
            while (true) {
                int peakHead = peakHead(headData);
                if (headData.type == 11) {
                    return false;
                }
                int i16 = headData.tag;
                if (i3 <= i16) {
                    if (i3 != i16) {
                        return false;
                    }
                    return true;
                }
                skip(peakHead);
                skipField(headData.type);
            }
        } catch (JceDecodeException | BufferUnderflowException unused) {
            return false;
        }
    }

    public void warp(byte[] bArr) {
        wrap(bArr);
    }

    public void wrap(byte[] bArr) {
        this.f40900bs = ByteBuffer.wrap(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> readMap(Map<K, V> map, Map<K, V> map2, int i3, boolean z16) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (skipToTag(i3)) {
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type == 8) {
                    int read = read(0, 0, true);
                    if (read < 0) {
                        throw new JceDecodeException("size invalid: " + read);
                    }
                    for (int i16 = 0; i16 < read; i16++) {
                        map.put(read((JceInputStream) key, 0, true), read((JceInputStream) value, 1, true));
                    }
                } else {
                    throw new JceDecodeException("type mismatch.");
                }
            } else if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    public byte read(byte b16, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return b16;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b17 = headData.type;
        if (b17 == 0) {
            return this.f40900bs.get();
        }
        if (b17 == 12) {
            return (byte) 0;
        }
        throw new JceDecodeException("type mismatch.");
    }

    public JceInputStream(ByteBuffer byteBuffer) {
        this.f40900bs = byteBuffer;
    }

    private void skipField(byte b16) {
        int i3 = 0;
        switch (b16) {
            case 0:
                skip(1);
                return;
            case 1:
                skip(2);
                return;
            case 2:
                skip(4);
                return;
            case 3:
                skip(8);
                return;
            case 4:
                skip(4);
                return;
            case 5:
                skip(8);
                return;
            case 6:
                int i16 = this.f40900bs.get();
                if (i16 < 0) {
                    i16 += 256;
                }
                skip(i16);
                return;
            case 7:
                skip(this.f40900bs.getInt());
                return;
            case 8:
                int read = read(0, 0, true);
                while (i3 < read * 2) {
                    skipField();
                    i3++;
                }
                return;
            case 9:
                int read2 = read(0, 0, true);
                while (i3 < read2) {
                    skipField();
                    i3++;
                }
                return;
            case 10:
                skipToStructEnd();
                return;
            case 11:
            case 12:
                return;
            case 13:
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type == 0) {
                    skip(read(0, 0, true));
                    return;
                }
                throw new JceDecodeException("skipField with invalid type, type value: " + ((int) b16) + ", " + ((int) headData.type));
            default:
                throw new JceDecodeException("invalid type.");
        }
    }

    public <T> List<T> readArray(List<T> list, int i3, boolean z16) {
        if (list != null && !list.isEmpty()) {
            Object[] readArrayImpl = readArrayImpl(list.get(0), i3, z16);
            if (readArrayImpl == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : readArrayImpl) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public void readHead(HeadData headData) {
        readHead(headData, this.f40900bs);
    }

    public JceInputStream(byte[] bArr) {
        this.f40900bs = ByteBuffer.wrap(bArr);
    }

    public JceInputStream(byte[] bArr, int i3) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f40900bs = wrap;
        wrap.position(i3);
    }

    public short read(short s16, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return s16;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b16 = headData.type;
        if (b16 == 0) {
            return this.f40900bs.get();
        }
        if (b16 == 1) {
            return this.f40900bs.getShort();
        }
        if (b16 == 12) {
            return (short) 0;
        }
        throw new JceDecodeException("type mismatch.");
    }

    public int read(int i3, int i16, boolean z16) {
        if (!skipToTag(i16)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return i3;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b16 = headData.type;
        if (b16 == 0) {
            return this.f40900bs.get();
        }
        if (b16 == 1) {
            return this.f40900bs.getShort();
        }
        if (b16 == 2) {
            return this.f40900bs.getInt();
        }
        if (b16 == 12) {
            return 0;
        }
        throw new JceDecodeException("type mismatch.");
    }

    public long read(long j3, int i3, boolean z16) {
        int i16;
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return j3;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b16 = headData.type;
        if (b16 == 0) {
            i16 = this.f40900bs.get();
        } else if (b16 == 1) {
            i16 = this.f40900bs.getShort();
        } else {
            if (b16 != 2) {
                if (b16 == 3) {
                    return this.f40900bs.getLong();
                }
                if (b16 == 12) {
                    return 0L;
                }
                throw new JceDecodeException("type mismatch.");
            }
            i16 = this.f40900bs.getInt();
        }
        return i16;
    }

    public static void main(String[] strArr) {
    }

    public float read(float f16, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return f16;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b16 = headData.type;
        if (b16 == 4) {
            return this.f40900bs.getFloat();
        }
        if (b16 == 12) {
            return 0.0f;
        }
        throw new JceDecodeException("type mismatch.");
    }

    public double read(double d16, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return d16;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b16 = headData.type;
        if (b16 == 4) {
            return this.f40900bs.getFloat();
        }
        if (b16 == 5) {
            return this.f40900bs.getDouble();
        }
        if (b16 == 12) {
            return 0.0d;
        }
        throw new JceDecodeException("type mismatch.");
    }

    public String read(String str, int i3, boolean z16) {
        String str2;
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return str;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b16 = headData.type;
        if (b16 == 6) {
            int i16 = this.f40900bs.get();
            if (i16 < 0) {
                i16 += 256;
            }
            byte[] bArr = new byte[i16];
            this.f40900bs.get(bArr);
            try {
                str2 = new String(bArr, this.sServerEncoding);
            } catch (UnsupportedEncodingException unused) {
                str2 = new String(bArr);
            }
        } else if (b16 == 7) {
            int i17 = this.f40900bs.getInt();
            if (i17 <= 104857600 && i17 >= 0 && i17 <= this.f40900bs.capacity()) {
                byte[] bArr2 = new byte[i17];
                this.f40900bs.get(bArr2);
                try {
                    str2 = new String(bArr2, this.sServerEncoding);
                } catch (UnsupportedEncodingException unused2) {
                    str2 = new String(bArr2);
                }
            } else {
                throw new JceDecodeException("String too long: " + i17);
            }
        } else {
            throw new JceDecodeException("type mismatch.");
        }
        return str2;
    }

    public String[] read(String[] strArr, int i3, boolean z16) {
        return (String[]) readArray(strArr, i3, z16);
    }

    public boolean[] read(boolean[] zArr, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read >= 0) {
                boolean[] zArr2 = new boolean[read];
                for (int i16 = 0; i16 < read; i16++) {
                    zArr2[i16] = read(zArr2[0], 0, true);
                }
                return zArr2;
            }
            throw new JceDecodeException("size invalid: " + read);
        }
        throw new JceDecodeException("type mismatch.");
    }

    public byte[] read(byte[] bArr, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b16 = headData.type;
        if (b16 == 9) {
            int read = read(0, 0, true);
            if (read >= 0 && read <= this.f40900bs.capacity()) {
                byte[] bArr2 = new byte[read];
                for (int i16 = 0; i16 < read; i16++) {
                    bArr2[i16] = read(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new JceDecodeException("size invalid: " + read);
        }
        if (b16 == 13) {
            HeadData headData2 = new HeadData();
            readHead(headData2);
            if (headData2.type == 0) {
                int read2 = read(0, 0, true);
                if (read2 >= 0 && read2 <= this.f40900bs.capacity()) {
                    byte[] bArr3 = new byte[read2];
                    this.f40900bs.get(bArr3);
                    return bArr3;
                }
                throw new JceDecodeException("invalid size, tag: " + i3 + ", type: " + ((int) headData.type) + ", " + ((int) headData2.type) + ", size: " + read2);
            }
            throw new JceDecodeException("type mismatch, tag: " + i3 + ", type: " + ((int) headData.type) + ", " + ((int) headData2.type));
        }
        throw new JceDecodeException("type mismatch.");
    }

    public short[] read(short[] sArr, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read >= 0) {
                short[] sArr2 = new short[read];
                for (int i16 = 0; i16 < read; i16++) {
                    sArr2[i16] = read(sArr2[0], 0, true);
                }
                return sArr2;
            }
            throw new JceDecodeException("size invalid: " + read);
        }
        throw new JceDecodeException("type mismatch.");
    }

    public int[] read(int[] iArr, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read >= 0) {
                int[] iArr2 = new int[read];
                for (int i16 = 0; i16 < read; i16++) {
                    iArr2[i16] = read(iArr2[0], 0, true);
                }
                return iArr2;
            }
            throw new JceDecodeException("size invalid: " + read);
        }
        throw new JceDecodeException("type mismatch.");
    }

    public long[] read(long[] jArr, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read >= 0) {
                long[] jArr2 = new long[read];
                for (int i16 = 0; i16 < read; i16++) {
                    jArr2[i16] = read(jArr2[0], 0, true);
                }
                return jArr2;
            }
            throw new JceDecodeException("size invalid: " + read);
        }
        throw new JceDecodeException("type mismatch.");
    }

    public float[] read(float[] fArr, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read >= 0) {
                float[] fArr2 = new float[read];
                for (int i16 = 0; i16 < read; i16++) {
                    fArr2[i16] = read(fArr2[0], 0, true);
                }
                return fArr2;
            }
            throw new JceDecodeException("size invalid: " + read);
        }
        throw new JceDecodeException("type mismatch.");
    }

    public double[] read(double[] dArr, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read >= 0) {
                double[] dArr2 = new double[read];
                for (int i16 = 0; i16 < read; i16++) {
                    dArr2[i16] = read(dArr2[0], 0, true);
                }
                return dArr2;
            }
            throw new JceDecodeException("size invalid: " + read);
        }
        throw new JceDecodeException("type mismatch.");
    }

    public JceStruct read(JceStruct jceStruct, int i3, boolean z16) {
        if (!skipToTag(i3)) {
            if (z16) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        try {
            JceStruct jceStruct2 = (JceStruct) jceStruct.getClass().newInstance();
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 10) {
                jceStruct2.readFrom(this);
                skipToStructEnd();
                return jceStruct2;
            }
            throw new JceDecodeException("type mismatch.");
        } catch (Exception e16) {
            throw new JceDecodeException(e16.getMessage());
        }
    }

    public JceStruct[] read(JceStruct[] jceStructArr, int i3, boolean z16) {
        return (JceStruct[]) readArray(jceStructArr, i3, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object read(T t16, int i3, boolean z16) {
        if (t16 instanceof Byte) {
            return Byte.valueOf(read((byte) 0, i3, z16));
        }
        if (t16 instanceof Boolean) {
            return Boolean.valueOf(read(false, i3, z16));
        }
        if (t16 instanceof Short) {
            return Short.valueOf(read((short) 0, i3, z16));
        }
        if (t16 instanceof Integer) {
            return Integer.valueOf(read(0, i3, z16));
        }
        if (t16 instanceof Long) {
            return Long.valueOf(read(0L, i3, z16));
        }
        if (t16 instanceof Float) {
            return Float.valueOf(read(0.0f, i3, z16));
        }
        if (t16 instanceof Double) {
            return Double.valueOf(read(0.0d, i3, z16));
        }
        if (t16 instanceof String) {
            return readString(i3, z16);
        }
        if (t16 instanceof Map) {
            return readMap((Map) t16, i3, z16);
        }
        if (t16 instanceof List) {
            return readArray((List) t16, i3, z16);
        }
        if (t16 instanceof JceStruct) {
            return read((JceStruct) t16, i3, z16);
        }
        if (t16.getClass().isArray()) {
            if (!(t16 instanceof byte[]) && !(t16 instanceof Byte[])) {
                if (t16 instanceof boolean[]) {
                    return read((boolean[]) null, i3, z16);
                }
                if (t16 instanceof short[]) {
                    return read((short[]) null, i3, z16);
                }
                if (t16 instanceof int[]) {
                    return read((int[]) null, i3, z16);
                }
                if (t16 instanceof long[]) {
                    return read((long[]) null, i3, z16);
                }
                if (t16 instanceof float[]) {
                    return read((float[]) null, i3, z16);
                }
                if (t16 instanceof double[]) {
                    return read((double[]) null, i3, z16);
                }
                return readArray((Object[]) t16, i3, z16);
            }
            return read((byte[]) null, i3, z16);
        }
        throw new JceDecodeException("read object error: unsupport type.");
    }
}
