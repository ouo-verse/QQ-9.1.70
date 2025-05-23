package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class AdPosItem extends ExtendableMessageNano<AdPosItem> {
    private static volatile AdPosItem[] _emptyArray;
    public String extraInfo;
    public int nNeedCnt;
    public int posId;

    public AdPosItem() {
        clear();
    }

    public static AdPosItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AdPosItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AdPosItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AdPosItem) MessageNano.mergeFrom(new AdPosItem(), bArr);
    }

    public AdPosItem clear() {
        this.posId = 0;
        this.nNeedCnt = 0;
        this.extraInfo = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.posId;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.nNeedCnt;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.extraInfo.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(14, this.extraInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.posId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.nNeedCnt;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.extraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AdPosItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AdPosItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AdPosItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.posId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.nNeedCnt = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 114) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.extraInfo = codedInputByteBufferNano.readString();
            }
        }
    }
}
