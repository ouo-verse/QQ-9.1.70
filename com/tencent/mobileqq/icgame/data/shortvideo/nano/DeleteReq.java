package com.tencent.mobileqq.icgame.data.shortvideo.nano;

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
public final class DeleteReq extends ExtendableMessageNano<DeleteReq> {
    private static volatile DeleteReq[] _emptyArray;
    public byte[] fileId;
    public int fileType;
    public int seq;
    public int ver;

    public DeleteReq() {
        clear();
    }

    public static DeleteReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new DeleteReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static DeleteReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (DeleteReq) MessageNano.mergeFrom(new DeleteReq(), bArr);
    }

    public DeleteReq clear() {
        this.ver = 0;
        this.seq = 0;
        this.fileType = 0;
        this.fileId = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.ver;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.seq;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.fileType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        if (!Arrays.equals(this.fileId, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.fileId);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.ver;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.seq;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.fileType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        if (!Arrays.equals(this.fileId, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.fileId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static DeleteReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new DeleteReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public DeleteReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.ver = codedInputByteBufferNano.readInt32();
            } else if (readTag == 16) {
                this.seq = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.fileType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.fileId = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
