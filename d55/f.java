package d55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public String f393069a;

    /* renamed from: b, reason: collision with root package name */
    public String f393070b;

    /* renamed from: c, reason: collision with root package name */
    public k[] f393071c;

    public f() {
        a();
    }

    public f a() {
        this.f393069a = "";
        this.f393070b = "";
        this.f393071c = k.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 42) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                            k[] kVarArr = this.f393071c;
                            if (kVarArr == null) {
                                length = 0;
                            } else {
                                length = kVarArr.length;
                            }
                            int i3 = repeatedFieldArrayLength + length;
                            k[] kVarArr2 = new k[i3];
                            if (length != 0) {
                                System.arraycopy(kVarArr, 0, kVarArr2, 0, length);
                            }
                            while (length < i3 - 1) {
                                k kVar = new k();
                                kVarArr2[length] = kVar;
                                codedInputByteBufferNano.readMessage(kVar);
                                codedInputByteBufferNano.readTag();
                                length++;
                            }
                            k kVar2 = new k();
                            kVarArr2[length] = kVar2;
                            codedInputByteBufferNano.readMessage(kVar2);
                            this.f393071c = kVarArr2;
                        }
                    } else {
                        this.f393070b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f393069a = codedInputByteBufferNano.readString();
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
        if (!this.f393069a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f393069a);
        }
        if (!this.f393070b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f393070b);
        }
        k[] kVarArr = this.f393071c;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f393071c;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, kVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f393069a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f393069a);
        }
        if (!this.f393070b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f393070b);
        }
        k[] kVarArr = this.f393071c;
        if (kVarArr != null && kVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                k[] kVarArr2 = this.f393071c;
                if (i3 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i3];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, kVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
