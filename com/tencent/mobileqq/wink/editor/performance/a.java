package com.tencent.mobileqq.wink.editor.performance;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import e93.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R$\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR$\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/performance/a;", "", "", "compressCount", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "medias", "", "d", "<set-?>", "b", "I", "a", "()I", "needCompressVideoCount", "c", "totalVideoCount", "totalImageCount", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f321445a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int needCompressVideoCount = -1;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int totalVideoCount = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int totalImageCount = -1;

    a() {
    }

    public final int a() {
        return needCompressVideoCount;
    }

    public final int b() {
        return totalImageCount;
    }

    public final int c() {
        return totalVideoCount;
    }

    public final void d(int compressCount, @NotNull List<? extends LocalMediaInfo> medias) {
        int i3;
        Intrinsics.checkNotNullParameter(medias, "medias");
        needCompressVideoCount = compressCount;
        List<? extends LocalMediaInfo> list = medias;
        boolean z16 = list instanceof Collection;
        int i16 = 0;
        if (z16 && list.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<T> it = list.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (i.I((LocalMediaInfo) it.next()) && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        totalVideoCount = i3;
        if (!z16 || !list.isEmpty()) {
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                if (i.G((LocalMediaInfo) it5.next()) && (i16 = i16 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        totalImageCount = i16;
    }
}
