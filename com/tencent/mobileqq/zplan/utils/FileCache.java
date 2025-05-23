package com.tencent.mobileqq.zplan.utils;

import com.jakewharton.disklrucache.DiskLruCache;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/FileCache;", "", "", "a", "Ljava/lang/String;", QzoneZipCacheHelper.DIR, "", "b", "J", "maxSize", "Lcom/jakewharton/disklrucache/DiskLruCache;", "c", "Lkotlin/Lazy;", "getDiskLruCache", "()Lcom/jakewharton/disklrucache/DiskLruCache;", "diskLruCache", "<init>", "(Ljava/lang/String;J)V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FileCache {

    /* renamed from: d, reason: collision with root package name */
    private static final a f335721d = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String dir;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long maxSize;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy diskLruCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/FileCache$a;", "", "", "FILE_SUFFIX_INDEX", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public FileCache(String dir, long j3) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.dir = dir;
        this.maxSize = j3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DiskLruCache>() { // from class: com.tencent.mobileqq.zplan.utils.FileCache$diskLruCache$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DiskLruCache invoke() {
                String str;
                long j16;
                str = FileCache.this.dir;
                File file = new File(str);
                j16 = FileCache.this.maxSize;
                long j17 = 1024;
                return DiskLruCache.open(file, 1, 1, j16 * j17 * j17);
            }
        });
        this.diskLruCache = lazy;
    }
}
