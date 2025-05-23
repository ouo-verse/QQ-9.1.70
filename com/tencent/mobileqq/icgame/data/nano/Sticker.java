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
public final class Sticker extends ExtendableMessageNano<Sticker> {
    private static volatile Sticker[] _emptyArray;
    public PicSticker picSticker;
    public int stickerType;
    public TextSticker textSticker;

    public Sticker() {
        clear();
    }

    public static Sticker[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Sticker[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Sticker parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Sticker) MessageNano.mergeFrom(new Sticker(), bArr);
    }

    public Sticker clear() {
        this.stickerType = 0;
        this.textSticker = null;
        this.picSticker = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.stickerType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        TextSticker textSticker = this.textSticker;
        if (textSticker != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, textSticker);
        }
        PicSticker picSticker = this.picSticker;
        if (picSticker != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, picSticker);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.stickerType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        TextSticker textSticker = this.textSticker;
        if (textSticker != null) {
            codedOutputByteBufferNano.writeMessage(2, textSticker);
        }
        PicSticker picSticker = this.picSticker;
        if (picSticker != null) {
            codedOutputByteBufferNano.writeMessage(3, picSticker);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Sticker parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Sticker().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Sticker mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.stickerType = readInt32;
                }
            } else if (readTag == 18) {
                if (this.textSticker == null) {
                    this.textSticker = new TextSticker();
                }
                codedInputByteBufferNano.readMessage(this.textSticker);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.picSticker == null) {
                    this.picSticker = new PicSticker();
                }
                codedInputByteBufferNano.readMessage(this.picSticker);
            }
        }
    }
}
