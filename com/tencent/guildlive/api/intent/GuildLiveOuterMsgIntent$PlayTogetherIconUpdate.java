package com.tencent.guildlive.api.intent;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"com/tencent/guildlive/api/intent/GuildLiveOuterMsgIntent$PlayTogetherIconUpdate", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "d", "I", "b", "()I", "visibility", "", "e", "Z", "c", "()Z", "isStatusOn", "f", "a", "showAnimation", "<init>", "(IZZ)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveOuterMsgIntent$PlayTogetherIconUpdate implements MsgIntent {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int visibility;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isStatusOn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean showAnimation;

    public GuildLiveOuterMsgIntent$PlayTogetherIconUpdate(int i3, boolean z16, boolean z17) {
        this.visibility = i3;
        this.isStatusOn = z16;
        this.showAnimation = z17;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getShowAnimation() {
        return this.showAnimation;
    }

    /* renamed from: b, reason: from getter */
    public final int getVisibility() {
        return this.visibility;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsStatusOn() {
        return this.isStatusOn;
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
