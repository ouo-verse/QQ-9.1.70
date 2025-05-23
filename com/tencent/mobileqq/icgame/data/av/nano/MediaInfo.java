package com.tencent.mobileqq.icgame.data.av.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class MediaInfo extends ExtendableMessageNano<MediaInfo> {
    private static volatile MediaInfo[] _emptyArray;
    public int audioCapFps;
    public int audioSendFps;
    public int cpuRate;
    public int cpuRateDevice;
    public int lostRate;
    public Resolution resolution;
    public int videoCapFps;
    public int videoSendFps;

    public MediaInfo() {
        clear();
    }

    public static MediaInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MediaInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static MediaInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (MediaInfo) MessageNano.mergeFrom(new MediaInfo(), bArr);
    }

    public MediaInfo clear() {
        this.resolution = null;
        this.videoCapFps = 0;
        this.videoSendFps = 0;
        this.audioCapFps = 0;
        this.audioSendFps = 0;
        this.lostRate = 0;
        this.cpuRate = 0;
        this.cpuRateDevice = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        Resolution resolution = this.resolution;
        if (resolution != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, resolution);
        }
        int i3 = this.videoCapFps;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.videoSendFps;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.audioCapFps;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.audioSendFps;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        int i19 = this.lostRate;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i19);
        }
        int i26 = this.cpuRate;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i26);
        }
        int i27 = this.cpuRateDevice;
        if (i27 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i27);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Resolution resolution = this.resolution;
        if (resolution != null) {
            codedOutputByteBufferNano.writeMessage(1, resolution);
        }
        int i3 = this.videoCapFps;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.videoSendFps;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.audioCapFps;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.audioSendFps;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        int i19 = this.lostRate;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i19);
        }
        int i26 = this.cpuRate;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i26);
        }
        int i27 = this.cpuRateDevice;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i27);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static MediaInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new MediaInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public MediaInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                if (this.resolution == null) {
                    this.resolution = new Resolution();
                }
                codedInputByteBufferNano.readMessage(this.resolution);
            } else if (readTag == 16) {
                this.videoCapFps = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.videoSendFps = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.audioCapFps = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.audioSendFps = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.lostRate = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.cpuRate = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.cpuRateDevice = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
