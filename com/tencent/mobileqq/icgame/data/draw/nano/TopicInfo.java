package com.tencent.mobileqq.icgame.data.draw.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class TopicInfo extends ExtendableMessageNano<TopicInfo> {
    private static volatile TopicInfo[] _emptyArray;
    public String topic;
    public int type;
    public String typeName;
    public int wordNum;

    public TopicInfo() {
        clear();
    }

    public static TopicInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TopicInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static TopicInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (TopicInfo) MessageNano.mergeFrom(new TopicInfo(), bArr);
    }

    public TopicInfo clear() {
        this.topic = "";
        this.type = 0;
        this.typeName = "";
        this.wordNum = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.topic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.topic);
        }
        int i3 = this.type;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        if (!this.typeName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.typeName);
        }
        int i16 = this.wordNum;
        if (i16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.topic.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.topic);
        }
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        if (!this.typeName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.typeName);
        }
        int i16 = this.wordNum;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static TopicInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new TopicInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public TopicInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.topic = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.typeName = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.wordNum = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
