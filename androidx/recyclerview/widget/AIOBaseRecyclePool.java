package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.cache.api.Business;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmDefault;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b \u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b\u00f8\u0001\u0000J\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0019\u0010\u0012\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001b"}, d2 = {"Landroidx/recyclerview/widget/AIOBaseRecyclePool;", "Lcom/tencent/cache/api/collection/b;", "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool$ScrapData;", "getScrapDataForType", "Lkotlin/Function0;", "", "invoker", "preLoadViewHolder", "output", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "scrap", "putRecycledView", "Landroidx/recyclerview/widget/IViewHolderDiscard;", "callback", "setViewHolderDiscardCallBack$sdk_debug", "(Landroidx/recyclerview/widget/IViewHolderDiscard;)V", "setViewHolderDiscardCallBack", "", WadlProxyConsts.PARAM_IS_PRELOAD, "Z", "discardCallBack", "Landroidx/recyclerview/widget/IViewHolderDiscard;", "<init>", "()V", "Companion", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class AIOBaseRecyclePool extends com.tencent.cache.api.collection.b {

    @NotNull
    private static final Companion Companion = new Companion(null);

    @Deprecated
    @NotNull
    public static final String SUB_BUSINESS_TAG = "AIORecycleViewPool";

    @Deprecated
    @NotNull
    public static final String TAG = "IAIORecyclePool";
    private IViewHolderDiscard discardCallBack;
    private boolean isPreLoad;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Landroidx/recyclerview/widget/AIOBaseRecyclePool$Companion;", "", "()V", "SUB_BUSINESS_TAG", "", "TAG", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes.dex */
    private static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AIOBaseRecyclePool() {
        super(Business.AIO, SUB_BUSINESS_TAG);
        setCacheListener(new com.tencent.cache.api.c() { // from class: androidx.recyclerview.widget.AIOBaseRecyclePool.1
            AnonymousClass1() {
            }

            @Override // com.tencent.cache.api.c
            public void onClearEnd() {
                com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
                Companion unused = AIOBaseRecyclePool.Companion;
                aVar.i(AIOBaseRecyclePool.TAG, "onClearEnd");
            }

            @Override // com.tencent.cache.api.c
            public void onClearStart() {
            }
        });
    }

    public static final /* synthetic */ boolean access$isPreLoad$p(AIOBaseRecyclePool aIOBaseRecyclePool) {
        return aIOBaseRecyclePool.isPreLoad;
    }

    public static final /* synthetic */ void access$setPreLoad$p(AIOBaseRecyclePool aIOBaseRecyclePool, boolean z16) {
        aIOBaseRecyclePool.isPreLoad = z16;
    }

    private final RecyclerView.RecycledViewPool.ScrapData getScrapDataForType(int viewType) {
        RecyclerView.RecycledViewPool.ScrapData scrapData = getScrap().get(viewType);
        if (scrapData == null) {
            RecyclerView.RecycledViewPool.ScrapData scrapData2 = new RecyclerView.RecycledViewPool.ScrapData();
            getScrap().put(viewType, scrapData2);
            return scrapData2;
        }
        return scrapData;
    }

    public final void output() {
        SparseArray<RecyclerView.RecycledViewPool.ScrapData> scrap = getScrap();
        Intrinsics.checkNotNullExpressionValue(scrap, "scrap");
        int size = scrap.size();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            int keyAt = scrap.keyAt(i17);
            RecyclerView.RecycledViewPool.ScrapData valueAt = scrap.valueAt(i17);
            i3 += valueAt.mScrapHeap.size();
            i16 += valueAt.mMaxScrap;
            com.tencent.aio.base.log.a.f69187b.e(TAG, "--------------" + keyAt + " scrap " + valueAt.mScrapHeap.size() + " maxSize " + valueAt.mMaxScrap + "----------------");
            ArrayList<RecyclerView.ViewHolder> arrayList = valueAt.mScrapHeap;
            Intrinsics.checkNotNullExpressionValue(arrayList, "value.mScrapHeap");
            for (RecyclerView.ViewHolder viewHolder : arrayList) {
                com.tencent.aio.base.log.a.f69187b.d(TAG, keyAt + " : value " + viewHolder.itemView);
            }
        }
        com.tencent.aio.base.log.a.f69187b.e(TAG, "complete output totalSize " + i3 + "  totalMaxSize " + i16);
    }

    public final void preLoadViewHolder(@NotNull Function0<Unit> invoker) {
        Intrinsics.checkNotNullParameter(invoker, "invoker");
        if (this.isPreLoad) {
            return;
        }
        invoker.invoke();
        this.isPreLoad = true;
    }

    @Override // com.tencent.cache.api.collection.b, androidx.recyclerview.widget.RecyclerView.RecycledViewPool
    public void putRecycledView(@NotNull RecyclerView.ViewHolder scrap) {
        IViewHolderDiscard iViewHolderDiscard;
        Intrinsics.checkNotNullParameter(scrap, "scrap");
        try {
            int itemViewType = scrap.getItemViewType();
            ArrayList<RecyclerView.ViewHolder> arrayList = getScrapDataForType(itemViewType).mScrapHeap;
            com.tencent.aio.base.log.b.a(com.tencent.aio.base.log.a.f69187b).d(TAG, "viewType " + itemViewType + "  mMaxScrap  " + getScrap().get(itemViewType).mMaxScrap + "  scrapHeap " + arrayList.size());
            if (getScrap().get(itemViewType).mMaxScrap <= arrayList.size() && (iViewHolderDiscard = this.discardCallBack) != null) {
                iViewHolderDiscard.onViewHolderDiscard(scrap);
            }
            super.putRecycledView(scrap);
        } catch (NullPointerException unused) {
            com.tencent.aio.base.log.a.f69187b.e(TAG, "putRecycledView error");
        }
    }

    @Override // com.tencent.cache.api.collection.b, com.tencent.cache.api.b
    @JvmDefault
    public /* bridge */ /* synthetic */ void register(@NotNull Business business, @NotNull String str) {
        com.tencent.cache.api.a.a(this, business, str);
    }

    public final void setViewHolderDiscardCallBack$sdk_debug(@Nullable IViewHolderDiscard callback) {
        this.discardCallBack = callback;
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"androidx/recyclerview/widget/AIOBaseRecyclePool$1", "Lcom/tencent/cache/api/c;", "", "onClearStart", "onClearEnd", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: androidx.recyclerview.widget.AIOBaseRecyclePool$1 */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 implements com.tencent.cache.api.c {
        AnonymousClass1() {
        }

        @Override // com.tencent.cache.api.c
        public void onClearEnd() {
            com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
            Companion unused = AIOBaseRecyclePool.Companion;
            aVar.i(AIOBaseRecyclePool.TAG, "onClearEnd");
        }

        @Override // com.tencent.cache.api.c
        public void onClearStart() {
        }
    }
}
