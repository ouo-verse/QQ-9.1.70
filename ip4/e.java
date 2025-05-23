package ip4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public int f408161a;

    /* renamed from: b, reason: collision with root package name */
    public int f408162b;

    /* renamed from: c, reason: collision with root package name */
    public String f408163c;

    /* renamed from: d, reason: collision with root package name */
    public String f408164d;

    /* renamed from: e, reason: collision with root package name */
    public String f408165e;

    /* renamed from: f, reason: collision with root package name */
    public String f408166f;

    /* renamed from: g, reason: collision with root package name */
    public String f408167g;

    public e() {
        a();
    }

    public e a() {
        this.f408161a = 0;
        this.f408162b = 0;
        this.f408163c = "";
        this.f408164d = "";
        this.f408165e = "";
        this.f408166f = "";
        this.f408167g = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 26) {
                            if (readTag != 34) {
                                if (readTag != 42) {
                                    if (readTag != 50) {
                                        if (readTag != 58) {
                                            if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                                return this;
                                            }
                                        } else {
                                            this.f408167g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f408166f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f408165e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f408164d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f408163c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f408162b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f408161a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f408161a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f408162b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f408163c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f408163c);
        }
        if (!this.f408164d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f408164d);
        }
        if (!this.f408165e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f408165e);
        }
        if (!this.f408166f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f408166f);
        }
        if (!this.f408167g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f408167g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f408161a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f408162b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f408163c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f408163c);
        }
        if (!this.f408164d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f408164d);
        }
        if (!this.f408165e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f408165e);
        }
        if (!this.f408166f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f408166f);
        }
        if (!this.f408167g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f408167g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
