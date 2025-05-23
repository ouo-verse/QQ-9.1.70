package as4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes39.dex */
public final class d extends ExtendableMessageNano<d> {

    /* renamed from: a, reason: collision with root package name */
    public int f26886a;

    /* renamed from: b, reason: collision with root package name */
    public long f26887b;

    /* renamed from: c, reason: collision with root package name */
    public long f26888c;

    /* renamed from: d, reason: collision with root package name */
    public int f26889d;

    /* renamed from: e, reason: collision with root package name */
    public String f26890e;

    /* renamed from: f, reason: collision with root package name */
    public String f26891f;

    /* renamed from: g, reason: collision with root package name */
    public String f26892g;

    /* renamed from: h, reason: collision with root package name */
    public String f26893h;

    /* renamed from: i, reason: collision with root package name */
    public int f26894i;

    public d() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 != 0 && readInt32 != 1 && readInt32 != 2 && readInt32 != 3 && readInt32 != 4 && readInt32 != 999) {
                    switch (readInt32) {
                    }
                }
                this.f26886a = readInt32;
            } else if (readTag == 16) {
                this.f26887b = codedInputByteBufferNano.readInt64();
            } else if (readTag == 24) {
                this.f26888c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 32) {
                this.f26889d = codedInputByteBufferNano.readInt32();
            } else if (readTag == 42) {
                this.f26890e = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.f26891f = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                this.f26892g = codedInputByteBufferNano.readString();
            } else if (readTag == 66) {
                this.f26893h = codedInputByteBufferNano.readString();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f26894i = codedInputByteBufferNano.readInt32();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.f26886a;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        long j3 = this.f26887b;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j3);
        }
        long j16 = this.f26888c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        int i16 = this.f26889d;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i16);
        }
        if (!this.f26890e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f26890e);
        }
        if (!this.f26891f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f26891f);
        }
        if (!this.f26892g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.f26892g);
        }
        if (!this.f26893h.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.f26893h);
        }
        int i17 = this.f26894i;
        return i17 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(9, i17) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.f26886a;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        long j3 = this.f26887b;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j3);
        }
        long j16 = this.f26888c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        int i16 = this.f26889d;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i16);
        }
        if (!this.f26890e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f26890e);
        }
        if (!this.f26891f.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f26891f);
        }
        if (!this.f26892g.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.f26892g);
        }
        if (!this.f26893h.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.f26893h);
        }
        int i17 = this.f26894i;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public d a() {
        this.f26886a = 0;
        this.f26887b = 0L;
        this.f26888c = 0L;
        this.f26889d = 0;
        this.f26890e = "";
        this.f26891f = "";
        this.f26892g = "";
        this.f26893h = "";
        this.f26894i = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
