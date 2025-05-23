package hs4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class j extends ExtendableMessageNano<j> {

    /* renamed from: a, reason: collision with root package name */
    public double f406153a;

    /* renamed from: b, reason: collision with root package name */
    public double f406154b;

    /* renamed from: c, reason: collision with root package name */
    public String f406155c;

    /* renamed from: d, reason: collision with root package name */
    public String f406156d;

    /* renamed from: e, reason: collision with root package name */
    public String f406157e;

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
            if (readTag == 9) {
                this.f406153a = codedInputByteBufferNano.readDouble();
            } else if (readTag == 17) {
                this.f406154b = codedInputByteBufferNano.readDouble();
            } else if (readTag == 26) {
                this.f406155c = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.f406156d = codedInputByteBufferNano.readString();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f406157e = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (Double.doubleToLongBits(this.f406153a) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(1, this.f406153a);
        }
        if (Double.doubleToLongBits(this.f406154b) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.f406154b);
        }
        if (!this.f406155c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f406155c);
        }
        if (!this.f406156d.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.f406156d);
        }
        return !this.f406157e.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.f406157e) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (Double.doubleToLongBits(this.f406153a) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(1, this.f406153a);
        }
        if (Double.doubleToLongBits(this.f406154b) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.f406154b);
        }
        if (!this.f406155c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f406155c);
        }
        if (!this.f406156d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f406156d);
        }
        if (!this.f406157e.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f406157e);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public j a() {
        this.f406153a = 0.0d;
        this.f406154b = 0.0d;
        this.f406155c = "";
        this.f406156d = "";
        this.f406157e = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
