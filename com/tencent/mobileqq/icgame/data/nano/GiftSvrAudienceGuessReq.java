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
public final class GiftSvrAudienceGuessReq extends ExtendableMessageNano<GiftSvrAudienceGuessReq> {
    private static volatile GiftSvrAudienceGuessReq[] _emptyArray;
    public String answer;
    public GivePayGiftReq answerPayGift;
    public long receiver;
    public long roomId;
    public long uid;

    public GiftSvrAudienceGuessReq() {
        clear();
    }

    public static GiftSvrAudienceGuessReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftSvrAudienceGuessReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftSvrAudienceGuessReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftSvrAudienceGuessReq) MessageNano.mergeFrom(new GiftSvrAudienceGuessReq(), bArr);
    }

    public GiftSvrAudienceGuessReq clear() {
        this.uid = 0L;
        this.receiver = 0L;
        this.answer = "";
        this.roomId = 0L;
        this.answerPayGift = null;
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
        long j16 = this.receiver;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.answer.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.answer);
        }
        long j17 = this.roomId;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j17);
        }
        GivePayGiftReq givePayGiftReq = this.answerPayGift;
        if (givePayGiftReq != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, givePayGiftReq);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.receiver;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.answer.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.answer);
        }
        long j17 = this.roomId;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j17);
        }
        GivePayGiftReq givePayGiftReq = this.answerPayGift;
        if (givePayGiftReq != null) {
            codedOutputByteBufferNano.writeMessage(5, givePayGiftReq);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftSvrAudienceGuessReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftSvrAudienceGuessReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftSvrAudienceGuessReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.receiver = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 26) {
                this.answer = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.answerPayGift == null) {
                    this.answerPayGift = new GivePayGiftReq();
                }
                codedInputByteBufferNano.readMessage(this.answerPayGift);
            }
        }
    }
}
