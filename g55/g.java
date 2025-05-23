package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public e f401364a;

    /* renamed from: b, reason: collision with root package name */
    public bc[] f401365b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f401366c;

    /* renamed from: d, reason: collision with root package name */
    public int f401367d;

    public g() {
        a();
    }

    public g a() {
        this.f401364a = null;
        this.f401365b = bc.b();
        this.f401366c = false;
        this.f401367d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f401367d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f401366c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        bc[] bcVarArr = this.f401365b;
                        if (bcVarArr == null) {
                            length = 0;
                        } else {
                            length = bcVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        bc[] bcVarArr2 = new bc[i3];
                        if (length != 0) {
                            System.arraycopy(bcVarArr, 0, bcVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            bc bcVar = new bc();
                            bcVarArr2[length] = bcVar;
                            codedInputByteBufferNano.readMessage(bcVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        bc bcVar2 = new bc();
                        bcVarArr2[length] = bcVar2;
                        codedInputByteBufferNano.readMessage(bcVar2);
                        this.f401365b = bcVarArr2;
                    }
                } else {
                    if (this.f401364a == null) {
                        this.f401364a = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f401364a);
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
        e eVar = this.f401364a;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, eVar);
        }
        bc[] bcVarArr = this.f401365b;
        if (bcVarArr != null && bcVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bc[] bcVarArr2 = this.f401365b;
                if (i3 >= bcVarArr2.length) {
                    break;
                }
                bc bcVar = bcVarArr2[i3];
                if (bcVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bcVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f401366c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        int i16 = this.f401367d;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        e eVar = this.f401364a;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(1, eVar);
        }
        bc[] bcVarArr = this.f401365b;
        if (bcVarArr != null && bcVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                bc[] bcVarArr2 = this.f401365b;
                if (i3 >= bcVarArr2.length) {
                    break;
                }
                bc bcVar = bcVarArr2[i3];
                if (bcVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, bcVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f401366c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        int i16 = this.f401367d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
