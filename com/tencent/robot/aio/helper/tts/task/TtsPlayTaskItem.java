package com.tencent.robot.aio.helper.tts.task;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\b\b\u0002\u0010(\u001a\u00020\u0007\u0012\b\b\u0002\u0010+\u001a\u00020\u0007\u0012\b\b\u0002\u0010.\u001a\u00020\u0007\u0012\b\b\u0002\u00103\u001a\u00020\u0002\u00a2\u0006\u0004\b6\u00107J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001d\u001a\u0004\b\n\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0010\u0010\u001a\"\u0004\b\"\u0010#R\"\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010#R\"\u0010+\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010#R\"\u0010.\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0018\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010#R\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010/\u001a\u0004\b%\u00100\"\u0004\b1\u00102R$\u00105\u001a\u00020\t2\u0006\u00104\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b\u0017\u0010\r\u00a8\u00068"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/task/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "taskKey", "Lcom/tencent/robot/aio/helper/tts/task/TtsPlayTaskType;", "b", "Lcom/tencent/robot/aio/helper/tts/task/TtsPlayTaskType;", "e", "()Lcom/tencent/robot/aio/helper/tts/task/TtsPlayTaskType;", "o", "(Lcom/tencent/robot/aio/helper/tts/task/TtsPlayTaskType;)V", "taskType", "c", "Z", "g", "()Z", "isAutoTrigger", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "k", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "msgItem", "l", "(Z)V", "needReExecute", "f", "i", DomainData.DOMAIN_NAME, "isStarted", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isRunning", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isWaiting", "Ljava/lang/String;", "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "ttsId", "<set-?>", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "<init>", "(JLcom/tencent/robot/aio/helper/tts/task/TtsPlayTaskType;ZLcom/tencent/mobileqq/aio/msg/AIOMsgItem;ZZZZLjava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.aio.helper.tts.task.h, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class TtsPlayTaskItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long taskKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private TtsPlayTaskType taskType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAutoTrigger;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private AIOMsgItem msgItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean needReExecute;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isStarted;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isRunning;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isWaiting;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String ttsId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long taskId;

    public TtsPlayTaskItem(long j3, @NotNull TtsPlayTaskType taskType, boolean z16, @NotNull AIOMsgItem msgItem, boolean z17, boolean z18, boolean z19, boolean z26, @NotNull String ttsId) {
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(ttsId, "ttsId");
        this.taskKey = j3;
        this.taskType = taskType;
        this.isAutoTrigger = z16;
        this.msgItem = msgItem;
        this.needReExecute = z17;
        this.isStarted = z18;
        this.isRunning = z19;
        this.isWaiting = z26;
        this.ttsId = ttsId;
        this.taskId = msgItem.getMsgId();
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AIOMsgItem getMsgItem() {
        return this.msgItem;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedReExecute() {
        return this.needReExecute;
    }

    /* renamed from: c, reason: from getter */
    public final long getTaskId() {
        return this.taskId;
    }

    /* renamed from: d, reason: from getter */
    public final long getTaskKey() {
        return this.taskKey;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final TtsPlayTaskType getTaskType() {
        return this.taskType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TtsPlayTaskItem)) {
            return false;
        }
        TtsPlayTaskItem ttsPlayTaskItem = (TtsPlayTaskItem) other;
        if (this.taskKey == ttsPlayTaskItem.taskKey && this.taskType == ttsPlayTaskItem.taskType && this.isAutoTrigger == ttsPlayTaskItem.isAutoTrigger && Intrinsics.areEqual(this.msgItem, ttsPlayTaskItem.msgItem) && this.needReExecute == ttsPlayTaskItem.needReExecute && this.isStarted == ttsPlayTaskItem.isStarted && this.isRunning == ttsPlayTaskItem.isRunning && this.isWaiting == ttsPlayTaskItem.isWaiting && Intrinsics.areEqual(this.ttsId, ttsPlayTaskItem.ttsId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTtsId() {
        return this.ttsId;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsAutoTrigger() {
        return this.isAutoTrigger;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((androidx.fragment.app.a.a(this.taskKey) * 31) + this.taskType.hashCode()) * 31;
        boolean z16 = this.isAutoTrigger;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int hashCode = (((a16 + i16) * 31) + this.msgItem.hashCode()) * 31;
        boolean z17 = this.needReExecute;
        int i17 = z17;
        if (z17 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode + i17) * 31;
        boolean z18 = this.isStarted;
        int i19 = z18;
        if (z18 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        boolean z19 = this.isRunning;
        int i27 = z19;
        if (z19 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        boolean z26 = this.isWaiting;
        if (!z26) {
            i3 = z26 ? 1 : 0;
        }
        return ((i28 + i3) * 31) + this.ttsId.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsStarted() {
        return this.isStarted;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsWaiting() {
        return this.isWaiting;
    }

    public final void k(@NotNull AIOMsgItem aIOMsgItem) {
        Intrinsics.checkNotNullParameter(aIOMsgItem, "<set-?>");
        this.msgItem = aIOMsgItem;
    }

    public final void l(boolean z16) {
        this.needReExecute = z16;
    }

    public final void m(boolean z16) {
        this.isRunning = z16;
    }

    public final void n(boolean z16) {
        this.isStarted = z16;
    }

    public final void o(@NotNull TtsPlayTaskType ttsPlayTaskType) {
        Intrinsics.checkNotNullParameter(ttsPlayTaskType, "<set-?>");
        this.taskType = ttsPlayTaskType;
    }

    public final void p(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ttsId = str;
    }

    public final void q(boolean z16) {
        this.isWaiting = z16;
    }

    @NotNull
    public String toString() {
        return "TtsPlayTaskItem(taskKey=" + this.taskKey + ", taskType=" + this.taskType + ", isAutoTrigger=" + this.isAutoTrigger + ", msgItem=" + this.msgItem + ", needReExecute=" + this.needReExecute + ", isStarted=" + this.isStarted + ", isRunning=" + this.isRunning + ", isWaiting=" + this.isWaiting + ", ttsId=" + this.ttsId + ")";
    }

    public /* synthetic */ TtsPlayTaskItem(long j3, TtsPlayTaskType ttsPlayTaskType, boolean z16, AIOMsgItem aIOMsgItem, boolean z17, boolean z18, boolean z19, boolean z26, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? NetConnInfoCenter.getServerTimeMillis() : j3, ttsPlayTaskType, z16, aIOMsgItem, (i3 & 16) != 0 ? false : z17, (i3 & 32) != 0 ? false : z18, (i3 & 64) != 0 ? false : z19, (i3 & 128) != 0 ? false : z26, (i3 & 256) != 0 ? "" : str);
    }
}
