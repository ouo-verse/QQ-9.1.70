package com.tencent.mobileqq.icgame.data.link.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class VideoChangeStatus extends ExtendableMessageNano<VideoChangeStatus> {
    private static volatile VideoChangeStatus[] _emptyArray;
    public int liveType;
    public int stat;
    public int videoBeginTimestamp;

    public VideoChangeStatus() {
        clear();
    }

    public static VideoChangeStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new VideoChangeStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public static VideoChangeStatus parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (VideoChangeStatus) MessageNano.mergeFrom(new VideoChangeStatus(), bArr);
    }

    public VideoChangeStatus clear() {
        this.stat = 0;
        this.liveType = 0;
        this.videoBeginTimestamp = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.stat;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.liveType;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.videoBeginTimestamp;
        if (i17 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeFixed32Size(3, i17);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.stat;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.liveType;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.videoBeginTimestamp;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeFixed32(3, i17);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static VideoChangeStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new VideoChangeStatus().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public VideoChangeStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.stat = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.liveType = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 29) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.videoBeginTimestamp = codedInputByteBufferNano.readFixed32();
            }
        }
    }
}
