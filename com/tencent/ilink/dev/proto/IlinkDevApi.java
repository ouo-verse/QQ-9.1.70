package com.tencent.ilink.dev.proto;

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
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class IlinkDevApi {

    /* compiled from: P */
    /* renamed from: com.tencent.ilink.dev.proto.IlinkDevApi$1, reason: invalid class name */
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
    public static final class IlinkDevApiSendMsgParams extends GeneratedMessageLite<IlinkDevApiSendMsgParams, Builder> implements IlinkDevApiSendMsgParamsOrBuilder {
        public static final int APPID_FIELD_NUMBER = 5;
        public static final int CLIMSGID_FIELD_NUMBER = 1;
        public static final int CONTENT_FIELD_NUMBER = 3;
        private static final IlinkDevApiSendMsgParams DEFAULT_INSTANCE;
        private static volatile bg<IlinkDevApiSendMsgParams> PARSER = null;
        public static final int TOILINKID_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 4;
        private int bitField0_;
        private String cliMsgid_ = "";
        private String toIlinkId_ = "";
        private String content_ = "";
        private String type_ = "";
        private String appid_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDevApiSendMsgParams, Builder> implements IlinkDevApiSendMsgParamsOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).clearAppid();
                return this;
            }

            public Builder clearCliMsgid() {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).clearCliMsgid();
                return this;
            }

            public Builder clearContent() {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).clearContent();
                return this;
            }

            public Builder clearToIlinkId() {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).clearToIlinkId();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).clearType();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public String getAppid() {
                return ((IlinkDevApiSendMsgParams) this.instance).getAppid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public ByteString getAppidBytes() {
                return ((IlinkDevApiSendMsgParams) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public String getCliMsgid() {
                return ((IlinkDevApiSendMsgParams) this.instance).getCliMsgid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public ByteString getCliMsgidBytes() {
                return ((IlinkDevApiSendMsgParams) this.instance).getCliMsgidBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public String getContent() {
                return ((IlinkDevApiSendMsgParams) this.instance).getContent();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public ByteString getContentBytes() {
                return ((IlinkDevApiSendMsgParams) this.instance).getContentBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public String getToIlinkId() {
                return ((IlinkDevApiSendMsgParams) this.instance).getToIlinkId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public ByteString getToIlinkIdBytes() {
                return ((IlinkDevApiSendMsgParams) this.instance).getToIlinkIdBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public String getType() {
                return ((IlinkDevApiSendMsgParams) this.instance).getType();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public ByteString getTypeBytes() {
                return ((IlinkDevApiSendMsgParams) this.instance).getTypeBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public boolean hasAppid() {
                return ((IlinkDevApiSendMsgParams) this.instance).hasAppid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public boolean hasCliMsgid() {
                return ((IlinkDevApiSendMsgParams) this.instance).hasCliMsgid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public boolean hasContent() {
                return ((IlinkDevApiSendMsgParams) this.instance).hasContent();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public boolean hasToIlinkId() {
                return ((IlinkDevApiSendMsgParams) this.instance).hasToIlinkId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
            public boolean hasType() {
                return ((IlinkDevApiSendMsgParams) this.instance).hasType();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setCliMsgid(String str) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setCliMsgid(str);
                return this;
            }

            public Builder setCliMsgidBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setCliMsgidBytes(byteString);
                return this;
            }

            public Builder setContent(String str) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setContent(str);
                return this;
            }

            public Builder setContentBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setContentBytes(byteString);
                return this;
            }

            public Builder setToIlinkId(String str) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setToIlinkId(str);
                return this;
            }

            public Builder setToIlinkIdBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setToIlinkIdBytes(byteString);
                return this;
            }

            public Builder setType(String str) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setType(str);
                return this;
            }

            public Builder setTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevApiSendMsgParams) this.instance).setTypeBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkDevApiSendMsgParams.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDevApiSendMsgParams ilinkDevApiSendMsgParams = new IlinkDevApiSendMsgParams();
            DEFAULT_INSTANCE = ilinkDevApiSendMsgParams;
            GeneratedMessageLite.registerDefaultInstance(IlinkDevApiSendMsgParams.class, ilinkDevApiSendMsgParams);
        }

        IlinkDevApiSendMsgParams() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -17;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCliMsgid() {
            this.bitField0_ &= -2;
            this.cliMsgid_ = getDefaultInstance().getCliMsgid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.bitField0_ &= -5;
            this.content_ = getDefaultInstance().getContent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToIlinkId() {
            this.bitField0_ &= -3;
            this.toIlinkId_ = getDefaultInstance().getToIlinkId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -9;
            this.type_ = getDefaultInstance().getType();
        }

        public static IlinkDevApiSendMsgParams getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDevApiSendMsgParams parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevApiSendMsgParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDevApiSendMsgParams> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppid(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.appid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.appid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCliMsgid(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.cliMsgid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCliMsgidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.cliMsgid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.content_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.content_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToIlinkId(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.toIlinkId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToIlinkIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.toIlinkId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.type_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.type_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDevApiSendMsgParams();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"bitField0_", "cliMsgid_", "toIlinkId_", "content_", "type_", "appid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDevApiSendMsgParams> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDevApiSendMsgParams.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public String getCliMsgid() {
            return this.cliMsgid_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public ByteString getCliMsgidBytes() {
            return ByteString.copyFromUtf8(this.cliMsgid_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public String getContent() {
            return this.content_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public ByteString getContentBytes() {
            return ByteString.copyFromUtf8(this.content_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public String getToIlinkId() {
            return this.toIlinkId_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public ByteString getToIlinkIdBytes() {
            return ByteString.copyFromUtf8(this.toIlinkId_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public String getType() {
            return this.type_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public boolean hasCliMsgid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public boolean hasContent() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public boolean hasToIlinkId() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevApiSendMsgParamsOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDevApiSendMsgParams ilinkDevApiSendMsgParams) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDevApiSendMsgParams);
        }

        public static IlinkDevApiSendMsgParams parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevApiSendMsgParams parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDevApiSendMsgParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDevApiSendMsgParams parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDevApiSendMsgParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDevApiSendMsgParams parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDevApiSendMsgParams parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevApiSendMsgParams parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevApiSendMsgParams parseFrom(k kVar) throws IOException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDevApiSendMsgParams parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDevApiSendMsgParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDevApiSendMsgParamsOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        String getCliMsgid();

        ByteString getCliMsgidBytes();

        String getContent();

        ByteString getContentBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getToIlinkId();

        ByteString getToIlinkIdBytes();

        String getType();

        ByteString getTypeBytes();

        boolean hasAppid();

        boolean hasCliMsgid();

        boolean hasContent();

        boolean hasToIlinkId();

        boolean hasType();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDevAuthParams extends GeneratedMessageLite<IlinkDevAuthParams, Builder> implements IlinkDevAuthParamsOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final IlinkDevAuthParams DEFAULT_INSTANCE;
        private static volatile bg<IlinkDevAuthParams> PARSER;
        private int bitField0_;
        private byte memoizedIsInitialized = 2;
        private String appid_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDevAuthParams, Builder> implements IlinkDevAuthParamsOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((IlinkDevAuthParams) this.instance).clearAppid();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevAuthParamsOrBuilder
            public String getAppid() {
                return ((IlinkDevAuthParams) this.instance).getAppid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevAuthParamsOrBuilder
            public ByteString getAppidBytes() {
                return ((IlinkDevAuthParams) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevAuthParamsOrBuilder
            public boolean hasAppid() {
                return ((IlinkDevAuthParams) this.instance).hasAppid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((IlinkDevAuthParams) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevAuthParams) this.instance).setAppidBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkDevAuthParams.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDevAuthParams ilinkDevAuthParams = new IlinkDevAuthParams();
            DEFAULT_INSTANCE = ilinkDevAuthParams;
            GeneratedMessageLite.registerDefaultInstance(IlinkDevAuthParams.class, ilinkDevAuthParams);
        }

        IlinkDevAuthParams() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        public static IlinkDevAuthParams getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDevAuthParams parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevAuthParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDevAuthParams> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppid(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.appid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.appid_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i3 = 1;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDevAuthParams();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0508\u0000", new Object[]{"bitField0_", "appid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDevAuthParams> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDevAuthParams.class) {
                            bgVar = PARSER;
                            if (bgVar == null) {
                                bgVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                                PARSER = bgVar;
                            }
                        }
                    }
                    return bgVar;
                case 6:
                    return Byte.valueOf(this.memoizedIsInitialized);
                case 7:
                    if (obj == null) {
                        i3 = 0;
                    }
                    this.memoizedIsInitialized = (byte) i3;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevAuthParamsOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevAuthParamsOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevAuthParamsOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDevAuthParams ilinkDevAuthParams) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDevAuthParams);
        }

        public static IlinkDevAuthParams parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevAuthParams parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDevAuthParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDevAuthParams parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDevAuthParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDevAuthParams parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDevAuthParams parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevAuthParams parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevAuthParams parseFrom(k kVar) throws IOException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDevAuthParams parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDevAuthParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDevAuthParamsOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasAppid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum IlinkDevCancelType implements ad.c {
        kIlinkDevCancelUnknown(-1),
        kIlinkDevCancelAll(0),
        kIlinkDevCancelAuth(1),
        kIlinkDevCancelUploadFile(2),
        kIlinkDevCancelRefreshAvatar(3),
        kIlinkDevCancelGetProfile(4),
        kIlinkDevCancelLogout(5),
        kIlinkDevCancelOplog(6),
        kIlinkDevCancelGetTicket(7),
        kIlinkDevCancelGetPublicAccountQrcode(8),
        kIlinkDevCancelAcceptFriendRequest(9),
        kIlinkDevCancelSendTextMsg(10),
        kIlinkDevCancelSendIotCmd(11);

        private static final ad.d<IlinkDevCancelType> internalValueMap = new ad.d<IlinkDevCancelType>() { // from class: com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevCancelType.1
            @Override // com.google.protobuf.ad.d
            public IlinkDevCancelType findValueByNumber(int i3) {
                return IlinkDevCancelType.forNumber(i3);
            }
        };
        public static final int kIlinkDevCancelAcceptFriendRequest_VALUE = 9;
        public static final int kIlinkDevCancelAll_VALUE = 0;
        public static final int kIlinkDevCancelAuth_VALUE = 1;
        public static final int kIlinkDevCancelGetProfile_VALUE = 4;
        public static final int kIlinkDevCancelGetPublicAccountQrcode_VALUE = 8;
        public static final int kIlinkDevCancelGetTicket_VALUE = 7;
        public static final int kIlinkDevCancelLogout_VALUE = 5;
        public static final int kIlinkDevCancelOplog_VALUE = 6;
        public static final int kIlinkDevCancelRefreshAvatar_VALUE = 3;
        public static final int kIlinkDevCancelSendIotCmd_VALUE = 11;
        public static final int kIlinkDevCancelSendTextMsg_VALUE = 10;
        public static final int kIlinkDevCancelUnknown_VALUE = -1;
        public static final int kIlinkDevCancelUploadFile_VALUE = 2;
        private final int value;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class IlinkDevCancelTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new IlinkDevCancelTypeVerifier();

            IlinkDevCancelTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (IlinkDevCancelType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        IlinkDevCancelType(int i3) {
            this.value = i3;
        }

        public static IlinkDevCancelType forNumber(int i3) {
            switch (i3) {
                case -1:
                    return kIlinkDevCancelUnknown;
                case 0:
                    return kIlinkDevCancelAll;
                case 1:
                    return kIlinkDevCancelAuth;
                case 2:
                    return kIlinkDevCancelUploadFile;
                case 3:
                    return kIlinkDevCancelRefreshAvatar;
                case 4:
                    return kIlinkDevCancelGetProfile;
                case 5:
                    return kIlinkDevCancelLogout;
                case 6:
                    return kIlinkDevCancelOplog;
                case 7:
                    return kIlinkDevCancelGetTicket;
                case 8:
                    return kIlinkDevCancelGetPublicAccountQrcode;
                case 9:
                    return kIlinkDevCancelAcceptFriendRequest;
                case 10:
                    return kIlinkDevCancelSendTextMsg;
                case 11:
                    return kIlinkDevCancelSendIotCmd;
                default:
                    return null;
            }
        }

        public static ad.d<IlinkDevCancelType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return IlinkDevCancelTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static IlinkDevCancelType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDevInitParameter extends GeneratedMessageLite<IlinkDevInitParameter, Builder> implements IlinkDevInitParameterOrBuilder {
        public static final int CLEAN_CACHE_FIELD_NUMBER = 8;
        private static final IlinkDevInitParameter DEFAULT_INSTANCE;
        public static final int DEVICE_AUTH_TYPE_FIELD_NUMBER = 4;
        public static final int DEVICE_SIGNATURE_FIELD_NUMBER = 7;
        public static final int DEVICE_SIGNATURE_TIMESTAMP_FIELD_NUMBER = 6;
        public static final int DEVICE_SIGNATURE_VERSION_FIELD_NUMBER = 5;
        public static final int ILINK_DEVICEID_FIELD_NUMBER = 3;
        public static final int ILINK_PRODUCT_ID_FIELD_NUMBER = 2;
        private static volatile bg<IlinkDevInitParameter> PARSER = null;
        public static final int SIGNATURE_ALGO_FIELD_NUMBER = 9;
        public static final int START_CONF_FIELD_NUMBER = 1;
        private int bitField0_;
        private boolean cleanCache_;
        private int deviceAuthType_;
        private int deviceSignatureTimestamp_;
        private int deviceSignatureVersion_;
        private int ilinkProductId_;
        private int signatureAlgo_;
        private ByteString startConf_ = ByteString.EMPTY;
        private String ilinkDeviceid_ = "";
        private String deviceSignature_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDevInitParameter, Builder> implements IlinkDevInitParameterOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCleanCache() {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).clearCleanCache();
                return this;
            }

            public Builder clearDeviceAuthType() {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).clearDeviceAuthType();
                return this;
            }

            public Builder clearDeviceSignature() {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).clearDeviceSignature();
                return this;
            }

            public Builder clearDeviceSignatureTimestamp() {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).clearDeviceSignatureTimestamp();
                return this;
            }

            public Builder clearDeviceSignatureVersion() {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).clearDeviceSignatureVersion();
                return this;
            }

            public Builder clearIlinkDeviceid() {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).clearIlinkDeviceid();
                return this;
            }

            public Builder clearIlinkProductId() {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).clearIlinkProductId();
                return this;
            }

            public Builder clearSignatureAlgo() {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).clearSignatureAlgo();
                return this;
            }

            public Builder clearStartConf() {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).clearStartConf();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean getCleanCache() {
                return ((IlinkDevInitParameter) this.instance).getCleanCache();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public int getDeviceAuthType() {
                return ((IlinkDevInitParameter) this.instance).getDeviceAuthType();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public String getDeviceSignature() {
                return ((IlinkDevInitParameter) this.instance).getDeviceSignature();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public ByteString getDeviceSignatureBytes() {
                return ((IlinkDevInitParameter) this.instance).getDeviceSignatureBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public int getDeviceSignatureTimestamp() {
                return ((IlinkDevInitParameter) this.instance).getDeviceSignatureTimestamp();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public int getDeviceSignatureVersion() {
                return ((IlinkDevInitParameter) this.instance).getDeviceSignatureVersion();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public String getIlinkDeviceid() {
                return ((IlinkDevInitParameter) this.instance).getIlinkDeviceid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public ByteString getIlinkDeviceidBytes() {
                return ((IlinkDevInitParameter) this.instance).getIlinkDeviceidBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public int getIlinkProductId() {
                return ((IlinkDevInitParameter) this.instance).getIlinkProductId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public int getSignatureAlgo() {
                return ((IlinkDevInitParameter) this.instance).getSignatureAlgo();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public ByteString getStartConf() {
                return ((IlinkDevInitParameter) this.instance).getStartConf();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean hasCleanCache() {
                return ((IlinkDevInitParameter) this.instance).hasCleanCache();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean hasDeviceAuthType() {
                return ((IlinkDevInitParameter) this.instance).hasDeviceAuthType();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean hasDeviceSignature() {
                return ((IlinkDevInitParameter) this.instance).hasDeviceSignature();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean hasDeviceSignatureTimestamp() {
                return ((IlinkDevInitParameter) this.instance).hasDeviceSignatureTimestamp();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean hasDeviceSignatureVersion() {
                return ((IlinkDevInitParameter) this.instance).hasDeviceSignatureVersion();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean hasIlinkDeviceid() {
                return ((IlinkDevInitParameter) this.instance).hasIlinkDeviceid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean hasIlinkProductId() {
                return ((IlinkDevInitParameter) this.instance).hasIlinkProductId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean hasSignatureAlgo() {
                return ((IlinkDevInitParameter) this.instance).hasSignatureAlgo();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
            public boolean hasStartConf() {
                return ((IlinkDevInitParameter) this.instance).hasStartConf();
            }

            public Builder setCleanCache(boolean z16) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setCleanCache(z16);
                return this;
            }

            public Builder setDeviceAuthType(int i3) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setDeviceAuthType(i3);
                return this;
            }

            public Builder setDeviceSignature(String str) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setDeviceSignature(str);
                return this;
            }

            public Builder setDeviceSignatureBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setDeviceSignatureBytes(byteString);
                return this;
            }

            public Builder setDeviceSignatureTimestamp(int i3) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setDeviceSignatureTimestamp(i3);
                return this;
            }

            public Builder setDeviceSignatureVersion(int i3) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setDeviceSignatureVersion(i3);
                return this;
            }

            public Builder setIlinkDeviceid(String str) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setIlinkDeviceid(str);
                return this;
            }

            public Builder setIlinkDeviceidBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setIlinkDeviceidBytes(byteString);
                return this;
            }

            public Builder setIlinkProductId(int i3) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setIlinkProductId(i3);
                return this;
            }

            public Builder setSignatureAlgo(int i3) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setSignatureAlgo(i3);
                return this;
            }

            public Builder setStartConf(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevInitParameter) this.instance).setStartConf(byteString);
                return this;
            }

            Builder() {
                super(IlinkDevInitParameter.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDevInitParameter ilinkDevInitParameter = new IlinkDevInitParameter();
            DEFAULT_INSTANCE = ilinkDevInitParameter;
            GeneratedMessageLite.registerDefaultInstance(IlinkDevInitParameter.class, ilinkDevInitParameter);
        }

        IlinkDevInitParameter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCleanCache() {
            this.bitField0_ &= -129;
            this.cleanCache_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceAuthType() {
            this.bitField0_ &= -9;
            this.deviceAuthType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceSignature() {
            this.bitField0_ &= -65;
            this.deviceSignature_ = getDefaultInstance().getDeviceSignature();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceSignatureTimestamp() {
            this.bitField0_ &= -33;
            this.deviceSignatureTimestamp_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceSignatureVersion() {
            this.bitField0_ &= -17;
            this.deviceSignatureVersion_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkDeviceid() {
            this.bitField0_ &= -5;
            this.ilinkDeviceid_ = getDefaultInstance().getIlinkDeviceid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkProductId() {
            this.bitField0_ &= -3;
            this.ilinkProductId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSignatureAlgo() {
            this.bitField0_ &= -257;
            this.signatureAlgo_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartConf() {
            this.bitField0_ &= -2;
            this.startConf_ = getDefaultInstance().getStartConf();
        }

        public static IlinkDevInitParameter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDevInitParameter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevInitParameter parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDevInitParameter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCleanCache(boolean z16) {
            this.bitField0_ |= 128;
            this.cleanCache_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceAuthType(int i3) {
            this.bitField0_ |= 8;
            this.deviceAuthType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceSignature(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.deviceSignature_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceSignatureBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.deviceSignature_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceSignatureTimestamp(int i3) {
            this.bitField0_ |= 32;
            this.deviceSignatureTimestamp_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceSignatureVersion(int i3) {
            this.bitField0_ |= 16;
            this.deviceSignatureVersion_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkDeviceid(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.ilinkDeviceid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkDeviceidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.ilinkDeviceid_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkProductId(int i3) {
            this.bitField0_ |= 2;
            this.ilinkProductId_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSignatureAlgo(int i3) {
            this.bitField0_ |= 256;
            this.signatureAlgo_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartConf(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.startConf_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDevInitParameter();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001\n\u0000\u0002\u0004\u0001\u0003\b\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u000b\u0005\u0007\b\u0006\b\u0007\u0007\t\u000b\b", new Object[]{"bitField0_", "startConf_", "ilinkProductId_", "ilinkDeviceid_", "deviceAuthType_", "deviceSignatureVersion_", "deviceSignatureTimestamp_", "deviceSignature_", "cleanCache_", "signatureAlgo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDevInitParameter> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDevInitParameter.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean getCleanCache() {
            return this.cleanCache_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public int getDeviceAuthType() {
            return this.deviceAuthType_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public String getDeviceSignature() {
            return this.deviceSignature_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public ByteString getDeviceSignatureBytes() {
            return ByteString.copyFromUtf8(this.deviceSignature_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public int getDeviceSignatureTimestamp() {
            return this.deviceSignatureTimestamp_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public int getDeviceSignatureVersion() {
            return this.deviceSignatureVersion_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public String getIlinkDeviceid() {
            return this.ilinkDeviceid_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public ByteString getIlinkDeviceidBytes() {
            return ByteString.copyFromUtf8(this.ilinkDeviceid_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public int getIlinkProductId() {
            return this.ilinkProductId_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public int getSignatureAlgo() {
            return this.signatureAlgo_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public ByteString getStartConf() {
            return this.startConf_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean hasCleanCache() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean hasDeviceAuthType() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean hasDeviceSignature() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean hasDeviceSignatureTimestamp() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean hasDeviceSignatureVersion() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean hasIlinkDeviceid() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean hasIlinkProductId() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean hasSignatureAlgo() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevInitParameterOrBuilder
        public boolean hasStartConf() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDevInitParameter ilinkDevInitParameter) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDevInitParameter);
        }

        public static IlinkDevInitParameter parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevInitParameter parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDevInitParameter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDevInitParameter parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDevInitParameter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDevInitParameter parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDevInitParameter parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevInitParameter parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevInitParameter parseFrom(k kVar) throws IOException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDevInitParameter parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDevInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDevInitParameterOrBuilder extends av {
        boolean getCleanCache();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getDeviceAuthType();

        String getDeviceSignature();

        ByteString getDeviceSignatureBytes();

        int getDeviceSignatureTimestamp();

        int getDeviceSignatureVersion();

        String getIlinkDeviceid();

        ByteString getIlinkDeviceidBytes();

        int getIlinkProductId();

        int getSignatureAlgo();

        ByteString getStartConf();

        boolean hasCleanCache();

        boolean hasDeviceAuthType();

        boolean hasDeviceSignature();

        boolean hasDeviceSignatureTimestamp();

        boolean hasDeviceSignatureVersion();

        boolean hasIlinkDeviceid();

        boolean hasIlinkProductId();

        boolean hasSignatureAlgo();

        boolean hasStartConf();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDevMessage extends GeneratedMessageLite<IlinkDevMessage, Builder> implements IlinkDevMessageOrBuilder {
        public static final int BODY_FIELD_NUMBER = 4;
        public static final int CMDID_FIELD_NUMBER = 1;
        public static final int CREATE_TIME_FIELD_NUMBER = 3;
        private static final IlinkDevMessage DEFAULT_INSTANCE;
        public static final int MSGID_FIELD_NUMBER = 2;
        private static volatile bg<IlinkDevMessage> PARSER;
        private int bitField0_;
        private ByteString body_ = ByteString.EMPTY;
        private long cmdid_;
        private long createTime_;
        private long msgid_;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDevMessage, Builder> implements IlinkDevMessageOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((IlinkDevMessage) this.instance).clearBody();
                return this;
            }

            public Builder clearCmdid() {
                copyOnWrite();
                ((IlinkDevMessage) this.instance).clearCmdid();
                return this;
            }

            public Builder clearCreateTime() {
                copyOnWrite();
                ((IlinkDevMessage) this.instance).clearCreateTime();
                return this;
            }

            public Builder clearMsgid() {
                copyOnWrite();
                ((IlinkDevMessage) this.instance).clearMsgid();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
            public ByteString getBody() {
                return ((IlinkDevMessage) this.instance).getBody();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
            public long getCmdid() {
                return ((IlinkDevMessage) this.instance).getCmdid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
            public long getCreateTime() {
                return ((IlinkDevMessage) this.instance).getCreateTime();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
            public long getMsgid() {
                return ((IlinkDevMessage) this.instance).getMsgid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
            public boolean hasBody() {
                return ((IlinkDevMessage) this.instance).hasBody();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
            public boolean hasCmdid() {
                return ((IlinkDevMessage) this.instance).hasCmdid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
            public boolean hasCreateTime() {
                return ((IlinkDevMessage) this.instance).hasCreateTime();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
            public boolean hasMsgid() {
                return ((IlinkDevMessage) this.instance).hasMsgid();
            }

            public Builder setBody(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevMessage) this.instance).setBody(byteString);
                return this;
            }

            public Builder setCmdid(long j3) {
                copyOnWrite();
                ((IlinkDevMessage) this.instance).setCmdid(j3);
                return this;
            }

            public Builder setCreateTime(long j3) {
                copyOnWrite();
                ((IlinkDevMessage) this.instance).setCreateTime(j3);
                return this;
            }

            public Builder setMsgid(long j3) {
                copyOnWrite();
                ((IlinkDevMessage) this.instance).setMsgid(j3);
                return this;
            }

            Builder() {
                super(IlinkDevMessage.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDevMessage ilinkDevMessage = new IlinkDevMessage();
            DEFAULT_INSTANCE = ilinkDevMessage;
            GeneratedMessageLite.registerDefaultInstance(IlinkDevMessage.class, ilinkDevMessage);
        }

        IlinkDevMessage() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -9;
            this.body_ = getDefaultInstance().getBody();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCmdid() {
            this.bitField0_ &= -2;
            this.cmdid_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreateTime() {
            this.bitField0_ &= -5;
            this.createTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsgid() {
            this.bitField0_ &= -3;
            this.msgid_ = 0L;
        }

        public static IlinkDevMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDevMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDevMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDevMessage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.body_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCmdid(long j3) {
            this.bitField0_ |= 1;
            this.cmdid_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreateTime(long j3) {
            this.bitField0_ |= 4;
            this.createTime_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgid(long j3) {
            this.bitField0_ |= 2;
            this.msgid_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDevMessage();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0003\u0000\u0002\u0003\u0001\u0003\u0003\u0002\u0004\n\u0003", new Object[]{"bitField0_", "cmdid_", "msgid_", "createTime_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDevMessage> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDevMessage.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
        public ByteString getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
        public long getCmdid() {
            return this.cmdid_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
        public long getCreateTime() {
            return this.createTime_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
        public long getMsgid() {
            return this.msgid_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
        public boolean hasCmdid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
        public boolean hasCreateTime() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevMessageOrBuilder
        public boolean hasMsgid() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDevMessage ilinkDevMessage) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDevMessage);
        }

        public static IlinkDevMessage parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevMessage parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDevMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDevMessage parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDevMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDevMessage parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDevMessage parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevMessage parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevMessage parseFrom(k kVar) throws IOException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDevMessage parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDevMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDevMessageOrBuilder extends av {
        ByteString getBody();

        long getCmdid();

        long getCreateTime();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        long getMsgid();

        boolean hasBody();

        boolean hasCmdid();

        boolean hasCreateTime();

        boolean hasMsgid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDevNetProxyInfo extends GeneratedMessageLite<IlinkDevNetProxyInfo, Builder> implements IlinkDevNetProxyInfoOrBuilder {
        private static final IlinkDevNetProxyInfo DEFAULT_INSTANCE;
        public static final int IP_FIELD_NUMBER = 1;
        private static volatile bg<IlinkDevNetProxyInfo> PARSER = null;
        public static final int PASSWORD_FIELD_NUMBER = 4;
        public static final int PORT_FIELD_NUMBER = 2;
        public static final int PROXYTYPE_FIELD_NUMBER = 5;
        public static final int USERNAME_FIELD_NUMBER = 3;
        private int bitField0_;
        private String ip_ = "";
        private ByteString password_;
        private int port_;
        private int proxytype_;
        private ByteString username_;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDevNetProxyInfo, Builder> implements IlinkDevNetProxyInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearIp() {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).clearIp();
                return this;
            }

            public Builder clearPassword() {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).clearPassword();
                return this;
            }

            public Builder clearPort() {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).clearPort();
                return this;
            }

            public Builder clearProxytype() {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).clearProxytype();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).clearUsername();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public String getIp() {
                return ((IlinkDevNetProxyInfo) this.instance).getIp();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public ByteString getIpBytes() {
                return ((IlinkDevNetProxyInfo) this.instance).getIpBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public ByteString getPassword() {
                return ((IlinkDevNetProxyInfo) this.instance).getPassword();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public int getPort() {
                return ((IlinkDevNetProxyInfo) this.instance).getPort();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public int getProxytype() {
                return ((IlinkDevNetProxyInfo) this.instance).getProxytype();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public ByteString getUsername() {
                return ((IlinkDevNetProxyInfo) this.instance).getUsername();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public boolean hasIp() {
                return ((IlinkDevNetProxyInfo) this.instance).hasIp();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public boolean hasPassword() {
                return ((IlinkDevNetProxyInfo) this.instance).hasPassword();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public boolean hasPort() {
                return ((IlinkDevNetProxyInfo) this.instance).hasPort();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public boolean hasProxytype() {
                return ((IlinkDevNetProxyInfo) this.instance).hasProxytype();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
            public boolean hasUsername() {
                return ((IlinkDevNetProxyInfo) this.instance).hasUsername();
            }

            public Builder setIp(String str) {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).setIp(str);
                return this;
            }

            public Builder setIpBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).setIpBytes(byteString);
                return this;
            }

            public Builder setPassword(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).setPassword(byteString);
                return this;
            }

            public Builder setPort(int i3) {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).setPort(i3);
                return this;
            }

            public Builder setProxytype(int i3) {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).setProxytype(i3);
                return this;
            }

            public Builder setUsername(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevNetProxyInfo) this.instance).setUsername(byteString);
                return this;
            }

            Builder() {
                super(IlinkDevNetProxyInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDevNetProxyInfo ilinkDevNetProxyInfo = new IlinkDevNetProxyInfo();
            DEFAULT_INSTANCE = ilinkDevNetProxyInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkDevNetProxyInfo.class, ilinkDevNetProxyInfo);
        }

        IlinkDevNetProxyInfo() {
            ByteString byteString = ByteString.EMPTY;
            this.username_ = byteString;
            this.password_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIp() {
            this.bitField0_ &= -2;
            this.ip_ = getDefaultInstance().getIp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPassword() {
            this.bitField0_ &= -9;
            this.password_ = getDefaultInstance().getPassword();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPort() {
            this.bitField0_ &= -3;
            this.port_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProxytype() {
            this.bitField0_ &= -17;
            this.proxytype_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.bitField0_ &= -5;
            this.username_ = getDefaultInstance().getUsername();
        }

        public static IlinkDevNetProxyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDevNetProxyInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevNetProxyInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDevNetProxyInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIp(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.ip_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIpBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.ip_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPassword(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.password_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPort(int i3) {
            this.bitField0_ |= 2;
            this.port_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProxytype(int i3) {
            this.bitField0_ |= 16;
            this.proxytype_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.username_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDevNetProxyInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u000b\u0004", new Object[]{"bitField0_", "ip_", "port_", "username_", "password_", "proxytype_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDevNetProxyInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDevNetProxyInfo.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public String getIp() {
            return this.ip_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public ByteString getIpBytes() {
            return ByteString.copyFromUtf8(this.ip_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public ByteString getPassword() {
            return this.password_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public int getPort() {
            return this.port_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public int getProxytype() {
            return this.proxytype_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public ByteString getUsername() {
            return this.username_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public boolean hasIp() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public boolean hasPassword() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public boolean hasPort() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public boolean hasProxytype() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevNetProxyInfoOrBuilder
        public boolean hasUsername() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDevNetProxyInfo ilinkDevNetProxyInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDevNetProxyInfo);
        }

        public static IlinkDevNetProxyInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevNetProxyInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDevNetProxyInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDevNetProxyInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDevNetProxyInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDevNetProxyInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDevNetProxyInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevNetProxyInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevNetProxyInfo parseFrom(k kVar) throws IOException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDevNetProxyInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDevNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDevNetProxyInfoOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getIp();

        ByteString getIpBytes();

        ByteString getPassword();

        int getPort();

        int getProxytype();

        ByteString getUsername();

        boolean hasIp();

        boolean hasPassword();

        boolean hasPort();

        boolean hasProxytype();

        boolean hasUsername();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDevOplogParams extends GeneratedMessageLite<IlinkDevOplogParams, Builder> implements IlinkDevOplogParamsOrBuilder {
        public static final int BUF_FIELD_NUMBER = 2;
        private static final IlinkDevOplogParams DEFAULT_INSTANCE;
        private static volatile bg<IlinkDevOplogParams> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int bitField0_;
        private ByteString buf_ = ByteString.EMPTY;
        private int type_;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDevOplogParams, Builder> implements IlinkDevOplogParamsOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBuf() {
                copyOnWrite();
                ((IlinkDevOplogParams) this.instance).clearBuf();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((IlinkDevOplogParams) this.instance).clearType();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevOplogParamsOrBuilder
            public ByteString getBuf() {
                return ((IlinkDevOplogParams) this.instance).getBuf();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevOplogParamsOrBuilder
            public int getType() {
                return ((IlinkDevOplogParams) this.instance).getType();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevOplogParamsOrBuilder
            public boolean hasBuf() {
                return ((IlinkDevOplogParams) this.instance).hasBuf();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevOplogParamsOrBuilder
            public boolean hasType() {
                return ((IlinkDevOplogParams) this.instance).hasType();
            }

            public Builder setBuf(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevOplogParams) this.instance).setBuf(byteString);
                return this;
            }

            public Builder setType(int i3) {
                copyOnWrite();
                ((IlinkDevOplogParams) this.instance).setType(i3);
                return this;
            }

            Builder() {
                super(IlinkDevOplogParams.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDevOplogParams ilinkDevOplogParams = new IlinkDevOplogParams();
            DEFAULT_INSTANCE = ilinkDevOplogParams;
            GeneratedMessageLite.registerDefaultInstance(IlinkDevOplogParams.class, ilinkDevOplogParams);
        }

        IlinkDevOplogParams() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBuf() {
            this.bitField0_ &= -3;
            this.buf_ = getDefaultInstance().getBuf();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -2;
            this.type_ = 0;
        }

        public static IlinkDevOplogParams getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDevOplogParams parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevOplogParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDevOplogParams> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBuf(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.buf_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i3) {
            this.bitField0_ |= 1;
            this.type_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDevOplogParams();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "type_", "buf_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDevOplogParams> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDevOplogParams.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevOplogParamsOrBuilder
        public ByteString getBuf() {
            return this.buf_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevOplogParamsOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevOplogParamsOrBuilder
        public boolean hasBuf() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevOplogParamsOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDevOplogParams ilinkDevOplogParams) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDevOplogParams);
        }

        public static IlinkDevOplogParams parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevOplogParams parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDevOplogParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDevOplogParams parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDevOplogParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDevOplogParams parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDevOplogParams parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevOplogParams parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevOplogParams parseFrom(k kVar) throws IOException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDevOplogParams parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDevOplogParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDevOplogParamsOrBuilder extends av {
        ByteString getBuf();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getType();

        boolean hasBuf();

        boolean hasType();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDevPullLogCmd extends GeneratedMessageLite<IlinkDevPullLogCmd, Builder> implements IlinkDevPullLogCmdOrBuilder {
        public static final int APPID_FIELD_NUMBER = 5;
        private static final IlinkDevPullLogCmd DEFAULT_INSTANCE;
        public static final int ENDTIME_FIELD_NUMBER = 2;
        public static final int EXTBUFFER_FIELD_NUMBER = 7;
        public static final int INCLUDEDEVLOG_FIELD_NUMBER = 6;
        public static final int NETTYPE_FIELD_NUMBER = 4;
        private static volatile bg<IlinkDevPullLogCmd> PARSER = null;
        public static final int STARTTIME_FIELD_NUMBER = 1;
        public static final int TOKEN_FIELD_NUMBER = 3;
        private int bitField0_;
        private int endTime_;
        private boolean includeDevLog_;
        private int nettype_;
        private int startTime_;
        private String token_ = "";
        private ad.j<String> appid_ = GeneratedMessageLite.emptyProtobufList();
        private String extBuffer_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDevPullLogCmd, Builder> implements IlinkDevPullLogCmdOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllAppid(Iterable<String> iterable) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).addAllAppid(iterable);
                return this;
            }

            public Builder addAppid(String str) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).addAppid(str);
                return this;
            }

            public Builder addAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).addAppidBytes(byteString);
                return this;
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).clearAppid();
                return this;
            }

            public Builder clearEndTime() {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).clearEndTime();
                return this;
            }

            public Builder clearExtBuffer() {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).clearExtBuffer();
                return this;
            }

            public Builder clearIncludeDevLog() {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).clearIncludeDevLog();
                return this;
            }

            public Builder clearNettype() {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).clearNettype();
                return this;
            }

            public Builder clearStartTime() {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).clearStartTime();
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).clearToken();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public String getAppid(int i3) {
                return ((IlinkDevPullLogCmd) this.instance).getAppid(i3);
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public ByteString getAppidBytes(int i3) {
                return ((IlinkDevPullLogCmd) this.instance).getAppidBytes(i3);
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public int getAppidCount() {
                return ((IlinkDevPullLogCmd) this.instance).getAppidCount();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public List<String> getAppidList() {
                return Collections.unmodifiableList(((IlinkDevPullLogCmd) this.instance).getAppidList());
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public int getEndTime() {
                return ((IlinkDevPullLogCmd) this.instance).getEndTime();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public String getExtBuffer() {
                return ((IlinkDevPullLogCmd) this.instance).getExtBuffer();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public ByteString getExtBufferBytes() {
                return ((IlinkDevPullLogCmd) this.instance).getExtBufferBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public boolean getIncludeDevLog() {
                return ((IlinkDevPullLogCmd) this.instance).getIncludeDevLog();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public Network getNettype() {
                return ((IlinkDevPullLogCmd) this.instance).getNettype();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public int getStartTime() {
                return ((IlinkDevPullLogCmd) this.instance).getStartTime();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public String getToken() {
                return ((IlinkDevPullLogCmd) this.instance).getToken();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public ByteString getTokenBytes() {
                return ((IlinkDevPullLogCmd) this.instance).getTokenBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public boolean hasEndTime() {
                return ((IlinkDevPullLogCmd) this.instance).hasEndTime();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public boolean hasExtBuffer() {
                return ((IlinkDevPullLogCmd) this.instance).hasExtBuffer();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public boolean hasIncludeDevLog() {
                return ((IlinkDevPullLogCmd) this.instance).hasIncludeDevLog();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public boolean hasNettype() {
                return ((IlinkDevPullLogCmd) this.instance).hasNettype();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public boolean hasStartTime() {
                return ((IlinkDevPullLogCmd) this.instance).hasStartTime();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
            public boolean hasToken() {
                return ((IlinkDevPullLogCmd) this.instance).hasToken();
            }

            public Builder setAppid(int i3, String str) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).setAppid(i3, str);
                return this;
            }

            public Builder setEndTime(int i3) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).setEndTime(i3);
                return this;
            }

            public Builder setExtBuffer(String str) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).setExtBuffer(str);
                return this;
            }

            public Builder setExtBufferBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).setExtBufferBytes(byteString);
                return this;
            }

            public Builder setIncludeDevLog(boolean z16) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).setIncludeDevLog(z16);
                return this;
            }

            public Builder setNettype(Network network) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).setNettype(network);
                return this;
            }

            public Builder setStartTime(int i3) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).setStartTime(i3);
                return this;
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).setToken(str);
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevPullLogCmd) this.instance).setTokenBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkDevPullLogCmd.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDevPullLogCmd ilinkDevPullLogCmd = new IlinkDevPullLogCmd();
            DEFAULT_INSTANCE = ilinkDevPullLogCmd;
            GeneratedMessageLite.registerDefaultInstance(IlinkDevPullLogCmd.class, ilinkDevPullLogCmd);
        }

        IlinkDevPullLogCmd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAppid(Iterable<String> iterable) {
            ensureAppidIsMutable();
            b.addAll((Iterable) iterable, (List) this.appid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAppid(String str) {
            str.getClass();
            ensureAppidIsMutable();
            this.appid_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAppidBytes(ByteString byteString) {
            byteString.getClass();
            ensureAppidIsMutable();
            this.appid_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.appid_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTime() {
            this.bitField0_ &= -3;
            this.endTime_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtBuffer() {
            this.bitField0_ &= -33;
            this.extBuffer_ = getDefaultInstance().getExtBuffer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIncludeDevLog() {
            this.bitField0_ &= -17;
            this.includeDevLog_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNettype() {
            this.bitField0_ &= -9;
            this.nettype_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTime() {
            this.bitField0_ &= -2;
            this.startTime_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.bitField0_ &= -5;
            this.token_ = getDefaultInstance().getToken();
        }

        private void ensureAppidIsMutable() {
            if (!this.appid_.z()) {
                this.appid_ = GeneratedMessageLite.mutableCopy(this.appid_);
            }
        }

        public static IlinkDevPullLogCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDevPullLogCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevPullLogCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDevPullLogCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppid(int i3, String str) {
            str.getClass();
            ensureAppidIsMutable();
            this.appid_.set(i3, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTime(int i3) {
            this.bitField0_ |= 2;
            this.endTime_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtBuffer(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.extBuffer_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtBufferBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.extBuffer_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIncludeDevLog(boolean z16) {
            this.bitField0_ |= 16;
            this.includeDevLog_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNettype(Network network) {
            network.getClass();
            this.bitField0_ |= 8;
            this.nettype_ = network.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTime(int i3) {
            this.bitField0_ |= 1;
            this.startTime_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.token_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.token_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDevPullLogCmd();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u000b\u0000\u0002\u000b\u0001\u0003\b\u0002\u0004\f\u0003\u0005\u001a\u0006\u0007\u0004\u0007\b\u0005", new Object[]{"bitField0_", "startTime_", "endTime_", "token_", "nettype_", Network.internalGetVerifier(), "appid_", "includeDevLog_", "extBuffer_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDevPullLogCmd> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDevPullLogCmd.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public String getAppid(int i3) {
            return this.appid_.get(i3);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public ByteString getAppidBytes(int i3) {
            return ByteString.copyFromUtf8(this.appid_.get(i3));
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public int getAppidCount() {
            return this.appid_.size();
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public List<String> getAppidList() {
            return this.appid_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public String getExtBuffer() {
            return this.extBuffer_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public ByteString getExtBufferBytes() {
            return ByteString.copyFromUtf8(this.extBuffer_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public boolean getIncludeDevLog() {
            return this.includeDevLog_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public Network getNettype() {
            Network forNumber = Network.forNumber(this.nettype_);
            if (forNumber == null) {
                return Network.LAN;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public boolean hasEndTime() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public boolean hasExtBuffer() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public boolean hasIncludeDevLog() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public boolean hasNettype() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public boolean hasStartTime() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevPullLogCmdOrBuilder
        public boolean hasToken() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDevPullLogCmd ilinkDevPullLogCmd) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDevPullLogCmd);
        }

        public static IlinkDevPullLogCmd parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevPullLogCmd parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDevPullLogCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDevPullLogCmd parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDevPullLogCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDevPullLogCmd parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDevPullLogCmd parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevPullLogCmd parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevPullLogCmd parseFrom(k kVar) throws IOException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDevPullLogCmd parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDevPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDevPullLogCmdOrBuilder extends av {
        String getAppid(int i3);

        ByteString getAppidBytes(int i3);

        int getAppidCount();

        List<String> getAppidList();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getEndTime();

        String getExtBuffer();

        ByteString getExtBufferBytes();

        boolean getIncludeDevLog();

        Network getNettype();

        int getStartTime();

        String getToken();

        ByteString getTokenBytes();

        boolean hasEndTime();

        boolean hasExtBuffer();

        boolean hasIncludeDevLog();

        boolean hasNettype();

        boolean hasStartTime();

        boolean hasToken();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDevRequest extends GeneratedMessageLite<IlinkDevRequest, Builder> implements IlinkDevRequestOrBuilder {
        public static final int BODY_FIELD_NUMBER = 5;
        public static final int CMDID_FIELD_NUMBER = 1;
        public static final int CRYPTO_ALGO_FIELD_NUMBER = 3;
        private static final IlinkDevRequest DEFAULT_INSTANCE;
        public static final int LIMIT_FLOW_FIELD_NUMBER = 7;
        public static final int LIMIT_FREQUENCY_FIELD_NUMBER = 8;
        public static final int NET_TYPE_FIELD_NUMBER = 4;
        private static volatile bg<IlinkDevRequest> PARSER = null;
        public static final int RETRY_COUNT_FIELD_NUMBER = 6;
        public static final int URL_FIELD_NUMBER = 2;
        private int bitField0_;
        private int cmdid_;
        private int cryptoAlgo_;
        private boolean limitFlow_;
        private boolean limitFrequency_;
        private int netType_;
        private int retryCount_;
        private String url_ = "";
        private ByteString body_ = ByteString.EMPTY;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDevRequest, Builder> implements IlinkDevRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).clearBody();
                return this;
            }

            public Builder clearCmdid() {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).clearCmdid();
                return this;
            }

            public Builder clearCryptoAlgo() {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).clearCryptoAlgo();
                return this;
            }

            public Builder clearLimitFlow() {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).clearLimitFlow();
                return this;
            }

            public Builder clearLimitFrequency() {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).clearLimitFrequency();
                return this;
            }

            public Builder clearNetType() {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).clearNetType();
                return this;
            }

            public Builder clearRetryCount() {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).clearRetryCount();
                return this;
            }

            public Builder clearUrl() {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).clearUrl();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public ByteString getBody() {
                return ((IlinkDevRequest) this.instance).getBody();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public int getCmdid() {
                return ((IlinkDevRequest) this.instance).getCmdid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public int getCryptoAlgo() {
                return ((IlinkDevRequest) this.instance).getCryptoAlgo();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean getLimitFlow() {
                return ((IlinkDevRequest) this.instance).getLimitFlow();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean getLimitFrequency() {
                return ((IlinkDevRequest) this.instance).getLimitFrequency();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public int getNetType() {
                return ((IlinkDevRequest) this.instance).getNetType();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public int getRetryCount() {
                return ((IlinkDevRequest) this.instance).getRetryCount();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public String getUrl() {
                return ((IlinkDevRequest) this.instance).getUrl();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public ByteString getUrlBytes() {
                return ((IlinkDevRequest) this.instance).getUrlBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean hasBody() {
                return ((IlinkDevRequest) this.instance).hasBody();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean hasCmdid() {
                return ((IlinkDevRequest) this.instance).hasCmdid();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean hasCryptoAlgo() {
                return ((IlinkDevRequest) this.instance).hasCryptoAlgo();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean hasLimitFlow() {
                return ((IlinkDevRequest) this.instance).hasLimitFlow();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean hasLimitFrequency() {
                return ((IlinkDevRequest) this.instance).hasLimitFrequency();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean hasNetType() {
                return ((IlinkDevRequest) this.instance).hasNetType();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean hasRetryCount() {
                return ((IlinkDevRequest) this.instance).hasRetryCount();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
            public boolean hasUrl() {
                return ((IlinkDevRequest) this.instance).hasUrl();
            }

            public Builder setBody(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).setBody(byteString);
                return this;
            }

            public Builder setCmdid(int i3) {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).setCmdid(i3);
                return this;
            }

            public Builder setCryptoAlgo(int i3) {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).setCryptoAlgo(i3);
                return this;
            }

            public Builder setLimitFlow(boolean z16) {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).setLimitFlow(z16);
                return this;
            }

            public Builder setLimitFrequency(boolean z16) {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).setLimitFrequency(z16);
                return this;
            }

            public Builder setNetType(int i3) {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).setNetType(i3);
                return this;
            }

            public Builder setRetryCount(int i3) {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).setRetryCount(i3);
                return this;
            }

            public Builder setUrl(String str) {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).setUrl(str);
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevRequest) this.instance).setUrlBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkDevRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDevRequest ilinkDevRequest = new IlinkDevRequest();
            DEFAULT_INSTANCE = ilinkDevRequest;
            GeneratedMessageLite.registerDefaultInstance(IlinkDevRequest.class, ilinkDevRequest);
        }

        IlinkDevRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -17;
            this.body_ = getDefaultInstance().getBody();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCmdid() {
            this.bitField0_ &= -2;
            this.cmdid_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCryptoAlgo() {
            this.bitField0_ &= -5;
            this.cryptoAlgo_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimitFlow() {
            this.bitField0_ &= -65;
            this.limitFlow_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimitFrequency() {
            this.bitField0_ &= -129;
            this.limitFrequency_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetType() {
            this.bitField0_ &= -9;
            this.netType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRetryCount() {
            this.bitField0_ &= -33;
            this.retryCount_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUrl() {
            this.bitField0_ &= -3;
            this.url_ = getDefaultInstance().getUrl();
        }

        public static IlinkDevRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDevRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDevRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDevRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.body_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCmdid(int i3) {
            this.bitField0_ |= 1;
            this.cmdid_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCryptoAlgo(int i3) {
            this.bitField0_ |= 4;
            this.cryptoAlgo_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimitFlow(boolean z16) {
            this.bitField0_ |= 64;
            this.limitFlow_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimitFrequency(boolean z16) {
            this.bitField0_ |= 128;
            this.limitFrequency_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetType(int i3) {
            this.bitField0_ |= 8;
            this.netType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRetryCount(int i3) {
            this.bitField0_ |= 32;
            this.retryCount_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrl(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.url_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrlBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.url_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDevRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0000\u0002\b\u0001\u0003\u000b\u0002\u0004\u000b\u0003\u0005\n\u0004\u0006\u000b\u0005\u0007\u0007\u0006\b\u0007\u0007", new Object[]{"bitField0_", "cmdid_", "url_", "cryptoAlgo_", "netType_", "body_", "retryCount_", "limitFlow_", "limitFrequency_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDevRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDevRequest.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public ByteString getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public int getCmdid() {
            return this.cmdid_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public int getCryptoAlgo() {
            return this.cryptoAlgo_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean getLimitFlow() {
            return this.limitFlow_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean getLimitFrequency() {
            return this.limitFrequency_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public int getNetType() {
            return this.netType_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public int getRetryCount() {
            return this.retryCount_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public String getUrl() {
            return this.url_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public ByteString getUrlBytes() {
            return ByteString.copyFromUtf8(this.url_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean hasCmdid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean hasCryptoAlgo() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean hasLimitFlow() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean hasLimitFrequency() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean hasNetType() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean hasRetryCount() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevRequestOrBuilder
        public boolean hasUrl() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDevRequest ilinkDevRequest) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDevRequest);
        }

        public static IlinkDevRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDevRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDevRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDevRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDevRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDevRequest parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevRequest parseFrom(k kVar) throws IOException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDevRequest parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDevRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDevRequestOrBuilder extends av {
        ByteString getBody();

        int getCmdid();

        int getCryptoAlgo();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean getLimitFlow();

        boolean getLimitFrequency();

        int getNetType();

        int getRetryCount();

        String getUrl();

        ByteString getUrlBytes();

        boolean hasBody();

        boolean hasCmdid();

        boolean hasCryptoAlgo();

        boolean hasLimitFlow();

        boolean hasLimitFrequency();

        boolean hasNetType();

        boolean hasRetryCount();

        boolean hasUrl();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDevResponse extends GeneratedMessageLite<IlinkDevResponse, Builder> implements IlinkDevResponseOrBuilder {
        public static final int BODY_FIELD_NUMBER = 1;
        private static final IlinkDevResponse DEFAULT_INSTANCE;
        private static volatile bg<IlinkDevResponse> PARSER;
        private int bitField0_;
        private ByteString body_ = ByteString.EMPTY;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDevResponse, Builder> implements IlinkDevResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((IlinkDevResponse) this.instance).clearBody();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevResponseOrBuilder
            public ByteString getBody() {
                return ((IlinkDevResponse) this.instance).getBody();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevResponseOrBuilder
            public boolean hasBody() {
                return ((IlinkDevResponse) this.instance).hasBody();
            }

            public Builder setBody(ByteString byteString) {
                copyOnWrite();
                ((IlinkDevResponse) this.instance).setBody(byteString);
                return this;
            }

            Builder() {
                super(IlinkDevResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDevResponse ilinkDevResponse = new IlinkDevResponse();
            DEFAULT_INSTANCE = ilinkDevResponse;
            GeneratedMessageLite.registerDefaultInstance(IlinkDevResponse.class, ilinkDevResponse);
        }

        IlinkDevResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -2;
            this.body_ = getDefaultInstance().getBody();
        }

        public static IlinkDevResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDevResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDevResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDevResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.body_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDevResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDevResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDevResponse.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevResponseOrBuilder
        public ByteString getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDevResponseOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDevResponse ilinkDevResponse) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDevResponse);
        }

        public static IlinkDevResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDevResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDevResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDevResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDevResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDevResponse parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDevResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDevResponse parseFrom(k kVar) throws IOException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDevResponse parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDevResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDevResponseOrBuilder extends av {
        ByteString getBody();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasBody();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDeviceInfo extends GeneratedMessageLite<IlinkDeviceInfo, Builder> implements IlinkDeviceInfoOrBuilder {
        private static final IlinkDeviceInfo DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 1;
        private static volatile bg<IlinkDeviceInfo> PARSER = null;
        public static final int SN_FIELD_NUMBER = 2;
        public static final int TOKEN_FIELD_NUMBER = 3;
        private int bitField0_;
        private String id_ = "";
        private String sn_ = "";
        private String token_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDeviceInfo, Builder> implements IlinkDeviceInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearId() {
                copyOnWrite();
                ((IlinkDeviceInfo) this.instance).clearId();
                return this;
            }

            public Builder clearSn() {
                copyOnWrite();
                ((IlinkDeviceInfo) this.instance).clearSn();
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((IlinkDeviceInfo) this.instance).clearToken();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
            public String getId() {
                return ((IlinkDeviceInfo) this.instance).getId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
            public ByteString getIdBytes() {
                return ((IlinkDeviceInfo) this.instance).getIdBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
            public String getSn() {
                return ((IlinkDeviceInfo) this.instance).getSn();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
            public ByteString getSnBytes() {
                return ((IlinkDeviceInfo) this.instance).getSnBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
            public String getToken() {
                return ((IlinkDeviceInfo) this.instance).getToken();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
            public ByteString getTokenBytes() {
                return ((IlinkDeviceInfo) this.instance).getTokenBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
            public boolean hasId() {
                return ((IlinkDeviceInfo) this.instance).hasId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
            public boolean hasSn() {
                return ((IlinkDeviceInfo) this.instance).hasSn();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
            public boolean hasToken() {
                return ((IlinkDeviceInfo) this.instance).hasToken();
            }

            public Builder setId(String str) {
                copyOnWrite();
                ((IlinkDeviceInfo) this.instance).setId(str);
                return this;
            }

            public Builder setIdBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceInfo) this.instance).setIdBytes(byteString);
                return this;
            }

            public Builder setSn(String str) {
                copyOnWrite();
                ((IlinkDeviceInfo) this.instance).setSn(str);
                return this;
            }

            public Builder setSnBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceInfo) this.instance).setSnBytes(byteString);
                return this;
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((IlinkDeviceInfo) this.instance).setToken(str);
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceInfo) this.instance).setTokenBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkDeviceInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDeviceInfo ilinkDeviceInfo = new IlinkDeviceInfo();
            DEFAULT_INSTANCE = ilinkDeviceInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkDeviceInfo.class, ilinkDeviceInfo);
        }

        IlinkDeviceInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.bitField0_ &= -2;
            this.id_ = getDefaultInstance().getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSn() {
            this.bitField0_ &= -3;
            this.sn_ = getDefaultInstance().getSn();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.bitField0_ &= -5;
            this.token_ = getDefaultInstance().getToken();
        }

        public static IlinkDeviceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDeviceInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDeviceInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDeviceInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.id_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.id_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSn(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.sn_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSnBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.sn_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.token_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.token_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDeviceInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002", new Object[]{"bitField0_", "id_", "sn_", "token_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDeviceInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDeviceInfo.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
        public String getId() {
            return this.id_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
        public ByteString getIdBytes() {
            return ByteString.copyFromUtf8(this.id_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
        public String getSn() {
            return this.sn_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
        public ByteString getSnBytes() {
            return ByteString.copyFromUtf8(this.sn_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
        public boolean hasId() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
        public boolean hasSn() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceInfoOrBuilder
        public boolean hasToken() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDeviceInfo ilinkDeviceInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDeviceInfo);
        }

        public static IlinkDeviceInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDeviceInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDeviceInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDeviceInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDeviceInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDeviceInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDeviceInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDeviceInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDeviceInfo parseFrom(k kVar) throws IOException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDeviceInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDeviceInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDeviceInfoOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getId();

        ByteString getIdBytes();

        String getSn();

        ByteString getSnBytes();

        String getToken();

        ByteString getTokenBytes();

        boolean hasId();

        boolean hasSn();

        boolean hasToken();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkDeviceParams extends GeneratedMessageLite<IlinkDeviceParams, Builder> implements IlinkDeviceParamsOrBuilder {
        private static final IlinkDeviceParams DEFAULT_INSTANCE;
        public static final int ILINK_PRODUCT_ID_FIELD_NUMBER = 1;
        private static volatile bg<IlinkDeviceParams> PARSER = null;
        public static final int SIGNATURE_FIELD_NUMBER = 2;
        public static final int SIGNATURE_TIMESTAMP_FIELD_NUMBER = 3;
        private int bitField0_;
        private int ilinkProductId_;
        private int signatureTimestamp_;
        private String signature_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDeviceParams, Builder> implements IlinkDeviceParamsOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearIlinkProductId() {
                copyOnWrite();
                ((IlinkDeviceParams) this.instance).clearIlinkProductId();
                return this;
            }

            public Builder clearSignature() {
                copyOnWrite();
                ((IlinkDeviceParams) this.instance).clearSignature();
                return this;
            }

            public Builder clearSignatureTimestamp() {
                copyOnWrite();
                ((IlinkDeviceParams) this.instance).clearSignatureTimestamp();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
            public int getIlinkProductId() {
                return ((IlinkDeviceParams) this.instance).getIlinkProductId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
            public String getSignature() {
                return ((IlinkDeviceParams) this.instance).getSignature();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
            public ByteString getSignatureBytes() {
                return ((IlinkDeviceParams) this.instance).getSignatureBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
            public int getSignatureTimestamp() {
                return ((IlinkDeviceParams) this.instance).getSignatureTimestamp();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
            public boolean hasIlinkProductId() {
                return ((IlinkDeviceParams) this.instance).hasIlinkProductId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
            public boolean hasSignature() {
                return ((IlinkDeviceParams) this.instance).hasSignature();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
            public boolean hasSignatureTimestamp() {
                return ((IlinkDeviceParams) this.instance).hasSignatureTimestamp();
            }

            public Builder setIlinkProductId(int i3) {
                copyOnWrite();
                ((IlinkDeviceParams) this.instance).setIlinkProductId(i3);
                return this;
            }

            public Builder setSignature(String str) {
                copyOnWrite();
                ((IlinkDeviceParams) this.instance).setSignature(str);
                return this;
            }

            public Builder setSignatureBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceParams) this.instance).setSignatureBytes(byteString);
                return this;
            }

            public Builder setSignatureTimestamp(int i3) {
                copyOnWrite();
                ((IlinkDeviceParams) this.instance).setSignatureTimestamp(i3);
                return this;
            }

            Builder() {
                super(IlinkDeviceParams.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDeviceParams ilinkDeviceParams = new IlinkDeviceParams();
            DEFAULT_INSTANCE = ilinkDeviceParams;
            GeneratedMessageLite.registerDefaultInstance(IlinkDeviceParams.class, ilinkDeviceParams);
        }

        IlinkDeviceParams() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkProductId() {
            this.bitField0_ &= -2;
            this.ilinkProductId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSignature() {
            this.bitField0_ &= -3;
            this.signature_ = getDefaultInstance().getSignature();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSignatureTimestamp() {
            this.bitField0_ &= -5;
            this.signatureTimestamp_ = 0;
        }

        public static IlinkDeviceParams getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDeviceParams parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDeviceParams parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDeviceParams> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkProductId(int i3) {
            this.bitField0_ |= 1;
            this.ilinkProductId_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSignature(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.signature_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSignatureBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.signature_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSignatureTimestamp(int i3) {
            this.bitField0_ |= 4;
            this.signatureTimestamp_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDeviceParams();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u000b\u0002", new Object[]{"bitField0_", "ilinkProductId_", "signature_", "signatureTimestamp_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDeviceParams> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDeviceParams.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
        public int getIlinkProductId() {
            return this.ilinkProductId_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
        public String getSignature() {
            return this.signature_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
        public ByteString getSignatureBytes() {
            return ByteString.copyFromUtf8(this.signature_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
        public int getSignatureTimestamp() {
            return this.signatureTimestamp_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
        public boolean hasIlinkProductId() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
        public boolean hasSignature() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkDeviceParamsOrBuilder
        public boolean hasSignatureTimestamp() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDeviceParams ilinkDeviceParams) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDeviceParams);
        }

        public static IlinkDeviceParams parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDeviceParams parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDeviceParams parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDeviceParams parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDeviceParams parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDeviceParams parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDeviceParams parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDeviceParams parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDeviceParams parseFrom(k kVar) throws IOException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDeviceParams parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDeviceParams) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkDeviceParamsOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getIlinkProductId();

        String getSignature();

        ByteString getSignatureBytes();

        int getSignatureTimestamp();

        boolean hasIlinkProductId();

        boolean hasSignature();

        boolean hasSignatureTimestamp();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class IlinkUploadLogInfo extends GeneratedMessageLite<IlinkUploadLogInfo, Builder> implements IlinkUploadLogInfoOrBuilder {
        public static final int CAPATH_FIELD_NUMBER = 5;
        private static final IlinkUploadLogInfo DEFAULT_INSTANCE;
        public static final int DEVICETYPE_FIELD_NUMBER = 8;
        public static final int EXTBUFFER_FIELD_NUMBER = 4;
        public static final int INCLUDEDEVLOG_FIELD_NUMBER = 3;
        public static final int LOGPATH_FIELD_NUMBER = 2;
        private static volatile bg<IlinkUploadLogInfo> PARSER = null;
        public static final int PRODUCTID_FIELD_NUMBER = 10;
        public static final int TOKEN_FIELD_NUMBER = 1;
        public static final int UIN_FIELD_NUMBER = 6;
        public static final int USERNAME_FIELD_NUMBER = 7;
        public static final int VERSION_FIELD_NUMBER = 9;
        private int bitField0_;
        private boolean includeDevLog_;
        private int productId_;
        private long uin_;
        private int version_;
        private String token_ = "";
        private ad.j<String> logPath_ = GeneratedMessageLite.emptyProtobufList();
        private String extBuffer_ = "";
        private String capath_ = "";
        private String username_ = "";
        private String deviceType_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkUploadLogInfo, Builder> implements IlinkUploadLogInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllLogPath(Iterable<String> iterable) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).addAllLogPath(iterable);
                return this;
            }

            public Builder addLogPath(String str) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).addLogPath(str);
                return this;
            }

            public Builder addLogPathBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).addLogPathBytes(byteString);
                return this;
            }

            public Builder clearCapath() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearCapath();
                return this;
            }

            public Builder clearDeviceType() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearDeviceType();
                return this;
            }

            public Builder clearExtBuffer() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearExtBuffer();
                return this;
            }

            public Builder clearIncludeDevLog() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearIncludeDevLog();
                return this;
            }

            public Builder clearLogPath() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearLogPath();
                return this;
            }

            public Builder clearProductId() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearProductId();
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearToken();
                return this;
            }

            public Builder clearUin() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearUin();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearUsername();
                return this;
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).clearVersion();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public String getCapath() {
                return ((IlinkUploadLogInfo) this.instance).getCapath();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public ByteString getCapathBytes() {
                return ((IlinkUploadLogInfo) this.instance).getCapathBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public String getDeviceType() {
                return ((IlinkUploadLogInfo) this.instance).getDeviceType();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public ByteString getDeviceTypeBytes() {
                return ((IlinkUploadLogInfo) this.instance).getDeviceTypeBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public String getExtBuffer() {
                return ((IlinkUploadLogInfo) this.instance).getExtBuffer();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public ByteString getExtBufferBytes() {
                return ((IlinkUploadLogInfo) this.instance).getExtBufferBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean getIncludeDevLog() {
                return ((IlinkUploadLogInfo) this.instance).getIncludeDevLog();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public String getLogPath(int i3) {
                return ((IlinkUploadLogInfo) this.instance).getLogPath(i3);
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public ByteString getLogPathBytes(int i3) {
                return ((IlinkUploadLogInfo) this.instance).getLogPathBytes(i3);
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public int getLogPathCount() {
                return ((IlinkUploadLogInfo) this.instance).getLogPathCount();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public List<String> getLogPathList() {
                return Collections.unmodifiableList(((IlinkUploadLogInfo) this.instance).getLogPathList());
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public int getProductId() {
                return ((IlinkUploadLogInfo) this.instance).getProductId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public String getToken() {
                return ((IlinkUploadLogInfo) this.instance).getToken();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public ByteString getTokenBytes() {
                return ((IlinkUploadLogInfo) this.instance).getTokenBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public long getUin() {
                return ((IlinkUploadLogInfo) this.instance).getUin();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public String getUsername() {
                return ((IlinkUploadLogInfo) this.instance).getUsername();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public ByteString getUsernameBytes() {
                return ((IlinkUploadLogInfo) this.instance).getUsernameBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public int getVersion() {
                return ((IlinkUploadLogInfo) this.instance).getVersion();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean hasCapath() {
                return ((IlinkUploadLogInfo) this.instance).hasCapath();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean hasDeviceType() {
                return ((IlinkUploadLogInfo) this.instance).hasDeviceType();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean hasExtBuffer() {
                return ((IlinkUploadLogInfo) this.instance).hasExtBuffer();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean hasIncludeDevLog() {
                return ((IlinkUploadLogInfo) this.instance).hasIncludeDevLog();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean hasProductId() {
                return ((IlinkUploadLogInfo) this.instance).hasProductId();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean hasToken() {
                return ((IlinkUploadLogInfo) this.instance).hasToken();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean hasUin() {
                return ((IlinkUploadLogInfo) this.instance).hasUin();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean hasUsername() {
                return ((IlinkUploadLogInfo) this.instance).hasUsername();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
            public boolean hasVersion() {
                return ((IlinkUploadLogInfo) this.instance).hasVersion();
            }

            public Builder setCapath(String str) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setCapath(str);
                return this;
            }

            public Builder setCapathBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setCapathBytes(byteString);
                return this;
            }

            public Builder setDeviceType(String str) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setDeviceType(str);
                return this;
            }

            public Builder setDeviceTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setDeviceTypeBytes(byteString);
                return this;
            }

            public Builder setExtBuffer(String str) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setExtBuffer(str);
                return this;
            }

            public Builder setExtBufferBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setExtBufferBytes(byteString);
                return this;
            }

            public Builder setIncludeDevLog(boolean z16) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setIncludeDevLog(z16);
                return this;
            }

            public Builder setLogPath(int i3, String str) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setLogPath(i3, str);
                return this;
            }

            public Builder setProductId(int i3) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setProductId(i3);
                return this;
            }

            public Builder setToken(String str) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setToken(str);
                return this;
            }

            public Builder setTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setTokenBytes(byteString);
                return this;
            }

            public Builder setUin(long j3) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setUin(j3);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setUsernameBytes(byteString);
                return this;
            }

            public Builder setVersion(int i3) {
                copyOnWrite();
                ((IlinkUploadLogInfo) this.instance).setVersion(i3);
                return this;
            }

            Builder() {
                super(IlinkUploadLogInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkUploadLogInfo ilinkUploadLogInfo = new IlinkUploadLogInfo();
            DEFAULT_INSTANCE = ilinkUploadLogInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkUploadLogInfo.class, ilinkUploadLogInfo);
        }

        IlinkUploadLogInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLogPath(Iterable<String> iterable) {
            ensureLogPathIsMutable();
            b.addAll((Iterable) iterable, (List) this.logPath_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLogPath(String str) {
            str.getClass();
            ensureLogPathIsMutable();
            this.logPath_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLogPathBytes(ByteString byteString) {
            byteString.getClass();
            ensureLogPathIsMutable();
            this.logPath_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCapath() {
            this.bitField0_ &= -9;
            this.capath_ = getDefaultInstance().getCapath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceType() {
            this.bitField0_ &= -65;
            this.deviceType_ = getDefaultInstance().getDeviceType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExtBuffer() {
            this.bitField0_ &= -5;
            this.extBuffer_ = getDefaultInstance().getExtBuffer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIncludeDevLog() {
            this.bitField0_ &= -3;
            this.includeDevLog_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLogPath() {
            this.logPath_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProductId() {
            this.bitField0_ &= -257;
            this.productId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.bitField0_ &= -2;
            this.token_ = getDefaultInstance().getToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUin() {
            this.bitField0_ &= -17;
            this.uin_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.bitField0_ &= -33;
            this.username_ = getDefaultInstance().getUsername();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -129;
            this.version_ = 0;
        }

        private void ensureLogPathIsMutable() {
            if (!this.logPath_.z()) {
                this.logPath_ = GeneratedMessageLite.mutableCopy(this.logPath_);
            }
        }

        public static IlinkUploadLogInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkUploadLogInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkUploadLogInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkUploadLogInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCapath(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.capath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCapathBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.capath_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceType(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.deviceType_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceTypeBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.deviceType_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtBuffer(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.extBuffer_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExtBufferBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.extBuffer_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIncludeDevLog(boolean z16) {
            this.bitField0_ |= 2;
            this.includeDevLog_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogPath(int i3, String str) {
            str.getClass();
            ensureLogPathIsMutable();
            this.logPath_.set(i3, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProductId(int i3) {
            this.bitField0_ |= 256;
            this.productId_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.token_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTokenBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.token_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUin(long j3) {
            this.bitField0_ |= 16;
            this.uin_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.username_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(int i3) {
            this.bitField0_ |= 128;
            this.version_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkUploadLogInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0001\u0000\u0001\b\u0000\u0002\u001a\u0003\u0007\u0001\u0004\b\u0002\u0005\b\u0003\u0006\u0003\u0004\u0007\b\u0005\b\b\u0006\t\u000b\u0007\n\u000b\b", new Object[]{"bitField0_", "token_", "logPath_", "includeDevLog_", "extBuffer_", "capath_", "uin_", "username_", "deviceType_", "version_", "productId_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkUploadLogInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkUploadLogInfo.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public String getCapath() {
            return this.capath_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public ByteString getCapathBytes() {
            return ByteString.copyFromUtf8(this.capath_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public String getDeviceType() {
            return this.deviceType_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public ByteString getDeviceTypeBytes() {
            return ByteString.copyFromUtf8(this.deviceType_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public String getExtBuffer() {
            return this.extBuffer_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public ByteString getExtBufferBytes() {
            return ByteString.copyFromUtf8(this.extBuffer_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean getIncludeDevLog() {
            return this.includeDevLog_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public String getLogPath(int i3) {
            return this.logPath_.get(i3);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public ByteString getLogPathBytes(int i3) {
            return ByteString.copyFromUtf8(this.logPath_.get(i3));
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public int getLogPathCount() {
            return this.logPath_.size();
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public List<String> getLogPathList() {
            return this.logPath_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public int getProductId() {
            return this.productId_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public long getUin() {
            return this.uin_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean hasCapath() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean hasDeviceType() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean hasExtBuffer() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean hasIncludeDevLog() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean hasProductId() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean hasToken() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean hasUin() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean hasUsername() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.IlinkUploadLogInfoOrBuilder
        public boolean hasVersion() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkUploadLogInfo ilinkUploadLogInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkUploadLogInfo);
        }

        public static IlinkUploadLogInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkUploadLogInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkUploadLogInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkUploadLogInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkUploadLogInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkUploadLogInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkUploadLogInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkUploadLogInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkUploadLogInfo parseFrom(k kVar) throws IOException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkUploadLogInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkUploadLogInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface IlinkUploadLogInfoOrBuilder extends av {
        String getCapath();

        ByteString getCapathBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getDeviceType();

        ByteString getDeviceTypeBytes();

        String getExtBuffer();

        ByteString getExtBufferBytes();

        boolean getIncludeDevLog();

        String getLogPath(int i3);

        ByteString getLogPathBytes(int i3);

        int getLogPathCount();

        List<String> getLogPathList();

        int getProductId();

        String getToken();

        ByteString getTokenBytes();

        long getUin();

        String getUsername();

        ByteString getUsernameBytes();

        int getVersion();

        boolean hasCapath();

        boolean hasDeviceType();

        boolean hasExtBuffer();

        boolean hasIncludeDevLog();

        boolean hasProductId();

        boolean hasToken();

        boolean hasUin();

        boolean hasUsername();

        boolean hasVersion();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum Network implements ad.c {
        LAN(0),
        ANY(1);

        public static final int ANY_VALUE = 1;
        public static final int LAN_VALUE = 0;
        private static final ad.d<Network> internalValueMap = new ad.d<Network>() { // from class: com.tencent.ilink.dev.proto.IlinkDevApi.Network.1
            @Override // com.google.protobuf.ad.d
            public Network findValueByNumber(int i3) {
                return Network.forNumber(i3);
            }
        };
        private final int value;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class NetworkVerifier implements ad.e {
            static final ad.e INSTANCE = new NetworkVerifier();

            NetworkVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (Network.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        Network(int i3) {
            this.value = i3;
        }

        public static Network forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return null;
                }
                return ANY;
            }
            return LAN;
        }

        public static ad.d<Network> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return NetworkVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static Network valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class StartConfig extends GeneratedMessageLite<StartConfig, Builder> implements StartConfigOrBuilder {
        public static final int DEBUG_IP_FIELD_NUMBER = 3;
        public static final int DEBUG_NET_FIELD_NUMBER = 2;
        private static final StartConfig DEFAULT_INSTANCE;
        public static final int FILE_DIR_FIELD_NUMBER = 1;
        private static volatile bg<StartConfig> PARSER = null;
        public static final int SELECT_DOMAIN_FIELD_NUMBER = 4;
        private int bitField0_;
        private int debugNet_;
        private int selectDomain_;
        private String fileDir_ = "";
        private String debugIp_ = "";

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<StartConfig, Builder> implements StartConfigOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDebugIp() {
                copyOnWrite();
                ((StartConfig) this.instance).clearDebugIp();
                return this;
            }

            public Builder clearDebugNet() {
                copyOnWrite();
                ((StartConfig) this.instance).clearDebugNet();
                return this;
            }

            public Builder clearFileDir() {
                copyOnWrite();
                ((StartConfig) this.instance).clearFileDir();
                return this;
            }

            public Builder clearSelectDomain() {
                copyOnWrite();
                ((StartConfig) this.instance).clearSelectDomain();
                return this;
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public String getDebugIp() {
                return ((StartConfig) this.instance).getDebugIp();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public ByteString getDebugIpBytes() {
                return ((StartConfig) this.instance).getDebugIpBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public int getDebugNet() {
                return ((StartConfig) this.instance).getDebugNet();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public String getFileDir() {
                return ((StartConfig) this.instance).getFileDir();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public ByteString getFileDirBytes() {
                return ((StartConfig) this.instance).getFileDirBytes();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public int getSelectDomain() {
                return ((StartConfig) this.instance).getSelectDomain();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public boolean hasDebugIp() {
                return ((StartConfig) this.instance).hasDebugIp();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public boolean hasDebugNet() {
                return ((StartConfig) this.instance).hasDebugNet();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public boolean hasFileDir() {
                return ((StartConfig) this.instance).hasFileDir();
            }

            @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
            public boolean hasSelectDomain() {
                return ((StartConfig) this.instance).hasSelectDomain();
            }

            public Builder setDebugIp(String str) {
                copyOnWrite();
                ((StartConfig) this.instance).setDebugIp(str);
                return this;
            }

            public Builder setDebugIpBytes(ByteString byteString) {
                copyOnWrite();
                ((StartConfig) this.instance).setDebugIpBytes(byteString);
                return this;
            }

            public Builder setDebugNet(int i3) {
                copyOnWrite();
                ((StartConfig) this.instance).setDebugNet(i3);
                return this;
            }

            public Builder setFileDir(String str) {
                copyOnWrite();
                ((StartConfig) this.instance).setFileDir(str);
                return this;
            }

            public Builder setFileDirBytes(ByteString byteString) {
                copyOnWrite();
                ((StartConfig) this.instance).setFileDirBytes(byteString);
                return this;
            }

            public Builder setSelectDomain(int i3) {
                copyOnWrite();
                ((StartConfig) this.instance).setSelectDomain(i3);
                return this;
            }

            Builder() {
                super(StartConfig.DEFAULT_INSTANCE);
            }
        }

        static {
            StartConfig startConfig = new StartConfig();
            DEFAULT_INSTANCE = startConfig;
            GeneratedMessageLite.registerDefaultInstance(StartConfig.class, startConfig);
        }

        StartConfig() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDebugIp() {
            this.bitField0_ &= -5;
            this.debugIp_ = getDefaultInstance().getDebugIp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDebugNet() {
            this.bitField0_ &= -3;
            this.debugNet_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileDir() {
            this.bitField0_ &= -2;
            this.fileDir_ = getDefaultInstance().getFileDir();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSelectDomain() {
            this.bitField0_ &= -9;
            this.selectDomain_ = 0;
        }

        public static StartConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static StartConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (StartConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<StartConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDebugIp(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.debugIp_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDebugIpBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.debugIp_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDebugNet(int i3) {
            this.bitField0_ |= 2;
            this.debugNet_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileDir(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.fileDir_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileDirBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.fileDir_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSelectDomain(int i3) {
            this.bitField0_ |= 8;
            this.selectDomain_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new StartConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\b\u0002\u0004\u000b\u0003", new Object[]{"bitField0_", "fileDir_", "debugNet_", "debugIp_", "selectDomain_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<StartConfig> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (StartConfig.class) {
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

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public String getDebugIp() {
            return this.debugIp_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public ByteString getDebugIpBytes() {
            return ByteString.copyFromUtf8(this.debugIp_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public int getDebugNet() {
            return this.debugNet_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public String getFileDir() {
            return this.fileDir_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public ByteString getFileDirBytes() {
            return ByteString.copyFromUtf8(this.fileDir_);
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public int getSelectDomain() {
            return this.selectDomain_;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public boolean hasDebugIp() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public boolean hasDebugNet() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public boolean hasFileDir() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.dev.proto.IlinkDevApi.StartConfigOrBuilder
        public boolean hasSelectDomain() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(StartConfig startConfig) {
            return DEFAULT_INSTANCE.createBuilder(startConfig);
        }

        public static StartConfig parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (StartConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static StartConfig parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static StartConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static StartConfig parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static StartConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static StartConfig parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static StartConfig parseFrom(InputStream inputStream) throws IOException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static StartConfig parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static StartConfig parseFrom(k kVar) throws IOException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static StartConfig parseFrom(k kVar, t tVar) throws IOException {
            return (StartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface StartConfigOrBuilder extends av {
        String getDebugIp();

        ByteString getDebugIpBytes();

        int getDebugNet();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getFileDir();

        ByteString getFileDirBytes();

        int getSelectDomain();

        boolean hasDebugIp();

        boolean hasDebugNet();

        boolean hasFileDir();

        boolean hasSelectDomain();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum enIlinkDevState implements ad.c {
        ILINK_DEV_ACCOUNT_LOGGED_OUT(0),
        ILINK_DEV_ACCOUNT_LOGGING_IN(1),
        ILINK_DEV_ACCOUNT_LOGGED_IN(2),
        ILINK_DEV_ACCOUNT_UNREGISTERED(3),
        ILINK_DEV_ACCOUNT_MANUAL_LOGOUT(4);

        public static final int ILINK_DEV_ACCOUNT_LOGGED_IN_VALUE = 2;
        public static final int ILINK_DEV_ACCOUNT_LOGGED_OUT_VALUE = 0;
        public static final int ILINK_DEV_ACCOUNT_LOGGING_IN_VALUE = 1;
        public static final int ILINK_DEV_ACCOUNT_MANUAL_LOGOUT_VALUE = 4;
        public static final int ILINK_DEV_ACCOUNT_UNREGISTERED_VALUE = 3;
        private static final ad.d<enIlinkDevState> internalValueMap = new ad.d<enIlinkDevState>() { // from class: com.tencent.ilink.dev.proto.IlinkDevApi.enIlinkDevState.1
            @Override // com.google.protobuf.ad.d
            public enIlinkDevState findValueByNumber(int i3) {
                return enIlinkDevState.forNumber(i3);
            }
        };
        private final int value;

        /* compiled from: P */
        /* loaded from: classes7.dex */
        public static final class enIlinkDevStateVerifier implements ad.e {
            static final ad.e INSTANCE = new enIlinkDevStateVerifier();

            enIlinkDevStateVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (enIlinkDevState.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        enIlinkDevState(int i3) {
            this.value = i3;
        }

        public static enIlinkDevState forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                return null;
                            }
                            return ILINK_DEV_ACCOUNT_MANUAL_LOGOUT;
                        }
                        return ILINK_DEV_ACCOUNT_UNREGISTERED;
                    }
                    return ILINK_DEV_ACCOUNT_LOGGED_IN;
                }
                return ILINK_DEV_ACCOUNT_LOGGING_IN;
            }
            return ILINK_DEV_ACCOUNT_LOGGED_OUT;
        }

        public static ad.d<enIlinkDevState> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return enIlinkDevStateVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static enIlinkDevState valueOf(int i3) {
            return forNumber(i3);
        }
    }

    IlinkDevApi() {
    }

    public static void registerAllExtensions(t tVar) {
    }
}
