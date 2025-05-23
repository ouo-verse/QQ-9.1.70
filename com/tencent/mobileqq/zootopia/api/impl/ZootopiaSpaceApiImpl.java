package com.tencent.mobileqq.zootopia.api.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi;
import com.tencent.mobileqq.zootopia.space.AllMapSpaceInfo;
import com.tencent.mobileqq.zootopia.space.MapOccupiedSpaceManager;
import com.tencent.mobileqq.zootopia.space.j;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0012j\b\u0012\u0004\u0012\u00020\u0006`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/impl/ZootopiaSpaceApiImpl;", "Lcom/tencent/mobileqq/zootopia/api/IZootopiaSpaceApi;", "Lcom/tencent/mobileqq/zootopia/space/a;", "allMapSpaceInfo", "", "onAllMapSpaceInfoUpdate", "Ltb3/a;", "l", "registerZootopiaSpaceOccupyListener", "unRegisterZootopiaSpaceOccupyListener", "calculateZootopiaSpaceOccupy", "Ltb3/b;", "setZootopiaTaskDeleteListener", "", "id", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "onTaskDelete", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "listenerPool", "Ljava/util/HashSet;", "mTaskDeleteListener", "Ltb3/b;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaSpaceApiImpl implements IZootopiaSpaceApi {
    private static final String TAG = "ZootopiaSpaceApiImpl_";
    private final HashSet<tb3.a> listenerPool = new HashSet<>();
    private tb3.b mTaskDeleteListener;

    public ZootopiaSpaceApiImpl() {
        LiveData<AllMapSpaceInfo> z16 = MapOccupiedSpaceManager.f329259b.z();
        final Function1<AllMapSpaceInfo, Unit> function1 = new Function1<AllMapSpaceInfo, Unit>() { // from class: com.tencent.mobileqq.zootopia.api.impl.ZootopiaSpaceApiImpl.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AllMapSpaceInfo allMapSpaceInfo) {
                invoke2(allMapSpaceInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AllMapSpaceInfo it) {
                ZootopiaSpaceApiImpl zootopiaSpaceApiImpl = ZootopiaSpaceApiImpl.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                zootopiaSpaceApiImpl.onAllMapSpaceInfoUpdate(it);
            }
        };
        z16.observeForever(new Observer() { // from class: com.tencent.mobileqq.zootopia.api.impl.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaSpaceApiImpl._init_$lambda$0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAllMapSpaceInfoUpdate(AllMapSpaceInfo allMapSpaceInfo) {
        QLog.i(TAG, 1, "onAllMapSpaceInfoUpdate allMapSpaceInfo:" + allMapSpaceInfo + " " + j.f329276a.e(allMapSpaceInfo.getTotalSize()) + " \n listenerPool:" + this.listenerPool);
        Iterator<T> it = this.listenerPool.iterator();
        while (it.hasNext()) {
            ((tb3.a) it.next()).totalOccupiedSpaceUpdate(allMapSpaceInfo.getTotalSize());
        }
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi
    public void calculateZootopiaSpaceOccupy() {
        MapOccupiedSpaceManager.f329259b.D();
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi
    public void onTaskDelete(String id5, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(source, "source");
        tb3.b bVar = this.mTaskDeleteListener;
        if (bVar != null) {
            bVar.a(id5, source);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi
    public void registerZootopiaSpaceOccupyListener(tb3.a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.listenerPool.add(l3);
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi
    public void setZootopiaTaskDeleteListener(tb3.b l3) {
        this.mTaskDeleteListener = l3;
    }

    @Override // com.tencent.mobileqq.zootopia.api.IZootopiaSpaceApi
    public void unRegisterZootopiaSpaceOccupyListener(tb3.a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.listenerPool.remove(l3);
    }
}
