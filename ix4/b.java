package ix4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f408927a;

    /* renamed from: b, reason: collision with root package name */
    public e f408928b;

    /* renamed from: c, reason: collision with root package name */
    public d f408929c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f408930d;

    /* renamed from: e, reason: collision with root package name */
    public int f408931e;

    /* renamed from: f, reason: collision with root package name */
    public String f408932f;

    /* renamed from: g, reason: collision with root package name */
    public int f408933g;

    /* renamed from: h, reason: collision with root package name */
    public String f408934h;

    /* renamed from: i, reason: collision with root package name */
    public String f408935i;

    /* renamed from: j, reason: collision with root package name */
    public gx4.a f408936j;

    public b() {
        a();
    }

    public b a() {
        this.f408927a = 0;
        this.f408928b = null;
        this.f408929c = null;
        this.f408930d = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f408931e = 0;
        this.f408932f = "";
        this.f408933g = 0;
        this.f408934h = "";
        this.f408935i = "";
        this.f408936j = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.f408927a = codedInputByteBufferNano.readInt32();
                    break;
                case 18:
                    if (this.f408928b == null) {
                        this.f408928b = new e();
                    }
                    codedInputByteBufferNano.readMessage(this.f408928b);
                    break;
                case 26:
                    if (this.f408929c == null) {
                        this.f408929c = new d();
                    }
                    codedInputByteBufferNano.readMessage(this.f408929c);
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    String[] strArr = this.f408930d;
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
                    this.f408930d = strArr2;
                    break;
                case 40:
                    this.f408931e = codedInputByteBufferNano.readInt32();
                    break;
                case 50:
                    this.f408932f = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.f408933g = codedInputByteBufferNano.readInt32();
                    break;
                case 66:
                    this.f408934h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f408935i = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    if (this.f408936j == null) {
                        this.f408936j = new gx4.a();
                    }
                    codedInputByteBufferNano.readMessage(this.f408936j);
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
        int i3 = this.f408927a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        e eVar = this.f408928b;
        if (eVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
        }
        d dVar = this.f408929c;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, dVar);
        }
        String[] strArr = this.f408930d;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f408930d;
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
        int i19 = this.f408931e;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i19);
        }
        if (!this.f408932f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f408932f);
        }
        int i26 = this.f408933g;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i26);
        }
        if (!this.f408934h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f408934h);
        }
        if (!this.f408935i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f408935i);
        }
        gx4.a aVar = this.f408936j;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f408927a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        e eVar = this.f408928b;
        if (eVar != null) {
            codedOutputByteBufferNano.writeMessage(2, eVar);
        }
        d dVar = this.f408929c;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(3, dVar);
        }
        String[] strArr = this.f408930d;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f408930d;
                if (i16 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i16];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i16++;
            }
        }
        int i17 = this.f408931e;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i17);
        }
        if (!this.f408932f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f408932f);
        }
        int i18 = this.f408933g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i18);
        }
        if (!this.f408934h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f408934h);
        }
        if (!this.f408935i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f408935i);
        }
        gx4.a aVar = this.f408936j;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(10, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
