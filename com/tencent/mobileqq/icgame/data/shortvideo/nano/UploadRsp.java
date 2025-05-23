package com.tencent.mobileqq.icgame.data.shortvideo.nano;

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
public final class UploadRsp extends ExtendableMessageNano<UploadRsp> {
    private static volatile UploadRsp[] _emptyArray;
    public byte[] authkey;
    public String errMsg;
    public int expiretime;
    public int frontid;
    public int[] frontip;
    public int prov;
    public int retcode;
    public int userflag;
    public int userip;
    public int ver;
    public String zonedomain;
    public int zoneid;
    public int[] zoneip;

    public UploadRsp() {
        clear();
    }

    public static UploadRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UploadRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static UploadRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (UploadRsp) MessageNano.mergeFrom(new UploadRsp(), bArr);
    }

    public UploadRsp clear() {
        this.retcode = 0;
        this.ver = 0;
        this.userip = 0;
        this.prov = 0;
        this.frontid = 0;
        int[] iArr = WireFormatNano.EMPTY_INT_ARRAY;
        this.frontip = iArr;
        this.zoneid = 0;
        this.zoneip = iArr;
        this.expiretime = 0;
        this.zonedomain = "";
        this.userflag = 0;
        this.authkey = WireFormatNano.EMPTY_BYTES;
        this.errMsg = "";
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int[] iArr;
        int[] iArr2;
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.retcode;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i3);
        }
        int i16 = this.ver;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i16);
        }
        int i17 = this.userip;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i17);
        }
        int i18 = this.prov;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i18);
        }
        int i19 = this.frontid;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i19);
        }
        int[] iArr3 = this.frontip;
        int i26 = 0;
        if (iArr3 != null && iArr3.length > 0) {
            int i27 = 0;
            int i28 = 0;
            while (true) {
                iArr2 = this.frontip;
                if (i27 >= iArr2.length) {
                    break;
                }
                i28 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i27]);
                i27++;
            }
            computeSerializedSize = computeSerializedSize + i28 + (iArr2.length * 1);
        }
        int i29 = this.zoneid;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i29);
        }
        int[] iArr4 = this.zoneip;
        if (iArr4 != null && iArr4.length > 0) {
            int i36 = 0;
            while (true) {
                iArr = this.zoneip;
                if (i26 >= iArr.length) {
                    break;
                }
                i36 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i26]);
                i26++;
            }
            computeSerializedSize = computeSerializedSize + i36 + (iArr.length * 1);
        }
        int i37 = this.expiretime;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i37);
        }
        if (!this.zonedomain.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.zonedomain);
        }
        int i38 = this.userflag;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i38);
        }
        if (!Arrays.equals(this.authkey, WireFormatNano.EMPTY_BYTES)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(12, this.authkey);
        }
        if (!this.errMsg.equals("")) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeStringSize(13, this.errMsg);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.retcode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i3);
        }
        int i16 = this.ver;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i16);
        }
        int i17 = this.userip;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i17);
        }
        int i18 = this.prov;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i18);
        }
        int i19 = this.frontid;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i19);
        }
        int[] iArr = this.frontip;
        int i26 = 0;
        if (iArr != null && iArr.length > 0) {
            int i27 = 0;
            while (true) {
                int[] iArr2 = this.frontip;
                if (i27 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(6, iArr2[i27]);
                i27++;
            }
        }
        int i28 = this.zoneid;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i28);
        }
        int[] iArr3 = this.zoneip;
        if (iArr3 != null && iArr3.length > 0) {
            while (true) {
                int[] iArr4 = this.zoneip;
                if (i26 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(8, iArr4[i26]);
                i26++;
            }
        }
        int i29 = this.expiretime;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i29);
        }
        if (!this.zonedomain.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.zonedomain);
        }
        int i36 = this.userflag;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i36);
        }
        if (!Arrays.equals(this.authkey, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(12, this.authkey);
        }
        if (!this.errMsg.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.errMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static UploadRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new UploadRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public UploadRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.retcode = codedInputByteBufferNano.readInt32();
                    break;
                case 16:
                    this.ver = codedInputByteBufferNano.readInt32();
                    break;
                case 24:
                    this.userip = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.prov = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.frontid = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 48);
                    int[] iArr = this.frontip;
                    int length = iArr == null ? 0 : iArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    int[] iArr2 = new int[i3];
                    if (length != 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        iArr2[length] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    this.frontip = iArr2;
                    break;
                case 50:
                    int pushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i16 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i16++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.frontip;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int i17 = i16 + length2;
                    int[] iArr4 = new int[i17];
                    if (length2 != 0) {
                        System.arraycopy(iArr3, 0, iArr4, 0, length2);
                    }
                    while (length2 < i17) {
                        iArr4[length2] = codedInputByteBufferNano.readUInt32();
                        length2++;
                    }
                    this.frontip = iArr4;
                    codedInputByteBufferNano.popLimit(pushLimit);
                    break;
                case 56:
                    this.zoneid = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 64);
                    int[] iArr5 = this.zoneip;
                    int length3 = iArr5 == null ? 0 : iArr5.length;
                    int i18 = repeatedFieldArrayLength2 + length3;
                    int[] iArr6 = new int[i18];
                    if (length3 != 0) {
                        System.arraycopy(iArr5, 0, iArr6, 0, length3);
                    }
                    while (length3 < i18 - 1) {
                        iArr6[length3] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    iArr6[length3] = codedInputByteBufferNano.readUInt32();
                    this.zoneip = iArr6;
                    break;
                case 66:
                    int pushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i19 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i19++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    int[] iArr7 = this.zoneip;
                    int length4 = iArr7 == null ? 0 : iArr7.length;
                    int i26 = i19 + length4;
                    int[] iArr8 = new int[i26];
                    if (length4 != 0) {
                        System.arraycopy(iArr7, 0, iArr8, 0, length4);
                    }
                    while (length4 < i26) {
                        iArr8[length4] = codedInputByteBufferNano.readUInt32();
                        length4++;
                    }
                    this.zoneip = iArr8;
                    codedInputByteBufferNano.popLimit(pushLimit2);
                    break;
                case 72:
                    this.expiretime = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.zonedomain = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.userflag = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    this.authkey = codedInputByteBufferNano.readBytes();
                    break;
                case 106:
                    this.errMsg = codedInputByteBufferNano.readString();
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
