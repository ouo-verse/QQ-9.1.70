package com.tencent.mobileqq.guild.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000f2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R3\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/config/x;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/guild/config/b;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "a", "()Ljava/util/HashMap;", "configMap", "<init>", "()V", "e", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class x implements IConfigData {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, GuideBubbleData> configMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/config/x$a;", "", "", "content", "Lcom/tencent/mobileqq/guild/config/b;", "a", "Lcom/tencent/mobileqq/guild/config/x;", "b", "GUILD_DISCOVER_BUBBLE", "Ljava/lang/String;", "GUILD_NODE_BUBBLE", "GUILD_NODE_BUBBLE_SUBTITLE", "GUILD_NODE_BUBBLE_TITLE", "GUILD_PERSONAL_PAGE_BUBBLE", "GUILD_RECOMMEND_BUBBLE", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.x$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuideBubbleData a(String content) {
            JSONObject jSONObject = new JSONObject(content);
            String title = jSONObject.optString("title");
            String subtitle = jSONObject.optString("subtitle");
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(subtitle, "subtitle");
            return new GuideBubbleData(title, subtitle);
        }

        @NotNull
        public final x b(@Nullable String content) {
            boolean z16;
            x xVar = new x();
            if (content != null && content.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return xVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (jSONObject.has("guild_node_bubble")) {
                    HashMap<Integer, GuideBubbleData> a16 = xVar.a();
                    String optString = jSONObject.optString("guild_node_bubble");
                    Intrinsics.checkNotNullExpressionValue(optString, "contentObj.optString(GUILD_NODE_BUBBLE)");
                    a16.put(0, a(optString));
                }
                if (jSONObject.has("guild_discover_bubble")) {
                    HashMap<Integer, GuideBubbleData> a17 = xVar.a();
                    String optString2 = jSONObject.optString("guild_discover_bubble");
                    Intrinsics.checkNotNullExpressionValue(optString2, "contentObj.optString(GUILD_DISCOVER_BUBBLE)");
                    a17.put(1, a(optString2));
                }
                if (jSONObject.has("guild_recommend_bubble")) {
                    HashMap<Integer, GuideBubbleData> a18 = xVar.a();
                    String optString3 = jSONObject.optString("guild_recommend_bubble");
                    Intrinsics.checkNotNullExpressionValue(optString3, "contentObj.optString(GUILD_RECOMMEND_BUBBLE)");
                    a18.put(2, a(optString3));
                }
                if (jSONObject.has("guild_personal_page_bubble")) {
                    HashMap<Integer, GuideBubbleData> a19 = xVar.a();
                    String optString4 = jSONObject.optString("guild_personal_page_bubble");
                    Intrinsics.checkNotNullExpressionValue(optString4, "contentObj.optString(GUILD_PERSONAL_PAGE_BUBBLE)");
                    a19.put(3, a(optString4));
                }
            } catch (JSONException e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "error parse NewUserGuideBubbleConfig content:" + content;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.config.NewUserGuideBubbleConfig", 1, (String) it.next(), e16);
                }
            }
            return xVar;
        }

        Companion() {
        }
    }

    public x() {
        HashMap<Integer, GuideBubbleData> hashMap = new HashMap<>();
        this.configMap = hashMap;
        hashMap.put(0, new GuideBubbleData("\u4f60\u52a0\u5165\u7684\u9891\u9053\u5728\u8fd9\u91cc", "\u70b9\u51fb\u5f00\u542f\u9891\u9053\u63a2\u7d22\u4e4b\u65c5"));
        hashMap.put(1, new GuideBubbleData("\u53d1\u73b0\u66f4\u597d\u73a9\u4e8b\u513f\u6765\u8fd9\u91cc", "\u70b9\u51fb\u5f00\u542f\u9891\u9053\u63a2\u7d22\u4e4b\u65c5"));
        hashMap.put(2, new GuideBubbleData("\u5b98\u65b9\u7504\u9009\u9891\u9053\u5728\u8fd9\u91cc", "\u70b9\u51fb\u76f4\u8fbe\u7cbe\u5f69\u9891\u9053"));
        hashMap.put(3, new GuideBubbleData("\u8fd9\u662f\u4e2a\u4eba\u4e3b\u9875", "\u70b9\u51fb\u8bbe\u7f6e\u5728\u9891\u9053\u7684\u5168\u65b0\u8eab\u4efd"));
    }

    @NotNull
    public final HashMap<Integer, GuideBubbleData> a() {
        return this.configMap;
    }

    @NotNull
    public String toString() {
        String obj = this.configMap.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "configMap.toString()");
        return obj;
    }
}
