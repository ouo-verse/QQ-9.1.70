package com.tencent.ilinkservice;

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

/* loaded from: classes7.dex */
public final class IlinkServiceProto {

    /* renamed from: com.tencent.ilinkservice.IlinkServiceProto$1, reason: invalid class name */
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
    public static final class AddMsgCmd extends GeneratedMessageLite<AddMsgCmd, Builder> implements AddMsgCmdOrBuilder {
        public static final int CONTENT_FIELD_NUMBER = 6;
        public static final int CREATETIME_FIELD_NUMBER = 9;
        private static final AddMsgCmd DEFAULT_INSTANCE;
        public static final int FROMILINKID_FIELD_NUMBER = 2;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int MSGTYPE_FIELD_NUMBER = 5;
        private static volatile bg<AddMsgCmd> PARSER = null;
        public static final int PUSHCONTENT_FIELD_NUMBER = 7;
        public static final int ROOMNAME_FIELD_NUMBER = 4;
        public static final int SEQ_FIELD_NUMBER = 8;
        public static final int STATUS_FIELD_NUMBER = 10;
        public static final int TOILINKID_FIELD_NUMBER = 3;
        private int bitField0_;
        private long createTime_;
        private long id_;
        private int msgType_;
        private long seq_;
        private long status_;
        private String fromIlinkId_ = "";
        private String toIlinkId_ = "";
        private String roomName_ = "";
        private String content_ = "";
        private String pushContent_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<AddMsgCmd, Builder> implements AddMsgCmdOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearContent() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearContent();
                return this;
            }

