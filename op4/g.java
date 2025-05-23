package op4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import fu4.w;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: b, reason: collision with root package name */
    private static volatile g[] f423328b;

    /* renamed from: a, reason: collision with root package name */
    public w f423329a;

    public g() {
        a();
    }

    public static g[] b() {
        if (f423328b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (f423328b == null) {
                    f423328b = new g[0];
                }
            }
        }
        return f423328b;
    }

    public g a() {
        this.f423329a = null;
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
                if (readTag != 10) {
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                } else {
                    if (this.f423329a == null) {
                        this.f423329a = new w();
                    }
                    codedInputByteBufferNano.readMessage(this.f423329a);
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
        w wVar = this.f423329a;
        if (wVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, wVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        w wVar = this.f423329a;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(1, wVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
