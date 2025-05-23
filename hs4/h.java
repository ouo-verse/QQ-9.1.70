package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public p[] f406145a;

    /* renamed from: b, reason: collision with root package name */
    public g[] f406146b;

    /* renamed from: c, reason: collision with root package name */
    public String[] f406147c;

    public h() {
        a();
    }

    public h a() {
        this.f406145a = p.b();
        this.f406146b = g.b();
        this.f406147c = WireFormatNano.EMPTY_STRING_ARRAY;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                p[] pVarArr = this.f406145a;
                int length = pVarArr == null ? 0 : pVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                p[] pVarArr2 = new p[i3];
                if (length != 0) {
                    System.arraycopy(pVarArr, 0, pVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    p pVar = new p();
                    pVarArr2[length] = pVar;
                    codedInputByteBufferNano.readMessage(pVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                p pVar2 = new p();
                pVarArr2[length] = pVar2;
                codedInputByteBufferNano.readMessage(pVar2);
                this.f406145a = pVarArr2;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                g[] gVarArr = this.f406146b;
                int length2 = gVarArr == null ? 0 : gVarArr.length;
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
                this.f406146b = gVarArr2;
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                String[] strArr = this.f406147c;
                int length3 = strArr == null ? 0 : strArr.length;
                int i17 = repeatedFieldArrayLength3 + length3;
                String[] strArr2 = new String[i17];
                if (length3 != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length3);
                }
                while (length3 < i17 - 1) {
                    strArr2[length3] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                strArr2[length3] = codedInputByteBufferNano.readString();
                this.f406147c = strArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        p[] pVarArr = this.f406145a;
        int i3 = 0;
        if (pVarArr != null && pVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                p[] pVarArr2 = this.f406145a;
                if (i16 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i16];
                if (pVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, pVar);
                }
                i16++;
            }
        }
        g[] gVarArr = this.f406146b;
        if (gVarArr != null && gVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                g[] gVarArr2 = this.f406146b;
                if (i17 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i17];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
                }
                i17++;
            }
        }
        String[] strArr = this.f406147c;
        if (strArr == null || strArr.length <= 0) {
            return computeSerializedSize;
        }
        int i18 = 0;
        int i19 = 0;
        while (true) {
            String[] strArr2 = this.f406147c;
            if (i3 >= strArr2.length) {
                return computeSerializedSize + i18 + (i19 * 1);
            }
            String str = strArr2[i3];
            if (str != null) {
                i19++;
                i18 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
            }
            i3++;
        }
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        p[] pVarArr = this.f406145a;
        int i3 = 0;
        if (pVarArr != null && pVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                p[] pVarArr2 = this.f406145a;
                if (i16 >= pVarArr2.length) {
                    break;
                }
                p pVar = pVarArr2[i16];
                if (pVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, pVar);
                }
                i16++;
            }
        }
        g[] gVarArr = this.f406146b;
        if (gVarArr != null && gVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                g[] gVarArr2 = this.f406146b;
                if (i17 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i17];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, gVar);
                }
                i17++;
            }
        }
        String[] strArr = this.f406147c;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.f406147c;
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
