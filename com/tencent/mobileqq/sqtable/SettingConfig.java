package com.tencent.mobileqq.sqtable;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.sqtable.SettingConfig;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\fR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/sqtable/SettingConfig;", "", "", "Lcom/tencent/mobileqq/sqtable/SettingConfig$a;", "b", ReportPlugin.KEY_TABLE_NAME, "", "c", "f", "d", "e", "Lcom/tencent/mobileqq/sqtable/SettingConfig$a$a;", "Lcom/tencent/mobileqq/sqtable/SettingConfig$a$a;", "defaultBuglyReportConfig", "", "Lkotlin/Lazy;", "getDefaultConfigs", "()Ljava/util/List;", "defaultConfigs", "Ljava/util/List;", DownloadInfo.spKey_Config, "<init>", "()V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SettingConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final SettingConfig f289642a = new SettingConfig();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final TablesConfig.ReportConfig defaultBuglyReportConfig = new TablesConfig.ReportConfig(1, Double.valueOf(1.0d));

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Lazy defaultConfigs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final List<TablesConfig> config;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<TablesConfig>>() { // from class: com.tencent.mobileqq.sqtable.SettingConfig$defaultConfigs$2
            @Override // kotlin.jvm.functions.Function0
            public final List<SettingConfig.TablesConfig> invoke() {
                SettingConfig.TablesConfig.ReportConfig reportConfig;
                SettingConfig.TablesConfig.ReportConfig reportConfig2;
                SettingConfig.TablesConfig.ReportConfig reportConfig3;
                SettingConfig.TablesConfig.ReportConfig reportConfig4;
                SettingConfig.TablesConfig.ReportConfig reportConfig5;
                SettingConfig.TablesConfig.ReportConfig reportConfig6;
                SettingConfig.TablesConfig.ReportConfig reportConfig7;
                List<SettingConfig.TablesConfig> mutableListOf;
                Regex regex = new Regex("\"^mr_data.*\"");
                reportConfig = SettingConfig.defaultBuglyReportConfig;
                Regex regex2 = new Regex(AppConstants.Preferences.CONVERSATION_INFO);
                reportConfig2 = SettingConfig.defaultBuglyReportConfig;
                Regex regex3 = new Regex("mr_multimessage");
                reportConfig3 = SettingConfig.defaultBuglyReportConfig;
                Regex regex4 = new Regex("\"^mr_temp_game_msg_.*\"");
                reportConfig4 = SettingConfig.defaultBuglyReportConfig;
                Regex regex5 = new Regex("\"^mr_troop_.*\"");
                reportConfig5 = SettingConfig.defaultBuglyReportConfig;
                Regex regex6 = new Regex("\"^mr_friend_.*\"");
                reportConfig6 = SettingConfig.defaultBuglyReportConfig;
                Regex regex7 = new Regex("\"^mr_.*\"");
                reportConfig7 = SettingConfig.defaultBuglyReportConfig;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new SettingConfig.TablesConfig(regex, true, reportConfig), new SettingConfig.TablesConfig(regex2, true, reportConfig2), new SettingConfig.TablesConfig(regex3, true, reportConfig3), new SettingConfig.TablesConfig(regex4, true, reportConfig4), new SettingConfig.TablesConfig(regex5, true, reportConfig5), new SettingConfig.TablesConfig(regex6, true, reportConfig6), new SettingConfig.TablesConfig(regex7, false, reportConfig7));
                return mutableListOf;
            }
        });
        defaultConfigs = lazy;
        ArrayList arrayList = new ArrayList();
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("105561", "");
        QLog.d("TableSettingConfig", 1, "loadConfigStr  from  remote : \n " + loadAsString + " ");
        if (!TextUtils.isEmpty(loadAsString)) {
            try {
                JSONArray optJSONArray = new JSONObject(loadAsString).optJSONArray("tables");
                if (optJSONArray != null) {
                    Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"tables\")");
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("report");
                        String optString = optJSONObject.optString("name");
                        Intrinsics.checkNotNullExpressionValue(optString, "this.optString(\"name\")");
                        arrayList.add(new TablesConfig(new Regex(optString), optJSONObject.optBoolean("intercept"), optJSONObject2 == null ? null : new TablesConfig.ReportConfig(optJSONObject2.optInt("type"), Double.valueOf(optJSONObject2.optDouble("sample")))));
                    }
                }
            } catch (Exception e16) {
                QLog.e("TableSettingConfig", 1, "parseConfig error!!", e16);
            }
        }
        config = arrayList;
    }

    SettingConfig() {
    }

    private final TablesConfig b(String str) {
        for (TablesConfig tablesConfig : config) {
            if (tablesConfig.getNameRegex().matches(str)) {
                return tablesConfig;
            }
        }
        return null;
    }

    public final boolean c(String tableName) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        TablesConfig b16 = b(tableName);
        return b16 != null && b16.getIntercept();
    }

    public final boolean d(String tableName) {
        TablesConfig.ReportConfig report;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        TablesConfig b16 = b(tableName);
        return (b16 == null || (report = b16.getReport()) == null || report.getType() != 1) ? false : true;
    }

    public final boolean e(String tableName) {
        TablesConfig.ReportConfig report;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        TablesConfig b16 = b(tableName);
        return (b16 == null || (report = b16.getReport()) == null || report.getType() != 2) ? false : true;
    }

    public final boolean f(String tableName) {
        TablesConfig.ReportConfig report;
        Double sample;
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        TablesConfig b16 = b(tableName);
        if (b16 != null && (report = b16.getReport()) != null && (sample = report.getSample()) != null) {
            double doubleValue = sample.doubleValue();
            if (doubleValue == 1.0d) {
                return true;
            }
            if (doubleValue <= 0.0d) {
                return false;
            }
            r1 = Random.INSTANCE.nextDouble() < doubleValue;
            if (!r1) {
                QLog.d("TableSettingConfig", 1, "not hit sample !! " + tableName);
            }
        }
        return r1;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nB#\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/sqtable/SettingConfig$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lkotlin/text/Regex;", "a", "Lkotlin/text/Regex;", "b", "()Lkotlin/text/Regex;", "nameRegex", "Z", "()Z", "intercept", "Lcom/tencent/mobileqq/sqtable/SettingConfig$a$a;", "c", "Lcom/tencent/mobileqq/sqtable/SettingConfig$a$a;", "()Lcom/tencent/mobileqq/sqtable/SettingConfig$a$a;", "report", "<init>", "(Lkotlin/text/Regex;ZLcom/tencent/mobileqq/sqtable/SettingConfig$a$a;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sqtable.SettingConfig$a, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class TablesConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final Regex nameRegex;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean intercept;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final ReportConfig report;

        public TablesConfig(Regex nameRegex, boolean z16, ReportConfig reportConfig) {
            Intrinsics.checkNotNullParameter(nameRegex, "nameRegex");
            this.nameRegex = nameRegex;
            this.intercept = z16;
            this.report = reportConfig;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIntercept() {
            return this.intercept;
        }

        /* renamed from: b, reason: from getter */
        public final Regex getNameRegex() {
            return this.nameRegex;
        }

        /* renamed from: c, reason: from getter */
        public final ReportConfig getReport() {
            return this.report;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.nameRegex.hashCode() * 31;
            boolean z16 = this.intercept;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode + i3) * 31;
            ReportConfig reportConfig = this.report;
            return i16 + (reportConfig == null ? 0 : reportConfig.hashCode());
        }

        public String toString() {
            return "TablesConfig(nameRegex=" + this.nameRegex + ", intercept=" + this.intercept + ", report=" + this.report + ")";
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/sqtable/SettingConfig$a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "type", "", "Ljava/lang/Double;", "()Ljava/lang/Double;", "sample", "<init>", "(ILjava/lang/Double;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.sqtable.SettingConfig$a$a, reason: collision with other inner class name and from toString */
        /* loaded from: classes35.dex */
        public static final /* data */ class ReportConfig {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final int type;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final Double sample;

            public ReportConfig(int i3, Double d16) {
                this.type = i3;
                this.sample = d16;
            }

            /* renamed from: a, reason: from getter */
            public final Double getSample() {
                return this.sample;
            }

            /* renamed from: b, reason: from getter */
            public final int getType() {
                return this.type;
            }

            public int hashCode() {
                int i3 = this.type * 31;
                Double d16 = this.sample;
                return i3 + (d16 == null ? 0 : d16.hashCode());
            }

            public String toString() {
                return "ReportConfig(type=" + this.type + ", sample=" + this.sample + ")";
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ReportConfig)) {
                    return false;
                }
                ReportConfig reportConfig = (ReportConfig) other;
                return this.type == reportConfig.type && Intrinsics.areEqual((Object) this.sample, (Object) reportConfig.sample);
            }
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TablesConfig)) {
                return false;
            }
            TablesConfig tablesConfig = (TablesConfig) other;
            return Intrinsics.areEqual(this.nameRegex, tablesConfig.nameRegex) && this.intercept == tablesConfig.intercept && Intrinsics.areEqual(this.report, tablesConfig.report);
        }
    }
}
