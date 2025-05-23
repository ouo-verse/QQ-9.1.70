package com.tencent.qmethod.monitor.ext.traffic;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qmethod.pandoraex.core.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u001a\u0010!\u001a\u00020\u001d8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010)\u001a\u00020\u00048\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u001a\u0010,\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r\u00a8\u0006-"}, d2 = {"Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureCheckPbTask;", "Lcom/tencent/qmethod/monitor/ext/traffic/NetworkCaptureBaseTask;", "Lorg/json/JSONObject;", "i", "", "t", "", "g", "", "e", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "getHttpBody", "()Ljava/lang/String;", "setHttpBody", "(Ljava/lang/String;)V", "httpBody", "G", "p", "url", "", "H", "[B", "getReqBody", "()[B", "reqBody", "I", "k", "requestSource", "", "J", "l", "()J", "requestTimeMills", "K", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "isAgreeBefore", "L", "r", "isBackground", "M", DomainData.DOMAIN_NAME, "stack", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class NetworkCaptureCheckPbTask extends NetworkCaptureBaseTask {

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String httpBody;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final byte[] reqBody;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String requestSource;

    /* renamed from: J, reason: from kotlin metadata */
    private final long requestTimeMills;

    /* renamed from: K, reason: from kotlin metadata */
    private final boolean isAgreeBefore;

    /* renamed from: L, reason: from kotlin metadata */
    private final boolean isBackground;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final String stack;

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    public void e() {
        int collectionSizeOrDefault;
        String joinToString$default;
        byte[] bArr = this.reqBody;
        if (bArr != null) {
            try {
                JSONObject a16 = h.f343733a.a(bArr);
                JSONObject jSONObject = new JSONObject();
                b(a16, jSONObject);
                this.httpBody = jSONObject.toString();
            } catch (Throwable unused) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("reqBody", new String(this.reqBody, Charsets.UTF_8));
                b(jSONObject3, jSONObject2);
                this.httpBody = jSONObject2.getString("reqBody");
            }
        }
        try {
            if (!m().isEmpty()) {
                if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                    o.a("NetworkCapture", "issueNetUrlPb = " + getUrl());
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("issueNetTypePb = ");
                    Collection<NetworkCaptureRule> m3 = m();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(m3, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = m3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((NetworkCaptureRule) it.next()).getSensitiveCategory());
                    }
                    joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null);
                    sb5.append(joinToString$default);
                    o.a("NetworkCapture", sb5.toString());
                    o.a("NetworkCapture", "issueNetDataPb = " + i().toString());
                    o.a("NetworkCapture", "issueNetStackPb = " + getStack());
                }
                if (f()) {
                    if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                        o.a("NetworkCapture", "issueNetUrlPb filterSameQuestion = $" + o());
                        return;
                    }
                    return;
                }
                f fVar = f.f343729e;
                fVar.i(this, fVar.f());
                return;
            }
            if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug() && !a.f343721k.j()) {
                o.a("NetworkCapture", "issueNetUrlPb = " + getUrl());
                o.a("NetworkCapture", "issueNetDataPb = " + i().toString());
                o.a("NetworkCapture", "issueNetStackPb = " + getStack());
            }
        } catch (Exception e16) {
            o.b("NetworkCapture", "issueNetDataPb decodeFail " + getUrl(), e16);
        }
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    @NotNull
    public String g() {
        return getUrl();
    }

    @Override // com.tencent.qmethod.monitor.ext.traffic.NetworkCaptureBaseTask
    @NotNull
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        if (this.reqBody != null) {
            jSONObject.put("PB_Buffer", this.httpBody);
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
        return false;
    }
}
