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
public final class ExtendUserInfoFilter extends ExtendableMessageNano<ExtendUserInfoFilter> {
    private static volatile ExtendUserInfoFilter[] _emptyArray;
    public int uint32Charm;
    public int uint32FansCount;
    public int uint32Nobility;
    public int uint32Popularity;
    public int uint32SubscribeCount;
    public int uint32SubscribeState;
    public int uint32UserExpLev;
    public int uint32UserVoiceCover;

    public ExtendUserInfoFilter() {
        clear();
    }

    public static ExtendUserInfoFilter[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ExtendUserInfoFilter[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ExtendUserInfoFilter parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ExtendUserInfoFilter) MessageNano.mergeFrom(new ExtendUserInfoFilter(), bArr);
    }

    public ExtendUserInfoFilter clear() {
        this.uint32Charm = 0;
        this.uint32Popularity = 0;
        this.uint32Nobility = 0;
        this.uint32UserVoiceCover = 0;
        this.uint32FansCount = 0;
        this.uint32SubscribeCount = 0;
        this.uint32SubscribeState = 0;
        this.uint32UserExpLev = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.uint32Charm;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.uint32Popularity;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.uint32Nobility;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.uint32UserVoiceCover;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.uint32FansCount;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        int i26 = this.uint32SubscribeCount;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i26);
        }
        int i27 = this.uint32SubscribeState;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i27);
        }
        int i28 = this.uint32UserExpLev;
        if (i28 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i28);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.uint32Charm;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.uint32Popularity;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.uint32Nobility;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.uint32UserVoiceCover;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.uint32FansCount;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        int i26 = this.uint32SubscribeCount;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i26);
        }
        int i27 = this.uint32SubscribeState;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i27);
        }
        int i28 = this.uint32UserExpLev;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i28);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ExtendUserInfoFilter parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ExtendUserInfoFilter().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ExtendUserInfoFilter mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uint32Charm = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.uint32Popularity = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.uint32Nobility = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.uint32UserVoiceCover = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 40) {
                this.uint32FansCount = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 48) {
                this.uint32SubscribeCount = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 56) {
                this.uint32SubscribeState = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uint32UserExpLev = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
