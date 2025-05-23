package com.tencent.mobileqq.wink.editor.hdr;

import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.videocut.model.HDRModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\u0018\u0000 \u00132\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019JB\u0010\u0007\u001a>\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u00050\u0002j\u001e\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u0003\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00050\u0005`\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\u000e\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ\u0016\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\nR0\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRCacheManager;", "", "Ljava/util/LinkedHashMap;", "", "kotlin.jvm.PlatformType", "Lcom/tencent/videocut/model/HDRModel;", "Lkotlin/collections/LinkedHashMap;", "c", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "winkEditData", "", "e", "", "hdrModel", tl.h.F, "originPath", "hdrPath", "g", "f", "b", "i", "a", "Ljava/util/LinkedHashMap;", "cachedHDRResult", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkHDRCacheManager {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<WinkHDRCacheManager> f320443c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, HDRModel> cachedHDRResult = new LinkedHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRCacheManager$a;", "", "Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRCacheManager;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRCacheManager;", "sInstance", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.hdr.WinkHDRCacheManager$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final WinkHDRCacheManager b() {
            return (WinkHDRCacheManager) WinkHDRCacheManager.f320443c.getValue();
        }

        @JvmStatic
        @NotNull
        public final WinkHDRCacheManager a() {
            return b();
        }

        Companion() {
        }
    }

    static {
        Lazy<WinkHDRCacheManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<WinkHDRCacheManager>() { // from class: com.tencent.mobileqq.wink.editor.hdr.WinkHDRCacheManager$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkHDRCacheManager invoke() {
                return new WinkHDRCacheManager();
            }
        });
        f320443c = lazy;
    }

    @JvmStatic
    @NotNull
    public static final WinkHDRCacheManager d() {
        return INSTANCE.a();
    }

    @Nullable
    public final HDRModel b(@NotNull String originPath) {
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        HDRModel hDRModel = this.cachedHDRResult.get(originPath);
        if (hDRModel == null) {
            return null;
        }
        if (!com.tencent.videocut.utils.g.f384239a.h(hDRModel.hdrVideoPath)) {
            this.cachedHDRResult.remove(originPath);
            hDRModel = null;
        }
        if (hDRModel == null) {
            return null;
        }
        return hDRModel;
    }

    @NotNull
    public final LinkedHashMap<String, HDRModel> c() {
        return new LinkedHashMap<>(this.cachedHDRResult);
    }

    public final void e(@NotNull WinkEditData winkEditData) {
        List<HDRModel> list;
        Intrinsics.checkNotNullParameter(winkEditData, "winkEditData");
        list = CollectionsKt___CollectionsKt.toList(winkEditData.getMediaModel().hdrModels.values());
        h(list);
    }

    public final void f(@NotNull HDRModel hdrModel) {
        Intrinsics.checkNotNullParameter(hdrModel, "hdrModel");
        com.tencent.videocut.utils.g gVar = com.tencent.videocut.utils.g.f384239a;
        if (gVar.h(hdrModel.originVideoPath) && gVar.h(hdrModel.hdrVideoPath)) {
            this.cachedHDRResult.put(hdrModel.originVideoPath, hdrModel);
        }
    }

    public final void g(@NotNull String originPath, @NotNull String hdrPath) {
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        Intrinsics.checkNotNullParameter(hdrPath, "hdrPath");
        f(new HDRModel(originPath, hdrPath, null, 4, null));
    }

    public final void h(@NotNull List<HDRModel> hdrModel) {
        Intrinsics.checkNotNullParameter(hdrModel, "hdrModel");
        Iterator<T> it = hdrModel.iterator();
        while (it.hasNext()) {
            f((HDRModel) it.next());
        }
    }

    public final void i() {
        this.cachedHDRResult.clear();
    }
}
