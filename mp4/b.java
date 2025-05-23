package mp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public float f417139a;

    /* renamed from: b, reason: collision with root package name */
    public float f417140b;

    /* renamed from: c, reason: collision with root package name */
    public float f417141c;

    /* renamed from: d, reason: collision with root package name */
    public float f417142d;

    public b() {
        a();
    }

    public b a() {
        this.f417139a = 0.0f;
        this.f417140b = 0.0f;
        this.f417141c = 0.0f;
        this.f417142d = 0.0f;
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
                if (readTag != 13) {
                    if (readTag != 21) {
                        if (readTag != 29) {
                            if (readTag != 37) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f417142d = codedInputByteBufferNano.readFloat();
                            }
                        } else {
                            this.f417141c = codedInputByteBufferNano.readFloat();
                        }
                    } else {
                        this.f417140b = codedInputByteBufferNano.readFloat();
                    }
                } else {
                    this.f417139a = codedInputByteBufferNano.readFloat();
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
        if (Float.floatToIntBits(this.f417139a) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(1, this.f417139a);
        }
        if (Float.floatToIntBits(this.f417140b) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(2, this.f417140b);
        }
        if (Float.floatToIntBits(this.f417141c) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.f417141c);
        }
        if (Float.floatToIntBits(this.f417142d) != Float.floatToIntBits(0.0f)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(4, this.f417142d);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (Float.floatToIntBits(this.f417139a) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(1, this.f417139a);
        }
        if (Float.floatToIntBits(this.f417140b) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(2, this.f417140b);
        }
        if (Float.floatToIntBits(this.f417141c) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.f417141c);
        }
        if (Float.floatToIntBits(this.f417142d) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.f417142d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
