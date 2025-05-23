package mq0;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotApi;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lmq0/h;", "Lmq0/e;", "", "i", "Landroid/view/View;", "v", "j", "", tl.h.F, "g", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "f", "", "e", "()Z", "isShowNew", "uinType", "<init>", "(I)V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class h extends e {
    public h(int i3) {
        super(i3);
    }

    private final void i() {
        ap0.b bVar = ap0.f.guildSlashHelper;
        if (bVar == null) {
            return;
        }
        ap0.f.isSlashPanelOpenFromAdd = true;
        ((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).openRobotSlashPanelFromBtn(bVar.f26648b);
    }

    private final void j(View v3) {
        HashMap hashMap = new HashMap();
        VideoReport.setElementId(v3, "em_sgrp_robot_cmd_entrance");
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", v3, hashMap);
    }

    @Override // lq0.f
    /* renamed from: e */
    public boolean getIsShowNew() {
        return !((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).isRobotSlashRedDotHasShow();
    }

    @Override // mq0.e, lq0.f
    public void f(@NotNull View v3, @NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        super.f(v3, panelParam);
        j(v3);
        i();
        View findViewById = v3.findViewById(R.id.flag_new);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setRobotSlashRedDotHasShow();
    }

    @Override // mq0.e
    public int g() {
        return R.drawable.guild_aio_robot_func_btn_in_add;
    }

    @Override // mq0.e
    public int h() {
        return R.string.f139460bb;
    }
}
