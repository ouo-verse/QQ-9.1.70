package com.tencent.mobileqq.icgame.data.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.tencent.view.FilterEnum;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class GiftInfoRsp extends ExtendableMessageNano<GiftInfoRsp> {
    private static volatile GiftInfoRsp[] _emptyArray;
    public byte[] activeIcon;
    public byte[] apngUrl;
    public int beginTs;
    public int belong;
    public byte[] bigIcon;
    public GiftNewEffect[] clickEffectList;
    public byte[] comment;
    public int defaultNum;
    public String diplayWord;
    public byte[] displayConfig;
    public boolean displayGiftName;
    public boolean displayIcon;
    public int displayType;
    public byte[] effectId;
    public int effectType;
    public int endTs;
    public int friendScence;
    public String giftComment;
    public GiftEffect[] giftEffectList;
    public int giftId;
    public byte[] giftName;
    public long giftScene;
    public int giftType;
    public int hideGiftType;
    public int isLocked;
    public byte[] middleIcon;
    public GiftNewEffect[] newEffectList;
    public int nobelType;
    public int price;
    public int priority;
    public byte[] resourcePack;
    public byte[] smallIcon;
    public SpecialNumber[] specialNumList;
    public int speed;
    public int style;
    public int timestamp;
    public int visible;

    public GiftInfoRsp() {
        clear();
    }

    public static GiftInfoRsp[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftInfoRsp[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftInfoRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftInfoRsp) MessageNano.mergeFrom(new GiftInfoRsp(), bArr);
    }

    public GiftInfoRsp clear() {
        this.giftId = 0;
        byte[] bArr = WireFormatNano.EMPTY_BYTES;
        this.giftName = bArr;
        this.price = 0;
        this.displayType = 0;
        this.timestamp = 0;
        this.giftType = 0;
        this.defaultNum = 0;
        this.priority = 0;
        this.smallIcon = bArr;
        this.bigIcon = bArr;
        this.comment = bArr;
        this.giftEffectList = GiftEffect.emptyArray();
        this.specialNumList = SpecialNumber.emptyArray();
        this.resourcePack = bArr;
        this.style = 0;
        this.speed = 0;
        this.effectId = bArr;
        this.apngUrl = bArr;
        this.newEffectList = GiftNewEffect.emptyArray();
        this.activeIcon = bArr;
        this.nobelType = 0;
        this.effectType = 0;
        this.giftScene = 0L;
        this.giftComment = "";
        this.displayIcon = false;
        this.displayGiftName = false;
        this.diplayWord = "";
        this.middleIcon = bArr;
        this.hideGiftType = 0;
        this.belong = 0;
        this.beginTs = 0;
        this.endTs = 0;
        this.clickEffectList = GiftNewEffect.emptyArray();
        this.isLocked = 0;
        this.friendScence = 0;
        this.visible = 0;
        this.displayConfig = bArr;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize() + CodedOutputByteBufferNano.computeUInt32Size(1, this.giftId) + CodedOutputByteBufferNano.computeBytesSize(2, this.giftName) + CodedOutputByteBufferNano.computeUInt32Size(3, this.price) + CodedOutputByteBufferNano.computeUInt32Size(4, this.displayType) + CodedOutputByteBufferNano.computeUInt32Size(5, this.timestamp);
        int i3 = this.giftType;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        int i16 = this.defaultNum;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i16);
        }
        int i17 = this.priority;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i17);
        }
        byte[] bArr = this.smallIcon;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(9, this.smallIcon);
        }
        if (!Arrays.equals(this.bigIcon, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(10, this.bigIcon);
        }
        if (!Arrays.equals(this.comment, bArr2)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(11, this.comment);
        }
        GiftEffect[] giftEffectArr = this.giftEffectList;
        int i18 = 0;
        if (giftEffectArr != null && giftEffectArr.length > 0) {
            int i19 = 0;
            while (true) {
                GiftEffect[] giftEffectArr2 = this.giftEffectList;
                if (i19 >= giftEffectArr2.length) {
                    break;
                }
                GiftEffect giftEffect = giftEffectArr2[i19];
                if (giftEffect != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, giftEffect);
                }
                i19++;
            }
        }
        SpecialNumber[] specialNumberArr = this.specialNumList;
        if (specialNumberArr != null && specialNumberArr.length > 0) {
            int i26 = 0;
            while (true) {
                SpecialNumber[] specialNumberArr2 = this.specialNumList;
                if (i26 >= specialNumberArr2.length) {
                    break;
                }
                SpecialNumber specialNumber = specialNumberArr2[i26];
                if (specialNumber != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, specialNumber);
                }
                i26++;
            }
        }
        byte[] bArr3 = this.resourcePack;
        byte[] bArr4 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr3, bArr4)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(14, this.resourcePack);
        }
        int i27 = this.style;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i27);
        }
        int i28 = this.speed;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i28);
        }
        if (!Arrays.equals(this.effectId, bArr4)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(17, this.effectId);
        }
        if (!Arrays.equals(this.apngUrl, bArr4)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(18, this.apngUrl);
        }
        GiftNewEffect[] giftNewEffectArr = this.newEffectList;
        if (giftNewEffectArr != null && giftNewEffectArr.length > 0) {
            int i29 = 0;
            while (true) {
                GiftNewEffect[] giftNewEffectArr2 = this.newEffectList;
                if (i29 >= giftNewEffectArr2.length) {
                    break;
                }
                GiftNewEffect giftNewEffect = giftNewEffectArr2[i29];
                if (giftNewEffect != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, giftNewEffect);
                }
                i29++;
            }
        }
        byte[] bArr5 = this.activeIcon;
        byte[] bArr6 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr5, bArr6)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(20, this.activeIcon);
        }
        int i36 = this.nobelType;
        if (i36 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(21, i36);
        }
        int i37 = this.effectType;
        if (i37 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i37);
        }
        long j3 = this.giftScene;
        if (j3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(23, j3);
        }
        if (!this.giftComment.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(24, this.giftComment);
        }
        boolean z16 = this.displayIcon;
        if (z16) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(25, z16);
        }
        boolean z17 = this.displayGiftName;
        if (z17) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(26, z17);
        }
        if (!this.diplayWord.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(27, this.diplayWord);
        }
        if (!Arrays.equals(this.middleIcon, bArr6)) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(28, this.middleIcon);
        }
        int i38 = this.hideGiftType;
        if (i38 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(29, i38);
        }
        int i39 = this.belong;
        if (i39 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(30, i39);
        }
        int i46 = this.beginTs;
        if (i46 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(31, i46);
        }
        int i47 = this.endTs;
        if (i47 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(32, i47);
        }
        GiftNewEffect[] giftNewEffectArr3 = this.clickEffectList;
        if (giftNewEffectArr3 != null && giftNewEffectArr3.length > 0) {
            while (true) {
                GiftNewEffect[] giftNewEffectArr4 = this.clickEffectList;
                if (i18 >= giftNewEffectArr4.length) {
                    break;
                }
                GiftNewEffect giftNewEffect2 = giftNewEffectArr4[i18];
                if (giftNewEffect2 != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(33, giftNewEffect2);
                }
                i18++;
            }
        }
        int i48 = this.isLocked;
        if (i48 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(34, i48);
        }
        int i49 = this.friendScence;
        if (i49 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(35, i49);
        }
        int i56 = this.visible;
        if (i56 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(36, i56);
        }
        if (!Arrays.equals(this.displayConfig, WireFormatNano.EMPTY_BYTES)) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(37, this.displayConfig);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt32(1, this.giftId);
        codedOutputByteBufferNano.writeBytes(2, this.giftName);
        codedOutputByteBufferNano.writeUInt32(3, this.price);
        codedOutputByteBufferNano.writeUInt32(4, this.displayType);
        codedOutputByteBufferNano.writeUInt32(5, this.timestamp);
        int i3 = this.giftType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        int i16 = this.defaultNum;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i16);
        }
        int i17 = this.priority;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i17);
        }
        byte[] bArr = this.smallIcon;
        byte[] bArr2 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr, bArr2)) {
            codedOutputByteBufferNano.writeBytes(9, this.smallIcon);
        }
        if (!Arrays.equals(this.bigIcon, bArr2)) {
            codedOutputByteBufferNano.writeBytes(10, this.bigIcon);
        }
        if (!Arrays.equals(this.comment, bArr2)) {
            codedOutputByteBufferNano.writeBytes(11, this.comment);
        }
        GiftEffect[] giftEffectArr = this.giftEffectList;
        int i18 = 0;
        if (giftEffectArr != null && giftEffectArr.length > 0) {
            int i19 = 0;
            while (true) {
                GiftEffect[] giftEffectArr2 = this.giftEffectList;
                if (i19 >= giftEffectArr2.length) {
                    break;
                }
                GiftEffect giftEffect = giftEffectArr2[i19];
                if (giftEffect != null) {
                    codedOutputByteBufferNano.writeMessage(12, giftEffect);
                }
                i19++;
            }
        }
        SpecialNumber[] specialNumberArr = this.specialNumList;
        if (specialNumberArr != null && specialNumberArr.length > 0) {
            int i26 = 0;
            while (true) {
                SpecialNumber[] specialNumberArr2 = this.specialNumList;
                if (i26 >= specialNumberArr2.length) {
                    break;
                }
                SpecialNumber specialNumber = specialNumberArr2[i26];
                if (specialNumber != null) {
                    codedOutputByteBufferNano.writeMessage(13, specialNumber);
                }
                i26++;
            }
        }
        byte[] bArr3 = this.resourcePack;
        byte[] bArr4 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr3, bArr4)) {
            codedOutputByteBufferNano.writeBytes(14, this.resourcePack);
        }
        int i27 = this.style;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i27);
        }
        int i28 = this.speed;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i28);
        }
        if (!Arrays.equals(this.effectId, bArr4)) {
            codedOutputByteBufferNano.writeBytes(17, this.effectId);
        }
        if (!Arrays.equals(this.apngUrl, bArr4)) {
            codedOutputByteBufferNano.writeBytes(18, this.apngUrl);
        }
        GiftNewEffect[] giftNewEffectArr = this.newEffectList;
        if (giftNewEffectArr != null && giftNewEffectArr.length > 0) {
            int i29 = 0;
            while (true) {
                GiftNewEffect[] giftNewEffectArr2 = this.newEffectList;
                if (i29 >= giftNewEffectArr2.length) {
                    break;
                }
                GiftNewEffect giftNewEffect = giftNewEffectArr2[i29];
                if (giftNewEffect != null) {
                    codedOutputByteBufferNano.writeMessage(19, giftNewEffect);
                }
                i29++;
            }
        }
        byte[] bArr5 = this.activeIcon;
        byte[] bArr6 = WireFormatNano.EMPTY_BYTES;
        if (!Arrays.equals(bArr5, bArr6)) {
            codedOutputByteBufferNano.writeBytes(20, this.activeIcon);
        }
        int i36 = this.nobelType;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(21, i36);
        }
        int i37 = this.effectType;
        if (i37 != 0) {
            codedOutputByteBufferNano.writeUInt32(22, i37);
        }
        long j3 = this.giftScene;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(23, j3);
        }
        if (!this.giftComment.equals("")) {
            codedOutputByteBufferNano.writeString(24, this.giftComment);
        }
        boolean z16 = this.displayIcon;
        if (z16) {
            codedOutputByteBufferNano.writeBool(25, z16);
        }
        boolean z17 = this.displayGiftName;
        if (z17) {
            codedOutputByteBufferNano.writeBool(26, z17);
        }
        if (!this.diplayWord.equals("")) {
            codedOutputByteBufferNano.writeString(27, this.diplayWord);
        }
        if (!Arrays.equals(this.middleIcon, bArr6)) {
            codedOutputByteBufferNano.writeBytes(28, this.middleIcon);
        }
        int i38 = this.hideGiftType;
        if (i38 != 0) {
            codedOutputByteBufferNano.writeUInt32(29, i38);
        }
        int i39 = this.belong;
        if (i39 != 0) {
            codedOutputByteBufferNano.writeUInt32(30, i39);
        }
        int i46 = this.beginTs;
        if (i46 != 0) {
            codedOutputByteBufferNano.writeUInt32(31, i46);
        }
        int i47 = this.endTs;
        if (i47 != 0) {
            codedOutputByteBufferNano.writeUInt32(32, i47);
        }
        GiftNewEffect[] giftNewEffectArr3 = this.clickEffectList;
        if (giftNewEffectArr3 != null && giftNewEffectArr3.length > 0) {
            while (true) {
                GiftNewEffect[] giftNewEffectArr4 = this.clickEffectList;
                if (i18 >= giftNewEffectArr4.length) {
                    break;
                }
                GiftNewEffect giftNewEffect2 = giftNewEffectArr4[i18];
                if (giftNewEffect2 != null) {
                    codedOutputByteBufferNano.writeMessage(33, giftNewEffect2);
                }
                i18++;
            }
        }
        int i48 = this.isLocked;
        if (i48 != 0) {
            codedOutputByteBufferNano.writeUInt32(34, i48);
        }
        int i49 = this.friendScence;
        if (i49 != 0) {
            codedOutputByteBufferNano.writeUInt32(35, i49);
        }
        int i56 = this.visible;
        if (i56 != 0) {
            codedOutputByteBufferNano.writeUInt32(36, i56);
        }
        if (!Arrays.equals(this.displayConfig, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(37, this.displayConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftInfoRsp parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftInfoRsp().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftInfoRsp mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.giftName = codedInputByteBufferNano.readBytes();
                    break;
                case 24:
                    this.price = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.displayType = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.timestamp = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.giftType = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.defaultNum = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.priority = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    this.smallIcon = codedInputByteBufferNano.readBytes();
                    break;
                case 82:
                    this.bigIcon = codedInputByteBufferNano.readBytes();
                    break;
                case 90:
                    this.comment = codedInputByteBufferNano.readBytes();
                    break;
                case 98:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    GiftEffect[] giftEffectArr = this.giftEffectList;
                    int length = giftEffectArr == null ? 0 : giftEffectArr.length;
                    int i3 = repeatedFieldArrayLength + length;
                    GiftEffect[] giftEffectArr2 = new GiftEffect[i3];
                    if (length != 0) {
                        System.arraycopy(giftEffectArr, 0, giftEffectArr2, 0, length);
                    }
                    while (length < i3 - 1) {
                        GiftEffect giftEffect = new GiftEffect();
                        giftEffectArr2[length] = giftEffect;
                        codedInputByteBufferNano.readMessage(giftEffect);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    GiftEffect giftEffect2 = new GiftEffect();
                    giftEffectArr2[length] = giftEffect2;
                    codedInputByteBufferNano.readMessage(giftEffect2);
                    this.giftEffectList = giftEffectArr2;
                    break;
                case 106:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    SpecialNumber[] specialNumberArr = this.specialNumList;
                    int length2 = specialNumberArr == null ? 0 : specialNumberArr.length;
                    int i16 = repeatedFieldArrayLength2 + length2;
                    SpecialNumber[] specialNumberArr2 = new SpecialNumber[i16];
                    if (length2 != 0) {
                        System.arraycopy(specialNumberArr, 0, specialNumberArr2, 0, length2);
                    }
                    while (length2 < i16 - 1) {
                        SpecialNumber specialNumber = new SpecialNumber();
                        specialNumberArr2[length2] = specialNumber;
                        codedInputByteBufferNano.readMessage(specialNumber);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    SpecialNumber specialNumber2 = new SpecialNumber();
                    specialNumberArr2[length2] = specialNumber2;
                    codedInputByteBufferNano.readMessage(specialNumber2);
                    this.specialNumList = specialNumberArr2;
                    break;
                case 114:
                    this.resourcePack = codedInputByteBufferNano.readBytes();
                    break;
                case 120:
                    this.style = codedInputByteBufferNano.readUInt32();
                    break;
                case 128:
                    this.speed = codedInputByteBufferNano.readUInt32();
                    break;
                case 138:
                    this.effectId = codedInputByteBufferNano.readBytes();
                    break;
                case 146:
                    this.apngUrl = codedInputByteBufferNano.readBytes();
                    break;
                case 154:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                    GiftNewEffect[] giftNewEffectArr = this.newEffectList;
                    int length3 = giftNewEffectArr == null ? 0 : giftNewEffectArr.length;
                    int i17 = repeatedFieldArrayLength3 + length3;
                    GiftNewEffect[] giftNewEffectArr2 = new GiftNewEffect[i17];
                    if (length3 != 0) {
                        System.arraycopy(giftNewEffectArr, 0, giftNewEffectArr2, 0, length3);
                    }
                    while (length3 < i17 - 1) {
                        GiftNewEffect giftNewEffect = new GiftNewEffect();
                        giftNewEffectArr2[length3] = giftNewEffect;
                        codedInputByteBufferNano.readMessage(giftNewEffect);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    GiftNewEffect giftNewEffect2 = new GiftNewEffect();
                    giftNewEffectArr2[length3] = giftNewEffect2;
                    codedInputByteBufferNano.readMessage(giftNewEffect2);
                    this.newEffectList = giftNewEffectArr2;
                    break;
                case 162:
                    this.activeIcon = codedInputByteBufferNano.readBytes();
                    break;
                case 168:
                    this.nobelType = codedInputByteBufferNano.readUInt32();
                    break;
                case 176:
                    this.effectType = codedInputByteBufferNano.readUInt32();
                    break;
                case 184:
                    this.giftScene = codedInputByteBufferNano.readUInt64();
                    break;
                case 194:
                    this.giftComment = codedInputByteBufferNano.readString();
                    break;
                case 200:
                    this.displayIcon = codedInputByteBufferNano.readBool();
                    break;
                case 208:
                    this.displayGiftName = codedInputByteBufferNano.readBool();
                    break;
                case 218:
                    this.diplayWord = codedInputByteBufferNano.readString();
                    break;
                case 226:
                    this.middleIcon = codedInputByteBufferNano.readBytes();
                    break;
                case 232:
                    this.hideGiftType = codedInputByteBufferNano.readUInt32();
                    break;
                case 240:
                    this.belong = codedInputByteBufferNano.readUInt32();
                    break;
                case 248:
                    this.beginTs = codedInputByteBufferNano.readUInt32();
                    break;
                case 256:
                    this.endTs = codedInputByteBufferNano.readUInt32();
                    break;
                case 266:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 266);
                    GiftNewEffect[] giftNewEffectArr3 = this.clickEffectList;
                    int length4 = giftNewEffectArr3 == null ? 0 : giftNewEffectArr3.length;
                    int i18 = repeatedFieldArrayLength4 + length4;
                    GiftNewEffect[] giftNewEffectArr4 = new GiftNewEffect[i18];
                    if (length4 != 0) {
                        System.arraycopy(giftNewEffectArr3, 0, giftNewEffectArr4, 0, length4);
                    }
                    while (length4 < i18 - 1) {
                        GiftNewEffect giftNewEffect3 = new GiftNewEffect();
                        giftNewEffectArr4[length4] = giftNewEffect3;
                        codedInputByteBufferNano.readMessage(giftNewEffect3);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    GiftNewEffect giftNewEffect4 = new GiftNewEffect();
                    giftNewEffectArr4[length4] = giftNewEffect4;
                    codedInputByteBufferNano.readMessage(giftNewEffect4);
                    this.clickEffectList = giftNewEffectArr4;
                    break;
                case 272:
                    this.isLocked = codedInputByteBufferNano.readUInt32();
                    break;
                case FilterEnum.MIC_PTU_TRANS_XINXIAN /* 280 */:
                    this.friendScence = codedInputByteBufferNano.readUInt32();
                    break;
                case 288:
                    this.visible = codedInputByteBufferNano.readUInt32();
                    break;
                case 298:
                    this.displayConfig = codedInputByteBufferNano.readBytes();
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
