package dv4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public int f395035a;

    /* renamed from: b, reason: collision with root package name */
    public a f395036b;

    /* renamed from: c, reason: collision with root package name */
    public b[] f395037c;

    /* renamed from: d, reason: collision with root package name */
    public int f395038d;

    /* renamed from: e, reason: collision with root package name */
    public c f395039e;

    /* renamed from: f, reason: collision with root package name */
    public int f395040f;

    public j() {
        a();
    }

    public static j c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (j) MessageNano.mergeFrom(new j(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1) {
                    this.f395035a = readInt32;
                }
            } else if (readTag == 18) {
                if (this.f395036b == null) {
                    this.f395036b = new a();
                }
                codedInputByteBufferNano.readMessage(this.f395036b);
            } else if (readTag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                b[] bVarArr = this.f395037c;
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
                this.f395037c = bVarArr2;
            } else if (readTag == 32) {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == 0 || readInt322 == 1 || readInt322 == 2) {
                    this.f395038d = readInt322;
                }
            } else if (readTag == 42) {
                if (this.f395039e == null) {
                    this.f395039e = new c();
                }
                codedInputByteBufferNano.readMessage(this.f395039e);
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f395040f = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f395035a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        a aVar = this.f395036b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        b[] bVarArr = this.f395037c;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f395037c;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, bVar);
                }
                i16++;
            }
        }
        int i17 = this.f395038d;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i17);
        }
        c cVar = this.f395039e;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, cVar);
        }
        int i18 = this.f395040f;
        return i18 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i18) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f395035a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        a aVar = this.f395036b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        b[] bVarArr = this.f395037c;
        if (bVarArr != null && bVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                b[] bVarArr2 = this.f395037c;
                if (i16 >= bVarArr2.length) {
                    break;
                }
                b bVar = bVarArr2[i16];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, bVar);
                }
                i16++;
            }
        }
        int i17 = this.f395038d;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i17);
        }
        c cVar = this.f395039e;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(5, cVar);
        }
        int i18 = this.f395040f;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f395035a = 0;
        this.f395036b = null;
        this.f395037c = b.b();
        this.f395038d = 0;
        this.f395039e = null;
        this.f395040f = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
