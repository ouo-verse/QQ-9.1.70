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
public final class QQUserInfo extends ExtendableMessageNano<QQUserInfo> {
    private static volatile QQUserInfo[] _emptyArray;
    public int age;
    public String avatar;
    public String city;
    public String country;
    public int gender;
    public String name;
    public String province;
    public long uid;

    public QQUserInfo() {
        clear();
    }

    public static QQUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new QQUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static QQUserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (QQUserInfo) MessageNano.mergeFrom(new QQUserInfo(), bArr);
    }

    public QQUserInfo clear() {
        this.name = "";
        this.gender = 0;
        this.country = "";
        this.province = "";
        this.city = "";
        this.age = 0;
        this.avatar = "";
        this.uid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.name.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
        }
        if (!this.country.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.country);
        }
        if (!this.province.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.province);
        }
        if (!this.city.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.city);
        }
        int i16 = this.age;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i16);
        }
        if (!this.avatar.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.avatar);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(8, j3);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.name);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i3);
        }
        if (!this.country.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.country);
        }
        if (!this.province.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.province);
        }
        if (!this.city.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.city);
        }
        int i16 = this.age;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i16);
        }
        if (!this.avatar.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.avatar);
        }
        long j3 = this.uid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(8, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static QQUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new QQUserInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public QQUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                this.name = codedInputByteBufferNano.readString();
            } else if (readTag == 16) {
                this.gender = codedInputByteBufferNano.readInt32();
            } else if (readTag == 26) {
                this.country = codedInputByteBufferNano.readString();
            } else if (readTag == 34) {
                this.province = codedInputByteBufferNano.readString();
            } else if (readTag == 42) {
                this.city = codedInputByteBufferNano.readString();
            } else if (readTag == 48) {
                this.age = codedInputByteBufferNano.readInt32();
            } else if (readTag == 58) {
                this.avatar = codedInputByteBufferNano.readString();
            } else if (readTag != 64) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                this.uid = codedInputByteBufferNano.readInt64();
            }
        }
    }
}
