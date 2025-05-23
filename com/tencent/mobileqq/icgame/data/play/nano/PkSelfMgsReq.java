package com.tencent.mobileqq.icgame.data.play.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PkSelfMgsReq extends ExtendableMessageNano<PkSelfMgsReq> {
    private static volatile PkSelfMgsReq[] _emptyArray;
    public String action;
    public int roomid;

    public PkSelfMgsReq() {
        clear();
    }

    public static PkSelfMgsReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PkSelfMgsReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PkSelfMgsReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PkSelfMgsReq) MessageNano.mergeFrom(new PkSelfMgsReq(), bArr);
    }

    public PkSelfMgsReq clear() {
        this.action = "";
        this.roomid = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.action.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.action);
        }
        int i3 = this.roomid;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.action.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.action);
        }
        int i3 = this.roomid;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PkSelfMgsReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PkSelfMgsReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PkSelfMgsReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.action = codedInputByteBufferNano.readString();
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.roomid = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
