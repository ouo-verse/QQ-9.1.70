package gu4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: e, reason: collision with root package name */
    private static volatile g[] f403389e;

    /* renamed from: a, reason: collision with root package name */
    public int f403390a;

    /* renamed from: b, reason: collision with root package name */
    public f f403391b;

    /* renamed from: c, reason: collision with root package name */
    public p f403392c;

    /* renamed from: d, reason: collision with root package name */
    public j f403393d;

    public g() {
        a();
    }

    public static g[] b() {
        if (f403389e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f403389e == null) {
                    f403389e = new g[0];
                }
            }
        }
        return f403389e;
    }

    public g a() {
        this.f403390a = 0;
        this.f403391b = null;
        this.f403392c = null;
        this.f403393d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f403393d == null) {
                                    this.f403393d = new j();
                                }
                                codedInputByteBufferNano.readMessage(this.f403393d);
                            }
                        } else {
                            if (this.f403392c == null) {
                                this.f403392c = new p();
                            }
                            codedInputByteBufferNano.readMessage(this.f403392c);
                        }
                    } else {
                        if (this.f403391b == null) {
                            this.f403391b = new f();
                        }
                        codedInputByteBufferNano.readMessage(this.f403391b);
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                        this.f403390a = readInt32;
                    }
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
        int i3 = this.f403390a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        f fVar = this.f403391b;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, fVar);
        }
        p pVar = this.f403392c;
        if (pVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, pVar);
        }
        j jVar = this.f403393d;
        if (jVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, jVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f403390a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        f fVar = this.f403391b;
        if (fVar != null) {
            codedOutputByteBufferNano.writeMessage(2, fVar);
        }
        p pVar = this.f403392c;
        if (pVar != null) {
            codedOutputByteBufferNano.writeMessage(3, pVar);
        }
        j jVar = this.f403393d;
        if (jVar != null) {
            codedOutputByteBufferNano.writeMessage(4, jVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
