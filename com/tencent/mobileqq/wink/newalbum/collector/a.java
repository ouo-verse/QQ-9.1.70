package com.tencent.mobileqq.wink.newalbum.collector;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/a;", "Ljava/util/Comparator;", "Lcom/tencent/mobileqq/wink/newalbum/collector/b;", "Lkotlin/Comparator;", "o1", "o2", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements Comparator<WinkNewAlbumCollectorConfigInfo> {
    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@Nullable WinkNewAlbumCollectorConfigInfo o16, @Nullable WinkNewAlbumCollectorConfigInfo o26) {
        if (o16 != null && o26 != null) {
            return Intrinsics.compare(o16.getPriorityIndex(), o26.getPriorityIndex());
        }
        if (o16 != null) {
            return -1;
        }
        if (o26 != null) {
            return 1;
        }
        return 0;
    }
}
