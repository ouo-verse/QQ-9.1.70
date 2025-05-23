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
public final class GiftWordConfig extends ExtendableMessageNano<GiftWordConfig> {
    private static volatile GiftWordConfig[] _emptyArray;
    public int giftNum;
    public String giftWord;

    public GiftWordConfig() {
        clear();
    }

    public static GiftWordConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftWordConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftWordConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftWordConfig) MessageNano.mergeFrom(new GiftWordConfig(), bArr);
    }

    public GiftWordConfig clear() {
        this.giftNum = 0;
        this.giftWord = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftNum);
        if (!this.giftWord.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.giftWord);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.giftNum);
        if (!this.giftWord.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.giftWord);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftWordConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftWordConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftWordConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.giftNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.giftWord = codedInputByteBufferNano.readString();
            }
        }
    }
}
