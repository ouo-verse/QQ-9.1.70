package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i extends ExtendableMessageNano<i> {

    /* renamed from: a, reason: collision with root package name */
    public int f403778a;

    /* renamed from: b, reason: collision with root package name */
    public k f403779b;

    /* renamed from: c, reason: collision with root package name */
    public k f403780c;

    /* renamed from: d, reason: collision with root package name */
    public float f403781d;

    /* renamed from: e, reason: collision with root package name */
    public float f403782e;

    /* renamed from: f, reason: collision with root package name */
    public float f403783f;

    public i() {
        a();
    }

    public i a() {
        this.f403778a = 0;
        this.f403779b = null;
        this.f403780c = null;
        this.f403781d = 0.0f;
        this.f403782e = 0.0f;
        this.f403783f = 0.0f;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public i mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 37) {
                                if (readTag != 45) {
                                    if (readTag != 53) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f403783f = codedInputByteBufferNano.readFloat();
                                    }
                                } else {
                                    this.f403782e = codedInputByteBufferNano.readFloat();
                                }
                            } else {
                                this.f403781d = codedInputByteBufferNano.readFloat();
                            }
                        } else {
                            if (this.f403780c == null) {
                                this.f403780c = new k();
                            }
                            codedInputByteBufferNano.readMessage(this.f403780c);
                        }
                    } else {
                        if (this.f403779b == null) {
                            this.f403779b = new k();
                        }
                        codedInputByteBufferNano.readMessage(this.f403779b);
                    }
                } else {
                    this.f403778a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f403778a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        k kVar = this.f403779b;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, kVar);
        }
        k kVar2 = this.f403780c;
        if (kVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, kVar2);
        }
        if (Float.floatToIntBits(this.f403781d) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(4, this.f403781d);
        }
        if (Float.floatToIntBits(this.f403782e) != Float.floatToIntBits(0.0f)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(5, this.f403782e);
        }
        if (Float.floatToIntBits(this.f403783f) != Float.floatToIntBits(0.0f)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(6, this.f403783f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403778a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        k kVar = this.f403779b;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(2, kVar);
        }
        k kVar2 = this.f403780c;
        if (kVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar2);
        }
        if (Float.floatToIntBits(this.f403781d) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.f403781d);
        }
        if (Float.floatToIntBits(this.f403782e) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(5, this.f403782e);
        }
        if (Float.floatToIntBits(this.f403783f) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(6, this.f403783f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
