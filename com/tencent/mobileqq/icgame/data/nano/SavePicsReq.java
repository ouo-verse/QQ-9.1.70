package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class SavePicsReq extends ExtendableMessageNano<SavePicsReq> {
    private static volatile SavePicsReq[] _emptyArray;
    public int picType;
    public String picUrl;

    public SavePicsReq() {
        clear();
    }

    public static SavePicsReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SavePicsReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SavePicsReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SavePicsReq) MessageNano.mergeFrom(new SavePicsReq(), bArr);
    }

    public SavePicsReq clear() {
        this.picType = 0;
        this.picUrl = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.picType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.picUrl.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.picUrl);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.picType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.picUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.picUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SavePicsReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SavePicsReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SavePicsReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.picType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.picUrl = codedInputByteBufferNano.readString();
            }
        }
    }
}
