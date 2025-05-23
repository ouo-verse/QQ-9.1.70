package d55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f393066a;

    /* renamed from: b, reason: collision with root package name */
    public String f393067b;

    /* renamed from: c, reason: collision with root package name */
    public h[] f393068c;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    public e a() {
        this.f393066a = false;
        this.f393067b = "";
        this.f393068c = h.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            h[] hVarArr = this.f393068c;
                            if (hVarArr == null) {
                                length = 0;
                            } else {
                                length = hVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            h[] hVarArr2 = new h[i3];
                            if (length != 0) {
                                System.arraycopy(hVarArr, 0, hVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                h hVar = new h();
                                hVarArr2[length] = hVar;
                                codedInputByteBufferNano.readMessage(hVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            h hVar2 = new h();
                            hVarArr2[length] = hVar2;
                            codedInputByteBufferNano.readMessage(hVar2);
                            this.f393068c = hVarArr2;
                        }
                    } else {
                        this.f393067b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f393066a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f393066a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!this.f393067b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f393067b);
        }
        h[] hVarArr = this.f393068c;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f393068c;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, hVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f393066a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!this.f393067b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f393067b);
        }
        h[] hVarArr = this.f393068c;
        if (hVarArr != null && hVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                h[] hVarArr2 = this.f393068c;
                if (i3 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i3];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, hVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
