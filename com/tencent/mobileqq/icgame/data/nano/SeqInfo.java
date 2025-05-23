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
public final class SeqInfo extends ExtendableMessageNano<SeqInfo> {
    private static volatile SeqInfo[] _emptyArray;
    public byte[] data;

    /* renamed from: id, reason: collision with root package name */
    public long f237291id;
    public long seq;
    public int type;

    public SeqInfo() {
        clear();
    }

    public static SeqInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SeqInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SeqInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SeqInfo) MessageNano.mergeFrom(new SeqInfo(), bArr);
    }

    public SeqInfo clear() {
        this.type = 0;
        this.f237291id = 0L;
        this.seq = 0L;
        this.data = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.type) + CodedOutputByteBufferNano.computeUInt64Size(2, this.f237291id);
        long j3 = this.seq;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        if (!Arrays.equals(this.data, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(4, this.data);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.type);
        codedOutputByteBufferNano.writeUInt64(2, this.f237291id);
        long j3 = this.seq;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        if (!Arrays.equals(this.data, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.data);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SeqInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SeqInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SeqInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f237291id = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.seq = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.data = codedInputByteBufferNano.readBytes();
            }
        }
    }
}
