package am4;

import com.tencent.timi.game.utils.l;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vl4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0003\u0006\u000e\u0016B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lam4/a;", "", "", "firstPosition", "secondPosition", "Lorg/json/JSONArray;", "a", "", "Ljava/lang/String;", "getArkUin", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "arkUin", "b", "I", "()I", "e", "(I)V", "columns", "", "Lam4/a$b;", "c", "Ljava/util/List;", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", VideoTemplateParser.ITEM_LIST, "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String arkUin = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int columns;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<b> itemList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000f"}, d2 = {"Lam4/a$a;", "", "Lorg/json/JSONArray;", "itemJsonArray", "", "Lam4/a$b;", "a", "Lam4/a$c;", "b", "", "param", "Lam4/a;", "c", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: am4.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final List<b> a(JSONArray itemJsonArray) {
            int i3;
            String str;
            ArrayList arrayList = new ArrayList();
            if (itemJsonArray.length() > 0) {
                int length = itemJsonArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    JSONObject optJSONObject = itemJsonArray.optJSONObject(i16);
                    b bVar = new b();
                    if (optJSONObject != null) {
                        i3 = optJSONObject.optInt("type");
                    } else {
                        i3 = -1;
                    }
                    bVar.g(i3);
                    JSONArray jSONArray = null;
                    if (optJSONObject != null) {
                        str = optJSONObject.optString("text");
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "";
                    }
                    bVar.f(str);
                    if (optJSONObject != null) {
                        jSONArray = optJSONObject.optJSONArray("child");
                    }
                    if (jSONArray != null) {
                        bVar.e(b(jSONArray));
                    }
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }

        private final List<c> b(JSONArray itemJsonArray) {
            String str;
            int i3;
            ArrayList arrayList = new ArrayList();
            if (itemJsonArray.length() > 0) {
                int length = itemJsonArray.length();
                for (int i16 = 0; i16 < length; i16++) {
                    JSONObject optJSONObject = itemJsonArray.optJSONObject(i16);
                    c cVar = new c();
                    if (optJSONObject != null) {
                        str = optJSONObject.optString("text");
                    } else {
                        str = null;
                    }
                    if (str == null) {
                        str = "";
                    }
                    cVar.c(str);
                    if (optJSONObject != null) {
                        i3 = optJSONObject.optInt("type");
                    } else {
                        i3 = -1;
                    }
                    cVar.d(i3);
                    arrayList.add(cVar);
                }
            }
            return arrayList;
        }

        @NotNull
        public final a c(@NotNull String param) {
            Intrinsics.checkNotNullParameter(param, "param");
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(param);
                String arkUin = jSONObject.optString("arkuin");
                Intrinsics.checkNotNullExpressionValue(arkUin, "arkUin");
                aVar.d(arkUin);
                aVar.e(jSONObject.optInt("columns", 0));
                JSONArray optJSONArray = jSONObject.optJSONArray("options");
                if (optJSONArray != null) {
                    aVar.f(a(optJSONArray));
                }
            } catch (JSONException e16) {
                l.e("ProfileRecordArkModeInfo", "parseSelectModeData error " + e16);
            }
            return aVar;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\r\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lam4/a$b;", "Lvl4/d;", "Lam4/a$c;", "", "a", "", "I", "d", "()I", "g", "(I)V", "type", "", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "text", "Ljava/util/List;", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "childList", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements d<c> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String text = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private List<c> childList;

        @Override // vl4.d
        @Nullable
        public List<c> a() {
            return this.childList;
        }

        @Nullable
        public final List<c> b() {
            return this.childList;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: d, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final void e(@Nullable List<c> list) {
            this.childList = list;
        }

        public final void f(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }

        public final void g(int i3) {
            this.type = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lam4/a$c;", "", "", "a", "I", "b", "()I", "d", "(I)V", "type", "", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "text", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int type = 1;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String text = "";

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* renamed from: b, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public final void c(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }

        public final void d(int i3) {
            this.type = i3;
        }
    }

    @NotNull
    public final JSONArray a(int firstPosition, int secondPosition) {
        int i3;
        JSONArray jSONArray = new JSONArray();
        if (this.columns >= 1 && firstPosition >= 0) {
            List<b> list = this.itemList;
            int i16 = 0;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            if (i3 > firstPosition) {
                List<b> list2 = this.itemList;
                Intrinsics.checkNotNull(list2);
                b bVar = list2.get(firstPosition);
                jSONArray.put(bVar.getType());
                if (this.columns >= 2 && secondPosition >= 0) {
                    List<c> b16 = bVar.b();
                    if (b16 != null) {
                        i16 = b16.size();
                    }
                    if (secondPosition < i16) {
                        List<c> b17 = bVar.b();
                        Intrinsics.checkNotNull(b17);
                        jSONArray.put(b17.get(secondPosition).getType());
                    }
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: b, reason: from getter */
    public final int getColumns() {
        return this.columns;
    }

    @Nullable
    public final List<b> c() {
        return this.itemList;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.arkUin = str;
    }

    public final void e(int i3) {
        this.columns = i3;
    }

    public final void f(@Nullable List<b> list) {
        this.itemList = list;
    }
}
