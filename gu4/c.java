package gu4;

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
    public int f403381a;

    /* renamed from: b, reason: collision with root package name */
    public String f403382b;

    /* renamed from: c, reason: collision with root package name */
    public k[] f403383c;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f403381a = 0;
        this.f403382b = "";
        this.f403383c = k.b();
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
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                            k[] kVarArr = this.f403383c;
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
                            this.f403383c = kVarArr2;
                        }
                    } else {
                        this.f403382b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f403381a = codedInputByteBufferNano.readInt32();
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
        int i3 = this.f403381a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f403382b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403382b);
        }
        k[] kVarArr = this.f403383c;
        if (kVarArr != null && kVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                k[] kVarArr2 = this.f403383c;
                if (i16 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i16];
                if (kVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, kVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403381a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f403382b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403382b);
        }
        k[] kVarArr = this.f403383c;
        if (kVarArr != null && kVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                k[] kVarArr2 = this.f403383c;
                if (i16 >= kVarArr2.length) {
                    break;
                }
                k kVar = kVarArr2[i16];
                if (kVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, kVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
