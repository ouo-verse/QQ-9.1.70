package com.tencent.guild.aio.msglist.graytips.combine;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/combine/e;", "", "", "a", "I", "b", "()I", "mIndex", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", "()Lcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;", "grayTipElement", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "c", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "<init>", "(ILcom/tencent/qqnt/kernelpublic/nativeinterface/GrayTipElement;Lcom/tencent/guild/api/data/msglist/GuildMsgItem;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int mIndex;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GrayTipElement grayTipElement;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildMsgItem msgItem;

    public e(int i3, @NotNull GrayTipElement grayTipElement, @NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(grayTipElement, "grayTipElement");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        this.mIndex = i3;
        this.grayTipElement = grayTipElement;
        this.msgItem = msgItem;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GrayTipElement getGrayTipElement() {
        return this.grayTipElement;
    }

    /* renamed from: b, reason: from getter */
    public final int getMIndex() {
        return this.mIndex;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildMsgItem getMsgItem() {
        return this.msgItem;
    }
}
