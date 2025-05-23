package com.tencent.mobileqq.qwallet.hb.skin.local;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007J\u0014\u0010\u000e\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fJ?\u0010\u0014\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u000f\u001a\u00020\u00042!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n0\u0010R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/local/HbSkinLocalDataSource;", "", "", "skinId", "", "outerSkinId", "skinFrom", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "e", "skinData", "", "f", "", "skinDataList", "j", "version", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onSuccess", "g", "Lcom/tencent/mobileqq/qwallet/hb/skin/local/a;", "b", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/qwallet/hb/skin/local/a;", "skinDao", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinLocalDataSource {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final HbSkinLocalDataSource f277855a = new HbSkinLocalDataSource();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy skinDao;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.qwallet.hb.skin.local.HbSkinLocalDataSource$skinDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return HbSkinDatabase.INSTANCE.a().d();
            }
        });
        skinDao = lazy;
    }

    HbSkinLocalDataSource() {
    }

    private final a d() {
        return (a) skinDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(HbSkinData skinData) {
        Intrinsics.checkNotNullParameter(skinData, "$skinData");
        try {
            long c16 = f277855a.d().c(skinData);
            if (QLog.isDebugVersion()) {
                QLog.d("HbSkinLocalDataSource", 4, "[insert] rowId=" + c16 + ", skinData=" + skinData);
            }
        } catch (Exception e16) {
            QLog.e("HbSkinLocalDataSource", 1, "[insert] error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(List skinDataList, String version, Function1 onSuccess) {
        Intrinsics.checkNotNullParameter(skinDataList, "$skinDataList");
        Intrinsics.checkNotNullParameter(version, "$version");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        try {
            f277855a.d().d(skinDataList, version, NetConnInfoCenter.getServerTimeMillis(), onSuccess);
        } catch (Exception e16) {
            QLog.e("HbSkinLocalDataSource", 1, "[clearAndInsertAll] error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(List skinDataList) {
        Intrinsics.checkNotNullParameter(skinDataList, "$skinDataList");
        try {
            f277855a.d().insertAll(skinDataList);
            Unit unit = Unit.INSTANCE;
            if (QLog.isDebugVersion()) {
                QLog.d("HbSkinLocalDataSource", 4, "[insertAll] rowId=" + unit + ", skinDataSize=" + skinDataList.size());
            }
        } catch (Exception e16) {
            QLog.e("HbSkinLocalDataSource", 1, "[insertAll] error", e16);
        }
    }

    @Deprecated(message = "\u540c\u6b65\u62c9\u53d6\u6709ANR\u98ce\u9669\uff0c\u8c03\u7528\u8005\u9700\u5728\u5b50\u7ebf\u7a0b\u8c03\u7528")
    @Nullable
    public final HbSkinData e(int skinId, @NotNull String outerSkinId, int skinFrom) {
        Intrinsics.checkNotNullParameter(outerSkinId, "outerSkinId");
        try {
            if (QLog.isDebugVersion()) {
                QLog.d("HbSkinLocalDataSource", 4, "[getSkinData] skinId=" + skinId + ", outerSkinId=" + outerSkinId + ", skinFrom=" + skinFrom);
            }
            return d().e(skinId, outerSkinId, skinFrom);
        } catch (Exception e16) {
            QLog.e("HbSkinLocalDataSource", 1, "[getSkinData] error", e16);
            return null;
        }
    }

    public final void f(@NotNull final HbSkinData skinData) {
        Intrinsics.checkNotNullParameter(skinData, "skinData");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.skin.local.c
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinLocalDataSource.h(HbSkinData.this);
            }
        }, 32, null, false);
    }

    public final void g(@NotNull final List<HbSkinData> skinDataList, @NotNull final String version, @NotNull final Function1<? super String, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(skinDataList, "skinDataList");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.skin.local.e
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinLocalDataSource.i(skinDataList, version, onSuccess);
            }
        }, 32, null, false);
    }

    public final void j(@NotNull final List<HbSkinData> skinDataList) {
        Intrinsics.checkNotNullParameter(skinDataList, "skinDataList");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.skin.local.d
            @Override // java.lang.Runnable
            public final void run() {
                HbSkinLocalDataSource.k(skinDataList);
            }
        }, 32, null, false);
    }
}
