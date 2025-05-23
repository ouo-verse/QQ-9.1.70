package iw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public String f408868a;

    /* renamed from: b, reason: collision with root package name */
    public String f408869b;

    /* renamed from: c, reason: collision with root package name */
    public int f408870c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f408871d;

    /* renamed from: e, reason: collision with root package name */
    public long f408872e;

    public a() {
        a();
    }

    public a a() {
        this.f408868a = "";
        this.f408869b = "";
        this.f408870c = 0;
        this.f408871d = WireFormatNano.EMPTY_BYTES;
        this.f408872e = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f408868a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f408869b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f408870c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                this.f408871d = codedInputByteBufferNano.readBytes();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f408872e = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f408868a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f408868a);
        }
        if (!this.f408869b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f408869b);
        }
        int i3 = this.f408870c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        if (!Arrays.equals(this.f408871d, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.f408871d);
        }
        long j3 = this.f408872e;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f408868a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f408868a);
        }
        if (!this.f408869b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f408869b);
        }
        int i3 = this.f408870c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        if (!Arrays.equals(this.f408871d, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.f408871d);
        }
        long j3 = this.f408872e;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
