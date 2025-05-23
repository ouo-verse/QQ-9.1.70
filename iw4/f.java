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

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f408884a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f408885b;

    /* renamed from: c, reason: collision with root package name */
    public t[] f408886c;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
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
                this.f408884a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                this.f408885b = codedInputByteBufferNano.readBytes();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                t[] tVarArr = this.f408886c;
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
                this.f408886c = tVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f408884a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!Arrays.equals(this.f408885b, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.f408885b);
        }
        t[] tVarArr = this.f408886c;
        if (tVarArr != null && tVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                t[] tVarArr2 = this.f408886c;
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
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f408884a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!Arrays.equals(this.f408885b, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.f408885b);
        }
        t[] tVarArr = this.f408886c;
        if (tVarArr != null && tVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                t[] tVarArr2 = this.f408886c;
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
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f408884a = false;
        this.f408885b = WireFormatNano.EMPTY_BYTES;
        this.f408886c = t.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
