package pq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public String[] f427038a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f427039b;

    /* renamed from: c, reason: collision with root package name */
    public String f427040c;

    /* renamed from: d, reason: collision with root package name */
    public String f427041d;

    /* renamed from: e, reason: collision with root package name */
    public String f427042e;

    /* renamed from: f, reason: collision with root package name */
    public int f427043f;

    public e() {
        a();
    }

    public e a() {
        String[] strArr = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f427038a = strArr;
        this.f427039b = strArr;
        this.f427040c = "";
        this.f427041d = "";
        this.f427042e = "";
        this.f427043f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f427043f = codedInputByteBufferNano.readUInt32();
                                    }
                                } else {
                                    this.f427042e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f427041d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f427040c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        String[] strArr = this.f427039b;
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
                        this.f427039b = strArr2;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    String[] strArr3 = this.f427038a;
                    if (strArr3 == null) {
                        length2 = 0;
                    } else {
                        length2 = strArr3.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    String[] strArr4 = new String[i16];
                    if (length2 != 0) {
                        System.arraycopy(strArr3, 0, strArr4, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.f427038a = strArr4;
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
        String[] strArr = this.f427038a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f427038a;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    i18++;
                    i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i16++;
            }
            computeSerializedSize = computeSerializedSize + i17 + (i18 * 1);
        }
        String[] strArr3 = this.f427039b;
        if (strArr3 != null && strArr3.length > 0) {
            int i19 = 0;
            int i26 = 0;
            while (true) {
                String[] strArr4 = this.f427039b;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    i26++;
                    i19 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (i26 * 1);
        }
        if (!this.f427040c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427040c);
        }
        if (!this.f427041d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f427041d);
        }
        if (!this.f427042e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f427042e);
        }
        int i27 = this.f427043f;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        String[] strArr = this.f427038a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f427038a;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                i16++;
            }
        }
        String[] strArr3 = this.f427039b;
        if (strArr3 != null && strArr3.length > 0) {
            while (true) {
                String[] strArr4 = this.f427039b;
                if (i3 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i3];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(2, str2);
                }
                i3++;
            }
        }
        if (!this.f427040c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427040c);
        }
        if (!this.f427041d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f427041d);
        }
        if (!this.f427042e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f427042e);
        }
        int i17 = this.f427043f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
