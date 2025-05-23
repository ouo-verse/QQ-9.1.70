package com.tencent.mobileqq.springhb;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\b\u001a\u00020\u00072\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J.\u0010\u000b\u001a\u00020\u00072\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J&\u0010\f\u001a\u00020\u00072\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J.\u0010\r\u001a\u00020\u00072\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J6\u0010\u0010\u001a\u00020\u000f2\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0005H\u0007R\u001b\u0010\u0019\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/springhb/SpringReporter;", "", "", "", "params", "", "activityType", "", "i", "", "isRealTime", "j", "b", "c", AdMetricTag.Report.TYPE, "Lcom/tencent/mobileqq/springhb/ReportInfo;", tl.h.F, CacheTable.TABLE_NAME, "f", "Lorg/json/JSONObject;", "paramsJSON", "k", "Lkotlin/Lazy;", "d", "()Z", "asyncCallSwitchOn", "Landroid/os/Handler;", "e", "()Landroid/os/Handler;", "commonThreadHandler", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SpringReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SpringReporter f288943a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy asyncCallSwitchOn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy commonThreadHandler;

    static {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20473);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f288943a = new SpringReporter();
        lazy = LazyKt__LazyJVMKt.lazy(SpringReporter$asyncCallSwitchOn$2.INSTANCE);
        asyncCallSwitchOn = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(SpringReporter$commonThreadHandler$2.INSTANCE);
        commonThreadHandler = lazy2;
    }

    SpringReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void b(@NotNull Map<String, String> params, int activityType) {
        Intrinsics.checkNotNullParameter(params, "params");
        c(params, false, activityType);
    }

    @JvmStatic
    public static final void c(@NotNull Map<String, String> params, boolean isRealTime, int activityType) {
        Intrinsics.checkNotNullParameter(params, "params");
        SpringReporter springReporter = f288943a;
        int i3 = 1;
        if (activityType == 1) {
            i3 = 3;
        }
        springReporter.f(springReporter.h(params, isRealTime, i3, activityType));
    }

    private final boolean d() {
        return ((Boolean) asyncCallSwitchOn.getValue()).booleanValue();
    }

    private final Handler e() {
        return (Handler) commonThreadHandler.getValue();
    }

    private final void f(final ReportInfo reportInfo) {
        ISpringHbReportApi iSpringHbReportApi;
        if (!reportInfo.isValid()) {
            com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringReporter", true, "[report] reportInfo is invalid" + reportInfo);
            return;
        }
        if (reportInfo.activityType == 2) {
            return;
        }
        if (MobileQQ.sProcessId == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
                iSpringHbReportApi.report(reportInfo, 1);
                return;
            }
            return;
        }
        if (d()) {
            e().post(new Runnable() { // from class: com.tencent.mobileqq.springhb.z
                @Override // java.lang.Runnable
                public final void run() {
                    SpringReporter.g(ReportInfo.this);
                }
            });
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("key1", reportInfo);
        QIPCClientHelper.getInstance().callServer("SpringHbIPCModule", "ReportData", bundle, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ReportInfo reportInfo) {
        Intrinsics.checkNotNullParameter(reportInfo, "$reportInfo");
        Bundle bundle = new Bundle();
        bundle.putSerializable("key1", reportInfo);
        QIPCClientHelper.getInstance().callServer("SpringHbIPCModule", "ReportData", bundle, null);
    }

    private final ReportInfo h(Map<String, String> params, boolean isRealTime, int reportType, int activityType) {
        String str;
        boolean z16;
        boolean z17 = true;
        com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringReporter", true, "[report] params = " + params + ", isRealTime = " + isRealTime);
        String str2 = params.get("buss_id");
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        String str3 = params.get("from_src");
        if (str3 == null) {
            str3 = "";
        }
        String str4 = params.get("module_id");
        if (str4 == null) {
            str4 = "";
        }
        String str5 = params.get("submodule_id");
        if (str5 == null) {
            str5 = "";
        }
        String str6 = params.get(WadlReportBuilder.TableElem.OPER_ID);
        if (str6 == null) {
            str6 = "";
        }
        HashMap hashMap = new HashMap();
        Iterator<String> it = c.f288968a.iterator();
        while (true) {
            boolean z18 = false;
            if (!it.hasNext()) {
                break;
            }
            String secondaryKey = it.next();
            String str7 = params.get(secondaryKey);
            if (str7 == null || str7.length() == 0) {
                z18 = true;
            }
            if (!z18) {
                Intrinsics.checkNotNullExpressionValue(secondaryKey, "secondaryKey");
                hashMap.put(secondaryKey, str7);
            }
        }
        String c16 = com.tencent.mobileqq.statistics.o.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getQimei36()");
        hashMap.put("dev_id", c16);
        CharSequence charSequence = (CharSequence) hashMap.get("log_type");
        if (charSequence != null && charSequence.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            hashMap.put("log_type", "app");
        }
        CharSequence charSequence2 = (CharSequence) hashMap.get("oper_res");
        if (charSequence2 != null && charSequence2.length() != 0) {
            z17 = false;
        }
        if (z17) {
            hashMap.put("oper_res", "1");
        }
        ReportInfo reportInfo = ReportInfo.create(str, str3, str4, str5, str6, hashMap, isRealTime, reportType, activityType);
        Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
        return reportInfo;
    }

    @JvmStatic
    public static final void i(@NotNull Map<String, String> params, int activityType) {
        Intrinsics.checkNotNullParameter(params, "params");
        j(params, false, activityType);
    }

    @JvmStatic
    public static final void j(@NotNull Map<String, String> params, boolean isRealTime, int activityType) {
        int i3;
        Intrinsics.checkNotNullParameter(params, "params");
        SpringReporter springReporter = f288943a;
        if (activityType == 1) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        springReporter.f(springReporter.h(params, isRealTime, i3, activityType));
    }

    @JvmStatic
    public static final void k(@NotNull JSONObject paramsJSON, int activityType) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(paramsJSON, "paramsJSON");
        String optString = paramsJSON.optString("buss_id");
        String optString2 = paramsJSON.optString("from_src");
        String optString3 = paramsJSON.optString("module_id");
        String optString4 = paramsJSON.optString("submodule_id");
        String optString5 = paramsJSON.optString(WadlReportBuilder.TableElem.OPER_ID);
        JSONObject optJSONObject = paramsJSON.optJSONObject("params");
        boolean z18 = false;
        int optInt = paramsJSON.optInt(TVKDataBinder.KEY_REPORT_TYPE, 0);
        HashMap hashMap = new HashMap();
        if (optJSONObject != null) {
            for (String secondaryKey : c.f288968a) {
                String value = optJSONObject.optString(secondaryKey);
                if (value != null && value.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    Intrinsics.checkNotNullExpressionValue(secondaryKey, "secondaryKey");
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    hashMap.put(secondaryKey, value);
                }
            }
        }
        String c16 = com.tencent.mobileqq.statistics.o.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getQimei36()");
        hashMap.put("dev_id", c16);
        CharSequence charSequence = (CharSequence) hashMap.get("log_type");
        if (charSequence != null && charSequence.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            hashMap.put("log_type", "web");
        }
        CharSequence charSequence2 = (CharSequence) hashMap.get("oper_res");
        if (charSequence2 == null || charSequence2.length() == 0) {
            z18 = true;
        }
        if (z18) {
            hashMap.put("oper_res", "1");
        }
        ReportInfo reportInfo = ReportInfo.create(optString, optString2, optString3, optString4, optString5, hashMap, Intrinsics.areEqual(paramsJSON.optString("immediately", "0"), "1"), optInt, activityType);
        SpringReporter springReporter = f288943a;
        Intrinsics.checkNotNullExpressionValue(reportInfo, "reportInfo");
        springReporter.f(reportInfo);
        com.tencent.mobileqq.springhb.util.b.f289632a.f("Springhb_report.SpringReporter", true, "[webOrArkReport] paramsJSON = " + paramsJSON);
    }
}
