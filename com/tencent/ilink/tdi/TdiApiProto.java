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
import com.tencent.ilink.tdi.TdiApiCommProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class TdiApiProto {

    /* renamed from: com.tencent.ilink.tdi.TdiApiProto$1, reason: invalid class name */
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
    public static final class TdiAppMessage extends GeneratedMessageLite<TdiAppMessage, Builder> implements TdiAppMessageOrBuilder {
        public static final int BODY_FIELD_NUMBER = 3;
        public static final int CREATE_TIME_FIELD_NUMBER = 2;
        private static final TdiAppMessage DEFAULT_INSTANCE;
        public static final int MSGID_FIELD_NUMBER = 1;
        private static volatile bg<TdiAppMessage> PARSER;
        private int bitField0_;
        private ByteString body_ = ByteString.EMPTY;
        private long createTime_;
        private long msgid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiAppMessage, Builder> implements TdiAppMessageOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((TdiAppMessage) this.instance).clearBody();
                return this;
            }

            public Builder clearCreateTime() {
                copyOnWrite();
                ((TdiAppMessage) this.instance).clearCreateTime();
                return this;
            }

            public Builder clearMsgid() {
                copyOnWrite();
                ((TdiAppMessage) this.instance).clearMsgid();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
            public ByteString getBody() {
                return ((TdiAppMessage) this.instance).getBody();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
            public long getCreateTime() {
                return ((TdiAppMessage) this.instance).getCreateTime();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
            public long getMsgid() {
                return ((TdiAppMessage) this.instance).getMsgid();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
            public boolean hasBody() {
                return ((TdiAppMessage) this.instance).hasBody();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
            public boolean hasCreateTime() {
                return ((TdiAppMessage) this.instance).hasCreateTime();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
            public boolean hasMsgid() {
                return ((TdiAppMessage) this.instance).hasMsgid();
            }

            public Builder setBody(ByteString byteString) {
                copyOnWrite();
                ((TdiAppMessage) this.instance).setBody(byteString);
                return this;
            }

            public Builder setCreateTime(long j3) {
                copyOnWrite();
                ((TdiAppMessage) this.instance).setCreateTime(j3);
                return this;
            }

            public Builder setMsgid(long j3) {
                copyOnWrite();
                ((TdiAppMessage) this.instance).setMsgid(j3);
                return this;
            }

            Builder() {
                super(TdiAppMessage.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiAppMessage tdiAppMessage = new TdiAppMessage();
            DEFAULT_INSTANCE = tdiAppMessage;
            GeneratedMessageLite.registerDefaultInstance(TdiAppMessage.class, tdiAppMessage);
        }

        TdiAppMessage() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -5;
            this.body_ = getDefaultInstance().getBody();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreateTime() {
            this.bitField0_ &= -3;
            this.createTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsgid() {
            this.bitField0_ &= -2;
            this.msgid_ = 0L;
        }

        public static TdiAppMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiAppMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiAppMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiAppMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiAppMessage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.body_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreateTime(long j3) {
            this.bitField0_ |= 2;
            this.createTime_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgid(long j3) {
            this.bitField0_ |= 1;
            this.msgid_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiAppMessage();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0003\u0000\u0002\u0003\u0001\u0003\n\u0002", new Object[]{"bitField0_", "msgid_", "createTime_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiAppMessage> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiAppMessage.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
        public ByteString getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
        public long getCreateTime() {
            return this.createTime_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
        public long getMsgid() {
            return this.msgid_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
        public boolean hasCreateTime() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppMessageOrBuilder
        public boolean hasMsgid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiAppMessage tdiAppMessage) {
            return DEFAULT_INSTANCE.createBuilder(tdiAppMessage);
        }

        public static TdiAppMessage parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiAppMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiAppMessage parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiAppMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiAppMessage parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiAppMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiAppMessage parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiAppMessage parseFrom(InputStream inputStream) throws IOException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiAppMessage parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiAppMessage parseFrom(k kVar) throws IOException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiAppMessage parseFrom(k kVar, t tVar) throws IOException {
            return (TdiAppMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiAppMessageOrBuilder extends av {
        ByteString getBody();

        long getCreateTime();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        long getMsgid();

        boolean hasBody();

        boolean hasCreateTime();

        boolean hasMsgid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiAppPushToken extends GeneratedMessageLite<TdiAppPushToken, Builder> implements TdiAppPushTokenOrBuilder {
        private static final TdiAppPushToken DEFAULT_INSTANCE;
        public static final int EXPIRE_TIMESTAMP_FIELD_NUMBER = 2;
        private static volatile bg<TdiAppPushToken> PARSER = null;
        public static final int TOKEN_FIELD_NUMBER = 1;
        private int bitField0_;
        private int expireTimestamp_;
        private ByteString token_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiAppPushToken, Builder> implements TdiAppPushTokenOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearExpireTimestamp() {
                copyOnWrite();
                ((TdiAppPushToken) this.instance).clearExpireTimestamp();
                return this;
            }

            public Builder clearToken() {
                copyOnWrite();
                ((TdiAppPushToken) this.instance).clearToken();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppPushTokenOrBuilder
            public int getExpireTimestamp() {
                return ((TdiAppPushToken) this.instance).getExpireTimestamp();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppPushTokenOrBuilder
            public ByteString getToken() {
                return ((TdiAppPushToken) this.instance).getToken();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppPushTokenOrBuilder
            public boolean hasExpireTimestamp() {
                return ((TdiAppPushToken) this.instance).hasExpireTimestamp();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppPushTokenOrBuilder
            public boolean hasToken() {
                return ((TdiAppPushToken) this.instance).hasToken();
            }

            public Builder setExpireTimestamp(int i3) {
                copyOnWrite();
                ((TdiAppPushToken) this.instance).setExpireTimestamp(i3);
                return this;
            }

            public Builder setToken(ByteString byteString) {
                copyOnWrite();
                ((TdiAppPushToken) this.instance).setToken(byteString);
                return this;
            }

            Builder() {
                super(TdiAppPushToken.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiAppPushToken tdiAppPushToken = new TdiAppPushToken();
            DEFAULT_INSTANCE = tdiAppPushToken;
            GeneratedMessageLite.registerDefaultInstance(TdiAppPushToken.class, tdiAppPushToken);
        }

        TdiAppPushToken() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExpireTimestamp() {
            this.bitField0_ &= -3;
            this.expireTimestamp_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToken() {
            this.bitField0_ &= -2;
            this.token_ = getDefaultInstance().getToken();
        }

        public static TdiAppPushToken getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiAppPushToken parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiAppPushToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiAppPushToken parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiAppPushToken> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExpireTimestamp(int i3) {
            this.bitField0_ |= 2;
            this.expireTimestamp_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToken(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.token_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiAppPushToken();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0000\u0002\u000b\u0001", new Object[]{"bitField0_", "token_", "expireTimestamp_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiAppPushToken> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiAppPushToken.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppPushTokenOrBuilder
        public int getExpireTimestamp() {
            return this.expireTimestamp_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppPushTokenOrBuilder
        public ByteString getToken() {
            return this.token_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppPushTokenOrBuilder
        public boolean hasExpireTimestamp() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppPushTokenOrBuilder
        public boolean hasToken() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiAppPushToken tdiAppPushToken) {
            return DEFAULT_INSTANCE.createBuilder(tdiAppPushToken);
        }

        public static TdiAppPushToken parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiAppPushToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiAppPushToken parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiAppPushToken parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiAppPushToken parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiAppPushToken parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiAppPushToken parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiAppPushToken parseFrom(InputStream inputStream) throws IOException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiAppPushToken parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiAppPushToken parseFrom(k kVar) throws IOException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiAppPushToken parseFrom(k kVar, t tVar) throws IOException {
            return (TdiAppPushToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiAppPushTokenOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getExpireTimestamp();

        ByteString getToken();

        boolean hasExpireTimestamp();

        boolean hasToken();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiAppRequest extends GeneratedMessageLite<TdiAppRequest, Builder> implements TdiAppRequestOrBuilder {
        public static final int BODY_FIELD_NUMBER = 5;
        public static final int CMDID_FIELD_NUMBER = 1;
        public static final int CRYPTO_ALGO_FIELD_NUMBER = 2;
        private static final TdiAppRequest DEFAULT_INSTANCE;
        public static final int LIMIT_FLOW_FIELD_NUMBER = 8;
        public static final int LIMIT_FREQUENCY_FIELD_NUMBER = 9;
        public static final int NET_TYPE_FIELD_NUMBER = 6;
        private static volatile bg<TdiAppRequest> PARSER = null;
        public static final int RETRY_COUNT_FIELD_NUMBER = 7;
        public static final int TIMEOUT_MS_FIELD_NUMBER = 3;
        public static final int URL_FIELD_NUMBER = 4;
        private int bitField0_;
        private int cmdid_;
        private boolean limitFlow_;
        private boolean limitFrequency_;
        private int retryCount_;
        private int timeoutMs_;
        private int cryptoAlgo_ = 1;
        private String url_ = "";
        private ByteString body_ = ByteString.EMPTY;
        private int netType_ = 1;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiAppRequest, Builder> implements TdiAppRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((TdiAppRequest) this.instance).clearBody();
                return this;
            }

            public Builder clearCmdid() {
                copyOnWrite();
                ((TdiAppRequest) this.instance).clearCmdid();
                return this;
            }

            public Builder clearCryptoAlgo() {
                copyOnWrite();
                ((TdiAppRequest) this.instance).clearCryptoAlgo();
                return this;
            }

            public Builder clearLimitFlow() {
                copyOnWrite();
                ((TdiAppRequest) this.instance).clearLimitFlow();
                return this;
            }

            public Builder clearLimitFrequency() {
                copyOnWrite();
                ((TdiAppRequest) this.instance).clearLimitFrequency();
                return this;
            }

            public Builder clearNetType() {
                copyOnWrite();
                ((TdiAppRequest) this.instance).clearNetType();
                return this;
            }

            public Builder clearRetryCount() {
                copyOnWrite();
                ((TdiAppRequest) this.instance).clearRetryCount();
                return this;
            }

            public Builder clearTimeoutMs() {
                copyOnWrite();
                ((TdiAppRequest) this.instance).clearTimeoutMs();
                return this;
            }

            public Builder clearUrl() {
                copyOnWrite();
                ((TdiAppRequest) this.instance).clearUrl();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public ByteString getBody() {
                return ((TdiAppRequest) this.instance).getBody();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public int getCmdid() {
                return ((TdiAppRequest) this.instance).getCmdid();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public TdiCryptoAlgo getCryptoAlgo() {
                return ((TdiAppRequest) this.instance).getCryptoAlgo();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean getLimitFlow() {
                return ((TdiAppRequest) this.instance).getLimitFlow();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean getLimitFrequency() {
                return ((TdiAppRequest) this.instance).getLimitFrequency();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public TdiNetType getNetType() {
                return ((TdiAppRequest) this.instance).getNetType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public int getRetryCount() {
                return ((TdiAppRequest) this.instance).getRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public int getTimeoutMs() {
                return ((TdiAppRequest) this.instance).getTimeoutMs();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public String getUrl() {
                return ((TdiAppRequest) this.instance).getUrl();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public ByteString getUrlBytes() {
                return ((TdiAppRequest) this.instance).getUrlBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean hasBody() {
                return ((TdiAppRequest) this.instance).hasBody();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean hasCmdid() {
                return ((TdiAppRequest) this.instance).hasCmdid();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean hasCryptoAlgo() {
                return ((TdiAppRequest) this.instance).hasCryptoAlgo();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean hasLimitFlow() {
                return ((TdiAppRequest) this.instance).hasLimitFlow();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean hasLimitFrequency() {
                return ((TdiAppRequest) this.instance).hasLimitFrequency();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean hasNetType() {
                return ((TdiAppRequest) this.instance).hasNetType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean hasRetryCount() {
                return ((TdiAppRequest) this.instance).hasRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean hasTimeoutMs() {
                return ((TdiAppRequest) this.instance).hasTimeoutMs();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
            public boolean hasUrl() {
                return ((TdiAppRequest) this.instance).hasUrl();
            }

            public Builder setBody(ByteString byteString) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setBody(byteString);
                return this;
            }

            public Builder setCmdid(int i3) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setCmdid(i3);
                return this;
            }

            public Builder setCryptoAlgo(TdiCryptoAlgo tdiCryptoAlgo) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setCryptoAlgo(tdiCryptoAlgo);
                return this;
            }

            public Builder setLimitFlow(boolean z16) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setLimitFlow(z16);
                return this;
            }

            public Builder setLimitFrequency(boolean z16) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setLimitFrequency(z16);
                return this;
            }

            public Builder setNetType(TdiNetType tdiNetType) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setNetType(tdiNetType);
                return this;
            }

            public Builder setRetryCount(int i3) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setRetryCount(i3);
                return this;
            }

            public Builder setTimeoutMs(int i3) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setTimeoutMs(i3);
                return this;
            }

            public Builder setUrl(String str) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setUrl(str);
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiAppRequest) this.instance).setUrlBytes(byteString);
                return this;
            }

            Builder() {
                super(TdiAppRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiAppRequest tdiAppRequest = new TdiAppRequest();
            DEFAULT_INSTANCE = tdiAppRequest;
            GeneratedMessageLite.registerDefaultInstance(TdiAppRequest.class, tdiAppRequest);
        }

        TdiAppRequest() {
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
            this.bitField0_ &= -3;
            this.cryptoAlgo_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimitFlow() {
            this.bitField0_ &= -129;
            this.limitFlow_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimitFrequency() {
            this.bitField0_ &= -257;
            this.limitFrequency_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetType() {
            this.bitField0_ &= -33;
            this.netType_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRetryCount() {
            this.bitField0_ &= -65;
            this.retryCount_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeoutMs() {
            this.bitField0_ &= -5;
            this.timeoutMs_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUrl() {
            this.bitField0_ &= -9;
            this.url_ = getDefaultInstance().getUrl();
        }

        public static TdiAppRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiAppRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiAppRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiAppRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiAppRequest> parser() {
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
        public void setCryptoAlgo(TdiCryptoAlgo tdiCryptoAlgo) {
            tdiCryptoAlgo.getClass();
            this.bitField0_ |= 2;
            this.cryptoAlgo_ = tdiCryptoAlgo.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimitFlow(boolean z16) {
            this.bitField0_ |= 128;
            this.limitFlow_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimitFrequency(boolean z16) {
            this.bitField0_ |= 256;
            this.limitFrequency_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetType(TdiNetType tdiNetType) {
            tdiNetType.getClass();
            this.bitField0_ |= 32;
            this.netType_ = tdiNetType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRetryCount(int i3) {
            this.bitField0_ |= 64;
            this.retryCount_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutMs(int i3) {
            this.bitField0_ |= 4;
            this.timeoutMs_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrl(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.url_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrlBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.url_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiAppRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0000\u0000\u0001\u000b\u0000\u0002\f\u0001\u0003\u000b\u0002\u0004\b\u0003\u0005\n\u0004\u0006\f\u0005\u0007\u000b\u0006\b\u0007\u0007\t\u0007\b", new Object[]{"bitField0_", "cmdid_", "cryptoAlgo_", TdiCryptoAlgo.internalGetVerifier(), "timeoutMs_", "url_", "body_", "netType_", TdiNetType.internalGetVerifier(), "retryCount_", "limitFlow_", "limitFrequency_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiAppRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiAppRequest.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public ByteString getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public int getCmdid() {
            return this.cmdid_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public TdiCryptoAlgo getCryptoAlgo() {
            TdiCryptoAlgo forNumber = TdiCryptoAlgo.forNumber(this.cryptoAlgo_);
            if (forNumber == null) {
                return TdiCryptoAlgo.kIlinkSession;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean getLimitFlow() {
            return this.limitFlow_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean getLimitFrequency() {
            return this.limitFrequency_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public TdiNetType getNetType() {
            TdiNetType forNumber = TdiNetType.forNumber(this.netType_);
            if (forNumber == null) {
                return TdiNetType.kIlinkLonglink;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public int getRetryCount() {
            return this.retryCount_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public int getTimeoutMs() {
            return this.timeoutMs_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public String getUrl() {
            return this.url_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public ByteString getUrlBytes() {
            return ByteString.copyFromUtf8(this.url_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean hasCmdid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean hasCryptoAlgo() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean hasLimitFlow() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean hasLimitFrequency() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean hasNetType() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean hasRetryCount() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean hasTimeoutMs() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppRequestOrBuilder
        public boolean hasUrl() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiAppRequest tdiAppRequest) {
            return DEFAULT_INSTANCE.createBuilder(tdiAppRequest);
        }

        public static TdiAppRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiAppRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiAppRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiAppRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiAppRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiAppRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiAppRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiAppRequest parseFrom(InputStream inputStream) throws IOException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiAppRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiAppRequest parseFrom(k kVar) throws IOException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiAppRequest parseFrom(k kVar, t tVar) throws IOException {
            return (TdiAppRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiAppRequestOrBuilder extends av {
        ByteString getBody();

        int getCmdid();

        TdiCryptoAlgo getCryptoAlgo();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean getLimitFlow();

        boolean getLimitFrequency();

        TdiNetType getNetType();

        int getRetryCount();

        int getTimeoutMs();

        String getUrl();

        ByteString getUrlBytes();

        boolean hasBody();

        boolean hasCmdid();

        boolean hasCryptoAlgo();

        boolean hasLimitFlow();

        boolean hasLimitFrequency();

        boolean hasNetType();

        boolean hasRetryCount();

        boolean hasTimeoutMs();

        boolean hasUrl();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiAppResponse extends GeneratedMessageLite<TdiAppResponse, Builder> implements TdiAppResponseOrBuilder {
        public static final int BODY_FIELD_NUMBER = 1;
        private static final TdiAppResponse DEFAULT_INSTANCE;
        private static volatile bg<TdiAppResponse> PARSER;
        private int bitField0_;
        private ByteString body_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiAppResponse, Builder> implements TdiAppResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((TdiAppResponse) this.instance).clearBody();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppResponseOrBuilder
            public ByteString getBody() {
                return ((TdiAppResponse) this.instance).getBody();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppResponseOrBuilder
            public boolean hasBody() {
                return ((TdiAppResponse) this.instance).hasBody();
            }

            public Builder setBody(ByteString byteString) {
                copyOnWrite();
                ((TdiAppResponse) this.instance).setBody(byteString);
                return this;
            }

            Builder() {
                super(TdiAppResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiAppResponse tdiAppResponse = new TdiAppResponse();
            DEFAULT_INSTANCE = tdiAppResponse;
            GeneratedMessageLite.registerDefaultInstance(TdiAppResponse.class, tdiAppResponse);
        }

        TdiAppResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -2;
            this.body_ = getDefaultInstance().getBody();
        }

        public static TdiAppResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiAppResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiAppResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiAppResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiAppResponse> parser() {
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
                    return new TdiAppResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiAppResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiAppResponse.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppResponseOrBuilder
        public ByteString getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiAppResponseOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiAppResponse tdiAppResponse) {
            return DEFAULT_INSTANCE.createBuilder(tdiAppResponse);
        }

        public static TdiAppResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiAppResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiAppResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiAppResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiAppResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiAppResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiAppResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiAppResponse parseFrom(InputStream inputStream) throws IOException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiAppResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiAppResponse parseFrom(k kVar) throws IOException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiAppResponse parseFrom(k kVar, t tVar) throws IOException {
            return (TdiAppResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiAppResponseOrBuilder extends av {
        ByteString getBody();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasBody();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiCancelOAuthRequest extends GeneratedMessageLite<TdiCancelOAuthRequest, Builder> implements TdiCancelOAuthRequestOrBuilder {
        private static final TdiCancelOAuthRequest DEFAULT_INSTANCE;
        public static final int ILINK_APPID_LIST_FIELD_NUMBER = 1;
        private static volatile bg<TdiCancelOAuthRequest> PARSER;
        private ad.j<String> ilinkAppidList_ = GeneratedMessageLite.emptyProtobufList();

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiCancelOAuthRequest, Builder> implements TdiCancelOAuthRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllIlinkAppidList(Iterable<String> iterable) {
                copyOnWrite();
                ((TdiCancelOAuthRequest) this.instance).addAllIlinkAppidList(iterable);
                return this;
            }

            public Builder addIlinkAppidList(String str) {
                copyOnWrite();
                ((TdiCancelOAuthRequest) this.instance).addIlinkAppidList(str);
                return this;
            }

            public Builder addIlinkAppidListBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiCancelOAuthRequest) this.instance).addIlinkAppidListBytes(byteString);
                return this;
            }

            public Builder clearIlinkAppidList() {
                copyOnWrite();
                ((TdiCancelOAuthRequest) this.instance).clearIlinkAppidList();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCancelOAuthRequestOrBuilder
            public String getIlinkAppidList(int i3) {
                return ((TdiCancelOAuthRequest) this.instance).getIlinkAppidList(i3);
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCancelOAuthRequestOrBuilder
            public ByteString getIlinkAppidListBytes(int i3) {
                return ((TdiCancelOAuthRequest) this.instance).getIlinkAppidListBytes(i3);
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCancelOAuthRequestOrBuilder
            public int getIlinkAppidListCount() {
                return ((TdiCancelOAuthRequest) this.instance).getIlinkAppidListCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCancelOAuthRequestOrBuilder
            public List<String> getIlinkAppidListList() {
                return Collections.unmodifiableList(((TdiCancelOAuthRequest) this.instance).getIlinkAppidListList());
            }

            public Builder setIlinkAppidList(int i3, String str) {
                copyOnWrite();
                ((TdiCancelOAuthRequest) this.instance).setIlinkAppidList(i3, str);
                return this;
            }

            Builder() {
                super(TdiCancelOAuthRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiCancelOAuthRequest tdiCancelOAuthRequest = new TdiCancelOAuthRequest();
            DEFAULT_INSTANCE = tdiCancelOAuthRequest;
            GeneratedMessageLite.registerDefaultInstance(TdiCancelOAuthRequest.class, tdiCancelOAuthRequest);
        }

        TdiCancelOAuthRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllIlinkAppidList(Iterable<String> iterable) {
            ensureIlinkAppidListIsMutable();
            b.addAll((Iterable) iterable, (List) this.ilinkAppidList_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIlinkAppidList(String str) {
            str.getClass();
            ensureIlinkAppidListIsMutable();
            this.ilinkAppidList_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIlinkAppidListBytes(ByteString byteString) {
            byteString.getClass();
            ensureIlinkAppidListIsMutable();
            this.ilinkAppidList_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkAppidList() {
            this.ilinkAppidList_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureIlinkAppidListIsMutable() {
            if (!this.ilinkAppidList_.z()) {
                this.ilinkAppidList_ = GeneratedMessageLite.mutableCopy(this.ilinkAppidList_);
            }
        }

        public static TdiCancelOAuthRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiCancelOAuthRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiCancelOAuthRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiCancelOAuthRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkAppidList(int i3, String str) {
            str.getClass();
            ensureIlinkAppidListIsMutable();
            this.ilinkAppidList_.set(i3, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiCancelOAuthRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"ilinkAppidList_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiCancelOAuthRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiCancelOAuthRequest.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCancelOAuthRequestOrBuilder
        public String getIlinkAppidList(int i3) {
            return this.ilinkAppidList_.get(i3);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCancelOAuthRequestOrBuilder
        public ByteString getIlinkAppidListBytes(int i3) {
            return ByteString.copyFromUtf8(this.ilinkAppidList_.get(i3));
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCancelOAuthRequestOrBuilder
        public int getIlinkAppidListCount() {
            return this.ilinkAppidList_.size();
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCancelOAuthRequestOrBuilder
        public List<String> getIlinkAppidListList() {
            return this.ilinkAppidList_;
        }

        public static Builder newBuilder(TdiCancelOAuthRequest tdiCancelOAuthRequest) {
            return DEFAULT_INSTANCE.createBuilder(tdiCancelOAuthRequest);
        }

        public static TdiCancelOAuthRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiCancelOAuthRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiCancelOAuthRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiCancelOAuthRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiCancelOAuthRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiCancelOAuthRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiCancelOAuthRequest parseFrom(InputStream inputStream) throws IOException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiCancelOAuthRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiCancelOAuthRequest parseFrom(k kVar) throws IOException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiCancelOAuthRequest parseFrom(k kVar, t tVar) throws IOException {
            return (TdiCancelOAuthRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiCancelOAuthRequestOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getIlinkAppidList(int i3);

        ByteString getIlinkAppidListBytes(int i3);

        int getIlinkAppidListCount();

        List<String> getIlinkAppidListList();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum TdiCancelType implements ad.c {
        kTdiCancelUnknown(-1),
        kTdiCancelAll(0),
        kTdiCancelFaceRecognizeConfig(1),
        kTdiCancelFaceRecognize(2),
        kTdiCancelFaceExtVerify(3),
        kTdiCancelFaceLogin(4),
        kTdiCancelGetLoginQrCode(5),
        kTdiCancelCheckLoginQrCode(6),
        kTdiCancelQrCodeLogin(7),
        kTdiCancelAutoLogin(8),
        kTdiCancelLogout(9),
        kTdiCancelGetAppPushToken(10),
        kTdiCancelOAuthLogin(11),
        kTdiCancelThirdAppLogin(12),
        kTdiCancelVisitorLogin(13),
        kTdiCancelPalmLogin(14);

        private static final ad.d<TdiCancelType> internalValueMap = new ad.d<TdiCancelType>() { // from class: com.tencent.ilink.tdi.TdiApiProto.TdiCancelType.1
            @Override // com.google.protobuf.ad.d
            public TdiCancelType findValueByNumber(int i3) {
                return TdiCancelType.forNumber(i3);
            }
        };
        public static final int kTdiCancelAll_VALUE = 0;
        public static final int kTdiCancelAutoLogin_VALUE = 8;
        public static final int kTdiCancelCheckLoginQrCode_VALUE = 6;
        public static final int kTdiCancelFaceExtVerify_VALUE = 3;
        public static final int kTdiCancelFaceLogin_VALUE = 4;
        public static final int kTdiCancelFaceRecognizeConfig_VALUE = 1;
        public static final int kTdiCancelFaceRecognize_VALUE = 2;
        public static final int kTdiCancelGetAppPushToken_VALUE = 10;
        public static final int kTdiCancelGetLoginQrCode_VALUE = 5;
        public static final int kTdiCancelLogout_VALUE = 9;
        public static final int kTdiCancelOAuthLogin_VALUE = 11;
        public static final int kTdiCancelPalmLogin_VALUE = 14;
        public static final int kTdiCancelQrCodeLogin_VALUE = 7;
        public static final int kTdiCancelThirdAppLogin_VALUE = 12;
        public static final int kTdiCancelUnknown_VALUE = -1;
        public static final int kTdiCancelVisitorLogin_VALUE = 13;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class TdiCancelTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new TdiCancelTypeVerifier();

            TdiCancelTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (TdiCancelType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        TdiCancelType(int i3) {
            this.value = i3;
        }

        public static TdiCancelType forNumber(int i3) {
            switch (i3) {
                case -1:
                    return kTdiCancelUnknown;
                case 0:
                    return kTdiCancelAll;
                case 1:
                    return kTdiCancelFaceRecognizeConfig;
                case 2:
                    return kTdiCancelFaceRecognize;
                case 3:
                    return kTdiCancelFaceExtVerify;
                case 4:
                    return kTdiCancelFaceLogin;
                case 5:
                    return kTdiCancelGetLoginQrCode;
                case 6:
                    return kTdiCancelCheckLoginQrCode;
                case 7:
                    return kTdiCancelQrCodeLogin;
                case 8:
                    return kTdiCancelAutoLogin;
                case 9:
                    return kTdiCancelLogout;
                case 10:
                    return kTdiCancelGetAppPushToken;
                case 11:
                    return kTdiCancelOAuthLogin;
                case 12:
                    return kTdiCancelThirdAppLogin;
                case 13:
                    return kTdiCancelVisitorLogin;
                case 14:
                    return kTdiCancelPalmLogin;
                default:
                    return null;
            }
        }

        public static ad.d<TdiCancelType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return TdiCancelTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TdiCancelType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class TdiCheckLoginQrCodeResponse extends GeneratedMessageLite<TdiCheckLoginQrCodeResponse, Builder> implements TdiCheckLoginQrCodeResponseOrBuilder {
        public static final int AVATAR_URL_FIELD_NUMBER = 4;
        public static final int BUSINESS_CONFIRM_RESP_BUFFER_FIELD_NUMBER = 5;
        private static final TdiCheckLoginQrCodeResponse DEFAULT_INSTANCE;
        public static final int NICKNAME_FIELD_NUMBER = 3;
        private static volatile bg<TdiCheckLoginQrCodeResponse> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 1;
        public static final int UIN_FIELD_NUMBER = 2;
        private int bitField0_;
        private int status_;
        private long uin_;
        private String nickname_ = "";
        private String avatarUrl_ = "";
        private ByteString businessConfirmRespBuffer_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiCheckLoginQrCodeResponse, Builder> implements TdiCheckLoginQrCodeResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAvatarUrl() {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).clearAvatarUrl();
                return this;
            }

            public Builder clearBusinessConfirmRespBuffer() {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).clearBusinessConfirmRespBuffer();
                return this;
            }

            public Builder clearNickname() {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).clearNickname();
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).clearStatus();
                return this;
            }

            public Builder clearUin() {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).clearUin();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public String getAvatarUrl() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).getAvatarUrl();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public ByteString getAvatarUrlBytes() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).getAvatarUrlBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public ByteString getBusinessConfirmRespBuffer() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).getBusinessConfirmRespBuffer();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public String getNickname() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).getNickname();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public ByteString getNicknameBytes() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).getNicknameBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public TdiApiCommProto.LoginQrCodeStatus getStatus() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).getStatus();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public long getUin() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).getUin();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public boolean hasAvatarUrl() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).hasAvatarUrl();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public boolean hasBusinessConfirmRespBuffer() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).hasBusinessConfirmRespBuffer();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public boolean hasNickname() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).hasNickname();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public boolean hasStatus() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).hasStatus();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
            public boolean hasUin() {
                return ((TdiCheckLoginQrCodeResponse) this.instance).hasUin();
            }

            public Builder setAvatarUrl(String str) {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).setAvatarUrl(str);
                return this;
            }

            public Builder setAvatarUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).setAvatarUrlBytes(byteString);
                return this;
            }

            public Builder setBusinessConfirmRespBuffer(ByteString byteString) {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).setBusinessConfirmRespBuffer(byteString);
                return this;
            }

            public Builder setNickname(String str) {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).setNickname(str);
                return this;
            }

            public Builder setNicknameBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).setNicknameBytes(byteString);
                return this;
            }

            public Builder setStatus(TdiApiCommProto.LoginQrCodeStatus loginQrCodeStatus) {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).setStatus(loginQrCodeStatus);
                return this;
            }

            public Builder setUin(long j3) {
                copyOnWrite();
                ((TdiCheckLoginQrCodeResponse) this.instance).setUin(j3);
                return this;
            }

            Builder() {
                super(TdiCheckLoginQrCodeResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiCheckLoginQrCodeResponse tdiCheckLoginQrCodeResponse = new TdiCheckLoginQrCodeResponse();
            DEFAULT_INSTANCE = tdiCheckLoginQrCodeResponse;
            GeneratedMessageLite.registerDefaultInstance(TdiCheckLoginQrCodeResponse.class, tdiCheckLoginQrCodeResponse);
        }

        TdiCheckLoginQrCodeResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAvatarUrl() {
            this.bitField0_ &= -9;
            this.avatarUrl_ = getDefaultInstance().getAvatarUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBusinessConfirmRespBuffer() {
            this.bitField0_ &= -17;
            this.businessConfirmRespBuffer_ = getDefaultInstance().getBusinessConfirmRespBuffer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNickname() {
            this.bitField0_ &= -5;
            this.nickname_ = getDefaultInstance().getNickname();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStatus() {
            this.bitField0_ &= -2;
            this.status_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUin() {
            this.bitField0_ &= -3;
            this.uin_ = 0L;
        }

        public static TdiCheckLoginQrCodeResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiCheckLoginQrCodeResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiCheckLoginQrCodeResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAvatarUrl(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.avatarUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAvatarUrlBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.avatarUrl_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBusinessConfirmRespBuffer(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.businessConfirmRespBuffer_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNickname(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.nickname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNicknameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.nickname_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatus(TdiApiCommProto.LoginQrCodeStatus loginQrCodeStatus) {
            loginQrCodeStatus.getClass();
            this.bitField0_ |= 1;
            this.status_ = loginQrCodeStatus.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUin(long j3) {
            this.bitField0_ |= 2;
            this.uin_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiCheckLoginQrCodeResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0003\u0001\u0003\b\u0002\u0004\b\u0003\u0005\n\u0004", new Object[]{"bitField0_", "status_", TdiApiCommProto.LoginQrCodeStatus.internalGetVerifier(), "uin_", "nickname_", "avatarUrl_", "businessConfirmRespBuffer_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiCheckLoginQrCodeResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiCheckLoginQrCodeResponse.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public String getAvatarUrl() {
            return this.avatarUrl_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public ByteString getAvatarUrlBytes() {
            return ByteString.copyFromUtf8(this.avatarUrl_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public ByteString getBusinessConfirmRespBuffer() {
            return this.businessConfirmRespBuffer_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public String getNickname() {
            return this.nickname_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public ByteString getNicknameBytes() {
            return ByteString.copyFromUtf8(this.nickname_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public TdiApiCommProto.LoginQrCodeStatus getStatus() {
            TdiApiCommProto.LoginQrCodeStatus forNumber = TdiApiCommProto.LoginQrCodeStatus.forNumber(this.status_);
            if (forNumber == null) {
                return TdiApiCommProto.LoginQrCodeStatus.kLoginQrCodeStatus_NoScan;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public long getUin() {
            return this.uin_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public boolean hasAvatarUrl() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public boolean hasBusinessConfirmRespBuffer() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public boolean hasNickname() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public boolean hasStatus() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiCheckLoginQrCodeResponseOrBuilder
        public boolean hasUin() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiCheckLoginQrCodeResponse tdiCheckLoginQrCodeResponse) {
            return DEFAULT_INSTANCE.createBuilder(tdiCheckLoginQrCodeResponse);
        }

        public static TdiCheckLoginQrCodeResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(InputStream inputStream) throws IOException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(k kVar) throws IOException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiCheckLoginQrCodeResponse parseFrom(k kVar, t tVar) throws IOException {
            return (TdiCheckLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiCheckLoginQrCodeResponseOrBuilder extends av {
        String getAvatarUrl();

        ByteString getAvatarUrlBytes();

        ByteString getBusinessConfirmRespBuffer();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getNickname();

        ByteString getNicknameBytes();

        TdiApiCommProto.LoginQrCodeStatus getStatus();

        long getUin();

        boolean hasAvatarUrl();

        boolean hasBusinessConfirmRespBuffer();

        boolean hasNickname();

        boolean hasStatus();

        boolean hasUin();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum TdiCryptoAlgo implements ad.c {
        kIlinkNoCrypto(0),
        kIlinkSession(1),
        kIlinkHybridEcdh(2),
        kIlinkEcdh(3);

        private static final ad.d<TdiCryptoAlgo> internalValueMap = new ad.d<TdiCryptoAlgo>() { // from class: com.tencent.ilink.tdi.TdiApiProto.TdiCryptoAlgo.1
            @Override // com.google.protobuf.ad.d
            public TdiCryptoAlgo findValueByNumber(int i3) {
                return TdiCryptoAlgo.forNumber(i3);
            }
        };
        public static final int kIlinkEcdh_VALUE = 3;
        public static final int kIlinkHybridEcdh_VALUE = 2;
        public static final int kIlinkNoCrypto_VALUE = 0;
        public static final int kIlinkSession_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class TdiCryptoAlgoVerifier implements ad.e {
            static final ad.e INSTANCE = new TdiCryptoAlgoVerifier();

            TdiCryptoAlgoVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (TdiCryptoAlgo.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        TdiCryptoAlgo(int i3) {
            this.value = i3;
        }

        public static TdiCryptoAlgo forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            return null;
                        }
                        return kIlinkEcdh;
                    }
                    return kIlinkHybridEcdh;
                }
                return kIlinkSession;
            }
            return kIlinkNoCrypto;
        }

        public static ad.d<TdiCryptoAlgo> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return TdiCryptoAlgoVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TdiCryptoAlgo valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class TdiEchoRequest extends GeneratedMessageLite<TdiEchoRequest, Builder> implements TdiEchoRequestOrBuilder {
        public static final int BODY_FIELD_NUMBER = 1;
        private static final TdiEchoRequest DEFAULT_INSTANCE;
        private static volatile bg<TdiEchoRequest> PARSER;
        private int bitField0_;
        private String body_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiEchoRequest, Builder> implements TdiEchoRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((TdiEchoRequest) this.instance).clearBody();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoRequestOrBuilder
            public String getBody() {
                return ((TdiEchoRequest) this.instance).getBody();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoRequestOrBuilder
            public ByteString getBodyBytes() {
                return ((TdiEchoRequest) this.instance).getBodyBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoRequestOrBuilder
            public boolean hasBody() {
                return ((TdiEchoRequest) this.instance).hasBody();
            }

            public Builder setBody(String str) {
                copyOnWrite();
                ((TdiEchoRequest) this.instance).setBody(str);
                return this;
            }

            public Builder setBodyBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiEchoRequest) this.instance).setBodyBytes(byteString);
                return this;
            }

            Builder() {
                super(TdiEchoRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiEchoRequest tdiEchoRequest = new TdiEchoRequest();
            DEFAULT_INSTANCE = tdiEchoRequest;
            GeneratedMessageLite.registerDefaultInstance(TdiEchoRequest.class, tdiEchoRequest);
        }

        TdiEchoRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -2;
            this.body_ = getDefaultInstance().getBody();
        }

        public static TdiEchoRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiEchoRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiEchoRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiEchoRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiEchoRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.body_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBodyBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.body_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiEchoRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiEchoRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiEchoRequest.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoRequestOrBuilder
        public String getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoRequestOrBuilder
        public ByteString getBodyBytes() {
            return ByteString.copyFromUtf8(this.body_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoRequestOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiEchoRequest tdiEchoRequest) {
            return DEFAULT_INSTANCE.createBuilder(tdiEchoRequest);
        }

        public static TdiEchoRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiEchoRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiEchoRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiEchoRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiEchoRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiEchoRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiEchoRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiEchoRequest parseFrom(InputStream inputStream) throws IOException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiEchoRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiEchoRequest parseFrom(k kVar) throws IOException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiEchoRequest parseFrom(k kVar, t tVar) throws IOException {
            return (TdiEchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiEchoRequestOrBuilder extends av {
        String getBody();

        ByteString getBodyBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasBody();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiEchoResponse extends GeneratedMessageLite<TdiEchoResponse, Builder> implements TdiEchoResponseOrBuilder {
        public static final int BODY_FIELD_NUMBER = 1;
        private static final TdiEchoResponse DEFAULT_INSTANCE;
        private static volatile bg<TdiEchoResponse> PARSER;
        private int bitField0_;
        private String body_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiEchoResponse, Builder> implements TdiEchoResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((TdiEchoResponse) this.instance).clearBody();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoResponseOrBuilder
            public String getBody() {
                return ((TdiEchoResponse) this.instance).getBody();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoResponseOrBuilder
            public ByteString getBodyBytes() {
                return ((TdiEchoResponse) this.instance).getBodyBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoResponseOrBuilder
            public boolean hasBody() {
                return ((TdiEchoResponse) this.instance).hasBody();
            }

            public Builder setBody(String str) {
                copyOnWrite();
                ((TdiEchoResponse) this.instance).setBody(str);
                return this;
            }

            public Builder setBodyBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiEchoResponse) this.instance).setBodyBytes(byteString);
                return this;
            }

            Builder() {
                super(TdiEchoResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiEchoResponse tdiEchoResponse = new TdiEchoResponse();
            DEFAULT_INSTANCE = tdiEchoResponse;
            GeneratedMessageLite.registerDefaultInstance(TdiEchoResponse.class, tdiEchoResponse);
        }

        TdiEchoResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -2;
            this.body_ = getDefaultInstance().getBody();
        }

        public static TdiEchoResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiEchoResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiEchoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiEchoResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiEchoResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.body_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBodyBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.body_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiEchoResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiEchoResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiEchoResponse.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoResponseOrBuilder
        public String getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoResponseOrBuilder
        public ByteString getBodyBytes() {
            return ByteString.copyFromUtf8(this.body_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiEchoResponseOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiEchoResponse tdiEchoResponse) {
            return DEFAULT_INSTANCE.createBuilder(tdiEchoResponse);
        }

        public static TdiEchoResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiEchoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiEchoResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiEchoResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiEchoResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiEchoResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiEchoResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiEchoResponse parseFrom(InputStream inputStream) throws IOException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiEchoResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiEchoResponse parseFrom(k kVar) throws IOException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiEchoResponse parseFrom(k kVar, t tVar) throws IOException {
            return (TdiEchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiEchoResponseOrBuilder extends av {
        String getBody();

        ByteString getBodyBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasBody();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiFaceExtVerifyRequest extends GeneratedMessageLite<TdiFaceExtVerifyRequest, Builder> implements TdiFaceExtVerifyRequestOrBuilder {
        public static final int BUSINESS_REQ_FIELD_NUMBER = 4;
        public static final int BUSINESS_TYPE_FIELD_NUMBER = 3;
        private static final TdiFaceExtVerifyRequest DEFAULT_INSTANCE;
        private static volatile bg<TdiFaceExtVerifyRequest> PARSER = null;
        public static final int RETRY_COUNT_FIELD_NUMBER = 5;
        public static final int TIMEOUT_MS_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 2;
        private int bitField0_;
        private int retryCount_;
        private int timeoutMs_;
        private int type_ = 1;
        private int businessType_ = -1;
        private ByteString businessReq_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiFaceExtVerifyRequest, Builder> implements TdiFaceExtVerifyRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBusinessReq() {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).clearBusinessReq();
                return this;
            }

            public Builder clearBusinessType() {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).clearBusinessType();
                return this;
            }

            public Builder clearRetryCount() {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).clearRetryCount();
                return this;
            }

            public Builder clearTimeoutMs() {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).clearTimeoutMs();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).clearType();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public ByteString getBusinessReq() {
                return ((TdiFaceExtVerifyRequest) this.instance).getBusinessReq();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public TdiApiCommProto.BusinessType getBusinessType() {
                return ((TdiFaceExtVerifyRequest) this.instance).getBusinessType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public int getRetryCount() {
                return ((TdiFaceExtVerifyRequest) this.instance).getRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public int getTimeoutMs() {
                return ((TdiFaceExtVerifyRequest) this.instance).getTimeoutMs();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public TdiApiCommProto.FaceExtVerifyType getType() {
                return ((TdiFaceExtVerifyRequest) this.instance).getType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public boolean hasBusinessReq() {
                return ((TdiFaceExtVerifyRequest) this.instance).hasBusinessReq();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public boolean hasBusinessType() {
                return ((TdiFaceExtVerifyRequest) this.instance).hasBusinessType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public boolean hasRetryCount() {
                return ((TdiFaceExtVerifyRequest) this.instance).hasRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public boolean hasTimeoutMs() {
                return ((TdiFaceExtVerifyRequest) this.instance).hasTimeoutMs();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
            public boolean hasType() {
                return ((TdiFaceExtVerifyRequest) this.instance).hasType();
            }

            public Builder setBusinessReq(ByteString byteString) {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).setBusinessReq(byteString);
                return this;
            }

            public Builder setBusinessType(TdiApiCommProto.BusinessType businessType) {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).setBusinessType(businessType);
                return this;
            }

            public Builder setRetryCount(int i3) {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).setRetryCount(i3);
                return this;
            }

            public Builder setTimeoutMs(int i3) {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).setTimeoutMs(i3);
                return this;
            }

            public Builder setType(TdiApiCommProto.FaceExtVerifyType faceExtVerifyType) {
                copyOnWrite();
                ((TdiFaceExtVerifyRequest) this.instance).setType(faceExtVerifyType);
                return this;
            }

            Builder() {
                super(TdiFaceExtVerifyRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiFaceExtVerifyRequest tdiFaceExtVerifyRequest = new TdiFaceExtVerifyRequest();
            DEFAULT_INSTANCE = tdiFaceExtVerifyRequest;
            GeneratedMessageLite.registerDefaultInstance(TdiFaceExtVerifyRequest.class, tdiFaceExtVerifyRequest);
        }

        TdiFaceExtVerifyRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBusinessReq() {
            this.bitField0_ &= -9;
            this.businessReq_ = getDefaultInstance().getBusinessReq();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBusinessType() {
            this.bitField0_ &= -5;
            this.businessType_ = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRetryCount() {
            this.bitField0_ &= -17;
            this.retryCount_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeoutMs() {
            this.bitField0_ &= -2;
            this.timeoutMs_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -3;
            this.type_ = 1;
        }

        public static TdiFaceExtVerifyRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiFaceExtVerifyRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceExtVerifyRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiFaceExtVerifyRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBusinessReq(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.businessReq_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBusinessType(TdiApiCommProto.BusinessType businessType) {
            businessType.getClass();
            this.bitField0_ |= 4;
            this.businessType_ = businessType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRetryCount(int i3) {
            this.bitField0_ |= 16;
            this.retryCount_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutMs(int i3) {
            this.bitField0_ |= 1;
            this.timeoutMs_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(TdiApiCommProto.FaceExtVerifyType faceExtVerifyType) {
            faceExtVerifyType.getClass();
            this.bitField0_ |= 2;
            this.type_ = faceExtVerifyType.getNumber();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiFaceExtVerifyRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u000b\u0000\u0002\f\u0001\u0003\f\u0002\u0004\n\u0003\u0005\u0004\u0004", new Object[]{"bitField0_", "timeoutMs_", "type_", TdiApiCommProto.FaceExtVerifyType.internalGetVerifier(), "businessType_", TdiApiCommProto.BusinessType.internalGetVerifier(), "businessReq_", "retryCount_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiFaceExtVerifyRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiFaceExtVerifyRequest.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public ByteString getBusinessReq() {
            return this.businessReq_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public TdiApiCommProto.BusinessType getBusinessType() {
            TdiApiCommProto.BusinessType forNumber = TdiApiCommProto.BusinessType.forNumber(this.businessType_);
            if (forNumber == null) {
                return TdiApiCommProto.BusinessType.kBusinessTypeUnknown;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public int getRetryCount() {
            return this.retryCount_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public int getTimeoutMs() {
            return this.timeoutMs_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public TdiApiCommProto.FaceExtVerifyType getType() {
            TdiApiCommProto.FaceExtVerifyType forNumber = TdiApiCommProto.FaceExtVerifyType.forNumber(this.type_);
            if (forNumber == null) {
                return TdiApiCommProto.FaceExtVerifyType.kFaceExtVerifyType_WxBase_4PhoneNum;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public boolean hasBusinessReq() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public boolean hasBusinessType() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public boolean hasRetryCount() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public boolean hasTimeoutMs() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyRequestOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiFaceExtVerifyRequest tdiFaceExtVerifyRequest) {
            return DEFAULT_INSTANCE.createBuilder(tdiFaceExtVerifyRequest);
        }

        public static TdiFaceExtVerifyRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceExtVerifyRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiFaceExtVerifyRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiFaceExtVerifyRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiFaceExtVerifyRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiFaceExtVerifyRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiFaceExtVerifyRequest parseFrom(InputStream inputStream) throws IOException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceExtVerifyRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceExtVerifyRequest parseFrom(k kVar) throws IOException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiFaceExtVerifyRequest parseFrom(k kVar, t tVar) throws IOException {
            return (TdiFaceExtVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiFaceExtVerifyRequestOrBuilder extends av {
        ByteString getBusinessReq();

        TdiApiCommProto.BusinessType getBusinessType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getRetryCount();

        int getTimeoutMs();

        TdiApiCommProto.FaceExtVerifyType getType();

        boolean hasBusinessReq();

        boolean hasBusinessType();

        boolean hasRetryCount();

        boolean hasTimeoutMs();

        boolean hasType();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiFaceExtVerifyResponse extends GeneratedMessageLite<TdiFaceExtVerifyResponse, Builder> implements TdiFaceExtVerifyResponseOrBuilder {
        public static final int BUSINESS_RESP_FIELD_NUMBER = 3;
        private static final TdiFaceExtVerifyResponse DEFAULT_INSTANCE;
        private static volatile bg<TdiFaceExtVerifyResponse> PARSER = null;
        public static final int PASS_TYPE_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int bitField0_;
        private int passType_;
        private int type_ = 1;
        private ByteString businessResp_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiFaceExtVerifyResponse, Builder> implements TdiFaceExtVerifyResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBusinessResp() {
                copyOnWrite();
                ((TdiFaceExtVerifyResponse) this.instance).clearBusinessResp();
                return this;
            }

            public Builder clearPassType() {
                copyOnWrite();
                ((TdiFaceExtVerifyResponse) this.instance).clearPassType();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((TdiFaceExtVerifyResponse) this.instance).clearType();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
            public ByteString getBusinessResp() {
                return ((TdiFaceExtVerifyResponse) this.instance).getBusinessResp();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
            public TdiApiCommProto.FaceRecognizeResType getPassType() {
                return ((TdiFaceExtVerifyResponse) this.instance).getPassType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
            public TdiApiCommProto.FaceExtVerifyType getType() {
                return ((TdiFaceExtVerifyResponse) this.instance).getType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
            public boolean hasBusinessResp() {
                return ((TdiFaceExtVerifyResponse) this.instance).hasBusinessResp();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
            public boolean hasPassType() {
                return ((TdiFaceExtVerifyResponse) this.instance).hasPassType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
            public boolean hasType() {
                return ((TdiFaceExtVerifyResponse) this.instance).hasType();
            }

            public Builder setBusinessResp(ByteString byteString) {
                copyOnWrite();
                ((TdiFaceExtVerifyResponse) this.instance).setBusinessResp(byteString);
                return this;
            }

            public Builder setPassType(TdiApiCommProto.FaceRecognizeResType faceRecognizeResType) {
                copyOnWrite();
                ((TdiFaceExtVerifyResponse) this.instance).setPassType(faceRecognizeResType);
                return this;
            }

            public Builder setType(TdiApiCommProto.FaceExtVerifyType faceExtVerifyType) {
                copyOnWrite();
                ((TdiFaceExtVerifyResponse) this.instance).setType(faceExtVerifyType);
                return this;
            }

            Builder() {
                super(TdiFaceExtVerifyResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiFaceExtVerifyResponse tdiFaceExtVerifyResponse = new TdiFaceExtVerifyResponse();
            DEFAULT_INSTANCE = tdiFaceExtVerifyResponse;
            GeneratedMessageLite.registerDefaultInstance(TdiFaceExtVerifyResponse.class, tdiFaceExtVerifyResponse);
        }

        TdiFaceExtVerifyResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBusinessResp() {
            this.bitField0_ &= -5;
            this.businessResp_ = getDefaultInstance().getBusinessResp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPassType() {
            this.bitField0_ &= -3;
            this.passType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -2;
            this.type_ = 1;
        }

        public static TdiFaceExtVerifyResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiFaceExtVerifyResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceExtVerifyResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiFaceExtVerifyResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBusinessResp(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.businessResp_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPassType(TdiApiCommProto.FaceRecognizeResType faceRecognizeResType) {
            faceRecognizeResType.getClass();
            this.bitField0_ |= 2;
            this.passType_ = faceRecognizeResType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(TdiApiCommProto.FaceExtVerifyType faceExtVerifyType) {
            faceExtVerifyType.getClass();
            this.bitField0_ |= 1;
            this.type_ = faceExtVerifyType.getNumber();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiFaceExtVerifyResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\f\u0001\u0003\n\u0002", new Object[]{"bitField0_", "type_", TdiApiCommProto.FaceExtVerifyType.internalGetVerifier(), "passType_", TdiApiCommProto.FaceRecognizeResType.internalGetVerifier(), "businessResp_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiFaceExtVerifyResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiFaceExtVerifyResponse.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
        public ByteString getBusinessResp() {
            return this.businessResp_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
        public TdiApiCommProto.FaceRecognizeResType getPassType() {
            TdiApiCommProto.FaceRecognizeResType forNumber = TdiApiCommProto.FaceRecognizeResType.forNumber(this.passType_);
            if (forNumber == null) {
                return TdiApiCommProto.FaceRecognizeResType.kFaceRecognizeTypeRes_Non;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
        public TdiApiCommProto.FaceExtVerifyType getType() {
            TdiApiCommProto.FaceExtVerifyType forNumber = TdiApiCommProto.FaceExtVerifyType.forNumber(this.type_);
            if (forNumber == null) {
                return TdiApiCommProto.FaceExtVerifyType.kFaceExtVerifyType_WxBase_4PhoneNum;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
        public boolean hasBusinessResp() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
        public boolean hasPassType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceExtVerifyResponseOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiFaceExtVerifyResponse tdiFaceExtVerifyResponse) {
            return DEFAULT_INSTANCE.createBuilder(tdiFaceExtVerifyResponse);
        }

        public static TdiFaceExtVerifyResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceExtVerifyResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiFaceExtVerifyResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiFaceExtVerifyResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiFaceExtVerifyResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiFaceExtVerifyResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiFaceExtVerifyResponse parseFrom(InputStream inputStream) throws IOException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceExtVerifyResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceExtVerifyResponse parseFrom(k kVar) throws IOException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiFaceExtVerifyResponse parseFrom(k kVar, t tVar) throws IOException {
            return (TdiFaceExtVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiFaceExtVerifyResponseOrBuilder extends av {
        ByteString getBusinessResp();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        TdiApiCommProto.FaceRecognizeResType getPassType();

        TdiApiCommProto.FaceExtVerifyType getType();

        boolean hasBusinessResp();

        boolean hasPassType();

        boolean hasType();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiFaceRecognizeConfigRequest extends GeneratedMessageLite<TdiFaceRecognizeConfigRequest, Builder> implements TdiFaceRecognizeConfigRequestOrBuilder {
        private static final TdiFaceRecognizeConfigRequest DEFAULT_INSTANCE;
        public static final int ENV_DATA_FIELD_NUMBER = 3;
        private static volatile bg<TdiFaceRecognizeConfigRequest> PARSER = null;
        public static final int RECO_TYPE_FIELD_NUMBER = 2;
        public static final int RETRY_COUNT_FIELD_NUMBER = 4;
        public static final int TIMEOUT_MS_FIELD_NUMBER = 1;
        private int bitField0_;
        private int retryCount_;
        private int timeoutMs_;
        private int recoType_ = 1;
        private ByteString envData_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiFaceRecognizeConfigRequest, Builder> implements TdiFaceRecognizeConfigRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearEnvData() {
                copyOnWrite();
                ((TdiFaceRecognizeConfigRequest) this.instance).clearEnvData();
                return this;
            }

            public Builder clearRecoType() {
                copyOnWrite();
                ((TdiFaceRecognizeConfigRequest) this.instance).clearRecoType();
                return this;
            }

            public Builder clearRetryCount() {
                copyOnWrite();
                ((TdiFaceRecognizeConfigRequest) this.instance).clearRetryCount();
                return this;
            }

            public Builder clearTimeoutMs() {
                copyOnWrite();
                ((TdiFaceRecognizeConfigRequest) this.instance).clearTimeoutMs();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
            public ByteString getEnvData() {
                return ((TdiFaceRecognizeConfigRequest) this.instance).getEnvData();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
            public TdiApiCommProto.FaceRecognizeType getRecoType() {
                return ((TdiFaceRecognizeConfigRequest) this.instance).getRecoType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
            public int getRetryCount() {
                return ((TdiFaceRecognizeConfigRequest) this.instance).getRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
            public int getTimeoutMs() {
                return ((TdiFaceRecognizeConfigRequest) this.instance).getTimeoutMs();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
            public boolean hasEnvData() {
                return ((TdiFaceRecognizeConfigRequest) this.instance).hasEnvData();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
            public boolean hasRecoType() {
                return ((TdiFaceRecognizeConfigRequest) this.instance).hasRecoType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
            public boolean hasRetryCount() {
                return ((TdiFaceRecognizeConfigRequest) this.instance).hasRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
            public boolean hasTimeoutMs() {
                return ((TdiFaceRecognizeConfigRequest) this.instance).hasTimeoutMs();
            }

            public Builder setEnvData(ByteString byteString) {
                copyOnWrite();
                ((TdiFaceRecognizeConfigRequest) this.instance).setEnvData(byteString);
                return this;
            }

            public Builder setRecoType(TdiApiCommProto.FaceRecognizeType faceRecognizeType) {
                copyOnWrite();
                ((TdiFaceRecognizeConfigRequest) this.instance).setRecoType(faceRecognizeType);
                return this;
            }

            public Builder setRetryCount(int i3) {
                copyOnWrite();
                ((TdiFaceRecognizeConfigRequest) this.instance).setRetryCount(i3);
                return this;
            }

            public Builder setTimeoutMs(int i3) {
                copyOnWrite();
                ((TdiFaceRecognizeConfigRequest) this.instance).setTimeoutMs(i3);
                return this;
            }

            Builder() {
                super(TdiFaceRecognizeConfigRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiFaceRecognizeConfigRequest tdiFaceRecognizeConfigRequest = new TdiFaceRecognizeConfigRequest();
            DEFAULT_INSTANCE = tdiFaceRecognizeConfigRequest;
            GeneratedMessageLite.registerDefaultInstance(TdiFaceRecognizeConfigRequest.class, tdiFaceRecognizeConfigRequest);
        }

        TdiFaceRecognizeConfigRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnvData() {
            this.bitField0_ &= -5;
            this.envData_ = getDefaultInstance().getEnvData();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecoType() {
            this.bitField0_ &= -3;
            this.recoType_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRetryCount() {
            this.bitField0_ &= -9;
            this.retryCount_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeoutMs() {
            this.bitField0_ &= -2;
            this.timeoutMs_ = 0;
        }

        public static TdiFaceRecognizeConfigRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiFaceRecognizeConfigRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiFaceRecognizeConfigRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnvData(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.envData_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecoType(TdiApiCommProto.FaceRecognizeType faceRecognizeType) {
            faceRecognizeType.getClass();
            this.bitField0_ |= 2;
            this.recoType_ = faceRecognizeType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRetryCount(int i3) {
            this.bitField0_ |= 8;
            this.retryCount_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutMs(int i3) {
            this.bitField0_ |= 1;
            this.timeoutMs_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiFaceRecognizeConfigRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0000\u0002\f\u0001\u0003\n\u0002\u0004\u0004\u0003", new Object[]{"bitField0_", "timeoutMs_", "recoType_", TdiApiCommProto.FaceRecognizeType.internalGetVerifier(), "envData_", "retryCount_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiFaceRecognizeConfigRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiFaceRecognizeConfigRequest.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
        public ByteString getEnvData() {
            return this.envData_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
        public TdiApiCommProto.FaceRecognizeType getRecoType() {
            TdiApiCommProto.FaceRecognizeType forNumber = TdiApiCommProto.FaceRecognizeType.forNumber(this.recoType_);
            if (forNumber == null) {
                return TdiApiCommProto.FaceRecognizeType.kFaceRecognizeType_WxPayOnly;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
        public int getRetryCount() {
            return this.retryCount_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
        public int getTimeoutMs() {
            return this.timeoutMs_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
        public boolean hasEnvData() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
        public boolean hasRecoType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
        public boolean hasRetryCount() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigRequestOrBuilder
        public boolean hasTimeoutMs() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiFaceRecognizeConfigRequest tdiFaceRecognizeConfigRequest) {
            return DEFAULT_INSTANCE.createBuilder(tdiFaceRecognizeConfigRequest);
        }

        public static TdiFaceRecognizeConfigRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(InputStream inputStream) throws IOException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(k kVar) throws IOException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiFaceRecognizeConfigRequest parseFrom(k kVar, t tVar) throws IOException {
            return (TdiFaceRecognizeConfigRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiFaceRecognizeConfigRequestOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getEnvData();

        TdiApiCommProto.FaceRecognizeType getRecoType();

        int getRetryCount();

        int getTimeoutMs();

        boolean hasEnvData();

        boolean hasRecoType();

        boolean hasRetryCount();

        boolean hasTimeoutMs();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiFaceRecognizeConfigResponse extends GeneratedMessageLite<TdiFaceRecognizeConfigResponse, Builder> implements TdiFaceRecognizeConfigResponseOrBuilder {
        public static final int CONFIG_DATA_FIELD_NUMBER = 1;
        private static final TdiFaceRecognizeConfigResponse DEFAULT_INSTANCE;
        private static volatile bg<TdiFaceRecognizeConfigResponse> PARSER;
        private int bitField0_;
        private ByteString configData_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiFaceRecognizeConfigResponse, Builder> implements TdiFaceRecognizeConfigResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearConfigData() {
                copyOnWrite();
                ((TdiFaceRecognizeConfigResponse) this.instance).clearConfigData();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigResponseOrBuilder
            public ByteString getConfigData() {
                return ((TdiFaceRecognizeConfigResponse) this.instance).getConfigData();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigResponseOrBuilder
            public boolean hasConfigData() {
                return ((TdiFaceRecognizeConfigResponse) this.instance).hasConfigData();
            }

            public Builder setConfigData(ByteString byteString) {
                copyOnWrite();
                ((TdiFaceRecognizeConfigResponse) this.instance).setConfigData(byteString);
                return this;
            }

            Builder() {
                super(TdiFaceRecognizeConfigResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiFaceRecognizeConfigResponse tdiFaceRecognizeConfigResponse = new TdiFaceRecognizeConfigResponse();
            DEFAULT_INSTANCE = tdiFaceRecognizeConfigResponse;
            GeneratedMessageLite.registerDefaultInstance(TdiFaceRecognizeConfigResponse.class, tdiFaceRecognizeConfigResponse);
        }

        TdiFaceRecognizeConfigResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConfigData() {
            this.bitField0_ &= -2;
            this.configData_ = getDefaultInstance().getConfigData();
        }

        public static TdiFaceRecognizeConfigResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiFaceRecognizeConfigResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiFaceRecognizeConfigResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConfigData(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.configData_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiFaceRecognizeConfigResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "configData_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiFaceRecognizeConfigResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiFaceRecognizeConfigResponse.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigResponseOrBuilder
        public ByteString getConfigData() {
            return this.configData_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeConfigResponseOrBuilder
        public boolean hasConfigData() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiFaceRecognizeConfigResponse tdiFaceRecognizeConfigResponse) {
            return DEFAULT_INSTANCE.createBuilder(tdiFaceRecognizeConfigResponse);
        }

        public static TdiFaceRecognizeConfigResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(InputStream inputStream) throws IOException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(k kVar) throws IOException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiFaceRecognizeConfigResponse parseFrom(k kVar, t tVar) throws IOException {
            return (TdiFaceRecognizeConfigResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiFaceRecognizeConfigResponseOrBuilder extends av {
        ByteString getConfigData();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasConfigData();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiFaceRecognizeRequest extends GeneratedMessageLite<TdiFaceRecognizeRequest, Builder> implements TdiFaceRecognizeRequestOrBuilder {
        public static final int DATA_TYPE_FIELD_NUMBER = 3;
        private static final TdiFaceRecognizeRequest DEFAULT_INSTANCE;
        public static final int FACE_DATA_FIELD_NUMBER = 4;
        private static volatile bg<TdiFaceRecognizeRequest> PARSER = null;
        public static final int RECG_TYPE_FIELD_NUMBER = 2;
        public static final int RETRY_COUNT_FIELD_NUMBER = 7;
        public static final int TIMEOUT_MS_FIELD_NUMBER = 1;
        public static final int WXBASE_REQ_FIELD_NUMBER = 5;
        public static final int WXPAY_REQ_FIELD_NUMBER = 6;
        private int bitField0_;
        private ByteString faceData_;
        private int retryCount_;
        private int timeoutMs_;
        private ByteString wxbaseReq_;
        private ByteString wxpayReq_;
        private int recgType_ = 1;
        private int dataType_ = 1;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiFaceRecognizeRequest, Builder> implements TdiFaceRecognizeRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).clearDataType();
                return this;
            }

            public Builder clearFaceData() {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).clearFaceData();
                return this;
            }

            public Builder clearRecgType() {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).clearRecgType();
                return this;
            }

            public Builder clearRetryCount() {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).clearRetryCount();
                return this;
            }

            public Builder clearTimeoutMs() {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).clearTimeoutMs();
                return this;
            }

            public Builder clearWxbaseReq() {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).clearWxbaseReq();
                return this;
            }

            public Builder clearWxpayReq() {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).clearWxpayReq();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public TdiApiCommProto.FaceDataType getDataType() {
                return ((TdiFaceRecognizeRequest) this.instance).getDataType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public ByteString getFaceData() {
                return ((TdiFaceRecognizeRequest) this.instance).getFaceData();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public TdiApiCommProto.FaceRecognizeType getRecgType() {
                return ((TdiFaceRecognizeRequest) this.instance).getRecgType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public int getRetryCount() {
                return ((TdiFaceRecognizeRequest) this.instance).getRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public int getTimeoutMs() {
                return ((TdiFaceRecognizeRequest) this.instance).getTimeoutMs();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public ByteString getWxbaseReq() {
                return ((TdiFaceRecognizeRequest) this.instance).getWxbaseReq();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public ByteString getWxpayReq() {
                return ((TdiFaceRecognizeRequest) this.instance).getWxpayReq();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public boolean hasDataType() {
                return ((TdiFaceRecognizeRequest) this.instance).hasDataType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public boolean hasFaceData() {
                return ((TdiFaceRecognizeRequest) this.instance).hasFaceData();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public boolean hasRecgType() {
                return ((TdiFaceRecognizeRequest) this.instance).hasRecgType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public boolean hasRetryCount() {
                return ((TdiFaceRecognizeRequest) this.instance).hasRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public boolean hasTimeoutMs() {
                return ((TdiFaceRecognizeRequest) this.instance).hasTimeoutMs();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public boolean hasWxbaseReq() {
                return ((TdiFaceRecognizeRequest) this.instance).hasWxbaseReq();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
            public boolean hasWxpayReq() {
                return ((TdiFaceRecognizeRequest) this.instance).hasWxpayReq();
            }

            public Builder setDataType(TdiApiCommProto.FaceDataType faceDataType) {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).setDataType(faceDataType);
                return this;
            }

            public Builder setFaceData(ByteString byteString) {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).setFaceData(byteString);
                return this;
            }

            public Builder setRecgType(TdiApiCommProto.FaceRecognizeType faceRecognizeType) {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).setRecgType(faceRecognizeType);
                return this;
            }

            public Builder setRetryCount(int i3) {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).setRetryCount(i3);
                return this;
            }

            public Builder setTimeoutMs(int i3) {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).setTimeoutMs(i3);
                return this;
            }

            public Builder setWxbaseReq(ByteString byteString) {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).setWxbaseReq(byteString);
                return this;
            }

            public Builder setWxpayReq(ByteString byteString) {
                copyOnWrite();
                ((TdiFaceRecognizeRequest) this.instance).setWxpayReq(byteString);
                return this;
            }

            Builder() {
                super(TdiFaceRecognizeRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiFaceRecognizeRequest tdiFaceRecognizeRequest = new TdiFaceRecognizeRequest();
            DEFAULT_INSTANCE = tdiFaceRecognizeRequest;
            GeneratedMessageLite.registerDefaultInstance(TdiFaceRecognizeRequest.class, tdiFaceRecognizeRequest);
        }

        TdiFaceRecognizeRequest() {
            ByteString byteString = ByteString.EMPTY;
            this.faceData_ = byteString;
            this.wxbaseReq_ = byteString;
            this.wxpayReq_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataType() {
            this.bitField0_ &= -5;
            this.dataType_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFaceData() {
            this.bitField0_ &= -9;
            this.faceData_ = getDefaultInstance().getFaceData();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecgType() {
            this.bitField0_ &= -3;
            this.recgType_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRetryCount() {
            this.bitField0_ &= -65;
            this.retryCount_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeoutMs() {
            this.bitField0_ &= -2;
            this.timeoutMs_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWxbaseReq() {
            this.bitField0_ &= -17;
            this.wxbaseReq_ = getDefaultInstance().getWxbaseReq();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWxpayReq() {
            this.bitField0_ &= -33;
            this.wxpayReq_ = getDefaultInstance().getWxpayReq();
        }

        public static TdiFaceRecognizeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiFaceRecognizeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceRecognizeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiFaceRecognizeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(TdiApiCommProto.FaceDataType faceDataType) {
            faceDataType.getClass();
            this.bitField0_ |= 4;
            this.dataType_ = faceDataType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFaceData(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.faceData_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecgType(TdiApiCommProto.FaceRecognizeType faceRecognizeType) {
            faceRecognizeType.getClass();
            this.bitField0_ |= 2;
            this.recgType_ = faceRecognizeType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRetryCount(int i3) {
            this.bitField0_ |= 64;
            this.retryCount_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutMs(int i3) {
            this.bitField0_ |= 1;
            this.timeoutMs_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWxbaseReq(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.wxbaseReq_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWxpayReq(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.wxpayReq_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiFaceRecognizeRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u000b\u0000\u0002\f\u0001\u0003\f\u0002\u0004\n\u0003\u0005\n\u0004\u0006\n\u0005\u0007\u0004\u0006", new Object[]{"bitField0_", "timeoutMs_", "recgType_", TdiApiCommProto.FaceRecognizeType.internalGetVerifier(), "dataType_", TdiApiCommProto.FaceDataType.internalGetVerifier(), "faceData_", "wxbaseReq_", "wxpayReq_", "retryCount_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiFaceRecognizeRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiFaceRecognizeRequest.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public TdiApiCommProto.FaceDataType getDataType() {
            TdiApiCommProto.FaceDataType forNumber = TdiApiCommProto.FaceDataType.forNumber(this.dataType_);
            if (forNumber == null) {
                return TdiApiCommProto.FaceDataType.kFaceDataType_3D;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public ByteString getFaceData() {
            return this.faceData_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public TdiApiCommProto.FaceRecognizeType getRecgType() {
            TdiApiCommProto.FaceRecognizeType forNumber = TdiApiCommProto.FaceRecognizeType.forNumber(this.recgType_);
            if (forNumber == null) {
                return TdiApiCommProto.FaceRecognizeType.kFaceRecognizeType_WxPayOnly;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public int getRetryCount() {
            return this.retryCount_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public int getTimeoutMs() {
            return this.timeoutMs_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public ByteString getWxbaseReq() {
            return this.wxbaseReq_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public ByteString getWxpayReq() {
            return this.wxpayReq_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public boolean hasDataType() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public boolean hasFaceData() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public boolean hasRecgType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public boolean hasRetryCount() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public boolean hasTimeoutMs() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public boolean hasWxbaseReq() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeRequestOrBuilder
        public boolean hasWxpayReq() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiFaceRecognizeRequest tdiFaceRecognizeRequest) {
            return DEFAULT_INSTANCE.createBuilder(tdiFaceRecognizeRequest);
        }

        public static TdiFaceRecognizeRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceRecognizeRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiFaceRecognizeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiFaceRecognizeRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiFaceRecognizeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiFaceRecognizeRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiFaceRecognizeRequest parseFrom(InputStream inputStream) throws IOException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceRecognizeRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceRecognizeRequest parseFrom(k kVar) throws IOException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiFaceRecognizeRequest parseFrom(k kVar, t tVar) throws IOException {
            return (TdiFaceRecognizeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiFaceRecognizeRequestOrBuilder extends av {
        TdiApiCommProto.FaceDataType getDataType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getFaceData();

        TdiApiCommProto.FaceRecognizeType getRecgType();

        int getRetryCount();

        int getTimeoutMs();

        ByteString getWxbaseReq();

        ByteString getWxpayReq();

        boolean hasDataType();

        boolean hasFaceData();

        boolean hasRecgType();

        boolean hasRetryCount();

        boolean hasTimeoutMs();

        boolean hasWxbaseReq();

        boolean hasWxpayReq();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiFaceRecognizeResponse extends GeneratedMessageLite<TdiFaceRecognizeResponse, Builder> implements TdiFaceRecognizeResponseOrBuilder {
        private static final TdiFaceRecognizeResponse DEFAULT_INSTANCE;
        private static volatile bg<TdiFaceRecognizeResponse> PARSER = null;
        public static final int PASS_TYPE_FIELD_NUMBER = 3;
        public static final int WXBASE_RESP_FIELD_NUMBER = 1;
        public static final int WXPAY_RESP_FIELD_NUMBER = 2;
        private int bitField0_;
        private int passType_;
        private ByteString wxbaseResp_;
        private ByteString wxpayResp_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiFaceRecognizeResponse, Builder> implements TdiFaceRecognizeResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearPassType() {
                copyOnWrite();
                ((TdiFaceRecognizeResponse) this.instance).clearPassType();
                return this;
            }

            public Builder clearWxbaseResp() {
                copyOnWrite();
                ((TdiFaceRecognizeResponse) this.instance).clearWxbaseResp();
                return this;
            }

            public Builder clearWxpayResp() {
                copyOnWrite();
                ((TdiFaceRecognizeResponse) this.instance).clearWxpayResp();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
            public TdiApiCommProto.FaceRecognizeResType getPassType() {
                return ((TdiFaceRecognizeResponse) this.instance).getPassType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
            public ByteString getWxbaseResp() {
                return ((TdiFaceRecognizeResponse) this.instance).getWxbaseResp();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
            public ByteString getWxpayResp() {
                return ((TdiFaceRecognizeResponse) this.instance).getWxpayResp();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
            public boolean hasPassType() {
                return ((TdiFaceRecognizeResponse) this.instance).hasPassType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
            public boolean hasWxbaseResp() {
                return ((TdiFaceRecognizeResponse) this.instance).hasWxbaseResp();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
            public boolean hasWxpayResp() {
                return ((TdiFaceRecognizeResponse) this.instance).hasWxpayResp();
            }

            public Builder setPassType(TdiApiCommProto.FaceRecognizeResType faceRecognizeResType) {
                copyOnWrite();
                ((TdiFaceRecognizeResponse) this.instance).setPassType(faceRecognizeResType);
                return this;
            }

            public Builder setWxbaseResp(ByteString byteString) {
                copyOnWrite();
                ((TdiFaceRecognizeResponse) this.instance).setWxbaseResp(byteString);
                return this;
            }

            public Builder setWxpayResp(ByteString byteString) {
                copyOnWrite();
                ((TdiFaceRecognizeResponse) this.instance).setWxpayResp(byteString);
                return this;
            }

            Builder() {
                super(TdiFaceRecognizeResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiFaceRecognizeResponse tdiFaceRecognizeResponse = new TdiFaceRecognizeResponse();
            DEFAULT_INSTANCE = tdiFaceRecognizeResponse;
            GeneratedMessageLite.registerDefaultInstance(TdiFaceRecognizeResponse.class, tdiFaceRecognizeResponse);
        }

        TdiFaceRecognizeResponse() {
            ByteString byteString = ByteString.EMPTY;
            this.wxbaseResp_ = byteString;
            this.wxpayResp_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPassType() {
            this.bitField0_ &= -5;
            this.passType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWxbaseResp() {
            this.bitField0_ &= -2;
            this.wxbaseResp_ = getDefaultInstance().getWxbaseResp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearWxpayResp() {
            this.bitField0_ &= -3;
            this.wxpayResp_ = getDefaultInstance().getWxpayResp();
        }

        public static TdiFaceRecognizeResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiFaceRecognizeResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceRecognizeResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiFaceRecognizeResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPassType(TdiApiCommProto.FaceRecognizeResType faceRecognizeResType) {
            faceRecognizeResType.getClass();
            this.bitField0_ |= 4;
            this.passType_ = faceRecognizeResType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWxbaseResp(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.wxbaseResp_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWxpayResp(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.wxpayResp_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiFaceRecognizeResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\f\u0002", new Object[]{"bitField0_", "wxbaseResp_", "wxpayResp_", "passType_", TdiApiCommProto.FaceRecognizeResType.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiFaceRecognizeResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiFaceRecognizeResponse.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
        public TdiApiCommProto.FaceRecognizeResType getPassType() {
            TdiApiCommProto.FaceRecognizeResType forNumber = TdiApiCommProto.FaceRecognizeResType.forNumber(this.passType_);
            if (forNumber == null) {
                return TdiApiCommProto.FaceRecognizeResType.kFaceRecognizeTypeRes_Non;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
        public ByteString getWxbaseResp() {
            return this.wxbaseResp_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
        public ByteString getWxpayResp() {
            return this.wxpayResp_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
        public boolean hasPassType() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
        public boolean hasWxbaseResp() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiFaceRecognizeResponseOrBuilder
        public boolean hasWxpayResp() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiFaceRecognizeResponse tdiFaceRecognizeResponse) {
            return DEFAULT_INSTANCE.createBuilder(tdiFaceRecognizeResponse);
        }

        public static TdiFaceRecognizeResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceRecognizeResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiFaceRecognizeResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiFaceRecognizeResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiFaceRecognizeResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiFaceRecognizeResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiFaceRecognizeResponse parseFrom(InputStream inputStream) throws IOException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiFaceRecognizeResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiFaceRecognizeResponse parseFrom(k kVar) throws IOException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiFaceRecognizeResponse parseFrom(k kVar, t tVar) throws IOException {
            return (TdiFaceRecognizeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiFaceRecognizeResponseOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        TdiApiCommProto.FaceRecognizeResType getPassType();

        ByteString getWxbaseResp();

        ByteString getWxpayResp();

        boolean hasPassType();

        boolean hasWxbaseResp();

        boolean hasWxpayResp();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiGetLoginQrCodeRequest extends GeneratedMessageLite<TdiGetLoginQrCodeRequest, Builder> implements TdiGetLoginQrCodeRequestOrBuilder {
        public static final int CONFIRM_BUSINESS_INFO_FIELD_NUMBER = 2;
        private static final TdiGetLoginQrCodeRequest DEFAULT_INSTANCE;
        private static volatile bg<TdiGetLoginQrCodeRequest> PARSER = null;
        public static final int QRCODE_VERIFY_SCENE_FIELD_NUMBER = 1;
        private int bitField0_;
        private ByteString confirmBusinessInfo_ = ByteString.EMPTY;
        private int qrcodeVerifyScene_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiGetLoginQrCodeRequest, Builder> implements TdiGetLoginQrCodeRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearConfirmBusinessInfo() {
                copyOnWrite();
                ((TdiGetLoginQrCodeRequest) this.instance).clearConfirmBusinessInfo();
                return this;
            }

            public Builder clearQrcodeVerifyScene() {
                copyOnWrite();
                ((TdiGetLoginQrCodeRequest) this.instance).clearQrcodeVerifyScene();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeRequestOrBuilder
            public ByteString getConfirmBusinessInfo() {
                return ((TdiGetLoginQrCodeRequest) this.instance).getConfirmBusinessInfo();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeRequestOrBuilder
            public int getQrcodeVerifyScene() {
                return ((TdiGetLoginQrCodeRequest) this.instance).getQrcodeVerifyScene();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeRequestOrBuilder
            public boolean hasConfirmBusinessInfo() {
                return ((TdiGetLoginQrCodeRequest) this.instance).hasConfirmBusinessInfo();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeRequestOrBuilder
            public boolean hasQrcodeVerifyScene() {
                return ((TdiGetLoginQrCodeRequest) this.instance).hasQrcodeVerifyScene();
            }

            public Builder setConfirmBusinessInfo(ByteString byteString) {
                copyOnWrite();
                ((TdiGetLoginQrCodeRequest) this.instance).setConfirmBusinessInfo(byteString);
                return this;
            }

            public Builder setQrcodeVerifyScene(int i3) {
                copyOnWrite();
                ((TdiGetLoginQrCodeRequest) this.instance).setQrcodeVerifyScene(i3);
                return this;
            }

            Builder() {
                super(TdiGetLoginQrCodeRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiGetLoginQrCodeRequest tdiGetLoginQrCodeRequest = new TdiGetLoginQrCodeRequest();
            DEFAULT_INSTANCE = tdiGetLoginQrCodeRequest;
            GeneratedMessageLite.registerDefaultInstance(TdiGetLoginQrCodeRequest.class, tdiGetLoginQrCodeRequest);
        }

        TdiGetLoginQrCodeRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearConfirmBusinessInfo() {
            this.bitField0_ &= -3;
            this.confirmBusinessInfo_ = getDefaultInstance().getConfirmBusinessInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQrcodeVerifyScene() {
            this.bitField0_ &= -2;
            this.qrcodeVerifyScene_ = 0;
        }

        public static TdiGetLoginQrCodeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiGetLoginQrCodeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiGetLoginQrCodeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setConfirmBusinessInfo(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.confirmBusinessInfo_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQrcodeVerifyScene(int i3) {
            this.bitField0_ |= 1;
            this.qrcodeVerifyScene_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiGetLoginQrCodeRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "qrcodeVerifyScene_", "confirmBusinessInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiGetLoginQrCodeRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiGetLoginQrCodeRequest.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeRequestOrBuilder
        public ByteString getConfirmBusinessInfo() {
            return this.confirmBusinessInfo_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeRequestOrBuilder
        public int getQrcodeVerifyScene() {
            return this.qrcodeVerifyScene_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeRequestOrBuilder
        public boolean hasConfirmBusinessInfo() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeRequestOrBuilder
        public boolean hasQrcodeVerifyScene() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiGetLoginQrCodeRequest tdiGetLoginQrCodeRequest) {
            return DEFAULT_INSTANCE.createBuilder(tdiGetLoginQrCodeRequest);
        }

        public static TdiGetLoginQrCodeRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(InputStream inputStream) throws IOException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(k kVar) throws IOException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiGetLoginQrCodeRequest parseFrom(k kVar, t tVar) throws IOException {
            return (TdiGetLoginQrCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiGetLoginQrCodeRequestOrBuilder extends av {
        ByteString getConfirmBusinessInfo();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getQrcodeVerifyScene();

        boolean hasConfirmBusinessInfo();

        boolean hasQrcodeVerifyScene();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiGetLoginQrCodeResponse extends GeneratedMessageLite<TdiGetLoginQrCodeResponse, Builder> implements TdiGetLoginQrCodeResponseOrBuilder {
        private static final TdiGetLoginQrCodeResponse DEFAULT_INSTANCE;
        private static volatile bg<TdiGetLoginQrCodeResponse> PARSER = null;
        public static final int PATH_FIELD_NUMBER = 1;
        private int bitField0_;
        private String path_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiGetLoginQrCodeResponse, Builder> implements TdiGetLoginQrCodeResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearPath() {
                copyOnWrite();
                ((TdiGetLoginQrCodeResponse) this.instance).clearPath();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeResponseOrBuilder
            public String getPath() {
                return ((TdiGetLoginQrCodeResponse) this.instance).getPath();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeResponseOrBuilder
            public ByteString getPathBytes() {
                return ((TdiGetLoginQrCodeResponse) this.instance).getPathBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeResponseOrBuilder
            public boolean hasPath() {
                return ((TdiGetLoginQrCodeResponse) this.instance).hasPath();
            }

            public Builder setPath(String str) {
                copyOnWrite();
                ((TdiGetLoginQrCodeResponse) this.instance).setPath(str);
                return this;
            }

            public Builder setPathBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiGetLoginQrCodeResponse) this.instance).setPathBytes(byteString);
                return this;
            }

            Builder() {
                super(TdiGetLoginQrCodeResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiGetLoginQrCodeResponse tdiGetLoginQrCodeResponse = new TdiGetLoginQrCodeResponse();
            DEFAULT_INSTANCE = tdiGetLoginQrCodeResponse;
            GeneratedMessageLite.registerDefaultInstance(TdiGetLoginQrCodeResponse.class, tdiGetLoginQrCodeResponse);
        }

        TdiGetLoginQrCodeResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPath() {
            this.bitField0_ &= -2;
            this.path_ = getDefaultInstance().getPath();
        }

        public static TdiGetLoginQrCodeResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiGetLoginQrCodeResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiGetLoginQrCodeResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPath(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.path_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPathBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.path_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiGetLoginQrCodeResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "path_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiGetLoginQrCodeResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiGetLoginQrCodeResponse.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeResponseOrBuilder
        public String getPath() {
            return this.path_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeResponseOrBuilder
        public ByteString getPathBytes() {
            return ByteString.copyFromUtf8(this.path_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetLoginQrCodeResponseOrBuilder
        public boolean hasPath() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiGetLoginQrCodeResponse tdiGetLoginQrCodeResponse) {
            return DEFAULT_INSTANCE.createBuilder(tdiGetLoginQrCodeResponse);
        }

        public static TdiGetLoginQrCodeResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(InputStream inputStream) throws IOException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(k kVar) throws IOException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiGetLoginQrCodeResponse parseFrom(k kVar, t tVar) throws IOException {
            return (TdiGetLoginQrCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiGetLoginQrCodeResponseOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getPath();

        ByteString getPathBytes();

        boolean hasPath();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiGetOAuthCodeRequest extends GeneratedMessageLite<TdiGetOAuthCodeRequest, Builder> implements TdiGetOAuthCodeRequestOrBuilder {
        private static final TdiGetOAuthCodeRequest DEFAULT_INSTANCE;
        public static final int ILINK_APPID_FIELD_NUMBER = 1;
        private static volatile bg<TdiGetOAuthCodeRequest> PARSER;
        private int bitField0_;
        private String ilinkAppid_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiGetOAuthCodeRequest, Builder> implements TdiGetOAuthCodeRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearIlinkAppid() {
                copyOnWrite();
                ((TdiGetOAuthCodeRequest) this.instance).clearIlinkAppid();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeRequestOrBuilder
            public String getIlinkAppid() {
                return ((TdiGetOAuthCodeRequest) this.instance).getIlinkAppid();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeRequestOrBuilder
            public ByteString getIlinkAppidBytes() {
                return ((TdiGetOAuthCodeRequest) this.instance).getIlinkAppidBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeRequestOrBuilder
            public boolean hasIlinkAppid() {
                return ((TdiGetOAuthCodeRequest) this.instance).hasIlinkAppid();
            }

            public Builder setIlinkAppid(String str) {
                copyOnWrite();
                ((TdiGetOAuthCodeRequest) this.instance).setIlinkAppid(str);
                return this;
            }

            public Builder setIlinkAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiGetOAuthCodeRequest) this.instance).setIlinkAppidBytes(byteString);
                return this;
            }

            Builder() {
                super(TdiGetOAuthCodeRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiGetOAuthCodeRequest tdiGetOAuthCodeRequest = new TdiGetOAuthCodeRequest();
            DEFAULT_INSTANCE = tdiGetOAuthCodeRequest;
            GeneratedMessageLite.registerDefaultInstance(TdiGetOAuthCodeRequest.class, tdiGetOAuthCodeRequest);
        }

        TdiGetOAuthCodeRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkAppid() {
            this.bitField0_ &= -2;
            this.ilinkAppid_ = getDefaultInstance().getIlinkAppid();
        }

        public static TdiGetOAuthCodeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiGetOAuthCodeRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiGetOAuthCodeRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiGetOAuthCodeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkAppid(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.ilinkAppid_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkAppidBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.ilinkAppid_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiGetOAuthCodeRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "ilinkAppid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiGetOAuthCodeRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiGetOAuthCodeRequest.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeRequestOrBuilder
        public String getIlinkAppid() {
            return this.ilinkAppid_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeRequestOrBuilder
        public ByteString getIlinkAppidBytes() {
            return ByteString.copyFromUtf8(this.ilinkAppid_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeRequestOrBuilder
        public boolean hasIlinkAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiGetOAuthCodeRequest tdiGetOAuthCodeRequest) {
            return DEFAULT_INSTANCE.createBuilder(tdiGetOAuthCodeRequest);
        }

        public static TdiGetOAuthCodeRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiGetOAuthCodeRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiGetOAuthCodeRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiGetOAuthCodeRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiGetOAuthCodeRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiGetOAuthCodeRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiGetOAuthCodeRequest parseFrom(InputStream inputStream) throws IOException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiGetOAuthCodeRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiGetOAuthCodeRequest parseFrom(k kVar) throws IOException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiGetOAuthCodeRequest parseFrom(k kVar, t tVar) throws IOException {
            return (TdiGetOAuthCodeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiGetOAuthCodeRequestOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getIlinkAppid();

        ByteString getIlinkAppidBytes();

        boolean hasIlinkAppid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiGetOAuthCodeResponse extends GeneratedMessageLite<TdiGetOAuthCodeResponse, Builder> implements TdiGetOAuthCodeResponseOrBuilder {
        private static final TdiGetOAuthCodeResponse DEFAULT_INSTANCE;
        public static final int OAUTH_CODE_FIELD_NUMBER = 1;
        private static volatile bg<TdiGetOAuthCodeResponse> PARSER;
        private int bitField0_;
        private ByteString oauthCode_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiGetOAuthCodeResponse, Builder> implements TdiGetOAuthCodeResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearOauthCode() {
                copyOnWrite();
                ((TdiGetOAuthCodeResponse) this.instance).clearOauthCode();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeResponseOrBuilder
            public ByteString getOauthCode() {
                return ((TdiGetOAuthCodeResponse) this.instance).getOauthCode();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeResponseOrBuilder
            public boolean hasOauthCode() {
                return ((TdiGetOAuthCodeResponse) this.instance).hasOauthCode();
            }

            public Builder setOauthCode(ByteString byteString) {
                copyOnWrite();
                ((TdiGetOAuthCodeResponse) this.instance).setOauthCode(byteString);
                return this;
            }

            Builder() {
                super(TdiGetOAuthCodeResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiGetOAuthCodeResponse tdiGetOAuthCodeResponse = new TdiGetOAuthCodeResponse();
            DEFAULT_INSTANCE = tdiGetOAuthCodeResponse;
            GeneratedMessageLite.registerDefaultInstance(TdiGetOAuthCodeResponse.class, tdiGetOAuthCodeResponse);
        }

        TdiGetOAuthCodeResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOauthCode() {
            this.bitField0_ &= -2;
            this.oauthCode_ = getDefaultInstance().getOauthCode();
        }

        public static TdiGetOAuthCodeResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiGetOAuthCodeResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiGetOAuthCodeResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiGetOAuthCodeResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOauthCode(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.oauthCode_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiGetOAuthCodeResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "oauthCode_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiGetOAuthCodeResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiGetOAuthCodeResponse.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeResponseOrBuilder
        public ByteString getOauthCode() {
            return this.oauthCode_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiGetOAuthCodeResponseOrBuilder
        public boolean hasOauthCode() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiGetOAuthCodeResponse tdiGetOAuthCodeResponse) {
            return DEFAULT_INSTANCE.createBuilder(tdiGetOAuthCodeResponse);
        }

        public static TdiGetOAuthCodeResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiGetOAuthCodeResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiGetOAuthCodeResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiGetOAuthCodeResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiGetOAuthCodeResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiGetOAuthCodeResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiGetOAuthCodeResponse parseFrom(InputStream inputStream) throws IOException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiGetOAuthCodeResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiGetOAuthCodeResponse parseFrom(k kVar) throws IOException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiGetOAuthCodeResponse parseFrom(k kVar, t tVar) throws IOException {
            return (TdiGetOAuthCodeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiGetOAuthCodeResponseOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getOauthCode();

        boolean hasOauthCode();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiInitParameter extends GeneratedMessageLite<TdiInitParameter, Builder> implements TdiInitParameterOrBuilder {
        public static final int APP_DIR_FIELD_NUMBER = 1;
        private static final TdiInitParameter DEFAULT_INSTANCE;
        public static final int ILINK_ID_FIELD_NUMBER = 4;
        public static final int ILINK_PRODUCT_ID_FIELD_NUMBER = 2;
        public static final int ILINK_SN_FIELD_NUMBER = 3;
        public static final int ILINK_TOKEN_FIELD_NUMBER = 5;
        public static final int IOS_IDFA_FIELD_NUMBER = 7;
        public static final int LOG_CONFIG_FIELD_NUMBER = 6;
        private static volatile bg<TdiInitParameter> PARSER;
        private int bitField0_;
        private int ilinkProductId_;
        private TdiLogConfig logConfig_;
        private String appDir_ = "";
        private String ilinkSn_ = "";
        private String ilinkId_ = "";
        private String ilinkToken_ = "";
        private String iosIdfa_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiInitParameter, Builder> implements TdiInitParameterOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppDir() {
                copyOnWrite();
                ((TdiInitParameter) this.instance).clearAppDir();
                return this;
            }

            public Builder clearIlinkId() {
                copyOnWrite();
                ((TdiInitParameter) this.instance).clearIlinkId();
                return this;
            }

            public Builder clearIlinkProductId() {
                copyOnWrite();
                ((TdiInitParameter) this.instance).clearIlinkProductId();
                return this;
            }

            public Builder clearIlinkSn() {
                copyOnWrite();
                ((TdiInitParameter) this.instance).clearIlinkSn();
                return this;
            }

            public Builder clearIlinkToken() {
                copyOnWrite();
                ((TdiInitParameter) this.instance).clearIlinkToken();
                return this;
            }

            public Builder clearIosIdfa() {
                copyOnWrite();
                ((TdiInitParameter) this.instance).clearIosIdfa();
                return this;
            }

            public Builder clearLogConfig() {
                copyOnWrite();
                ((TdiInitParameter) this.instance).clearLogConfig();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public String getAppDir() {
                return ((TdiInitParameter) this.instance).getAppDir();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public ByteString getAppDirBytes() {
                return ((TdiInitParameter) this.instance).getAppDirBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public String getIlinkId() {
                return ((TdiInitParameter) this.instance).getIlinkId();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public ByteString getIlinkIdBytes() {
                return ((TdiInitParameter) this.instance).getIlinkIdBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public int getIlinkProductId() {
                return ((TdiInitParameter) this.instance).getIlinkProductId();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public String getIlinkSn() {
                return ((TdiInitParameter) this.instance).getIlinkSn();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public ByteString getIlinkSnBytes() {
                return ((TdiInitParameter) this.instance).getIlinkSnBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public String getIlinkToken() {
                return ((TdiInitParameter) this.instance).getIlinkToken();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public ByteString getIlinkTokenBytes() {
                return ((TdiInitParameter) this.instance).getIlinkTokenBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public String getIosIdfa() {
                return ((TdiInitParameter) this.instance).getIosIdfa();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public ByteString getIosIdfaBytes() {
                return ((TdiInitParameter) this.instance).getIosIdfaBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public TdiLogConfig getLogConfig() {
                return ((TdiInitParameter) this.instance).getLogConfig();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public boolean hasAppDir() {
                return ((TdiInitParameter) this.instance).hasAppDir();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public boolean hasIlinkId() {
                return ((TdiInitParameter) this.instance).hasIlinkId();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public boolean hasIlinkProductId() {
                return ((TdiInitParameter) this.instance).hasIlinkProductId();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public boolean hasIlinkSn() {
                return ((TdiInitParameter) this.instance).hasIlinkSn();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public boolean hasIlinkToken() {
                return ((TdiInitParameter) this.instance).hasIlinkToken();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public boolean hasIosIdfa() {
                return ((TdiInitParameter) this.instance).hasIosIdfa();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
            public boolean hasLogConfig() {
                return ((TdiInitParameter) this.instance).hasLogConfig();
            }

            public Builder mergeLogConfig(TdiLogConfig tdiLogConfig) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).mergeLogConfig(tdiLogConfig);
                return this;
            }

            public Builder setAppDir(String str) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setAppDir(str);
                return this;
            }

            public Builder setAppDirBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setAppDirBytes(byteString);
                return this;
            }

            public Builder setIlinkId(String str) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setIlinkId(str);
                return this;
            }

            public Builder setIlinkIdBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setIlinkIdBytes(byteString);
                return this;
            }

            public Builder setIlinkProductId(int i3) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setIlinkProductId(i3);
                return this;
            }

            public Builder setIlinkSn(String str) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setIlinkSn(str);
                return this;
            }

            public Builder setIlinkSnBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setIlinkSnBytes(byteString);
                return this;
            }

            public Builder setIlinkToken(String str) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setIlinkToken(str);
                return this;
            }

            public Builder setIlinkTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setIlinkTokenBytes(byteString);
                return this;
            }

            public Builder setIosIdfa(String str) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setIosIdfa(str);
                return this;
            }

            public Builder setIosIdfaBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setIosIdfaBytes(byteString);
                return this;
            }

            public Builder setLogConfig(TdiLogConfig tdiLogConfig) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setLogConfig(tdiLogConfig);
                return this;
            }

            Builder() {
                super(TdiInitParameter.DEFAULT_INSTANCE);
            }

            public Builder setLogConfig(TdiLogConfig.Builder builder) {
                copyOnWrite();
                ((TdiInitParameter) this.instance).setLogConfig(builder);
                return this;
            }
        }

        static {
            TdiInitParameter tdiInitParameter = new TdiInitParameter();
            DEFAULT_INSTANCE = tdiInitParameter;
            GeneratedMessageLite.registerDefaultInstance(TdiInitParameter.class, tdiInitParameter);
        }

        TdiInitParameter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppDir() {
            this.bitField0_ &= -2;
            this.appDir_ = getDefaultInstance().getAppDir();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkId() {
            this.bitField0_ &= -9;
            this.ilinkId_ = getDefaultInstance().getIlinkId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkProductId() {
            this.bitField0_ &= -3;
            this.ilinkProductId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkSn() {
            this.bitField0_ &= -5;
            this.ilinkSn_ = getDefaultInstance().getIlinkSn();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkToken() {
            this.bitField0_ &= -17;
            this.ilinkToken_ = getDefaultInstance().getIlinkToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIosIdfa() {
            this.bitField0_ &= -65;
            this.iosIdfa_ = getDefaultInstance().getIosIdfa();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLogConfig() {
            this.logConfig_ = null;
            this.bitField0_ &= -33;
        }

        public static TdiInitParameter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeLogConfig(TdiLogConfig tdiLogConfig) {
            tdiLogConfig.getClass();
            TdiLogConfig tdiLogConfig2 = this.logConfig_;
            if (tdiLogConfig2 != null && tdiLogConfig2 != TdiLogConfig.getDefaultInstance()) {
                this.logConfig_ = TdiLogConfig.newBuilder(this.logConfig_).mergeFrom((TdiLogConfig.Builder) tdiLogConfig).buildPartial();
            } else {
                this.logConfig_ = tdiLogConfig;
            }
            this.bitField0_ |= 32;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiInitParameter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiInitParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiInitParameter parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiInitParameter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppDir(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.appDir_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppDirBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.appDir_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkId(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.ilinkId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.ilinkId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkProductId(int i3) {
            this.bitField0_ |= 2;
            this.ilinkProductId_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkSn(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.ilinkSn_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkSnBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.ilinkSn_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkToken(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.ilinkToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkTokenBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.ilinkToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIosIdfa(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.iosIdfa_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIosIdfaBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.iosIdfa_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogConfig(TdiLogConfig tdiLogConfig) {
            tdiLogConfig.getClass();
            this.logConfig_ = tdiLogConfig;
            this.bitField0_ |= 32;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiInitParameter();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\t\u0005\u0007\b\u0006", new Object[]{"bitField0_", "appDir_", "ilinkProductId_", "ilinkSn_", "ilinkId_", "ilinkToken_", "logConfig_", "iosIdfa_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiInitParameter> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiInitParameter.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public String getAppDir() {
            return this.appDir_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public ByteString getAppDirBytes() {
            return ByteString.copyFromUtf8(this.appDir_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public String getIlinkId() {
            return this.ilinkId_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public ByteString getIlinkIdBytes() {
            return ByteString.copyFromUtf8(this.ilinkId_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public int getIlinkProductId() {
            return this.ilinkProductId_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public String getIlinkSn() {
            return this.ilinkSn_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public ByteString getIlinkSnBytes() {
            return ByteString.copyFromUtf8(this.ilinkSn_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public String getIlinkToken() {
            return this.ilinkToken_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public ByteString getIlinkTokenBytes() {
            return ByteString.copyFromUtf8(this.ilinkToken_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public String getIosIdfa() {
            return this.iosIdfa_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public ByteString getIosIdfaBytes() {
            return ByteString.copyFromUtf8(this.iosIdfa_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public TdiLogConfig getLogConfig() {
            TdiLogConfig tdiLogConfig = this.logConfig_;
            if (tdiLogConfig == null) {
                return TdiLogConfig.getDefaultInstance();
            }
            return tdiLogConfig;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public boolean hasAppDir() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public boolean hasIlinkId() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public boolean hasIlinkProductId() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public boolean hasIlinkSn() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public boolean hasIlinkToken() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public boolean hasIosIdfa() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiInitParameterOrBuilder
        public boolean hasLogConfig() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiInitParameter tdiInitParameter) {
            return DEFAULT_INSTANCE.createBuilder(tdiInitParameter);
        }

        public static TdiInitParameter parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiInitParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiInitParameter parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiInitParameter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiInitParameter parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogConfig(TdiLogConfig.Builder builder) {
            this.logConfig_ = builder.build();
            this.bitField0_ |= 32;
        }

        public static TdiInitParameter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiInitParameter parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiInitParameter parseFrom(InputStream inputStream) throws IOException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiInitParameter parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiInitParameter parseFrom(k kVar) throws IOException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiInitParameter parseFrom(k kVar, t tVar) throws IOException {
            return (TdiInitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiInitParameterOrBuilder extends av {
        String getAppDir();

        ByteString getAppDirBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getIlinkId();

        ByteString getIlinkIdBytes();

        int getIlinkProductId();

        String getIlinkSn();

        ByteString getIlinkSnBytes();

        String getIlinkToken();

        ByteString getIlinkTokenBytes();

        String getIosIdfa();

        ByteString getIosIdfaBytes();

        TdiLogConfig getLogConfig();

        boolean hasAppDir();

        boolean hasIlinkId();

        boolean hasIlinkProductId();

        boolean hasIlinkSn();

        boolean hasIlinkToken();

        boolean hasIosIdfa();

        boolean hasLogConfig();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiLogConfig extends GeneratedMessageLite<TdiLogConfig, Builder> implements TdiLogConfigOrBuilder {
        private static final TdiLogConfig DEFAULT_INSTANCE;
        public static final int ENABLE_CONSOLE_FIELD_NUMBER = 2;
        public static final int ENABLE_LOG_FIELD_NUMBER = 1;
        public static final int LOG_LEVEL_FIELD_NUMBER = 3;
        private static volatile bg<TdiLogConfig> PARSER;
        private int bitField0_;
        private boolean enableConsole_;
        private boolean enableLog_;
        private int logLevel_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiLogConfig, Builder> implements TdiLogConfigOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearEnableConsole() {
                copyOnWrite();
                ((TdiLogConfig) this.instance).clearEnableConsole();
                return this;
            }

            public Builder clearEnableLog() {
                copyOnWrite();
                ((TdiLogConfig) this.instance).clearEnableLog();
                return this;
            }

            public Builder clearLogLevel() {
                copyOnWrite();
                ((TdiLogConfig) this.instance).clearLogLevel();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
            public boolean getEnableConsole() {
                return ((TdiLogConfig) this.instance).getEnableConsole();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
            public boolean getEnableLog() {
                return ((TdiLogConfig) this.instance).getEnableLog();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
            public int getLogLevel() {
                return ((TdiLogConfig) this.instance).getLogLevel();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
            public boolean hasEnableConsole() {
                return ((TdiLogConfig) this.instance).hasEnableConsole();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
            public boolean hasEnableLog() {
                return ((TdiLogConfig) this.instance).hasEnableLog();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
            public boolean hasLogLevel() {
                return ((TdiLogConfig) this.instance).hasLogLevel();
            }

            public Builder setEnableConsole(boolean z16) {
                copyOnWrite();
                ((TdiLogConfig) this.instance).setEnableConsole(z16);
                return this;
            }

            public Builder setEnableLog(boolean z16) {
                copyOnWrite();
                ((TdiLogConfig) this.instance).setEnableLog(z16);
                return this;
            }

            public Builder setLogLevel(int i3) {
                copyOnWrite();
                ((TdiLogConfig) this.instance).setLogLevel(i3);
                return this;
            }

            Builder() {
                super(TdiLogConfig.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiLogConfig tdiLogConfig = new TdiLogConfig();
            DEFAULT_INSTANCE = tdiLogConfig;
            GeneratedMessageLite.registerDefaultInstance(TdiLogConfig.class, tdiLogConfig);
        }

        TdiLogConfig() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnableConsole() {
            this.bitField0_ &= -3;
            this.enableConsole_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnableLog() {
            this.bitField0_ &= -2;
            this.enableLog_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLogLevel() {
            this.bitField0_ &= -5;
            this.logLevel_ = 0;
        }

        public static TdiLogConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiLogConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiLogConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiLogConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiLogConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnableConsole(boolean z16) {
            this.bitField0_ |= 2;
            this.enableConsole_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnableLog(boolean z16) {
            this.bitField0_ |= 1;
            this.enableLog_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogLevel(int i3) {
            this.bitField0_ |= 4;
            this.logLevel_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiLogConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0000\u0002\u0007\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "enableLog_", "enableConsole_", "logLevel_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiLogConfig> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiLogConfig.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
        public boolean getEnableConsole() {
            return this.enableConsole_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
        public boolean getEnableLog() {
            return this.enableLog_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
        public int getLogLevel() {
            return this.logLevel_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
        public boolean hasEnableConsole() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
        public boolean hasEnableLog() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLogConfigOrBuilder
        public boolean hasLogLevel() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiLogConfig tdiLogConfig) {
            return DEFAULT_INSTANCE.createBuilder(tdiLogConfig);
        }

        public static TdiLogConfig parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiLogConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiLogConfig parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiLogConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiLogConfig parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiLogConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiLogConfig parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiLogConfig parseFrom(InputStream inputStream) throws IOException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiLogConfig parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiLogConfig parseFrom(k kVar) throws IOException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiLogConfig parseFrom(k kVar, t tVar) throws IOException {
            return (TdiLogConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiLogConfigOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean getEnableConsole();

        boolean getEnableLog();

        int getLogLevel();

        boolean hasEnableConsole();

        boolean hasEnableLog();

        boolean hasLogLevel();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum TdiLogLevel implements ad.c {
        kTdiLogLevelVerbose(0),
        kTdiLogLevelDebug(1),
        kTdiLogLevelInfo(2),
        kTdiLogLevelWarn(3),
        kTdiLogLevelError(4),
        kTdiLogLevelFatal(5),
        kTdiLogLevelNone(6);

        private static final ad.d<TdiLogLevel> internalValueMap = new ad.d<TdiLogLevel>() { // from class: com.tencent.ilink.tdi.TdiApiProto.TdiLogLevel.1
            @Override // com.google.protobuf.ad.d
            public TdiLogLevel findValueByNumber(int i3) {
                return TdiLogLevel.forNumber(i3);
            }
        };
        public static final int kTdiLogLevelDebug_VALUE = 1;
        public static final int kTdiLogLevelError_VALUE = 4;
        public static final int kTdiLogLevelFatal_VALUE = 5;
        public static final int kTdiLogLevelInfo_VALUE = 2;
        public static final int kTdiLogLevelNone_VALUE = 6;
        public static final int kTdiLogLevelVerbose_VALUE = 0;
        public static final int kTdiLogLevelWarn_VALUE = 3;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class TdiLogLevelVerifier implements ad.e {
            static final ad.e INSTANCE = new TdiLogLevelVerifier();

            TdiLogLevelVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (TdiLogLevel.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        TdiLogLevel(int i3) {
            this.value = i3;
        }

        public static TdiLogLevel forNumber(int i3) {
            switch (i3) {
                case 0:
                    return kTdiLogLevelVerbose;
                case 1:
                    return kTdiLogLevelDebug;
                case 2:
                    return kTdiLogLevelInfo;
                case 3:
                    return kTdiLogLevelWarn;
                case 4:
                    return kTdiLogLevelError;
                case 5:
                    return kTdiLogLevelFatal;
                case 6:
                    return kTdiLogLevelNone;
                default:
                    return null;
            }
        }

        public static ad.d<TdiLogLevel> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return TdiLogLevelVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TdiLogLevel valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class TdiLoginRequest extends GeneratedMessageLite<TdiLoginRequest, Builder> implements TdiLoginRequestOrBuilder {
        public static final int AUTH_CODE_FIELD_NUMBER = 3;
        public static final int BUSINESS_REQ_FIELD_NUMBER = 2;
        private static final TdiLoginRequest DEFAULT_INSTANCE;
        public static final int LKID_FIELD_NUMBER = 7;
        private static volatile bg<TdiLoginRequest> PARSER = null;
        public static final int RETRY_COUNT_FIELD_NUMBER = 4;
        public static final int SECURITY_INFO_FIELD_NUMBER = 8;
        public static final int SESSION_TYPE_FIELD_NUMBER = 5;
        public static final int TIMEOUT_MS_FIELD_NUMBER = 1;
        public static final int VENDORID_FIELD_NUMBER = 6;
        private ByteString authCode_;
        private int bitField0_;
        private ByteString businessReq_;
        private ByteString lkid_;
        private int retryCount_;
        private ByteString securityInfo_;
        private int sessionType_;
        private int timeoutMs_;
        private ByteString vendorid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiLoginRequest, Builder> implements TdiLoginRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAuthCode() {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).clearAuthCode();
                return this;
            }

            public Builder clearBusinessReq() {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).clearBusinessReq();
                return this;
            }

            public Builder clearLkid() {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).clearLkid();
                return this;
            }

            public Builder clearRetryCount() {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).clearRetryCount();
                return this;
            }

            public Builder clearSecurityInfo() {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).clearSecurityInfo();
                return this;
            }

            public Builder clearSessionType() {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).clearSessionType();
                return this;
            }

            public Builder clearTimeoutMs() {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).clearTimeoutMs();
                return this;
            }

            public Builder clearVendorid() {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).clearVendorid();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public ByteString getAuthCode() {
                return ((TdiLoginRequest) this.instance).getAuthCode();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public ByteString getBusinessReq() {
                return ((TdiLoginRequest) this.instance).getBusinessReq();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public ByteString getLkid() {
                return ((TdiLoginRequest) this.instance).getLkid();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public int getRetryCount() {
                return ((TdiLoginRequest) this.instance).getRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public ByteString getSecurityInfo() {
                return ((TdiLoginRequest) this.instance).getSecurityInfo();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public int getSessionType() {
                return ((TdiLoginRequest) this.instance).getSessionType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public int getTimeoutMs() {
                return ((TdiLoginRequest) this.instance).getTimeoutMs();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public ByteString getVendorid() {
                return ((TdiLoginRequest) this.instance).getVendorid();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public boolean hasAuthCode() {
                return ((TdiLoginRequest) this.instance).hasAuthCode();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public boolean hasBusinessReq() {
                return ((TdiLoginRequest) this.instance).hasBusinessReq();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public boolean hasLkid() {
                return ((TdiLoginRequest) this.instance).hasLkid();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public boolean hasRetryCount() {
                return ((TdiLoginRequest) this.instance).hasRetryCount();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public boolean hasSecurityInfo() {
                return ((TdiLoginRequest) this.instance).hasSecurityInfo();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public boolean hasSessionType() {
                return ((TdiLoginRequest) this.instance).hasSessionType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public boolean hasTimeoutMs() {
                return ((TdiLoginRequest) this.instance).hasTimeoutMs();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
            public boolean hasVendorid() {
                return ((TdiLoginRequest) this.instance).hasVendorid();
            }

            public Builder setAuthCode(ByteString byteString) {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).setAuthCode(byteString);
                return this;
            }

            public Builder setBusinessReq(ByteString byteString) {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).setBusinessReq(byteString);
                return this;
            }

            public Builder setLkid(ByteString byteString) {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).setLkid(byteString);
                return this;
            }

            public Builder setRetryCount(int i3) {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).setRetryCount(i3);
                return this;
            }

            public Builder setSecurityInfo(ByteString byteString) {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).setSecurityInfo(byteString);
                return this;
            }

            public Builder setSessionType(int i3) {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).setSessionType(i3);
                return this;
            }

            public Builder setTimeoutMs(int i3) {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).setTimeoutMs(i3);
                return this;
            }

            public Builder setVendorid(ByteString byteString) {
                copyOnWrite();
                ((TdiLoginRequest) this.instance).setVendorid(byteString);
                return this;
            }

            Builder() {
                super(TdiLoginRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiLoginRequest tdiLoginRequest = new TdiLoginRequest();
            DEFAULT_INSTANCE = tdiLoginRequest;
            GeneratedMessageLite.registerDefaultInstance(TdiLoginRequest.class, tdiLoginRequest);
        }

        TdiLoginRequest() {
            ByteString byteString = ByteString.EMPTY;
            this.businessReq_ = byteString;
            this.authCode_ = byteString;
            this.vendorid_ = byteString;
            this.lkid_ = byteString;
            this.securityInfo_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAuthCode() {
            this.bitField0_ &= -5;
            this.authCode_ = getDefaultInstance().getAuthCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBusinessReq() {
            this.bitField0_ &= -3;
            this.businessReq_ = getDefaultInstance().getBusinessReq();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLkid() {
            this.bitField0_ &= -65;
            this.lkid_ = getDefaultInstance().getLkid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRetryCount() {
            this.bitField0_ &= -9;
            this.retryCount_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSecurityInfo() {
            this.bitField0_ &= -129;
            this.securityInfo_ = getDefaultInstance().getSecurityInfo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionType() {
            this.bitField0_ &= -17;
            this.sessionType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeoutMs() {
            this.bitField0_ &= -2;
            this.timeoutMs_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVendorid() {
            this.bitField0_ &= -33;
            this.vendorid_ = getDefaultInstance().getVendorid();
        }

        public static TdiLoginRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiLoginRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiLoginRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiLoginRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiLoginRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAuthCode(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.authCode_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBusinessReq(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.businessReq_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLkid(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.lkid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRetryCount(int i3) {
            this.bitField0_ |= 8;
            this.retryCount_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSecurityInfo(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 128;
            this.securityInfo_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionType(int i3) {
            this.bitField0_ |= 16;
            this.sessionType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutMs(int i3) {
            this.bitField0_ |= 1;
            this.timeoutMs_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVendorid(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.vendorid_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiLoginRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0000\u0002\n\u0001\u0003\n\u0002\u0004\u0004\u0003\u0005\u000b\u0004\u0006\n\u0005\u0007\n\u0006\b\n\u0007", new Object[]{"bitField0_", "timeoutMs_", "businessReq_", "authCode_", "retryCount_", "sessionType_", "vendorid_", "lkid_", "securityInfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiLoginRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiLoginRequest.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public ByteString getAuthCode() {
            return this.authCode_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public ByteString getBusinessReq() {
            return this.businessReq_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public ByteString getLkid() {
            return this.lkid_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public int getRetryCount() {
            return this.retryCount_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public ByteString getSecurityInfo() {
            return this.securityInfo_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public int getSessionType() {
            return this.sessionType_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public int getTimeoutMs() {
            return this.timeoutMs_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public ByteString getVendorid() {
            return this.vendorid_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public boolean hasAuthCode() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public boolean hasBusinessReq() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public boolean hasLkid() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public boolean hasRetryCount() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public boolean hasSecurityInfo() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public boolean hasSessionType() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public boolean hasTimeoutMs() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginRequestOrBuilder
        public boolean hasVendorid() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiLoginRequest tdiLoginRequest) {
            return DEFAULT_INSTANCE.createBuilder(tdiLoginRequest);
        }

        public static TdiLoginRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiLoginRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiLoginRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiLoginRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiLoginRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiLoginRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiLoginRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiLoginRequest parseFrom(InputStream inputStream) throws IOException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiLoginRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiLoginRequest parseFrom(k kVar) throws IOException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiLoginRequest parseFrom(k kVar, t tVar) throws IOException {
            return (TdiLoginRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiLoginRequestOrBuilder extends av {
        ByteString getAuthCode();

        ByteString getBusinessReq();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getLkid();

        int getRetryCount();

        ByteString getSecurityInfo();

        int getSessionType();

        int getTimeoutMs();

        ByteString getVendorid();

        boolean hasAuthCode();

        boolean hasBusinessReq();

        boolean hasLkid();

        boolean hasRetryCount();

        boolean hasSecurityInfo();

        boolean hasSessionType();

        boolean hasTimeoutMs();

        boolean hasVendorid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class TdiLoginResponse extends GeneratedMessageLite<TdiLoginResponse, Builder> implements TdiLoginResponseOrBuilder {
        private static final TdiLoginResponse DEFAULT_INSTANCE;
        public static final int DETAIL_RET_FIELD_NUMBER = 3;
        public static final int LOGIN_TYPE_FIELD_NUMBER = 1;
        private static volatile bg<TdiLoginResponse> PARSER = null;
        public static final int VERIFY_BUFFER_FIELD_NUMBER = 2;
        private int bitField0_;
        private int detailRet_;
        private int loginType_;
        private ByteString verifyBuffer_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiLoginResponse, Builder> implements TdiLoginResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDetailRet() {
                copyOnWrite();
                ((TdiLoginResponse) this.instance).clearDetailRet();
                return this;
            }

            public Builder clearLoginType() {
                copyOnWrite();
                ((TdiLoginResponse) this.instance).clearLoginType();
                return this;
            }

            public Builder clearVerifyBuffer() {
                copyOnWrite();
                ((TdiLoginResponse) this.instance).clearVerifyBuffer();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
            public int getDetailRet() {
                return ((TdiLoginResponse) this.instance).getDetailRet();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
            public int getLoginType() {
                return ((TdiLoginResponse) this.instance).getLoginType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
            public ByteString getVerifyBuffer() {
                return ((TdiLoginResponse) this.instance).getVerifyBuffer();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
            public boolean hasDetailRet() {
                return ((TdiLoginResponse) this.instance).hasDetailRet();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
            public boolean hasLoginType() {
                return ((TdiLoginResponse) this.instance).hasLoginType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
            public boolean hasVerifyBuffer() {
                return ((TdiLoginResponse) this.instance).hasVerifyBuffer();
            }

            public Builder setDetailRet(int i3) {
                copyOnWrite();
                ((TdiLoginResponse) this.instance).setDetailRet(i3);
                return this;
            }

            public Builder setLoginType(int i3) {
                copyOnWrite();
                ((TdiLoginResponse) this.instance).setLoginType(i3);
                return this;
            }

            public Builder setVerifyBuffer(ByteString byteString) {
                copyOnWrite();
                ((TdiLoginResponse) this.instance).setVerifyBuffer(byteString);
                return this;
            }

            Builder() {
                super(TdiLoginResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiLoginResponse tdiLoginResponse = new TdiLoginResponse();
            DEFAULT_INSTANCE = tdiLoginResponse;
            GeneratedMessageLite.registerDefaultInstance(TdiLoginResponse.class, tdiLoginResponse);
        }

        TdiLoginResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDetailRet() {
            this.bitField0_ &= -5;
            this.detailRet_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLoginType() {
            this.bitField0_ &= -2;
            this.loginType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVerifyBuffer() {
            this.bitField0_ &= -3;
            this.verifyBuffer_ = getDefaultInstance().getVerifyBuffer();
        }

        public static TdiLoginResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiLoginResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiLoginResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiLoginResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiLoginResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDetailRet(int i3) {
            this.bitField0_ |= 4;
            this.detailRet_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoginType(int i3) {
            this.bitField0_ |= 1;
            this.loginType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVerifyBuffer(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.verifyBuffer_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiLoginResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0000\u0002\n\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "loginType_", "verifyBuffer_", "detailRet_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiLoginResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiLoginResponse.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
        public int getDetailRet() {
            return this.detailRet_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
        public int getLoginType() {
            return this.loginType_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
        public ByteString getVerifyBuffer() {
            return this.verifyBuffer_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
        public boolean hasDetailRet() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
        public boolean hasLoginType() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiLoginResponseOrBuilder
        public boolean hasVerifyBuffer() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiLoginResponse tdiLoginResponse) {
            return DEFAULT_INSTANCE.createBuilder(tdiLoginResponse);
        }

        public static TdiLoginResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiLoginResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiLoginResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiLoginResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiLoginResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiLoginResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiLoginResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiLoginResponse parseFrom(InputStream inputStream) throws IOException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiLoginResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiLoginResponse parseFrom(k kVar) throws IOException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiLoginResponse parseFrom(k kVar, t tVar) throws IOException {
            return (TdiLoginResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiLoginResponseOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getDetailRet();

        int getLoginType();

        ByteString getVerifyBuffer();

        boolean hasDetailRet();

        boolean hasLoginType();

        boolean hasVerifyBuffer();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum TdiLoginScene implements ad.c {
        kTdiLoginSceneNone(0),
        kTdiLoginSceneFace(1),
        kTdiLoginSceneQrCode(2),
        kTdiLoginSceneThirdApp(5),
        kTdiLoginSceneOAuth(6),
        kTdiLoginSceneVisitor(7);

        private static final ad.d<TdiLoginScene> internalValueMap = new ad.d<TdiLoginScene>() { // from class: com.tencent.ilink.tdi.TdiApiProto.TdiLoginScene.1
            @Override // com.google.protobuf.ad.d
            public TdiLoginScene findValueByNumber(int i3) {
                return TdiLoginScene.forNumber(i3);
            }
        };
        public static final int kTdiLoginSceneFace_VALUE = 1;
        public static final int kTdiLoginSceneNone_VALUE = 0;
        public static final int kTdiLoginSceneOAuth_VALUE = 6;
        public static final int kTdiLoginSceneQrCode_VALUE = 2;
        public static final int kTdiLoginSceneThirdApp_VALUE = 5;
        public static final int kTdiLoginSceneVisitor_VALUE = 7;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class TdiLoginSceneVerifier implements ad.e {
            static final ad.e INSTANCE = new TdiLoginSceneVerifier();

            TdiLoginSceneVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (TdiLoginScene.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        TdiLoginScene(int i3) {
            this.value = i3;
        }

        public static TdiLoginScene forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 5) {
                            if (i3 != 6) {
                                if (i3 != 7) {
                                    return null;
                                }
                                return kTdiLoginSceneVisitor;
                            }
                            return kTdiLoginSceneOAuth;
                        }
                        return kTdiLoginSceneThirdApp;
                    }
                    return kTdiLoginSceneQrCode;
                }
                return kTdiLoginSceneFace;
            }
            return kTdiLoginSceneNone;
        }

        public static ad.d<TdiLoginScene> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return TdiLoginSceneVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TdiLoginScene valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public enum TdiLoginStatus implements ad.c {
        kTdiLoginUnknown(-1),
        kTdiLoginSuccess(0),
        kTdiRequireManualLogin(1),
        kTdiRequireAutoLogin(2);

        private static final ad.d<TdiLoginStatus> internalValueMap = new ad.d<TdiLoginStatus>() { // from class: com.tencent.ilink.tdi.TdiApiProto.TdiLoginStatus.1
            @Override // com.google.protobuf.ad.d
            public TdiLoginStatus findValueByNumber(int i3) {
                return TdiLoginStatus.forNumber(i3);
            }
        };
        public static final int kTdiLoginSuccess_VALUE = 0;
        public static final int kTdiLoginUnknown_VALUE = -1;
        public static final int kTdiRequireAutoLogin_VALUE = 2;
        public static final int kTdiRequireManualLogin_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class TdiLoginStatusVerifier implements ad.e {
            static final ad.e INSTANCE = new TdiLoginStatusVerifier();

            TdiLoginStatusVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (TdiLoginStatus.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        TdiLoginStatus(int i3) {
            this.value = i3;
        }

        public static TdiLoginStatus forNumber(int i3) {
            if (i3 != -1) {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            return null;
                        }
                        return kTdiRequireAutoLogin;
                    }
                    return kTdiRequireManualLogin;
                }
                return kTdiLoginSuccess;
            }
            return kTdiLoginUnknown;
        }

        public static ad.d<TdiLoginStatus> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return TdiLoginStatusVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TdiLoginStatus valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public enum TdiLoginType implements ad.c {
        kTdiLoginTypeNone(0),
        kTdiLoginTypeAuto(1),
        kTdiLoginTypeFace(2),
        kTdiLoginTypeQrCode(3),
        kTdiLoginTypeOAuth(4),
        kTdiLoginTypeThirdApp(5),
        kTdiLoginTypeVisitor(6),
        kTdiLoginTypePalm(7);

        private static final ad.d<TdiLoginType> internalValueMap = new ad.d<TdiLoginType>() { // from class: com.tencent.ilink.tdi.TdiApiProto.TdiLoginType.1
            @Override // com.google.protobuf.ad.d
            public TdiLoginType findValueByNumber(int i3) {
                return TdiLoginType.forNumber(i3);
            }
        };
        public static final int kTdiLoginTypeAuto_VALUE = 1;
        public static final int kTdiLoginTypeFace_VALUE = 2;
        public static final int kTdiLoginTypeNone_VALUE = 0;
        public static final int kTdiLoginTypeOAuth_VALUE = 4;
        public static final int kTdiLoginTypePalm_VALUE = 7;
        public static final int kTdiLoginTypeQrCode_VALUE = 3;
        public static final int kTdiLoginTypeThirdApp_VALUE = 5;
        public static final int kTdiLoginTypeVisitor_VALUE = 6;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class TdiLoginTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new TdiLoginTypeVerifier();

            TdiLoginTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (TdiLoginType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        TdiLoginType(int i3) {
            this.value = i3;
        }

        public static TdiLoginType forNumber(int i3) {
            switch (i3) {
                case 0:
                    return kTdiLoginTypeNone;
                case 1:
                    return kTdiLoginTypeAuto;
                case 2:
                    return kTdiLoginTypeFace;
                case 3:
                    return kTdiLoginTypeQrCode;
                case 4:
                    return kTdiLoginTypeOAuth;
                case 5:
                    return kTdiLoginTypeThirdApp;
                case 6:
                    return kTdiLoginTypeVisitor;
                case 7:
                    return kTdiLoginTypePalm;
                default:
                    return null;
            }
        }

        public static ad.d<TdiLoginType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return TdiLoginTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TdiLoginType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public enum TdiNetType implements ad.c {
        kIlinkShortlink(0),
        kIlinkLonglink(1);

        private static final ad.d<TdiNetType> internalValueMap = new ad.d<TdiNetType>() { // from class: com.tencent.ilink.tdi.TdiApiProto.TdiNetType.1
            @Override // com.google.protobuf.ad.d
            public TdiNetType findValueByNumber(int i3) {
                return TdiNetType.forNumber(i3);
            }
        };
        public static final int kIlinkLonglink_VALUE = 1;
        public static final int kIlinkShortlink_VALUE = 0;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class TdiNetTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new TdiNetTypeVerifier();

            TdiNetTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (TdiNetType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        TdiNetType(int i3) {
            this.value = i3;
        }

        public static TdiNetType forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return null;
                }
                return kIlinkLonglink;
            }
            return kIlinkShortlink;
        }

        public static ad.d<TdiNetType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return TdiNetTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TdiNetType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public enum TdiSesssionKickOutDetailRet implements ad.c {
        kTdiSesssionKickOutDetailRet_Default(0),
        kTdiSesssionKickOutDetailRet_DeviceIdUnMatch(1),
        kTdiSesssionKickOutDetailRet_DisableStatus(2),
        kTdiSesssionKickOutDetailRet_DeviceClosed_Comm(3),
        kTdiSesssionKickOutDetailRet_DeviceClosed_Migrate(4),
        kTdiSesssionKickOutDetailRet_3rdApp_Timeout(5);

        private static final ad.d<TdiSesssionKickOutDetailRet> internalValueMap = new ad.d<TdiSesssionKickOutDetailRet>() { // from class: com.tencent.ilink.tdi.TdiApiProto.TdiSesssionKickOutDetailRet.1
            @Override // com.google.protobuf.ad.d
            public TdiSesssionKickOutDetailRet findValueByNumber(int i3) {
                return TdiSesssionKickOutDetailRet.forNumber(i3);
            }
        };
        public static final int kTdiSesssionKickOutDetailRet_3rdApp_Timeout_VALUE = 5;
        public static final int kTdiSesssionKickOutDetailRet_Default_VALUE = 0;
        public static final int kTdiSesssionKickOutDetailRet_DeviceClosed_Comm_VALUE = 3;
        public static final int kTdiSesssionKickOutDetailRet_DeviceClosed_Migrate_VALUE = 4;
        public static final int kTdiSesssionKickOutDetailRet_DeviceIdUnMatch_VALUE = 1;
        public static final int kTdiSesssionKickOutDetailRet_DisableStatus_VALUE = 2;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class TdiSesssionKickOutDetailRetVerifier implements ad.e {
            static final ad.e INSTANCE = new TdiSesssionKickOutDetailRetVerifier();

            TdiSesssionKickOutDetailRetVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (TdiSesssionKickOutDetailRet.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        TdiSesssionKickOutDetailRet(int i3) {
            this.value = i3;
        }

        public static TdiSesssionKickOutDetailRet forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                if (i3 != 5) {
                                    return null;
                                }
                                return kTdiSesssionKickOutDetailRet_3rdApp_Timeout;
                            }
                            return kTdiSesssionKickOutDetailRet_DeviceClosed_Migrate;
                        }
                        return kTdiSesssionKickOutDetailRet_DeviceClosed_Comm;
                    }
                    return kTdiSesssionKickOutDetailRet_DisableStatus;
                }
                return kTdiSesssionKickOutDetailRet_DeviceIdUnMatch;
            }
            return kTdiSesssionKickOutDetailRet_Default;
        }

        public static ad.d<TdiSesssionKickOutDetailRet> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return TdiSesssionKickOutDetailRetVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static TdiSesssionKickOutDetailRet valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class TdiUserInfo extends GeneratedMessageLite<TdiUserInfo, Builder> implements TdiUserInfoOrBuilder {
        private static final TdiUserInfo DEFAULT_INSTANCE;
        public static final int LOGIN_SCENE_FIELD_NUMBER = 5;
        public static final int LOGIN_STATUS_FIELD_NUMBER = 1;
        public static final int LOGIN_TYPE_FIELD_NUMBER = 2;
        private static volatile bg<TdiUserInfo> PARSER = null;
        public static final int UIN_FIELD_NUMBER = 3;
        public static final int USERNAME_FIELD_NUMBER = 4;
        private int bitField0_;
        private int loginScene_;
        private int loginType_;
        private long uin_;
        private int loginStatus_ = -1;
        private String username_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<TdiUserInfo, Builder> implements TdiUserInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearLoginScene() {
                copyOnWrite();
                ((TdiUserInfo) this.instance).clearLoginScene();
                return this;
            }

            public Builder clearLoginStatus() {
                copyOnWrite();
                ((TdiUserInfo) this.instance).clearLoginStatus();
                return this;
            }

            public Builder clearLoginType() {
                copyOnWrite();
                ((TdiUserInfo) this.instance).clearLoginType();
                return this;
            }

            public Builder clearUin() {
                copyOnWrite();
                ((TdiUserInfo) this.instance).clearUin();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((TdiUserInfo) this.instance).clearUsername();
                return this;
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public TdiLoginScene getLoginScene() {
                return ((TdiUserInfo) this.instance).getLoginScene();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public TdiLoginStatus getLoginStatus() {
                return ((TdiUserInfo) this.instance).getLoginStatus();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public int getLoginType() {
                return ((TdiUserInfo) this.instance).getLoginType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public long getUin() {
                return ((TdiUserInfo) this.instance).getUin();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public String getUsername() {
                return ((TdiUserInfo) this.instance).getUsername();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public ByteString getUsernameBytes() {
                return ((TdiUserInfo) this.instance).getUsernameBytes();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public boolean hasLoginScene() {
                return ((TdiUserInfo) this.instance).hasLoginScene();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public boolean hasLoginStatus() {
                return ((TdiUserInfo) this.instance).hasLoginStatus();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public boolean hasLoginType() {
                return ((TdiUserInfo) this.instance).hasLoginType();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public boolean hasUin() {
                return ((TdiUserInfo) this.instance).hasUin();
            }

            @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
            public boolean hasUsername() {
                return ((TdiUserInfo) this.instance).hasUsername();
            }

            public Builder setLoginScene(TdiLoginScene tdiLoginScene) {
                copyOnWrite();
                ((TdiUserInfo) this.instance).setLoginScene(tdiLoginScene);
                return this;
            }

            public Builder setLoginStatus(TdiLoginStatus tdiLoginStatus) {
                copyOnWrite();
                ((TdiUserInfo) this.instance).setLoginStatus(tdiLoginStatus);
                return this;
            }

            public Builder setLoginType(int i3) {
                copyOnWrite();
                ((TdiUserInfo) this.instance).setLoginType(i3);
                return this;
            }

            public Builder setUin(long j3) {
                copyOnWrite();
                ((TdiUserInfo) this.instance).setUin(j3);
                return this;
            }

            public Builder setUsername(String str) {
                copyOnWrite();
                ((TdiUserInfo) this.instance).setUsername(str);
                return this;
            }

            public Builder setUsernameBytes(ByteString byteString) {
                copyOnWrite();
                ((TdiUserInfo) this.instance).setUsernameBytes(byteString);
                return this;
            }

            Builder() {
                super(TdiUserInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            TdiUserInfo tdiUserInfo = new TdiUserInfo();
            DEFAULT_INSTANCE = tdiUserInfo;
            GeneratedMessageLite.registerDefaultInstance(TdiUserInfo.class, tdiUserInfo);
        }

        TdiUserInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLoginScene() {
            this.bitField0_ &= -17;
            this.loginScene_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLoginStatus() {
            this.bitField0_ &= -2;
            this.loginStatus_ = -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLoginType() {
            this.bitField0_ &= -3;
            this.loginType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUin() {
            this.bitField0_ &= -5;
            this.uin_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUsername() {
            this.bitField0_ &= -9;
            this.username_ = getDefaultInstance().getUsername();
        }

        public static TdiUserInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static TdiUserInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (TdiUserInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiUserInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<TdiUserInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoginScene(TdiLoginScene tdiLoginScene) {
            tdiLoginScene.getClass();
            this.bitField0_ |= 16;
            this.loginScene_ = tdiLoginScene.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoginStatus(TdiLoginStatus tdiLoginStatus) {
            tdiLoginStatus.getClass();
            this.bitField0_ |= 1;
            this.loginStatus_ = tdiLoginStatus.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoginType(int i3) {
            this.bitField0_ |= 2;
            this.loginType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUin(long j3) {
            this.bitField0_ |= 4;
            this.uin_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsername(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.username_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUsernameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.username_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TdiUserInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u000b\u0001\u0003\u0003\u0002\u0004\b\u0003\u0005\f\u0004", new Object[]{"bitField0_", "loginStatus_", TdiLoginStatus.internalGetVerifier(), "loginType_", "uin_", "username_", "loginScene_", TdiLoginScene.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<TdiUserInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (TdiUserInfo.class) {
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

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public TdiLoginScene getLoginScene() {
            TdiLoginScene forNumber = TdiLoginScene.forNumber(this.loginScene_);
            if (forNumber == null) {
                return TdiLoginScene.kTdiLoginSceneNone;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public TdiLoginStatus getLoginStatus() {
            TdiLoginStatus forNumber = TdiLoginStatus.forNumber(this.loginStatus_);
            if (forNumber == null) {
                return TdiLoginStatus.kTdiLoginUnknown;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public int getLoginType() {
            return this.loginType_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public long getUin() {
            return this.uin_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public boolean hasLoginScene() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public boolean hasLoginStatus() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public boolean hasLoginType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public boolean hasUin() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.tdi.TdiApiProto.TdiUserInfoOrBuilder
        public boolean hasUsername() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(TdiUserInfo tdiUserInfo) {
            return DEFAULT_INSTANCE.createBuilder(tdiUserInfo);
        }

        public static TdiUserInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiUserInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiUserInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static TdiUserInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TdiUserInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static TdiUserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TdiUserInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static TdiUserInfo parseFrom(InputStream inputStream) throws IOException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TdiUserInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static TdiUserInfo parseFrom(k kVar) throws IOException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static TdiUserInfo parseFrom(k kVar, t tVar) throws IOException {
            return (TdiUserInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface TdiUserInfoOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        TdiLoginScene getLoginScene();

        TdiLoginStatus getLoginStatus();

        int getLoginType();

        long getUin();

        String getUsername();

        ByteString getUsernameBytes();

        boolean hasLoginScene();

        boolean hasLoginStatus();

        boolean hasLoginType();

        boolean hasUin();

        boolean hasUsername();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    TdiApiProto() {
    }

    public static void registerAllExtensions(t tVar) {
    }
}
