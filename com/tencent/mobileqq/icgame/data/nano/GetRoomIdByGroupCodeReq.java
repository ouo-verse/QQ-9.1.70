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
public final class GetRoomIdByGroupCodeReq extends ExtendableMessageNano<GetRoomIdByGroupCodeReq> {
    private static volatile GetRoomIdByGroupCodeReq[] _emptyArray;
    public long groupCode;
    public boolean requireRoomInfo;

    public GetRoomIdByGroupCodeReq() {
        clear();
    }

    public static GetRoomIdByGroupCodeReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomIdByGroupCodeReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomIdByGroupCodeReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomIdByGroupCodeReq) MessageNano.mergeFrom(new GetRoomIdByGroupCodeReq(), bArr);
    }

    public GetRoomIdByGroupCodeReq clear() {
        this.groupCode = 0L;
        this.requireRoomInfo = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.groupCode);
        boolean z16 = this.requireRoomInfo;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.groupCode);
        boolean z16 = this.requireRoomInfo;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomIdByGroupCodeReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomIdByGroupCodeReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomIdByGroupCodeReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.groupCode = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.requireRoomInfo = codedInputByteBufferNano.readBool();
            }
        }
    }
}
