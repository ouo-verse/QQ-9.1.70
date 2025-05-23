package com.tencent.mobileqq.vas.liangnum;

import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/liangnum/c;", "", "", "id", "Lcom/tencent/mobileqq/vas/updatesystem/business/QQVasUpdateBusiness;", "business", "", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f309987a = new c();

    c() {
    }

    public final boolean a(int id5, @NotNull QQVasUpdateBusiness<?> business) {
        Intrinsics.checkNotNullParameter(business, "business");
        return new File(business.getSavePath(id5) + "/point.png").exists();
    }
}
