package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public t f406416a;

    /* renamed from: b, reason: collision with root package name */
    public i f406417b;

    /* renamed from: c, reason: collision with root package name */
    public k f406418c;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f406416a == null) {
                    this.f406416a = new t();
                }
                codedInputByteBufferNano.readMessage(this.f406416a);
            } else if (readTag == 18) {
                if (this.f406417b == null) {
                    this.f406417b = new i();
                }
                codedInputByteBufferNano.readMessage(this.f406417b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f406418c == null) {
                    this.f406418c = new k();
                }
                codedInputByteBufferNano.readMessage(this.f406418c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        t tVar = this.f406416a;
        if (tVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, tVar);
        }
        i iVar = this.f406417b;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, iVar);
        }
        k kVar = this.f406418c;
        return kVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, kVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        t tVar = this.f406416a;
        if (tVar != null) {
            codedOutputByteBufferNano.writeMessage(1, tVar);
        }
        i iVar = this.f406417b;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(2, iVar);
        }
        k kVar = this.f406418c;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(3, kVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f406416a = null;
        this.f406417b = null;
        this.f406418c = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
