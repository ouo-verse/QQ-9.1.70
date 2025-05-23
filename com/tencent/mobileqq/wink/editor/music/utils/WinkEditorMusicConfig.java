package com.tencent.mobileqq.wink.editor.music.utils;

import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u0006\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/utils/WinkEditorMusicConfig;", "", "", "a", "b", "Lkotlin/Lazy;", "isHitSingleVideoAutoMusicExp", "()Z", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorMusicConfig {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkEditorMusicConfig f321149a = new WinkEditorMusicConfig();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy isHitSingleVideoAutoMusicExp;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.utils.WinkEditorMusicConfig$isHitSingleVideoAutoMusicExp$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Boolean valueOf = Boolean.valueOf(((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).isExperiment("exp_xsj_upload_shoot_single_content_add_music"));
                QLog.d("WinkEditorMusicConfig", 1, "isHitSingleVideoAutoMusicExp = " + valueOf.booleanValue());
                return valueOf;
            }
        });
        isHitSingleVideoAutoMusicExp = lazy;
    }

    WinkEditorMusicConfig() {
    }

    public final boolean a() {
        WinkContext e16 = WinkContext.INSTANCE.e();
        if (e16 == null || !e16.u("QCIRCLE")) {
            return false;
        }
        return true;
    }
}
