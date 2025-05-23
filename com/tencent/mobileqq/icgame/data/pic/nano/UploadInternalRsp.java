package com.tencent.mobileqq.icgame.data.pic.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class UploadInternalRsp extends ExtendableMessageNano<UploadInternalRsp> {
    private static volatile UploadInternalRsp[] _emptyArray;
    public int height;
    public String url;
    public int width;

    public UploadInternalRsp() {
        clear();
    }

    public static UploadInternalRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UploadInternalRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UploadInternalRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UploadInternalRsp) MessageNano.mergeFrom(new UploadInternalRsp(), bArr);
    }

    public UploadInternalRsp clear() {
        this.url = "";
        this.width = 0;
        this.height = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.url.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.url);
        }
        int i3 = this.width;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.height;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.url);
        }
        int i3 = this.width;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.height;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UploadInternalRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UploadInternalRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UploadInternalRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.url = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.width = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.height = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
