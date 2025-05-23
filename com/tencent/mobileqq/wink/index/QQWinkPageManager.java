package com.tencent.mobileqq.wink.index;

import android.content.Context;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import common.config.service.QzoneConfig;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0006\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\b\u0010\u0007R'\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/index/QQWinkPageManager;", "", "Landroid/content/Context;", "context", "", "b", "c", "()Z", "d", "", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "", "Lkotlin/Lazy;", "a", "()Ljava/util/Map;", "pageToElementId", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkPageManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQWinkPageManager f322925a = new QQWinkPageManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy pageToElementId;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<QQWinkPage, ? extends String>>() { // from class: com.tencent.mobileqq.wink.index.QQWinkPageManager$pageToElementId$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<QQWinkPage, ? extends String> invoke() {
                return WinkHomeReportHelper.f326257a.b();
            }
        });
        pageToElementId = lazy;
    }

    QQWinkPageManager() {
    }

    @NotNull
    public final Map<QQWinkPage, String> a() {
        return (Map) pageToElementId.getValue();
    }

    public final boolean b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z16 = true;
        if (!QzoneConfig.isShowWinkLiveEntrance()) {
            w53.b.f("qqBaseActivity", "[isLiveDisable] switch off");
            return true;
        }
        if (!com.tencent.qqlive.common.screen.a.d(context) && !com.tencent.qqlive.common.screen.a.g(context) && !com.tencent.qqlive.common.screen.a.h(context)) {
            z16 = false;
        }
        if (z16) {
            w53.b.f("qqBaseActivity", "[isLiveDisable] isPad");
        }
        return z16;
    }

    public final boolean c() {
        return QzoneConfig.forceCloseMagicStudio();
    }

    public final boolean d() {
        return !w83.b.f445025a.Q();
    }
}
