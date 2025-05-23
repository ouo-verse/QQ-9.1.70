package com.tencent.mobileqq.webview.config;

import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\bJ\b\u0010\f\u001a\u00020\u0006H\u0016R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/webview/config/c;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObj", "", "a", "", "host", "", "b", "c", "d", "toString", "", "Ljava/util/List;", "blackHosts", "e", "whiteHosts", "f", "Z", "onlyFirstPage", "<init>", "()V", h.F, "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class c implements IConfigData {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<String> blackHosts;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<String> whiteHosts;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean onlyFirstPage;

    public c() {
        List<String> listOf;
        List<String> emptyList;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{FlockBaseRequest.QUN_DOMAIN, ITeamWorkHandler.DOCS_DOMAIN});
        this.blackHosts = listOf;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.whiteHosts = emptyList;
        this.onlyFirstPage = true;
    }

    public final void a(JSONObject jsonObj) {
        Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
        if (QLog.isColorLevel()) {
            QLog.d("htmlAgent_HtmlAgentConfigParser", 2, "from json:" + jsonObj);
        }
        this.onlyFirstPage = jsonObj.optBoolean("onlyFirstPage", true);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.blackHosts);
        JSONArray optJSONArray = jsonObj.optJSONArray("black");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString) && !arrayList.contains(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        this.blackHosts = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.whiteHosts);
        JSONArray optJSONArray2 = jsonObj.optJSONArray("white");
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                String optString2 = optJSONArray2.optString(i16);
                if (!TextUtils.isEmpty(optString2) && !arrayList2.contains(optString2)) {
                    arrayList2.add(optString2);
                }
            }
        }
        this.whiteHosts = arrayList2;
    }

    public final boolean b(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        String lowerCase = host.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        List<String> list = this.blackHosts;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (AuthorizeConfig.P((String) it.next(), lowerCase)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        String lowerCase = host.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        List<String> list = this.whiteHosts;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (AuthorizeConfig.P((String) it.next(), lowerCase)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getOnlyFirstPage() {
        return this.onlyFirstPage;
    }

    public String toString() {
        String joinToString$default;
        String joinToString$default2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onlyFirstPage= ");
        sb5.append(this.onlyFirstPage);
        sb5.append(" whites= ");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.whiteHosts, null, null, null, 0, null, null, 63, null);
        sb5.append(joinToString$default);
        sb5.append(" blacks= ");
        joinToString$default2 = CollectionsKt___CollectionsKt.joinToString$default(this.blackHosts, null, null, null, 0, null, null, 63, null);
        sb5.append(joinToString$default2);
        return sb5.toString();
    }
}
