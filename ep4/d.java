package ep4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public a f396948a;

    /* renamed from: b, reason: collision with root package name */
    public a[] f396949b;

    /* renamed from: c, reason: collision with root package name */
    public int f396950c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f396951d;

    /* renamed from: e, reason: collision with root package name */
    public b f396952e;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f396948a = null;
        this.f396949b = a.b();
        this.f396950c = 0;
        this.f396951d = false;
        this.f396952e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 26) {
                    if (readTag != 34) {
                        if (readTag != 40) {
                            if (readTag != 48) {
                                if (readTag != 66) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    if (this.f396952e == null) {
                                        this.f396952e = new b();
                                    }
                                    codedInputByteBufferNano.readMessage(this.f396952e);
                                }
                            } else {
                                this.f396951d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f396950c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        a[] aVarArr = this.f396949b;
                        if (aVarArr == null) {
                            length = 0;
                        } else {
                            length = aVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        a[] aVarArr2 = new a[i3];
                        if (length != 0) {
                            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            a aVar = new a();
                            aVarArr2[length] = aVar;
                            codedInputByteBufferNano.readMessage(aVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        a aVar2 = new a();
                        aVarArr2[length] = aVar2;
                        codedInputByteBufferNano.readMessage(aVar2);
                        this.f396949b = aVarArr2;
                    }
                } else {
                    if (this.f396948a == null) {
                        this.f396948a = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f396948a);
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
        a aVar = this.f396948a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
        }
        a[] aVarArr = this.f396949b;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f396949b;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar2 = aVarArr2[i3];
                if (aVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar2);
                }
                i3++;
            }
        }
        int i16 = this.f396950c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        boolean z16 = this.f396951d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        b bVar = this.f396952e;
        if (bVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, bVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a aVar = this.f396948a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        a[] aVarArr = this.f396949b;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                a[] aVarArr2 = this.f396949b;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar2 = aVarArr2[i3];
                if (aVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, aVar2);
                }
                i3++;
            }
        }
        int i16 = this.f396950c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        boolean z16 = this.f396951d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        b bVar = this.f396952e;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(8, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
