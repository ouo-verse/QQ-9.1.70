package at4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import hs4.i;
import hs4.r;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile a[] f26921e;

    /* renamed from: a, reason: collision with root package name */
    public f f26922a;

    /* renamed from: b, reason: collision with root package name */
    public r f26923b;

    /* renamed from: c, reason: collision with root package name */
    public i f26924c;

    /* renamed from: d, reason: collision with root package name */
    public String f26925d;

    public a() {
        a();
    }

    public static a[] b() {
        if (f26921e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f26921e == null) {
                    f26921e = new a[0];
                }
            }
        }
        return f26921e;
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
                if (this.f26922a == null) {
                    this.f26922a = new f();
                }
                codedInputByteBufferNano.readMessage(this.f26922a);
            } else if (readTag == 18) {
                if (this.f26923b == null) {
                    this.f26923b = new r();
                }
                codedInputByteBufferNano.readMessage(this.f26923b);
            } else if (readTag == 26) {
                if (this.f26924c == null) {
                    this.f26924c = new i();
                }
                codedInputByteBufferNano.readMessage(this.f26924c);
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f26925d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        f fVar = this.f26922a;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, fVar);
        }
        r rVar = this.f26923b;
        if (rVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, rVar);
        }
        i iVar = this.f26924c;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, iVar);
        }
        return !this.f26925d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f26925d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        f fVar = this.f26922a;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(1, fVar);
        }
        r rVar = this.f26923b;
        if (rVar != null) {
            codedOutputByteBufferNano.writeMessage(2, rVar);
        }
        i iVar = this.f26924c;
        if (iVar != null) {
            codedOutputByteBufferNano.writeMessage(3, iVar);
        }
        if (!this.f26925d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f26925d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public a a() {
        this.f26922a = null;
        this.f26923b = null;
        this.f26924c = null;
        this.f26925d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
