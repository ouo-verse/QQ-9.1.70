package com.tencent.guild.aio.help;

import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.guild.heartbeatreport.IFragmentStatusReportApi;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/help/p;", "Lcom/tencent/aio/main/businesshelper/h;", "", "b", "a", "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "<init>", "()V", "e", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class p implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    private final void a() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        if (com.tencent.guild.aio.util.a.k(g16)) {
            ((IFragmentStatusReportApi) QRoute.api(IFragmentStatusReportApi.class)).pause();
        }
    }

    private final void b() {
        Integer num;
        String str;
        boolean z16;
        GuildAppReportSourceInfo.ExtraInfo extraInfo;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        String str2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        AIOParam g16 = bVar.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "param.aioContext.aioParam");
        if (com.tencent.guild.aio.util.a.k(g16)) {
            com.tencent.aio.main.businesshelper.b bVar2 = this.param;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar2 = null;
            }
            AIOParam g17 = bVar2.a().g();
            Intrinsics.checkNotNullExpressionValue(g17, "param.aioContext.aioParam");
            GuildAppReportSourceInfo h16 = com.tencent.guild.aio.util.a.h(g17);
            IFragmentStatusReportApi iFragmentStatusReportApi = (IFragmentStatusReportApi) QRoute.api(IFragmentStatusReportApi.class);
            com.tencent.aio.main.businesshelper.b bVar3 = this.param;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar3 = null;
            }
            AIOParam g18 = bVar3.a().g();
            Intrinsics.checkNotNullExpressionValue(g18, "param.aioContext.aioParam");
            String g19 = com.tencent.guild.aio.util.a.g(g18);
            com.tencent.aio.main.businesshelper.b bVar4 = this.param;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar4 = null;
            }
            AIOParam g26 = bVar4.a().g();
            Intrinsics.checkNotNullExpressionValue(g26, "param.aioContext.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g26);
            if (h16 != null && (extraInfo = h16.extraInfo) != null) {
                num = Integer.valueOf(extraInfo.channelOpenSourceForOnlineReport);
            } else {
                num = null;
            }
            if (h16 != null) {
                str2 = h16.getPageInSourceName();
            }
            if (str2 == null) {
                str = "";
            } else {
                str = str2;
            }
            if (h16 != null) {
                z16 = h16.getStartFromGuildTab();
            } else {
                z16 = false;
            }
            iFragmentStatusReportApi.reportResume(g19, b16, num, str, z16);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 15;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "HeartBeatReportHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{3, 8};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 3) {
            if (state == 8) {
                a();
                return;
            }
            return;
        }
        b();
    }
}
