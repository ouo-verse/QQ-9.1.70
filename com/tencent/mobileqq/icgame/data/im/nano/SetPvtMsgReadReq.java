package com.tencent.mobileqq.icgame.data.im.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class SetPvtMsgReadReq extends ExtendableMessageNano<SetPvtMsgReadReq> {
    private static volatile SetPvtMsgReadReq[] _emptyArray;
    public int accountSubGroup;
    public int adminAccount;
    public long readLastTime;

    public SetPvtMsgReadReq() {
        clear();
    }

    public static SetPvtMsgReadReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetPvtMsgReadReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetPvtMsgReadReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetPvtMsgReadReq) MessageNano.mergeFrom(new SetPvtMsgReadReq(), bArr);
    }

    public SetPvtMsgReadReq clear() {
        this.adminAccount = 0;
        this.accountSubGroup = 0;
        this.readLastTime = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.adminAccount;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.accountSubGroup;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        long j3 = this.readLastTime;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.adminAccount;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.accountSubGroup;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        long j3 = this.readLastTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetPvtMsgReadReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetPvtMsgReadReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetPvtMsgReadReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                switch (readInt32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        this.adminAccount = readInt32;
                        break;
                }
            } else if (readTag == 16) {
                this.accountSubGroup = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.readLastTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
