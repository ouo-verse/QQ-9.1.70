package com.tencent.mobileqq.guild.config;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b)\u0010*R$\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R0\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\u00158\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u001bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR<\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100 2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100 8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R&\u0010(\u001a\u0012\u0012\u0004\u0012\u00020&0\u000fj\b\u0012\u0004\u0012\u00020&`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0013\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/config/v;", "", "", "<set-?>", "a", "Z", "getEnableManage", "()Z", "enableManage", "", "b", "I", "getDefaultTypeId", "()I", "defaultTypeId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/config/t;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "_typeList", "", "d", "Ljava/util/List;", "getTypeList", "()Ljava/util/List;", "typeList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "_typeMap", "", "f", "Ljava/util/Map;", "getTypeMap", "()Ljava/util/Map;", "typeMap", "Lcom/tencent/mobileqq/guild/config/u;", "g", "_customTypeList", "<init>", "()V", tl.h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class v {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static v f216227i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean enableManage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int defaultTypeId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<GuildTextChannelSubType> _typeList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<GuildTextChannelSubType> typeList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, GuildTextChannelSubType> _typeMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<Integer, GuildTextChannelSubType> typeMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<GuildTextChannelSubTypeWithFilterId> _customTypeList;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0014\u0010\u001b\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/config/v$a;", "", "Lcom/tencent/mobileqq/guild/config/v;", "bean", "Lorg/json/JSONObject;", "jsonObj", "", "b", "subTypeJson", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/guild/config/t;", "c", "", "a", "", "DEFAULT_TYPE_ID_JSON_KEY", "Ljava/lang/String;", "ENABLE_JSON_KEY", "SUBTYPE_GUILD_ID_ARR_JSON_KEY", "SUBTYPE_HINT_TEXT_JSON_KEY", "SUBTYPE_ICON_URL_JSON_KEY", "SUBTYPE_ID_JSON_KEY", "SUBTYPE_NAME_JSON_KEY", "SUBTYPE_ORDER_JSON_KEY", "SUBTYPE_WELCOME_ICON_URL_JSON_KEY", "TAG", "TYPE_CUSTOM_LIST_JSON_KEY", "TYPE_LIST_JSON_KEY", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.v$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            if (jsonObj.has("defaultTypeId") && jsonObj.has("enable")) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final void b(@NotNull v bean, @NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            QLog.i("Guild.config.GuildTextChannelSubtypeConfBean", 1, "parseFromJson: " + jsonObj);
            bean.enableManage = jsonObj.optBoolean("enable");
            bean.defaultTypeId = jsonObj.optInt("defaultTypeId");
            JSONArray subtypeArrayJson = jsonObj.optJSONArray("typeList");
            bean._typeList.clear();
            bean._typeMap.clear();
            bean._customTypeList.clear();
            if (subtypeArrayJson != null) {
                Intrinsics.checkNotNullExpressionValue(subtypeArrayJson, "subtypeArrayJson");
                int length = subtypeArrayJson.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject subTypeJson = subtypeArrayJson.getJSONObject(i3);
                    Companion companion = v.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(subTypeJson, "subTypeJson");
                    Pair<Integer, GuildTextChannelSubType> c16 = companion.c(subTypeJson);
                    int intValue = c16.component1().intValue();
                    GuildTextChannelSubType component2 = c16.component2();
                    bean._typeList.add(component2);
                    bean._typeMap.put(Integer.valueOf(intValue), component2);
                }
            }
            JSONArray customSubTypeArrayJson = jsonObj.optJSONArray("guildCustomTypeList");
            if (customSubTypeArrayJson != null) {
                Intrinsics.checkNotNullExpressionValue(customSubTypeArrayJson, "customSubTypeArrayJson");
                int length2 = customSubTypeArrayJson.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    JSONObject subTypeJson2 = customSubTypeArrayJson.getJSONObject(i16);
                    Companion companion2 = v.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(subTypeJson2, "subTypeJson");
                    Pair<Integer, GuildTextChannelSubType> c17 = companion2.c(subTypeJson2);
                    int intValue2 = c17.component1().intValue();
                    GuildTextChannelSubType component22 = c17.component2();
                    JSONArray guildIdArrayJson = subTypeJson2.optJSONArray("guildIdArr");
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    if (guildIdArrayJson != null) {
                        Intrinsics.checkNotNullExpressionValue(guildIdArrayJson, "guildIdArrayJson");
                        int length3 = guildIdArrayJson.length();
                        for (int i17 = 0; i17 < length3; i17++) {
                            String string = guildIdArrayJson.getString(i17);
                            Intrinsics.checkNotNullExpressionValue(string, "guildIdArrayJson.getString(j)");
                            linkedHashSet.add(string);
                        }
                    }
                    GuildTextChannelSubTypeWithFilterId guildTextChannelSubTypeWithFilterId = new GuildTextChannelSubTypeWithFilterId(component22, linkedHashSet);
                    bean._typeMap.put(Integer.valueOf(intValue2), component22);
                    bean._customTypeList.add(guildTextChannelSubTypeWithFilterId);
                }
            }
            QLog.i("Guild.config.GuildTextChannelSubtypeConfBean", 2, "parseFromJson complete.");
            v.f216227i = bean;
        }

        @JvmStatic
        @NotNull
        public final Pair<Integer, GuildTextChannelSubType> c(@NotNull JSONObject subTypeJson) {
            Intrinsics.checkNotNullParameter(subTypeJson, "subTypeJson");
            int optInt = subTypeJson.optInt("id");
            int optInt2 = subTypeJson.optInt("order");
            String name = subTypeJson.optString("name");
            String hintText = subTypeJson.optString("hintText");
            String iconUrl = subTypeJson.optString("iconUrl");
            String welcomeIconUrl = subTypeJson.optString("welcomeIconUrl");
            Integer valueOf = Integer.valueOf(optInt);
            Intrinsics.checkNotNullExpressionValue(name, "name");
            Intrinsics.checkNotNullExpressionValue(hintText, "hintText");
            Intrinsics.checkNotNullExpressionValue(iconUrl, "iconUrl");
            Intrinsics.checkNotNullExpressionValue(welcomeIconUrl, "welcomeIconUrl");
            return new Pair<>(valueOf, new GuildTextChannelSubType(optInt, optInt2, name, hintText, iconUrl, welcomeIconUrl));
        }

        Companion() {
        }
    }

    public v() {
        ArrayList<GuildTextChannelSubType> arrayList = new ArrayList<>();
        this._typeList = arrayList;
        this.typeList = arrayList;
        HashMap<Integer, GuildTextChannelSubType> hashMap = new HashMap<>();
        this._typeMap = hashMap;
        this.typeMap = hashMap;
        this._customTypeList = new ArrayList<>();
    }

    @JvmStatic
    public static final boolean g(@NotNull JSONObject jSONObject) {
        return INSTANCE.a(jSONObject);
    }

    @JvmStatic
    public static final void h(@NotNull v vVar, @NotNull JSONObject jSONObject) {
        INSTANCE.b(vVar, jSONObject);
    }
}
