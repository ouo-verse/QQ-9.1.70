package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GetUserVoiceCoverRsp extends ExtendableMessageNano<GetUserVoiceCoverRsp> {
    private static volatile GetUserVoiceCoverRsp[] _emptyArray;
    public UserVoiceCover[] userVoiceCover;

    public GetUserVoiceCoverRsp() {
        clear();
    }

    public static GetUserVoiceCoverRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetUserVoiceCoverRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetUserVoiceCoverRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetUserVoiceCoverRsp) MessageNano.mergeFrom(new GetUserVoiceCoverRsp(), bArr);
    }

    public GetUserVoiceCoverRsp clear() {
        this.userVoiceCover = UserVoiceCover.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        UserVoiceCover[] userVoiceCoverArr = this.userVoiceCover;
        if (userVoiceCoverArr != null && userVoiceCoverArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserVoiceCover[] userVoiceCoverArr2 = this.userVoiceCover;
                if (i3 >= userVoiceCoverArr2.length) {
                    break;
                }
                UserVoiceCover userVoiceCover = userVoiceCoverArr2[i3];
                if (userVoiceCover != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userVoiceCover);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserVoiceCover[] userVoiceCoverArr = this.userVoiceCover;
        if (userVoiceCoverArr != null && userVoiceCoverArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserVoiceCover[] userVoiceCoverArr2 = this.userVoiceCover;
                if (i3 >= userVoiceCoverArr2.length) {
                    break;
                }
                UserVoiceCover userVoiceCover = userVoiceCoverArr2[i3];
                if (userVoiceCover != null) {
                    codedOutputByteBufferNano.writeMessage(1, userVoiceCover);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetUserVoiceCoverRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetUserVoiceCoverRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetUserVoiceCoverRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                UserVoiceCover[] userVoiceCoverArr = this.userVoiceCover;
                int length = userVoiceCoverArr == null ? 0 : userVoiceCoverArr.length;
                int i3 = repeatedFieldArrayLength + length;
                UserVoiceCover[] userVoiceCoverArr2 = new UserVoiceCover[i3];
                if (length != 0) {
                    System.arraycopy(userVoiceCoverArr, 0, userVoiceCoverArr2, 0, length);
                }
                while (length < i3 - 1) {
                    UserVoiceCover userVoiceCover = new UserVoiceCover();
                    userVoiceCoverArr2[length] = userVoiceCover;
                    codedInputByteBufferNano.readMessage(userVoiceCover);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                UserVoiceCover userVoiceCover2 = new UserVoiceCover();
                userVoiceCoverArr2[length] = userVoiceCover2;
                codedInputByteBufferNano.readMessage(userVoiceCover2);
                this.userVoiceCover = userVoiceCoverArr2;
            }
        }
    }
}
