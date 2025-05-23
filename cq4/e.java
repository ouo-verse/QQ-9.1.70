package cq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f391679a;

    /* renamed from: b, reason: collision with root package name */
    public String f391680b;

    /* renamed from: c, reason: collision with root package name */
    public int f391681c;

    public e() {
        a();
    }

    public e a() {
        this.f391679a = WireFormatNano.EMPTY_BYTES;
        this.f391680b = "";
        this.f391681c = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int readInt32 = codedInputByteBufferNano.readInt32();
                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                this.f391681c = readInt32;
                            }
                        }
                    } else {
                        this.f391680b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f391679a = codedInputByteBufferNano.readBytes();
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
        if (!Arrays.equals(this.f391679a, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(1, this.f391679a);
        }
        if (!this.f391680b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f391680b);
        }
        int i3 = this.f391681c;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!Arrays.equals(this.f391679a, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(1, this.f391679a);
        }
        if (!this.f391680b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f391680b);
        }
        int i3 = this.f391681c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
