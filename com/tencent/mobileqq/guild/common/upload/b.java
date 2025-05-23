package com.tencent.mobileqq.guild.common.upload;

import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.r;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/common/upload/b;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f215495a = new b();

    b() {
    }

    @JvmStatic
    @NotNull
    public static final HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("guid", r.a());
        String qImei36 = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getQImei36();
        Intrinsics.checkNotNullExpressionValue(qImei36, "api(IGuildFeatureAdapterApi::class.java).qImei36");
        hashMap.put("qimei36", qImei36);
        return hashMap;
    }
}
