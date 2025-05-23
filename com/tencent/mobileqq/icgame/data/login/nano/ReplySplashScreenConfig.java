package com.tencent.mobileqq.icgame.data.login.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class ReplySplashScreenConfig extends ExtendableMessageNano<ReplySplashScreenConfig> {
    private static volatile ReplySplashScreenConfig[] _emptyArray;
    public String birthLogoUrl;
    public String birthSplashUrl;
    public int btnColor;
    public String content;
    public int duration;
    public int endTime;

    /* renamed from: id, reason: collision with root package name */
    public int f237264id;
    public int interval;
    public String jumpUrl;
    public String logo;
    public String nick;
    public int onlyOnce;
    public String splashMedia;
    public String splashMediaMd5;
    public int splashType;
    public String splashUrl;
    public int startTime;
    public String title;
    public int type;
    public int versionNo;

    public ReplySplashScreenConfig() {
        clear();
    }

    public static ReplySplashScreenConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ReplySplashScreenConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static ReplySplashScreenConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (ReplySplashScreenConfig) MessageNano.mergeFrom(new ReplySplashScreenConfig(), bArr);
    }

    public ReplySplashScreenConfig clear() {
        this.versionNo = 0;
        this.splashUrl = "";
        this.jumpUrl = "";
        this.startTime = 0;
        this.endTime = 0;
        this.duration = 0;
        this.interval = 0;
        this.btnColor = 0;
        this.splashType = 0;
        this.splashMedia = "";
        this.splashMediaMd5 = "";
        this.onlyOnce = 0;
        this.type = 0;
        this.logo = "";
        this.nick = "";
        this.title = "";
        this.content = "";
        this.birthSplashUrl = "";
        this.birthLogoUrl = "";
        this.f237264id = 0;
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i3 = this.versionNo;
        if (i3 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i3);
        }
        if (!this.splashUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.splashUrl);
        }
        if (!this.jumpUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl);
        }
        int i16 = this.startTime;
        if (i16 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i16);
        }
        int i17 = this.endTime;
        if (i17 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i17);
        }
        int i18 = this.duration;
        if (i18 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i18);
        }
        int i19 = this.interval;
        if (i19 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i19);
        }
        int i26 = this.btnColor;
        if (i26 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i26);
        }
        int i27 = this.splashType;
        if (i27 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i27);
        }
        if (!this.splashMedia.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.splashMedia);
        }
        if (!this.splashMediaMd5.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.splashMediaMd5);
        }
        int i28 = this.onlyOnce;
        if (i28 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i28);
        }
        int i29 = this.type;
        if (i29 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i29);
        }
        if (!this.logo.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.logo);
        }
        if (!this.nick.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.nick);
        }
        if (!this.title.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.title);
        }
        if (!this.content.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.content);
        }
        if (!this.birthSplashUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.birthSplashUrl);
        }
        if (!this.birthLogoUrl.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.birthLogoUrl);
        }
        int i36 = this.f237264id;
        if (i36 != 0) {
            return computeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(20, i36);
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i3 = this.versionNo;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i3);
        }
        if (!this.splashUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.splashUrl);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.jumpUrl);
        }
        int i16 = this.startTime;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i16);
        }
        int i17 = this.endTime;
        if (i17 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i17);
        }
        int i18 = this.duration;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i18);
        }
        int i19 = this.interval;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i19);
        }
        int i26 = this.btnColor;
        if (i26 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i26);
        }
        int i27 = this.splashType;
        if (i27 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i27);
        }
        if (!this.splashMedia.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.splashMedia);
        }
        if (!this.splashMediaMd5.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.splashMediaMd5);
        }
        int i28 = this.onlyOnce;
        if (i28 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i28);
        }
        int i29 = this.type;
        if (i29 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i29);
        }
        if (!this.logo.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.logo);
        }
        if (!this.nick.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.nick);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.title);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.content);
        }
        if (!this.birthSplashUrl.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.birthSplashUrl);
        }
        if (!this.birthLogoUrl.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.birthLogoUrl);
        }
        int i36 = this.f237264id;
        if (i36 != 0) {
            codedOutputByteBufferNano.writeUInt32(20, i36);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static ReplySplashScreenConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new ReplySplashScreenConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public ReplySplashScreenConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            switch (readTag) {
                case 0:
                    return this;
                case 8:
                    this.versionNo = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.splashUrl = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.jumpUrl = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.startTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.endTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.duration = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.interval = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.btnColor = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.splashType = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    this.splashMedia = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.splashMediaMd5 = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.onlyOnce = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.type = codedInputByteBufferNano.readUInt32();
                    break;
                case 114:
                    this.logo = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.nick = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    this.title = codedInputByteBufferNano.readString();
                    break;
                case 138:
                    this.content = codedInputByteBufferNano.readString();
                    break;
                case 146:
                    this.birthSplashUrl = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.birthLogoUrl = codedInputByteBufferNano.readString();
                    break;
                case 160:
                    this.f237264id = codedInputByteBufferNano.readUInt32();
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
