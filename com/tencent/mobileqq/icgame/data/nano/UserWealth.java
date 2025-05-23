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
public final class UserWealth extends ExtendableMessageNano<UserWealth> {
    private static volatile UserWealth[] _emptyArray;
    public String avatar;
    public int gender;
    public String name;
    public long uid;
    public int wealth;

    public UserWealth() {
        clear();
    }

    public static UserWealth[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserWealth[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserWealth parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserWealth) MessageNano.mergeFrom(new UserWealth(), bArr);
    }

    public UserWealth clear() {
        this.uid = 0L;
        this.wealth = 0;
        this.name = "";
        this.avatar = "";
        this.gender = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt64Size(1, this.uid) + CodedOutputByteBufferNano.computeUInt32Size(2, this.wealth);
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.name);
        }
        if (!this.avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.avatar);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.uid);
        codedOutputByteBufferNano.writeUInt32(2, this.wealth);
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.name);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.avatar);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserWealth parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserWealth().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserWealth mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.wealth = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.avatar = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.gender = readInt32;
                }
            }
        }
    }
}
