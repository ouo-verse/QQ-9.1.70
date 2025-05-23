package com.tencent.qqnt.dns;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.dns.IpData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.dns.c;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J4\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J6\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/dns/e;", "Lcom/tencent/qqnt/dns/b;", "", "domain", "", "businessType", "", "allowIpc", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/transfile/dns/IpData;", "Lkotlin/collections/ArrayList;", ReportConstant.COSTREPORT_PREFIX, "action", "Landroid/os/Bundle;", "params", "callbackId", "Leipc/EIPCResult;", "onCall", DomainData.DOMAIN_NAME, "ip", "f", h.F, "Ljava/lang/String;", "mServerProcName", "<init>", "()V", "nt_dns_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mServerProcName;

    public e() {
        super(InnerDns.NAME);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            QIPCClientHelper.getInstance().getClient().connect(null);
            QIPCClientHelper.getInstance().register(this);
        }
    }

    private final ArrayList<IpData> s(String domain, int businessType, boolean allowIpc) {
        int i3;
        if (allowIpc) {
            c.Companion companion = c.INSTANCE;
            Bundle bundle = new Bundle();
            bundle.putString("domain", domain);
            bundle.putInt("businessType", businessType);
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), InnerDns.NAME, "reqDomain2IpList", bundle);
            if (callServer.isSuccess()) {
                return callServer.data.getParcelableArrayList("ip");
            }
            i3 = 20;
        } else {
            i3 = 10;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "getIpDataListIPC error:" + i3);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(e this$0, Bundle params) {
        HashMap<String, HashMap<String, DomainData>> q16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        if (QLog.isColorLevel()) {
            QLog.i(this$0.getTAG(), 1, "syncAddressData called, mServerProcName=" + this$0.mServerProcName);
        }
        String string = params.getString("addressData");
        if (!TextUtils.isEmpty(string) && (q16 = this$0.q(string)) != null) {
            synchronized (this$0) {
                this$0.o(new HashMap<>(q16));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.dns.b
    public int f(@Nullable String domain, @NotNull String ip5, int businessType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, domain, ip5, Integer.valueOf(businessType))).intValue();
        }
        Intrinsics.checkNotNullParameter(ip5, "ip");
        int f16 = super.f(domain, ip5, businessType);
        if (f16 == 0) {
            Bundle bundle = new Bundle();
            bundle.putString("domain", domain);
            bundle.putString("ip", ip5);
            bundle.putInt("businessType", businessType);
            if (!BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), InnerDns.NAME, "reportBadIp", bundle).isSuccess()) {
                return 20;
            }
            return f16;
        }
        return f16;
    }

    @Override // com.tencent.qqnt.dns.b
    @Nullable
    public ArrayList<IpData> n(@Nullable String domain, int businessType, boolean allowIpc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, this, domain, Integer.valueOf(businessType), Boolean.valueOf(allowIpc));
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "reqDns, processId:" + MobileQQ.sProcessId + " domain:" + domain + ", businessType:" + businessType + " , mServerProcName:" + this.mServerProcName);
        }
        if (TextUtils.isEmpty(domain)) {
            return null;
        }
        if (!c().isEmpty()) {
            return b(domain, businessType);
        }
        Intrinsics.checkNotNull(domain);
        return s(domain, businessType, allowIpc);
    }

    @Override // eipc.EIPCModule
    @NotNull
    public EIPCResult onCall(@NotNull String action, @NotNull final Bundle params, int callbackId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EIPCResult) iPatchRedirector.redirect((short) 2, this, action, params, Integer.valueOf(callbackId));
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        if (Intrinsics.areEqual("notifySyncAddressData", action)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.dns.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.t(e.this, params);
                }
            }, 64, null, false);
        }
        EIPCResult createSuccessResult = EIPCResult.createSuccessResult(null);
        Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(null)");
        return createSuccessResult;
    }
}
