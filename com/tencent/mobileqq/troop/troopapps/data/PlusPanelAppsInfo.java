package com.tencent.mobileqq.troop.troopapps.data;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fBA\u0012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\r\u001a\u00020\t\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0019\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u00c6\u0003J\u0019\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003JG\u0010\u000e\u001a\u00020\u00002\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\b\u0002\u0010\r\u001a\u00020\tH\u00c6\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R'\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R'\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;", "Ljava/io/Serializable;", "", "toJson", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "component1", "component2", "", "component3", "appList", "moreList", "cacheExpiryTime", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/util/ArrayList;", "getAppList", "()Ljava/util/ArrayList;", "getMoreList", "J", "getCacheExpiryTime", "()J", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;J)V", "Companion", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class PlusPanelAppsInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final long serialVersionUID = 1;

    @NotNull
    private final ArrayList<Integer> appList;
    private final long cacheExpiryTime;

    @NotNull
    private final ArrayList<Integer> moreList;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo$a;", "", "", "jsonString", "Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;", "a", "JSON_KEY_APP_LIST", "Ljava/lang/String;", "JSON_KEY_EXPIRY_INTERVAL", "JSON_KEY_MORE_LIST", "TAG", "", "serialVersionUID", "J", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopapps.data.PlusPanelAppsInfo$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final PlusPanelAppsInfo a(@Nullable String jsonString) {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PlusPanelAppsInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonString);
            }
            if (TextUtils.isEmpty(jsonString)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONObject jSONObject = new JSONObject(jsonString);
                if (jSONObject.has("appList")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("appList");
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        arrayList.add(Integer.valueOf(jSONArray.getInt(i3)));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                if (jSONObject.has("moreList")) {
                    JSONArray jSONArray2 = jSONObject.getJSONArray("moreList");
                    int length2 = jSONArray2.length();
                    for (int i16 = 0; i16 < length2; i16++) {
                        arrayList2.add(Integer.valueOf(jSONArray2.getInt(i16)));
                    }
                }
                if (jSONObject.has("cacheExpiryTime")) {
                    j3 = jSONObject.getLong("cacheExpiryTime");
                } else {
                    j3 = 0;
                }
                return new PlusPanelAppsInfo(arrayList, arrayList2, j3);
            } catch (JSONException e16) {
                QLog.e("PlusPanelAppsInfo", 1, "[fromJson] exception " + e16, e16);
                return null;
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25028);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlusPanelAppsInfo(@NotNull ArrayList<Integer> appList, @NotNull ArrayList<Integer> moreList, long j3) {
        Intrinsics.checkNotNullParameter(appList, "appList");
        Intrinsics.checkNotNullParameter(moreList, "moreList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appList, moreList, Long.valueOf(j3));
            return;
        }
        this.appList = appList;
        this.moreList = moreList;
        this.cacheExpiryTime = j3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlusPanelAppsInfo copy$default(PlusPanelAppsInfo plusPanelAppsInfo, ArrayList arrayList, ArrayList arrayList2, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = plusPanelAppsInfo.appList;
        }
        if ((i3 & 2) != 0) {
            arrayList2 = plusPanelAppsInfo.moreList;
        }
        if ((i3 & 4) != 0) {
            j3 = plusPanelAppsInfo.cacheExpiryTime;
        }
        return plusPanelAppsInfo.copy(arrayList, arrayList2, j3);
    }

    @NotNull
    public final ArrayList<Integer> component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.appList;
    }

    @NotNull
    public final ArrayList<Integer> component2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.moreList;
    }

    public final long component3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.cacheExpiryTime;
    }

    @NotNull
    public final PlusPanelAppsInfo copy(@NotNull ArrayList<Integer> appList, @NotNull ArrayList<Integer> moreList, long cacheExpiryTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (PlusPanelAppsInfo) iPatchRedirector.redirect((short) 10, this, appList, moreList, Long.valueOf(cacheExpiryTime));
        }
        Intrinsics.checkNotNullParameter(appList, "appList");
        Intrinsics.checkNotNullParameter(moreList, "moreList");
        return new PlusPanelAppsInfo(appList, moreList, cacheExpiryTime);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlusPanelAppsInfo)) {
            return false;
        }
        PlusPanelAppsInfo plusPanelAppsInfo = (PlusPanelAppsInfo) other;
        if (Intrinsics.areEqual(this.appList, plusPanelAppsInfo.appList) && Intrinsics.areEqual(this.moreList, plusPanelAppsInfo.moreList) && this.cacheExpiryTime == plusPanelAppsInfo.cacheExpiryTime) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<Integer> getAppList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.appList;
    }

    public final long getCacheExpiryTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.cacheExpiryTime;
    }

    @NotNull
    public final ArrayList<Integer> getMoreList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.moreList;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (((this.appList.hashCode() * 31) + this.moreList.hashCode()) * 31) + androidx.fragment.app.a.a(this.cacheExpiryTime);
    }

    @NotNull
    public final String toJson() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appList", new JSONArray((Collection) this.appList));
        jSONObject.put("moreList", new JSONArray((Collection) this.moreList));
        jSONObject.put("cacheExpiryTime", this.cacheExpiryTime);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ime)\n        }.toString()");
        return jSONObject2;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return "PlusPanelAppsInfo(appList=" + this.appList + ", moreList=" + this.moreList + ", cacheExpiryTime=" + this.cacheExpiryTime + ")";
    }

    public /* synthetic */ PlusPanelAppsInfo(ArrayList arrayList, ArrayList arrayList2, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, (i3 & 2) != 0 ? new ArrayList() : arrayList2, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, arrayList, arrayList2, Long.valueOf(j3), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
