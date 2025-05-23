package com.tencent.robot.aio.helper.tts.task;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.qqnt.audio.tts.ui.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u000e\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/aio/helper/tts/task/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "()Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "ttsId", "Z", "d", "()Z", "isAutoTrigger", "Lcom/tencent/qqnt/audio/tts/ui/e$c;", "Lcom/tencent/qqnt/audio/tts/ui/e$c;", "()Lcom/tencent/qqnt/audio/tts/ui/e$c;", "playStateListener", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Ljava/lang/String;ZLcom/tencent/qqnt/audio/tts/ui/e$c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.aio.helper.tts.task.e, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class TtsPlayProcessArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final AIOMsgItem msgItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String ttsId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isAutoTrigger;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final e.c playStateListener;

    public TtsPlayProcessArgs(@NotNull AIOMsgItem msgItem, @NotNull String ttsId, boolean z16, @NotNull e.c playStateListener) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(ttsId, "ttsId");
        Intrinsics.checkNotNullParameter(playStateListener, "playStateListener");
        this.msgItem = msgItem;
        this.ttsId = ttsId;
        this.isAutoTrigger = z16;
        this.playStateListener = playStateListener;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AIOMsgItem getMsgItem() {
        return this.msgItem;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final e.c getPlayStateListener() {
        return this.playStateListener;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTtsId() {
        return this.ttsId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsAutoTrigger() {
        return this.isAutoTrigger;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TtsPlayProcessArgs)) {
            return false;
        }
        TtsPlayProcessArgs ttsPlayProcessArgs = (TtsPlayProcessArgs) other;
        if (Intrinsics.areEqual(this.msgItem, ttsPlayProcessArgs.msgItem) && Intrinsics.areEqual(this.ttsId, ttsPlayProcessArgs.ttsId) && this.isAutoTrigger == ttsPlayProcessArgs.isAutoTrigger && Intrinsics.areEqual(this.playStateListener, ttsPlayProcessArgs.playStateListener)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.msgItem.hashCode() * 31) + this.ttsId.hashCode()) * 31;
        boolean z16 = this.isAutoTrigger;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.playStateListener.hashCode();
    }

    @NotNull
    public String toString() {
        return "TtsPlayProcessArgs(msgItem=" + this.msgItem + ", ttsId=" + this.ttsId + ", isAutoTrigger=" + this.isAutoTrigger + ", playStateListener=" + this.playStateListener + ")";
    }
}
