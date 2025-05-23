package com.tencent.guild.aio.msglist.graytips.combine;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\b\u001a\u00020\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/combine/d;", "", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", TabPreloadItem.TAB_NAME_MESSAGE, "", "c", "b", "a", "Ljava/util/List;", "mCombineGrayTipMsgList", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<GuildMsgItem> mCombineGrayTipMsgList = new ArrayList();

    public final void a() {
        this.mCombineGrayTipMsgList.clear();
    }

    @NotNull
    public final List<GuildMsgItem> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mCombineGrayTipMsgList);
        return arrayList;
    }

    public final void c(@NotNull List<GuildMsgItem> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        this.mCombineGrayTipMsgList = msgList;
    }
}
