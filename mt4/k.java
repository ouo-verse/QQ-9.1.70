package mt4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class k extends ExtendableMessageNano<k> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile k[] f417595d;

    /* renamed from: a, reason: collision with root package name */
    public int f417596a;

    /* renamed from: b, reason: collision with root package name */
    public String f417597b;

    /* renamed from: c, reason: collision with root package name */
    public j[] f417598c;

    public k() {
        a();
    }

    public static k[] b() {
        if (f417595d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f417595d == null) {
                    f417595d = new k[0];
                }
            }
        }
        return f417595d;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public k mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f417596a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.f417597b = codedInputByteBufferNano.readString();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                j[] jVarArr = this.f417598c;
                int length = jVarArr == null ? 0 : jVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                j[] jVarArr2 = new j[i3];
                if (length != 0) {
                    System.arraycopy(jVarArr, 0, jVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    j jVar = new j();
                    jVarArr2[length] = jVar;
                    codedInputByteBufferNano.readMessage(jVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                j jVar2 = new j();
                jVarArr2[length] = jVar2;
                codedInputByteBufferNano.readMessage(jVar2);
                this.f417598c = jVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f417596a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.f417597b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f417597b);
        }
        j[] jVarArr = this.f417598c;
        if (jVarArr != null && jVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                j[] jVarArr2 = this.f417598c;
                if (i16 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i16];
                if (jVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, jVar);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f417596a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.f417597b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f417597b);
        }
        j[] jVarArr = this.f417598c;
        if (jVarArr != null && jVarArr.length > 0) {
            int i16 = 0;
            while (true) {
                j[] jVarArr2 = this.f417598c;
                if (i16 >= jVarArr2.length) {
                    break;
                }
                j jVar = jVarArr2[i16];
                if (jVar != null) {
                    codedOutputByteBufferNano.writeMessage(3, jVar);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public k a() {
        this.f417596a = 0;
        this.f417597b = "";
        this.f417598c = j.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
