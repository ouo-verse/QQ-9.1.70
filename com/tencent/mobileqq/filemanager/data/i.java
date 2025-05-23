package com.tencent.mobileqq.filemanager.data;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0002\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "b", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class i {
    private static final FileManagerEntity a(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity.nFileType == 2) {
            String str = fileManagerEntity.fileName;
            Intrinsics.checkNotNullExpressionValue(str, "this.fileName");
            int k3 = c81.a.k(str);
            if (k3 != 2) {
                fileManagerEntity.nFileType = k3;
                QLog.d("FileManagerProxyExt", 1, "fix nFileType " + k3 + " fileName " + fileManagerEntity.fileName);
            }
        }
        return fileManagerEntity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final List<FileManagerEntity> b(@Nullable List<? extends FileManagerEntity> list) {
        boolean z16;
        int collectionSizeOrDefault;
        List<? extends FileManagerEntity> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return list;
        }
        List<? extends FileManagerEntity> list3 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(a((FileManagerEntity) it.next()));
        }
        return arrayList;
    }
}
