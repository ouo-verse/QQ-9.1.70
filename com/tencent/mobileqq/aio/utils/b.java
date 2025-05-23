package com.tencent.mobileqq.aio.utils;

import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\u0002J&\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J&\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J0\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J&\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007J0\u0010\u0011\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nJ$\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nJ\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020#J\u0016\u0010+\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(J\u0016\u0010.\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0001J\u0016\u00100\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0001R\u0016\u00102\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u00101R \u00105\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0015038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u00104R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0015068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/b;", "", "Landroid/view/View;", "target", "", "", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "elementId", "", "params", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "elementCustomKey", "r", "t", "u", "Lcom/tencent/mobileqq/aio/utils/a;", "builder", tl.h.F, "Lcom/tencent/mobileqq/aio/utils/b$a;", "g", "root", "Landroid/os/Bundle;", "bundle", "d", "i", "a", "k", "eventId", DomainData.DOMAIN_NAME, "o", "p", ReportConstant.COSTREPORT_PREFIX, "", "type", "f", "itemId", "e", "", "isScale", "isMinAio", "b", "key", "cacheVal", "c", "defaultVal", "j", "I", "slideCount", "Ljava/util/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "sParamDataMap", "Ljava/util/Stack;", "Ljava/util/Stack;", "sParamDataStack", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f194119a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int slideCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LinkedHashMap<Integer, a> sParamDataMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Stack<a> sParamDataStack;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015\"\u0004\b\u0016\u0010\u0017R#\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001a0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u0013\u0010\u001cR#\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/b$a;", "", "", "a", "I", "d", "()I", "g", "(I)V", "key", "Lcom/tencent/mobileqq/aio/utils/a;", "b", "Lcom/tencent/mobileqq/aio/utils/a;", "e", "()Lcom/tencent/mobileqq/aio/utils/a;", tl.h.F, "(Lcom/tencent/mobileqq/aio/utils/a;)V", "paramBuilder", "", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "aioDisappearType", "Landroid/util/ArrayMap;", "", "Landroid/util/ArrayMap;", "()Landroid/util/ArrayMap;", "exploreMap", "cacheMap", "<init>", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int key;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.mobileqq.aio.utils.a paramBuilder;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String aioDisappearType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayMap<String, Long> exploreMap;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayMap<String, Object> cacheMap;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.paramBuilder = new com.tencent.mobileqq.aio.utils.a();
            this.aioDisappearType = "3";
            this.exploreMap = new ArrayMap<>();
            this.cacheMap = new ArrayMap<>();
        }

        @NotNull
        public final String a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.aioDisappearType;
        }

        @NotNull
        public final ArrayMap<String, Object> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (ArrayMap) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.cacheMap;
        }

        @NotNull
        public final ArrayMap<String, Long> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (ArrayMap) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.exploreMap;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.key;
        }

        @NotNull
        public final com.tencent.mobileqq.aio.utils.a e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.mobileqq.aio.utils.a) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.paramBuilder;
        }

        public final void f(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            } else {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.aioDisappearType = str;
            }
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            } else {
                this.key = i3;
            }
        }

        public final void h(@NotNull com.tencent.mobileqq.aio.utils.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
            } else {
                Intrinsics.checkNotNullParameter(aVar, "<set-?>");
                this.paramBuilder = aVar;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49805);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        f194119a = new b();
        sParamDataMap = new LinkedHashMap<>();
        sParamDataStack = new Stack<>();
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void l(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        a g16 = f194119a.g();
        if (g16 == null) {
            return;
        }
        Map<String, Object> a16 = g16.e().a();
        a16.put("qq_eid", elementId);
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("qq_clck", a16);
        if (QLog.isDevelopLevel()) {
            QLog.d("AIO_Report", 4, "reportClick " + elementId + ", newMap = " + a16);
        }
    }

    private final void m(View target, Map<String, Object> pageParams) {
        VideoReport.setPageId(target, "pg_aio");
        VideoReport.setPageReportPolicy(target, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(target, new PageParams((Map<String, ?>) pageParams));
        VideoReport.reportPgIn(target, false);
    }

    @JvmStatic
    public static final void q(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        r(elementId, params, "");
    }

    @JvmStatic
    public static final void r(@NotNull String elementId, @Nullable Map<String, ? extends Object> params, @Nullable String elementCustomKey) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        a g16 = f194119a.g();
        if (g16 == null) {
            return;
        }
        g16.c().put(elementId + elementCustomKey, Long.valueOf(System.currentTimeMillis()));
        Map<String, Object> a16 = g16.e().a();
        a16.put("qq_eid", elementId);
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("qq_imp", a16);
        if (QLog.isDevelopLevel()) {
            QLog.d("AIO_Report", 4, "reportQQImp " + elementId + ", newMap = " + a16);
        }
    }

    @JvmStatic
    public static final void t(@NotNull String elementId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        u(elementId, params, "");
    }

    @JvmStatic
    public static final void u(@NotNull String elementId, @Nullable Map<String, ? extends Object> params, @Nullable String elementCustomKey) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        a g16 = f194119a.g();
        if (g16 == null) {
            return;
        }
        Map<String, Object> a16 = g16.e().a();
        a16.put("qq_eid", elementId);
        String str = elementId + elementCustomKey;
        if (g16.c().containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            Long l3 = g16.c().get(str);
            Intrinsics.checkNotNull(l3);
            a16.put("qq_element_lvtm", Long.valueOf(currentTimeMillis - l3.longValue()));
            g16.c().remove(str);
        } else {
            a16.put("qq_element_lvtm", 0);
        }
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("qq_imp_end", a16);
        if (QLog.isDevelopLevel()) {
            QLog.d("AIO_Report", 4, "reportQQImpEnd " + elementId + ", newMap= " + a16);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            slideCount++;
        }
    }

    @NotNull
    public final String b(boolean isScale, boolean isMinAio) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(isScale), Boolean.valueOf(isMinAio));
        }
        if (isScale) {
            return "1";
        }
        if (isMinAio) {
            return "2";
        }
        return "0";
    }

    public final void c(@NotNull String key, @NotNull Object cacheVal) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) key, cacheVal);
            return;
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(cacheVal, "cacheVal");
        a g16 = g();
        if (g16 == null) {
            return;
        }
        g16.b().put(key, cacheVal);
    }

    public final void d(@NotNull View root, @NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) root, (Object) bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        a g16 = g();
        boolean z16 = false;
        if (g16 != null && g16.d() == root.hashCode()) {
            z16 = true;
        }
        if (z16) {
            String string = bundle.getString("aio_disappear_type", "3");
            Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(AIO_DISAPPEAR_TYPE, \"3\")");
            g16.f(string);
            return;
        }
        QLog.d("MsgElementFilePathExtUtil", 1, "cacheExitType paramDTData invalid");
    }

    @NotNull
    public final String e(int itemId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, itemId);
        }
        if (itemId == R.id.bbi) {
            return "1";
        }
        if (itemId == R.id.cjs) {
            return "2";
        }
        if (itemId == R.id.i7f) {
            return "3";
        }
        if (itemId == R.id.f1x) {
            return "4";
        }
        if (itemId == R.id.bfa) {
            return "5";
        }
        if (itemId == R.id.f2w) {
            return "6";
        }
        if (itemId == R.id.c39) {
            return "7";
        }
        if (itemId == R.id.f164194mu) {
            return "8";
        }
        if (itemId == R.id.f164035i0) {
            return "9";
        }
        if (itemId == R.id.fv6) {
            return "10";
        }
        if (itemId == R.id.j0h) {
            return "11";
        }
        if (itemId == R.id.j0e) {
            return "12";
        }
        if (itemId == R.id.zgj) {
            return "13";
        }
        return "";
    }

    @NotNull
    public final String f(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, type);
        }
        if (type != 1000) {
            if (type != 1001) {
                if (type != 1011) {
                    if (type != 1014) {
                        if (type != 1015) {
                            switch (type) {
                                case 1003:
                                    return "1";
                                case 1004:
                                    return "3";
                                case 1005:
                                    return "2";
                                case 1006:
                                    return "5";
                                default:
                                    return "-1";
                            }
                        }
                        return "8";
                    }
                    return "6";
                }
                return "7";
            }
            return "4";
        }
        return "0";
    }

    @Nullable
    public final a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Stack<a> stack = sParamDataStack;
        if (stack.isEmpty()) {
            QLog.d("AIO_Report", 1, "currentParamData sParamDataStack.isEmpty");
            return null;
        }
        return stack.peek();
    }

    public final void h(@NotNull View target, @NotNull com.tencent.mobileqq.aio.utils.a builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) target, (Object) builder);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(builder, "builder");
        LinkedHashMap<Integer, a> linkedHashMap = sParamDataMap;
        if (linkedHashMap.get(Integer.valueOf(target.hashCode())) != null) {
            return;
        }
        a aVar = new a();
        aVar.h(builder);
        aVar.g(target.hashCode());
        linkedHashMap.put(Integer.valueOf(target.hashCode()), aVar);
        sParamDataStack.push(aVar);
        slideCount = 0;
        QLog.d("AIO_Report", 1, "enterAIO " + aVar.d());
        m(target, aVar.e().a());
    }

    public final void i(@NotNull View target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) target);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        LinkedHashMap<Integer, a> linkedHashMap = sParamDataMap;
        a aVar = linkedHashMap.get(Integer.valueOf(target.hashCode()));
        if (aVar == null) {
            QLog.d("AIO_Report", 1, "exitAIO paramData == null, " + target.hashCode());
            return;
        }
        QLog.d("AIO_Report", 1, "exitAIO " + aVar.d());
        HashMap hashMap = new HashMap();
        hashMap.put("aio_disappear_type", aVar.a());
        Map<String, Object> a16 = aVar.e().a();
        if (a16.get("group_id") != null && !Intrinsics.areEqual(a16.get("group_id"), "")) {
            hashMap.put("slide_num", String.valueOf(slideCount));
        }
        a16.putAll(hashMap);
        VideoReport.setPageId(target, "pg_aio");
        VideoReport.setPageReportPolicy(target, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(target, new PageParams((Map<String, ?>) a16));
        VideoReport.reportPgOut(target);
        linkedHashMap.remove(Integer.valueOf(target.hashCode()));
        sParamDataStack.remove(aVar);
        slideCount = 0;
    }

    @NotNull
    public final Object j(@NotNull String key, @NotNull Object defaultVal) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return iPatchRedirector.redirect((short) 16, (Object) this, (Object) key, defaultVal);
        }
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultVal, "defaultVal");
        a g16 = g();
        if (g16 == null) {
            return defaultVal;
        }
        if (!g16.b().containsKey(key)) {
            return defaultVal;
        }
        Object obj = g16.b().get(key);
        if (obj != null) {
            defaultVal = obj;
        }
        g16.b().remove(key);
        return defaultVal;
    }

    public final void k(@NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) elementId);
        } else {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            l(elementId, null);
        }
    }

    public final void n(@NotNull String eventId, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) eventId, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        a g16 = g();
        if (g16 == null) {
            return;
        }
        Map<String, Object> a16 = g16.e().a();
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent(eventId, a16);
        if (QLog.isDevelopLevel()) {
            QLog.d("AIO_Report", 4, "reportEvBas " + eventId + ", newMap = " + a16);
        }
    }

    public final void o(@NotNull String eventId, @Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) eventId, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        VideoReport.reportEvent(eventId, params);
        if (QLog.isDevelopLevel()) {
            QLog.d("AIO_Report", 4, "reportEvBas " + eventId + ", params = " + params);
        }
    }

    public final void p(@NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) elementId);
        } else {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            q(elementId, null);
        }
    }

    public final void s(@NotNull String elementId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) elementId);
        } else {
            Intrinsics.checkNotNullParameter(elementId, "elementId");
            t(elementId, null);
        }
    }
}
