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
public final class ConfItem extends ExtendableMessageNano<ConfItem> {
    private static volatile ConfItem[] _emptyArray;
    public String key;
    public String val;

    public ConfItem() {
        clear();
    }

    public static ConfItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ConfItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ConfItem parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ConfItem) MessageNano.mergeFrom(new ConfItem(), bArr);
    }

    public ConfItem clear() {
        this.key = "";
        this.val = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.key.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.key);
        }
        if (!this.val.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.val);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.key.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.key);
        }
        if (!this.val.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.val);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ConfItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ConfItem().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ConfItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.key = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.val = codedInputByteBufferNano.readString();
            }
        }
    }
}
