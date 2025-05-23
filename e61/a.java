package e61;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\nB5\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Le61/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "c", "()J", "id", "", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "label", "I", "()I", "emotionId", "Ljava/lang/String;", "()Ljava/lang/String;", "icon", "<init>", "(JLjava/util/List;ILjava/lang/String;)V", "e", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> label;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int emotionId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String icon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Le61/a$a;", "", "Lorg/json/JSONArray;", "", "", "b", "", "key", "Lorg/json/JSONObject;", "jsonObject", "Le61/a;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e61.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<String> b(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String optString = jSONArray.optString(i3);
                if (optString == null) {
                    optString = "";
                }
                arrayList.add(optString);
            }
            return arrayList;
        }

        @NotNull
        public final a a(long key, @NotNull JSONObject jsonObject) {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            a aVar = new a(0L, null, 0, null, 15, null);
            try {
                JSONArray optJSONArray = jsonObject.optJSONArray("label");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray((Object) 0);
                }
                List<String> b16 = b(optJSONArray);
                int optInt = jsonObject.optInt("emotionId");
                String optString = jsonObject.optString("icon");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(InteractSendMsgBean.ICON)");
                return new a(key, b16, optInt, optString);
            } catch (Exception e16) {
                QLog.e("InteractSendMsgBean", 1, "copyFromJson " + e16);
                return aVar;
            }
        }

        Companion() {
        }
    }

    public a() {
        this(0L, null, 0, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getEmotionId() {
        return this.emotionId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    public final List<String> d() {
        return this.label;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.id == aVar.id && Intrinsics.areEqual(this.label, aVar.label) && this.emotionId == aVar.emotionId && Intrinsics.areEqual(this.icon, aVar.icon)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((androidx.fragment.app.a.a(this.id) * 31) + this.label.hashCode()) * 31) + this.emotionId) * 31) + this.icon.hashCode();
    }

    @NotNull
    public String toString() {
        return "id = " + this.id + ", label = " + this.label + ", emotionId = " + this.emotionId + ", icon = " + this.icon;
    }

    public a(long j3, @NotNull List<String> label, int i3, @NotNull String icon) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(icon, "icon");
        this.id = j3;
        this.label = label;
        this.emotionId = i3;
        this.icon = icon;
    }

    public /* synthetic */ a(long j3, List list, int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1L : j3, (i16 & 2) != 0 ? new ArrayList() : list, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str);
    }
}
