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
public final class AnimList extends ExtendableMessageNano<AnimList> {
    private static volatile AnimList[] _emptyArray;
    public String animType;
    public String animUrl;

    public AnimList() {
        clear();
    }

    public static AnimList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnimList[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnimList parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnimList) MessageNano.mergeFrom(new AnimList(), bArr);
    }

    public AnimList clear() {
        this.animUrl = "";
        this.animType = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.animUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.animUrl);
        }
        if (!this.animType.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.animType);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.animUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.animUrl);
        }
        if (!this.animType.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.animType);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnimList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnimList().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnimList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.animUrl = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.animType = codedInputByteBufferNano.readString();
            }
        }
    }
}
