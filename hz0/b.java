package hz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f406949a;

    /* renamed from: b, reason: collision with root package name */
    public long f406950b;

    /* renamed from: c, reason: collision with root package name */
    public int f406951c;

    /* renamed from: d, reason: collision with root package name */
    public String[] f406952d;

    /* renamed from: e, reason: collision with root package name */
    public String f406953e;

    /* renamed from: f, reason: collision with root package name */
    public long f406954f;

    public b() {
        a();
    }

    public b a() {
        this.f406949a = false;
        this.f406950b = 0L;
        this.f406951c = 0;
        this.f406952d = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f406953e = "";
        this.f406954f = 0L;
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
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 48) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f406954f = codedInputByteBufferNano.readUInt64();
                                    }
                                } else {
                                    this.f406953e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                                String[] strArr = this.f406952d;
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
                                this.f406952d = strArr2;
                            }
                        } else {
                            this.f406951c = codedInputByteBufferNano.readInt32();
                        }
                    } else {
                        this.f406950b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f406949a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f406949a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        long j3 = this.f406950b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.f406951c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        String[] strArr = this.f406952d;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f406952d;
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
        if (!this.f406953e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f406953e);
        }
        long j16 = this.f406954f;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f406949a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        long j3 = this.f406950b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.f406951c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        String[] strArr = this.f406952d;
        if (strArr != null && strArr.length > 0) {
            int i16 = 0;
            while (true) {
                String[] strArr2 = this.f406952d;
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
        if (!this.f406953e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f406953e);
        }
        long j16 = this.f406954f;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
