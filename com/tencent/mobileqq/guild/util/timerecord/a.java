package com.tencent.mobileqq.guild.util.timerecord;

import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/util/timerecord/a;", "Lcom/tencent/mobileqq/guild/util/timerecord/d;", "", "eventID", "", "", "params", "", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a implements d {
    @Override // com.tencent.mobileqq.guild.util.timerecord.d
    public void a(@NotNull String eventID, @NotNull Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(params, "params");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).doReportEvent(eventID, params);
    }
}
