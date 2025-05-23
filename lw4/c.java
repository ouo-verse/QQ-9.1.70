package lw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f415698a;

    /* renamed from: b, reason: collision with root package name */
    public String f415699b;

    /* renamed from: c, reason: collision with root package name */
    public e[] f415700c;

    /* renamed from: d, reason: collision with root package name */
    public String f415701d;

    /* renamed from: e, reason: collision with root package name */
    public int f415702e;

    /* renamed from: f, reason: collision with root package name */
    public int f415703f;

    public c() {
        a();
    }

    public static c c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (c) MessageNano.mergeFrom(new c(), bArr);
    }

    public c a() {
        this.f415698a = "";
        this.f415699b = "";
        this.f415700c = e.b();
        this.f415701d = "";
        this.f415702e = 0;
        this.f415703f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f415698a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f415699b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                e[] eVarArr = this.f415700c;
                int length = eVarArr == null ? 0 : eVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                e[] eVarArr2 = new e[i3];
                if (length != 0) {
                    System.arraycopy(eVarArr, 0, eVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    e eVar = new e();
                    eVarArr2[length] = eVar;
                    codedInputByteBufferNano.readMessage(eVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                e eVar2 = new e();
                eVarArr2[length] = eVar2;
                codedInputByteBufferNano.readMessage(eVar2);
                this.f415700c = eVarArr2;
            } else if (readTag == 34) {
                this.f415701d = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.f415702e = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f415703f = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f415698a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f415698a);
        }
        if (!this.f415699b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f415699b);
        }
        e[] eVarArr = this.f415700c;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f415700c;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, eVar);
                }
                i3++;
            }
        }
        if (!this.f415701d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f415701d);
        }
        int i16 = this.f415702e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        int i17 = this.f415703f;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f415698a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f415698a);
        }
        if (!this.f415699b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f415699b);
        }
        e[] eVarArr = this.f415700c;
        if (eVarArr != null && eVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                e[] eVarArr2 = this.f415700c;
                if (i3 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i3];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, eVar);
                }
                i3++;
            }
        }
        if (!this.f415701d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f415701d);
        }
        int i16 = this.f415702e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        int i17 = this.f415703f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
