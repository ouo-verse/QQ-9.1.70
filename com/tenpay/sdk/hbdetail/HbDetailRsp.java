package com.tenpay.sdk.hbdetail;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0004'()*B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JP\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020\tH\u0016J\t\u0010%\u001a\u00020&H\u00d6\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006+"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbDetailRsp;", "Ljava/io/Serializable;", "sender", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;", "self", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "receivers", "", "limit", "", "operationBubble", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;", "(Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;[Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;Ljava/lang/Integer;Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;)V", "getLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOperationBubble", "()Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;", "getReceivers", "()[Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "[Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "getSelf", "()Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "getSender", "()Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;[Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;Ljava/lang/Integer;Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;)Lcom/tenpay/sdk/hbdetail/HbDetailRsp;", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "HbOperationBubble", "HbReceiver", "HbSender", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class HbDetailRsp implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @NotNull
    private static final String TAG = "HbDetailRsp";

    @NotNull
    private static final Lazy<Gson> gson$delegate;

    @Nullable
    private final Integer limit;

    @SerializedName("bubble")
    @Nullable
    private final HbOperationBubble operationBubble;

    @SerializedName("recv_array")
    @Nullable
    private final HbReceiver[] receivers;

    @SerializedName("self_object")
    @Nullable
    private final HbReceiver self;

    @SerializedName("send_object")
    @Nullable
    private final HbSender sender;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbDetailRsp$Companion;", "", "()V", "DATE_FORMAT", "", "TAG", "gson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "fromJson", "Lcom/tenpay/sdk/hbdetail/HbDetailRsp;", "hbDataStr", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Gson getGson() {
            return (Gson) HbDetailRsp.gson$delegate.getValue();
        }

        @JvmStatic
        @NotNull
        public final HbDetailRsp fromJson(@NotNull String hbDataStr) throws JsonSyntaxException {
            Intrinsics.checkNotNullParameter(hbDataStr, "hbDataStr");
            f.a(HbDetailRsp.TAG, "hbDataStr:" + hbDataStr);
            Object fromJson = getGson().fromJson(hbDataStr, (Class<Object>) HbDetailRsp.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(hbDataStr, HbDetailRsp::class.java)");
            return (HbDetailRsp) fromJson;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbOperationBubble;", "", "icon", "", "content", "contentColor", "buttonTxt", "url", CacheTable.TABLE_NAME, "token", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonTxt", "()Ljava/lang/String;", "getContent", "getContentColor", "getIcon", "getReportInfo", "getToken", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class HbOperationBubble {

        @SerializedName(AppDownloadCallback.BUTTON_TXT)
        @Nullable
        private final String buttonTxt;

        @SerializedName("content")
        @Nullable
        private final String content;

        @SerializedName("content_color")
        @Nullable
        private final String contentColor;

        @SerializedName("icon")
        @Nullable
        private final String icon;

        @SerializedName(QQWinkTempConstants.MAIGC_STUDIO_AIGC_RESULT_REPORT_INFO)
        @Nullable
        private final String reportInfo;

        @SerializedName("token")
        @Nullable
        private final String token;

        @SerializedName("url")
        @Nullable
        private final String url;

        public HbOperationBubble(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
            this.icon = str;
            this.content = str2;
            this.contentColor = str3;
            this.buttonTxt = str4;
            this.url = str5;
            this.reportInfo = str6;
            this.token = str7;
        }

        public static /* synthetic */ HbOperationBubble copy$default(HbOperationBubble hbOperationBubble, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = hbOperationBubble.icon;
            }
            if ((i3 & 2) != 0) {
                str2 = hbOperationBubble.content;
            }
            String str8 = str2;
            if ((i3 & 4) != 0) {
                str3 = hbOperationBubble.contentColor;
            }
            String str9 = str3;
            if ((i3 & 8) != 0) {
                str4 = hbOperationBubble.buttonTxt;
            }
            String str10 = str4;
            if ((i3 & 16) != 0) {
                str5 = hbOperationBubble.url;
            }
            String str11 = str5;
            if ((i3 & 32) != 0) {
                str6 = hbOperationBubble.reportInfo;
            }
            String str12 = str6;
            if ((i3 & 64) != 0) {
                str7 = hbOperationBubble.token;
            }
            return hbOperationBubble.copy(str, str8, str9, str10, str11, str12, str7);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getContentColor() {
            return this.contentColor;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getButtonTxt() {
            return this.buttonTxt;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getReportInfo() {
            return this.reportInfo;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        @NotNull
        public final HbOperationBubble copy(@Nullable String icon, @Nullable String content, @Nullable String contentColor, @Nullable String buttonTxt, @Nullable String url, @Nullable String reportInfo, @Nullable String token) {
            return new HbOperationBubble(icon, content, contentColor, buttonTxt, url, reportInfo, token);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HbOperationBubble)) {
                return false;
            }
            HbOperationBubble hbOperationBubble = (HbOperationBubble) other;
            if (Intrinsics.areEqual(this.icon, hbOperationBubble.icon) && Intrinsics.areEqual(this.content, hbOperationBubble.content) && Intrinsics.areEqual(this.contentColor, hbOperationBubble.contentColor) && Intrinsics.areEqual(this.buttonTxt, hbOperationBubble.buttonTxt) && Intrinsics.areEqual(this.url, hbOperationBubble.url) && Intrinsics.areEqual(this.reportInfo, hbOperationBubble.reportInfo) && Intrinsics.areEqual(this.token, hbOperationBubble.token)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getButtonTxt() {
            return this.buttonTxt;
        }

        @Nullable
        public final String getContent() {
            return this.content;
        }

        @Nullable
        public final String getContentColor() {
            return this.contentColor;
        }

        @Nullable
        public final String getIcon() {
            return this.icon;
        }

        @Nullable
        public final String getReportInfo() {
            return this.reportInfo;
        }

        @Nullable
        public final String getToken() {
            return this.token;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            String str = this.icon;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.content;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.contentColor;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.buttonTxt;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.url;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str6 = this.reportInfo;
            if (str6 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str6.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            String str7 = this.token;
            if (str7 != null) {
                i3 = str7.hashCode();
            }
            return i27 + i3;
        }

        @NotNull
        public String toString() {
            return "HbOperationBubble(icon=" + this.icon + ", content=" + this.content + ", contentColor=" + this.contentColor + ", buttonTxt=" + this.buttonTxt + ", url=" + this.url + ", reportInfo=" + this.reportInfo + ", token=" + this.token + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003Jg\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010-\u001a\u00020\u00142\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010/\u001a\u00020\u0003H\u0016J\t\u00100\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u001bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u001b\u00a8\u00061"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbReceiver;", "", "amount", "", "answer", "", WadlProxyConsts.CREATE_TIME, "createTs", "recvListId", "recvName", "recvTinyId", "recvUin", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()I", "getAnswer", "()Ljava/lang/String;", "getCreateTime", "getCreateTs", "isLuck", "", "()Z", "setLuck", "(Z)V", "getRecvListId", "getRecvName", "setRecvName", "(Ljava/lang/String;)V", "getRecvTinyId", "getRecvUin", "tinyAvatarUrl", "getTinyAvatarUrl", "setTinyAvatarUrl", "uinAvatarPath", "getUinAvatarPath", "setUinAvatarPath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class HbReceiver {
        private final int amount;

        @Nullable
        private final String answer;

        @Nullable
        private final String createTime;

        @Nullable
        private final String createTs;
        private boolean isLuck;

        @Nullable
        private final String recvListId;

        @Nullable
        private String recvName;

        @SerializedName("recv_tinyid")
        @Nullable
        private final String recvTinyId;

        @Nullable
        private final String recvUin;

        @Nullable
        private String tinyAvatarUrl;

        @Nullable
        private String uinAvatarPath;

        public HbReceiver(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
            this.amount = i3;
            this.answer = str;
            this.createTime = str2;
            this.createTs = str3;
            this.recvListId = str4;
            this.recvName = str5;
            this.recvTinyId = str6;
            this.recvUin = str7;
        }

        public static /* synthetic */ HbReceiver copy$default(HbReceiver hbReceiver, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i16, Object obj) {
            int i17;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            if ((i16 & 1) != 0) {
                i17 = hbReceiver.amount;
            } else {
                i17 = i3;
            }
            if ((i16 & 2) != 0) {
                str8 = hbReceiver.answer;
            } else {
                str8 = str;
            }
            if ((i16 & 4) != 0) {
                str9 = hbReceiver.createTime;
            } else {
                str9 = str2;
            }
            if ((i16 & 8) != 0) {
                str10 = hbReceiver.createTs;
            } else {
                str10 = str3;
            }
            if ((i16 & 16) != 0) {
                str11 = hbReceiver.recvListId;
            } else {
                str11 = str4;
            }
            if ((i16 & 32) != 0) {
                str12 = hbReceiver.recvName;
            } else {
                str12 = str5;
            }
            if ((i16 & 64) != 0) {
                str13 = hbReceiver.recvTinyId;
            } else {
                str13 = str6;
            }
            if ((i16 & 128) != 0) {
                str14 = hbReceiver.recvUin;
            } else {
                str14 = str7;
            }
            return hbReceiver.copy(i17, str8, str9, str10, str11, str12, str13, str14);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAmount() {
            return this.amount;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getAnswer() {
            return this.answer;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getCreateTime() {
            return this.createTime;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getCreateTs() {
            return this.createTs;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getRecvListId() {
            return this.recvListId;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getRecvName() {
            return this.recvName;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final String getRecvTinyId() {
            return this.recvTinyId;
        }

        @Nullable
        /* renamed from: component8, reason: from getter */
        public final String getRecvUin() {
            return this.recvUin;
        }

        @NotNull
        public final HbReceiver copy(int amount, @Nullable String answer, @Nullable String createTime, @Nullable String createTs, @Nullable String recvListId, @Nullable String recvName, @Nullable String recvTinyId, @Nullable String recvUin) {
            return new HbReceiver(amount, answer, createTime, createTs, recvListId, recvName, recvTinyId, recvUin);
        }

        public boolean equals(@Nullable Object other) {
            Class<?> cls;
            if (this == other) {
                return true;
            }
            if (other != null) {
                cls = other.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(HbReceiver.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tenpay.sdk.hbdetail.HbDetailRsp.HbReceiver");
            HbReceiver hbReceiver = (HbReceiver) other;
            if (this.amount == hbReceiver.amount && Intrinsics.areEqual(this.answer, hbReceiver.answer) && Intrinsics.areEqual(this.createTime, hbReceiver.createTime) && Intrinsics.areEqual(this.createTs, hbReceiver.createTs) && Intrinsics.areEqual(this.recvListId, hbReceiver.recvListId) && Intrinsics.areEqual(this.recvName, hbReceiver.recvName) && Intrinsics.areEqual(this.recvTinyId, hbReceiver.recvTinyId) && Intrinsics.areEqual(this.recvUin, hbReceiver.recvUin) && this.isLuck == hbReceiver.isLuck) {
                return true;
            }
            return false;
        }

        public final int getAmount() {
            return this.amount;
        }

        @Nullable
        public final String getAnswer() {
            return this.answer;
        }

        @Nullable
        public final String getCreateTime() {
            return this.createTime;
        }

        @Nullable
        public final String getCreateTs() {
            return this.createTs;
        }

        @Nullable
        public final String getRecvListId() {
            return this.recvListId;
        }

        @Nullable
        public final String getRecvName() {
            return this.recvName;
        }

        @Nullable
        public final String getRecvTinyId() {
            return this.recvTinyId;
        }

        @Nullable
        public final String getRecvUin() {
            return this.recvUin;
        }

        @Nullable
        public final String getTinyAvatarUrl() {
            return this.tinyAvatarUrl;
        }

        @Nullable
        public final String getUinAvatarPath() {
            return this.uinAvatarPath;
        }

        public int hashCode() {
            int i3;
            int i16;
            int i17;
            int i18;
            int i19;
            int i26;
            int i27 = this.amount * 31;
            String str = this.answer;
            int i28 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i29 = (i27 + i3) * 31;
            String str2 = this.createTime;
            if (str2 != null) {
                i16 = str2.hashCode();
            } else {
                i16 = 0;
            }
            int i36 = (i29 + i16) * 31;
            String str3 = this.createTs;
            if (str3 != null) {
                i17 = str3.hashCode();
            } else {
                i17 = 0;
            }
            int i37 = (i36 + i17) * 31;
            String str4 = this.recvListId;
            if (str4 != null) {
                i18 = str4.hashCode();
            } else {
                i18 = 0;
            }
            int i38 = (i37 + i18) * 31;
            String str5 = this.recvName;
            if (str5 != null) {
                i19 = str5.hashCode();
            } else {
                i19 = 0;
            }
            int i39 = (i38 + i19) * 31;
            String str6 = this.recvTinyId;
            if (str6 != null) {
                i26 = str6.hashCode();
            } else {
                i26 = 0;
            }
            int i46 = (i39 + i26) * 31;
            String str7 = this.recvUin;
            if (str7 != null) {
                i28 = str7.hashCode();
            }
            return ((i46 + i28) * 31) + com.tencent.aio.widget.textView.param.a.a(this.isLuck);
        }

        /* renamed from: isLuck, reason: from getter */
        public final boolean getIsLuck() {
            return this.isLuck;
        }

        public final void setLuck(boolean z16) {
            this.isLuck = z16;
        }

        public final void setRecvName(@Nullable String str) {
            this.recvName = str;
        }

        public final void setTinyAvatarUrl(@Nullable String str) {
            this.tinyAvatarUrl = str;
        }

        public final void setUinAvatarPath(@Nullable String str) {
            this.uinAvatarPath = str;
        }

        @NotNull
        public String toString() {
            return "HbReceiver(amount=" + this.amount + ", answer=" + this.answer + ", createTime=" + this.createTime + ", createTs=" + this.createTs + ", recvListId=" + this.recvListId + ", recvName=" + this.recvName + ", recvTinyId=" + this.recvTinyId + ", recvUin=" + this.recvUin + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\bE\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00c9\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u001cJ\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010@\u001a\u00020\u0010H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010D\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0010H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u0010O\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u00f9\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\u0013\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010X\u001a\u00020\u0003H\u0016J\t\u0010Y\u001a\u00020\u0006H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u001a\u0010\u0012\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010!\"\u0004\b/\u00100R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0011\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001eR\u001c\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010!\"\u0004\b6\u00100R\u0011\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010+R\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001eR\u001c\u0010:\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010!\"\u0004\b<\u00100R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010!\u00a8\u0006Z"}, d2 = {"Lcom/tenpay/sdk/hbdetail/HbDetailRsp$HbSender;", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", WadlProxyConsts.CHANNEL, "grabUinList", "", "invalidTime", "Ljava/util/Date;", "isOwner", "listId", "luckyAmount", "luckyCreateTime", "luckyUin", "mchIcon", "recvAmount", "", "recvNum", "sendName", "sendTinyId", "sendUin", "sendListId", "state", "totalAmount", "totalNum", "type", "wishing", "hbStatusDesc", "(IILjava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJIILjava/lang/String;Ljava/lang/String;)V", "getBusiType", "()I", "getChannel", "getGrabUinList", "()Ljava/lang/String;", "getHbStatusDesc", "getInvalidTime", "()Ljava/util/Date;", "getListId", "getLuckyAmount", "getLuckyCreateTime", "getLuckyUin", "getMchIcon", "getRecvAmount", "()J", "getRecvNum", "getSendListId", "getSendName", "setSendName", "(Ljava/lang/String;)V", "getSendTinyId", "getSendUin", "getState", "tinyIdAvatarUrl", "getTinyIdAvatarUrl", "setTinyIdAvatarUrl", "getTotalAmount", "getTotalNum", "getType", "uinAvatarPath", "getUinAvatarPath", "setUinAvatarPath", "getWishing", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class HbSender {

        @SerializedName("bus_type")
        private final int busiType;
        private final int channel;

        @Nullable
        private final String grabUinList;

        @SerializedName("comment")
        @Nullable
        private final String hbStatusDesc;

        @Nullable
        private final Date invalidTime;

        @NotNull
        private final String isOwner;

        @SerializedName("listid")
        @Nullable
        private final String listId;
        private final int luckyAmount;

        @Nullable
        private final String luckyCreateTime;

        @Nullable
        private final String luckyUin;

        @Nullable
        private final String mchIcon;
        private final long recvAmount;
        private final int recvNum;

        @SerializedName("send_listid")
        @Nullable
        private final String sendListId;

        @NotNull
        private String sendName;

        @SerializedName("send_tinyid")
        @Nullable
        private final String sendTinyId;

        @NotNull
        private final String sendUin;
        private final int state;

        @Nullable
        private String tinyIdAvatarUrl;
        private final long totalAmount;
        private final int totalNum;
        private final int type;

        @Nullable
        private String uinAvatarPath;

        @Nullable
        private final String wishing;

        public HbSender(int i3, int i16, @Nullable String str, @Nullable Date date, @NotNull String isOwner, @Nullable String str2, int i17, @Nullable String str3, @Nullable String str4, @Nullable String str5, long j3, int i18, @NotNull String sendName, @Nullable String str6, @NotNull String sendUin, @Nullable String str7, int i19, long j16, int i26, int i27, @Nullable String str8, @Nullable String str9) {
            Intrinsics.checkNotNullParameter(isOwner, "isOwner");
            Intrinsics.checkNotNullParameter(sendName, "sendName");
            Intrinsics.checkNotNullParameter(sendUin, "sendUin");
            this.busiType = i3;
            this.channel = i16;
            this.grabUinList = str;
            this.invalidTime = date;
            this.isOwner = isOwner;
            this.listId = str2;
            this.luckyAmount = i17;
            this.luckyCreateTime = str3;
            this.luckyUin = str4;
            this.mchIcon = str5;
            this.recvAmount = j3;
            this.recvNum = i18;
            this.sendName = sendName;
            this.sendTinyId = str6;
            this.sendUin = sendUin;
            this.sendListId = str7;
            this.state = i19;
            this.totalAmount = j16;
            this.totalNum = i26;
            this.type = i27;
            this.wishing = str8;
            this.hbStatusDesc = str9;
        }

        /* renamed from: component1, reason: from getter */
        public final int getBusiType() {
            return this.busiType;
        }

        @Nullable
        /* renamed from: component10, reason: from getter */
        public final String getMchIcon() {
            return this.mchIcon;
        }

        /* renamed from: component11, reason: from getter */
        public final long getRecvAmount() {
            return this.recvAmount;
        }

        /* renamed from: component12, reason: from getter */
        public final int getRecvNum() {
            return this.recvNum;
        }

        @NotNull
        /* renamed from: component13, reason: from getter */
        public final String getSendName() {
            return this.sendName;
        }

        @Nullable
        /* renamed from: component14, reason: from getter */
        public final String getSendTinyId() {
            return this.sendTinyId;
        }

        @NotNull
        /* renamed from: component15, reason: from getter */
        public final String getSendUin() {
            return this.sendUin;
        }

        @Nullable
        /* renamed from: component16, reason: from getter */
        public final String getSendListId() {
            return this.sendListId;
        }

        /* renamed from: component17, reason: from getter */
        public final int getState() {
            return this.state;
        }

        /* renamed from: component18, reason: from getter */
        public final long getTotalAmount() {
            return this.totalAmount;
        }

        /* renamed from: component19, reason: from getter */
        public final int getTotalNum() {
            return this.totalNum;
        }

        /* renamed from: component2, reason: from getter */
        public final int getChannel() {
            return this.channel;
        }

        /* renamed from: component20, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @Nullable
        /* renamed from: component21, reason: from getter */
        public final String getWishing() {
            return this.wishing;
        }

        @Nullable
        /* renamed from: component22, reason: from getter */
        public final String getHbStatusDesc() {
            return this.hbStatusDesc;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getGrabUinList() {
            return this.grabUinList;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final Date getInvalidTime() {
            return this.invalidTime;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final String getIsOwner() {
            return this.isOwner;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getListId() {
            return this.listId;
        }

        /* renamed from: component7, reason: from getter */
        public final int getLuckyAmount() {
            return this.luckyAmount;
        }

        @Nullable
        /* renamed from: component8, reason: from getter */
        public final String getLuckyCreateTime() {
            return this.luckyCreateTime;
        }

        @Nullable
        /* renamed from: component9, reason: from getter */
        public final String getLuckyUin() {
            return this.luckyUin;
        }

        @NotNull
        public final HbSender copy(int busiType, int channel, @Nullable String grabUinList, @Nullable Date invalidTime, @NotNull String isOwner, @Nullable String listId, int luckyAmount, @Nullable String luckyCreateTime, @Nullable String luckyUin, @Nullable String mchIcon, long recvAmount, int recvNum, @NotNull String sendName, @Nullable String sendTinyId, @NotNull String sendUin, @Nullable String sendListId, int state, long totalAmount, int totalNum, int type, @Nullable String wishing, @Nullable String hbStatusDesc) {
            Intrinsics.checkNotNullParameter(isOwner, "isOwner");
            Intrinsics.checkNotNullParameter(sendName, "sendName");
            Intrinsics.checkNotNullParameter(sendUin, "sendUin");
            return new HbSender(busiType, channel, grabUinList, invalidTime, isOwner, listId, luckyAmount, luckyCreateTime, luckyUin, mchIcon, recvAmount, recvNum, sendName, sendTinyId, sendUin, sendListId, state, totalAmount, totalNum, type, wishing, hbStatusDesc);
        }

        public boolean equals(@Nullable Object other) {
            Class<?> cls;
            if (this == other) {
                return true;
            }
            if (other != null) {
                cls = other.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(HbSender.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tenpay.sdk.hbdetail.HbDetailRsp.HbSender");
            HbSender hbSender = (HbSender) other;
            if (Intrinsics.areEqual(this.listId, hbSender.listId) && Intrinsics.areEqual(this.sendTinyId, hbSender.sendTinyId) && Intrinsics.areEqual(this.sendUin, hbSender.sendUin)) {
                return true;
            }
            return false;
        }

        public final int getBusiType() {
            return this.busiType;
        }

        public final int getChannel() {
            return this.channel;
        }

        @Nullable
        public final String getGrabUinList() {
            return this.grabUinList;
        }

        @Nullable
        public final String getHbStatusDesc() {
            return this.hbStatusDesc;
        }

        @Nullable
        public final Date getInvalidTime() {
            return this.invalidTime;
        }

        @Nullable
        public final String getListId() {
            return this.listId;
        }

        public final int getLuckyAmount() {
            return this.luckyAmount;
        }

        @Nullable
        public final String getLuckyCreateTime() {
            return this.luckyCreateTime;
        }

        @Nullable
        public final String getLuckyUin() {
            return this.luckyUin;
        }

        @Nullable
        public final String getMchIcon() {
            return this.mchIcon;
        }

        public final long getRecvAmount() {
            return this.recvAmount;
        }

        public final int getRecvNum() {
            return this.recvNum;
        }

        @Nullable
        public final String getSendListId() {
            return this.sendListId;
        }

        @NotNull
        public final String getSendName() {
            return this.sendName;
        }

        @Nullable
        public final String getSendTinyId() {
            return this.sendTinyId;
        }

        @NotNull
        public final String getSendUin() {
            return this.sendUin;
        }

        public final int getState() {
            return this.state;
        }

        @Nullable
        public final String getTinyIdAvatarUrl() {
            return this.tinyIdAvatarUrl;
        }

        public final long getTotalAmount() {
            return this.totalAmount;
        }

        public final int getTotalNum() {
            return this.totalNum;
        }

        public final int getType() {
            return this.type;
        }

        @Nullable
        public final String getUinAvatarPath() {
            return this.uinAvatarPath;
        }

        @Nullable
        public final String getWishing() {
            return this.wishing;
        }

        public int hashCode() {
            int i3;
            String str = this.listId;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            String str2 = this.sendTinyId;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return ((i17 + i16) * 31) + this.sendUin.hashCode();
        }

        @NotNull
        public final String isOwner() {
            return this.isOwner;
        }

        public final void setSendName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sendName = str;
        }

        public final void setTinyIdAvatarUrl(@Nullable String str) {
            this.tinyIdAvatarUrl = str;
        }

        public final void setUinAvatarPath(@Nullable String str) {
            this.uinAvatarPath = str;
        }

        @NotNull
        public String toString() {
            return "HbSender(busiType=" + this.busiType + ", channel=" + this.channel + ", grabUinList=" + this.grabUinList + ", invalidTime=" + this.invalidTime + ", isOwner=" + this.isOwner + ", listId=" + this.listId + ", luckyAmount=" + this.luckyAmount + ", luckyCreateTime=" + this.luckyCreateTime + ", luckyUin=" + this.luckyUin + ", mchIcon=" + this.mchIcon + ", recvAmount=" + this.recvAmount + ", recvNum=" + this.recvNum + ", sendName=" + this.sendName + ", sendTinyId=" + this.sendTinyId + ", sendUin=" + this.sendUin + ", sendListId=" + this.sendListId + ", state=" + this.state + ", totalAmount=" + this.totalAmount + ", totalNum=" + this.totalNum + ", type=" + this.type + ", wishing=" + this.wishing + ", hbStatusDesc=" + this.hbStatusDesc + ")";
        }
    }

    static {
        Lazy<Gson> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Gson>() { // from class: com.tenpay.sdk.hbdetail.HbDetailRsp$Companion$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            }
        });
        gson$delegate = lazy;
    }

    public HbDetailRsp(@Nullable HbSender hbSender, @Nullable HbReceiver hbReceiver, @Nullable HbReceiver[] hbReceiverArr, @Nullable Integer num, @Nullable HbOperationBubble hbOperationBubble) {
        this.sender = hbSender;
        this.self = hbReceiver;
        this.receivers = hbReceiverArr;
        this.limit = num;
        this.operationBubble = hbOperationBubble;
    }

    public static /* synthetic */ HbDetailRsp copy$default(HbDetailRsp hbDetailRsp, HbSender hbSender, HbReceiver hbReceiver, HbReceiver[] hbReceiverArr, Integer num, HbOperationBubble hbOperationBubble, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            hbSender = hbDetailRsp.sender;
        }
        if ((i3 & 2) != 0) {
            hbReceiver = hbDetailRsp.self;
        }
        HbReceiver hbReceiver2 = hbReceiver;
        if ((i3 & 4) != 0) {
            hbReceiverArr = hbDetailRsp.receivers;
        }
        HbReceiver[] hbReceiverArr2 = hbReceiverArr;
        if ((i3 & 8) != 0) {
            num = hbDetailRsp.limit;
        }
        Integer num2 = num;
        if ((i3 & 16) != 0) {
            hbOperationBubble = hbDetailRsp.operationBubble;
        }
        return hbDetailRsp.copy(hbSender, hbReceiver2, hbReceiverArr2, num2, hbOperationBubble);
    }

    @JvmStatic
    @NotNull
    public static final HbDetailRsp fromJson(@NotNull String str) throws JsonSyntaxException {
        return INSTANCE.fromJson(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final HbSender getSender() {
        return this.sender;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final HbReceiver getSelf() {
        return this.self;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final HbReceiver[] getReceivers() {
        return this.receivers;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Integer getLimit() {
        return this.limit;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final HbOperationBubble getOperationBubble() {
        return this.operationBubble;
    }

    @NotNull
    public final HbDetailRsp copy(@Nullable HbSender sender, @Nullable HbReceiver self, @Nullable HbReceiver[] receivers, @Nullable Integer limit, @Nullable HbOperationBubble operationBubble) {
        return new HbDetailRsp(sender, self, receivers, limit, operationBubble);
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(HbDetailRsp.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tenpay.sdk.hbdetail.HbDetailRsp");
        HbDetailRsp hbDetailRsp = (HbDetailRsp) other;
        if (!Intrinsics.areEqual(this.sender, hbDetailRsp.sender) || !Intrinsics.areEqual(this.self, hbDetailRsp.self)) {
            return false;
        }
        HbReceiver[] hbReceiverArr = this.receivers;
        if (hbReceiverArr != null) {
            HbReceiver[] hbReceiverArr2 = hbDetailRsp.receivers;
            if (hbReceiverArr2 == null || !Arrays.equals(hbReceiverArr, hbReceiverArr2)) {
                return false;
            }
        } else if (hbDetailRsp.receivers != null) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Integer getLimit() {
        return this.limit;
    }

    @Nullable
    public final HbOperationBubble getOperationBubble() {
        return this.operationBubble;
    }

    @Nullable
    public final HbReceiver[] getReceivers() {
        return this.receivers;
    }

    @Nullable
    public final HbReceiver getSelf() {
        return this.self;
    }

    @Nullable
    public final HbSender getSender() {
        return this.sender;
    }

    public int hashCode() {
        int i3;
        int i16;
        HbSender hbSender = this.sender;
        int i17 = 0;
        if (hbSender != null) {
            i3 = hbSender.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        HbReceiver hbReceiver = this.self;
        if (hbReceiver != null) {
            i16 = hbReceiver.hashCode();
        } else {
            i16 = 0;
        }
        int i19 = (i18 + i16) * 31;
        HbReceiver[] hbReceiverArr = this.receivers;
        if (hbReceiverArr != null) {
            i17 = Arrays.hashCode(hbReceiverArr);
        }
        return i19 + i17;
    }

    @NotNull
    public String toString() {
        return "HbDetailRsp(sender=" + this.sender + ", self=" + this.self + ", receivers=" + Arrays.toString(this.receivers) + ", limit=" + this.limit + ", operationBubble=" + this.operationBubble + ")";
    }
}
