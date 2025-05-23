package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class UinData extends ExtendableMessageNano<UinData> {
    private static volatile UinData[] _emptyArray;
    public int birthdayDay;
    public int birthdayMonth;
    public int birthdayYear;
    public byte[] city;
    public byte[] country;
    public int gender;
    public byte[] nick;
    public byte[] province;
    public long uin;
    public byte[] userLogoUrl;

    public UinData() {
        clear();
    }

    public static UinData[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UinData[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UinData parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UinData) MessageNano.mergeFrom(new UinData(), bArr);
    }

    public UinData clear() {
        this.uin = 0L;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.nick = bArr;
        this.gender = 0;
        this.userLogoUrl = bArr;
        this.country = bArr;
        this.province = bArr;
        this.city = bArr;
        this.birthdayYear = 0;
        this.birthdayMonth = 0;
        this.birthdayDay = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j3 = this.uin;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j3);
        }
        byte[] bArr = this.nick;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.nick);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        if (!Arrays.equals(this.userLogoUrl, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.userLogoUrl);
        }
        if (!Arrays.equals(this.country, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(5, this.country);
        }
        if (!Arrays.equals(this.province, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(6, this.province);
        }
        if (!Arrays.equals(this.city, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(7, this.city);
        }
        int i16 = this.birthdayYear;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i16);
        }
        int i17 = this.birthdayMonth;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i17);
        }
        int i18 = this.birthdayDay;
        if (i18 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(10, i18);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j3 = this.uin;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j3);
        }
        byte[] bArr = this.nick;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(2, this.nick);
        }
        int i3 = this.gender;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        if (!Arrays.equals(this.userLogoUrl, bArr2)) {
            codedOutputByteBufferNano.writeBytes(4, this.userLogoUrl);
        }
        if (!Arrays.equals(this.country, bArr2)) {
            codedOutputByteBufferNano.writeBytes(5, this.country);
        }
        if (!Arrays.equals(this.province, bArr2)) {
            codedOutputByteBufferNano.writeBytes(6, this.province);
        }
        if (!Arrays.equals(this.city, bArr2)) {
            codedOutputByteBufferNano.writeBytes(7, this.city);
        }
        int i16 = this.birthdayYear;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i16);
        }
        int i17 = this.birthdayMonth;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i17);
        }
        int i18 = this.birthdayDay;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i18);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UinData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UinData().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UinData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.uin = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.nick = codedInputByteBufferNano.readBytes();
                    break;
                case 24:
                    this.gender = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.userLogoUrl = codedInputByteBufferNano.readBytes();
                    break;
                case 42:
                    this.country = codedInputByteBufferNano.readBytes();
                    break;
                case 50:
                    this.province = codedInputByteBufferNano.readBytes();
                    break;
                case 58:
                    this.city = codedInputByteBufferNano.readBytes();
                    break;
                case 64:
                    this.birthdayYear = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.birthdayMonth = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.birthdayDay = codedInputByteBufferNano.readUInt32();
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
