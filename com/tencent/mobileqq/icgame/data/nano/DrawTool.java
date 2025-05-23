package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class DrawTool extends ExtendableMessageNano<DrawTool> {
    private static volatile DrawTool[] _emptyArray;
    public int brushGiftId;
    public Brush[] brushs;
    public int padGiftId;
    public Sketchpad[] sketchpads;

    public DrawTool() {
        clear();
    }

    public static DrawTool[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DrawTool[0];
                }
            }
        }
        return _emptyArray;
    }

    public static DrawTool parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DrawTool) MessageNano.mergeFrom(new DrawTool(), bArr);
    }

    public DrawTool clear() {
        this.brushs = Brush.emptyArray();
        this.sketchpads = Sketchpad.emptyArray();
        this.padGiftId = 0;
        this.brushGiftId = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Brush[] brushArr = this.brushs;
        int i3 = 0;
        if (brushArr != null && brushArr.length > 0) {
            int i16 = 0;
            while (true) {
                Brush[] brushArr2 = this.brushs;
                if (i16 >= brushArr2.length) {
                    break;
                }
                Brush brush = brushArr2[i16];
                if (brush != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, brush);
                }
                i16++;
            }
        }
        Sketchpad[] sketchpadArr = this.sketchpads;
        if (sketchpadArr != null && sketchpadArr.length > 0) {
            while (true) {
                Sketchpad[] sketchpadArr2 = this.sketchpads;
                if (i3 >= sketchpadArr2.length) {
                    break;
                }
                Sketchpad sketchpad = sketchpadArr2[i3];
                if (sketchpad != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, sketchpad);
                }
                i3++;
            }
        }
        int i17 = this.padGiftId;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.brushGiftId;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Brush[] brushArr = this.brushs;
        int i3 = 0;
        if (brushArr != null && brushArr.length > 0) {
            int i16 = 0;
            while (true) {
                Brush[] brushArr2 = this.brushs;
                if (i16 >= brushArr2.length) {
                    break;
                }
                Brush brush = brushArr2[i16];
                if (brush != null) {
                    codedOutputByteBufferNano.writeMessage(1, brush);
                }
                i16++;
            }
        }
        Sketchpad[] sketchpadArr = this.sketchpads;
        if (sketchpadArr != null && sketchpadArr.length > 0) {
            while (true) {
                Sketchpad[] sketchpadArr2 = this.sketchpads;
                if (i3 >= sketchpadArr2.length) {
                    break;
                }
                Sketchpad sketchpad = sketchpadArr2[i3];
                if (sketchpad != null) {
                    codedOutputByteBufferNano.writeMessage(2, sketchpad);
                }
                i3++;
            }
        }
        int i17 = this.padGiftId;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.brushGiftId;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static DrawTool parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DrawTool().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public DrawTool mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Brush[] brushArr = this.brushs;
                int length = brushArr == null ? 0 : brushArr.length;
                int i3 = repeatedFieldArrayLength + length;
                Brush[] brushArr2 = new Brush[i3];
                if (length != 0) {
                    System.arraycopy(brushArr, 0, brushArr2, 0, length);
                }
                while (length < i3 - 1) {
                    Brush brush = new Brush();
                    brushArr2[length] = brush;
                    codedInputByteBufferNano.readMessage(brush);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Brush brush2 = new Brush();
                brushArr2[length] = brush2;
                codedInputByteBufferNano.readMessage(brush2);
                this.brushs = brushArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                Sketchpad[] sketchpadArr = this.sketchpads;
                int length2 = sketchpadArr == null ? 0 : sketchpadArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                Sketchpad[] sketchpadArr2 = new Sketchpad[i16];
                if (length2 != 0) {
                    System.arraycopy(sketchpadArr, 0, sketchpadArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    Sketchpad sketchpad = new Sketchpad();
                    sketchpadArr2[length2] = sketchpad;
                    codedInputByteBufferNano.readMessage(sketchpad);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                Sketchpad sketchpad2 = new Sketchpad();
                sketchpadArr2[length2] = sketchpad2;
                codedInputByteBufferNano.readMessage(sketchpad2);
                this.sketchpads = sketchpadArr2;
            } else if (readTag == 24) {
                this.padGiftId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.brushGiftId = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
