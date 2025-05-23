package com.tencent.mobileqq.zplan.aigc.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanOutfitPublishHelper;", "", "", "resourcePath", "Lbv4/b;", "avatar", "Lbv4/c;", "detail", "Lbv4/e;", "outfit", "Lnk3/h;", "callback", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanOutfitPublishHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanOutfitPublishHelper f330231a = new ZPlanOutfitPublishHelper();

    ZPlanOutfitPublishHelper() {
    }

    public final void a(String resourcePath, bv4.b avatar, bv4.c detail, bv4.e outfit, nk3.h callback) {
        Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(outfit, "outfit");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ZPlanOutfitPublishHelper$triggerPublish$1(avatar, detail, outfit, callback, null), 3, null);
    }
}
