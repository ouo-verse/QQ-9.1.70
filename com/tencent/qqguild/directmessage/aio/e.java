package com.tencent.qqguild.directmessage.aio;

import com.tencent.guild.aio.panel.provider.PhotoPanelProvider;
import com.tencent.guild.api.aio.panel.IPanelProviderFactoryApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;
import zq0.AioPanelParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/e;", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "", "panelId", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
final class e extends com.tencent.aio.part.root.panel.mvx.config.a {
    @Override // com.tencent.aio.part.root.panel.mvx.config.a
    @Nullable
    public com.tencent.aio.part.root.panel.mvx.config.b b(int panelId) {
        int i3 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        switch (panelId) {
            case 1001:
                return ((IPanelProviderFactoryApi) QRoute.api(IPanelProviderFactoryApi.class)).getEmotionPanelProvider(new AioPanelParam(a(), null, 2, null));
            case 1002:
                return new com.tencent.guild.aio.panel.provider.a(a(), new lq0.e(new mq0.e[]{new at3.a()}, 0, i3, defaultConstructorMarker));
            case 1003:
                return new PhotoPanelProvider(a());
            default:
                return null;
        }
    }
}
