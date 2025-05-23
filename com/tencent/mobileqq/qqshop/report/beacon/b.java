package com.tencent.mobileqq.qqshop.report.beacon;

import android.os.Bundle;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ6\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0005J8\u0010\u000b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqshop/report/beacon/b;", "", "", "opName", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "inputParams", "", "b", AdMetricTag.EVENT_NAME, "params", "c", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f274709a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40604);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f274709a = new b();
            UserAction.registerTunnel(new TunnelInfo(QQBeaconReport.QWALLET_APP_KEY));
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, HashMap params) {
        Intrinsics.checkNotNullParameter(params, "$params");
        ReportMethodProxy.onUserActionToTunnel(QQBeaconReport.QWALLET_APP_KEY, str, true, -1L, -1L, params, true, true);
    }

    public final void b(@NotNull String opName, @NotNull HashMap<String, String> inputParams) {
        HashMap<String, String> hashMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) opName, (Object) inputParams);
            return;
        }
        Intrinsics.checkNotNullParameter(opName, "opName");
        Intrinsics.checkNotNullParameter(inputParams, "inputParams");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("pvid", String.valueOf(NetConnInfoCenter.getServerTimeMillis())), TuplesKt.to("ext15", com.tencent.mobileqq.ecshop.abtest.b.b()), TuplesKt.to(PreDownloadConstants.RPORT_KEY_BUSINESS_DEPARTMENT, "Vip_pay_mywallet"), TuplesKt.to("plat", "android"), TuplesKt.to("version", AppSetting.f99551k), TuplesKt.to("A8", com.tencent.mobileqq.ecshop.utils.a.a().getCurrentAccountUin()));
        hashMapOf.putAll(inputParams);
        QLog.i("QQShopBeaconReporter", 2, "reportByMap opName: " + opName);
        if (com.tencent.mobileqq.ecshop.utils.a.a() instanceof BaseQQAppInterface) {
            c(opName, hashMapOf);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_report_event", opName);
        bundle.putSerializable("key_report_params", hashMapOf);
        QIPCClientHelper.getInstance().callServer("EcshopIPCModule", "reportToBeacon", bundle, null);
    }

    public final void c(@Nullable final String eventName, @NotNull final HashMap<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) eventName, (Object) params);
        } else {
            Intrinsics.checkNotNullParameter(params, "params");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqshop.report.beacon.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.d(eventName, params);
                }
            }, 16, null, false);
        }
    }
}
