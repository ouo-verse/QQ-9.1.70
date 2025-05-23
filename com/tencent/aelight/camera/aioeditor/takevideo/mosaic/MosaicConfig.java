package com.tencent.aelight.camera.aioeditor.takevideo.mosaic;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aelight/camera/aioeditor/takevideo/mosaic/MosaicConfig;", "", "", "b", "Lkotlin/Lazy;", "a", "()Z", "getSIsMosaicIndividualize$annotations", "()V", "sIsMosaicIndividualize", "<init>", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class MosaicConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final MosaicConfig f68762a = new MosaicConfig();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy sIsMosaicIndividualize;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.mosaic.MosaicConfig$sIsMosaicIndividualize$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("9060_mosaic_117040763", true));
            }
        });
        sIsMosaicIndividualize = lazy;
    }

    MosaicConfig() {
    }

    public static final boolean a() {
        return ((Boolean) sIsMosaicIndividualize.getValue()).booleanValue();
    }
}
