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
public final class ReportInfo extends ExtendableMessageNano<ReportInfo> {
    private static volatile ReportInfo[] _emptyArray;
    public String category;
    public String feedId;

    /* renamed from: msg, reason: collision with root package name */
    public String f237257msg;
    public int msgType;
    public String replyId;
    public String reportId;
    public long reporterTinyId;
    public long reporterUid;
    public int status;
    public long tinyId;
    public int type;
    public long uid;

    public ReportInfo() {
        clear();
    }

    public static ReportInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReportInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReportInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReportInfo) MessageNano.mergeFrom(new ReportInfo(), bArr);
    }

    public ReportInfo clear() {
        this.reportId = "";
        this.reporterTinyId = 0L;
        this.type = 0;
        this.tinyId = 0L;
        this.category = "";
        this.f237257msg = "";
        this.msgType = 0;
        this.feedId = "";
        this.replyId = "";
        this.status = 0;
        this.reporterUid = 0L;
        this.uid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.reportId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.reportId);
        }
        long j3 = this.reporterTinyId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        long j16 = this.tinyId;
        if (j16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j16);
        }
        if (!this.category.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.category);
        }
        if (!this.f237257msg.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.f237257msg);
        }
        int i16 = this.msgType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        if (!this.feedId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.feedId);
        }
        if (!this.replyId.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.replyId);
        }
        int i17 = this.status;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i17);
        }
        long j17 = this.reporterUid;
        if (j17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j17);
        }
        long j18 = this.uid;
        if (j18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(12, j18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.reportId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.reportId);
        }
        long j3 = this.reporterTinyId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        long j16 = this.tinyId;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j16);
        }
        if (!this.category.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.category);
        }
        if (!this.f237257msg.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.f237257msg);
        }
        int i16 = this.msgType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        if (!this.feedId.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.feedId);
        }
        if (!this.replyId.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.replyId);
        }
        int i17 = this.status;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i17);
        }
        long j17 = this.reporterUid;
        if (j17 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j17);
        }
        long j18 = this.uid;
        if (j18 != 0) {
            codedOutputByteBufferNano.writeUInt64(12, j18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReportInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReportInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReportInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.reportId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.reporterTinyId = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.type = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.tinyId = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    this.category = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.f237257msg = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.msgType = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.feedId = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.replyId = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.status = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.reporterUid = codedInputByteBufferNano.readUInt64();
                    break;
                case 96:
                    this.uid = codedInputByteBufferNano.readUInt64();
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
