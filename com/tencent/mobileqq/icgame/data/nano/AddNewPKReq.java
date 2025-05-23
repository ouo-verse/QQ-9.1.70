package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AddNewPKReq extends ExtendableMessageNano<AddNewPKReq> {
    private static volatile AddNewPKReq[] _emptyArray;
    public String actId;
    public String pkId;
    public long pkStartTs;

    public AddNewPKReq() {
        clear();
    }

    public static AddNewPKReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AddNewPKReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AddNewPKReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AddNewPKReq) MessageNano.mergeFrom(new AddNewPKReq(), bArr);
    }

    public AddNewPKReq clear() {
        this.actId = "";
        this.pkId = "";
        this.pkStartTs = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.actId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.actId);
        }
        if (!this.pkId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.pkId);
        }
        long j3 = this.pkStartTs;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.actId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.actId);
        }
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.pkId);
        }
        long j3 = this.pkStartTs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AddNewPKReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AddNewPKReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AddNewPKReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.actId = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.pkStartTs = codedInputByteBufferNano.readInt64();
            }
        }
    }
}
