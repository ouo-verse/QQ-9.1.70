package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class n extends ExtendableMessageNano<n> {

    /* renamed from: a, reason: collision with root package name */
    public m f406172a;

    /* renamed from: b, reason: collision with root package name */
    public m f406173b;

    /* renamed from: c, reason: collision with root package name */
    public int f406174c;

    /* renamed from: d, reason: collision with root package name */
    public m[] f406175d;

    public n() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.f406172a == null) {
                    this.f406172a = new m();
                }
                codedInputByteBufferNano.readMessage(this.f406172a);
            } else if (readTag == 18) {
                if (this.f406173b == null) {
                    this.f406173b = new m();
                }
                codedInputByteBufferNano.readMessage(this.f406173b);
            } else if (readTag == 24) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                switch (readInt32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        this.f406174c = readInt32;
                        break;
                }
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                m[] mVarArr = this.f406175d;
                int length = mVarArr == null ? 0 : mVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                m[] mVarArr2 = new m[i3];
                if (length != 0) {
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    m mVar = new m();
                    mVarArr2[length] = mVar;
                    codedInputByteBufferNano.readMessage(mVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                m mVar2 = new m();
                mVarArr2[length] = mVar2;
                codedInputByteBufferNano.readMessage(mVar2);
                this.f406175d = mVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        m mVar = this.f406172a;
        if (mVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, mVar);
        }
        m mVar2 = this.f406173b;
        if (mVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, mVar2);
        }
        int i3 = this.f406174c;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        m[] mVarArr = this.f406175d;
        if (mVarArr != null && mVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                m[] mVarArr2 = this.f406175d;
                if (i16 >= mVarArr2.length) {
                    break;
                }
                m mVar3 = mVarArr2[i16];
                if (mVar3 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, mVar3);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        m mVar = this.f406172a;
        if (mVar != null) {
            codedOutputByteBufferNano.writeMessage(1, mVar);
        }
        m mVar2 = this.f406173b;
        if (mVar2 != null) {
            codedOutputByteBufferNano.writeMessage(2, mVar2);
        }
        int i3 = this.f406174c;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        m[] mVarArr = this.f406175d;
        if (mVarArr != null && mVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                m[] mVarArr2 = this.f406175d;
                if (i16 >= mVarArr2.length) {
                    break;
                }
                m mVar3 = mVarArr2[i16];
                if (mVar3 != null) {
                    codedOutputByteBufferNano.writeMessage(4, mVar3);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public n a() {
        this.f406172a = null;
        this.f406173b = null;
        this.f406174c = 0;
        this.f406175d = m.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
