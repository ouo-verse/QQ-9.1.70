package com.tencent.sqshow.zootopia.nativeui.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\rJ\u0006\u0010\u000f\u001a\u00020\u0005R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0003`\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\"\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00000\u00000\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/l;", "", "", "Luv4/az;", VideoTemplateParser.ITEM_LIST, "", "d", "([Luv4/az;)V", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/g;", "e", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "Landroidx/lifecycle/LiveData;", "c", "a", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mPool", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "Landroidx/lifecycle/MutableLiveData;", "mSelf", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, az> mPool = new HashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<l> mSelf = new MutableLiveData<>(this);

    public final void a() {
        this.mPool.clear();
    }

    public final az b(az item) {
        Intrinsics.checkNotNullParameter(item, "item");
        az azVar = this.mPool.get(r94.b.a(item));
        return azVar == null ? item : azVar;
    }

    public final LiveData<l> c() {
        return this.mSelf;
    }

    public final void d(az[] itemList) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        for (az azVar : itemList) {
            this.mPool.put(r94.b.a(azVar), azVar);
        }
        this.mSelf.postValue(this);
    }

    public final void e(List<com.tencent.sqshow.zootopia.nativeui.data.repo.g> itemList) {
        Intrinsics.checkNotNullParameter(itemList, "itemList");
        Iterator<T> it = itemList.iterator();
        while (it.hasNext()) {
            bk storeTypeItem = ((com.tencent.sqshow.zootopia.nativeui.data.repo.g) it.next()).getStoreTypeItem();
            az azVar = storeTypeItem != null ? storeTypeItem.f440366b : null;
            if (azVar != null) {
                Intrinsics.checkNotNullExpressionValue(azVar, "it.storeTypeItem?.storeItem ?: return@forEach");
                this.mPool.put(r94.b.a(azVar), azVar);
            }
        }
        this.mSelf.postValue(this);
    }
}
