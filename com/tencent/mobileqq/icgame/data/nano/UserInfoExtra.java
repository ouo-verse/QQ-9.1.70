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
public final class UserInfoExtra extends ExtendableMessageNano<UserInfoExtra> {
    private static volatile UserInfoExtra[] _emptyArray;
    public int favorRoomCount;
    public int subscribeCount;

    public UserInfoExtra() {
        clear();
    }

    public static UserInfoExtra[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserInfoExtra[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserInfoExtra parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserInfoExtra) MessageNano.mergeFrom(new UserInfoExtra(), bArr);
    }

    public UserInfoExtra clear() {
        this.favorRoomCount = 0;
        this.subscribeCount = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.favorRoomCount;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(201, i3);
        }
        int i16 = this.subscribeCount;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(202, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.favorRoomCount;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(201, i3);
        }
        int i16 = this.subscribeCount;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(202, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserInfoExtra parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserInfoExtra().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserInfoExtra mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 1608) {
                this.favorRoomCount = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 1616) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.subscribeCount = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
