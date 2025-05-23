package dt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public c[] f394843a;

    /* renamed from: b, reason: collision with root package name */
    public int f394844b;

    public a() {
        a();
    }

    public a a() {
        this.f394843a = c.b();
        this.f394844b = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                c[] cVarArr = this.f394843a;
                int length = cVarArr == null ? 0 : cVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                c[] cVarArr2 = new c[i3];
                if (length != 0) {
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    c cVar = new c();
                    cVarArr2[length] = cVar;
                    codedInputByteBufferNano.readMessage(cVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                c cVar2 = new c();
                cVarArr2[length] = cVar2;
                codedInputByteBufferNano.readMessage(cVar2);
                this.f394843a = cVarArr2;
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 999) {
                    switch (readInt32) {
                    }
                }
                this.f394844b = readInt32;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        c[] cVarArr = this.f394843a;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f394843a;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
                }
                i3++;
            }
        }
        int i16 = this.f394844b;
        return i16 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        c[] cVarArr = this.f394843a;
        if (cVarArr != null && cVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                c[] cVarArr2 = this.f394843a;
                if (i3 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i3];
                if (cVar != null) {
                    codedOutputByteBufferNano.writeMessage(1, cVar);
                }
                i3++;
            }
        }
        int i16 = this.f394844b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
