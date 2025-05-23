package com.tencent.mobileqq.icgame.data.ilive.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class CheckResult extends ExtendableMessageNano<CheckResult> {
    private static volatile CheckResult[] _emptyArray;
    public int retCode;
    public String retMsg;
    public int sdkType;
    public long uid;

    public CheckResult() {
        clear();
    }

    public static CheckResult[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CheckResult[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CheckResult parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CheckResult) MessageNano.mergeFrom(new CheckResult(), bArr);
    }

    public CheckResult clear() {
        this.uid = 0L;
        this.retCode = 0;
        this.retMsg = "";
        this.sdkType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.retCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.retMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.retMsg);
        }
        int i16 = this.sdkType;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.retCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.retMsg.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.retMsg);
        }
        int i16 = this.sdkType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CheckResult parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CheckResult().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CheckResult mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.retCode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.retMsg = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.sdkType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
