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
public final class SetUserVoiceCoverReq extends ExtendableMessageNano<SetUserVoiceCoverReq> {
    private static volatile SetUserVoiceCoverReq[] _emptyArray;
    public UserVoiceCover userVoiceCover;

    public SetUserVoiceCoverReq() {
        clear();
    }

    public static SetUserVoiceCoverReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SetUserVoiceCoverReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static SetUserVoiceCoverReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (SetUserVoiceCoverReq) MessageNano.mergeFrom(new SetUserVoiceCoverReq(), bArr);
    }

    public SetUserVoiceCoverReq clear() {
        this.userVoiceCover = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserVoiceCover userVoiceCover = this.userVoiceCover;
        if (userVoiceCover != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, userVoiceCover);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserVoiceCover userVoiceCover = this.userVoiceCover;
        if (userVoiceCover != null) {
            codedOutputByteBufferNano.writeMessage(1, userVoiceCover);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static SetUserVoiceCoverReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new SetUserVoiceCoverReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public SetUserVoiceCoverReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag != 10) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.userVoiceCover == null) {
                    this.userVoiceCover = new UserVoiceCover();
                }
                codedInputByteBufferNano.readMessage(this.userVoiceCover);
            }
        }
    }
}
