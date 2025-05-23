package com.tencent.mobileqq.vip.api.impl;

import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipTraceDetailReportImpl;", "Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport;", "", "url", "Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport$b;", "from", "getNewDefaultReportInfo", "getTraceDetailInfo", "Lcom/tencent/mobileqq/vip/api/IVipTraceDetailReport$FROM;", "buildTraceDetailUrl", "", "skipWhenExists", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipTraceDetailReportImpl implements IVipTraceDetailReport {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "VipTraceDetailReport";
    private static final boolean bugfix;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipTraceDetailReportImpl$a;", "", "", "TAG", "Ljava/lang/String;", "", "bugfix", "Z", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.VipTraceDetailReportImpl$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50232);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            bugfix = ar.INSTANCE.b("kenaiyu", "2024-11-28", "vas_bug_base64fix").isEnable(true);
        }
    }

    public VipTraceDetailReportImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String getNewDefaultReportInfo(String url, IVipTraceDetailReport.b from) {
        boolean contains$default;
        boolean z16;
        String str;
        boolean z17;
        boolean z18;
        JSONObject jSONObject = new JSONObject();
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            str = "&trace_detail=base64-";
        } else {
            if (url.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str = "trace_detail=base64-";
            } else {
                str = "?trace_detail=base64-";
            }
        }
        try {
            jSONObject.put("appid", from.a());
            jSONObject.put("page_id", from.d());
            if (from.b().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                jSONObject.put("item_id", from.b());
            }
            if (from.c().length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                jSONObject.put("item_type", from.c());
            }
            if (bugfix) {
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
                byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                return str + Base64.encodeToString(bytes, 2);
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.toString()");
            byte[] bytes2 = jSONObject3.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            return str + Base64.encodeToString(bytes2, 0);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "json exception" + e16);
            return str;
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipTraceDetailReport
    @NotNull
    public String buildTraceDetailUrl(@NotNull String url, @NotNull IVipTraceDetailReport.FROM from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) from);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(from, "from");
        return buildTraceDetailUrl(url, from.toData());
    }

    @Override // com.tencent.mobileqq.vip.api.IVipTraceDetailReport
    @NotNull
    public String getTraceDetailInfo(@NotNull IVipTraceDetailReport.b from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) from);
        }
        Intrinsics.checkNotNullParameter(from, "from");
        return getNewDefaultReportInfo("", from);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipTraceDetailReport
    @NotNull
    public String buildTraceDetailUrl(@NotNull String url, @NotNull IVipTraceDetailReport.b from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) url, (Object) from);
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(from, "from");
        return buildTraceDetailUrl(url, from, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014a A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.vip.api.IVipTraceDetailReport
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String buildTraceDetailUrl(@NotNull String url, @NotNull IVipTraceDetailReport.b from, boolean skipWhenExists) {
        boolean startsWith$default;
        boolean startsWith$default2;
        String str;
        List split$default;
        boolean startsWith$default3;
        boolean startsWith$default4;
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, url, from, Boolean.valueOf(skipWhenExists));
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(from, "from");
        if (url.length() == 0) {
            return url;
        }
        if (skipWhenExists) {
            contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "trace_detail=base64-", false, 2, (Object) null);
            if (contains$default3) {
                return url;
            }
        }
        String newDefaultReportInfo = getNewDefaultReportInfo(url, from);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "[" + from + "] \norigin url = " + url + " \nadd = " + newDefaultReportInfo);
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http", false, 2, null);
        if (startsWith$default) {
            str = url + newDefaultReportInfo;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "_proxy", false, 2, (Object) null);
            if (contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "_proxyByURL", false, 2, (Object) null);
                if (!contains$default2) {
                    str = str + "&_proxyByURL=1";
                }
            }
        } else {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "mqqapi://hippy", false, 2, null);
            if (startsWith$default2) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
                StringBuilder sb5 = new StringBuilder();
                boolean z16 = false;
                int i3 = 0;
                for (Object obj : split$default) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    String str2 = (String) obj;
                    startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(str2, "url=trace_detail", false, 2, null);
                    if (!startsWith$default3) {
                        startsWith$default4 = StringsKt__StringsJVMKt.startsWith$default(str2, "url=", false, 2, null);
                        if (startsWith$default4) {
                            sb5.append(str2);
                            sb5.append(URLEncoder.encode(URLEncoder.encode(URLEncoder.encode(newDefaultReportInfo))));
                        } else {
                            sb5.append(str2);
                            if (i3 == str2.length() - 1) {
                                sb5.append(ContainerUtils.FIELD_DELIMITER);
                            }
                            i3 = i16;
                        }
                    } else {
                        sb5.append("url=");
                        String substring = newDefaultReportInfo.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        sb5.append(URLEncoder.encode(URLEncoder.encode(URLEncoder.encode(substring))));
                    }
                    z16 = true;
                    if (i3 == str2.length() - 1) {
                    }
                    i3 = i16;
                }
                if (!z16) {
                    sb5.append("&url=");
                    String substring2 = newDefaultReportInfo.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                    sb5.append(URLEncoder.encode(URLEncoder.encode(URLEncoder.encode(substring2))));
                }
                str = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(str, "sb.toString()");
            } else {
                str = url + newDefaultReportInfo;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "replaceUrl url = " + str);
        }
        return str;
    }
}
