package kc2;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\t\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001\tB7\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0018\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lkc2/b;", "", "", "text", "e", "c", "", "key", "d", "a", "Ljava/lang/String;", "getConstellationName", "()Ljava/lang/String;", "setConstellationName", "(Ljava/lang/String;)V", "constellationName", "", "b", "Ljava/util/List;", "getTrends", "()Ljava/util/List;", "setTrends", "(Ljava/util/List;)V", "trends", "", "Ljava/util/Map;", "getTrendsMap", "()Ljava/util/Map;", "setTrendsMap", "(Ljava/util/Map;)V", "trendsMap", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public class b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final int f412014e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final int f412015f = 2;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String constellationName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> trends;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, String> trendsMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkc2/b$a;", "", "", "TYPE_COLOR", "I", "a", "()I", "TYPE_NUMBER", "b", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kc2.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return b.f412014e;
        }

        public final int b() {
            return b.f412015f;
        }

        Companion() {
        }
    }

    public b() {
        this(null, null, null, 7, null);
    }

    @NotNull
    public final String c() {
        Object random;
        if (!this.trends.isEmpty()) {
            random = CollectionsKt___CollectionsKt.random(this.trends, Random.INSTANCE);
            return (String) random;
        }
        return "";
    }

    @Nullable
    public final String d(int key) {
        if (this.trendsMap.containsKey(Integer.valueOf(key)) && this.trendsMap.get(Integer.valueOf(key)) != null) {
            return this.trendsMap.get(Integer.valueOf(key));
        }
        return "";
    }

    @NotNull
    public final b e(@Nullable String text) {
        boolean z16;
        boolean z17;
        boolean isBlank;
        boolean z18;
        boolean z19;
        if (QLog.isColorLevel()) {
            QLog.d("ConstellationTrend", 2, "parse: called. ", "text: " + text);
        }
        try {
            JSONObject jSONObject = new JSONObject(text);
            String optString = jSONObject.optString("title");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"title\")");
            this.constellationName = optString;
            List<String> list = this.trends;
            String luckyColor = jSONObject.optString("lucky_color");
            Intrinsics.checkNotNullExpressionValue(luckyColor, "luckyColor");
            if (luckyColor.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                list.add("\u4eca\u65e5\u5e78\u8fd0\u989c\u8272\u4e3a" + luckyColor);
                this.trendsMap.put(Integer.valueOf(f412014e), luckyColor);
            }
            String luckyNumber = jSONObject.optString("lucky_number");
            Intrinsics.checkNotNullExpressionValue(luckyNumber, "luckyNumber");
            if (luckyNumber.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                list.add("\u4eca\u65e5\u5e78\u8fd0\u6570\u5b57\u4e3a" + luckyNumber);
                this.trendsMap.put(Integer.valueOf(f412015f), luckyNumber);
            }
            String greatThing = jSONObject.optString("great_thing");
            Intrinsics.checkNotNullExpressionValue(greatThing, "greatThing");
            List<String> split = new Regex("[,\uff0c]").split(greatThing, 0);
            isBlank = StringsKt__StringsJVMKt.isBlank(greatThing);
            if ((!isBlank) && (!split.isEmpty())) {
                list.add("\u4eca\u65e5\u5b9c" + ((Object) split.get(0)));
            }
            String speedSign = jSONObject.optString("speed_sign_name");
            Intrinsics.checkNotNullExpressionValue(speedSign, "speedSign");
            if (speedSign.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                list.add("\u901f\u914d\u661f\u5ea7\uff1a" + speedSign);
            }
            List<String> list2 = this.trends;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (((String) obj).length() > 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    arrayList.add(obj);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ConstellationTrend", 2, "parse: called. ", "constellationName: " + this.constellationName, e16);
            }
        }
        return this;
    }

    public b(@NotNull String constellationName, @NotNull List<String> trends, @NotNull Map<Integer, String> trendsMap) {
        Intrinsics.checkNotNullParameter(constellationName, "constellationName");
        Intrinsics.checkNotNullParameter(trends, "trends");
        Intrinsics.checkNotNullParameter(trendsMap, "trendsMap");
        this.constellationName = constellationName;
        this.trends = trends;
        this.trendsMap = trendsMap;
    }

    public /* synthetic */ b(String str, List list, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? new ArrayList() : list, (i3 & 4) != 0 ? new LinkedHashMap() : map);
    }
}
