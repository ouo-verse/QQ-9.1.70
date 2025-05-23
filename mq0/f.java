package mq0;

import android.view.View;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildSpeechApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lmq0/f;", "Lmq0/e;", "Landroid/view/View;", "v", "", "i", "", tl.h.F, "g", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "f", "uinType", "<init>", "(I)V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f extends e {
    public f(int i3) {
        super(i3);
    }

    private final void i(View v3) {
        HashMap hashMap = new HashMap();
        VideoReport.setElementId(v3, "em_sgrp_aio_plus_packet");
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", v3, hashMap);
    }

    @Override // mq0.e, lq0.f
    public void f(@NotNull View v3, @NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        if (fo0.b.c(panelParam.a())) {
            QLog.i("GuildRedPocketAppInfo", 1, "interceptOperationWhenInGuestInputMode");
            return;
        }
        i(v3);
        if (((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).isNeedInterceptHongbao(com.tencent.guild.aio.util.a.g(panelParam.b()), com.tencent.guild.aio.util.a.b(panelParam.b()))) {
            ((IGuildSpeechApi) QRoute.api(IGuildSpeechApi.class)).showInterceptRedEnvelopeSendToast();
        } else if (com.tencent.guild.aio.util.ex.a.k(panelParam.a())) {
            QQToast.makeText(v3.getContext(), R.string.f156871ld, 0).show();
        } else {
            super.f(v3, panelParam);
            panelParam.a().e().h(new PanelMsg.ShowPanel("GuildAioPlusViewModel", 1004, false, 4, null));
        }
    }

    @Override // mq0.e
    public int g() {
        return R.drawable.guild_redpack_icon;
    }

    @Override // mq0.e
    public int h() {
        return R.string.f139430b9;
    }
}
