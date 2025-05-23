package com.tencent.mobileqq.icgame.data.ilive.nano;

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
public final class LinkMicTaskGetRsp extends ExtendableMessageNano<LinkMicTaskGetRsp> {
    private static volatile LinkMicTaskGetRsp[] _emptyArray;
    public long anchorUid;
    public int freeTimes;
    public LinkMicTask[] tasks;

    public LinkMicTaskGetRsp() {
        clear();
    }

    public static LinkMicTaskGetRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicTaskGetRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicTaskGetRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicTaskGetRsp) MessageNano.mergeFrom(new LinkMicTaskGetRsp(), bArr);
    }

    public LinkMicTaskGetRsp clear() {
        this.anchorUid = 0L;
        this.freeTimes = 0;
        this.tasks = LinkMicTask.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.anchorUid;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        int i3 = this.freeTimes;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        LinkMicTask[] linkMicTaskArr = this.tasks;
        if (linkMicTaskArr != null && linkMicTaskArr.length > 0) {
            int i16 = 0;
            while (true) {
                LinkMicTask[] linkMicTaskArr2 = this.tasks;
                if (i16 >= linkMicTaskArr2.length) {
                    break;
                }
                LinkMicTask linkMicTask = linkMicTaskArr2[i16];
                if (linkMicTask != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, linkMicTask);
                }
                i16++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.freeTimes;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        LinkMicTask[] linkMicTaskArr = this.tasks;
        if (linkMicTaskArr != null && linkMicTaskArr.length > 0) {
            int i16 = 0;
            while (true) {
                LinkMicTask[] linkMicTaskArr2 = this.tasks;
                if (i16 >= linkMicTaskArr2.length) {
                    break;
                }
                LinkMicTask linkMicTask = linkMicTaskArr2[i16];
                if (linkMicTask != null) {
                    codedOutputByteBufferNano.writeMessage(3, linkMicTask);
                }
                i16++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicTaskGetRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicTaskGetRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicTaskGetRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.freeTimes = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LinkMicTask[] linkMicTaskArr = this.tasks;
                int length = linkMicTaskArr == null ? 0 : linkMicTaskArr.length;
                int i3 = repeatedFieldArrayLength + length;
                LinkMicTask[] linkMicTaskArr2 = new LinkMicTask[i3];
                if (length != 0) {
                    System.arraycopy(linkMicTaskArr, 0, linkMicTaskArr2, 0, length);
                }
                while (length < i3 - 1) {
                    LinkMicTask linkMicTask = new LinkMicTask();
                    linkMicTaskArr2[length] = linkMicTask;
                    codedInputByteBufferNano.readMessage(linkMicTask);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                LinkMicTask linkMicTask2 = new LinkMicTask();
                linkMicTaskArr2[length] = linkMicTask2;
                codedInputByteBufferNano.readMessage(linkMicTask2);
                this.tasks = linkMicTaskArr2;
            }
        }
    }
}
