package com.tencent.filament.zplan.animation;

import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplan.engine.FilamentViewerV2;
import com.tencent.filament.zplanservice.download.ZPlanAvatarService;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J'\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\b\u0010\tJ+\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/filament/zplan/animation/FilamentAnimationHelper;", "", "", "Lcom/tencent/filament/zplan/animation/ZPlanAction;", "animations", "Lcom/tencent/filament/zplan/engine/FilamentViewerV2;", "viewerV2", "Lcom/tencent/filament/zplan/animation/b;", "c", "([Lcom/tencent/filament/zplan/animation/ZPlanAction;Lcom/tencent/filament/zplan/engine/FilamentViewerV2;)Lcom/tencent/filament/zplan/animation/b;", "Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;", "avatarService", "Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;", "gender", "", "actionId", "a", "(Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;Lcom/tencent/filament/zplan/avatar/model/EnumUserGender;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "facePath", "bodyPath", "b", "(Lcom/tencent/filament/zplanservice/download/ZPlanAvatarService;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class FilamentAnimationHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FilamentAnimationHelper f105573a = new FilamentAnimationHelper();

    FilamentAnimationHelper() {
    }

    @Nullable
    public final Object a(@NotNull ZPlanAvatarService zPlanAvatarService, @NotNull EnumUserGender enumUserGender, long j3, @NotNull Continuation<? super ZPlanAction> continuation) {
        return CoroutineScopeKt.coroutineScope(new FilamentAnimationHelper$fetchIdActionWithService$2(zPlanAvatarService, j3, enumUserGender, null), continuation);
    }

    @Nullable
    public final Object b(@NotNull ZPlanAvatarService zPlanAvatarService, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super ZPlanAction> continuation) {
        return CoroutineScopeKt.coroutineScope(new FilamentAnimationHelper$fetchPathActionWithService$2(str, zPlanAvatarService, str2, null), continuation);
    }

    @Nullable
    public final b c(@NotNull ZPlanAction[] animations, @Nullable FilamentViewerV2 viewerV2) {
        boolean z16;
        boolean z17;
        Object first;
        Object first2;
        Intrinsics.checkNotNullParameter(animations, "animations");
        if (viewerV2 == null) {
            return null;
        }
        b bVar = new b();
        a aVar = new a();
        a aVar2 = new a();
        for (ZPlanAction zPlanAction : animations) {
            FilamentAnimation[] loadAnimation$default = FilamentViewerV2.loadAnimation$default(viewerV2, zPlanAction.getFaceAnimationGltfPath(), null, 2, null);
            if (loadAnimation$default.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                first2 = ArraysKt___ArraysKt.first(loadAnimation$default);
                aVar.a((FilamentAnimation) first2);
            }
            FilamentAnimation[] loadAnimation$default2 = FilamentViewerV2.loadAnimation$default(viewerV2, zPlanAction.getBodyAnimationGltfPath(), null, 2, null);
            if (loadAnimation$default2.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                first = ArraysKt___ArraysKt.first(loadAnimation$default2);
                aVar2.a((FilamentAnimation) first);
            }
        }
        bVar.a(aVar);
        bVar.a(aVar2);
        return bVar;
    }
}
