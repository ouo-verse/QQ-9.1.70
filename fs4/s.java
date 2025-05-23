package fs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class s extends ExtendableMessageNano<s> {

    /* renamed from: a, reason: collision with root package name */
    public String f400572a;

    /* renamed from: b, reason: collision with root package name */
    public String f400573b;

    /* renamed from: c, reason: collision with root package name */
    public String f400574c;

    /* renamed from: d, reason: collision with root package name */
    public String f400575d;

    /* renamed from: e, reason: collision with root package name */
    public String f400576e;

    /* renamed from: f, reason: collision with root package name */
    public String f400577f;

    /* renamed from: g, reason: collision with root package name */
    public b[] f400578g;

    /* renamed from: h, reason: collision with root package name */
    public m[] f400579h;

    public s() {
        a();
    }

    public s a() {
        this.f400572a = "";
        this.f400573b = "";
        this.f400574c = "";
        this.f400575d = "";
        this.f400576e = "";
        this.f400577f = "";
        this.f400578g = b.b();
        this.f400579h = m.b();
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
                this.f400572a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f400573b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f400574c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f400575d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f400576e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f400577f = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                b[] bVarArr = this.f400578g;
                int length = bVarArr == null ? 0 : bVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                b[] bVarArr2 = new b[i3];
                if (length != 0) {
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    b bVar = new b();
                    bVarArr2[length] = bVar;
                    codedInputByteBufferNano.readMessage(bVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                b bVar2 = new b();
                bVarArr2[length] = bVar2;
                codedInputByteBufferNano.readMessage(bVar2);
                this.f400578g = bVarArr2;
            } else if (readTag != 66) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                m[] mVarArr = this.f400579h;
                int length2 = mVarArr == null ? 0 : mVarArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                m[] mVarArr2 = new m[i16];
                if (length2 != 0) {
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    m mVar = new m();
                    mVarArr2[length2] = mVar;
                    codedInputByteBufferNano.readMessage(mVar);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                m mVar2 = new m();
                mVarArr2[length2] = mVar2;
                codedInputByteBufferNano.readMessage(mVar2);
                this.f400579h = mVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f400572a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f400572a);
        }
        if (!this.f400573b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f400573b);
        }
        if (!this.f400574c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f400574c);
        }
        if (!this.f400575d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f400575d);
        }
        if (!this.f400576e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f400576e);
        }
        if (!this.f400577f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f400577f);
        }
        b[] bVarArr = this.f400578g;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f400578g;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, bVar);
                }
                i16++;
            }
        }
        m[] mVarArr = this.f400579h;
        if (mVarArr != null && mVarArr.length > 0) {
            while (true) {
                m[] mVarArr2 = this.f400579h;
                if (i3 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i3];
                if (mVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, mVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f400572a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f400572a);
        }
        if (!this.f400573b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f400573b);
        }
        if (!this.f400574c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400574c);
        }
        if (!this.f400575d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f400575d);
        }
        if (!this.f400576e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f400576e);
        }
        if (!this.f400577f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f400577f);
        }
        b[] bVarArr = this.f400578g;
        int i3 = 0;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f400578g;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(7, bVar);
                }
                i16++;
            }
        }
        m[] mVarArr = this.f400579h;
        if (mVarArr != null && mVarArr.length > 0) {
            while (true) {
                m[] mVarArr2 = this.f400579h;
                if (i3 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i3];
                if (mVar != null) {
                    codedOutputByteBufferNano.writeMessage(8, mVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
