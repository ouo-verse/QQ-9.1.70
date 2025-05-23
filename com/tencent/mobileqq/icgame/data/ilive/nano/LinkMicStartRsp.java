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
public final class LinkMicStartRsp extends ExtendableMessageNano<LinkMicStartRsp> {
    private static volatile LinkMicStartRsp[] _emptyArray;
    public String linkMicId;
    public int retCode;
    public String retMsg;

    public LinkMicStartRsp() {
        clear();
    }

    public static LinkMicStartRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicStartRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicStartRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicStartRsp) MessageNano.mergeFrom(new LinkMicStartRsp(), bArr);
    }

    public LinkMicStartRsp clear() {
        this.retCode = 0;
        this.retMsg = "";
        this.linkMicId = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retCode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.retMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.retMsg);
        }
        if (!this.linkMicId.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.linkMicId);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retCode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.retMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.retMsg);
        }
        if (!this.linkMicId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.linkMicId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicStartRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicStartRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicStartRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.retCode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.retMsg = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.linkMicId = codedInputByteBufferNano.readString();
            }
        }
    }
}
