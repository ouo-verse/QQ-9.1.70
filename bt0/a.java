package bt0;

import com.tencent.aio.part.root.panel.mvx.config.b;
import com.tencent.guild.api.aio.panel.IPanelProviderFactoryApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import zq0.AioPanelParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lbt0/a;", "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "", "panelId", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "b", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.aio.part.root.panel.mvx.config.a {
    @Override // com.tencent.aio.part.root.panel.mvx.config.a
    @Nullable
    public b b(int panelId) {
        if (panelId != 1001) {
            return null;
        }
        return ((IPanelProviderFactoryApi) QRoute.api(IPanelProviderFactoryApi.class)).getEmotionPanelProvider(new AioPanelParam(a(), null, 2, null));
    }
}
