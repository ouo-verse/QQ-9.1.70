package com.tencent.biz.pubaccount.recentcontact;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountMenuUnsubscribeDoubleCheckUseCase;
import com.tencent.mobileqq.qqshop.api.QQShopPublicAccountMenuUnsubscribeDoubleCheckUseCase;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/pubaccount/recentcontact/e;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "", "Lcom/tencent/biz/pubaccount/recentcontact/b;", "Ljava/util/List;", "mListenerList", "<init>", "()V", "b", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/PublicAccount/Inject_PublicAccountUnfollowClickMrg.yml", version = 2)
    private static final ArrayList<Class<b>> f79897c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<b> mListenerList;

    static {
        ArrayList<Class<b>> arrayList = new ArrayList<>();
        f79897c = arrayList;
        arrayList.add(a.class);
        arrayList.add(QCirclePublicAccountMenuUnsubscribeDoubleCheckUseCase.class);
        arrayList.add(QQShopPublicAccountMenuUnsubscribeDoubleCheckUseCase.class);
    }

    public e() {
        int collectionSizeOrDefault;
        Object first;
        ArrayList<Class<b>> arrayList = f79897c;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.biz.pubaccount.recentcontact.IPAUnfollowClickListener");
            arrayList2.add((b) newInstance);
        }
        this.mListenerList = arrayList2;
    }

    public final void a(RecentContactInfo item) {
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<b> it = this.mListenerList.iterator();
        while (it.hasNext()) {
            it.next().a(item);
        }
    }
}
