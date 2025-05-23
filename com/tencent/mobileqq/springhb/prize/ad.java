package com.tencent.mobileqq.springhb.prize;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.springhb.pack.PackInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleQualityReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\"\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bH\u0007J0\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0007J\b\u0010\u0012\u001a\u00020\u0006H\u0007J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/springhb/prize/ad;", "", "Lcom/tencent/mobileqq/springhb/pack/PackInfo;", "packInfo", "", "sceneType", "", "e", "", "submoduleId", "", "isExposure", "ext3", tl.h.F, "b", "", "c", "g", "f", WidgetCacheConstellationData.MONEY, "a", "Lcom/tencent/mobileqq/springhb/pack/PackInfo;", "I", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ad {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ad f289558a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static PackInfo packInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int sceneType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61275);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f289558a = new ad();
            packInfo = new PackInfo();
        }
    }

    ad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0.type == 1) goto L8;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(@NotNull String ext3) {
        boolean z16;
        String str;
        ISpringHbReportApi iSpringHbReportApi;
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        PackInfo packInfo2 = packInfo;
        if (packInfo2 != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            str = "cashbutton";
        } else {
            str = "doudicardbutton";
        }
        Map<String, String> c16 = f289558a.c(str, false, ext3);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
            iSpringHbReportApi.reportForGameCenter(c16);
        }
    }

    private final Map<String, String> c(String submoduleId, boolean isExposure, String ext3) {
        boolean z16;
        boolean z17;
        String str;
        String str2;
        Map<String, String> mutableMapOf;
        if (QLog.isColorLevel()) {
            QLog.d("SpringPrizeReport", 1, "ext3:" + ext3);
        }
        PackInfo packInfo2 = packInfo;
        if (packInfo2 != null && packInfo2.type == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "1";
        } else {
            if (packInfo2 != null && packInfo2.type == 102) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                str = "2";
            } else {
                str = "";
            }
        }
        Pair[] pairArr = new Pair[11];
        pairArr[0] = TuplesKt.to("buss_id", "host");
        pairArr[1] = TuplesKt.to("from_src", "2");
        pairArr[2] = TuplesKt.to("module_id", "prizecards");
        pairArr[3] = TuplesKt.to("submodule_id", submoduleId);
        if (isExposure) {
            str2 = "exp";
        } else {
            str2 = "clk";
        }
        pairArr[4] = TuplesKt.to(WadlReportBuilder.TableElem.OPER_ID, str2);
        pairArr[5] = TuplesKt.to(QCircleQualityReporter.KEY_OBJ_ID, packInfo.bizId);
        pairArr[6] = TuplesKt.to("card_id", String.valueOf(packInfo.prizeId));
        pairArr[7] = TuplesKt.to("changci_id", String.valueOf(packInfo.promotionId));
        pairArr[8] = TuplesKt.to("ext1", str);
        pairArr[9] = TuplesKt.to("ext3", ext3);
        pairArr[10] = TuplesKt.to("ext5", h.e());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    static /* synthetic */ Map d(ad adVar, String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return adVar.c(str, z16, str2);
    }

    @JvmStatic
    public static final void e(@Nullable PackInfo packInfo2, int sceneType2) {
        if (packInfo2 == null) {
            packInfo2 = new PackInfo();
        }
        packInfo = packInfo2;
        sceneType = sceneType2;
    }

    @JvmStatic
    public static final void f() {
        i("suspend_floating", false, null, 4, null);
    }

    @JvmStatic
    public static final void g() {
        i("suspend_floating", true, null, 4, null);
    }

    @JvmStatic
    public static final void h(@NotNull String submoduleId, boolean isExposure, @NotNull String ext3) {
        ISpringHbReportApi iSpringHbReportApi;
        Intrinsics.checkNotNullParameter(submoduleId, "submoduleId");
        Intrinsics.checkNotNullParameter(ext3, "ext3");
        Map<String, String> c16 = f289558a.c(submoduleId, isExposure, ext3);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
            iSpringHbReportApi.reportForGameCenter(c16);
        }
    }

    public static /* synthetic */ void i(String str, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        h(str, z16, str2);
    }

    public final void a(int money) {
        Map<String, String> mutableMap;
        ISpringHbReportApi iSpringHbReportApi;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            mutableMap = MapsKt__MapsKt.toMutableMap(d(this, "cash", true, null, 4, null));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")) != null) {
                iSpringHbReportApi.reportForGameCenter(mutableMap);
                return;
            }
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, money);
    }
}
