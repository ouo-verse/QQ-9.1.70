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
public final class SendGiftRsp extends ExtendableMessageNano<SendGiftRsp> {
    private static volatile SendGiftRsp[] _emptyArray;
    public int balance;
    public GiftStore giftStore;

    public SendGiftRsp() {
        clear();
    }

    public static SendGiftRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SendGiftRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SendGiftRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SendGiftRsp) MessageNano.mergeFrom(new SendGiftRsp(), bArr);
    }

    public SendGiftRsp clear() {
        this.balance = 0;
        this.giftStore = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.balance;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        GiftStore giftStore = this.giftStore;
        if (giftStore != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, giftStore);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.balance;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        GiftStore giftStore = this.giftStore;
        if (giftStore != null) {
            codedOutputByteBufferNano.writeMessage(2, giftStore);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SendGiftRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SendGiftRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SendGiftRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.balance = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.giftStore == null) {
                    this.giftStore = new GiftStore();
                }
                codedInputByteBufferNano.readMessage(this.giftStore);
            }
        }
    }
}
