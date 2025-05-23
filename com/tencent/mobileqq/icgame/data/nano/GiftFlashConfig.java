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
public final class GiftFlashConfig extends ExtendableMessageNano<GiftFlashConfig> {
    private static volatile GiftFlashConfig[] _emptyArray;
    public String giftFlashDesc;
    public String giftFlashEffect;
    public int giftId;
    public int maxNum;
    public int minNum;

    public GiftFlashConfig() {
        clear();
    }

    public static GiftFlashConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftFlashConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftFlashConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftFlashConfig) MessageNano.mergeFrom(new GiftFlashConfig(), bArr);
    }

    public GiftFlashConfig clear() {
        this.giftId = 0;
        this.minNum = 0;
        this.maxNum = 0;
        this.giftFlashEffect = "";
        this.giftFlashDesc = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftId) + CodedOutputByteBufferNano.computeUInt32Size(2, this.minNum) + CodedOutputByteBufferNano.computeUInt32Size(3, this.maxNum);
        if (!this.giftFlashEffect.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.giftFlashEffect);
        }
        if (!this.giftFlashDesc.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.giftFlashDesc);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.giftId);
        codedOutputByteBufferNano.writeUInt32(2, this.minNum);
        codedOutputByteBufferNano.writeUInt32(3, this.maxNum);
        if (!this.giftFlashEffect.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.giftFlashEffect);
        }
        if (!this.giftFlashDesc.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.giftFlashDesc);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftFlashConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftFlashConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftFlashConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.minNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.maxNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.giftFlashEffect = codedInputByteBufferNano.readString();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.giftFlashDesc = codedInputByteBufferNano.readString();
            }
        }
    }
}
