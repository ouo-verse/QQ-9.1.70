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
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public pu4.n f408873a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f408874b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f408875c;

    /* renamed from: d, reason: collision with root package name */
    public t[] f408876d;

    /* renamed from: e, reason: collision with root package name */
    public int f408877e;

    /* renamed from: f, reason: collision with root package name */
    public bq f408878f;

    /* renamed from: g, reason: collision with root package name */
    public int f408879g;

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
                if (this.f408873a == null) {
                    this.f408873a = new pu4.n();
                }
                codedInputByteBufferNano.readMessage(this.f408873a);
            } else if (readTag == 16) {
                this.f408874b = codedInputByteBufferNano.readBool();
            } else if (readTag == 26) {
                this.f408875c = codedInputByteBufferNano.readBytes();
            } else if (readTag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                t[] tVarArr = this.f408876d;
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
                this.f408876d = tVarArr2;
            } else if (readTag == 40) {
                this.f408877e = codedInputByteBufferNano.readInt32();
            } else if (readTag == 50) {
                if (this.f408878f == null) {
                    this.f408878f = new bq();
                }
                codedInputByteBufferNano.readMessage(this.f408878f);
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f408879g = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        pu4.n nVar = this.f408873a;
        if (nVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, nVar);
        }
        boolean z16 = this.f408874b;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z16);
        }
        if (!Arrays.equals(this.f408875c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f408875c);
        }
        t[] tVarArr = this.f408876d;
        if (tVarArr != null && tVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                t[] tVarArr2 = this.f408876d;
                if (i3 >= tVarArr2.length) {
                    break;
                }
                t tVar = tVarArr2[i3];
                if (tVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, tVar);
                }
                i3++;
            }
        }
        int i16 = this.f408877e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        bq bqVar = this.f408878f;
        if (bqVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, bqVar);
        }
        int i17 = this.f408879g;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(7, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        pu4.n nVar = this.f408873a;
        if (nVar != null) {
            codedOutputByteBufferNano.writeMessage(1, nVar);
        }
        boolean z16 = this.f408874b;
        if (z16) {
            codedOutputByteBufferNano.writeBool(2, z16);
        }
        if (!Arrays.equals(this.f408875c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f408875c);
        }
        t[] tVarArr = this.f408876d;
        if (tVarArr != null && tVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                t[] tVarArr2 = this.f408876d;
                if (i3 >= tVarArr2.length) {
                    break;
                }
                t tVar = tVarArr2[i3];
                if (tVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, tVar);
                }
                i3++;
            }
        }
        int i16 = this.f408877e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        bq bqVar = this.f408878f;
        if (bqVar != null) {
            codedOutputByteBufferNano.writeMessage(6, bqVar);
        }
        int i17 = this.f408879g;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public b a() {
        this.f408873a = null;
        this.f408874b = false;
        this.f408875c = WireFormatNano.EMPTY_BYTES;
        this.f408876d = t.b();
        this.f408877e = 0;
        this.f408878f = null;
        this.f408879g = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
