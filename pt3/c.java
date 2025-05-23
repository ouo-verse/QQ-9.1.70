package pt3;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public String f427120a;

    /* renamed from: b, reason: collision with root package name */
    public String f427121b;

    /* renamed from: c, reason: collision with root package name */
    public String f427122c;

    /* renamed from: d, reason: collision with root package name */
    public h f427123d;

    /* renamed from: e, reason: collision with root package name */
    public int f427124e;

    /* renamed from: f, reason: collision with root package name */
    public int f427125f;

    /* renamed from: g, reason: collision with root package name */
    public int f427126g;

    /* renamed from: h, reason: collision with root package name */
    public int f427127h;

    /* renamed from: i, reason: collision with root package name */
    public int f427128i;

    /* renamed from: j, reason: collision with root package name */
    public f[] f427129j;

    public c() {
        a();
    }

    public c a() {
        this.f427120a = "";
        this.f427121b = "";
        this.f427122c = "";
        this.f427123d = null;
        this.f427124e = 0;
        this.f427125f = 0;
        this.f427126g = 0;
        this.f427127h = 0;
        this.f427128i = 0;
        this.f427129j = f.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.f427120a = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.f427121b = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.f427122c = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    if (this.f427123d == null) {
                        this.f427123d = new h();
                    }
                    codedInputByteBufferNano.readMessage(this.f427123d);
                    break;
                case 40:
                    this.f427124e = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.f427125f = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.f427126g = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.f427127h = codedInputByteBufferNano.readInt32();
                    break;
                case 80:
                    this.f427128i = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    f[] fVarArr = this.f427129j;
                    if (fVarArr == null) {
                        length = 0;
                    } else {
                        length = fVarArr.length;
                    }
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
                    this.f427129j = fVarArr2;
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f427120a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f427120a);
        }
        if (!this.f427121b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f427121b);
        }
        if (!this.f427122c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f427122c);
        }
        h hVar = this.f427123d;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, hVar);
        }
        int i3 = this.f427124e;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.f427125f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        int i17 = this.f427126g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        int i18 = this.f427127h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i18);
        }
        int i19 = this.f427128i;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i19);
        }
        f[] fVarArr = this.f427129j;
        if (fVarArr != null && fVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                f[] fVarArr2 = this.f427129j;
                if (i26 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i26];
                if (fVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, fVar);
                }
                i26++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f427120a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f427120a);
        }
        if (!this.f427121b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f427121b);
        }
        if (!this.f427122c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f427122c);
        }
        h hVar = this.f427123d;
        if (hVar != null) {
            codedOutputByteBufferNano.writeMessage(4, hVar);
        }
        int i3 = this.f427124e;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.f427125f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        int i17 = this.f427126g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        int i18 = this.f427127h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i18);
        }
        int i19 = this.f427128i;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i19);
        }
        f[] fVarArr = this.f427129j;
        if (fVarArr != null && fVarArr.length > 0) {
            int i26 = 0;
            while (true) {
                f[] fVarArr2 = this.f427129j;
                if (i26 >= fVarArr2.length) {
                    break;
                }
                f fVar = fVarArr2[i26];
                if (fVar != null) {
                    codedOutputByteBufferNano.writeMessage(11, fVar);
                }
                i26++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
