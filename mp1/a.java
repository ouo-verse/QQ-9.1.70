package mp1;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.homev2.misc.GuildHomeV2FragmentBehavior;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lmp1/a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior;", "e", "()Lcom/tencent/mobileqq/guild/homev2/misc/GuildHomeV2FragmentBehavior;", "fragmentBehavior", "Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "d", "()Lcom/tencent/mobileqq/guild/homev2/viewmodels/GuildHomeViewModel;", "homeViewModel", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "a", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "b", "()Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "f", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a {
    @NotNull
    GuildFacadeType a();

    @NotNull
    IPerformanceReportTask b();

    @NotNull
    GuildHomeViewModel d();

    @NotNull
    GuildHomeV2FragmentBehavior e();

    @NotNull
    JumpGuildParam f();

    @NotNull
    QBaseActivity getActivity();
}
