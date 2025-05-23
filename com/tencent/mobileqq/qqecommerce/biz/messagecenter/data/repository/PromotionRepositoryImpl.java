package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.repository;

import ag2.c;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import xf2.a;
import xf2.b;
import zf2.PromotionPanelItem;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0006B!\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R&\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00168\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0006\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/data/repository/PromotionRepositoryImpl;", "Lag2/c;", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lxf2/a;", "a", "Lxf2/a;", "localDataSource", "Lxf2/b;", "Lxf2/b;", "remoteDataSource", "Lkotlinx/coroutines/CoroutineDispatcher;", "c", "Lkotlinx/coroutines/CoroutineDispatcher;", "remoteOpContext", "Landroidx/lifecycle/MutableLiveData;", "", "Lzf2/d;", "d", "Landroidx/lifecycle/MutableLiveData;", "_promotionItems", "Landroidx/lifecycle/LiveData;", "e", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "promotionItems", "<init>", "(Lxf2/a;Lxf2/b;Lkotlinx/coroutines/CoroutineDispatcher;)V", "f", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PromotionRepositoryImpl implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a localDataSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final b remoteDataSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher remoteOpContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<PromotionPanelItem>> _promotionItems;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<PromotionPanelItem>> promotionItems;

    public PromotionRepositoryImpl(a localDataSource, b remoteDataSource, CoroutineDispatcher remoteOpContext) {
        Intrinsics.checkNotNullParameter(localDataSource, "localDataSource");
        Intrinsics.checkNotNullParameter(remoteDataSource, "remoteDataSource");
        Intrinsics.checkNotNullParameter(remoteOpContext, "remoteOpContext");
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.remoteOpContext = remoteOpContext;
        MutableLiveData<List<PromotionPanelItem>> mutableLiveData = new MutableLiveData<>();
        this._promotionItems = mutableLiveData;
        this.promotionItems = mutableLiveData;
    }

    @Override // ag2.c
    public LiveData<List<PromotionPanelItem>> a() {
        return this.promotionItems;
    }

    @Override // ag2.c
    public Object b(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ArrayList<PromotionPanelItem> a16 = this.localDataSource.a();
        if (!a16.isEmpty()) {
            booleanRef.element = true;
            this._promotionItems.postValue(a16);
            QLog.d("ECMsgCenter|PromotionRepositoryImpl", 2, "fetchPromotionList return local datas. size = " + a16.size());
        }
        Object withContext = BuildersKt.withContext(this.remoteOpContext, new PromotionRepositoryImpl$fetchPromotionList$2(this, a16, booleanRef, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return withContext == coroutine_suspended ? withContext : Unit.INSTANCE;
    }

    public /* synthetic */ PromotionRepositoryImpl(a aVar, b bVar, CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, bVar, (i3 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
