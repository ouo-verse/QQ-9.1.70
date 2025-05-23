package com.tencent.mobileqq.util.privacy;

import android.text.TextUtils;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\nB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016J!\u0010\n\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor;", "Lcom/tencent/mobileqq/config/l;", "Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor$b;", "", "type", "Ljava/lang/Class;", "clazz", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "b", "([Lcom/tencent/mobileqq/config/ai;)Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor$b;", "newConf", "", "c", ImageTaskConst.FAIL_CODE, "onReqFailed", "migrateOldVersion", "a", "", "isNeedCompressed", "isNeedStoreLargeFile", "isAccountRelated", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class PackageInstallWhiteListConfigProcessor extends l<b> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor$a;", "", "", "key", "Lorg/json/JSONArray;", "a", "", "CONFIG_ID", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.util.privacy.PackageInstallWhiteListConfigProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final JSONArray a(@NotNull String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            Object x16 = am.s().x(776);
            Intrinsics.checkNotNullExpressionValue(x16, "getSingleton().loadConObj(CONFIG_ID)");
            return ((b) x16).a().get(key);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R>\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007`\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/util/privacy/PackageInstallWhiteListConfigProcessor$b;", "", "", "configText", "", "b", "Ljava/util/HashMap;", "Lorg/json/JSONArray;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "setWhiteListMap$QQCommon_release", "(Ljava/util/HashMap;)V", "whiteListMap", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private HashMap<String, JSONArray> whiteListMap = new HashMap<>();

        @NotNull
        public final HashMap<String, JSONArray> a() {
            return this.whiteListMap;
        }

        public final void b(@NotNull String configText) {
            Intrinsics.checkNotNullParameter(configText, "configText");
            QLog.d("PackageInstallWhiteListConfigProcessor", 1, configText);
            if (!TextUtils.isEmpty(configText)) {
                try {
                    JSONObject jSONObject = new JSONObject(configText);
                    Iterator keys = jSONObject.keys();
                    Intrinsics.checkNotNullExpressionValue(keys, "json.keys()");
                    while (keys.hasNext()) {
                        Object next = keys.next();
                        HashMap<String, JSONArray> hashMap = this.whiteListMap;
                        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                        String str = (String) next;
                        JSONArray optJSONArray = jSONObject.optJSONArray((String) next);
                        Intrinsics.checkNotNull(optJSONArray, "null cannot be cast to non-null type org.json.JSONArray");
                        hashMap.put(str, optJSONArray);
                    }
                } catch (Throwable th5) {
                    QLog.e("PackageInstallWhiteListConfigProcessor", 1, th5, new Object[0]);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b migrateOldOrDefaultContent(int type) {
        return new b();
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b onParsed(@Nullable ai[] confFiles) {
        boolean z16;
        QLog.d("PackageInstallWhiteListConfigProcessor", 1, "onParsed");
        b bVar = new b();
        if (confFiles != null) {
            if (confFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                String str = confFiles[0].f202268b;
                Intrinsics.checkNotNullExpressionValue(str, "confFiles[0].content");
                bVar.b(str);
            }
        }
        return bVar;
    }

    @Override // com.tencent.mobileqq.config.l
    @NotNull
    public Class<b> clazz() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isAccountRelated() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 776;
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onUpdate(@Nullable b newConf) {
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int failCode) {
    }
}
