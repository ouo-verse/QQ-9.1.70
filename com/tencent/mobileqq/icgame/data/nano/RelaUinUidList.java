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
public final class RelaUinUidList extends ExtendableMessageNano<RelaUinUidList> {
    private static volatile RelaUinUidList[] _emptyArray;
    public int idType;
    public RelaUinUid[] list;

    public RelaUinUidList() {
        clear();
    }

    public static RelaUinUidList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RelaUinUidList[0];
                }
            }
        }
        return _emptyArray;
    }

    public static RelaUinUidList parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (RelaUinUidList) MessageNano.mergeFrom(new RelaUinUidList(), bArr);
    }

    public RelaUinUidList clear() {
        this.list = RelaUinUid.emptyArray();
        this.idType = 1;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        RelaUinUid[] relaUinUidArr = this.list;
        if (relaUinUidArr != null && relaUinUidArr.length > 0) {
            int i3 = 0;
            while (true) {
                RelaUinUid[] relaUinUidArr2 = this.list;
                if (i3 >= relaUinUidArr2.length) {
                    break;
                }
                RelaUinUid relaUinUid = relaUinUidArr2[i3];
                if (relaUinUid != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, relaUinUid);
                }
                i3++;
            }
        }
        int i16 = this.idType;
        if (i16 != 1) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        RelaUinUid[] relaUinUidArr = this.list;
        if (relaUinUidArr != null && relaUinUidArr.length > 0) {
            int i3 = 0;
            while (true) {
                RelaUinUid[] relaUinUidArr2 = this.list;
                if (i3 >= relaUinUidArr2.length) {
                    break;
                }
                RelaUinUid relaUinUid = relaUinUidArr2[i3];
                if (relaUinUid != null) {
                    codedOutputByteBufferNano.writeMessage(1, relaUinUid);
                }
                i3++;
            }
        }
        int i16 = this.idType;
        if (i16 != 1) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static RelaUinUidList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new RelaUinUidList().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public RelaUinUidList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                RelaUinUid[] relaUinUidArr = this.list;
                int length = relaUinUidArr == null ? 0 : relaUinUidArr.length;
                int i3 = repeatedFieldArrayLength + length;
                RelaUinUid[] relaUinUidArr2 = new RelaUinUid[i3];
                if (length != 0) {
                    System.arraycopy(relaUinUidArr, 0, relaUinUidArr2, 0, length);
                }
                while (length < i3 - 1) {
                    RelaUinUid relaUinUid = new RelaUinUid();
                    relaUinUidArr2[length] = relaUinUid;
                    codedInputByteBufferNano.readMessage(relaUinUid);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                RelaUinUid relaUinUid2 = new RelaUinUid();
                relaUinUidArr2[length] = relaUinUid2;
                codedInputByteBufferNano.readMessage(relaUinUid2);
                this.list = relaUinUidArr2;
            } else if (readTag != 16) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 1 || readInt32 == 2) {
                    this.idType = readInt32;
                }
            }
        }
    }
}
