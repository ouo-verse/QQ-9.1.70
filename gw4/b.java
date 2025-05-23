package gw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: d, reason: collision with root package name */
    private static volatile b[] f403458d;

    /* renamed from: a, reason: collision with root package name */
    public String f403459a;

    /* renamed from: b, reason: collision with root package name */
    public f f403460b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f403461c;

    public b() {
        a();
    }

    public static b[] b() {
        if (f403458d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403458d == null) {
                    f403458d = new b[0];
                }
            }
        }
        return f403458d;
    }

    public static b d(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (b) MessageNano.mergeFrom(new b(), bArr);
    }

    public b a() {
        this.f403459a = "";
        this.f403460b = null;
        this.f403461c = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.f403459a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f403460b == null) {
                    this.f403460b = new f();
                }
                codedInputByteBufferNano.readMessage(this.f403460b);
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f403461c = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f403459a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403459a);
        }
        f fVar = this.f403460b;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, fVar);
        }
        boolean z16 = this.f403461c;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403459a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403459a);
        }
        f fVar = this.f403460b;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(2, fVar);
        }
        boolean z16 = this.f403461c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
