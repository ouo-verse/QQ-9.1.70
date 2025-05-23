package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ReportValue extends ExtendableMessageNano<ReportValue> {
    public static final int VALUE_TYPE_DOUBLE = 3;
    public static final int VALUE_TYPE_STRING = 2;
    public static final int VALUE_TYPE_UINT64 = 1;
    private static volatile ReportValue[] _emptyArray;
    public double doubleValue;
    public String fieldName;
    public String stringValue;
    public long uintValue;
    public int valueType;

    public ReportValue() {
        clear();
    }

    public static ReportValue[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportValue[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportValue parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportValue) MessageNano.mergeFrom(new ReportValue(), bArr);
    }

    public ReportValue clear() {
        this.fieldName = "";
        this.valueType = 1;
        this.uintValue = 0L;
        this.stringValue = "";
        this.doubleValue = 0.0d;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.fieldName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.fieldName);
        }
        int i3 = this.valueType;
        if (i3 != 1) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        long j3 = this.uintValue;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        if (!this.stringValue.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.stringValue);
        }
        if (Double.doubleToLongBits(this.doubleValue) != Double.doubleToLongBits(0.0d)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(5, this.doubleValue);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.fieldName.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.fieldName);
        }
        int i3 = this.valueType;
        if (i3 != 1) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        long j3 = this.uintValue;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        if (!this.stringValue.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.stringValue);
        }
        if (Double.doubleToLongBits(this.doubleValue) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(5, this.doubleValue);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportValue parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportValue().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportValue mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.fieldName = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.valueType = readInt32;
                }
            } else if (readTag == 24) {
                this.uintValue = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                this.stringValue = codedInputByteBufferNano.readString();
            } else if (readTag != 41) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.doubleValue = codedInputByteBufferNano.readDouble();
            }
        }
    }
}
