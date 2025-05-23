package dz0;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class e extends ExtendableMessageNano<e> {

    /* renamed from: a, reason: collision with root package name */
    public int f395253a;

    /* renamed from: b, reason: collision with root package name */
    public int f395254b;

    /* renamed from: c, reason: collision with root package name */
    public String f395255c;

    /* renamed from: d, reason: collision with root package name */
    public String f395256d;

    /* renamed from: e, reason: collision with root package name */
    public String f395257e;

    /* renamed from: f, reason: collision with root package name */
    public String f395258f;

    /* renamed from: g, reason: collision with root package name */
    public String f395259g;

    public e() {
        a();
    }

    public e a() {
        this.f395253a = 0;
        this.f395254b = 0;
        this.f395255c = "";
        this.f395256d = "";
        this.f395257e = "";
        this.f395258f = "";
        this.f395259g = "";
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
                                            this.f395259g = codedInputByteBufferNano.readString();
                                        }
                                    } else {
                                        this.f395258f = codedInputByteBufferNano.readString();
                                    }
                                } else {
                                    this.f395257e = codedInputByteBufferNano.readString();
                                }
                            } else {
                                this.f395256d = codedInputByteBufferNano.readString();
                            }
                        } else {
                            this.f395255c = codedInputByteBufferNano.readString();
                        }
                    } else {
                        this.f395254b = codedInputByteBufferNano.readUInt32();
                    }
                } else {
                    this.f395253a = codedInputByteBufferNano.readUInt32();
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
        int i3 = this.f395253a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.f395254b;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        if (!this.f395255c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f395255c);
        }
        if (!this.f395256d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f395256d);
        }
        if (!this.f395257e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f395257e);
        }
        if (!this.f395258f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f395258f);
        }
        if (!this.f395259g.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.f395259g);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f395253a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.f395254b;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        if (!this.f395255c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f395255c);
        }
        if (!this.f395256d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f395256d);
        }
        if (!this.f395257e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f395257e);
        }
        if (!this.f395258f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f395258f);
        }
        if (!this.f395259g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f395259g);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
