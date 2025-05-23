package cr4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class a extends ExtendableMessageNano<a> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f391705a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f391706b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f391707c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f391708d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f391709e;

    public a() {
        a();
    }

    public a a() {
        this.f391705a = false;
        this.f391706b = false;
        this.f391707c = false;
        this.f391708d = false;
        this.f391709e = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag != 8) {
                    if (readTag != 16) {
                        if (readTag != 24) {
                            if (readTag != 32) {
                                if (readTag != 40) {
                                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                                        return this;
                                    }
                                } else {
                                    this.f391709e = codedInputByteBufferNano.readBool();
                                }
                            } else {
                                this.f391708d = codedInputByteBufferNano.readBool();
                            }
                        } else {
                            this.f391707c = codedInputByteBufferNano.readBool();
                        }
                    } else {
                        this.f391706b = codedInputByteBufferNano.readBool();
                    }
                } else {
                    this.f391705a = codedInputByteBufferNano.readBool();
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
        boolean z16 = this.f391705a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        boolean z17 = this.f391706b;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z17);
        }
        boolean z18 = this.f391707c;
        if (z18) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z18);
        }
        boolean z19 = this.f391708d;
        if (z19) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z19);
        }
        boolean z26 = this.f391709e;
        if (z26) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z26);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f391705a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        boolean z17 = this.f391706b;
        if (z17) {
            codedOutputByteBufferNano.writeBool(2, z17);
        }
        boolean z18 = this.f391707c;
        if (z18) {
            codedOutputByteBufferNano.writeBool(3, z18);
        }
        boolean z19 = this.f391708d;
        if (z19) {
            codedOutputByteBufferNano.writeBool(4, z19);
        }
        boolean z26 = this.f391709e;
        if (z26) {
            codedOutputByteBufferNano.writeBool(5, z26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
