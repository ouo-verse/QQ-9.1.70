package bq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile b[] f28995e;

    /* renamed from: a, reason: collision with root package name */
    public a f28996a;

    /* renamed from: b, reason: collision with root package name */
    public c f28997b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f28998c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f28999d;

    public b() {
        a();
    }

    public static b[] b() {
        if (f28995e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f28995e == null) {
                    f28995e = new b[0];
                }
            }
        }
        return f28995e;
    }

    public b a() {
        this.f28996a = null;
        this.f28997b = null;
        this.f28998c = WireFormatNano.EMPTY_BYTES;
        this.f28999d = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 32) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                this.f28999d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f28998c = codedInputByteBufferNano.readBytes();
                        }
                    } else {
                        if (this.f28997b == null) {
                            this.f28997b = new c();
                        }
                        codedInputByteBufferNano.readMessage(this.f28997b);
                    }
                } else {
                    if (this.f28996a == null) {
                        this.f28996a = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f28996a);
                }
            } else {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        a aVar = this.f28996a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        c cVar = this.f28997b;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar);
        }
        if (!Arrays.equals(this.f28998c, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.f28998c);
        }
        boolean z16 = this.f28999d;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a aVar = this.f28996a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        c cVar = this.f28997b;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(2, cVar);
        }
        if (!Arrays.equals(this.f28998c, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(3, this.f28998c);
        }
        boolean z16 = this.f28999d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
