package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class EditSendPrivReq extends ExtendableMessageNano<EditSendPrivReq> {
    private static volatile EditSendPrivReq[] _emptyArray;
    public int openSendPriv;
    public int roomId;
    public long uid;

    public EditSendPrivReq() {
        clear();
    }

    public static EditSendPrivReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new EditSendPrivReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static EditSendPrivReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (EditSendPrivReq) MessageNano.mergeFrom(new EditSendPrivReq(), bArr);
    }

    public EditSendPrivReq clear() {
        this.roomId = 0;
        this.uid = 0L;
        this.openSendPriv = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid);
        int i3 = this.openSendPriv;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.uid);
        int i3 = this.openSendPriv;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static EditSendPrivReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new EditSendPrivReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public EditSendPrivReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.openSendPriv = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
