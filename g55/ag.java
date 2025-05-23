package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ag extends ExtendableMessageNano<ag> {

    /* renamed from: a, reason: collision with root package name */
    public String f401295a;

    /* renamed from: b, reason: collision with root package name */
    public e55.a f401296b;

    /* renamed from: c, reason: collision with root package name */
    public e55.a f401297c;

    /* renamed from: d, reason: collision with root package name */
    public int f401298d;

    /* renamed from: e, reason: collision with root package name */
    public int f401299e;

    /* renamed from: f, reason: collision with root package name */
    public int f401300f;

    /* renamed from: g, reason: collision with root package name */
    public int f401301g;

    public ag() {
        a();
    }

    public static ag c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ag) MessageNano.mergeFrom(new ag(), bArr);
    }

    public ag a() {
        this.f401295a = "";
        this.f401296b = null;
        this.f401297c = null;
        this.f401298d = 0;
        this.f401299e = 0;
        this.f401300f = 0;
        this.f401301g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ag mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 56) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            int readInt32 = codedInputByteBufferNano.readInt32();
                                            if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4 || readInt32 == 5) {
                                                this.f401301g = readInt32;
                                            }
                                        }
                                    } else {
                                        int readInt322 = codedInputByteBufferNano.readInt32();
                                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                                            this.f401300f = readInt322;
                                        }
                                    }
                                } else {
                                    int readInt323 = codedInputByteBufferNano.readInt32();
                                    if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2 || readInt323 == 3 || readInt323 == 4 || readInt323 == 5) {
                                        this.f401299e = readInt323;
                                    }
                                }
                            } else {
                                int readInt324 = codedInputByteBufferNano.readInt32();
                                if (readInt324 == 0 || readInt324 == 1 || readInt324 == 2 || readInt324 == 3 || readInt324 == 4 || readInt324 == 5) {
                                    this.f401298d = readInt324;
                                }
                            }
                        } else {
                            if (this.f401297c == null) {
                                this.f401297c = new e55.a();
                            }
                            codedInputByteBufferNano.readMessage(this.f401297c);
                        }
                    } else {
                        if (this.f401296b == null) {
                            this.f401296b = new e55.a();
                        }
                        codedInputByteBufferNano.readMessage(this.f401296b);
                    }
                } else {
                    this.f401295a = codedInputByteBufferNano.readString();
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
        if (!this.f401295a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f401295a);
        }
        e55.a aVar = this.f401296b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        e55.a aVar2 = this.f401297c;
        if (aVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar2);
        }
        int i3 = this.f401298d;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        int i16 = this.f401299e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        int i17 = this.f401300f;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i17);
        }
        int i18 = this.f401301g;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f401295a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f401295a);
        }
        e55.a aVar = this.f401296b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        e55.a aVar2 = this.f401297c;
        if (aVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar2);
        }
        int i3 = this.f401298d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        int i16 = this.f401299e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        int i17 = this.f401300f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        int i18 = this.f401301g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
