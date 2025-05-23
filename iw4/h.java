package iw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;
import pv4.t;
import qv4.bq;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f408892a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f408893b;

    /* renamed from: c, reason: collision with root package name */
    public t[] f408894c;

    /* renamed from: d, reason: collision with root package name */
    public int f408895d;

    /* renamed from: e, reason: collision with root package name */
    public bq f408896e;

    /* renamed from: f, reason: collision with root package name */
    public int f408897f;

    public h() {
        a();
    }

    public static h c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (h) MessageNano.mergeFrom(new h(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f408892a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                this.f408893b = codedInputByteBufferNano.readBytes();
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                t[] tVarArr = this.f408894c;
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
                this.f408894c = tVarArr2;
            } else if (readTag == 32) {
                this.f408895d = codedInputByteBufferNano.readInt32();
            } else if (readTag == 42) {
                if (this.f408896e == null) {
                    this.f408896e = new bq();
                }
                codedInputByteBufferNano.readMessage(this.f408896e);
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f408897f = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f408892a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!Arrays.equals(this.f408893b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f408893b);
        }
        t[] tVarArr = this.f408894c;
        if (tVarArr != null && tVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                t[] tVarArr2 = this.f408894c;
                if (i3 >= tVarArr2.length) {
                    break;
                }
                t tVar = tVarArr2[i3];
                if (tVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, tVar);
                }
                i3++;
            }
        }
        int i16 = this.f408895d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        bq bqVar = this.f408896e;
        if (bqVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, bqVar);
        }
        int i17 = this.f408897f;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f408892a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!Arrays.equals(this.f408893b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f408893b);
        }
        t[] tVarArr = this.f408894c;
        if (tVarArr != null && tVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                t[] tVarArr2 = this.f408894c;
                if (i3 >= tVarArr2.length) {
                    break;
                }
                t tVar = tVarArr2[i3];
                if (tVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, tVar);
                }
                i3++;
            }
        }
        int i16 = this.f408895d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        bq bqVar = this.f408896e;
        if (bqVar != null) {
            codedOutputByteBufferNano.writeMessage(5, bqVar);
        }
        int i17 = this.f408897f;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public h a() {
        this.f408892a = false;
        this.f408893b = WireFormatNano.EMPTY_BYTES;
        this.f408894c = t.b();
        this.f408895d = 0;
        this.f408896e = null;
        this.f408897f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
