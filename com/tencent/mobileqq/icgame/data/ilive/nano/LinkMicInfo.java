package com.tencent.mobileqq.icgame.data.ilive.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class LinkMicInfo extends ExtendableMessageNano<LinkMicInfo> {
    private static volatile LinkMicInfo[] _emptyArray;
    public long anchorUid;
    public int freeTimes;
    public int linkMicInviteSwitch;
    public int linkMicMode;
    public int linkMicSwitch;

    public LinkMicInfo() {
        clear();
    }

    public static LinkMicInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LinkMicInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static LinkMicInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (LinkMicInfo) MessageNano.mergeFrom(new LinkMicInfo(), bArr);
    }

    public LinkMicInfo clear() {
        this.anchorUid = 0L;
        this.linkMicInviteSwitch = 0;
        this.linkMicMode = 0;
        this.freeTimes = 0;
        this.linkMicSwitch = 0;
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
        int i3 = this.linkMicInviteSwitch;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i3);
        }
        int i16 = this.linkMicMode;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        int i17 = this.freeTimes;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i17);
        }
        int i18 = this.linkMicSwitch;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.anchorUid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        int i3 = this.linkMicInviteSwitch;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i3);
        }
        int i16 = this.linkMicMode;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        int i17 = this.freeTimes;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i17);
        }
        int i18 = this.linkMicSwitch;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static LinkMicInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new LinkMicInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public LinkMicInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.anchorUid = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.linkMicInviteSwitch = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.linkMicMode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.freeTimes = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 40) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.linkMicSwitch = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
