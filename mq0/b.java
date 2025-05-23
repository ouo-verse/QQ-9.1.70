package mq0;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.guild.api.file.IGuildFileSelectorApi;
import com.tencent.mobileqq.R;
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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lmq0/b;", "Lmq0/e;", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "", "i", "Landroid/view/View;", "v", "j", "", tl.h.F, "g", "f", "uinType", "<init>", "(I)V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends e {
    public b(int i3) {
        super(i3);
    }

    private final void i(com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        FragmentActivity activity = panelParam.a().c().getActivity();
        if (activity != null) {
            if (fo0.b.c(panelParam.a())) {
                QLog.i("GuildFileAppInfo", 1, "checkIsGuestInputModeAndPopTip");
            } else {
                ((IGuildFileSelectorApi) QRoute.api(IGuildFileSelectorApi.class)).openFileSelector(activity, panelParam.b());
            }
        }
    }

    private final void j(View v3) {
        HashMap hashMap = new HashMap();
        VideoReport.setElementId(v3, "em_sgrp_aio_plus_file");
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", v3, hashMap);
    }

    @Override // mq0.e, lq0.f
    public void f(@NotNull View v3, @NotNull com.tencent.aio.part.root.panel.mvx.config.c panelParam) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        if (com.tencent.guild.aio.util.ex.a.k(panelParam.a())) {
            QQToast.makeText(v3.getContext(), R.string.f156871ld, 0).show();
            return;
        }
        super.f(v3, panelParam);
        j(v3);
        i(panelParam);
    }

    @Override // mq0.e
    public int g() {
        return R.drawable.guild_aio_plus_panel_send_file;
    }

    @Override // mq0.e
    public int h() {
        return R.string.f139400b6;
    }
}
