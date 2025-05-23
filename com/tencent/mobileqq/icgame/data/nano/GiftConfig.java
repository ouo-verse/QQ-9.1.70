package com.tencent.mobileqq.icgame.data.nano;

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
public final class GiftConfig extends ExtendableMessageNano<GiftConfig> {
    private static volatile GiftConfig[] _emptyArray;
    public GiftEffectConfig[] effectConfig;
    public GiftFlashConfig[] flashConfig;
    public GiftWordConfig[] wordConfig;

    public GiftConfig() {
        clear();
    }

    public static GiftConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GiftConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public static GiftConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (GiftConfig) MessageNano.mergeFrom(new GiftConfig(), bArr);
    }

    public GiftConfig clear() {
        this.wordConfig = GiftWordConfig.emptyArray();
        this.flashConfig = GiftFlashConfig.emptyArray();
        this.effectConfig = GiftEffectConfig.emptyArray();
        this.unknownFieldData = null;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        GiftWordConfig[] giftWordConfigArr = this.wordConfig;
        int i3 = 0;
        if (giftWordConfigArr != null && giftWordConfigArr.length > 0) {
            int i16 = 0;
            while (true) {
                GiftWordConfig[] giftWordConfigArr2 = this.wordConfig;
                if (i16 >= giftWordConfigArr2.length) {
                    break;
                }
                GiftWordConfig giftWordConfig = giftWordConfigArr2[i16];
                if (giftWordConfig != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, giftWordConfig);
                }
                i16++;
            }
        }
        GiftFlashConfig[] giftFlashConfigArr = this.flashConfig;
        if (giftFlashConfigArr != null && giftFlashConfigArr.length > 0) {
            int i17 = 0;
            while (true) {
                GiftFlashConfig[] giftFlashConfigArr2 = this.flashConfig;
                if (i17 >= giftFlashConfigArr2.length) {
                    break;
                }
                GiftFlashConfig giftFlashConfig = giftFlashConfigArr2[i17];
                if (giftFlashConfig != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, giftFlashConfig);
                }
                i17++;
            }
        }
        GiftEffectConfig[] giftEffectConfigArr = this.effectConfig;
        if (giftEffectConfigArr != null && giftEffectConfigArr.length > 0) {
            while (true) {
                GiftEffectConfig[] giftEffectConfigArr2 = this.effectConfig;
                if (i3 >= giftEffectConfigArr2.length) {
                    break;
                }
                GiftEffectConfig giftEffectConfig = giftEffectConfigArr2[i3];
                if (giftEffectConfig != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, giftEffectConfig);
                }
                i3++;
            }
        }
        return computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.ExtendableMessageNano, com.google.protobuf.nano.MessageNano
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        GiftWordConfig[] giftWordConfigArr = this.wordConfig;
        int i3 = 0;
        if (giftWordConfigArr != null && giftWordConfigArr.length > 0) {
            int i16 = 0;
            while (true) {
                GiftWordConfig[] giftWordConfigArr2 = this.wordConfig;
                if (i16 >= giftWordConfigArr2.length) {
                    break;
                }
                GiftWordConfig giftWordConfig = giftWordConfigArr2[i16];
                if (giftWordConfig != null) {
                    codedOutputByteBufferNano.writeMessage(1, giftWordConfig);
                }
                i16++;
            }
        }
        GiftFlashConfig[] giftFlashConfigArr = this.flashConfig;
        if (giftFlashConfigArr != null && giftFlashConfigArr.length > 0) {
            int i17 = 0;
            while (true) {
                GiftFlashConfig[] giftFlashConfigArr2 = this.flashConfig;
                if (i17 >= giftFlashConfigArr2.length) {
                    break;
                }
                GiftFlashConfig giftFlashConfig = giftFlashConfigArr2[i17];
                if (giftFlashConfig != null) {
                    codedOutputByteBufferNano.writeMessage(2, giftFlashConfig);
                }
                i17++;
            }
        }
        GiftEffectConfig[] giftEffectConfigArr = this.effectConfig;
        if (giftEffectConfigArr != null && giftEffectConfigArr.length > 0) {
            while (true) {
                GiftEffectConfig[] giftEffectConfigArr2 = this.effectConfig;
                if (i3 >= giftEffectConfigArr2.length) {
                    break;
                }
                GiftEffectConfig giftEffectConfig = giftEffectConfigArr2[i3];
                if (giftEffectConfig != null) {
                    codedOutputByteBufferNano.writeMessage(3, giftEffectConfig);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static GiftConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new GiftConfig().mergeFrom(codedInputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public GiftConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                return this;
            }
            if (readTag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                GiftWordConfig[] giftWordConfigArr = this.wordConfig;
                int length = giftWordConfigArr == null ? 0 : giftWordConfigArr.length;
                int i3 = repeatedFieldArrayLength + length;
                GiftWordConfig[] giftWordConfigArr2 = new GiftWordConfig[i3];
                if (length != 0) {
                    System.arraycopy(giftWordConfigArr, 0, giftWordConfigArr2, 0, length);
                }
                while (length < i3 - 1) {
                    GiftWordConfig giftWordConfig = new GiftWordConfig();
                    giftWordConfigArr2[length] = giftWordConfig;
                    codedInputByteBufferNano.readMessage(giftWordConfig);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                GiftWordConfig giftWordConfig2 = new GiftWordConfig();
                giftWordConfigArr2[length] = giftWordConfig2;
                codedInputByteBufferNano.readMessage(giftWordConfig2);
                this.wordConfig = giftWordConfigArr2;
            } else if (readTag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                GiftFlashConfig[] giftFlashConfigArr = this.flashConfig;
                int length2 = giftFlashConfigArr == null ? 0 : giftFlashConfigArr.length;
                int i16 = repeatedFieldArrayLength2 + length2;
                GiftFlashConfig[] giftFlashConfigArr2 = new GiftFlashConfig[i16];
                if (length2 != 0) {
                    System.arraycopy(giftFlashConfigArr, 0, giftFlashConfigArr2, 0, length2);
                }
                while (length2 < i16 - 1) {
                    GiftFlashConfig giftFlashConfig = new GiftFlashConfig();
                    giftFlashConfigArr2[length2] = giftFlashConfig;
                    codedInputByteBufferNano.readMessage(giftFlashConfig);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                GiftFlashConfig giftFlashConfig2 = new GiftFlashConfig();
                giftFlashConfigArr2[length2] = giftFlashConfig2;
                codedInputByteBufferNano.readMessage(giftFlashConfig2);
                this.flashConfig = giftFlashConfigArr2;
            } else if (readTag != 26) {
                if (!storeUnknownField(codedInputByteBufferNano, readTag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                GiftEffectConfig[] giftEffectConfigArr = this.effectConfig;
                int length3 = giftEffectConfigArr == null ? 0 : giftEffectConfigArr.length;
                int i17 = repeatedFieldArrayLength3 + length3;
                GiftEffectConfig[] giftEffectConfigArr2 = new GiftEffectConfig[i17];
                if (length3 != 0) {
                    System.arraycopy(giftEffectConfigArr, 0, giftEffectConfigArr2, 0, length3);
                }
                while (length3 < i17 - 1) {
                    GiftEffectConfig giftEffectConfig = new GiftEffectConfig();
                    giftEffectConfigArr2[length3] = giftEffectConfig;
                    codedInputByteBufferNano.readMessage(giftEffectConfig);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                GiftEffectConfig giftEffectConfig2 = new GiftEffectConfig();
                giftEffectConfigArr2[length3] = giftEffectConfig2;
                codedInputByteBufferNano.readMessage(giftEffectConfig2);
                this.effectConfig = giftEffectConfigArr2;
            }
        }
    }
}
