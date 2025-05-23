package com.tencent.mobileqq.qwallet.jsp.invoke;

import android.app.Activity;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tenpay.form.queryaccount.IdQueryEntryFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/j;", "Lcom/tencent/mobileqq/qwallet/jsp/invoke/QWInvokeHandler$c;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "jsCallback", "", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class j extends QWInvokeHandler.c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/invoke/j$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "channelInfo", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tokenId", "c", WadlProxyConsts.CHANNEL, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.jsp.invoke.j$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class Request {

        @SerializedName(WadlProxyConsts.CHANNEL)
        @Nullable
        private final String channel;

        @SerializedName("channelInfo")
        @Nullable
        private final String channelInfo;

        @SerializedName("tokenId")
        @Nullable
        private final String tokenId;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getChannel() {
            return this.channel;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getChannelInfo() {
            return this.channelInfo;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getTokenId() {
            return this.tokenId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Request)) {
                return false;
            }
            Request request = (Request) other;
            if (Intrinsics.areEqual(this.channelInfo, request.channelInfo) && Intrinsics.areEqual(this.tokenId, request.tokenId) && Intrinsics.areEqual(this.channel, request.channel)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.channelInfo;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.tokenId;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.channel;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "Request(channelInfo=" + this.channelInfo + ", tokenId=" + this.tokenId + ", channel=" + this.channel + ")";
        }
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.invoke.QWInvokeHandler.b
    public void a(@NotNull WebViewPlugin plugin, @NotNull JSONObject jsonData, @Nullable String jsCallback) {
        Activity activity;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(jsonData, "jsonData");
        Request request = (Request) new GsonBuilder().create().fromJson(jsonData.toString(), Request.class);
        IdQueryEntryFragment.Companion companion = IdQueryEntryFragment.INSTANCE;
        String channelInfo = request.getChannelInfo();
        String tokenId = request.getTokenId();
        String channel = request.getChannel();
        WebViewPlugin.b bVar = plugin.mRuntime;
        if (bVar != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        companion.startIdQuery(channelInfo, tokenId, channel, null, activity);
        if (jsCallback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", 0);
            jSONObject.put("retMsg", "");
            plugin.callJs(jsCallback, jSONObject.toString());
        }
    }
}
