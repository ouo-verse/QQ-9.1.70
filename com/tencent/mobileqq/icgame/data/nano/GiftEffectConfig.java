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
public final class GiftEffectConfig extends ExtendableMessageNano<GiftEffectConfig> {
    private static volatile GiftEffectConfig[] _emptyArray;
    public int effectLvl;
    public int effectTime;
    public int giftMaxAccount;

    public GiftEffectConfig() {
        clear();
    }

    public static GiftEffectConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftEffectConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftEffectConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftEffectConfig) MessageNano.mergeFrom(new GiftEffectConfig(), bArr);
    }

    public GiftEffectConfig clear() {
        this.giftMaxAccount = 0;
        this.effectLvl = 0;
        this.effectTime = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftMaxAccount);
        int i3 = this.effectLvl;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.effectTime;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.giftMaxAccount);
        int i3 = this.effectLvl;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.effectTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftEffectConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftEffectConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftEffectConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.giftMaxAccount = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.effectLvl = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.effectTime = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
