package com.tencent.mobileqq.hermes.task;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.au;
import com.google.protobuf.av;
import com.google.protobuf.bg;
import com.google.protobuf.k;
import com.google.protobuf.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes8.dex */
public final class CountManagerPB {
    static IPatchRedirector $redirector_;

    /* renamed from: com.tencent.mobileqq.hermes.task.CountManagerPB$1, reason: invalid class name */
    /* loaded from: classes8.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25517);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
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

    /* loaded from: classes8.dex */
    public static final class GetCountResReq extends GeneratedMessageLite<GetCountResReq, Builder> implements GetCountResReqOrBuilder {
        static IPatchRedirector $redirector_ = null;
        public static final int BIZ_TYPE_FIELD_NUMBER = 1;
        private static final GetCountResReq DEFAULT_INSTANCE;
        private static volatile bg<GetCountResReq> PARSER;
        private long bizType_;

        /* loaded from: classes8.dex */
        public static final class Builder extends GeneratedMessageLite.a<GetCountResReq, Builder> implements GetCountResReqOrBuilder {
            static IPatchRedirector $redirector_;

            Builder() {
                super(GetCountResReq.DEFAULT_INSTANCE);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public Builder clearBizType() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Builder) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                copyOnWrite();
                ((GetCountResReq) this.instance).clearBizType();
                return this;
            }

            @Override // com.tencent.mobileqq.hermes.task.CountManagerPB.GetCountResReqOrBuilder
            public long getBizType() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
                }
                return ((GetCountResReq) this.instance).getBizType();
            }

            public Builder setBizType(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, j3);
                }
                copyOnWrite();
                ((GetCountResReq) this.instance).setBizType(j3);
                return this;
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27017);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
                return;
            }
            GetCountResReq getCountResReq = new GetCountResReq();
            DEFAULT_INSTANCE = getCountResReq;
            GeneratedMessageLite.registerDefaultInstance(GetCountResReq.class, getCountResReq);
        }

        GetCountResReq() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBizType() {
            this.bizType_ = 0L;
        }

        public static GetCountResReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static GetCountResReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetCountResReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetCountResReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<GetCountResReq> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBizType(long j3) {
            this.bizType_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, this, methodToInvoke, obj, obj2);
            }
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetCountResReq();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0003", new Object[]{"bizType_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<GetCountResReq> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (GetCountResReq.class) {
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

        @Override // com.tencent.mobileqq.hermes.task.CountManagerPB.GetCountResReqOrBuilder
        public long getBizType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.bizType_;
        }

        public static Builder newBuilder(GetCountResReq getCountResReq) {
            return DEFAULT_INSTANCE.createBuilder(getCountResReq);
        }

        public static GetCountResReq parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (GetCountResReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static GetCountResReq parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static GetCountResReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetCountResReq parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static GetCountResReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetCountResReq parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static GetCountResReq parseFrom(InputStream inputStream) throws IOException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetCountResReq parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static GetCountResReq parseFrom(k kVar) throws IOException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static GetCountResReq parseFrom(k kVar, t tVar) throws IOException {
            return (GetCountResReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes8.dex */
    public interface GetCountResReqOrBuilder extends av {
        long getBizType();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes8.dex */
    public static final class GetCountResRsp extends GeneratedMessageLite<GetCountResRsp, Builder> implements GetCountResRspOrBuilder {
        static IPatchRedirector $redirector_ = null;
        public static final int COUNT_FIELD_NUMBER = 1;
        private static final GetCountResRsp DEFAULT_INSTANCE;
        private static volatile bg<GetCountResRsp> PARSER;
        private long count_;

        /* loaded from: classes8.dex */
        public static final class Builder extends GeneratedMessageLite.a<GetCountResRsp, Builder> implements GetCountResRspOrBuilder {
            static IPatchRedirector $redirector_;

            Builder() {
                super(GetCountResRsp.DEFAULT_INSTANCE);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public Builder clearCount() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Builder) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                copyOnWrite();
                ((GetCountResRsp) this.instance).clearCount();
                return this;
            }

            @Override // com.tencent.mobileqq.hermes.task.CountManagerPB.GetCountResRspOrBuilder
            public long getCount() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
                }
                return ((GetCountResRsp) this.instance).getCount();
            }

            public Builder setCount(long j3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, j3);
                }
                copyOnWrite();
                ((GetCountResRsp) this.instance).setCount(j3);
                return this;
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28917);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
                return;
            }
            GetCountResRsp getCountResRsp = new GetCountResRsp();
            DEFAULT_INSTANCE = getCountResRsp;
            GeneratedMessageLite.registerDefaultInstance(GetCountResRsp.class, getCountResRsp);
        }

        GetCountResRsp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCount() {
            this.count_ = 0L;
        }

        public static GetCountResRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static GetCountResRsp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (GetCountResRsp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetCountResRsp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<GetCountResRsp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCount(long j3) {
            this.count_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, this, methodToInvoke, obj, obj2);
            }
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new GetCountResRsp();
                case 2:
                    return new Builder();
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0003", new Object[]{"count_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<GetCountResRsp> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (GetCountResRsp.class) {
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

        @Override // com.tencent.mobileqq.hermes.task.CountManagerPB.GetCountResRspOrBuilder
        public long getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.count_;
        }

        public static Builder newBuilder(GetCountResRsp getCountResRsp) {
            return DEFAULT_INSTANCE.createBuilder(getCountResRsp);
        }

        public static GetCountResRsp parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (GetCountResRsp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static GetCountResRsp parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static GetCountResRsp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static GetCountResRsp parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static GetCountResRsp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static GetCountResRsp parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static GetCountResRsp parseFrom(InputStream inputStream) throws IOException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static GetCountResRsp parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static GetCountResRsp parseFrom(k kVar) throws IOException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static GetCountResRsp parseFrom(k kVar, t tVar) throws IOException {
            return (GetCountResRsp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes8.dex */
    public interface GetCountResRspOrBuilder extends av {
        long getCount();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30225);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    CountManagerPB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void registerAllExtensions(t tVar) {
    }
}
