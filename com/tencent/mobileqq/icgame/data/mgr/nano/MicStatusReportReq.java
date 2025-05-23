package com.tencent.mobileqq.icgame.data.mgr.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.icgame.data.av.nano.Extinfo;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class MicStatusReportReq extends ExtendableMessageNano<MicStatusReportReq> {
    private static volatile MicStatusReportReq[] _emptyArray;
    public Extinfo extInfo;
    public int open;
    public int roomId;
    public int type;
    public long uid;

    public MicStatusReportReq() {
        clear();
    }

    public static MicStatusReportReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MicStatusReportReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MicStatusReportReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MicStatusReportReq) MessageNano.mergeFrom(new MicStatusReportReq(), bArr);
    }

    public MicStatusReportReq clear() {
        this.roomId = 0;
        this.uid = 0L;
        this.type = 0;
        this.open = 0;
        this.extInfo = null;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId) + CodedOutputByteBufferNano.computeUInt64Size(2, this.uid) + CodedOutputByteBufferNano.computeUInt32Size(3, this.type) + CodedOutputByteBufferNano.computeUInt32Size(4, this.open);
        Extinfo extinfo = this.extInfo;
        if (extinfo != null) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, extinfo);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        codedOutputByteBufferNano.writeUInt64(2, this.uid);
        codedOutputByteBufferNano.writeUInt32(3, this.type);
        codedOutputByteBufferNano.writeUInt32(4, this.open);
        Extinfo extinfo = this.extInfo;
        if (extinfo != null) {
            codedOutputByteBufferNano.writeMessage(5, extinfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MicStatusReportReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MicStatusReportReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MicStatusReportReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.uid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 24) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.open = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 42) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                if (this.extInfo == null) {
                    this.extInfo = new Extinfo();
                }
                codedInputByteBufferNano.readMessage(this.extInfo);
            }
        }
    }
}
