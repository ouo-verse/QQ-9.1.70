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
public final class QQInfo extends ExtendableMessageNano<QQInfo> {
    private static volatile QQInfo[] _emptyArray;
    public int qqAge;
    public String qqAvatar;
    public String qqCity;
    public int qqGender;
    public String qqName;
    public String qqProvince;

    public QQInfo() {
        clear();
    }

    public static QQInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QQInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QQInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QQInfo) MessageNano.mergeFrom(new QQInfo(), bArr);
    }

    public QQInfo clear() {
        this.qqName = "";
        this.qqGender = 0;
        this.qqProvince = "";
        this.qqCity = "";
        this.qqAge = 0;
        this.qqAvatar = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.qqName.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.qqName);
        }
        int i3 = this.qqGender;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.qqProvince.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.qqProvince);
        }
        if (!this.qqCity.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.qqCity);
        }
        int i16 = this.qqAge;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i16);
        }
        if (!this.qqAvatar.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.qqAvatar);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.qqName.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.qqName);
        }
        int i3 = this.qqGender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.qqProvince.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.qqProvince);
        }
        if (!this.qqCity.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.qqCity);
        }
        int i16 = this.qqAge;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i16);
        }
        if (!this.qqAvatar.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.qqAvatar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QQInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QQInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QQInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.qqName = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.qqGender = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                this.qqProvince = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.qqCity = codedInputByteBufferNano.readString();
            } else if (readTag == 40) {
                this.qqAge = codedInputByteBufferNano.readInt32();
            } else if (readTag != 50) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.qqAvatar = codedInputByteBufferNano.readString();
            }
        }
    }
}
