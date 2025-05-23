package com.tencent.mobileqq.icgame.data.lucky.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class FansRecord extends ExtendableMessageNano<FansRecord> {
    private static volatile FansRecord[] _emptyArray;
    public User fans;
    public GiftRecord record;

    public FansRecord() {
        clear();
    }

    public static FansRecord[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new FansRecord[0];
                }
            }
        }
        return _emptyArray;
    }

    public static FansRecord parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (FansRecord) MessageNano.mergeFrom(new FansRecord(), bArr);
    }

    public FansRecord clear() {
        this.fans = null;
        this.record = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        User user = this.fans;
        if (user != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, user);
        }
        GiftRecord giftRecord = this.record;
        if (giftRecord != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, giftRecord);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        User user = this.fans;
        if (user != null) {
            codedOutputByteBufferNano.writeMessage(1, user);
        }
        GiftRecord giftRecord = this.record;
        if (giftRecord != null) {
            codedOutputByteBufferNano.writeMessage(2, giftRecord);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static FansRecord parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new FansRecord().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public FansRecord mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.fans == null) {
                    this.fans = new User();
                }
                codedInputByteBufferNano.readMessage(this.fans);
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.record == null) {
                    this.record = new GiftRecord();
                }
                codedInputByteBufferNano.readMessage(this.record);
            }
        }
    }
}
