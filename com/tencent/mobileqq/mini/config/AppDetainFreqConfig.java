package com.tencent.mobileqq.mini.config;

import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig;", "Lcom/tencent/freesia/IConfigData;", "()V", "mItemList", "", "Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig$ItemConfig;", "getItemConfig", "appId", "", "parse", "", "content", "Companion", "ItemConfig", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class AppDetainFreqConfig implements IConfigData {
    private static final String TAG = "AppDetainFreqConfig";
    private List<ItemConfig> mItemList;

    public AppDetainFreqConfig() {
        List<ItemConfig> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mItemList = emptyList;
    }

    public final ItemConfig getItemConfig(String appId) {
        Object obj;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Iterator<T> it = this.mItemList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((ItemConfig) obj).getAppId(), appId)) {
                break;
            }
        }
        return (ItemConfig) obj;
    }

    public final void parse(String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONObject(content).getJSONArray("appList");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String string = jSONObject.getString("appid");
                Intrinsics.checkNotNullExpressionValue(string, "itemJson.getString(\"appid\")");
                arrayList.add(new ItemConfig(string, jSONObject.getInt("limitTimes")));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse failed -->", e16);
        }
        this.mItemList = arrayList;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/mini/config/AppDetainFreqConfig$ItemConfig;", "", "appId", "", "limitTimes", "", "(Ljava/lang/String;I)V", "getAppId", "()Ljava/lang/String;", "getLimitTimes", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final /* data */ class ItemConfig {
        private final String appId;
        private final int limitTimes;

        public ItemConfig(String appId, int i3) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            this.appId = appId;
            this.limitTimes = i3;
        }

        /* renamed from: component1, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getLimitTimes() {
            return this.limitTimes;
        }

        public final ItemConfig copy(String appId, int limitTimes) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            return new ItemConfig(appId, limitTimes);
        }

        public final String getAppId() {
            return this.appId;
        }

        public final int getLimitTimes() {
            return this.limitTimes;
        }

        public int hashCode() {
            return (this.appId.hashCode() * 31) + this.limitTimes;
        }

        public String toString() {
            return "ItemConfig(appId=" + this.appId + ", limitTimes=" + this.limitTimes + ")";
        }

        public static /* synthetic */ ItemConfig copy$default(ItemConfig itemConfig, String str, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                str = itemConfig.appId;
            }
            if ((i16 & 2) != 0) {
                i3 = itemConfig.limitTimes;
            }
            return itemConfig.copy(str, i3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemConfig)) {
                return false;
            }
            ItemConfig itemConfig = (ItemConfig) other;
            return Intrinsics.areEqual(this.appId, itemConfig.appId) && this.limitTimes == itemConfig.limitTimes;
        }
    }
}
