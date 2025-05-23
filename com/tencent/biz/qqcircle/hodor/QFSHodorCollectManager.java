package com.tencent.biz.qqcircle.hodor;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002R\u001b\u0010\r\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/hodor/QFSHodorCollectManager;", "", "", "biz", "", "a", "c", "trackInfo", "b", "", "Lkotlin/Lazy;", "getFeatEnable", "()Z", "featEnable", "", "Ljava/util/List;", "unCollectEndBizList", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSHodorCollectManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QFSHodorCollectManager f84689a = new QFSHodorCollectManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy featEnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> unCollectEndBizList;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager$featEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_hodor_collect", true));
            }
        });
        featEnable = lazy;
        unCollectEndBizList = new ArrayList();
    }

    QFSHodorCollectManager() {
    }

    public final void a(@NotNull String biz) {
        Intrinsics.checkNotNullParameter(biz, "biz");
    }

    public final void b(@NotNull String trackInfo) {
        Intrinsics.checkNotNullParameter(trackInfo, "trackInfo");
    }

    public final void c(@NotNull String biz) {
        Intrinsics.checkNotNullParameter(biz, "biz");
    }
}
