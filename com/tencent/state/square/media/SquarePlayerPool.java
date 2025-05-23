package com.tencent.state.square.media;

import androidx.core.util.Pools;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/media/SquarePlayerPool;", "", "creator", "Lkotlin/Function0;", "Lcom/tencent/state/square/media/SquarePlayer;", "(Lkotlin/jvm/functions/Function0;)V", "createCount", "", "pool", "Landroidx/core/util/Pools$SimplePool;", "_acquire", "_release", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "acquire", "destroy", "recycle", "Companion", "square_media_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquarePlayerPool {
    private static final int MAX_SIZE = 30;
    private static final String TAG = "SquarePlayerPool";
    private int createCount;
    private final Function0<SquarePlayer> creator;
    private final Pools.SimplePool<SquarePlayer> pool;

    public SquarePlayerPool() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final SquarePlayer _acquire() {
        return this.pool.acquire();
    }

    private final void _release(SquarePlayer item) {
        try {
            this.pool.release(item);
        } catch (Throwable th5) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "release error: " + th5.getMessage(), null, 4, null);
        }
    }

    public final SquarePlayer acquire() {
        boolean any;
        SquarePlayer _acquire = _acquire();
        ArrayList arrayList = new ArrayList();
        while (_acquire != null && _acquire.isDestroying()) {
            arrayList.add(_acquire);
            _acquire = _acquire();
        }
        any = CollectionsKt___CollectionsKt.any(arrayList);
        if (any) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                _release((SquarePlayer) it.next());
            }
            SquareBaseKt.getSquareLog().i(TAG, "pool#" + hashCode() + " find destroying player count: " + arrayList.size());
        }
        if (_acquire != null) {
            return _acquire;
        }
        SquarePlayer invoke = this.creator.invoke();
        SquareLogger squareLog = SquareBaseKt.getSquareLog();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("pool#");
        sb5.append(hashCode());
        sb5.append(" player count: ");
        int i3 = this.createCount + 1;
        this.createCount = i3;
        sb5.append(i3);
        squareLog.i(TAG, sb5.toString());
        return invoke;
    }

    public final void destroy() {
        SquarePlayer _acquire = _acquire();
        while (_acquire != null) {
            _acquire.release();
            _acquire = _acquire();
        }
    }

    public final void recycle(SquarePlayer item) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.onSurfaceDestroyed(null);
        _release(item);
    }

    public SquarePlayerPool(Function0<SquarePlayer> creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.creator = creator;
        this.pool = new Pools.SimplePool<>(30);
    }

    public /* synthetic */ SquarePlayerPool(Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Function0<SquarePlayer>() { // from class: com.tencent.state.square.media.SquarePlayerPool.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SquarePlayer invoke() {
                return new SquarePlayer(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
            }
        } : function0);
    }
}
