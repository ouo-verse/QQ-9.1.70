package lv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f415656a;

    /* renamed from: b, reason: collision with root package name */
    public jv4.f f415657b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f415658c;

    /* renamed from: d, reason: collision with root package name */
    public jv4.j f415659d;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f415656a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.f415657b == null) {
                    this.f415657b = new jv4.f();
                }
                codedInputByteBufferNano.readMessage(this.f415657b);
            } else if (readTag == 24) {
                this.f415658c = codedInputByteBufferNano.readBool();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f415659d == null) {
                    this.f415659d = new jv4.j();
                }
                codedInputByteBufferNano.readMessage(this.f415659d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f415656a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        jv4.f fVar = this.f415657b;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, fVar);
        }
        boolean z17 = this.f415658c;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z17);
        }
        jv4.j jVar = this.f415659d;
        return jVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, jVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f415656a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        jv4.f fVar = this.f415657b;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(2, fVar);
        }
        boolean z17 = this.f415658c;
        if (z17) {
            codedOutputByteBufferNano.writeBool(3, z17);
        }
        jv4.j jVar = this.f415659d;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(4, jVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f415656a = false;
        this.f415657b = null;
        this.f415658c = false;
        this.f415659d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
