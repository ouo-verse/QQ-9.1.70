package com.tencent.guild.aio.msglist.holder.component;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/GuildEmojiSelectState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "", "d", "I", "a", "()I", "emojiId", "e", "b", "emojiType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "<init>", "(IILcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildEmojiSelectState implements MviUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int emojiId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int emojiType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msg;

    public GuildEmojiSelectState(int i3, int i16, @NotNull MsgRecord msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        this.emojiId = i3;
        this.emojiType = i16;
        this.msg = msg2;
    }

    /* renamed from: a, reason: from getter */
    public final int getEmojiId() {
        return this.emojiId;
    }

    /* renamed from: b, reason: from getter */
    public final int getEmojiType() {
        return this.emojiType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MsgRecord getMsg() {
        return this.msg;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
