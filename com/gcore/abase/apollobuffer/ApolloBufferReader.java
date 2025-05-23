package com.gcore.abase.apollobuffer;

import com.gcore.abase.log.XLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ApolloBufferReader {

    /* renamed from: bs, reason: collision with root package name */
    private ByteBuffer f32841bs;

    public ApolloBufferReader() {
    }

    public boolean Read(boolean z16) {
        return Read((byte) 0) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> List<T> ReadList(List<T> list) {
        if (list != null && !list.isEmpty()) {
            int Read = Read(0);
            if (Read <= 0) {
                return new ArrayList();
            }
            T t16 = list.get(0);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < Read; i3++) {
                try {
                    arrayList.add(Read((ApolloBufferReader) t16.getClass().newInstance()));
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return null;
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public <K, V> Map<K, V> ReadMap(Map<K, V> map) {
        return (HashMap) ReadMap(new HashMap(), map);
    }

    public ApolloBufferReader(ByteBuffer byteBuffer) {
        this.f32841bs = byteBuffer;
    }

    public byte Read(byte b16) {
        ByteBuffer byteBuffer = this.f32841bs;
        if (byteBuffer != null) {
            return byteBuffer.get();
        }
        return (byte) 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> ReadMap(Map<K, V> map, Map<K, V> map2) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            int Read = Read(0);
            if (Read <= 0) {
                return new HashMap();
            }
            for (int i3 = 0; i3 < Read; i3++) {
                map.put(Read((ApolloBufferReader) key), Read((ApolloBufferReader) value));
            }
            return map;
        }
        return new HashMap();
    }

    public ApolloBufferReader(byte[] bArr) {
        this.f32841bs = ByteBuffer.wrap(bArr);
    }

    public byte[] Read(byte[] bArr) {
        int Read = Read(0);
        if (Read <= 0 || Read >= this.f32841bs.capacity()) {
            return null;
        }
        byte[] bArr2 = new byte[Read];
        this.f32841bs.get(bArr2);
        return bArr2;
    }

    public short Read(short s16) {
        ByteBuffer byteBuffer = this.f32841bs;
        if (byteBuffer == null) {
            return (short) 0;
        }
        return byteBuffer.getShort();
    }

    public int Read(int i3) {
        ByteBuffer byteBuffer = this.f32841bs;
        if (byteBuffer == null) {
            return 0;
        }
        return byteBuffer.getInt();
    }

    public long Read(long j3) {
        ByteBuffer byteBuffer = this.f32841bs;
        if (byteBuffer == null) {
            return 0L;
        }
        return byteBuffer.getLong();
    }

    public String Read(String str) {
        byte[] Read;
        if (this.f32841bs == null || (Read = Read((byte[]) null)) == null) {
            return null;
        }
        return new String(Read);
    }

    public ApolloBufferBase Read(ApolloBufferBase apolloBufferBase) {
        if (apolloBufferBase != null) {
            apolloBufferBase.Decode(this);
        }
        return apolloBufferBase;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object Read(T t16) {
        if (t16 instanceof Byte) {
            return Byte.valueOf(Read((byte) 0));
        }
        if (t16 instanceof Boolean) {
            return Boolean.valueOf(Read(false));
        }
        if (t16 instanceof Short) {
            return Short.valueOf(Read((short) 0));
        }
        if (t16 instanceof Integer) {
            return Integer.valueOf(Read(0));
        }
        if (t16 instanceof Long) {
            return Long.valueOf(Read(0L));
        }
        if (t16 instanceof String) {
            return Read("");
        }
        if (t16 instanceof ApolloBufferBase) {
            return Read((ApolloBufferBase) t16);
        }
        if (t16 instanceof List) {
            return ReadList((List) t16);
        }
        if (t16 instanceof Map) {
            return ReadMap((Map) t16);
        }
        XLog.w("ABase", "ApolloBufferReader Read Unknown Type");
        return null;
    }
}
