package ms4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public d f417526a;

    /* renamed from: b, reason: collision with root package name */
    public a f417527b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f417528c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f417529d;

    /* renamed from: e, reason: collision with root package name */
    public int f417530e;

    /* renamed from: f, reason: collision with root package name */
    public long f417531f;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f417526a == null) {
                    this.f417526a = new d();
                }
                codedInputByteBufferNano.readMessage(this.f417526a);
            } else if (readTag == 18) {
                if (this.f417527b == null) {
                    this.f417527b = new a();
                }
                codedInputByteBufferNano.readMessage(this.f417527b);
            } else if (readTag == 24) {
                this.f417528c = codedInputByteBufferNano.readBool();
            } else if (readTag == 32) {
                this.f417529d = codedInputByteBufferNano.readBool();
            } else if (readTag == 40) {
                this.f417530e = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f417531f = codedInputByteBufferNano.readInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        d dVar = this.f417526a;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
        }
        a aVar = this.f417527b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        boolean z16 = this.f417528c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        boolean z17 = this.f417529d;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z17);
        }
        int i3 = this.f417530e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        long j3 = this.f417531f;
        return j3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(6, j3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d dVar = this.f417526a;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(1, dVar);
        }
        a aVar = this.f417527b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        boolean z16 = this.f417528c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        boolean z17 = this.f417529d;
        if (z17) {
            codedOutputByteBufferNano.writeBool(4, z17);
        }
        int i3 = this.f417530e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        long j3 = this.f417531f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f417526a = null;
        this.f417527b = null;
        this.f417528c = false;
        this.f417529d = false;
        this.f417530e = 0;
        this.f417531f = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
