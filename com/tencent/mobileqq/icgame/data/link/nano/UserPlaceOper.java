package com.tencent.mobileqq.icgame.data.link.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class UserPlaceOper extends ExtendableMessageNano<UserPlaceOper> {
    private static volatile UserPlaceOper[] _emptyArray;
    public int opType;
    public UserPlaceInfo placeInfo;

    public UserPlaceOper() {
        clear();
    }

    public static UserPlaceOper[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserPlaceOper[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserPlaceOper parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserPlaceOper) MessageNano.mergeFrom(new UserPlaceOper(), bArr);
    }

    public UserPlaceOper clear() {
        this.opType = 0;
        this.placeInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.opType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        UserPlaceInfo userPlaceInfo = this.placeInfo;
        if (userPlaceInfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, userPlaceInfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.opType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        UserPlaceInfo userPlaceInfo = this.placeInfo;
        if (userPlaceInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userPlaceInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserPlaceOper parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserPlaceOper().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserPlaceOper mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.opType = codedInputByteBufferNano.readInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.placeInfo == null) {
                    this.placeInfo = new UserPlaceInfo();
                }
                codedInputByteBufferNano.readMessage(this.placeInfo);
            }
        }
    }
}
