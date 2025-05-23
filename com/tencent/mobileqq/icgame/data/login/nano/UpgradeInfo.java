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
public final class UpgradeInfo extends ExtendableMessageNano<UpgradeInfo> {
    private static volatile UpgradeInfo[] _emptyArray;
    public String jumpUrl;

    public UpgradeInfo() {
        clear();
    }

    public static UpgradeInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UpgradeInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UpgradeInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UpgradeInfo) MessageNano.mergeFrom(new UpgradeInfo(), bArr);
    }

    public UpgradeInfo clear() {
        this.jumpUrl = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.jumpUrl.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.jumpUrl);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.jumpUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UpgradeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UpgradeInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UpgradeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.jumpUrl = codedInputByteBufferNano.readString();
            }
        }
    }
}
