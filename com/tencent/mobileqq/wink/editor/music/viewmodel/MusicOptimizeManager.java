package com.tencent.mobileqq.wink.editor.music.viewmodel;

import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicOptimizeManager;", "", "", "d", "c", "a", "b", "Lkotlin/Lazy;", "()Z", "_isHitMusicApplyOptimize", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MusicOptimizeManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MusicOptimizeManager f321154a = new MusicOptimizeManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy _isHitMusicApplyOptimize;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.viewmodel.MusicOptimizeManager$_isHitMusicApplyOptimize$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(((IQCircle571ABTestApi) QRoute.api(IQCircle571ABTestApi.class)).isExperiment("exp_qqvideo_music_apply_optimize_new") || ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("xsp_xsj_dangshipinyoubgmbuzidongpeiyue") || ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_optimize_auto_music_2") || ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_local_bgm_check_new_2"));
                w53.b.f("MusicOptimizeManager", "isHitMusicApplyOptimize=" + valueOf.booleanValue());
                return valueOf;
            }
        });
        _isHitMusicApplyOptimize = lazy;
    }

    MusicOptimizeManager() {
    }

    private final boolean b() {
        return ((Boolean) _isHitMusicApplyOptimize.getValue()).booleanValue();
    }

    public final boolean a() {
        return false;
    }

    public final boolean c() {
        if (b() && d()) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        WinkContext e16 = WinkContext.INSTANCE.e();
        if (e16 == null || !e16.u("QCIRCLE")) {
            return false;
        }
        return true;
    }
}
