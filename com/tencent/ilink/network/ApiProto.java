package com.tencent.ilink.network;

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
import com.tencent.mobileqq.data.MessageRecord;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class ApiProto {

    /* renamed from: com.tencent.ilink.network.ApiProto$1, reason: invalid class name */
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
    public static final class IlinkAppCommSessionInfo extends GeneratedMessageLite<IlinkAppCommSessionInfo, Builder> implements IlinkAppCommSessionInfoOrBuilder {
        public static final int AUTOAUTH_ENC_KEY_FIELD_NUMBER = 3;
        public static final int CLIENT_SESSION_KEY_FIELD_NUMBER = 1;
        private static final IlinkAppCommSessionInfo DEFAULT_INSTANCE;
        private static volatile bg<IlinkAppCommSessionInfo> PARSER = null;
        public static final int SERVERID_FIELD_NUMBER = 5;
        public static final int SERVER_SESSION_KEY_FIELD_NUMBER = 2;
        public static final int UIN_FIELD_NUMBER = 4;
        private ByteString autoauthEncKey_;
        private int bitField0_;
        private ByteString clientSessionKey_;
        private ByteString serverSessionKey_;
        private ByteString serverid_;
        private long uin_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkAppCommSessionInfo, Builder> implements IlinkAppCommSessionInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAutoauthEncKey() {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).clearAutoauthEncKey();
                return this;
            }

            public Builder clearClientSessionKey() {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).clearClientSessionKey();
                return this;
            }

            public Builder clearServerSessionKey() {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).clearServerSessionKey();
                return this;
            }

            public Builder clearServerid() {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).clearServerid();
                return this;
            }

            public Builder clearUin() {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).clearUin();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public ByteString getAutoauthEncKey() {
                return ((IlinkAppCommSessionInfo) this.instance).getAutoauthEncKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public ByteString getClientSessionKey() {
                return ((IlinkAppCommSessionInfo) this.instance).getClientSessionKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public ByteString getServerSessionKey() {
                return ((IlinkAppCommSessionInfo) this.instance).getServerSessionKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public ByteString getServerid() {
                return ((IlinkAppCommSessionInfo) this.instance).getServerid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public long getUin() {
                return ((IlinkAppCommSessionInfo) this.instance).getUin();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public boolean hasAutoauthEncKey() {
                return ((IlinkAppCommSessionInfo) this.instance).hasAutoauthEncKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public boolean hasClientSessionKey() {
                return ((IlinkAppCommSessionInfo) this.instance).hasClientSessionKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public boolean hasServerSessionKey() {
                return ((IlinkAppCommSessionInfo) this.instance).hasServerSessionKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public boolean hasServerid() {
                return ((IlinkAppCommSessionInfo) this.instance).hasServerid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
            public boolean hasUin() {
                return ((IlinkAppCommSessionInfo) this.instance).hasUin();
            }

            public Builder setAutoauthEncKey(ByteString byteString) {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).setAutoauthEncKey(byteString);
                return this;
            }

            public Builder setClientSessionKey(ByteString byteString) {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).setClientSessionKey(byteString);
                return this;
            }

            public Builder setServerSessionKey(ByteString byteString) {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).setServerSessionKey(byteString);
                return this;
            }

            public Builder setServerid(ByteString byteString) {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).setServerid(byteString);
                return this;
            }

            public Builder setUin(long j3) {
                copyOnWrite();
                ((IlinkAppCommSessionInfo) this.instance).setUin(j3);
                return this;
            }

            Builder() {
                super(IlinkAppCommSessionInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkAppCommSessionInfo ilinkAppCommSessionInfo = new IlinkAppCommSessionInfo();
            DEFAULT_INSTANCE = ilinkAppCommSessionInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkAppCommSessionInfo.class, ilinkAppCommSessionInfo);
        }

        IlinkAppCommSessionInfo() {
            ByteString byteString = ByteString.EMPTY;
            this.clientSessionKey_ = byteString;
            this.serverSessionKey_ = byteString;
            this.autoauthEncKey_ = byteString;
            this.serverid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAutoauthEncKey() {
            this.bitField0_ &= -5;
            this.autoauthEncKey_ = getDefaultInstance().getAutoauthEncKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientSessionKey() {
            this.bitField0_ &= -2;
            this.clientSessionKey_ = getDefaultInstance().getClientSessionKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerSessionKey() {
            this.bitField0_ &= -3;
            this.serverSessionKey_ = getDefaultInstance().getServerSessionKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerid() {
            this.bitField0_ &= -17;
            this.serverid_ = getDefaultInstance().getServerid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUin() {
            this.bitField0_ &= -9;
            this.uin_ = 0L;
        }

        public static IlinkAppCommSessionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkAppCommSessionInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkAppCommSessionInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkAppCommSessionInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAutoauthEncKey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.autoauthEncKey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientSessionKey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.clientSessionKey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerSessionKey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.serverSessionKey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerid(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.serverid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUin(long j3) {
            this.bitField0_ |= 8;
            this.uin_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkAppCommSessionInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002\u0004\u0003\u0003\u0005\n\u0004", new Object[]{"bitField0_", "clientSessionKey_", "serverSessionKey_", "autoauthEncKey_", "uin_", "serverid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkAppCommSessionInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkAppCommSessionInfo.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public ByteString getAutoauthEncKey() {
            return this.autoauthEncKey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public ByteString getClientSessionKey() {
            return this.clientSessionKey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public ByteString getServerSessionKey() {
            return this.serverSessionKey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public ByteString getServerid() {
            return this.serverid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public long getUin() {
            return this.uin_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public boolean hasAutoauthEncKey() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public boolean hasClientSessionKey() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public boolean hasServerSessionKey() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public boolean hasServerid() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppCommSessionInfoOrBuilder
        public boolean hasUin() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkAppCommSessionInfo ilinkAppCommSessionInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkAppCommSessionInfo);
        }

        public static IlinkAppCommSessionInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkAppCommSessionInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkAppCommSessionInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkAppCommSessionInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkAppCommSessionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkAppCommSessionInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkAppCommSessionInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkAppCommSessionInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkAppCommSessionInfo parseFrom(k kVar) throws IOException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkAppCommSessionInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkAppCommSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkAppCommSessionInfoOrBuilder extends av {
        ByteString getAutoauthEncKey();

        ByteString getClientSessionKey();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getServerSessionKey();

        ByteString getServerid();

        long getUin();

        boolean hasAutoauthEncKey();

        boolean hasClientSessionKey();

        boolean hasServerSessionKey();

        boolean hasServerid();

        boolean hasUin();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkAppGetSessionInfo extends GeneratedMessageLite<IlinkAppGetSessionInfo, Builder> implements IlinkAppGetSessionInfoOrBuilder {
        public static final int CLIENT_SESSION_KEY_FIELD_NUMBER = 3;
        public static final int COOKIE_FIELD_NUMBER = 6;
        private static final IlinkAppGetSessionInfo DEFAULT_INSTANCE;
        private static volatile bg<IlinkAppGetSessionInfo> PARSER = null;
        public static final int REAL_UIN_FIELD_NUMBER = 1;
        public static final int SERVERID_FIELD_NUMBER = 5;
        public static final int SERVER_SESSION_KEY_FIELD_NUMBER = 4;
        public static final int SHOW_UIN_FIELD_NUMBER = 2;
        private int bitField0_;
        private ByteString clientSessionKey_;
        private ByteString cookie_;
        private long realUin_;
        private ByteString serverSessionKey_;
        private ByteString serverid_;
        private long showUin_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkAppGetSessionInfo, Builder> implements IlinkAppGetSessionInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearClientSessionKey() {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).clearClientSessionKey();
                return this;
            }

            public Builder clearCookie() {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).clearCookie();
                return this;
            }

            public Builder clearRealUin() {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).clearRealUin();
                return this;
            }

            public Builder clearServerSessionKey() {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).clearServerSessionKey();
                return this;
            }

            public Builder clearServerid() {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).clearServerid();
                return this;
            }

            public Builder clearShowUin() {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).clearShowUin();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public ByteString getClientSessionKey() {
                return ((IlinkAppGetSessionInfo) this.instance).getClientSessionKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public ByteString getCookie() {
                return ((IlinkAppGetSessionInfo) this.instance).getCookie();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public long getRealUin() {
                return ((IlinkAppGetSessionInfo) this.instance).getRealUin();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public ByteString getServerSessionKey() {
                return ((IlinkAppGetSessionInfo) this.instance).getServerSessionKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public ByteString getServerid() {
                return ((IlinkAppGetSessionInfo) this.instance).getServerid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public long getShowUin() {
                return ((IlinkAppGetSessionInfo) this.instance).getShowUin();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public boolean hasClientSessionKey() {
                return ((IlinkAppGetSessionInfo) this.instance).hasClientSessionKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public boolean hasCookie() {
                return ((IlinkAppGetSessionInfo) this.instance).hasCookie();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public boolean hasRealUin() {
                return ((IlinkAppGetSessionInfo) this.instance).hasRealUin();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public boolean hasServerSessionKey() {
                return ((IlinkAppGetSessionInfo) this.instance).hasServerSessionKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public boolean hasServerid() {
                return ((IlinkAppGetSessionInfo) this.instance).hasServerid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
            public boolean hasShowUin() {
                return ((IlinkAppGetSessionInfo) this.instance).hasShowUin();
            }

            public Builder setClientSessionKey(ByteString byteString) {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).setClientSessionKey(byteString);
                return this;
            }

            public Builder setCookie(ByteString byteString) {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).setCookie(byteString);
                return this;
            }

            public Builder setRealUin(long j3) {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).setRealUin(j3);
                return this;
            }

            public Builder setServerSessionKey(ByteString byteString) {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).setServerSessionKey(byteString);
                return this;
            }

            public Builder setServerid(ByteString byteString) {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).setServerid(byteString);
                return this;
            }

            public Builder setShowUin(long j3) {
                copyOnWrite();
                ((IlinkAppGetSessionInfo) this.instance).setShowUin(j3);
                return this;
            }

            Builder() {
                super(IlinkAppGetSessionInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkAppGetSessionInfo ilinkAppGetSessionInfo = new IlinkAppGetSessionInfo();
            DEFAULT_INSTANCE = ilinkAppGetSessionInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkAppGetSessionInfo.class, ilinkAppGetSessionInfo);
        }

        IlinkAppGetSessionInfo() {
            ByteString byteString = ByteString.EMPTY;
            this.clientSessionKey_ = byteString;
            this.serverSessionKey_ = byteString;
            this.serverid_ = byteString;
            this.cookie_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientSessionKey() {
            this.bitField0_ &= -5;
            this.clientSessionKey_ = getDefaultInstance().getClientSessionKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCookie() {
            this.bitField0_ &= -33;
            this.cookie_ = getDefaultInstance().getCookie();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRealUin() {
            this.bitField0_ &= -2;
            this.realUin_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerSessionKey() {
            this.bitField0_ &= -9;
            this.serverSessionKey_ = getDefaultInstance().getServerSessionKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerid() {
            this.bitField0_ &= -17;
            this.serverid_ = getDefaultInstance().getServerid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShowUin() {
            this.bitField0_ &= -3;
            this.showUin_ = 0L;
        }

        public static IlinkAppGetSessionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkAppGetSessionInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkAppGetSessionInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkAppGetSessionInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientSessionKey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.clientSessionKey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCookie(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.cookie_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRealUin(long j3) {
            this.bitField0_ |= 1;
            this.realUin_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerSessionKey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.serverSessionKey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerid(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.serverid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShowUin(long j3) {
            this.bitField0_ |= 2;
            this.showUin_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkAppGetSessionInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0003\u0000\u0002\u0003\u0001\u0003\n\u0002\u0004\n\u0003\u0005\n\u0004\u0006\n\u0005", new Object[]{"bitField0_", "realUin_", "showUin_", "clientSessionKey_", "serverSessionKey_", "serverid_", "cookie_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkAppGetSessionInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkAppGetSessionInfo.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public ByteString getClientSessionKey() {
            return this.clientSessionKey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public ByteString getCookie() {
            return this.cookie_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public long getRealUin() {
            return this.realUin_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public ByteString getServerSessionKey() {
            return this.serverSessionKey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public ByteString getServerid() {
            return this.serverid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public long getShowUin() {
            return this.showUin_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public boolean hasClientSessionKey() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public boolean hasCookie() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public boolean hasRealUin() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public boolean hasServerSessionKey() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public boolean hasServerid() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppGetSessionInfoOrBuilder
        public boolean hasShowUin() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkAppGetSessionInfo ilinkAppGetSessionInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkAppGetSessionInfo);
        }

        public static IlinkAppGetSessionInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkAppGetSessionInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkAppGetSessionInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkAppGetSessionInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkAppGetSessionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkAppGetSessionInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkAppGetSessionInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkAppGetSessionInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkAppGetSessionInfo parseFrom(k kVar) throws IOException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkAppGetSessionInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkAppGetSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkAppGetSessionInfoOrBuilder extends av {
        ByteString getClientSessionKey();

        ByteString getCookie();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        long getRealUin();

        ByteString getServerSessionKey();

        ByteString getServerid();

        long getShowUin();

        boolean hasClientSessionKey();

        boolean hasCookie();

        boolean hasRealUin();

        boolean hasServerSessionKey();

        boolean hasServerid();

        boolean hasShowUin();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkAppLoginInfo extends GeneratedMessageLite<IlinkAppLoginInfo, Builder> implements IlinkAppLoginInfoOrBuilder {
        public static final int AUTH_CODE_FIELD_NUMBER = 1;
        private static final IlinkAppLoginInfo DEFAULT_INSTANCE;
        private static volatile bg<IlinkAppLoginInfo> PARSER = null;
        public static final int SESSION_MODULE_TYPE_FIELD_NUMBER = 3;
        public static final int SESSION_TYPE_FIELD_NUMBER = 2;
        private ByteString authCode_ = ByteString.EMPTY;
        private int bitField0_;
        private int sessionModuleType_;
        private int sessionType_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkAppLoginInfo, Builder> implements IlinkAppLoginInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAuthCode() {
                copyOnWrite();
                ((IlinkAppLoginInfo) this.instance).clearAuthCode();
                return this;
            }

            public Builder clearSessionModuleType() {
                copyOnWrite();
                ((IlinkAppLoginInfo) this.instance).clearSessionModuleType();
                return this;
            }

            public Builder clearSessionType() {
                copyOnWrite();
                ((IlinkAppLoginInfo) this.instance).clearSessionType();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
            public ByteString getAuthCode() {
                return ((IlinkAppLoginInfo) this.instance).getAuthCode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
            public int getSessionModuleType() {
                return ((IlinkAppLoginInfo) this.instance).getSessionModuleType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
            public int getSessionType() {
                return ((IlinkAppLoginInfo) this.instance).getSessionType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
            public boolean hasAuthCode() {
                return ((IlinkAppLoginInfo) this.instance).hasAuthCode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
            public boolean hasSessionModuleType() {
                return ((IlinkAppLoginInfo) this.instance).hasSessionModuleType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
            public boolean hasSessionType() {
                return ((IlinkAppLoginInfo) this.instance).hasSessionType();
            }

            public Builder setAuthCode(ByteString byteString) {
                copyOnWrite();
                ((IlinkAppLoginInfo) this.instance).setAuthCode(byteString);
                return this;
            }

            public Builder setSessionModuleType(int i3) {
                copyOnWrite();
                ((IlinkAppLoginInfo) this.instance).setSessionModuleType(i3);
                return this;
            }

            public Builder setSessionType(int i3) {
                copyOnWrite();
                ((IlinkAppLoginInfo) this.instance).setSessionType(i3);
                return this;
            }

            Builder() {
                super(IlinkAppLoginInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkAppLoginInfo ilinkAppLoginInfo = new IlinkAppLoginInfo();
            DEFAULT_INSTANCE = ilinkAppLoginInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkAppLoginInfo.class, ilinkAppLoginInfo);
        }

        IlinkAppLoginInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAuthCode() {
            this.bitField0_ &= -2;
            this.authCode_ = getDefaultInstance().getAuthCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionModuleType() {
            this.bitField0_ &= -5;
            this.sessionModuleType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionType() {
            this.bitField0_ &= -3;
            this.sessionType_ = 0;
        }

        public static IlinkAppLoginInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkAppLoginInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkAppLoginInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkAppLoginInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAuthCode(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.authCode_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionModuleType(int i3) {
            this.bitField0_ |= 4;
            this.sessionModuleType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionType(int i3) {
            this.bitField0_ |= 2;
            this.sessionType_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkAppLoginInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0000\u0002\u000b\u0001\u0003\u000b\u0002", new Object[]{"bitField0_", "authCode_", "sessionType_", "sessionModuleType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkAppLoginInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkAppLoginInfo.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
        public ByteString getAuthCode() {
            return this.authCode_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
        public int getSessionModuleType() {
            return this.sessionModuleType_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
        public int getSessionType() {
            return this.sessionType_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
        public boolean hasAuthCode() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
        public boolean hasSessionModuleType() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkAppLoginInfoOrBuilder
        public boolean hasSessionType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkAppLoginInfo ilinkAppLoginInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkAppLoginInfo);
        }

        public static IlinkAppLoginInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkAppLoginInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkAppLoginInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkAppLoginInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkAppLoginInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkAppLoginInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkAppLoginInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkAppLoginInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkAppLoginInfo parseFrom(k kVar) throws IOException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkAppLoginInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkAppLoginInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkAppLoginInfoOrBuilder extends av {
        ByteString getAuthCode();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getSessionModuleType();

        int getSessionType();

        boolean hasAuthCode();

        boolean hasSessionModuleType();

        boolean hasSessionType();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkC2CDownload extends GeneratedMessageLite<IlinkC2CDownload, Builder> implements IlinkC2CDownloadOrBuilder {
        public static final int AESKEY_FIELD_NUMBER = 6;
        private static final IlinkC2CDownload DEFAULT_INSTANCE;
        public static final int FILEID_FIELD_NUMBER = 7;
        public static final int FILE_PATH_FIELD_NUMBER = 3;
        public static final int FILE_SIZE_FIELD_NUMBER = 4;
        public static final int FILE_TYPE_FIELD_NUMBER = 2;
        public static final int FILE_URL_FIELD_NUMBER = 5;
        private static volatile bg<IlinkC2CDownload> PARSER = null;
        public static final int TASK_IDENT_FIELD_NUMBER = 1;
        private ByteString aeskey_;
        private int bitField0_;
        private long fileSize_;
        private int fileType_;
        private ByteString fileid_;
        private String taskIdent_ = "";
        private String filePath_ = "";
        private String fileUrl_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkC2CDownload, Builder> implements IlinkC2CDownloadOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAeskey() {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).clearAeskey();
                return this;
            }

            public Builder clearFilePath() {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).clearFilePath();
                return this;
            }

            public Builder clearFileSize() {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).clearFileSize();
                return this;
            }

            public Builder clearFileType() {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).clearFileType();
                return this;
            }

            public Builder clearFileUrl() {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).clearFileUrl();
                return this;
            }

            public Builder clearFileid() {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).clearFileid();
                return this;
            }

            public Builder clearTaskIdent() {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).clearTaskIdent();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public ByteString getAeskey() {
                return ((IlinkC2CDownload) this.instance).getAeskey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public String getFilePath() {
                return ((IlinkC2CDownload) this.instance).getFilePath();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public ByteString getFilePathBytes() {
                return ((IlinkC2CDownload) this.instance).getFilePathBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public long getFileSize() {
                return ((IlinkC2CDownload) this.instance).getFileSize();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public int getFileType() {
                return ((IlinkC2CDownload) this.instance).getFileType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public String getFileUrl() {
                return ((IlinkC2CDownload) this.instance).getFileUrl();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public ByteString getFileUrlBytes() {
                return ((IlinkC2CDownload) this.instance).getFileUrlBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public ByteString getFileid() {
                return ((IlinkC2CDownload) this.instance).getFileid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public String getTaskIdent() {
                return ((IlinkC2CDownload) this.instance).getTaskIdent();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public ByteString getTaskIdentBytes() {
                return ((IlinkC2CDownload) this.instance).getTaskIdentBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public boolean hasAeskey() {
                return ((IlinkC2CDownload) this.instance).hasAeskey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public boolean hasFilePath() {
                return ((IlinkC2CDownload) this.instance).hasFilePath();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public boolean hasFileSize() {
                return ((IlinkC2CDownload) this.instance).hasFileSize();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public boolean hasFileType() {
                return ((IlinkC2CDownload) this.instance).hasFileType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public boolean hasFileUrl() {
                return ((IlinkC2CDownload) this.instance).hasFileUrl();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public boolean hasFileid() {
                return ((IlinkC2CDownload) this.instance).hasFileid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
            public boolean hasTaskIdent() {
                return ((IlinkC2CDownload) this.instance).hasTaskIdent();
            }

            public Builder setAeskey(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setAeskey(byteString);
                return this;
            }

            public Builder setFilePath(String str) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setFilePath(str);
                return this;
            }

            public Builder setFilePathBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setFilePathBytes(byteString);
                return this;
            }

            public Builder setFileSize(long j3) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setFileSize(j3);
                return this;
            }

            public Builder setFileType(int i3) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setFileType(i3);
                return this;
            }

            public Builder setFileUrl(String str) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setFileUrl(str);
                return this;
            }

            public Builder setFileUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setFileUrlBytes(byteString);
                return this;
            }

            public Builder setFileid(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setFileid(byteString);
                return this;
            }

            public Builder setTaskIdent(String str) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setTaskIdent(str);
                return this;
            }

            public Builder setTaskIdentBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CDownload) this.instance).setTaskIdentBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkC2CDownload.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkC2CDownload ilinkC2CDownload = new IlinkC2CDownload();
            DEFAULT_INSTANCE = ilinkC2CDownload;
            GeneratedMessageLite.registerDefaultInstance(IlinkC2CDownload.class, ilinkC2CDownload);
        }

        IlinkC2CDownload() {
            ByteString byteString = ByteString.EMPTY;
            this.aeskey_ = byteString;
            this.fileid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAeskey() {
            this.bitField0_ &= -33;
            this.aeskey_ = getDefaultInstance().getAeskey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFilePath() {
            this.bitField0_ &= -5;
            this.filePath_ = getDefaultInstance().getFilePath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileSize() {
            this.bitField0_ &= -9;
            this.fileSize_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileType() {
            this.bitField0_ &= -3;
            this.fileType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileUrl() {
            this.bitField0_ &= -17;
            this.fileUrl_ = getDefaultInstance().getFileUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileid() {
            this.bitField0_ &= -65;
            this.fileid_ = getDefaultInstance().getFileid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskIdent() {
            this.bitField0_ &= -2;
            this.taskIdent_ = getDefaultInstance().getTaskIdent();
        }

        public static IlinkC2CDownload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkC2CDownload parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkC2CDownload parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkC2CDownload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAeskey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.aeskey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilePath(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.filePath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilePathBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.filePath_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileSize(long j3) {
            this.bitField0_ |= 8;
            this.fileSize_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileType(int i3) {
            this.bitField0_ |= 2;
            this.fileType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileUrl(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.fileUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileUrlBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.fileUrl_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileid(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.fileid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskIdent(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.taskIdent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskIdentBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.taskIdent_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkC2CDownload();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\b\u0002\u0004\u0003\u0003\u0005\b\u0004\u0006\n\u0005\u0007\n\u0006", new Object[]{"bitField0_", "taskIdent_", "fileType_", "filePath_", "fileSize_", "fileUrl_", "aeskey_", "fileid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkC2CDownload> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkC2CDownload.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public ByteString getAeskey() {
            return this.aeskey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public String getFilePath() {
            return this.filePath_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public ByteString getFilePathBytes() {
            return ByteString.copyFromUtf8(this.filePath_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public long getFileSize() {
            return this.fileSize_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public int getFileType() {
            return this.fileType_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public String getFileUrl() {
            return this.fileUrl_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public ByteString getFileUrlBytes() {
            return ByteString.copyFromUtf8(this.fileUrl_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public ByteString getFileid() {
            return this.fileid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public String getTaskIdent() {
            return this.taskIdent_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public ByteString getTaskIdentBytes() {
            return ByteString.copyFromUtf8(this.taskIdent_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public boolean hasAeskey() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public boolean hasFilePath() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public boolean hasFileSize() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public boolean hasFileType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public boolean hasFileUrl() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public boolean hasFileid() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadOrBuilder
        public boolean hasTaskIdent() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkC2CDownload ilinkC2CDownload) {
            return DEFAULT_INSTANCE.createBuilder(ilinkC2CDownload);
        }

        public static IlinkC2CDownload parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkC2CDownload parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkC2CDownload parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkC2CDownload parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkC2CDownload parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkC2CDownload parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkC2CDownload parseFrom(InputStream inputStream) throws IOException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkC2CDownload parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkC2CDownload parseFrom(k kVar) throws IOException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkC2CDownload parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkC2CDownload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkC2CDownloadOrBuilder extends av {
        ByteString getAeskey();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getFilePath();

        ByteString getFilePathBytes();

        long getFileSize();

        int getFileType();

        String getFileUrl();

        ByteString getFileUrlBytes();

        ByteString getFileid();

        String getTaskIdent();

        ByteString getTaskIdentBytes();

        boolean hasAeskey();

        boolean hasFilePath();

        boolean hasFileSize();

        boolean hasFileType();

        boolean hasFileUrl();

        boolean hasFileid();

        boolean hasTaskIdent();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkC2CDownloadResult extends GeneratedMessageLite<IlinkC2CDownloadResult, Builder> implements IlinkC2CDownloadResultOrBuilder {
        private static final IlinkC2CDownloadResult DEFAULT_INSTANCE;
        public static final int END_TIME_FIELD_NUMBER = 7;
        public static final int EN_QUEUETIME_FIELD_NUMBER = 5;
        public static final int ERROR_CODE_FIELD_NUMBER = 1;
        public static final int FILE_SIZE_FIELD_NUMBER = 3;
        private static volatile bg<IlinkC2CDownloadResult> PARSER = null;
        public static final int RECVED_BYTES_FIELD_NUMBER = 4;
        public static final int START_TIME_FIELD_NUMBER = 6;
        public static final int TASK_IDENT_FIELD_NUMBER = 2;
        private int bitField0_;
        private long enQueuetime_;
        private long endTime_;
        private int errorCode_;
        private long fileSize_;
        private long recvedBytes_;
        private long startTime_;
        private String taskIdent_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkC2CDownloadResult, Builder> implements IlinkC2CDownloadResultOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearEnQueuetime() {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).clearEnQueuetime();
                return this;
            }

            public Builder clearEndTime() {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).clearEndTime();
                return this;
            }

            public Builder clearErrorCode() {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).clearErrorCode();
                return this;
            }

            public Builder clearFileSize() {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).clearFileSize();
                return this;
            }

            public Builder clearRecvedBytes() {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).clearRecvedBytes();
                return this;
            }

            public Builder clearStartTime() {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).clearStartTime();
                return this;
            }

            public Builder clearTaskIdent() {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).clearTaskIdent();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public long getEnQueuetime() {
                return ((IlinkC2CDownloadResult) this.instance).getEnQueuetime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public long getEndTime() {
                return ((IlinkC2CDownloadResult) this.instance).getEndTime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public int getErrorCode() {
                return ((IlinkC2CDownloadResult) this.instance).getErrorCode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public long getFileSize() {
                return ((IlinkC2CDownloadResult) this.instance).getFileSize();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public long getRecvedBytes() {
                return ((IlinkC2CDownloadResult) this.instance).getRecvedBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public long getStartTime() {
                return ((IlinkC2CDownloadResult) this.instance).getStartTime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public String getTaskIdent() {
                return ((IlinkC2CDownloadResult) this.instance).getTaskIdent();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public ByteString getTaskIdentBytes() {
                return ((IlinkC2CDownloadResult) this.instance).getTaskIdentBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public boolean hasEnQueuetime() {
                return ((IlinkC2CDownloadResult) this.instance).hasEnQueuetime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public boolean hasEndTime() {
                return ((IlinkC2CDownloadResult) this.instance).hasEndTime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public boolean hasErrorCode() {
                return ((IlinkC2CDownloadResult) this.instance).hasErrorCode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public boolean hasFileSize() {
                return ((IlinkC2CDownloadResult) this.instance).hasFileSize();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public boolean hasRecvedBytes() {
                return ((IlinkC2CDownloadResult) this.instance).hasRecvedBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public boolean hasStartTime() {
                return ((IlinkC2CDownloadResult) this.instance).hasStartTime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
            public boolean hasTaskIdent() {
                return ((IlinkC2CDownloadResult) this.instance).hasTaskIdent();
            }

            public Builder setEnQueuetime(long j3) {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).setEnQueuetime(j3);
                return this;
            }

            public Builder setEndTime(long j3) {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).setEndTime(j3);
                return this;
            }

            public Builder setErrorCode(int i3) {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).setErrorCode(i3);
                return this;
            }

            public Builder setFileSize(long j3) {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).setFileSize(j3);
                return this;
            }

            public Builder setRecvedBytes(long j3) {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).setRecvedBytes(j3);
                return this;
            }

            public Builder setStartTime(long j3) {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).setStartTime(j3);
                return this;
            }

            public Builder setTaskIdent(String str) {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).setTaskIdent(str);
                return this;
            }

            public Builder setTaskIdentBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CDownloadResult) this.instance).setTaskIdentBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkC2CDownloadResult.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkC2CDownloadResult ilinkC2CDownloadResult = new IlinkC2CDownloadResult();
            DEFAULT_INSTANCE = ilinkC2CDownloadResult;
            GeneratedMessageLite.registerDefaultInstance(IlinkC2CDownloadResult.class, ilinkC2CDownloadResult);
        }

        IlinkC2CDownloadResult() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnQueuetime() {
            this.bitField0_ &= -17;
            this.enQueuetime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTime() {
            this.bitField0_ &= -65;
            this.endTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorCode() {
            this.bitField0_ &= -2;
            this.errorCode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileSize() {
            this.bitField0_ &= -5;
            this.fileSize_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecvedBytes() {
            this.bitField0_ &= -9;
            this.recvedBytes_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTime() {
            this.bitField0_ &= -33;
            this.startTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskIdent() {
            this.bitField0_ &= -3;
            this.taskIdent_ = getDefaultInstance().getTaskIdent();
        }

        public static IlinkC2CDownloadResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkC2CDownloadResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkC2CDownloadResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkC2CDownloadResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnQueuetime(long j3) {
            this.bitField0_ |= 16;
            this.enQueuetime_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTime(long j3) {
            this.bitField0_ |= 64;
            this.endTime_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorCode(int i3) {
            this.bitField0_ |= 1;
            this.errorCode_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileSize(long j3) {
            this.bitField0_ |= 4;
            this.fileSize_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecvedBytes(long j3) {
            this.bitField0_ |= 8;
            this.recvedBytes_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTime(long j3) {
            this.bitField0_ |= 32;
            this.startTime_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskIdent(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.taskIdent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskIdentBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.taskIdent_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkC2CDownloadResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0003\u0002\u0004\u0003\u0003\u0005\u0003\u0004\u0006\u0003\u0005\u0007\u0003\u0006", new Object[]{"bitField0_", "errorCode_", "taskIdent_", "fileSize_", "recvedBytes_", "enQueuetime_", "startTime_", "endTime_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkC2CDownloadResult> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkC2CDownloadResult.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public long getEnQueuetime() {
            return this.enQueuetime_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public long getEndTime() {
            return this.endTime_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public int getErrorCode() {
            return this.errorCode_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public long getFileSize() {
            return this.fileSize_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public long getRecvedBytes() {
            return this.recvedBytes_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public long getStartTime() {
            return this.startTime_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public String getTaskIdent() {
            return this.taskIdent_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public ByteString getTaskIdentBytes() {
            return ByteString.copyFromUtf8(this.taskIdent_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public boolean hasEnQueuetime() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public boolean hasEndTime() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public boolean hasErrorCode() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public boolean hasFileSize() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public boolean hasRecvedBytes() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public boolean hasStartTime() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CDownloadResultOrBuilder
        public boolean hasTaskIdent() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkC2CDownloadResult ilinkC2CDownloadResult) {
            return DEFAULT_INSTANCE.createBuilder(ilinkC2CDownloadResult);
        }

        public static IlinkC2CDownloadResult parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkC2CDownloadResult parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkC2CDownloadResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkC2CDownloadResult parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkC2CDownloadResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkC2CDownloadResult parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkC2CDownloadResult parseFrom(InputStream inputStream) throws IOException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkC2CDownloadResult parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkC2CDownloadResult parseFrom(k kVar) throws IOException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkC2CDownloadResult parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkC2CDownloadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkC2CDownloadResultOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        long getEnQueuetime();

        long getEndTime();

        int getErrorCode();

        long getFileSize();

        long getRecvedBytes();

        long getStartTime();

        String getTaskIdent();

        ByteString getTaskIdentBytes();

        boolean hasEnQueuetime();

        boolean hasEndTime();

        boolean hasErrorCode();

        boolean hasFileSize();

        boolean hasRecvedBytes();

        boolean hasStartTime();

        boolean hasTaskIdent();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkC2CUpload extends GeneratedMessageLite<IlinkC2CUpload, Builder> implements IlinkC2CUploadOrBuilder {
        public static final int APP_TYPE_FIELD_NUMBER = 6;
        public static final int BIZ_SCENE_FIELD_NUMBER = 5;
        private static final IlinkC2CUpload DEFAULT_INSTANCE;
        public static final int FILE_DATA_FIELD_NUMBER = 9;
        public static final int FILE_PATH_FIELD_NUMBER = 3;
        public static final int FILE_TYPE_FIELD_NUMBER = 2;
        public static final int IS_STORAGE_MODE_FIELD_NUMBER = 7;
        private static volatile bg<IlinkC2CUpload> PARSER = null;
        public static final int SNS_UPLOAD_VERSION_FIELD_NUMBER = 8;
        public static final int TASK_IDENT_FIELD_NUMBER = 1;
        public static final int THUMB_FILEDATA_FIELD_NUMBER = 10;
        public static final int THUMB_FILEPATH_FIELD_NUMBER = 4;
        private int appType_;
        private int bitField0_;
        private int bizScene_;
        private ByteString fileData_;
        private int fileType_;
        private boolean isStorageMode_;
        private int snsUploadVersion_;
        private ByteString thumbFiledata_;
        private String taskIdent_ = "";
        private String filePath_ = "";
        private String thumbFilepath_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkC2CUpload, Builder> implements IlinkC2CUploadOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppType() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearAppType();
                return this;
            }

            public Builder clearBizScene() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearBizScene();
                return this;
            }

            public Builder clearFileData() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearFileData();
                return this;
            }

            public Builder clearFilePath() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearFilePath();
                return this;
            }

            public Builder clearFileType() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearFileType();
                return this;
            }

            public Builder clearIsStorageMode() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearIsStorageMode();
                return this;
            }

            public Builder clearSnsUploadVersion() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearSnsUploadVersion();
                return this;
            }

            public Builder clearTaskIdent() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearTaskIdent();
                return this;
            }

            public Builder clearThumbFiledata() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearThumbFiledata();
                return this;
            }

            public Builder clearThumbFilepath() {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).clearThumbFilepath();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public int getAppType() {
                return ((IlinkC2CUpload) this.instance).getAppType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public IlinkEBizScene getBizScene() {
                return ((IlinkC2CUpload) this.instance).getBizScene();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public ByteString getFileData() {
                return ((IlinkC2CUpload) this.instance).getFileData();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public String getFilePath() {
                return ((IlinkC2CUpload) this.instance).getFilePath();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public ByteString getFilePathBytes() {
                return ((IlinkC2CUpload) this.instance).getFilePathBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public int getFileType() {
                return ((IlinkC2CUpload) this.instance).getFileType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean getIsStorageMode() {
                return ((IlinkC2CUpload) this.instance).getIsStorageMode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public int getSnsUploadVersion() {
                return ((IlinkC2CUpload) this.instance).getSnsUploadVersion();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public String getTaskIdent() {
                return ((IlinkC2CUpload) this.instance).getTaskIdent();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public ByteString getTaskIdentBytes() {
                return ((IlinkC2CUpload) this.instance).getTaskIdentBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public ByteString getThumbFiledata() {
                return ((IlinkC2CUpload) this.instance).getThumbFiledata();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public String getThumbFilepath() {
                return ((IlinkC2CUpload) this.instance).getThumbFilepath();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public ByteString getThumbFilepathBytes() {
                return ((IlinkC2CUpload) this.instance).getThumbFilepathBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasAppType() {
                return ((IlinkC2CUpload) this.instance).hasAppType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasBizScene() {
                return ((IlinkC2CUpload) this.instance).hasBizScene();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasFileData() {
                return ((IlinkC2CUpload) this.instance).hasFileData();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasFilePath() {
                return ((IlinkC2CUpload) this.instance).hasFilePath();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasFileType() {
                return ((IlinkC2CUpload) this.instance).hasFileType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasIsStorageMode() {
                return ((IlinkC2CUpload) this.instance).hasIsStorageMode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasSnsUploadVersion() {
                return ((IlinkC2CUpload) this.instance).hasSnsUploadVersion();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasTaskIdent() {
                return ((IlinkC2CUpload) this.instance).hasTaskIdent();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasThumbFiledata() {
                return ((IlinkC2CUpload) this.instance).hasThumbFiledata();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
            public boolean hasThumbFilepath() {
                return ((IlinkC2CUpload) this.instance).hasThumbFilepath();
            }

            public Builder setAppType(int i3) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setAppType(i3);
                return this;
            }

            public Builder setBizScene(IlinkEBizScene ilinkEBizScene) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setBizScene(ilinkEBizScene);
                return this;
            }

            public Builder setFileData(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setFileData(byteString);
                return this;
            }

            public Builder setFilePath(String str) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setFilePath(str);
                return this;
            }

            public Builder setFilePathBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setFilePathBytes(byteString);
                return this;
            }

            public Builder setFileType(int i3) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setFileType(i3);
                return this;
            }

            public Builder setIsStorageMode(boolean z16) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setIsStorageMode(z16);
                return this;
            }

            public Builder setSnsUploadVersion(int i3) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setSnsUploadVersion(i3);
                return this;
            }

            public Builder setTaskIdent(String str) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setTaskIdent(str);
                return this;
            }

            public Builder setTaskIdentBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setTaskIdentBytes(byteString);
                return this;
            }

            public Builder setThumbFiledata(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setThumbFiledata(byteString);
                return this;
            }

            public Builder setThumbFilepath(String str) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setThumbFilepath(str);
                return this;
            }

            public Builder setThumbFilepathBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUpload) this.instance).setThumbFilepathBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkC2CUpload.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkC2CUpload ilinkC2CUpload = new IlinkC2CUpload();
            DEFAULT_INSTANCE = ilinkC2CUpload;
            GeneratedMessageLite.registerDefaultInstance(IlinkC2CUpload.class, ilinkC2CUpload);
        }

        IlinkC2CUpload() {
            ByteString byteString = ByteString.EMPTY;
            this.fileData_ = byteString;
            this.thumbFiledata_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppType() {
            this.bitField0_ &= -33;
            this.appType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBizScene() {
            this.bitField0_ &= -17;
            this.bizScene_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileData() {
            this.bitField0_ &= -257;
            this.fileData_ = getDefaultInstance().getFileData();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFilePath() {
            this.bitField0_ &= -5;
            this.filePath_ = getDefaultInstance().getFilePath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileType() {
            this.bitField0_ &= -3;
            this.fileType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsStorageMode() {
            this.bitField0_ &= -65;
            this.isStorageMode_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSnsUploadVersion() {
            this.bitField0_ &= -129;
            this.snsUploadVersion_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskIdent() {
            this.bitField0_ &= -2;
            this.taskIdent_ = getDefaultInstance().getTaskIdent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThumbFiledata() {
            this.bitField0_ &= -513;
            this.thumbFiledata_ = getDefaultInstance().getThumbFiledata();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThumbFilepath() {
            this.bitField0_ &= -9;
            this.thumbFilepath_ = getDefaultInstance().getThumbFilepath();
        }

        public static IlinkC2CUpload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkC2CUpload parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkC2CUpload parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkC2CUpload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAppType(int i3) {
            this.bitField0_ |= 32;
            this.appType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBizScene(IlinkEBizScene ilinkEBizScene) {
            ilinkEBizScene.getClass();
            this.bitField0_ |= 16;
            this.bizScene_ = ilinkEBizScene.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileData(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 256;
            this.fileData_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilePath(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.filePath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFilePathBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.filePath_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileType(int i3) {
            this.bitField0_ |= 2;
            this.fileType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsStorageMode(boolean z16) {
            this.bitField0_ |= 64;
            this.isStorageMode_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSnsUploadVersion(int i3) {
            this.bitField0_ |= 128;
            this.snsUploadVersion_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskIdent(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.taskIdent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskIdentBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.taskIdent_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThumbFiledata(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 512;
            this.thumbFiledata_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThumbFilepath(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.thumbFilepath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThumbFilepathBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.thumbFilepath_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkC2CUpload();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\f\u0004\u0006\u000b\u0005\u0007\u0007\u0006\b\u000b\u0007\t\n\b\n\n\t", new Object[]{"bitField0_", "taskIdent_", "fileType_", "filePath_", "thumbFilepath_", "bizScene_", IlinkEBizScene.internalGetVerifier(), "appType_", "isStorageMode_", "snsUploadVersion_", "fileData_", "thumbFiledata_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkC2CUpload> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkC2CUpload.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public int getAppType() {
            return this.appType_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public IlinkEBizScene getBizScene() {
            IlinkEBizScene forNumber = IlinkEBizScene.forNumber(this.bizScene_);
            if (forNumber == null) {
                return IlinkEBizScene.kC2CScene;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public ByteString getFileData() {
            return this.fileData_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public String getFilePath() {
            return this.filePath_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public ByteString getFilePathBytes() {
            return ByteString.copyFromUtf8(this.filePath_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public int getFileType() {
            return this.fileType_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean getIsStorageMode() {
            return this.isStorageMode_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public int getSnsUploadVersion() {
            return this.snsUploadVersion_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public String getTaskIdent() {
            return this.taskIdent_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public ByteString getTaskIdentBytes() {
            return ByteString.copyFromUtf8(this.taskIdent_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public ByteString getThumbFiledata() {
            return this.thumbFiledata_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public String getThumbFilepath() {
            return this.thumbFilepath_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public ByteString getThumbFilepathBytes() {
            return ByteString.copyFromUtf8(this.thumbFilepath_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasAppType() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasBizScene() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasFileData() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasFilePath() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasFileType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasIsStorageMode() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasSnsUploadVersion() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasTaskIdent() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasThumbFiledata() {
            if ((this.bitField0_ & 512) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadOrBuilder
        public boolean hasThumbFilepath() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkC2CUpload ilinkC2CUpload) {
            return DEFAULT_INSTANCE.createBuilder(ilinkC2CUpload);
        }

        public static IlinkC2CUpload parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkC2CUpload parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkC2CUpload parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkC2CUpload parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkC2CUpload parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkC2CUpload parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkC2CUpload parseFrom(InputStream inputStream) throws IOException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkC2CUpload parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkC2CUpload parseFrom(k kVar) throws IOException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkC2CUpload parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkC2CUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkC2CUploadOrBuilder extends av {
        int getAppType();

        IlinkEBizScene getBizScene();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getFileData();

        String getFilePath();

        ByteString getFilePathBytes();

        int getFileType();

        boolean getIsStorageMode();

        int getSnsUploadVersion();

        String getTaskIdent();

        ByteString getTaskIdentBytes();

        ByteString getThumbFiledata();

        String getThumbFilepath();

        ByteString getThumbFilepathBytes();

        boolean hasAppType();

        boolean hasBizScene();

        boolean hasFileData();

        boolean hasFilePath();

        boolean hasFileType();

        boolean hasIsStorageMode();

        boolean hasSnsUploadVersion();

        boolean hasTaskIdent();

        boolean hasThumbFiledata();

        boolean hasThumbFilepath();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkC2CUploadResult extends GeneratedMessageLite<IlinkC2CUploadResult, Builder> implements IlinkC2CUploadResultOrBuilder {
        public static final int AESKEY_FIELD_NUMBER = 7;
        private static final IlinkC2CUploadResult DEFAULT_INSTANCE;
        public static final int ERROR_CODE_FIELD_NUMBER = 1;
        public static final int FILEID_FIELD_NUMBER = 6;
        public static final int FILE_SIZE_FIELD_NUMBER = 3;
        public static final int FILE_URL_FIELD_NUMBER = 4;
        private static volatile bg<IlinkC2CUploadResult> PARSER = null;
        public static final int TASK_IDENT_FIELD_NUMBER = 2;
        public static final int THUMB_URL_FIELD_NUMBER = 5;
        private ByteString aeskey_;
        private int bitField0_;
        private int errorCode_;
        private long fileSize_;
        private ByteString fileid_;
        private String taskIdent_ = "";
        private String fileUrl_ = "";
        private String thumbUrl_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkC2CUploadResult, Builder> implements IlinkC2CUploadResultOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAeskey() {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).clearAeskey();
                return this;
            }

            public Builder clearErrorCode() {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).clearErrorCode();
                return this;
            }

            public Builder clearFileSize() {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).clearFileSize();
                return this;
            }

            public Builder clearFileUrl() {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).clearFileUrl();
                return this;
            }

            public Builder clearFileid() {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).clearFileid();
                return this;
            }

            public Builder clearTaskIdent() {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).clearTaskIdent();
                return this;
            }

            public Builder clearThumbUrl() {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).clearThumbUrl();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public ByteString getAeskey() {
                return ((IlinkC2CUploadResult) this.instance).getAeskey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public int getErrorCode() {
                return ((IlinkC2CUploadResult) this.instance).getErrorCode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public long getFileSize() {
                return ((IlinkC2CUploadResult) this.instance).getFileSize();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public String getFileUrl() {
                return ((IlinkC2CUploadResult) this.instance).getFileUrl();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public ByteString getFileUrlBytes() {
                return ((IlinkC2CUploadResult) this.instance).getFileUrlBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public ByteString getFileid() {
                return ((IlinkC2CUploadResult) this.instance).getFileid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public String getTaskIdent() {
                return ((IlinkC2CUploadResult) this.instance).getTaskIdent();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public ByteString getTaskIdentBytes() {
                return ((IlinkC2CUploadResult) this.instance).getTaskIdentBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public String getThumbUrl() {
                return ((IlinkC2CUploadResult) this.instance).getThumbUrl();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public ByteString getThumbUrlBytes() {
                return ((IlinkC2CUploadResult) this.instance).getThumbUrlBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public boolean hasAeskey() {
                return ((IlinkC2CUploadResult) this.instance).hasAeskey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public boolean hasErrorCode() {
                return ((IlinkC2CUploadResult) this.instance).hasErrorCode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public boolean hasFileSize() {
                return ((IlinkC2CUploadResult) this.instance).hasFileSize();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public boolean hasFileUrl() {
                return ((IlinkC2CUploadResult) this.instance).hasFileUrl();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public boolean hasFileid() {
                return ((IlinkC2CUploadResult) this.instance).hasFileid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public boolean hasTaskIdent() {
                return ((IlinkC2CUploadResult) this.instance).hasTaskIdent();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
            public boolean hasThumbUrl() {
                return ((IlinkC2CUploadResult) this.instance).hasThumbUrl();
            }

            public Builder setAeskey(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setAeskey(byteString);
                return this;
            }

            public Builder setErrorCode(int i3) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setErrorCode(i3);
                return this;
            }

            public Builder setFileSize(long j3) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setFileSize(j3);
                return this;
            }

            public Builder setFileUrl(String str) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setFileUrl(str);
                return this;
            }

            public Builder setFileUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setFileUrlBytes(byteString);
                return this;
            }

            public Builder setFileid(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setFileid(byteString);
                return this;
            }

            public Builder setTaskIdent(String str) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setTaskIdent(str);
                return this;
            }

            public Builder setTaskIdentBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setTaskIdentBytes(byteString);
                return this;
            }

            public Builder setThumbUrl(String str) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setThumbUrl(str);
                return this;
            }

            public Builder setThumbUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkC2CUploadResult) this.instance).setThumbUrlBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkC2CUploadResult.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkC2CUploadResult ilinkC2CUploadResult = new IlinkC2CUploadResult();
            DEFAULT_INSTANCE = ilinkC2CUploadResult;
            GeneratedMessageLite.registerDefaultInstance(IlinkC2CUploadResult.class, ilinkC2CUploadResult);
        }

        IlinkC2CUploadResult() {
            ByteString byteString = ByteString.EMPTY;
            this.fileid_ = byteString;
            this.aeskey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAeskey() {
            this.bitField0_ &= -65;
            this.aeskey_ = getDefaultInstance().getAeskey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrorCode() {
            this.bitField0_ &= -2;
            this.errorCode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileSize() {
            this.bitField0_ &= -5;
            this.fileSize_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileUrl() {
            this.bitField0_ &= -9;
            this.fileUrl_ = getDefaultInstance().getFileUrl();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFileid() {
            this.bitField0_ &= -33;
            this.fileid_ = getDefaultInstance().getFileid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskIdent() {
            this.bitField0_ &= -3;
            this.taskIdent_ = getDefaultInstance().getTaskIdent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearThumbUrl() {
            this.bitField0_ &= -17;
            this.thumbUrl_ = getDefaultInstance().getThumbUrl();
        }

        public static IlinkC2CUploadResult getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkC2CUploadResult parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkC2CUploadResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkC2CUploadResult> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAeskey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.aeskey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrorCode(int i3) {
            this.bitField0_ |= 1;
            this.errorCode_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileSize(long j3) {
            this.bitField0_ |= 4;
            this.fileSize_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileUrl(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.fileUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileUrlBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.fileUrl_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFileid(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.fileid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskIdent(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.taskIdent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskIdentBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.taskIdent_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThumbUrl(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.thumbUrl_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setThumbUrlBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.thumbUrl_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkC2CUploadResult();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u0003\u0002\u0004\b\u0003\u0005\b\u0004\u0006\n\u0005\u0007\n\u0006", new Object[]{"bitField0_", "errorCode_", "taskIdent_", "fileSize_", "fileUrl_", "thumbUrl_", "fileid_", "aeskey_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkC2CUploadResult> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkC2CUploadResult.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public ByteString getAeskey() {
            return this.aeskey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public int getErrorCode() {
            return this.errorCode_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public long getFileSize() {
            return this.fileSize_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public String getFileUrl() {
            return this.fileUrl_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public ByteString getFileUrlBytes() {
            return ByteString.copyFromUtf8(this.fileUrl_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public ByteString getFileid() {
            return this.fileid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public String getTaskIdent() {
            return this.taskIdent_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public ByteString getTaskIdentBytes() {
            return ByteString.copyFromUtf8(this.taskIdent_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public String getThumbUrl() {
            return this.thumbUrl_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public ByteString getThumbUrlBytes() {
            return ByteString.copyFromUtf8(this.thumbUrl_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public boolean hasAeskey() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public boolean hasErrorCode() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public boolean hasFileSize() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public boolean hasFileUrl() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public boolean hasFileid() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public boolean hasTaskIdent() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkC2CUploadResultOrBuilder
        public boolean hasThumbUrl() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkC2CUploadResult ilinkC2CUploadResult) {
            return DEFAULT_INSTANCE.createBuilder(ilinkC2CUploadResult);
        }

        public static IlinkC2CUploadResult parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkC2CUploadResult parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkC2CUploadResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkC2CUploadResult parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkC2CUploadResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkC2CUploadResult parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkC2CUploadResult parseFrom(InputStream inputStream) throws IOException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkC2CUploadResult parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkC2CUploadResult parseFrom(k kVar) throws IOException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkC2CUploadResult parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkC2CUploadResult) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkC2CUploadResultOrBuilder extends av {
        ByteString getAeskey();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getErrorCode();

        long getFileSize();

        String getFileUrl();

        ByteString getFileUrlBytes();

        ByteString getFileid();

        String getTaskIdent();

        ByteString getTaskIdentBytes();

        String getThumbUrl();

        ByteString getThumbUrlBytes();

        boolean hasAeskey();

        boolean hasErrorCode();

        boolean hasFileSize();

        boolean hasFileUrl();

        boolean hasFileid();

        boolean hasTaskIdent();

        boolean hasThumbUrl();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum IlinkCdnFileType implements ad.c {
        kMediaTypeFile(5),
        kMediaTypeAppImageStorage(kMediaTypeAppImageStorage_VALUE);

        private static final ad.d<IlinkCdnFileType> internalValueMap = new ad.d<IlinkCdnFileType>() { // from class: com.tencent.ilink.network.ApiProto.IlinkCdnFileType.1
            @Override // com.google.protobuf.ad.d
            public IlinkCdnFileType findValueByNumber(int i3) {
                return IlinkCdnFileType.forNumber(i3);
            }
        };
        public static final int kMediaTypeAppImageStorage_VALUE = 20304;
        public static final int kMediaTypeFile_VALUE = 5;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class IlinkCdnFileTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new IlinkCdnFileTypeVerifier();

            IlinkCdnFileTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (IlinkCdnFileType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        IlinkCdnFileType(int i3) {
            this.value = i3;
        }

        public static IlinkCdnFileType forNumber(int i3) {
            if (i3 != 5) {
                if (i3 != 20304) {
                    return null;
                }
                return kMediaTypeAppImageStorage;
            }
            return kMediaTypeFile;
        }

        public static ad.d<IlinkCdnFileType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return IlinkCdnFileTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static IlinkCdnFileType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class IlinkCmdItem extends GeneratedMessageLite<IlinkCmdItem, Builder> implements IlinkCmdItemOrBuilder {
        public static final int CMDBUF_FIELD_NUMBER = 2;
        public static final int CMDID_FIELD_NUMBER = 1;
        private static final IlinkCmdItem DEFAULT_INSTANCE;
        private static volatile bg<IlinkCmdItem> PARSER;
        private int bitField0_;
        private ByteString cmdbuf_ = ByteString.EMPTY;
        private int cmdid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkCmdItem, Builder> implements IlinkCmdItemOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCmdbuf() {
                copyOnWrite();
                ((IlinkCmdItem) this.instance).clearCmdbuf();
                return this;
            }

            public Builder clearCmdid() {
                copyOnWrite();
                ((IlinkCmdItem) this.instance).clearCmdid();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkCmdItemOrBuilder
            public ByteString getCmdbuf() {
                return ((IlinkCmdItem) this.instance).getCmdbuf();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkCmdItemOrBuilder
            public int getCmdid() {
                return ((IlinkCmdItem) this.instance).getCmdid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkCmdItemOrBuilder
            public boolean hasCmdbuf() {
                return ((IlinkCmdItem) this.instance).hasCmdbuf();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkCmdItemOrBuilder
            public boolean hasCmdid() {
                return ((IlinkCmdItem) this.instance).hasCmdid();
            }

            public Builder setCmdbuf(ByteString byteString) {
                copyOnWrite();
                ((IlinkCmdItem) this.instance).setCmdbuf(byteString);
                return this;
            }

            public Builder setCmdid(int i3) {
                copyOnWrite();
                ((IlinkCmdItem) this.instance).setCmdid(i3);
                return this;
            }

            Builder() {
                super(IlinkCmdItem.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkCmdItem ilinkCmdItem = new IlinkCmdItem();
            DEFAULT_INSTANCE = ilinkCmdItem;
            GeneratedMessageLite.registerDefaultInstance(IlinkCmdItem.class, ilinkCmdItem);
        }

        IlinkCmdItem() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCmdbuf() {
            this.bitField0_ &= -3;
            this.cmdbuf_ = getDefaultInstance().getCmdbuf();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCmdid() {
            this.bitField0_ &= -2;
            this.cmdid_ = 0;
        }

        public static IlinkCmdItem getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkCmdItem parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkCmdItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkCmdItem parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkCmdItem> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCmdbuf(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.cmdbuf_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCmdid(int i3) {
            this.bitField0_ |= 1;
            this.cmdid_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkCmdItem();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\n\u0001", new Object[]{"bitField0_", "cmdid_", "cmdbuf_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkCmdItem> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkCmdItem.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkCmdItemOrBuilder
        public ByteString getCmdbuf() {
            return this.cmdbuf_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkCmdItemOrBuilder
        public int getCmdid() {
            return this.cmdid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkCmdItemOrBuilder
        public boolean hasCmdbuf() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkCmdItemOrBuilder
        public boolean hasCmdid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkCmdItem ilinkCmdItem) {
            return DEFAULT_INSTANCE.createBuilder(ilinkCmdItem);
        }

        public static IlinkCmdItem parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkCmdItem) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkCmdItem parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkCmdItem parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkCmdItem parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkCmdItem parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkCmdItem parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkCmdItem parseFrom(InputStream inputStream) throws IOException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkCmdItem parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkCmdItem parseFrom(k kVar) throws IOException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkCmdItem parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkCmdItem) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkCmdItemOrBuilder extends av {
        ByteString getCmdbuf();

        int getCmdid();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasCmdbuf();

        boolean hasCmdid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum IlinkContentType implements ad.c {
        kIlinkContentTypeDefault(0),
        kIlinkContentTypeProtobuf(1),
        kIlinkContentTypeJson(2);

        private static final ad.d<IlinkContentType> internalValueMap = new ad.d<IlinkContentType>() { // from class: com.tencent.ilink.network.ApiProto.IlinkContentType.1
            @Override // com.google.protobuf.ad.d
            public IlinkContentType findValueByNumber(int i3) {
                return IlinkContentType.forNumber(i3);
            }
        };
        public static final int kIlinkContentTypeDefault_VALUE = 0;
        public static final int kIlinkContentTypeJson_VALUE = 2;
        public static final int kIlinkContentTypeProtobuf_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class IlinkContentTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new IlinkContentTypeVerifier();

            IlinkContentTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (IlinkContentType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        IlinkContentType(int i3) {
            this.value = i3;
        }

        public static IlinkContentType forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        return null;
                    }
                    return kIlinkContentTypeJson;
                }
                return kIlinkContentTypeProtobuf;
            }
            return kIlinkContentTypeDefault;
        }

        public static ad.d<IlinkContentType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return IlinkContentTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static IlinkContentType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public enum IlinkCryptoAlgo implements ad.c {
        kIlinkNoCrypto(0),
        kIlinkSession(1),
        kIlinkHybridEcdh(2),
        kIlinkEcdh(3);

        private static final ad.d<IlinkCryptoAlgo> internalValueMap = new ad.d<IlinkCryptoAlgo>() { // from class: com.tencent.ilink.network.ApiProto.IlinkCryptoAlgo.1
            @Override // com.google.protobuf.ad.d
            public IlinkCryptoAlgo findValueByNumber(int i3) {
                return IlinkCryptoAlgo.forNumber(i3);
            }
        };
        public static final int kIlinkEcdh_VALUE = 3;
        public static final int kIlinkHybridEcdh_VALUE = 2;
        public static final int kIlinkNoCrypto_VALUE = 0;
        public static final int kIlinkSession_VALUE = 1;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class IlinkCryptoAlgoVerifier implements ad.e {
            static final ad.e INSTANCE = new IlinkCryptoAlgoVerifier();

            IlinkCryptoAlgoVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (IlinkCryptoAlgo.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        IlinkCryptoAlgo(int i3) {
            this.value = i3;
        }

        public static IlinkCryptoAlgo forNumber(int i3) {
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

        public static ad.d<IlinkCryptoAlgo> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return IlinkCryptoAlgoVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static IlinkCryptoAlgo valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class IlinkDeviceSessionInfo extends GeneratedMessageLite<IlinkDeviceSessionInfo, Builder> implements IlinkDeviceSessionInfoOrBuilder {
        public static final int AUTOAUTH_ENC_KEY_FIELD_NUMBER = 3;
        public static final int CLIENT_RANDOM_KEY_FIELD_NUMBER = 1;
        public static final int COOKIE_FIELD_NUMBER = 5;
        private static final IlinkDeviceSessionInfo DEFAULT_INSTANCE;
        public static final int ILINK_DEVICEID_FIELD_NUMBER = 7;
        public static final int ILINK_PRODUCTID_FIELD_NUMBER = 8;
        private static volatile bg<IlinkDeviceSessionInfo> PARSER = null;
        public static final int SERVERID_FIELD_NUMBER = 4;
        public static final int SERVER_RANDOM_KEY_FIELD_NUMBER = 2;
        public static final int UIN_FIELD_NUMBER = 6;
        private ByteString autoauthEncKey_;
        private int bitField0_;
        private ByteString clientRandomKey_;
        private ByteString cookie_;
        private ByteString ilinkDeviceid_;
        private int ilinkProductid_;
        private ByteString serverRandomKey_;
        private ByteString serverid_;
        private long uin_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkDeviceSessionInfo, Builder> implements IlinkDeviceSessionInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAutoauthEncKey() {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).clearAutoauthEncKey();
                return this;
            }

            public Builder clearClientRandomKey() {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).clearClientRandomKey();
                return this;
            }

            public Builder clearCookie() {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).clearCookie();
                return this;
            }

            public Builder clearIlinkDeviceid() {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).clearIlinkDeviceid();
                return this;
            }

            public Builder clearIlinkProductid() {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).clearIlinkProductid();
                return this;
            }

            public Builder clearServerRandomKey() {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).clearServerRandomKey();
                return this;
            }

            public Builder clearServerid() {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).clearServerid();
                return this;
            }

            public Builder clearUin() {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).clearUin();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public ByteString getAutoauthEncKey() {
                return ((IlinkDeviceSessionInfo) this.instance).getAutoauthEncKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public ByteString getClientRandomKey() {
                return ((IlinkDeviceSessionInfo) this.instance).getClientRandomKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public ByteString getCookie() {
                return ((IlinkDeviceSessionInfo) this.instance).getCookie();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public ByteString getIlinkDeviceid() {
                return ((IlinkDeviceSessionInfo) this.instance).getIlinkDeviceid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public int getIlinkProductid() {
                return ((IlinkDeviceSessionInfo) this.instance).getIlinkProductid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public ByteString getServerRandomKey() {
                return ((IlinkDeviceSessionInfo) this.instance).getServerRandomKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public ByteString getServerid() {
                return ((IlinkDeviceSessionInfo) this.instance).getServerid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public long getUin() {
                return ((IlinkDeviceSessionInfo) this.instance).getUin();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public boolean hasAutoauthEncKey() {
                return ((IlinkDeviceSessionInfo) this.instance).hasAutoauthEncKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public boolean hasClientRandomKey() {
                return ((IlinkDeviceSessionInfo) this.instance).hasClientRandomKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public boolean hasCookie() {
                return ((IlinkDeviceSessionInfo) this.instance).hasCookie();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public boolean hasIlinkDeviceid() {
                return ((IlinkDeviceSessionInfo) this.instance).hasIlinkDeviceid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public boolean hasIlinkProductid() {
                return ((IlinkDeviceSessionInfo) this.instance).hasIlinkProductid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public boolean hasServerRandomKey() {
                return ((IlinkDeviceSessionInfo) this.instance).hasServerRandomKey();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public boolean hasServerid() {
                return ((IlinkDeviceSessionInfo) this.instance).hasServerid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
            public boolean hasUin() {
                return ((IlinkDeviceSessionInfo) this.instance).hasUin();
            }

            public Builder setAutoauthEncKey(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).setAutoauthEncKey(byteString);
                return this;
            }

            public Builder setClientRandomKey(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).setClientRandomKey(byteString);
                return this;
            }

            public Builder setCookie(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).setCookie(byteString);
                return this;
            }

            public Builder setIlinkDeviceid(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).setIlinkDeviceid(byteString);
                return this;
            }

            public Builder setIlinkProductid(int i3) {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).setIlinkProductid(i3);
                return this;
            }

            public Builder setServerRandomKey(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).setServerRandomKey(byteString);
                return this;
            }

            public Builder setServerid(ByteString byteString) {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).setServerid(byteString);
                return this;
            }

            public Builder setUin(long j3) {
                copyOnWrite();
                ((IlinkDeviceSessionInfo) this.instance).setUin(j3);
                return this;
            }

            Builder() {
                super(IlinkDeviceSessionInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkDeviceSessionInfo ilinkDeviceSessionInfo = new IlinkDeviceSessionInfo();
            DEFAULT_INSTANCE = ilinkDeviceSessionInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkDeviceSessionInfo.class, ilinkDeviceSessionInfo);
        }

        IlinkDeviceSessionInfo() {
            ByteString byteString = ByteString.EMPTY;
            this.clientRandomKey_ = byteString;
            this.serverRandomKey_ = byteString;
            this.autoauthEncKey_ = byteString;
            this.serverid_ = byteString;
            this.cookie_ = byteString;
            this.ilinkDeviceid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAutoauthEncKey() {
            this.bitField0_ &= -5;
            this.autoauthEncKey_ = getDefaultInstance().getAutoauthEncKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientRandomKey() {
            this.bitField0_ &= -2;
            this.clientRandomKey_ = getDefaultInstance().getClientRandomKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCookie() {
            this.bitField0_ &= -17;
            this.cookie_ = getDefaultInstance().getCookie();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkDeviceid() {
            this.bitField0_ &= -65;
            this.ilinkDeviceid_ = getDefaultInstance().getIlinkDeviceid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkProductid() {
            this.bitField0_ &= -129;
            this.ilinkProductid_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerRandomKey() {
            this.bitField0_ &= -3;
            this.serverRandomKey_ = getDefaultInstance().getServerRandomKey();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearServerid() {
            this.bitField0_ &= -9;
            this.serverid_ = getDefaultInstance().getServerid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUin() {
            this.bitField0_ &= -33;
            this.uin_ = 0L;
        }

        public static IlinkDeviceSessionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkDeviceSessionInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDeviceSessionInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkDeviceSessionInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAutoauthEncKey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.autoauthEncKey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientRandomKey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.clientRandomKey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCookie(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.cookie_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkDeviceid(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.ilinkDeviceid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkProductid(int i3) {
            this.bitField0_ |= 128;
            this.ilinkProductid_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerRandomKey(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.serverRandomKey_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServerid(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.serverid_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUin(long j3) {
            this.bitField0_ |= 32;
            this.uin_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkDeviceSessionInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\n\u0000\u0002\n\u0001\u0003\n\u0002\u0004\n\u0003\u0005\n\u0004\u0006\u0003\u0005\u0007\n\u0006\b\u000b\u0007", new Object[]{"bitField0_", "clientRandomKey_", "serverRandomKey_", "autoauthEncKey_", "serverid_", "cookie_", "uin_", "ilinkDeviceid_", "ilinkProductid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkDeviceSessionInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkDeviceSessionInfo.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public ByteString getAutoauthEncKey() {
            return this.autoauthEncKey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public ByteString getClientRandomKey() {
            return this.clientRandomKey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public ByteString getCookie() {
            return this.cookie_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public ByteString getIlinkDeviceid() {
            return this.ilinkDeviceid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public int getIlinkProductid() {
            return this.ilinkProductid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public ByteString getServerRandomKey() {
            return this.serverRandomKey_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public ByteString getServerid() {
            return this.serverid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public long getUin() {
            return this.uin_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public boolean hasAutoauthEncKey() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public boolean hasClientRandomKey() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public boolean hasCookie() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public boolean hasIlinkDeviceid() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public boolean hasIlinkProductid() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public boolean hasServerRandomKey() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public boolean hasServerid() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkDeviceSessionInfoOrBuilder
        public boolean hasUin() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkDeviceSessionInfo ilinkDeviceSessionInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkDeviceSessionInfo);
        }

        public static IlinkDeviceSessionInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDeviceSessionInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkDeviceSessionInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkDeviceSessionInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkDeviceSessionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkDeviceSessionInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkDeviceSessionInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkDeviceSessionInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkDeviceSessionInfo parseFrom(k kVar) throws IOException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkDeviceSessionInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkDeviceSessionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkDeviceSessionInfoOrBuilder extends av {
        ByteString getAutoauthEncKey();

        ByteString getClientRandomKey();

        ByteString getCookie();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getIlinkDeviceid();

        int getIlinkProductid();

        ByteString getServerRandomKey();

        ByteString getServerid();

        long getUin();

        boolean hasAutoauthEncKey();

        boolean hasClientRandomKey();

        boolean hasCookie();

        boolean hasIlinkDeviceid();

        boolean hasIlinkProductid();

        boolean hasServerRandomKey();

        boolean hasServerid();

        boolean hasUin();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum IlinkEBizScene implements ad.c {
        kC2CScene(0),
        kAppScene(2);

        private static final ad.d<IlinkEBizScene> internalValueMap = new ad.d<IlinkEBizScene>() { // from class: com.tencent.ilink.network.ApiProto.IlinkEBizScene.1
            @Override // com.google.protobuf.ad.d
            public IlinkEBizScene findValueByNumber(int i3) {
                return IlinkEBizScene.forNumber(i3);
            }
        };
        public static final int kAppScene_VALUE = 2;
        public static final int kC2CScene_VALUE = 0;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class IlinkEBizSceneVerifier implements ad.e {
            static final ad.e INSTANCE = new IlinkEBizSceneVerifier();

            IlinkEBizSceneVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (IlinkEBizScene.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        IlinkEBizScene(int i3) {
            this.value = i3;
        }

        public static IlinkEBizScene forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 2) {
                    return null;
                }
                return kAppScene;
            }
            return kC2CScene;
        }

        public static ad.d<IlinkEBizScene> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return IlinkEBizSceneVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static IlinkEBizScene valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class IlinkKvReportInfo extends GeneratedMessageLite<IlinkKvReportInfo, Builder> implements IlinkKvReportInfoOrBuilder {
        private static final IlinkKvReportInfo DEFAULT_INSTANCE;
        public static final int IGNORE_FREQ_CHECK_FIELD_NUMBER = 5;
        public static final int LOGID_FIELD_NUMBER = 1;
        private static volatile bg<IlinkKvReportInfo> PARSER = null;
        public static final int REPORT_NOW_FIELD_NUMBER = 4;
        public static final int REPORT_UIN_TYPE_FIELD_NUMBER = 6;
        public static final int TYPE_FIELD_NUMBER = 2;
        public static final int VALUE_FIELD_NUMBER = 3;
        private int bitField0_;
        private boolean ignoreFreqCheck_;
        private int logid_;
        private boolean reportNow_;
        private int reportUinType_;
        private int type_;
        private ByteString value_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkKvReportInfo, Builder> implements IlinkKvReportInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearIgnoreFreqCheck() {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).clearIgnoreFreqCheck();
                return this;
            }

            public Builder clearLogid() {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).clearLogid();
                return this;
            }

            public Builder clearReportNow() {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).clearReportNow();
                return this;
            }

            public Builder clearReportUinType() {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).clearReportUinType();
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).clearType();
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).clearValue();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public boolean getIgnoreFreqCheck() {
                return ((IlinkKvReportInfo) this.instance).getIgnoreFreqCheck();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public int getLogid() {
                return ((IlinkKvReportInfo) this.instance).getLogid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public boolean getReportNow() {
                return ((IlinkKvReportInfo) this.instance).getReportNow();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public int getReportUinType() {
                return ((IlinkKvReportInfo) this.instance).getReportUinType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public int getType() {
                return ((IlinkKvReportInfo) this.instance).getType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public ByteString getValue() {
                return ((IlinkKvReportInfo) this.instance).getValue();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public boolean hasIgnoreFreqCheck() {
                return ((IlinkKvReportInfo) this.instance).hasIgnoreFreqCheck();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public boolean hasLogid() {
                return ((IlinkKvReportInfo) this.instance).hasLogid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public boolean hasReportNow() {
                return ((IlinkKvReportInfo) this.instance).hasReportNow();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public boolean hasReportUinType() {
                return ((IlinkKvReportInfo) this.instance).hasReportUinType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public boolean hasType() {
                return ((IlinkKvReportInfo) this.instance).hasType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
            public boolean hasValue() {
                return ((IlinkKvReportInfo) this.instance).hasValue();
            }

            public Builder setIgnoreFreqCheck(boolean z16) {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).setIgnoreFreqCheck(z16);
                return this;
            }

            public Builder setLogid(int i3) {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).setLogid(i3);
                return this;
            }

            public Builder setReportNow(boolean z16) {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).setReportNow(z16);
                return this;
            }

            public Builder setReportUinType(int i3) {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).setReportUinType(i3);
                return this;
            }

            public Builder setType(int i3) {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).setType(i3);
                return this;
            }

            public Builder setValue(ByteString byteString) {
                copyOnWrite();
                ((IlinkKvReportInfo) this.instance).setValue(byteString);
                return this;
            }

            Builder() {
                super(IlinkKvReportInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkKvReportInfo ilinkKvReportInfo = new IlinkKvReportInfo();
            DEFAULT_INSTANCE = ilinkKvReportInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkKvReportInfo.class, ilinkKvReportInfo);
        }

        IlinkKvReportInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIgnoreFreqCheck() {
            this.bitField0_ &= -17;
            this.ignoreFreqCheck_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLogid() {
            this.bitField0_ &= -2;
            this.logid_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReportNow() {
            this.bitField0_ &= -9;
            this.reportNow_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReportUinType() {
            this.bitField0_ &= -33;
            this.reportUinType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -3;
            this.type_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.bitField0_ &= -5;
            this.value_ = getDefaultInstance().getValue();
        }

        public static IlinkKvReportInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkKvReportInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkKvReportInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkKvReportInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIgnoreFreqCheck(boolean z16) {
            this.bitField0_ |= 16;
            this.ignoreFreqCheck_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogid(int i3) {
            this.bitField0_ |= 1;
            this.logid_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReportNow(boolean z16) {
            this.bitField0_ |= 8;
            this.reportNow_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReportUinType(int i3) {
            this.bitField0_ |= 32;
            this.reportUinType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(int i3) {
            this.bitField0_ |= 2;
            this.type_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.value_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkKvReportInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u000b\u0000\u0002\u000b\u0001\u0003\n\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u000b\u0005", new Object[]{"bitField0_", "logid_", "type_", "value_", "reportNow_", "ignoreFreqCheck_", "reportUinType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkKvReportInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkKvReportInfo.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public boolean getIgnoreFreqCheck() {
            return this.ignoreFreqCheck_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public int getLogid() {
            return this.logid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public boolean getReportNow() {
            return this.reportNow_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public int getReportUinType() {
            return this.reportUinType_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public boolean hasIgnoreFreqCheck() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public boolean hasLogid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public boolean hasReportNow() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public boolean hasReportUinType() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkKvReportInfoOrBuilder
        public boolean hasValue() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkKvReportInfo ilinkKvReportInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkKvReportInfo);
        }

        public static IlinkKvReportInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkKvReportInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkKvReportInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkKvReportInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkKvReportInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkKvReportInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkKvReportInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkKvReportInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkKvReportInfo parseFrom(k kVar) throws IOException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkKvReportInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkKvReportInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkKvReportInfoOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean getIgnoreFreqCheck();

        int getLogid();

        boolean getReportNow();

        int getReportUinType();

        int getType();

        ByteString getValue();

        boolean hasIgnoreFreqCheck();

        boolean hasLogid();

        boolean hasReportNow();

        boolean hasReportUinType();

        boolean hasType();

        boolean hasValue();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkNetProxyInfo extends GeneratedMessageLite<IlinkNetProxyInfo, Builder> implements IlinkNetProxyInfoOrBuilder {
        private static final IlinkNetProxyInfo DEFAULT_INSTANCE;
        public static final int IP_FIELD_NUMBER = 1;
        private static volatile bg<IlinkNetProxyInfo> PARSER = null;
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

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkNetProxyInfo, Builder> implements IlinkNetProxyInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearIp() {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).clearIp();
                return this;
            }

            public Builder clearPassword() {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).clearPassword();
                return this;
            }

            public Builder clearPort() {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).clearPort();
                return this;
            }

            public Builder clearProxytype() {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).clearProxytype();
                return this;
            }

            public Builder clearUsername() {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).clearUsername();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public String getIp() {
                return ((IlinkNetProxyInfo) this.instance).getIp();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public ByteString getIpBytes() {
                return ((IlinkNetProxyInfo) this.instance).getIpBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public ByteString getPassword() {
                return ((IlinkNetProxyInfo) this.instance).getPassword();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public int getPort() {
                return ((IlinkNetProxyInfo) this.instance).getPort();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public int getProxytype() {
                return ((IlinkNetProxyInfo) this.instance).getProxytype();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public ByteString getUsername() {
                return ((IlinkNetProxyInfo) this.instance).getUsername();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public boolean hasIp() {
                return ((IlinkNetProxyInfo) this.instance).hasIp();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public boolean hasPassword() {
                return ((IlinkNetProxyInfo) this.instance).hasPassword();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public boolean hasPort() {
                return ((IlinkNetProxyInfo) this.instance).hasPort();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public boolean hasProxytype() {
                return ((IlinkNetProxyInfo) this.instance).hasProxytype();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
            public boolean hasUsername() {
                return ((IlinkNetProxyInfo) this.instance).hasUsername();
            }

            public Builder setIp(String str) {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).setIp(str);
                return this;
            }

            public Builder setIpBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).setIpBytes(byteString);
                return this;
            }

            public Builder setPassword(ByteString byteString) {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).setPassword(byteString);
                return this;
            }

            public Builder setPort(int i3) {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).setPort(i3);
                return this;
            }

            public Builder setProxytype(int i3) {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).setProxytype(i3);
                return this;
            }

            public Builder setUsername(ByteString byteString) {
                copyOnWrite();
                ((IlinkNetProxyInfo) this.instance).setUsername(byteString);
                return this;
            }

            Builder() {
                super(IlinkNetProxyInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkNetProxyInfo ilinkNetProxyInfo = new IlinkNetProxyInfo();
            DEFAULT_INSTANCE = ilinkNetProxyInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkNetProxyInfo.class, ilinkNetProxyInfo);
        }

        IlinkNetProxyInfo() {
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

        public static IlinkNetProxyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkNetProxyInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkNetProxyInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkNetProxyInfo> parser() {
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
                    return new IlinkNetProxyInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\n\u0002\u0004\n\u0003\u0005\u000b\u0004", new Object[]{"bitField0_", "ip_", "port_", "username_", "password_", "proxytype_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkNetProxyInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkNetProxyInfo.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public String getIp() {
            return this.ip_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public ByteString getIpBytes() {
            return ByteString.copyFromUtf8(this.ip_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public ByteString getPassword() {
            return this.password_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public int getPort() {
            return this.port_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public int getProxytype() {
            return this.proxytype_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public ByteString getUsername() {
            return this.username_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public boolean hasIp() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public boolean hasPassword() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public boolean hasPort() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public boolean hasProxytype() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkNetProxyInfoOrBuilder
        public boolean hasUsername() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkNetProxyInfo ilinkNetProxyInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkNetProxyInfo);
        }

        public static IlinkNetProxyInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkNetProxyInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkNetProxyInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkNetProxyInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkNetProxyInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkNetProxyInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkNetProxyInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkNetProxyInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkNetProxyInfo parseFrom(k kVar) throws IOException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkNetProxyInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkNetProxyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkNetProxyInfoOrBuilder extends av {
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

    /* loaded from: classes7.dex */
    public enum IlinkNetType implements ad.c {
        kIlinkShortlink(0),
        kIlinkLonglink(1);

        private static final ad.d<IlinkNetType> internalValueMap = new ad.d<IlinkNetType>() { // from class: com.tencent.ilink.network.ApiProto.IlinkNetType.1
            @Override // com.google.protobuf.ad.d
            public IlinkNetType findValueByNumber(int i3) {
                return IlinkNetType.forNumber(i3);
            }
        };
        public static final int kIlinkLonglink_VALUE = 1;
        public static final int kIlinkShortlink_VALUE = 0;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class IlinkNetTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new IlinkNetTypeVerifier();

            IlinkNetTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (IlinkNetType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        IlinkNetType(int i3) {
            this.value = i3;
        }

        public static IlinkNetType forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return null;
                }
                return kIlinkLonglink;
            }
            return kIlinkShortlink;
        }

        public static ad.d<IlinkNetType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return IlinkNetTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static IlinkNetType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class IlinkPullLogCmd extends GeneratedMessageLite<IlinkPullLogCmd, Builder> implements IlinkPullLogCmdOrBuilder {
        private static final IlinkPullLogCmd DEFAULT_INSTANCE;
        public static final int END_TIME_FIELD_NUMBER = 2;
        public static final int EXT_BUFFER_FIELD_NUMBER = 7;
        public static final int ILINK_APPIDS_FIELD_NUMBER = 5;
        public static final int ILINK_CAPATH_FIELD_NUMBER = 8;
        public static final int ILINK_LOGS_FIELD_NUMBER = 9;
        public static final int INCLUDE_DEVLOG_FIELD_NUMBER = 6;
        private static volatile bg<IlinkPullLogCmd> PARSER = null;
        public static final int START_TIME_FIELD_NUMBER = 1;
        public static final int UPLOAD_TOKEN_FIELD_NUMBER = 3;
        public static final int USE_NETTYPE_FIELD_NUMBER = 4;
        private int bitField0_;
        private int endTime_;
        private boolean includeDevlog_;
        private int startTime_;
        private int useNettype_;
        private String uploadToken_ = "";
        private ad.j<String> ilinkAppids_ = GeneratedMessageLite.emptyProtobufList();
        private String extBuffer_ = "";
        private String ilinkCapath_ = "";
        private ad.j<String> ilinkLogs_ = GeneratedMessageLite.emptyProtobufList();

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkPullLogCmd, Builder> implements IlinkPullLogCmdOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllIlinkAppids(Iterable<String> iterable) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).addAllIlinkAppids(iterable);
                return this;
            }

            public Builder addAllIlinkLogs(Iterable<String> iterable) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).addAllIlinkLogs(iterable);
                return this;
            }

            public Builder addIlinkAppids(String str) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).addIlinkAppids(str);
                return this;
            }

            public Builder addIlinkAppidsBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).addIlinkAppidsBytes(byteString);
                return this;
            }

            public Builder addIlinkLogs(String str) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).addIlinkLogs(str);
                return this;
            }

            public Builder addIlinkLogsBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).addIlinkLogsBytes(byteString);
                return this;
            }

            public Builder clearEndTime() {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).clearEndTime();
                return this;
            }

            public Builder clearExtBuffer() {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).clearExtBuffer();
                return this;
            }

            public Builder clearIlinkAppids() {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).clearIlinkAppids();
                return this;
            }

            public Builder clearIlinkCapath() {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).clearIlinkCapath();
                return this;
            }

            public Builder clearIlinkLogs() {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).clearIlinkLogs();
                return this;
            }

            public Builder clearIncludeDevlog() {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).clearIncludeDevlog();
                return this;
            }

            public Builder clearStartTime() {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).clearStartTime();
                return this;
            }

            public Builder clearUploadToken() {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).clearUploadToken();
                return this;
            }

            public Builder clearUseNettype() {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).clearUseNettype();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public int getEndTime() {
                return ((IlinkPullLogCmd) this.instance).getEndTime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public String getExtBuffer() {
                return ((IlinkPullLogCmd) this.instance).getExtBuffer();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public ByteString getExtBufferBytes() {
                return ((IlinkPullLogCmd) this.instance).getExtBufferBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public String getIlinkAppids(int i3) {
                return ((IlinkPullLogCmd) this.instance).getIlinkAppids(i3);
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public ByteString getIlinkAppidsBytes(int i3) {
                return ((IlinkPullLogCmd) this.instance).getIlinkAppidsBytes(i3);
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public int getIlinkAppidsCount() {
                return ((IlinkPullLogCmd) this.instance).getIlinkAppidsCount();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public List<String> getIlinkAppidsList() {
                return Collections.unmodifiableList(((IlinkPullLogCmd) this.instance).getIlinkAppidsList());
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public String getIlinkCapath() {
                return ((IlinkPullLogCmd) this.instance).getIlinkCapath();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public ByteString getIlinkCapathBytes() {
                return ((IlinkPullLogCmd) this.instance).getIlinkCapathBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public String getIlinkLogs(int i3) {
                return ((IlinkPullLogCmd) this.instance).getIlinkLogs(i3);
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public ByteString getIlinkLogsBytes(int i3) {
                return ((IlinkPullLogCmd) this.instance).getIlinkLogsBytes(i3);
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public int getIlinkLogsCount() {
                return ((IlinkPullLogCmd) this.instance).getIlinkLogsCount();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public List<String> getIlinkLogsList() {
                return Collections.unmodifiableList(((IlinkPullLogCmd) this.instance).getIlinkLogsList());
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public boolean getIncludeDevlog() {
                return ((IlinkPullLogCmd) this.instance).getIncludeDevlog();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public int getStartTime() {
                return ((IlinkPullLogCmd) this.instance).getStartTime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public String getUploadToken() {
                return ((IlinkPullLogCmd) this.instance).getUploadToken();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public ByteString getUploadTokenBytes() {
                return ((IlinkPullLogCmd) this.instance).getUploadTokenBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public int getUseNettype() {
                return ((IlinkPullLogCmd) this.instance).getUseNettype();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public boolean hasEndTime() {
                return ((IlinkPullLogCmd) this.instance).hasEndTime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public boolean hasExtBuffer() {
                return ((IlinkPullLogCmd) this.instance).hasExtBuffer();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public boolean hasIlinkCapath() {
                return ((IlinkPullLogCmd) this.instance).hasIlinkCapath();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public boolean hasIncludeDevlog() {
                return ((IlinkPullLogCmd) this.instance).hasIncludeDevlog();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public boolean hasStartTime() {
                return ((IlinkPullLogCmd) this.instance).hasStartTime();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public boolean hasUploadToken() {
                return ((IlinkPullLogCmd) this.instance).hasUploadToken();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
            public boolean hasUseNettype() {
                return ((IlinkPullLogCmd) this.instance).hasUseNettype();
            }

            public Builder setEndTime(int i3) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setEndTime(i3);
                return this;
            }

            public Builder setExtBuffer(String str) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setExtBuffer(str);
                return this;
            }

            public Builder setExtBufferBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setExtBufferBytes(byteString);
                return this;
            }

            public Builder setIlinkAppids(int i3, String str) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setIlinkAppids(i3, str);
                return this;
            }

            public Builder setIlinkCapath(String str) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setIlinkCapath(str);
                return this;
            }

            public Builder setIlinkCapathBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setIlinkCapathBytes(byteString);
                return this;
            }

            public Builder setIlinkLogs(int i3, String str) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setIlinkLogs(i3, str);
                return this;
            }

            public Builder setIncludeDevlog(boolean z16) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setIncludeDevlog(z16);
                return this;
            }

            public Builder setStartTime(int i3) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setStartTime(i3);
                return this;
            }

            public Builder setUploadToken(String str) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setUploadToken(str);
                return this;
            }

            public Builder setUploadTokenBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setUploadTokenBytes(byteString);
                return this;
            }

            public Builder setUseNettype(int i3) {
                copyOnWrite();
                ((IlinkPullLogCmd) this.instance).setUseNettype(i3);
                return this;
            }

            Builder() {
                super(IlinkPullLogCmd.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkPullLogCmd ilinkPullLogCmd = new IlinkPullLogCmd();
            DEFAULT_INSTANCE = ilinkPullLogCmd;
            GeneratedMessageLite.registerDefaultInstance(IlinkPullLogCmd.class, ilinkPullLogCmd);
        }

        IlinkPullLogCmd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllIlinkAppids(Iterable<String> iterable) {
            ensureIlinkAppidsIsMutable();
            b.addAll((Iterable) iterable, (List) this.ilinkAppids_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllIlinkLogs(Iterable<String> iterable) {
            ensureIlinkLogsIsMutable();
            b.addAll((Iterable) iterable, (List) this.ilinkLogs_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIlinkAppids(String str) {
            str.getClass();
            ensureIlinkAppidsIsMutable();
            this.ilinkAppids_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIlinkAppidsBytes(ByteString byteString) {
            byteString.getClass();
            ensureIlinkAppidsIsMutable();
            this.ilinkAppids_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIlinkLogs(String str) {
            str.getClass();
            ensureIlinkLogsIsMutable();
            this.ilinkLogs_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addIlinkLogsBytes(ByteString byteString) {
            byteString.getClass();
            ensureIlinkLogsIsMutable();
            this.ilinkLogs_.add(byteString.toStringUtf8());
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
        public void clearIlinkAppids() {
            this.ilinkAppids_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkCapath() {
            this.bitField0_ &= -65;
            this.ilinkCapath_ = getDefaultInstance().getIlinkCapath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinkLogs() {
            this.ilinkLogs_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIncludeDevlog() {
            this.bitField0_ &= -17;
            this.includeDevlog_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTime() {
            this.bitField0_ &= -2;
            this.startTime_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUploadToken() {
            this.bitField0_ &= -5;
            this.uploadToken_ = getDefaultInstance().getUploadToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUseNettype() {
            this.bitField0_ &= -9;
            this.useNettype_ = 0;
        }

        private void ensureIlinkAppidsIsMutable() {
            if (!this.ilinkAppids_.z()) {
                this.ilinkAppids_ = GeneratedMessageLite.mutableCopy(this.ilinkAppids_);
            }
        }

        private void ensureIlinkLogsIsMutable() {
            if (!this.ilinkLogs_.z()) {
                this.ilinkLogs_ = GeneratedMessageLite.mutableCopy(this.ilinkLogs_);
            }
        }

        public static IlinkPullLogCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkPullLogCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkPullLogCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkPullLogCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
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
        public void setIlinkAppids(int i3, String str) {
            str.getClass();
            ensureIlinkAppidsIsMutable();
            this.ilinkAppids_.set(i3, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkCapath(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.ilinkCapath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkCapathBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.ilinkCapath_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinkLogs(int i3, String str) {
            str.getClass();
            ensureIlinkLogsIsMutable();
            this.ilinkLogs_.set(i3, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIncludeDevlog(boolean z16) {
            this.bitField0_ |= 16;
            this.includeDevlog_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTime(int i3) {
            this.bitField0_ |= 1;
            this.startTime_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUploadToken(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.uploadToken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUploadTokenBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.uploadToken_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUseNettype(int i3) {
            this.bitField0_ |= 8;
            this.useNettype_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkPullLogCmd();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0000\u0001\u000b\u0000\u0002\u000b\u0001\u0003\b\u0002\u0004\u000b\u0003\u0005\u001a\u0006\u0007\u0004\u0007\b\u0005\b\b\u0006\t\u001a", new Object[]{"bitField0_", "startTime_", "endTime_", "uploadToken_", "useNettype_", "ilinkAppids_", "includeDevlog_", "extBuffer_", "ilinkCapath_", "ilinkLogs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkPullLogCmd> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkPullLogCmd.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public String getExtBuffer() {
            return this.extBuffer_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public ByteString getExtBufferBytes() {
            return ByteString.copyFromUtf8(this.extBuffer_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public String getIlinkAppids(int i3) {
            return this.ilinkAppids_.get(i3);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public ByteString getIlinkAppidsBytes(int i3) {
            return ByteString.copyFromUtf8(this.ilinkAppids_.get(i3));
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public int getIlinkAppidsCount() {
            return this.ilinkAppids_.size();
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public List<String> getIlinkAppidsList() {
            return this.ilinkAppids_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public String getIlinkCapath() {
            return this.ilinkCapath_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public ByteString getIlinkCapathBytes() {
            return ByteString.copyFromUtf8(this.ilinkCapath_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public String getIlinkLogs(int i3) {
            return this.ilinkLogs_.get(i3);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public ByteString getIlinkLogsBytes(int i3) {
            return ByteString.copyFromUtf8(this.ilinkLogs_.get(i3));
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public int getIlinkLogsCount() {
            return this.ilinkLogs_.size();
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public List<String> getIlinkLogsList() {
            return this.ilinkLogs_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public boolean getIncludeDevlog() {
            return this.includeDevlog_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public String getUploadToken() {
            return this.uploadToken_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public ByteString getUploadTokenBytes() {
            return ByteString.copyFromUtf8(this.uploadToken_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public int getUseNettype() {
            return this.useNettype_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public boolean hasEndTime() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public boolean hasExtBuffer() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public boolean hasIlinkCapath() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public boolean hasIncludeDevlog() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public boolean hasStartTime() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public boolean hasUploadToken() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkPullLogCmdOrBuilder
        public boolean hasUseNettype() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkPullLogCmd ilinkPullLogCmd) {
            return DEFAULT_INSTANCE.createBuilder(ilinkPullLogCmd);
        }

        public static IlinkPullLogCmd parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkPullLogCmd parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkPullLogCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkPullLogCmd parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkPullLogCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkPullLogCmd parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkPullLogCmd parseFrom(InputStream inputStream) throws IOException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkPullLogCmd parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkPullLogCmd parseFrom(k kVar) throws IOException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkPullLogCmd parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkPullLogCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkPullLogCmdOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getEndTime();

        String getExtBuffer();

        ByteString getExtBufferBytes();

        String getIlinkAppids(int i3);

        ByteString getIlinkAppidsBytes(int i3);

        int getIlinkAppidsCount();

        List<String> getIlinkAppidsList();

        String getIlinkCapath();

        ByteString getIlinkCapathBytes();

        String getIlinkLogs(int i3);

        ByteString getIlinkLogsBytes(int i3);

        int getIlinkLogsCount();

        List<String> getIlinkLogsList();

        boolean getIncludeDevlog();

        int getStartTime();

        String getUploadToken();

        ByteString getUploadTokenBytes();

        int getUseNettype();

        boolean hasEndTime();

        boolean hasExtBuffer();

        boolean hasIlinkCapath();

        boolean hasIncludeDevlog();

        boolean hasStartTime();

        boolean hasUploadToken();

        boolean hasUseNettype();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum IlinkPullLogNetType implements ad.c {
        kIlinkLan(0),
        kIlinkAny(1);

        private static final ad.d<IlinkPullLogNetType> internalValueMap = new ad.d<IlinkPullLogNetType>() { // from class: com.tencent.ilink.network.ApiProto.IlinkPullLogNetType.1
            @Override // com.google.protobuf.ad.d
            public IlinkPullLogNetType findValueByNumber(int i3) {
                return IlinkPullLogNetType.forNumber(i3);
            }
        };
        public static final int kIlinkAny_VALUE = 1;
        public static final int kIlinkLan_VALUE = 0;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class IlinkPullLogNetTypeVerifier implements ad.e {
            static final ad.e INSTANCE = new IlinkPullLogNetTypeVerifier();

            IlinkPullLogNetTypeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (IlinkPullLogNetType.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        IlinkPullLogNetType(int i3) {
            this.value = i3;
        }

        public static IlinkPullLogNetType forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return null;
                }
                return kIlinkAny;
            }
            return kIlinkLan;
        }

        public static ad.d<IlinkPullLogNetType> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return IlinkPullLogNetTypeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static IlinkPullLogNetType valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class IlinkRequestInfo extends GeneratedMessageLite<IlinkRequestInfo, Builder> implements IlinkRequestInfoOrBuilder {
        public static final int BODY_FIELD_NUMBER = 3;
        public static final int CMDID_FIELD_NUMBER = 1;
        public static final int CONTENT_TYPE_FIELD_NUMBER = 12;
        public static final int CRYPTO_ALGO_FIELD_NUMBER = 7;
        private static final IlinkRequestInfo DEFAULT_INSTANCE;
        public static final int LIMIT_FLOW_FIELD_NUMBER = 8;
        public static final int LIMIT_FREQUENCY_FIELD_NUMBER = 9;
        public static final int LONG_POLLING_FIELD_NUMBER = 10;
        public static final int LONG_POLLING_TIMEOUT_FIELD_NUMBER = 11;
        public static final int NET_TYPE_FIELD_NUMBER = 6;
        private static volatile bg<IlinkRequestInfo> PARSER = null;
        public static final int RETRY_COUNT_FIELD_NUMBER = 5;
        public static final int TIMEOUT_MS_FIELD_NUMBER = 4;
        public static final int URL_FIELD_NUMBER = 2;
        private int bitField0_;
        private int cmdid_;
        private boolean limitFlow_;
        private boolean limitFrequency_;
        private int longPollingTimeout_;
        private boolean longPolling_;
        private int retryCount_;
        private int timeoutMs_;
        private String url_ = "";
        private ByteString body_ = ByteString.EMPTY;
        private int netType_ = 1;
        private int cryptoAlgo_ = 1;
        private int contentType_ = 1;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkRequestInfo, Builder> implements IlinkRequestInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearBody();
                return this;
            }

            public Builder clearCmdid() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearCmdid();
                return this;
            }

            public Builder clearContentType() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearContentType();
                return this;
            }

            public Builder clearCryptoAlgo() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearCryptoAlgo();
                return this;
            }

            public Builder clearLimitFlow() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearLimitFlow();
                return this;
            }

            public Builder clearLimitFrequency() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearLimitFrequency();
                return this;
            }

            public Builder clearLongPolling() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearLongPolling();
                return this;
            }

            public Builder clearLongPollingTimeout() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearLongPollingTimeout();
                return this;
            }

            public Builder clearNetType() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearNetType();
                return this;
            }

            public Builder clearRetryCount() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearRetryCount();
                return this;
            }

            public Builder clearTimeoutMs() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearTimeoutMs();
                return this;
            }

            public Builder clearUrl() {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).clearUrl();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public ByteString getBody() {
                return ((IlinkRequestInfo) this.instance).getBody();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public int getCmdid() {
                return ((IlinkRequestInfo) this.instance).getCmdid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public IlinkContentType getContentType() {
                return ((IlinkRequestInfo) this.instance).getContentType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public IlinkCryptoAlgo getCryptoAlgo() {
                return ((IlinkRequestInfo) this.instance).getCryptoAlgo();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean getLimitFlow() {
                return ((IlinkRequestInfo) this.instance).getLimitFlow();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean getLimitFrequency() {
                return ((IlinkRequestInfo) this.instance).getLimitFrequency();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean getLongPolling() {
                return ((IlinkRequestInfo) this.instance).getLongPolling();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public int getLongPollingTimeout() {
                return ((IlinkRequestInfo) this.instance).getLongPollingTimeout();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public IlinkNetType getNetType() {
                return ((IlinkRequestInfo) this.instance).getNetType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public int getRetryCount() {
                return ((IlinkRequestInfo) this.instance).getRetryCount();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public int getTimeoutMs() {
                return ((IlinkRequestInfo) this.instance).getTimeoutMs();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public String getUrl() {
                return ((IlinkRequestInfo) this.instance).getUrl();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public ByteString getUrlBytes() {
                return ((IlinkRequestInfo) this.instance).getUrlBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasBody() {
                return ((IlinkRequestInfo) this.instance).hasBody();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasCmdid() {
                return ((IlinkRequestInfo) this.instance).hasCmdid();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasContentType() {
                return ((IlinkRequestInfo) this.instance).hasContentType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasCryptoAlgo() {
                return ((IlinkRequestInfo) this.instance).hasCryptoAlgo();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasLimitFlow() {
                return ((IlinkRequestInfo) this.instance).hasLimitFlow();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasLimitFrequency() {
                return ((IlinkRequestInfo) this.instance).hasLimitFrequency();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasLongPolling() {
                return ((IlinkRequestInfo) this.instance).hasLongPolling();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasLongPollingTimeout() {
                return ((IlinkRequestInfo) this.instance).hasLongPollingTimeout();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasNetType() {
                return ((IlinkRequestInfo) this.instance).hasNetType();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasRetryCount() {
                return ((IlinkRequestInfo) this.instance).hasRetryCount();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasTimeoutMs() {
                return ((IlinkRequestInfo) this.instance).hasTimeoutMs();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
            public boolean hasUrl() {
                return ((IlinkRequestInfo) this.instance).hasUrl();
            }

            public Builder setBody(ByteString byteString) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setBody(byteString);
                return this;
            }

            public Builder setCmdid(int i3) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setCmdid(i3);
                return this;
            }

            public Builder setContentType(IlinkContentType ilinkContentType) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setContentType(ilinkContentType);
                return this;
            }

            public Builder setCryptoAlgo(IlinkCryptoAlgo ilinkCryptoAlgo) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setCryptoAlgo(ilinkCryptoAlgo);
                return this;
            }

            public Builder setLimitFlow(boolean z16) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setLimitFlow(z16);
                return this;
            }

            public Builder setLimitFrequency(boolean z16) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setLimitFrequency(z16);
                return this;
            }

            public Builder setLongPolling(boolean z16) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setLongPolling(z16);
                return this;
            }

            public Builder setLongPollingTimeout(int i3) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setLongPollingTimeout(i3);
                return this;
            }

            public Builder setNetType(IlinkNetType ilinkNetType) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setNetType(ilinkNetType);
                return this;
            }

            public Builder setRetryCount(int i3) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setRetryCount(i3);
                return this;
            }

            public Builder setTimeoutMs(int i3) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setTimeoutMs(i3);
                return this;
            }

            public Builder setUrl(String str) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setUrl(str);
                return this;
            }

            public Builder setUrlBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkRequestInfo) this.instance).setUrlBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkRequestInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkRequestInfo ilinkRequestInfo = new IlinkRequestInfo();
            DEFAULT_INSTANCE = ilinkRequestInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkRequestInfo.class, ilinkRequestInfo);
        }

        IlinkRequestInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -5;
            this.body_ = getDefaultInstance().getBody();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCmdid() {
            this.bitField0_ &= -2;
            this.cmdid_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContentType() {
            this.bitField0_ &= MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
            this.contentType_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCryptoAlgo() {
            this.bitField0_ &= -65;
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
        public void clearLongPolling() {
            this.bitField0_ &= -513;
            this.longPolling_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLongPollingTimeout() {
            this.bitField0_ &= -1025;
            this.longPollingTimeout_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNetType() {
            this.bitField0_ &= -33;
            this.netType_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRetryCount() {
            this.bitField0_ &= -17;
            this.retryCount_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeoutMs() {
            this.bitField0_ &= -9;
            this.timeoutMs_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUrl() {
            this.bitField0_ &= -3;
            this.url_ = getDefaultInstance().getUrl();
        }

        public static IlinkRequestInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkRequestInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkRequestInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkRequestInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.body_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCmdid(int i3) {
            this.bitField0_ |= 1;
            this.cmdid_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentType(IlinkContentType ilinkContentType) {
            ilinkContentType.getClass();
            this.bitField0_ |= 2048;
            this.contentType_ = ilinkContentType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCryptoAlgo(IlinkCryptoAlgo ilinkCryptoAlgo) {
            ilinkCryptoAlgo.getClass();
            this.bitField0_ |= 64;
            this.cryptoAlgo_ = ilinkCryptoAlgo.getNumber();
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
        public void setLongPolling(boolean z16) {
            this.bitField0_ |= 512;
            this.longPolling_ = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLongPollingTimeout(int i3) {
            this.bitField0_ |= 1024;
            this.longPollingTimeout_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNetType(IlinkNetType ilinkNetType) {
            ilinkNetType.getClass();
            this.bitField0_ |= 32;
            this.netType_ = ilinkNetType.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRetryCount(int i3) {
            this.bitField0_ |= 16;
            this.retryCount_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeoutMs(int i3) {
            this.bitField0_ |= 8;
            this.timeoutMs_ = i3;
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
                    return new IlinkRequestInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001\u000b\u0000\u0002\b\u0001\u0003\n\u0002\u0004\u000b\u0003\u0005\u000b\u0004\u0006\f\u0005\u0007\f\u0006\b\u0007\u0007\t\u0007\b\n\u0007\t\u000b\u0004\n\f\f\u000b", new Object[]{"bitField0_", "cmdid_", "url_", "body_", "timeoutMs_", "retryCount_", "netType_", IlinkNetType.internalGetVerifier(), "cryptoAlgo_", IlinkCryptoAlgo.internalGetVerifier(), "limitFlow_", "limitFrequency_", "longPolling_", "longPollingTimeout_", "contentType_", IlinkContentType.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkRequestInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkRequestInfo.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public ByteString getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public int getCmdid() {
            return this.cmdid_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public IlinkContentType getContentType() {
            IlinkContentType forNumber = IlinkContentType.forNumber(this.contentType_);
            if (forNumber == null) {
                return IlinkContentType.kIlinkContentTypeProtobuf;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public IlinkCryptoAlgo getCryptoAlgo() {
            IlinkCryptoAlgo forNumber = IlinkCryptoAlgo.forNumber(this.cryptoAlgo_);
            if (forNumber == null) {
                return IlinkCryptoAlgo.kIlinkSession;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean getLimitFlow() {
            return this.limitFlow_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean getLimitFrequency() {
            return this.limitFrequency_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean getLongPolling() {
            return this.longPolling_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public int getLongPollingTimeout() {
            return this.longPollingTimeout_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public IlinkNetType getNetType() {
            IlinkNetType forNumber = IlinkNetType.forNumber(this.netType_);
            if (forNumber == null) {
                return IlinkNetType.kIlinkLonglink;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public int getRetryCount() {
            return this.retryCount_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public int getTimeoutMs() {
            return this.timeoutMs_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public String getUrl() {
            return this.url_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public ByteString getUrlBytes() {
            return ByteString.copyFromUtf8(this.url_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasCmdid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasContentType() {
            if ((this.bitField0_ & 2048) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasCryptoAlgo() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasLimitFlow() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasLimitFrequency() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasLongPolling() {
            if ((this.bitField0_ & 512) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasLongPollingTimeout() {
            if ((this.bitField0_ & 1024) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasNetType() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasRetryCount() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasTimeoutMs() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkRequestInfoOrBuilder
        public boolean hasUrl() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkRequestInfo ilinkRequestInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkRequestInfo);
        }

        public static IlinkRequestInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkRequestInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkRequestInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkRequestInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkRequestInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkRequestInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkRequestInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkRequestInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkRequestInfo parseFrom(k kVar) throws IOException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkRequestInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkRequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkRequestInfoOrBuilder extends av {
        ByteString getBody();

        int getCmdid();

        IlinkContentType getContentType();

        IlinkCryptoAlgo getCryptoAlgo();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean getLimitFlow();

        boolean getLimitFrequency();

        boolean getLongPolling();

        int getLongPollingTimeout();

        IlinkNetType getNetType();

        int getRetryCount();

        int getTimeoutMs();

        String getUrl();

        ByteString getUrlBytes();

        boolean hasBody();

        boolean hasCmdid();

        boolean hasContentType();

        boolean hasCryptoAlgo();

        boolean hasLimitFlow();

        boolean hasLimitFrequency();

        boolean hasLongPolling();

        boolean hasLongPollingTimeout();

        boolean hasNetType();

        boolean hasRetryCount();

        boolean hasTimeoutMs();

        boolean hasUrl();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public enum IlinkRunningMode implements ad.c {
        kIlinkDeviceMode(0),
        kIlinkAppMode(1);

        private static final ad.d<IlinkRunningMode> internalValueMap = new ad.d<IlinkRunningMode>() { // from class: com.tencent.ilink.network.ApiProto.IlinkRunningMode.1
            @Override // com.google.protobuf.ad.d
            public IlinkRunningMode findValueByNumber(int i3) {
                return IlinkRunningMode.forNumber(i3);
            }
        };
        public static final int kIlinkAppMode_VALUE = 1;
        public static final int kIlinkDeviceMode_VALUE = 0;
        private final int value;

        /* loaded from: classes7.dex */
        public static final class IlinkRunningModeVerifier implements ad.e {
            static final ad.e INSTANCE = new IlinkRunningModeVerifier();

            IlinkRunningModeVerifier() {
            }

            @Override // com.google.protobuf.ad.e
            public boolean isInRange(int i3) {
                if (IlinkRunningMode.forNumber(i3) != null) {
                    return true;
                }
                return false;
            }
        }

        IlinkRunningMode(int i3) {
            this.value = i3;
        }

        public static IlinkRunningMode forNumber(int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    return null;
                }
                return kIlinkAppMode;
            }
            return kIlinkDeviceMode;
        }

        public static ad.d<IlinkRunningMode> internalGetValueMap() {
            return internalValueMap;
        }

        public static ad.e internalGetVerifier() {
            return IlinkRunningModeVerifier.INSTANCE;
        }

        @Override // com.google.protobuf.ad.c
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static IlinkRunningMode valueOf(int i3) {
            return forNumber(i3);
        }
    }

    /* loaded from: classes7.dex */
    public static final class IlinkServerIplist extends GeneratedMessageLite<IlinkServerIplist, Builder> implements IlinkServerIplistOrBuilder {
        private static final IlinkServerIplist DEFAULT_INSTANCE;
        private static volatile bg<IlinkServerIplist> PARSER = null;
        public static final int SVR_IPLIST_FIELD_NUMBER = 1;
        private ad.j<String> svrIplist_ = GeneratedMessageLite.emptyProtobufList();

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkServerIplist, Builder> implements IlinkServerIplistOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllSvrIplist(Iterable<String> iterable) {
                copyOnWrite();
                ((IlinkServerIplist) this.instance).addAllSvrIplist(iterable);
                return this;
            }

            public Builder addSvrIplist(String str) {
                copyOnWrite();
                ((IlinkServerIplist) this.instance).addSvrIplist(str);
                return this;
            }

            public Builder addSvrIplistBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkServerIplist) this.instance).addSvrIplistBytes(byteString);
                return this;
            }

            public Builder clearSvrIplist() {
                copyOnWrite();
                ((IlinkServerIplist) this.instance).clearSvrIplist();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkServerIplistOrBuilder
            public String getSvrIplist(int i3) {
                return ((IlinkServerIplist) this.instance).getSvrIplist(i3);
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkServerIplistOrBuilder
            public ByteString getSvrIplistBytes(int i3) {
                return ((IlinkServerIplist) this.instance).getSvrIplistBytes(i3);
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkServerIplistOrBuilder
            public int getSvrIplistCount() {
                return ((IlinkServerIplist) this.instance).getSvrIplistCount();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkServerIplistOrBuilder
            public List<String> getSvrIplistList() {
                return Collections.unmodifiableList(((IlinkServerIplist) this.instance).getSvrIplistList());
            }

            public Builder setSvrIplist(int i3, String str) {
                copyOnWrite();
                ((IlinkServerIplist) this.instance).setSvrIplist(i3, str);
                return this;
            }

            Builder() {
                super(IlinkServerIplist.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkServerIplist ilinkServerIplist = new IlinkServerIplist();
            DEFAULT_INSTANCE = ilinkServerIplist;
            GeneratedMessageLite.registerDefaultInstance(IlinkServerIplist.class, ilinkServerIplist);
        }

        IlinkServerIplist() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllSvrIplist(Iterable<String> iterable) {
            ensureSvrIplistIsMutable();
            b.addAll((Iterable) iterable, (List) this.svrIplist_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSvrIplist(String str) {
            str.getClass();
            ensureSvrIplistIsMutable();
            this.svrIplist_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSvrIplistBytes(ByteString byteString) {
            byteString.getClass();
            ensureSvrIplistIsMutable();
            this.svrIplist_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSvrIplist() {
            this.svrIplist_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureSvrIplistIsMutable() {
            if (!this.svrIplist_.z()) {
                this.svrIplist_ = GeneratedMessageLite.mutableCopy(this.svrIplist_);
            }
        }

        public static IlinkServerIplist getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkServerIplist parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkServerIplist) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkServerIplist parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkServerIplist> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSvrIplist(int i3, String str) {
            str.getClass();
            ensureSvrIplistIsMutable();
            this.svrIplist_.set(i3, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkServerIplist();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"svrIplist_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkServerIplist> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkServerIplist.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkServerIplistOrBuilder
        public String getSvrIplist(int i3) {
            return this.svrIplist_.get(i3);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkServerIplistOrBuilder
        public ByteString getSvrIplistBytes(int i3) {
            return ByteString.copyFromUtf8(this.svrIplist_.get(i3));
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkServerIplistOrBuilder
        public int getSvrIplistCount() {
            return this.svrIplist_.size();
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkServerIplistOrBuilder
        public List<String> getSvrIplistList() {
            return this.svrIplist_;
        }

        public static Builder newBuilder(IlinkServerIplist ilinkServerIplist) {
            return DEFAULT_INSTANCE.createBuilder(ilinkServerIplist);
        }

        public static IlinkServerIplist parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkServerIplist) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkServerIplist parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkServerIplist parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkServerIplist parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkServerIplist parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkServerIplist parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkServerIplist parseFrom(InputStream inputStream) throws IOException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkServerIplist parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkServerIplist parseFrom(k kVar) throws IOException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkServerIplist parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkServerIplistOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getSvrIplist(int i3);

        ByteString getSvrIplistBytes(int i3);

        int getSvrIplistCount();

        List<String> getSvrIplistList();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkSmcBaseInfo extends GeneratedMessageLite<IlinkSmcBaseInfo, Builder> implements IlinkSmcBaseInfoOrBuilder {
        private static final IlinkSmcBaseInfo DEFAULT_INSTANCE;
        public static final int DEVICE_BRAND_FIELD_NUMBER = 2;
        public static final int DEVICE_MODEL_FIELD_NUMBER = 1;
        public static final int LANGUAGE_VER_FIELD_NUMBER = 5;
        public static final int OSNAME_FIELD_NUMBER = 3;
        public static final int OSVERSION_FIELD_NUMBER = 4;
        private static volatile bg<IlinkSmcBaseInfo> PARSER;
        private int bitField0_;
        private String deviceModel_ = "";
        private String deviceBrand_ = "";
        private String osname_ = "";
        private String osversion_ = "";
        private String languageVer_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkSmcBaseInfo, Builder> implements IlinkSmcBaseInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDeviceBrand() {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).clearDeviceBrand();
                return this;
            }

            public Builder clearDeviceModel() {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).clearDeviceModel();
                return this;
            }

            public Builder clearLanguageVer() {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).clearLanguageVer();
                return this;
            }

            public Builder clearOsname() {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).clearOsname();
                return this;
            }

            public Builder clearOsversion() {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).clearOsversion();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public String getDeviceBrand() {
                return ((IlinkSmcBaseInfo) this.instance).getDeviceBrand();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getDeviceBrandBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getDeviceBrandBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public String getDeviceModel() {
                return ((IlinkSmcBaseInfo) this.instance).getDeviceModel();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getDeviceModelBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getDeviceModelBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public String getLanguageVer() {
                return ((IlinkSmcBaseInfo) this.instance).getLanguageVer();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getLanguageVerBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getLanguageVerBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public String getOsname() {
                return ((IlinkSmcBaseInfo) this.instance).getOsname();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getOsnameBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getOsnameBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public String getOsversion() {
                return ((IlinkSmcBaseInfo) this.instance).getOsversion();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getOsversionBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getOsversionBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public boolean hasDeviceBrand() {
                return ((IlinkSmcBaseInfo) this.instance).hasDeviceBrand();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public boolean hasDeviceModel() {
                return ((IlinkSmcBaseInfo) this.instance).hasDeviceModel();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public boolean hasLanguageVer() {
                return ((IlinkSmcBaseInfo) this.instance).hasLanguageVer();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public boolean hasOsname() {
                return ((IlinkSmcBaseInfo) this.instance).hasOsname();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
            public boolean hasOsversion() {
                return ((IlinkSmcBaseInfo) this.instance).hasOsversion();
            }

            public Builder setDeviceBrand(String str) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setDeviceBrand(str);
                return this;
            }

            public Builder setDeviceBrandBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setDeviceBrandBytes(byteString);
                return this;
            }

            public Builder setDeviceModel(String str) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setDeviceModel(str);
                return this;
            }

            public Builder setDeviceModelBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setDeviceModelBytes(byteString);
                return this;
            }

            public Builder setLanguageVer(String str) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setLanguageVer(str);
                return this;
            }

            public Builder setLanguageVerBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setLanguageVerBytes(byteString);
                return this;
            }

            public Builder setOsname(String str) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setOsname(str);
                return this;
            }

            public Builder setOsnameBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setOsnameBytes(byteString);
                return this;
            }

            public Builder setOsversion(String str) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setOsversion(str);
                return this;
            }

            public Builder setOsversionBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkSmcBaseInfo) this.instance).setOsversionBytes(byteString);
                return this;
            }

            Builder() {
                super(IlinkSmcBaseInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkSmcBaseInfo ilinkSmcBaseInfo = new IlinkSmcBaseInfo();
            DEFAULT_INSTANCE = ilinkSmcBaseInfo;
            GeneratedMessageLite.registerDefaultInstance(IlinkSmcBaseInfo.class, ilinkSmcBaseInfo);
        }

        IlinkSmcBaseInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceBrand() {
            this.bitField0_ &= -3;
            this.deviceBrand_ = getDefaultInstance().getDeviceBrand();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceModel() {
            this.bitField0_ &= -2;
            this.deviceModel_ = getDefaultInstance().getDeviceModel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLanguageVer() {
            this.bitField0_ &= -17;
            this.languageVer_ = getDefaultInstance().getLanguageVer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOsname() {
            this.bitField0_ &= -5;
            this.osname_ = getDefaultInstance().getOsname();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOsversion() {
            this.bitField0_ &= -9;
            this.osversion_ = getDefaultInstance().getOsversion();
        }

        public static IlinkSmcBaseInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkSmcBaseInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkSmcBaseInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkSmcBaseInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceBrand(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.deviceBrand_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceBrandBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.deviceBrand_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceModel(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.deviceModel_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceModelBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.deviceModel_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLanguageVer(String str) {
            str.getClass();
            this.bitField0_ |= 16;
            this.languageVer_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLanguageVerBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 16;
            this.languageVer_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOsname(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.osname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOsnameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.osname_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOsversion(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.osversion_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOsversionBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.osversion_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkSmcBaseInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"bitField0_", "deviceModel_", "deviceBrand_", "osname_", "osversion_", "languageVer_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkSmcBaseInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkSmcBaseInfo.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public String getDeviceBrand() {
            return this.deviceBrand_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getDeviceBrandBytes() {
            return ByteString.copyFromUtf8(this.deviceBrand_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public String getDeviceModel() {
            return this.deviceModel_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getDeviceModelBytes() {
            return ByteString.copyFromUtf8(this.deviceModel_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public String getLanguageVer() {
            return this.languageVer_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getLanguageVerBytes() {
            return ByteString.copyFromUtf8(this.languageVer_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public String getOsname() {
            return this.osname_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getOsnameBytes() {
            return ByteString.copyFromUtf8(this.osname_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public String getOsversion() {
            return this.osversion_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getOsversionBytes() {
            return ByteString.copyFromUtf8(this.osversion_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public boolean hasDeviceBrand() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public boolean hasDeviceModel() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public boolean hasLanguageVer() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public boolean hasOsname() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSmcBaseInfoOrBuilder
        public boolean hasOsversion() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkSmcBaseInfo ilinkSmcBaseInfo) {
            return DEFAULT_INSTANCE.createBuilder(ilinkSmcBaseInfo);
        }

        public static IlinkSmcBaseInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkSmcBaseInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkSmcBaseInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkSmcBaseInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkSmcBaseInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkSmcBaseInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkSmcBaseInfo parseFrom(InputStream inputStream) throws IOException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkSmcBaseInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkSmcBaseInfo parseFrom(k kVar) throws IOException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkSmcBaseInfo parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkSmcBaseInfoOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getDeviceBrand();

        ByteString getDeviceBrandBytes();

        String getDeviceModel();

        ByteString getDeviceModelBytes();

        String getLanguageVer();

        ByteString getLanguageVerBytes();

        String getOsname();

        ByteString getOsnameBytes();

        String getOsversion();

        ByteString getOsversionBytes();

        boolean hasDeviceBrand();

        boolean hasDeviceModel();

        boolean hasLanguageVer();

        boolean hasOsname();

        boolean hasOsversion();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkStartConfig extends GeneratedMessageLite<IlinkStartConfig, Builder> implements IlinkStartConfigOrBuilder {
        public static final int DEBUG_IP_FIELD_NUMBER = 3;
        public static final int DEBUG_NET_FIELD_NUMBER = 2;
        private static final IlinkStartConfig DEFAULT_INSTANCE;
        public static final int FILE_DIR_FIELD_NUMBER = 1;
        private static volatile bg<IlinkStartConfig> PARSER = null;
        public static final int RUNNING_MODE_FIELD_NUMBER = 5;
        public static final int SELECT_DOMAIN_FIELD_NUMBER = 4;
        private int bitField0_;
        private int debugNet_;
        private int runningMode_;
        private int selectDomain_;
        private String fileDir_ = "";
        private String debugIp_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkStartConfig, Builder> implements IlinkStartConfigOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDebugIp() {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).clearDebugIp();
                return this;
            }

            public Builder clearDebugNet() {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).clearDebugNet();
                return this;
            }

            public Builder clearFileDir() {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).clearFileDir();
                return this;
            }

            public Builder clearRunningMode() {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).clearRunningMode();
                return this;
            }

            public Builder clearSelectDomain() {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).clearSelectDomain();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public String getDebugIp() {
                return ((IlinkStartConfig) this.instance).getDebugIp();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public ByteString getDebugIpBytes() {
                return ((IlinkStartConfig) this.instance).getDebugIpBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public int getDebugNet() {
                return ((IlinkStartConfig) this.instance).getDebugNet();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public String getFileDir() {
                return ((IlinkStartConfig) this.instance).getFileDir();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public ByteString getFileDirBytes() {
                return ((IlinkStartConfig) this.instance).getFileDirBytes();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public IlinkRunningMode getRunningMode() {
                return ((IlinkStartConfig) this.instance).getRunningMode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public int getSelectDomain() {
                return ((IlinkStartConfig) this.instance).getSelectDomain();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public boolean hasDebugIp() {
                return ((IlinkStartConfig) this.instance).hasDebugIp();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public boolean hasDebugNet() {
                return ((IlinkStartConfig) this.instance).hasDebugNet();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public boolean hasFileDir() {
                return ((IlinkStartConfig) this.instance).hasFileDir();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public boolean hasRunningMode() {
                return ((IlinkStartConfig) this.instance).hasRunningMode();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
            public boolean hasSelectDomain() {
                return ((IlinkStartConfig) this.instance).hasSelectDomain();
            }

            public Builder setDebugIp(String str) {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).setDebugIp(str);
                return this;
            }

            public Builder setDebugIpBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).setDebugIpBytes(byteString);
                return this;
            }

            public Builder setDebugNet(int i3) {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).setDebugNet(i3);
                return this;
            }

            public Builder setFileDir(String str) {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).setFileDir(str);
                return this;
            }

            public Builder setFileDirBytes(ByteString byteString) {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).setFileDirBytes(byteString);
                return this;
            }

            public Builder setRunningMode(IlinkRunningMode ilinkRunningMode) {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).setRunningMode(ilinkRunningMode);
                return this;
            }

            public Builder setSelectDomain(int i3) {
                copyOnWrite();
                ((IlinkStartConfig) this.instance).setSelectDomain(i3);
                return this;
            }

            Builder() {
                super(IlinkStartConfig.DEFAULT_INSTANCE);
            }
        }

        static {
            IlinkStartConfig ilinkStartConfig = new IlinkStartConfig();
            DEFAULT_INSTANCE = ilinkStartConfig;
            GeneratedMessageLite.registerDefaultInstance(IlinkStartConfig.class, ilinkStartConfig);
        }

        IlinkStartConfig() {
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
        public void clearRunningMode() {
            this.bitField0_ &= -17;
            this.runningMode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSelectDomain() {
            this.bitField0_ &= -9;
            this.selectDomain_ = 0;
        }

        public static IlinkStartConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkStartConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkStartConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkStartConfig parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkStartConfig> parser() {
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
        public void setRunningMode(IlinkRunningMode ilinkRunningMode) {
            ilinkRunningMode.getClass();
            this.bitField0_ |= 16;
            this.runningMode_ = ilinkRunningMode.getNumber();
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
                    return new IlinkStartConfig();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\b\u0002\u0004\u000b\u0003\u0005\f\u0004", new Object[]{"bitField0_", "fileDir_", "debugNet_", "debugIp_", "selectDomain_", "runningMode_", IlinkRunningMode.internalGetVerifier()});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkStartConfig> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkStartConfig.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public String getDebugIp() {
            return this.debugIp_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public ByteString getDebugIpBytes() {
            return ByteString.copyFromUtf8(this.debugIp_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public int getDebugNet() {
            return this.debugNet_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public String getFileDir() {
            return this.fileDir_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public ByteString getFileDirBytes() {
            return ByteString.copyFromUtf8(this.fileDir_);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public IlinkRunningMode getRunningMode() {
            IlinkRunningMode forNumber = IlinkRunningMode.forNumber(this.runningMode_);
            if (forNumber == null) {
                return IlinkRunningMode.kIlinkDeviceMode;
            }
            return forNumber;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public int getSelectDomain() {
            return this.selectDomain_;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public boolean hasDebugIp() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public boolean hasDebugNet() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public boolean hasFileDir() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public boolean hasRunningMode() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkStartConfigOrBuilder
        public boolean hasSelectDomain() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(IlinkStartConfig ilinkStartConfig) {
            return DEFAULT_INSTANCE.createBuilder(ilinkStartConfig);
        }

        public static IlinkStartConfig parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkStartConfig) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkStartConfig parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkStartConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static IlinkStartConfig parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static IlinkStartConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkStartConfig parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static IlinkStartConfig parseFrom(InputStream inputStream) throws IOException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkStartConfig parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkStartConfig parseFrom(k kVar) throws IOException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkStartConfig parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkStartConfig) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkStartConfigOrBuilder extends av {
        String getDebugIp();

        ByteString getDebugIpBytes();

        int getDebugNet();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getFileDir();

        ByteString getFileDirBytes();

        IlinkRunningMode getRunningMode();

        int getSelectDomain();

        boolean hasDebugIp();

        boolean hasDebugNet();

        boolean hasFileDir();

        boolean hasRunningMode();

        boolean hasSelectDomain();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class IlinkSyncCmdList extends GeneratedMessageLite<IlinkSyncCmdList, Builder> implements IlinkSyncCmdListOrBuilder {
        public static final int CMDLIST_FIELD_NUMBER = 1;
        private static final IlinkSyncCmdList DEFAULT_INSTANCE;
        private static volatile bg<IlinkSyncCmdList> PARSER;
        private ad.j<IlinkCmdItem> cmdlist_ = GeneratedMessageLite.emptyProtobufList();

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<IlinkSyncCmdList, Builder> implements IlinkSyncCmdListOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllCmdlist(Iterable<? extends IlinkCmdItem> iterable) {
                copyOnWrite();
                ((IlinkSyncCmdList) this.instance).addAllCmdlist(iterable);
                return this;
            }

            public Builder addCmdlist(IlinkCmdItem ilinkCmdItem) {
                copyOnWrite();
                ((IlinkSyncCmdList) this.instance).addCmdlist(ilinkCmdItem);
                return this;
            }

            public Builder clearCmdlist() {
                copyOnWrite();
                ((IlinkSyncCmdList) this.instance).clearCmdlist();
                return this;
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSyncCmdListOrBuilder
            public IlinkCmdItem getCmdlist(int i3) {
                return ((IlinkSyncCmdList) this.instance).getCmdlist(i3);
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSyncCmdListOrBuilder
            public int getCmdlistCount() {
                return ((IlinkSyncCmdList) this.instance).getCmdlistCount();
            }

            @Override // com.tencent.ilink.network.ApiProto.IlinkSyncCmdListOrBuilder
            public List<IlinkCmdItem> getCmdlistList() {
                return Collections.unmodifiableList(((IlinkSyncCmdList) this.instance).getCmdlistList());
            }

            public Builder removeCmdlist(int i3) {
                copyOnWrite();
                ((IlinkSyncCmdList) this.instance).removeCmdlist(i3);
                return this;
            }

            public Builder setCmdlist(int i3, IlinkCmdItem ilinkCmdItem) {
                copyOnWrite();
                ((IlinkSyncCmdList) this.instance).setCmdlist(i3, ilinkCmdItem);
                return this;
            }

            Builder() {
                super(IlinkSyncCmdList.DEFAULT_INSTANCE);
            }

            public Builder addCmdlist(int i3, IlinkCmdItem ilinkCmdItem) {
                copyOnWrite();
                ((IlinkSyncCmdList) this.instance).addCmdlist(i3, ilinkCmdItem);
                return this;
            }

            public Builder setCmdlist(int i3, IlinkCmdItem.Builder builder) {
                copyOnWrite();
                ((IlinkSyncCmdList) this.instance).setCmdlist(i3, builder);
                return this;
            }

            public Builder addCmdlist(IlinkCmdItem.Builder builder) {
                copyOnWrite();
                ((IlinkSyncCmdList) this.instance).addCmdlist(builder);
                return this;
            }

            public Builder addCmdlist(int i3, IlinkCmdItem.Builder builder) {
                copyOnWrite();
                ((IlinkSyncCmdList) this.instance).addCmdlist(i3, builder);
                return this;
            }
        }

        static {
            IlinkSyncCmdList ilinkSyncCmdList = new IlinkSyncCmdList();
            DEFAULT_INSTANCE = ilinkSyncCmdList;
            GeneratedMessageLite.registerDefaultInstance(IlinkSyncCmdList.class, ilinkSyncCmdList);
        }

        IlinkSyncCmdList() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllCmdlist(Iterable<? extends IlinkCmdItem> iterable) {
            ensureCmdlistIsMutable();
            b.addAll((Iterable) iterable, (List) this.cmdlist_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCmdlist(IlinkCmdItem ilinkCmdItem) {
            ilinkCmdItem.getClass();
            ensureCmdlistIsMutable();
            this.cmdlist_.add(ilinkCmdItem);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCmdlist() {
            this.cmdlist_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureCmdlistIsMutable() {
            if (!this.cmdlist_.z()) {
                this.cmdlist_ = GeneratedMessageLite.mutableCopy(this.cmdlist_);
            }
        }

        public static IlinkSyncCmdList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static IlinkSyncCmdList parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkSyncCmdList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<IlinkSyncCmdList> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeCmdlist(int i3) {
            ensureCmdlistIsMutable();
            this.cmdlist_.remove(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCmdlist(int i3, IlinkCmdItem ilinkCmdItem) {
            ilinkCmdItem.getClass();
            ensureCmdlistIsMutable();
            this.cmdlist_.set(i3, ilinkCmdItem);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new IlinkSyncCmdList();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"cmdlist_", IlinkCmdItem.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<IlinkSyncCmdList> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (IlinkSyncCmdList.class) {
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

        @Override // com.tencent.ilink.network.ApiProto.IlinkSyncCmdListOrBuilder
        public IlinkCmdItem getCmdlist(int i3) {
            return this.cmdlist_.get(i3);
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSyncCmdListOrBuilder
        public int getCmdlistCount() {
            return this.cmdlist_.size();
        }

        @Override // com.tencent.ilink.network.ApiProto.IlinkSyncCmdListOrBuilder
        public List<IlinkCmdItem> getCmdlistList() {
            return this.cmdlist_;
        }

        public IlinkCmdItemOrBuilder getCmdlistOrBuilder(int i3) {
            return this.cmdlist_.get(i3);
        }

        public List<? extends IlinkCmdItemOrBuilder> getCmdlistOrBuilderList() {
            return this.cmdlist_;
        }

        public static Builder newBuilder(IlinkSyncCmdList ilinkSyncCmdList) {
            return DEFAULT_INSTANCE.createBuilder(ilinkSyncCmdList);
        }

        public static IlinkSyncCmdList parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static IlinkSyncCmdList parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static IlinkSyncCmdList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCmdlist(int i3, IlinkCmdItem ilinkCmdItem) {
            ilinkCmdItem.getClass();
            ensureCmdlistIsMutable();
            this.cmdlist_.add(i3, ilinkCmdItem);
        }

        public static IlinkSyncCmdList parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCmdlist(int i3, IlinkCmdItem.Builder builder) {
            ensureCmdlistIsMutable();
            this.cmdlist_.set(i3, builder.build());
        }

        public static IlinkSyncCmdList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static IlinkSyncCmdList parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCmdlist(IlinkCmdItem.Builder builder) {
            ensureCmdlistIsMutable();
            this.cmdlist_.add(builder.build());
        }

        public static IlinkSyncCmdList parseFrom(InputStream inputStream) throws IOException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static IlinkSyncCmdList parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addCmdlist(int i3, IlinkCmdItem.Builder builder) {
            ensureCmdlistIsMutable();
            this.cmdlist_.add(i3, builder.build());
        }

        public static IlinkSyncCmdList parseFrom(k kVar) throws IOException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static IlinkSyncCmdList parseFrom(k kVar, t tVar) throws IOException {
            return (IlinkSyncCmdList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface IlinkSyncCmdListOrBuilder extends av {
        IlinkCmdItem getCmdlist(int i3);

        int getCmdlistCount();

        List<IlinkCmdItem> getCmdlistList();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    ApiProto() {
    }

    public static void registerAllExtensions(t tVar) {
    }
}
