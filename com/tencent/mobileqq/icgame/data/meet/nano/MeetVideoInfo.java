package com.tencent.mobileqq.icgame.data.meet.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class MeetVideoInfo extends ExtendableMessageNano<MeetVideoInfo> {
    private static volatile MeetVideoInfo[] _emptyArray;
    public AnchorInfo anchorInfo;
    public String coverUrl;
    public long roomId;
    public int videoType;
    public String videoUrl;

    public MeetVideoInfo() {
        clear();
    }

    public static MeetVideoInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MeetVideoInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MeetVideoInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MeetVideoInfo) MessageNano.mergeFrom(new MeetVideoInfo(), bArr);
    }

    public MeetVideoInfo clear() {
        this.anchorInfo = null;
        this.roomId = 0L;
        this.videoUrl = "";
        this.coverUrl = "";
        this.videoType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        AnchorInfo anchorInfo = this.anchorInfo;
        if (anchorInfo != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, anchorInfo);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j3);
        }
        if (!this.videoUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.videoUrl);
        }
        if (!this.coverUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.coverUrl);
        }
        int i3 = this.videoType;
        if (i3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        AnchorInfo anchorInfo = this.anchorInfo;
        if (anchorInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, anchorInfo);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j3);
        }
        if (!this.videoUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.videoUrl);
        }
        if (!this.coverUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.coverUrl);
        }
        int i3 = this.videoType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MeetVideoInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MeetVideoInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MeetVideoInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.anchorInfo == null) {
                    this.anchorInfo = new AnchorInfo();
                }
                codedInputByteBufferNano.readMessage(this.anchorInfo);
            } else if (readTag == 16) {
                this.roomId = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 26) {
                this.videoUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.coverUrl = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.videoType = codedInputByteBufferNano.readInt32();
            }
        }
    }
}
