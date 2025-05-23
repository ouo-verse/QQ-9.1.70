package com.tencent.guild.aio.article.data;

import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0003B%\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000f\u001a\u0004\b\b\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/article/data/h;", "", "", "a", "I", "()I", "loadSource", "", "b", "Z", "c", "()Z", "isSuccess", "", "Lcom/tencent/aio/data/msglist/a;", "Ljava/util/List;", "()Ljava/util/List;", TabPreloadItem.TAB_NAME_MESSAGE, "<init>", "(IZLjava/util/List;)V", "d", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int loadSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isSuccess;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.aio.data.msglist.a> msgList;

    /* JADX WARN: Multi-variable type inference failed */
    public h(int i3, boolean z16, @NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        this.loadSource = i3;
        this.isSuccess = z16;
        this.msgList = msgList;
    }

    /* renamed from: a, reason: from getter */
    public final int getLoadSource() {
        return this.loadSource;
    }

    @NotNull
    public final List<com.tencent.aio.data.msglist.a> b() {
        return this.msgList;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }
}
