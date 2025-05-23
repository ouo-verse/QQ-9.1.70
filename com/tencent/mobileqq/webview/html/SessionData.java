package com.tencent.mobileqq.webview.html;

import android.text.TextUtils;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000\u00a2\u0006\u0002\u0010\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R \u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R0\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00160\u00158\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/webview/html/SessionData;", "Lcom/tencent/mobileqq/persistence/Entity;", "sessionData", "(Lcom/tencent/mobileqq/webview/html/SessionData;)V", "()V", "eTag", "", "expiredTime", "", QFSEdgeItem.KEY_EXTEND, "hitCount", "", TextComponent.SpanType.HTML, "getHtml", "()Ljava/lang/String;", "setHtml", "(Ljava/lang/String;)V", "htmlSha1", "htmlSize", "lastModified", "rspHeaders", "", "", "getRspHeaders", "()Ljava/util/Map;", "setRspHeaders", "(Ljava/util/Map;)V", "sessionId", "getTableName", "postRead", "", "prewrite", "toString", "webview_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class SessionData extends Entity {
    static IPatchRedirector $redirector_;

    @JvmField
    @Nullable
    public String eTag;

    @JvmField
    public long expiredTime;

    @JvmField
    @Nullable
    public String extend;

    @JvmField
    public int hitCount;

    @notColumn
    @Nullable
    private String html;

    @JvmField
    @NotNull
    public String htmlSha1;

    @JvmField
    public int htmlSize;

    @JvmField
    @Nullable
    public String lastModified;

    @notColumn
    @NotNull
    private Map<String, List<String>> rspHeaders;

    @unique
    @JvmField
    @NotNull
    public String sessionId;

    public SessionData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sessionId = "";
        this.htmlSha1 = "";
        this.rspHeaders = new LinkedHashMap();
    }

    @Nullable
    public final String getHtml() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.html;
    }

    @NotNull
    public final Map<String, List<String>> getRspHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.rspHeaders;
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    @NotNull
    public String getTableName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "HtmlSessionData";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.postRead();
        this.rspHeaders.clear();
        try {
            jSONObject = new JSONObject(this.extend);
        } catch (Exception unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = ((String) keys.next()).toString();
                JSONArray child = jSONObject.optJSONArray(str);
                if (child != null) {
                    Intrinsics.checkNotNullExpressionValue(child, "child");
                    if (child.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        this.rspHeaders.put(str, arrayList);
                        int length = child.length() - 1;
                        if (length >= 0) {
                            int i3 = 0;
                            while (true) {
                                String optString = child.optString(i3);
                                Intrinsics.checkNotNullExpressionValue(optString, "cd.optString(i)");
                                arrayList.add(optString);
                                if (i3 != length) {
                                    i3++;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.prewrite();
        if (TextUtils.isEmpty(this.extend)) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, List<String>> entry : this.rspHeaders.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<T> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put((String) it.next());
                }
                jSONObject.put(entry.getKey(), jSONArray);
            }
            this.extend = jSONObject.toString();
        }
    }

    public final void setHtml(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.html = str;
        }
    }

    public final void setRspHeaders(@NotNull Map<String, List<String>> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) map);
        } else {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.rspHeaders = map;
        }
    }

    @NotNull
    public String toString() {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String str = this.sessionId;
        int i3 = this.hitCount;
        int i16 = this.htmlSize;
        long j3 = this.expiredTime;
        String str2 = this.lastModified;
        String str3 = this.eTag;
        String str4 = this.htmlSha1;
        int size = this.rspHeaders.size();
        String str5 = this.extend;
        if (str5 != null) {
            num = Integer.valueOf(str5.length());
        } else {
            num = null;
        }
        return "SessionData[ sessionId:" + str + ", hitCount:" + i3 + ", htmlSize:" + i16 + ", expiredTime:" + j3 + ", lastModified:" + str2 + ", eTag:" + str3 + ", sha1:" + str4 + ", rspHeaders:" + size + ", extend:" + num + " ]";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionData(@NotNull SessionData sessionData) {
        this();
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) sessionData);
            return;
        }
        this.sessionId = sessionData.sessionId;
        this.htmlSha1 = sessionData.htmlSha1;
        this.eTag = sessionData.eTag;
        this.lastModified = sessionData.lastModified;
        this.htmlSize = sessionData.htmlSize;
        this.expiredTime = sessionData.expiredTime;
        this.hitCount = sessionData.hitCount;
        this.extend = sessionData.extend;
        setStatus(sessionData.getStatus());
        setId(sessionData.getId());
    }
}
