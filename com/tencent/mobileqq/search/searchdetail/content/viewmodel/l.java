package com.tencent.mobileqq.search.searchdetail.content.viewmodel;

import com.tencent.ecommerce.base.location.IECLocationServiceProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0005\u001a\u00020\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u000b\u001a\u00020\u00068\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u001a\u0010\u0010\u001a\u00020\f8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u001a\u0010\u0015\u001a\u00020\u00118\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0019\u001a\u00020\u00168\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0001\u0010\u0018\"\u001a\u0010\u001e\u001a\u00020\u001a8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0007\u0010\u001d\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/f;", "a", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/f;", "e", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/f;", "emptyProvince", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/a;", "b", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/a;", "c", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/a;", "emptyCity", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/d;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/d;", "d", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/d;", "emptyDistrict", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/e;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/e;", "getEmptyPlaceInfo", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/e;", "emptyPlaceInfo", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/m;", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/m;", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/m;", "defaultSortRule", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/n;", "f", "Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/n;", "()Lcom/tencent/mobileqq/search/searchdetail/content/viewmodel/n;", "defaultTroopLabel", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Province f284353a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final City f284354b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final District f284355c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final e f284356d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final SortRule f284357e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final TroopLabel f284358f;

    static {
        List emptyList;
        List emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        f284353a = new Province(IECLocationServiceProxy.ALL_REGION, emptyList, 0, 4, null);
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        f284354b = new City("", emptyList2, 0, 4, null);
        f284355c = new District("", 0, 2, null);
        f284356d = new e(null, null, null, 7, null);
        f284357e = new SortRule("\u667a\u80fd\u6392\u5e8f", 1);
        f284358f = new TroopLabel("\u4eba\u6570\u4e0d\u9650", "1");
    }

    @NotNull
    public static final SortRule a() {
        return f284357e;
    }

    @NotNull
    public static final TroopLabel b() {
        return f284358f;
    }

    @NotNull
    public static final City c() {
        return f284354b;
    }

    @NotNull
    public static final District d() {
        return f284355c;
    }

    @NotNull
    public static final Province e() {
        return f284353a;
    }
}
