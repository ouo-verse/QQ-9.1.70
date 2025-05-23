package com.qwallet.temp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.y;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0002&'J,\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH&J\u001c\u0010\u0013\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H&J,\u0010 \u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020\u001eH&J0\u0010%\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H&\u00a8\u0006("}, d2 = {"Lcom/qwallet/temp/IPayShareMsgTempApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/qwallet/temp/IPayShareMsgTempApi$a;", "listener", "", "createShareMsgImpl", "shareMsgImpl", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "", "initWebInterface", "Lcom/tencent/mobileqq/webview/swift/y;", "baseInterface", "onShareMsgImplSetWebUiInterface", "onShareMsgImplDestroy", "Lcom/qwallet/temp/IPayShareMsgTempApi$b;", "shareArkParam", "Lorg/json/JSONObject;", "buildArkMsgParamJSON", "", "shareSupportType", "convertShareType", "forwardType", "dataObj", "", "handleWhiteList", "shareArkMsgToQQ", "requestCode", "", "forwardTitle", "forwardDialogText", "forwardMsgToQQ", "a", "b", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IPayShareMsgTempApi extends QRouteApi {

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/qwallet/temp/IPayShareMsgTempApi$a;", "", "", "callbackId", "result", "", "a", "Landroid/content/Intent;", "intent", "", "requestCode", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public interface a {
        void a(@Nullable String callbackId, @Nullable String result);

        void startActivityForResult(@Nullable Intent intent, byte requestCode);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0013\u0010\u000bR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0015\u0010\u000bR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u0017\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/qwallet/temp/IPayShareMsgTempApi$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "app", "b", h.F, "view", "c", "d", PublicAccountMessageUtilImpl.META_NAME, "g", "ver", "e", DownloadInfo.spKey_Config, "f", "desc", "prompt", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "shareSupportType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qwallet.temp.IPayShareMsgTempApi$b, reason: from toString */
    /* loaded from: classes3.dex */
    public static final /* data */ class ShareArkParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String app;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String view;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String meta;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String ver;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String config;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String desc;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String prompt;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Integer shareSupportType;

        public ShareArkParam() {
            this(null, null, null, null, null, null, null, null, 255, null);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getApp() {
            return this.app;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getConfig() {
            return this.config;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getMeta() {
            return this.meta;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getPrompt() {
            return this.prompt;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShareArkParam)) {
                return false;
            }
            ShareArkParam shareArkParam = (ShareArkParam) other;
            if (Intrinsics.areEqual(this.app, shareArkParam.app) && Intrinsics.areEqual(this.view, shareArkParam.view) && Intrinsics.areEqual(this.meta, shareArkParam.meta) && Intrinsics.areEqual(this.ver, shareArkParam.ver) && Intrinsics.areEqual(this.config, shareArkParam.config) && Intrinsics.areEqual(this.desc, shareArkParam.desc) && Intrinsics.areEqual(this.prompt, shareArkParam.prompt) && Intrinsics.areEqual(this.shareSupportType, shareArkParam.shareSupportType)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final Integer getShareSupportType() {
            return this.shareSupportType;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final String getVer() {
            return this.ver;
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final String getView() {
            return this.view;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            int hashCode7;
            String str = this.app;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.view;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.meta;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.ver;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (i18 + hashCode4) * 31;
            String str5 = this.config;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (i19 + hashCode5) * 31;
            String str6 = this.desc;
            if (str6 == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = str6.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            String str7 = this.prompt;
            if (str7 == null) {
                hashCode7 = 0;
            } else {
                hashCode7 = str7.hashCode();
            }
            int i28 = (i27 + hashCode7) * 31;
            Integer num = this.shareSupportType;
            if (num != null) {
                i3 = num.hashCode();
            }
            return i28 + i3;
        }

        @NotNull
        public String toString() {
            return "ShareArkParam(app=" + this.app + ", view=" + this.view + ", meta=" + this.meta + ", ver=" + this.ver + ", config=" + this.config + ", desc=" + this.desc + ", prompt=" + this.prompt + ", shareSupportType=" + this.shareSupportType + ')';
        }

        public ShareArkParam(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Integer num) {
            this.app = str;
            this.view = str2;
            this.meta = str3;
            this.ver = str4;
            this.config = str5;
            this.desc = str6;
            this.prompt = str7;
            this.shareSupportType = num;
        }

        public /* synthetic */ ShareArkParam(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : str6, (i3 & 64) != 0 ? null : str7, (i3 & 128) == 0 ? num : null);
        }
    }

    @NotNull
    JSONObject buildArkMsgParamJSON(@NotNull ShareArkParam shareArkParam);

    int convertShareType(int shareSupportType);

    @Nullable
    Object createShareMsgImpl(@NotNull Context context, @Nullable Activity activity, @NotNull AppInterface appInterface, @NotNull a listener);

    void forwardMsgToQQ(@NotNull Activity activity, int requestCode, int forwardType, @NotNull String forwardTitle, @NotNull String forwardDialogText) throws Exception;

    void initWebInterface(@Nullable Object shareMsgImpl, @NotNull WebViewPlugin plugin);

    void onShareMsgImplDestroy(@Nullable Object shareMsgImpl);

    void onShareMsgImplSetWebUiInterface(@Nullable Object shareMsgImpl, @Nullable y baseInterface);

    void shareArkMsgToQQ(int forwardType, @Nullable Object shareMsgImpl, @Nullable JSONObject dataObj, boolean handleWhiteList) throws Exception;
}
