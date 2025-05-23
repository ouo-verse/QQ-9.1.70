package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class DynamicInputStream {

    /* renamed from: bs, reason: collision with root package name */
    private ByteBuffer f40902bs;
    private String sServerEncoding = "GBK";

    public DynamicInputStream(ByteBuffer byteBuffer) {
        this.f40902bs = byteBuffer;
    }

    private JceField readString(JceInputStream.HeadData headData, int i3) {
        String str;
        byte[] bArr = new byte[i3];
        this.f40902bs.get(bArr);
        try {
            str = new String(bArr, this.sServerEncoding);
        } catch (UnsupportedEncodingException unused) {
            str = new String(bArr);
        }
        return JceField.create(str, headData.tag);
    }

    public JceField read() {
        try {
            JceInputStream.HeadData headData = new JceInputStream.HeadData();
            JceInputStream.readHead(headData, this.f40902bs);
            int i3 = 0;
            switch (headData.type) {
                case 0:
                    return JceField.create(this.f40902bs.get(), headData.tag);
                case 1:
                    return JceField.create(this.f40902bs.getShort(), headData.tag);
                case 2:
                    return JceField.create(this.f40902bs.getInt(), headData.tag);
                case 3:
                    return JceField.create(this.f40902bs.getLong(), headData.tag);
                case 4:
                    return JceField.create(this.f40902bs.getFloat(), headData.tag);
                case 5:
                    return JceField.create(this.f40902bs.getDouble(), headData.tag);
                case 6:
                    int i16 = this.f40902bs.get();
                    if (i16 < 0) {
                        i16 += 256;
                    }
                    return readString(headData, i16);
                case 7:
                    return readString(headData, this.f40902bs.getInt());
                case 8:
                    int intValue = ((NumberField) read()).intValue();
                    JceField[] jceFieldArr = new JceField[intValue];
                    JceField[] jceFieldArr2 = new JceField[intValue];
                    while (i3 < intValue) {
                        jceFieldArr[i3] = read();
                        jceFieldArr2[i3] = read();
                        i3++;
                    }
                    return JceField.createMap(jceFieldArr, jceFieldArr2, headData.tag);
                case 9:
                    int intValue2 = ((NumberField) read()).intValue();
                    JceField[] jceFieldArr3 = new JceField[intValue2];
                    while (i3 < intValue2) {
                        jceFieldArr3[i3] = read();
                        i3++;
                    }
                    return JceField.createList(jceFieldArr3, headData.tag);
                case 10:
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        JceField read = read();
                        if (read == null) {
                            return JceField.createStruct((JceField[]) arrayList.toArray(new JceField[0]), headData.tag);
                        }
                        arrayList.add(read);
                    }
                case 11:
                default:
                    return null;
                case 12:
                    return JceField.createZero(headData.tag);
                case 13:
                    int i17 = headData.tag;
                    JceInputStream.readHead(headData, this.f40902bs);
                    if (headData.type == 0) {
                        byte[] bArr = new byte[((NumberField) read()).intValue()];
                        this.f40902bs.get(bArr);
                        return JceField.create(bArr, i17);
                    }
                    throw new JceDecodeException("type mismatch, simple_list only support byte, tag: " + i17 + ", type: " + ((int) headData.type));
            }
        } catch (BufferUnderflowException unused) {
            return null;
        }
    }

    public int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public DynamicInputStream(byte[] bArr) {
        this.f40902bs = ByteBuffer.wrap(bArr);
    }
}