            public Builder clearCreateTime() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearCreateTime();
                return this;
            }

            public Builder clearFromIlinkId() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearFromIlinkId();
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearId();
                return this;
            }

            public Builder clearMsgType() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearMsgType();
                return this;
            }

            public Builder clearPushContent() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearPushContent();
                return this;
            }

            public Builder clearRoomName() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearRoomName();
                return this;
            }

            public Builder clearSeq() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearSeq();
                return this;
            }

            public Builder clearStatus() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearStatus();
                return this;
            }

            public Builder clearToIlinkId() {
                copyOnWrite();
                ((AddMsgCmd) this.instance).clearToIlinkId();
                return this;
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public String getContent() {
                return ((AddMsgCmd) this.instance).getContent();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public ByteString getContentBytes() {
                return ((AddMsgCmd) this.instance).getContentBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public long getCreateTime() {
                return ((AddMsgCmd) this.instance).getCreateTime();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public String getFromIlinkId() {
                return ((AddMsgCmd) this.instance).getFromIlinkId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public ByteString getFromIlinkIdBytes() {
                return ((AddMsgCmd) this.instance).getFromIlinkIdBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public long getId() {
                return ((AddMsgCmd) this.instance).getId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public int getMsgType() {
                return ((AddMsgCmd) this.instance).getMsgType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public String getPushContent() {
                return ((AddMsgCmd) this.instance).getPushContent();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public ByteString getPushContentBytes() {
                return ((AddMsgCmd) this.instance).getPushContentBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public String getRoomName() {
                return ((AddMsgCmd) this.instance).getRoomName();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public ByteString getRoomNameBytes() {
                return ((AddMsgCmd) this.instance).getRoomNameBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public long getSeq() {
                return ((AddMsgCmd) this.instance).getSeq();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public long getStatus() {
                return ((AddMsgCmd) this.instance).getStatus();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public String getToIlinkId() {
                return ((AddMsgCmd) this.instance).getToIlinkId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public ByteString getToIlinkIdBytes() {
                return ((AddMsgCmd) this.instance).getToIlinkIdBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasContent() {
                return ((AddMsgCmd) this.instance).hasContent();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasCreateTime() {
                return ((AddMsgCmd) this.instance).hasCreateTime();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasFromIlinkId() {
                return ((AddMsgCmd) this.instance).hasFromIlinkId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasId() {
                return ((AddMsgCmd) this.instance).hasId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasMsgType() {
                return ((AddMsgCmd) this.instance).hasMsgType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasPushContent() {
                return ((AddMsgCmd) this.instance).hasPushContent();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasRoomName() {
                return ((AddMsgCmd) this.instance).hasRoomName();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasSeq() {
                return ((AddMsgCmd) this.instance).hasSeq();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasStatus() {
                return ((AddMsgCmd) this.instance).hasStatus();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
            public boolean hasToIlinkId() {
                return ((AddMsgCmd) this.instance).hasToIlinkId();
            }

            public Builder setContent(String str) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setContent(str);
                return this;
            }

            public Builder setContentBytes(ByteString byteString) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setContentBytes(byteString);
                return this;
            }

            public Builder setCreateTime(long j3) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setCreateTime(j3);
                return this;
            }

            public Builder setFromIlinkId(String str) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setFromIlinkId(str);
                return this;
            }

            public Builder setFromIlinkIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setFromIlinkIdBytes(byteString);
                return this;
            }

            public Builder setId(long j3) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setId(j3);
                return this;
            }

            public Builder setMsgType(int i3) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setMsgType(i3);
                return this;
            }

            public Builder setPushContent(String str) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setPushContent(str);
                return this;
            }

            public Builder setPushContentBytes(ByteString byteString) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setPushContentBytes(byteString);
                return this;
            }

            public Builder setRoomName(String str) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setRoomName(str);
                return this;
            }

            public Builder setRoomNameBytes(ByteString byteString) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setRoomNameBytes(byteString);
                return this;
            }

            public Builder setSeq(long j3) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setSeq(j3);
                return this;
            }

            public Builder setStatus(long j3) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setStatus(j3);
                return this;
            }

            public Builder setToIlinkId(String str) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setToIlinkId(str);
                return this;
            }

            public Builder setToIlinkIdBytes(ByteString byteString) {
                copyOnWrite();
                ((AddMsgCmd) this.instance).setToIlinkIdBytes(byteString);
                return this;
            }

            Builder() {
                super(AddMsgCmd.DEFAULT_INSTANCE);
            }
        }

        static {
            AddMsgCmd addMsgCmd = new AddMsgCmd();
            DEFAULT_INSTANCE = addMsgCmd;
            GeneratedMessageLite.registerDefaultInstance(AddMsgCmd.class, addMsgCmd);
        }

        AddMsgCmd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearContent() {
            this.bitField0_ &= -33;
            this.content_ = getDefaultInstance().getContent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCreateTime() {
            this.bitField0_ &= -257;
            this.createTime_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFromIlinkId() {
            this.bitField0_ &= -3;
            this.fromIlinkId_ = getDefaultInstance().getFromIlinkId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.bitField0_ &= -2;
            this.id_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMsgType() {
            this.bitField0_ &= -17;
            this.msgType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPushContent() {
            this.bitField0_ &= -65;
            this.pushContent_ = getDefaultInstance().getPushContent();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRoomName() {
            this.bitField0_ &= -9;
            this.roomName_ = getDefaultInstance().getRoomName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSeq() {
            this.bitField0_ &= -129;
            this.seq_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStatus() {
            this.bitField0_ &= -513;
            this.status_ = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearToIlinkId() {
            this.bitField0_ &= -5;
            this.toIlinkId_ = getDefaultInstance().getToIlinkId();
        }

        public static AddMsgCmd getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static AddMsgCmd parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AddMsgCmd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AddMsgCmd parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<AddMsgCmd> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContent(String str) {
            str.getClass();
            this.bitField0_ |= 32;
            this.content_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setContentBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 32;
            this.content_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCreateTime(long j3) {
            this.bitField0_ |= 256;
            this.createTime_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFromIlinkId(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.fromIlinkId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFromIlinkIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.fromIlinkId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(long j3) {
            this.bitField0_ |= 1;
            this.id_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMsgType(int i3) {
            this.bitField0_ |= 16;
            this.msgType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPushContent(String str) {
            str.getClass();
            this.bitField0_ |= 64;
            this.pushContent_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPushContentBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 64;
            this.pushContent_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomName(String str) {
            str.getClass();
            this.bitField0_ |= 8;
            this.roomName_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRoomNameBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 8;
            this.roomName_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSeq(long j3) {
            this.bitField0_ |= 128;
            this.seq_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStatus(long j3) {
            this.bitField0_ |= 512;
            this.status_ = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToIlinkId(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.toIlinkId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setToIlinkIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.toIlinkId_ = byteString.toStringUtf8();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new AddMsgCmd();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\u0003\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u000b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0003\u0007\t\u0003\b\n\u0003\t", new Object[]{"bitField0_", "id_", "fromIlinkId_", "toIlinkId_", "roomName_", "msgType_", "content_", "pushContent_", "seq_", "createTime_", "status_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<AddMsgCmd> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (AddMsgCmd.class) {
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public String getContent() {
            return this.content_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public ByteString getContentBytes() {
            return ByteString.copyFromUtf8(this.content_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public long getCreateTime() {
            return this.createTime_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public String getFromIlinkId() {
            return this.fromIlinkId_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public ByteString getFromIlinkIdBytes() {
            return ByteString.copyFromUtf8(this.fromIlinkId_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public long getId() {
            return this.id_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public int getMsgType() {
            return this.msgType_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public String getPushContent() {
            return this.pushContent_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public ByteString getPushContentBytes() {
            return ByteString.copyFromUtf8(this.pushContent_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public String getRoomName() {
            return this.roomName_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public ByteString getRoomNameBytes() {
            return ByteString.copyFromUtf8(this.roomName_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public long getSeq() {
            return this.seq_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public long getStatus() {
            return this.status_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public String getToIlinkId() {
            return this.toIlinkId_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public ByteString getToIlinkIdBytes() {
            return ByteString.copyFromUtf8(this.toIlinkId_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasContent() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasCreateTime() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasFromIlinkId() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasId() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasMsgType() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasPushContent() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasRoomName() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasSeq() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasStatus() {
            if ((this.bitField0_ & 512) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.AddMsgCmdOrBuilder
        public boolean hasToIlinkId() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(AddMsgCmd addMsgCmd) {
            return DEFAULT_INSTANCE.createBuilder(addMsgCmd);
        }

        public static AddMsgCmd parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (AddMsgCmd) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static AddMsgCmd parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static AddMsgCmd parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AddMsgCmd parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static AddMsgCmd parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AddMsgCmd parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static AddMsgCmd parseFrom(InputStream inputStream) throws IOException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AddMsgCmd parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static AddMsgCmd parseFrom(k kVar) throws IOException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static AddMsgCmd parseFrom(k kVar, t tVar) throws IOException {
            return (AddMsgCmd) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface AddMsgCmdOrBuilder extends av {
        String getContent();

        ByteString getContentBytes();

        long getCreateTime();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getFromIlinkId();

        ByteString getFromIlinkIdBytes();

        long getId();

        int getMsgType();

        String getPushContent();

        ByteString getPushContentBytes();

        String getRoomName();

        ByteString getRoomNameBytes();

        long getSeq();

        long getStatus();

        String getToIlinkId();

        ByteString getToIlinkIdBytes();

        boolean hasContent();

        boolean hasCreateTime();

        boolean hasFromIlinkId();

        boolean hasId();

        boolean hasMsgType();

        boolean hasPushContent();

        boolean hasRoomName();

        boolean hasSeq();

        boolean hasStatus();

        boolean hasToIlinkId();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class EchoRequest extends GeneratedMessageLite<EchoRequest, Builder> implements EchoRequestOrBuilder {
        public static final int BODY_FIELD_NUMBER = 1;
        private static final EchoRequest DEFAULT_INSTANCE;
        private static volatile bg<EchoRequest> PARSER;
        private int bitField0_;
        private String body_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<EchoRequest, Builder> implements EchoRequestOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((EchoRequest) this.instance).clearBody();
                return this;
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoRequestOrBuilder
            public String getBody() {
                return ((EchoRequest) this.instance).getBody();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoRequestOrBuilder
            public ByteString getBodyBytes() {
                return ((EchoRequest) this.instance).getBodyBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoRequestOrBuilder
            public boolean hasBody() {
                return ((EchoRequest) this.instance).hasBody();
            }

            public Builder setBody(String str) {
                copyOnWrite();
                ((EchoRequest) this.instance).setBody(str);
                return this;
            }

            public Builder setBodyBytes(ByteString byteString) {
                copyOnWrite();
                ((EchoRequest) this.instance).setBodyBytes(byteString);
                return this;
            }

            Builder() {
                super(EchoRequest.DEFAULT_INSTANCE);
            }
        }

        static {
            EchoRequest echoRequest = new EchoRequest();
            DEFAULT_INSTANCE = echoRequest;
            GeneratedMessageLite.registerDefaultInstance(EchoRequest.class, echoRequest);
        }

        EchoRequest() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -2;
            this.body_ = getDefaultInstance().getBody();
        }

        public static EchoRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static EchoRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EchoRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EchoRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<EchoRequest> parser() {
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
                    return new EchoRequest();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<EchoRequest> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (EchoRequest.class) {
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoRequestOrBuilder
        public String getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoRequestOrBuilder
        public ByteString getBodyBytes() {
            return ByteString.copyFromUtf8(this.body_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoRequestOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(EchoRequest echoRequest) {
            return DEFAULT_INSTANCE.createBuilder(echoRequest);
        }

        public static EchoRequest parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (EchoRequest) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static EchoRequest parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static EchoRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EchoRequest parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static EchoRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EchoRequest parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static EchoRequest parseFrom(InputStream inputStream) throws IOException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EchoRequest parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static EchoRequest parseFrom(k kVar) throws IOException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static EchoRequest parseFrom(k kVar, t tVar) throws IOException {
            return (EchoRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface EchoRequestOrBuilder extends av {
        String getBody();

        ByteString getBodyBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasBody();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class EchoResponse extends GeneratedMessageLite<EchoResponse, Builder> implements EchoResponseOrBuilder {
        public static final int BODY_FIELD_NUMBER = 1;
        private static final EchoResponse DEFAULT_INSTANCE;
        private static volatile bg<EchoResponse> PARSER;
        private int bitField0_;
        private String body_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<EchoResponse, Builder> implements EchoResponseOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearBody() {
                copyOnWrite();
                ((EchoResponse) this.instance).clearBody();
                return this;
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoResponseOrBuilder
            public String getBody() {
                return ((EchoResponse) this.instance).getBody();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoResponseOrBuilder
            public ByteString getBodyBytes() {
                return ((EchoResponse) this.instance).getBodyBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoResponseOrBuilder
            public boolean hasBody() {
                return ((EchoResponse) this.instance).hasBody();
            }

            public Builder setBody(String str) {
                copyOnWrite();
                ((EchoResponse) this.instance).setBody(str);
                return this;
            }

            public Builder setBodyBytes(ByteString byteString) {
                copyOnWrite();
                ((EchoResponse) this.instance).setBodyBytes(byteString);
                return this;
            }

            Builder() {
                super(EchoResponse.DEFAULT_INSTANCE);
            }
        }

        static {
            EchoResponse echoResponse = new EchoResponse();
            DEFAULT_INSTANCE = echoResponse;
            GeneratedMessageLite.registerDefaultInstance(EchoResponse.class, echoResponse);
        }

        EchoResponse() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBody() {
            this.bitField0_ &= -2;
            this.body_ = getDefaultInstance().getBody();
        }

        public static EchoResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static EchoResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (EchoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EchoResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<EchoResponse> parser() {
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
                    return new EchoResponse();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"bitField0_", "body_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<EchoResponse> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (EchoResponse.class) {
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoResponseOrBuilder
        public String getBody() {
            return this.body_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoResponseOrBuilder
        public ByteString getBodyBytes() {
            return ByteString.copyFromUtf8(this.body_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.EchoResponseOrBuilder
        public boolean hasBody() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(EchoResponse echoResponse) {
            return DEFAULT_INSTANCE.createBuilder(echoResponse);
        }

        public static EchoResponse parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (EchoResponse) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static EchoResponse parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static EchoResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static EchoResponse parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static EchoResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static EchoResponse parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static EchoResponse parseFrom(InputStream inputStream) throws IOException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static EchoResponse parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static EchoResponse parseFrom(k kVar) throws IOException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static EchoResponse parseFrom(k kVar, t tVar) throws IOException {
            return (EchoResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface EchoResponseOrBuilder extends av {
        String getBody();

        ByteString getBodyBytes();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        boolean hasBody();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
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

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public boolean getIgnoreFreqCheck() {
                return ((IlinkKvReportInfo) this.instance).getIgnoreFreqCheck();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public int getLogid() {
                return ((IlinkKvReportInfo) this.instance).getLogid();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public boolean getReportNow() {
                return ((IlinkKvReportInfo) this.instance).getReportNow();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public int getReportUinType() {
                return ((IlinkKvReportInfo) this.instance).getReportUinType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public int getType() {
                return ((IlinkKvReportInfo) this.instance).getType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public ByteString getValue() {
                return ((IlinkKvReportInfo) this.instance).getValue();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public boolean hasIgnoreFreqCheck() {
                return ((IlinkKvReportInfo) this.instance).hasIgnoreFreqCheck();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public boolean hasLogid() {
                return ((IlinkKvReportInfo) this.instance).hasLogid();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public boolean hasReportNow() {
                return ((IlinkKvReportInfo) this.instance).hasReportNow();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public boolean hasReportUinType() {
                return ((IlinkKvReportInfo) this.instance).hasReportUinType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
            public boolean hasType() {
                return ((IlinkKvReportInfo) this.instance).hasType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public boolean getIgnoreFreqCheck() {
            return this.ignoreFreqCheck_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public int getLogid() {
            return this.logid_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public boolean getReportNow() {
            return this.reportNow_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public int getReportUinType() {
            return this.reportUinType_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public ByteString getValue() {
            return this.value_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public boolean hasIgnoreFreqCheck() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public boolean hasLogid() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public boolean hasReportNow() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public boolean hasReportUinType() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
        public boolean hasType() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkKvReportInfoOrBuilder
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

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public String getIp() {
                return ((IlinkNetProxyInfo) this.instance).getIp();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public ByteString getIpBytes() {
                return ((IlinkNetProxyInfo) this.instance).getIpBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public ByteString getPassword() {
                return ((IlinkNetProxyInfo) this.instance).getPassword();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public int getPort() {
                return ((IlinkNetProxyInfo) this.instance).getPort();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public int getProxytype() {
                return ((IlinkNetProxyInfo) this.instance).getProxytype();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public ByteString getUsername() {
                return ((IlinkNetProxyInfo) this.instance).getUsername();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public boolean hasIp() {
                return ((IlinkNetProxyInfo) this.instance).hasIp();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public boolean hasPassword() {
                return ((IlinkNetProxyInfo) this.instance).hasPassword();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public boolean hasPort() {
                return ((IlinkNetProxyInfo) this.instance).hasPort();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
            public boolean hasProxytype() {
                return ((IlinkNetProxyInfo) this.instance).hasProxytype();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public String getIp() {
            return this.ip_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public ByteString getIpBytes() {
            return ByteString.copyFromUtf8(this.ip_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public ByteString getPassword() {
            return this.password_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public int getPort() {
            return this.port_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public int getProxytype() {
            return this.proxytype_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public ByteString getUsername() {
            return this.username_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public boolean hasIp() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public boolean hasPassword() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public boolean hasPort() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
        public boolean hasProxytype() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkNetProxyInfoOrBuilder
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

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public int getEndTime() {
                return ((IlinkPullLogCmd) this.instance).getEndTime();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public String getExtBuffer() {
                return ((IlinkPullLogCmd) this.instance).getExtBuffer();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public ByteString getExtBufferBytes() {
                return ((IlinkPullLogCmd) this.instance).getExtBufferBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public String getIlinkAppids(int i3) {
                return ((IlinkPullLogCmd) this.instance).getIlinkAppids(i3);
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public ByteString getIlinkAppidsBytes(int i3) {
                return ((IlinkPullLogCmd) this.instance).getIlinkAppidsBytes(i3);
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public int getIlinkAppidsCount() {
                return ((IlinkPullLogCmd) this.instance).getIlinkAppidsCount();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public List<String> getIlinkAppidsList() {
                return Collections.unmodifiableList(((IlinkPullLogCmd) this.instance).getIlinkAppidsList());
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public String getIlinkCapath() {
                return ((IlinkPullLogCmd) this.instance).getIlinkCapath();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public ByteString getIlinkCapathBytes() {
                return ((IlinkPullLogCmd) this.instance).getIlinkCapathBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public String getIlinkLogs(int i3) {
                return ((IlinkPullLogCmd) this.instance).getIlinkLogs(i3);
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public ByteString getIlinkLogsBytes(int i3) {
                return ((IlinkPullLogCmd) this.instance).getIlinkLogsBytes(i3);
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public int getIlinkLogsCount() {
                return ((IlinkPullLogCmd) this.instance).getIlinkLogsCount();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public List<String> getIlinkLogsList() {
                return Collections.unmodifiableList(((IlinkPullLogCmd) this.instance).getIlinkLogsList());
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public boolean getIncludeDevlog() {
                return ((IlinkPullLogCmd) this.instance).getIncludeDevlog();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public int getStartTime() {
                return ((IlinkPullLogCmd) this.instance).getStartTime();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public String getUploadToken() {
                return ((IlinkPullLogCmd) this.instance).getUploadToken();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public ByteString getUploadTokenBytes() {
                return ((IlinkPullLogCmd) this.instance).getUploadTokenBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public int getUseNettype() {
                return ((IlinkPullLogCmd) this.instance).getUseNettype();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public boolean hasEndTime() {
                return ((IlinkPullLogCmd) this.instance).hasEndTime();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public boolean hasExtBuffer() {
                return ((IlinkPullLogCmd) this.instance).hasExtBuffer();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public boolean hasIlinkCapath() {
                return ((IlinkPullLogCmd) this.instance).hasIlinkCapath();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public boolean hasIncludeDevlog() {
                return ((IlinkPullLogCmd) this.instance).hasIncludeDevlog();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public boolean hasStartTime() {
                return ((IlinkPullLogCmd) this.instance).hasStartTime();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
            public boolean hasUploadToken() {
                return ((IlinkPullLogCmd) this.instance).hasUploadToken();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public String getExtBuffer() {
            return this.extBuffer_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public ByteString getExtBufferBytes() {
            return ByteString.copyFromUtf8(this.extBuffer_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public String getIlinkAppids(int i3) {
            return this.ilinkAppids_.get(i3);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public ByteString getIlinkAppidsBytes(int i3) {
            return ByteString.copyFromUtf8(this.ilinkAppids_.get(i3));
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public int getIlinkAppidsCount() {
            return this.ilinkAppids_.size();
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public List<String> getIlinkAppidsList() {
            return this.ilinkAppids_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public String getIlinkCapath() {
            return this.ilinkCapath_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public ByteString getIlinkCapathBytes() {
            return ByteString.copyFromUtf8(this.ilinkCapath_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public String getIlinkLogs(int i3) {
            return this.ilinkLogs_.get(i3);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public ByteString getIlinkLogsBytes(int i3) {
            return ByteString.copyFromUtf8(this.ilinkLogs_.get(i3));
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public int getIlinkLogsCount() {
            return this.ilinkLogs_.size();
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public List<String> getIlinkLogsList() {
            return this.ilinkLogs_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public boolean getIncludeDevlog() {
            return this.includeDevlog_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public int getStartTime() {
            return this.startTime_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public String getUploadToken() {
            return this.uploadToken_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public ByteString getUploadTokenBytes() {
            return ByteString.copyFromUtf8(this.uploadToken_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public int getUseNettype() {
            return this.useNettype_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public boolean hasEndTime() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public boolean hasExtBuffer() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public boolean hasIlinkCapath() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public boolean hasIncludeDevlog() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public boolean hasStartTime() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
        public boolean hasUploadToken() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogCmdOrBuilder
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

        private static final ad.d<IlinkPullLogNetType> internalValueMap = new ad.d<IlinkPullLogNetType>() { // from class: com.tencent.ilinkservice.IlinkServiceProto.IlinkPullLogNetType.1
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

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public String getDeviceBrand() {
                return ((IlinkSmcBaseInfo) this.instance).getDeviceBrand();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getDeviceBrandBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getDeviceBrandBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public String getDeviceModel() {
                return ((IlinkSmcBaseInfo) this.instance).getDeviceModel();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getDeviceModelBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getDeviceModelBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public String getLanguageVer() {
                return ((IlinkSmcBaseInfo) this.instance).getLanguageVer();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getLanguageVerBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getLanguageVerBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public String getOsname() {
                return ((IlinkSmcBaseInfo) this.instance).getOsname();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getOsnameBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getOsnameBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public String getOsversion() {
                return ((IlinkSmcBaseInfo) this.instance).getOsversion();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public ByteString getOsversionBytes() {
                return ((IlinkSmcBaseInfo) this.instance).getOsversionBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public boolean hasDeviceBrand() {
                return ((IlinkSmcBaseInfo) this.instance).hasDeviceBrand();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public boolean hasDeviceModel() {
                return ((IlinkSmcBaseInfo) this.instance).hasDeviceModel();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public boolean hasLanguageVer() {
                return ((IlinkSmcBaseInfo) this.instance).hasLanguageVer();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
            public boolean hasOsname() {
                return ((IlinkSmcBaseInfo) this.instance).hasOsname();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public String getDeviceBrand() {
            return this.deviceBrand_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getDeviceBrandBytes() {
            return ByteString.copyFromUtf8(this.deviceBrand_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public String getDeviceModel() {
            return this.deviceModel_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getDeviceModelBytes() {
            return ByteString.copyFromUtf8(this.deviceModel_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public String getLanguageVer() {
            return this.languageVer_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getLanguageVerBytes() {
            return ByteString.copyFromUtf8(this.languageVer_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public String getOsname() {
            return this.osname_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getOsnameBytes() {
            return ByteString.copyFromUtf8(this.osname_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public String getOsversion() {
            return this.osversion_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public ByteString getOsversionBytes() {
            return ByteString.copyFromUtf8(this.osversion_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public boolean hasDeviceBrand() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public boolean hasDeviceModel() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public boolean hasLanguageVer() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
        public boolean hasOsname() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkSmcBaseInfoOrBuilder
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

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public String getCapath() {
                return ((IlinkUploadLogInfo) this.instance).getCapath();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public ByteString getCapathBytes() {
                return ((IlinkUploadLogInfo) this.instance).getCapathBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public String getDeviceType() {
                return ((IlinkUploadLogInfo) this.instance).getDeviceType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public ByteString getDeviceTypeBytes() {
                return ((IlinkUploadLogInfo) this.instance).getDeviceTypeBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public String getExtBuffer() {
                return ((IlinkUploadLogInfo) this.instance).getExtBuffer();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public ByteString getExtBufferBytes() {
                return ((IlinkUploadLogInfo) this.instance).getExtBufferBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public boolean getIncludeDevLog() {
                return ((IlinkUploadLogInfo) this.instance).getIncludeDevLog();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public String getLogPath(int i3) {
                return ((IlinkUploadLogInfo) this.instance).getLogPath(i3);
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public ByteString getLogPathBytes(int i3) {
                return ((IlinkUploadLogInfo) this.instance).getLogPathBytes(i3);
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public int getLogPathCount() {
                return ((IlinkUploadLogInfo) this.instance).getLogPathCount();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public List<String> getLogPathList() {
                return Collections.unmodifiableList(((IlinkUploadLogInfo) this.instance).getLogPathList());
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public int getProductId() {
                return ((IlinkUploadLogInfo) this.instance).getProductId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public String getToken() {
                return ((IlinkUploadLogInfo) this.instance).getToken();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public ByteString getTokenBytes() {
                return ((IlinkUploadLogInfo) this.instance).getTokenBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public long getUin() {
                return ((IlinkUploadLogInfo) this.instance).getUin();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public String getUsername() {
                return ((IlinkUploadLogInfo) this.instance).getUsername();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public ByteString getUsernameBytes() {
                return ((IlinkUploadLogInfo) this.instance).getUsernameBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public int getVersion() {
                return ((IlinkUploadLogInfo) this.instance).getVersion();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public boolean hasCapath() {
                return ((IlinkUploadLogInfo) this.instance).hasCapath();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public boolean hasDeviceType() {
                return ((IlinkUploadLogInfo) this.instance).hasDeviceType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public boolean hasExtBuffer() {
                return ((IlinkUploadLogInfo) this.instance).hasExtBuffer();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public boolean hasIncludeDevLog() {
                return ((IlinkUploadLogInfo) this.instance).hasIncludeDevLog();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public boolean hasProductId() {
                return ((IlinkUploadLogInfo) this.instance).hasProductId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public boolean hasToken() {
                return ((IlinkUploadLogInfo) this.instance).hasToken();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public boolean hasUin() {
                return ((IlinkUploadLogInfo) this.instance).hasUin();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
            public boolean hasUsername() {
                return ((IlinkUploadLogInfo) this.instance).hasUsername();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public String getCapath() {
            return this.capath_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public ByteString getCapathBytes() {
            return ByteString.copyFromUtf8(this.capath_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public String getDeviceType() {
            return this.deviceType_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public ByteString getDeviceTypeBytes() {
            return ByteString.copyFromUtf8(this.deviceType_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public String getExtBuffer() {
            return this.extBuffer_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public ByteString getExtBufferBytes() {
            return ByteString.copyFromUtf8(this.extBuffer_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public boolean getIncludeDevLog() {
            return this.includeDevLog_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public String getLogPath(int i3) {
            return this.logPath_.get(i3);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public ByteString getLogPathBytes(int i3) {
            return ByteString.copyFromUtf8(this.logPath_.get(i3));
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public int getLogPathCount() {
            return this.logPath_.size();
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public List<String> getLogPathList() {
            return this.logPath_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public int getProductId() {
            return this.productId_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public String getToken() {
            return this.token_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public ByteString getTokenBytes() {
            return ByteString.copyFromUtf8(this.token_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public long getUin() {
            return this.uin_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public String getUsername() {
            return this.username_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public ByteString getUsernameBytes() {
            return ByteString.copyFromUtf8(this.username_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public int getVersion() {
            return this.version_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public boolean hasCapath() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public boolean hasDeviceType() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public boolean hasExtBuffer() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public boolean hasIncludeDevLog() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public boolean hasProductId() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public boolean hasToken() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public boolean hasUin() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
        public boolean hasUsername() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.IlinkUploadLogInfoOrBuilder
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

    /* loaded from: classes7.dex */
    public static final class InitParameter extends GeneratedMessageLite<InitParameter, Builder> implements InitParameterOrBuilder {
        public static final int AUTH_TYPE_FIELD_NUMBER = 5;
        public static final int DEBUG_IP_FIELD_NUMBER = 9;
        public static final int DEBUG_NET_FIELD_NUMBER = 7;
        private static final InitParameter DEFAULT_INSTANCE;
        public static final int DEVICE_ID_FIELD_NUMBER = 2;
        public static final int DEVICE_SIGNATURE_FIELD_NUMBER = 3;
        public static final int LOGPATH_FIELD_NUMBER = 8;
        private static volatile bg<InitParameter> PARSER = null;
        public static final int PRODUCT_ID_FIELD_NUMBER = 1;
        public static final int RUNNING_MODE_FIELD_NUMBER = 10;
        public static final int SIGNATURE_TIMESTAMP_FIELD_NUMBER = 6;
        public static final int SIGNATURE_VERSION_FIELD_NUMBER = 4;
        public static final int USE_IOTDOMAIN_FIELD_NUMBER = 11;
        private int authType_;
        private int bitField0_;
        private int debugNet_;
        private int productId_;
        private int runningMode_;
        private int signatureTimestamp_;
        private int signatureVersion_;
        private boolean useIotdomain_;
        private byte memoizedIsInitialized = 2;
        private String deviceId_ = "";
        private String deviceSignature_ = "";
        private String logpath_ = "";
        private String debugIp_ = "";

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<InitParameter, Builder> implements InitParameterOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAuthType() {
                copyOnWrite();
                ((InitParameter) this.instance).clearAuthType();
                return this;
            }

            public Builder clearDebugIp() {
                copyOnWrite();
                ((InitParameter) this.instance).clearDebugIp();
                return this;
            }

            public Builder clearDebugNet() {
                copyOnWrite();
                ((InitParameter) this.instance).clearDebugNet();
                return this;
            }

            public Builder clearDeviceId() {
                copyOnWrite();
                ((InitParameter) this.instance).clearDeviceId();
                return this;
            }

            public Builder clearDeviceSignature() {
                copyOnWrite();
                ((InitParameter) this.instance).clearDeviceSignature();
                return this;
            }

            public Builder clearLogpath() {
                copyOnWrite();
                ((InitParameter) this.instance).clearLogpath();
                return this;
            }

            public Builder clearProductId() {
                copyOnWrite();
                ((InitParameter) this.instance).clearProductId();
                return this;
            }

            public Builder clearRunningMode() {
                copyOnWrite();
                ((InitParameter) this.instance).clearRunningMode();
                return this;
            }

            public Builder clearSignatureTimestamp() {
                copyOnWrite();
                ((InitParameter) this.instance).clearSignatureTimestamp();
                return this;
            }

            public Builder clearSignatureVersion() {
                copyOnWrite();
                ((InitParameter) this.instance).clearSignatureVersion();
                return this;
            }

            public Builder clearUseIotdomain() {
                copyOnWrite();
                ((InitParameter) this.instance).clearUseIotdomain();
                return this;
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public int getAuthType() {
                return ((InitParameter) this.instance).getAuthType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public String getDebugIp() {
                return ((InitParameter) this.instance).getDebugIp();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public ByteString getDebugIpBytes() {
                return ((InitParameter) this.instance).getDebugIpBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public int getDebugNet() {
                return ((InitParameter) this.instance).getDebugNet();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public String getDeviceId() {
                return ((InitParameter) this.instance).getDeviceId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public ByteString getDeviceIdBytes() {
                return ((InitParameter) this.instance).getDeviceIdBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public String getDeviceSignature() {
                return ((InitParameter) this.instance).getDeviceSignature();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public ByteString getDeviceSignatureBytes() {
                return ((InitParameter) this.instance).getDeviceSignatureBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public String getLogpath() {
                return ((InitParameter) this.instance).getLogpath();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public ByteString getLogpathBytes() {
                return ((InitParameter) this.instance).getLogpathBytes();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public int getProductId() {
                return ((InitParameter) this.instance).getProductId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public int getRunningMode() {
                return ((InitParameter) this.instance).getRunningMode();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public int getSignatureTimestamp() {
                return ((InitParameter) this.instance).getSignatureTimestamp();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public int getSignatureVersion() {
                return ((InitParameter) this.instance).getSignatureVersion();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean getUseIotdomain() {
                return ((InitParameter) this.instance).getUseIotdomain();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasAuthType() {
                return ((InitParameter) this.instance).hasAuthType();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasDebugIp() {
                return ((InitParameter) this.instance).hasDebugIp();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasDebugNet() {
                return ((InitParameter) this.instance).hasDebugNet();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasDeviceId() {
                return ((InitParameter) this.instance).hasDeviceId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasDeviceSignature() {
                return ((InitParameter) this.instance).hasDeviceSignature();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasLogpath() {
                return ((InitParameter) this.instance).hasLogpath();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasProductId() {
                return ((InitParameter) this.instance).hasProductId();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasRunningMode() {
                return ((InitParameter) this.instance).hasRunningMode();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasSignatureTimestamp() {
                return ((InitParameter) this.instance).hasSignatureTimestamp();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasSignatureVersion() {
                return ((InitParameter) this.instance).hasSignatureVersion();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
            public boolean hasUseIotdomain() {
                return ((InitParameter) this.instance).hasUseIotdomain();
            }

            public Builder setAuthType(int i3) {
                copyOnWrite();
                ((InitParameter) this.instance).setAuthType(i3);
                return this;
            }

            public Builder setDebugIp(String str) {
                copyOnWrite();
                ((InitParameter) this.instance).setDebugIp(str);
                return this;
            }

            public Builder setDebugIpBytes(ByteString byteString) {
                copyOnWrite();
                ((InitParameter) this.instance).setDebugIpBytes(byteString);
                return this;
            }

            public Builder setDebugNet(int i3) {
                copyOnWrite();
                ((InitParameter) this.instance).setDebugNet(i3);
                return this;
            }

            public Builder setDeviceId(String str) {
                copyOnWrite();
                ((InitParameter) this.instance).setDeviceId(str);
                return this;
            }

            public Builder setDeviceIdBytes(ByteString byteString) {
                copyOnWrite();
                ((InitParameter) this.instance).setDeviceIdBytes(byteString);
                return this;
            }

            public Builder setDeviceSignature(String str) {
                copyOnWrite();
                ((InitParameter) this.instance).setDeviceSignature(str);
                return this;
            }

            public Builder setDeviceSignatureBytes(ByteString byteString) {
                copyOnWrite();
                ((InitParameter) this.instance).setDeviceSignatureBytes(byteString);
                return this;
            }

            public Builder setLogpath(String str) {
                copyOnWrite();
                ((InitParameter) this.instance).setLogpath(str);
                return this;
            }

            public Builder setLogpathBytes(ByteString byteString) {
                copyOnWrite();
                ((InitParameter) this.instance).setLogpathBytes(byteString);
                return this;
            }

            public Builder setProductId(int i3) {
                copyOnWrite();
                ((InitParameter) this.instance).setProductId(i3);
                return this;
            }

            public Builder setRunningMode(int i3) {
                copyOnWrite();
                ((InitParameter) this.instance).setRunningMode(i3);
                return this;
            }

            public Builder setSignatureTimestamp(int i3) {
                copyOnWrite();
                ((InitParameter) this.instance).setSignatureTimestamp(i3);
                return this;
            }

            public Builder setSignatureVersion(int i3) {
                copyOnWrite();
                ((InitParameter) this.instance).setSignatureVersion(i3);
                return this;
            }

            public Builder setUseIotdomain(boolean z16) {
                copyOnWrite();
                ((InitParameter) this.instance).setUseIotdomain(z16);
                return this;
            }

            Builder() {
                super(InitParameter.DEFAULT_INSTANCE);
            }
        }

        static {
            InitParameter initParameter = new InitParameter();
            DEFAULT_INSTANCE = initParameter;
            GeneratedMessageLite.registerDefaultInstance(InitParameter.class, initParameter);
        }

        InitParameter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAuthType() {
            this.bitField0_ &= -17;
            this.authType_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDebugIp() {
            this.bitField0_ &= -257;
            this.debugIp_ = getDefaultInstance().getDebugIp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDebugNet() {
            this.bitField0_ &= -65;
            this.debugNet_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceId() {
            this.bitField0_ &= -3;
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeviceSignature() {
            this.bitField0_ &= -5;
            this.deviceSignature_ = getDefaultInstance().getDeviceSignature();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLogpath() {
            this.bitField0_ &= -129;
            this.logpath_ = getDefaultInstance().getLogpath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProductId() {
            this.bitField0_ &= -2;
            this.productId_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRunningMode() {
            this.bitField0_ &= -513;
            this.runningMode_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSignatureTimestamp() {
            this.bitField0_ &= -33;
            this.signatureTimestamp_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSignatureVersion() {
            this.bitField0_ &= -9;
            this.signatureVersion_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUseIotdomain() {
            this.bitField0_ &= -1025;
            this.useIotdomain_ = false;
        }

        public static InitParameter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static InitParameter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (InitParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InitParameter parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<InitParameter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAuthType(int i3) {
            this.bitField0_ |= 16;
            this.authType_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDebugIp(String str) {
            str.getClass();
            this.bitField0_ |= 256;
            this.debugIp_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDebugIpBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 256;
            this.debugIp_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDebugNet(int i3) {
            this.bitField0_ |= 64;
            this.debugNet_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceId(String str) {
            str.getClass();
            this.bitField0_ |= 2;
            this.deviceId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceIdBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 2;
            this.deviceId_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceSignature(String str) {
            str.getClass();
            this.bitField0_ |= 4;
            this.deviceSignature_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeviceSignatureBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 4;
            this.deviceSignature_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogpath(String str) {
            str.getClass();
            this.bitField0_ |= 128;
            this.logpath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLogpathBytes(ByteString byteString) {
            byteString.getClass();
            this.bitField0_ |= 128;
            this.logpath_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProductId(int i3) {
            this.bitField0_ |= 1;
            this.productId_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRunningMode(int i3) {
            this.bitField0_ |= 512;
            this.runningMode_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSignatureTimestamp(int i3) {
            this.bitField0_ |= 32;
            this.signatureTimestamp_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSignatureVersion(int i3) {
            this.bitField0_ |= 8;
            this.signatureVersion_ = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUseIotdomain(boolean z16) {
            this.bitField0_ |= 1024;
            this.useIotdomain_ = z16;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i3 = 1;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new InitParameter();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0004\u0001\u050b\u0000\u0002\u0508\u0001\u0003\u0508\u0002\u0004\u050b\u0003\u0005\u000b\u0004\u0006\u000b\u0005\u0007\u000b\u0006\b\b\u0007\t\b\b\n\u000b\t\u000b\u0007\n", new Object[]{"bitField0_", "productId_", "deviceId_", "deviceSignature_", "signatureVersion_", "authType_", "signatureTimestamp_", "debugNet_", "logpath_", "debugIp_", "runningMode_", "useIotdomain_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<InitParameter> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (InitParameter.class) {
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public int getAuthType() {
            return this.authType_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public String getDebugIp() {
            return this.debugIp_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public ByteString getDebugIpBytes() {
            return ByteString.copyFromUtf8(this.debugIp_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public int getDebugNet() {
            return this.debugNet_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public String getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public ByteString getDeviceIdBytes() {
            return ByteString.copyFromUtf8(this.deviceId_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public String getDeviceSignature() {
            return this.deviceSignature_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public ByteString getDeviceSignatureBytes() {
            return ByteString.copyFromUtf8(this.deviceSignature_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public String getLogpath() {
            return this.logpath_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public ByteString getLogpathBytes() {
            return ByteString.copyFromUtf8(this.logpath_);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public int getProductId() {
            return this.productId_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public int getRunningMode() {
            return this.runningMode_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public int getSignatureTimestamp() {
            return this.signatureTimestamp_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public int getSignatureVersion() {
            return this.signatureVersion_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean getUseIotdomain() {
            return this.useIotdomain_;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasAuthType() {
            if ((this.bitField0_ & 16) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasDebugIp() {
            if ((this.bitField0_ & 256) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasDebugNet() {
            if ((this.bitField0_ & 64) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasDeviceId() {
            if ((this.bitField0_ & 2) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasDeviceSignature() {
            if ((this.bitField0_ & 4) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasLogpath() {
            if ((this.bitField0_ & 128) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasProductId() {
            if ((this.bitField0_ & 1) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasRunningMode() {
            if ((this.bitField0_ & 512) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasSignatureTimestamp() {
            if ((this.bitField0_ & 32) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasSignatureVersion() {
            if ((this.bitField0_ & 8) != 0) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.InitParameterOrBuilder
        public boolean hasUseIotdomain() {
            if ((this.bitField0_ & 1024) != 0) {
                return true;
            }
            return false;
        }

        public static Builder newBuilder(InitParameter initParameter) {
            return DEFAULT_INSTANCE.createBuilder(initParameter);
        }

        public static InitParameter parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (InitParameter) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static InitParameter parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static InitParameter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static InitParameter parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static InitParameter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static InitParameter parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static InitParameter parseFrom(InputStream inputStream) throws IOException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static InitParameter parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static InitParameter parseFrom(k kVar) throws IOException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static InitParameter parseFrom(k kVar, t tVar) throws IOException {
            return (InitParameter) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface InitParameterOrBuilder extends av {
        int getAuthType();

        String getDebugIp();

        ByteString getDebugIpBytes();

        int getDebugNet();

        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getDeviceSignature();

        ByteString getDeviceSignatureBytes();

        String getLogpath();

        ByteString getLogpathBytes();

        int getProductId();

        int getRunningMode();

        int getSignatureTimestamp();

        int getSignatureVersion();

        boolean getUseIotdomain();

        boolean hasAuthType();

        boolean hasDebugIp();

        boolean hasDebugNet();

        boolean hasDeviceId();

        boolean hasDeviceSignature();

        boolean hasLogpath();

        boolean hasProductId();

        boolean hasRunningMode();

        boolean hasSignatureTimestamp();

        boolean hasSignatureVersion();

        boolean hasUseIotdomain();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    /* loaded from: classes7.dex */
    public static final class ServerIplist extends GeneratedMessageLite<ServerIplist, Builder> implements ServerIplistOrBuilder {
        private static final ServerIplist DEFAULT_INSTANCE;
        private static volatile bg<ServerIplist> PARSER = null;
        public static final int SVRIPLIST_FIELD_NUMBER = 1;
        private ad.j<String> svriplist_ = GeneratedMessageLite.emptyProtobufList();

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.a<ServerIplist, Builder> implements ServerIplistOrBuilder {
            public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllSvriplist(Iterable<String> iterable) {
                copyOnWrite();
                ((ServerIplist) this.instance).addAllSvriplist(iterable);
                return this;
            }

            public Builder addSvriplist(String str) {
                copyOnWrite();
                ((ServerIplist) this.instance).addSvriplist(str);
                return this;
            }

            public Builder addSvriplistBytes(ByteString byteString) {
                copyOnWrite();
                ((ServerIplist) this.instance).addSvriplistBytes(byteString);
                return this;
            }

            public Builder clearSvriplist() {
                copyOnWrite();
                ((ServerIplist) this.instance).clearSvriplist();
                return this;
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.ServerIplistOrBuilder
            public String getSvriplist(int i3) {
                return ((ServerIplist) this.instance).getSvriplist(i3);
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.ServerIplistOrBuilder
            public ByteString getSvriplistBytes(int i3) {
                return ((ServerIplist) this.instance).getSvriplistBytes(i3);
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.ServerIplistOrBuilder
            public int getSvriplistCount() {
                return ((ServerIplist) this.instance).getSvriplistCount();
            }

            @Override // com.tencent.ilinkservice.IlinkServiceProto.ServerIplistOrBuilder
            public List<String> getSvriplistList() {
                return Collections.unmodifiableList(((ServerIplist) this.instance).getSvriplistList());
            }

            public Builder setSvriplist(int i3, String str) {
                copyOnWrite();
                ((ServerIplist) this.instance).setSvriplist(i3, str);
                return this;
            }

            Builder() {
                super(ServerIplist.DEFAULT_INSTANCE);
            }
        }

        static {
            ServerIplist serverIplist = new ServerIplist();
            DEFAULT_INSTANCE = serverIplist;
            GeneratedMessageLite.registerDefaultInstance(ServerIplist.class, serverIplist);
        }

        ServerIplist() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllSvriplist(Iterable<String> iterable) {
            ensureSvriplistIsMutable();
            b.addAll((Iterable) iterable, (List) this.svriplist_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSvriplist(String str) {
            str.getClass();
            ensureSvriplistIsMutable();
            this.svriplist_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSvriplistBytes(ByteString byteString) {
            byteString.getClass();
            ensureSvriplistIsMutable();
            this.svriplist_.add(byteString.toStringUtf8());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSvriplist() {
            this.svriplist_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void ensureSvriplistIsMutable() {
            if (!this.svriplist_.z()) {
                this.svriplist_ = GeneratedMessageLite.mutableCopy(this.svriplist_);
            }
        }

        public static ServerIplist getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static ServerIplist parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ServerIplist) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServerIplist parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static bg<ServerIplist> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSvriplist(int i3, String str) {
            str.getClass();
            ensureSvriplistIsMutable();
            this.svriplist_.set(i3, str);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ServerIplist();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"svriplist_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    bg<ServerIplist> bgVar = PARSER;
                    if (bgVar == null) {
                        synchronized (ServerIplist.class) {
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

        @Override // com.tencent.ilinkservice.IlinkServiceProto.ServerIplistOrBuilder
        public String getSvriplist(int i3) {
            return this.svriplist_.get(i3);
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.ServerIplistOrBuilder
        public ByteString getSvriplistBytes(int i3) {
            return ByteString.copyFromUtf8(this.svriplist_.get(i3));
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.ServerIplistOrBuilder
        public int getSvriplistCount() {
            return this.svriplist_.size();
        }

        @Override // com.tencent.ilinkservice.IlinkServiceProto.ServerIplistOrBuilder
        public List<String> getSvriplistList() {
            return this.svriplist_;
        }

        public static Builder newBuilder(ServerIplist serverIplist) {
            return DEFAULT_INSTANCE.createBuilder(serverIplist);
        }

        public static ServerIplist parseDelimitedFrom(InputStream inputStream, t tVar) throws IOException {
            return (ServerIplist) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ServerIplist parseFrom(ByteBuffer byteBuffer, t tVar) throws InvalidProtocolBufferException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, tVar);
        }

        public static ServerIplist parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ServerIplist parseFrom(ByteString byteString, t tVar) throws InvalidProtocolBufferException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, tVar);
        }

        public static ServerIplist parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ServerIplist parseFrom(byte[] bArr, t tVar) throws InvalidProtocolBufferException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, tVar);
        }

        public static ServerIplist parseFrom(InputStream inputStream) throws IOException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ServerIplist parseFrom(InputStream inputStream, t tVar) throws IOException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, tVar);
        }

        public static ServerIplist parseFrom(k kVar) throws IOException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar);
        }

        public static ServerIplist parseFrom(k kVar, t tVar) throws IOException {
            return (ServerIplist) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, kVar, tVar);
        }
    }

    /* loaded from: classes7.dex */
    public interface ServerIplistOrBuilder extends av {
        @Override // com.google.protobuf.av, com.google.protobuf.ax
        /* synthetic */ au getDefaultInstanceForType();

        String getSvriplist(int i3);

        ByteString getSvriplistBytes(int i3);

        int getSvriplistCount();

        List<String> getSvriplistList();

        @Override // com.google.protobuf.av
        /* synthetic */ boolean isInitialized();
    }

    IlinkServiceProto() {
    }

    public static void registerAllExtensions(t tVar) {
    }
}
