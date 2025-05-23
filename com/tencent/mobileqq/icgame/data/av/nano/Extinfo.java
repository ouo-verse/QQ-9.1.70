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
public final class Extinfo extends ExtendableMessageNano<Extinfo> {
    private static volatile Extinfo[] _emptyArray;
    public String clientVersion;
    public int enableVideo;
    public int enableVoice;
    public int mode;
    public String netType;
    public String phoneType;
    public int place;
    public Resolution resolution;
    public int seatType;

    public Extinfo() {
        clear();
    }

    public static Extinfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Extinfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static Extinfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Extinfo) MessageNano.mergeFrom(new Extinfo(), bArr);
    }

    public Extinfo clear() {
        this.netType = "";
        this.phoneType = "";
        this.clientVersion = "";
        this.resolution = null;
        this.place = 0;
        this.mode = 0;
        this.enableVideo = 0;
        this.enableVoice = 0;
        this.seatType = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.netType.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.netType);
        }
        if (!this.phoneType.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.phoneType);
        }
        if (!this.clientVersion.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.clientVersion);
        }
        Resolution resolution = this.resolution;
        if (resolution != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, resolution);
        }
        int i3 = this.place;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        int i16 = this.mode;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i16);
        }
        int i17 = this.enableVideo;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i17);
        }
        int i18 = this.enableVoice;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i18);
        }
        int i19 = this.seatType;
        if (i19 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i19);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.netType.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.netType);
        }
        if (!this.phoneType.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.phoneType);
        }
        if (!this.clientVersion.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.clientVersion);
        }
        Resolution resolution = this.resolution;
        if (resolution != null) {
            codedOutputByteBufferNano.writeMessage(4, resolution);
        }
        int i3 = this.place;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        int i16 = this.mode;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i16);
        }
        int i17 = this.enableVideo;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i17);
        }
        int i18 = this.enableVoice;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        int i19 = this.seatType;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i19);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static Extinfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Extinfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public Extinfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.netType = codedInputByteBufferNano.readString();
            } else if (readTag == 18) {
                this.phoneType = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.clientVersion = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                if (this.resolution == null) {
                    this.resolution = new Resolution();
                }
                codedInputByteBufferNano.readMessage(this.resolution);
            } else if (readTag == 40) {
                this.place = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.mode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.enableVideo = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 64) {
                this.enableVoice = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 72) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.seatType = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
