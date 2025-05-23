package com.tencent.mobileqq.aio.config;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.util.notification.NotificationController;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\rB5\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/aio/config/a;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "", "configVer", "J", "b", "()J", "configURL", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "configMD5", "getConfigMD5", "", "Lcom/tencent/mobileqq/aio/config/a$b;", "limits", "Ljava/util/List;", "c", "()Ljava/util/List;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "aio_animation_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @SerializedName("config_md5")
    @NotNull
    private final String configMD5;

    @SerializedName("config_url")
    @NotNull
    private final String configURL;

    @SerializedName(NotificationController.Constants.CONFIG_VERSION)
    private final long configVer;

    @SerializedName("limits")
    @NotNull
    private final List<b> limits;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/config/a$a;", "", "Lcom/tencent/mobileqq/aio/config/a;", "a", "b", "", "CONFIG_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_animation_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.config.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
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

        private final a a() {
            List emptyList;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return new a(0L, "", "", emptyList);
        }

        @JvmStatic
        @NotNull
        public final a b() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            String loadConfigAsString = FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("android_eggs_config", "");
            if (loadConfigAsString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return a();
            }
            try {
                Object fromJson = new Gson().fromJson(loadConfigAsString, (Class<Object>) a.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "{\n                Gson()\u2026class.java)\n            }");
                return (a) fromJson;
            } catch (Exception e16) {
                QLog.w("AIOAnimationConfigBean", 1, "[parse]  jsonString:" + loadConfigAsString + ", exception=" + e16);
                return a();
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/config/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "idList", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "perDay", "I", "c", "()I", "gap", "a", "<init>", "(Ljava/lang/String;II)V", "aio_animation_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        @SerializedName("gap")
        private final int gap;

        @SerializedName("id_list")
        @NotNull
        private final String idList;

        @SerializedName("per_day")
        private final int perDay;

        public b() {
            this(null, 0, 0, 7, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                return;
            }
            iPatchRedirector.redirect((short) 13, (Object) this);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.gap;
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.idList;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.perDay;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.idList, bVar.idList) && this.perDay == bVar.perDay && this.gap == bVar.gap) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return (((this.idList.hashCode() * 31) + this.perDay) * 31) + this.gap;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "Limit(idList=" + this.idList + ", perDay=" + this.perDay + ", gap=" + this.gap + ")";
        }

        public b(@NotNull String idList, int i3, int i16) {
            Intrinsics.checkNotNullParameter(idList, "idList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, idList, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.idList = idList;
            this.perDay = i3;
            this.gap = i16;
        }

        public /* synthetic */ b(String str, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? -1 : i3, (i17 & 4) != 0 ? 0 : i16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41439);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        this(0L, null, null, null, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, (Object) this);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.configURL;
    }

    public final long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.configVer;
    }

    @NotNull
    public final List<b> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.limits;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.configVer != 0 && !TextUtils.isEmpty(this.configURL) && !TextUtils.isEmpty(this.configMD5)) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.configVer == aVar.configVer && Intrinsics.areEqual(this.configURL, aVar.configURL) && Intrinsics.areEqual(this.configMD5, aVar.configMD5) && Intrinsics.areEqual(this.limits, aVar.limits)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return (((((androidx.fragment.app.a.a(this.configVer) * 31) + this.configURL.hashCode()) * 31) + this.configMD5.hashCode()) * 31) + this.limits.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "{ver:" + this.configVer + ",url:" + this.configURL + ",md5:" + this.configMD5 + "}";
    }

    public a(long j3, @NotNull String configURL, @NotNull String configMD5, @NotNull List<b> limits) {
        Intrinsics.checkNotNullParameter(configURL, "configURL");
        Intrinsics.checkNotNullParameter(configMD5, "configMD5");
        Intrinsics.checkNotNullParameter(limits, "limits");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), configURL, configMD5, limits);
            return;
        }
        this.configVer = j3;
        this.configURL = configURL;
        this.configMD5 = configMD5;
        this.limits = limits;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(long j3, String str, String str2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r3, r5, r6, r7);
        List list2;
        List emptyList;
        long j16 = (i3 & 1) != 0 ? 0L : j3;
        String str3 = (i3 & 2) != 0 ? "" : str;
        String str4 = (i3 & 4) != 0 ? "" : str2;
        if ((i3 & 8) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        } else {
            list2 = list;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2, list, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
