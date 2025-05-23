package ft4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public as4.g f400617a;

    /* renamed from: b, reason: collision with root package name */
    public as4.d f400618b;

    /* renamed from: c, reason: collision with root package name */
    public as4.c[] f400619c;

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
            if (readTag == 10) {
                if (this.f400617a == null) {
                    this.f400617a = new as4.g();
                }
                codedInputByteBufferNano.readMessage(this.f400617a);
            } else if (readTag == 18) {
                if (this.f400618b == null) {
                    this.f400618b = new as4.d();
                }
                codedInputByteBufferNano.readMessage(this.f400618b);
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                as4.c[] cVarArr = this.f400619c;
                int length = cVarArr == null ? 0 : cVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                as4.c[] cVarArr2 = new as4.c[i3];
                if (length != 0) {
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    as4.c cVar = new as4.c();
                    cVarArr2[length] = cVar;
                    codedInputByteBufferNano.readMessage(cVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                as4.c cVar2 = new as4.c();
                cVarArr2[length] = cVar2;
                codedInputByteBufferNano.readMessage(cVar2);
                this.f400619c = cVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        as4.g gVar = this.f400617a;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, gVar);
        }
        as4.d dVar = this.f400618b;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, dVar);
        }
        as4.c[] cVarArr = this.f400619c;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                as4.c[] cVarArr2 = this.f400619c;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                as4.c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, cVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        as4.g gVar = this.f400617a;
        if (gVar != null) {
            codedOutputByteBufferNano.writeMessage(1, gVar);
        }
        as4.d dVar = this.f400618b;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(2, dVar);
        }
        as4.c[] cVarArr = this.f400619c;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                as4.c[] cVarArr2 = this.f400619c;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                as4.c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, cVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public f a() {
        this.f400617a = null;
        this.f400618b = null;
        this.f400619c = as4.c.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
