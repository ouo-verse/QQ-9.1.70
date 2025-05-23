package com.tencent.guildmedia.aio.excellentdetail.title;

import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\f\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guildmedia/aio/excellentdetail/title/AnnounceDetailMoreIconVisible;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "", "d", "Z", "a", "()Z", NodeProps.VISIBLE, "e", "getResult", "setResult", "(Z)V", "result", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "f", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "getType", "()Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;", "setType", "(Lcom/tencent/guild/aio/title/IGuildAioTitleUIState$TYPE;)V", "type", "<init>", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class AnnounceDetailMoreIconVisible implements IGuildAioTitleUIState {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean visible;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean result = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IGuildAioTitleUIState.TYPE type = IGuildAioTitleUIState.TYPE.EMPTY_DATA;

    public AnnounceDetailMoreIconVisible(boolean z16) {
        this.visible = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getVisible() {
        return this.visible;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.guild.aio.title.IGuildAioTitleUIState
    public boolean getResult() {
        return this.result;
    }

    @Override // com.tencent.guild.aio.title.IGuildAioTitleUIState
    @NotNull
    public IGuildAioTitleUIState.TYPE getType() {
        return this.type;
    }
}
