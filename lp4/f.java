package lp4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class f extends ExtendableMessageNano<f> {

    /* renamed from: a, reason: collision with root package name */
    public int f415365a;

    /* renamed from: b, reason: collision with root package name */
    public int f415366b;

    /* renamed from: c, reason: collision with root package name */
    public b f415367c;

    /* renamed from: d, reason: collision with root package name */
    public d f415368d;

    public f() {
        a();
    }

    public f a() {
        this.f415365a = 0;
        this.f415366b = 0;
        this.f415367c = null;
        this.f415368d = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public f mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                    return this;
                                }
                            } else {
                                if (this.f415368d == null) {
                                    this.f415368d = new d();
                                }
                                codedInputByteBufferNano.readMessage(this.f415368d);
                            }
                        } else {
                            if (this.f415367c == null) {
                                this.f415367c = new b();
                            }
                            codedInputByteBufferNano.readMessage(this.f415367c);
                        }
                    } else {
                        this.f415366b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f415365a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f415365a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f415366b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        b bVar = this.f415367c;
        if (bVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, bVar);
        }
        d dVar = this.f415368d;
        if (dVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, dVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f415365a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f415366b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        b bVar = this.f415367c;
        if (bVar != null) {
            codedOutputByteBufferNano.writeMessage(3, bVar);
        }
        d dVar = this.f415368d;
        if (dVar != null) {
            codedOutputByteBufferNano.writeMessage(4, dVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
