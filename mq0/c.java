package mq0;

import android.view.View;
import com.tencent.guild.api.gift.IGuildGiftApi;
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
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lmq0/c;", "Lmq0/e;", "Landroid/view/View;", "v", "", "i", "", tl.h.F, "g", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "f", "", "d", "Ljava/lang/String;", "TAG", "e", "I", "appInfoUinType", "uinType", "<init>", "(I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int appInfoUinType;

    public c(int i3) {
        super(i3);
        this.TAG = "GuildGiftAppInfo";
        this.appInfoUinType = i3;
    }

    private final void i(View v3) {
        HashMap hashMap = new HashMap();
        VideoReport.setElementId(v3, "em_sgrp_aio_gifts");
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
        if (fo0.b.c(panelParam.a())) {
            QLog.i(this.TAG, 1, "interceptOperationWhenInGuestInputMode");
            return;
        }
        i(v3);
        try {
            ((IGuildGiftApi) QRoute.api(IGuildGiftApi.class)).handleGiftBtnClick(panelParam, this.appInfoUinType);
        } catch (Exception e16) {
            QLog.d(this.TAG, 2, e16.getMessage());
        }
    }

    @Override // mq0.e
    public int g() {
        return R.drawable.guild_aio_plus_gift;
    }

    @Override // mq0.e
    public int h() {
        return R.string.f139410b7;
    }
}
