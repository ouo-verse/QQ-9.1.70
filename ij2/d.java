package ij2;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qqshop.report.dev.KuiklyLaunchData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import i01.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0004\u0005\u0013\u0006\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bj\u0004\u0018\u0001`\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lij2/d;", "Li01/e;", "", "params", "", "a", "c", "method", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "d", "b", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d extends e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lij2/d$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "bgColor", "J", "a", "()J", "textNormalColor", "b", "textSelectColor", "c", "isHidden", "Z", "d", "()Z", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ij2.d$b, reason: from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class MenuInfo {

        @SerializedName("bgColor")
        private final long bgColor;

        @SerializedName("isHidden")
        private final boolean isHidden;

        @SerializedName("textNormalColor")
        private final long textNormalColor;

        @SerializedName("textSelectColor")
        private final long textSelectColor;

        /* renamed from: a, reason: from getter */
        public final long getBgColor() {
            return this.bgColor;
        }

        /* renamed from: b, reason: from getter */
        public final long getTextNormalColor() {
            return this.textNormalColor;
        }

        /* renamed from: c, reason: from getter */
        public final long getTextSelectColor() {
            return this.textSelectColor;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsHidden() {
            return this.isHidden;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MenuInfo)) {
                return false;
            }
            MenuInfo menuInfo = (MenuInfo) other;
            if (this.bgColor == menuInfo.bgColor && this.textNormalColor == menuInfo.textNormalColor && this.textSelectColor == menuInfo.textSelectColor && this.isHidden == menuInfo.isHidden) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((((androidx.fragment.app.a.a(this.bgColor) * 31) + androidx.fragment.app.a.a(this.textNormalColor)) * 31) + androidx.fragment.app.a.a(this.textSelectColor)) * 31;
            boolean z16 = this.isHidden;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "MenuInfo(bgColor=" + this.bgColor + ", textNormalColor=" + this.textNormalColor + ", textSelectColor=" + this.textSelectColor + ", isHidden=" + this.isHidden + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lij2/d$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "bgColor", "J", "a", "()J", "textColor", "b", "isStatusDark", "Z", "()Z", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ij2.d$c, reason: from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class NavInfo {

        @SerializedName("bgColor")
        private final long bgColor;

        @SerializedName("isStatusDark")
        private final boolean isStatusDark;

        @SerializedName("textColor")
        private final long textColor;

        /* renamed from: a, reason: from getter */
        public final long getBgColor() {
            return this.bgColor;
        }

        /* renamed from: b, reason: from getter */
        public final long getTextColor() {
            return this.textColor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavInfo)) {
                return false;
            }
            NavInfo navInfo = (NavInfo) other;
            if (this.bgColor == navInfo.bgColor && this.textColor == navInfo.textColor && this.isStatusDark == navInfo.isStatusDark) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((androidx.fragment.app.a.a(this.bgColor) * 31) + androidx.fragment.app.a.a(this.textColor)) * 31;
            boolean z16 = this.isStatusDark;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "NavInfo(bgColor=" + this.bgColor + ", textColor=" + this.textColor + ", isStatusDark=" + this.isStatusDark + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Lij2/d$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "isCustomUI", "Z", "c", "()Z", "Lij2/d$c;", "navInfo", "Lij2/d$c;", "b", "()Lij2/d$c;", "Lij2/d$b;", "menuInfo", "Lij2/d$b;", "a", "()Lij2/d$b;", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ij2.d$d, reason: collision with other inner class name and from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class UIStyle {

        @SerializedName("isCustomUI")
        private final boolean isCustomUI;

        @SerializedName("menuInfo")
        @Nullable
        private final MenuInfo menuInfo;

        @SerializedName("navInfo")
        @Nullable
        private final NavInfo navInfo;

        @Nullable
        /* renamed from: a, reason: from getter */
        public final MenuInfo getMenuInfo() {
            return this.menuInfo;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final NavInfo getNavInfo() {
            return this.navInfo;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsCustomUI() {
            return this.isCustomUI;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UIStyle)) {
                return false;
            }
            UIStyle uIStyle = (UIStyle) other;
            if (this.isCustomUI == uIStyle.isCustomUI && Intrinsics.areEqual(this.navInfo, uIStyle.navInfo) && Intrinsics.areEqual(this.menuInfo, uIStyle.menuInfo)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isCustomUI;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            NavInfo navInfo = this.navInfo;
            int i16 = 0;
            if (navInfo == null) {
                hashCode = 0;
            } else {
                hashCode = navInfo.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            MenuInfo menuInfo = this.menuInfo;
            if (menuInfo != null) {
                i16 = menuInfo.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "UIStyle(isCustomUI=" + this.isCustomUI + ", navInfo=" + this.navInfo + ", menuInfo=" + this.menuInfo + ")";
        }
    }

    private final void a(String params) {
        WeakReference<KuiklyLaunchData> b16;
        KuiklyLaunchData kuiklyLaunchData;
        WeakReference<KuiklyLaunchData> b17;
        KuiklyLaunchData kuiklyLaunchData2;
        boolean z16 = true;
        if (params == null) {
            QLog.e("QQShopUIModule", 1, "launchReport params is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            String stepKey = jSONObject.optString("step");
            if (stepKey != null && stepKey.length() != 0) {
                z16 = false;
            }
            if (!z16 && (b17 = com.tencent.mobileqq.qqshop.report.dev.b.f274713a.b()) != null && (kuiklyLaunchData2 = b17.get()) != null) {
                Intrinsics.checkNotNullExpressionValue(stepKey, "stepKey");
                KuiklyLaunchData.addKuiklyAction$default(kuiklyLaunchData2, stepKey, 0L, 2, null);
            }
            JSONObject optJSONObject = jSONObject.optJSONObject(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS);
            if (optJSONObject != null && (b16 = com.tencent.mobileqq.qqshop.report.dev.b.f274713a.b()) != null && (kuiklyLaunchData = b16.get()) != null) {
                kuiklyLaunchData.addKuiklyData(optJSONObject);
            }
        } catch (JSONException e16) {
            QLog.e("QQShopUIModule", 1, "launchReport params to json is error", e16);
        }
    }

    private final void c(String params) {
        if (params == null) {
            QLog.e("QQShopUIModule", 1, "setUIStyle params is null");
            return;
        }
        try {
            Object fromJson = new Gson().fromJson(params, (Class<Object>) UIStyle.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(params, UIStyle::class.java)");
            com.tencent.mobileqq.qqshop.publicaccount.d.f274576a.n((UIStyle) fromJson);
        } catch (JsonSyntaxException e16) {
            QLog.e("QQShopUIModule", 1, "setUIStyle params to json is error", e16);
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "setUIStyle")) {
            c(params);
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, "launchReport")) {
            a(params);
            return Unit.INSTANCE;
        }
        QLog.e("QQShopUIModule", 1, "unknown method: " + method);
        return super.call(method, params, callback);
    }
}
