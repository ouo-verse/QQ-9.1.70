package com.tencent.mobileqq.qwallet.home;

import com.google.gson.annotations.SerializedName;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedDot;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/d;", "", "Lcom/tencent/mobileqq/qwallet/home/d$b;", "f", "", "b", "", "d", "msgTime", "", "e", tl.h.F, "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedDot;", "redDot", "c", "g", "Lcom/tencent/mobileqq/qwallet/home/d$a;", "Lcom/tencent/mobileqq/qwallet/home/d$a;", "defaultConfig", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/qwallet/home/d$b;", "saveData", "<init>", "()V", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f278053a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CarouselRedDotConfig defaultConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CarouselRedDotConfig config;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SaveData saveData;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/d$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "maxCount", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "storageDays", "b", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.d$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class CarouselRedDotConfig {

        @SerializedName("maxCount")
        @Nullable
        private final Integer maxCount;

        @SerializedName("storageDays")
        @Nullable
        private final Integer storageDays;

        public CarouselRedDotConfig() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Integer getMaxCount() {
            return this.maxCount;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final Integer getStorageDays() {
            return this.storageDays;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CarouselRedDotConfig)) {
                return false;
            }
            CarouselRedDotConfig carouselRedDotConfig = (CarouselRedDotConfig) other;
            if (Intrinsics.areEqual(this.maxCount, carouselRedDotConfig.maxCount) && Intrinsics.areEqual(this.storageDays, carouselRedDotConfig.storageDays)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            Integer num = this.maxCount;
            int i3 = 0;
            if (num == null) {
                hashCode = 0;
            } else {
                hashCode = num.hashCode();
            }
            int i16 = hashCode * 31;
            Integer num2 = this.storageDays;
            if (num2 != null) {
                i3 = num2.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "CarouselRedDotConfig(maxCount=" + this.maxCount + ", storageDays=" + this.storageDays + ")";
        }

        public CarouselRedDotConfig(@Nullable Integer num, @Nullable Integer num2) {
            this.maxCount = num;
            this.storageDays = num2;
        }

        public /* synthetic */ CarouselRedDotConfig(Integer num, Integer num2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : num2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0018\b\u0002\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000fj\b\u0012\u0004\u0012\u00020\u0004`\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR'\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000fj\b\u0012\u0004\u0012\u00020\u0004`\u00108\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/d$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "time", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "redDotIds", "<init>", "(JLjava/util/ArrayList;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.d$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class SaveData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long time;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ArrayList<Integer> redDotIds;

        public SaveData() {
            this(0L, null, 3, null);
        }

        @NotNull
        public final ArrayList<Integer> a() {
            return this.redDotIds;
        }

        /* renamed from: b, reason: from getter */
        public final long getTime() {
            return this.time;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaveData)) {
                return false;
            }
            SaveData saveData = (SaveData) other;
            if (this.time == saveData.time && Intrinsics.areEqual(this.redDotIds, saveData.redDotIds)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (androidx.fragment.app.a.a(this.time) * 31) + this.redDotIds.hashCode();
        }

        @NotNull
        public String toString() {
            return "SaveData(time=" + this.time + ", redDotIds=" + this.redDotIds + ")";
        }

        public SaveData(long j3, @NotNull ArrayList<Integer> redDotIds) {
            Intrinsics.checkNotNullParameter(redDotIds, "redDotIds");
            this.time = j3;
            this.redDotIds = redDotIds;
        }

        public /* synthetic */ SaveData(long j3, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? d.f278053a.d() : j3, (i3 & 2) != 0 ? new ArrayList() : arrayList);
        }
    }

    static {
        d dVar = new d();
        f278053a = dVar;
        CarouselRedDotConfig carouselRedDotConfig = new CarouselRedDotConfig(5, 1);
        defaultConfig = carouselRedDotConfig;
        config = (CarouselRedDotConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_HOME_CAROUSEL_RED_DOT, carouselRedDotConfig);
        saveData = dVar.f();
    }

    d() {
    }

    private final void b() {
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = saveData.a().iterator();
        while (it.hasNext()) {
            jSONArray.put(((Number) it.next()).intValue());
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("lastDay", saveData.getTime());
        jSONObject.put("idList", jSONArray);
        String str = "qwallet_home_carousel_red_dot_clicked_" + com.tencent.mobileqq.base.a.c();
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        com.tencent.mobileqq.qwallet.utils.g.q(str, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long d() {
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    private final boolean e(long msgTime) {
        int i3;
        long currentTimeMillis = System.currentTimeMillis() - msgTime;
        Integer storageDays = config.getStorageDays();
        if (storageDays != null) {
            i3 = storageDays.intValue();
        } else {
            i3 = 1;
        }
        if (currentTimeMillis > i3 * 86400000) {
            return true;
        }
        return false;
    }

    private final SaveData f() {
        try {
            boolean z16 = true;
            QLog.d("CarouselRedDotNativeData", 1, "parseList uin=" + com.tencent.mobileqq.base.a.c());
            String i3 = com.tencent.mobileqq.qwallet.utils.g.i("qwallet_home_carousel_red_dot_clicked_" + com.tencent.mobileqq.base.a.c());
            if (i3.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return new SaveData(0L, null, 3, null);
            }
            JSONObject jSONObject = new JSONObject(i3);
            long optLong = jSONObject.optLong("lastDay");
            if (e(optLong)) {
                return new SaveData(0L, null, 3, null);
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("idList");
            if (optJSONArray == null) {
                return new SaveData(0L, null, 3, null);
            }
            int length = optJSONArray.length();
            for (int i16 = 0; i16 < length; i16++) {
                arrayList.add(Integer.valueOf(optJSONArray.optInt(i16)));
            }
            return new SaveData(optLong, arrayList);
        } catch (Throwable th5) {
            QLog.e("CarouselRedDotNativeData", 4, th5, new Object[0]);
            return new SaveData(d(), new ArrayList());
        }
    }

    public final boolean c(@NotNull QWalletHomePage$RedDot redDot) {
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        int size = saveData.a().size();
        Integer maxCount = config.getMaxCount();
        if (maxCount != null) {
            i3 = maxCount.intValue();
        } else {
            i3 = 5;
        }
        boolean z17 = false;
        if (size >= i3 || !c4.a.s(redDot)) {
            return false;
        }
        ArrayList<Integer> a16 = saveData.a();
        if (!(a16 instanceof Collection) || !a16.isEmpty()) {
            Iterator<T> it = a16.iterator();
            while (it.hasNext()) {
                if (((Number) it.next()).intValue() == redDot.f41695id.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            }
        }
        z17 = true;
        QLog.d("CarouselRedDotNativeData", 1, redDot.f41695id.get() + " canShow result = " + z17);
        return z17;
    }

    public final void g(@NotNull QWalletHomePage$RedDot redDot) {
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        saveData.a().add(Integer.valueOf(redDot.f41695id.get()));
        b();
    }

    public final void h() {
        saveData = f();
        config = (CarouselRedDotConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_HOME_CAROUSEL_RED_DOT, defaultConfig);
    }
}
