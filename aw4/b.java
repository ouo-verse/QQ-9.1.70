package aw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import hu4.f;
import java.io.IOException;
import pv4.t;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public f f27088a;

    /* renamed from: b, reason: collision with root package name */
    public t[] f27089b;

    /* renamed from: c, reason: collision with root package name */
    public long f27090c;

    /* renamed from: d, reason: collision with root package name */
    public c[] f27091d;

    /* renamed from: e, reason: collision with root package name */
    public iw4.f f27092e;

    /* renamed from: f, reason: collision with root package name */
    public String f27093f;

    /* renamed from: g, reason: collision with root package name */
    public int f27094g;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
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
                if (this.f27088a == null) {
                    this.f27088a = new f();
                }
                codedInputByteBufferNano.readMessage(this.f27088a);
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                t[] tVarArr = this.f27089b;
                int length = tVarArr == null ? 0 : tVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                t[] tVarArr2 = new t[i3];
                if (length != 0) {
                    System.arraycopy(tVarArr, 0, tVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    t tVar = new t();
                    tVarArr2[length] = tVar;
                    codedInputByteBufferNano.readMessage(tVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                t tVar2 = new t();
                tVarArr2[length] = tVar2;
                codedInputByteBufferNano.readMessage(tVar2);
                this.f27089b = tVarArr2;
            } else if (readTag == 24) {
                this.f27090c = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                c[] cVarArr = this.f27091d;
                int length2 = cVarArr == null ? 0 : cVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                c[] cVarArr2 = new c[i16];
                if (length2 != 0) {
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    c cVar = new c();
                    cVarArr2[length2] = cVar;
                    codedInputByteBufferNano.readMessage(cVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                c cVar2 = new c();
                cVarArr2[length2] = cVar2;
                codedInputByteBufferNano.readMessage(cVar2);
                this.f27091d = cVarArr2;
            } else if (readTag == 42) {
                if (this.f27092e == null) {
                    this.f27092e = new iw4.f();
                }
                codedInputByteBufferNano.readMessage(this.f27092e);
            } else if (readTag == 50) {
                this.f27093f = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f27094g = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        f fVar = this.f27088a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        t[] tVarArr = this.f27089b;
        int i3 = 0;
        if (tVarArr != null && tVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                t[] tVarArr2 = this.f27089b;
                if (i16 >= tVarArr2.length) {
                    break;
                }
                t tVar = tVarArr2[i16];
                if (tVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, tVar);
                }
                i16++;
            }
        }
        long j3 = this.f27090c;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        c[] cVarArr = this.f27091d;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f27091d;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, cVar);
                }
                i3++;
            }
        }
        iw4.f fVar2 = this.f27092e;
        if (fVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, fVar2);
        }
        if (!this.f27093f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f27093f);
        }
        int i17 = this.f27094g;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f fVar = this.f27088a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        t[] tVarArr = this.f27089b;
        int i3 = 0;
        if (tVarArr != null && tVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                t[] tVarArr2 = this.f27089b;
                if (i16 >= tVarArr2.length) {
                    break;
                }
                t tVar = tVarArr2[i16];
                if (tVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, tVar);
                }
                i16++;
            }
        }
        long j3 = this.f27090c;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        c[] cVarArr = this.f27091d;
        if (cVarArr != null && cVarArr.length > 0) {
            while (true) {
                c[] cVarArr2 = this.f27091d;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, cVar);
                }
                i3++;
            }
        }
        iw4.f fVar2 = this.f27092e;
        if (fVar2 != null) {
            codedOutputByteBufferNano.writeMessage(5, fVar2);
        }
        if (!this.f27093f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f27093f);
        }
        int i17 = this.f27094g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f27088a = null;
        this.f27089b = t.b();
        this.f27090c = 0L;
        this.f27091d = c.b();
        this.f27092e = null;
        this.f27093f = "";
        this.f27094g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
