package pn4;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pn4.f;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TextMsg;
import trpc.yes.common.MessageOuterClass$TimMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u0000 \u00192\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010+\u001a\u00020'\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0004H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010\"\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010 H\u0016J\u0013\u0010$\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016R\u0017\u0010+\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010,R$\u00103\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00106R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00108R\u0018\u0010;\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010:R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00108\u00a8\u0006?"}, d2 = {"Lpn4/g;", "Lcom/tencent/timi/game/tim/api/message/a;", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", ReportConstant.COSTREPORT_PREFIX, "", "id", "", "l", "", "type", "time", "Lcom/tencent/timi/game/tim/api/message/MsgStatus;", h.F, "status", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "c", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "a", "g", "j", "f", "", "b", "i", "data", "k", "p", "value", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "d", "e", "other", "equals", "hashCode", "o", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "r", "()Lcom/tencent/imsdk/v2/V2TIMMessage;", "v2TIMMessage", "Ljava/lang/String;", "TAG", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "getContent", "()Ltrpc/yes/common/MessageOuterClass$MsgContent;", "setContent", "(Ltrpc/yes/common/MessageOuterClass$MsgContent;)V", "content", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "msgRecord", "Lcom/tencent/timi/game/tim/api/message/MsgStatus;", "innerStatus", "J", "timeDebug", "Ljava/lang/Object;", "memData", "createTimeStamp", "<init>", "(Lcom/tencent/imsdk/v2/V2TIMMessage;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class g implements com.tencent.timi.game.tim.api.message.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final V2TIMMessage v2TIMMessage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageOuterClass$MsgContent content;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageOuterClass$TimMsgBody msgRecord;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgStatus innerStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long timeDebug;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object memData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long createTimeStamp;

    public g(@NotNull V2TIMMessage v2TIMMessage) {
        Intrinsics.checkNotNullParameter(v2TIMMessage, "v2TIMMessage");
        this.v2TIMMessage = v2TIMMessage;
        this.TAG = "MessageInfo";
        this.createTimeStamp = yn4.d.d() / 1000;
        this.timeDebug = v2TIMMessage.getTimestamp() * 1000;
    }

    private final MessageOuterClass$TimMsgBody s() {
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody;
        if (this.v2TIMMessage.getElemType() != 2) {
            return new MessageOuterClass$TimMsgBody();
        }
        if (this.msgRecord == null) {
            try {
                messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody().mergeFrom(PluginBaseInfoHelper.Base64Helper.decode(this.v2TIMMessage.getCustomElem().getData(), 2));
            } catch (InvalidProtocolBufferMicroException unused) {
                l.i(this.TAG, "parse error:" + this.v2TIMMessage.getCustomElem());
                messageOuterClass$TimMsgBody = new MessageOuterClass$TimMsgBody();
                messageOuterClass$TimMsgBody.msg_type.set(1);
                MessageOuterClass$MsgContent messageOuterClass$MsgContent = messageOuterClass$TimMsgBody.content;
                MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = new MessageOuterClass$MsgContent();
                MessageOuterClass$TextMsg messageOuterClass$TextMsg = messageOuterClass$MsgContent2.text_msg;
                MessageOuterClass$TextMsg messageOuterClass$TextMsg2 = new MessageOuterClass$TextMsg();
                messageOuterClass$TextMsg2.text.set("[\u6536\u5230\u4e00\u6761\u6d88\u606f\uff0c\u5f53\u524d\u7248\u672c\u4e0d\u652f\u6301\u67e5\u770b\uff0c\u8bf7\u66f4\u65b0\u81f3\u65b0\u7248\u672c]");
                messageOuterClass$TextMsg.set(messageOuterClass$TextMsg2);
                messageOuterClass$MsgContent.set(messageOuterClass$MsgContent2);
            }
            this.msgRecord = messageOuterClass$TimMsgBody;
        }
        MessageOuterClass$TimMsgBody messageOuterClass$TimMsgBody2 = this.msgRecord;
        Intrinsics.checkNotNull(messageOuterClass$TimMsgBody2);
        return messageOuterClass$TimMsgBody2;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    @NotNull
    public MessageOuterClass$MsgContent a() {
        MessageOuterClass$MsgContent messageOuterClass$MsgContent;
        if (this.content == null) {
            if (this.v2TIMMessage.getElemType() == 1) {
                f.Companion companion = f.INSTANCE;
                String text = this.v2TIMMessage.getTextElem().getText();
                Intrinsics.checkNotNullExpressionValue(text, "v2TIMMessage.textElem.text");
                messageOuterClass$MsgContent = companion.a(text);
            } else {
                messageOuterClass$MsgContent = s().content;
            }
            this.content = messageOuterClass$MsgContent;
        }
        MessageOuterClass$MsgContent messageOuterClass$MsgContent2 = this.content;
        if (messageOuterClass$MsgContent2 == null) {
            return new MessageOuterClass$MsgContent();
        }
        return messageOuterClass$MsgContent2;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public boolean b() {
        return this.v2TIMMessage.isSelf();
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    @NotNull
    public CommonOuterClass$QQUserId c() {
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = s().from_user;
        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "msgRecord().from_user");
        return commonOuterClass$QQUserId;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    @Nullable
    /* renamed from: d, reason: from getter */
    public Object getMemData() {
        return this.memData;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public void e(@Nullable Object data) {
        this.memData = data;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(g.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.timi.game.tim.api.impl.message.MsgInfo");
        if (Intrinsics.areEqual(id(), ((g) other).id())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public long f() {
        ULong uLongOrNull;
        String userID = this.v2TIMMessage.getUserID();
        if (userID != null && (uLongOrNull = UStringsKt.toULongOrNull(userID)) != null) {
            return uLongOrNull.getData();
        }
        return 0L;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    @NotNull
    public String g() {
        String str = s().update_text.get();
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord().update_text.get()");
        return str;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    @NotNull
    public MsgStatus h() {
        MsgStatus msgStatus = this.innerStatus;
        if (msgStatus != null) {
            Intrinsics.checkNotNull(msgStatus);
            return msgStatus;
        }
        int status = this.v2TIMMessage.getStatus();
        if (status != 1) {
            if (status != 2) {
                if (status != 3) {
                    if (status != 4) {
                        if (status != 6) {
                            return MsgStatus.SUCCESS;
                        }
                        return MsgStatus.REVOKE;
                    }
                    return MsgStatus.DELETE;
                }
                return MsgStatus.FAILED;
            }
            return MsgStatus.SUCCESS;
        }
        return MsgStatus.SENDING;
    }

    public int hashCode() {
        return this.v2TIMMessage.hashCode();
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public boolean i() {
        if (j() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    @NotNull
    public String id() {
        String msgID = this.v2TIMMessage.getMsgID();
        Intrinsics.checkNotNullExpressionValue(msgID, "v2TIMMessage.msgID");
        return msgID;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public long j() {
        ULong uLongOrNull;
        String groupID = this.v2TIMMessage.getGroupID();
        if (groupID != null && (uLongOrNull = UStringsKt.toULongOrNull(groupID)) != null) {
            return uLongOrNull.getData();
        }
        return 0L;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public void k(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.v2TIMMessage.setLocalCustomData(data);
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public long l() {
        return this.v2TIMMessage.getSeq();
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public int m() {
        return this.v2TIMMessage.getLocalCustomInt();
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public void n(int value) {
        this.v2TIMMessage.setLocalCustomInt(value);
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public int o() {
        MessageOuterClass$TimMsgBody s16 = s();
        if (s16.content.text_msg.has()) {
            String a16 = com.tencent.mobileqq.qqlive.widget.util.c.a(s16.content.text_msg.text.get());
            if (QQEmojiUtil.containsEmoji(a16) || TextUtils.hasSysEmotion(a16)) {
                return 0;
            }
        }
        if (s16.content.timi_emo_msg.msg_data.has()) {
            return s16.content.timi_emo_msg.msg_data.type.get();
        }
        return -1;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    @Nullable
    public String p() {
        return this.v2TIMMessage.getLocalCustomData();
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public void q(@NotNull MsgStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.innerStatus = status;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final V2TIMMessage getV2TIMMessage() {
        return this.v2TIMMessage;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public long time() {
        long j3;
        if (this.v2TIMMessage.getTimestamp() != 0) {
            j3 = this.v2TIMMessage.getTimestamp();
        } else {
            j3 = this.createTimeStamp;
        }
        return j3 * 1000;
    }

    @Override // com.tencent.timi.game.tim.api.message.a
    public int type() {
        if (this.v2TIMMessage.getElemType() != 2 || !s().msg_type.has()) {
            return 1;
        }
        return s().msg_type.get();
    }
}
