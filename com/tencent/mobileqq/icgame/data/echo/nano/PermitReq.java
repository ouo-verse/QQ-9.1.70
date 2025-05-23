package com.tencent.mobileqq.icgame.data.echo.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class PermitReq extends ExtendableMessageNano<PermitReq> {
    private static volatile PermitReq[] _emptyArray;
    public String officialAccTips;
    public String reason;
    public long tinyId;
    public int type;
    public long uid;

    public PermitReq() {
        clear();
    }

    public static PermitReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PermitReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static PermitReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (PermitReq) MessageNano.mergeFrom(new PermitReq(), bArr);
    }

    public PermitReq clear() {
        this.type = 0;
        this.tinyId = 0L;
        this.reason = "";
        this.officialAccTips = "";
        this.uid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.tinyId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.reason.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.reason);
        }
        if (!this.officialAccTips.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.officialAccTips);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.tinyId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.reason.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.reason);
        }
        if (!this.officialAccTips.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.officialAccTips);
        }
        long j16 = this.uid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static PermitReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new PermitReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public PermitReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.tinyId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 26) {
                this.reason = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.officialAccTips = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
