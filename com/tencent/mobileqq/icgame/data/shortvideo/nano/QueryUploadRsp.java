package com.tencent.mobileqq.icgame.data.shortvideo.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class QueryUploadRsp extends ExtendableMessageNano<QueryUploadRsp> {
    private static volatile QueryUploadRsp[] _emptyArray;
    public String cdnDomain;
    public String cosAppid;
    public String cosBucket;
    public String cosFilepath;
    public String cosRegion;
    public String errMsg;
    public String fileId;
    public int maxFileSize;
    public int retcode;
    public TmpAuth tmpAuth;

    public QueryUploadRsp() {
        clear();
    }

    public static QueryUploadRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QueryUploadRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QueryUploadRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QueryUploadRsp) MessageNano.mergeFrom(new QueryUploadRsp(), bArr);
    }

    public QueryUploadRsp clear() {
        this.retcode = 0;
        this.errMsg = "";
        this.cdnDomain = "";
        this.cosAppid = "";
        this.cosBucket = "";
        this.cosFilepath = "";
        this.cosRegion = "";
        this.tmpAuth = null;
        this.fileId = "";
        this.maxFileSize = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retcode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        if (!this.errMsg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.errMsg);
        }
        if (!this.cdnDomain.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.cdnDomain);
        }
        if (!this.cosAppid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.cosAppid);
        }
        if (!this.cosBucket.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.cosBucket);
        }
        if (!this.cosFilepath.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.cosFilepath);
        }
        if (!this.cosRegion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.cosRegion);
        }
        TmpAuth tmpAuth = this.tmpAuth;
        if (tmpAuth != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, tmpAuth);
        }
        if (!this.fileId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.fileId);
        }
        int i16 = this.maxFileSize;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(10, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.errMsg);
        }
        if (!this.cdnDomain.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.cdnDomain);
        }
        if (!this.cosAppid.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.cosAppid);
        }
        if (!this.cosBucket.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.cosBucket);
        }
        if (!this.cosFilepath.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.cosFilepath);
        }
        if (!this.cosRegion.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.cosRegion);
        }
        TmpAuth tmpAuth = this.tmpAuth;
        if (tmpAuth != null) {
            codedOutputByteBufferNano.writeMessage(8, tmpAuth);
        }
        if (!this.fileId.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.fileId);
        }
        int i16 = this.maxFileSize;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QueryUploadRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QueryUploadRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QueryUploadRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.retcode = codedInputByteBufferNano.readInt32();
                    break;
                case 18:
                    this.errMsg = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.cdnDomain = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.cosAppid = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.cosBucket = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.cosFilepath = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.cosRegion = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    if (this.tmpAuth == null) {
                        this.tmpAuth = new TmpAuth();
                    }
                    codedInputByteBufferNano.readMessage(this.tmpAuth);
                    break;
                case 74:
                    this.fileId = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.maxFileSize = codedInputByteBufferNano.readUInt32();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
