package pp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f426971a;

    /* renamed from: b, reason: collision with root package name */
    public String f426972b;

    /* renamed from: c, reason: collision with root package name */
    public String f426973c;

    /* renamed from: d, reason: collision with root package name */
    public String f426974d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f426975e;

    public c() {
        a();
    }

    public c a() {
        this.f426971a = 0;
        this.f426972b = "";
        this.f426973c = "";
        this.f426974d = "";
        this.f426975e = WireFormatNano.EMPTY_STRING_ARRAY;
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
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                                    String[] strArr = this.f426975e;
                                    if (strArr == null) {
                                        length = 0;
                                    } else {
                                        length = strArr.length;
                                    }
                                    int i3 = repeatedFieldArrayLength + length;
                                    String[] strArr2 = new String[i3];
                                    if (length != 0) {
                                        System.arraycopy(strArr, 0, strArr2, 0, length);
                                    }
                                    while (length < i3 - 1) {
                                        strArr2[length] = codedInputByteBufferNano.readString();
                                        codedInputByteBufferNano.readTag();
                                        length++;
                                    }
                                    strArr2[length] = codedInputByteBufferNano.readString();
                                    this.f426975e = strArr2;
                                }
                            } else {
                                this.f426974d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f426973c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f426972b = codedInputByteBufferNano.readString();
                    }
                } else {
                    this.f426971a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f426971a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f426972b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f426972b);
        }
        if (!this.f426973c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f426973c);
        }
        if (!this.f426974d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f426974d);
        }
        String[] strArr = this.f426975e;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f426975e;
                if (i16 < strArr2.length) {
                    String str = strArr2[i16];
                    if (str != null) {
                        i18++;
                        i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i16++;
                } else {
                    return computeSerializedSize + i17 + (i18 * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f426971a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f426972b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f426972b);
        }
        if (!this.f426973c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f426973c);
        }
        if (!this.f426974d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f426974d);
        }
        String[] strArr = this.f426975e;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f426975e;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(5, str);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
