package com.tencent.state.template.push;

import com.tencent.state.common.push.PushBasic;
import com.tencent.state.common.push.PushMessage;
import com.tencent.state.square.SquareBaseKt;
import cooperation.vip.tianshu.TianShuMMKVConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\rJ\b\u0010\u001f\u001a\u00020\u0003H\u0016R\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/template/push/BubbleMessage;", "Lcom/tencent/state/common/push/PushMessage;", "text", "", "(Ljava/lang/String;)V", "type", "", "info", "Lcom/tencent/state/common/push/PushBasic;", "templateId", "uin", "", "duration", "(ILcom/tencent/state/common/push/PushBasic;Ljava/lang/String;JLjava/lang/String;I)V", TianShuMMKVConstant.LicenseInfoKey.CAN_SHOW, "", "getCanShow", "()Z", "getDuration", "()I", "getInfo", "()Lcom/tencent/state/common/push/PushBasic;", "lastTime", "getLastTime", "()J", "messageTime", "getTemplateId", "()Ljava/lang/String;", "getText", "getType", "getUin", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class BubbleMessage extends PushMessage {
    private final int duration;
    private final PushBasic info;
    private final long messageTime;
    private final String templateId;
    private final String text;
    private final int type;
    private final long uin;

    public BubbleMessage(int i3, PushBasic info, String templateId, long j3, String text, int i16) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(text, "text");
        this.type = i3;
        this.info = info;
        this.templateId = templateId;
        this.uin = j3;
        this.text = text;
        this.duration = i16;
        this.messageTime = System.currentTimeMillis();
    }

    public final boolean getCanShow() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.text);
        return (isBlank ^ true) && getLastTime() > 0;
    }

    public final int getDuration() {
        return this.duration;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public PushBasic getInfo() {
        return this.info;
    }

    public final long getLastTime() {
        return (this.duration * 1000) - (System.currentTimeMillis() - this.messageTime);
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.tencent.state.common.push.PushMessage
    public int getType() {
        return this.type;
    }

    public final long getUin() {
        return this.uin;
    }

    public String toString() {
        return "BubbleMessage(type=" + getType() + ", uin: " + this.uin + ", text: " + this.text + ", duration: " + this.duration + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BubbleMessage(String text) {
        this(14, new PushBasic(0L, 0L, 0L), "", Long.parseLong(SquareBaseKt.getSquareCommon().getCurrentAccountUin()), text, 15);
        Intrinsics.checkNotNullParameter(text, "text");
    }
}
