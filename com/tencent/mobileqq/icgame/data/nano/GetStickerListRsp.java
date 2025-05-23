package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetStickerListRsp extends ExtendableMessageNano<GetStickerListRsp> {
    private static volatile GetStickerListRsp[] _emptyArray;
    public PicSticker[] picStickers;
    public TextSticker[] textStickers;

    public GetStickerListRsp() {
        clear();
    }

    public static GetStickerListRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetStickerListRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetStickerListRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetStickerListRsp) MessageNano.mergeFrom(new GetStickerListRsp(), bArr);
    }

    public GetStickerListRsp clear() {
        this.textStickers = TextSticker.emptyArray();
        this.picStickers = PicSticker.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        TextSticker[] textStickerArr = this.textStickers;
        int i3 = 0;
        if (textStickerArr != null && textStickerArr.length > 0) {
            int i16 = 0;
            while (true) {
                TextSticker[] textStickerArr2 = this.textStickers;
                if (i16 >= textStickerArr2.length) {
                    break;
                }
                TextSticker textSticker = textStickerArr2[i16];
                if (textSticker != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, textSticker);
                }
                i16++;
            }
        }
        PicSticker[] picStickerArr = this.picStickers;
        if (picStickerArr != null && picStickerArr.length > 0) {
            while (true) {
                PicSticker[] picStickerArr2 = this.picStickers;
                if (i3 >= picStickerArr2.length) {
                    break;
                }
                PicSticker picSticker = picStickerArr2[i3];
                if (picSticker != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, picSticker);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        TextSticker[] textStickerArr = this.textStickers;
        int i3 = 0;
        if (textStickerArr != null && textStickerArr.length > 0) {
            int i16 = 0;
            while (true) {
                TextSticker[] textStickerArr2 = this.textStickers;
                if (i16 >= textStickerArr2.length) {
                    break;
                }
                TextSticker textSticker = textStickerArr2[i16];
                if (textSticker != null) {
                    codedOutputByteBufferNano.writeMessage(1, textSticker);
                }
                i16++;
            }
        }
        PicSticker[] picStickerArr = this.picStickers;
        if (picStickerArr != null && picStickerArr.length > 0) {
            while (true) {
                PicSticker[] picStickerArr2 = this.picStickers;
                if (i3 >= picStickerArr2.length) {
                    break;
                }
                PicSticker picSticker = picStickerArr2[i3];
                if (picSticker != null) {
                    codedOutputByteBufferNano.writeMessage(2, picSticker);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetStickerListRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetStickerListRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetStickerListRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                TextSticker[] textStickerArr = this.textStickers;
                int length = textStickerArr == null ? 0 : textStickerArr.length;
                int i3 = repeatedFieldArrayLength + length;
                TextSticker[] textStickerArr2 = new TextSticker[i3];
                if (length != 0) {
                    System.arraycopy(textStickerArr, 0, textStickerArr2, 0, length);
                }
                while (length < i3 - 1) {
                    TextSticker textSticker = new TextSticker();
                    textStickerArr2[length] = textSticker;
                    codedInputByteBufferNano.readMessage(textSticker);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                TextSticker textSticker2 = new TextSticker();
                textStickerArr2[length] = textSticker2;
                codedInputByteBufferNano.readMessage(textSticker2);
                this.textStickers = textStickerArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                PicSticker[] picStickerArr = this.picStickers;
                int length2 = picStickerArr == null ? 0 : picStickerArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                PicSticker[] picStickerArr2 = new PicSticker[i16];
                if (length2 != 0) {
                    System.arraycopy(picStickerArr, 0, picStickerArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    PicSticker picSticker = new PicSticker();
                    picStickerArr2[length2] = picSticker;
                    codedInputByteBufferNano.readMessage(picSticker);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                PicSticker picSticker2 = new PicSticker();
                picStickerArr2[length2] = picSticker2;
                codedInputByteBufferNano.readMessage(picSticker2);
                this.picStickers = picStickerArr2;
            }
        }
    }
}
