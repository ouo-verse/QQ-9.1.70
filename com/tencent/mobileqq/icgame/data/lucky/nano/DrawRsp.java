package com.tencent.mobileqq.icgame.data.lucky.nano;

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
public final class DrawRsp extends ExtendableMessageNano<DrawRsp> {
    private static volatile DrawRsp[] _emptyArray;
    public DrawRecord[] records;

    public DrawRsp() {
        clear();
    }

    public static DrawRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DrawRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static DrawRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DrawRsp) MessageNano.mergeFrom(new DrawRsp(), bArr);
    }

    public DrawRsp clear() {
        this.records = DrawRecord.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        DrawRecord[] drawRecordArr = this.records;
        if (drawRecordArr != null && drawRecordArr.length > 0) {
            int i3 = 0;
            while (true) {
                DrawRecord[] drawRecordArr2 = this.records;
                if (i3 >= drawRecordArr2.length) {
                    break;
                }
                DrawRecord drawRecord = drawRecordArr2[i3];
                if (drawRecord != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, drawRecord);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        DrawRecord[] drawRecordArr = this.records;
        if (drawRecordArr != null && drawRecordArr.length > 0) {
            int i3 = 0;
            while (true) {
                DrawRecord[] drawRecordArr2 = this.records;
                if (i3 >= drawRecordArr2.length) {
                    break;
                }
                DrawRecord drawRecord = drawRecordArr2[i3];
                if (drawRecord != null) {
                    codedOutputByteBufferNano.writeMessage(1, drawRecord);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static DrawRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DrawRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public DrawRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                DrawRecord[] drawRecordArr = this.records;
                int length = drawRecordArr == null ? 0 : drawRecordArr.length;
                int i3 = repeatedFieldArrayLength + length;
                DrawRecord[] drawRecordArr2 = new DrawRecord[i3];
                if (length != 0) {
                    System.arraycopy(drawRecordArr, 0, drawRecordArr2, 0, length);
                }
                while (length < i3 - 1) {
                    DrawRecord drawRecord = new DrawRecord();
                    drawRecordArr2[length] = drawRecord;
                    codedInputByteBufferNano.readMessage(drawRecord);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                DrawRecord drawRecord2 = new DrawRecord();
                drawRecordArr2[length] = drawRecord2;
                codedInputByteBufferNano.readMessage(drawRecord2);
                this.records = drawRecordArr2;
            }
        }
    }
}
