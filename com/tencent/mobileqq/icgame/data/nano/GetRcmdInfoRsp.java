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
public final class GetRcmdInfoRsp extends ExtendableMessageNano<GetRcmdInfoRsp> {
    private static volatile GetRcmdInfoRsp[] _emptyArray;
    public long anchorUid;
    public String logoUrl;
    public String nick;
    public String rcmdWord;
    public long roomId;

    public GetRcmdInfoRsp() {
        clear();
    }

    public static GetRcmdInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRcmdInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRcmdInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRcmdInfoRsp) MessageNano.mergeFrom(new GetRcmdInfoRsp(), bArr);
    }

    public GetRcmdInfoRsp clear() {
        this.logoUrl = "";
        this.nick = "";
        this.rcmdWord = "";
        this.roomId = 0L;
        this.anchorUid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.logoUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.logoUrl);
        }
        if (!this.nick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.nick);
        }
        if (!this.rcmdWord.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.rcmdWord);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        long j16 = this.anchorUid;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.logoUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.logoUrl);
        }
        if (!this.nick.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.nick);
        }
        if (!this.rcmdWord.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.rcmdWord);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        long j16 = this.anchorUid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRcmdInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRcmdInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRcmdInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.logoUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.nick = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.rcmdWord = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
