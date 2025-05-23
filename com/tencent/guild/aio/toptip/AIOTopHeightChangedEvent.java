package com.tencent.guild.aio.toptip;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/toptip/AIOTopHeightChangedEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "d", "I", "a", "()I", "height", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class AIOTopHeightChangedEvent implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int height;

    public AIOTopHeightChangedEvent(int i3) {
        this.height = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
