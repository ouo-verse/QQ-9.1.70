package ds4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public long f394790a;

    /* renamed from: b, reason: collision with root package name */
    public int f394791b;

    /* renamed from: c, reason: collision with root package name */
    public long f394792c;

    /* renamed from: d, reason: collision with root package name */
    public String f394793d;

    /* renamed from: e, reason: collision with root package name */
    public String f394794e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f394795f;

    public j() {
        a();
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f394790a = codedInputByteBufferNano.readInt64();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.f394791b = readInt32;
                }
            } else if (readTag == 24) {
                this.f394792c = codedInputByteBufferNano.readInt64();
            } else if (readTag == 34) {
                this.f394793d = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.f394794e = codedInputByteBufferNano.readString();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f394795f = codedInputByteBufferNano.readBool();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.f394790a;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j3);
        }
        int i3 = this.f394791b;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        long j16 = this.f394792c;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j16);
        }
        if (!this.f394793d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f394793d);
        }
        if (!this.f394794e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f394794e);
        }
        boolean z16 = this.f394795f;
        return z16 ? computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z16) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.f394790a;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(1, j3);
        }
        int i3 = this.f394791b;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        long j16 = this.f394792c;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j16);
        }
        if (!this.f394793d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f394793d);
        }
        if (!this.f394794e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f394794e);
        }
        boolean z16 = this.f394795f;
        if (z16) {
            codedOutputByteBufferNano.writeBool(6, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f394790a = 0L;
        this.f394791b = 0;
        this.f394792c = 0L;
        this.f394793d = "";
        this.f394794e = "";
        this.f394795f = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
