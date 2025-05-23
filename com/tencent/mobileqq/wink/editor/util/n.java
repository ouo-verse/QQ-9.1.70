package com.tencent.mobileqq.wink.editor.util;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/n;", "", "", "currentLightVersion", "Ljava/util/concurrent/Callable;", "", "cleanAction", "", "a", "", "b", "version", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f322649a = new n();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\n\u001a\u00020\u0005H\u0016R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/util/n$a;", "", "", tl.h.F, "other", "", "c", "", "", "equals", "hashCode", "d", "Ljava/lang/String;", "version", "<init>", "(Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String version;

        public a(@NotNull String version) {
            List split$default;
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(version, "version");
            split$default = StringsKt__StringsKt.split$default((CharSequence) version, new String[]{"-"}, false, 0, 6, (Object) null);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) split$default);
            String str = (String) firstOrNull;
            str = str == null ? "" : str;
            if (new Regex("[0-9]+(\\.[0-9]+)*").matches(str)) {
                this.version = str;
                return;
            }
            throw new IllegalArgumentException("Invalid version format");
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull a other) {
            List split$default;
            List split$default2;
            int i3;
            int i16;
            Intrinsics.checkNotNullParameter(other, "other");
            split$default = StringsKt__StringsKt.split$default((CharSequence) getVersion(), new String[]{"."}, false, 0, 6, (Object) null);
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) other.getVersion(), new String[]{"."}, false, 0, 6, (Object) null);
            int max = Math.max(split$default.size(), split$default2.size());
            for (int i17 = 0; i17 < max; i17++) {
                if (i17 < split$default.size()) {
                    i3 = Integer.parseInt((String) split$default.get(i17));
                } else {
                    i3 = 0;
                }
                if (i17 < split$default2.size()) {
                    i16 = Integer.parseInt((String) split$default2.get(i17));
                } else {
                    i16 = 0;
                }
                if (i3 < i16) {
                    return -1;
                }
                if (i3 > i16) {
                    return 1;
                }
            }
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (other == null) {
                return false;
            }
            if (Intrinsics.areEqual(a.class, other.getClass()) && compareTo((a) other) == 0) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getVersion() {
            return this.version;
        }

        public int hashCode() {
            return this.version.hashCode();
        }
    }

    n() {
    }

    @JvmStatic
    public static final void a(@NotNull String currentLightVersion, @NotNull Callable<Boolean> cleanAction) {
        Intrinsics.checkNotNullParameter(currentLightVersion, "currentLightVersion");
        Intrinsics.checkNotNullParameter(cleanAction, "cleanAction");
        String maxVersionString = QzoneConfig.getWinkLightCacheConfigMax();
        String minVersionString = QzoneConfig.getWinkLightCacheConfigMin();
        int winkLightCacheConfigVersion = QzoneConfig.getWinkLightCacheConfigVersion();
        n nVar = f322649a;
        int b16 = nVar.b();
        w53.b.f("WinkLightCacheUtil", "LightCache max = " + maxVersionString + ", min = " + minVersionString + ", currentLightVersion = " + currentLightVersion + "cacheVersion = " + winkLightCacheConfigVersion + ", localLightCacheVersion = " + b16);
        try {
            Intrinsics.checkNotNullExpressionValue(maxVersionString, "maxVersionString");
            a aVar = new a(maxVersionString);
            Intrinsics.checkNotNullExpressionValue(minVersionString, "minVersionString");
            a aVar2 = new a(minVersionString);
            a aVar3 = new a(currentLightVersion);
            if (aVar3.compareTo(aVar2) >= 0 && aVar3.compareTo(aVar) <= 0 && b16 < winkLightCacheConfigVersion) {
                Boolean call = cleanAction.call();
                Intrinsics.checkNotNullExpressionValue(call, "cleanAction.call()");
                if (call.booleanValue()) {
                    nVar.c(winkLightCacheConfigVersion);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            w53.b.c("WinkLightCacheUtil", "checkNeedCleanLightCache, e = " + e16);
        }
    }

    private final int b() {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        return from.decodeInt("key_wink_light_cache_version", 0);
    }

    private final void c(int version) {
        MMKVOptionEntity from = QMMKV.from(BaseApplication.getContext(), QMMKVFile.FILE_QCIRCLE);
        Intrinsics.checkNotNullExpressionValue(from, "from(BaseApplication.get\u2026, QMMKVFile.FILE_QCIRCLE)");
        from.encodeInt("key_wink_light_cache_version", version).commitAsync();
    }
}
