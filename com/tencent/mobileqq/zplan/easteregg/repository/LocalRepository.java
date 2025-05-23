package com.tencent.mobileqq.zplan.easteregg.repository;

import com.tencent.mobileqq.zplan.avatar.image.easterEgg.ZPlanAvatarEasterEggPortraitCacheManager;
import com.tencent.mobileqq.zplan.easteregg.PortraitSource;
import com.tencent.mobileqq.zplan.easteregg.model.PortraitQueryType;
import com.tencent.mobileqq.zplan.easteregg.model.d;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ResultCode;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R/\u0010\u0011\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/repository/LocalRepository;", "", "", "appearanceKey", "Lkotlin/Pair;", "", "b", "Lcom/tencent/mobileqq/zplan/easteregg/model/d;", "param", "Lhh3/a;", "listener", "", "c", "", "a", "Lkotlin/Lazy;", "()Ljava/util/List;", "errorAppearanceInfo", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LocalRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy errorAppearanceInfo;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f333031a;

        static {
            int[] iArr = new int[PortraitQueryType.values().length];
            try {
                iArr[PortraitQueryType.BATCH_QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PortraitQueryType.SINGLE_QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f333031a = iArr;
        }
    }

    public LocalRepository() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<Pair<? extends String, ? extends Long>>>() { // from class: com.tencent.mobileqq.zplan.easteregg.repository.LocalRepository$errorAppearanceInfo$2
            @Override // kotlin.jvm.functions.Function0
            public final List<Pair<? extends String, ? extends Long>> invoke() {
                return bb.f335811a.f();
            }
        });
        this.errorAppearanceInfo = lazy;
    }

    private final List<Pair<String, Long>> a() {
        return (List) this.errorAppearanceInfo.getValue();
    }

    private final Pair<String, Long> b(String appearanceKey) {
        List<Pair<String, Long>> a16 = a();
        List<Pair<String, Long>> list = a16;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (Pair<String, Long> pair : a16) {
            if (Intrinsics.areEqual(pair.getFirst(), appearanceKey)) {
                return pair;
            }
        }
        return null;
    }

    public void c(d param, hh3.a listener) {
        List<Integer> e16;
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String appearanceKey = param.getAppearanceKey();
        if (appearanceKey.length() == 0) {
            QLog.e("[EasterEggResource]LocalRepository", 1, "queryPortrait failed, appearanceKey invalid, param: " + param);
            listener.a(PortraitSource.LOCAL, "queryPortrait failed, appearanceKey invalid");
            return;
        }
        int i3 = b.f333031a[param.getType().ordinal()];
        if (i3 == 1) {
            e16 = param.e();
        } else if (i3 == 2) {
            Integer id5 = param.getId();
            e16 = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(id5 != null ? id5.intValue() : -1));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        List<Integer> list = e16;
        Pair<String, Long> b16 = b(appearanceKey);
        if (b16 != null) {
            QLog.i("[EasterEggResource]LocalRepository", 1, "invalid appearance, key: " + appearanceKey);
            listener.b(new ResultData(ResultCode.FAIL, list, null, PortraitSource.LOCAL, null, b16, 20, null));
            return;
        }
        List<String> j3 = ZPlanAvatarEasterEggPortraitCacheManager.f331820a.j(appearanceKey, list);
        List<String> list2 = j3;
        if (list2 == null || list2.isEmpty()) {
            QLog.i("[EasterEggResource]LocalRepository", 1, "local portrait query failed, try remote query.");
            listener.b(null);
        } else {
            listener.b(new ResultData(ResultCode.SUCCESS, list, j3, PortraitSource.LOCAL, null, null, 48, null));
        }
    }
}
