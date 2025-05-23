package com.tencent.mobileqq.config.business.qflutter;

import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey;", "", "", "desc", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "ExpandPluginPreload", "ExpandPluginPreInstall", "ExpandPluginPreDownload", "QFlutterEngine", "Unknown", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public enum ExpandModuleKey {
    ExpandPluginPreload("ExpandPluginPreload"),
    ExpandPluginPreInstall("ExpandPluginPreInstall"),
    ExpandPluginPreDownload("ExpandPluginPreDownload"),
    QFlutterEngine("QFlutterEngine"),
    Unknown("Unknown");


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String desc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey$a;", "", "", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey;", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.business.qflutter.ExpandModuleKey$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExpandModuleKey a(@NotNull String engine) {
            Object firstOrNull;
            boolean equals;
            Intrinsics.checkNotNullParameter(engine, "engine");
            ExpandModuleKey[] values = ExpandModuleKey.values();
            ArrayList arrayList = new ArrayList();
            for (ExpandModuleKey expandModuleKey : values) {
                equals = StringsKt__StringsJVMKt.equals(expandModuleKey.getDesc(), engine, true);
                if (equals) {
                    arrayList.add(expandModuleKey);
                }
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            ExpandModuleKey expandModuleKey2 = (ExpandModuleKey) firstOrNull;
            if (expandModuleKey2 == null) {
                return ExpandModuleKey.Unknown;
            }
            return expandModuleKey2;
        }

        Companion() {
        }
    }

    ExpandModuleKey(String str) {
        this.desc = str;
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }
}
