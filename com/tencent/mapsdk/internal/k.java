package com.tencent.mapsdk.internal;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f148951a;

    /* renamed from: b, reason: collision with root package name */
    private int f148952b;

    public k(StringBuilder sb5, int i3) {
        this.f148951a = sb5;
        this.f148952b = i3;
    }

    private void a(String str) {
        for (int i3 = 0; i3 < this.f148952b; i3++) {
            this.f148951a.append('\t');
        }
        if (str != null) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(str);
            sb5.append(MsgSummary.STR_COLON);
        }
    }

    k(StringBuilder sb5) {
        this.f148952b = 0;
        this.f148951a = sb5;
    }

    private k a(boolean z16, String str) {
        a(str);
        StringBuilder sb5 = this.f148951a;
        sb5.append(z16 ? 'T' : 'F');
        sb5.append('\n');
        return this;
    }

    private k a(boolean z16, boolean z17) {
        this.f148951a.append(z16 ? 'T' : 'F');
        if (z17) {
            this.f148951a.append("|");
        }
        return this;
    }

    public final k a(byte b16, String str) {
        a(str);
        StringBuilder sb5 = this.f148951a;
        sb5.append((int) b16);
        sb5.append('\n');
        return this;
    }

    public final k a(byte b16, boolean z16) {
        this.f148951a.append((int) b16);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private k a(char c16, String str) {
        a(str);
        StringBuilder sb5 = this.f148951a;
        sb5.append(c16);
        sb5.append('\n');
        return this;
    }

    private k a(char c16, boolean z16) {
        this.f148951a.append(c16);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    public final k a(short s16, String str) {
        a(str);
        StringBuilder sb5 = this.f148951a;
        sb5.append((int) s16);
        sb5.append('\n');
        return this;
    }

    public final k a(short s16, boolean z16) {
        this.f148951a.append((int) s16);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    public final k a(int i3, String str) {
        a(str);
        StringBuilder sb5 = this.f148951a;
        sb5.append(i3);
        sb5.append('\n');
        return this;
    }

    public final k a(int i3, boolean z16) {
        this.f148951a.append(i3);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    public final k a(long j3, String str) {
        a(str);
        StringBuilder sb5 = this.f148951a;
        sb5.append(j3);
        sb5.append('\n');
        return this;
    }

    public final k a(long j3, boolean z16) {
        this.f148951a.append(j3);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private k a(float f16, String str) {
        a(str);
        StringBuilder sb5 = this.f148951a;
        sb5.append(f16);
        sb5.append('\n');
        return this;
    }

    private k a(float f16, boolean z16) {
        this.f148951a.append(f16);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private k a(double d16, String str) {
        a(str);
        StringBuilder sb5 = this.f148951a;
        sb5.append(d16);
        sb5.append('\n');
        return this;
    }

    private k a(double d16, boolean z16) {
        this.f148951a.append(d16);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    public final k a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f148951a.append("null\n");
        } else {
            StringBuilder sb5 = this.f148951a;
            sb5.append(str);
            sb5.append('\n');
        }
        return this;
    }

    public final k a(String str, boolean z16) {
        if (str == null) {
            this.f148951a.append("null");
        } else {
            this.f148951a.append(str);
        }
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    public final k a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f148951a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(bArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f148951a;
        sb6.append(bArr.length);
        sb6.append(", [\n");
        k kVar = new k(this.f148951a, this.f148952b + 1);
        for (byte b16 : bArr) {
            kVar.a(b16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public final k a(byte[] bArr, boolean z16) {
        if (bArr == null || bArr.length == 0) {
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        this.f148951a.append(i.a(bArr));
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private k a(char[] cArr, String str) {
        a(str);
        if (cArr == null) {
            this.f148951a.append("null\n");
            return this;
        }
        if (cArr.length == 0) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(cArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f148951a;
        sb6.append(cArr.length);
        sb6.append(", [\n");
        k kVar = new k(this.f148951a, this.f148952b + 1);
        for (char c16 : cArr) {
            kVar.a(c16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private k a(char[] cArr, boolean z16) {
        if (cArr == null || cArr.length == 0) {
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        this.f148951a.append(new String(cArr));
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private k a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.f148951a.append("null\n");
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(sArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f148951a;
        sb6.append(sArr.length);
        sb6.append(", [\n");
        k kVar = new k(this.f148951a, this.f148952b + 1);
        for (short s16 : sArr) {
            kVar.a(s16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private k a(short[] sArr, boolean z16) {
        if (sArr != null && sArr.length != 0) {
            this.f148951a.append("[");
            k kVar = new k(this.f148951a, this.f148952b + 1);
            for (int i3 = 0; i3 < sArr.length; i3++) {
                short s16 = sArr[i3];
                if (i3 != 0) {
                    this.f148951a.append("|");
                }
                kVar.a(s16, false);
            }
            this.f148951a.append("]");
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        this.f148951a.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private k a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.f148951a.append("null\n");
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(iArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f148951a;
        sb6.append(iArr.length);
        sb6.append(", [\n");
        k kVar = new k(this.f148951a, this.f148952b + 1);
        for (int i3 : iArr) {
            kVar.a(i3, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private k a(int[] iArr, boolean z16) {
        if (iArr != null && iArr.length != 0) {
            this.f148951a.append("[");
            k kVar = new k(this.f148951a, this.f148952b + 1);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int i16 = iArr[i3];
                if (i3 != 0) {
                    this.f148951a.append("|");
                }
                kVar.a(i16, false);
            }
            this.f148951a.append("]");
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        this.f148951a.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private k a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.f148951a.append("null\n");
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(jArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f148951a;
        sb6.append(jArr.length);
        sb6.append(", [\n");
        k kVar = new k(this.f148951a, this.f148952b + 1);
        for (long j3 : jArr) {
            kVar.a(j3, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private k a(long[] jArr, boolean z16) {
        if (jArr != null && jArr.length != 0) {
            this.f148951a.append("[");
            k kVar = new k(this.f148951a, this.f148952b + 1);
            for (int i3 = 0; i3 < jArr.length; i3++) {
                long j3 = jArr[i3];
                if (i3 != 0) {
                    this.f148951a.append("|");
                }
                kVar.a(j3, false);
            }
            this.f148951a.append("]");
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        this.f148951a.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private k a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.f148951a.append("null\n");
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(fArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f148951a;
        sb6.append(fArr.length);
        sb6.append(", [\n");
        k kVar = new k(this.f148951a, this.f148952b + 1);
        for (float f16 : fArr) {
            kVar.a(f16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private k a(float[] fArr, boolean z16) {
        if (fArr != null && fArr.length != 0) {
            this.f148951a.append("[");
            k kVar = new k(this.f148951a, this.f148952b + 1);
            for (int i3 = 0; i3 < fArr.length; i3++) {
                float f16 = fArr[i3];
                if (i3 != 0) {
                    this.f148951a.append("|");
                }
                kVar.a(f16, false);
            }
            this.f148951a.append("]");
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        this.f148951a.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private k a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.f148951a.append("null\n");
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(dArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f148951a;
        sb6.append(dArr.length);
        sb6.append(", [\n");
        k kVar = new k(this.f148951a, this.f148952b + 1);
        for (double d16 : dArr) {
            kVar.a(d16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private k a(double[] dArr, boolean z16) {
        if (dArr != null && dArr.length != 0) {
            this.f148951a.append("[");
            k kVar = new k(this.f148951a, this.f148952b + 1);
            for (int i3 = 0; i3 < dArr.length; i3++) {
                double d16 = dArr[i3];
                if (i3 != 0) {
                    this.f148951a.append("|");
                }
                kVar.a(d16, false);
            }
            this.f148951a.append("[");
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        this.f148951a.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    public final <K, V> k a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f148951a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(map.size());
            sb5.append(", {}\n");
            return this;
        }
        StringBuilder sb6 = this.f148951a;
        sb6.append(map.size());
        sb6.append(", {\n");
        k kVar = new k(this.f148951a, this.f148952b + 1);
        k kVar2 = new k(this.f148951a, this.f148952b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            kVar.a('(', (String) null);
            kVar2.a((k) entry.getKey(), (String) null);
            kVar2.a((k) entry.getValue(), (String) null);
            kVar.a(')', (String) null);
        }
        a('}', (String) null);
        return this;
    }

    private <K, V> k a(Map<K, V> map, boolean z16) {
        if (map != null && !map.isEmpty()) {
            this.f148951a.append("{");
            k kVar = new k(this.f148951a, this.f148952b + 2);
            boolean z17 = true;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (!z17) {
                    this.f148951a.append(",");
                }
                kVar.a((k) entry.getKey(), true);
                kVar.a((k) entry.getValue(), false);
                z17 = false;
            }
            this.f148951a.append("}");
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        this.f148951a.append("{}");
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    private <T> k a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f148951a.append("null\n");
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb5 = this.f148951a;
            sb5.append(tArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f148951a;
        sb6.append(tArr.length);
        sb6.append(", [\n");
        k kVar = new k(this.f148951a, this.f148952b + 1);
        for (T t16 : tArr) {
            kVar.a((k) t16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private <T> k a(T[] tArr, boolean z16) {
        if (tArr != null && tArr.length != 0) {
            this.f148951a.append("[");
            k kVar = new k(this.f148951a, this.f148952b + 1);
            for (int i3 = 0; i3 < tArr.length; i3++) {
                T t16 = tArr[i3];
                if (i3 != 0) {
                    this.f148951a.append("|");
                }
                kVar.a((k) t16, false);
            }
            this.f148951a.append("]");
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        this.f148951a.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> k a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            this.f148951a.append("null\t");
            return this;
        }
        return a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> k a(Collection<T> collection, boolean z16) {
        if (collection == null) {
            this.f148951a.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            if (z16) {
                this.f148951a.append("|");
            }
            return this;
        }
        return a(collection.toArray(), z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> k a(T t16, String str) {
        if (t16 == 0) {
            this.f148951a.append("null\n");
        } else if (t16 instanceof Byte) {
            a(((Byte) t16).byteValue(), str);
        } else if (t16 instanceof Boolean) {
            a(((Boolean) t16).booleanValue(), str);
        } else if (t16 instanceof Short) {
            a(((Short) t16).shortValue(), str);
        } else if (t16 instanceof Integer) {
            a(((Integer) t16).intValue(), str);
        } else if (t16 instanceof Long) {
            a(((Long) t16).longValue(), str);
        } else if (t16 instanceof Float) {
            a(((Float) t16).floatValue(), str);
        } else if (t16 instanceof Double) {
            a(((Double) t16).doubleValue(), str);
        } else if (t16 instanceof String) {
            a((String) t16, str);
        } else if (t16 instanceof Map) {
            a((Map) t16, str);
        } else if (t16 instanceof List) {
            a((Collection) t16, str);
        } else if (t16 instanceof p) {
            a((p) t16, str);
        } else if (t16 instanceof byte[]) {
            a((byte[]) t16, str);
        } else if (t16 instanceof boolean[]) {
            a((k) t16, str);
        } else if (t16 instanceof short[]) {
            a((short[]) t16, str);
        } else if (t16 instanceof int[]) {
            a((int[]) t16, str);
        } else if (t16 instanceof long[]) {
            a((long[]) t16, str);
        } else if (t16 instanceof float[]) {
            a((float[]) t16, str);
        } else if (t16 instanceof double[]) {
            a((double[]) t16, str);
        } else if (t16.getClass().isArray()) {
            a((Object[]) t16, str);
        } else {
            throw new l("write object error: unsupport type.");
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> k a(T t16, boolean z16) {
        if (t16 == 0) {
            this.f148951a.append("null\n");
        } else if (t16 instanceof Byte) {
            a(((Byte) t16).byteValue(), z16);
        } else if (t16 instanceof Boolean) {
            a(((Boolean) t16).booleanValue(), z16);
        } else if (t16 instanceof Short) {
            a(((Short) t16).shortValue(), z16);
        } else if (t16 instanceof Integer) {
            a(((Integer) t16).intValue(), z16);
        } else if (t16 instanceof Long) {
            a(((Long) t16).longValue(), z16);
        } else if (t16 instanceof Float) {
            a(((Float) t16).floatValue(), z16);
        } else if (t16 instanceof Double) {
            a(((Double) t16).doubleValue(), z16);
        } else if (t16 instanceof String) {
            a((String) t16, z16);
        } else if (t16 instanceof Map) {
            a((Map) t16, z16);
        } else if (t16 instanceof List) {
            a((Collection) t16, z16);
        } else if (t16 instanceof p) {
            a((p) t16, z16);
        } else if (t16 instanceof byte[]) {
            a((byte[]) t16, z16);
        } else if (t16 instanceof boolean[]) {
            a((k) t16, z16);
        } else if (t16 instanceof short[]) {
            a((short[]) t16, z16);
        } else if (t16 instanceof int[]) {
            a((int[]) t16, z16);
        } else if (t16 instanceof long[]) {
            a((long[]) t16, z16);
        } else if (t16 instanceof float[]) {
            a((float[]) t16, z16);
        } else if (t16 instanceof double[]) {
            a((double[]) t16, z16);
        } else if (t16.getClass().isArray()) {
            a((Object[]) t16, z16);
        } else {
            throw new l("write object error: unsupport type.");
        }
        return this;
    }

    public final k a(p pVar, String str) {
        a('{', str);
        if (pVar == null) {
            StringBuilder sb5 = this.f148951a;
            sb5.append('\t');
            sb5.append("null");
        } else {
            pVar.display(this.f148951a, this.f148952b + 1);
        }
        a('}', (String) null);
        return this;
    }

    public final k a(p pVar, boolean z16) {
        this.f148951a.append("{");
        if (pVar == null) {
            StringBuilder sb5 = this.f148951a;
            sb5.append('\t');
            sb5.append("null");
        } else {
            pVar.displaySimple(this.f148951a, this.f148952b + 1);
        }
        this.f148951a.append("}");
        if (z16) {
            this.f148951a.append("|");
        }
        return this;
    }
}
