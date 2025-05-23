package com.tencent.ilink.tdi;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ad;
import com.google.protobuf.au;
import com.google.protobuf.av;
import com.google.protobuf.b;
import com.google.protobuf.bg;
import com.google.protobuf.k;
import com.google.protobuf.t;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class TdiApiCommProto {

    /* renamed from: com.tencent.ilink.tdi.TdiApiCommProto$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum BusinessType implements ad.c {
        kBusinessTypeUnknown(-1),
        kBusinessTypeWxBase(0),
        kBusinessTypeWxPay(1);

        private static final ad.d<BusinessType> internalValueMap = new ad.d<BusinessType>() { // from class: com.tencent.ilink.tdi.TdiApiCommProto.BusinessType.1
            @Override // com.google.protobuf.ad.d
            public BusinessType findValueByNumber(int i3) {
                return BusinessType.forNumber(i3);
            }
        };
        public static final int kBusinessTypeUnknown_VALUE = -1;
        public static final int kBusinessTypeWxBase_VALUE = 0;
        public static final int kBusinessTypeWxPay_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class BusinessTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new BusinessTypeVerifier();

            BusinessTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (BusinessType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        BusinessType(int i3) {
            this.value = i3;
        }

        public static BusinessType forNumber(int i3) {
            if (i3 != -1) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        return null;
                    }
                    return kBusinessTypeWxPay;
                }
                return kBusinessTypeWxBase;
            }
            return kBusinessTypeUnknown;
        }

        public static ad.d<BusinessType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return BusinessTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static BusinessType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class EncryptInfo extends GeneratedMessageLite<EncryptInfo, Builder> implements EncryptInfoOrBuilder {
        public static final int ACTIONS_FIELD_NUMBER = 2;
        public static final int CHECKSTR_FIELD_NUMBER = 5;
        private static final EncryptInfo DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 1;
        private static volatile bg<EncryptInfo> PARSER = null;
        public static final int RANDSTR_FIELD_NUMBER = 4;
        public static final int TMSTAMP_FIELD_NUMBER = 3;
        private static final ad.h.a<Integer, LiveActionType> actions_converter_ = new ad.h.a<Integer, LiveActionType>() { // from class: com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfo.1
            @Override // com.google.protobuf.ad.h.a
            public LiveActionType convert(Integer num) {
                LiveActionType forNumber = LiveActionType.forNumber(num.intValue());
                return forNumber == null ? LiveActionType.ENUM_EYE_BLINK : forNumber;
            }
        };
        private int bitField0_;
        private int tmstamp_;
        private String deviceid_ = "";
        private ad.g actions_ = GeneratedMessageLite.emptyIntList();
        private String randstr_ = "";
        private String checkstr_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<EncryptInfo, Builder> implements EncryptInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addActions(LiveActionType liveActionType) {
                copyOnWrite();
                ((EncryptInfo) this.instance).addActions(liveActionType);
                return this;
            }

            public Builder addAllActions(Iterable<? extends LiveActionType> iterable) {
                copyOnWrite();
                ((EncryptInfo) this.instance).addAllActions(iterable);
                return this;
            }

            public Builder clearActions() {
                copyOnWrite();
                ((EncryptInfo) this.instance).clearActions();
                return this;
            }

            public Builder clearCheckstr() {
                copyOnWrite();
                ((EncryptInfo) this.instance).clearCheckstr();
                return this;
            }

            public Builder clearDeviceid() {
                copyOnWrite();
                ((EncryptInfo) this.instance).clearDeviceid();
                return this;
            }

            public Builder clearRandstr() {
                copyOnWrite();
                ((EncryptInfo) this.instance).clearRandstr();
                return this;
            }

            public Builder clearTmstamp() {
                copyOnWrite();
                ((EncryptInfo) this.instance).clearTmstamp();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public LiveActionType getActions(int i3) {
                return ((EncryptInfo) this.instance).getActions(i3);
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public int getActionsCount() {
                return ((EncryptInfo) this.instance).getActionsCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public List<LiveActionType> getActionsList() {
                return ((EncryptInfo) this.instance).getActionsList();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public String getCheckstr() {
                return ((EncryptInfo) this.instance).getCheckstr();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public ByteString getCheckstrBytes() {
                return ((EncryptInfo) this.instance).getCheckstrBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public String getDeviceid() {
                return ((EncryptInfo) this.instance).getDeviceid();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public ByteString getDeviceidBytes() {
                return ((EncryptInfo) this.instance).getDeviceidBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public String getRandstr() {
                return ((EncryptInfo) this.instance).getRandstr();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public ByteString getRandstrBytes() {
                return ((EncryptInfo) this.instance).getRandstrBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public int getTmstamp() {
                return ((EncryptInfo) this.instance).getTmstamp();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public boolean hasCheckstr() {
                return ((EncryptInfo) this.instance).hasCheckstr();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public boolean hasDeviceid() {
                return ((EncryptInfo) this.instance).hasDeviceid();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public boolean hasRandstr() {
                return ((EncryptInfo) this.instance).hasRandstr();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
            public boolean hasTmstamp() {
                return ((EncryptInfo) this.instance).hasTmstamp();
            }

            public Builder setActions(int i3, LiveActionType liveActionType) {
                copyOnWrite();
                ((EncryptInfo) this.instance).setActions(i3, liveActionType);
                return this;
            }

            public Builder setCheckstr(String str) {
                copyOnWrite();
                ((EncryptInfo) this.instance).setCheckstr(str);
                return this;
            }

            public Builder setCheckstrBytes(ByteString byteString) {
                copyOnWrite();
                ((EncryptInfo) this.instance).setCheckstrBytes(byteString);
                return this;
            }

            public Builder setDeviceid(String str) {
                copyOnWrite();
                ((EncryptInfo) this.instance).setDeviceid(str);
                return this;
            }

            public Builder setDeviceidBytes(ByteString byteString) {
                copyOnWrite();
                ((EncryptInfo) this.instance).setDeviceidBytes(byteString);
                return this;
            }

            public Builder setRandstr(String str) {
                copyOnWrite();
                ((EncryptInfo) this.instance).setRandstr(str);
                return this;
            }

            public Builder setRandstrBytes(ByteString byteString) {
                copyOnWrite();
                ((EncryptInfo) this.instance).setRandstrBytes(byteString);
                return this;
            }

            public Builder setTmstamp(int i3) {
                copyOnWrite();
                ((EncryptInfo) this.instance).setTmstamp(i3);
                return this;
            }

            Builder() {
                super(EncryptInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            EncryptInfo encryptInfo = new EncryptInfo();
            DEFAULT_INSTANCE = encryptInfo;
            GeneratedMessageLite.registerDefaultInstance(EncryptInfo.class, encryptInfo);
        }

        EncryptInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addActions(LiveActionType liveActionType) {
            liveActionType.getClass();
            ensureActionsIsMutable();
            this.actions_.e(liveActionType.getNumber());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllActions(Iterable<? extends LiveActionType> iterable) {
            ensureActionsIsMutable();
            Iterator<? extends LiveActionType> it = iterable.iterator();
            while (it.hasNext()) {
                this.actions_.e(it.next().getNumber());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearActions() {
            this.actions_ = GeneratedMessageLite.emptyIntList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCheckstr() {
            this.bitField0_ &= -9;
            this.checkstr_ = getDefaultInstance().getCheckstr();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceid() {
            this.bitField0_ &= -2;
            this.deviceid_ = getDefaultInstance().getDeviceid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRandstr() {
            this.bitField0_ &= -5;
            this.randstr_ = getDefaultInstance().getRandstr();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTmstamp() {
            this.bitField0_ &= -3;
            this.tmstamp_ = 0;
        }

        private void ensureActionsIsMutable() {
            if (!this.actions_.z()) {
                this.actions_ = GeneratedMessageLite.mutableCopy(this.actions_);
            }
        }

        public static EncryptInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static EncryptInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EncryptInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EncryptInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<EncryptInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActions(int i3, LiveActionType liveActionType) {
            liveActionType.getClass();
            ensureActionsIsMutable();
            this.actions_.k(i3, liveActionType.getNumber());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCheckstr(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.checkstr_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCheckstrBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.checkstr_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceid(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.deviceid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.deviceid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRandstr(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.randstr_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRandstrBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.randstr_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTmstamp(int i3) {
            this.bitField0_ |= 2;
            this.tmstamp_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new EncryptInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\b\u0000\u0002\u001e\u0003\u000b\u0001\u0004\b\u0002\u0005\b\u0003", new Object[]{"bitField0_", "deviceid_", "actions_", LiveActionType.internalGetVerifier(), "tmstamp_", "randstr_", "checkstr_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<EncryptInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (EncryptInfo.class) {
                            bgVar = PARSER;
                            if (bgVar == null) {
                                bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bgVar;
                            }
                        }
                    }
                    return bgVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public LiveActionType getActions(int i3) {
            return actions_converter_.convert(Integer.valueOf(this.actions_.getInt(i3)));
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public int getActionsCount() {
            return this.actions_.size();
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public List<LiveActionType> getActionsList() {
            return new ad.h(this.actions_, actions_converter_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public String getCheckstr() {
            return this.checkstr_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public ByteString getCheckstrBytes() {
            return ByteString.copyFromUtf8(this.checkstr_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public String getDeviceid() {
            return this.deviceid_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public ByteString getDeviceidBytes() {
            return ByteString.copyFromUtf8(this.deviceid_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public String getRandstr() {
            return this.randstr_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public ByteString getRandstrBytes() {
            return ByteString.copyFromUtf8(this.randstr_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public int getTmstamp() {
            return this.tmstamp_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public boolean hasCheckstr() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public boolean hasDeviceid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public boolean hasRandstr() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.EncryptInfoOrBuilder
        public boolean hasTmstamp() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(EncryptInfo encryptInfo) {
            return DEFAULT_INSTANCE.createBuilder(encryptInfo);
        }

        public static EncryptInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (EncryptInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static EncryptInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static EncryptInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EncryptInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static EncryptInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EncryptInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static EncryptInfo parseFrom(InputStream inputStream) throws IOException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EncryptInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static EncryptInfo parseFrom(k kVar) throws IOException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static EncryptInfo parseFrom(k kVar, t tVar) throws IOException {
            return (EncryptInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface EncryptInfoOrBuilder extends av {
        LiveActionType getActions(int i3);

        int getActionsCount();

        List<LiveActionType> getActionsList();

        String getCheckstr();

        ByteString getCheckstrBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getDeviceid();

        ByteString getDeviceidBytes();

        String getRandstr();

        ByteString getRandstrBytes();

        int getTmstamp();

        boolean hasCheckstr();

        boolean hasDeviceid();

        boolean hasRandstr();

        boolean hasTmstamp();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum FaceDataType implements ad.c {
        kFaceDataType_3D(1),
        kFaceDataType_2D_Video(2);

        private static final ad.d<FaceDataType> internalValueMap = new ad.d<FaceDataType>() { // from class: com.tencent.ilink.tdi.TdiApiCommProto.FaceDataType.1
            @Override // com.google.protobuf.ad.d
            public FaceDataType findValueByNumber(int i3) {
                return FaceDataType.forNumber(i3);
            }
        };
        public static final int kFaceDataType_2D_Video_VALUE = 2;
        public static final int kFaceDataType_3D_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class FaceDataTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new FaceDataTypeVerifier();

            FaceDataTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (FaceDataType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        FaceDataType(int i3) {
            this.value = i3;
        }

        public static FaceDataType forNumber(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return null;
                }
                return kFaceDataType_2D_Video;
            }
            return kFaceDataType_3D;
        }

        public static ad.d<FaceDataType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return FaceDataTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static FaceDataType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public enum FaceExtVerifyType implements ad.c {
        kFaceExtVerifyType_WxBase_Begin(0),
        kFaceExtVerifyType_WxBase_4PhoneNum(1),
        kFaceExtVerifyType_WxBase_End(999),
        kFaceExtVerifyType_WxPay_Begin(1000),
        kFaceExtVerifyType_WxPay_4PhoneNum(1001),
        kFaceExtVerifyType_WxPay_WholePhoneNum(1002),
        kFaceExtVerifyType_WxPay_QrCode(1003),
        kFaceExtVerifyType_WxPay_FacePin(1004),
        kFaceExtVerifyType_WxPay_End(1999);

        private static final ad.d<FaceExtVerifyType> internalValueMap = new ad.d<FaceExtVerifyType>() { // from class: com.tencent.ilink.tdi.TdiApiCommProto.FaceExtVerifyType.1
            @Override // com.google.protobuf.ad.d
            public FaceExtVerifyType findValueByNumber(int i3) {
                return FaceExtVerifyType.forNumber(i3);
            }
        };
        public static final int kFaceExtVerifyType_WxBase_4PhoneNum_VALUE = 1;
        public static final int kFaceExtVerifyType_WxBase_Begin_VALUE = 0;
        public static final int kFaceExtVerifyType_WxBase_End_VALUE = 999;
        public static final int kFaceExtVerifyType_WxPay_4PhoneNum_VALUE = 1001;
        public static final int kFaceExtVerifyType_WxPay_Begin_VALUE = 1000;
        public static final int kFaceExtVerifyType_WxPay_End_VALUE = 1999;
        public static final int kFaceExtVerifyType_WxPay_FacePin_VALUE = 1004;
        public static final int kFaceExtVerifyType_WxPay_QrCode_VALUE = 1003;
        public static final int kFaceExtVerifyType_WxPay_WholePhoneNum_VALUE = 1002;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class FaceExtVerifyTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new FaceExtVerifyTypeVerifier();

            FaceExtVerifyTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (FaceExtVerifyType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        FaceExtVerifyType(int i3) {
            this.value = i3;
        }

        public static FaceExtVerifyType forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 1999) {
                        switch (i3) {
                            case 999:
                                return kFaceExtVerifyType_WxBase_End;
                            case 1000:
                                return kFaceExtVerifyType_WxPay_Begin;
                            case 1001:
                                return kFaceExtVerifyType_WxPay_4PhoneNum;
                            case 1002:
                                return kFaceExtVerifyType_WxPay_WholePhoneNum;
                            case 1003:
                                return kFaceExtVerifyType_WxPay_QrCode;
                            case 1004:
                                return kFaceExtVerifyType_WxPay_FacePin;
                            default:
                                return null;
                        }
                    }
                    return kFaceExtVerifyType_WxPay_End;
                }
                return kFaceExtVerifyType_WxBase_4PhoneNum;
            }
            return kFaceExtVerifyType_WxBase_Begin;
        }

        public static ad.d<FaceExtVerifyType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return FaceExtVerifyTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static FaceExtVerifyType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class FaceFrame extends GeneratedMessageLite<FaceFrame, Builder> implements FaceFrameOrBuilder {
        private static final FaceFrame DEFAULT_INSTANCE;
        public static final int IMAGE_FIELD_NUMBER = 3;
        private static volatile bg<FaceFrame> PARSER = null;
        public static final int X_COORDINATES_FIELD_NUMBER = 1;
        public static final int Y_COORDINATES_FIELD_NUMBER = 2;
        private int bitField0_;
        private ad.f xCoordinates_ = GeneratedMessageLite.emptyFloatList();
        private ad.f yCoordinates_ = GeneratedMessageLite.emptyFloatList();
        private ByteString image_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<FaceFrame, Builder> implements FaceFrameOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllXCoordinates(Iterable<? extends Float> iterable) {
                copyOnWrite();
                ((FaceFrame) this.instance).addAllXCoordinates(iterable);
                return this;
            }

            public Builder addAllYCoordinates(Iterable<? extends Float> iterable) {
                copyOnWrite();
                ((FaceFrame) this.instance).addAllYCoordinates(iterable);
                return this;
            }

            public Builder addXCoordinates(float f16) {
                copyOnWrite();
                ((FaceFrame) this.instance).addXCoordinates(f16);
                return this;
            }

            public Builder addYCoordinates(float f16) {
                copyOnWrite();
                ((FaceFrame) this.instance).addYCoordinates(f16);
                return this;
            }

            public Builder clearImage() {
                copyOnWrite();
                ((FaceFrame) this.instance).clearImage();
                return this;
            }

            public Builder clearXCoordinates() {
                copyOnWrite();
                ((FaceFrame) this.instance).clearXCoordinates();
                return this;
            }

            public Builder clearYCoordinates() {
                copyOnWrite();
                ((FaceFrame) this.instance).clearYCoordinates();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
            public ByteString getImage() {
                return ((FaceFrame) this.instance).getImage();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
            public float getXCoordinates(int i3) {
                return ((FaceFrame) this.instance).getXCoordinates(i3);
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
            public int getXCoordinatesCount() {
                return ((FaceFrame) this.instance).getXCoordinatesCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
            public List<Float> getXCoordinatesList() {
                return Collections.unmodifiableList(((FaceFrame) this.instance).getXCoordinatesList());
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
            public float getYCoordinates(int i3) {
                return ((FaceFrame) this.instance).getYCoordinates(i3);
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
            public int getYCoordinatesCount() {
                return ((FaceFrame) this.instance).getYCoordinatesCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
            public List<Float> getYCoordinatesList() {
                return Collections.unmodifiableList(((FaceFrame) this.instance).getYCoordinatesList());
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
            public boolean hasImage() {
                return ((FaceFrame) this.instance).hasImage();
            }

            public Builder setImage(ByteString byteString) {
                copyOnWrite();
                ((FaceFrame) this.instance).setImage(byteString);
                return this;
            }

            public Builder setXCoordinates(int i3, float f16) {
                copyOnWrite();
                ((FaceFrame) this.instance).setXCoordinates(i3, f16);
                return this;
            }

            public Builder setYCoordinates(int i3, float f16) {
                copyOnWrite();
                ((FaceFrame) this.instance).setYCoordinates(i3, f16);
                return this;
            }

            Builder() {
                super(FaceFrame.DEFAULT_INSTANCE);
            }
        }

        static {
            FaceFrame faceFrame = new FaceFrame();
            DEFAULT_INSTANCE = faceFrame;
            GeneratedMessageLite.registerDefaultInstance(FaceFrame.class, faceFrame);
        }

        FaceFrame() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllXCoordinates(Iterable<? extends Float> iterable) {
            ensureXCoordinatesIsMutable();
            b.addAll((Iterable) iterable, (List) this.xCoordinates_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllYCoordinates(Iterable<? extends Float> iterable) {
            ensureYCoordinatesIsMutable();
            b.addAll((Iterable) iterable, (List) this.yCoordinates_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addXCoordinates(float f16) {
            ensureXCoordinatesIsMutable();
            this.xCoordinates_.j(f16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addYCoordinates(float f16) {
            ensureYCoordinatesIsMutable();
            this.yCoordinates_.j(f16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearImage() {
            this.bitField0_ &= -2;
            this.image_ = getDefaultInstance().getImage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearXCoordinates() {
            this.xCoordinates_ = GeneratedMessageLite.emptyFloatList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearYCoordinates() {
            this.yCoordinates_ = GeneratedMessageLite.emptyFloatList();
        }

        private void ensureXCoordinatesIsMutable() {
            if (!this.xCoordinates_.z()) {
                this.xCoordinates_ = GeneratedMessageLite.mutableCopy(this.xCoordinates_);
            }
        }

        private void ensureYCoordinatesIsMutable() {
            if (!this.yCoordinates_.z()) {
                this.yCoordinates_ = GeneratedMessageLite.mutableCopy(this.yCoordinates_);
            }
        }

        public static FaceFrame getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static FaceFrame parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FaceFrame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FaceFrame parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<FaceFrame> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImage(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.image_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXCoordinates(int i3, float f16) {
            ensureXCoordinatesIsMutable();
            this.xCoordinates_.l(i3, f16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setYCoordinates(int i3, float f16) {
            ensureYCoordinatesIsMutable();
            this.yCoordinates_.l(i3, f16);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new FaceFrame();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u0013\u0002\u0013\u0003\n\u0000", new Object[]{"bitField0_", "xCoordinates_", "yCoordinates_", "image_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<FaceFrame> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (FaceFrame.class) {
                            bgVar = PARSER;
                            if (bgVar == null) {
                                bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bgVar;
                            }
                        }
                    }
                    return bgVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
        public ByteString getImage() {
            return this.image_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
        public float getXCoordinates(int i3) {
            return this.xCoordinates_.getFloat(i3);
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
        public int getXCoordinatesCount() {
            return this.xCoordinates_.size();
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
        public List<Float> getXCoordinatesList() {
            return this.xCoordinates_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
        public float getYCoordinates(int i3) {
            return this.yCoordinates_.getFloat(i3);
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
        public int getYCoordinatesCount() {
            return this.yCoordinates_.size();
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
        public List<Float> getYCoordinatesList() {
            return this.yCoordinates_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceFrameOrBuilder
        public boolean hasImage() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(FaceFrame faceFrame) {
            return DEFAULT_INSTANCE.createBuilder(faceFrame);
        }

        public static FaceFrame parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (FaceFrame) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static FaceFrame parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static FaceFrame parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FaceFrame parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static FaceFrame parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FaceFrame parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static FaceFrame parseFrom(InputStream inputStream) throws IOException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FaceFrame parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static FaceFrame parseFrom(k kVar) throws IOException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static FaceFrame parseFrom(k kVar, t tVar) throws IOException {
            return (FaceFrame) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface FaceFrameOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getImage();

        float getXCoordinates(int i3);

        int getXCoordinatesCount();

        List<Float> getXCoordinatesList();

        float getYCoordinates(int i3);

        int getYCoordinatesCount();

        List<Float> getYCoordinatesList();

        boolean hasImage();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum FaceRecognizeResType implements ad.c {
        kFaceRecognizeTypeRes_Non(0),
        kFaceRecognizeTypeRes_WxPay(1),
        kFaceRecognizeTypeRes_WxBase(2),
        kFaceRecognizeTypeRes_WxPayBaseAll(3);

        private static final ad.d<FaceRecognizeResType> internalValueMap = new ad.d<FaceRecognizeResType>() { // from class: com.tencent.ilink.tdi.TdiApiCommProto.FaceRecognizeResType.1
            @Override // com.google.protobuf.ad.d
            public FaceRecognizeResType findValueByNumber(int i3) {
                return FaceRecognizeResType.forNumber(i3);
            }
        };
        public static final int kFaceRecognizeTypeRes_Non_VALUE = 0;
        public static final int kFaceRecognizeTypeRes_WxBase_VALUE = 2;
        public static final int kFaceRecognizeTypeRes_WxPayBaseAll_VALUE = 3;
        public static final int kFaceRecognizeTypeRes_WxPay_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class FaceRecognizeResTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new FaceRecognizeResTypeVerifier();

            FaceRecognizeResTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (FaceRecognizeResType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        FaceRecognizeResType(int i3) {
            this.value = i3;
        }

        public static FaceRecognizeResType forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return null;
                        }
                        return kFaceRecognizeTypeRes_WxPayBaseAll;
                    }
                    return kFaceRecognizeTypeRes_WxBase;
                }
                return kFaceRecognizeTypeRes_WxPay;
            }
            return kFaceRecognizeTypeRes_Non;
        }

        public static ad.d<FaceRecognizeResType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return FaceRecognizeResTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static FaceRecognizeResType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public enum FaceRecognizeType implements ad.c {
        kFaceRecognizeType_WxPayOnly(1),
        kFaceRecognizeType_Both_WxPayMain(2),
        kFaceRecognizeType_WxBaseOnly(3),
        kFaceRecognizeType_Both_WxBaseMain(4);

        private static final ad.d<FaceRecognizeType> internalValueMap = new ad.d<FaceRecognizeType>() { // from class: com.tencent.ilink.tdi.TdiApiCommProto.FaceRecognizeType.1
            @Override // com.google.protobuf.ad.d
            public FaceRecognizeType findValueByNumber(int i3) {
                return FaceRecognizeType.forNumber(i3);
            }
        };
        public static final int kFaceRecognizeType_Both_WxBaseMain_VALUE = 4;
        public static final int kFaceRecognizeType_Both_WxPayMain_VALUE = 2;
        public static final int kFaceRecognizeType_WxBaseOnly_VALUE = 3;
        public static final int kFaceRecognizeType_WxPayOnly_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class FaceRecognizeTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new FaceRecognizeTypeVerifier();

            FaceRecognizeTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (FaceRecognizeType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        FaceRecognizeType(int i3) {
            this.value = i3;
        }

        public static FaceRecognizeType forNumber(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return null;
                        }
                        return kFaceRecognizeType_Both_WxBaseMain;
                    }
                    return kFaceRecognizeType_WxBaseOnly;
                }
                return kFaceRecognizeType_Both_WxPayMain;
            }
            return kFaceRecognizeType_WxPayOnly;
        }

        public static ad.d<FaceRecognizeType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return FaceRecognizeTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static FaceRecognizeType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class FaceRect extends GeneratedMessageLite<FaceRect, Builder> implements FaceRectOrBuilder {
        private static final FaceRect DEFAULT_INSTANCE;
        public static final int FACE_HEIGHT_FIELD_NUMBER = 4;
        public static final int FACE_WIDTH_FIELD_NUMBER = 3;
        public static final int FACE_X_FIELD_NUMBER = 1;
        public static final int FACE_Y_FIELD_NUMBER = 2;
        private static volatile bg<FaceRect> PARSER;
        private int bitField0_;
        private int faceHeight_;
        private int faceWidth_;
        private int faceX_;
        private int faceY_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<FaceRect, Builder> implements FaceRectOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearFaceHeight() {
                copyOnWrite();
                ((FaceRect) this.instance).clearFaceHeight();
                return this;
            }

            public Builder clearFaceWidth() {
                copyOnWrite();
                ((FaceRect) this.instance).clearFaceWidth();
                return this;
            }

            public Builder clearFaceX() {
                copyOnWrite();
                ((FaceRect) this.instance).clearFaceX();
                return this;
            }

            public Builder clearFaceY() {
                copyOnWrite();
                ((FaceRect) this.instance).clearFaceY();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
            public int getFaceHeight() {
                return ((FaceRect) this.instance).getFaceHeight();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
            public int getFaceWidth() {
                return ((FaceRect) this.instance).getFaceWidth();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
            public int getFaceX() {
                return ((FaceRect) this.instance).getFaceX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
            public int getFaceY() {
                return ((FaceRect) this.instance).getFaceY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
            public boolean hasFaceHeight() {
                return ((FaceRect) this.instance).hasFaceHeight();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
            public boolean hasFaceWidth() {
                return ((FaceRect) this.instance).hasFaceWidth();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
            public boolean hasFaceX() {
                return ((FaceRect) this.instance).hasFaceX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
            public boolean hasFaceY() {
                return ((FaceRect) this.instance).hasFaceY();
            }

            public Builder setFaceHeight(int i3) {
                copyOnWrite();
                ((FaceRect) this.instance).setFaceHeight(i3);
                return this;
            }

            public Builder setFaceWidth(int i3) {
                copyOnWrite();
                ((FaceRect) this.instance).setFaceWidth(i3);
                return this;
            }

            public Builder setFaceX(int i3) {
                copyOnWrite();
                ((FaceRect) this.instance).setFaceX(i3);
                return this;
            }

            public Builder setFaceY(int i3) {
                copyOnWrite();
                ((FaceRect) this.instance).setFaceY(i3);
                return this;
            }

            Builder() {
                super(FaceRect.DEFAULT_INSTANCE);
            }
        }

        static {
            FaceRect faceRect = new FaceRect();
            DEFAULT_INSTANCE = faceRect;
            GeneratedMessageLite.registerDefaultInstance(FaceRect.class, faceRect);
        }

        FaceRect() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceHeight() {
            this.bitField0_ &= -9;
            this.faceHeight_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceWidth() {
            this.bitField0_ &= -5;
            this.faceWidth_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceX() {
            this.bitField0_ &= -2;
            this.faceX_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceY() {
            this.bitField0_ &= -3;
            this.faceY_ = 0;
        }

        public static FaceRect getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static FaceRect parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FaceRect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FaceRect parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<FaceRect> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceHeight(int i3) {
            this.bitField0_ |= 8;
            this.faceHeight_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceWidth(int i3) {
            this.bitField0_ |= 4;
            this.faceWidth_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceX(int i3) {
            this.bitField0_ |= 1;
            this.faceX_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceY(int i3) {
            this.bitField0_ |= 2;
            this.faceY_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new FaceRect();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0000\u0002\u000b\u0001\u0003\u000b\u0002\u0004\u000b\u0003", new Object[]{"bitField0_", "faceX_", "faceY_", "faceWidth_", "faceHeight_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<FaceRect> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (FaceRect.class) {
                            bgVar = PARSER;
                            if (bgVar == null) {
                                bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bgVar;
                            }
                        }
                    }
                    return bgVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
        public int getFaceHeight() {
            return this.faceHeight_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
        public int getFaceWidth() {
            return this.faceWidth_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
        public int getFaceX() {
            return this.faceX_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
        public int getFaceY() {
            return this.faceY_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
        public boolean hasFaceHeight() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
        public boolean hasFaceWidth() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
        public boolean hasFaceX() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceRectOrBuilder
        public boolean hasFaceY() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(FaceRect faceRect) {
            return DEFAULT_INSTANCE.createBuilder(faceRect);
        }

        public static FaceRect parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (FaceRect) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static FaceRect parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static FaceRect parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static FaceRect parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static FaceRect parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FaceRect parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static FaceRect parseFrom(InputStream inputStream) throws IOException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FaceRect parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static FaceRect parseFrom(k kVar) throws IOException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static FaceRect parseFrom(k kVar, t tVar) throws IOException {
            return (FaceRect) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface FaceRectOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getFaceHeight();

        int getFaceWidth();

        int getFaceX();

        int getFaceY();

        boolean hasFaceHeight();

        boolean hasFaceWidth();

        boolean hasFaceX();

        boolean hasFaceY();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class FaceVideo extends GeneratedMessageLite<FaceVideo, Builder> implements FaceVideoOrBuilder {
        public static final int ACTION_FIELD_NUMBER = 2;
        private static final FaceVideo DEFAULT_INSTANCE;
        public static final int FRAMES_FIELD_NUMBER = 1;
        private static volatile bg<FaceVideo> PARSER;
        private int action_;
        private int bitField0_;
        private ad.j<FaceFrame> frames_ = GeneratedMessageLite.emptyProtobufList();

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<FaceVideo, Builder> implements FaceVideoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllFrames(Iterable<? extends FaceFrame> iterable) {
                copyOnWrite();
                ((FaceVideo) this.instance).addAllFrames(iterable);
                return this;
            }

            public Builder addFrames(FaceFrame faceFrame) {
                copyOnWrite();
                ((FaceVideo) this.instance).addFrames(faceFrame);
                return this;
            }

            public Builder clearAction() {
                copyOnWrite();
                ((FaceVideo) this.instance).clearAction();
                return this;
            }

            public Builder clearFrames() {
                copyOnWrite();
                ((FaceVideo) this.instance).clearFrames();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
            public LiveActionType getAction() {
                return ((FaceVideo) this.instance).getAction();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
            public FaceFrame getFrames(int i3) {
                return ((FaceVideo) this.instance).getFrames(i3);
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
            public int getFramesCount() {
                return ((FaceVideo) this.instance).getFramesCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
            public List<FaceFrame> getFramesList() {
                return Collections.unmodifiableList(((FaceVideo) this.instance).getFramesList());
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
            public boolean hasAction() {
                return ((FaceVideo) this.instance).hasAction();
            }

            public Builder removeFrames(int i3) {
                copyOnWrite();
                ((FaceVideo) this.instance).removeFrames(i3);
                return this;
            }

            public Builder setAction(LiveActionType liveActionType) {
                copyOnWrite();
                ((FaceVideo) this.instance).setAction(liveActionType);
                return this;
            }

            public Builder setFrames(int i3, FaceFrame faceFrame) {
                copyOnWrite();
                ((FaceVideo) this.instance).setFrames(i3, faceFrame);
                return this;
            }

            Builder() {
                super(FaceVideo.DEFAULT_INSTANCE);
            }

            public Builder addFrames(int i3, FaceFrame faceFrame) {
                copyOnWrite();
                ((FaceVideo) this.instance).addFrames(i3, faceFrame);
                return this;
            }

            public Builder setFrames(int i3, FaceFrame.Builder builder) {
                copyOnWrite();
                ((FaceVideo) this.instance).setFrames(i3, builder);
                return this;
            }

            public Builder addFrames(FaceFrame.Builder builder) {
                copyOnWrite();
                ((FaceVideo) this.instance).addFrames(builder);
                return this;
            }

            public Builder addFrames(int i3, FaceFrame.Builder builder) {
                copyOnWrite();
                ((FaceVideo) this.instance).addFrames(i3, builder);
                return this;
            }
        }

        static {
            FaceVideo faceVideo = new FaceVideo();
            DEFAULT_INSTANCE = faceVideo;
            GeneratedMessageLite.registerDefaultInstance(FaceVideo.class, faceVideo);
        }

        FaceVideo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllFrames(Iterable<? extends FaceFrame> iterable) {
            ensureFramesIsMutable();
            b.addAll((Iterable) iterable, (List) this.frames_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFrames(FaceFrame faceFrame) {
            faceFrame.getClass();
            ensureFramesIsMutable();
            this.frames_.add(faceFrame);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAction() {
            this.bitField0_ &= -2;
            this.action_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFrames() {
            this.frames_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureFramesIsMutable() {
            if (!this.frames_.z()) {
                this.frames_ = GeneratedMessageLite.mutableCopy(this.frames_);
            }
        }

        public static FaceVideo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static FaceVideo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FaceVideo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FaceVideo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<FaceVideo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeFrames(int i3) {
            ensureFramesIsMutable();
            this.frames_.remove(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAction(LiveActionType liveActionType) {
            liveActionType.getClass();
            this.bitField0_ |= 1;
            this.action_ = liveActionType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFrames(int i3, FaceFrame faceFrame) {
            faceFrame.getClass();
            ensureFramesIsMutable();
            this.frames_.set(i3, faceFrame);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new FaceVideo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\f\u0000", new Object[]{"bitField0_", "frames_", FaceFrame.class, "action_", LiveActionType.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<FaceVideo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (FaceVideo.class) {
                            bgVar = PARSER;
                            if (bgVar == null) {
                                bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bgVar;
                            }
                        }
                    }
                    return bgVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
        public LiveActionType getAction() {
            LiveActionType forNumber = LiveActionType.forNumber(this.action_);
            if (forNumber == null) {
                return LiveActionType.ENUM_EYE_BLINK;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
        public FaceFrame getFrames(int i3) {
            return this.frames_.get(i3);
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
        public int getFramesCount() {
            return this.frames_.size();
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
        public List<FaceFrame> getFramesList() {
            return this.frames_;
        }

        public FaceFrameOrBuilder getFramesOrBuilder(int i3) {
            return this.frames_.get(i3);
        }

        public List<? extends FaceFrameOrBuilder> getFramesOrBuilderList() {
            return this.frames_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.FaceVideoOrBuilder
        public boolean hasAction() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(FaceVideo faceVideo) {
            return DEFAULT_INSTANCE.createBuilder(faceVideo);
        }

        public static FaceVideo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (FaceVideo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static FaceVideo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static FaceVideo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFrames(int i3, FaceFrame faceFrame) {
            faceFrame.getClass();
            ensureFramesIsMutable();
            this.frames_.add(i3, faceFrame);
        }

        public static FaceVideo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFrames(int i3, FaceFrame.Builder builder) {
            ensureFramesIsMutable();
            this.frames_.set(i3, builder.build());
        }

        public static FaceVideo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static FaceVideo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFrames(FaceFrame.Builder builder) {
            ensureFramesIsMutable();
            this.frames_.add(builder.build());
        }

        public static FaceVideo parseFrom(InputStream inputStream) throws IOException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static FaceVideo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addFrames(int i3, FaceFrame.Builder builder) {
            ensureFramesIsMutable();
            this.frames_.add(i3, builder.build());
        }

        public static FaceVideo parseFrom(k kVar) throws IOException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static FaceVideo parseFrom(k kVar, t tVar) throws IOException {
            return (FaceVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface FaceVideoOrBuilder extends av {
        LiveActionType getAction();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        FaceFrame getFrames(int i3);

        int getFramesCount();

        List<FaceFrame> getFramesList();

        boolean hasAction();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum ILinkAppLoginType implements ad.c {
        kILinkAppLoginType_WxPay(1),
        kILinkAppLoginType_WxBase(2),
        kILinkAppLoginType_WxOAuth(4);

        private static final ad.d<ILinkAppLoginType> internalValueMap = new ad.d<ILinkAppLoginType>() { // from class: com.tencent.ilink.tdi.TdiApiCommProto.ILinkAppLoginType.1
            @Override // com.google.protobuf.ad.d
            public ILinkAppLoginType findValueByNumber(int i3) {
                return ILinkAppLoginType.forNumber(i3);
            }
        };
        public static final int kILinkAppLoginType_WxBase_VALUE = 2;
        public static final int kILinkAppLoginType_WxOAuth_VALUE = 4;
        public static final int kILinkAppLoginType_WxPay_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class ILinkAppLoginTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new ILinkAppLoginTypeVerifier();

            ILinkAppLoginTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (ILinkAppLoginType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        ILinkAppLoginType(int i3) {
            this.value = i3;
        }

        public static ILinkAppLoginType forNumber(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 4) {
                        return null;
                    }
                    return kILinkAppLoginType_WxOAuth;
                }
                return kILinkAppLoginType_WxBase;
            }
            return kILinkAppLoginType_WxPay;
        }

        public static ad.d<ILinkAppLoginType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return ILinkAppLoginTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ILinkAppLoginType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class KeyPoints extends GeneratedMessageLite<KeyPoints, Builder> implements KeyPointsOrBuilder {
        private static final KeyPoints DEFAULT_INSTANCE;
        public static final int LEFT_EYE_X_FIELD_NUMBER = 1;
        public static final int LEFT_EYE_Y_FIELD_NUMBER = 2;
        public static final int LEFT_MOUTH_X_FIELD_NUMBER = 7;
        public static final int LEFT_MOUTH_Y_FIELD_NUMBER = 8;
        public static final int NOSE_X_FIELD_NUMBER = 5;
        public static final int NOSE_Y_FIELD_NUMBER = 6;
        private static volatile bg<KeyPoints> PARSER = null;
        public static final int RIGHT_EYE_X_FIELD_NUMBER = 3;
        public static final int RIGHT_EYE_Y_FIELD_NUMBER = 4;
        public static final int RIGHT_MOUTH_X_FIELD_NUMBER = 9;
        public static final int RIGHT_MOUTH_Y_FIELD_NUMBER = 10;
        private int bitField0_;
        private float leftEyeX_;
        private float leftEyeY_;
        private float leftMouthX_;
        private float leftMouthY_;
        private float noseX_;
        private float noseY_;
        private float rightEyeX_;
        private float rightEyeY_;
        private float rightMouthX_;
        private float rightMouthY_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<KeyPoints, Builder> implements KeyPointsOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearLeftEyeX() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearLeftEyeX();
                return this;
            }

            public Builder clearLeftEyeY() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearLeftEyeY();
                return this;
            }

            public Builder clearLeftMouthX() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearLeftMouthX();
                return this;
            }

            public Builder clearLeftMouthY() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearLeftMouthY();
                return this;
            }

            public Builder clearNoseX() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearNoseX();
                return this;
            }

            public Builder clearNoseY() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearNoseY();
                return this;
            }

            public Builder clearRightEyeX() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearRightEyeX();
                return this;
            }

            public Builder clearRightEyeY() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearRightEyeY();
                return this;
            }

            public Builder clearRightMouthX() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearRightMouthX();
                return this;
            }

            public Builder clearRightMouthY() {
                copyOnWrite();
                ((KeyPoints) this.instance).clearRightMouthY();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getLeftEyeX() {
                return ((KeyPoints) this.instance).getLeftEyeX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getLeftEyeY() {
                return ((KeyPoints) this.instance).getLeftEyeY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getLeftMouthX() {
                return ((KeyPoints) this.instance).getLeftMouthX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getLeftMouthY() {
                return ((KeyPoints) this.instance).getLeftMouthY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getNoseX() {
                return ((KeyPoints) this.instance).getNoseX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getNoseY() {
                return ((KeyPoints) this.instance).getNoseY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getRightEyeX() {
                return ((KeyPoints) this.instance).getRightEyeX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getRightEyeY() {
                return ((KeyPoints) this.instance).getRightEyeY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getRightMouthX() {
                return ((KeyPoints) this.instance).getRightMouthX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public float getRightMouthY() {
                return ((KeyPoints) this.instance).getRightMouthY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasLeftEyeX() {
                return ((KeyPoints) this.instance).hasLeftEyeX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasLeftEyeY() {
                return ((KeyPoints) this.instance).hasLeftEyeY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasLeftMouthX() {
                return ((KeyPoints) this.instance).hasLeftMouthX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasLeftMouthY() {
                return ((KeyPoints) this.instance).hasLeftMouthY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasNoseX() {
                return ((KeyPoints) this.instance).hasNoseX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasNoseY() {
                return ((KeyPoints) this.instance).hasNoseY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasRightEyeX() {
                return ((KeyPoints) this.instance).hasRightEyeX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasRightEyeY() {
                return ((KeyPoints) this.instance).hasRightEyeY();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasRightMouthX() {
                return ((KeyPoints) this.instance).hasRightMouthX();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
            public boolean hasRightMouthY() {
                return ((KeyPoints) this.instance).hasRightMouthY();
            }

            public Builder setLeftEyeX(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setLeftEyeX(f16);
                return this;
            }

            public Builder setLeftEyeY(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setLeftEyeY(f16);
                return this;
            }

            public Builder setLeftMouthX(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setLeftMouthX(f16);
                return this;
            }

            public Builder setLeftMouthY(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setLeftMouthY(f16);
                return this;
            }

            public Builder setNoseX(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setNoseX(f16);
                return this;
            }

            public Builder setNoseY(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setNoseY(f16);
                return this;
            }

            public Builder setRightEyeX(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setRightEyeX(f16);
                return this;
            }

            public Builder setRightEyeY(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setRightEyeY(f16);
                return this;
            }

            public Builder setRightMouthX(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setRightMouthX(f16);
                return this;
            }

            public Builder setRightMouthY(float f16) {
                copyOnWrite();
                ((KeyPoints) this.instance).setRightMouthY(f16);
                return this;
            }

            Builder() {
                super(KeyPoints.DEFAULT_INSTANCE);
            }
        }

        static {
            KeyPoints keyPoints = new KeyPoints();
            DEFAULT_INSTANCE = keyPoints;
            GeneratedMessageLite.registerDefaultInstance(KeyPoints.class, keyPoints);
        }

        KeyPoints() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLeftEyeX() {
            this.bitField0_ &= -2;
            this.leftEyeX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLeftEyeY() {
            this.bitField0_ &= -3;
            this.leftEyeY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLeftMouthX() {
            this.bitField0_ &= -65;
            this.leftMouthX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLeftMouthY() {
            this.bitField0_ &= -129;
            this.leftMouthY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNoseX() {
            this.bitField0_ &= -17;
            this.noseX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNoseY() {
            this.bitField0_ &= -33;
            this.noseY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRightEyeX() {
            this.bitField0_ &= -5;
            this.rightEyeX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRightEyeY() {
            this.bitField0_ &= -9;
            this.rightEyeY_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRightMouthX() {
            this.bitField0_ &= -257;
            this.rightMouthX_ = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRightMouthY() {
            this.bitField0_ &= -513;
            this.rightMouthY_ = 0.0f;
        }

        public static KeyPoints getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static KeyPoints parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (KeyPoints) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyPoints parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<KeyPoints> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeftEyeX(float f16) {
            this.bitField0_ |= 1;
            this.leftEyeX_ = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeftEyeY(float f16) {
            this.bitField0_ |= 2;
            this.leftEyeY_ = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeftMouthX(float f16) {
            this.bitField0_ |= 64;
            this.leftMouthX_ = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeftMouthY(float f16) {
            this.bitField0_ |= 128;
            this.leftMouthY_ = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNoseX(float f16) {
            this.bitField0_ |= 16;
            this.noseX_ = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNoseY(float f16) {
            this.bitField0_ |= 32;
            this.noseY_ = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRightEyeX(float f16) {
            this.bitField0_ |= 4;
            this.rightEyeX_ = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRightEyeY(float f16) {
            this.bitField0_ |= 8;
            this.rightEyeY_ = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRightMouthX(float f16) {
            this.bitField0_ |= 256;
            this.rightMouthX_ = f16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRightMouthY(float f16) {
            this.bitField0_ |= 512;
            this.rightMouthY_ = f16;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new KeyPoints();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\u0001\u0000\u0002\u0001\u0001\u0003\u0001\u0002\u0004\u0001\u0003\u0005\u0001\u0004\u0006\u0001\u0005\u0007\u0001\u0006\b\u0001\u0007\t\u0001\b\n\u0001\t", new Object[]{"bitField0_", "leftEyeX_", "leftEyeY_", "rightEyeX_", "rightEyeY_", "noseX_", "noseY_", "leftMouthX_", "leftMouthY_", "rightMouthX_", "rightMouthY_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<KeyPoints> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (KeyPoints.class) {
                            bgVar = PARSER;
                            if (bgVar == null) {
                                bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bgVar;
                            }
                        }
                    }
                    return bgVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getLeftEyeX() {
            return this.leftEyeX_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getLeftEyeY() {
            return this.leftEyeY_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getLeftMouthX() {
            return this.leftMouthX_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getLeftMouthY() {
            return this.leftMouthY_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getNoseX() {
            return this.noseX_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getNoseY() {
            return this.noseY_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getRightEyeX() {
            return this.rightEyeX_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getRightEyeY() {
            return this.rightEyeY_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getRightMouthX() {
            return this.rightMouthX_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public float getRightMouthY() {
            return this.rightMouthY_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasLeftEyeX() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasLeftEyeY() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasLeftMouthX() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasLeftMouthY() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasNoseX() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasNoseY() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasRightEyeX() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasRightEyeY() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasRightMouthX() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.KeyPointsOrBuilder
        public boolean hasRightMouthY() {
            if ((this.bitField0_ & 512) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(KeyPoints keyPoints) {
            return DEFAULT_INSTANCE.createBuilder(keyPoints);
        }

        public static KeyPoints parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (KeyPoints) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static KeyPoints parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static KeyPoints parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static KeyPoints parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static KeyPoints parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static KeyPoints parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static KeyPoints parseFrom(InputStream inputStream) throws IOException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static KeyPoints parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static KeyPoints parseFrom(k kVar) throws IOException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static KeyPoints parseFrom(k kVar, t tVar) throws IOException {
            return (KeyPoints) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface KeyPointsOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        float getLeftEyeX();

        float getLeftEyeY();

        float getLeftMouthX();

        float getLeftMouthY();

        float getNoseX();

        float getNoseY();

        float getRightEyeX();

        float getRightEyeY();

        float getRightMouthX();

        float getRightMouthY();

        boolean hasLeftEyeX();

        boolean hasLeftEyeY();

        boolean hasLeftMouthX();

        boolean hasLeftMouthY();

        boolean hasNoseX();

        boolean hasNoseY();

        boolean hasRightEyeX();

        boolean hasRightEyeY();

        boolean hasRightMouthX();

        boolean hasRightMouthY();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum LiveActionType implements ad.c {
        ENUM_EYE_BLINK(0),
        ENUM_HEAD_SHAKE(1),
        ENUM_MOUTH_OPEN(2);

        public static final int ENUM_EYE_BLINK_VALUE = 0;
        public static final int ENUM_HEAD_SHAKE_VALUE = 1;
        public static final int ENUM_MOUTH_OPEN_VALUE = 2;
        private static final ad.d<LiveActionType> internalValueMap = new ad.d<LiveActionType>() { // from class: com.tencent.ilink.tdi.TdiApiCommProto.LiveActionType.1
            @Override // com.google.protobuf.ad.d
            public LiveActionType findValueByNumber(int i3) {
                return LiveActionType.forNumber(i3);
            }
        };
        private final int value;

        /* loaded from: classes7.dex */
        public static final class LiveActionTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new LiveActionTypeVerifier();

            LiveActionTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (LiveActionType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        LiveActionType(int i3) {
            this.value = i3;
        }

        public static LiveActionType forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return null;
                    }
                    return ENUM_MOUTH_OPEN;
                }
                return ENUM_HEAD_SHAKE;
            }
            return ENUM_EYE_BLINK;
        }

        public static ad.d<LiveActionType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return LiveActionTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static LiveActionType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public enum LoginQrCodeStatus implements ad.c {
        kLoginQrCodeStatus_NoScan(0),
        kLoginQrCodeStatus_Scaned(1),
        kLoginQrCodeStatus_Confirmed(2),
        kLoginQrCodeStatus_Canceled(3),
        kLoginQrCodeStatus_Expired(4);

        private static final ad.d<LoginQrCodeStatus> internalValueMap = new ad.d<LoginQrCodeStatus>() { // from class: com.tencent.ilink.tdi.TdiApiCommProto.LoginQrCodeStatus.1
            @Override // com.google.protobuf.ad.d
            public LoginQrCodeStatus findValueByNumber(int i3) {
                return LoginQrCodeStatus.forNumber(i3);
            }
        };
        public static final int kLoginQrCodeStatus_Canceled_VALUE = 3;
        public static final int kLoginQrCodeStatus_Confirmed_VALUE = 2;
        public static final int kLoginQrCodeStatus_Expired_VALUE = 4;
        public static final int kLoginQrCodeStatus_NoScan_VALUE = 0;
        public static final int kLoginQrCodeStatus_Scaned_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class LoginQrCodeStatusVerifier implements ad.e {
            static final ad.e INSTANCE = new LoginQrCodeStatusVerifier();

            LoginQrCodeStatusVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (LoginQrCodeStatus.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        LoginQrCodeStatus(int i3) {
            this.value = i3;
        }

        public static LoginQrCodeStatus forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                return null;
                            }
                            return kLoginQrCodeStatus_Expired;
                        }
                        return kLoginQrCodeStatus_Canceled;
                    }
                    return kLoginQrCodeStatus_Confirmed;
                }
                return kLoginQrCodeStatus_Scaned;
            }
            return kLoginQrCodeStatus_NoScan;
        }

        public static ad.d<LoginQrCodeStatus> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return LoginQrCodeStatusVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static LoginQrCodeStatus valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class ThreeDFaceData extends GeneratedMessageLite<ThreeDFaceData, Builder> implements ThreeDFaceDataOrBuilder {
        public static final int COLOR_IMAGE_FIELD_NUMBER = 1;
        private static final ThreeDFaceData DEFAULT_INSTANCE;
        public static final int DEPTH_IMAGE_FIELD_NUMBER = 2;
        public static final int FACE_RECT_FIELD_NUMBER = 5;
        public static final int INFRARED_IMAGE_FIELD_NUMBER = 3;
        public static final int KEY_POINTS_FIELD_NUMBER = 4;
        private static volatile bg<ThreeDFaceData> PARSER;
        private int bitField0_;
        private ByteString colorImage_;
        private ByteString depthImage_;
        private FaceRect faceRect_;
        private ByteString infraredImage_;
        private KeyPoints keyPoints_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<ThreeDFaceData, Builder> implements ThreeDFaceDataOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearColorImage() {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).clearColorImage();
                return this;
            }

            public Builder clearDepthImage() {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).clearDepthImage();
                return this;
            }

            public Builder clearFaceRect() {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).clearFaceRect();
                return this;
            }

            public Builder clearInfraredImage() {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).clearInfraredImage();
                return this;
            }

            public Builder clearKeyPoints() {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).clearKeyPoints();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public ByteString getColorImage() {
                return ((ThreeDFaceData) this.instance).getColorImage();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public ByteString getDepthImage() {
                return ((ThreeDFaceData) this.instance).getDepthImage();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public FaceRect getFaceRect() {
                return ((ThreeDFaceData) this.instance).getFaceRect();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public ByteString getInfraredImage() {
                return ((ThreeDFaceData) this.instance).getInfraredImage();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public KeyPoints getKeyPoints() {
                return ((ThreeDFaceData) this.instance).getKeyPoints();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public boolean hasColorImage() {
                return ((ThreeDFaceData) this.instance).hasColorImage();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public boolean hasDepthImage() {
                return ((ThreeDFaceData) this.instance).hasDepthImage();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public boolean hasFaceRect() {
                return ((ThreeDFaceData) this.instance).hasFaceRect();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public boolean hasInfraredImage() {
                return ((ThreeDFaceData) this.instance).hasInfraredImage();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
            public boolean hasKeyPoints() {
                return ((ThreeDFaceData) this.instance).hasKeyPoints();
            }

            public Builder mergeFaceRect(FaceRect faceRect) {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).mergeFaceRect(faceRect);
                return this;
            }

            public Builder mergeKeyPoints(KeyPoints keyPoints) {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).mergeKeyPoints(keyPoints);
                return this;
            }

            public Builder setColorImage(ByteString byteString) {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).setColorImage(byteString);
                return this;
            }

            public Builder setDepthImage(ByteString byteString) {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).setDepthImage(byteString);
                return this;
            }

            public Builder setFaceRect(FaceRect faceRect) {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).setFaceRect(faceRect);
                return this;
            }

            public Builder setInfraredImage(ByteString byteString) {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).setInfraredImage(byteString);
                return this;
            }

            public Builder setKeyPoints(KeyPoints keyPoints) {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).setKeyPoints(keyPoints);
                return this;
            }

            Builder() {
                super(ThreeDFaceData.DEFAULT_INSTANCE);
            }

            public Builder setFaceRect(FaceRect.Builder builder) {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).setFaceRect(builder);
                return this;
            }

            public Builder setKeyPoints(KeyPoints.Builder builder) {
                copyOnWrite();
                ((ThreeDFaceData) this.instance).setKeyPoints(builder);
                return this;
            }
        }

        static {
            ThreeDFaceData threeDFaceData = new ThreeDFaceData();
            DEFAULT_INSTANCE = threeDFaceData;
            GeneratedMessageLite.registerDefaultInstance(ThreeDFaceData.class, threeDFaceData);
        }

        ThreeDFaceData() {
            ByteString byteString = ByteString.EMPTY;
            this.colorImage_ = byteString;
            this.depthImage_ = byteString;
            this.infraredImage_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearColorImage() {
            this.bitField0_ &= -2;
            this.colorImage_ = getDefaultInstance().getColorImage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDepthImage() {
            this.bitField0_ &= -3;
            this.depthImage_ = getDefaultInstance().getDepthImage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceRect() {
            this.faceRect_ = null;
            this.bitField0_ &= -17;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInfraredImage() {
            this.bitField0_ &= -5;
            this.infraredImage_ = getDefaultInstance().getInfraredImage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearKeyPoints() {
            this.keyPoints_ = null;
            this.bitField0_ &= -9;
        }

        public static ThreeDFaceData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeFaceRect(FaceRect faceRect) {
            faceRect.getClass();
            FaceRect faceRect2 = this.faceRect_;
            if (faceRect2 != null && faceRect2 != FaceRect.getDefaultInstance()) {
                this.faceRect_ = FaceRect.newBuilder(this.faceRect_).mergeFrom((FaceRect.Builder) faceRect).buildPartial();
            } else {
                this.faceRect_ = faceRect;
            }
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeKeyPoints(KeyPoints keyPoints) {
            keyPoints.getClass();
            KeyPoints keyPoints2 = this.keyPoints_;
            if (keyPoints2 != null && keyPoints2 != KeyPoints.getDefaultInstance()) {
                this.keyPoints_ = KeyPoints.newBuilder(this.keyPoints_).mergeFrom((KeyPoints.Builder) keyPoints).buildPartial();
            } else {
                this.keyPoints_ = keyPoints;
            }
            this.bitField0_ |= 8;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ThreeDFaceData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ThreeDFaceData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ThreeDFaceData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<ThreeDFaceData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setColorImage(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.colorImage_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDepthImage(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.depthImage_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceRect(FaceRect faceRect) {
            faceRect.getClass();
            this.faceRect_ = faceRect;
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInfraredImage(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.infraredImage_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyPoints(KeyPoints keyPoints) {
            keyPoints.getClass();
            this.keyPoints_ = keyPoints;
            this.bitField0_ |= 8;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ThreeDFaceData();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002\u0004\t\u0003\u0005\t\u0004", new Object[]{"bitField0_", "colorImage_", "depthImage_", "infraredImage_", "keyPoints_", "faceRect_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<ThreeDFaceData> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (ThreeDFaceData.class) {
                            bgVar = PARSER;
                            if (bgVar == null) {
                                bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bgVar;
                            }
                        }
                    }
                    return bgVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public ByteString getColorImage() {
            return this.colorImage_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public ByteString getDepthImage() {
            return this.depthImage_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public FaceRect getFaceRect() {
            FaceRect faceRect = this.faceRect_;
            if (faceRect == null) {
                return FaceRect.getDefaultInstance();
            }
            return faceRect;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public ByteString getInfraredImage() {
            return this.infraredImage_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public KeyPoints getKeyPoints() {
            KeyPoints keyPoints = this.keyPoints_;
            if (keyPoints == null) {
                return KeyPoints.getDefaultInstance();
            }
            return keyPoints;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public boolean hasColorImage() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public boolean hasDepthImage() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public boolean hasFaceRect() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public boolean hasInfraredImage() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.ThreeDFaceDataOrBuilder
        public boolean hasKeyPoints() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(ThreeDFaceData threeDFaceData) {
            return DEFAULT_INSTANCE.createBuilder(threeDFaceData);
        }

        public static ThreeDFaceData parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ThreeDFaceData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ThreeDFaceData parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static ThreeDFaceData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ThreeDFaceData parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceRect(FaceRect.Builder builder) {
            this.faceRect_ = builder.build();
            this.bitField0_ |= 16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setKeyPoints(KeyPoints.Builder builder) {
            this.keyPoints_ = builder.build();
            this.bitField0_ |= 8;
        }

        public static ThreeDFaceData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ThreeDFaceData parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static ThreeDFaceData parseFrom(InputStream inputStream) throws IOException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ThreeDFaceData parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ThreeDFaceData parseFrom(k kVar) throws IOException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static ThreeDFaceData parseFrom(k kVar, t tVar) throws IOException {
            return (ThreeDFaceData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface ThreeDFaceDataOrBuilder extends av {
        ByteString getColorImage();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getDepthImage();

        FaceRect getFaceRect();

        ByteString getInfraredImage();

        KeyPoints getKeyPoints();

        boolean hasColorImage();

        boolean hasDepthImage();

        boolean hasFaceRect();

        boolean hasInfraredImage();

        boolean hasKeyPoints();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TwoDConfig extends GeneratedMessageLite<TwoDConfig, Builder> implements TwoDConfigOrBuilder {
        private static final TwoDConfig DEFAULT_INSTANCE;
        public static final int ENCRYPT_FIELD_NUMBER = 1;
        private static volatile bg<TwoDConfig> PARSER;
        private int bitField0_;
        private EncryptInfo encrypt_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TwoDConfig, Builder> implements TwoDConfigOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearEncrypt() {
                copyOnWrite();
                ((TwoDConfig) this.instance).clearEncrypt();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDConfigOrBuilder
            public EncryptInfo getEncrypt() {
                return ((TwoDConfig) this.instance).getEncrypt();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDConfigOrBuilder
            public boolean hasEncrypt() {
                return ((TwoDConfig) this.instance).hasEncrypt();
            }

            public Builder mergeEncrypt(EncryptInfo encryptInfo) {
                copyOnWrite();
                ((TwoDConfig) this.instance).mergeEncrypt(encryptInfo);
                return this;
            }

            public Builder setEncrypt(EncryptInfo encryptInfo) {
                copyOnWrite();
                ((TwoDConfig) this.instance).setEncrypt(encryptInfo);
                return this;
            }

            Builder() {
                super(TwoDConfig.DEFAULT_INSTANCE);
            }

            public Builder setEncrypt(EncryptInfo.Builder builder) {
                copyOnWrite();
                ((TwoDConfig) this.instance).setEncrypt(builder);
                return this;
            }
        }

        static {
            TwoDConfig twoDConfig = new TwoDConfig();
            DEFAULT_INSTANCE = twoDConfig;
            GeneratedMessageLite.registerDefaultInstance(TwoDConfig.class, twoDConfig);
        }

        TwoDConfig() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEncrypt() {
            this.encrypt_ = null;
            this.bitField0_ &= -2;
        }

        public static TwoDConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEncrypt(EncryptInfo encryptInfo) {
            encryptInfo.getClass();
            EncryptInfo encryptInfo2 = this.encrypt_;
            if (encryptInfo2 != null && encryptInfo2 != EncryptInfo.getDefaultInstance()) {
                this.encrypt_ = EncryptInfo.newBuilder(this.encrypt_).mergeFrom((EncryptInfo.Builder) encryptInfo).buildPartial();
            } else {
                this.encrypt_ = encryptInfo;
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TwoDConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TwoDConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TwoDConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TwoDConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncrypt(EncryptInfo encryptInfo) {
            encryptInfo.getClass();
            this.encrypt_ = encryptInfo;
            this.bitField0_ |= 1;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TwoDConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t\u0000", new Object[]{"bitField0_", "encrypt_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TwoDConfig> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TwoDConfig.class) {
                            bgVar = PARSER;
                            if (bgVar == null) {
                                bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bgVar;
                            }
                        }
                    }
                    return bgVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDConfigOrBuilder
        public EncryptInfo getEncrypt() {
            EncryptInfo encryptInfo = this.encrypt_;
            if (encryptInfo == null) {
                return EncryptInfo.getDefaultInstance();
            }
            return encryptInfo;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDConfigOrBuilder
        public boolean hasEncrypt() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TwoDConfig twoDConfig) {
            return DEFAULT_INSTANCE.createBuilder(twoDConfig);
        }

        public static TwoDConfig parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TwoDConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TwoDConfig parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TwoDConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TwoDConfig parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncrypt(EncryptInfo.Builder builder) {
            this.encrypt_ = builder.build();
            this.bitField0_ |= 1;
        }

        public static TwoDConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TwoDConfig parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TwoDConfig parseFrom(InputStream inputStream) throws IOException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TwoDConfig parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TwoDConfig parseFrom(k kVar) throws IOException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TwoDConfig parseFrom(k kVar, t tVar) throws IOException {
            return (TwoDConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TwoDConfigOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        EncryptInfo getEncrypt();

        boolean hasEncrypt();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TwoDVideoData extends GeneratedMessageLite<TwoDVideoData, Builder> implements TwoDVideoDataOrBuilder {
        private static final TwoDVideoData DEFAULT_INSTANCE;
        public static final int ENCRYPT_FIELD_NUMBER = 2;
        private static volatile bg<TwoDVideoData> PARSER = null;
        public static final int VS_FIELD_NUMBER = 1;
        private int bitField0_;
        private EncryptInfo encrypt_;
        private ad.j<FaceVideo> vs_ = GeneratedMessageLite.emptyProtobufList();

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TwoDVideoData, Builder> implements TwoDVideoDataOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllVs(Iterable<? extends FaceVideo> iterable) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).addAllVs(iterable);
                return this;
            }

            public Builder addVs(FaceVideo faceVideo) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).addVs(faceVideo);
                return this;
            }

            public Builder clearEncrypt() {
                copyOnWrite();
                ((TwoDVideoData) this.instance).clearEncrypt();
                return this;
            }

            public Builder clearVs() {
                copyOnWrite();
                ((TwoDVideoData) this.instance).clearVs();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
            public EncryptInfo getEncrypt() {
                return ((TwoDVideoData) this.instance).getEncrypt();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
            public FaceVideo getVs(int i3) {
                return ((TwoDVideoData) this.instance).getVs(i3);
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
            public int getVsCount() {
                return ((TwoDVideoData) this.instance).getVsCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
            public List<FaceVideo> getVsList() {
                return Collections.unmodifiableList(((TwoDVideoData) this.instance).getVsList());
            }

            @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
            public boolean hasEncrypt() {
                return ((TwoDVideoData) this.instance).hasEncrypt();
            }

            public Builder mergeEncrypt(EncryptInfo encryptInfo) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).mergeEncrypt(encryptInfo);
                return this;
            }

            public Builder removeVs(int i3) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).removeVs(i3);
                return this;
            }

            public Builder setEncrypt(EncryptInfo encryptInfo) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).setEncrypt(encryptInfo);
                return this;
            }

            public Builder setVs(int i3, FaceVideo faceVideo) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).setVs(i3, faceVideo);
                return this;
            }

            Builder() {
                super(TwoDVideoData.DEFAULT_INSTANCE);
            }

            public Builder addVs(int i3, FaceVideo faceVideo) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).addVs(i3, faceVideo);
                return this;
            }

            public Builder setEncrypt(EncryptInfo.Builder builder) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).setEncrypt(builder);
                return this;
            }

            public Builder setVs(int i3, FaceVideo.Builder builder) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).setVs(i3, builder);
                return this;
            }

            public Builder addVs(FaceVideo.Builder builder) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).addVs(builder);
                return this;
            }

            public Builder addVs(int i3, FaceVideo.Builder builder) {
                copyOnWrite();
                ((TwoDVideoData) this.instance).addVs(i3, builder);
                return this;
            }
        }

        static {
            TwoDVideoData twoDVideoData = new TwoDVideoData();
            DEFAULT_INSTANCE = twoDVideoData;
            GeneratedMessageLite.registerDefaultInstance(TwoDVideoData.class, twoDVideoData);
        }

        TwoDVideoData() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllVs(Iterable<? extends FaceVideo> iterable) {
            ensureVsIsMutable();
            b.addAll((Iterable) iterable, (List) this.vs_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addVs(FaceVideo faceVideo) {
            faceVideo.getClass();
            ensureVsIsMutable();
            this.vs_.add(faceVideo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEncrypt() {
            this.encrypt_ = null;
            this.bitField0_ &= -2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVs() {
            this.vs_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureVsIsMutable() {
            if (!this.vs_.z()) {
                this.vs_ = GeneratedMessageLite.mutableCopy(this.vs_);
            }
        }

        public static TwoDVideoData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeEncrypt(EncryptInfo encryptInfo) {
            encryptInfo.getClass();
            EncryptInfo encryptInfo2 = this.encrypt_;
            if (encryptInfo2 != null && encryptInfo2 != EncryptInfo.getDefaultInstance()) {
                this.encrypt_ = EncryptInfo.newBuilder(this.encrypt_).mergeFrom((EncryptInfo.Builder) encryptInfo).buildPartial();
            } else {
                this.encrypt_ = encryptInfo;
            }
            this.bitField0_ |= 1;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TwoDVideoData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TwoDVideoData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TwoDVideoData parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TwoDVideoData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeVs(int i3) {
            ensureVsIsMutable();
            this.vs_.remove(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncrypt(EncryptInfo encryptInfo) {
            encryptInfo.getClass();
            this.encrypt_ = encryptInfo;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVs(int i3, FaceVideo faceVideo) {
            faceVideo.getClass();
            ensureVsIsMutable();
            this.vs_.set(i3, faceVideo);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TwoDVideoData();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\t\u0000", new Object[]{"bitField0_", "vs_", FaceVideo.class, "encrypt_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TwoDVideoData> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TwoDVideoData.class) {
                            bgVar = PARSER;
                            if (bgVar == null) {
                                bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bgVar;
                            }
                        }
                    }
                    return bgVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
        public EncryptInfo getEncrypt() {
            EncryptInfo encryptInfo = this.encrypt_;
            if (encryptInfo == null) {
                return EncryptInfo.getDefaultInstance();
            }
            return encryptInfo;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
        public FaceVideo getVs(int i3) {
            return this.vs_.get(i3);
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
        public int getVsCount() {
            return this.vs_.size();
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
        public List<FaceVideo> getVsList() {
            return this.vs_;
        }

        public FaceVideoOrBuilder getVsOrBuilder(int i3) {
            return this.vs_.get(i3);
        }

        public List<? extends FaceVideoOrBuilder> getVsOrBuilderList() {
            return this.vs_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiCommProto.TwoDVideoDataOrBuilder
        public boolean hasEncrypt() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TwoDVideoData twoDVideoData) {
            return DEFAULT_INSTANCE.createBuilder(twoDVideoData);
        }

        public static TwoDVideoData parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TwoDVideoData) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TwoDVideoData parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TwoDVideoData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addVs(int i3, FaceVideo faceVideo) {
            faceVideo.getClass();
            ensureVsIsMutable();
            this.vs_.add(i3, faceVideo);
        }

        public static TwoDVideoData parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEncrypt(EncryptInfo.Builder builder) {
            this.encrypt_ = builder.build();
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVs(int i3, FaceVideo.Builder builder) {
            ensureVsIsMutable();
            this.vs_.set(i3, builder.build());
        }

        public static TwoDVideoData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TwoDVideoData parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addVs(FaceVideo.Builder builder) {
            ensureVsIsMutable();
            this.vs_.add(builder.build());
        }

        public static TwoDVideoData parseFrom(InputStream inputStream) throws IOException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TwoDVideoData parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addVs(int i3, FaceVideo.Builder builder) {
            ensureVsIsMutable();
            this.vs_.add(i3, builder.build());
        }

        public static TwoDVideoData parseFrom(k kVar) throws IOException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TwoDVideoData parseFrom(k kVar, t tVar) throws IOException {
            return (TwoDVideoData) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TwoDVideoDataOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        EncryptInfo getEncrypt();

        FaceVideo getVs(int i3);

        int getVsCount();

        List<FaceVideo> getVsList();

        boolean hasEncrypt();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    TdiApiCommProto() {
    }

    public static void registerAllExtensions(t tVar) {
    }
}
