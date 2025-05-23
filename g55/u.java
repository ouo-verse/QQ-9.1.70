package g55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class u extends ExtendableMessageNano<u> {

    /* renamed from: a, reason: collision with root package name */
    public String f401394a;

    /* renamed from: b, reason: collision with root package name */
    public at[] f401395b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f401396c;

    /* renamed from: d, reason: collision with root package name */
    public int f401397d;

    /* renamed from: e, reason: collision with root package name */
    public String f401398e;

    public u() {
        a();
    }

    public static u c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (u) MessageNano.mergeFrom(new u(), bArr);
    }

    public u a() {
        this.f401394a = "";
        this.f401395b = at.b();
        this.f401396c = false;
        this.f401397d = 0;
        this.f401398e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f401398e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f401397d = codedInputByteBufferNano.readUInt32();
                            }
                        } else {
                            this.f401396c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        at[] atVarArr = this.f401395b;
                        if (atVarArr == null) {
                            length = 0;
                        } else {
                            length = atVarArr.length;
                        }
                        int i3 = repeatedFieldArrayLength + length;
                        at[] atVarArr2 = new at[i3];
                        if (length != 0) {
                            System.arraycopy(atVarArr, 0, atVarArr2, 0, length);
                        }
                        while (length < i3 - 1) {
                            at atVar = new at();
                            atVarArr2[length] = atVar;
                            codedInputByteBufferNano.readMessage(atVar);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        at atVar2 = new at();
                        atVarArr2[length] = atVar2;
                        codedInputByteBufferNano.readMessage(atVar2);
                        this.f401395b = atVarArr2;
                    }
                } else {
                    this.f401394a = codedInputByteBufferNano.readString();
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
        if (!this.f401394a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f401394a);
        }
        at[] atVarArr = this.f401395b;
        if (atVarArr != null && atVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                at[] atVarArr2 = this.f401395b;
                if (i3 >= atVarArr2.length) {
                    break;
                }
                at atVar = atVarArr2[i3];
                if (atVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, atVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f401396c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        int i16 = this.f401397d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.f401398e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f401398e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f401394a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f401394a);
        }
        at[] atVarArr = this.f401395b;
        if (atVarArr != null && atVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                at[] atVarArr2 = this.f401395b;
                if (i3 >= atVarArr2.length) {
                    break;
                }
                at atVar = atVarArr2[i3];
                if (atVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, atVar);
                }
                i3++;
            }
        }
        boolean z16 = this.f401396c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        int i16 = this.f401397d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.f401398e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f401398e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
