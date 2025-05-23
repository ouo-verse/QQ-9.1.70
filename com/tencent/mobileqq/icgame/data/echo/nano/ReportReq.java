package com.tencent.mobileqq.icgame.data.echo.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ReportReq extends ExtendableMessageNano<ReportReq> {
    private static volatile ReportReq[] _emptyArray;
    public String category;
    public String feedId;

    /* renamed from: msg, reason: collision with root package name */
    public String f237258msg;
    public long msgSendTime;
    public int msgType;
    public String replyId;
    public long tinyId;
    public int type;
    public long uid;

    public ReportReq() {
        clear();
    }

    public static ReportReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportReq) MessageNano.mergeFrom(new ReportReq(), bArr);
    }

    public ReportReq clear() {
        this.type = 0;
        this.tinyId = 0L;
        this.category = "";
        this.msgType = 0;
        this.f237258msg = "";
        this.feedId = "";
        this.replyId = "";
        this.msgSendTime = 0L;
        this.uid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        long j3 = this.tinyId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.category.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.category);
        }
        int i16 = this.msgType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        if (!this.f237258msg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.f237258msg);
        }
        if (!this.feedId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.feedId);
        }
        if (!this.replyId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.replyId);
        }
        long j16 = this.msgSendTime;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j16);
        }
        long j17 = this.uid;
        if (j17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(9, j17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        long j3 = this.tinyId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.category.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.category);
        }
        int i16 = this.msgType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        if (!this.f237258msg.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.f237258msg);
        }
        if (!this.feedId.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.feedId);
        }
        if (!this.replyId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.replyId);
        }
        long j16 = this.msgSendTime;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j16);
        }
        long j17 = this.uid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.tinyId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 26) {
                this.category = codedInputByteBufferNano.readString();
            } else if (readTag == 32) {
                this.msgType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.f237258msg = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.feedId = codedInputByteBufferNano.readString();
            } else if (readTag == 58) {
                this.replyId = codedInputByteBufferNano.readString();
            } else if (readTag == 64) {
                this.msgSendTime = codedInputByteBufferNano.readUInt64();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uid = codedInputByteBufferNano.readUInt64();
            }
        }
    }
}
