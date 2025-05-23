package com.tencent.mobileqq.qqlive.sail.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\u0005B5\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0010\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/b;", "", "", "from", "", "a", "toString", "", "hashCode", "other", "equals", "I", "getAllSource", "()I", "allSource", "", "b", "Ljava/util/List;", "getSources", "()Ljava/util/List;", "sources", "", "c", "J", "()J", "countdownTime", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "countdownMsg", "<init>", "(ILjava/util/List;JLjava/lang/String;)V", "e", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int allSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> sources;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long countdownTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String countdownMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/b$a;", "", "Lcom/tencent/mobileqq/qqlive/sail/model/b;", "a", "", "DEFAULT_CONFIG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

        @NotNull
        public final b a() {
            boolean isBlank;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            String d16 = ht3.a.d("qqlive_task_end_live_ab_test_config", "\n                {\n                all_source: 1,\n                sources: [\"12\", \"13\", \"14\", \"300001\", \"300002\", \"300004\", \"300007\", \"300008\", \"51\"],\n                count_down_msg: \"%s \u79d2\u540e\u4e3a\u4f60\u5207\u6362\u5230\u4e0b\u4e00\u4e2a\u76f4\u64ad\",\n                count_down_time: 3000\n                }\n            ");
            isBlank = StringsKt__StringsJVMKt.isBlank(d16);
            if (isBlank) {
                return new b(0, null, 0L, null, 15, null);
            }
            try {
                JSONObject jSONObject = new JSONObject(d16);
                ArrayList arrayList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("sources");
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String string = jSONArray.getString(i3);
                    Intrinsics.checkNotNullExpressionValue(string, "sourcesArray.getString(i)");
                    arrayList.add(string);
                }
                int i16 = jSONObject.getInt("all_source");
                long j3 = jSONObject.getLong("count_down_time");
                String string2 = jSONObject.getString("count_down_msg");
                Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"count_down_msg\")");
                return new b(i16, arrayList, j3, string2);
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Audience|EndLiveAutoSwitchInfo", "fetchWnsConfig", "error, ", e16);
                return new b(0, null, 0L, null, 15, null);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50340);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        this(0, null, 0L, null, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, (Object) this);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(@Nullable String from) {
        boolean z16;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) from)).booleanValue();
        }
        if (from != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(from);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                if (this.allSource > 0 || this.sources.contains(from)) {
                    return true;
                }
                return false;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.countdownMsg;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.countdownTime;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.allSource == bVar.allSource && Intrinsics.areEqual(this.sources, bVar.sources) && this.countdownTime == bVar.countdownTime && Intrinsics.areEqual(this.countdownMsg, bVar.countdownMsg)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return (((((this.allSource * 31) + this.sources.hashCode()) * 31) + androidx.fragment.app.a.a(this.countdownTime)) * 31) + this.countdownMsg.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "EndLiveAutoSwitchConfig(allSource=" + this.allSource + ", sources=" + this.sources + ", countdownTime=" + this.countdownTime + ", countdownMsg=" + this.countdownMsg + ")";
    }

    public b(int i3, @NotNull List<String> sources, long j3, @NotNull String countdownMsg) {
        Intrinsics.checkNotNullParameter(sources, "sources");
        Intrinsics.checkNotNullParameter(countdownMsg, "countdownMsg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), sources, Long.valueOf(j3), countdownMsg);
            return;
        }
        this.allSource = i3;
        this.sources = sources;
        this.countdownTime = j3;
        this.countdownMsg = countdownMsg;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ b(int i3, List list, long j3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, r4, (i16 & 4) != 0 ? 0L : j3, (i16 & 8) != 0 ? "" : str);
        List list2;
        List emptyList;
        int i17 = (i16 & 1) != 0 ? 0 : i3;
        if ((i16 & 2) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), list, Long.valueOf(j3), str, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
