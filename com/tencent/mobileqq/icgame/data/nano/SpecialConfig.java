package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class SpecialConfig extends ExtendableMessageNano<SpecialConfig> {
    private static volatile SpecialConfig[] _emptyArray;
    public String urlNameplate;
    public String urlPrecipitate;

    public SpecialConfig() {
        clear();
    }

    public static SpecialConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SpecialConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SpecialConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SpecialConfig) MessageNano.mergeFrom(new SpecialConfig(), bArr);
    }

    public SpecialConfig clear() {
        this.urlPrecipitate = "";
        this.urlNameplate = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.urlPrecipitate.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.urlPrecipitate);
        }
        if (!this.urlNameplate.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.urlNameplate);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.urlPrecipitate.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.urlPrecipitate);
        }
        if (!this.urlNameplate.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.urlNameplate);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SpecialConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SpecialConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SpecialConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.urlPrecipitate = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.urlNameplate = codedInputByteBufferNano.readString();
            }
        }
    }
}
