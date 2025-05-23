package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceOutputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class DynamicOutputStream extends JceOutputStream {
    public DynamicOutputStream(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public void write(JceField jceField) {
        int tag = jceField.getTag();
        int i3 = 0;
        if (jceField instanceof ZeroField) {
            write(0, tag);
            return;
        }
        if (jceField instanceof IntField) {
            write(((IntField) jceField).get(), tag);
            return;
        }
        if (jceField instanceof ShortField) {
            write(((ShortField) jceField).get(), tag);
            return;
        }
        if (jceField instanceof ByteField) {
            write(((ByteField) jceField).get(), tag);
            return;
        }
        if (jceField instanceof StringField) {
            write(((StringField) jceField).get(), tag);
            return;
        }
        if (jceField instanceof ByteArrayField) {
            write(((ByteArrayField) jceField).get(), tag);
            return;
        }
        if (jceField instanceof ListField) {
            ListField listField = (ListField) jceField;
            reserve(8);
            writeHead((byte) 9, tag);
            write(listField.size(), 0);
            JceField[] jceFieldArr = listField.get();
            int length = jceFieldArr.length;
            while (i3 < length) {
                write(jceFieldArr[i3]);
                i3++;
            }
            return;
        }
        if (jceField instanceof MapField) {
            MapField mapField = (MapField) jceField;
            reserve(8);
            writeHead((byte) 8, tag);
            int size = mapField.size();
            write(size, 0);
            while (i3 < size) {
                write(mapField.getKey(i3));
                write(mapField.getValue(i3));
                i3++;
            }
            return;
        }
        if (jceField instanceof StructField) {
            reserve(2);
            writeHead((byte) 10, tag);
            for (JceField jceField2 : ((StructField) jceField).get()) {
                write(jceField2);
            }
            reserve(2);
            writeHead((byte) 11, 0);
            return;
        }
        if (jceField instanceof LongField) {
            write(((LongField) jceField).get(), tag);
            return;
        }
        if (jceField instanceof FloatField) {
            write(((FloatField) jceField).get(), tag);
        } else {
            if (jceField instanceof DoubleField) {
                write(((DoubleField) jceField).get(), tag);
                return;
            }
            throw new JceDecodeException("unknow JceField type: " + jceField.getClass().getName());
        }
    }

    public DynamicOutputStream(int i3) {
        super(i3);
    }

    public DynamicOutputStream() {
    }
}
