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
public final class ActivityInfo extends ExtendableMessageNano<ActivityInfo> {
    private static volatile ActivityInfo[] _emptyArray;
    public String bubleUrl;
    public String iconUrl;
    public String openUrl;
    public int status;

    public ActivityInfo() {
        clear();
    }

    public static ActivityInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ActivityInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ActivityInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ActivityInfo) MessageNano.mergeFrom(new ActivityInfo(), bArr);
    }

    public ActivityInfo clear() {
        this.status = 0;
        this.iconUrl = "";
        this.bubleUrl = "";
        this.openUrl = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.status;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.iconUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.iconUrl);
        }
        if (!this.bubleUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.bubleUrl);
        }
        if (!this.openUrl.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.openUrl);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.status;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.iconUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.iconUrl);
        }
        if (!this.bubleUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.bubleUrl);
        }
        if (!this.openUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.openUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ActivityInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ActivityInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ActivityInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 8) {
                this.status = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 18) {
                this.iconUrl = codedInputByteBufferNano.readString();
            } else if (readTag == 26) {
                this.bubleUrl = codedInputByteBufferNano.readString();
            } else if (readTag != 34) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.openUrl = codedInputByteBufferNano.readString();
            }
        }
    }
}
