package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB!\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "enable", "Z", "a", "()Z", "", "slots", "Ljava/util/List;", "b", "()Ljava/util/List;", "<init>", "(ZLjava/util/List;)V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.sqshow.utils.featureswitch.model.j, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ReloadAvatarDelaySlotConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("slotIds")
    private final List<String> slots;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/j$a;", "", "Lorg/json/JSONObject;", "Lcom/tencent/sqshow/utils/featureswitch/model/j;", DownloadInfo.spKey_Config, "", "a", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.utils.featureswitch.model.j$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(JSONObject jSONObject, ReloadAvatarDelaySlotConfig config) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            Intrinsics.checkNotNullParameter(config, "config");
            boolean z16 = false;
            if (config.getEnable() && !config.b().isEmpty()) {
                JSONObject optJSONObject = jSONObject.optJSONObject("avatar_info");
                JSONArray optJSONArray = optJSONObject != null ? optJSONObject.optJSONArray("slot_arr") : null;
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int length = optJSONArray.length() - 1; -1 < length; length--) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(length);
                        if (optJSONObject2 != null && optJSONObject2.has(MiniAppReportManager2.KEY_SLOT_ID)) {
                            if (config.b().contains(String.valueOf(optJSONObject2.optInt(MiniAppReportManager2.KEY_SLOT_ID)))) {
                                optJSONArray.remove(length);
                                z16 = true;
                            }
                        }
                    }
                }
            }
            return z16;
        }

        Companion() {
        }
    }

    public ReloadAvatarDelaySlotConfig() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> b() {
        return this.slots;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.enable;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.slots.hashCode();
    }

    public String toString() {
        return "ReloadAvatarDelaySlotConfig(enable=" + this.enable + ", slots=" + this.slots + ')';
    }

    public ReloadAvatarDelaySlotConfig(boolean z16, List<String> slots) {
        Intrinsics.checkNotNullParameter(slots, "slots");
        this.enable = z16;
        this.slots = slots;
    }

    public /* synthetic */ ReloadAvatarDelaySlotConfig(boolean z16, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReloadAvatarDelaySlotConfig)) {
            return false;
        }
        ReloadAvatarDelaySlotConfig reloadAvatarDelaySlotConfig = (ReloadAvatarDelaySlotConfig) other;
        return this.enable == reloadAvatarDelaySlotConfig.enable && Intrinsics.areEqual(this.slots, reloadAvatarDelaySlotConfig.slots);
    }
}
