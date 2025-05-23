package com.tencent.open.agent.report;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.open.agent.report.OpenSdkShareReporterProxy;
import com.tencent.open.agent.report.b;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/open/agent/report/OpenSdkShareReporterProxy;", "", "<init>", "()V", "a", "b", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class OpenSdkShareReporterProxy {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy<b> f340483b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<com.tencent.open.agent.report.b> f340484c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Map<String, b.a> f340485d;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\u0018J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J$\u0010\r\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bH\u0007J\u001e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007R!\u0010\u0019\u001a\u00020\u00128FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006\""}, d2 = {"Lcom/tencent/open/agent/report/OpenSdkShareReporterProxy$a;", "", "", "encode", "d", "", "appId", "Lcom/tencent/open/agent/report/b$a;", "b", "", "c", "", Node.ATTRS_ATTR, "e", "", "Lcom/tencent/open/agent/report/b$c;", "list", "f", "Lcom/tencent/open/agent/report/b;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/open/agent/report/b;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "TAG", "Ljava/lang/String;", "", "reportParamsMap", "Ljava/util/Map;", "reporterList", "Ljava/util/List;", "<init>", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.agent.report.OpenSdkShareReporterProxy$a, reason: from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String d(String encode) {
            boolean z16;
            if (encode != null && encode.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return "";
            }
            try {
                byte[] decode = PluginBaseInfoHelper.Base64Helper.decode(encode, 0);
                Intrinsics.checkNotNullExpressionValue(decode, "decode(encode, Base64Util.DEFAULT)");
                return new String(decode, Charsets.UTF_8);
            } catch (Exception unused) {
                return "";
            }
        }

        @NotNull
        public final com.tencent.open.agent.report.b a() {
            return (com.tencent.open.agent.report.b) OpenSdkShareReporterProxy.f340483b.getValue();
        }

        @JvmStatic
        @NotNull
        public final b.a b(long appId) {
            b.a aVar;
            QLog.d("OpenSdkShareReporterProxy", 2, "getReportParams appId: " + appId + " ");
            synchronized (OpenSdkShareReporterProxy.class) {
                aVar = (b.a) OpenSdkShareReporterProxy.f340485d.get(String.valueOf(appId));
                if (aVar == null) {
                    aVar = new b.a(appId);
                    OpenSdkShareReporterProxy.f340485d.put(String.valueOf(appId), aVar);
                }
            }
            return aVar;
        }

        @JvmStatic
        public final void c(long appId) {
            synchronized (OpenSdkShareReporterProxy.class) {
            }
        }

        @JvmStatic
        public final void e(long appId, @NotNull Map<String, String> attrs) {
            boolean z16;
            Integer intOrNull;
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            b.a b16 = b(appId);
            String d16 = d(attrs.get(AppConstants.Key.SHARE_REQ_TYPE));
            String d17 = d(attrs.get("url"));
            boolean z17 = true;
            int i3 = 0;
            if (d17.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                d17 = OpenSdkShareReporterProxy.INSTANCE.d(attrs.get("detail_url"));
            }
            String d18 = d(attrs.get(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL));
            if (TextUtils.isEmpty(d18)) {
                d18 = d(attrs.get("image_url"));
            }
            String d19 = d(attrs.get("title"));
            if (d19.length() != 0) {
                z17 = false;
            }
            if (z17) {
                d19 = OpenSdkShareReporterProxy.INSTANCE.d(attrs.get("desc"));
            }
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(d16);
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            }
            b16.e(new b.ShareContent(i3, d17, d19, d18));
        }

        @JvmStatic
        public final void f(long appId, @NotNull List<b.ShareTarget> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            b.a b16 = b(appId);
            b16.d().clear();
            b16.d().addAll(list);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/open/agent/report/OpenSdkShareReporterProxy$b;", "Lcom/tencent/open/agent/report/b;", "Lcom/tencent/open/agent/report/b$a;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "c", "Landroid/view/View;", "view", "i", "d", "g", "b", "a", "e", h.F, "", "positive", "f", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements com.tencent.open.agent.report.b {
        @Override // com.tencent.open.agent.report.b
        public void a(@Nullable b.a reportParams) {
            String str;
            if (reportParams != null) {
                str = reportParams.b();
            } else {
                str = null;
            }
            QLog.d("OpenSdkShareReporterProxy", 4, "reportClickSendBtn: " + str);
            Iterator it = OpenSdkShareReporterProxy.f340484c.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.agent.report.b) it.next()).a(reportParams);
            }
        }

        @Override // com.tencent.open.agent.report.b
        public void b(@Nullable View view, @Nullable b.a reportParams) {
            String str;
            if (reportParams != null) {
                str = reportParams.b();
            } else {
                str = null;
            }
            QLog.d("OpenSdkShareReporterProxy", 4, "reportMsgPreviewDialogShow: " + str);
            Iterator it = OpenSdkShareReporterProxy.f340484c.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.agent.report.b) it.next()).b(view, reportParams);
            }
        }

        @Override // com.tencent.open.agent.report.b
        public void c(@Nullable b.a reportParams) {
            String str;
            if (reportParams != null) {
                str = reportParams.b();
            } else {
                str = null;
            }
            QLog.d("OpenSdkShareReporterProxy", 4, "reportShareStart: " + str);
            Iterator it = OpenSdkShareReporterProxy.f340484c.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.agent.report.b) it.next()).c(reportParams);
            }
        }

        @Override // com.tencent.open.agent.report.b
        public void d(@Nullable b.a reportParams) {
            String str;
            if (reportParams != null) {
                str = reportParams.b();
            } else {
                str = null;
            }
            QLog.d("OpenSdkShareReporterProxy", 4, "reportClickCloseBtn: " + str);
            Iterator it = OpenSdkShareReporterProxy.f340484c.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.agent.report.b) it.next()).d(reportParams);
            }
        }

        @Override // com.tencent.open.agent.report.b
        public void e(@Nullable b.a reportParams) {
            String str;
            if (reportParams != null) {
                str = reportParams.b();
            } else {
                str = null;
            }
            QLog.d("OpenSdkShareReporterProxy", 4, "reportClickCancelBtn: " + str);
            Iterator it = OpenSdkShareReporterProxy.f340484c.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.agent.report.b) it.next()).e(reportParams);
            }
        }

        @Override // com.tencent.open.agent.report.b
        public void f(boolean positive, @Nullable b.a reportParams) {
            String str;
            if (reportParams != null) {
                str = reportParams.b();
            } else {
                str = null;
            }
            QLog.d("OpenSdkShareReporterProxy", 4, "reportClickShareCallbackBtn: " + str);
            Iterator it = OpenSdkShareReporterProxy.f340484c.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.agent.report.b) it.next()).f(positive, reportParams);
            }
            if (reportParams != null) {
                OpenSdkShareReporterProxy.INSTANCE.c(reportParams.getAppId());
            }
        }

        @Override // com.tencent.open.agent.report.b
        public void g(@Nullable b.a reportParams) {
            String str;
            if (reportParams != null) {
                str = reportParams.b();
            } else {
                str = null;
            }
            QLog.d("OpenSdkShareReporterProxy", 4, "reportSelectForwardTarget: " + str);
            Iterator it = OpenSdkShareReporterProxy.f340484c.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.agent.report.b) it.next()).g(reportParams);
            }
        }

        @Override // com.tencent.open.agent.report.b
        public void h(@Nullable View view, @Nullable b.a reportParams) {
            String str;
            if (reportParams != null) {
                str = reportParams.b();
            } else {
                str = null;
            }
            QLog.d("OpenSdkShareReporterProxy", 4, "reportShareCallbackDialogShow: " + str);
            Iterator it = OpenSdkShareReporterProxy.f340484c.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.agent.report.b) it.next()).h(view, reportParams);
            }
        }

        @Override // com.tencent.open.agent.report.b
        public void i(@Nullable View view, @Nullable b.a reportParams) {
            String str;
            if (reportParams != null) {
                str = reportParams.b();
            } else {
                str = null;
            }
            QLog.d("OpenSdkShareReporterProxy", 4, "reportForwardPageShow: " + str);
            Iterator it = OpenSdkShareReporterProxy.f340484c.iterator();
            while (it.hasNext()) {
                ((com.tencent.open.agent.report.b) it.next()).i(view, reportParams);
            }
        }
    }

    static {
        Lazy<b> lazy;
        List<com.tencent.open.agent.report.b> listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.open.agent.report.OpenSdkShareReporterProxy$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final OpenSdkShareReporterProxy.b invoke() {
                return new OpenSdkShareReporterProxy.b();
            }
        });
        f340483b = lazy;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new a());
        f340484c = listOf;
        f340485d = new LinkedHashMap();
    }

    @NotNull
    public static final com.tencent.open.agent.report.b d() {
        return INSTANCE.a();
    }

    @JvmStatic
    @NotNull
    public static final b.a e(long j3) {
        return INSTANCE.b(j3);
    }

    @JvmStatic
    public static final void f(long j3, @NotNull Map<String, String> map) {
        INSTANCE.e(j3, map);
    }

    @JvmStatic
    public static final void g(long j3, @NotNull List<b.ShareTarget> list) {
        INSTANCE.f(j3, list);
    }
}
