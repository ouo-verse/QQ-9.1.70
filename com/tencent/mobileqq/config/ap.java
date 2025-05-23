package com.tencent.mobileqq.config;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016R$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\b\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/config/ap;", "Lcom/tencent/freesia/IConfigData;", "", "", "c", "toString", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "canDeleteManageConf", "", "<set-?>", "e", "Z", "()Z", "enableClean", "<init>", "()V", "f", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ap implements IConfigData {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> canDeleteManageConf = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean enableClean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/config/ap$a;", "", "Lcom/tencent/mobileqq/config/ap;", "a", "", "content", "b", "CAN_DELETE_CONFIG_LIST", "Ljava/lang/String;", "CONFIG_NAME", "ENABLE_CLEAN", "TAG", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.ap$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ap a() {
            ap apVar = (ap) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("manage_clean_ids");
            return apVar == null ? new ap() : apVar;
        }

        public final ap b(String content) {
            ap apVar = new ap();
            if (content == null || content.length() == 0) {
                return apVar;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (jSONObject.has("can_clean_list")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("can_clean_list");
                    int length = jSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        apVar.canDeleteManageConf.add(jSONArray.optString(i3));
                    }
                    apVar.enableClean = jSONObject.optBoolean("enable_clean", false);
                }
            } catch (Throwable th5) {
                QLog.w("QManageCleanConfig", 1, "parseContent: " + content + " failed", th5);
            }
            QLog.i("QManageCleanConfig", 1, "getConfig: " + apVar);
            return apVar;
        }

        Companion() {
        }
    }

    public final Set<String> c() {
        Set<String> set;
        set = CollectionsKt___CollectionsKt.toSet(this.canDeleteManageConf);
        return set;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getEnableClean() {
        return this.enableClean;
    }

    public String toString() {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.canDeleteManageConf, ";", null, null, 0, null, null, 62, null);
        return "QManageCleanConfig: " + joinToString$default + ", enableClean: " + this.enableClean;
    }
}
