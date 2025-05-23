package hq4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class h extends ExtendableMessageNano<h> {

    /* renamed from: a, reason: collision with root package name */
    public np4.c f405973a;

    /* renamed from: b, reason: collision with root package name */
    public sp4.c f405974b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f405975c;

    /* renamed from: d, reason: collision with root package name */
    public mp4.d f405976d;

    public h() {
        a();
    }

    public h a() {
        this.f405973a = null;
        this.f405974b = null;
        this.f405975c = false;
        this.f405976d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public h mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 18) {
                        if (readTag != 24) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f405976d == null) {
                                    this.f405976d = new mp4.d();
                                }
                                codedInputByteBufferNano.readMessage(this.f405976d);
                            }
                        } else {
                            this.f405975c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        if (this.f405974b == null) {
                            this.f405974b = new sp4.c();
                        }
                        codedInputByteBufferNano.readMessage(this.f405974b);
                    }
                } else {
                    if (this.f405973a == null) {
                        this.f405973a = new np4.c();
                    }
                    codedInputByteBufferNano.readMessage(this.f405973a);
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
        np4.c cVar = this.f405973a;
        if (cVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, cVar);
        }
        sp4.c cVar2 = this.f405974b;
        if (cVar2 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, cVar2);
        }
        boolean z16 = this.f405975c;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z16);
        }
        mp4.d dVar = this.f405976d;
        if (dVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, dVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        np4.c cVar = this.f405973a;
        if (cVar != null) {
            codedOutputByteBufferNano.writeMessage(1, cVar);
        }
        sp4.c cVar2 = this.f405974b;
        if (cVar2 != null) {
            codedOutputByteBufferNano.writeMessage(2, cVar2);
        }
        boolean z16 = this.f405975c;
        if (z16) {
            codedOutputByteBufferNano.writeBool(3, z16);
        }
        mp4.d dVar = this.f405976d;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(4, dVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
