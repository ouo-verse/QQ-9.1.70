package com.tencent.mobileqq.onlinestatus.view.zplan;

import android.content.Context;
import com.tencent.mobileqq.onlinestatus.model.AvatarStatusViewScene;
import com.tencent.mobileqq.onlinestatus.view.aj;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/zplan/h;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", "scene", "Lcom/tencent/mobileqq/onlinestatus/view/aj;", "a", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f256841a = new h();

    h() {
    }

    @NotNull
    public final aj a(@NotNull Context context, @NotNull AvatarStatusViewScene scene) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scene, "scene");
        return new AvatarStatusView(context, scene, AvatarStatusViewLoadStrategy.INSTANCE.a().b(scene));
    }
}
