package com.tencent.guild.aio.util.ui;

import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.RichDownLoadReq;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/util/ui/e;", "", "", "getSeq", "", "getMsgId", "getChatType", "", "getPeerUin", "b", "getMsgSeq", "a", "getSenderUin", "getGuildID", "downloadType", "thumbLevel", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/RichDownLoadReq;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        @NotNull
        public static RichDownLoadReq a(@NotNull e eVar, int i3, int i16, @NotNull MsgElement msgElement) {
            Intrinsics.checkNotNullParameter(msgElement, "msgElement");
            return new RichDownLoadReq(i3, i16, eVar.getMsgId(), eVar.b(), eVar.getMsgSeq(), eVar.a(), eVar.getChatType(), eVar.getSenderUin(), eVar.getPeerUin(), eVar.getGuildID(), msgElement, null);
        }

        @NotNull
        public static RichMediaElementGetReq b(@NotNull e eVar, int i3, int i16, @NotNull MsgElement msgElement) {
            Intrinsics.checkNotNullParameter(msgElement, "msgElement");
            return new RichMediaElementGetReq(eVar.getMsgId(), eVar.getPeerUin(), eVar.getChatType(), msgElement.elementId, i3, i16, "", 0L, 0, 0);
        }
    }

    long a();

    long b();

    @NotNull
    RichMediaElementGetReq c(int downloadType, int thumbLevel, @NotNull MsgElement msgElement);

    @NotNull
    RichDownLoadReq d(int downloadType, int thumbLevel, @NotNull MsgElement msgElement);

    int getChatType();

    @NotNull
    String getGuildID();

    long getMsgId();

    long getMsgSeq();

    @NotNull
    String getPeerUin();

    @NotNull
    String getSenderUin();

    int getSeq();
}
