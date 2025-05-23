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
public final class GiftEffect extends ExtendableMessageNano<GiftEffect> {
    private static volatile GiftEffect[] _emptyArray;
    public FlashEffect flashEffect;
    public FlashEffect fullscreenEffect;
    public byte[] gifEffect;
    public int maxNum;
    public int minNum;

    public GiftEffect() {
        clear();
    }

    public static GiftEffect[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftEffect[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftEffect parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftEffect) MessageNano.mergeFrom(new GiftEffect(), bArr);
    }

    public GiftEffect clear() {
        this.minNum = 0;
        this.maxNum = 0;
        this.gifEffect = WireFormatNano.EMPTY_BYTES;
        this.flashEffect = null;
        this.fullscreenEffect = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.minNum) + CodedOutputByteBufferNano.computeUInt32Size(2, this.maxNum);
        if (!Arrays.equals(this.gifEffect, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.gifEffect);
        }
        FlashEffect flashEffect = this.flashEffect;
        if (flashEffect != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, flashEffect);
        }
        FlashEffect flashEffect2 = this.fullscreenEffect;
        if (flashEffect2 != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, flashEffect2);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.minNum);
        codedOutputByteBufferNano.writeUInt32(2, this.maxNum);
        if (!Arrays.equals(this.gifEffect, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.gifEffect);
        }
        FlashEffect flashEffect = this.flashEffect;
        if (flashEffect != null) {
            codedOutputByteBufferNano.writeMessage(4, flashEffect);
        }
        FlashEffect flashEffect2 = this.fullscreenEffect;
        if (flashEffect2 != null) {
            codedOutputByteBufferNano.writeMessage(5, flashEffect2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftEffect parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftEffect().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftEffect mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.minNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.maxNum = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.gifEffect = codedInputByteBufferNano.readBytes();
            } else if (readTag == 34) {
                if (this.flashEffect == null) {
                    this.flashEffect = new FlashEffect();
                }
                codedInputByteBufferNano.readMessage(this.flashEffect);
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.fullscreenEffect == null) {
                    this.fullscreenEffect = new FlashEffect();
                }
                codedInputByteBufferNano.readMessage(this.fullscreenEffect);
            }
        }
    }
}
