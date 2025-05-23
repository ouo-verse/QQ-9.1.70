package com.tencent.qqnt.aio.api;

import com.tencent.aio.api.factory.g;
import com.tencent.aio.api.factory.i;
import com.tencent.aio.api.factory.j;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOFactoryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/factory/g;", "", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOFactoryApi extends QRouteApi, com.tencent.aio.api.factory.g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "buildPanelArea", imports = {}))
        @Nullable
        public static com.tencent.aio.part.root.panel.mvx.config.a a(@NotNull IAIOFactoryApi iAIOFactoryApi) {
            return g.a.h(iAIOFactoryApi);
        }
    }

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    /* synthetic */ com.tencent.aio.base.log.f buildAIOLogger();

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    /* synthetic */ com.tencent.aio.msgservice.a buildAIOMsgService();

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* synthetic */ ys.a buildActivityJumpService();

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* synthetic */ com.tencent.aio.api.factory.f buildBusinessLevel();

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    /* synthetic */ com.tencent.aio.api.factory.a buildFullBackgroundLevel();

    @Override // com.tencent.aio.api.help.c
    @NotNull
    /* synthetic */ com.tencent.aio.api.help.d buildHelperProvider();

    @Override // com.tencent.aio.api.factory.g
    @NotNull
    /* synthetic */ j buildMsgLevel();

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    /* synthetic */ com.tencent.aio.api.factory.c buildPanelArea();

    @NotNull
    /* synthetic */ com.tencent.aio.api.factory.c buildPanelAreaWithPanelFactory(@NotNull i iVar);

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    /* synthetic */ com.tencent.aio.api.factory.d buildReserve1Level();

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    /* synthetic */ com.tencent.aio.api.factory.e buildReserve2Level();

    @Override // com.tencent.aio.api.factory.g
    @Nullable
    /* synthetic */ dt.b getBottomDialogFactory();

    @Override // com.tencent.aio.api.factory.g
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "buildPanelArea", imports = {}))
    @Nullable
    /* synthetic */ com.tencent.aio.part.root.panel.mvx.config.a getPanelFactory();

    @Override // com.tencent.aio.api.factory.g
    /* synthetic */ boolean isDebugModel();
}
