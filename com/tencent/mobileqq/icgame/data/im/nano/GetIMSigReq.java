package com.tencent.mobileqq.icgame.data.im.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetIMSigReq extends ExtendableMessageNano<GetIMSigReq> {
    private static volatile GetIMSigReq[] _emptyArray;
    public int refer;

    /* renamed from: st, reason: collision with root package name */
    public String f237260st;
    public long uid;

    public GetIMSigReq() {
        clear();
    }

    public static GetIMSigReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetIMSigReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetIMSigReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetIMSigReq) MessageNano.mergeFrom(new GetIMSigReq(), bArr);
    }

    public GetIMSigReq clear() {
        this.uid = 0L;
        this.f237260st = "";
        this.refer = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.f237260st.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f237260st);
        }
        int i3 = this.refer;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.f237260st.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f237260st);
        }
        int i3 = this.refer;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetIMSigReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetIMSigReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetIMSigReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.f237260st = codedInputByteBufferNano.readString();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.refer = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
