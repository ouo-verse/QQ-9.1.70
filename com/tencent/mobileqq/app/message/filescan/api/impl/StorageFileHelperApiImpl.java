package com.tencent.mobileqq.app.message.filescan.api.impl;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.cleanup.CleanUpThoroughManager;
import com.tencent.mobileqq.app.message.cleanup.h;
import com.tencent.mobileqq.app.message.cleanup.i;
import com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi;
import com.tencent.mobileqq.app.message.filescan.c;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.filescan.e;
import com.tencent.mobileqq.app.message.messageclean.StorageCacheManager;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J0\u0010\u0015\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u00120\u0011j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u0012`\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016JH\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/app/message/filescan/api/impl/StorageFileHelperApiImpl;", "Lcom/tencent/mobileqq/app/message/filescan/api/IStorageFileHelperApi;", "", "path", "", "getDirSize", "", "deleteFilesInDirectory", "Lcom/tencent/mobileqq/app/message/filescan/c;", "callback", "getCacheSize", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "", "isOptimizeStorageUI", "scanCacheFile", "getWhiteListSize", "cleanUpThorough", "Ljava/util/ArrayList;", "", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Lkotlin/collections/ArrayList;", "getCleanUpThoroughBusinessPath", "isFileUnderPublicDir", "releaseCleanupManager", "size", "isFile", "isWhiteListFile", "isPublicFile", "name", "totalSize", "cantClearSize", "reportFileSizeInfo", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class StorageFileHelperApiImpl implements IStorageFileHelperApi {
    static IPatchRedirector $redirector_;

    public StorageFileHelperApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public void cleanUpThorough() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            i.f195956a.c();
        }
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            StorageCacheManager.f196111a.a();
        }
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public void deleteFilesInDirectory(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) path);
        } else {
            Intrinsics.checkNotNullParameter(path, "path");
            FileUtils.deleteFilesInDirectory(path);
        }
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public long getCacheSize(@Nullable c callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) callback)).longValue();
        }
        return StorageCacheManager.f196111a.b(callback);
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    @NotNull
    public ArrayList<Map.Entry<String, y>> getCleanUpThoroughBusinessPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        HashMap<String, y> b16 = CleanUpThoroughManager.INSTANCE.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, y> entry : b16.entrySet()) {
            if (!entry.getValue().getWhiteList().isEmpty()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((Map.Entry) it.next());
        }
        return new ArrayList<>(arrayList);
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public long getDirSize(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path)).longValue();
        }
        Intrinsics.checkNotNullParameter(path, "path");
        return e.f195993a.a(path);
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public long getWhiteListSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        return i.f195956a.b();
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public boolean isFileUnderPublicDir(@NotNull String path) {
        int collectionSizeOrDefault;
        boolean startsWith$default;
        int indexOf$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) path)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(path, "path");
        if (!new File(path).isFile()) {
            return false;
        }
        ArrayList<String> g16 = d.f195978a.g();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
        ArrayList<String> arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = g16.iterator();
        while (it.hasNext()) {
            arrayList.add(((String) it.next()) + '/');
        }
        for (String str : arrayList) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, str, false, 2, null);
            if (startsWith$default) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) path, "/", str.length(), false, 4, (Object) null);
                if (indexOf$default < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public void releaseCleanupManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            i.f195956a.d();
        }
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public void reportFileSizeInfo(@NotNull String path, long size, boolean isFile, boolean isWhiteListFile, boolean isPublicFile, @NotNull String name, long totalSize, long cantClearSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, path, Long.valueOf(size), Boolean.valueOf(isFile), Boolean.valueOf(isWhiteListFile), Boolean.valueOf(isPublicFile), name, Long.valueOf(totalSize), Long.valueOf(cantClearSize));
            return;
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(name, "name");
        h.f195951a.e(path, size, isFile, isWhiteListFile, isPublicFile, name, totalSize, cantClearSize);
    }

    @Override // com.tencent.mobileqq.app.message.filescan.api.IStorageFileHelperApi
    public long scanCacheFile(boolean isOptimizeStorageUI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, isOptimizeStorageUI)).longValue();
        }
        return i.f195956a.e(isOptimizeStorageUI);
    }
}
