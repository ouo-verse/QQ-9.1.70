package mq0;

import android.view.View;
import com.tencent.guild.aio.event.GuildAtPanelEvent;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lmq0/d;", "Lmq0/e;", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "", "i", "j", "", "g", tl.h.F, "Landroid/view/View;", "v", "f", "uinType", "<init>", "(I)V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends e {
    public d(int i3) {
        super(i3);
    }

    private final void i(com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        if (panelParam.a().c().getActivity() != null && fo0.b.c(panelParam.a())) {
            QLog.i("GuildFileAppInfo", 1, "checkIsGuestInputModeAndPopTip");
        } else {
            panelParam.a().e().h(new GuildAtPanelEvent.ShowHashtagPanel(true));
            j();
        }
    }

    private final void j() {
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_sgrp_aio");
        hashMap.put("eid", "em_sgrp_aio_link_sub_channel");
        VideoReport.reportEvent("clck", hashMap);
    }

    @Override // mq0.e, lq0.f
    public void f(@NotNull View v3, @NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        super.f(v3, panelParam);
        i(panelParam);
    }

    @Override // mq0.e
    public int g() {
        return R.drawable.guild_aio_plus_panel_hashtag;
    }

    @Override // mq0.e
    public int h() {
        return R.string.f139420b8;
    }
}
