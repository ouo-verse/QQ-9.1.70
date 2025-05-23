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
public final class GiftSvrAudienceGuessRsp extends ExtendableMessageNano<GiftSvrAudienceGuessRsp> {
    private static volatile GiftSvrAudienceGuessRsp[] _emptyArray;
    public String errmsg;
    public int result;

    public GiftSvrAudienceGuessRsp() {
        clear();
    }

    public static GiftSvrAudienceGuessRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftSvrAudienceGuessRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftSvrAudienceGuessRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftSvrAudienceGuessRsp) MessageNano.mergeFrom(new GiftSvrAudienceGuessRsp(), bArr);
    }

    public GiftSvrAudienceGuessRsp clear() {
        this.result = 0;
        this.errmsg = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.errmsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.errmsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.errmsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.errmsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftSvrAudienceGuessRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftSvrAudienceGuessRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftSvrAudienceGuessRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.errmsg = codedInputByteBufferNano.readString();
            }
        }
    }
}
