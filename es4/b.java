package es4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b[] f397093e;

    /* renamed from: a, reason: collision with root package name */
    public String f397094a;

    /* renamed from: b, reason: collision with root package name */
    public a f397095b;

    /* renamed from: c, reason: collision with root package name */
    public a f397096c;

    /* renamed from: d, reason: collision with root package name */
    public int f397097d;

    public b() {
        a();
    }

    public static b[] b() {
        if (f397093e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f397093e == null) {
                    f397093e = new b[0];
                }
            }
        }
        return f397093e;
    }

    public b a() {
        this.f397094a = "";
        this.f397095b = null;
        this.f397096c = null;
        this.f397097d = 0;
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
                this.f397094a = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                if (this.f397095b == null) {
                    this.f397095b = new a();
                }
                codedInputByteBufferNano.readMessage(this.f397095b);
            } else if (readTag == 26) {
                if (this.f397096c == null) {
                    this.f397096c = new a();
                }
                codedInputByteBufferNano.readMessage(this.f397096c);
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f397097d = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f397094a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f397094a);
        }
        a aVar = this.f397095b;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, aVar);
        }
        a aVar2 = this.f397096c;
        if (aVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, aVar2);
        }
        int i3 = this.f397097d;
        return i3 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i3) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f397094a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f397094a);
        }
        a aVar = this.f397095b;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(2, aVar);
        }
        a aVar2 = this.f397096c;
        if (aVar2 != null) {
            codedOutputByteBufferNano.writeMessage(3, aVar2);
        }
        int i3 = this.f397097d;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
