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
public final class liveLinkMicSig extends ExtendableMessageNano<liveLinkMicSig> {
    private static volatile liveLinkMicSig[] _emptyArray;
    public String strConnedThirdAccount;
    public String strThirdAccount;
    public int uint32ConnedGroupcode;
    public int uint32CreateTime;
    public int uint32ExpireTime;
    public int uint32Groupcode;

    public liveLinkMicSig() {
        clear();
    }

    public static liveLinkMicSig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new liveLinkMicSig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static liveLinkMicSig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (liveLinkMicSig) MessageNano.mergeFrom(new liveLinkMicSig(), bArr);
    }

    public liveLinkMicSig clear() {
        this.uint32Groupcode = 0;
        this.strThirdAccount = "";
        this.uint32ConnedGroupcode = 0;
        this.strConnedThirdAccount = "";
        this.uint32CreateTime = 0;
        this.uint32ExpireTime = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.uint32Groupcode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.strThirdAccount.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.strThirdAccount);
        }
        int i16 = this.uint32ConnedGroupcode;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i16);
        }
        if (!this.strConnedThirdAccount.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.strConnedThirdAccount);
        }
        int i17 = this.uint32CreateTime;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.uint32ExpireTime;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.uint32Groupcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.strThirdAccount.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.strThirdAccount);
        }
        int i16 = this.uint32ConnedGroupcode;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i16);
        }
        if (!this.strConnedThirdAccount.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.strConnedThirdAccount);
        }
        int i17 = this.uint32CreateTime;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.uint32ExpireTime;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static liveLinkMicSig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new liveLinkMicSig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public liveLinkMicSig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.uint32Groupcode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.strThirdAccount = codedInputByteBufferNano.readString();
            } else if (readTag == 24) {
                this.uint32ConnedGroupcode = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 34) {
                this.strConnedThirdAccount = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.uint32CreateTime = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 48) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uint32ExpireTime = codedInputByteBufferNano.readUInt32();
            }
        }
    }
}
