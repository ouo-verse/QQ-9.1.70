package d55;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public a f393072a;

    /* renamed from: b, reason: collision with root package name */
    public int f393073b;

    /* renamed from: c, reason: collision with root package name */
    public int f393074c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f393075d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f393076e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f393077f;

    /* renamed from: g, reason: collision with root package name */
    public String f393078g;

    public g() {
        a();
    }

    public g a() {
        this.f393072a = null;
        this.f393073b = 0;
        this.f393074c = 0;
        this.f393075d = false;
        this.f393076e = false;
        this.f393077f = false;
        this.f393078g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 10) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f393078g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f393077f = codedInputByteBufferNano.readBool();
                                    }
                                } else {
                                    this.f393076e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f393075d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f393074c = codedInputByteBufferNano.readUInt32();
                        }
                    } else {
                        this.f393073b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    if (this.f393072a == null) {
                        this.f393072a = new a();
                    }
                    codedInputByteBufferNano.readMessage(this.f393072a);
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
        a aVar = this.f393072a;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, aVar);
        }
        int i3 = this.f393073b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.f393074c;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        boolean z16 = this.f393075d;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z16);
        }
        boolean z17 = this.f393076e;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z17);
        }
        boolean z18 = this.f393077f;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z18);
        }
        if (!this.f393078g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f393078g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        a aVar = this.f393072a;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(1, aVar);
        }
        int i3 = this.f393073b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.f393074c;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        boolean z16 = this.f393075d;
        if (z16) {
            codedOutputByteBufferNano.writeBool(4, z16);
        }
        boolean z17 = this.f393076e;
        if (z17) {
            codedOutputByteBufferNano.writeBool(5, z17);
        }
        boolean z18 = this.f393077f;
        if (z18) {
            codedOutputByteBufferNano.writeBool(6, z18);
        }
        if (!this.f393078g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f393078g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
