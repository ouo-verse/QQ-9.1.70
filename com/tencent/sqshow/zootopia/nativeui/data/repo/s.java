package com.tencent.sqshow.zootopia.nativeui.data.repo;

import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.ak;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R2\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\tj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/s;", "", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "Luv4/ak;", "data", "", "b", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mStoreAvatarDataCache", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f371156a = new s();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static HashMap<UEAvatarGender, ak> mStoreAvatarDataCache = new HashMap<>();

    s() {
    }

    public final ak a(UEAvatarGender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        return mStoreAvatarDataCache.get(gender);
    }

    public final void b(UEAvatarGender gender, ak data) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(data, "data");
        mStoreAvatarDataCache.put(gender, data);
    }
}
