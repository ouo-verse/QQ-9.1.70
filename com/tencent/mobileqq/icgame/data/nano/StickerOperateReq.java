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
public final class StickerOperateReq extends ExtendableMessageNano<StickerOperateReq> {
    private static volatile StickerOperateReq[] _emptyArray;
    public int opType;
    public Sticker sticker;

    public StickerOperateReq() {
        clear();
    }

    public static StickerOperateReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new StickerOperateReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static StickerOperateReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (StickerOperateReq) MessageNano.mergeFrom(new StickerOperateReq(), bArr);
    }

    public StickerOperateReq clear() {
        this.opType = 0;
        this.sticker = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.opType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        Sticker sticker = this.sticker;
        if (sticker != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, sticker);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.opType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        Sticker sticker = this.sticker;
        if (sticker != null) {
            codedOutputByteBufferNano.writeMessage(2, sticker);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static StickerOperateReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new StickerOperateReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public StickerOperateReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                        this.opType = readInt32;
                        break;
                }
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.sticker == null) {
                    this.sticker = new Sticker();
                }
                codedInputByteBufferNano.readMessage(this.sticker);
            }
        }
    }
}
