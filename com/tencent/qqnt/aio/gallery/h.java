package com.tencent.qqnt.aio.gallery;

import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/h;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "mediaInfo", "Lkotlin/Pair;", "", "", "a", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "richMediaData", "", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f350002a = new h();

    h() {
    }

    public final Pair<Long, Integer> a(RFWLayerItemMediaInfo mediaInfo) {
        boolean contains$default;
        int i3;
        long parseLong;
        List split$default;
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        String mediaId = mediaInfo.getMediaId();
        Intrinsics.checkNotNull(mediaId);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) mediaId, (CharSequence) "_", false, 2, (Object) null);
        if (contains$default) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) mediaId, new String[]{"_"}, false, 0, 6, (Object) null);
            Object[] array = split$default.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            String[] strArr = (String[]) array;
            if (strArr.length != 2) {
                return null;
            }
            parseLong = Long.parseLong(strArr[0]);
            i3 = Integer.parseInt(strArr[1]);
        } else {
            i3 = 0;
            parseLong = Long.parseLong(mediaId);
        }
        return new Pair<>(Long.valueOf(parseLong), Integer.valueOf(i3));
    }

    public final String b(AIORichMediaData richMediaData) {
        return (richMediaData != null ? Long.valueOf(richMediaData.f179628d) : null) + "_" + (richMediaData != null ? Integer.valueOf(richMediaData.f179629e) : null);
    }
}
