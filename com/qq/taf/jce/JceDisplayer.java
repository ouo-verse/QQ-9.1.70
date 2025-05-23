package com.qq.taf.jce;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class JceDisplayer {
    private int _level;

    /* renamed from: sb, reason: collision with root package name */
    private StringBuilder f40899sb;

    public JceDisplayer(StringBuilder sb5, int i3) {
        this.f40899sb = sb5;
        this._level = i3;
    }

    public static void main(String[] strArr) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(1.2d);
        System.out.println(sb5.toString());
    }

    private void ps(String str) {
        for (int i3 = 0; i3 < this._level; i3++) {
            this.f40899sb.append('\t');
        }
        if (str != null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append(str);
            sb5.append(MsgSummary.STR_COLON);
        }
    }

    public JceDisplayer display(boolean z16, String str) {
        ps(str);
        StringBuilder sb5 = this.f40899sb;
        sb5.append(z16 ? 'T' : 'F');
        sb5.append('\n');
        return this;
    }

    public JceDisplayer displaySimple(boolean z16, boolean z17) {
        this.f40899sb.append(z16 ? 'T' : 'F');
        if (z17) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(byte b16, String str) {
        ps(str);
        StringBuilder sb5 = this.f40899sb;
        sb5.append((int) b16);
        sb5.append('\n');
        return this;
    }

    public JceDisplayer displaySimple(byte b16, boolean z16) {
        this.f40899sb.append((int) b16);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer(StringBuilder sb5) {
        this._level = 0;
        this.f40899sb = sb5;
    }

    public JceDisplayer display(char c16, String str) {
        ps(str);
        StringBuilder sb5 = this.f40899sb;
        sb5.append(c16);
        sb5.append('\n');
        return this;
    }

    public JceDisplayer displaySimple(char c16, boolean z16) {
        this.f40899sb.append(c16);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(short s16, String str) {
        ps(str);
        StringBuilder sb5 = this.f40899sb;
        sb5.append((int) s16);
        sb5.append('\n');
        return this;
    }

    public JceDisplayer displaySimple(short s16, boolean z16) {
        this.f40899sb.append((int) s16);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(int i3, String str) {
        ps(str);
        StringBuilder sb5 = this.f40899sb;
        sb5.append(i3);
        sb5.append('\n');
        return this;
    }

    public JceDisplayer displaySimple(int i3, boolean z16) {
        this.f40899sb.append(i3);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(long j3, String str) {
        ps(str);
        StringBuilder sb5 = this.f40899sb;
        sb5.append(j3);
        sb5.append('\n');
        return this;
    }

    public JceDisplayer displaySimple(long j3, boolean z16) {
        this.f40899sb.append(j3);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(float f16, String str) {
        ps(str);
        StringBuilder sb5 = this.f40899sb;
        sb5.append(f16);
        sb5.append('\n');
        return this;
    }

    public JceDisplayer displaySimple(float f16, boolean z16) {
        this.f40899sb.append(f16);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(double d16, String str) {
        ps(str);
        StringBuilder sb5 = this.f40899sb;
        sb5.append(d16);
        sb5.append('\n');
        return this;
    }

    public JceDisplayer displaySimple(double d16, boolean z16) {
        this.f40899sb.append(d16);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(String str, String str2) {
        ps(str2);
        if (str == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
        } else {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(str);
            sb6.append('\n');
        }
        return this;
    }

    public JceDisplayer displaySimple(String str, boolean z16) {
        if (str == null) {
            this.f40899sb.append("null");
        } else {
            this.f40899sb.append(str);
        }
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(byte[] bArr, String str) {
        ps(str);
        if (bArr == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(bArr.length);
            sb6.append(", []");
            sb6.append('\n');
            return this;
        }
        StringBuilder sb7 = this.f40899sb;
        sb7.append(bArr.length);
        sb7.append(", [");
        sb7.append('\n');
        JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
        for (byte b16 : bArr) {
            jceDisplayer.display(b16, (String) null);
        }
        display(']', (String) null);
        return this;
    }

    public JceDisplayer displaySimple(byte[] bArr, boolean z16) {
        if (bArr == null || bArr.length == 0) {
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        this.f40899sb.append(HexUtil.bytes2HexStr(bArr));
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer displaySimple(char[] cArr, boolean z16) {
        if (cArr == null || cArr.length == 0) {
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        this.f40899sb.append(new String(cArr));
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer displaySimple(short[] sArr, boolean z16) {
        if (sArr != null && sArr.length != 0) {
            this.f40899sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
            for (int i3 = 0; i3 < sArr.length; i3++) {
                short s16 = sArr[i3];
                if (i3 != 0) {
                    this.f40899sb.append("|");
                }
                jceDisplayer.displaySimple(s16, false);
            }
            this.f40899sb.append("]");
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        this.f40899sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(char[] cArr, String str) {
        ps(str);
        if (cArr == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
            return this;
        }
        if (cArr.length == 0) {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(cArr.length);
            sb6.append(", []");
            sb6.append('\n');
            return this;
        }
        StringBuilder sb7 = this.f40899sb;
        sb7.append(cArr.length);
        sb7.append(", [");
        sb7.append('\n');
        JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
        for (char c16 : cArr) {
            jceDisplayer.display(c16, (String) null);
        }
        display(']', (String) null);
        return this;
    }

    public JceDisplayer display(short[] sArr, String str) {
        ps(str);
        if (sArr == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(sArr.length);
            sb6.append(", []");
            sb6.append('\n');
            return this;
        }
        StringBuilder sb7 = this.f40899sb;
        sb7.append(sArr.length);
        sb7.append(", [");
        sb7.append('\n');
        JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
        for (short s16 : sArr) {
            jceDisplayer.display(s16, (String) null);
        }
        display(']', (String) null);
        return this;
    }

    public JceDisplayer displaySimple(int[] iArr, boolean z16) {
        if (iArr != null && iArr.length != 0) {
            this.f40899sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                int i16 = iArr[i3];
                if (i3 != 0) {
                    this.f40899sb.append("|");
                }
                jceDisplayer.displaySimple(i16, false);
            }
            this.f40899sb.append("]");
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        this.f40899sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(int[] iArr, String str) {
        ps(str);
        if (iArr == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(iArr.length);
            sb6.append(", []");
            sb6.append('\n');
            return this;
        }
        StringBuilder sb7 = this.f40899sb;
        sb7.append(iArr.length);
        sb7.append(", [");
        sb7.append('\n');
        JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
        for (int i3 : iArr) {
            jceDisplayer.display(i3, (String) null);
        }
        display(']', (String) null);
        return this;
    }

    public JceDisplayer displaySimple(long[] jArr, boolean z16) {
        if (jArr != null && jArr.length != 0) {
            this.f40899sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
            for (int i3 = 0; i3 < jArr.length; i3++) {
                long j3 = jArr[i3];
                if (i3 != 0) {
                    this.f40899sb.append("|");
                }
                jceDisplayer.displaySimple(j3, false);
            }
            this.f40899sb.append("]");
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        this.f40899sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(long[] jArr, String str) {
        ps(str);
        if (jArr == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(jArr.length);
            sb6.append(", []");
            sb6.append('\n');
            return this;
        }
        StringBuilder sb7 = this.f40899sb;
        sb7.append(jArr.length);
        sb7.append(", [");
        sb7.append('\n');
        JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
        for (long j3 : jArr) {
            jceDisplayer.display(j3, (String) null);
        }
        display(']', (String) null);
        return this;
    }

    public JceDisplayer displaySimple(float[] fArr, boolean z16) {
        if (fArr != null && fArr.length != 0) {
            this.f40899sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
            for (int i3 = 0; i3 < fArr.length; i3++) {
                float f16 = fArr[i3];
                if (i3 != 0) {
                    this.f40899sb.append("|");
                }
                jceDisplayer.displaySimple(f16, false);
            }
            this.f40899sb.append("]");
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        this.f40899sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(float[] fArr, String str) {
        ps(str);
        if (fArr == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(fArr.length);
            sb6.append(", []");
            sb6.append('\n');
            return this;
        }
        StringBuilder sb7 = this.f40899sb;
        sb7.append(fArr.length);
        sb7.append(", [");
        sb7.append('\n');
        JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
        for (float f16 : fArr) {
            jceDisplayer.display(f16, (String) null);
        }
        display(']', (String) null);
        return this;
    }

    public JceDisplayer displaySimple(double[] dArr, boolean z16) {
        if (dArr != null && dArr.length != 0) {
            this.f40899sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
            for (int i3 = 0; i3 < dArr.length; i3++) {
                double d16 = dArr[i3];
                if (i3 != 0) {
                    this.f40899sb.append("|");
                }
                jceDisplayer.displaySimple(d16, false);
            }
            this.f40899sb.append("[");
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        this.f40899sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public JceDisplayer display(double[] dArr, String str) {
        ps(str);
        if (dArr == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(dArr.length);
            sb6.append(", []");
            sb6.append('\n');
            return this;
        }
        StringBuilder sb7 = this.f40899sb;
        sb7.append(dArr.length);
        sb7.append(", [");
        sb7.append('\n');
        JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
        for (double d16 : dArr) {
            jceDisplayer.display(d16, (String) null);
        }
        display(']', (String) null);
        return this;
    }

    public <K, V> JceDisplayer display(Map<K, V> map, String str) {
        ps(str);
        if (map == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(map.size());
            sb6.append(", {}");
            sb6.append('\n');
            return this;
        }
        StringBuilder sb7 = this.f40899sb;
        sb7.append(map.size());
        sb7.append(", {");
        sb7.append('\n');
        JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
        JceDisplayer jceDisplayer2 = new JceDisplayer(this.f40899sb, this._level + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            jceDisplayer.display('(', (String) null);
            jceDisplayer2.display((JceDisplayer) entry.getKey(), (String) null);
            jceDisplayer2.display((JceDisplayer) entry.getValue(), (String) null);
            jceDisplayer.display(')', (String) null);
        }
        display('}', (String) null);
        return this;
    }

    public <K, V> JceDisplayer displaySimple(Map<K, V> map, boolean z16) {
        if (map != null && !map.isEmpty()) {
            this.f40899sb.append("{");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 2);
            boolean z17 = true;
            for (Map.Entry<K, V> entry : map.entrySet()) {
                if (!z17) {
                    this.f40899sb.append(",");
                }
                jceDisplayer.displaySimple((JceDisplayer) entry.getKey(), true);
                jceDisplayer.displaySimple((JceDisplayer) entry.getValue(), false);
                z17 = false;
            }
            this.f40899sb.append("}");
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        this.f40899sb.append("{}");
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public <T> JceDisplayer displaySimple(T[] tArr, boolean z16) {
        if (tArr != null && tArr.length != 0) {
            this.f40899sb.append("[");
            JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
            for (int i3 = 0; i3 < tArr.length; i3++) {
                T t16 = tArr[i3];
                if (i3 != 0) {
                    this.f40899sb.append("|");
                }
                jceDisplayer.displaySimple((JceDisplayer) t16, false);
            }
            this.f40899sb.append("]");
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        this.f40899sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }

    public <T> JceDisplayer display(T[] tArr, String str) {
        ps(str);
        if (tArr == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb6 = this.f40899sb;
            sb6.append(tArr.length);
            sb6.append(", []");
            sb6.append('\n');
            return this;
        }
        StringBuilder sb7 = this.f40899sb;
        sb7.append(tArr.length);
        sb7.append(", [");
        sb7.append('\n');
        JceDisplayer jceDisplayer = new JceDisplayer(this.f40899sb, this._level + 1);
        for (T t16 : tArr) {
            jceDisplayer.display((JceDisplayer) t16, (String) null);
        }
        display(']', (String) null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> JceDisplayer display(Collection<T> collection, String str) {
        if (collection == null) {
            ps(str);
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\t');
            return this;
        }
        return display(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> JceDisplayer displaySimple(Collection<T> collection, boolean z16) {
        if (collection == null) {
            this.f40899sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            if (z16) {
                this.f40899sb.append("|");
            }
            return this;
        }
        return displaySimple(collection.toArray(), z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> JceDisplayer display(T t16, String str) {
        if (t16 == 0) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
        } else if (t16 instanceof Byte) {
            display(((Byte) t16).byteValue(), str);
        } else if (t16 instanceof Boolean) {
            display(((Boolean) t16).booleanValue(), str);
        } else if (t16 instanceof Short) {
            display(((Short) t16).shortValue(), str);
        } else if (t16 instanceof Integer) {
            display(((Integer) t16).intValue(), str);
        } else if (t16 instanceof Long) {
            display(((Long) t16).longValue(), str);
        } else if (t16 instanceof Float) {
            display(((Float) t16).floatValue(), str);
        } else if (t16 instanceof Double) {
            display(((Double) t16).doubleValue(), str);
        } else if (t16 instanceof String) {
            display((String) t16, str);
        } else if (t16 instanceof Map) {
            display((Map) t16, str);
        } else if (t16 instanceof List) {
            display((Collection) t16, str);
        } else if (t16 instanceof JceStruct) {
            display((JceStruct) t16, str);
        } else if (t16 instanceof byte[]) {
            display((byte[]) t16, str);
        } else if (t16 instanceof boolean[]) {
            display((JceDisplayer) t16, str);
        } else if (t16 instanceof short[]) {
            display((short[]) t16, str);
        } else if (t16 instanceof int[]) {
            display((int[]) t16, str);
        } else if (t16 instanceof long[]) {
            display((long[]) t16, str);
        } else if (t16 instanceof float[]) {
            display((float[]) t16, str);
        } else if (t16 instanceof double[]) {
            display((double[]) t16, str);
        } else if (t16.getClass().isArray()) {
            display((Object[]) t16, str);
        } else {
            throw new JceEncodeException("write object error: unsupport type.");
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> JceDisplayer displaySimple(T t16, boolean z16) {
        if (t16 == 0) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append("null");
            sb5.append('\n');
        } else if (t16 instanceof Byte) {
            displaySimple(((Byte) t16).byteValue(), z16);
        } else if (t16 instanceof Boolean) {
            displaySimple(((Boolean) t16).booleanValue(), z16);
        } else if (t16 instanceof Short) {
            displaySimple(((Short) t16).shortValue(), z16);
        } else if (t16 instanceof Integer) {
            displaySimple(((Integer) t16).intValue(), z16);
        } else if (t16 instanceof Long) {
            displaySimple(((Long) t16).longValue(), z16);
        } else if (t16 instanceof Float) {
            displaySimple(((Float) t16).floatValue(), z16);
        } else if (t16 instanceof Double) {
            displaySimple(((Double) t16).doubleValue(), z16);
        } else if (t16 instanceof String) {
            displaySimple((String) t16, z16);
        } else if (t16 instanceof Map) {
            displaySimple((Map) t16, z16);
        } else if (t16 instanceof List) {
            displaySimple((Collection) t16, z16);
        } else if (t16 instanceof JceStruct) {
            displaySimple((JceStruct) t16, z16);
        } else if (t16 instanceof byte[]) {
            displaySimple((byte[]) t16, z16);
        } else if (t16 instanceof boolean[]) {
            displaySimple((JceDisplayer) t16, z16);
        } else if (t16 instanceof short[]) {
            displaySimple((short[]) t16, z16);
        } else if (t16 instanceof int[]) {
            displaySimple((int[]) t16, z16);
        } else if (t16 instanceof long[]) {
            displaySimple((long[]) t16, z16);
        } else if (t16 instanceof float[]) {
            displaySimple((float[]) t16, z16);
        } else if (t16 instanceof double[]) {
            displaySimple((double[]) t16, z16);
        } else if (t16.getClass().isArray()) {
            displaySimple((Object[]) t16, z16);
        } else {
            throw new JceEncodeException("write object error: unsupport type.");
        }
        return this;
    }

    public JceDisplayer display(JceStruct jceStruct, String str) {
        display('{', str);
        if (jceStruct == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append('\t');
            sb5.append("null");
        } else {
            jceStruct.display(this.f40899sb, this._level + 1);
        }
        display('}', (String) null);
        return this;
    }

    public JceDisplayer displaySimple(JceStruct jceStruct, boolean z16) {
        this.f40899sb.append("{");
        if (jceStruct == null) {
            StringBuilder sb5 = this.f40899sb;
            sb5.append('\t');
            sb5.append("null");
        } else {
            jceStruct.displaySimple(this.f40899sb, this._level + 1);
        }
        this.f40899sb.append("}");
        if (z16) {
            this.f40899sb.append("|");
        }
        return this;
    }
}
