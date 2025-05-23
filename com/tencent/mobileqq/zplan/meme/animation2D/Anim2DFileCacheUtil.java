package com.tencent.mobileqq.zplan.meme.animation2D;

import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.zplan.common.utils.FileCache;
import com.tencent.zplan.utils.ZPlanConstant;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001b\u0010\u0010\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/animation2D/Anim2DFileCacheUtil;", "", "", "d", "recordKey", "Ljava/io/File;", "a", "path", "key", "", "e", "c", "Lcom/tencent/zplan/common/utils/FileCache;", "b", "Lkotlin/Lazy;", "()Lcom/tencent/zplan/common/utils/FileCache;", "fileCache", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class Anim2DFileCacheUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Anim2DFileCacheUtil f333892a = new Anim2DFileCacheUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy fileCache;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FileCache>() { // from class: com.tencent.mobileqq.zplan.meme.animation2D.Anim2DFileCacheUtil$fileCache$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FileCache invoke() {
                return new FileCache(ZPlanConstant.f386195f.a(), ZPlanQQMC.INSTANCE.getEmoticonTabFileCacheSize());
            }
        });
        fileCache = lazy;
    }

    Anim2DFileCacheUtil() {
    }

    private final FileCache b() {
        return (FileCache) fileCache.getValue();
    }

    public final File a(String recordKey) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        return b().c(recordKey);
    }

    public final String c(String recordKey) {
        Intrinsics.checkNotNullParameter(recordKey, "recordKey");
        return ZPlanConstant.f386195f.a() + "/" + recordKey;
    }

    public final String d() {
        return ZPlanConstant.f386195f.a();
    }

    public final boolean e(String path, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return b().g(path, key);
    }
}
