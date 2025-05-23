package com.tencent.mobileqq.activity.aio.intimate.header;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u0000 \u00052\u00020\u0001:\u0001\u000bBG\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\u0006\u0010!\u001a\u00020\u0002\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0015\u0010\u000eR\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u001c\u0010\u000eR\u0017\u0010\u001e\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u0013\u0010\u001aR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b\u0010\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "", "", "toString", "Lorg/json/JSONObject;", "i", "", "hashCode", "other", "", "equals", "a", "I", tl.h.F, "()I", "type", "b", "d", "level", "c", "days", "f", "realDays", "", "e", "J", "()J", "lightUpTime", "g", "scores", "flag", "Ljava/lang/String;", "()Ljava/lang/String;", "extendName", "<init>", "(IIIIJIJLjava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class g {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int level;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int days;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int realDays;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long lightUpTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int scores;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final long flag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String extendName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0007J \u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0007R\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/g$a;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "Lkotlin/collections/ArrayList;", IQQGameCommApi.K_ABTEST_MODELS, "Lorg/json/JSONArray;", "b", "", "jsonStr", "d", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "c", "model", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.aio.intimate.header.g$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final g a(@NotNull g model) {
            Intrinsics.checkNotNullParameter(model, "model");
            return new g(model.getType(), model.getLevel(), model.getRealDays(), model.getRealDays(), model.getLightUpTime(), model.getScores(), model.getFlag(), model.getExtendName());
        }

        @JvmStatic
        @NotNull
        public final JSONArray b(@NotNull ArrayList<g> models) {
            Intrinsics.checkNotNullParameter(models, "models");
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = models.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(((g) it.next()).i());
            }
            return jSONArray;
        }

        @JvmStatic
        @Nullable
        public final g c(@NotNull JSONObject json) {
            Intrinsics.checkNotNullParameter(json, "json");
            try {
                int i3 = json.getInt("type");
                int i16 = json.getInt("level");
                int i17 = json.getInt("days");
                int i18 = json.getInt("realDays");
                long j3 = json.getLong("lightUpTime");
                int i19 = json.getInt("scores");
                long optLong = json.optLong("flag", 0L);
                String extendName = json.optString("extendName", "");
                Intrinsics.checkNotNullExpressionValue(extendName, "extendName");
                return new g(i3, i16, i17, i18, j3, i19, optLong, extendName);
            } catch (JSONException e16) {
                QLog.e("IntimateHeaderCardModel", 1, e16, new Object[0]);
                return null;
            }
        }

        @JvmStatic
        @NotNull
        public final ArrayList<g> d(@NotNull String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            if (TextUtils.isEmpty(jsonStr)) {
                return new ArrayList<>();
            }
            try {
                ArrayList<g> arrayList = new ArrayList<>();
                JSONArray jSONArray = new JSONArray(jsonStr);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject json = jSONArray.optJSONObject(i3);
                    Intrinsics.checkNotNullExpressionValue(json, "json");
                    g c16 = c(json);
                    if (c16 != null) {
                        arrayList.add(c16);
                    }
                }
                return arrayList;
            } catch (JSONException e16) {
                QLog.e("IntimateHeaderCardModel", 1, e16, new Object[0]);
                return new ArrayList<>();
            }
        }

        Companion() {
        }
    }

    public g(int i3, int i16, int i17, int i18, long j3, int i19, long j16, @NotNull String extendName) {
        Intrinsics.checkNotNullParameter(extendName, "extendName");
        this.type = i3;
        this.level = i16;
        this.days = i17;
        this.realDays = i18;
        this.lightUpTime = j3;
        this.scores = i19;
        this.flag = j16;
        this.extendName = extendName;
    }

    /* renamed from: a, reason: from getter */
    public final int getDays() {
        return this.days;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getExtendName() {
        return this.extendName;
    }

    /* renamed from: c, reason: from getter */
    public final long getFlag() {
        return this.flag;
    }

    /* renamed from: d, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* renamed from: e, reason: from getter */
    public final long getLightUpTime() {
        return this.lightUpTime;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof g)) {
            return false;
        }
        g gVar = (g) other;
        if (this.type == gVar.type && this.level == gVar.level && this.days == gVar.days && this.realDays == gVar.realDays && this.lightUpTime == gVar.lightUpTime && this.scores == gVar.scores && this.flag == gVar.flag && Intrinsics.areEqual(this.extendName, gVar.extendName)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getRealDays() {
        return this.realDays;
    }

    /* renamed from: g, reason: from getter */
    public final int getScores() {
        return this.scores;
    }

    /* renamed from: h, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((this.type * 31) + this.level) * 31) + this.days) * 31) + this.realDays) * 31) + androidx.fragment.app.a.a(this.lightUpTime)) * 31) + this.scores) * 31) + androidx.fragment.app.a.a(this.flag)) * 31) + this.extendName.hashCode();
    }

    @NotNull
    public final JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.type);
        jSONObject.put("level", this.level);
        jSONObject.put("days", this.days);
        jSONObject.put("realDays", this.realDays);
        jSONObject.put("lightUpTime", this.lightUpTime);
        jSONObject.put("scores", this.scores);
        jSONObject.put("flag", this.flag);
        jSONObject.put("extendName", this.extendName);
        return jSONObject;
    }

    @NotNull
    public String toString() {
        return "IntimateHeaderCardModel[type=" + this.type + ",level=" + this.level + ",days=" + this.days + ",realDays=" + this.realDays + ",scores=" + this.scores + "]";
    }
}
