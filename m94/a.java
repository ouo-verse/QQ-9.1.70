package m94;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\r\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lm94/a;", "", "", "toString", "", "d", "Lorg/json/JSONObject;", "e", "", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "a", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "c", "()Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "", "Luv4/az;", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "dressMap", "Lqu4/a;", "Lqu4/a;", "()Lqu4/a;", "avatarCharacter", "<init>", "(Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;Ljava/util/Map;Lqu4/a;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final /* data */ class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final UEAvatarGender gender;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, az> dressMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final qu4.a avatarCharacter;

    public a() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final qu4.a getAvatarCharacter() {
        return this.avatarCharacter;
    }

    public final Map<Integer, az> b() {
        return this.dressMap;
    }

    /* renamed from: c, reason: from getter */
    public final UEAvatarGender getGender() {
        return this.gender;
    }

    public final boolean d() {
        return !this.dressMap.isEmpty();
    }

    public final JSONObject e() {
        JSONArray jSONArray = new JSONArray();
        for (az azVar : this.dressMap.values()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, azVar.B);
            jSONArray.mo162put(jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("items", jSONArray);
        jSONObject2.put("gender", this.gender.getIndex());
        return jSONObject2;
    }

    public int hashCode() {
        return (((this.gender.hashCode() * 31) + this.dressMap.hashCode()) * 31) + this.avatarCharacter.hashCode();
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("gender", this.gender);
        jSONObject.put("dressMapSimple", r94.c.z(this.dressMap));
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public a(UEAvatarGender gender, Map<Integer, az> dressMap, qu4.a avatarCharacter) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(dressMap, "dressMap");
        Intrinsics.checkNotNullParameter(avatarCharacter, "avatarCharacter");
        this.gender = gender;
        this.dressMap = dressMap;
        this.avatarCharacter = avatarCharacter;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return this.gender == aVar.gender && Intrinsics.areEqual(this.dressMap, aVar.dressMap) && Intrinsics.areEqual(this.avatarCharacter, aVar.avatarCharacter);
    }

    public /* synthetic */ a(UEAvatarGender uEAvatarGender, Map map, qu4.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? UEAvatarGender.MALE : uEAvatarGender, (i3 & 2) != 0 ? new HashMap() : map, (i3 & 4) != 0 ? new qu4.a() : aVar);
    }
}
