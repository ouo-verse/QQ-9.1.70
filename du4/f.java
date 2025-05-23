package du4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile f[] f394972j;

    /* renamed from: a, reason: collision with root package name */
    public String[] f394973a;

    /* renamed from: b, reason: collision with root package name */
    public a f394974b;

    /* renamed from: c, reason: collision with root package name */
    public a f394975c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f394976d;

    /* renamed from: e, reason: collision with root package name */
    public String f394977e;

    /* renamed from: f, reason: collision with root package name */
    public int f394978f;

    /* renamed from: g, reason: collision with root package name */
    public int f394979g;

    /* renamed from: h, reason: collision with root package name */
    public String f394980h;

    /* renamed from: i, reason: collision with root package name */
    public String f394981i;

    public f() {
        a();
    }

    public static f[] b() {
        if (f394972j == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f394972j == null) {
                    f394972j = new f[0];
                }
            }
        }
        return f394972j;
    }

    public f a() {
        this.f394973a = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f394974b = null;
        this.f394975c = null;
        this.f394976d = WireFormatNano.EMPTY_INT_ARRAY;
        this.f394977e = "";
        this.f394978f = 0;
        this.f394979g = 0;
        this.f394980h = "";
        this.f394981i = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        int length3;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    String[] strArr = this.f394973a;
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
                    this.f394973a = strArr2;
                    break;
                case 18:
                    if (this.f394974b == null) {
                        this.f394974b = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f394974b);
                    break;
                case 26:
                    if (this.f394975c == null) {
                        this.f394975c = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f394975c);
                    break;
                case 32:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                    int[] iArr = new int[repeatedFieldArrayLength2];
                    int i16 = 0;
                    for (int i17 = 0; i17 < repeatedFieldArrayLength2; i17++) {
                        if (i17 != 0) {
                            codedInputByteBufferNano.readTag();
                        }
                        int readInt32 = codedInputByteBufferNano.readInt32();
                        if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                            iArr[i16] = readInt32;
                            i16++;
                        }
                    }
                    if (i16 == 0) {
                        break;
                    } else {
                        int[] iArr2 = this.f394976d;
                        if (iArr2 == null) {
                            length2 = 0;
                        } else {
                            length2 = iArr2.length;
                        }
                        if (length2 == 0 && i16 == repeatedFieldArrayLength2) {
                            this.f394976d = iArr;
                            break;
                        } else {
                            int[] iArr3 = new int[length2 + i16];
                            if (length2 != 0) {
                                System.arraycopy(iArr2, 0, iArr3, 0, length2);
                            }
                            System.arraycopy(iArr, 0, iArr3, length2, i16);
                            this.f394976d = iArr3;
                            break;
                        }
                    }
                case 34:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i18 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        int readInt322 = codedInputByteBufferNano.readInt32();
                        if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2 || readInt322 == 3) {
                            i18++;
                        }
                    }
                    if (i18 != 0) {
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr4 = this.f394976d;
                        if (iArr4 == null) {
                            length3 = 0;
                        } else {
                            length3 = iArr4.length;
                        }
                        int[] iArr5 = new int[i18 + length3];
                        if (length3 != 0) {
                            System.arraycopy(iArr4, 0, iArr5, 0, length3);
                        }
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            int readInt323 = codedInputByteBufferNano.readInt32();
                            if (readInt323 == 0 || readInt323 == 1 || readInt323 == 2 || readInt323 == 3) {
                                iArr5[length3] = readInt323;
                                length3++;
                            }
                        }
                        this.f394976d = iArr5;
                    }
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 42:
                    this.f394977e = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.f394978f = codedInputByteBufferNano.readInt32();
                    break;
                case 56:
                    this.f394979g = codedInputByteBufferNano.readInt32();
                    break;
                case 66:
                    this.f394980h = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.f394981i = codedInputByteBufferNano.readString();
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
        int[] iArr;
        int computeSerializedSize = super.computeSerializedSize();
        String[] strArr = this.f394973a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f394973a;
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
        a aVar = this.f394974b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        a aVar2 = this.f394975c;
        if (aVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar2);
        }
        int[] iArr2 = this.f394976d;
        if (iArr2 != null && iArr2.length > 0) {
            int i19 = 0;
            while (true) {
                iArr = this.f394976d;
                if (i3 >= iArr.length) {
                    break;
                }
                i19 += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            computeSerializedSize = computeSerializedSize + i19 + (iArr.length * 1);
        }
        if (!this.f394977e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f394977e);
        }
        int i26 = this.f394978f;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i26);
        }
        int i27 = this.f394979g;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i27);
        }
        if (!this.f394980h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f394980h);
        }
        if (!this.f394981i.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.f394981i);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        String[] strArr = this.f394973a;
        int i3 = 0;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f394973a;
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
        a aVar = this.f394974b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        a aVar2 = this.f394975c;
        if (aVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar2);
        }
        int[] iArr = this.f394976d;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.f394976d;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt32(4, iArr2[i3]);
                i3++;
            }
        }
        if (!this.f394977e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f394977e);
        }
        int i17 = this.f394978f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        int i18 = this.f394979g;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i18);
        }
        if (!this.f394980h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f394980h);
        }
        if (!this.f394981i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f394981i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
