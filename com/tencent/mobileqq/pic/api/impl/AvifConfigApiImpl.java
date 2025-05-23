package com.tencent.mobileqq.pic.api.impl;

import com.google.gson.Gson;
import com.tencent.mobileqq.avifcodec.api.IAvifConfigServiceApi;
import com.tencent.mobileqq.avifcodec.b;
import com.tencent.mobileqq.config.business.AvifDownloadConfProcessor;
import com.tencent.mobileqq.config.business.c;
import com.tencent.mobileqq.pic.api.IAvifConfigApi;
import com.tencent.mobileqq.pic.api.NativeAvifConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/pic/api/impl/AvifConfigApiImpl;", "Lcom/tencent/mobileqq/pic/api/IAvifConfigApi;", "", "code", "codecSupport", "", "doReportAvifReqSupport", "", "getAvifConfigForNative", "<init>", "()V", "Companion", "a", "qqpic-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class AvifConfigApiImpl implements IAvifConfigApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "avif_AvifConfigApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/pic/api/impl/AvifConfigApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqpic-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.pic.api.impl.AvifConfigApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17009);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AvifConfigApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void doReportAvifReqSupport(int code, int codecSupport) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_code", String.valueOf(code));
        hashMap.put("param_codec_support", String.valueOf(codecSupport));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.AVIF_REQ_SUPPORT_STATISTIC_TAG, true, 0L, 0L, hashMap, null);
    }

    @Override // com.tencent.mobileqq.pic.api.IAvifConfigApi
    @NotNull
    public String getAvifConfigForNative() {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        c a16 = AvifDownloadConfProcessor.a();
        if (a16 != null && a16.f()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            doReportAvifReqSupport(4, 0);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            doReportAvifReqSupport(12, 0);
            z17 = false;
        } else {
            com.tencent.mobileqq.avifcodec.data.a decoderSupportAndUpdate = ((IAvifConfigServiceApi) QRoute.api(IAvifConfigServiceApi.class)).getDecoderSupportAndUpdate(peekAppRuntime, a16.e());
            if (!decoderSupportAndUpdate.f200174a) {
                doReportAvifReqSupport(5, decoderSupportAndUpdate.f200175b);
            }
            z17 = decoderSupportAndUpdate.f200174a;
        }
        boolean c16 = b.b().c();
        if (!c16) {
            doReportAvifReqSupport(8, 0);
            b.b().f(null);
        }
        if (z16 && z17 && c16) {
            z18 = true;
        } else {
            z18 = false;
        }
        String jsonString = new Gson().toJson(new NativeAvifConfig(z18, a16.b(), a16.a()));
        QLog.i(TAG, 1, "switchOn=" + z16 + ", deviceSupport=" + z17 + ", soLoaded:" + c16 + ", nativeAvifConfig:" + jsonString);
        Intrinsics.checkNotNullExpressionValue(jsonString, "jsonString");
        return jsonString;
    }
}
