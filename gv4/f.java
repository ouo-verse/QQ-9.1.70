package gv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import xv4.ab;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public int f403431a;

    /* renamed from: b, reason: collision with root package name */
    public int f403432b;

    /* renamed from: c, reason: collision with root package name */
    public int f403433c;

    /* renamed from: d, reason: collision with root package name */
    public int f403434d;

    /* renamed from: e, reason: collision with root package name */
    public ab[] f403435e;

    /* renamed from: f, reason: collision with root package name */
    public long f403436f;

    /* renamed from: g, reason: collision with root package name */
    public long f403437g;

    public f() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f403431a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.f403432b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.f403433c = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.f403434d = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                ab[] abVarArr = this.f403435e;
                int length = abVarArr == null ? 0 : abVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                ab[] abVarArr2 = new ab[i3];
                if (length != 0) {
                    System.arraycopy(abVarArr, 0, abVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    ab abVar = new ab();
                    abVarArr2[length] = abVar;
                    codedInputByteBufferNano.readMessage(abVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                ab abVar2 = new ab();
                abVarArr2[length] = abVar2;
                codedInputByteBufferNano.readMessage(abVar2);
                this.f403435e = abVarArr2;
            } else if (readTag == 48) {
                this.f403436f = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f403437g = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f403431a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f403432b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.f403433c;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.f403434d;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        ab[] abVarArr = this.f403435e;
        if (abVarArr != null && abVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                ab[] abVarArr2 = this.f403435e;
                if (i19 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i19];
                if (abVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, abVar);
                }
                i19++;
            }
        }
        long j3 = this.f403436f;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        long j16 = this.f403437g;
        return j16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403431a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f403432b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.f403433c;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.f403434d;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        ab[] abVarArr = this.f403435e;
        if (abVarArr != null && abVarArr.length > 0) {
            int i19 = 0;
            while (true) {
                ab[] abVarArr2 = this.f403435e;
                if (i19 >= abVarArr2.length) {
                    break;
                }
                ab abVar = abVarArr2[i19];
                if (abVar != null) {
                    codedOutputByteBufferNano.writeMessage(5, abVar);
                }
                i19++;
            }
        }
        long j3 = this.f403436f;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        long j16 = this.f403437g;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f403431a = 0;
        this.f403432b = 0;
        this.f403433c = 0;
        this.f403434d = 0;
        this.f403435e = ab.b();
        this.f403436f = 0L;
        this.f403437g = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
