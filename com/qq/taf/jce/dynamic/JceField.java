package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;

/* compiled from: P */
/* loaded from: classes3.dex */
public class JceField {

    /* renamed from: zs, reason: collision with root package name */
    private static ZeroField[] f40903zs = new ZeroField[256];
    private int tag;

    static {
        int i3 = 0;
        while (true) {
            ZeroField[] zeroFieldArr = f40903zs;
            if (i3 < zeroFieldArr.length) {
                zeroFieldArr[i3] = new ZeroField(i3);
                i3++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JceField(int i3) {
        this.tag = i3;
    }

    public static JceField create(byte b16, int i3) {
        return new ByteField(b16, i3);
    }

    public static JceField createList(JceField[] jceFieldArr, int i3) {
        return new ListField(jceFieldArr, i3);
    }

    public static JceField createMap(JceField[] jceFieldArr, JceField[] jceFieldArr2, int i3) {
        return new MapField(jceFieldArr, jceFieldArr2, i3);
    }

    public static JceField createStruct(JceField[] jceFieldArr, int i3) {
        return new StructField(jceFieldArr, i3);
    }

    public static JceField createZero(int i3) {
        if (i3 >= 0 && i3 < 255) {
            return f40903zs[i3];
        }
        throw new JceDecodeException("invalid tag: " + i3);
    }

    public int getTag() {
        return this.tag;
    }

    public static JceField create(short s16, int i3) {
        return new ShortField(s16, i3);
    }

    public static JceField create(int i3, int i16) {
        return new IntField(i3, i16);
    }

    public static JceField create(long j3, int i3) {
        return new LongField(j3, i3);
    }

    public static JceField create(float f16, int i3) {
        return new FloatField(f16, i3);
    }

    public static JceField create(double d16, int i3) {
        return new DoubleField(d16, i3);
    }

    public static JceField create(String str, int i3) {
        return new StringField(str, i3);
    }

    public static JceField create(byte[] bArr, int i3) {
        return new ByteArrayField(bArr, i3);
    }
}
