package com.tencent.mobileqq.icgame.data.lucky.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class User extends ExtendableMessageNano<User> {
    private static volatile User[] _emptyArray;
    public String icon;
    public String nick;

    public User() {
        clear();
    }

    public static User[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new User[0];
                }
            }
        }
        return _emptyArray;
    }

    public static User parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (User) MessageNano.mergeFrom(new User(), bArr);
    }

    public User clear() {
        this.nick = "";
        this.icon = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.nick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.nick);
        }
        if (!this.icon.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.icon);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.nick.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.nick);
        }
        if (!this.icon.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.icon);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static User parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new User().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public User mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.nick = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.icon = codedInputByteBufferNano.readString();
            }
        }
    }
}
