package nr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b extends ExtendableMessageNano<b> {

    /* renamed from: a, reason: collision with root package name */
    public int f421205a;

    /* renamed from: b, reason: collision with root package name */
    public String f421206b;

    /* renamed from: c, reason: collision with root package name */
    public String f421207c;

    /* renamed from: d, reason: collision with root package name */
    public String f421208d;

    /* renamed from: e, reason: collision with root package name */
    public int f421209e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f421210f;

    /* renamed from: g, reason: collision with root package name */
    public a f421211g;

    public b() {
        a();
    }

    public b a() {
        this.f421205a = 0;
        this.f421206b = "";
        this.f421207c = "";
        this.f421208d = "";
        this.f421209e = 0;
        this.f421210f = false;
        this.f421211g = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 18) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 40) {
                                    if (readTag != 48) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            if (this.f421211g == null) {
                                                this.f421211g = new a();
                                            }
                                            codedInputByteBufferNano.readMessage(this.f421211g);
                                        }
                                    } else {
                                        this.f421210f = codedInputByteBufferNano.readBool();
                                    }
                                } else {
                                    this.f421209e = codedInputByteBufferNano.readUInt32();
                                }
                            } else {
                                this.f421208d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f421207c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f421206b = codedInputByteBufferNano.readString();
                    }
                } else {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                        this.f421205a = readInt32;
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
        int i3 = this.f421205a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.f421206b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f421206b);
        }
        if (!this.f421207c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f421207c);
        }
        if (!this.f421208d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f421208d);
        }
        int i16 = this.f421209e;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        boolean z16 = this.f421210f;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z16);
        }
        a aVar = this.f421211g;
        if (aVar != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, aVar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f421205a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.f421206b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f421206b);
        }
        if (!this.f421207c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f421207c);
        }
        if (!this.f421208d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f421208d);
        }
        int i16 = this.f421209e;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        boolean z16 = this.f421210f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        a aVar = this.f421211g;
        if (aVar != null) {
            codedOutputByteBufferNano.writeMessage(7, aVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
