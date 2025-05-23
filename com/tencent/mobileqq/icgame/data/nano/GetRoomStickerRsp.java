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
public final class GetRoomStickerRsp extends ExtendableMessageNano<GetRoomStickerRsp> {
    private static volatile GetRoomStickerRsp[] _emptyArray;
    public Sticker[] stickers;

    public GetRoomStickerRsp() {
        clear();
    }

    public static GetRoomStickerRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomStickerRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomStickerRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomStickerRsp) MessageNano.mergeFrom(new GetRoomStickerRsp(), bArr);
    }

    public GetRoomStickerRsp clear() {
        this.stickers = Sticker.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Sticker[] stickerArr = this.stickers;
        if (stickerArr != null && stickerArr.length > 0) {
            int i3 = 0;
            while (true) {
                Sticker[] stickerArr2 = this.stickers;
                if (i3 >= stickerArr2.length) {
                    break;
                }
                Sticker sticker = stickerArr2[i3];
                if (sticker != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sticker);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Sticker[] stickerArr = this.stickers;
        if (stickerArr != null && stickerArr.length > 0) {
            int i3 = 0;
            while (true) {
                Sticker[] stickerArr2 = this.stickers;
                if (i3 >= stickerArr2.length) {
                    break;
                }
                Sticker sticker = stickerArr2[i3];
                if (sticker != null) {
                    codedOutputByteBufferNano.writeMessage(1, sticker);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomStickerRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomStickerRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomStickerRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Sticker[] stickerArr = this.stickers;
                int length = stickerArr == null ? 0 : stickerArr.length;
                int i3 = repeatedFieldArrayLength + length;
                Sticker[] stickerArr2 = new Sticker[i3];
                if (length != 0) {
                    System.arraycopy(stickerArr, 0, stickerArr2, 0, length);
                }
                while (length < i3 - 1) {
                    Sticker sticker = new Sticker();
                    stickerArr2[length] = sticker;
                    codedInputByteBufferNano.readMessage(sticker);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                Sticker sticker2 = new Sticker();
                stickerArr2[length] = sticker2;
                codedInputByteBufferNano.readMessage(sticker2);
                this.stickers = stickerArr2;
            }
        }
    }
}
