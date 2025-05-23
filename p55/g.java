package p55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public int f425393a;

    /* renamed from: b, reason: collision with root package name */
    public int f425394b;

    /* renamed from: c, reason: collision with root package name */
    public int f425395c;

    /* renamed from: d, reason: collision with root package name */
    public int f425396d;

    /* renamed from: e, reason: collision with root package name */
    public String f425397e;

    /* renamed from: f, reason: collision with root package name */
    public f[] f425398f;

    public g() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f425393a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.f425394b = readInt32;
                }
            } else if (readTag == 24) {
                this.f425395c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f425396d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.f425397e = codedInputByteBufferNano.readString();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                f[] fVarArr = this.f425398f;
                int length = fVarArr == null ? 0 : fVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                f[] fVarArr2 = new f[i3];
                if (length != 0) {
                    System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    f fVar = new f();
                    fVarArr2[length] = fVar;
                    codedInputByteBufferNano.readMessage(fVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                f fVar2 = new f();
                fVarArr2[length] = fVar2;
                codedInputByteBufferNano.readMessage(fVar2);
                this.f425398f = fVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f425393a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f425394b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.f425395c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.f425396d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        if (!this.f425397e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f425397e);
        }
        f[] fVarArr = this.f425398f;
        if (fVarArr != null && fVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                f[] fVarArr2 = this.f425398f;
                if (i19 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i19];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, fVar);
                }
                i19++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f425393a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f425394b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.f425395c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.f425396d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        if (!this.f425397e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f425397e);
        }
        f[] fVarArr = this.f425398f;
        if (fVarArr != null && fVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                f[] fVarArr2 = this.f425398f;
                if (i19 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i19];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, fVar);
                }
                i19++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f425393a = 0;
        this.f425394b = 0;
        this.f425395c = 0;
        this.f425396d = 0;
        this.f425397e = "";
        this.f425398f = f.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
