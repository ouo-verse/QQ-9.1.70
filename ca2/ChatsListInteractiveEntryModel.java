package ca2;

import com.tencent.mobileqq.nearbypro.base.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lca2/a;", "", "", "c", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "", "b", "J", "()J", "time", "<init>", "(Ljava/lang/String;J)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ca2.a, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class ChatsListInteractiveEntryModel {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long time;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lca2/a$a;", "", "", "str", "Lca2/a;", "a", "", "time", "b", "NICK", "Ljava/lang/String;", "TAG", "TARGET_IS_SELF", "TARGET_NICK", "TEXT", "TIME", "TYPE", "<init>", "()V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ca2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ChatsListInteractiveEntryModel a(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("text");
                Intrinsics.checkNotNullExpressionValue(optString, "json.optString(TEXT)");
                return new ChatsListInteractiveEntryModel(optString, jSONObject.optLong("time"));
            } catch (Throwable th5) {
                j.c().d("ChatsListInteractiveCache", " " + th5);
                return null;
            }
        }

        @Nullable
        public final ChatsListInteractiveEntryModel b(@Nullable String str, long time) {
            if (str == null) {
                return null;
            }
            return new ChatsListInteractiveEntryModel(str, time);
        }

        Companion() {
        }
    }

    public ChatsListInteractiveEntryModel(@NotNull String text, long j3) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.time = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: b, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    @NotNull
    public final String c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("text", this.text);
        jSONObject.put("time", this.time);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026ime)\n        }.toString()");
        return jSONObject2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChatsListInteractiveEntryModel)) {
            return false;
        }
        ChatsListInteractiveEntryModel chatsListInteractiveEntryModel = (ChatsListInteractiveEntryModel) other;
        if (Intrinsics.areEqual(this.text, chatsListInteractiveEntryModel.text) && this.time == chatsListInteractiveEntryModel.time) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + androidx.fragment.app.a.a(this.time);
    }

    @NotNull
    public String toString() {
        return "ChatsListInteractiveEntryModel(text=" + this.text + ", time=" + this.time + ")";
    }
}
