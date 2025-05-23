package kq0;

import com.tencent.aio.part.root.panel.mvx.config.b;
import com.tencent.aio.part.root.panel.mvx.config.c;
import com.tencent.guild.aio.panel.provider.PhotoPanelProvider;
import com.tencent.guild.api.aio.panel.IPanelProviderFactoryApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.Unit;
import lq0.e;
import org.jetbrains.annotations.Nullable;
import zq0.AioPanelParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lkq0/a;", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "", "panelId", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.part.root.panel.mvx.config.a {
    @Override // com.tencent.aio.part.root.panel.mvx.config.a
    @Nullable
    public b b(int panelId) {
        switch (panelId) {
            case 1001:
                IPanelProviderFactoryApi iPanelProviderFactoryApi = (IPanelProviderFactoryApi) QRoute.api(IPanelProviderFactoryApi.class);
                c a16 = a();
                zq0.a aVar = new zq0.a();
                aVar.c(R.drawable.qui_common_bg_nav_bottom_aio_bg);
                aVar.d(R.drawable.qui_common_bg_nav_bottom_aio_bg);
                Unit unit = Unit.INSTANCE;
                return iPanelProviderFactoryApi.getEmotionPanelProvider(new AioPanelParam(a16, aVar));
            case 1002:
                return new com.tencent.guild.aio.panel.provider.a(a(), new e(null, 0, 3, null));
            case 1003:
                return new PhotoPanelProvider(a());
            case 1004:
                return new com.tencent.guild.aio.panel.provider.b(a());
            default:
                return null;
        }
    }
}
