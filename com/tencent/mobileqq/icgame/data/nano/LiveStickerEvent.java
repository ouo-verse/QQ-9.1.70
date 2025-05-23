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
public final class LiveStickerEvent extends ExtendableMessageNano<LiveStickerEvent> {
    private static volatile LiveStickerEvent[] _emptyArray;
    public boolean isHit;
    public Sticker[] liveStickers;
    public int stickerOp;

    public LiveStickerEvent() {
        clear();
    }

    public static LiveStickerEvent[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveStickerEvent[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LiveStickerEvent parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LiveStickerEvent) MessageNano.mergeFrom(new LiveStickerEvent(), bArr);
    }

    public LiveStickerEvent clear() {
        this.stickerOp = 0;
        this.liveStickers = Sticker.emptyArray();
        this.isHit = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.stickerOp;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        Sticker[] stickerArr = this.liveStickers;
        if (stickerArr != null && stickerArr.length > 0) {
            int i16 = 0;
            while (true) {
                Sticker[] stickerArr2 = this.liveStickers;
                if (i16 >= stickerArr2.length) {
                    break;
                }
                Sticker sticker = stickerArr2[i16];
                if (sticker != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, sticker);
                }
                i16++;
            }
        }
        boolean z16 = this.isHit;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.stickerOp;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        Sticker[] stickerArr = this.liveStickers;
        if (stickerArr != null && stickerArr.length > 0) {
            int i16 = 0;
            while (true) {
                Sticker[] stickerArr2 = this.liveStickers;
                if (i16 >= stickerArr2.length) {
                    break;
                }
                Sticker sticker = stickerArr2[i16];
                if (sticker != null) {
                    codedOutputByteBufferNano.writeMessage(2, sticker);
                }
                i16++;
            }
        }
        boolean z16 = this.isHit;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LiveStickerEvent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LiveStickerEvent().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LiveStickerEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                switch (readInt32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        this.stickerOp = readInt32;
                        break;
                }
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                Sticker[] stickerArr = this.liveStickers;
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
                this.liveStickers = stickerArr2;
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.isHit = codedInputByteBufferNano.readBool();
            }
        }
    }
}
