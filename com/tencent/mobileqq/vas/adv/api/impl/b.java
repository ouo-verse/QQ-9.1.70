package com.tencent.mobileqq.vas.adv.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/api/impl/b;", "", "", "posId", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "posIdToSrcTypeMap", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f307952a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> posIdToSrcTypeMap;

    static {
        HashMap<String, Integer> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("7075765881355084", 10), TuplesKt.to("1082214467882419", 13), TuplesKt.to("5015318293089789", 13), TuplesKt.to("5075514213382984", 13), TuplesKt.to("7088010619062240", 68));
        posIdToSrcTypeMap = hashMapOf;
    }

    b() {
    }

    public static /* synthetic */ int b(b bVar, String str, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        return bVar.a(str, i3);
    }

    public final int a(@Nullable String posId, int busiType) {
        Integer num;
        if (busiType >= 0) {
            return busiType;
        }
        if (TextUtils.isEmpty(posId)) {
            return 15;
        }
        HashMap<String, Integer> hashMap = posIdToSrcTypeMap;
        if (!hashMap.containsKey(posId) || (num = hashMap.get(posId)) == null) {
            return 15;
        }
        return num.intValue();
    }
}
