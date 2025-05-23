package pt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: a, reason: collision with root package name */
    public v[] f427238a;

    /* renamed from: b, reason: collision with root package name */
    public int f427239b;

    /* renamed from: c, reason: collision with root package name */
    public int f427240c;

    /* renamed from: d, reason: collision with root package name */
    public int f427241d;

    public s() {
        a();
    }

    public s a() {
        this.f427238a = v.b();
        this.f427239b = 0;
        this.f427240c = 0;
        this.f427241d = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public s mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                v[] vVarArr = this.f427238a;
                int length = vVarArr == null ? 0 : vVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                v[] vVarArr2 = new v[i3];
                if (length != 0) {
                    System.arraycopy(vVarArr, 0, vVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    v vVar = new v();
                    vVarArr2[length] = vVar;
                    codedInputByteBufferNano.readMessage(vVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                v vVar2 = new v();
                vVarArr2[length] = vVar2;
                codedInputByteBufferNano.readMessage(vVar2);
                this.f427238a = vVarArr2;
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f427239b = readInt32;
                }
            } else if (readTag == 24) {
                this.f427240c = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f427241d = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        v[] vVarArr = this.f427238a;
        if (vVarArr != null && vVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                v[] vVarArr2 = this.f427238a;
                if (i3 >= vVarArr2.length) {
                    break;
                }
                v vVar = vVarArr2[i3];
                if (vVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, vVar);
                }
                i3++;
            }
        }
        int i16 = this.f427239b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f427240c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.f427241d;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        v[] vVarArr = this.f427238a;
        if (vVarArr != null && vVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                v[] vVarArr2 = this.f427238a;
                if (i3 >= vVarArr2.length) {
                    break;
                }
                v vVar = vVarArr2[i3];
                if (vVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, vVar);
                }
                i3++;
            }
        }
        int i16 = this.f427239b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f427240c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.f427241d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
