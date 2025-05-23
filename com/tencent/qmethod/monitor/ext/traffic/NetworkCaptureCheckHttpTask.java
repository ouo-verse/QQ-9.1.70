package com.tencent.qmethod.monitor.ext.traffic;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.Typography;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u00101\u001a\u0004\u0018\u00010.\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u000205\u0012\b\b\u0002\u0010>\u001a\u00020\u0014\u0012\b\b\u0002\u0010A\u001a\u00020\u0014\u0012\b\b\u0002\u0010D\u001a\u00020\u0003\u0012\b\b\u0002\u0010G\u001a\u00020\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u0002\u0012\b\b\u0002\u0010L\u001a\u00020\u0003\u0012\b\b\u0002\u0010O\u001a\u000205\u00a2\u0006\u0004\bP\u0010QJ\"\u0010\u0007\u001a\u00020\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u001c\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00060\fj\u0002`\r8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010&\u001a\u00060\fj\u0002`\r8\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00030'j\b\u0012\u0004\u0012\u00020\u0003`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010\b\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001bR\u0016\u00101\u001a\u0004\u0018\u00010.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001a\u00104\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b2\u0010\u0019\u001a\u0004\b3\u0010\u001bR\u001a\u00109\u001a\u0002058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b6\u0010,\u001a\u0004\b7\u00108R\u001a\u0010>\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001a\u0010A\u001a\u00020\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b@\u0010=R\u001a\u0010D\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bB\u0010\u0019\u001a\u0004\bC\u0010\u001bR\u001a\u0010G\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\bE\u0010\u0019\u001a\u0004\bF\u0010\u001bR&\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0017\u0010L\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\bJ\u0010\u0019\u001a\u0004\bK\u0010\u001bR\u0017\u0010O\u001a\u0002058\u0006\u00a2\u0006\f\n\u0004\bM\u0010,\u001a\u0004\bN\u00108\u00a8\u0006R"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureCheckHttpTask;", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureBaseTask;", "", "", "", "headerMap", "", "u", "url", HippyTKDListViewAdapter.X, "v", "value", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "paramContent", "y", "body", "w", "Lorg/json/JSONObject;", "i", "", "t", "e", "g", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "getHttpBody", "()Ljava/lang/String;", "setHttpBody", "(Ljava/lang/String;)V", "httpBody", "G", "Ljava/lang/StringBuilder;", "getHttpHeader", "()Ljava/lang/StringBuilder;", "httpHeader", "H", "getHttpUrlParams", "httpUrlParams", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "I", "Ljava/util/ArrayList;", "whiteHosts", "J", "p", "", "K", "[B", "reqBody", "L", "k", "requestSource", "", "M", "l", "()J", "requestTimeMills", "N", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "isAgreeBefore", "P", "r", "isBackground", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, tl.h.F, "monitorMethod", BdhLogUtil.LogTag.Tag_Req, DomainData.DOMAIN_NAME, "stack", ExifInterface.LATITUDE_SOUTH, "Ljava/util/Map;", "T", "getContentType", "contentType", "U", "getContentLength", "contentLength", "<init>", "(Ljava/lang/String;[BLjava/lang/String;JZZLjava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;J)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class NetworkCaptureCheckHttpTask extends NetworkCaptureBaseTask {

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String httpBody;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final StringBuilder httpHeader;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final StringBuilder httpUrlParams;

    /* renamed from: I, reason: from kotlin metadata */
    private final ArrayList<String> whiteHosts;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: K, reason: from kotlin metadata */
    private final byte[] reqBody;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final String requestSource;

    /* renamed from: M, reason: from kotlin metadata */
    private final long requestTimeMills;

    /* renamed from: N, reason: from kotlin metadata */
    private final boolean isAgreeBefore;

    /* renamed from: P, reason: from kotlin metadata */
    private final boolean isBackground;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final String monitorMethod;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final String stack;

    /* renamed from: S, reason: from kotlin metadata */
    private final Map<String, List<String>> headerMap;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final String contentType;

    /* renamed from: U, reason: from kotlin metadata */
    private final long contentLength;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NetworkCaptureCheckHttpTask(@NotNull String url, @Nullable byte[] bArr, @NotNull String requestSource, long j3, boolean z16, boolean z17, @NotNull String monitorMethod, @NotNull String stack, @NotNull Map<String, ? extends List<String>> headerMap, @NotNull String contentType, long j16) {
        super(url, requestSource, j3, z16, z17, monitorMethod, stack, null, 0, MsgConstant.KRMFILETHUMBSIZE384, null);
        ArrayList<String> arrayListOf;
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(requestSource, "requestSource");
        Intrinsics.checkParameterIsNotNull(monitorMethod, "monitorMethod");
        Intrinsics.checkParameterIsNotNull(stack, "stack");
        Intrinsics.checkParameterIsNotNull(headerMap, "headerMap");
        Intrinsics.checkParameterIsNotNull(contentType, "contentType");
        this.url = url;
        this.reqBody = bArr;
        this.requestSource = requestSource;
        this.requestTimeMills = j3;
        this.isAgreeBefore = z16;
        this.isBackground = z17;
        this.monitorMethod = monitorMethod;
        this.stack = stack;
        this.headerMap = headerMap;
        this.contentType = contentType;
        this.contentLength = j16;
        this.httpHeader = new StringBuilder();
        this.httpUrlParams = new StringBuilder();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("qq.com");
        this.whiteHosts = arrayListOf;
    }

    private final void u(Map<String, ? extends List<String>> headerMap) {
        boolean contains$default;
        boolean contains$default2;
        for (Map.Entry<String, ? extends List<String>> entry : headerMap.entrySet()) {
            NetworkCaptureRule a16 = b.a(entry.getKey());
            if (a16 != null) {
                m().add(a16);
                c.c(this.httpHeader, entry.getKey());
                this.httpHeader.append(":");
                int i3 = 0;
                for (Object obj : entry.getValue()) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    String str = (String) obj;
                    if (i3 != 0) {
                        this.httpHeader.append(",");
                    }
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ContainerUtils.FIELD_DELIMITER, false, 2, (Object) null);
                    if (contains$default) {
                        this.httpHeader.append(v(str));
                    } else {
                        y(str, this.httpHeader);
                    }
                    i3 = i16;
                }
                this.httpHeader.append(" ");
            } else {
                this.httpHeader.append(entry.getKey());
                this.httpHeader.append(":");
                int i17 = 0;
                for (Object obj2 : entry.getValue()) {
                    int i18 = i17 + 1;
                    if (i17 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    String str2 = (String) obj2;
                    if (i17 != 0) {
                        this.httpHeader.append(", ");
                    }
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) ContainerUtils.FIELD_DELIMITER, false, 2, (Object) null);
                    if (contains$default2) {
                        this.httpHeader.append(v(str2));
                    } else {
                        y(str2, this.httpHeader);
                    }
                    i17 = i18;
                }
                this.httpHeader.append(" ");
            }
        }
    }

    private final String v(String url) {
        List<String> split$default;
        List split$default2;
        String str;
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        if (split$default != null) {
            for (String str2 : split$default) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                String str3 = (String) split$default2.get(0);
                if (split$default2.size() > 1) {
                    str = (String) split$default2.get(1);
                } else {
                    str = "";
                }
                NetworkCaptureRule a16 = b.a(str3);
                if (a16 != null) {
                    m().add(a16);
                    c.c(sb5, str3);
                    sb5.append(":");
                    y(str, sb5);
                    arrayList.add(String.valueOf(str3));
                } else {
                    arrayList.add(str2);
                    sb5.append(str3);
                    sb5.append(":");
                    y(str, sb5);
                }
                sb5.append(" ");
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "paramContent.toString()");
        return sb6;
    }

    private final void w(String body) {
        boolean contains$default;
        boolean contains$default2;
        List split$default;
        List split$default2;
        try {
            JSONObject jSONObject = new JSONObject(body);
            JSONObject jSONObject2 = new JSONObject();
            b(jSONObject, jSONObject2);
            this.httpBody = jSONObject2.toString();
        } catch (Exception unused) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) body, Typography.amp, false, 2, (Object) null);
            if (contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) body, (CharSequence) " ", false, 2, (Object) null);
                if (!contains$default2) {
                    try {
                        split$default = StringsKt__StringsKt.split$default((CharSequence) body, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
                        StringBuilder sb5 = new StringBuilder();
                        if (split$default != null) {
                            Iterator it = split$default.iterator();
                            while (it.hasNext()) {
                                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                                String str = (String) split$default2.get(0);
                                String str2 = "";
                                if (split$default2.size() > 1) {
                                    str2 = (String) split$default2.get(1);
                                }
                                NetworkCaptureRule a16 = b.a(str);
                                if (a16 != null) {
                                    m().add(a16);
                                    c.c(sb5, str);
                                    sb5.append(":");
                                    y(str2, sb5);
                                } else {
                                    sb5.append(str);
                                    sb5.append(":");
                                    y(str2, sb5);
                                }
                                sb5.append(" ");
                            }
                        }
                        this.httpBody = sb5.toString();
                        return;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("reqBody", body);
            b(jSONObject4, jSONObject3);
            this.httpBody = jSONObject3.getString("reqBody");
        }
    }

    private final String x(String url) {
        List split$default;
        Object orNull;
        List<String> list;
        List split$default2;
        Object orNull2;
        String joinToString$default;
        List split$default3;
        String str;
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, 1);
        String str2 = (String) orNull;
        if (str2 != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb5 = this.httpUrlParams;
        if (list != null) {
            for (String str3 : list) {
                split$default3 = StringsKt__StringsKt.split$default((CharSequence) str3, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                String str4 = (String) split$default3.get(0);
                if (split$default3.size() > 1) {
                    str = (String) split$default3.get(1);
                } else {
                    str = "";
                }
                NetworkCaptureRule a16 = b.a(str4);
                if (a16 != null) {
                    m().add(a16);
                    c.c(sb5, str4);
                    sb5.append(":");
                    y(str, sb5);
                    arrayList.add(String.valueOf(str4));
                } else {
                    arrayList.add(str3);
                    sb5.append(str4);
                    sb5.append(":");
                    y(str, sb5);
                }
                sb5.append(" ");
            }
        }
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(split$default2, 0);
        String str5 = (String) orNull2;
        if (str5 != null) {
            url = str5;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(url);
        sb6.append('?');
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
        sb6.append(joinToString$default);
        return sb6.toString();
    }

    private final void y(String value, StringBuilder paramContent) {
        Pair<List<g>, String> a16 = a(value);
        List<g> component1 = a16.component1();
        String component2 = a16.component2();
        if (!component1.isEmpty()) {
            Iterator<T> it = component1.iterator();
            while (it.hasNext()) {
                m().add(((g) it.next()).getMatchRule());
            }
            c.b(paramContent, component2, component1);
            return;
        }
        c.a(paramContent, component2);
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    public void e() {
        int collectionSizeOrDefault;
        List distinct;
        String joinToString$default;
        x(getUrl());
        byte[] bArr = this.reqBody;
        if (bArr != null) {
            w(new String(bArr, Charsets.UTF_8));
        }
        u(this.headerMap);
        try {
            if (!m().isEmpty()) {
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                    o.a("NetworkCapture", "issueNet" + getMonitorMethod() + "Url = " + getUrl() + "  method = " + getMonitorMethod() + TokenParser.SP + this.contentType + TokenParser.SP + this.contentLength + " }");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("issueNet");
                    sb5.append(getMonitorMethod());
                    sb5.append("Type = ");
                    Collection<NetworkCaptureRule> m3 = m();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(m3, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = m3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((NetworkCaptureRule) it.next()).getSensitiveCategory());
                    }
                    distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(distinct, null, null, null, 0, null, null, 63, null);
                    sb5.append(joinToString$default);
                    o.a("NetworkCapture", sb5.toString());
                    o.a("NetworkCapture", "issueNet" + getMonitorMethod() + "Data = " + i().toString());
                    byte[] bArr2 = this.reqBody;
                    if (bArr2 != null) {
                        o.a("NetworkCapture", "issueNet" + getMonitorMethod() + "Size = " + bArr2.length);
                    }
                    o.a("NetworkCapture", "issueNet" + getMonitorMethod() + "StackHttp = " + getStack());
                }
                d.f343723b.a(this);
                if (f()) {
                    if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                        o.a("NetworkCapture", "issueNet" + getMonitorMethod() + "Http filterSameQuestion = " + o());
                        return;
                    }
                    return;
                }
                f fVar = f.f343729e;
                fVar.i(this, fVar.f());
                return;
            }
            if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug() && !a.f343721k.j()) {
                o.a("NetworkCapture", "issueNet" + getMonitorMethod() + "Url = " + getUrl() + "  method = " + getMonitorMethod() + TokenParser.SP + this.contentType + TokenParser.SP + this.contentLength);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("issueNet");
                sb6.append(getMonitorMethod());
                sb6.append("Data = ");
                sb6.append(i().toString());
                o.a("NetworkCapture", sb6.toString());
                byte[] bArr3 = this.reqBody;
                if (bArr3 != null) {
                    o.a("NetworkCapture", "issueNet" + getMonitorMethod() + "Size = " + bArr3.length);
                }
                o.a("NetworkCapture", "issueNet" + getMonitorMethod() + "Stack = " + getStack());
            }
        } catch (Exception e16) {
            o.d("NetworkCapture", "issueNetDataHttp decodeFail " + getUrl(), e16);
        }
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    @NotNull
    public String g() {
        List split$default;
        Object orNull;
        List list;
        List split$default2;
        Object orNull2;
        String joinToString$default;
        List split$default3;
        split$default = StringsKt__StringsKt.split$default((CharSequence) getUrl(), new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        orNull = CollectionsKt___CollectionsKt.getOrNull(split$default, 1);
        String str = (String) orNull;
        if (str != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                split$default3 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                arrayList.add(String.valueOf((String) split$default3.get(0)));
            }
        }
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) getUrl(), new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(split$default2, 0);
        String str2 = (String) orNull2;
        if (str2 == null) {
            str2 = getUrl();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str2);
        sb5.append('?');
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
        sb5.append(joinToString$default);
        return sb5.toString();
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    @NotNull
    /* renamed from: h, reason: from getter */
    public String getMonitorMethod() {
        return this.monitorMethod;
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    @NotNull
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("HTTP_Parameter", this.httpUrlParams.toString());
        jSONObject.put("HTTP_Header", this.httpHeader.toString());
        if (this.reqBody != null) {
            jSONObject.put("HTTP_Body", this.httpBody);
        }
        return jSONObject;
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    @NotNull
    /* renamed from: k, reason: from getter */
    public String getRequestSource() {
        return this.requestSource;
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    /* renamed from: l, reason: from getter */
    public long getRequestTimeMills() {
        return this.requestTimeMills;
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    @NotNull
    /* renamed from: n, reason: from getter */
    public String getStack() {
        return this.stack;
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    @NotNull
    /* renamed from: p, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    /* renamed from: q, reason: from getter */
    public boolean getIsAgreeBefore() {
        return this.isAgreeBefore;
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    /* renamed from: r, reason: from getter */
    public boolean getIsBackground() {
        return this.isBackground;
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    public boolean t() {
        boolean contains$default;
        ArrayList<String> arrayList = this.whiteHosts;
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return true;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) getUrl(), (CharSequence) it.next(), false, 2, (Object) null);
            if (contains$default) {
                return false;
            }
        }
        return true;
    }
}
