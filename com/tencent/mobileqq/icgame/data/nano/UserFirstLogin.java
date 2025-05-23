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
public final class UserFirstLogin extends ExtendableMessageNano<UserFirstLogin> {
    private static volatile UserFirstLogin[] _emptyArray;
    public boolean isFirstLogin;

    public UserFirstLogin() {
        clear();
    }

    public static UserFirstLogin[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserFirstLogin[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UserFirstLogin parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UserFirstLogin) MessageNano.mergeFrom(new UserFirstLogin(), bArr);
    }

    public UserFirstLogin clear() {
        this.isFirstLogin = false;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z16 = this.isFirstLogin;
        if (z16) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(1, z16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z16 = this.isFirstLogin;
        if (z16) {
            codedOutputByteBufferNano.writeBool(1, z16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UserFirstLogin parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UserFirstLogin().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UserFirstLogin mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 8) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.isFirstLogin = codedInputByteBufferNano.readBool();
            }
        }
    }
}
