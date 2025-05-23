package com.tencent.state.square.cache;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.data.FilamentAvatarCoverUri;
import com.tencent.zplan.common.utils.d;
import java.io.File;
import java.io.FileFilter;
import java.io.InputStream;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt__FileTreeWalkKt;
import kotlin.io.FilesKt__UtilsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001$B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0014H\u0014J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0006H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/square/cache/DiskLruCache;", "Lcom/nostra13/universalimageloader/cache/disc/impl/BaseDiskCache;", "Lcom/tencent/state/square/cache/IDiskCache;", "rootDir", "Ljava/io/File;", "maxSize", "", "reserveCacheDir", "(Ljava/io/File;ILjava/io/File;)V", "map", "Lcom/tencent/state/square/cache/SafelyCacheMap;", "add", "", "file", "addDirectory", "", "addFile", "build", "buildDir", "dirName", "", "entryRemoved", "evicted", "oldValue", "getFile", "imageUri", "remove", "save", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "imageStream", "Ljava/io/InputStream;", "listener", "Lcom/nostra13/universalimageloader/utils/IoUtils$CopyListener;", "trimToSize", "size", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DiskLruCache extends BaseDiskCache implements IDiskCache {
    private static final String TAG = "DiskLruCache";
    private final SafelyCacheMap map;
    private final int maxSize;
    private final File reserveCacheDir;
    private final File rootDir;

    public /* synthetic */ DiskLruCache(File file, int i3, File file2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, i3, (i16 & 4) != 0 ? null : file2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean addDirectory(File file) {
        boolean startsWith$default;
        if (file != null && file.isDirectory()) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            String absolutePath2 = this.rootDir.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "rootDir.absolutePath");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(absolutePath, absolutePath2, false, 2, null);
            if (startsWith$default) {
                this.map.add(file);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean addFile(File file) {
        boolean startsWith$default;
        if (file != null && file.isFile()) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
            String absolutePath2 = this.rootDir.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "rootDir.absolutePath");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(absolutePath, absolutePath2, false, 2, null);
            if (startsWith$default) {
                this.map.add(file);
                return true;
            }
        }
        return false;
    }

    private final void entryRemoved(boolean evicted, final File oldValue) {
        if (evicted) {
            SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.cache.DiskLruCache$entryRemoved$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    if (oldValue.isDirectory()) {
                        FilesKt__UtilsKt.deleteRecursively(oldValue);
                    }
                    if (oldValue.isFile()) {
                        oldValue.delete();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trimToSize(int size) {
        int coerceAtLeast;
        File removeFirstOrNull;
        SquareBaseKt.getSquareLog().i(TAG, "trimToSize: size=" + size);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(size, 0);
        while (this.map.size() > coerceAtLeast && (removeFirstOrNull = this.map.removeFirstOrNull()) != null) {
            entryRemoved(true, removeFirstOrNull);
        }
    }

    @Override // com.tencent.state.square.cache.IDiskCache
    public void add(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (addFile(file)) {
            int size = this.map.size();
            int i3 = this.maxSize;
            if (size > i3) {
                trimToSize(i3);
            }
        }
    }

    @Override // com.tencent.state.square.cache.IDiskCache
    public void build() {
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.cache.DiskLruCache$build$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                File file;
                FileTreeWalk walkTopDown;
                int i3;
                file = DiskLruCache.this.rootDir;
                walkTopDown = FilesKt__FileTreeWalkKt.walkTopDown(file);
                Iterator<File> it = walkTopDown.iterator();
                while (it.hasNext()) {
                    DiskLruCache.this.addFile(it.next());
                }
                DiskLruCache diskLruCache = DiskLruCache.this;
                i3 = diskLruCache.maxSize;
                diskLruCache.trimToSize(i3);
            }
        });
    }

    @Override // com.tencent.state.square.cache.IDiskCache
    public void buildDir(@Nullable final String dirName) {
        SquareBaseKt.getSquareThread().postOnFileThread(new Function0<Unit>() { // from class: com.tencent.state.square.cache.DiskLruCache$buildDir$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0018  */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                boolean z16;
                File file;
                File file2;
                File[] listFiles;
                int i3;
                boolean isBlank;
                String str = dirName;
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank) {
                        z16 = false;
                        if (!z16) {
                            file = DiskLruCache.this.rootDir;
                        } else {
                            file2 = DiskLruCache.this.rootDir;
                            file = new File(file2, dirName);
                        }
                        listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.state.square.cache.DiskLruCache$buildDir$1.1
                            @Override // java.io.FileFilter
                            public final boolean accept(File file3) {
                                Intrinsics.checkNotNullExpressionValue(file3, "file");
                                return file3.isDirectory();
                            }
                        });
                        if (listFiles != null) {
                            for (File file3 : listFiles) {
                                DiskLruCache.this.addDirectory(file3);
                            }
                        }
                        DiskLruCache diskLruCache = DiskLruCache.this;
                        i3 = diskLruCache.maxSize;
                        diskLruCache.trimToSize(i3);
                    }
                }
                z16 = true;
                if (!z16) {
                }
                listFiles = file.listFiles(new FileFilter() { // from class: com.tencent.state.square.cache.DiskLruCache$buildDir$1.1
                    @Override // java.io.FileFilter
                    public final boolean accept(File file32) {
                        Intrinsics.checkNotNullExpressionValue(file32, "file");
                        return file32.isDirectory();
                    }
                });
                if (listFiles != null) {
                }
                DiskLruCache diskLruCache2 = DiskLruCache.this;
                i3 = diskLruCache2.maxSize;
                diskLruCache2.trimToSize(i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache
    @NotNull
    public File getFile(@NotNull String imageUri) {
        File file;
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        FilamentAvatarCoverUri decode = FilamentAvatarCoverUri.INSTANCE.decode(imageUri);
        if (decode != null) {
            if (decode.isRemoteCorrect()) {
                imageUri = decode.getRemoteUrl();
            } else {
                if (decode.isLocalCacheExists()) {
                    return decode.getLocalCacheFile();
                }
                imageUri = decode.getRemoteUrl();
            }
        }
        String str = d.c(imageUri) + ".png";
        File file2 = this.cacheDir;
        if (!file2.exists() && !this.cacheDir.mkdirs() && (file = this.reserveCacheDir) != null && (file.exists() || this.reserveCacheDir.mkdirs())) {
            file2 = this.reserveCacheDir;
        }
        return new File(file2, str);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache, com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean remove(@NotNull String imageUri) {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        FilamentAvatarCoverUri decode = FilamentAvatarCoverUri.INSTANCE.decode(imageUri);
        if (decode != null) {
            return super.remove(decode.getRemoteUrl());
        }
        return super.remove(imageUri);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache, com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(@NotNull String imageUri, @Nullable InputStream imageStream, @Nullable IoUtils.CopyListener listener) {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        FilamentAvatarCoverUri decode = FilamentAvatarCoverUri.INSTANCE.decode(imageUri);
        if (decode != null) {
            return super.save(decode.getRemoteUrl(), imageStream, listener);
        }
        return super.save(imageUri, imageStream, listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache(@NotNull File rootDir, int i3, @Nullable File file) {
        super(rootDir, file);
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        this.rootDir = rootDir;
        this.maxSize = i3;
        this.reserveCacheDir = file;
        this.map = new SafelyCacheMap();
    }

    @Override // com.nostra13.universalimageloader.cache.disc.impl.BaseDiskCache, com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(@NotNull String imageUri, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageUri, "imageUri");
        FilamentAvatarCoverUri decode = FilamentAvatarCoverUri.INSTANCE.decode(imageUri);
        if (decode != null) {
            return super.save(decode.getRemoteUrl(), bitmap);
        }
        return super.save(imageUri, bitmap);
    }
}
