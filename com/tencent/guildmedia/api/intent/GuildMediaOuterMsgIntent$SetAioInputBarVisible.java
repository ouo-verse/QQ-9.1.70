package com.tencent.guildmedia.api.intent;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"com/tencent/guildmedia/api/intent/GuildMediaOuterMsgIntent$SetAioInputBarVisible", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "d", "Z", "a", "()Z", NodeProps.VISIBLE, "<init>", "(Z)V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaOuterMsgIntent$SetAioInputBarVisible implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean visible;

    public GuildMediaOuterMsgIntent$SetAioInputBarVisible(boolean z16) {
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

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }
}
