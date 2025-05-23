package mu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String[] f417639a;

    /* renamed from: b, reason: collision with root package name */
    public String f417640b;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f417639a = WireFormatNano.EMPTY_STRING_ARRAY;
        this.f417640b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                String[] strArr = this.f417639a;
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
                this.f417639a = strArr2;
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f417640b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        String[] strArr = this.f417639a;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.f417639a;
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
        return !this.f417640b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.f417640b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        String[] strArr = this.f417639a;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f417639a;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(1, str);
                }
                i3++;
            }
        }
        if (!this.f417640b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f417640b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
