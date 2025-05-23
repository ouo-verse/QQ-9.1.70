package cv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public f f391910a;

    /* renamed from: b, reason: collision with root package name */
    public int f391911b;

    /* renamed from: c, reason: collision with root package name */
    public int f391912c;

    /* renamed from: d, reason: collision with root package name */
    public b f391913d;

    /* renamed from: e, reason: collision with root package name */
    public int f391914e;

    /* renamed from: f, reason: collision with root package name */
    public d f391915f;

    /* renamed from: g, reason: collision with root package name */
    public d f391916g;

    /* renamed from: h, reason: collision with root package name */
    public int f391917h;

    public a() {
        a();
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
                if (this.f391910a == null) {
                    this.f391910a = new f();
                }
                codedInputByteBufferNano.readMessage(this.f391910a);
            } else if (readTag == 16) {
                this.f391911b = codedInputByteBufferNano.readInt32();
            } else if (readTag == 24) {
                this.f391912c = codedInputByteBufferNano.readInt32();
            } else if (readTag == 34) {
                if (this.f391913d == null) {
                    this.f391913d = new b();
                }
                codedInputByteBufferNano.readMessage(this.f391913d);
            } else if (readTag == 40) {
                this.f391914e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 50) {
                if (this.f391915f == null) {
                    this.f391915f = new d();
                }
                codedInputByteBufferNano.readMessage(this.f391915f);
            } else if (readTag == 58) {
                if (this.f391916g == null) {
                    this.f391916g = new d();
                }
                codedInputByteBufferNano.readMessage(this.f391916g);
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f391917h = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        f fVar = this.f391910a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        int i3 = this.f391911b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        int i16 = this.f391912c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i16);
        }
        b bVar = this.f391913d;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, bVar);
        }
        int i17 = this.f391914e;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i17);
        }
        d dVar = this.f391915f;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, dVar);
        }
        d dVar2 = this.f391916g;
        if (dVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, dVar2);
        }
        int i18 = this.f391917h;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f fVar = this.f391910a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        int i3 = this.f391911b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        int i16 = this.f391912c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i16);
        }
        b bVar = this.f391913d;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(4, bVar);
        }
        int i17 = this.f391914e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        d dVar = this.f391915f;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(6, dVar);
        }
        d dVar2 = this.f391916g;
        if (dVar2 != null) {
            codedOutputByteBufferNano.writeMessage(7, dVar2);
        }
        int i18 = this.f391917h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f391910a = null;
        this.f391911b = 0;
        this.f391912c = 0;
        this.f391913d = null;
        this.f391914e = 0;
        this.f391915f = null;
        this.f391916g = null;
        this.f391917h = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
