package com.xiaomi.push;

import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class fw {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator f388931a = new b();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class b implements Comparator {
        b() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if (obj instanceof List) {
                return fw.g((List) obj, (List) obj2);
            }
            if (obj instanceof Set) {
                return fw.i((Set) obj, (Set) obj2);
            }
            if (obj instanceof Map) {
                return fw.h((Map) obj, (Map) obj2);
            }
            if (obj instanceof byte[]) {
                return fw.l((byte[]) obj, (byte[]) obj2);
            }
            return fw.d((Comparable) obj, (Comparable) obj2);
        }
    }

    public static int a(byte b16, byte b17) {
        if (b16 < b17) {
            return -1;
        }
        if (b17 < b16) {
            return 1;
        }
        return 0;
    }

    public static int b(int i3, int i16) {
        if (i3 < i16) {
            return -1;
        }
        if (i16 < i3) {
            return 1;
        }
        return 0;
    }

    public static int c(long j3, long j16) {
        if (j3 < j16) {
            return -1;
        }
        if (j16 < j3) {
            return 1;
        }
        return 0;
    }

    public static int d(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int e(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int f(ByteBuffer byteBuffer, byte[] bArr, int i3) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i3, remaining);
        return remaining;
    }

    public static int g(List list, List list2) {
        int b16 = b(list.size(), list2.size());
        if (b16 != 0) {
            return b16;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            int compare = f388931a.compare(list.get(i3), list2.get(i3));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int h(Map map, Map map2) {
        int b16 = b(map.size(), map2.size());
        if (b16 != 0) {
            return b16;
        }
        Comparator comparator = f388931a;
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(comparator);
        treeMap2.putAll(map2);
        Iterator it5 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it5.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it5.next();
            Comparator comparator2 = f388931a;
            int compare = comparator2.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = comparator2.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public static int i(Set set, Set set2) {
        int b16 = b(set.size(), set2.size());
        if (b16 != 0) {
            return b16;
        }
        Comparator comparator = f388931a;
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(comparator);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it5 = treeSet2.iterator();
        while (it.hasNext() && it5.hasNext()) {
            int compare = f388931a.compare(it.next(), it5.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int j(short s16, short s17) {
        if (s16 < s17) {
            return -1;
        }
        if (s17 < s16) {
            return 1;
        }
        return 0;
    }

    public static int k(boolean z16, boolean z17) {
        return Boolean.valueOf(z16).compareTo(Boolean.valueOf(z17));
    }

    public static int l(byte[] bArr, byte[] bArr2) {
        int b16 = b(bArr.length, bArr2.length);
        if (b16 != 0) {
            return b16;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            int a16 = a(bArr[i3], bArr2[i3]);
            if (a16 != 0) {
                return a16;
            }
        }
        return 0;
    }

    public static String m(byte b16) {
        return Integer.toHexString((b16 | 256) & 511).toUpperCase().substring(1);
    }

    public static ByteBuffer n(ByteBuffer byteBuffer) {
        if (p(byteBuffer)) {
            return byteBuffer;
        }
        return ByteBuffer.wrap(q(byteBuffer));
    }

    public static void o(ByteBuffer byteBuffer, StringBuilder sb5) {
        int i3;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        if (limit - arrayOffset > 128) {
            i3 = arrayOffset + 128;
        } else {
            i3 = limit;
        }
        for (int i16 = arrayOffset; i16 < i3; i16++) {
            if (i16 > arrayOffset) {
                sb5.append(" ");
            }
            sb5.append(m(array[i16]));
        }
        if (limit != i3) {
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
        }
    }

    public static boolean p(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity()) {
            return true;
        }
        return false;
    }

    public static byte[] q(ByteBuffer byteBuffer) {
        if (p(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        f(byteBuffer, bArr, 0);
        return bArr;
    }
}
