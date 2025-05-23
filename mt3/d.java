package mt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public g[] f417548a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f417549b;

    public d() {
        a();
    }

    public static d c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (d) MessageNano.mergeFrom(new d(), bArr);
    }

    public d a() {
        this.f417548a = g.b();
        this.f417549b = WireFormatNano.EMPTY_STRING_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        int length2;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        String[] strArr = this.f417549b;
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
                        this.f417549b = strArr2;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    g[] gVarArr = this.f417548a;
                    if (gVarArr == null) {
                        length2 = 0;
                    } else {
                        length2 = gVarArr.length;
                    }
                    int i16 = repeatedFieldArrayLength2 + length2;
                    g[] gVarArr2 = new g[i16];
                    if (length2 != 0) {
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        g gVar = new g();
                        gVarArr2[length2] = gVar;
                        codedInputByteBufferNano.readMessage(gVar);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    g gVar2 = new g();
                    gVarArr2[length2] = gVar2;
                    codedInputByteBufferNano.readMessage(gVar2);
                    this.f417548a = gVarArr2;
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
        g[] gVarArr = this.f417548a;
        int i3 = 0;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f417548a;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i16];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
                }
                i16++;
            }
        }
        String[] strArr = this.f417549b;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            int i18 = 0;
            while (true) {
                String[] strArr2 = this.f417549b;
                if (i3 < strArr2.length) {
                    String str = strArr2[i3];
                    if (str != null) {
                        i18++;
                        i17 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i3++;
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
        g[] gVarArr = this.f417548a;
        int i3 = 0;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f417548a;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i16];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, gVar);
                }
                i16++;
            }
        }
        String[] strArr = this.f417549b;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.f417549b;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
