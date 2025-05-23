package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GiftNewEffect extends ExtendableMessageNano<GiftNewEffect> {
    private static volatile GiftNewEffect[] _emptyArray;
    public byte[] effectId;
    public int effectNum;
    public int effectType;
    public byte[] effectWord;

    public GiftNewEffect() {
        clear();
    }

    public static GiftNewEffect[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftNewEffect[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftNewEffect parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftNewEffect) MessageNano.mergeFrom(new GiftNewEffect(), bArr);
    }

    public GiftNewEffect clear() {
        this.effectNum = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.effectId = bArr;
        this.effectWord = bArr;
        this.effectType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.effectNum);
        byte[] bArr = this.effectId;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.effectId);
        }
        if (!Arrays.equals(this.effectWord, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.effectWord);
        }
        int i3 = this.effectType;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.effectNum);
        byte[] bArr = this.effectId;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.effectId);
        }
        if (!Arrays.equals(this.effectWord, bArr2)) {
            codedOutputByteBufferNano.writeBytes(3, this.effectWord);
        }
        int i3 = this.effectType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftNewEffect parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftNewEffect().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftNewEffect mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.effectNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.effectId = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                this.effectWord = codedInputByteBufferNano.readBytes();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.effectType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
