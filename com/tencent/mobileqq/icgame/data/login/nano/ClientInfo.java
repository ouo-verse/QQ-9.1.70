package com.tencent.mobileqq.icgame.data.login.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ClientInfo extends ExtendableMessageNano<ClientInfo> {
    private static volatile ClientInfo[] _emptyArray;
    public String key;
    public String value;

    public ClientInfo() {
        clear();
    }

    public static ClientInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ClientInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ClientInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ClientInfo) MessageNano.mergeFrom(new ClientInfo(), bArr);
    }

    public ClientInfo clear() {
        this.key = "";
        this.value = "";
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
        if (!this.value.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.value);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.key.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.key);
        }
        if (!this.value.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.value);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ClientInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ClientInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ClientInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                this.value = codedInputByteBufferNano.readString();
            }
        }
    }
}
