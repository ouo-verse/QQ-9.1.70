package com.tencent.mobileqq.icgame.data.nano;

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
public final class GetMidLinkMicSigRsp extends ExtendableMessageNano<GetMidLinkMicSigRsp> {
    private static volatile GetMidLinkMicSigRsp[] _emptyArray;
    public long imsdkTinyid;
    public int result;
    public byte[] sig;

    public GetMidLinkMicSigRsp() {
        clear();
    }

    public static GetMidLinkMicSigRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetMidLinkMicSigRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetMidLinkMicSigRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetMidLinkMicSigRsp) MessageNano.mergeFrom(new GetMidLinkMicSigRsp(), bArr);
    }

    public GetMidLinkMicSigRsp clear() {
        this.result = 0;
        this.sig = WireFormatNano.EMPTY_BYTES;
        this.imsdkTinyid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.sig);
        }
        long j3 = this.imsdkTinyid;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!Arrays.equals(this.sig, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.sig);
        }
        long j3 = this.imsdkTinyid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetMidLinkMicSigRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetMidLinkMicSigRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetMidLinkMicSigRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.sig = codedInputByteBufferNano.readBytes();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.imsdkTinyid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
