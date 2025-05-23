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
public final class UserIdentityInfo extends ExtendableMessageNano<UserIdentityInfo> {
    private static volatile UserIdentityInfo[] _emptyArray;
    public ManagerInfo managerInfo;
    public long userId;
    public int userIdentity;

    public UserIdentityInfo() {
        clear();
    }

    public static UserIdentityInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserIdentityInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserIdentityInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserIdentityInfo) MessageNano.mergeFrom(new UserIdentityInfo(), bArr);
    }

    public UserIdentityInfo clear() {
        this.userIdentity = 0;
        this.managerInfo = null;
        this.userId = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.userIdentity;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        ManagerInfo managerInfo = this.managerInfo;
        if (managerInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, managerInfo);
        }
        long j3 = this.userId;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.userIdentity;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        ManagerInfo managerInfo = this.managerInfo;
        if (managerInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, managerInfo);
        }
        long j3 = this.userId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserIdentityInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserIdentityInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserIdentityInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.userIdentity = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                if (this.managerInfo == null) {
                    this.managerInfo = new ManagerInfo();
                }
                codedInputByteBufferNano.readMessage(this.managerInfo);
            } else if (readTag != 24) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.userId = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
