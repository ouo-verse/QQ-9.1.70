package pq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public a f427023a;

    /* renamed from: b, reason: collision with root package name */
    public b f427024b;

    /* renamed from: c, reason: collision with root package name */
    public e f427025c;

    /* renamed from: d, reason: collision with root package name */
    public d[] f427026d;

    /* renamed from: e, reason: collision with root package name */
    public String f427027e;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f427023a = null;
        this.f427024b = null;
        this.f427025c = null;
        this.f427026d = d.b();
        this.f427027e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 50) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f427027e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                d[] dVarArr = this.f427026d;
                                if (dVarArr == null) {
                                    length = 0;
                                } else {
                                    length = dVarArr.length;
                                }
                                int i3 = repeatedFieldArrayLength + length;
                                d[] dVarArr2 = new d[i3];
                                if (length != 0) {
                                    System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                                }
                                while (length < i3 - 1) {
                                    d dVar = new d();
                                    dVarArr2[length] = dVar;
                                    codedInputByteBufferNano.readMessage(dVar);
                                    codedInputByteBufferNano.readTag();
                                    length++;
                                }
                                d dVar2 = new d();
                                dVarArr2[length] = dVar2;
                                codedInputByteBufferNano.readMessage(dVar2);
                                this.f427026d = dVarArr2;
                            }
                        } else {
                            if (this.f427025c == null) {
                                this.f427025c = new e();
                            }
                            codedInputByteBufferNano.readMessage(this.f427025c);
                        }
                    } else {
                        if (this.f427024b == null) {
                            this.f427024b = new b();
                        }
                        codedInputByteBufferNano.readMessage(this.f427024b);
                    }
                } else {
                    if (this.f427023a == null) {
                        this.f427023a = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f427023a);
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
        a aVar = this.f427023a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        b bVar = this.f427024b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        e eVar = this.f427025c;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
        }
        d[] dVarArr = this.f427026d;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f427026d;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, dVar);
                }
                i3++;
            }
        }
        if (!this.f427027e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.f427027e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a aVar = this.f427023a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        b bVar = this.f427024b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        e eVar = this.f427025c;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(3, eVar);
        }
        d[] dVarArr = this.f427026d;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f427026d;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, dVar);
                }
                i3++;
            }
        }
        if (!this.f427027e.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f427027e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
