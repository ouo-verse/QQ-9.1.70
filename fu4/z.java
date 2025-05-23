package fu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class z extends ExtendableMessageNano<z> {

    /* renamed from: g, reason: collision with root package name */
    private static volatile z[] f400829g;

    /* renamed from: a, reason: collision with root package name */
    public v f400830a;

    /* renamed from: b, reason: collision with root package name */
    public ad f400831b;

    /* renamed from: c, reason: collision with root package name */
    public ay f400832c;

    /* renamed from: d, reason: collision with root package name */
    public a f400833d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f400834e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f400835f;

    public z() {
        a();
    }

    public static z[] b() {
        if (f400829g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f400829g == null) {
                    f400829g = new z[0];
                }
            }
        }
        return f400829g;
    }

    public z a() {
        this.f400830a = null;
        this.f400831b = null;
        this.f400832c = null;
        this.f400833d = null;
        this.f400834e = false;
        this.f400835f = WireFormatNano.EMPTY_BYTES;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public z mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 50) {
                                        if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                            return this;
                                        }
                                    } else {
                                        this.f400835f = codedInputByteBufferNano.readBytes();
                                    }
                                } else {
                                    this.f400834e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                if (this.f400833d == null) {
                                    this.f400833d = new a();
                                }
                                codedInputByteBufferNano.readMessage(this.f400833d);
                            }
                        } else {
                            if (this.f400832c == null) {
                                this.f400832c = new ay();
                            }
                            codedInputByteBufferNano.readMessage(this.f400832c);
                        }
                    } else {
                        if (this.f400831b == null) {
                            this.f400831b = new ad();
                        }
                        codedInputByteBufferNano.readMessage(this.f400831b);
                    }
                } else {
                    if (this.f400830a == null) {
                        this.f400830a = new v();
                    }
                    codedInputByteBufferNano.readMessage(this.f400830a);
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
        v vVar = this.f400830a;
        if (vVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, vVar);
        }
        ad adVar = this.f400831b;
        if (adVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, adVar);
        }
        ay ayVar = this.f400832c;
        if (ayVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, ayVar);
        }
        a aVar = this.f400833d;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, aVar);
        }
        boolean z16 = this.f400834e;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z16);
        }
        if (!Arrays.equals(this.f400835f, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(6, this.f400835f);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        v vVar = this.f400830a;
        if (vVar != null) {
            codedOutputByteBufferNano.writeMessage(1, vVar);
        }
        ad adVar = this.f400831b;
        if (adVar != null) {
            codedOutputByteBufferNano.writeMessage(2, adVar);
        }
        ay ayVar = this.f400832c;
        if (ayVar != null) {
            codedOutputByteBufferNano.writeMessage(3, ayVar);
        }
        a aVar = this.f400833d;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(4, aVar);
        }
        boolean z16 = this.f400834e;
        if (z16) {
            codedOutputByteBufferNano.writeBool(5, z16);
        }
        if (!Arrays.equals(this.f400835f, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(6, this.f400835f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
