package p8;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a[] f425691c;

    /* renamed from: a, reason: collision with root package name */
    public b[] f425692a;

    /* renamed from: b, reason: collision with root package name */
    public String f425693b;

    public a() {
        a();
    }

    public static a[] b() {
        if (f425691c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f425691c == null) {
                    f425691c = new a[0];
                }
            }
        }
        return f425691c;
    }

    public a a() {
        this.f425692a = b.b();
        this.f425693b = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                b[] bVarArr = this.f425692a;
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
                this.f425692a = bVarArr2;
            } else if (readTag != 802) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f425693b = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        b[] bVarArr = this.f425692a;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                b[] bVarArr2 = this.f425692a;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bVar);
                }
                i3++;
            }
        }
        return !this.f425693b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(100, this.f425693b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        b[] bVarArr = this.f425692a;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                b[] bVarArr2 = this.f425692a;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, bVar);
                }
                i3++;
            }
        }
        if (!this.f425693b.equals("")) {
            codedOutputByteBufferNano.writeString(100, this.f425693b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
