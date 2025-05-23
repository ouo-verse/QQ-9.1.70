package hz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f406943a;

    /* renamed from: b, reason: collision with root package name */
    public long f406944b;

    /* renamed from: c, reason: collision with root package name */
    public String f406945c;

    /* renamed from: d, reason: collision with root package name */
    public String f406946d;

    /* renamed from: e, reason: collision with root package name */
    public String f406947e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f406948f;

    public a() {
        a();
    }

    public static a c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (a) MessageNano.mergeFrom(new a(), bArr);
    }

    public a a() {
        this.f406943a = 0L;
        this.f406944b = 0L;
        this.f406945c = "";
        this.f406946d = "";
        this.f406947e = "";
        this.f406948f = WireFormatNano.EMPTY_STRING_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                                        String[] strArr = this.f406948f;
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
                                        this.f406948f = strArr2;
                                    }
                                } else {
                                    this.f406947e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f406946d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f406945c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f406944b = codedInputByteBufferNano.readUInt64();
                    }
                } else {
                    this.f406943a = codedInputByteBufferNano.readUInt64();
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
        long j3 = this.f406943a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        long j16 = this.f406944b;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j16);
        }
        if (!this.f406945c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406945c);
        }
        if (!this.f406946d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406946d);
        }
        if (!this.f406947e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f406947e);
        }
        String[] strArr = this.f406948f;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f406948f;
                if (i3 < strArr2.length) {
                    String str = strArr2[i3];
                    if (str != null) {
                        i17++;
                        i16 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i3++;
                } else {
                    return computeSerializedSize + i16 + (i17 * 1);
                }
            }
        } else {
            return computeSerializedSize;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f406943a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        long j16 = this.f406944b;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j16);
        }
        if (!this.f406945c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406945c);
        }
        if (!this.f406946d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406946d);
        }
        if (!this.f406947e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f406947e);
        }
        String[] strArr = this.f406948f;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f406948f;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(6, str);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
