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
public final class BehaviourToUserInfo extends ExtendableMessageNano<BehaviourToUserInfo> {
    private static volatile BehaviourToUserInfo[] _emptyArray;
    public int adoreScore;
    public boolean isSubscribe;
    public int subscribeState;

    public BehaviourToUserInfo() {
        clear();
    }

    public static BehaviourToUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BehaviourToUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static BehaviourToUserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (BehaviourToUserInfo) MessageNano.mergeFrom(new BehaviourToUserInfo(), bArr);
    }

    public BehaviourToUserInfo clear() {
        this.isSubscribe = false;
        this.adoreScore = 0;
        this.subscribeState = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.isSubscribe;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(401, z16);
        }
        int i3 = this.adoreScore;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(402, i3);
        }
        int i16 = this.subscribeState;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(403, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.isSubscribe;
        if (z16) {
            codedOutputByteBufferNano.writeBool(401, z16);
        }
        int i3 = this.adoreScore;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(402, i3);
        }
        int i16 = this.subscribeState;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(403, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static BehaviourToUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new BehaviourToUserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public BehaviourToUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 3208) {
                this.isSubscribe = codedInputByteBufferNano.readBool();
            } else if (readTag == 3216) {
                this.adoreScore = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 3224) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.subscribeState = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
