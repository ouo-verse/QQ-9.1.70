package com.tencent.ilinkservice;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.au;
import com.google.protobuf.av;
import com.google.protobuf.bg;
import com.google.protobuf.k;
import com.google.protobuf.t;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class AidlProto {

    /* renamed from: com.tencent.ilinkservice.AidlProto$1, reason: invalid class name */
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
    public static final class changeDomainRequest extends GeneratedMessageLite<changeDomainRequest, Builder> implements changeDomainRequestOrBuilder {
        private static final changeDomainRequest DEFAULT_INSTANCE;
        public static final int DOMAIN_FIELD_NUMBER = 1;
        private static volatile bg<changeDomainRequest> PARSER;
        private int bitField0_;
        private int domain_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<changeDomainRequest, Builder> implements changeDomainRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDomain() {
                copyOnWrite();
                ((changeDomainRequest) this.instance).clearDomain();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.changeDomainRequestOrBuilder
            public int getDomain() {
                return ((changeDomainRequest) this.instance).getDomain();
            }

            @Override // com.tencent.ilinkservice.AidlProto.changeDomainRequestOrBuilder
            public boolean hasDomain() {
                return ((changeDomainRequest) this.instance).hasDomain();
            }

            public Builder setDomain(int i3) {
                copyOnWrite();
                ((changeDomainRequest) this.instance).setDomain(i3);
                return this;
            }

            Builder() {
                super(changeDomainRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            changeDomainRequest changedomainrequest = new changeDomainRequest();
            DEFAULT_INSTANCE = changedomainrequest;
            GeneratedMessageLite.registerDefaultInstance(changeDomainRequest.class, changedomainrequest);
        }

        changeDomainRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDomain() {
            this.bitField0_ &= -2;
            this.domain_ = 0;
        }

        public static changeDomainRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static changeDomainRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (changeDomainRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static changeDomainRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<changeDomainRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDomain(int i3) {
            this.bitField0_ |= 1;
            this.domain_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new changeDomainRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"bitField0_", "domain_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<changeDomainRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (changeDomainRequest.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.changeDomainRequestOrBuilder
        public int getDomain() {
            return this.domain_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.changeDomainRequestOrBuilder
        public boolean hasDomain() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(changeDomainRequest changedomainrequest) {
            return DEFAULT_INSTANCE.createBuilder(changedomainrequest);
        }

        public static changeDomainRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (changeDomainRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static changeDomainRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static changeDomainRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static changeDomainRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static changeDomainRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static changeDomainRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static changeDomainRequest parseFrom(InputStream inputStream) throws IOException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static changeDomainRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static changeDomainRequest parseFrom(k kVar) throws IOException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static changeDomainRequest parseFrom(k kVar, t tVar) throws IOException {
            return (changeDomainRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface changeDomainRequestOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getDomain();

        boolean hasDomain();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class commFunctionReqWithReq extends GeneratedMessageLite<commFunctionReqWithReq, Builder> implements commFunctionReqWithReqOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final commFunctionReqWithReq DEFAULT_INSTANCE;
        private static volatile bg<commFunctionReqWithReq> PARSER = null;
        public static final int REQDATA_FIELD_NUMBER = 2;
        private int bitField0_;
        private String appid_ = "";
        private ByteString reqdata_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<commFunctionReqWithReq, Builder> implements commFunctionReqWithReqOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((commFunctionReqWithReq) this.instance).clearAppid();
                return this;
            }

            public Builder clearReqdata() {
                copyOnWrite();
                ((commFunctionReqWithReq) this.instance).clearReqdata();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
            public String getAppid() {
                return ((commFunctionReqWithReq) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
            public ByteString getAppidBytes() {
                return ((commFunctionReqWithReq) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
            public ByteString getReqdata() {
                return ((commFunctionReqWithReq) this.instance).getReqdata();
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
            public boolean hasAppid() {
                return ((commFunctionReqWithReq) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
            public boolean hasReqdata() {
                return ((commFunctionReqWithReq) this.instance).hasReqdata();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((commFunctionReqWithReq) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((commFunctionReqWithReq) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setReqdata(ByteString byteString) {
                copyOnWrite();
                ((commFunctionReqWithReq) this.instance).setReqdata(byteString);
                return this;
            }

            Builder() {
                super(commFunctionReqWithReq.DEFAULT_INSTANCE);
            }
        }

        static {
            commFunctionReqWithReq commfunctionreqwithreq = new commFunctionReqWithReq();
            DEFAULT_INSTANCE = commfunctionreqwithreq;
            GeneratedMessageLite.registerDefaultInstance(commFunctionReqWithReq.class, commfunctionreqwithreq);
        }

        commFunctionReqWithReq() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReqdata() {
            this.bitField0_ &= -3;
            this.reqdata_ = getDefaultInstance().getReqdata();
        }

        public static commFunctionReqWithReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static commFunctionReqWithReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static commFunctionReqWithReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<commFunctionReqWithReq> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setReqdata(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.reqdata_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new commFunctionReqWithReq();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "appid_", "reqdata_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<commFunctionReqWithReq> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (commFunctionReqWithReq.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
        public ByteString getReqdata() {
            return this.reqdata_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithReqOrBuilder
        public boolean hasReqdata() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(commFunctionReqWithReq commfunctionreqwithreq) {
            return DEFAULT_INSTANCE.createBuilder(commfunctionreqwithreq);
        }

        public static commFunctionReqWithReq parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static commFunctionReqWithReq parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static commFunctionReqWithReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static commFunctionReqWithReq parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static commFunctionReqWithReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static commFunctionReqWithReq parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static commFunctionReqWithReq parseFrom(InputStream inputStream) throws IOException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static commFunctionReqWithReq parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static commFunctionReqWithReq parseFrom(k kVar) throws IOException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static commFunctionReqWithReq parseFrom(k kVar, t tVar) throws IOException {
            return (commFunctionReqWithReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface commFunctionReqWithReqOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getReqdata();

        boolean hasAppid();

        boolean hasReqdata();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class commFunctionReqWithTaskid extends GeneratedMessageLite<commFunctionReqWithTaskid, Builder> implements commFunctionReqWithTaskidOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final commFunctionReqWithTaskid DEFAULT_INSTANCE;
        private static volatile bg<commFunctionReqWithTaskid> PARSER = null;
        public static final int TASKID_FIELD_NUMBER = 2;
        private String appid_ = "";
        private int bitField0_;
        private int taskid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<commFunctionReqWithTaskid, Builder> implements commFunctionReqWithTaskidOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((commFunctionReqWithTaskid) this.instance).clearAppid();
                return this;
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((commFunctionReqWithTaskid) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
            public String getAppid() {
                return ((commFunctionReqWithTaskid) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
            public ByteString getAppidBytes() {
                return ((commFunctionReqWithTaskid) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
            public int getTaskid() {
                return ((commFunctionReqWithTaskid) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
            public boolean hasAppid() {
                return ((commFunctionReqWithTaskid) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
            public boolean hasTaskid() {
                return ((commFunctionReqWithTaskid) this.instance).hasTaskid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((commFunctionReqWithTaskid) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((commFunctionReqWithTaskid) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setTaskid(int i3) {
                copyOnWrite();
                ((commFunctionReqWithTaskid) this.instance).setTaskid(i3);
                return this;
            }

            Builder() {
                super(commFunctionReqWithTaskid.DEFAULT_INSTANCE);
            }
        }

        static {
            commFunctionReqWithTaskid commfunctionreqwithtaskid = new commFunctionReqWithTaskid();
            DEFAULT_INSTANCE = commfunctionreqwithtaskid;
            GeneratedMessageLite.registerDefaultInstance(commFunctionReqWithTaskid.class, commfunctionreqwithtaskid);
        }

        commFunctionReqWithTaskid() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -3;
            this.taskid_ = 0;
        }

        public static commFunctionReqWithTaskid getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static commFunctionReqWithTaskid parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static commFunctionReqWithTaskid parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<commFunctionReqWithTaskid> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(int i3) {
            this.bitField0_ |= 2;
            this.taskid_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new commFunctionReqWithTaskid();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001", new Object[]{"bitField0_", "appid_", "taskid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<commFunctionReqWithTaskid> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (commFunctionReqWithTaskid.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
        public int getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionReqWithTaskidOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(commFunctionReqWithTaskid commfunctionreqwithtaskid) {
            return DEFAULT_INSTANCE.createBuilder(commfunctionreqwithtaskid);
        }

        public static commFunctionReqWithTaskid parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static commFunctionReqWithTaskid parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static commFunctionReqWithTaskid parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static commFunctionReqWithTaskid parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static commFunctionReqWithTaskid parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static commFunctionReqWithTaskid parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static commFunctionReqWithTaskid parseFrom(InputStream inputStream) throws IOException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static commFunctionReqWithTaskid parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static commFunctionReqWithTaskid parseFrom(k kVar) throws IOException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static commFunctionReqWithTaskid parseFrom(k kVar, t tVar) throws IOException {
            return (commFunctionReqWithTaskid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface commFunctionReqWithTaskidOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getTaskid();

        boolean hasAppid();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class commFunctionTaskidResp extends GeneratedMessageLite<commFunctionTaskidResp, Builder> implements commFunctionTaskidRespOrBuilder {
        private static final commFunctionTaskidResp DEFAULT_INSTANCE;
        private static volatile bg<commFunctionTaskidResp> PARSER = null;
        public static final int TASKID_FIELD_NUMBER = 1;
        private int bitField0_;
        private int taskid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<commFunctionTaskidResp, Builder> implements commFunctionTaskidRespOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((commFunctionTaskidResp) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionTaskidRespOrBuilder
            public int getTaskid() {
                return ((commFunctionTaskidResp) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.commFunctionTaskidRespOrBuilder
            public boolean hasTaskid() {
                return ((commFunctionTaskidResp) this.instance).hasTaskid();
            }

            public Builder setTaskid(int i3) {
                copyOnWrite();
                ((commFunctionTaskidResp) this.instance).setTaskid(i3);
                return this;
            }

            Builder() {
                super(commFunctionTaskidResp.DEFAULT_INSTANCE);
            }
        }

        static {
            commFunctionTaskidResp commfunctiontaskidresp = new commFunctionTaskidResp();
            DEFAULT_INSTANCE = commfunctiontaskidresp;
            GeneratedMessageLite.registerDefaultInstance(commFunctionTaskidResp.class, commfunctiontaskidresp);
        }

        commFunctionTaskidResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -2;
            this.taskid_ = 0;
        }

        public static commFunctionTaskidResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static commFunctionTaskidResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static commFunctionTaskidResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<commFunctionTaskidResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(int i3) {
            this.bitField0_ |= 1;
            this.taskid_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new commFunctionTaskidResp();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b\u0000", new Object[]{"bitField0_", "taskid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<commFunctionTaskidResp> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (commFunctionTaskidResp.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionTaskidRespOrBuilder
        public int getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.commFunctionTaskidRespOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(commFunctionTaskidResp commfunctiontaskidresp) {
            return DEFAULT_INSTANCE.createBuilder(commfunctiontaskidresp);
        }

        public static commFunctionTaskidResp parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static commFunctionTaskidResp parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static commFunctionTaskidResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static commFunctionTaskidResp parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static commFunctionTaskidResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static commFunctionTaskidResp parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static commFunctionTaskidResp parseFrom(InputStream inputStream) throws IOException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static commFunctionTaskidResp parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static commFunctionTaskidResp parseFrom(k kVar) throws IOException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static commFunctionTaskidResp parseFrom(k kVar, t tVar) throws IOException {
            return (commFunctionTaskidResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface commFunctionTaskidRespOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getTaskid();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class createImSession extends GeneratedMessageLite<createImSession, Builder> implements createImSessionOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final createImSession DEFAULT_INSTANCE;
        private static volatile bg<createImSession> PARSER;
        private String appid_ = "";
        private int bitField0_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<createImSession, Builder> implements createImSessionOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((createImSession) this.instance).clearAppid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.createImSessionOrBuilder
            public String getAppid() {
                return ((createImSession) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.createImSessionOrBuilder
            public ByteString getAppidBytes() {
                return ((createImSession) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.createImSessionOrBuilder
            public boolean hasAppid() {
                return ((createImSession) this.instance).hasAppid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((createImSession) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((createImSession) this.instance).setAppidBytes(byteString);
                return this;
            }

            Builder() {
                super(createImSession.DEFAULT_INSTANCE);
            }
        }

        static {
            createImSession createimsession = new createImSession();
            DEFAULT_INSTANCE = createimsession;
            GeneratedMessageLite.registerDefaultInstance(createImSession.class, createimsession);
        }

        createImSession() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        public static createImSession getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static createImSession parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (createImSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static createImSession parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<createImSession> parser() {
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
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new createImSession();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "appid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<createImSession> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (createImSession.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.createImSessionOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.createImSessionOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.createImSessionOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(createImSession createimsession) {
            return DEFAULT_INSTANCE.createBuilder(createimsession);
        }

        public static createImSession parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (createImSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static createImSession parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static createImSession parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static createImSession parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static createImSession parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static createImSession parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static createImSession parseFrom(InputStream inputStream) throws IOException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static createImSession parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static createImSession parseFrom(k kVar) throws IOException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static createImSession parseFrom(k kVar, t tVar) throws IOException {
            return (createImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface createImSessionOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasAppid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class destroyImSession extends GeneratedMessageLite<destroyImSession, Builder> implements destroyImSessionOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final destroyImSession DEFAULT_INSTANCE;
        private static volatile bg<destroyImSession> PARSER;
        private String appid_ = "";
        private int bitField0_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<destroyImSession, Builder> implements destroyImSessionOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((destroyImSession) this.instance).clearAppid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.destroyImSessionOrBuilder
            public String getAppid() {
                return ((destroyImSession) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.destroyImSessionOrBuilder
            public ByteString getAppidBytes() {
                return ((destroyImSession) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.destroyImSessionOrBuilder
            public boolean hasAppid() {
                return ((destroyImSession) this.instance).hasAppid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((destroyImSession) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((destroyImSession) this.instance).setAppidBytes(byteString);
                return this;
            }

            Builder() {
                super(destroyImSession.DEFAULT_INSTANCE);
            }
        }

        static {
            destroyImSession destroyimsession = new destroyImSession();
            DEFAULT_INSTANCE = destroyimsession;
            GeneratedMessageLite.registerDefaultInstance(destroyImSession.class, destroyimsession);
        }

        destroyImSession() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        public static destroyImSession getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static destroyImSession parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (destroyImSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static destroyImSession parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<destroyImSession> parser() {
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
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new destroyImSession();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "appid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<destroyImSession> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (destroyImSession.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.destroyImSessionOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.destroyImSessionOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.destroyImSessionOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(destroyImSession destroyimsession) {
            return DEFAULT_INSTANCE.createBuilder(destroyimsession);
        }

        public static destroyImSession parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (destroyImSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static destroyImSession parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static destroyImSession parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static destroyImSession parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static destroyImSession parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static destroyImSession parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static destroyImSession parseFrom(InputStream inputStream) throws IOException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static destroyImSession parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static destroyImSession parseFrom(k kVar) throws IOException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static destroyImSession parseFrom(k kVar, t tVar) throws IOException {
            return (destroyImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface destroyImSessionOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasAppid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class getDeviceShadowReq extends GeneratedMessageLite<getDeviceShadowReq, Builder> implements getDeviceShadowReqOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final getDeviceShadowReq DEFAULT_INSTANCE;
        private static volatile bg<getDeviceShadowReq> PARSER;
        private String appid_ = "";
        private int bitField0_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<getDeviceShadowReq, Builder> implements getDeviceShadowReqOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((getDeviceShadowReq) this.instance).clearAppid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowReqOrBuilder
            public String getAppid() {
                return ((getDeviceShadowReq) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowReqOrBuilder
            public ByteString getAppidBytes() {
                return ((getDeviceShadowReq) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowReqOrBuilder
            public boolean hasAppid() {
                return ((getDeviceShadowReq) this.instance).hasAppid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((getDeviceShadowReq) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((getDeviceShadowReq) this.instance).setAppidBytes(byteString);
                return this;
            }

            Builder() {
                super(getDeviceShadowReq.DEFAULT_INSTANCE);
            }
        }

        static {
            getDeviceShadowReq getdeviceshadowreq = new getDeviceShadowReq();
            DEFAULT_INSTANCE = getdeviceshadowreq;
            GeneratedMessageLite.registerDefaultInstance(getDeviceShadowReq.class, getdeviceshadowreq);
        }

        getDeviceShadowReq() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        public static getDeviceShadowReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static getDeviceShadowReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static getDeviceShadowReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<getDeviceShadowReq> parser() {
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
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new getDeviceShadowReq();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "appid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<getDeviceShadowReq> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (getDeviceShadowReq.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowReqOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowReqOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowReqOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(getDeviceShadowReq getdeviceshadowreq) {
            return DEFAULT_INSTANCE.createBuilder(getdeviceshadowreq);
        }

        public static getDeviceShadowReq parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static getDeviceShadowReq parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static getDeviceShadowReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static getDeviceShadowReq parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static getDeviceShadowReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static getDeviceShadowReq parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static getDeviceShadowReq parseFrom(InputStream inputStream) throws IOException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static getDeviceShadowReq parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static getDeviceShadowReq parseFrom(k kVar) throws IOException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static getDeviceShadowReq parseFrom(k kVar, t tVar) throws IOException {
            return (getDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface getDeviceShadowReqOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasAppid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class getDeviceShadowResp extends GeneratedMessageLite<getDeviceShadowResp, Builder> implements getDeviceShadowRespOrBuilder {
        private static final getDeviceShadowResp DEFAULT_INSTANCE;
        private static volatile bg<getDeviceShadowResp> PARSER = null;
        public static final int TASKID_FIELD_NUMBER = 1;
        private int bitField0_;
        private int taskid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<getDeviceShadowResp, Builder> implements getDeviceShadowRespOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((getDeviceShadowResp) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowRespOrBuilder
            public int getTaskid() {
                return ((getDeviceShadowResp) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowRespOrBuilder
            public boolean hasTaskid() {
                return ((getDeviceShadowResp) this.instance).hasTaskid();
            }

            public Builder setTaskid(int i3) {
                copyOnWrite();
                ((getDeviceShadowResp) this.instance).setTaskid(i3);
                return this;
            }

            Builder() {
                super(getDeviceShadowResp.DEFAULT_INSTANCE);
            }
        }

        static {
            getDeviceShadowResp getdeviceshadowresp = new getDeviceShadowResp();
            DEFAULT_INSTANCE = getdeviceshadowresp;
            GeneratedMessageLite.registerDefaultInstance(getDeviceShadowResp.class, getdeviceshadowresp);
        }

        getDeviceShadowResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -2;
            this.taskid_ = 0;
        }

        public static getDeviceShadowResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static getDeviceShadowResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static getDeviceShadowResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<getDeviceShadowResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(int i3) {
            this.bitField0_ |= 1;
            this.taskid_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new getDeviceShadowResp();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b\u0000", new Object[]{"bitField0_", "taskid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<getDeviceShadowResp> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (getDeviceShadowResp.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowRespOrBuilder
        public int getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.getDeviceShadowRespOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(getDeviceShadowResp getdeviceshadowresp) {
            return DEFAULT_INSTANCE.createBuilder(getdeviceshadowresp);
        }

        public static getDeviceShadowResp parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static getDeviceShadowResp parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static getDeviceShadowResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static getDeviceShadowResp parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static getDeviceShadowResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static getDeviceShadowResp parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static getDeviceShadowResp parseFrom(InputStream inputStream) throws IOException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static getDeviceShadowResp parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static getDeviceShadowResp parseFrom(k kVar) throws IOException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static getDeviceShadowResp parseFrom(k kVar, t tVar) throws IOException {
            return (getDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface getDeviceShadowRespOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getTaskid();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class getIlinkServiceVersionResp extends GeneratedMessageLite<getIlinkServiceVersionResp, Builder> implements getIlinkServiceVersionRespOrBuilder {
        private static final getIlinkServiceVersionResp DEFAULT_INSTANCE;
        private static volatile bg<getIlinkServiceVersionResp> PARSER = null;
        public static final int VERSION_FIELD_NUMBER = 1;
        private int bitField0_;
        private String version_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<getIlinkServiceVersionResp, Builder> implements getIlinkServiceVersionRespOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearVersion() {
                copyOnWrite();
                ((getIlinkServiceVersionResp) this.instance).clearVersion();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.getIlinkServiceVersionRespOrBuilder
            public String getVersion() {
                return ((getIlinkServiceVersionResp) this.instance).getVersion();
            }

            @Override // com.tencent.ilinkservice.AidlProto.getIlinkServiceVersionRespOrBuilder
            public ByteString getVersionBytes() {
                return ((getIlinkServiceVersionResp) this.instance).getVersionBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.getIlinkServiceVersionRespOrBuilder
            public boolean hasVersion() {
                return ((getIlinkServiceVersionResp) this.instance).hasVersion();
            }

            public Builder setVersion(String str) {
                copyOnWrite();
                ((getIlinkServiceVersionResp) this.instance).setVersion(str);
                return this;
            }

            public Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((getIlinkServiceVersionResp) this.instance).setVersionBytes(byteString);
                return this;
            }

            Builder() {
                super(getIlinkServiceVersionResp.DEFAULT_INSTANCE);
            }
        }

        static {
            getIlinkServiceVersionResp getilinkserviceversionresp = new getIlinkServiceVersionResp();
            DEFAULT_INSTANCE = getilinkserviceversionresp;
            GeneratedMessageLite.registerDefaultInstance(getIlinkServiceVersionResp.class, getilinkserviceversionresp);
        }

        getIlinkServiceVersionResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.bitField0_ &= -2;
            this.version_ = getDefaultInstance().getVersion();
        }

        public static getIlinkServiceVersionResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static getIlinkServiceVersionResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static getIlinkServiceVersionResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<getIlinkServiceVersionResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.version_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new getIlinkServiceVersionResp();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "version_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<getIlinkServiceVersionResp> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (getIlinkServiceVersionResp.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.getIlinkServiceVersionRespOrBuilder
        public String getVersion() {
            return this.version_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.getIlinkServiceVersionRespOrBuilder
        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.getIlinkServiceVersionRespOrBuilder
        public boolean hasVersion() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(getIlinkServiceVersionResp getilinkserviceversionresp) {
            return DEFAULT_INSTANCE.createBuilder(getilinkserviceversionresp);
        }

        public static getIlinkServiceVersionResp parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static getIlinkServiceVersionResp parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static getIlinkServiceVersionResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static getIlinkServiceVersionResp parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static getIlinkServiceVersionResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static getIlinkServiceVersionResp parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static getIlinkServiceVersionResp parseFrom(InputStream inputStream) throws IOException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static getIlinkServiceVersionResp parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static getIlinkServiceVersionResp parseFrom(k kVar) throws IOException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static getIlinkServiceVersionResp parseFrom(k kVar, t tVar) throws IOException {
            return (getIlinkServiceVersionResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface getIlinkServiceVersionRespOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getVersion();

        ByteString getVersionBytes();

        boolean hasVersion();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class ilinkliveCanAutoLoginResp extends GeneratedMessageLite<ilinkliveCanAutoLoginResp, Builder> implements ilinkliveCanAutoLoginRespOrBuilder {
        private static final ilinkliveCanAutoLoginResp DEFAULT_INSTANCE;
        private static volatile bg<ilinkliveCanAutoLoginResp> PARSER = null;
        public static final int STATE_FIELD_NUMBER = 1;
        private int bitField0_;
        private boolean state_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<ilinkliveCanAutoLoginResp, Builder> implements ilinkliveCanAutoLoginRespOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearState() {
                copyOnWrite();
                ((ilinkliveCanAutoLoginResp) this.instance).clearState();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCanAutoLoginRespOrBuilder
            public boolean getState() {
                return ((ilinkliveCanAutoLoginResp) this.instance).getState();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCanAutoLoginRespOrBuilder
            public boolean hasState() {
                return ((ilinkliveCanAutoLoginResp) this.instance).hasState();
            }

            public Builder setState(boolean z16) {
                copyOnWrite();
                ((ilinkliveCanAutoLoginResp) this.instance).setState(z16);
                return this;
            }

            Builder() {
                super(ilinkliveCanAutoLoginResp.DEFAULT_INSTANCE);
            }
        }

        static {
            ilinkliveCanAutoLoginResp ilinklivecanautologinresp = new ilinkliveCanAutoLoginResp();
            DEFAULT_INSTANCE = ilinklivecanautologinresp;
            GeneratedMessageLite.registerDefaultInstance(ilinkliveCanAutoLoginResp.class, ilinklivecanautologinresp);
        }

        ilinkliveCanAutoLoginResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearState() {
            this.bitField0_ &= -2;
            this.state_ = false;
        }

        public static ilinkliveCanAutoLoginResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ilinkliveCanAutoLoginResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<ilinkliveCanAutoLoginResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setState(boolean z16) {
            this.bitField0_ |= 1;
            this.state_ = z16;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ilinkliveCanAutoLoginResp();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0007\u0000", new Object[]{"bitField0_", "state_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<ilinkliveCanAutoLoginResp> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (ilinkliveCanAutoLoginResp.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCanAutoLoginRespOrBuilder
        public boolean getState() {
            return this.state_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCanAutoLoginRespOrBuilder
        public boolean hasState() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(ilinkliveCanAutoLoginResp ilinklivecanautologinresp) {
            return DEFAULT_INSTANCE.createBuilder(ilinklivecanautologinresp);
        }

        public static ilinkliveCanAutoLoginResp parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(InputStream inputStream) throws IOException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(k kVar) throws IOException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static ilinkliveCanAutoLoginResp parseFrom(k kVar, t tVar) throws IOException {
            return (ilinkliveCanAutoLoginResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface ilinkliveCanAutoLoginRespOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean getState();

        boolean hasState();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class ilinkliveCommRequest extends GeneratedMessageLite<ilinkliveCommRequest, Builder> implements ilinkliveCommRequestOrBuilder {
        private static final ilinkliveCommRequest DEFAULT_INSTANCE;
        public static final int FUNCARGS_FIELD_NUMBER = 2;
        public static final int FUNCNAME_FIELD_NUMBER = 1;
        private static volatile bg<ilinkliveCommRequest> PARSER;
        private int bitField0_;
        private String funcname_ = "";
        private ByteString funcargs_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<ilinkliveCommRequest, Builder> implements ilinkliveCommRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearFuncargs() {
                copyOnWrite();
                ((ilinkliveCommRequest) this.instance).clearFuncargs();
                return this;
            }

            public Builder clearFuncname() {
                copyOnWrite();
                ((ilinkliveCommRequest) this.instance).clearFuncname();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
            public ByteString getFuncargs() {
                return ((ilinkliveCommRequest) this.instance).getFuncargs();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
            public String getFuncname() {
                return ((ilinkliveCommRequest) this.instance).getFuncname();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
            public ByteString getFuncnameBytes() {
                return ((ilinkliveCommRequest) this.instance).getFuncnameBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
            public boolean hasFuncargs() {
                return ((ilinkliveCommRequest) this.instance).hasFuncargs();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
            public boolean hasFuncname() {
                return ((ilinkliveCommRequest) this.instance).hasFuncname();
            }

            public Builder setFuncargs(ByteString byteString) {
                copyOnWrite();
                ((ilinkliveCommRequest) this.instance).setFuncargs(byteString);
                return this;
            }

            public Builder setFuncname(String str) {
                copyOnWrite();
                ((ilinkliveCommRequest) this.instance).setFuncname(str);
                return this;
            }

            public Builder setFuncnameBytes(ByteString byteString) {
                copyOnWrite();
                ((ilinkliveCommRequest) this.instance).setFuncnameBytes(byteString);
                return this;
            }

            Builder() {
                super(ilinkliveCommRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            ilinkliveCommRequest ilinklivecommrequest = new ilinkliveCommRequest();
            DEFAULT_INSTANCE = ilinklivecommrequest;
            GeneratedMessageLite.registerDefaultInstance(ilinkliveCommRequest.class, ilinklivecommrequest);
        }

        ilinkliveCommRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFuncargs() {
            this.bitField0_ &= -3;
            this.funcargs_ = getDefaultInstance().getFuncargs();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFuncname() {
            this.bitField0_ &= -2;
            this.funcname_ = getDefaultInstance().getFuncname();
        }

        public static ilinkliveCommRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ilinkliveCommRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveCommRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<ilinkliveCommRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFuncargs(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.funcargs_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFuncname(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.funcname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFuncnameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.funcname_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ilinkliveCommRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "funcname_", "funcargs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<ilinkliveCommRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (ilinkliveCommRequest.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
        public ByteString getFuncargs() {
            return this.funcargs_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
        public String getFuncname() {
            return this.funcname_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
        public ByteString getFuncnameBytes() {
            return ByteString.copyFromUtf8(this.funcname_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
        public boolean hasFuncargs() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveCommRequestOrBuilder
        public boolean hasFuncname() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(ilinkliveCommRequest ilinklivecommrequest) {
            return DEFAULT_INSTANCE.createBuilder(ilinklivecommrequest);
        }

        public static ilinkliveCommRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveCommRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static ilinkliveCommRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ilinkliveCommRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static ilinkliveCommRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ilinkliveCommRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static ilinkliveCommRequest parseFrom(InputStream inputStream) throws IOException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveCommRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveCommRequest parseFrom(k kVar) throws IOException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static ilinkliveCommRequest parseFrom(k kVar, t tVar) throws IOException {
            return (ilinkliveCommRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface ilinkliveCommRequestOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getFuncargs();

        String getFuncname();

        ByteString getFuncnameBytes();

        boolean hasFuncargs();

        boolean hasFuncname();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class ilinkliveFinderJsApis extends GeneratedMessageLite<ilinkliveFinderJsApis, Builder> implements ilinkliveFinderJsApisOrBuilder {
        public static final int BODY_FIELD_NUMBER = 2;
        private static final ilinkliveFinderJsApis DEFAULT_INSTANCE;
        private static volatile bg<ilinkliveFinderJsApis> PARSER = null;
        public static final int TASKID_FIELD_NUMBER = 1;
        private int bitField0_;
        private ByteString body_ = ByteString.EMPTY;
        private long taskid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<ilinkliveFinderJsApis, Builder> implements ilinkliveFinderJsApisOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((ilinkliveFinderJsApis) this.instance).clearBody();
                return this;
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((ilinkliveFinderJsApis) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveFinderJsApisOrBuilder
            public ByteString getBody() {
                return ((ilinkliveFinderJsApis) this.instance).getBody();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveFinderJsApisOrBuilder
            public long getTaskid() {
                return ((ilinkliveFinderJsApis) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveFinderJsApisOrBuilder
            public boolean hasBody() {
                return ((ilinkliveFinderJsApis) this.instance).hasBody();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveFinderJsApisOrBuilder
            public boolean hasTaskid() {
                return ((ilinkliveFinderJsApis) this.instance).hasTaskid();
            }

            public Builder setBody(ByteString byteString) {
                copyOnWrite();
                ((ilinkliveFinderJsApis) this.instance).setBody(byteString);
                return this;
            }

            public Builder setTaskid(long j3) {
                copyOnWrite();
                ((ilinkliveFinderJsApis) this.instance).setTaskid(j3);
                return this;
            }

            Builder() {
                super(ilinkliveFinderJsApis.DEFAULT_INSTANCE);
            }
        }

        static {
            ilinkliveFinderJsApis ilinklivefinderjsapis = new ilinkliveFinderJsApis();
            DEFAULT_INSTANCE = ilinklivefinderjsapis;
            GeneratedMessageLite.registerDefaultInstance(ilinkliveFinderJsApis.class, ilinklivefinderjsapis);
        }

        ilinkliveFinderJsApis() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -3;
            this.body_ = getDefaultInstance().getBody();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -2;
            this.taskid_ = 0L;
        }

        public static ilinkliveFinderJsApis getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ilinkliveFinderJsApis parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveFinderJsApis parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<ilinkliveFinderJsApis> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.body_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(long j3) {
            this.bitField0_ |= 1;
            this.taskid_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ilinkliveFinderJsApis();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0000\u0002\n\u0001", new Object[]{"bitField0_", "taskid_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<ilinkliveFinderJsApis> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (ilinkliveFinderJsApis.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveFinderJsApisOrBuilder
        public ByteString getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveFinderJsApisOrBuilder
        public long getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveFinderJsApisOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveFinderJsApisOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(ilinkliveFinderJsApis ilinklivefinderjsapis) {
            return DEFAULT_INSTANCE.createBuilder(ilinklivefinderjsapis);
        }

        public static ilinkliveFinderJsApis parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveFinderJsApis parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static ilinkliveFinderJsApis parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ilinkliveFinderJsApis parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static ilinkliveFinderJsApis parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ilinkliveFinderJsApis parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static ilinkliveFinderJsApis parseFrom(InputStream inputStream) throws IOException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveFinderJsApis parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveFinderJsApis parseFrom(k kVar) throws IOException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static ilinkliveFinderJsApis parseFrom(k kVar, t tVar) throws IOException {
            return (ilinkliveFinderJsApis) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface ilinkliveFinderJsApisOrBuilder extends av {
        ByteString getBody();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        long getTaskid();

        boolean hasBody();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class ilinkliveGetJsBridgeDataResp extends GeneratedMessageLite<ilinkliveGetJsBridgeDataResp, Builder> implements ilinkliveGetJsBridgeDataRespOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final ilinkliveGetJsBridgeDataResp DEFAULT_INSTANCE;
        private static volatile bg<ilinkliveGetJsBridgeDataResp> PARSER;
        private int bitField0_;
        private ByteString data_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<ilinkliveGetJsBridgeDataResp, Builder> implements ilinkliveGetJsBridgeDataRespOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearData() {
                copyOnWrite();
                ((ilinkliveGetJsBridgeDataResp) this.instance).clearData();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveGetJsBridgeDataRespOrBuilder
            public ByteString getData() {
                return ((ilinkliveGetJsBridgeDataResp) this.instance).getData();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveGetJsBridgeDataRespOrBuilder
            public boolean hasData() {
                return ((ilinkliveGetJsBridgeDataResp) this.instance).hasData();
            }

            public Builder setData(ByteString byteString) {
                copyOnWrite();
                ((ilinkliveGetJsBridgeDataResp) this.instance).setData(byteString);
                return this;
            }

            Builder() {
                super(ilinkliveGetJsBridgeDataResp.DEFAULT_INSTANCE);
            }
        }

        static {
            ilinkliveGetJsBridgeDataResp ilinklivegetjsbridgedataresp = new ilinkliveGetJsBridgeDataResp();
            DEFAULT_INSTANCE = ilinklivegetjsbridgedataresp;
            GeneratedMessageLite.registerDefaultInstance(ilinkliveGetJsBridgeDataResp.class, ilinklivegetjsbridgedataresp);
        }

        ilinkliveGetJsBridgeDataResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.bitField0_ &= -2;
            this.data_ = getDefaultInstance().getData();
        }

        public static ilinkliveGetJsBridgeDataResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ilinkliveGetJsBridgeDataResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<ilinkliveGetJsBridgeDataResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.data_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ilinkliveGetJsBridgeDataResp();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "data_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<ilinkliveGetJsBridgeDataResp> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (ilinkliveGetJsBridgeDataResp.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveGetJsBridgeDataRespOrBuilder
        public ByteString getData() {
            return this.data_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveGetJsBridgeDataRespOrBuilder
        public boolean hasData() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(ilinkliveGetJsBridgeDataResp ilinklivegetjsbridgedataresp) {
            return DEFAULT_INSTANCE.createBuilder(ilinklivegetjsbridgedataresp);
        }

        public static ilinkliveGetJsBridgeDataResp parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(InputStream inputStream) throws IOException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(k kVar) throws IOException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static ilinkliveGetJsBridgeDataResp parseFrom(k kVar, t tVar) throws IOException {
            return (ilinkliveGetJsBridgeDataResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface ilinkliveGetJsBridgeDataRespOrBuilder extends av {
        ByteString getData();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasData();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class ilinkliveInit extends GeneratedMessageLite<ilinkliveInit, Builder> implements ilinkliveInitOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final ilinkliveInit DEFAULT_INSTANCE;
        private static volatile bg<ilinkliveInit> PARSER;
        private String appid_ = "";
        private int bitField0_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<ilinkliveInit, Builder> implements ilinkliveInitOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((ilinkliveInit) this.instance).clearAppid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveInitOrBuilder
            public String getAppid() {
                return ((ilinkliveInit) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveInitOrBuilder
            public ByteString getAppidBytes() {
                return ((ilinkliveInit) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveInitOrBuilder
            public boolean hasAppid() {
                return ((ilinkliveInit) this.instance).hasAppid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((ilinkliveInit) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((ilinkliveInit) this.instance).setAppidBytes(byteString);
                return this;
            }

            Builder() {
                super(ilinkliveInit.DEFAULT_INSTANCE);
            }
        }

        static {
            ilinkliveInit ilinkliveinit = new ilinkliveInit();
            DEFAULT_INSTANCE = ilinkliveinit;
            GeneratedMessageLite.registerDefaultInstance(ilinkliveInit.class, ilinkliveinit);
        }

        ilinkliveInit() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        public static ilinkliveInit getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ilinkliveInit parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ilinkliveInit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveInit parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<ilinkliveInit> parser() {
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
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ilinkliveInit();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "appid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<ilinkliveInit> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (ilinkliveInit.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveInitOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveInitOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveInitOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(ilinkliveInit ilinkliveinit) {
            return DEFAULT_INSTANCE.createBuilder(ilinkliveinit);
        }

        public static ilinkliveInit parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveInit) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveInit parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static ilinkliveInit parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ilinkliveInit parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static ilinkliveInit parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ilinkliveInit parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static ilinkliveInit parseFrom(InputStream inputStream) throws IOException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveInit parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveInit parseFrom(k kVar) throws IOException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static ilinkliveInit parseFrom(k kVar, t tVar) throws IOException {
            return (ilinkliveInit) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface ilinkliveInitOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasAppid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class ilinkliveThirdLogin extends GeneratedMessageLite<ilinkliveThirdLogin, Builder> implements ilinkliveThirdLoginOrBuilder {
        public static final int AUTHBUFFER_FIELD_NUMBER = 1;
        private static final ilinkliveThirdLogin DEFAULT_INSTANCE;
        private static volatile bg<ilinkliveThirdLogin> PARSER;
        private ByteString authbuffer_ = ByteString.EMPTY;
        private int bitField0_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<ilinkliveThirdLogin, Builder> implements ilinkliveThirdLoginOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAuthbuffer() {
                copyOnWrite();
                ((ilinkliveThirdLogin) this.instance).clearAuthbuffer();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveThirdLoginOrBuilder
            public ByteString getAuthbuffer() {
                return ((ilinkliveThirdLogin) this.instance).getAuthbuffer();
            }

            @Override // com.tencent.ilinkservice.AidlProto.ilinkliveThirdLoginOrBuilder
            public boolean hasAuthbuffer() {
                return ((ilinkliveThirdLogin) this.instance).hasAuthbuffer();
            }

            public Builder setAuthbuffer(ByteString byteString) {
                copyOnWrite();
                ((ilinkliveThirdLogin) this.instance).setAuthbuffer(byteString);
                return this;
            }

            Builder() {
                super(ilinkliveThirdLogin.DEFAULT_INSTANCE);
            }
        }

        static {
            ilinkliveThirdLogin ilinklivethirdlogin = new ilinkliveThirdLogin();
            DEFAULT_INSTANCE = ilinklivethirdlogin;
            GeneratedMessageLite.registerDefaultInstance(ilinkliveThirdLogin.class, ilinklivethirdlogin);
        }

        ilinkliveThirdLogin() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAuthbuffer() {
            this.bitField0_ &= -2;
            this.authbuffer_ = getDefaultInstance().getAuthbuffer();
        }

        public static ilinkliveThirdLogin getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ilinkliveThirdLogin parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveThirdLogin parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<ilinkliveThirdLogin> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAuthbuffer(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.authbuffer_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ilinkliveThirdLogin();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "authbuffer_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<ilinkliveThirdLogin> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (ilinkliveThirdLogin.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveThirdLoginOrBuilder
        public ByteString getAuthbuffer() {
            return this.authbuffer_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.ilinkliveThirdLoginOrBuilder
        public boolean hasAuthbuffer() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(ilinkliveThirdLogin ilinklivethirdlogin) {
            return DEFAULT_INSTANCE.createBuilder(ilinklivethirdlogin);
        }

        public static ilinkliveThirdLogin parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveThirdLogin parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static ilinkliveThirdLogin parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ilinkliveThirdLogin parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static ilinkliveThirdLogin parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ilinkliveThirdLogin parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static ilinkliveThirdLogin parseFrom(InputStream inputStream) throws IOException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ilinkliveThirdLogin parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ilinkliveThirdLogin parseFrom(k kVar) throws IOException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static ilinkliveThirdLogin parseFrom(k kVar, t tVar) throws IOException {
            return (ilinkliveThirdLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface ilinkliveThirdLoginOrBuilder extends av {
        ByteString getAuthbuffer();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasAuthbuffer();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class loginImSession extends GeneratedMessageLite<loginImSession, Builder> implements loginImSessionOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final loginImSession DEFAULT_INSTANCE;
        private static volatile bg<loginImSession> PARSER;
        private String appid_ = "";
        private int bitField0_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<loginImSession, Builder> implements loginImSessionOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((loginImSession) this.instance).clearAppid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.loginImSessionOrBuilder
            public String getAppid() {
                return ((loginImSession) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.loginImSessionOrBuilder
            public ByteString getAppidBytes() {
                return ((loginImSession) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.loginImSessionOrBuilder
            public boolean hasAppid() {
                return ((loginImSession) this.instance).hasAppid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((loginImSession) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((loginImSession) this.instance).setAppidBytes(byteString);
                return this;
            }

            Builder() {
                super(loginImSession.DEFAULT_INSTANCE);
            }
        }

        static {
            loginImSession loginimsession = new loginImSession();
            DEFAULT_INSTANCE = loginimsession;
            GeneratedMessageLite.registerDefaultInstance(loginImSession.class, loginimsession);
        }

        loginImSession() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        public static loginImSession getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static loginImSession parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (loginImSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static loginImSession parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<loginImSession> parser() {
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
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new loginImSession();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "appid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<loginImSession> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (loginImSession.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.loginImSessionOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.loginImSessionOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.loginImSessionOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(loginImSession loginimsession) {
            return DEFAULT_INSTANCE.createBuilder(loginimsession);
        }

        public static loginImSession parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (loginImSession) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static loginImSession parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static loginImSession parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static loginImSession parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static loginImSession parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static loginImSession parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static loginImSession parseFrom(InputStream inputStream) throws IOException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static loginImSession parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static loginImSession parseFrom(k kVar) throws IOException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static loginImSession parseFrom(k kVar, t tVar) throws IOException {
            return (loginImSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface loginImSessionOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasAppid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onCommFunctionCallback extends GeneratedMessageLite<onCommFunctionCallback, Builder> implements onCommFunctionCallbackOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final onCommFunctionCallback DEFAULT_INSTANCE;
        private static volatile bg<onCommFunctionCallback> PARSER = null;
        public static final int RESPDATA_FIELD_NUMBER = 3;
        public static final int TASKID_FIELD_NUMBER = 2;
        private int bitField0_;
        private int taskid_;
        private String appid_ = "";
        private ByteString respdata_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onCommFunctionCallback, Builder> implements onCommFunctionCallbackOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((onCommFunctionCallback) this.instance).clearAppid();
                return this;
            }

            public Builder clearRespdata() {
                copyOnWrite();
                ((onCommFunctionCallback) this.instance).clearRespdata();
                return this;
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((onCommFunctionCallback) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
            public String getAppid() {
                return ((onCommFunctionCallback) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
            public ByteString getAppidBytes() {
                return ((onCommFunctionCallback) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
            public ByteString getRespdata() {
                return ((onCommFunctionCallback) this.instance).getRespdata();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
            public int getTaskid() {
                return ((onCommFunctionCallback) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
            public boolean hasAppid() {
                return ((onCommFunctionCallback) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
            public boolean hasRespdata() {
                return ((onCommFunctionCallback) this.instance).hasRespdata();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
            public boolean hasTaskid() {
                return ((onCommFunctionCallback) this.instance).hasTaskid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((onCommFunctionCallback) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((onCommFunctionCallback) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setRespdata(ByteString byteString) {
                copyOnWrite();
                ((onCommFunctionCallback) this.instance).setRespdata(byteString);
                return this;
            }

            public Builder setTaskid(int i3) {
                copyOnWrite();
                ((onCommFunctionCallback) this.instance).setTaskid(i3);
                return this;
            }

            Builder() {
                super(onCommFunctionCallback.DEFAULT_INSTANCE);
            }
        }

        static {
            onCommFunctionCallback oncommfunctioncallback = new onCommFunctionCallback();
            DEFAULT_INSTANCE = oncommfunctioncallback;
            GeneratedMessageLite.registerDefaultInstance(onCommFunctionCallback.class, oncommfunctioncallback);
        }

        onCommFunctionCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRespdata() {
            this.bitField0_ &= -5;
            this.respdata_ = getDefaultInstance().getRespdata();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -3;
            this.taskid_ = 0;
        }

        public static onCommFunctionCallback getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onCommFunctionCallback parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onCommFunctionCallback parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onCommFunctionCallback> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setRespdata(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.respdata_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(int i3) {
            this.bitField0_ |= 2;
            this.taskid_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onCommFunctionCallback();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\n\u0002", new Object[]{"bitField0_", "appid_", "taskid_", "respdata_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onCommFunctionCallback> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onCommFunctionCallback.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
        public ByteString getRespdata() {
            return this.respdata_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
        public int getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
        public boolean hasRespdata() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onCommFunctionCallbackOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onCommFunctionCallback oncommfunctioncallback) {
            return DEFAULT_INSTANCE.createBuilder(oncommfunctioncallback);
        }

        public static onCommFunctionCallback parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onCommFunctionCallback parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onCommFunctionCallback parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onCommFunctionCallback parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onCommFunctionCallback parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onCommFunctionCallback parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onCommFunctionCallback parseFrom(InputStream inputStream) throws IOException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onCommFunctionCallback parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onCommFunctionCallback parseFrom(k kVar) throws IOException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onCommFunctionCallback parseFrom(k kVar, t tVar) throws IOException {
            return (onCommFunctionCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onCommFunctionCallbackOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getRespdata();

        int getTaskid();

        boolean hasAppid();

        boolean hasRespdata();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onDeviceShadowUpdate extends GeneratedMessageLite<onDeviceShadowUpdate, Builder> implements onDeviceShadowUpdateOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final onDeviceShadowUpdate DEFAULT_INSTANCE;
        private static volatile bg<onDeviceShadowUpdate> PARSER = null;
        public static final int SHADOWDATA_FIELD_NUMBER = 2;
        private int bitField0_;
        private String appid_ = "";
        private ByteString shadowdata_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onDeviceShadowUpdate, Builder> implements onDeviceShadowUpdateOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((onDeviceShadowUpdate) this.instance).clearAppid();
                return this;
            }

            public Builder clearShadowdata() {
                copyOnWrite();
                ((onDeviceShadowUpdate) this.instance).clearShadowdata();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
            public String getAppid() {
                return ((onDeviceShadowUpdate) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
            public ByteString getAppidBytes() {
                return ((onDeviceShadowUpdate) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
            public ByteString getShadowdata() {
                return ((onDeviceShadowUpdate) this.instance).getShadowdata();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
            public boolean hasAppid() {
                return ((onDeviceShadowUpdate) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
            public boolean hasShadowdata() {
                return ((onDeviceShadowUpdate) this.instance).hasShadowdata();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((onDeviceShadowUpdate) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((onDeviceShadowUpdate) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setShadowdata(ByteString byteString) {
                copyOnWrite();
                ((onDeviceShadowUpdate) this.instance).setShadowdata(byteString);
                return this;
            }

            Builder() {
                super(onDeviceShadowUpdate.DEFAULT_INSTANCE);
            }
        }

        static {
            onDeviceShadowUpdate ondeviceshadowupdate = new onDeviceShadowUpdate();
            DEFAULT_INSTANCE = ondeviceshadowupdate;
            GeneratedMessageLite.registerDefaultInstance(onDeviceShadowUpdate.class, ondeviceshadowupdate);
        }

        onDeviceShadowUpdate() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShadowdata() {
            this.bitField0_ &= -3;
            this.shadowdata_ = getDefaultInstance().getShadowdata();
        }

        public static onDeviceShadowUpdate getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onDeviceShadowUpdate parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onDeviceShadowUpdate parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onDeviceShadowUpdate> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setShadowdata(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.shadowdata_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onDeviceShadowUpdate();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "appid_", "shadowdata_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onDeviceShadowUpdate> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onDeviceShadowUpdate.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
        public ByteString getShadowdata() {
            return this.shadowdata_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onDeviceShadowUpdateOrBuilder
        public boolean hasShadowdata() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onDeviceShadowUpdate ondeviceshadowupdate) {
            return DEFAULT_INSTANCE.createBuilder(ondeviceshadowupdate);
        }

        public static onDeviceShadowUpdate parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onDeviceShadowUpdate parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onDeviceShadowUpdate parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onDeviceShadowUpdate parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onDeviceShadowUpdate parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onDeviceShadowUpdate parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onDeviceShadowUpdate parseFrom(InputStream inputStream) throws IOException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onDeviceShadowUpdate parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onDeviceShadowUpdate parseFrom(k kVar) throws IOException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onDeviceShadowUpdate parseFrom(k kVar, t tVar) throws IOException {
            return (onDeviceShadowUpdate) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onDeviceShadowUpdateOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getShadowdata();

        boolean hasAppid();

        boolean hasShadowdata();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onGetDeviceShadow extends GeneratedMessageLite<onGetDeviceShadow, Builder> implements onGetDeviceShadowOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final onGetDeviceShadow DEFAULT_INSTANCE;
        private static volatile bg<onGetDeviceShadow> PARSER = null;
        public static final int RESULT_FIELD_NUMBER = 3;
        public static final int SHADOWDATA_FIELD_NUMBER = 4;
        public static final int TASKID_FIELD_NUMBER = 2;
        private int bitField0_;
        private int result_;
        private int taskid_;
        private String appid_ = "";
        private ByteString shadowdata_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onGetDeviceShadow, Builder> implements onGetDeviceShadowOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((onGetDeviceShadow) this.instance).clearAppid();
                return this;
            }

            public Builder clearResult() {
                copyOnWrite();
                ((onGetDeviceShadow) this.instance).clearResult();
                return this;
            }

            public Builder clearShadowdata() {
                copyOnWrite();
                ((onGetDeviceShadow) this.instance).clearShadowdata();
                return this;
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((onGetDeviceShadow) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
            public String getAppid() {
                return ((onGetDeviceShadow) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
            public ByteString getAppidBytes() {
                return ((onGetDeviceShadow) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
            public int getResult() {
                return ((onGetDeviceShadow) this.instance).getResult();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
            public ByteString getShadowdata() {
                return ((onGetDeviceShadow) this.instance).getShadowdata();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
            public int getTaskid() {
                return ((onGetDeviceShadow) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
            public boolean hasAppid() {
                return ((onGetDeviceShadow) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
            public boolean hasResult() {
                return ((onGetDeviceShadow) this.instance).hasResult();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
            public boolean hasShadowdata() {
                return ((onGetDeviceShadow) this.instance).hasShadowdata();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
            public boolean hasTaskid() {
                return ((onGetDeviceShadow) this.instance).hasTaskid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((onGetDeviceShadow) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((onGetDeviceShadow) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setResult(int i3) {
                copyOnWrite();
                ((onGetDeviceShadow) this.instance).setResult(i3);
                return this;
            }

            public Builder setShadowdata(ByteString byteString) {
                copyOnWrite();
                ((onGetDeviceShadow) this.instance).setShadowdata(byteString);
                return this;
            }

            public Builder setTaskid(int i3) {
                copyOnWrite();
                ((onGetDeviceShadow) this.instance).setTaskid(i3);
                return this;
            }

            Builder() {
                super(onGetDeviceShadow.DEFAULT_INSTANCE);
            }
        }

        static {
            onGetDeviceShadow ongetdeviceshadow = new onGetDeviceShadow();
            DEFAULT_INSTANCE = ongetdeviceshadow;
            GeneratedMessageLite.registerDefaultInstance(onGetDeviceShadow.class, ongetdeviceshadow);
        }

        onGetDeviceShadow() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResult() {
            this.bitField0_ &= -5;
            this.result_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShadowdata() {
            this.bitField0_ &= -9;
            this.shadowdata_ = getDefaultInstance().getShadowdata();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -3;
            this.taskid_ = 0;
        }

        public static onGetDeviceShadow getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onGetDeviceShadow parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onGetDeviceShadow parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onGetDeviceShadow> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setResult(int i3) {
            this.bitField0_ |= 4;
            this.result_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShadowdata(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.shadowdata_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(int i3) {
            this.bitField0_ |= 2;
            this.taskid_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onGetDeviceShadow();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\u000b\u0002\u0004\n\u0003", new Object[]{"bitField0_", "appid_", "taskid_", "result_", "shadowdata_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onGetDeviceShadow> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onGetDeviceShadow.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
        public int getResult() {
            return this.result_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
        public ByteString getShadowdata() {
            return this.shadowdata_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
        public int getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
        public boolean hasResult() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
        public boolean hasShadowdata() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onGetDeviceShadowOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onGetDeviceShadow ongetdeviceshadow) {
            return DEFAULT_INSTANCE.createBuilder(ongetdeviceshadow);
        }

        public static onGetDeviceShadow parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onGetDeviceShadow parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onGetDeviceShadow parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onGetDeviceShadow parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onGetDeviceShadow parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onGetDeviceShadow parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onGetDeviceShadow parseFrom(InputStream inputStream) throws IOException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onGetDeviceShadow parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onGetDeviceShadow parseFrom(k kVar) throws IOException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onGetDeviceShadow parseFrom(k kVar, t tVar) throws IOException {
            return (onGetDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onGetDeviceShadowOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getResult();

        ByteString getShadowdata();

        int getTaskid();

        boolean hasAppid();

        boolean hasResult();

        boolean hasShadowdata();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onImLoginComplete extends GeneratedMessageLite<onImLoginComplete, Builder> implements onImLoginCompleteOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final onImLoginComplete DEFAULT_INSTANCE;
        private static volatile bg<onImLoginComplete> PARSER = null;
        public static final int RESULT_FIELD_NUMBER = 2;
        private String appid_ = "";
        private int bitField0_;
        private int result_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onImLoginComplete, Builder> implements onImLoginCompleteOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((onImLoginComplete) this.instance).clearAppid();
                return this;
            }

            public Builder clearResult() {
                copyOnWrite();
                ((onImLoginComplete) this.instance).clearResult();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
            public String getAppid() {
                return ((onImLoginComplete) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
            public ByteString getAppidBytes() {
                return ((onImLoginComplete) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
            public int getResult() {
                return ((onImLoginComplete) this.instance).getResult();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
            public boolean hasAppid() {
                return ((onImLoginComplete) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
            public boolean hasResult() {
                return ((onImLoginComplete) this.instance).hasResult();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((onImLoginComplete) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((onImLoginComplete) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setResult(int i3) {
                copyOnWrite();
                ((onImLoginComplete) this.instance).setResult(i3);
                return this;
            }

            Builder() {
                super(onImLoginComplete.DEFAULT_INSTANCE);
            }
        }

        static {
            onImLoginComplete onimlogincomplete = new onImLoginComplete();
            DEFAULT_INSTANCE = onimlogincomplete;
            GeneratedMessageLite.registerDefaultInstance(onImLoginComplete.class, onimlogincomplete);
        }

        onImLoginComplete() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResult() {
            this.bitField0_ &= -3;
            this.result_ = 0;
        }

        public static onImLoginComplete getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onImLoginComplete parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onImLoginComplete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onImLoginComplete parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onImLoginComplete> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setResult(int i3) {
            this.bitField0_ |= 2;
            this.result_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onImLoginComplete();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0004\u0001", new Object[]{"bitField0_", "appid_", "result_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onImLoginComplete> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onImLoginComplete.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
        public int getResult() {
            return this.result_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onImLoginCompleteOrBuilder
        public boolean hasResult() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onImLoginComplete onimlogincomplete) {
            return DEFAULT_INSTANCE.createBuilder(onimlogincomplete);
        }

        public static onImLoginComplete parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onImLoginComplete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onImLoginComplete parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onImLoginComplete parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onImLoginComplete parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onImLoginComplete parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onImLoginComplete parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onImLoginComplete parseFrom(InputStream inputStream) throws IOException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onImLoginComplete parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onImLoginComplete parseFrom(k kVar) throws IOException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onImLoginComplete parseFrom(k kVar, t tVar) throws IOException {
            return (onImLoginComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onImLoginCompleteOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getResult();

        boolean hasAppid();

        boolean hasResult();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onUpdateDeviceShadow extends GeneratedMessageLite<onUpdateDeviceShadow, Builder> implements onUpdateDeviceShadowOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final onUpdateDeviceShadow DEFAULT_INSTANCE;
        private static volatile bg<onUpdateDeviceShadow> PARSER = null;
        public static final int RESULT_FIELD_NUMBER = 3;
        public static final int SHADOWDATA_FIELD_NUMBER = 4;
        public static final int TASKID_FIELD_NUMBER = 2;
        private int bitField0_;
        private int result_;
        private int taskid_;
        private String appid_ = "";
        private ByteString shadowdata_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onUpdateDeviceShadow, Builder> implements onUpdateDeviceShadowOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((onUpdateDeviceShadow) this.instance).clearAppid();
                return this;
            }

            public Builder clearResult() {
                copyOnWrite();
                ((onUpdateDeviceShadow) this.instance).clearResult();
                return this;
            }

            public Builder clearShadowdata() {
                copyOnWrite();
                ((onUpdateDeviceShadow) this.instance).clearShadowdata();
                return this;
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((onUpdateDeviceShadow) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
            public String getAppid() {
                return ((onUpdateDeviceShadow) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
            public ByteString getAppidBytes() {
                return ((onUpdateDeviceShadow) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
            public int getResult() {
                return ((onUpdateDeviceShadow) this.instance).getResult();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
            public ByteString getShadowdata() {
                return ((onUpdateDeviceShadow) this.instance).getShadowdata();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
            public int getTaskid() {
                return ((onUpdateDeviceShadow) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
            public boolean hasAppid() {
                return ((onUpdateDeviceShadow) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
            public boolean hasResult() {
                return ((onUpdateDeviceShadow) this.instance).hasResult();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
            public boolean hasShadowdata() {
                return ((onUpdateDeviceShadow) this.instance).hasShadowdata();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
            public boolean hasTaskid() {
                return ((onUpdateDeviceShadow) this.instance).hasTaskid();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((onUpdateDeviceShadow) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((onUpdateDeviceShadow) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setResult(int i3) {
                copyOnWrite();
                ((onUpdateDeviceShadow) this.instance).setResult(i3);
                return this;
            }

            public Builder setShadowdata(ByteString byteString) {
                copyOnWrite();
                ((onUpdateDeviceShadow) this.instance).setShadowdata(byteString);
                return this;
            }

            public Builder setTaskid(int i3) {
                copyOnWrite();
                ((onUpdateDeviceShadow) this.instance).setTaskid(i3);
                return this;
            }

            Builder() {
                super(onUpdateDeviceShadow.DEFAULT_INSTANCE);
            }
        }

        static {
            onUpdateDeviceShadow onupdatedeviceshadow = new onUpdateDeviceShadow();
            DEFAULT_INSTANCE = onupdatedeviceshadow;
            GeneratedMessageLite.registerDefaultInstance(onUpdateDeviceShadow.class, onupdatedeviceshadow);
        }

        onUpdateDeviceShadow() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearResult() {
            this.bitField0_ &= -5;
            this.result_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShadowdata() {
            this.bitField0_ &= -9;
            this.shadowdata_ = getDefaultInstance().getShadowdata();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -3;
            this.taskid_ = 0;
        }

        public static onUpdateDeviceShadow getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onUpdateDeviceShadow parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onUpdateDeviceShadow parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onUpdateDeviceShadow> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setResult(int i3) {
            this.bitField0_ |= 4;
            this.result_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setShadowdata(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.shadowdata_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(int i3) {
            this.bitField0_ |= 2;
            this.taskid_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onUpdateDeviceShadow();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\u000b\u0002\u0004\n\u0003", new Object[]{"bitField0_", "appid_", "taskid_", "result_", "shadowdata_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onUpdateDeviceShadow> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onUpdateDeviceShadow.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
        public int getResult() {
            return this.result_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
        public ByteString getShadowdata() {
            return this.shadowdata_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
        public int getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
        public boolean hasResult() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
        public boolean hasShadowdata() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onUpdateDeviceShadowOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onUpdateDeviceShadow onupdatedeviceshadow) {
            return DEFAULT_INSTANCE.createBuilder(onupdatedeviceshadow);
        }

        public static onUpdateDeviceShadow parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onUpdateDeviceShadow parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onUpdateDeviceShadow parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onUpdateDeviceShadow parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onUpdateDeviceShadow parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onUpdateDeviceShadow parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onUpdateDeviceShadow parseFrom(InputStream inputStream) throws IOException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onUpdateDeviceShadow parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onUpdateDeviceShadow parseFrom(k kVar) throws IOException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onUpdateDeviceShadow parseFrom(k kVar, t tVar) throws IOException {
            return (onUpdateDeviceShadow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onUpdateDeviceShadowOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getResult();

        ByteString getShadowdata();

        int getTaskid();

        boolean hasAppid();

        boolean hasResult();

        boolean hasShadowdata();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onUploadLogComplete extends GeneratedMessageLite<onUploadLogComplete, Builder> implements onUploadLogCompleteOrBuilder {
        private static final onUploadLogComplete DEFAULT_INSTANCE;
        public static final int ERRCODE_FIELD_NUMBER = 1;
        private static volatile bg<onUploadLogComplete> PARSER;
        private int bitField0_;
        private int errcode_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onUploadLogComplete, Builder> implements onUploadLogCompleteOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearErrcode() {
                copyOnWrite();
                ((onUploadLogComplete) this.instance).clearErrcode();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUploadLogCompleteOrBuilder
            public int getErrcode() {
                return ((onUploadLogComplete) this.instance).getErrcode();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onUploadLogCompleteOrBuilder
            public boolean hasErrcode() {
                return ((onUploadLogComplete) this.instance).hasErrcode();
            }

            public Builder setErrcode(int i3) {
                copyOnWrite();
                ((onUploadLogComplete) this.instance).setErrcode(i3);
                return this;
            }

            Builder() {
                super(onUploadLogComplete.DEFAULT_INSTANCE);
            }
        }

        static {
            onUploadLogComplete onuploadlogcomplete = new onUploadLogComplete();
            DEFAULT_INSTANCE = onuploadlogcomplete;
            GeneratedMessageLite.registerDefaultInstance(onUploadLogComplete.class, onuploadlogcomplete);
        }

        onUploadLogComplete() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrcode() {
            this.bitField0_ &= -2;
            this.errcode_ = 0;
        }

        public static onUploadLogComplete getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onUploadLogComplete parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onUploadLogComplete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onUploadLogComplete parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onUploadLogComplete> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrcode(int i3) {
            this.bitField0_ |= 1;
            this.errcode_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onUploadLogComplete();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004\u0000", new Object[]{"bitField0_", "errcode_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onUploadLogComplete> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onUploadLogComplete.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onUploadLogCompleteOrBuilder
        public int getErrcode() {
            return this.errcode_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onUploadLogCompleteOrBuilder
        public boolean hasErrcode() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onUploadLogComplete onuploadlogcomplete) {
            return DEFAULT_INSTANCE.createBuilder(onuploadlogcomplete);
        }

        public static onUploadLogComplete parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onUploadLogComplete) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onUploadLogComplete parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onUploadLogComplete parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onUploadLogComplete parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onUploadLogComplete parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onUploadLogComplete parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onUploadLogComplete parseFrom(InputStream inputStream) throws IOException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onUploadLogComplete parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onUploadLogComplete parseFrom(k kVar) throws IOException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onUploadLogComplete parseFrom(k kVar, t tVar) throws IOException {
            return (onUploadLogComplete) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onUploadLogCompleteOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getErrcode();

        boolean hasErrcode();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onilinkliveCommCallback extends GeneratedMessageLite<onilinkliveCommCallback, Builder> implements onilinkliveCommCallbackOrBuilder {
        private static final onilinkliveCommCallback DEFAULT_INSTANCE;
        public static final int FUNCARGS_FIELD_NUMBER = 2;
        public static final int FUNCNAME_FIELD_NUMBER = 1;
        private static volatile bg<onilinkliveCommCallback> PARSER;
        private int bitField0_;
        private String funcname_ = "";
        private ByteString funcargs_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onilinkliveCommCallback, Builder> implements onilinkliveCommCallbackOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearFuncargs() {
                copyOnWrite();
                ((onilinkliveCommCallback) this.instance).clearFuncargs();
                return this;
            }

            public Builder clearFuncname() {
                copyOnWrite();
                ((onilinkliveCommCallback) this.instance).clearFuncname();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
            public ByteString getFuncargs() {
                return ((onilinkliveCommCallback) this.instance).getFuncargs();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
            public String getFuncname() {
                return ((onilinkliveCommCallback) this.instance).getFuncname();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
            public ByteString getFuncnameBytes() {
                return ((onilinkliveCommCallback) this.instance).getFuncnameBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
            public boolean hasFuncargs() {
                return ((onilinkliveCommCallback) this.instance).hasFuncargs();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
            public boolean hasFuncname() {
                return ((onilinkliveCommCallback) this.instance).hasFuncname();
            }

            public Builder setFuncargs(ByteString byteString) {
                copyOnWrite();
                ((onilinkliveCommCallback) this.instance).setFuncargs(byteString);
                return this;
            }

            public Builder setFuncname(String str) {
                copyOnWrite();
                ((onilinkliveCommCallback) this.instance).setFuncname(str);
                return this;
            }

            public Builder setFuncnameBytes(ByteString byteString) {
                copyOnWrite();
                ((onilinkliveCommCallback) this.instance).setFuncnameBytes(byteString);
                return this;
            }

            Builder() {
                super(onilinkliveCommCallback.DEFAULT_INSTANCE);
            }
        }

        static {
            onilinkliveCommCallback onilinklivecommcallback = new onilinkliveCommCallback();
            DEFAULT_INSTANCE = onilinklivecommcallback;
            GeneratedMessageLite.registerDefaultInstance(onilinkliveCommCallback.class, onilinklivecommcallback);
        }

        onilinkliveCommCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFuncargs() {
            this.bitField0_ &= -3;
            this.funcargs_ = getDefaultInstance().getFuncargs();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFuncname() {
            this.bitField0_ &= -2;
            this.funcname_ = getDefaultInstance().getFuncname();
        }

        public static onilinkliveCommCallback getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onilinkliveCommCallback parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onilinkliveCommCallback parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onilinkliveCommCallback> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFuncargs(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.funcargs_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFuncname(String str) {
            str.getClass();
            this.bitField0_ |= 1;
            this.funcname_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFuncnameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.funcname_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onilinkliveCommCallback();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "funcname_", "funcargs_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onilinkliveCommCallback> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onilinkliveCommCallback.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
        public ByteString getFuncargs() {
            return this.funcargs_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
        public String getFuncname() {
            return this.funcname_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
        public ByteString getFuncnameBytes() {
            return ByteString.copyFromUtf8(this.funcname_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
        public boolean hasFuncargs() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveCommCallbackOrBuilder
        public boolean hasFuncname() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onilinkliveCommCallback onilinklivecommcallback) {
            return DEFAULT_INSTANCE.createBuilder(onilinklivecommcallback);
        }

        public static onilinkliveCommCallback parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onilinkliveCommCallback parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onilinkliveCommCallback parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onilinkliveCommCallback parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onilinkliveCommCallback parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onilinkliveCommCallback parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onilinkliveCommCallback parseFrom(InputStream inputStream) throws IOException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onilinkliveCommCallback parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onilinkliveCommCallback parseFrom(k kVar) throws IOException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onilinkliveCommCallback parseFrom(k kVar, t tVar) throws IOException {
            return (onilinkliveCommCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onilinkliveCommCallbackOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getFuncargs();

        String getFuncname();

        ByteString getFuncnameBytes();

        boolean hasFuncargs();

        boolean hasFuncname();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onilinkliveFinderJsapiCallback extends GeneratedMessageLite<onilinkliveFinderJsapiCallback, Builder> implements onilinkliveFinderJsapiCallbackOrBuilder {
        public static final int BODY_FIELD_NUMBER = 2;
        private static final onilinkliveFinderJsapiCallback DEFAULT_INSTANCE;
        private static volatile bg<onilinkliveFinderJsapiCallback> PARSER = null;
        public static final int TASKID_FIELD_NUMBER = 1;
        private int bitField0_;
        private ByteString body_ = ByteString.EMPTY;
        private long taskid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onilinkliveFinderJsapiCallback, Builder> implements onilinkliveFinderJsapiCallbackOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((onilinkliveFinderJsapiCallback) this.instance).clearBody();
                return this;
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((onilinkliveFinderJsapiCallback) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveFinderJsapiCallbackOrBuilder
            public ByteString getBody() {
                return ((onilinkliveFinderJsapiCallback) this.instance).getBody();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveFinderJsapiCallbackOrBuilder
            public long getTaskid() {
                return ((onilinkliveFinderJsapiCallback) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveFinderJsapiCallbackOrBuilder
            public boolean hasBody() {
                return ((onilinkliveFinderJsapiCallback) this.instance).hasBody();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveFinderJsapiCallbackOrBuilder
            public boolean hasTaskid() {
                return ((onilinkliveFinderJsapiCallback) this.instance).hasTaskid();
            }

            public Builder setBody(ByteString byteString) {
                copyOnWrite();
                ((onilinkliveFinderJsapiCallback) this.instance).setBody(byteString);
                return this;
            }

            public Builder setTaskid(long j3) {
                copyOnWrite();
                ((onilinkliveFinderJsapiCallback) this.instance).setTaskid(j3);
                return this;
            }

            Builder() {
                super(onilinkliveFinderJsapiCallback.DEFAULT_INSTANCE);
            }
        }

        static {
            onilinkliveFinderJsapiCallback onilinklivefinderjsapicallback = new onilinkliveFinderJsapiCallback();
            DEFAULT_INSTANCE = onilinklivefinderjsapicallback;
            GeneratedMessageLite.registerDefaultInstance(onilinkliveFinderJsapiCallback.class, onilinklivefinderjsapicallback);
        }

        onilinkliveFinderJsapiCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -3;
            this.body_ = getDefaultInstance().getBody();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -2;
            this.taskid_ = 0L;
        }

        public static onilinkliveFinderJsapiCallback getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onilinkliveFinderJsapiCallback parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onilinkliveFinderJsapiCallback> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBody(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.body_ = byteString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(long j3) {
            this.bitField0_ |= 1;
            this.taskid_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onilinkliveFinderJsapiCallback();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0000\u0002\n\u0001", new Object[]{"bitField0_", "taskid_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onilinkliveFinderJsapiCallback> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onilinkliveFinderJsapiCallback.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveFinderJsapiCallbackOrBuilder
        public ByteString getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveFinderJsapiCallbackOrBuilder
        public long getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveFinderJsapiCallbackOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveFinderJsapiCallbackOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onilinkliveFinderJsapiCallback onilinklivefinderjsapicallback) {
            return DEFAULT_INSTANCE.createBuilder(onilinklivefinderjsapicallback);
        }

        public static onilinkliveFinderJsapiCallback parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(InputStream inputStream) throws IOException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(k kVar) throws IOException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onilinkliveFinderJsapiCallback parseFrom(k kVar, t tVar) throws IOException {
            return (onilinkliveFinderJsapiCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onilinkliveFinderJsapiCallbackOrBuilder extends av {
        ByteString getBody();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        long getTaskid();

        boolean hasBody();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onilinkliveLoginCompleteCallback extends GeneratedMessageLite<onilinkliveLoginCompleteCallback, Builder> implements onilinkliveLoginCompleteCallbackOrBuilder {
        private static final onilinkliveLoginCompleteCallback DEFAULT_INSTANCE;
        public static final int ERRCODE_FIELD_NUMBER = 2;
        private static volatile bg<onilinkliveLoginCompleteCallback> PARSER = null;
        public static final int TASKID_FIELD_NUMBER = 1;
        private int bitField0_;
        private int errcode_;
        private long taskid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onilinkliveLoginCompleteCallback, Builder> implements onilinkliveLoginCompleteCallbackOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearErrcode() {
                copyOnWrite();
                ((onilinkliveLoginCompleteCallback) this.instance).clearErrcode();
                return this;
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((onilinkliveLoginCompleteCallback) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveLoginCompleteCallbackOrBuilder
            public int getErrcode() {
                return ((onilinkliveLoginCompleteCallback) this.instance).getErrcode();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveLoginCompleteCallbackOrBuilder
            public long getTaskid() {
                return ((onilinkliveLoginCompleteCallback) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveLoginCompleteCallbackOrBuilder
            public boolean hasErrcode() {
                return ((onilinkliveLoginCompleteCallback) this.instance).hasErrcode();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveLoginCompleteCallbackOrBuilder
            public boolean hasTaskid() {
                return ((onilinkliveLoginCompleteCallback) this.instance).hasTaskid();
            }

            public Builder setErrcode(int i3) {
                copyOnWrite();
                ((onilinkliveLoginCompleteCallback) this.instance).setErrcode(i3);
                return this;
            }

            public Builder setTaskid(long j3) {
                copyOnWrite();
                ((onilinkliveLoginCompleteCallback) this.instance).setTaskid(j3);
                return this;
            }

            Builder() {
                super(onilinkliveLoginCompleteCallback.DEFAULT_INSTANCE);
            }
        }

        static {
            onilinkliveLoginCompleteCallback onilinklivelogincompletecallback = new onilinkliveLoginCompleteCallback();
            DEFAULT_INSTANCE = onilinklivelogincompletecallback;
            GeneratedMessageLite.registerDefaultInstance(onilinkliveLoginCompleteCallback.class, onilinklivelogincompletecallback);
        }

        onilinkliveLoginCompleteCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearErrcode() {
            this.bitField0_ &= -3;
            this.errcode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -2;
            this.taskid_ = 0L;
        }

        public static onilinkliveLoginCompleteCallback getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onilinkliveLoginCompleteCallback parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onilinkliveLoginCompleteCallback> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setErrcode(int i3) {
            this.bitField0_ |= 2;
            this.errcode_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(long j3) {
            this.bitField0_ |= 1;
            this.taskid_ = j3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onilinkliveLoginCompleteCallback();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0003\u0000\u0002\u0004\u0001", new Object[]{"bitField0_", "taskid_", "errcode_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onilinkliveLoginCompleteCallback> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onilinkliveLoginCompleteCallback.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveLoginCompleteCallbackOrBuilder
        public int getErrcode() {
            return this.errcode_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveLoginCompleteCallbackOrBuilder
        public long getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveLoginCompleteCallbackOrBuilder
        public boolean hasErrcode() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveLoginCompleteCallbackOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onilinkliveLoginCompleteCallback onilinklivelogincompletecallback) {
            return DEFAULT_INSTANCE.createBuilder(onilinklivelogincompletecallback);
        }

        public static onilinkliveLoginCompleteCallback parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(InputStream inputStream) throws IOException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(k kVar) throws IOException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onilinkliveLoginCompleteCallback parseFrom(k kVar, t tVar) throws IOException {
            return (onilinkliveLoginCompleteCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onilinkliveLoginCompleteCallbackOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getErrcode();

        long getTaskid();

        boolean hasErrcode();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class onilinkliveRtmpUrlUpdateCallback extends GeneratedMessageLite<onilinkliveRtmpUrlUpdateCallback, Builder> implements onilinkliveRtmpUrlUpdateCallbackOrBuilder {
        private static final onilinkliveRtmpUrlUpdateCallback DEFAULT_INSTANCE;
        private static volatile bg<onilinkliveRtmpUrlUpdateCallback> PARSER = null;
        public static final int URL_FIELD_NUMBER = 1;
        private int bitField0_;
        private ByteString url_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<onilinkliveRtmpUrlUpdateCallback, Builder> implements onilinkliveRtmpUrlUpdateCallbackOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearUrl() {
                copyOnWrite();
                ((onilinkliveRtmpUrlUpdateCallback) this.instance).clearUrl();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveRtmpUrlUpdateCallbackOrBuilder
            public ByteString getUrl() {
                return ((onilinkliveRtmpUrlUpdateCallback) this.instance).getUrl();
            }

            @Override // com.tencent.ilinkservice.AidlProto.onilinkliveRtmpUrlUpdateCallbackOrBuilder
            public boolean hasUrl() {
                return ((onilinkliveRtmpUrlUpdateCallback) this.instance).hasUrl();
            }

            public Builder setUrl(ByteString byteString) {
                copyOnWrite();
                ((onilinkliveRtmpUrlUpdateCallback) this.instance).setUrl(byteString);
                return this;
            }

            Builder() {
                super(onilinkliveRtmpUrlUpdateCallback.DEFAULT_INSTANCE);
            }
        }

        static {
            onilinkliveRtmpUrlUpdateCallback onilinklivertmpurlupdatecallback = new onilinkliveRtmpUrlUpdateCallback();
            DEFAULT_INSTANCE = onilinklivertmpurlupdatecallback;
            GeneratedMessageLite.registerDefaultInstance(onilinkliveRtmpUrlUpdateCallback.class, onilinklivertmpurlupdatecallback);
        }

        onilinkliveRtmpUrlUpdateCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUrl() {
            this.bitField0_ &= -2;
            this.url_ = getDefaultInstance().getUrl();
        }

        public static onilinkliveRtmpUrlUpdateCallback getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static onilinkliveRtmpUrlUpdateCallback parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<onilinkliveRtmpUrlUpdateCallback> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUrl(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.url_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new onilinkliveRtmpUrlUpdateCallback();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "url_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<onilinkliveRtmpUrlUpdateCallback> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (onilinkliveRtmpUrlUpdateCallback.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveRtmpUrlUpdateCallbackOrBuilder
        public ByteString getUrl() {
            return this.url_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.onilinkliveRtmpUrlUpdateCallbackOrBuilder
        public boolean hasUrl() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(onilinkliveRtmpUrlUpdateCallback onilinklivertmpurlupdatecallback) {
            return DEFAULT_INSTANCE.createBuilder(onilinklivertmpurlupdatecallback);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(InputStream inputStream) throws IOException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(k kVar) throws IOException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static onilinkliveRtmpUrlUpdateCallback parseFrom(k kVar, t tVar) throws IOException {
            return (onilinkliveRtmpUrlUpdateCallback) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface onilinkliveRtmpUrlUpdateCallbackOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getUrl();

        boolean hasUrl();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class requestUploadLogfiles extends GeneratedMessageLite<requestUploadLogfiles, Builder> implements requestUploadLogfilesOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final requestUploadLogfiles DEFAULT_INSTANCE;
        public static final int END_TIME_FIELD_NUMBER = 3;
        private static volatile bg<requestUploadLogfiles> PARSER = null;
        public static final int START_TIME_FIELD_NUMBER = 2;
        private String appid_ = "";
        private int bitField0_;
        private int endTime_;
        private int startTime_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<requestUploadLogfiles, Builder> implements requestUploadLogfilesOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((requestUploadLogfiles) this.instance).clearAppid();
                return this;
            }

            public Builder clearEndTime() {
                copyOnWrite();
                ((requestUploadLogfiles) this.instance).clearEndTime();
                return this;
            }

            public Builder clearStartTime() {
                copyOnWrite();
                ((requestUploadLogfiles) this.instance).clearStartTime();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
            public String getAppid() {
                return ((requestUploadLogfiles) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
            public ByteString getAppidBytes() {
                return ((requestUploadLogfiles) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
            public int getEndTime() {
                return ((requestUploadLogfiles) this.instance).getEndTime();
            }

            @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
            public int getStartTime() {
                return ((requestUploadLogfiles) this.instance).getStartTime();
            }

            @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
            public boolean hasAppid() {
                return ((requestUploadLogfiles) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
            public boolean hasEndTime() {
                return ((requestUploadLogfiles) this.instance).hasEndTime();
            }

            @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
            public boolean hasStartTime() {
                return ((requestUploadLogfiles) this.instance).hasStartTime();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((requestUploadLogfiles) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((requestUploadLogfiles) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setEndTime(int i3) {
                copyOnWrite();
                ((requestUploadLogfiles) this.instance).setEndTime(i3);
                return this;
            }

            public Builder setStartTime(int i3) {
                copyOnWrite();
                ((requestUploadLogfiles) this.instance).setStartTime(i3);
                return this;
            }

            Builder() {
                super(requestUploadLogfiles.DEFAULT_INSTANCE);
            }
        }

        static {
            requestUploadLogfiles requestuploadlogfiles = new requestUploadLogfiles();
            DEFAULT_INSTANCE = requestuploadlogfiles;
            GeneratedMessageLite.registerDefaultInstance(requestUploadLogfiles.class, requestuploadlogfiles);
        }

        requestUploadLogfiles() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTime() {
            this.bitField0_ &= -5;
            this.endTime_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTime() {
            this.bitField0_ &= -3;
            this.startTime_ = 0;
        }

        public static requestUploadLogfiles getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static requestUploadLogfiles parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static requestUploadLogfiles parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<requestUploadLogfiles> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTime(int i3) {
            this.bitField0_ |= 4;
            this.endTime_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTime(int i3) {
            this.bitField0_ |= 2;
            this.startTime_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new requestUploadLogfiles();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u000b\u0001\u0003\u000b\u0002", new Object[]{"bitField0_", "appid_", "startTime_", "endTime_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<requestUploadLogfiles> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (requestUploadLogfiles.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
        public boolean hasEndTime() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.requestUploadLogfilesOrBuilder
        public boolean hasStartTime() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(requestUploadLogfiles requestuploadlogfiles) {
            return DEFAULT_INSTANCE.createBuilder(requestuploadlogfiles);
        }

        public static requestUploadLogfiles parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static requestUploadLogfiles parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static requestUploadLogfiles parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static requestUploadLogfiles parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static requestUploadLogfiles parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static requestUploadLogfiles parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static requestUploadLogfiles parseFrom(InputStream inputStream) throws IOException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static requestUploadLogfiles parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static requestUploadLogfiles parseFrom(k kVar) throws IOException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static requestUploadLogfiles parseFrom(k kVar, t tVar) throws IOException {
            return (requestUploadLogfiles) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface requestUploadLogfilesOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getEndTime();

        int getStartTime();

        boolean hasAppid();

        boolean hasEndTime();

        boolean hasStartTime();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class setLonglinkIplist extends GeneratedMessageLite<setLonglinkIplist, Builder> implements setLonglinkIplistOrBuilder {
        private static final setLonglinkIplist DEFAULT_INSTANCE;
        private static volatile bg<setLonglinkIplist> PARSER = null;
        public static final int SVRIPLIST_FIELD_NUMBER = 1;
        private int bitField0_;
        private ByteString svriplist_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<setLonglinkIplist, Builder> implements setLonglinkIplistOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearSvriplist() {
                copyOnWrite();
                ((setLonglinkIplist) this.instance).clearSvriplist();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.setLonglinkIplistOrBuilder
            public ByteString getSvriplist() {
                return ((setLonglinkIplist) this.instance).getSvriplist();
            }

            @Override // com.tencent.ilinkservice.AidlProto.setLonglinkIplistOrBuilder
            public boolean hasSvriplist() {
                return ((setLonglinkIplist) this.instance).hasSvriplist();
            }

            public Builder setSvriplist(ByteString byteString) {
                copyOnWrite();
                ((setLonglinkIplist) this.instance).setSvriplist(byteString);
                return this;
            }

            Builder() {
                super(setLonglinkIplist.DEFAULT_INSTANCE);
            }
        }

        static {
            setLonglinkIplist setlonglinkiplist = new setLonglinkIplist();
            DEFAULT_INSTANCE = setlonglinkiplist;
            GeneratedMessageLite.registerDefaultInstance(setLonglinkIplist.class, setlonglinkiplist);
        }

        setLonglinkIplist() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSvriplist() {
            this.bitField0_ &= -2;
            this.svriplist_ = getDefaultInstance().getSvriplist();
        }

        public static setLonglinkIplist getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static setLonglinkIplist parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (setLonglinkIplist) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static setLonglinkIplist parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<setLonglinkIplist> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSvriplist(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.svriplist_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new setLonglinkIplist();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "svriplist_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<setLonglinkIplist> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (setLonglinkIplist.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.setLonglinkIplistOrBuilder
        public ByteString getSvriplist() {
            return this.svriplist_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.setLonglinkIplistOrBuilder
        public boolean hasSvriplist() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(setLonglinkIplist setlonglinkiplist) {
            return DEFAULT_INSTANCE.createBuilder(setlonglinkiplist);
        }

        public static setLonglinkIplist parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (setLonglinkIplist) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static setLonglinkIplist parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static setLonglinkIplist parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static setLonglinkIplist parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static setLonglinkIplist parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static setLonglinkIplist parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static setLonglinkIplist parseFrom(InputStream inputStream) throws IOException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static setLonglinkIplist parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static setLonglinkIplist parseFrom(k kVar) throws IOException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static setLonglinkIplist parseFrom(k kVar, t tVar) throws IOException {
            return (setLonglinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface setLonglinkIplistOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getSvriplist();

        boolean hasSvriplist();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class setShortlinkIplist extends GeneratedMessageLite<setShortlinkIplist, Builder> implements setShortlinkIplistOrBuilder {
        private static final setShortlinkIplist DEFAULT_INSTANCE;
        private static volatile bg<setShortlinkIplist> PARSER = null;
        public static final int SVRIPLIST_FIELD_NUMBER = 1;
        private int bitField0_;
        private ByteString svriplist_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<setShortlinkIplist, Builder> implements setShortlinkIplistOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearSvriplist() {
                copyOnWrite();
                ((setShortlinkIplist) this.instance).clearSvriplist();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.setShortlinkIplistOrBuilder
            public ByteString getSvriplist() {
                return ((setShortlinkIplist) this.instance).getSvriplist();
            }

            @Override // com.tencent.ilinkservice.AidlProto.setShortlinkIplistOrBuilder
            public boolean hasSvriplist() {
                return ((setShortlinkIplist) this.instance).hasSvriplist();
            }

            public Builder setSvriplist(ByteString byteString) {
                copyOnWrite();
                ((setShortlinkIplist) this.instance).setSvriplist(byteString);
                return this;
            }

            Builder() {
                super(setShortlinkIplist.DEFAULT_INSTANCE);
            }
        }

        static {
            setShortlinkIplist setshortlinkiplist = new setShortlinkIplist();
            DEFAULT_INSTANCE = setshortlinkiplist;
            GeneratedMessageLite.registerDefaultInstance(setShortlinkIplist.class, setshortlinkiplist);
        }

        setShortlinkIplist() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSvriplist() {
            this.bitField0_ &= -2;
            this.svriplist_ = getDefaultInstance().getSvriplist();
        }

        public static setShortlinkIplist getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static setShortlinkIplist parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (setShortlinkIplist) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static setShortlinkIplist parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<setShortlinkIplist> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSvriplist(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.svriplist_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new setShortlinkIplist();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "svriplist_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<setShortlinkIplist> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (setShortlinkIplist.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.setShortlinkIplistOrBuilder
        public ByteString getSvriplist() {
            return this.svriplist_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.setShortlinkIplistOrBuilder
        public boolean hasSvriplist() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(setShortlinkIplist setshortlinkiplist) {
            return DEFAULT_INSTANCE.createBuilder(setshortlinkiplist);
        }

        public static setShortlinkIplist parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (setShortlinkIplist) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static setShortlinkIplist parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static setShortlinkIplist parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static setShortlinkIplist parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static setShortlinkIplist parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static setShortlinkIplist parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static setShortlinkIplist parseFrom(InputStream inputStream) throws IOException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static setShortlinkIplist parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static setShortlinkIplist parseFrom(k kVar) throws IOException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static setShortlinkIplist parseFrom(k kVar, t tVar) throws IOException {
            return (setShortlinkIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface setShortlinkIplistOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getSvriplist();

        boolean hasSvriplist();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class setSmcBaseInfo extends GeneratedMessageLite<setSmcBaseInfo, Builder> implements setSmcBaseInfoOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final setSmcBaseInfo DEFAULT_INSTANCE;
        private static volatile bg<setSmcBaseInfo> PARSER = null;
        public static final int SMCBASEINFO_FIELD_NUMBER = 2;
        private int bitField0_;
        private String appid_ = "";
        private ByteString smcbaseinfo_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<setSmcBaseInfo, Builder> implements setSmcBaseInfoOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((setSmcBaseInfo) this.instance).clearAppid();
                return this;
            }

            public Builder clearSmcbaseinfo() {
                copyOnWrite();
                ((setSmcBaseInfo) this.instance).clearSmcbaseinfo();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
            public String getAppid() {
                return ((setSmcBaseInfo) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
            public ByteString getAppidBytes() {
                return ((setSmcBaseInfo) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
            public ByteString getSmcbaseinfo() {
                return ((setSmcBaseInfo) this.instance).getSmcbaseinfo();
            }

            @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
            public boolean hasAppid() {
                return ((setSmcBaseInfo) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
            public boolean hasSmcbaseinfo() {
                return ((setSmcBaseInfo) this.instance).hasSmcbaseinfo();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((setSmcBaseInfo) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((setSmcBaseInfo) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setSmcbaseinfo(ByteString byteString) {
                copyOnWrite();
                ((setSmcBaseInfo) this.instance).setSmcbaseinfo(byteString);
                return this;
            }

            Builder() {
                super(setSmcBaseInfo.DEFAULT_INSTANCE);
            }
        }

        static {
            setSmcBaseInfo setsmcbaseinfo = new setSmcBaseInfo();
            DEFAULT_INSTANCE = setsmcbaseinfo;
            GeneratedMessageLite.registerDefaultInstance(setSmcBaseInfo.class, setsmcbaseinfo);
        }

        setSmcBaseInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSmcbaseinfo() {
            this.bitField0_ &= -3;
            this.smcbaseinfo_ = getDefaultInstance().getSmcbaseinfo();
        }

        public static setSmcBaseInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static setSmcBaseInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static setSmcBaseInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<setSmcBaseInfo> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setSmcbaseinfo(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.smcbaseinfo_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new setSmcBaseInfo();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "appid_", "smcbaseinfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<setSmcBaseInfo> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (setSmcBaseInfo.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
        public ByteString getSmcbaseinfo() {
            return this.smcbaseinfo_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.setSmcBaseInfoOrBuilder
        public boolean hasSmcbaseinfo() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(setSmcBaseInfo setsmcbaseinfo) {
            return DEFAULT_INSTANCE.createBuilder(setsmcbaseinfo);
        }

        public static setSmcBaseInfo parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static setSmcBaseInfo parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static setSmcBaseInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static setSmcBaseInfo parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static setSmcBaseInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static setSmcBaseInfo parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static setSmcBaseInfo parseFrom(InputStream inputStream) throws IOException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static setSmcBaseInfo parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static setSmcBaseInfo parseFrom(k kVar) throws IOException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static setSmcBaseInfo parseFrom(k kVar, t tVar) throws IOException {
            return (setSmcBaseInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface setSmcBaseInfoOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getSmcbaseinfo();

        boolean hasAppid();

        boolean hasSmcbaseinfo();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class startUploadLog extends GeneratedMessageLite<startUploadLog, Builder> implements startUploadLogOrBuilder {
        private static final startUploadLog DEFAULT_INSTANCE;
        public static final int LOGINFO_FIELD_NUMBER = 1;
        private static volatile bg<startUploadLog> PARSER;
        private int bitField0_;
        private ByteString loginfo_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<startUploadLog, Builder> implements startUploadLogOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearLoginfo() {
                copyOnWrite();
                ((startUploadLog) this.instance).clearLoginfo();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.startUploadLogOrBuilder
            public ByteString getLoginfo() {
                return ((startUploadLog) this.instance).getLoginfo();
            }

            @Override // com.tencent.ilinkservice.AidlProto.startUploadLogOrBuilder
            public boolean hasLoginfo() {
                return ((startUploadLog) this.instance).hasLoginfo();
            }

            public Builder setLoginfo(ByteString byteString) {
                copyOnWrite();
                ((startUploadLog) this.instance).setLoginfo(byteString);
                return this;
            }

            Builder() {
                super(startUploadLog.DEFAULT_INSTANCE);
            }
        }

        static {
            startUploadLog startuploadlog = new startUploadLog();
            DEFAULT_INSTANCE = startuploadlog;
            GeneratedMessageLite.registerDefaultInstance(startUploadLog.class, startuploadlog);
        }

        startUploadLog() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLoginfo() {
            this.bitField0_ &= -2;
            this.loginfo_ = getDefaultInstance().getLoginfo();
        }

        public static startUploadLog getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static startUploadLog parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (startUploadLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static startUploadLog parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<startUploadLog> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLoginfo(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 1;
            this.loginfo_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new startUploadLog();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n\u0000", new Object[]{"bitField0_", "loginfo_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<startUploadLog> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (startUploadLog.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.startUploadLogOrBuilder
        public ByteString getLoginfo() {
            return this.loginfo_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.startUploadLogOrBuilder
        public boolean hasLoginfo() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(startUploadLog startuploadlog) {
            return DEFAULT_INSTANCE.createBuilder(startuploadlog);
        }

        public static startUploadLog parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (startUploadLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static startUploadLog parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static startUploadLog parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static startUploadLog parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static startUploadLog parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static startUploadLog parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static startUploadLog parseFrom(InputStream inputStream) throws IOException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static startUploadLog parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static startUploadLog parseFrom(k kVar) throws IOException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static startUploadLog parseFrom(k kVar, t tVar) throws IOException {
            return (startUploadLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface startUploadLogOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getLoginfo();

        boolean hasLoginfo();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class thirdAppLogin extends GeneratedMessageLite<thirdAppLogin, Builder> implements thirdAppLoginOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final thirdAppLogin DEFAULT_INSTANCE;
        private static volatile bg<thirdAppLogin> PARSER = null;
        public static final int REQ_FIELD_NUMBER = 2;
        private int bitField0_;
        private String appid_ = "";
        private ByteString req_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<thirdAppLogin, Builder> implements thirdAppLoginOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((thirdAppLogin) this.instance).clearAppid();
                return this;
            }

            public Builder clearReq() {
                copyOnWrite();
                ((thirdAppLogin) this.instance).clearReq();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
            public String getAppid() {
                return ((thirdAppLogin) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
            public ByteString getAppidBytes() {
                return ((thirdAppLogin) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
            public ByteString getReq() {
                return ((thirdAppLogin) this.instance).getReq();
            }

            @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
            public boolean hasAppid() {
                return ((thirdAppLogin) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
            public boolean hasReq() {
                return ((thirdAppLogin) this.instance).hasReq();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((thirdAppLogin) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((thirdAppLogin) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setReq(ByteString byteString) {
                copyOnWrite();
                ((thirdAppLogin) this.instance).setReq(byteString);
                return this;
            }

            Builder() {
                super(thirdAppLogin.DEFAULT_INSTANCE);
            }
        }

        static {
            thirdAppLogin thirdapplogin = new thirdAppLogin();
            DEFAULT_INSTANCE = thirdapplogin;
            GeneratedMessageLite.registerDefaultInstance(thirdAppLogin.class, thirdapplogin);
        }

        thirdAppLogin() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReq() {
            this.bitField0_ &= -3;
            this.req_ = getDefaultInstance().getReq();
        }

        public static thirdAppLogin getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static thirdAppLogin parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (thirdAppLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static thirdAppLogin parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<thirdAppLogin> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setReq(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.req_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new thirdAppLogin();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "appid_", "req_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<thirdAppLogin> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (thirdAppLogin.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
        public ByteString getReq() {
            return this.req_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.thirdAppLoginOrBuilder
        public boolean hasReq() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(thirdAppLogin thirdapplogin) {
            return DEFAULT_INSTANCE.createBuilder(thirdapplogin);
        }

        public static thirdAppLogin parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (thirdAppLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static thirdAppLogin parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static thirdAppLogin parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static thirdAppLogin parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static thirdAppLogin parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static thirdAppLogin parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static thirdAppLogin parseFrom(InputStream inputStream) throws IOException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static thirdAppLogin parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static thirdAppLogin parseFrom(k kVar) throws IOException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static thirdAppLogin parseFrom(k kVar, t tVar) throws IOException {
            return (thirdAppLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface thirdAppLoginOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getReq();

        boolean hasAppid();

        boolean hasReq();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class updateDeviceShadowReq extends GeneratedMessageLite<updateDeviceShadowReq, Builder> implements updateDeviceShadowReqOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final updateDeviceShadowReq DEFAULT_INSTANCE;
        private static volatile bg<updateDeviceShadowReq> PARSER = null;
        public static final int SHADOWDATA_FIELD_NUMBER = 2;
        private int bitField0_;
        private String appid_ = "";
        private ByteString shadowdata_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<updateDeviceShadowReq, Builder> implements updateDeviceShadowReqOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((updateDeviceShadowReq) this.instance).clearAppid();
                return this;
            }

            public Builder clearShadowdata() {
                copyOnWrite();
                ((updateDeviceShadowReq) this.instance).clearShadowdata();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
            public String getAppid() {
                return ((updateDeviceShadowReq) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
            public ByteString getAppidBytes() {
                return ((updateDeviceShadowReq) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
            public ByteString getShadowdata() {
                return ((updateDeviceShadowReq) this.instance).getShadowdata();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
            public boolean hasAppid() {
                return ((updateDeviceShadowReq) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
            public boolean hasShadowdata() {
                return ((updateDeviceShadowReq) this.instance).hasShadowdata();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((updateDeviceShadowReq) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((updateDeviceShadowReq) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setShadowdata(ByteString byteString) {
                copyOnWrite();
                ((updateDeviceShadowReq) this.instance).setShadowdata(byteString);
                return this;
            }

            Builder() {
                super(updateDeviceShadowReq.DEFAULT_INSTANCE);
            }
        }

        static {
            updateDeviceShadowReq updatedeviceshadowreq = new updateDeviceShadowReq();
            DEFAULT_INSTANCE = updatedeviceshadowreq;
            GeneratedMessageLite.registerDefaultInstance(updateDeviceShadowReq.class, updatedeviceshadowreq);
        }

        updateDeviceShadowReq() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearShadowdata() {
            this.bitField0_ &= -3;
            this.shadowdata_ = getDefaultInstance().getShadowdata();
        }

        public static updateDeviceShadowReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static updateDeviceShadowReq parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static updateDeviceShadowReq parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<updateDeviceShadowReq> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setShadowdata(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.shadowdata_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new updateDeviceShadowReq();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "appid_", "shadowdata_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<updateDeviceShadowReq> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (updateDeviceShadowReq.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
        public ByteString getShadowdata() {
            return this.shadowdata_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowReqOrBuilder
        public boolean hasShadowdata() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(updateDeviceShadowReq updatedeviceshadowreq) {
            return DEFAULT_INSTANCE.createBuilder(updatedeviceshadowreq);
        }

        public static updateDeviceShadowReq parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static updateDeviceShadowReq parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static updateDeviceShadowReq parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static updateDeviceShadowReq parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static updateDeviceShadowReq parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static updateDeviceShadowReq parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static updateDeviceShadowReq parseFrom(InputStream inputStream) throws IOException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static updateDeviceShadowReq parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static updateDeviceShadowReq parseFrom(k kVar) throws IOException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static updateDeviceShadowReq parseFrom(k kVar, t tVar) throws IOException {
            return (updateDeviceShadowReq) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface updateDeviceShadowReqOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getShadowdata();

        boolean hasAppid();

        boolean hasShadowdata();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class updateDeviceShadowResp extends GeneratedMessageLite<updateDeviceShadowResp, Builder> implements updateDeviceShadowRespOrBuilder {
        private static final updateDeviceShadowResp DEFAULT_INSTANCE;
        private static volatile bg<updateDeviceShadowResp> PARSER = null;
        public static final int TASKID_FIELD_NUMBER = 1;
        private int bitField0_;
        private int taskid_;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<updateDeviceShadowResp, Builder> implements updateDeviceShadowRespOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearTaskid() {
                copyOnWrite();
                ((updateDeviceShadowResp) this.instance).clearTaskid();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowRespOrBuilder
            public int getTaskid() {
                return ((updateDeviceShadowResp) this.instance).getTaskid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowRespOrBuilder
            public boolean hasTaskid() {
                return ((updateDeviceShadowResp) this.instance).hasTaskid();
            }

            public Builder setTaskid(int i3) {
                copyOnWrite();
                ((updateDeviceShadowResp) this.instance).setTaskid(i3);
                return this;
            }

            Builder() {
                super(updateDeviceShadowResp.DEFAULT_INSTANCE);
            }
        }

        static {
            updateDeviceShadowResp updatedeviceshadowresp = new updateDeviceShadowResp();
            DEFAULT_INSTANCE = updatedeviceshadowresp;
            GeneratedMessageLite.registerDefaultInstance(updateDeviceShadowResp.class, updatedeviceshadowresp);
        }

        updateDeviceShadowResp() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTaskid() {
            this.bitField0_ &= -2;
            this.taskid_ = 0;
        }

        public static updateDeviceShadowResp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static updateDeviceShadowResp parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static updateDeviceShadowResp parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<updateDeviceShadowResp> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTaskid(int i3) {
            this.bitField0_ |= 1;
            this.taskid_ = i3;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new updateDeviceShadowResp();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b\u0000", new Object[]{"bitField0_", "taskid_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<updateDeviceShadowResp> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (updateDeviceShadowResp.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowRespOrBuilder
        public int getTaskid() {
            return this.taskid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateDeviceShadowRespOrBuilder
        public boolean hasTaskid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(updateDeviceShadowResp updatedeviceshadowresp) {
            return DEFAULT_INSTANCE.createBuilder(updatedeviceshadowresp);
        }

        public static updateDeviceShadowResp parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static updateDeviceShadowResp parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static updateDeviceShadowResp parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static updateDeviceShadowResp parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static updateDeviceShadowResp parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static updateDeviceShadowResp parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static updateDeviceShadowResp parseFrom(InputStream inputStream) throws IOException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static updateDeviceShadowResp parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static updateDeviceShadowResp parseFrom(k kVar) throws IOException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static updateDeviceShadowResp parseFrom(k kVar, t tVar) throws IOException {
            return (updateDeviceShadowResp) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface updateDeviceShadowRespOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        int getTaskid();

        boolean hasTaskid();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class updateIlinkToken extends GeneratedMessageLite<updateIlinkToken, Builder> implements updateIlinkTokenOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final updateIlinkToken DEFAULT_INSTANCE;
        public static final int ILINKTOKEN_FIELD_NUMBER = 2;
        private static volatile bg<updateIlinkToken> PARSER;
        private int bitField0_;
        private String appid_ = "";
        private String ilinktoken_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<updateIlinkToken, Builder> implements updateIlinkTokenOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((updateIlinkToken) this.instance).clearAppid();
                return this;
            }

            public Builder clearIlinktoken() {
                copyOnWrite();
                ((updateIlinkToken) this.instance).clearIlinktoken();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
            public String getAppid() {
                return ((updateIlinkToken) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
            public ByteString getAppidBytes() {
                return ((updateIlinkToken) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
            public String getIlinktoken() {
                return ((updateIlinkToken) this.instance).getIlinktoken();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
            public ByteString getIlinktokenBytes() {
                return ((updateIlinkToken) this.instance).getIlinktokenBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
            public boolean hasAppid() {
                return ((updateIlinkToken) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
            public boolean hasIlinktoken() {
                return ((updateIlinkToken) this.instance).hasIlinktoken();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((updateIlinkToken) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((updateIlinkToken) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setIlinktoken(String str) {
                copyOnWrite();
                ((updateIlinkToken) this.instance).setIlinktoken(str);
                return this;
            }

            public Builder setIlinktokenBytes(ByteString byteString) {
                copyOnWrite();
                ((updateIlinkToken) this.instance).setIlinktokenBytes(byteString);
                return this;
            }

            Builder() {
                super(updateIlinkToken.DEFAULT_INSTANCE);
            }
        }

        static {
            updateIlinkToken updateilinktoken = new updateIlinkToken();
            DEFAULT_INSTANCE = updateilinktoken;
            GeneratedMessageLite.registerDefaultInstance(updateIlinkToken.class, updateilinktoken);
        }

        updateIlinkToken() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIlinktoken() {
            this.bitField0_ &= -3;
            this.ilinktoken_ = getDefaultInstance().getIlinktoken();
        }

        public static updateIlinkToken getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static updateIlinkToken parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (updateIlinkToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static updateIlinkToken parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<updateIlinkToken> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinktoken(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.ilinktoken_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIlinktokenBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.ilinktoken_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new updateIlinkToken();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"bitField0_", "appid_", "ilinktoken_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<updateIlinkToken> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (updateIlinkToken.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
        public String getIlinktoken() {
            return this.ilinktoken_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
        public ByteString getIlinktokenBytes() {
            return ByteString.copyFromUtf8(this.ilinktoken_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.updateIlinkTokenOrBuilder
        public boolean hasIlinktoken() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(updateIlinkToken updateilinktoken) {
            return DEFAULT_INSTANCE.createBuilder(updateilinktoken);
        }

        public static updateIlinkToken parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (updateIlinkToken) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static updateIlinkToken parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static updateIlinkToken parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static updateIlinkToken parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static updateIlinkToken parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static updateIlinkToken parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static updateIlinkToken parseFrom(InputStream inputStream) throws IOException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static updateIlinkToken parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static updateIlinkToken parseFrom(k kVar) throws IOException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static updateIlinkToken parseFrom(k kVar, t tVar) throws IOException {
            return (updateIlinkToken) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface updateIlinkTokenOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getIlinktoken();

        ByteString getIlinktokenBytes();

        boolean hasAppid();

        boolean hasIlinktoken();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class visitorLogin extends GeneratedMessageLite<visitorLogin, Builder> implements visitorLoginOrBuilder {
        public static final int APPID_FIELD_NUMBER = 1;
        private static final visitorLogin DEFAULT_INSTANCE;
        private static volatile bg<visitorLogin> PARSER = null;
        public static final int REQ_FIELD_NUMBER = 2;
        private int bitField0_;
        private String appid_ = "";
        private ByteString req_ = ByteString.EMPTY;

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<visitorLogin, Builder> implements visitorLoginOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAppid() {
                copyOnWrite();
                ((visitorLogin) this.instance).clearAppid();
                return this;
            }

            public Builder clearReq() {
                copyOnWrite();
                ((visitorLogin) this.instance).clearReq();
                return this;
            }

            @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
            public String getAppid() {
                return ((visitorLogin) this.instance).getAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
            public ByteString getAppidBytes() {
                return ((visitorLogin) this.instance).getAppidBytes();
            }

            @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
            public ByteString getReq() {
                return ((visitorLogin) this.instance).getReq();
            }

            @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
            public boolean hasAppid() {
                return ((visitorLogin) this.instance).hasAppid();
            }

            @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
            public boolean hasReq() {
                return ((visitorLogin) this.instance).hasReq();
            }

            public Builder setAppid(String str) {
                copyOnWrite();
                ((visitorLogin) this.instance).setAppid(str);
                return this;
            }

            public Builder setAppidBytes(ByteString byteString) {
                copyOnWrite();
                ((visitorLogin) this.instance).setAppidBytes(byteString);
                return this;
            }

            public Builder setReq(ByteString byteString) {
                copyOnWrite();
                ((visitorLogin) this.instance).setReq(byteString);
                return this;
            }

            Builder() {
                super(visitorLogin.DEFAULT_INSTANCE);
            }
        }

        static {
            visitorLogin visitorlogin = new visitorLogin();
            DEFAULT_INSTANCE = visitorlogin;
            GeneratedMessageLite.registerDefaultInstance(visitorLogin.class, visitorlogin);
        }

        visitorLogin() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAppid() {
            this.bitField0_ &= -2;
            this.appid_ = getDefaultInstance().getAppid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReq() {
            this.bitField0_ &= -3;
            this.req_ = getDefaultInstance().getReq();
        }

        public static visitorLogin getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static visitorLogin parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (visitorLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static visitorLogin parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<visitorLogin> parser() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setReq(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.req_ = byteString;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new visitorLogin();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "appid_", "req_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<visitorLogin> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (visitorLogin.class) {
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

        @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
        public String getAppid() {
            return this.appid_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
        public ByteString getAppidBytes() {
            return ByteString.copyFromUtf8(this.appid_);
        }

        @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
        public ByteString getReq() {
            return this.req_;
        }

        @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
        public boolean hasAppid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.AidlProto.visitorLoginOrBuilder
        public boolean hasReq() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(visitorLogin visitorlogin) {
            return DEFAULT_INSTANCE.createBuilder(visitorlogin);
        }

        public static visitorLogin parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (visitorLogin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static visitorLogin parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static visitorLogin parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static visitorLogin parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static visitorLogin parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static visitorLogin parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static visitorLogin parseFrom(InputStream inputStream) throws IOException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static visitorLogin parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static visitorLogin parseFrom(k kVar) throws IOException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static visitorLogin parseFrom(k kVar, t tVar) throws IOException {
            return (visitorLogin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface visitorLoginOrBuilder extends av {
        String getAppid();

        ByteString getAppidBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        ByteString getReq();

        boolean hasAppid();

        boolean hasReq();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    AidlProto() {
    }

    public static void registerAllExtensions(t tVar) {
    }
}
