package com.tencent.guild.api.data.msglist;

import android.text.TextUtils;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qr0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0001aB\u000f\u0012\u0006\u0010;\u001a\u00020\u0017\u00a2\u0006\u0004\b^\u0010_J8\u0010\t\u001a\u00020\b2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0000H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0000H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0000H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u0000H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0001H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u0006\u0010\u001c\u001a\u00020\bJ\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\b\u0010\"\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0001H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0001H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020&H\u0016J\u0010\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020\u0012J\u0006\u0010,\u001a\u00020\bJ\u000e\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u000e\u00100\u001a\u00020-2\u0006\u0010/\u001a\u00020\bJ\u001a\u00104\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u000201J\u0012\u00106\u001a\u0004\u0018\u0001052\u0006\u0010#\u001a\u00020\u0001H\u0016J\u0016\u00108\u001a\u00020-2\u0006\u00102\u001a\u0002012\u0006\u00107\u001a\u000201J\u000e\u00109\u001a\u00020-2\u0006\u00102\u001a\u000201J\u0006\u0010:\u001a\u000201R\u0017\u0010;\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0018\u0010?\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010I\u001a\u00020H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010]R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010]\u00a8\u0006b"}, d2 = {"Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/aio/data/msglist/a;", "Ljava/io/Serializable;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgEmojiLikes;", "Lkotlin/collections/ArrayList;", "list1", "list2", "", "o", "newItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "targetMsgItem", DomainData.DOMAIN_NAME, "p", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "k", "", "j", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/LocalGrayTipElement;", "localGrayTipElement", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "cloneNewInstanceWithMsgRecord", "cloneNewInstance", "getViewType", "isReviewingMsg", "isGrayTipMsg", "isWalletMsg", "isLocalSend", "banConvertViewType", "isMixMsg", "isSelf", "target", "isSameContent", "isSameItem", "", "getMsgSeq", "getMsgId", "type", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "getFirstTypeElement", "isNeedCombine", "", "setIsNeedCombine", "isLastMsgNeedCombine", "setIsLastMsgNeedCombine", "", "key", "default", "getExtInfoFromExtStr", "", "getChangePayload", "value", "saveExtInfoToExtStr", "removeExtInfoToExtStr", "getSimpleDebugInfo", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsgRecord", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", AppConstants.Key.COLUMN_EXT_STR, "Ljava/lang/String;", "Lorg/json/JSONObject;", "extJsonObject", "Lorg/json/JSONObject;", "getExtJsonObject", "()Lorg/json/JSONObject;", "setExtJsonObject", "(Lorg/json/JSONObject;)V", "", "radii", "[F", "getRadii", "()[F", "setRadii", "([F)V", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileTransNotifyInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "getFileTransNotifyInfo", "()Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "setFileTransNotifyInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;)V", "Lcom/tencent/guild/api/data/msglist/c;", "preParseInfo", "Lcom/tencent/guild/api/data/msglist/c;", "getPreParseInfo", "()Lcom/tencent/guild/api/data/msglist/c;", "setPreParseInfo", "(Lcom/tencent/guild/api/data/msglist/c;)V", "Z", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "Companion", "a", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildMsgItem extends com.tencent.aio.data.msglist.a implements Serializable {

    @NotNull
    public static final String NICK_FRIEND = "friend";

    @NotNull
    public static final String NICK_SELF = "self";
    public static final long ROBOT_MSG_FLAG = 3161;

    @NotNull
    public static final String TAG = "GuildMsgItem";

    @Nullable
    private JSONObject extJsonObject;

    @Nullable
    private String extStr;

    @NotNull
    private FileTransNotifyInfo fileTransNotifyInfo;
    private boolean isLastMsgNeedCombine;
    private boolean isNeedCombine;

    @NotNull
    private final MsgRecord msgRecord;

    @NotNull
    private c preParseInfo;

    @NotNull
    private float[] radii;

    public GuildMsgItem(@NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        this.msgRecord = msgRecord;
        this.radii = new float[]{18.0f, 18.0f, 18.0f, 18.0f, 18.0f, 18.0f, 18.0f, 18.0f};
        this.fileTransNotifyInfo = new FileTransNotifyInfo();
        this.preParseInfo = new c();
    }

    public static /* synthetic */ String getExtInfoFromExtStr$default(GuildMsgItem guildMsgItem, String str, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                str2 = "";
            }
            return guildMsgItem.getExtInfoFromExtStr(str, str2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getExtInfoFromExtStr");
    }

    private final int j() {
        GrayTipElement grayTipElement;
        int i3;
        MsgElement firstTypeElement = getFirstTypeElement(8);
        if (firstTypeElement == null || (grayTipElement = firstTypeElement.grayTipElement) == null) {
            return 0;
        }
        int i16 = grayTipElement.subElementType;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 7) {
                        if (i16 != 12) {
                            if (i16 != 13) {
                                return 0;
                            }
                            i3 = l(grayTipElement.localGrayTipElement);
                        } else {
                            i3 = 56;
                        }
                    } else {
                        i3 = 51;
                    }
                } else {
                    i3 = 49;
                }
            } else {
                i3 = 57;
            }
        } else {
            i3 = 50;
        }
        return i3;
    }

    private final ReplyElement k(GuildMsgItem msgItem) {
        ReplyElement replyElement;
        ArrayList<MsgElement> arrayList = msgItem.msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 7 && (replyElement = msgElement.replyElement) != null) {
                return replyElement;
            }
        }
        return null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0005. Please report as an issue. */
    private final int l(LocalGrayTipElement localGrayTipElement) {
        int i3;
        if (localGrayTipElement == null) {
            return 0;
        }
        switch (localGrayTipElement.type) {
            case 1:
                i3 = 52;
                return i3;
            case 2:
                i3 = 53;
                return i3;
            case 3:
                i3 = 54;
                return i3;
            case 4:
                i3 = 55;
                return i3;
            case 5:
                i3 = 64;
                return i3;
            case 6:
                i3 = 65;
                return i3;
            case 7:
                i3 = 82;
                return i3;
            case 8:
                i3 = 56;
                return i3;
            case 9:
                i3 = 84;
                return i3;
            default:
                return 0;
        }
    }

    private final boolean m(GuildMsgItem newItem) {
        if (Intrinsics.areEqual(getExtInfoFromExtStr$default(newItem, "guild_current_msg_combine_status", null, 2, null), getExtInfoFromExtStr$default(this, "guild_current_msg_combine_status", null, 2, null)) && Intrinsics.areEqual(getExtInfoFromExtStr$default(newItem, "guild_last_msg_combine_status", null, 2, null), getExtInfoFromExtStr$default(this, "guild_last_msg_combine_status", null, 2, null))) {
            return false;
        }
        return true;
    }

    private final boolean n(GuildMsgItem targetMsgItem) {
        if (this.msgRecord.msgType != 9 || targetMsgItem.msgRecord.msgType != 9) {
            return false;
        }
        ReplyElement k3 = k(this);
        ReplyElement k16 = k(targetMsgItem);
        if (k3 == null || k16 == null || Intrinsics.areEqual(k3.replayMsgRootCommentCnt, k16.replayMsgRootCommentCnt)) {
            return false;
        }
        return true;
    }

    private final boolean o(ArrayList<MsgEmojiLikes> list1, ArrayList<MsgEmojiLikes> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        int i3 = 0;
        for (Object obj : list1) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MsgEmojiLikes msgEmojiLikes = list2.get(i3);
            Intrinsics.checkNotNullExpressionValue(msgEmojiLikes, "list2[index]");
            if (!qr0.c.l((MsgEmojiLikes) obj, msgEmojiLikes)) {
                return false;
            }
            i3 = i16;
        }
        return true;
    }

    private final boolean p(GuildMsgItem targetMsgItem) {
        if (this.msgRecord.msgType != 9 || targetMsgItem.msgRecord.msgType != 9) {
            return false;
        }
        ReplyElement k3 = k(this);
        ReplyElement k16 = k(targetMsgItem);
        if (k3 == null || k16 == null || k3.replyMsgRevokeType != 0 || k16.replyMsgRevokeType == 0) {
            return false;
        }
        return true;
    }

    public final boolean banConvertViewType() {
        String extInfoFromExtStr$default = getExtInfoFromExtStr$default(this, "ban_convert_view_holder_type", null, 2, null);
        if (TextUtils.isEmpty(extInfoFromExtStr$default) || !StringsKt.equals$default(extInfoFromExtStr$default, "1", false, 2, null)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.aio.data.msglist.a
    @NotNull
    public com.tencent.aio.data.msglist.a cloneNewInstance() {
        GuildMsgItem guildMsgItem = new GuildMsgItem(this.msgRecord);
        guildMsgItem.extStr = this.extStr;
        guildMsgItem.extJsonObject = this.extJsonObject;
        guildMsgItem.isNeedCombine = this.isNeedCombine;
        guildMsgItem.isLastMsgNeedCombine = this.isLastMsgNeedCombine;
        guildMsgItem.fileTransNotifyInfo = this.fileTransNotifyInfo;
        guildMsgItem.preParseInfo = this.preParseInfo;
        return guildMsgItem;
    }

    @NotNull
    public com.tencent.aio.data.msglist.a cloneNewInstanceWithMsgRecord(@NotNull MsgRecord targetMsgRecord) {
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        GuildMsgItem guildMsgItem = new GuildMsgItem(targetMsgRecord);
        guildMsgItem.extStr = this.extStr;
        guildMsgItem.extJsonObject = this.extJsonObject;
        guildMsgItem.isNeedCombine = this.isNeedCombine;
        guildMsgItem.isLastMsgNeedCombine = this.isLastMsgNeedCombine;
        guildMsgItem.fileTransNotifyInfo = this.fileTransNotifyInfo;
        guildMsgItem.preParseInfo = this.preParseInfo;
        return guildMsgItem;
    }

    @Override // com.tencent.aio.data.msglist.a
    @Nullable
    public Object getChangePayload(@NotNull com.tencent.aio.data.msglist.a target) {
        GuildMsgItem guildMsgItem;
        Intrinsics.checkNotNullParameter(target, "target");
        HashMap hashMap = new HashMap();
        if (target instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) target;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem != null) {
            GuildMsgItem guildMsgItem2 = (GuildMsgItem) target;
            long j3 = guildMsgItem2.msgRecord.msgTime;
            long j16 = this.msgRecord.msgTime;
            String str = TAG;
            if (j3 != j16) {
                String str2 = "getChangePayload msgId = " + getMsgId() + ", seq = " + getMsgSeq() + "msgTime =  " + guildMsgItem2.msgRecord.msgTime + ", old msgTime = " + this.msgRecord.msgTime;
                str = TAG;
                QLog.i(str, 1, str2);
                hashMap.put(GuildMsgItemPayloadType.TIME_PAYLOAD, b.g.f112500a);
            }
            if (guildMsgItem2.msgRecord.sendStatus != this.msgRecord.sendStatus) {
                QLog.i(str, 1, "getChangePayload msgId = " + getMsgId() + ", seq = " + getMsgSeq() + "status =  " + guildMsgItem2.msgRecord.sendStatus + ", old status = " + this.msgRecord.sendStatus);
                hashMap.put(GuildMsgItemPayloadType.STATUS_PAYLOAD, new b.GuildMsgItemStatusPayload(guildMsgItem2.msgRecord.sendStatus));
            }
            ArrayList<MsgEmojiLikes> arrayList = guildMsgItem2.msgRecord.emojiLikesList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "target.msgRecord.emojiLikesList");
            ArrayList<MsgEmojiLikes> arrayList2 = this.msgRecord.emojiLikesList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.emojiLikesList");
            if (!o(arrayList, arrayList2)) {
                hashMap.put(GuildMsgItemPayloadType.REACTION_PAYLOAD, b.c.f112496a);
            }
            if (!qr0.c.d(this.fileTransNotifyInfo, guildMsgItem2.fileTransNotifyInfo)) {
                hashMap.put(GuildMsgItemPayloadType.RICH_MEDIA_PAYLOAD, new b.GuildMsgItemRichMediaPayload(guildMsgItem2.fileTransNotifyInfo));
            }
            if (n(guildMsgItem2)) {
                hashMap.put(GuildMsgItemPayloadType.REPLAY_MSG_COMMENT_COUNT_PAYLOAD, b.C1218b.f112495a);
            }
            if (p(guildMsgItem2)) {
                hashMap.put(GuildMsgItemPayloadType.REPLY_MSG_REVOKED_PAYLOAD, b.d.f112497a);
            }
            if (m(guildMsgItem2)) {
                hashMap.put(GuildMsgItemPayloadType.COMBINE_PAYLOAD, b.a.f112494a);
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    @Nullable
    public final String getExtInfoFromExtStr(@NotNull String key, @NotNull String r56) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(r56, "default");
        if (this.extStr != null) {
            try {
                if (this.extJsonObject == null) {
                    this.extJsonObject = new JSONObject(this.extStr);
                }
                JSONObject jSONObject = this.extJsonObject;
                Intrinsics.checkNotNull(jSONObject);
                if (jSONObject.has(key)) {
                    JSONObject jSONObject2 = this.extJsonObject;
                    Intrinsics.checkNotNull(jSONObject2);
                    return jSONObject2.getString(key);
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "extStr error", e16);
            }
        }
        return r56;
    }

    @Nullable
    public final JSONObject getExtJsonObject() {
        return this.extJsonObject;
    }

    @NotNull
    public final FileTransNotifyInfo getFileTransNotifyInfo() {
        return this.fileTransNotifyInfo;
    }

    @Nullable
    public final MsgElement getFirstTypeElement(int type) {
        ArrayList<MsgElement> arrayList = this.msgRecord.elements;
        if (arrayList.isEmpty()) {
            return null;
        }
        boolean z16 = false;
        MsgElement msgElement = arrayList.get(0);
        if (msgElement != null && msgElement.elementType == type) {
            z16 = true;
        }
        if (!z16) {
            return null;
        }
        return msgElement;
    }

    @Override // com.tencent.aio.data.msglist.a
    public long getMsgId() {
        return this.msgRecord.msgId;
    }

    @NotNull
    public final MsgRecord getMsgRecord() {
        return this.msgRecord;
    }

    @Override // com.tencent.aio.data.msglist.a
    public long getMsgSeq() {
        return this.msgRecord.msgSeq;
    }

    @NotNull
    public final c getPreParseInfo() {
        return this.preParseInfo;
    }

    @NotNull
    public final float[] getRadii() {
        return this.radii;
    }

    @NotNull
    public final String getSimpleDebugInfo() {
        String str;
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        sb5.append("seq: " + getMsgSeq() + ", ");
        sb5.append("cntSeq: " + this.msgRecord.cntSeq + ", ");
        sb5.append("id: " + getMsgId() + ", ");
        sb5.append("type: " + this.msgRecord.msgType + ", ");
        sb5.append("subMsgType: " + this.msgRecord.subMsgType + ", ");
        sb5.append("time: " + this.msgRecord.msgTime + ", ");
        sb5.append("sendType: " + this.msgRecord.sendType + ", ");
        sb5.append("senderUid: " + this.msgRecord.senderUid + ", ");
        sb5.append("peerUid: " + this.msgRecord.peerUid + ", ");
        sb5.append("channelId: " + this.msgRecord.channelId + ", ");
        sb5.append("sendStatus: " + this.msgRecord.sendStatus + ", ");
        sb5.append("roleId: " + this.msgRecord.roleId + ", ");
        sb5.append("roleType: " + this.msgRecord.roleType + ", ");
        Intrinsics.checkNotNullExpressionValue(this.msgRecord.elements, "msgRecord.elements");
        if (!r1.isEmpty()) {
            Iterator<MsgElement> it = this.msgRecord.elements.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MsgElement next = it.next();
                TextElement textElement = next.textElement;
                if (textElement != null && (str = textElement.content) != null) {
                    Intrinsics.checkNotNullExpressionValue(str, "element.textElement.content");
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        sb5.append("content: " + next.textElement.content.charAt(0) + "|" + next.textElement.content.length());
                        break;
                    }
                }
            }
        }
        sb5.append("}");
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0166, code lost:
    
        if (isSelf() != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:?, code lost:
    
        return 26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0197, code lost:
    
        if (isSelf() != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x011d, code lost:
    
        if (qr0.d.c(r11) != false) goto L109;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:37:0x0094. Please report as an issue. */
    @Override // com.tencent.aio.data.msglist.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getViewType() {
        if (!TextUtils.isEmpty(getExtInfoFromExtStr$default(this, "guild_article_is_main_msg", null, 2, null)) && this.msgRecord.msgType == 1) {
            return 50;
        }
        if (!TextUtils.isEmpty(getExtInfoFromExtStr$default(this, "guild_article_is_main_empty_msg", null, 2, null))) {
            return 40;
        }
        if (!TextUtils.isEmpty(getExtInfoFromExtStr$default(this, "guild_article_is_main_reply_count_msg", null, 2, null))) {
            return 41;
        }
        if (!TextUtils.isEmpty(getExtInfoFromExtStr$default(this, "guild_yolo_game_create_team", null, 2, null))) {
            return 46;
        }
        if (!TextUtils.isEmpty(getExtInfoFromExtStr$default(this, "guild_yolo_game_result", null, 2, null))) {
            return 47;
        }
        if (!TextUtils.isEmpty(getExtInfoFromExtStr$default(this, "guild_yolo_game_system", null, 2, null))) {
            return 48;
        }
        MsgRecord msgRecord = this.msgRecord;
        int i3 = msgRecord.msgType;
        int i16 = 5;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 5) {
                    if (i3 != 7) {
                        if (i3 != 31) {
                            if (i3 != 13) {
                                i16 = 30;
                                if (i3 != 14) {
                                    if (i3 != 17) {
                                        if (i3 == 18) {
                                            return 47;
                                        }
                                        switch (i3) {
                                            case 9:
                                                if (getIsNeedCombine() && !banConvertViewType()) {
                                                    if (!isSelf()) {
                                                        break;
                                                    }
                                                    return 7;
                                                }
                                                if (!d.c(this)) {
                                                    if (isSelf()) {
                                                        return 24;
                                                    }
                                                    return 23;
                                                }
                                                break;
                                            case 10:
                                                if (isWalletMsg()) {
                                                    if (isSelf()) {
                                                        return 43;
                                                    }
                                                    return 42;
                                                }
                                                if (isSelf()) {
                                                    return 45;
                                                }
                                                return 44;
                                            case 11:
                                                ArrayList<MsgElement> arrayList = msgRecord.elements;
                                                if (arrayList != null) {
                                                    Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
                                                    if (!arrayList.isEmpty()) {
                                                        Iterator<MsgElement> it = this.msgRecord.elements.iterator();
                                                        while (it.hasNext()) {
                                                            if (it.next().textGiftElement != null) {
                                                                if (isSelf()) {
                                                                    return 31;
                                                                }
                                                                return 30;
                                                            }
                                                        }
                                                    }
                                                }
                                                if (isSelf()) {
                                                    return 34;
                                                }
                                                return 35;
                                            default:
                                                if (!isSelf()) {
                                                    return 1;
                                                }
                                                return 0;
                                        }
                                    } else {
                                        if (isSelf()) {
                                            return 37;
                                        }
                                        return 36;
                                    }
                                } else {
                                    if (isSelf()) {
                                        return 31;
                                    }
                                    return i16;
                                }
                            } else {
                                if (isSelf()) {
                                    return 22;
                                }
                                return 21;
                            }
                        }
                        return 25;
                    }
                    if (isSelf()) {
                        return 11;
                    }
                    return 10;
                }
                return j();
            }
            if (isSelf()) {
                return 9;
            }
            return 8;
        }
        if (!d.c(this)) {
            if (d.o(this)) {
                if (!isSelf()) {
                    return 6;
                }
                return 7;
            }
            if (d.m(this)) {
                if (!isSelf()) {
                    return 4;
                }
                return i16;
            }
            if (d.k(this)) {
                if (isSelf()) {
                    return 60;
                }
                return 61;
            }
            if (d.l(this)) {
                if (isSelf()) {
                    return 62;
                }
                return 63;
            }
            if (!isSelf()) {
                return 2;
            }
            return 3;
        }
    }

    public final boolean isGrayTipMsg() {
        if (this.msgRecord.msgType == 5) {
            return true;
        }
        return false;
    }

    /* renamed from: isLastMsgNeedCombine, reason: from getter */
    public final boolean getIsLastMsgNeedCombine() {
        return this.isLastMsgNeedCombine;
    }

    public final boolean isLocalSend() {
        if (this.msgRecord.sendType == 1) {
            return true;
        }
        return false;
    }

    public final boolean isMixMsg() {
        int viewType = getViewType();
        if (viewType != 2 && viewType != 3 && viewType != 60 && viewType != 61 && viewType != 62 && viewType != 63) {
            return false;
        }
        return true;
    }

    /* renamed from: isNeedCombine, reason: from getter */
    public final boolean getIsNeedCombine() {
        return this.isNeedCombine;
    }

    public final boolean isReviewingMsg() {
        if (this.msgRecord.sendStatus == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aio.data.msglist.a
    public boolean isSameContent(@NotNull com.tencent.aio.data.msglist.a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof GuildMsgItem)) {
            return false;
        }
        GuildMsgItem guildMsgItem = (GuildMsgItem) target;
        if (this.msgRecord.elements.size() != guildMsgItem.msgRecord.elements.size()) {
            return false;
        }
        int size = guildMsgItem.msgRecord.elements.size();
        for (int i3 = 0; i3 < size; i3++) {
            MsgElement msgElement = guildMsgItem.msgRecord.elements.get(i3);
            Intrinsics.checkNotNullExpressionValue(msgElement, "target.msgRecord.elements[index]");
            if (!qr0.c.k(msgElement, this.msgRecord.elements.get(i3))) {
                return false;
            }
        }
        ArrayList<MsgEmojiLikes> arrayList = guildMsgItem.msgRecord.emojiLikesList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "target.msgRecord.emojiLikesList");
        ArrayList<MsgEmojiLikes> arrayList2 = this.msgRecord.emojiLikesList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.emojiLikesList");
        if (!o(arrayList, arrayList2) || guildMsgItem.msgRecord.commentCnt != this.msgRecord.commentCnt || !Intrinsics.areEqual(this.extStr, guildMsgItem.extStr)) {
            return false;
        }
        MsgRecord msgRecord = this.msgRecord;
        int i16 = msgRecord.sendStatus;
        MsgRecord msgRecord2 = guildMsgItem.msgRecord;
        if (i16 != msgRecord2.sendStatus || msgRecord.editable != msgRecord2.editable || !qr0.c.d(this.fileTransNotifyInfo, guildMsgItem.fileTransNotifyInfo)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.aio.data.msglist.a
    public boolean isSameItem(@NotNull com.tencent.aio.data.msglist.a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof GuildMsgItem)) {
            return false;
        }
        GuildMsgItem guildMsgItem = (GuildMsgItem) target;
        if (!Intrinsics.areEqual(this.msgRecord.peerUid, guildMsgItem.msgRecord.peerUid) || !Intrinsics.areEqual(this.msgRecord.senderUid, guildMsgItem.msgRecord.senderUid) || this.msgRecord.msgId != guildMsgItem.msgRecord.msgId) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.aio.data.msglist.a
    public boolean isSelf() {
        int i3 = this.msgRecord.sendType;
        if (i3 == 1 || i3 == 2 || i3 == 4 || i3 == 6) {
            return true;
        }
        return false;
    }

    public final boolean isWalletMsg() {
        if (this.msgRecord.msgType == 10) {
            return true;
        }
        return false;
    }

    public final void removeExtInfoToExtStr(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (!TextUtils.isEmpty(this.extStr)) {
                JSONObject jSONObject = new JSONObject(this.extStr);
                if (jSONObject.has(key)) {
                    jSONObject.remove(key);
                    this.extStr = jSONObject.toString();
                    this.extJsonObject = jSONObject;
                }
                if (jSONObject.length() == 0) {
                    this.extStr = null;
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "removeExtInfoToExtStr error: " + e16.getMessage());
        }
    }

    public final void saveExtInfoToExtStr(@NotNull String key, @NotNull String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            if (TextUtils.isEmpty(this.extStr)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(key, value);
                this.extStr = jSONObject.toString();
                this.extJsonObject = jSONObject;
            } else {
                JSONObject jSONObject2 = new JSONObject(this.extStr);
                jSONObject2.put(key, value);
                this.extStr = jSONObject2.toString();
                this.extJsonObject = jSONObject2;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "saveExtInfoToExtStr error", e16);
        }
    }

    public final void setExtJsonObject(@Nullable JSONObject jSONObject) {
        this.extJsonObject = jSONObject;
    }

    public final void setFileTransNotifyInfo(@NotNull FileTransNotifyInfo fileTransNotifyInfo) {
        Intrinsics.checkNotNullParameter(fileTransNotifyInfo, "<set-?>");
        this.fileTransNotifyInfo = fileTransNotifyInfo;
    }

    public final void setIsLastMsgNeedCombine(boolean isLastMsgNeedCombine) {
        this.isLastMsgNeedCombine = isLastMsgNeedCombine;
    }

    public final void setIsNeedCombine(boolean isNeedCombine) {
        this.isNeedCombine = isNeedCombine;
    }

    public final void setPreParseInfo(@NotNull c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.preParseInfo = cVar;
    }

    public final void setRadii(@NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<set-?>");
        this.radii = fArr;
    }
}
