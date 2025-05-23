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
public final class ChatModeUserInfo extends ExtendableMessageNano<ChatModeUserInfo> {
    private static volatile ChatModeUserInfo[] _emptyArray;
    public int age;
    public String avatar;
    public String city;
    public int gender;
    public String name;
    public String province;
    public long uid;

    public ChatModeUserInfo() {
        clear();
    }

    public static ChatModeUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ChatModeUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ChatModeUserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ChatModeUserInfo) MessageNano.mergeFrom(new ChatModeUserInfo(), bArr);
    }

    public ChatModeUserInfo clear() {
        this.name = "";
        this.gender = 0;
        this.province = "";
        this.city = "";
        this.age = 0;
        this.avatar = "";
        this.uid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.province.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.province);
        }
        if (!this.city.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.city);
        }
        int i16 = this.age;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        if (!this.avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.avatar);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(7, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.province.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.province);
        }
        if (!this.city.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.city);
        }
        int i16 = this.age;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.avatar);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(7, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ChatModeUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ChatModeUserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ChatModeUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.gender = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                this.province = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.city = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.age = codedInputByteBufferNano.readInt32();
            } else if (readTag == 50) {
                this.avatar = codedInputByteBufferNano.readString();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uid = codedInputByteBufferNano.readInt64();
            }
        }
    }
}
