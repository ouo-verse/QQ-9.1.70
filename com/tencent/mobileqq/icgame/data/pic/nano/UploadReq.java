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
public final class UploadReq extends ExtendableMessageNano<UploadReq> {
    private static volatile UploadReq[] _emptyArray;
    public boolean base64;
    public byte[] pic;
    public long roomId;
    public String strPic;
    public int type;

    public UploadReq() {
        clear();
    }

    public static UploadReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UploadReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UploadReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UploadReq) MessageNano.mergeFrom(new UploadReq(), bArr);
    }

    public UploadReq clear() {
        this.roomId = 0L;
        this.type = 0;
        this.base64 = false;
        this.pic = WireFormatNano.EMPTY_BYTES;
        this.strPic = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
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
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.pic);
        }
        if (!this.strPic.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.strPic);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
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
        if (!this.strPic.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.strPic);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UploadReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UploadReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UploadReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.type = readInt32;
                }
            } else if (readTag == 24) {
                this.base64 = codedInputByteBufferNano.readBool();
            } else if (readTag == 34) {
                this.pic = codedInputByteBufferNano.readBytes();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.strPic = codedInputByteBufferNano.readString();
            }
        }
    }
}
