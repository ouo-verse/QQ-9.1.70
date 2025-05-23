package com.tencent.guild.aio.msglist.holder.state;

import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.data.msglist.a;
import com.tencent.mvi.base.route.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/state/MsgListItemState;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "a", "()Lcom/tencent/aio/data/msglist/a;", "data", "", "e", "I", "c", "()I", "position", "", "", "f", "Ljava/util/List;", "b", "()Ljava/util/List;", "payloads", "<init>", "(Lcom/tencent/aio/data/msglist/a;ILjava/util/List;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class MsgListItemState implements MsgListUiState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Object> payloads;

    public MsgListItemState(@NotNull a data, int i3, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.data = data;
        this.position = i3;
        this.payloads = payloads;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final a getData() {
        return this.data;
    }

    @NotNull
    public final List<Object> b() {
        return this.payloads;
    }

    /* renamed from: c, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }
}
