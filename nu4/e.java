package nu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f421355a;

    /* renamed from: b, reason: collision with root package name */
    public String f421356b;

    /* renamed from: c, reason: collision with root package name */
    public g[] f421357c;

    /* renamed from: d, reason: collision with root package name */
    public a[] f421358d;

    /* renamed from: e, reason: collision with root package name */
    public f f421359e;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) MessageNano.mergeFrom(new e(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f421355a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                this.f421356b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                g[] gVarArr = this.f421357c;
                int length = gVarArr == null ? 0 : gVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                g[] gVarArr2 = new g[i3];
                if (length != 0) {
                    System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    g gVar = new g();
                    gVarArr2[length] = gVar;
                    codedInputByteBufferNano.readMessage(gVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                g gVar2 = new g();
                gVarArr2[length] = gVar2;
                codedInputByteBufferNano.readMessage(gVar2);
                this.f421357c = gVarArr2;
            } else if (readTag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                a[] aVarArr = this.f421358d;
                int length2 = aVarArr == null ? 0 : aVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                a[] aVarArr2 = new a[i16];
                if (length2 != 0) {
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    a aVar = new a();
                    aVarArr2[length2] = aVar;
                    codedInputByteBufferNano.readMessage(aVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                a aVar2 = new a();
                aVarArr2[length2] = aVar2;
                codedInputByteBufferNano.readMessage(aVar2);
                this.f421358d = aVarArr2;
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.f421359e == null) {
                    this.f421359e = new f();
                }
                codedInputByteBufferNano.readMessage(this.f421359e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f421355a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!this.f421356b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421356b);
        }
        g[] gVarArr = this.f421357c;
        int i3 = 0;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f421357c;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i16];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, gVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f421358d;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f421358d;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
                }
                i3++;
            }
        }
        f fVar = this.f421359e;
        return fVar != null ? computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, fVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f421355a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!this.f421356b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421356b);
        }
        g[] gVarArr = this.f421357c;
        int i3 = 0;
        if (gVarArr != null && gVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                g[] gVarArr2 = this.f421357c;
                if (i16 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i16];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, gVar);
                }
                i16++;
            }
        }
        a[] aVarArr = this.f421358d;
        if (aVarArr != null && aVarArr.length > 0) {
            while (true) {
                a[] aVarArr2 = this.f421358d;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, aVar);
                }
                i3++;
            }
        }
        f fVar = this.f421359e;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(5, fVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public e a() {
        this.f421355a = false;
        this.f421356b = "";
        this.f421357c = g.b();
        this.f421358d = a.b();
        this.f421359e = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
