package gw4;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class g extends ExtendableMessageNano<g> {

    /* renamed from: a, reason: collision with root package name */
    public boolean f403475a;

    /* renamed from: b, reason: collision with root package name */
    public String f403476b;

    /* renamed from: c, reason: collision with root package name */
    public String f403477c;

    /* renamed from: d, reason: collision with root package name */
    public String f403478d;

    public g() {
        a();
    }

    public static g c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (g) MessageNano.mergeFrom(new g(), bArr);
    }

    @Override // com.google.protobuf.nano.MessageNano
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.f403475a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                this.f403476b = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.f403477c = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.f403478d = codedInputByteBufferNano.readString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.f403475a;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        if (!this.f403476b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.f403476b);
        }
        if (!this.f403477c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.f403477c);
        }
        return !this.f403478d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.f403478d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.f403475a;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        if (!this.f403476b.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.f403476b);
        }
        if (!this.f403477c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.f403477c);
        }
        if (!this.f403478d.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.f403478d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public g a() {
        this.f403475a = false;
        this.f403476b = "";
        this.f403477c = "";
        this.f403478d = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }
}
