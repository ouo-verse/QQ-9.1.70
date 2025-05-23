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
public final class GetRoomInfoRsp extends ExtendableMessageNano<GetRoomInfoRsp> {
    private static volatile GetRoomInfoRsp[] _emptyArray;
    public String announcement;
    public String coverUrl;
    public String roomTag;
    public String topic;

    public GetRoomInfoRsp() {
        clear();
    }

    public static GetRoomInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetRoomInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetRoomInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetRoomInfoRsp) MessageNano.mergeFrom(new GetRoomInfoRsp(), bArr);
    }

    public GetRoomInfoRsp clear() {
        this.coverUrl = "";
        this.roomTag = "";
        this.topic = "";
        this.announcement = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.coverUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.coverUrl);
        }
        if (!this.roomTag.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.roomTag);
        }
        if (!this.topic.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.topic);
        }
        if (!this.announcement.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.announcement);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.coverUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.coverUrl);
        }
        if (!this.roomTag.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roomTag);
        }
        if (!this.topic.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.topic);
        }
        if (!this.announcement.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.announcement);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetRoomInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetRoomInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetRoomInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.coverUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.roomTag = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.topic = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.announcement = codedInputByteBufferNano.readString();
            }
        }
    }
}
