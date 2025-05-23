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
public final class UserInfo extends ExtendableMessageNano<UserInfo> {
    private static volatile UserInfo[] _emptyArray;
    public String headUrl;
    public long logoTimestamp;
    public String nickName;
    public int sex;
    public String signName;
    public long uid;

    public UserInfo() {
        clear();
    }

    public static UserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserInfo) MessageNano.mergeFrom(new UserInfo(), bArr);
    }

    public UserInfo clear() {
        this.uid = 0L;
        this.nickName = "";
        this.headUrl = "";
        this.sex = 0;
        this.signName = "";
        this.logoTimestamp = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.nickName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.nickName);
        }
        if (!this.headUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.headUrl);
        }
        int i3 = this.sex;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!this.signName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.signName);
        }
        long j16 = this.logoTimestamp;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.nickName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.nickName);
        }
        if (!this.headUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.headUrl);
        }
        int i3 = this.sex;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!this.signName.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.signName);
        }
        long j16 = this.logoTimestamp;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.nickName = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.headUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.sex = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.signName = codedInputByteBufferNano.readString();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.logoTimestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
