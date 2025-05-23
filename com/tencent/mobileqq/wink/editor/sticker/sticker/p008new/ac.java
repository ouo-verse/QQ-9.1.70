package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u001a\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a\u001a\u0010\u000b\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\n\u001a\u00020\u0002H\u0000\u00a8\u0006\f"}, d2 = {"", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "", "position", "", "b", "a", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "e", "d", "index", "c", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ac {
    @Nullable
    public static final MetaCategory a(@NotNull List<MetaCategory> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int i16 = 0;
        for (MetaCategory metaCategory : list) {
            i16 += metaCategory.materials.size();
            if (i3 < i16) {
                return metaCategory;
            }
        }
        return null;
    }

    @Nullable
    public static final String b(@NotNull List<MetaCategory> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        MetaCategory a16 = a(list, i3);
        if (a16 != null) {
            return a16.f30532id;
        }
        return null;
    }

    public static final int c(@NotNull List<MetaCategory> list, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "<this>");
        int i16 = 0;
        if (i3 >= 0 && i3 < list.size()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return -1;
        }
        if (i3 == 0) {
            return 0;
        }
        Iterator<T> it = list.subList(0, i3).iterator();
        while (it.hasNext()) {
            i16 += ((MetaCategory) it.next()).materials.size();
        }
        return i16;
    }

    public static final int d(@NotNull List<MetaCategory> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<MetaCategory> it = list.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            int size = it.next().materials.size();
            i16 += size;
            if (i3 < i16) {
                return size - (i16 - i3);
            }
        }
        return -1;
    }

    @Nullable
    public static final MetaMaterial e(@NotNull List<MetaCategory> list, int i3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        int i16 = 0;
        for (MetaCategory metaCategory : list) {
            int size = metaCategory.materials.size();
            i16 += size;
            if (i3 < i16) {
                return metaCategory.materials.get(size - (i16 - i3));
            }
        }
        return null;
    }
}
