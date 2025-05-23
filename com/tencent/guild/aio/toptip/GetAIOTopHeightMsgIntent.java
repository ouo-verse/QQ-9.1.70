package com.tencent.guild.aio.toptip;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/toptip/GetAIOTopHeightMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class GetAIOTopHeightMsgIntent implements MsgIntent {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GetAIOTopHeightMsgIntent f112353d = new GetAIOTopHeightMsgIntent();

    GetAIOTopHeightMsgIntent() {
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
