package gx4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public b f403746a;

    /* renamed from: b, reason: collision with root package name */
    public g f403747b;

    /* renamed from: c, reason: collision with root package name */
    public j f403748c;

    /* renamed from: d, reason: collision with root package name */
    public c f403749d;

    /* renamed from: e, reason: collision with root package name */
    public int f403750e;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f403746a = null;
        this.f403747b = null;
        this.f403748c = null;
        this.f403749d = null;
        this.f403750e = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    int readInt32 = codedInputByteBufferNano.readInt32();
                                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                                        this.f403750e = readInt32;
                                    }
                                }
                            } else {
                                if (this.f403749d == null) {
                                    this.f403749d = new c();
                                }
                                codedInputByteBufferNano.readMessage(this.f403749d);
                            }
                        } else {
                            if (this.f403748c == null) {
                                this.f403748c = new j();
                            }
                            codedInputByteBufferNano.readMessage(this.f403748c);
                        }
                    } else {
                        if (this.f403747b == null) {
                            this.f403747b = new g();
                        }
                        codedInputByteBufferNano.readMessage(this.f403747b);
                    }
                } else {
                    if (this.f403746a == null) {
                        this.f403746a = new b();
                    }
                    codedInputByteBufferNano.readMessage(this.f403746a);
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
        b bVar = this.f403746a;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
        }
        g gVar = this.f403747b;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, gVar);
        }
        j jVar = this.f403748c;
        if (jVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, jVar);
        }
        c cVar = this.f403749d;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar);
        }
        int i3 = this.f403750e;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b bVar = this.f403746a;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(1, bVar);
        }
        g gVar = this.f403747b;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(2, gVar);
        }
        j jVar = this.f403748c;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(3, jVar);
        }
        c cVar = this.f403749d;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(4, cVar);
        }
        int i3 = this.f403750e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
