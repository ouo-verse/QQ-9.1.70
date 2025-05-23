package ot4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import hs4.k;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public String f424044a;

    /* renamed from: b, reason: collision with root package name */
    public String f424045b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f424046c;

    /* renamed from: d, reason: collision with root package name */
    public String f424047d;

    /* renamed from: e, reason: collision with root package name */
    public int f424048e;

    /* renamed from: f, reason: collision with root package name */
    public int f424049f;

    /* renamed from: g, reason: collision with root package name */
    public k f424050g;

    /* renamed from: h, reason: collision with root package name */
    public k[] f424051h;

    public b() {
        a();
    }

    public b a() {
        this.f424044a = "";
        this.f424045b = "";
        this.f424046c = false;
        this.f424047d = "";
        this.f424048e = 0;
        this.f424049f = 0;
        this.f424050g = null;
        this.f424051h = k.b();
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
                this.f424044a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f424045b = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.f424046c = codedInputByteBufferNano.readBool();
            } else if (readTag == 34) {
                this.f424047d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f424048e = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.f424049f = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 58) {
                if (this.f424050g == null) {
                    this.f424050g = new k();
                }
                codedInputByteBufferNano.readMessage(this.f424050g);
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                k[] kVarArr = this.f424051h;
                int length = kVarArr == null ? 0 : kVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                k[] kVarArr2 = new k[i3];
                if (length != 0) {
                    System.arraycopy(kVarArr, 0, kVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    k kVar = new k();
                    kVarArr2[length] = kVar;
                    codedInputByteBufferNano.readMessage(kVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                k kVar2 = new k();
                kVarArr2[length] = kVar2;
                codedInputByteBufferNano.readMessage(kVar2);
                this.f424051h = kVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f424044a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f424044a);
        }
        if (!this.f424045b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f424045b);
        }
        boolean z16 = this.f424046c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        if (!this.f424047d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f424047d);
        }
        int i3 = this.f424048e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.f424049f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        k kVar = this.f424050g;
        if (kVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, kVar);
        }
        k[] kVarArr = this.f424051h;
        if (kVarArr != null && kVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                k[] kVarArr2 = this.f424051h;
                if (i17 >= kVarArr2.length) {
                    break;
                }
                k kVar2 = kVarArr2[i17];
                if (kVar2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, kVar2);
                }
                i17++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f424044a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f424044a);
        }
        if (!this.f424045b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f424045b);
        }
        boolean z16 = this.f424046c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        if (!this.f424047d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f424047d);
        }
        int i3 = this.f424048e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.f424049f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        k kVar = this.f424050g;
        if (kVar != null) {
            codedOutputByteBufferNano.writeMessage(7, kVar);
        }
        k[] kVarArr = this.f424051h;
        if (kVarArr != null && kVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                k[] kVarArr2 = this.f424051h;
                if (i17 >= kVarArr2.length) {
                    break;
                }
                k kVar2 = kVarArr2[i17];
                if (kVar2 != null) {
                    codedOutputByteBufferNano.writeMessage(8, kVar2);
                }
                i17++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
