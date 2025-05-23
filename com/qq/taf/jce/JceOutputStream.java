package com.qq.taf.jce;

import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JceOutputStream {

    /* renamed from: bs, reason: collision with root package name */
    private ByteBuffer f40901bs;
    private OnIllegalArgumentException exceptionHandler;
    protected String sServerEncoding;

    public JceOutputStream(ByteBuffer byteBuffer) {
        this.sServerEncoding = "GBK";
        this.f40901bs = byteBuffer;
    }

    public static void main(String[] strArr) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.write(1311768467283714885L, 0);
        System.out.println(HexUtil.bytes2HexStr(jceOutputStream.getByteBuffer().array()));
        System.out.println(Arrays.toString(jceOutputStream.toByteArray()));
    }

    private void writeArray(Object[] objArr, int i3) {
        reserve(8);
        writeHead((byte) 9, i3);
        write(objArr.length, 0);
        for (Object obj : objArr) {
            write(obj, 0);
        }
    }

    public ByteBuffer getByteBuffer() {
        return this.f40901bs;
    }

    public OnIllegalArgumentException getExceptionHandler() {
        return this.exceptionHandler;
    }

    public void reserve(int i3) {
        if (this.f40901bs.remaining() < i3) {
            int capacity = (this.f40901bs.capacity() + i3) * 2;
            try {
                ByteBuffer allocate = ByteBuffer.allocate(capacity);
                allocate.put(this.f40901bs.array(), 0, this.f40901bs.position());
                this.f40901bs = allocate;
            } catch (IllegalArgumentException e16) {
                OnIllegalArgumentException onIllegalArgumentException = this.exceptionHandler;
                if (onIllegalArgumentException != null) {
                    onIllegalArgumentException.onException(e16, this.f40901bs, i3, capacity);
                }
                throw e16;
            }
        }
    }

    public void setExceptionHandler(OnIllegalArgumentException onIllegalArgumentException) {
        this.exceptionHandler = onIllegalArgumentException;
    }

    public int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public byte[] toByteArray() {
        byte[] bArr = new byte[this.f40901bs.position()];
        System.arraycopy(this.f40901bs.array(), 0, bArr, 0, this.f40901bs.position());
        return bArr;
    }

    public void write(boolean z16, int i3) {
        write(z16 ? (byte) 1 : (byte) 0, i3);
    }

    public void writeByteString(String str, int i3) {
        reserve(str.length() + 10);
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
        if (hexStr2Bytes.length > 255) {
            writeHead((byte) 7, i3);
            this.f40901bs.putInt(hexStr2Bytes.length);
            this.f40901bs.put(hexStr2Bytes);
        } else {
            writeHead((byte) 6, i3);
            this.f40901bs.put((byte) hexStr2Bytes.length);
            this.f40901bs.put(hexStr2Bytes);
        }
    }

    public void writeHead(byte b16, int i3) {
        if (i3 < 15) {
            this.f40901bs.put((byte) (b16 | (i3 << 4)));
        } else if (i3 < 256) {
            this.f40901bs.put((byte) (b16 | 240));
            this.f40901bs.put((byte) i3);
        } else {
            throw new JceEncodeException("tag is too large: " + i3);
        }
    }

    public void writeStringByte(String str, int i3) {
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(str);
        reserve(hexStr2Bytes.length + 10);
        if (hexStr2Bytes.length > 255) {
            writeHead((byte) 7, i3);
            this.f40901bs.putInt(hexStr2Bytes.length);
            this.f40901bs.put(hexStr2Bytes);
        } else {
            writeHead((byte) 6, i3);
            this.f40901bs.put((byte) hexStr2Bytes.length);
            this.f40901bs.put(hexStr2Bytes);
        }
    }

    public void write(byte b16, int i3) {
        reserve(3);
        if (b16 == 0) {
            writeHead((byte) 12, i3);
        } else {
            writeHead((byte) 0, i3);
            this.f40901bs.put(b16);
        }
    }

    public JceOutputStream(int i3) {
        this.sServerEncoding = "GBK";
        this.f40901bs = ByteBuffer.allocate(i3);
    }

    public void write(short s16, int i3) {
        reserve(4);
        if (s16 >= -128 && s16 <= 127) {
            write((byte) s16, i3);
        } else {
            writeHead((byte) 1, i3);
            this.f40901bs.putShort(s16);
        }
    }

    public JceOutputStream() {
        this(128);
    }

    public void write(int i3, int i16) {
        reserve(6);
        if (i3 >= -32768 && i3 <= 32767) {
            write((short) i3, i16);
        } else {
            writeHead((byte) 2, i16);
            this.f40901bs.putInt(i3);
        }
    }

    public void write(long j3, int i3) {
        reserve(10);
        if (j3 >= WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && j3 <= TTL.MAX_VALUE) {
            write((int) j3, i3);
        } else {
            writeHead((byte) 3, i3);
            this.f40901bs.putLong(j3);
        }
    }

    public void write(float f16, int i3) {
        reserve(6);
        writeHead((byte) 4, i3);
        this.f40901bs.putFloat(f16);
    }

    public void write(double d16, int i3) {
        reserve(10);
        writeHead((byte) 5, i3);
        this.f40901bs.putDouble(d16);
    }

    public void write(String str, int i3) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.sServerEncoding);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        reserve(bytes.length + 10);
        if (bytes.length > 255) {
            writeHead((byte) 7, i3);
            this.f40901bs.putInt(bytes.length);
            this.f40901bs.put(bytes);
        } else {
            writeHead((byte) 6, i3);
            this.f40901bs.put((byte) bytes.length);
            this.f40901bs.put(bytes);
        }
    }

    public <K, V> void write(Map<K, V> map, int i3) {
        reserve(8);
        writeHead((byte) 8, i3);
        write(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                write(entry.getKey(), 0);
                write(entry.getValue(), 1);
            }
        }
    }

    public void write(boolean[] zArr, int i3) {
        reserve(8);
        writeHead((byte) 9, i3);
        write(zArr.length, 0);
        for (boolean z16 : zArr) {
            write(z16, 0);
        }
    }

    public void write(byte[] bArr, int i3) {
        reserve(bArr.length + 8);
        writeHead((byte) 13, i3);
        writeHead((byte) 0, 0);
        write(bArr.length, 0);
        this.f40901bs.put(bArr);
    }

    public void write(short[] sArr, int i3) {
        reserve(8);
        writeHead((byte) 9, i3);
        write(sArr.length, 0);
        for (short s16 : sArr) {
            write(s16, 0);
        }
    }

    public void write(int[] iArr, int i3) {
        reserve(8);
        writeHead((byte) 9, i3);
        write(iArr.length, 0);
        for (int i16 : iArr) {
            write(i16, 0);
        }
    }

    public void write(long[] jArr, int i3) {
        reserve(8);
        writeHead((byte) 9, i3);
        write(jArr.length, 0);
        for (long j3 : jArr) {
            write(j3, 0);
        }
    }

    public void write(float[] fArr, int i3) {
        reserve(8);
        writeHead((byte) 9, i3);
        write(fArr.length, 0);
        for (float f16 : fArr) {
            write(f16, 0);
        }
    }

    public void write(double[] dArr, int i3) {
        reserve(8);
        writeHead((byte) 9, i3);
        write(dArr.length, 0);
        for (double d16 : dArr) {
            write(d16, 0);
        }
    }

    public <T> void write(T[] tArr, int i3) {
        writeArray(tArr, i3);
    }

    public <T> void write(Collection<T> collection, int i3) {
        reserve(8);
        writeHead((byte) 9, i3);
        write(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                write(it.next(), 0);
            }
        }
    }

    public void write(JceStruct jceStruct, int i3) {
        reserve(2);
        writeHead((byte) 10, i3);
        jceStruct.writeTo(this);
        reserve(2);
        writeHead((byte) 11, 0);
    }

    public void write(Byte b16, int i3) {
        write(b16.byteValue(), i3);
    }

    public void write(Boolean bool, int i3) {
        write(bool.booleanValue(), i3);
    }

    public void write(Short sh5, int i3) {
        write(sh5.shortValue(), i3);
    }

    public void write(Integer num, int i3) {
        write(num.intValue(), i3);
    }

    public void write(Long l3, int i3) {
        write(l3.longValue(), i3);
    }

    public void write(Float f16, int i3) {
        write(f16.floatValue(), i3);
    }

    public void write(Double d16, int i3) {
        write(d16.doubleValue(), i3);
    }

    public void write(Object obj, int i3) {
        if (obj instanceof Byte) {
            write(((Byte) obj).byteValue(), i3);
            return;
        }
        if (obj instanceof Boolean) {
            write(((Boolean) obj).booleanValue(), i3);
            return;
        }
        if (obj instanceof Short) {
            write(((Short) obj).shortValue(), i3);
            return;
        }
        if (obj instanceof Integer) {
            write(((Integer) obj).intValue(), i3);
            return;
        }
        if (obj instanceof Long) {
            write(((Long) obj).longValue(), i3);
            return;
        }
        if (obj instanceof Float) {
            write(((Float) obj).floatValue(), i3);
            return;
        }
        if (obj instanceof Double) {
            write(((Double) obj).doubleValue(), i3);
            return;
        }
        if (obj instanceof String) {
            write((String) obj, i3);
            return;
        }
        if (obj instanceof Map) {
            write((Map) obj, i3);
            return;
        }
        if (obj instanceof List) {
            write((Collection) obj, i3);
            return;
        }
        if (obj instanceof JceStruct) {
            write((JceStruct) obj, i3);
            return;
        }
        if (obj instanceof byte[]) {
            write((byte[]) obj, i3);
            return;
        }
        if (obj instanceof boolean[]) {
            write((boolean[]) obj, i3);
            return;
        }
        if (obj instanceof short[]) {
            write((short[]) obj, i3);
            return;
        }
        if (obj instanceof int[]) {
            write((int[]) obj, i3);
            return;
        }
        if (obj instanceof long[]) {
            write((long[]) obj, i3);
            return;
        }
        if (obj instanceof float[]) {
            write((float[]) obj, i3);
            return;
        }
        if (obj instanceof double[]) {
            write((double[]) obj, i3);
            return;
        }
        if (obj.getClass().isArray()) {
            writeArray((Object[]) obj, i3);
        } else {
            if (obj instanceof Collection) {
                write((Collection) obj, i3);
                return;
            }
            throw new JceEncodeException("write object error: unsupport type. " + obj.getClass());
        }
    }
}
