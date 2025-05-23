package ln2;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 \u00032\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u0005\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\u0012\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lln2/a;", "", "", "e", "", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "title", "b", "f", "description", "c", h.F, WadlProxyConsts.KEY_JUMP_URL, "g", "iconUrl", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String title = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String description = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String jumpUrl = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String iconUrl = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lln2/a$a;", "", "", "content", "Lln2/a;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ln2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final a a(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            JSONObject jSONObject = new JSONObject(content);
            a aVar = new a();
            String optString = jSONObject.optString("title", "");
            Intrinsics.checkNotNullExpressionValue(optString, "contentJson.optString(\"title\", \"\")");
            aVar.i(optString);
            String optString2 = jSONObject.optString("description", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "contentJson.optString(\"description\", \"\")");
            aVar.f(optString2);
            String optString3 = jSONObject.optString("url", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "contentJson.optString(\"url\", \"\")");
            aVar.h(optString3);
            String optString4 = jSONObject.optString("icon_url", "");
            Intrinsics.checkNotNullExpressionValue(optString4, "contentJson.optString(\"icon_url\", \"\")");
            aVar.g(optString4);
            if (!aVar.e()) {
                return null;
            }
            return aVar;
        }

        Companion() {
        }
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final boolean e() {
        boolean z16;
        boolean z17;
        if (this.title.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (this.jumpUrl.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.iconUrl = str;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
