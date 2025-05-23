package com.tencent.mobileqq.config.square;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/config/square/a;", "", "", "c", "", "d", "Lcom/tencent/mobileqq/config/square/SquareOnlineStatusBean;", DownloadInfo.spKey_Config, "f", "", "id", "Lcom/tencent/mobileqq/onlinestatus/au;", "b", "", "a", "e", "Lcom/tencent/mobileqq/config/square/SquareOnlineStatusBean;", "", "Ljava/lang/String;", "squareStatusTitlePrefix", "Z", "isLoaded", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f202944a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static SquareOnlineStatusBean config = new SquareOnlineStatusBean(null, 1, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String squareStatusTitlePrefix = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isLoaded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/config/square/a$a", "Lpy2/a;", "Lcom/tencent/mobileqq/config/square/SquareOnlineStatusBean;", DownloadInfo.spKey_Config, "", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.config.square.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7477a implements py2.a<SquareOnlineStatusBean> {
        C7477a() {
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable SquareOnlineStatusBean config) {
            if (config != null) {
                a.f202944a.f(config);
            }
        }
    }

    a() {
    }

    @NotNull
    public final List<au> a() {
        int collectionSizeOrDefault;
        List<SquareOnlineStatusItem> c16 = config.c();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (SquareOnlineStatusItem squareOnlineStatusItem : c16) {
            au auVar = new au(squareOnlineStatusItem.getId(), squareStatusTitlePrefix + squareOnlineStatusItem.getTitle(), squareOnlineStatusItem.getIcon(), squareOnlineStatusItem.getBigIcon());
            if (squareOnlineStatusItem.getShowInStudyMode() != null) {
                auVar.f255497j = squareOnlineStatusItem.getShowInStudyMode().booleanValue();
            }
            arrayList.add(auVar);
        }
        return arrayList;
    }

    @Nullable
    public final au b(long id5) {
        SquareOnlineStatusItem b16 = config.b(id5);
        if (b16 != null) {
            au auVar = new au(b16.getId(), squareStatusTitlePrefix + b16.getTitle(), b16.getIcon(), b16.getBigIcon());
            if (b16.getShowInStudyMode() != null) {
                auVar.f255497j = b16.getShowInStudyMode().booleanValue();
                return auVar;
            }
            return auVar;
        }
        return null;
    }

    public final void c() {
        String string = MobileQQ.sMobileQQ.getResources().getString(R.string.f228466tt);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.resources.getS\u2026i.R.string.status_square)");
        squareStatusTitlePrefix = string;
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("zplan_status_square_online_status_config", new C7477a());
    }

    public final boolean d() {
        return isLoaded;
    }

    public final boolean e(long id5) {
        return config.a(id5);
    }

    public final void f(@NotNull SquareOnlineStatusBean config2) {
        Intrinsics.checkNotNullParameter(config2, "config");
        isLoaded = true;
        config = config2;
    }
}
