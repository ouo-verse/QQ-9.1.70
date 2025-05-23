package fv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public d[] f400852a;

    /* renamed from: b, reason: collision with root package name */
    public long f400853b;

    /* renamed from: c, reason: collision with root package name */
    public String f400854c;

    public b() {
        a();
    }

    public static b c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f400852a = d.b();
        this.f400853b = 0L;
        this.f400854c = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                return this;
                            }
                        } else {
                            this.f400854c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f400853b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    d[] dVarArr = this.f400852a;
                    if (dVarArr == null) {
                        length = 0;
                    } else {
                        length = dVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    d[] dVarArr2 = new d[i3];
                    if (length != 0) {
                        System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        d dVar = new d();
                        dVarArr2[length] = dVar;
                        codedInputByteBufferNano.readMessage(dVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    d dVar2 = new d();
                    dVarArr2[length] = dVar2;
                    codedInputByteBufferNano.readMessage(dVar2);
                    this.f400852a = dVarArr2;
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        d[] dVarArr = this.f400852a;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f400852a;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, dVar);
                }
                i3++;
            }
        }
        long j3 = this.f400853b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        if (!this.f400854c.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.f400854c);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        d[] dVarArr = this.f400852a;
        if (dVarArr != null && dVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                d[] dVarArr2 = this.f400852a;
                if (i3 >= dVarArr2.length) {
                    break;
                }
                d dVar = dVarArr2[i3];
                if (dVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, dVar);
                }
                i3++;
            }
        }
        long j3 = this.f400853b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        if (!this.f400854c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f400854c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
