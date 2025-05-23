package ov4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class q extends ExtendableMessageNano<q> {

    /* renamed from: a, reason: collision with root package name */
    public String f424196a;

    /* renamed from: b, reason: collision with root package name */
    public String f424197b;

    /* renamed from: c, reason: collision with root package name */
    public String f424198c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f424199d;

    /* renamed from: e, reason: collision with root package name */
    public String f424200e;

    /* renamed from: f, reason: collision with root package name */
    public String f424201f;

    /* renamed from: g, reason: collision with root package name */
    public String f424202g;

    /* renamed from: h, reason: collision with root package name */
    public int f424203h;

    /* renamed from: i, reason: collision with root package name */
    public int f424204i;

    /* renamed from: j, reason: collision with root package name */
    public String f424205j;

    public q() {
        a();
    }

    public q a() {
        this.f424196a = "";
        this.f424197b = "";
        this.f424198c = "";
        this.f424199d = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f424200e = "";
        this.f424201f = "";
        this.f424202g = "";
        this.f424203h = 0;
        this.f424204i = 0;
        this.f424205j = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f424196a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f424197b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f424198c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    String[] strArr = this.f424199d;
                    int length = strArr == null ? 0 : strArr.length;
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
                    this.f424199d = strArr2;
                    break;
                case 42:
                    this.f424200e = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f424201f = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.f424202g = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.f424203h = codedInputByteBufferNano.readInt32();
                    break;
                case 72:
                    this.f424204i = codedInputByteBufferNano.readInt32();
                    break;
                case 82:
                    this.f424205j = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f424196a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f424196a);
        }
        if (!this.f424197b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424197b);
        }
        if (!this.f424198c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f424198c);
        }
        String[] strArr = this.f424199d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f424199d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i17++;
                    i16 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i16 + (i17 * 1);
        }
        if (!this.f424200e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f424200e);
        }
        if (!this.f424201f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f424201f);
        }
        if (!this.f424202g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f424202g);
        }
        int i18 = this.f424203h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i18);
        }
        int i19 = this.f424204i;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i19);
        }
        return !this.f424205j.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.f424205j) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f424196a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f424196a);
        }
        if (!this.f424197b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424197b);
        }
        if (!this.f424198c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f424198c);
        }
        String[] strArr = this.f424199d;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f424199d;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i3++;
            }
        }
        if (!this.f424200e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f424200e);
        }
        if (!this.f424201f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f424201f);
        }
        if (!this.f424202g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f424202g);
        }
        int i16 = this.f424203h;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i16);
        }
        int i17 = this.f424204i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i17);
        }
        if (!this.f424205j.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.f424205j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
