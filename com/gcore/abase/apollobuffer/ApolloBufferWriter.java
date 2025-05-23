package com.gcore.abase.apollobuffer;

import com.gcore.abase.log.XLog;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApolloBufferWriter {

    /* renamed from: bs, reason: collision with root package name */
    private ByteBuffer f32842bs;

    public ApolloBufferWriter() {
        this(128);
    }

    public byte[] GetBufferData() {
        byte[] bArr = new byte[this.f32842bs.position()];
        System.arraycopy(this.f32842bs.array(), 0, bArr, 0, this.f32842bs.position());
        return bArr;
    }

    public ByteBuffer GetByteBuffer() {
        return this.f32842bs;
    }

    public void Reserve(int i3) {
        ByteBuffer byteBuffer;
        if (this.f32842bs.remaining() < i3) {
            try {
                byteBuffer = ByteBuffer.allocate((this.f32842bs.capacity() + i3) * 2);
                try {
                    byteBuffer.put(this.f32842bs.array(), 0, this.f32842bs.position());
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    this.f32842bs = byteBuffer;
                }
            } catch (Exception e17) {
                e = e17;
                byteBuffer = null;
            }
            this.f32842bs = byteBuffer;
        }
    }

    public void Write(boolean z16) {
        Write(z16 ? (byte) 1 : (byte) 0);
    }

    public ApolloBufferWriter(int i3) {
        this.f32842bs = ByteBuffer.allocate(i3);
    }

    public void Write(byte b16) {
        Reserve(1);
        this.f32842bs.put(b16);
    }

    public ApolloBufferWriter(ByteBuffer byteBuffer) {
        this.f32842bs = byteBuffer;
    }

    public void Write(short s16) {
        Reserve(2);
        this.f32842bs.putShort(s16);
    }

    public void Write(int i3) {
        Reserve(4);
        this.f32842bs.putInt(i3);
    }

    public void Write(long j3) {
        Reserve(8);
        this.f32842bs.putLong(j3);
    }

    public void Write(byte[] bArr) {
        Write(bArr, -1);
    }

    public void Write(byte[] bArr, int i3) {
        if (bArr != null) {
            if (i3 == -1 || i3 > bArr.length) {
                i3 = bArr.length;
            }
            Write(i3);
            Reserve(i3);
            this.f32842bs.put(bArr, 0, i3);
            return;
        }
        Write(0);
    }

    public void Write(String str) {
        if (str == null) {
            str = "";
        }
        byte[] bytes = str.getBytes();
        if (bytes == null) {
            bytes = new byte[0];
        }
        Write(bytes);
    }

    public <T> void Write(List<T> list) {
        Write(list != null ? list.size() : 0);
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                Write(list.get(i3));
            }
        }
    }

    public <T> void Write(Collection<T> collection) {
        Write(collection != null ? collection.size() : 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                Write(it.next());
            }
        }
    }

    public <K, V> void Write(Map<K, V> map) {
        if (map != null) {
            Write(map.size());
            for (Map.Entry<K, V> entry : map.entrySet()) {
                Write(entry.getKey());
                Write(entry.getValue());
            }
            return;
        }
        Write(0);
    }

    public void Write(ApolloBufferBase apolloBufferBase) {
        if (apolloBufferBase != null) {
            apolloBufferBase.Encode(this);
        }
    }

    public void Write(Object obj) {
        if (obj instanceof Byte) {
            Write(((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof Boolean) {
            Write(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Short) {
            Write(((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Integer) {
            Write(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            Write(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            Write(Float.valueOf(((Float) obj).floatValue()));
            return;
        }
        if (obj instanceof Double) {
            Write(Double.valueOf(((Double) obj).doubleValue()));
            return;
        }
        if (obj instanceof String) {
            Write((String) obj);
            return;
        }
        if (obj instanceof ApolloBufferBase) {
            Write((ApolloBufferBase) obj);
            return;
        }
        if (obj instanceof byte[]) {
            Write((byte[]) obj);
            return;
        }
        if (obj instanceof boolean[]) {
            Write((boolean[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            Write((short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            Write((int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            Write((long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            Write((float[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            Write((double[]) obj);
            return;
        }
        if (obj.getClass().isArray()) {
            Write((Object[]) obj);
            return;
        }
        if (obj instanceof List) {
            Write((List) obj);
            return;
        }
        if (obj instanceof Collection) {
            Write((Collection) obj);
        } else if (obj instanceof Map) {
            Write((Map) obj);
        } else {
            XLog.w("ABase", "ApolloBufferWriter Write Unknown Type");
        }
    }
}
