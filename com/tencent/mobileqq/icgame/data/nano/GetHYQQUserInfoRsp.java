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
public final class GetHYQQUserInfoRsp extends ExtendableMessageNano<GetHYQQUserInfoRsp> {
    private static volatile GetHYQQUserInfoRsp[] _emptyArray;
    public int hasSecondIdentity;
    public String hyAvatar;
    public String hyName;
    public int infoType;
    public String qqAvatar;
    public String qqName;
    public long uid;

    public GetHYQQUserInfoRsp() {
        clear();
    }

    public static GetHYQQUserInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetHYQQUserInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetHYQQUserInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetHYQQUserInfoRsp) MessageNano.mergeFrom(new GetHYQQUserInfoRsp(), bArr);
    }

    public GetHYQQUserInfoRsp clear() {
        this.uid = 0L;
        this.qqName = "";
        this.qqAvatar = "";
        this.hyName = "";
        this.hyAvatar = "";
        this.infoType = 0;
        this.hasSecondIdentity = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        if (!this.qqName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.qqName);
        }
        if (!this.qqAvatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.qqAvatar);
        }
        if (!this.hyName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.hyName);
        }
        if (!this.hyAvatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.hyAvatar);
        }
        int i3 = this.infoType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        int i16 = this.hasSecondIdentity;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        if (!this.qqName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.qqName);
        }
        if (!this.qqAvatar.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.qqAvatar);
        }
        if (!this.hyName.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.hyName);
        }
        if (!this.hyAvatar.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.hyAvatar);
        }
        int i3 = this.infoType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        int i16 = this.hasSecondIdentity;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetHYQQUserInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetHYQQUserInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetHYQQUserInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 18) {
                this.qqName = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.qqAvatar = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.hyName = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.hyAvatar = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                this.infoType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 56) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.hasSecondIdentity = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
