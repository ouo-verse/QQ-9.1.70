package com.tencent.ilink.dev.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ad;
import com.google.protobuf.au;
import com.google.protobuf.av;
import com.google.protobuf.bg;
import com.google.protobuf.k;
import com.google.protobuf.t;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class OtaApi {

    /* compiled from: P */
    /* renamed from: com.tencent.ilink.dev.proto.OtaApi$1, reason: invalid class name */
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

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class CheckUpdateResultInfo extends GeneratedMessageLite<CheckUpdateResultInfo, Builder> implements CheckUpdateResultInfoOrBuilder {
        public static final int BUSSINESS_ID_FIELD_NUMBER = 1;
        private static final CheckUpdateResultInfo DEFAULT_INSTANCE;
        public static final int ERRCODE_FIELD_NUMBER = 2;
        public static final int ERRMSG_FIELD_NUMBER = 3;
        public static final int HAVE_NEW_VERSION_FIELD_NUMBER = 4;
        public static final int PACKAGEINFO_FIELD_NUMBER = 6;
        private static volatile bg<CheckUpdateResultInfo> PARSER = null;
        public static final int UPDATAINFO_FIELD_NUMBER = 5;
        private int bitField0_;
        private int errcode_;
        private boolean haveNewVersion_;
        private String bussinessId_ = "";
        private String errmsg_ = "";
        private String updataInfo_ = "";
        private String packageInfo_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<CheckUpdateResultInfo, Builder> implements CheckUpdateResultInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBussinessId() {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).clearBussinessId();
                return this;
            }

            public Builder clearErrcode() {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).clearErrcode();
                return this;
            }

            public Builder clearErrmsg() {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).clearErrmsg();
                return this;
            }

            public Builder clearHaveNewVersion() {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).clearHaveNewVersion();
                return this;
            }

            public Builder clearPackageInfo() {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).clearPackageInfo();
                return this;
            }

            public Builder clearUpdataInfo() {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).clearUpdataInfo();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public String getBussinessId() {
                return ((CheckUpdateResultInfo) this.instance).getBussinessId();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public ByteString getBussinessIdBytes() {
                return ((CheckUpdateResultInfo) this.instance).getBussinessIdBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public int getErrcode() {
                return ((CheckUpdateResultInfo) this.instance).getErrcode();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public String getErrmsg() {
                return ((CheckUpdateResultInfo) this.instance).getErrmsg();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public ByteString getErrmsgBytes() {
                return ((CheckUpdateResultInfo) this.instance).getErrmsgBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public boolean getHaveNewVersion() {
                return ((CheckUpdateResultInfo) this.instance).getHaveNewVersion();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public String getPackageInfo() {
                return ((CheckUpdateResultInfo) this.instance).getPackageInfo();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public ByteString getPackageInfoBytes() {
                return ((CheckUpdateResultInfo) this.instance).getPackageInfoBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public String getUpdataInfo() {
                return ((CheckUpdateResultInfo) this.instance).getUpdataInfo();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public ByteString getUpdataInfoBytes() {
                return ((CheckUpdateResultInfo) this.instance).getUpdataInfoBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public boolean hasBussinessId() {
                return ((CheckUpdateResultInfo) this.instance).hasBussinessId();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public boolean hasErrcode() {
                return ((CheckUpdateResultInfo) this.instance).hasErrcode();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public boolean hasErrmsg() {
                return ((CheckUpdateResultInfo) this.instance).hasErrmsg();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public boolean hasHaveNewVersion() {
                return ((CheckUpdateResultInfo) this.instance).hasHaveNewVersion();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public boolean hasPackageInfo() {
                return ((CheckUpdateResultInfo) this.instance).hasPackageInfo();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
            public boolean hasUpdataInfo() {
                return ((CheckUpdateResultInfo) this.instance).hasUpdataInfo();
            }

            public Builder setBussinessId(String str) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setBussinessId(str);
                return this;
            }

            public Builder setBussinessIdBytes(ByteString byteString) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setBussinessIdBytes(byteString);
                return this;
            }

            public Builder setErrcode(int i3) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setErrcode(i3);
                return this;
            }

            public Builder setErrmsg(String str) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setErrmsg(str);
                return this;
            }

            public Builder setErrmsgBytes(ByteString byteString) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setErrmsgBytes(byteString);
                return this;
            }

            public Builder setHaveNewVersion(boolean z16) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setHaveNewVersion(z16);
                return this;
            }

            public Builder setPackageInfo(String str) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setPackageInfo(str);
                return this;
            }

            public Builder setPackageInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setPackageInfoBytes(byteString);
                return this;
            }

            public Builder setUpdataInfo(String str) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setUpdataInfo(str);
                return this;
            }

            public Builder setUpdataInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((CheckUpdateResultInfo) this.instance).setUpdataInfoBytes(byteString);
                return this;
            }

            Builder() {
                super(CheckUpdateResultInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            CheckUpdateResultInfo checkUpdateResultInfo = new CheckUpdateResultInfo();
            DEFAULT_INSTANCE = checkUpdateResultInfo;
            GeneratedMessageLite.registerDefaultInstance(CheckUpdateResultInfo.class, checkUpdateResultInfo);
        }

        CheckUpdateResultInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBussinessId() {
            this.bitField0_ &= -2;
            this.bussinessId_ = getDefaultInstance().getBussinessId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrcode() {
            this.bitField0_ &= -3;
            this.errcode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrmsg() {
            this.bitField0_ &= -5;
            this.errmsg_ = getDefaultInstance().getErrmsg();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHaveNewVersion() {
            this.bitField0_ &= -9;
            this.haveNewVersion_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackageInfo() {
            this.bitField0_ &= -33;
            this.packageInfo_ = getDefaultInstance().getPackageInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdataInfo() {
            this.bitField0_ &= -17;
            this.updataInfo_ = getDefaultInstance().getUpdataInfo();
        }

        public static CheckUpdateResultInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static CheckUpdateResultInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CheckUpdateResultInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<CheckUpdateResultInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBussinessId(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.bussinessId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBussinessIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.bussinessId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrcode(int i3) {
            this.bitField0_ |= 2;
            this.errcode_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrmsg(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.errmsg_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrmsgBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.errmsg_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHaveNewVersion(boolean z16) {
            this.bitField0_ |= 8;
            this.haveNewVersion_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageInfo(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.packageInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageInfoBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.packageInfo_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdataInfo(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.updataInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdataInfoBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.updataInfo_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CheckUpdateResultInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005", new Object[]{"bitField0_", "bussinessId_", "errcode_", "errmsg_", "haveNewVersion_", "updataInfo_", "packageInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<CheckUpdateResultInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (CheckUpdateResultInfo.class) {
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

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public String getBussinessId() {
            return this.bussinessId_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public ByteString getBussinessIdBytes() {
            return ByteString.copyFromUtf8(this.bussinessId_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public int getErrcode() {
            return this.errcode_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public String getErrmsg() {
            return this.errmsg_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public ByteString getErrmsgBytes() {
            return ByteString.copyFromUtf8(this.errmsg_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public boolean getHaveNewVersion() {
            return this.haveNewVersion_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public String getPackageInfo() {
            return this.packageInfo_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public ByteString getPackageInfoBytes() {
            return ByteString.copyFromUtf8(this.packageInfo_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public String getUpdataInfo() {
            return this.updataInfo_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public ByteString getUpdataInfoBytes() {
            return ByteString.copyFromUtf8(this.updataInfo_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public boolean hasBussinessId() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public boolean hasErrcode() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public boolean hasErrmsg() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public boolean hasHaveNewVersion() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public boolean hasPackageInfo() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.CheckUpdateResultInfoOrBuilder
        public boolean hasUpdataInfo() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(CheckUpdateResultInfo checkUpdateResultInfo) {
            return DEFAULT_INSTANCE.createBuilder(checkUpdateResultInfo);
        }

        public static CheckUpdateResultInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static CheckUpdateResultInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static CheckUpdateResultInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CheckUpdateResultInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static CheckUpdateResultInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CheckUpdateResultInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static CheckUpdateResultInfo parseFrom(InputStream inputStream) throws IOException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CheckUpdateResultInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static CheckUpdateResultInfo parseFrom(k kVar) throws IOException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static CheckUpdateResultInfo parseFrom(k kVar, t tVar) throws IOException {
            return (CheckUpdateResultInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface CheckUpdateResultInfoOrBuilder extends av {
        String getBussinessId();

        ByteString getBussinessIdBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getErrcode();

        String getErrmsg();

        ByteString getErrmsgBytes();

        boolean getHaveNewVersion();

        String getPackageInfo();

        ByteString getPackageInfoBytes();

        String getUpdataInfo();

        ByteString getUpdataInfoBytes();

        boolean hasBussinessId();

        boolean hasErrcode();

        boolean hasErrmsg();

        boolean hasHaveNewVersion();

        boolean hasPackageInfo();

        boolean hasUpdataInfo();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum HashType implements ad.c {
        MD5(1),
        SHA1(2),
        SHA256(3);

        public static final int MD5_VALUE = 1;
        public static final int SHA1_VALUE = 2;
        public static final int SHA256_VALUE = 3;
        private static final ad.d<HashType> internalValueMap = new ad.d<HashType>() { // from class: com.tencent.ilink.dev.proto.OtaApi.HashType.1
            @Override // com.google.protobuf.ad.d
            public HashType findValueByNumber(int i3) {
                return HashType.forNumber(i3);
            }
        };
        private final int value;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class HashTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new HashTypeVerifier();

            HashTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (HashType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        HashType(int i3) {
            this.value = i3;
        }

        public static HashType forNumber(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return null;
                    }
                    return SHA256;
                }
                return SHA1;
            }
            return MD5;
        }

        public static ad.d<HashType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return HashTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static HashType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class PackageInfo extends GeneratedMessageLite<PackageInfo, Builder> implements PackageInfoOrBuilder {
        private static final PackageInfo DEFAULT_INSTANCE;
        public static final int PACKAGE_HASH_FIELD_NUMBER = 3;
        public static final int PACKAGE_HASH_TYPE_FIELD_NUMBER = 2;
        public static final int PACKAGE_SIZE_FIELD_NUMBER = 4;
        public static final int PACKAGE_URL_FIELD_NUMBER = 1;
        private static volatile bg<PackageInfo> PARSER;
        private int bitField0_;
        private long packageSize_;
        private String packageUrl_ = "";
        private int packageHashType_ = 1;
        private String packageHash_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<PackageInfo, Builder> implements PackageInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearPackageHash() {
                copyOnWrite();
                ((PackageInfo) this.instance).clearPackageHash();
                return this;
            }

            public Builder clearPackageHashType() {
                copyOnWrite();
                ((PackageInfo) this.instance).clearPackageHashType();
                return this;
            }

            public Builder clearPackageSize() {
                copyOnWrite();
                ((PackageInfo) this.instance).clearPackageSize();
                return this;
            }

            public Builder clearPackageUrl() {
                copyOnWrite();
                ((PackageInfo) this.instance).clearPackageUrl();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public String getPackageHash() {
                return ((PackageInfo) this.instance).getPackageHash();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public ByteString getPackageHashBytes() {
                return ((PackageInfo) this.instance).getPackageHashBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public HashType getPackageHashType() {
                return ((PackageInfo) this.instance).getPackageHashType();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public long getPackageSize() {
                return ((PackageInfo) this.instance).getPackageSize();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public String getPackageUrl() {
                return ((PackageInfo) this.instance).getPackageUrl();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public ByteString getPackageUrlBytes() {
                return ((PackageInfo) this.instance).getPackageUrlBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public boolean hasPackageHash() {
                return ((PackageInfo) this.instance).hasPackageHash();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public boolean hasPackageHashType() {
                return ((PackageInfo) this.instance).hasPackageHashType();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public boolean hasPackageSize() {
                return ((PackageInfo) this.instance).hasPackageSize();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
            public boolean hasPackageUrl() {
                return ((PackageInfo) this.instance).hasPackageUrl();
            }

            public Builder setPackageHash(String str) {
                copyOnWrite();
                ((PackageInfo) this.instance).setPackageHash(str);
                return this;
            }

            public Builder setPackageHashBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageInfo) this.instance).setPackageHashBytes(byteString);
                return this;
            }

            public Builder setPackageHashType(HashType hashType) {
                copyOnWrite();
                ((PackageInfo) this.instance).setPackageHashType(hashType);
                return this;
            }

            public Builder setPackageSize(long j3) {
                copyOnWrite();
                ((PackageInfo) this.instance).setPackageSize(j3);
                return this;
            }

            public Builder setPackageUrl(String str) {
                copyOnWrite();
                ((PackageInfo) this.instance).setPackageUrl(str);
                return this;
            }

            public Builder setPackageUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((PackageInfo) this.instance).setPackageUrlBytes(byteString);
                return this;
            }

            Builder() {
                super(PackageInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            PackageInfo packageInfo = new PackageInfo();
            DEFAULT_INSTANCE = packageInfo;
            GeneratedMessageLite.registerDefaultInstance(PackageInfo.class, packageInfo);
        }

        PackageInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackageHash() {
            this.bitField0_ &= -5;
            this.packageHash_ = getDefaultInstance().getPackageHash();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackageHashType() {
            this.bitField0_ &= -3;
            this.packageHashType_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackageSize() {
            this.bitField0_ &= -9;
            this.packageSize_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPackageUrl() {
            this.bitField0_ &= -2;
            this.packageUrl_ = getDefaultInstance().getPackageUrl();
        }

        public static PackageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static PackageInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (PackageInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PackageInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<PackageInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageHash(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.packageHash_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageHashBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.packageHash_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageHashType(HashType hashType) {
            hashType.getClass();
            this.bitField0_ |= 2;
            this.packageHashType_ = hashType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageSize(long j3) {
            this.bitField0_ |= 8;
            this.packageSize_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageUrl(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.packageUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPackageUrlBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.packageUrl_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new PackageInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\b\u0002\u0004\u0003\u0003", new Object[]{"bitField0_", "packageUrl_", "packageHashType_", HashType.internalGetVerifier(), "packageHash_", "packageSize_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<PackageInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (PackageInfo.class) {
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

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public String getPackageHash() {
            return this.packageHash_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public ByteString getPackageHashBytes() {
            return ByteString.copyFromUtf8(this.packageHash_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public HashType getPackageHashType() {
            HashType forNumber = HashType.forNumber(this.packageHashType_);
            if (forNumber == null) {
                return HashType.MD5;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public long getPackageSize() {
            return this.packageSize_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public String getPackageUrl() {
            return this.packageUrl_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public ByteString getPackageUrlBytes() {
            return ByteString.copyFromUtf8(this.packageUrl_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public boolean hasPackageHash() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public boolean hasPackageHashType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public boolean hasPackageSize() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.PackageInfoOrBuilder
        public boolean hasPackageUrl() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(PackageInfo packageInfo) {
            return DEFAULT_INSTANCE.createBuilder(packageInfo);
        }

        public static PackageInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (PackageInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static PackageInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static PackageInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PackageInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static PackageInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PackageInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static PackageInfo parseFrom(InputStream inputStream) throws IOException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PackageInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static PackageInfo parseFrom(k kVar) throws IOException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static PackageInfo parseFrom(k kVar, t tVar) throws IOException {
            return (PackageInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface PackageInfoOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getPackageHash();

        ByteString getPackageHashBytes();

        HashType getPackageHashType();

        long getPackageSize();

        String getPackageUrl();

        ByteString getPackageUrlBytes();

        boolean hasPackageHash();

        boolean hasPackageHashType();

        boolean hasPackageSize();

        boolean hasPackageUrl();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class UpdateInfo extends GeneratedMessageLite<UpdateInfo, Builder> implements UpdateInfoOrBuilder {
        private static final UpdateInfo DEFAULT_INSTANCE;
        public static final int DEV_VERSION_FIELD_NUMBER = 5;
        public static final int EXTRA_INFO_FIELD_NUMBER = 9;
        private static volatile bg<UpdateInfo> PARSER = null;
        public static final int REMARK_FIELD_NUMBER = 7;
        public static final int UPDATE_LEVEL_FIELD_NUMBER = 4;
        public static final int UPDATE_TIME_FIELD_NUMBER = 1;
        public static final int UPDATE_TIPS_FIELD_NUMBER = 6;
        public static final int UPDATE_TYPE_FIELD_NUMBER = 2;
        public static final int VERSION_FIELD_NUMBER = 3;
        public static final int VERSION_NAME_FIELD_NUMBER = 8;
        private int bitField0_;
        private int devVersion_;
        private int updateLevel_;
        private long updateTime_;
        private int updateType_;
        private long version_;
        private String updateTips_ = "";
        private String remark_ = "";
        private String versionName_ = "";
        private String extraInfo_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<UpdateInfo, Builder> implements UpdateInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDevVersion() {
                copyOnWrite();
                ((UpdateInfo) this.instance).clearDevVersion();
                return this;
            }

            public Builder clearExtraInfo() {
                copyOnWrite();
                ((UpdateInfo) this.instance).clearExtraInfo();
                return this;
            }

            public Builder clearRemark() {
                copyOnWrite();
                ((UpdateInfo) this.instance).clearRemark();
                return this;
            }

            public Builder clearUpdateLevel() {
                copyOnWrite();
                ((UpdateInfo) this.instance).clearUpdateLevel();
                return this;
            }

            public Builder clearUpdateTime() {
                copyOnWrite();
                ((UpdateInfo) this.instance).clearUpdateTime();
                return this;
            }

            public Builder clearUpdateTips() {
                copyOnWrite();
                ((UpdateInfo) this.instance).clearUpdateTips();
                return this;
            }

            public Builder clearUpdateType() {
                copyOnWrite();
                ((UpdateInfo) this.instance).clearUpdateType();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((UpdateInfo) this.instance).clearVersion();
                return this;
            }

            public Builder clearVersionName() {
                copyOnWrite();
                ((UpdateInfo) this.instance).clearVersionName();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public int getDevVersion() {
                return ((UpdateInfo) this.instance).getDevVersion();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public String getExtraInfo() {
                return ((UpdateInfo) this.instance).getExtraInfo();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public ByteString getExtraInfoBytes() {
                return ((UpdateInfo) this.instance).getExtraInfoBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public String getRemark() {
                return ((UpdateInfo) this.instance).getRemark();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public ByteString getRemarkBytes() {
                return ((UpdateInfo) this.instance).getRemarkBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public int getUpdateLevel() {
                return ((UpdateInfo) this.instance).getUpdateLevel();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public long getUpdateTime() {
                return ((UpdateInfo) this.instance).getUpdateTime();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public String getUpdateTips() {
                return ((UpdateInfo) this.instance).getUpdateTips();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public ByteString getUpdateTipsBytes() {
                return ((UpdateInfo) this.instance).getUpdateTipsBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public UpdateType getUpdateType() {
                return ((UpdateInfo) this.instance).getUpdateType();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public long getVersion() {
                return ((UpdateInfo) this.instance).getVersion();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public String getVersionName() {
                return ((UpdateInfo) this.instance).getVersionName();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public ByteString getVersionNameBytes() {
                return ((UpdateInfo) this.instance).getVersionNameBytes();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public boolean hasDevVersion() {
                return ((UpdateInfo) this.instance).hasDevVersion();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public boolean hasExtraInfo() {
                return ((UpdateInfo) this.instance).hasExtraInfo();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public boolean hasRemark() {
                return ((UpdateInfo) this.instance).hasRemark();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public boolean hasUpdateLevel() {
                return ((UpdateInfo) this.instance).hasUpdateLevel();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public boolean hasUpdateTime() {
                return ((UpdateInfo) this.instance).hasUpdateTime();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public boolean hasUpdateTips() {
                return ((UpdateInfo) this.instance).hasUpdateTips();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public boolean hasUpdateType() {
                return ((UpdateInfo) this.instance).hasUpdateType();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public boolean hasVersion() {
                return ((UpdateInfo) this.instance).hasVersion();
            }

            @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
            public boolean hasVersionName() {
                return ((UpdateInfo) this.instance).hasVersionName();
            }

            public Builder setDevVersion(int i3) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setDevVersion(i3);
                return this;
            }

            public Builder setExtraInfo(String str) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setExtraInfo(str);
                return this;
            }

            public Builder setExtraInfoBytes(ByteString byteString) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setExtraInfoBytes(byteString);
                return this;
            }

            public Builder setRemark(String str) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setRemark(str);
                return this;
            }

            public Builder setRemarkBytes(ByteString byteString) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setRemarkBytes(byteString);
                return this;
            }

            public Builder setUpdateLevel(int i3) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setUpdateLevel(i3);
                return this;
            }

            public Builder setUpdateTime(long j3) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setUpdateTime(j3);
                return this;
            }

            public Builder setUpdateTips(String str) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setUpdateTips(str);
                return this;
            }

            public Builder setUpdateTipsBytes(ByteString byteString) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setUpdateTipsBytes(byteString);
                return this;
            }

            public Builder setUpdateType(UpdateType updateType) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setUpdateType(updateType);
                return this;
            }

            public Builder setVersion(long j3) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setVersion(j3);
                return this;
            }

            public Builder setVersionName(String str) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setVersionName(str);
                return this;
            }

            public Builder setVersionNameBytes(ByteString byteString) {
                copyOnWrite();
                ((UpdateInfo) this.instance).setVersionNameBytes(byteString);
                return this;
            }

            Builder() {
                super(UpdateInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            UpdateInfo updateInfo = new UpdateInfo();
            DEFAULT_INSTANCE = updateInfo;
            GeneratedMessageLite.registerDefaultInstance(UpdateInfo.class, updateInfo);
        }

        UpdateInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDevVersion() {
            this.bitField0_ &= -17;
            this.devVersion_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtraInfo() {
            this.bitField0_ &= -257;
            this.extraInfo_ = getDefaultInstance().getExtraInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRemark() {
            this.bitField0_ &= -65;
            this.remark_ = getDefaultInstance().getRemark();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateLevel() {
            this.bitField0_ &= -9;
            this.updateLevel_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateTime() {
            this.bitField0_ &= -2;
            this.updateTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateTips() {
            this.bitField0_ &= -33;
            this.updateTips_ = getDefaultInstance().getUpdateTips();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateType() {
            this.bitField0_ &= -3;
            this.updateType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -5;
            this.version_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersionName() {
            this.bitField0_ &= -129;
            this.versionName_ = getDefaultInstance().getVersionName();
        }

        public static UpdateInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static UpdateInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UpdateInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UpdateInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<UpdateInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDevVersion(int i3) {
            this.bitField0_ |= 16;
            this.devVersion_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtraInfo(String str) {
            str.getClass();
            this.bitField0_ |= 256;
            this.extraInfo_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtraInfoBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 256;
            this.extraInfo_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemark(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.remark_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRemarkBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.remark_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateLevel(int i3) {
            this.bitField0_ |= 8;
            this.updateLevel_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateTime(long j3) {
            this.bitField0_ |= 1;
            this.updateTime_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateTips(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.updateTips_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateTipsBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.updateTips_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateType(UpdateType updateType) {
            updateType.getClass();
            this.bitField0_ |= 2;
            this.updateType_ = updateType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(long j3) {
            this.bitField0_ |= 4;
            this.version_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionName(String str) {
            str.getClass();
            this.bitField0_ |= 128;
            this.versionName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionNameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 128;
            this.versionName_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new UpdateInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001\u0003\u0000\u0002\f\u0001\u0003\u0003\u0002\u0004\u000b\u0003\u0005\u000b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b", new Object[]{"bitField0_", "updateTime_", "updateType_", UpdateType.internalGetVerifier(), "version_", "updateLevel_", "devVersion_", "updateTips_", "remark_", "versionName_", "extraInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<UpdateInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (UpdateInfo.class) {
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

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public int getDevVersion() {
            return this.devVersion_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public String getExtraInfo() {
            return this.extraInfo_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public ByteString getExtraInfoBytes() {
            return ByteString.copyFromUtf8(this.extraInfo_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public String getRemark() {
            return this.remark_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public ByteString getRemarkBytes() {
            return ByteString.copyFromUtf8(this.remark_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public int getUpdateLevel() {
            return this.updateLevel_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public long getUpdateTime() {
            return this.updateTime_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public String getUpdateTips() {
            return this.updateTips_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public ByteString getUpdateTipsBytes() {
            return ByteString.copyFromUtf8(this.updateTips_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public UpdateType getUpdateType() {
            UpdateType forNumber = UpdateType.forNumber(this.updateType_);
            if (forNumber == null) {
                return UpdateType.unknow;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public long getVersion() {
            return this.version_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public String getVersionName() {
            return this.versionName_;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public ByteString getVersionNameBytes() {
            return ByteString.copyFromUtf8(this.versionName_);
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public boolean hasDevVersion() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public boolean hasExtraInfo() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public boolean hasRemark() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public boolean hasUpdateLevel() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public boolean hasUpdateTime() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public boolean hasUpdateTips() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public boolean hasUpdateType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public boolean hasVersion() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.OtaApi.UpdateInfoOrBuilder
        public boolean hasVersionName() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(UpdateInfo updateInfo) {
            return DEFAULT_INSTANCE.createBuilder(updateInfo);
        }

        public static UpdateInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (UpdateInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static UpdateInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static UpdateInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UpdateInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static UpdateInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UpdateInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static UpdateInfo parseFrom(InputStream inputStream) throws IOException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UpdateInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static UpdateInfo parseFrom(k kVar) throws IOException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static UpdateInfo parseFrom(k kVar, t tVar) throws IOException {
            return (UpdateInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface UpdateInfoOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getDevVersion();

        String getExtraInfo();

        ByteString getExtraInfoBytes();

        String getRemark();

        ByteString getRemarkBytes();

        int getUpdateLevel();

        long getUpdateTime();

        String getUpdateTips();

        ByteString getUpdateTipsBytes();

        UpdateType getUpdateType();

        long getVersion();

        String getVersionName();

        ByteString getVersionNameBytes();

        boolean hasDevVersion();

        boolean hasExtraInfo();

        boolean hasRemark();

        boolean hasUpdateLevel();

        boolean hasUpdateTime();

        boolean hasUpdateTips();

        boolean hasUpdateType();

        boolean hasVersion();

        boolean hasVersionName();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum UpdateType implements ad.c {
        unknow(0),
        software(1),
        firmware(2),
        hardware(3);

        public static final int firmware_VALUE = 2;
        public static final int hardware_VALUE = 3;
        private static final ad.d<UpdateType> internalValueMap = new ad.d<UpdateType>() { // from class: com.tencent.ilink.dev.proto.OtaApi.UpdateType.1
            @Override // com.google.protobuf.ad.d
            public UpdateType findValueByNumber(int i3) {
                return UpdateType.forNumber(i3);
            }
        };
        public static final int software_VALUE = 1;
        public static final int unknow_VALUE = 0;
        private final int value;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class UpdateTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new UpdateTypeVerifier();

            UpdateTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (UpdateType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        UpdateType(int i3) {
            this.value = i3;
        }

        public static UpdateType forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return null;
                        }
                        return hardware;
                    }
                    return firmware;
                }
                return software;
            }
            return unknow;
        }

        public static ad.d<UpdateType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return UpdateTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static UpdateType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    OtaApi() {
    }

    public static void registerAllExtensions(t tVar) {
    }
}
