package ca2;

import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.mobileqq.nearbypro.base.j;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u00032\u00020\u0001:\u0001\u0004B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000e\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lca2/b;", "", "", "d", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "accountId", "b", "c", "setNick", "nick", "setAvatarUrl", PhotoCategorySummaryInfo.AVATAR_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String accountId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String nick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String avatarUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lca2/b$a;", "", "", "jsonString", "Lca2/b;", "a", "ACCOUNT_ID", "Ljava/lang/String;", "AVATAR_URL", "NICK", "TAG", "<init>", "()V", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ca2.b$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a(@NotNull String jsonString) {
            boolean z16;
            b bVar;
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                if (jsonString.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    bVar = new b(null, null, null, 7, null);
                } else {
                    JSONObject jSONObject = new JSONObject(jsonString);
                    bVar = new b(jSONObject.optString("accountId"), jSONObject.optString("nick"), jSONObject.optString(PhotoCategorySummaryInfo.AVATAR_URL));
                }
                return bVar;
            } catch (Throwable th5) {
                j.c().d("MatchFriendBaseInfo", th5.toString());
                return new b(null, null, null, 7, null);
            }
        }

        Companion() {
        }
    }

    public b(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.accountId = str;
        this.nick = str2;
        this.avatarUrl = str3;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAccountId() {
        return this.accountId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    @NotNull
    public final String d() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("accountId", this.accountId);
        jSONObject.put("nick", this.nick);
        jSONObject.put(PhotoCategorySummaryInfo.AVATAR_URL, this.avatarUrl);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026Url)\n        }.toString()");
        return jSONObject2;
    }

    public /* synthetic */ b(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3);
    }
}
