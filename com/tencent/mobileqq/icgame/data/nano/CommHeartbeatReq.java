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
public final class CommHeartbeatReq extends ExtendableMessageNano<CommHeartbeatReq> {
    private static volatile CommHeartbeatReq[] _emptyArray;
    public int roomId;
    public SeqInfo[] seqInfos;

    public CommHeartbeatReq() {
        clear();
    }

    public static CommHeartbeatReq[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommHeartbeatReq[0];
                }
            }
        }
        return _emptyArray;
    }

    public static CommHeartbeatReq parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (CommHeartbeatReq) MessageNano.mergeFrom(new CommHeartbeatReq(), bArr);
    }

    public CommHeartbeatReq clear() {
        this.roomId = 0;
        this.seqInfos = SeqInfo.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.roomId);
        SeqInfo[] seqInfoArr = this.seqInfos;
        if (seqInfoArr != null && seqInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                SeqInfo[] seqInfoArr2 = this.seqInfos;
                if (i3 >= seqInfoArr2.length) {
                    break;
                }
                SeqInfo seqInfo = seqInfoArr2[i3];
                if (seqInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, seqInfo);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.roomId);
        SeqInfo[] seqInfoArr = this.seqInfos;
        if (seqInfoArr != null && seqInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                SeqInfo[] seqInfoArr2 = this.seqInfos;
                if (i3 >= seqInfoArr2.length) {
                    break;
                }
                SeqInfo seqInfo = seqInfoArr2[i3];
                if (seqInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, seqInfo);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static CommHeartbeatReq parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new CommHeartbeatReq().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public CommHeartbeatReq mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.roomId = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                SeqInfo[] seqInfoArr = this.seqInfos;
                int length = seqInfoArr == null ? 0 : seqInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                SeqInfo[] seqInfoArr2 = new SeqInfo[i3];
                if (length != 0) {
                    System.arraycopy(seqInfoArr, 0, seqInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    SeqInfo seqInfo = new SeqInfo();
                    seqInfoArr2[length] = seqInfo;
                    codedInputByteBufferNano.readMessage(seqInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                SeqInfo seqInfo2 = new SeqInfo();
                seqInfoArr2[length] = seqInfo2;
                codedInputByteBufferNano.readMessage(seqInfo2);
                this.seqInfos = seqInfoArr2;
            }
        }
    }
}
