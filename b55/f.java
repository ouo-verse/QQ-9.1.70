package b55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public g[] f27971a;

    public f() {
        a();
    }

    public static f c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (f) MessageNano.mergeFrom(new f(), bArr);
    }

    public f a() {
        this.f27971a = g.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        int length;
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    g[] gVarArr = this.f27971a;
                    if (gVarArr == null) {
                        length = 0;
                    } else {
                        length = gVarArr.length;
                    }
                    int i3 = repeatedFieldArrayLength + length;
                    g[] gVarArr2 = new g[i3];
                    if (length != 0) {
                        System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        g gVar = new g();
                        gVarArr2[length] = gVar;
                        codedInputByteBufferNano.readMessage(gVar);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    g gVar2 = new g();
                    gVarArr2[length] = gVar2;
                    codedInputByteBufferNano.readMessage(gVar2);
                    this.f27971a = gVarArr2;
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
        g[] gVarArr = this.f27971a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f27971a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        g[] gVarArr = this.f27971a;
        if (gVarArr != null && gVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                g[] gVarArr2 = this.f27971a;
                if (i3 >= gVarArr2.length) {
                    break;
                }
                g gVar = gVarArr2[i3];
                if (gVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, gVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
