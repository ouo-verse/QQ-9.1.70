package gr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class z extends ExtendableMessageNano<z> {

    /* renamed from: a, reason: collision with root package name */
    public String f403246a;

    /* renamed from: b, reason: collision with root package name */
    public long f403247b;

    /* renamed from: c, reason: collision with root package name */
    public w f403248c;

    /* renamed from: d, reason: collision with root package name */
    public String f403249d;

    /* renamed from: e, reason: collision with root package name */
    public String f403250e;

    public z() {
        a();
    }

    public static z c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (z) MessageNano.mergeFrom(new z(), bArr);
    }

    public z a() {
        this.f403246a = "";
        this.f403247b = 0L;
        this.f403248c = null;
        this.f403249d = "";
        this.f403250e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f403250e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f403249d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            if (this.f403248c == null) {
                                this.f403248c = new w();
                            }
                            codedInputByteBufferNano.readMessage(this.f403248c);
                        }
                    } else {
                        this.f403247b = codedInputByteBufferNano.readInt64();
                    }
                } else {
                    this.f403246a = codedInputByteBufferNano.readString();
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
        if (!this.f403246a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f403246a);
        }
        long j3 = this.f403247b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        w wVar = this.f403248c;
        if (wVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, wVar);
        }
        if (!this.f403249d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f403249d);
        }
        if (!this.f403250e.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f403250e);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f403246a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f403246a);
        }
        long j3 = this.f403247b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        w wVar = this.f403248c;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(3, wVar);
        }
        if (!this.f403249d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403249d);
        }
        if (!this.f403250e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f403250e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
