package com.tencent.mobileqq.album.ext;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001c\u0010\n\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0004\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0001\u001a\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r*\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0000\u001a\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007*\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lcom/tencent/mobileqq/album/ext/c;", "j", "Lcom/tencent/mobileqq/album/ext/a;", "callBack", "", "e", "", "list", "Lcom/tencent/mobileqq/album/ext/b;", "g", "Lcom/tencent/mobileqq/album/media/c;", "d", "", "c", "i", "album_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class WrapLocalMediaInfoKt {
    @NotNull
    public static final List<LocalMediaInfo> c(@NotNull List<c> list) {
        Sequence asSequence;
        Sequence map;
        List<LocalMediaInfo> mutableList;
        Intrinsics.checkNotNullParameter(list, "<this>");
        asSequence = CollectionsKt___CollectionsKt.asSequence(list);
        map = SequencesKt___SequencesKt.map(asSequence, WrapLocalMediaInfoKt$mutableList$1.INSTANCE);
        mutableList = SequencesKt___SequencesKt.toMutableList(map);
        return mutableList;
    }

    @NotNull
    public static final com.tencent.mobileqq.album.media.c d(@NotNull c cVar) {
        String b16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        if (cVar.a().getMMediaType() == 1) {
            b16 = null;
        } else {
            b16 = cVar.b();
        }
        return com.tencent.mobileqq.album.media.b.c(cVar.a(), null, b16, 1, null);
    }

    public static final void e(@NotNull final c cVar, @NotNull final a callBack) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (cVar.a().getMMediaType() == 1) {
            callBack.a(com.tencent.mobileqq.album.media.b.c(cVar.a(), null, null, 1, null));
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.album.ext.d
                @Override // java.lang.Runnable
                public final void run() {
                    WrapLocalMediaInfoKt.f(c.this, callBack);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this_toPickPhotoResult, a callBack) {
        Intrinsics.checkNotNullParameter(this_toPickPhotoResult, "$this_toPickPhotoResult");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        callBack.a(com.tencent.mobileqq.album.media.b.c(this_toPickPhotoResult.a(), null, this_toPickPhotoResult.b(), 1, null));
    }

    public static final void g(@NotNull final List<c> list, @NotNull final b callBack) {
        List<com.tencent.mobileqq.album.media.c> emptyList;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (list.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            callBack.a(emptyList);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.album.ext.e
                @Override // java.lang.Runnable
                public final void run() {
                    WrapLocalMediaInfoKt.h(list, callBack);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(List list, b callBack) {
        int collectionSizeOrDefault;
        com.tencent.mobileqq.album.media.c c16;
        Intrinsics.checkNotNullParameter(list, "$list");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        List<c> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (c cVar : list2) {
            if (cVar.a().getMMediaType() == 1) {
                c16 = com.tencent.mobileqq.album.media.b.c(cVar.a(), null, null, 1, null);
            } else {
                c16 = com.tencent.mobileqq.album.media.b.c(cVar.a(), null, cVar.b(), 1, null);
            }
            arrayList.add(c16);
        }
        callBack.a(arrayList);
    }

    @NotNull
    public static final List<com.tencent.mobileqq.album.media.c> i(@NotNull List<c> list) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<c> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(d((c) it.next()));
        }
        return arrayList;
    }

    @NotNull
    public static final c j(@NotNull LocalMediaInfo localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "<this>");
        return new c(localMediaInfo);
    }
}
