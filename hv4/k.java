package hv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f406440a;

    /* renamed from: b, reason: collision with root package name */
    public qu4.s[] f406441b;

    /* renamed from: c, reason: collision with root package name */
    public l[] f406442c;

    /* renamed from: d, reason: collision with root package name */
    public h[] f406443d;

    /* renamed from: e, reason: collision with root package name */
    public q f406444e;

    /* renamed from: f, reason: collision with root package name */
    public m[] f406445f;

    public k() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f406440a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                qu4.s[] sVarArr = this.f406441b;
                int length = sVarArr == null ? 0 : sVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                qu4.s[] sVarArr2 = new qu4.s[i3];
                if (length != 0) {
                    System.arraycopy(sVarArr, 0, sVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    qu4.s sVar = new qu4.s();
                    sVarArr2[length] = sVar;
                    codedInputByteBufferNano.readMessage(sVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                qu4.s sVar2 = new qu4.s();
                sVarArr2[length] = sVar2;
                codedInputByteBufferNano.readMessage(sVar2);
                this.f406441b = sVarArr2;
            } else if (readTag == 26) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                l[] lVarArr = this.f406442c;
                int length2 = lVarArr == null ? 0 : lVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                l[] lVarArr2 = new l[i16];
                if (length2 != 0) {
                    System.arraycopy(lVarArr, 0, lVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    l lVar = new l();
                    lVarArr2[length2] = lVar;
                    codedInputByteBufferNano.readMessage(lVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                l lVar2 = new l();
                lVarArr2[length2] = lVar2;
                codedInputByteBufferNano.readMessage(lVar2);
                this.f406442c = lVarArr2;
            } else if (readTag == 34) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                h[] hVarArr = this.f406443d;
                int length3 = hVarArr == null ? 0 : hVarArr.length;
                int i17 = repeatedFieldArrayLength3 + length3;
                h[] hVarArr2 = new h[i17];
                if (length3 != 0) {
                    System.arraycopy(hVarArr, 0, hVarArr2, 0, length3);
                }
                while (length3 < i17 - 1) {
                    h hVar = new h();
                    hVarArr2[length3] = hVar;
                    codedInputByteBufferNano.readMessage(hVar);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                h hVar2 = new h();
                hVarArr2[length3] = hVar2;
                codedInputByteBufferNano.readMessage(hVar2);
                this.f406443d = hVarArr2;
            } else if (readTag == 42) {
                if (this.f406444e == null) {
                    this.f406444e = new q();
                }
                codedInputByteBufferNano.readMessage(this.f406444e);
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                m[] mVarArr = this.f406445f;
                int length4 = mVarArr == null ? 0 : mVarArr.length;
                int i18 = repeatedFieldArrayLength4 + length4;
                m[] mVarArr2 = new m[i18];
                if (length4 != 0) {
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length4);
                }
                while (length4 < i18 - 1) {
                    m mVar = new m();
                    mVarArr2[length4] = mVar;
                    codedInputByteBufferNano.readMessage(mVar);
                    codedInputByteBufferNano.readTag();
                    length4++;
                }
                m mVar2 = new m();
                mVarArr2[length4] = mVar2;
                codedInputByteBufferNano.readMessage(mVar2);
                this.f406445f = mVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f406440a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        qu4.s[] sVarArr = this.f406441b;
        int i3 = 0;
        if (sVarArr != null && sVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                qu4.s[] sVarArr2 = this.f406441b;
                if (i16 >= sVarArr2.length) {
                    break;
                }
                qu4.s sVar = sVarArr2[i16];
                if (sVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, sVar);
                }
                i16++;
            }
        }
        l[] lVarArr = this.f406442c;
        if (lVarArr != null && lVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                l[] lVarArr2 = this.f406442c;
                if (i17 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i17];
                if (lVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, lVar);
                }
                i17++;
            }
        }
        h[] hVarArr = this.f406443d;
        if (hVarArr != null && hVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                h[] hVarArr2 = this.f406443d;
                if (i18 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i18];
                if (hVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, hVar);
                }
                i18++;
            }
        }
        q qVar = this.f406444e;
        if (qVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, qVar);
        }
        m[] mVarArr = this.f406445f;
        if (mVarArr != null && mVarArr.length > 0) {
            while (true) {
                m[] mVarArr2 = this.f406445f;
                if (i3 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i3];
                if (mVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, mVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f406440a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        qu4.s[] sVarArr = this.f406441b;
        int i3 = 0;
        if (sVarArr != null && sVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                qu4.s[] sVarArr2 = this.f406441b;
                if (i16 >= sVarArr2.length) {
                    break;
                }
                qu4.s sVar = sVarArr2[i16];
                if (sVar != null) {
                    codedOutputByteBufferNano.writeMessage(2, sVar);
                }
                i16++;
            }
        }
        l[] lVarArr = this.f406442c;
        if (lVarArr != null && lVarArr.length > 0) {
            int i17 = 0;
            while (true) {
                l[] lVarArr2 = this.f406442c;
                if (i17 >= lVarArr2.length) {
                    break;
                }
                l lVar = lVarArr2[i17];
                if (lVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, lVar);
                }
                i17++;
            }
        }
        h[] hVarArr = this.f406443d;
        if (hVarArr != null && hVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                h[] hVarArr2 = this.f406443d;
                if (i18 >= hVarArr2.length) {
                    break;
                }
                h hVar = hVarArr2[i18];
                if (hVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, hVar);
                }
                i18++;
            }
        }
        q qVar = this.f406444e;
        if (qVar != null) {
            codedOutputByteBufferNano.writeMessage(5, qVar);
        }
        m[] mVarArr = this.f406445f;
        if (mVarArr != null && mVarArr.length > 0) {
            while (true) {
                m[] mVarArr2 = this.f406445f;
                if (i3 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i3];
                if (mVar != null) {
                    codedOutputByteBufferNano.writeMessage(6, mVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public k a() {
        this.f406440a = false;
        this.f406441b = qu4.s.b();
        this.f406442c = l.b();
        this.f406443d = h.b();
        this.f406444e = null;
        this.f406445f = m.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
