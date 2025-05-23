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
public final class GetActivityRsp extends ExtendableMessageNano<GetActivityRsp> {
    private static volatile GetActivityRsp[] _emptyArray;
    public int actId;
    public int actType;
    public int autoClick;
    public int displayType;
    public String iconUrl;
    public int isBubble;
    public int isShow;
    public String openUrl;

    public GetActivityRsp() {
        clear();
    }

    public static GetActivityRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GetActivityRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GetActivityRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GetActivityRsp) MessageNano.mergeFrom(new GetActivityRsp(), bArr);
    }

    public GetActivityRsp clear() {
        this.isShow = 0;
        this.actId = 0;
        this.actType = 0;
        this.displayType = 0;
        this.iconUrl = "";
        this.openUrl = "";
        this.autoClick = 0;
        this.isBubble = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.isShow;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        int i16 = this.actId;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i16);
        }
        int i17 = this.actType;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.displayType;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        if (!this.iconUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.iconUrl);
        }
        if (!this.openUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.openUrl);
        }
        int i19 = this.autoClick;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        int i26 = this.isBubble;
        if (i26 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i26);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.isShow;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        int i16 = this.actId;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i16);
        }
        int i17 = this.actType;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.displayType;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        if (!this.iconUrl.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.iconUrl);
        }
        if (!this.openUrl.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.openUrl);
        }
        int i19 = this.autoClick;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        int i26 = this.isBubble;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i26);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GetActivityRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GetActivityRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GetActivityRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.isShow = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.actId = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 24) {
                this.actType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 32) {
                this.displayType = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 42) {
                this.iconUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 50) {
                this.openUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 56) {
                this.autoClick = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.isBubble = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
