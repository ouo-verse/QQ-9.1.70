package fr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f400378a;

    /* renamed from: b, reason: collision with root package name */
    public long f400379b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f400380c;

    /* renamed from: d, reason: collision with root package name */
    public int f400381d;

    /* renamed from: e, reason: collision with root package name */
    public String f400382e;

    public c() {
        a();
    }

    public c a() {
        this.f400378a = "";
        this.f400379b = 0L;
        this.f400380c = WireFormatNano.EMPTY_BYTES;
        this.f400381d = 0;
        this.f400382e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f400382e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f400381d = codedInputByteBufferNano.readInt32();
                            }
                        } else {
                            this.f400380c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        this.f400379b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f400378a = codedInputByteBufferNano.readString();
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f400378a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400378a);
        }
        long j3 = this.f400379b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!Arrays.equals(this.f400380c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f400380c);
        }
        int i3 = this.f400381d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        if (!this.f400382e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f400382e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400378a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400378a);
        }
        long j3 = this.f400379b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!Arrays.equals(this.f400380c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f400380c);
        }
        int i3 = this.f400381d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        if (!this.f400382e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f400382e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
