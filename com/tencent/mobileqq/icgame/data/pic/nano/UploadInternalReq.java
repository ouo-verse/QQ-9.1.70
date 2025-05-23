package com.tencent.mobileqq.icgame.data.pic.nano;

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
public final class UploadInternalReq extends ExtendableMessageNano<UploadInternalReq> {
    private static volatile UploadInternalReq[] _emptyArray;
    public boolean base64;
    public String fileName;
    public byte[] pic;
    public int type;

    public UploadInternalReq() {
        clear();
    }

    public static UploadInternalReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UploadInternalReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UploadInternalReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UploadInternalReq) MessageNano.mergeFrom(new UploadInternalReq(), bArr);
    }

    public UploadInternalReq clear() {
        this.fileName = "";
        this.type = 0;
        this.base64 = false;
        this.pic = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.fileName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.fileName);
        }
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        boolean z16 = this.base64;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        if (!Arrays.equals(this.pic, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.pic);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.fileName.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.fileName);
        }
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        boolean z16 = this.base64;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        if (!Arrays.equals(this.pic, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.pic);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UploadInternalReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UploadInternalReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UploadInternalReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.fileName = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.type = readInt32;
                }
            } else if (readTag == 24) {
                this.base64 = codedInputByteBufferNano.readBool();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.pic = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
