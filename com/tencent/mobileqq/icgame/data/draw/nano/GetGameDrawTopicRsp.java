package com.tencent.mobileqq.icgame.data.draw.nano;

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
public final class GetGameDrawTopicRsp extends ExtendableMessageNano<GetGameDrawTopicRsp> {
    private static volatile GetGameDrawTopicRsp[] _emptyArray;
    public String errMsg;
    public int result;
    public TopicInfo[] topicList;

    public GetGameDrawTopicRsp() {
        clear();
    }

    public static GetGameDrawTopicRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetGameDrawTopicRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetGameDrawTopicRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetGameDrawTopicRsp) MessageNano.mergeFrom(new GetGameDrawTopicRsp(), bArr);
    }

    public GetGameDrawTopicRsp clear() {
        this.result = 0;
        this.topicList = TopicInfo.emptyArray();
        this.errMsg = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.result;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        TopicInfo[] topicInfoArr = this.topicList;
        if (topicInfoArr != null && topicInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                TopicInfo[] topicInfoArr2 = this.topicList;
                if (i16 >= topicInfoArr2.length) {
                    break;
                }
                TopicInfo topicInfo = topicInfoArr2[i16];
                if (topicInfo != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, topicInfo);
                }
                i16++;
            }
        }
        if (!this.errMsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.errMsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.result;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        TopicInfo[] topicInfoArr = this.topicList;
        if (topicInfoArr != null && topicInfoArr.length > 0) {
            int i16 = 0;
            while (true) {
                TopicInfo[] topicInfoArr2 = this.topicList;
                if (i16 >= topicInfoArr2.length) {
                    break;
                }
                TopicInfo topicInfo = topicInfoArr2[i16];
                if (topicInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, topicInfo);
                }
                i16++;
            }
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.errMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetGameDrawTopicRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetGameDrawTopicRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetGameDrawTopicRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.result = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                TopicInfo[] topicInfoArr = this.topicList;
                int length = topicInfoArr == null ? 0 : topicInfoArr.length;
                int i3 = repeatedFieldArrayLength + length;
                TopicInfo[] topicInfoArr2 = new TopicInfo[i3];
                if (length != 0) {
                    System.arraycopy(topicInfoArr, 0, topicInfoArr2, 0, length);
                }
                while (length < i3 - 1) {
                    TopicInfo topicInfo = new TopicInfo();
                    topicInfoArr2[length] = topicInfo;
                    codedInputByteBufferNano.readMessage(topicInfo);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                TopicInfo topicInfo2 = new TopicInfo();
                topicInfoArr2[length] = topicInfo2;
                codedInputByteBufferNano.readMessage(topicInfo2);
                this.topicList = topicInfoArr2;
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.errMsg = codedInputByteBufferNano.readString();
            }
        }
    }
}
