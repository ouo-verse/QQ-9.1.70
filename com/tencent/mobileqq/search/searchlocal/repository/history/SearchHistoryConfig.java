package com.tencent.mobileqq.search.searchlocal.repository.history;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/searchlocal/repository/history/SearchHistoryConfig;", "", "", "c", "", "a", "b", "<init>", "()V", "IHistoryABType", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchHistoryConfig {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final SearchHistoryConfig f284826a = new SearchHistoryConfig();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/search/searchlocal/repository/history/SearchHistoryConfig$IHistoryABType;", "", "Companion", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes18.dex */
    public @interface IHistoryABType {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f284827a;
        public static final int DEFAULT_TYPE = 2;
        public static final int NEW_TYPE = 1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/search/searchlocal/repository/history/SearchHistoryConfig$IHistoryABType$a;", "", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.searchlocal.repository.history.SearchHistoryConfig$IHistoryABType$a, reason: from kotlin metadata */
        /* loaded from: classes18.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f284827a = new Companion();

            Companion() {
            }
        }
    }

    SearchHistoryConfig() {
    }

    private final int a() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_qqsearch_searchhistory");
        Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026QSEARCH_SEARCHHISTORY_ID)");
        if (expEntity.isExpHit("exp_qqsearch_searchhistory_A")) {
            expEntity.reportExpExposure();
            return 2;
        }
        if (!expEntity.isExpHit("exp_qqsearch_searchhistory_B")) {
            return 2;
        }
        expEntity.reportExpExposure();
        return 1;
    }

    private final boolean c() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101773", false);
    }

    public final boolean b() {
        boolean z16;
        if (a() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (c()) {
            return true;
        }
        return z16;
    }
}
