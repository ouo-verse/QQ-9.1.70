package ep4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f396942a;

    /* renamed from: b, reason: collision with root package name */
    public int f396943b;

    /* renamed from: c, reason: collision with root package name */
    public float f396944c;

    /* renamed from: d, reason: collision with root package name */
    public float f396945d;

    public b() {
        a();
    }

    public b a() {
        this.f396942a = false;
        this.f396943b = 0;
        this.f396944c = 0.0f;
        this.f396945d = 0.0f;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 29) {
                            if (readTag != 37) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f396945d = codedInputByteBufferNano.readFloat();
                            }
                        } else {
                            this.f396944c = codedInputByteBufferNano.readFloat();
                        }
                    } else {
                        this.f396943b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f396942a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f396942a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        int i3 = this.f396943b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (Float.floatToIntBits(this.f396944c) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.f396944c);
        }
        if (Float.floatToIntBits(this.f396945d) != Float.floatToIntBits(0.0f)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(4, this.f396945d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f396942a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        int i3 = this.f396943b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (Float.floatToIntBits(this.f396944c) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.f396944c);
        }
        if (Float.floatToIntBits(this.f396945d) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.f396945d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
