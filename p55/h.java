package p55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile h[] f425399e;

    /* renamed from: a, reason: collision with root package name */
    public String f425400a;

    /* renamed from: b, reason: collision with root package name */
    public String f425401b;

    /* renamed from: c, reason: collision with root package name */
    public String f425402c;

    /* renamed from: d, reason: collision with root package name */
    public w45.b[] f425403d;

    public h() {
        a();
    }

    public static h[] b() {
        if (f425399e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f425399e == null) {
                    f425399e = new h[0];
                }
            }
        }
        return f425399e;
    }

    public h a() {
        this.f425400a = "";
        this.f425401b = "";
        this.f425402c = "";
        this.f425403d = w45.b.b();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f425400a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.f425401b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f425402c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                w45.b[] bVarArr = this.f425403d;
                int length = bVarArr == null ? 0 : bVarArr.length;
                int i3 = repeatedFieldArrayLength + length;
                w45.b[] bVarArr2 = new w45.b[i3];
                if (length != 0) {
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                }
                while (length < i3 - 1) {
                    w45.b bVar = new w45.b();
                    bVarArr2[length] = bVar;
                    codedInputByteBufferNano.readMessage(bVar);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                w45.b bVar2 = new w45.b();
                bVarArr2[length] = bVar2;
                codedInputByteBufferNano.readMessage(bVar2);
                this.f425403d = bVarArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f425400a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f425400a);
        }
        if (!this.f425401b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f425401b);
        }
        if (!this.f425402c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f425402c);
        }
        w45.b[] bVarArr = this.f425403d;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                w45.b[] bVarArr2 = this.f425403d;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                w45.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, bVar);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f425400a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f425400a);
        }
        if (!this.f425401b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f425401b);
        }
        if (!this.f425402c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f425402c);
        }
        w45.b[] bVarArr = this.f425403d;
        if (bVarArr != null && bVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                w45.b[] bVarArr2 = this.f425403d;
                if (i3 >= bVarArr2.length) {
                    break;
                }
                w45.b bVar = bVarArr2[i3];
                if (bVar != null) {
                    codedOutputByteBufferNano.writeMessage(4, bVar);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
