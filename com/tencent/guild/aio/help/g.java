package com.tencent.guild.aio.help;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/help/g;", "Lcom/tencent/aio/main/businesshelper/h;", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", "state", "onMoveToState", "<init>", "()V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g implements com.tencent.aio.main.businesshelper.h {
    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 16;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GuildAIOMetricsHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state == 12) {
                ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).noteTextChannelStatus(false);
                return;
            }
            return;
        }
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).noteTextChannelStatus(true);
    }
}
