package ow4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f424389a;

    /* renamed from: b, reason: collision with root package name */
    public e[] f424390b;

    /* renamed from: c, reason: collision with root package name */
    public a f424391c;

    /* renamed from: d, reason: collision with root package name */
    public String f424392d;

    /* renamed from: e, reason: collision with root package name */
    public String f424393e;

    public b() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.f424389a = readInt32;
                }
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                e[] eVarArr = this.f424390b;
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
                this.f424390b = eVarArr2;
            } else if (readTag == 26) {
                if (this.f424391c == null) {
                    this.f424391c = new a();
                }
                codedInputByteBufferNano.readMessage(this.f424391c);
            } else if (readTag == 34) {
                this.f424392d = codedInputByteBufferNano.readString();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f424393e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f424389a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        e[] eVarArr = this.f424390b;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f424390b;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, eVar);
                }
                i16++;
            }
        }
        a aVar = this.f424391c;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar);
        }
        if (!this.f424392d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f424392d);
        }
        return !this.f424393e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f424393e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f424389a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        e[] eVarArr = this.f424390b;
        if (eVarArr != null && eVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                e[] eVarArr2 = this.f424390b;
                if (i16 >= eVarArr2.length) {
                    break;
                }
                e eVar = eVarArr2[i16];
                if (eVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, eVar);
                }
                i16++;
            }
        }
        a aVar = this.f424391c;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar);
        }
        if (!this.f424392d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f424392d);
        }
        if (!this.f424393e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f424393e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f424389a = 0;
        this.f424390b = e.b();
        this.f424391c = null;
        this.f424392d = "";
        this.f424393e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
