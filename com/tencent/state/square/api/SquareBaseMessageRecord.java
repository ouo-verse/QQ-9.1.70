package com.tencent.state.square.api;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u00103\u001a\u00020\u0000H&J\u000e\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0000J\u0006\u00107\u001a\u00020\bJ\u0006\u00108\u001a\u00020\bJ\u0006\u00109\u001a\u00020\bJ\u0006\u0010:\u001a\u00020\bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0012R\u001a\u0010*\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\n\"\u0004\b,\u0010\fR\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u0006;"}, d2 = {"Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "", "uin", "", "recordType", "Lcom/tencent/state/square/api/MessageRecordType;", "(Ljava/lang/String;Lcom/tencent/state/square/api/MessageRecordType;)V", "forbiddenNotify", "", "getForbiddenNotify", "()Z", "setForbiddenNotify", "(Z)V", "hasUnreadPtt", "getHasUnreadPtt", "setHasUnreadPtt", "lastMsg", "getLastMsg", "()Ljava/lang/String;", "setLastMsg", "(Ljava/lang/String;)V", "lastMsgUid", "", "getLastMsgUid", "()J", "setLastMsgUid", "(J)V", "lastTimeStamp", "getLastTimeStamp", "setLastTimeStamp", "nickName", "getNickName", "setNickName", "getRecordType", "()Lcom/tencent/state/square/api/MessageRecordType;", "summaryData", "Lcom/tencent/state/square/api/SummaryData;", "getSummaryData", "()Lcom/tencent/state/square/api/SummaryData;", "setSummaryData", "(Lcom/tencent/state/square/api/SummaryData;)V", "getUin", "unReadMark", "getUnReadMark", "setUnReadMark", "unreadCount", "", "getUnreadCount", "()I", "setUnreadCount", "(I)V", "copyDepth", "copyValue", "", "msg", IProfileProtocolConst.PARAM_IS_FRIEND, "isSquareLibrary", "isTroop", "isValidRecord", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public abstract class SquareBaseMessageRecord {
    private boolean forbiddenNotify;
    private boolean hasUnreadPtt;

    @Nullable
    private String lastMsg;
    private long lastMsgUid;
    private long lastTimeStamp;

    @NotNull
    private String nickName;

    @NotNull
    private final MessageRecordType recordType;

    @NotNull
    private SummaryData summaryData;

    @NotNull
    private final String uin;
    private boolean unReadMark;
    private int unreadCount;

    public SquareBaseMessageRecord(@NotNull String uin, @NotNull MessageRecordType recordType) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(recordType, "recordType");
        this.uin = uin;
        this.recordType = recordType;
        this.nickName = "";
        boolean isTroop = isTroop();
        this.summaryData = new SummaryData(false, null, this.lastMsg, 0, 0, isTroop, 27, null);
    }

    @NotNull
    public abstract SquareBaseMessageRecord copyDepth();

    public final void copyValue(@NotNull SquareBaseMessageRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        msg2.unreadCount = this.unreadCount;
        msg2.lastMsgUid = this.lastMsgUid;
        msg2.lastMsg = this.lastMsg;
        msg2.lastTimeStamp = this.lastTimeStamp;
        msg2.nickName = this.nickName;
        msg2.summaryData = this.summaryData.copyDepth();
        msg2.forbiddenNotify = this.forbiddenNotify;
        msg2.unReadMark = this.unReadMark;
        msg2.hasUnreadPtt = this.hasUnreadPtt;
    }

    public final boolean getForbiddenNotify() {
        return this.forbiddenNotify;
    }

    public final boolean getHasUnreadPtt() {
        return this.hasUnreadPtt;
    }

    @Nullable
    public final String getLastMsg() {
        return this.lastMsg;
    }

    public final long getLastMsgUid() {
        return this.lastMsgUid;
    }

    public final long getLastTimeStamp() {
        return this.lastTimeStamp;
    }

    @NotNull
    public final String getNickName() {
        return this.nickName;
    }

    @NotNull
    public MessageRecordType getRecordType() {
        return this.recordType;
    }

    @NotNull
    public final SummaryData getSummaryData() {
        return this.summaryData;
    }

    @NotNull
    public String getUin() {
        return this.uin;
    }

    public final boolean getUnReadMark() {
        return this.unReadMark;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final boolean isFriend() {
        if (getRecordType() == MessageRecordType.RECORD_TYPE_FRIEND) {
            return true;
        }
        return false;
    }

    public final boolean isSquareLibrary() {
        if (getRecordType() == MessageRecordType.RECORD_TYPE_SQUARE_TEMP) {
            return true;
        }
        return false;
    }

    public final boolean isTroop() {
        if (getRecordType() == MessageRecordType.RECORD_TYPE_TROOP) {
            return true;
        }
        return false;
    }

    public final boolean isValidRecord() {
        return !StringsKt.isBlank(getUin());
    }

    public final void setForbiddenNotify(boolean z16) {
        this.forbiddenNotify = z16;
    }

    public final void setHasUnreadPtt(boolean z16) {
        this.hasUnreadPtt = z16;
    }

    public final void setLastMsg(@Nullable String str) {
        this.lastMsg = str;
    }

    public final void setLastMsgUid(long j3) {
        this.lastMsgUid = j3;
    }

    public final void setLastTimeStamp(long j3) {
        this.lastTimeStamp = j3;
    }

    public final void setNickName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final void setSummaryData(@NotNull SummaryData summaryData) {
        Intrinsics.checkNotNullParameter(summaryData, "<set-?>");
        this.summaryData = summaryData;
    }

    public final void setUnReadMark(boolean z16) {
        this.unReadMark = z16;
    }

    public final void setUnreadCount(int i3) {
        this.unreadCount = i3;
    }

    public /* synthetic */ SquareBaseMessageRecord(String str, MessageRecordType messageRecordType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? MessageRecordType.RECORD_TYPE_NONE : messageRecordType);
    }
}
