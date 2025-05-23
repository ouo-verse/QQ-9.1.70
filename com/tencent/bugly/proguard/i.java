package com.tencent.bugly.proguard;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f98516a;

    /* renamed from: b, reason: collision with root package name */
    private int f98517b;

    public i(StringBuilder sb5, int i3) {
        this.f98516a = sb5;
        this.f98517b = i3;
    }

    private void a(String str) {
        for (int i3 = 0; i3 < this.f98517b; i3++) {
            this.f98516a.append('\t');
        }
        if (str != null) {
            StringBuilder sb5 = this.f98516a;
            sb5.append(str);
            sb5.append(MsgSummary.STR_COLON);
        }
    }

    public final i a(boolean z16, String str) {
        a(str);
        StringBuilder sb5 = this.f98516a;
        sb5.append(z16 ? 'T' : 'F');
        sb5.append('\n');
        return this;
    }

    public final i a(byte b16, String str) {
        a(str);
        StringBuilder sb5 = this.f98516a;
        sb5.append((int) b16);
        sb5.append('\n');
        return this;
    }

    private i a(char c16, String str) {
        a(str);
        StringBuilder sb5 = this.f98516a;
        sb5.append(c16);
        sb5.append('\n');
        return this;
    }

    public final i a(short s16, String str) {
        a(str);
        StringBuilder sb5 = this.f98516a;
        sb5.append((int) s16);
        sb5.append('\n');
        return this;
    }

    public final i a(int i3, String str) {
        a(str);
        StringBuilder sb5 = this.f98516a;
        sb5.append(i3);
        sb5.append('\n');
        return this;
    }

    public final i a(long j3, String str) {
        a(str);
        StringBuilder sb5 = this.f98516a;
        sb5.append(j3);
        sb5.append('\n');
        return this;
    }

    private i a(float f16, String str) {
        a(str);
        StringBuilder sb5 = this.f98516a;
        sb5.append(f16);
        sb5.append('\n');
        return this;
    }

    private i a(double d16, String str) {
        a(str);
        StringBuilder sb5 = this.f98516a;
        sb5.append(d16);
        sb5.append('\n');
        return this;
    }

    public final i a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f98516a.append("null\n");
        } else {
            StringBuilder sb5 = this.f98516a;
            sb5.append(str);
            sb5.append('\n');
        }
        return this;
    }

    public final i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f98516a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb5 = this.f98516a;
            sb5.append(bArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f98516a;
        sb6.append(bArr.length);
        sb6.append(", [\n");
        i iVar = new i(this.f98516a, this.f98517b + 1);
        for (byte b16 : bArr) {
            iVar.a(b16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.f98516a.append("null\n");
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb5 = this.f98516a;
            sb5.append(sArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f98516a;
        sb6.append(sArr.length);
        sb6.append(", [\n");
        i iVar = new i(this.f98516a, this.f98517b + 1);
        for (short s16 : sArr) {
            iVar.a(s16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.f98516a.append("null\n");
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb5 = this.f98516a;
            sb5.append(iArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f98516a;
        sb6.append(iArr.length);
        sb6.append(", [\n");
        i iVar = new i(this.f98516a, this.f98517b + 1);
        for (int i3 : iArr) {
            iVar.a(i3, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.f98516a.append("null\n");
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb5 = this.f98516a;
            sb5.append(jArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f98516a;
        sb6.append(jArr.length);
        sb6.append(", [\n");
        i iVar = new i(this.f98516a, this.f98517b + 1);
        for (long j3 : jArr) {
            iVar.a(j3, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.f98516a.append("null\n");
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb5 = this.f98516a;
            sb5.append(fArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f98516a;
        sb6.append(fArr.length);
        sb6.append(", [\n");
        i iVar = new i(this.f98516a, this.f98517b + 1);
        for (float f16 : fArr) {
            iVar.a(f16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.f98516a.append("null\n");
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb5 = this.f98516a;
            sb5.append(dArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f98516a;
        sb6.append(dArr.length);
        sb6.append(", [\n");
        i iVar = new i(this.f98516a, this.f98517b + 1);
        for (double d16 : dArr) {
            iVar.a(d16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f98516a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb5 = this.f98516a;
            sb5.append(map.size());
            sb5.append(", {}\n");
            return this;
        }
        StringBuilder sb6 = this.f98516a;
        sb6.append(map.size());
        sb6.append(", {\n");
        i iVar = new i(this.f98516a, this.f98517b + 1);
        i iVar2 = new i(this.f98516a, this.f98517b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            iVar.a('(', (String) null);
            iVar2.a((i) entry.getKey(), (String) null);
            iVar2.a((i) entry.getValue(), (String) null);
            iVar.a(')', (String) null);
        }
        a('}', (String) null);
        return this;
    }

    private <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f98516a.append("null\n");
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb5 = this.f98516a;
            sb5.append(tArr.length);
            sb5.append(", []\n");
            return this;
        }
        StringBuilder sb6 = this.f98516a;
        sb6.append(tArr.length);
        sb6.append(", [\n");
        i iVar = new i(this.f98516a, this.f98517b + 1);
        for (T t16 : tArr) {
            iVar.a((i) t16, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            this.f98516a.append("null\t");
            return this;
        }
        return a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(T t16, String str) {
        if (t16 == 0) {
            this.f98516a.append("null\n");
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
        } else if (t16 instanceof m) {
            a((m) t16, str);
        } else if (t16 instanceof byte[]) {
            a((byte[]) t16, str);
        } else if (t16 instanceof boolean[]) {
            a((i) t16, str);
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
            throw new j("write object error: unsupport type.");
        }
        return this;
    }

    public final i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            StringBuilder sb5 = this.f98516a;
            sb5.append('\t');
            sb5.append("null");
        } else {
            mVar.a(this.f98516a, this.f98517b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
