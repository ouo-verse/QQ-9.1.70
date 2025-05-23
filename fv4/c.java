package fv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class c extends ExtendableMessageNano<c> {

    /* renamed from: a, reason: collision with root package name */
    public int f400855a;

    /* renamed from: b, reason: collision with root package name */
    public long f400856b;

    /* renamed from: c, reason: collision with root package name */
    public String f400857c;

    /* renamed from: d, reason: collision with root package name */
    public long f400858d;

    /* renamed from: e, reason: collision with root package name */
    public long f400859e;

    /* renamed from: f, reason: collision with root package name */
    public int f400860f;

    /* renamed from: g, reason: collision with root package name */
    public int f400861g;

    /* renamed from: h, reason: collision with root package name */
    public int f400862h;

    /* renamed from: i, reason: collision with root package name */
    public String f400863i;

    /* renamed from: j, reason: collision with root package name */
    public int f400864j;

    /* renamed from: k, reason: collision with root package name */
    public String f400865k;

    public c() {
        a();
    }

    public c a() {
        this.f400855a = 0;
        this.f400856b = 0L;
        this.f400857c = "";
        this.f400858d = 0L;
        this.f400859e = 0L;
        this.f400860f = 0;
        this.f400861g = 0;
        this.f400862h = 0;
        this.f400863i = "";
        this.f400864j = 0;
        this.f400865k = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 200 && readInt32 != 201) {
                        switch (readInt32) {
                        }
                    }
                    this.f400855a = readInt32;
                    break;
                case 16:
                    this.f400856b = codedInputByteBufferNano.readUInt64();
                    break;
                case 26:
                    this.f400857c = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.f400858d = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.f400859e = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 != 0 && readInt322 != 1 && readInt322 != 2 && readInt322 != 3 && readInt322 != 4 && readInt322 != 6 && readInt322 != 7) {
                        break;
                    } else {
                        this.f400860f = readInt322;
                        break;
                    }
                case 56:
                    int readInt323 = codedInputByteBufferNano.readInt32();
                    if (readInt323 != 0 && readInt323 != 1 && readInt323 != 2) {
                        break;
                    } else {
                        this.f400861g = readInt323;
                        break;
                    }
                case 64:
                    int readInt324 = codedInputByteBufferNano.readInt32();
                    if (readInt324 != 0 && readInt324 != 1 && readInt324 != 2 && readInt324 != 3) {
                        break;
                    } else {
                        this.f400862h = readInt324;
                        break;
                    }
                case 74:
                    this.f400863i = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    int readInt325 = codedInputByteBufferNano.readInt32();
                    if (readInt325 != 0 && readInt325 != 109 && readInt325 != 110 && readInt325 != 112 && readInt325 != 113) {
                        break;
                    } else {
                        this.f400864j = readInt325;
                        break;
                    }
                case 90:
                    this.f400865k = codedInputByteBufferNano.readString();
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
        int i3 = this.f400855a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f400856b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.f400857c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f400857c);
        }
        long j16 = this.f400858d;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        long j17 = this.f400859e;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j17);
        }
        int i16 = this.f400860f;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        int i17 = this.f400861g;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i17);
        }
        int i18 = this.f400862h;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i18);
        }
        if (!this.f400863i.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.f400863i);
        }
        int i19 = this.f400864j;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i19);
        }
        if (!this.f400865k.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.f400865k);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f400855a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f400856b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.f400857c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400857c);
        }
        long j16 = this.f400858d;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        long j17 = this.f400859e;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j17);
        }
        int i16 = this.f400860f;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        int i17 = this.f400861g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        int i18 = this.f400862h;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i18);
        }
        if (!this.f400863i.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.f400863i);
        }
        int i19 = this.f400864j;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i19);
        }
        if (!this.f400865k.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.f400865k);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
