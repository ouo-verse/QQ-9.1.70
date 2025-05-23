package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PicSticker extends ExtendableMessageNano<PicSticker> {
    private static volatile PicSticker[] _emptyArray;
    public boolean isSelect;
    public int jumpType;
    public String jumpUrl;
    public long latestTs;
    public String location;
    public String materialMd5;
    public String materialUrl;
    public String stickerName;

    public PicSticker() {
        clear();
    }

    public static PicSticker[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PicSticker[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PicSticker parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PicSticker) MessageNano.mergeFrom(new PicSticker(), bArr);
    }

    public PicSticker clear() {
        this.stickerName = "";
        this.materialUrl = "";
        this.jumpUrl = "";
        this.jumpType = 0;
        this.materialMd5 = "";
        this.isSelect = false;
        this.location = "";
        this.latestTs = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.stickerName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.stickerName);
        }
        if (!this.materialUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.materialUrl);
        }
        if (!this.jumpUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl);
        }
        int i3 = this.jumpType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        if (!this.materialMd5.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.materialMd5);
        }
        boolean z16 = this.isSelect;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z16);
        }
        if (!this.location.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.location);
        }
        long j3 = this.latestTs;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(12, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.stickerName.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.stickerName);
        }
        if (!this.materialUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.materialUrl);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.jumpUrl);
        }
        int i3 = this.jumpType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        if (!this.materialMd5.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.materialMd5);
        }
        boolean z16 = this.isSelect;
        if (z16) {
            codedOutputByteBufferNano.writeBool(10, z16);
        }
        if (!this.location.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.location);
        }
        long j3 = this.latestTs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(12, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PicSticker parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PicSticker().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PicSticker mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.stickerName = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.materialUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.jumpUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.jumpType = readInt32;
                }
            } else if (readTag == 42) {
                this.materialMd5 = codedInputByteBufferNano.readString();
            } else if (readTag == 80) {
                this.isSelect = codedInputByteBufferNano.readBool();
            } else if (readTag == 90) {
                this.location = codedInputByteBufferNano.readString();
            } else if (readTag != 96) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.latestTs = codedInputByteBufferNano.readInt64();
            }
        }
    }
}
