package com.tencent.mobileqq.zootopia.space;

import android.content.Context;
import com.tencent.mobileqq.zootopia.download.v;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/space/j;", "", "", "", "targetDirs", "", "b", "targetDir", "a", "size", "e", "mapId", "Landroid/content/Context;", "ctx", "d", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f329276a = new j();

    j() {
    }

    public final long a(String targetDir) {
        long length;
        Intrinsics.checkNotNullParameter(targetDir, "targetDir");
        File file = new File(targetDir);
        long j3 = 0;
        if (!file.exists()) {
            return 0L;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] list = file.listFiles();
        boolean z16 = true;
        if (list != null) {
            if (!(list.length == 0)) {
                z16 = false;
            }
        }
        if (z16) {
            return 0L;
        }
        Intrinsics.checkNotNullExpressionValue(list, "list");
        for (File file2 : list) {
            if (file2.isDirectory()) {
                String absolutePath = file2.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "subFile.absolutePath");
                length = a(absolutePath);
            } else {
                length = file2.length();
            }
            j3 += length;
        }
        return j3;
    }

    public final long b(List<String> targetDirs) {
        Intrinsics.checkNotNullParameter(targetDirs, "targetDirs");
        Iterator<String> it = targetDirs.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += a(it.next());
        }
        return j3;
    }

    public final List<String> c(String mapId, Context ctx) {
        String path;
        List<String> listOf;
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        File externalFilesDir = ctx.getExternalFilesDir(null);
        if (externalFilesDir == null || (path = externalFilesDir.getPath()) == null) {
            path = ctx.getFilesDir().getPath();
        }
        String str = File.separator;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{path + str + mapId, path + str + "ZplanModDownload" + str + mapId});
        return listOf;
    }

    public final List<String> d(String mapId, Context ctx) {
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String h16 = v.h(v.f328299a, mapId, false, 2, null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(h16);
        return arrayList;
    }

    public final String e(long size) {
        if (size <= 0) {
            return "0MB";
        }
        String a16 = t74.a.a(size);
        Intrinsics.checkNotNullExpressionValue(a16, "convertSizeToReadableDesc(size)");
        return a16;
    }
}
