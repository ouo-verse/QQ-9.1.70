package com.tenpay.idverify.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.helper.RealNameAgePopHelper;
import cooperation.qwallet.plugin.FakeUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qk2.ChildRealNameConfig;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0002&'B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\bH\u00c6\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0003J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\n\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006("}, d2 = {"Lcom/tenpay/idverify/model/ChildrenRealNameConfig;", "", "applyNewStrategy", "", "rejectAge", "parentConfirmAge", "majorityAge", "nonAgeRejectTip", "Lcom/tenpay/idverify/model/ChildrenRealNameConfig$PopConfig;", "childAgeTip", "nonAgeGuideTip", "(IIIILcom/tenpay/idverify/model/ChildrenRealNameConfig$PopConfig;Lcom/tenpay/idverify/model/ChildrenRealNameConfig$PopConfig;Lcom/tenpay/idverify/model/ChildrenRealNameConfig$PopConfig;)V", "getApplyNewStrategy", "()I", "getChildAgeTip", "()Lcom/tenpay/idverify/model/ChildrenRealNameConfig$PopConfig;", "getMajorityAge", "getNonAgeGuideTip", "getNonAgeRejectTip", "getParentConfirmAge", "getRejectAge", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "getRealNameAgeType", "Lcom/tenpay/sdk/helper/RealNameAgePopHelper$EnumPopAgeType;", "age", "hashCode", "toString", "", "Companion", "PopConfig", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final /* data */ class ChildrenRealNameConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ChildrenRealNameConfig DEFAULT = new ChildrenRealNameConfig(1, 8, 16, 18, new PopConfig("\u4f60\u7684\u5e74\u9f84\u672a\u6ee1 8 \u5468\u5c81\uff0c\u6839\u636e\u56fd\u5bb6\u6cd5\u5f8b\u6cd5\u89c4\u548c\u76d1\u7ba1\u8981\u6c42\uff0c\u6682\u65e0\u6cd5\u4f7f\u7528QQ\u652f\u4ed8\u76f8\u5173\u529f\u80fd", null, "\u6211\u77e5\u9053\u4e86", null, 10, null), new PopConfig("\u6839\u636e\u4f60\u63d0\u4f9b\u7684\u4fe1\u606f\uff0c\u4f60\u5c5e\u4e8e\u672a\u6210\u5e74\u4eba\u3002\u4f9d\u636e\u6cd5\u5f8b\u6cd5\u89c4\u53ca\u76d1\u7ba1\u89c4\u5b9a\uff0c\u4f60\u9700\u5411\u76d1\u62a4\u4eba\u53d1\u9001\u6388\u6743\u94fe\u63a5\uff0c\u5e76\u7531\u5176\u586b\u5199\u76f8\u5173\u4fe1\u606f\u548c\u786e\u8ba4\u540e\uff0c\u65b9\u53ef\u7ee7\u7eed\u5f00\u6237\u6d41\u7a0b\uff0c\u63a5\u6536\u65b9\u53ef\u901a\u8fc7\u6388\u6743\u94fe\u63a5\u67e5\u770b\u4f60\u7684\u4e2a\u4eba\u4fe1\u606f\uff0c\u8bf7\u52ff\u5c06\u94fe\u63a5\u53d1\u9001\u7ed9\u975e\u76d1\u62a4\u4eba\u3002", "\u9700\u76d1\u62a4\u4eba\u786e\u8ba4\uff0c\u4ee5\u7ee7\u7eed\u5b9e\u540d", "\u53d6\u6d88", "\u9009\u62e9\u76d1\u62a4\u4eba"), new PopConfig("<title=\"\u300a\u8d22\u4ed8\u901a\u670d\u52a1\u534f\u8bae\u300b\",url=\"https://posts.tenpay.com/posts/3b020ca36008eb660046aad41d458236.html\">\n<title=\"\u300aQQ\u94b1\u5305\u652f\u4ed8\u7528\u6237\u670d\u52a1\u534f\u8bae\u300b\",url=\"https://www.tenpay.com/v2/html5/basic/public/agreement/protocol_mqq_pay.shtml\">\n<title=\"\u300a\u8d22\u4ed8\u901a\u9690\u79c1\u653f\u7b56\u300b\",url=\"https://posts.tenpay.com/posts/18ed0968618e3db204d4931651708953.html\">\n<title=\"\u300a\u8d22\u4ed8\u901a\u513f\u7ae5\u9690\u79c1\u4fdd\u62a4\u58f0\u660e\u300b\",url=\"https://www.tenpay.com/v3/helpcenter/low/privacy_child.shtml\">", "\u8bf7\u9605\u8bfb\u5e76\u540c\u610f<title=\"\u300a\u76d1\u62a4\u4eba\u6388\u6743\u987b\u77e5\u300b\",url=\"https://i.qianbao.qq.com/hybird/modules/document/guardianAuthorization.html\">\u53ca\u4ee5\u4e0b\u672a\u6210\u5e74\u4eba\u5f00\u6237\u7b7e\u7f72\u534f\u8bae", "\u4e0d\u540c\u610f", "\u540c\u610f"));

    @NotNull
    private static final String TAG = "ChildrenRealNameConfig";

    @Nullable
    private static ChildrenRealNameConfig remoteData;

    @SerializedName("applyNewStrategy")
    private final int applyNewStrategy;

    @SerializedName("childAgeTip")
    @NotNull
    private final PopConfig childAgeTip;

    @SerializedName("majorityAge")
    private final int majorityAge;

    @SerializedName("nonAgeGuideTip")
    @NotNull
    private final PopConfig nonAgeGuideTip;

    @SerializedName("nonAgeRejectTip")
    @NotNull
    private final PopConfig nonAgeRejectTip;

    @SerializedName("parentConfirmAge")
    private final int parentConfirmAge;

    @SerializedName("rejectAge")
    private final int rejectAge;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tenpay/idverify/model/ChildrenRealNameConfig$Companion;", "", "()V", "DEFAULT", "Lcom/tenpay/idverify/model/ChildrenRealNameConfig;", "getDEFAULT", "()Lcom/tenpay/idverify/model/ChildrenRealNameConfig;", "TAG", "", "remoteData", "getRemoteData", "setRemoteData", "(Lcom/tenpay/idverify/model/ChildrenRealNameConfig;)V", "get", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ChildrenRealNameConfig get() {
            ChildrenRealNameConfig remoteData = getRemoteData();
            if (remoteData != null && !Intrinsics.areEqual(remoteData, ChildrenRealNameConfig.INSTANCE.getDEFAULT())) {
                return remoteData;
            }
            try {
                setRemoteData(((ChildRealNameConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_CHILD_REAL_NAME_CONFIG, new ChildRealNameConfig(null, 1, null))).getConfig());
                QLog.i(ChildrenRealNameConfig.TAG, 1, "parse json success: " + getRemoteData());
                ChildrenRealNameConfig remoteData2 = getRemoteData();
                if (remoteData2 == null) {
                    return getDEFAULT();
                }
                return remoteData2;
            } catch (Exception e16) {
                QLog.w(ChildrenRealNameConfig.TAG, 1, "parse json fail: ", e16);
                return getDEFAULT();
            }
        }

        @NotNull
        public final ChildrenRealNameConfig getDEFAULT() {
            return ChildrenRealNameConfig.DEFAULT;
        }

        @Nullable
        public final ChildrenRealNameConfig getRemoteData() {
            return ChildrenRealNameConfig.remoteData;
        }

        public final void setRemoteData(@Nullable ChildrenRealNameConfig childrenRealNameConfig) {
            ChildrenRealNameConfig.remoteData = childrenRealNameConfig;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J9\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/tenpay/idverify/model/ChildrenRealNameConfig$PopConfig;", "", "retMsg", "", "title", "leftButton", "rightButton", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLeftButton", "()Ljava/lang/String;", "getRetMsg", "getRightButton", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class PopConfig {

        @SerializedName(FakeUrl.FAKE_LBUTTON)
        @Nullable
        private final String leftButton;

        @SerializedName("retmsg")
        @Nullable
        private final String retMsg;

        @SerializedName(FakeUrl.FAKE_RBUTTON)
        @Nullable
        private final String rightButton;

        @SerializedName("title")
        @Nullable
        private final String title;

        public PopConfig() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ PopConfig copy$default(PopConfig popConfig, String str, String str2, String str3, String str4, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = popConfig.retMsg;
            }
            if ((i3 & 2) != 0) {
                str2 = popConfig.title;
            }
            if ((i3 & 4) != 0) {
                str3 = popConfig.leftButton;
            }
            if ((i3 & 8) != 0) {
                str4 = popConfig.rightButton;
            }
            return popConfig.copy(str, str2, str3, str4);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getRetMsg() {
            return this.retMsg;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getLeftButton() {
            return this.leftButton;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getRightButton() {
            return this.rightButton;
        }

        @NotNull
        public final PopConfig copy(@Nullable String retMsg, @Nullable String title, @Nullable String leftButton, @Nullable String rightButton) {
            return new PopConfig(retMsg, title, leftButton, rightButton);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PopConfig)) {
                return false;
            }
            PopConfig popConfig = (PopConfig) other;
            if (Intrinsics.areEqual(this.retMsg, popConfig.retMsg) && Intrinsics.areEqual(this.title, popConfig.title) && Intrinsics.areEqual(this.leftButton, popConfig.leftButton) && Intrinsics.areEqual(this.rightButton, popConfig.rightButton)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getLeftButton() {
            return this.leftButton;
        }

        @Nullable
        public final String getRetMsg() {
            return this.retMsg;
        }

        @Nullable
        public final String getRightButton() {
            return this.rightButton;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            String str = this.retMsg;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.title;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.leftButton;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.rightButton;
            if (str4 != null) {
                i3 = str4.hashCode();
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            return "PopConfig(retMsg=" + this.retMsg + ", title=" + this.title + ", leftButton=" + this.leftButton + ", rightButton=" + this.rightButton + ")";
        }

        public PopConfig(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.retMsg = str;
            this.title = str2;
            this.leftButton = str3;
            this.rightButton = str4;
        }

        public /* synthetic */ PopConfig(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4);
        }
    }

    public ChildrenRealNameConfig(int i3, int i16, int i17, int i18, @NotNull PopConfig nonAgeRejectTip, @NotNull PopConfig childAgeTip, @NotNull PopConfig nonAgeGuideTip) {
        Intrinsics.checkNotNullParameter(nonAgeRejectTip, "nonAgeRejectTip");
        Intrinsics.checkNotNullParameter(childAgeTip, "childAgeTip");
        Intrinsics.checkNotNullParameter(nonAgeGuideTip, "nonAgeGuideTip");
        this.applyNewStrategy = i3;
        this.rejectAge = i16;
        this.parentConfirmAge = i17;
        this.majorityAge = i18;
        this.nonAgeRejectTip = nonAgeRejectTip;
        this.childAgeTip = childAgeTip;
        this.nonAgeGuideTip = nonAgeGuideTip;
    }

    public static /* synthetic */ ChildrenRealNameConfig copy$default(ChildrenRealNameConfig childrenRealNameConfig, int i3, int i16, int i17, int i18, PopConfig popConfig, PopConfig popConfig2, PopConfig popConfig3, int i19, Object obj) {
        if ((i19 & 1) != 0) {
            i3 = childrenRealNameConfig.applyNewStrategy;
        }
        if ((i19 & 2) != 0) {
            i16 = childrenRealNameConfig.rejectAge;
        }
        int i26 = i16;
        if ((i19 & 4) != 0) {
            i17 = childrenRealNameConfig.parentConfirmAge;
        }
        int i27 = i17;
        if ((i19 & 8) != 0) {
            i18 = childrenRealNameConfig.majorityAge;
        }
        int i28 = i18;
        if ((i19 & 16) != 0) {
            popConfig = childrenRealNameConfig.nonAgeRejectTip;
        }
        PopConfig popConfig4 = popConfig;
        if ((i19 & 32) != 0) {
            popConfig2 = childrenRealNameConfig.childAgeTip;
        }
        PopConfig popConfig5 = popConfig2;
        if ((i19 & 64) != 0) {
            popConfig3 = childrenRealNameConfig.nonAgeGuideTip;
        }
        return childrenRealNameConfig.copy(i3, i26, i27, i28, popConfig4, popConfig5, popConfig3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getApplyNewStrategy() {
        return this.applyNewStrategy;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRejectAge() {
        return this.rejectAge;
    }

    /* renamed from: component3, reason: from getter */
    public final int getParentConfirmAge() {
        return this.parentConfirmAge;
    }

    /* renamed from: component4, reason: from getter */
    public final int getMajorityAge() {
        return this.majorityAge;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final PopConfig getNonAgeRejectTip() {
        return this.nonAgeRejectTip;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final PopConfig getChildAgeTip() {
        return this.childAgeTip;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final PopConfig getNonAgeGuideTip() {
        return this.nonAgeGuideTip;
    }

    @NotNull
    public final ChildrenRealNameConfig copy(int applyNewStrategy, int rejectAge, int parentConfirmAge, int majorityAge, @NotNull PopConfig nonAgeRejectTip, @NotNull PopConfig childAgeTip, @NotNull PopConfig nonAgeGuideTip) {
        Intrinsics.checkNotNullParameter(nonAgeRejectTip, "nonAgeRejectTip");
        Intrinsics.checkNotNullParameter(childAgeTip, "childAgeTip");
        Intrinsics.checkNotNullParameter(nonAgeGuideTip, "nonAgeGuideTip");
        return new ChildrenRealNameConfig(applyNewStrategy, rejectAge, parentConfirmAge, majorityAge, nonAgeRejectTip, childAgeTip, nonAgeGuideTip);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChildrenRealNameConfig)) {
            return false;
        }
        ChildrenRealNameConfig childrenRealNameConfig = (ChildrenRealNameConfig) other;
        if (this.applyNewStrategy == childrenRealNameConfig.applyNewStrategy && this.rejectAge == childrenRealNameConfig.rejectAge && this.parentConfirmAge == childrenRealNameConfig.parentConfirmAge && this.majorityAge == childrenRealNameConfig.majorityAge && Intrinsics.areEqual(this.nonAgeRejectTip, childrenRealNameConfig.nonAgeRejectTip) && Intrinsics.areEqual(this.childAgeTip, childrenRealNameConfig.childAgeTip) && Intrinsics.areEqual(this.nonAgeGuideTip, childrenRealNameConfig.nonAgeGuideTip)) {
            return true;
        }
        return false;
    }

    public final int getApplyNewStrategy() {
        return this.applyNewStrategy;
    }

    @NotNull
    public final PopConfig getChildAgeTip() {
        return this.childAgeTip;
    }

    public final int getMajorityAge() {
        return this.majorityAge;
    }

    @NotNull
    public final PopConfig getNonAgeGuideTip() {
        return this.nonAgeGuideTip;
    }

    @NotNull
    public final PopConfig getNonAgeRejectTip() {
        return this.nonAgeRejectTip;
    }

    public final int getParentConfirmAge() {
        return this.parentConfirmAge;
    }

    @NotNull
    public final RealNameAgePopHelper.EnumPopAgeType getRealNameAgeType(int age) {
        boolean z16;
        int i3 = this.rejectAge;
        if (age < i3) {
            return RealNameAgePopHelper.EnumPopAgeType.REJECT_0_8;
        }
        int i16 = this.parentConfirmAge;
        boolean z17 = true;
        if (age < i16 && i3 <= age) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return RealNameAgePopHelper.EnumPopAgeType.PARENT_COMMIT_8_16;
        }
        if (age >= this.majorityAge || i16 > age) {
            z17 = false;
        }
        if (z17) {
            return RealNameAgePopHelper.EnumPopAgeType.PARENT_CONFIRM_16_18;
        }
        return RealNameAgePopHelper.EnumPopAgeType.ADULT_PASS_18;
    }

    public final int getRejectAge() {
        return this.rejectAge;
    }

    public int hashCode() {
        return (((((((((((this.applyNewStrategy * 31) + this.rejectAge) * 31) + this.parentConfirmAge) * 31) + this.majorityAge) * 31) + this.nonAgeRejectTip.hashCode()) * 31) + this.childAgeTip.hashCode()) * 31) + this.nonAgeGuideTip.hashCode();
    }

    @NotNull
    public String toString() {
        return "ChildrenRealNameConfig(applyNewStrategy=" + this.applyNewStrategy + ", rejectAge=" + this.rejectAge + ", parentConfirmAge=" + this.parentConfirmAge + ", majorityAge=" + this.majorityAge + ", nonAgeRejectTip=" + this.nonAgeRejectTip + ", childAgeTip=" + this.childAgeTip + ", nonAgeGuideTip=" + this.nonAgeGuideTip + ")";
    }
}
