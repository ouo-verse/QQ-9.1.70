package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.app.Activity;
import android.content.Intent;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.qwallet.student.ChsiCertificationFragment;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0005\u000e\u0015\u001a\t\u0004B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002J\u0014\u0010\t\u001a\u00020\b*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J*\u0010\u0015\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/c;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/ChsiCertificationParams;", "e", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/c$b;", "response", "", "d", "plugin", "jsonData", "", "jsCallback", "a", "Landroid/content/Intent;", "intent", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "b", "Ljava/lang/String;", "currentCallbackId", "<init>", "()V", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c extends QWInvokeHandler.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentCallbackId;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "url", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "token", "b", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/c$d;", "guideConfig", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/c$d;", "a", "()Lcom/tencent/mobileqq/qwallet/jsp/invoke/c$d;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.jsp.invoke.c$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class ChsiCertificationJsRequest {

        @SerializedName("guideConfig")
        @Nullable
        private final GuideConfig guideConfig;

        @SerializedName("token")
        @Nullable
        private final String token;

        @SerializedName("url")
        @Nullable
        private final String url;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final GuideConfig getGuideConfig() {
            return this.guideConfig;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChsiCertificationJsRequest)) {
                return false;
            }
            ChsiCertificationJsRequest chsiCertificationJsRequest = (ChsiCertificationJsRequest) other;
            if (Intrinsics.areEqual(this.url, chsiCertificationJsRequest.url) && Intrinsics.areEqual(this.token, chsiCertificationJsRequest.token) && Intrinsics.areEqual(this.guideConfig, chsiCertificationJsRequest.guideConfig)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.url;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.token;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            GuideConfig guideConfig = this.guideConfig;
            if (guideConfig != null) {
                i3 = guideConfig.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "ChsiCertificationJsRequest(url=" + this.url + ", token=" + this.token + ", guideConfig=" + this.guideConfig + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "code", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/Integer;", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.jsp.invoke.c$b, reason: from toString */
    /* loaded from: classes16.dex */
    private static final /* data */ class ChsiCertificationJsResponse {

        @SerializedName("code")
        @Nullable
        private final Integer code;

        @SerializedName("msg")
        @Nullable
        private final String msg;

        public ChsiCertificationJsResponse(@Nullable Integer num, @Nullable String str) {
            this.code = num;
            this.msg = str;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChsiCertificationJsResponse)) {
                return false;
            }
            ChsiCertificationJsResponse chsiCertificationJsResponse = (ChsiCertificationJsResponse) other;
            if (Intrinsics.areEqual(this.code, chsiCertificationJsResponse.code) && Intrinsics.areEqual(this.msg, chsiCertificationJsResponse.msg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Integer num = this.code;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            String str = this.msg;
            if (str != null) {
                i3 = str.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "ChsiCertificationJsResponse(code=" + this.code + ", msg=" + this.msg + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR$\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/c$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "moreURL", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "successURL", "d", "protocolText", "c", "", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/c$e;", "guideItems", "Ljava/util/List;", "a", "()Ljava/util/List;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.jsp.invoke.c$d, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class GuideConfig {

        @SerializedName("guideItems")
        @Nullable
        private final List<GuideItem> guideItems;

        @SerializedName("moreURL")
        @Nullable
        private final String moreURL;

        @SerializedName("protocolText")
        @Nullable
        private final String protocolText;

        @SerializedName("successURL")
        @Nullable
        private final String successURL;

        @Nullable
        public final List<GuideItem> a() {
            return this.guideItems;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getMoreURL() {
            return this.moreURL;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getProtocolText() {
            return this.protocolText;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getSuccessURL() {
            return this.successURL;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuideConfig)) {
                return false;
            }
            GuideConfig guideConfig = (GuideConfig) other;
            if (Intrinsics.areEqual(this.moreURL, guideConfig.moreURL) && Intrinsics.areEqual(this.successURL, guideConfig.successURL) && Intrinsics.areEqual(this.protocolText, guideConfig.protocolText) && Intrinsics.areEqual(this.guideItems, guideConfig.guideItems)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.moreURL;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.successURL;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.protocolText;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            List<GuideItem> list = this.guideItems;
            if (list != null) {
                i3 = list.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "GuideConfig(moreURL=" + this.moreURL + ", successURL=" + this.successURL + ", protocolText=" + this.protocolText + ", guideItems=" + this.guideItems + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/c$e;", "", "", "toString", "", "hashCode", "other", "", "equals", "id", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "url", "c", "text", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.jsp.invoke.c$e, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class GuideItem {

        @SerializedName("itemId")
        @Nullable
        private final String id;

        @SerializedName("guideText")
        @Nullable
        private final String text;

        @SerializedName("url")
        @Nullable
        private final String url;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuideItem)) {
                return false;
            }
            GuideItem guideItem = (GuideItem) other;
            if (Intrinsics.areEqual(this.id, guideItem.id) && Intrinsics.areEqual(this.url, guideItem.url) && Intrinsics.areEqual(this.text, guideItem.text)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.id;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.url;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.text;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "GuideItem(id=" + this.id + ", url=" + this.url + ", text=" + this.text + ")";
        }
    }

    private final void d(WebViewPlugin webViewPlugin, ChsiCertificationJsResponse chsiCertificationJsResponse) {
        webViewPlugin.callJs(this.currentCallbackId, new GsonBuilder().create().toJson(chsiCertificationJsResponse));
    }

    private final ChsiCertificationParams e(JSONObject jSONObject) {
        String str;
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        try {
            ChsiCertificationJsRequest chsiCertificationJsRequest = (ChsiCertificationJsRequest) new GsonBuilder().create().fromJson(jSONObject.toString(), ChsiCertificationJsRequest.class);
            String url = chsiCertificationJsRequest.getUrl();
            String token = chsiCertificationJsRequest.getToken();
            GuideConfig guideConfig = chsiCertificationJsRequest.getGuideConfig();
            if (guideConfig != null) {
                str = guideConfig.getSuccessURL();
            } else {
                str = null;
            }
            if (guideConfig != null) {
                str2 = guideConfig.getMoreURL();
            } else {
                str2 = null;
            }
            if (guideConfig != null) {
                str3 = guideConfig.getProtocolText();
            } else {
                str3 = null;
            }
            if (url != null && url.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (token != null && token.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    if (str != null && str.length() != 0) {
                        z18 = false;
                    } else {
                        z18 = true;
                    }
                    if (!z18) {
                        ArrayList arrayList = new ArrayList();
                        List<GuideItem> a16 = guideConfig.a();
                        if (a16 != null) {
                            for (GuideItem guideItem : a16) {
                                if (guideItem != null) {
                                    String url2 = guideItem.getUrl();
                                    if (url2 != null && url2.length() != 0) {
                                        z19 = false;
                                    } else {
                                        z19 = true;
                                    }
                                    if (!z19) {
                                        String text = guideItem.getText();
                                        if (text != null && text.length() != 0) {
                                            z26 = false;
                                        } else {
                                            z26 = true;
                                        }
                                        if (!z26) {
                                            String id5 = guideItem.getId();
                                            if (id5 == null) {
                                                id5 = "";
                                            }
                                            arrayList.add(new GuideParamItem(id5, guideItem.getUrl(), guideItem.getText()));
                                        }
                                    }
                                }
                            }
                        }
                        return new ChsiCertificationParams(url, token, str, str3, str2, arrayList);
                    }
                }
            }
            return null;
        } catch (JsonSyntaxException e16) {
            QLog.e("ChsiCertificationProcessor", 1, e16, new Object[0]);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.b
    public void a(@NotNull WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable String jsCallback) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        this.currentCallbackId = jsCallback;
        Activity a16 = plugin.mRuntime.a();
        if (a16 != null && !a16.isFinishing()) {
            ChsiCertificationParams e16 = e(jsonData);
            if (e16 == null) {
                d(plugin, new ChsiCertificationJsResponse(-2, null));
                this.currentCallbackId = null;
                return;
            } else {
                ChsiCertificationFragment.INSTANCE.b(plugin, e16, 1002);
                return;
            }
        }
        QLog.w("ChsiCertificationProcessor", 1, "error, activity is finishing");
        this.currentCallbackId = null;
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.c
    public void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode, int resultCode) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        super.b(plugin, intent, requestCode, resultCode);
        if (requestCode == -22 && resultCode == -1) {
            QLog.i("ChsiCertificationProcessor", 1, "onVerifyFinish: success");
            d(plugin, new ChsiCertificationJsResponse(0, null));
        } else if (requestCode == -22 && resultCode == 0) {
            QLog.i("ChsiCertificationProcessor", 1, "onVerifyFinish: cancel");
            d(plugin, new ChsiCertificationJsResponse(-3, null));
        }
    }
}
