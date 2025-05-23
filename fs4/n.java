package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public long f400542a;

    /* renamed from: b, reason: collision with root package name */
    public q[] f400543b;

    /* renamed from: c, reason: collision with root package name */
    public t[] f400544c;

    /* renamed from: d, reason: collision with root package name */
    public r[] f400545d;

    /* renamed from: e, reason: collision with root package name */
    public s f400546e;

    /* renamed from: f, reason: collision with root package name */
    public int f400547f;

    /* renamed from: g, reason: collision with root package name */
    public int f400548g;

    /* renamed from: h, reason: collision with root package name */
    public l[] f400549h;

    public n() {
        a();
    }

    public static n c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (n) MessageNano.mergeFrom(new n(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f400542a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                q[] qVarArr = this.f400543b;
                int length = qVarArr == null ? 0 : qVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                q[] qVarArr2 = new q[i3];
                if (length != 0) {
                    System.arraycopy(qVarArr, 0, qVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    q qVar = new q();
                    qVarArr2[length] = qVar;
                    codedInputByteBufferNano.readMessage(qVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                q qVar2 = new q();
                qVarArr2[length] = qVar2;
                codedInputByteBufferNano.readMessage(qVar2);
                this.f400543b = qVarArr2;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                t[] tVarArr = this.f400544c;
                int length2 = tVarArr == null ? 0 : tVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                t[] tVarArr2 = new t[i16];
                if (length2 != 0) {
                    System.arraycopy(tVarArr, 0, tVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    t tVar = new t();
                    tVarArr2[length2] = tVar;
                    codedInputByteBufferNano.readMessage(tVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                t tVar2 = new t();
                tVarArr2[length2] = tVar2;
                codedInputByteBufferNano.readMessage(tVar2);
                this.f400544c = tVarArr2;
            } else if (readTag == 34) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                r[] rVarArr = this.f400545d;
                int length3 = rVarArr == null ? 0 : rVarArr.length;
                int i17 = repeatedFieldArrayLength3 + length3;
                r[] rVarArr2 = new r[i17];
                if (length3 != 0) {
                    System.arraycopy(rVarArr, 0, rVarArr2, 0, length3);
                }
                while (length3 < i17 - 1) {
                    r rVar = new r();
                    rVarArr2[length3] = rVar;
                    codedInputByteBufferNano.readMessage(rVar);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                r rVar2 = new r();
                rVarArr2[length3] = rVar2;
                codedInputByteBufferNano.readMessage(rVar2);
                this.f400545d = rVarArr2;
            } else if (readTag == 42) {
                if (this.f400546e == null) {
                    this.f400546e = new s();
                }
                codedInputByteBufferNano.readMessage(this.f400546e);
            } else if (readTag == 48) {
                this.f400547f = codedInputByteBufferNano.readInt32();
            } else if (readTag == 56) {
                this.f400548g = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                l[] lVarArr = this.f400549h;
                int length4 = lVarArr == null ? 0 : lVarArr.length;
                int i18 = repeatedFieldArrayLength4 + length4;
                l[] lVarArr2 = new l[i18];
                if (length4 != 0) {
                    System.arraycopy(lVarArr, 0, lVarArr2, 0, length4);
                }
                while (length4 < i18 - 1) {
                    l lVar = new l();
                    lVarArr2[length4] = lVar;
                    codedInputByteBufferNano.readMessage(lVar);
                    codedInputByteBufferNano.readTag();
                    length4++;
                }
                l lVar2 = new l();
                lVarArr2[length4] = lVar2;
                codedInputByteBufferNano.readMessage(lVar2);
                this.f400549h = lVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f400542a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        q[] qVarArr = this.f400543b;
        int i3 = 0;
        if (qVarArr != null && qVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                q[] qVarArr2 = this.f400543b;
                if (i16 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i16];
                if (qVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, qVar);
                }
                i16++;
            }
        }
        t[] tVarArr = this.f400544c;
        if (tVarArr != null && tVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                t[] tVarArr2 = this.f400544c;
                if (i17 >= tVarArr2.length) {
                    break;
                }
                t tVar = tVarArr2[i17];
                if (tVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, tVar);
                }
                i17++;
            }
        }
        r[] rVarArr = this.f400545d;
        if (rVarArr != null && rVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                r[] rVarArr2 = this.f400545d;
                if (i18 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i18];
                if (rVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, rVar);
                }
                i18++;
            }
        }
        s sVar = this.f400546e;
        if (sVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, sVar);
        }
        int i19 = this.f400547f;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i19);
        }
        int i26 = this.f400548g;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i26);
        }
        l[] lVarArr = this.f400549h;
        if (lVarArr != null && lVarArr.length > 0) {
            while (true) {
                l[] lVarArr2 = this.f400549h;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, lVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f400542a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        q[] qVarArr = this.f400543b;
        int i3 = 0;
        if (qVarArr != null && qVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                q[] qVarArr2 = this.f400543b;
                if (i16 >= qVarArr2.length) {
                    break;
                }
                q qVar = qVarArr2[i16];
                if (qVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, qVar);
                }
                i16++;
            }
        }
        t[] tVarArr = this.f400544c;
        if (tVarArr != null && tVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                t[] tVarArr2 = this.f400544c;
                if (i17 >= tVarArr2.length) {
                    break;
                }
                t tVar = tVarArr2[i17];
                if (tVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, tVar);
                }
                i17++;
            }
        }
        r[] rVarArr = this.f400545d;
        if (rVarArr != null && rVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                r[] rVarArr2 = this.f400545d;
                if (i18 >= rVarArr2.length) {
                    break;
                }
                r rVar = rVarArr2[i18];
                if (rVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, rVar);
                }
                i18++;
            }
        }
        s sVar = this.f400546e;
        if (sVar != null) {
            codedOutputByteBufferNano.writeMessage(5, sVar);
        }
        int i19 = this.f400547f;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i19);
        }
        int i26 = this.f400548g;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i26);
        }
        l[] lVarArr = this.f400549h;
        if (lVarArr != null && lVarArr.length > 0) {
            while (true) {
                l[] lVarArr2 = this.f400549h;
                if (i3 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i3];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(8, lVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f400542a = 0L;
        this.f400543b = q.b();
        this.f400544c = t.b();
        this.f400545d = r.b();
        this.f400546e = null;
        this.f400547f = 0;
        this.f400548g = 0;
        this.f400549h = l.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
