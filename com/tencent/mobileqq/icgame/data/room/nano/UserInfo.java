package com.tencent.mobileqq.icgame.data.room.nano;

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
    public String avatar;
    public int gender;
    public int hasSecondIdentity;
    public String name;
    public long uid;
    public int userType;

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
        this.name = "";
        this.gender = 0;
        this.userType = 0;
        this.avatar = "";
        this.hasSecondIdentity = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid);
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i16 = this.userType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.avatar);
        }
        int i17 = this.hasSecondIdentity;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i16 = this.userType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.avatar);
        }
        int i17 = this.hasSecondIdentity;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i17);
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
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.gender = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.userType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.avatar = codedInputByteBufferNano.readString();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.hasSecondIdentity = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
