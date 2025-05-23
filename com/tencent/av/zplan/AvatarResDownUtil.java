package com.tencent.av.zplan;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J&\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/av/zplan/AvatarResDownUtil;", "", "", "isSelf", "", "uin", "Lcom/tencent/av/zplan/b;", "listener", "", "a", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "faceActionPath", "bodyActionPath", "Lcom/tencent/av/zplan/a;", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class AvatarResDownUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AvatarResDownUtil f77244a = new AvatarResDownUtil();

    AvatarResDownUtil() {
    }

    public final void a(boolean isSelf, @NotNull String uin, @NotNull b listener) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AvatarResDownUtil$requestAvatarRes$1(isSelf, uin, listener, null), 3, null);
    }

    public final void b(@NotNull EnumUserGender gender, @NotNull String faceActionPath, @NotNull String bodyActionPath, @NotNull a listener) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(faceActionPath, "faceActionPath");
        Intrinsics.checkNotNullParameter(bodyActionPath, "bodyActionPath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AvatarResDownUtil$requestZPlanAnimationRes$1(gender, faceActionPath, bodyActionPath, listener, null), 3, null);
    }
}
