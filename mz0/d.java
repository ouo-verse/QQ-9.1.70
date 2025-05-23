package mz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public f f417851a;

    /* renamed from: b, reason: collision with root package name */
    public b f417852b;

    /* renamed from: c, reason: collision with root package name */
    public long f417853c;

    /* renamed from: d, reason: collision with root package name */
    public a f417854d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f417855e;

    /* renamed from: f, reason: collision with root package name */
    public String f417856f;

    /* renamed from: g, reason: collision with root package name */
    public e f417857g;

    /* renamed from: h, reason: collision with root package name */
    public String f417858h;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f417851a = null;
        this.f417852b = null;
        this.f417853c = 0L;
        this.f417854d = null;
        this.f417855e = false;
        this.f417856f = "";
        this.f417857g = null;
        this.f417858h = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 32) {
                            if (readTag != 42) {
                                if (readTag != 48) {
                                    if (readTag != 58) {
                                        if (readTag != 66) {
                                            if (readTag != 74) {
                                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                    return this;
                                                }
                                            } else {
                                                this.f417858h = codedInputByteBufferNano.readString();
                                            }
                                        } else {
                                            if (this.f417857g == null) {
                                                this.f417857g = new e();
                                            }
                                            codedInputByteBufferNano.readMessage(this.f417857g);
                                        }
                                    } else {
                                        this.f417856f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f417855e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                if (this.f417854d == null) {
                                    this.f417854d = new a();
                                }
                                codedInputByteBufferNano.readMessage(this.f417854d);
                            }
                        } else {
                            this.f417853c = codedInputByteBufferNano.readUInt64();
                        }
                    } else {
                        if (this.f417852b == null) {
                            this.f417852b = new b();
                        }
                        codedInputByteBufferNano.readMessage(this.f417852b);
                    }
                } else {
                    if (this.f417851a == null) {
                        this.f417851a = new f();
                    }
                    codedInputByteBufferNano.readMessage(this.f417851a);
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
        f fVar = this.f417851a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        b bVar = this.f417852b;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bVar);
        }
        long j3 = this.f417853c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        a aVar = this.f417854d;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, aVar);
        }
        boolean z16 = this.f417855e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        if (!this.f417856f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f417856f);
        }
        e eVar = this.f417857g;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, eVar);
        }
        if (!this.f417858h.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f417858h);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f fVar = this.f417851a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        b bVar = this.f417852b;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(2, bVar);
        }
        long j3 = this.f417853c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        a aVar = this.f417854d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(5, aVar);
        }
        boolean z16 = this.f417855e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        if (!this.f417856f.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f417856f);
        }
        e eVar = this.f417857g;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(8, eVar);
        }
        if (!this.f417858h.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f417858h);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
