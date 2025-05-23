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
public final class UploadRsp extends ExtendableMessageNano<UploadRsp> {
    private static volatile UploadRsp[] _emptyArray;
    public int height;

    /* renamed from: ts, reason: collision with root package name */
    public long f237298ts;
    public String url;
    public int width;

    public UploadRsp() {
        clear();
    }

    public static UploadRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UploadRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UploadRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UploadRsp) MessageNano.mergeFrom(new UploadRsp(), bArr);
    }

    public UploadRsp clear() {
        this.url = "";
        this.f237298ts = 0L;
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
        long j3 = this.f237298ts;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.width;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.height;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.url);
        }
        long j3 = this.f237298ts;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.width;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.height;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UploadRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UploadRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UploadRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.url = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.f237298ts = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.width = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.height = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
