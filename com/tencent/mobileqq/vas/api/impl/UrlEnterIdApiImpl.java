package com.tencent.mobileqq.vas.api.impl;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.vas.api.IUrlEnterIdApi;
import com.tencent.mobileqq.vas.webview.VasWebConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/UrlEnterIdApiImpl;", "Lcom/tencent/mobileqq/vas/api/IUrlEnterIdApi;", "", "pageId", "", "appId", "parseReportEntryStr", "url", "addEntryParamToUrl", "<init>", "()V", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class UrlEnterIdApiImpl implements IUrlEnterIdApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0016\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/UrlEnterIdApiImpl$a;", "", "", "a", "b", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appId", "getPageId", "setPageId", "pageId", "c", "getItemId", "setItemId", "itemId", "d", "getItemType", "setItemType", "itemType", "", "<init>", "(ILjava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String appId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String pageId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String itemId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String itemType;

        public a(int i3, @Nullable String str) {
            if (!TextUtils.isEmpty(str)) {
                this.appId = str;
            } else {
                this.appId = VasWebConstants.REPORT_ORIGIN;
            }
            this.pageId = String.valueOf(i3);
            this.itemId = "";
            this.itemType = "";
        }

        @NotNull
        public final String a() {
            byte[] bytes = b().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(bytes, 0);
            Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(toByteArray, Base64Util.DEFAULT)");
            return encodeToString;
        }

        @NotNull
        public final String b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", this.appId);
                jSONObject.put("page_id", this.pageId);
                jSONObject.put("item_id", this.itemId);
                jSONObject.put("item_type", this.itemType);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("WebReportAdapter", 2, "vas_web_report\uff0cjson: " + e16);
                }
            }
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "result.toString()");
            return jSONObject2;
        }
    }

    private final String parseReportEntryStr(int pageId, String appId) {
        return VasWebConstants.ENTRY_REPORT_PRE + new a(pageId, appId).a();
    }

    @Override // com.tencent.mobileqq.vas.api.IUrlEnterIdApi
    @NotNull
    public String addEntryParamToUrl(@NotNull String url, int pageId, @Nullable String appId) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(url, "url");
        if (QLog.isColorLevel()) {
            QLog.d("WebReportAdapter", 2, "vas_web_report_entry: " + pageId + "-->" + url);
        }
        if (pageId == 0) {
            return url;
        }
        String parseReportEntryStr = parseReportEntryStr(pageId, appId);
        if (!TextUtils.isEmpty(parseReportEntryStr)) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
            if (!contains$default) {
                parseReportEntryStr = new Regex(ContainerUtils.FIELD_DELIMITER).replaceFirst(parseReportEntryStr, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            }
            return url + parseReportEntryStr;
        }
        return url;
    }
}
