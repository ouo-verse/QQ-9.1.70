package com.tencent.mobileqq.icgame.data.meet.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class AnchorInfo extends ExtendableMessageNano<AnchorInfo> {
    private static volatile AnchorInfo[] _emptyArray;
    public int age;
    public String city;
    public double distance;
    public String encryptUid;
    public String logo;
    public String nick;
    public long nowid;
    public int onlineStatus;
    public String[] personalTags;
    public long roomId;
    public int sex;

    public AnchorInfo() {
        clear();
    }

    public static AnchorInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AnchorInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static AnchorInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (AnchorInfo) MessageNano.mergeFrom(new AnchorInfo(), bArr);
    }

    public AnchorInfo clear() {
        this.encryptUid = "";
        this.nick = "";
        this.logo = "";
        this.sex = 0;
        this.age = 0;
        this.personalTags = WireFormatNano.EMPTY_STRING_ARRAY;
        this.distance = 0.0d;
        this.onlineStatus = 0;
        this.city = "";
        this.roomId = 0L;
        this.nowid = 0L;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.encryptUid.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.encryptUid);
        }
        if (!this.nick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.nick);
        }
        if (!this.logo.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.logo);
        }
        int i3 = this.sex;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        int i16 = this.age;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i16);
        }
        String[] strArr = this.personalTags;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                String[] strArr2 = this.personalTags;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    i19++;
                    i18 += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i17++;
            }
            computeSerializedSize = computeSerializedSize + i18 + (i19 * 1);
        }
        if (Double.doubleToLongBits(this.distance) != Double.doubleToLongBits(0.0d)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(7, this.distance);
        }
        int i26 = this.onlineStatus;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i26);
        }
        if (!this.city.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.city);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j3);
        }
        long j16 = this.nowid;
        if (j16 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(11, j16);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.encryptUid.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.encryptUid);
        }
        if (!this.nick.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.nick);
        }
        if (!this.logo.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.logo);
        }
        int i3 = this.sex;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        int i16 = this.age;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i16);
        }
        String[] strArr = this.personalTags;
        if (strArr != null && strArr.length > 0) {
            int i17 = 0;
            while (true) {
                String[] strArr2 = this.personalTags;
                if (i17 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i17];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(6, str);
                }
                i17++;
            }
        }
        if (Double.doubleToLongBits(this.distance) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(7, this.distance);
        }
        int i18 = this.onlineStatus;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i18);
        }
        if (!this.city.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.city);
        }
        long j3 = this.roomId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j3);
        }
        long j16 = this.nowid;
        if (j16 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j16);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static AnchorInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new AnchorInfo().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public AnchorInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 10:
                    this.encryptUid = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.nick = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.logo = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.sex = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.age = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr = this.personalTags;
                    int length = strArr == null ? 0 : strArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    String[] strArr2 = new String[i3];
                    if (length != 0) {
                        System.arraycopy(strArr, 0, strArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.personalTags = strArr2;
                    break;
                case 57:
                    this.distance = codedInputByteBufferNano.readDouble();
                    break;
                case 64:
                    this.onlineStatus = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.city = codedInputByteBufferNano.readString();
                    break;
                case 80:
                    this.roomId = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    this.nowid = codedInputByteBufferNano.readUInt64();
                    break;
                default:
                    if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
