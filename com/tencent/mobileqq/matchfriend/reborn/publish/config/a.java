package com.tencent.mobileqq.matchfriend.reborn.publish.config;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\u0005\u0010\tR.\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\r\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/a;", "Lcom/tencent/freesia/IConfigData;", "", "c", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;", "a", "()Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;", "(Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;)V", "default", "", "", "e", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "tipBeanMap", "<init>", "()V", "f", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a implements IConfigData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TipsBean default;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Map<String, TipsBean> tipBeanMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/a$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/b;", "b", "", "content", "Lcom/tencent/mobileqq/matchfriend/reborn/publish/config/a;", "a", "NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.publish.config.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final TipsBean b(JSONObject jsonObject) {
            String optString = jsonObject.optString("imageUrl");
            if (optString == null) {
                optString = "";
            }
            return new TipsBean(optString, com.tencent.mobileqq.matchfriend.reborn.config.a.c(jsonObject, "tips"));
        }

        public final a a(String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(content);
                JSONObject optJSONObject = jSONObject.optJSONObject("default");
                if (optJSONObject != null) {
                    aVar.d(a.INSTANCE.b(optJSONObject));
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("configList");
                if (optJSONArray != null) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject configItem = optJSONArray.getJSONObject(i3);
                        String date = configItem.optString("date");
                        Intrinsics.checkNotNullExpressionValue(date, "date");
                        Companion companion = a.INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(configItem, "configItem");
                        linkedHashMap.put(date, companion.b(configItem));
                    }
                    aVar.e(linkedHashMap);
                }
            } catch (Exception e16) {
                QLog.e("QQStrangerSquarePublishConfigBean", 1, "parse config error", e16);
            }
            return aVar;
        }

        Companion() {
        }
    }

    public a() {
        List emptyList;
        Map<String, TipsBean> emptyMap;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.default = new TipsBean("", emptyList);
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.tipBeanMap = emptyMap;
    }

    /* renamed from: a, reason: from getter */
    public final TipsBean getDefault() {
        return this.default;
    }

    public final Map<String, TipsBean> b() {
        return this.tipBeanMap;
    }

    public final boolean c() {
        if (!((this.default.getImageUrl().length() > 0) && (this.default.b().isEmpty() ^ true))) {
            return false;
        }
        if (!this.tipBeanMap.isEmpty()) {
            for (Map.Entry<String, TipsBean> entry : this.tipBeanMap.entrySet()) {
                if (!(entry.getKey().length() == 0)) {
                    if (!(entry.getValue().getImageUrl().length() == 0) && !entry.getValue().b().isEmpty()) {
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final void d(TipsBean tipsBean) {
        Intrinsics.checkNotNullParameter(tipsBean, "<set-?>");
        this.default = tipsBean;
    }

    public final void e(Map<String, TipsBean> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.tipBeanMap = map;
    }
}
