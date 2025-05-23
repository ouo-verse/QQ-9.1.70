package nv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public long f421399a;

    /* renamed from: b, reason: collision with root package name */
    public int f421400b;

    /* renamed from: c, reason: collision with root package name */
    public int f421401c;

    /* renamed from: d, reason: collision with root package name */
    public int f421402d;

    /* renamed from: e, reason: collision with root package name */
    public m[] f421403e;

    public g() {
        a();
    }

    public static g c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
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
                this.f421399a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.f421400b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f421401c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f421402d = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                m[] mVarArr = this.f421403e;
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
                this.f421403e = mVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f421399a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.f421400b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f421401c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.f421402d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        m[] mVarArr = this.f421403e;
        if (mVarArr != null && mVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                m[] mVarArr2 = this.f421403e;
                if (i18 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i18];
                if (mVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, mVar);
                }
                i18++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f421399a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.f421400b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f421401c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.f421402d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        m[] mVarArr = this.f421403e;
        if (mVarArr != null && mVarArr.length > 0) {
            int i18 = 0;
            while (true) {
                m[] mVarArr2 = this.f421403e;
                if (i18 >= mVarArr2.length) {
                    break;
                }
                m mVar = mVarArr2[i18];
                if (mVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, mVar);
                }
                i18++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f421399a = 0L;
        this.f421400b = 0;
        this.f421401c = 0;
        this.f421402d = 0;
        this.f421403e = m.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
