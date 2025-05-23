package com.tencent.mobileqq.wink.editor;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\u001a\u001c\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\"(\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"(\u0010\u0012\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\"(\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00038F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u0019\u001a\u00020\u0007*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "", "key", "", "default", "b", "f", "", "value", "e", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)Z", "setShouldHideCategory", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Z)V", "shouldHideCategory", "a", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)Ljava/lang/String;", "setAesKey", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;Ljava/lang/String;)V", "aesKey", "c", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;)I", "setMaxShowItemCount", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;I)V", "maxShowItemCount", "d", "shareOriginImage", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull MetaCategory metaCategory) {
        Intrinsics.checkNotNullParameter(metaCategory, "<this>");
        return f(metaCategory, "aesKey");
    }

    private static final int b(MetaCategory metaCategory, String str, int i3) {
        Map<String, String> map = metaCategory.dynamicFields;
        if (map == null) {
            return i3;
        }
        String str2 = map.get(str);
        if (str2 == null) {
            return i3;
        }
        try {
            return Integer.parseInt(str2);
        } catch (Exception unused) {
            return i3;
        }
    }

    public static final int c(@NotNull MetaCategory metaCategory) {
        Intrinsics.checkNotNullParameter(metaCategory, "<this>");
        return b(metaCategory, "maxShowItemCount", 6);
    }

    public static final boolean d(@NotNull MetaCategory metaCategory) {
        Intrinsics.checkNotNullParameter(metaCategory, "<this>");
        if (b(metaCategory, "shareOriginImage", 1) == 1) {
            return true;
        }
        return false;
    }

    public static final boolean e(@NotNull MetaCategory metaCategory) {
        Intrinsics.checkNotNullParameter(metaCategory, "<this>");
        if (b(metaCategory, "shouldHideCategory", 0) != 1) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String f(@NotNull MetaCategory metaCategory, @NotNull String key) {
        String str;
        Intrinsics.checkNotNullParameter(metaCategory, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaCategory.dynamicFields;
        if (map == null || (str = map.get(key)) == null) {
            return "";
        }
        return str;
    }
}
