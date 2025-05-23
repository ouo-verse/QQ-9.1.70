package com.tencent.mobileqq.vas.pay.page.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import du4.d;
import j23.f;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0007,-./012Bg\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010%\u001a\u00020$\u00a2\u0006\u0004\b)\u0010*R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020$8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig;", "", "", "vipProtocol", "Ljava/lang/String;", "getVipProtocol", "()Ljava/lang/String;", "autoRenewalProtocol", "getAutoRenewalProtocol", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Hippy;", "hippy", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Hippy;", "getHippy", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Hippy;", "", "", "Ldu4/d;", "payInfo", "Ljava/util/Map;", "getPayInfo", "()Ljava/util/Map;", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Vip2Retention;", "retention", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Vip2Retention;", "getRetention", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Vip2Retention;", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Person;", "person", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Person;", "getPerson", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Person;", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "phoneCall", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "getPhoneCall", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$MaxYearTip;", "maxYear", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$MaxYearTip;", "getMaxYear", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$MaxYearTip;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Hippy;Ljava/util/Map;Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Vip2Retention;Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Person;Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$MaxYearTip;)V", "Companion", "a", "DialogCall", HippyQQConstants.HIPPY_TAG, "MaxYearTip", "Person", "RetentionInfo", "Vip2Retention", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class RenewalPageToggleConfig {

    @NotNull
    private static final String AUTO_PAY_PROTOCOL_URL = "https://m.vip.qq.com/clubact/2017/iap/privacy-policy-norenewing.html";

    @NotNull
    private static final String AVALIABLE_TEXT = "\u5c0a\u8d35\u7684SVIP\uff0c\u4f60\u7684\u4f1a\u5458\u8eab\u4efd\u5728%s\u5929\u540e\u5c31\u8981\u8fc7\u671f\u5566\uff01\u786e\u5b9a\u8981\u79bb\u5f00\u5417\uff1f";

    @NotNull
    private static final String AVALIABLE_TODAY_TEXT = "\u4f60\u7684\u4f1a\u5458\u8eab\u4efd\u5728\u4eca\u5929\u5c31\u8981\u8fc7\u671f\u5566\uff01";

    @NotNull
    private static final String EXPIRED_TEXT = "\u4f60\u7684SVIP\u5df2\u8fc7\u671f%s\u5929\u5566\uff0c\u73b0\u5728\u7eed\u8d39\u7acb\u5373\u6062\u590d\u6240\u6709\u7279\u6743\u54e6\uff01\u786e\u5b9a\u8981\u79bb\u5f00\u5417\uff1f";

    @NotNull
    private static final String LEFT_TEXT = "\u6211\u518d\u60f3\u60f3";

    @NotNull
    private static final String RIGHT_TEXT = "\u72e0\u5fc3\u79bb\u5f00";

    @NotNull
    private static final String SVIP_PROTOCOL_URL = "https://m.vip.qq.com/club/policy/privacy-policy-pay-svip.html";

    @NotNull
    private static final String USER_AVALIABLE_TEXT = "%s\u5230\u671f";

    @NotNull
    private static final String USER_EXPIRED_TEXT = "%s\u5df2\u8fc7\u671f%s\u5929";

    @NotNull
    private static final String USER_IS_NEW_TEXT = "\u5f00\u901a\u8d85\u7ea7\u4f1a\u5458\uff0c\u4eabSVIP\u94ed\u724c\u7b49100+\u7279\u6743";

    @SerializedName("auto_renewal_protocol")
    @NotNull
    private final String autoRenewalProtocol;

    @SerializedName("hippy")
    @Nullable
    private final Hippy hippy;

    @SerializedName("maxYearPay")
    @NotNull
    private final MaxYearTip maxYear;

    @SerializedName("payInfo")
    @Nullable
    private final Map<Integer, d> payInfo;

    @SerializedName("person")
    @NotNull
    private final Person person;

    @SerializedName("phoneCall")
    @NotNull
    private final DialogCall phoneCall;

    @SerializedName("retention")
    @NotNull
    private final Vip2Retention retention;

    @SerializedName("vip_protocol")
    @NotNull
    private final String vipProtocol;

    @Keep
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B/\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "", "", "toString", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "content", "getContent", MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, "getConfirm", "cancel", "getCancel", WadlProxyConsts.KEY_JUMP_URL, "getJumpUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class DialogCall {

        @SerializedName("cancel")
        @NotNull
        private final String cancel;

        @SerializedName(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM)
        @NotNull
        private final String confirm;

        @SerializedName("content")
        @NotNull
        private final String content;

        @SerializedName(WadlProxyConsts.KEY_JUMP_URL)
        @NotNull
        private final String jumpUrl;

        @SerializedName("title")
        @NotNull
        private final String title;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static final DialogCall phonePayInstance = new DialogCall("\u6e29\u99a8\u63d0\u793a", "\u4f60\u5f53\u524d\u662f\u624b\u673a\u8bdd\u8d39\u4f1a\u5458\uff0c\u987b\u5173\u95ed\u624b\u673a\u4f1a\u5458\uff0c\u5728\u672c\u9875\u9762\u8d2d\u4e70\u7684\u4f1a\u5458\u624d\u80fd\u6b63\u5e38\u5230\u8d26\u54e6~", "\u7ee7\u7eed\u652f\u4ed8", "\u67e5\u770b\u5173\u95ed\u5f15\u5bfc", "https://kf.qq.com/touch/faq/1709133YZRnY170913rmAF7R.html");

        @NotNull
        private static final DialogCall _2099Instance = new DialogCall("\u6e29\u99a8\u63d0\u9192", "\u4f60\u7684\u4f1a\u5458\u5df2\u5f00\u901a\u81f32099\u5e74\uff0c\u65e0\u6cd5\u6b63\u5e38\u5f00\u901a\u3002", "\u786e\u5b9a", "\u53d6\u6d88", "");

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall$a;", "", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "phonePayInstance", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "a", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "_2099Instance", "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vas.pay.page.bean.RenewalPageToggleConfig$DialogCall$a, reason: from kotlin metadata */
        /* loaded from: classes20.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final DialogCall a() {
                return DialogCall.phonePayInstance;
            }

            @NotNull
            public final DialogCall b() {
                return DialogCall._2099Instance;
            }

            Companion() {
            }
        }

        public DialogCall(@NotNull String title, @NotNull String content, @NotNull String confirm, @NotNull String cancel, @NotNull String jumpUrl) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(confirm, "confirm");
            Intrinsics.checkNotNullParameter(cancel, "cancel");
            Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
            this.title = title;
            this.content = content;
            this.confirm = confirm;
            this.cancel = cancel;
            this.jumpUrl = jumpUrl;
        }

        @NotNull
        public final String getCancel() {
            return this.cancel;
        }

        @NotNull
        public final String getConfirm() {
            return this.confirm;
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        @NotNull
        public final String getJumpUrl() {
            return this.jumpUrl;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public String toString() {
            return "DialogCall(title='" + this.title + "', content='" + this.content + "', confirm='" + this.confirm + "', cancel='" + this.cancel + "', jumpUrl='" + this.jumpUrl + "')";
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Hippy;", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "hippyHeight", IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO, "Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "(IILcom/tencent/hippy/qq/api/OpenHippyInfo;)V", "getHippyHeight", "()I", "getHippyInfo", "()Lcom/tencent/hippy/qq/api/OpenHippyInfo;", "getSwitch", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Hippy {

        @SerializedName("hippy_height")
        private final int hippyHeight;

        @SerializedName("openParams")
        @Nullable
        private final OpenHippyInfo hippyInfo;

        @SerializedName(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)
        private final int switch;

        public Hippy() {
            this(0, 0, null, 7, null);
        }

        public final int getHippyHeight() {
            return this.hippyHeight;
        }

        @Nullable
        public final OpenHippyInfo getHippyInfo() {
            return this.hippyInfo;
        }

        public final int getSwitch() {
            return this.switch;
        }

        public Hippy(int i3, int i16, @Nullable OpenHippyInfo openHippyInfo) {
            this.switch = i3;
            this.hippyHeight = i16;
            this.hippyInfo = openHippyInfo;
        }

        public /* synthetic */ Hippy(int i3, int i16, OpenHippyInfo openHippyInfo, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 1 : i3, (i17 & 2) != 0 ? 700 : i16, (i17 & 4) != 0 ? null : openHippyInfo);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$MaxYearTip;", "", "maxYear", "", "dialog", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "(ILcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;)V", "getDialog", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "getMaxYear", "()I", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class MaxYearTip {

        @SerializedName("dialog")
        @NotNull
        private final DialogCall dialog;

        @SerializedName("maxYear")
        private final int maxYear;

        public MaxYearTip() {
            this(0, null, 3, 0 == true ? 1 : 0);
        }

        @NotNull
        public final DialogCall getDialog() {
            return this.dialog;
        }

        public final int getMaxYear() {
            return this.maxYear;
        }

        public MaxYearTip(int i3, @NotNull DialogCall dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            this.maxYear = i3;
            this.dialog = dialog;
        }

        public /* synthetic */ MaxYearTip(int i3, DialogCall dialogCall, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 2099 : i3, (i16 & 2) != 0 ? DialogCall.INSTANCE.b() : dialogCall);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\r\u001a\u00020\u0003R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Person;", "", "userNewText", "", "userAvaliableText", "userExpiredText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserAvaliableText", "()Ljava/lang/String;", "getUserExpiredText", "getUserNewText", "getAvaliableText", "getExpiredText", "getNewText", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Person {

        @SerializedName("avaliable")
        @NotNull
        private final String userAvaliableText;

        @SerializedName("expired")
        @NotNull
        private final String userExpiredText;

        @SerializedName(QCircleDaTongConstant.ElementParamValue.NEW)
        @NotNull
        private final String userNewText;

        public Person() {
            this(null, null, null, 7, null);
        }

        @NotNull
        public final String getAvaliableText() {
            String b16;
            b16 = f.b(this.userAvaliableText, RenewalPageToggleConfig.USER_AVALIABLE_TEXT);
            return b16;
        }

        @NotNull
        public final String getExpiredText() {
            String b16;
            b16 = f.b(this.userExpiredText, RenewalPageToggleConfig.USER_EXPIRED_TEXT);
            return b16;
        }

        @NotNull
        public final String getNewText() {
            String b16;
            b16 = f.b(this.userNewText, RenewalPageToggleConfig.USER_IS_NEW_TEXT);
            return b16;
        }

        @NotNull
        public final String getUserAvaliableText() {
            return this.userAvaliableText;
        }

        @NotNull
        public final String getUserExpiredText() {
            return this.userExpiredText;
        }

        @NotNull
        public final String getUserNewText() {
            return this.userNewText;
        }

        public Person(@NotNull String userNewText, @NotNull String userAvaliableText, @NotNull String userExpiredText) {
            Intrinsics.checkNotNullParameter(userNewText, "userNewText");
            Intrinsics.checkNotNullParameter(userAvaliableText, "userAvaliableText");
            Intrinsics.checkNotNullParameter(userExpiredText, "userExpiredText");
            this.userNewText = userNewText;
            this.userAvaliableText = userAvaliableText;
            this.userExpiredText = userExpiredText;
        }

        public /* synthetic */ Person(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3);
        }
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$Vip2Retention;", "", "svipRetentionInfo", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo;", "(Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo;)V", "getSvipRetentionInfo", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo;", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Vip2Retention {

        @SerializedName("svip")
        @NotNull
        private final RetentionInfo svipRetentionInfo;

        public Vip2Retention() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final RetentionInfo getSvipRetentionInfo() {
            return this.svipRetentionInfo;
        }

        public Vip2Retention(@NotNull RetentionInfo svipRetentionInfo) {
            Intrinsics.checkNotNullParameter(svipRetentionInfo, "svipRetentionInfo");
            this.svipRetentionInfo = svipRetentionInfo;
        }

        public /* synthetic */ Vip2Retention(RetentionInfo retentionInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? RetentionInfo.INSTANCE.a() : retentionInfo);
        }
    }

    public RenewalPageToggleConfig() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    @NotNull
    public final String getAutoRenewalProtocol() {
        return this.autoRenewalProtocol;
    }

    @Nullable
    public final Hippy getHippy() {
        return this.hippy;
    }

    @NotNull
    public final MaxYearTip getMaxYear() {
        return this.maxYear;
    }

    @Nullable
    public final Map<Integer, d> getPayInfo() {
        return this.payInfo;
    }

    @NotNull
    public final Person getPerson() {
        return this.person;
    }

    @NotNull
    public final DialogCall getPhoneCall() {
        return this.phoneCall;
    }

    @NotNull
    public final Vip2Retention getRetention() {
        return this.retention;
    }

    @NotNull
    public final String getVipProtocol() {
        return this.vipProtocol;
    }

    public RenewalPageToggleConfig(@NotNull String vipProtocol, @NotNull String autoRenewalProtocol, @Nullable Hippy hippy, @Nullable Map<Integer, d> map, @NotNull Vip2Retention retention, @NotNull Person person, @NotNull DialogCall phoneCall, @NotNull MaxYearTip maxYear) {
        Intrinsics.checkNotNullParameter(vipProtocol, "vipProtocol");
        Intrinsics.checkNotNullParameter(autoRenewalProtocol, "autoRenewalProtocol");
        Intrinsics.checkNotNullParameter(retention, "retention");
        Intrinsics.checkNotNullParameter(person, "person");
        Intrinsics.checkNotNullParameter(phoneCall, "phoneCall");
        Intrinsics.checkNotNullParameter(maxYear, "maxYear");
        this.vipProtocol = vipProtocol;
        this.autoRenewalProtocol = autoRenewalProtocol;
        this.hippy = hippy;
        this.payInfo = map;
        this.retention = retention;
        this.person = person;
        this.phoneCall = phoneCall;
        this.maxYear = maxYear;
    }

    @Keep
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0014B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo;", "", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "I", "getSwitch", "()I", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo$RetentionCell;", "expire", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo$RetentionCell;", "getExpire", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo$RetentionCell;", "avaliable", "getAvaliable", "today", "getToday", "<init>", "(ILcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo$RetentionCell;Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo$RetentionCell;Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo$RetentionCell;)V", "Companion", "a", "RetentionCell", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class RetentionInfo {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static final RetentionInfo svipRetention = new RetentionInfo(1, new RetentionCell(RenewalPageToggleConfig.LEFT_TEXT, RenewalPageToggleConfig.RIGHT_TEXT, RenewalPageToggleConfig.EXPIRED_TEXT, -90, -1, RenewalPageToggleConfig.EXPIRED_TEXT), new RetentionCell(RenewalPageToggleConfig.LEFT_TEXT, RenewalPageToggleConfig.RIGHT_TEXT, RenewalPageToggleConfig.AVALIABLE_TEXT, 1, 30, RenewalPageToggleConfig.AVALIABLE_TEXT), new RetentionCell(RenewalPageToggleConfig.LEFT_TEXT, RenewalPageToggleConfig.RIGHT_TEXT, RenewalPageToggleConfig.AVALIABLE_TODAY_TEXT, 0, 0, RenewalPageToggleConfig.AVALIABLE_TEXT));

        @SerializedName("avaliable")
        @NotNull
        private final RetentionCell avaliable;

        @SerializedName("expire")
        @NotNull
        private final RetentionCell expire;

        @SerializedName(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH)
        private final int switch;

        @SerializedName("today")
        @NotNull
        private final RetentionCell today;

        @Keep
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo$RetentionCell;", "", "left", "", "right", "text", "start", "", "end", "defText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getEnd", "()I", "getLeft", "()Ljava/lang/String;", "getRight", "getStart", "getText", "getLeftText", "getRightText", "getTextValue", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes20.dex */
        public static final class RetentionCell {

            @NotNull
            private final String defText;

            @SerializedName("end")
            private final int end;

            @SerializedName("left")
            @NotNull
            private final String left;

            @SerializedName("right")
            @NotNull
            private final String right;

            @SerializedName("start")
            private final int start;

            @SerializedName("text")
            @NotNull
            private final String text;

            public RetentionCell(@NotNull String left, @NotNull String right, @NotNull String text, int i3, int i16, @NotNull String defText) {
                Intrinsics.checkNotNullParameter(left, "left");
                Intrinsics.checkNotNullParameter(right, "right");
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(defText, "defText");
                this.left = left;
                this.right = right;
                this.text = text;
                this.start = i3;
                this.end = i16;
                this.defText = defText;
            }

            public final int getEnd() {
                return this.end;
            }

            @NotNull
            public final String getLeft() {
                return this.left;
            }

            @NotNull
            public final String getLeftText() {
                String b16;
                b16 = f.b(this.left, RenewalPageToggleConfig.RIGHT_TEXT);
                return b16;
            }

            @NotNull
            public final String getRight() {
                return this.right;
            }

            @NotNull
            public final String getRightText() {
                String b16;
                b16 = f.b(this.right, RenewalPageToggleConfig.LEFT_TEXT);
                return b16;
            }

            public final int getStart() {
                return this.start;
            }

            @NotNull
            public final String getText() {
                return this.text;
            }

            @NotNull
            public final String getTextValue() {
                String b16;
                b16 = f.b(this.text, this.defText);
                return b16;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo$a;", "", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo;", "svipRetention", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo;", "a", "()Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$RetentionInfo;", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vas.pay.page.bean.RenewalPageToggleConfig$RetentionInfo$a, reason: from kotlin metadata */
        /* loaded from: classes20.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final RetentionInfo a() {
                return RetentionInfo.svipRetention;
            }

            Companion() {
            }
        }

        public RetentionInfo(int i3, @NotNull RetentionCell expire, @NotNull RetentionCell avaliable, @NotNull RetentionCell today) {
            Intrinsics.checkNotNullParameter(expire, "expire");
            Intrinsics.checkNotNullParameter(avaliable, "avaliable");
            Intrinsics.checkNotNullParameter(today, "today");
            this.switch = i3;
            this.expire = expire;
            this.avaliable = avaliable;
            this.today = today;
        }

        @NotNull
        public final RetentionCell getAvaliable() {
            return this.avaliable;
        }

        @NotNull
        public final RetentionCell getExpire() {
            return this.expire;
        }

        public final int getSwitch() {
            return this.switch;
        }

        @NotNull
        public final RetentionCell getToday() {
            return this.today;
        }

        public /* synthetic */ RetentionInfo(int i3, RetentionCell retentionCell, RetentionCell retentionCell2, RetentionCell retentionCell3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3, retentionCell, retentionCell2, retentionCell3);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ RenewalPageToggleConfig(String str, String str2, Hippy hippy, Map map, Vip2Retention vip2Retention, Person person, DialogCall dialogCall, MaxYearTip maxYearTip, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r2, r3, r5, r6, r7, r8, r0);
        Vip2Retention vip2Retention2;
        MaxYearTip maxYearTip2;
        String str3 = (i3 & 1) != 0 ? SVIP_PROTOCOL_URL : str;
        String str4 = (i3 & 2) != 0 ? AUTO_PAY_PROTOCOL_URL : str2;
        RetentionInfo retentionInfo = null;
        byte b16 = 0;
        byte b17 = 0;
        byte b18 = 0;
        Hippy hippy2 = (i3 & 4) != 0 ? null : hippy;
        Map map2 = (i3 & 8) != 0 ? null : map;
        if ((i3 & 16) != 0) {
            vip2Retention2 = new Vip2Retention(retentionInfo, 1, b18 == true ? 1 : 0);
        } else {
            vip2Retention2 = vip2Retention;
        }
        Person person2 = (i3 & 32) != 0 ? new Person(null, null, null, 7, null) : person;
        DialogCall a16 = (i3 & 64) != 0 ? DialogCall.INSTANCE.a() : dialogCall;
        if ((i3 & 128) != 0) {
            maxYearTip2 = new MaxYearTip(0, b17 == true ? 1 : 0, 3, b16 == true ? 1 : 0);
        } else {
            maxYearTip2 = maxYearTip;
        }
    }
}
