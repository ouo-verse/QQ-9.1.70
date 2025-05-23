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
public final class commResponse extends ExtendableMessageNano<commResponse> {
    private static volatile commResponse[] _emptyArray;
    public byte[] body;
    public int code;

    /* renamed from: msg, reason: collision with root package name */
    public String f237295msg;
    public long seq;

    public commResponse() {
        clear();
    }

    public static commResponse[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new commResponse[0];
                }
            }
        }
        return _emptyArray;
    }

    public static commResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (commResponse) MessageNano.mergeFrom(new commResponse(), bArr);
    }

    public commResponse clear() {
        this.seq = 0L;
        this.code = 0;
        this.f237295msg = "";
        this.body = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.seq;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.code;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.f237295msg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f237295msg);
        }
        if (!Arrays.equals(this.body, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.body);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.seq;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.code;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.f237295msg.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f237295msg);
        }
        if (!Arrays.equals(this.body, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.body);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static commResponse parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new commResponse().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public commResponse mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.seq = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.code = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                this.f237295msg = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.body = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
