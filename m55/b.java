package m55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public n55.a[] f416282a;

    /* renamed from: b, reason: collision with root package name */
    public int f416283b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f416284c;

    public b() {
        a();
    }

    public b a() {
        this.f416282a = n55.a.b();
        this.f416283b = 0;
        this.f416284c = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                n55.a[] aVarArr = this.f416282a;
                int length = aVarArr == null ? 0 : aVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                n55.a[] aVarArr2 = new n55.a[i3];
                if (length != 0) {
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    n55.a aVar = new n55.a();
                    aVarArr2[length] = aVar;
                    codedInputByteBufferNano.readMessage(aVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                n55.a aVar2 = new n55.a();
                aVarArr2[length] = aVar2;
                codedInputByteBufferNano.readMessage(aVar2);
                this.f416282a = aVarArr2;
            } else if (readTag == 16) {
                this.f416283b = codedInputByteBufferNano.readInt32();
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f416284c = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        n55.a[] aVarArr = this.f416282a;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n55.a[] aVarArr2 = this.f416282a;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                n55.a aVar = aVarArr2[i3];
                if (aVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
                }
                i3++;
            }
        }
        int i16 = this.f416283b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        boolean z16 = this.f416284c;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        n55.a[] aVarArr = this.f416282a;
        if (aVarArr != null && aVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                n55.a[] aVarArr2 = this.f416282a;
                if (i3 >= aVarArr2.length) {
                    break;
                }
                n55.a aVar = aVarArr2[i3];
                if (aVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, aVar);
                }
                i3++;
            }
        }
        int i16 = this.f416283b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        boolean z16 = this.f416284c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
