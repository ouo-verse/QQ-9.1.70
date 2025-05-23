package com.tencent.mobileqq.matchfriend.reborn.content.msg.part;

import android.view.View;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/b;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/a;", "", "B9", "C9", "", "", "A9", "z9", "x9", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends a {
    private final Map<String, ?> A9() {
        Map<String, ?> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId()));
        return mapOf;
    }

    private final void B9() {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            Map<String, ?> A9 = A9();
            VideoReport.setPageReportPolicy(partRootView, PageReportPolicy.REPORT_NONE);
            VideoReport.setPageId(partRootView, "pg_kl_new_chat_list");
            VideoReport.setPageParams(partRootView, new PageParams(A9));
            VideoReport.reportEvent("dt_pgin", partRootView, A9);
        }
    }

    private final void C9() {
        View partRootView = getPartRootView();
        if (partRootView != null) {
            Map<String, ?> A9 = A9();
            VideoReport.setPageId(partRootView, "pg_kl_new_chat_list");
            VideoReport.setPageParams(partRootView, new PageParams(A9));
            VideoReport.reportEvent("dt_pgout", partRootView, A9);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.a
    public void x9() {
        super.x9();
        C9();
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.content.a
    public void z9() {
        super.z9();
        B9();
    }
}
