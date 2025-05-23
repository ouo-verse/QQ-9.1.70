package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernelgpro.nativeinterface.IFetchListCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionListener;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelDirectSessionService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001cB\u0019\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J.\u0010\u0011\u001a\u00020\u00062\u001a\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0010H\u0016J&\u0010\u0015\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProDirectSessionService;", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProDirectSessionBaseService;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelDirectSessionListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelDirectSessionService;", "Luh2/a;", "listener", "", "addKernelDirectSessionListener", "removeKernelDirectSessionListener", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGuildOperateCallback;", "cb", "getDirectSessionList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "guilds", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IFetchListCallback;", "fetchDirectSessionList", "", "guildId", "channelId", "deleteDirectMsgRecordsAndDirectSession", "service", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;", "content", "<init>", "(Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelDirectSessionService;Lcom/tencent/mobileqq/qqguildsdk/api/impl/ServiceContent;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GProDirectSessionService extends GProDirectSessionBaseService<IKernelDirectSessionListener, IKernelDirectSessionService> implements uh2.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GProDirectSessionService(@Nullable IKernelDirectSessionService iKernelDirectSessionService, @NotNull ServiceContent content) {
        super("GProDirectSessionService", content, iKernelDirectSessionService);
        Intrinsics.checkNotNullParameter(content, "content");
    }

    @Override // uh2.a
    public void addKernelDirectSessionListener(@Nullable IKernelDirectSessionListener listener) {
        IKernelDirectSessionService S0 = S0();
        if (S0 != null) {
            S0.addKernelDirectSessionListener(listener);
        }
    }

    @Override // uh2.a
    public void deleteDirectMsgRecordsAndDirectSession(@Nullable final String guildId, @Nullable final String channelId, @Nullable IGuildOperateCallback cb5) {
        f1("deleteDirectMsgRecordsAndDirectSession", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProDirectSessionService$deleteDirectMsgRecordsAndDirectSession$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelDirectSessionService S0 = GProDirectSessionService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.deleteDirectMsgRecordsAndDirectSession(guildId, channelId, iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.a
    public void fetchDirectSessionList(@Nullable final ArrayList<Long> guilds, @Nullable IFetchListCallback cb5) {
        e1("fetchDirectSessionList", cb5, new Function1<IFetchListCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProDirectSessionService$fetchDirectSessionList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IFetchListCallback iFetchListCallback) {
                IKernelDirectSessionService S0 = GProDirectSessionService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.fetchDirectSessionList(guilds, iFetchListCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.a
    public void getDirectSessionList(@Nullable IGuildOperateCallback cb5) {
        f1("getDirectSessionList", cb5, new Function1<IGuildOperateCallback, Unit>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProDirectSessionService$getDirectSessionList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Unit invoke(@Nullable IGuildOperateCallback iGuildOperateCallback) {
                IKernelDirectSessionService S0 = GProDirectSessionService.this.S0();
                if (S0 == null) {
                    return null;
                }
                S0.getDirectSessionList(iGuildOperateCallback);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // uh2.a
    public void removeKernelDirectSessionListener(@Nullable IKernelDirectSessionListener listener) {
        IKernelDirectSessionService S0 = S0();
        if (S0 != null) {
            S0.removeKernelDirectSessionListener(listener);
        }
    }
}
