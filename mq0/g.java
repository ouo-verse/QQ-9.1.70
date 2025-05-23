package mq0;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelFeature;
import com.tencent.qqnt.kernel.nativeinterface.GProGuildRobotPlusPanelFeatureInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 \t2\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\u00148\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lmq0/g;", "Lmq0/e;", "Landroid/view/View;", "v", "", "k", "l", "", tl.h.F, "g", "", "j", "i", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPlusPanelFeature;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPlusPanelFeature;", "plusPanelFeature", "", "e", "Z", "()Z", "isRobotService", "I", "getPosition", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "position", "uinType", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/GProGuildRobotPlusPanelFeature;I)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class g extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GProGuildRobotPlusPanelFeature plusPanelFeature;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isRobotService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull GProGuildRobotPlusPanelFeature plusPanelFeature, int i3) {
        super(i3);
        Intrinsics.checkNotNullParameter(plusPanelFeature, "plusPanelFeature");
        this.plusPanelFeature = plusPanelFeature;
        this.isRobotService = true;
    }

    private final void k(View v3) {
        GProGuildRobotPlusPanelFeatureInfo gProGuildRobotPlusPanelFeatureInfo = this.plusPanelFeature.serviceInfo;
        int i3 = gProGuildRobotPlusPanelFeatureInfo.type;
        String str = gProGuildRobotPlusPanelFeatureInfo.url;
        Intrinsics.checkNotNullExpressionValue(str, "plusPanelFeature.serviceInfo.url");
        if (i3 != 0) {
            if (i3 != 1) {
                QQToast.makeText(v3.getContext(), R.string.f143550md, 1).show();
                return;
            } else {
                ((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).startMiniAppService(v3.getContext(), str);
                return;
            }
        }
        ((IGuildRobotApi) QRoute.api(IGuildRobotApi.class)).startH5Service(v3.getContext(), str);
    }

    private final void l(View v3) {
        VideoReport.setElementId(v3, "em_pg_sgrp_aio_plus_configure");
        HashMap hashMap = new HashMap();
        String str = this.plusPanelFeature.serviceName;
        Intrinsics.checkNotNullExpressionValue(str, "plusPanelFeature.serviceName");
        hashMap.put("sgrp_configure_name", str);
        String str2 = this.plusPanelFeature.serviceInfo.name;
        Intrinsics.checkNotNullExpressionValue(str2, "plusPanelFeature.serviceInfo.name");
        hashMap.put("sgrp_configure_command", str2);
        hashMap.put("sgrp_configure_rank", Integer.valueOf(this.position));
        hashMap.put("sgrp_configure_id", Integer.valueOf(this.plusPanelFeature.serviceInfo.f359176id));
        hashMap.put("sgrp_is_robot", "1");
        VideoReport.setElementParams(v3, hashMap);
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(v3, EndExposurePolicy.REPORT_ALL);
        VideoReport.reportEvent("clck", v3, hashMap);
    }

    @Override // lq0.f
    /* renamed from: d, reason: from getter */
    public boolean getIsRobotService() {
        return this.isRobotService;
    }

    @Override // mq0.e, lq0.f
    public void f(@NotNull View v3, @NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        super.f(v3, panelParam);
        k(v3);
        l(v3);
    }

    @Override // mq0.e
    public int g() {
        return R.drawable.guild_aio_robot_func_btn_in_add;
    }

    @Override // mq0.e
    public int h() {
        return R.string.f139460bb;
    }

    @NotNull
    public final String i() {
        String str = this.plusPanelFeature.icon;
        Intrinsics.checkNotNullExpressionValue(str, "plusPanelFeature.icon");
        return str;
    }

    @NotNull
    public final String j() {
        String str = this.plusPanelFeature.serviceName;
        Intrinsics.checkNotNullExpressionValue(str, "plusPanelFeature.serviceName");
        return str;
    }

    public final void m(int i3) {
        this.position = i3;
    }
}
