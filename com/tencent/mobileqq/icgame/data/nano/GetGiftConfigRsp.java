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
public final class GetGiftConfigRsp extends ExtendableMessageNano<GetGiftConfigRsp> {
    private static volatile GetGiftConfigRsp[] _emptyArray;
    public GiftConfig config;

    public GetGiftConfigRsp() {
        clear();
    }

    public static GetGiftConfigRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGiftConfigRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGiftConfigRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGiftConfigRsp) MessageNano.mergeFrom(new GetGiftConfigRsp(), bArr);
    }

    public GetGiftConfigRsp clear() {
        this.config = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        GiftConfig giftConfig = this.config;
        if (giftConfig != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, giftConfig);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        GiftConfig giftConfig = this.config;
        if (giftConfig != null) {
            codedOutputByteBufferNano.writeMessage(1, giftConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGiftConfigRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGiftConfigRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGiftConfigRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                if (this.config == null) {
                    this.config = new GiftConfig();
                }
                codedInputByteBufferNano.readMessage(this.config);
            }
        }
    }
}
