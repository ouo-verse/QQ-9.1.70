package com.tencent.guild.aio.usecase.channel.title;

import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0017R$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/usecase/channel/title/ChannelNameUseCase;", "Lpl3/a;", "Lcom/tencent/guild/aio/usecase/channel/title/a;", "Lcom/tencent/guild/aio/usecase/channel/title/b;", "action", "Lkotlinx/coroutines/flow/Flow;", "e", "Lkotlin/Function1;", "", "a", "Lkotlin/jvm/functions/Function1;", "channelNameCB", "<init>", "()V", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class ChannelNameUseCase implements pl3.a<a, ChannelNameMviResult> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super ChannelNameMviResult, Unit> channelNameCB;

    @Override // pl3.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull a aVar) {
        a.C11027a.a(this, aVar);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.String] */
    @ExperimentalCoroutinesApi
    @NotNull
    public Flow<ChannelNameMviResult> e(@NotNull a action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).getChannelName(action.getContact());
        QLog.i("ChannelNameUseCase", 1, "handleActionFlow channelId:" + action.getContact().j());
        return FlowKt.callbackFlow(new ChannelNameUseCase$handleActionFlow$1(this, objectRef, null));
    }
}
