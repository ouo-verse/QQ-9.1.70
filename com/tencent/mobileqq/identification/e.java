package com.tencent.mobileqq.identification;

import android.os.Build;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/identification/e;", "", "", "a", "Lcom/tencent/mobileqq/identification/e$a;", "b", "<init>", "()V", "qqconnectface-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f237942a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/identification/e$a;", "", "", "a", "", "toString", "", "hashCode", "other", "equals", "Z", "getEnable", "()Z", "enable", "", "b", "Ljava/util/Set;", "getOsBuildVerSet", "()Ljava/util/Set;", "osBuildVerSet", "c", "getModelSet", "modelSet", "<init>", "(ZLjava/util/Set;Ljava/util/Set;)V", "qqconnectface-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean enable;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Set<Integer> osBuildVerSet;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Set<String> modelSet;

        public a() {
            this(false, null, null, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return;
            }
            iPatchRedirector.redirect((short) 14, (Object) this);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkDeviceEnable sdkInt: ");
            int i3 = Build.VERSION.SDK_INT;
            sb5.append(i3);
            sb5.append(", model: ");
            sb5.append(DeviceInfoMonitor.getModel());
            QLog.d("HuiYan720pConfigUtil", 4, sb5.toString());
            if (!this.enable || !this.osBuildVerSet.contains(Integer.valueOf(i3))) {
                return false;
            }
            return this.modelSet.contains(DeviceInfoMonitor.getModel());
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.enable == aVar.enable && Intrinsics.areEqual(this.osBuildVerSet, aVar.osBuildVerSet) && Intrinsics.areEqual(this.modelSet, aVar.modelSet)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            boolean z16 = this.enable;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (((r06 * 31) + this.osBuildVerSet.hashCode()) * 31) + this.modelSet.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "Config(enable=" + this.enable + ", osBuildVerSet=" + this.osBuildVerSet + ", modelSet=" + this.modelSet + ')';
        }

        public a(boolean z16, @NotNull Set<Integer> osBuildVerSet, @NotNull Set<String> modelSet) {
            Intrinsics.checkNotNullParameter(osBuildVerSet, "osBuildVerSet");
            Intrinsics.checkNotNullParameter(modelSet, "modelSet");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), osBuildVerSet, modelSet);
                return;
            }
            this.enable = z16;
            this.osBuildVerSet = osBuildVerSet;
            this.modelSet = modelSet;
        }

        public /* synthetic */ a(boolean z16, Set set, Set set2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? SetsKt__SetsKt.emptySet() : set, (i3 & 4) != 0 ? SetsKt__SetsKt.emptySet() : set2);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), set, set2, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f237942a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final boolean a() {
        a b16 = f237942a.b();
        boolean a16 = b16.a();
        QLog.i("HuiYan720pConfigUtil", 1, "checkDeviceEnable check: " + a16 + ", config: " + b16);
        return a16;
    }

    @NotNull
    public final a b() {
        boolean z16;
        String str;
        boolean z17;
        Integer num;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        IUnitedConfigManager iUnitedConfigManager = (IUnitedConfigManager) api;
        if (!iUnitedConfigManager.isSwitchOn("huiyan_720p_preview_switch", true)) {
            return new a(false, null, null, 7, null);
        }
        String loadAsString = iUnitedConfigManager.loadAsString("huiyan_720p_preview_switch", "\n            {\n                \"build_versions\": [\n                    35\n                ],\n                \"models\": [\n                    \"PGT110\"\n                ]\n            }\n        ");
        if (loadAsString.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return new a(false, null, null, 7, null);
        }
        try {
            JSONObject jSONObject = new JSONObject(loadAsString);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            JSONArray optJSONArray = jSONObject.optJSONArray("build_versions");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    Object obj = optJSONArray.get(i16);
                    if (obj instanceof Integer) {
                        num = (Integer) obj;
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        i3 = num.intValue();
                    } else {
                        i3 = 0;
                    }
                    if (i3 > 0) {
                        linkedHashSet.add(Integer.valueOf(i3));
                    }
                }
            }
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            JSONArray optJSONArray2 = jSONObject.optJSONArray(IQQGameCommApi.K_ABTEST_MODELS);
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i17 = 0; i17 < length2; i17++) {
                    Object obj2 = optJSONArray2.get(i17);
                    if (obj2 instanceof String) {
                        str = (String) obj2;
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "";
                    }
                    if (str.length() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        linkedHashSet2.add(str);
                    }
                }
            }
            return new a(true, linkedHashSet, linkedHashSet2);
        } catch (Exception e16) {
            QLog.e("HuiYan720pConfigUtil", 1, "loadConfig error", e16);
            return new a(false, null, null, 7, null);
        }
    }
}
