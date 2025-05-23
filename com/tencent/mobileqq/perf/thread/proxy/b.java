package com.tencent.mobileqq.perf.thread.proxy;

import android.os.Build;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 12\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R(\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00105\u001a\u00020)8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/perf/thread/proxy/b;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "Z", "k", "()Z", "p", "(Z)V", "optimize", h.F, "o", "oomReport", "g", DomainData.DOMAIN_NAME, "", "userSample", "D", "l", "()D", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(D)V", "eventSample", "d", "setEventSample", "", "stackDepth", "I", "j", "()I", "setStackDepth", "(I)V", "buglyThreshold", "c", "setBuglyThreshold", "reportInterval", "i", "setReportInterval", "", "Lcom/tencent/mobileqq/perf/thread/proxy/a;", "mfrConfigList", "Ljava/util/List;", "f", "()Ljava/util/List;", "setMfrConfigList", "(Ljava/util/List;)V", "Lcom/tencent/mobileqq/perf/thread/proxy/a;", "e", "()Lcom/tencent/mobileqq/perf/thread/proxy/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/perf/thread/proxy/a;)V", "mfrConfig", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static b f258153f;

    @SerializedName("buglyTHR")
    private int buglyThreshold;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Expose(deserialize = false)
    @NotNull
    private a mfrConfig;

    @SerializedName("eventSmp")
    private double eventSample;

    @SerializedName("mfrCfg")
    @NotNull
    private List<a> mfrConfigList;

    @SerializedName("oomRep")
    private boolean oomReport;

    @SerializedName("opt")
    private boolean optimize;

    @SerializedName("reportINR")
    private int reportInterval;

    @SerializedName("stkDep")
    private int stackDepth;

    @SerializedName("SW")
    private boolean switch;

    @SerializedName("userSmp")
    private double userSample;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/perf/thread/proxy/b$a;", "", "Lcom/tencent/mobileqq/perf/thread/proxy/b;", "a", "", "f", "c", "", "jsonStr", "d", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/perf/thread/proxy/b;", "b", "()Lcom/tencent/mobileqq/perf/thread/proxy/b;", "e", "(Lcom/tencent/mobileqq/perf/thread/proxy/b;)V", "GROUP", "Ljava/lang/String;", "TAG", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.thread.proxy.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (b) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return new b();
        }

        @NotNull
        public final b b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return b.f258153f;
            }
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final b c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            b bVar = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("105592");
            if (bVar == null) {
                return a();
            }
            return bVar;
        }

        @NotNull
        public final b d(@NotNull String jsonStr) {
            Object obj;
            boolean contains$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) jsonStr);
            }
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            b config = (b) new Gson().fromJson(jsonStr, b.class);
            Iterator<T> it = config.f().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    String MANUFACTURER = Build.MANUFACTURER;
                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                    Locale ENGLISH = Locale.ENGLISH;
                    Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
                    String lowerCase = MANUFACTURER.toLowerCase(ENGLISH);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    if (com.tencent.mobileqq.perf.process.util.b.f257946a.d(((a) obj).a(), lowerCase, 0)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            a aVar = (a) obj;
            if (aVar != null) {
                config.m(aVar);
            }
            if (!AppSetting.isPublicVersion()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) jsonStr, (CharSequence) "usePublish", false, 2, (Object) null);
                if (!contains$default && !Utils.K()) {
                    config.p(true);
                    config.o(true);
                    config.n(true);
                    config.q(1.0d);
                }
            }
            QLog.i("ThreadProxy_config", 1, String.valueOf(config));
            Intrinsics.checkNotNullExpressionValue(config, "config");
            return config;
        }

        public final void e(@NotNull b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
            } else {
                Intrinsics.checkNotNullParameter(bVar, "<set-?>");
                b.f258153f = bVar;
            }
        }

        public final void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                e(c());
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44848);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f258153f = companion.c();
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.userSample = 0.01d;
        this.eventSample = 0.01d;
        this.stackDepth = 20;
        this.buglyThreshold = 10;
        this.reportInterval = 15;
        this.mfrConfigList = new ArrayList();
        this.mfrConfig = new a();
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.buglyThreshold;
    }

    public final double d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Double) iPatchRedirector.redirect((short) 10, (Object) this)).doubleValue();
        }
        return this.eventSample;
    }

    @NotNull
    public final a e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (a) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mfrConfig;
    }

    @NotNull
    public final List<a> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mfrConfigList;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.oomReport;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.optimize;
    }

    public final int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.reportInterval;
    }

    public final int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.stackDepth;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.switch;
    }

    public final double l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Double) iPatchRedirector.redirect((short) 8, (Object) this)).doubleValue();
        }
        return this.userSample;
    }

    public final void m(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.mfrConfig = aVar;
        }
    }

    public final void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.oomReport = z16;
        }
    }

    public final void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.optimize = z16;
        }
    }

    public final void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.switch = z16;
        }
    }

    public final void q(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Double.valueOf(d16));
        } else {
            this.userSample = d16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "ThreadProxyConfig, sw=" + this.switch + ", opt=" + this.optimize + ", oomRep=" + this.oomReport + ", userSmp=" + this.userSample + ", eventSmp=" + this.eventSample + ", stackDepth=" + this.stackDepth + ", buglyTHR=" + this.buglyThreshold + ", reportINR=" + this.reportInterval + ", mfrMoreCfg=" + this.mfrConfigList + ", mfrConfig=" + this.mfrConfig;
    }
}
