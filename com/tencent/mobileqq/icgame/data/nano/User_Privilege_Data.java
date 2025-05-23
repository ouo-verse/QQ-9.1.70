package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* loaded from: classes15.dex */
public final class User_Privilege_Data extends ExtendableMessageNano<User_Privilege_Data> {
    private static volatile User_Privilege_Data[] _emptyArray;
    public long uint64Uin;
    public Privilege_Time_Data userPrivilege;

    public User_Privilege_Data() {
        clear();
    }

    public static User_Privilege_Data[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new User_Privilege_Data[0];
                }
            }
        }
        return _emptyArray;
    }

    public static User_Privilege_Data parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (User_Privilege_Data) MessageNano.mergeFrom(new User_Privilege_Data(), bArr);
    }

    public User_Privilege_Data clear() {
        this.uint64Uin = 0L;
        this.userPrivilege = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uint64Uin;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        Privilege_Time_Data privilege_Time_Data = this.userPrivilege;
        if (privilege_Time_Data != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, privilege_Time_Data);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uint64Uin;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        Privilege_Time_Data privilege_Time_Data = this.userPrivilege;
        if (privilege_Time_Data != null) {
            codedOutputByteBufferNano.writeMessage(2, privilege_Time_Data);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static User_Privilege_Data parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new User_Privilege_Data().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public User_Privilege_Data mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uint64Uin = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.userPrivilege == null) {
                    this.userPrivilege = new Privilege_Time_Data();
                }
                codedInputByteBufferNano.readMessage(this.userPrivilege);
            }
        }
    }
}
