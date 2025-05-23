package com.tencent.mobileqq.qmmkv.v2;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mmkv.MMKV;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0013\u00a2\u0006\u0004\b#\u0010$J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0014J(\u0010\u0019\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0003H\u0014J(\u0010\u001c\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0004R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qmmkv/v2/b;", "Lcom/tencent/mobileqq/qmmkv/v2/f;", "", "Lcom/tencent/mobileqq/qmmkv/v2/e;", "Lcom/tencent/mobileqq/qmmkv/v2/k;", "mmapId", "", "mode", "", "withAccount", "c", "boundToAccount", "e", "mmapKey", "a", "b", "d", "kv", "priority", "", "prioritySize", "v", "isTrimElseRemove", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", HippyTKDListViewAdapter.X, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "w", "Ljava/util/concurrent/ConcurrentHashMap;", "", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "locks", "maxSize", "<init>", "(J)V", "library_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public abstract class b extends f<String, e> implements k {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, Object> locks;

    public b(long j3) {
        super(j3);
        this.locks = new ConcurrentHashMap<>();
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.k
    public final boolean a(@NotNull String mmapId, @NotNull String mmapKey) {
        boolean z16;
        Object obj;
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        e k3 = k(mmapKey);
        boolean z17 = false;
        if (k3 == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(k3, "get(mmapKey) ?: return false");
        if (k3 instanceof c) {
            Object obj2 = this.locks.get(mmapId);
            if (obj2 == null) {
                synchronized (this.locks) {
                    obj = this.locks.get(mmapId);
                    if (obj == null) {
                        obj = new Object();
                        this.locks.put(mmapId, obj);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                obj2 = obj;
            }
            synchronized (obj2) {
                if (!((c) k3).getClosed()) {
                    z16 = ((c) k3).a();
                } else {
                    z16 = false;
                }
                Unit unit2 = Unit.INSTANCE;
            }
            if (!((c) k3).getClosed()) {
                x(mmapKey, k3);
            }
        } else {
            z16 = true;
        }
        if (z16) {
            if (r(mmapKey) != null) {
                z17 = true;
            }
            return z17;
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.k
    @NotNull
    public final e b(@NotNull String mmapId, @NotNull String mmapKey, int mode) {
        e k3;
        boolean z16;
        Object obj;
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        e k16 = k(mmapKey);
        if (k16 == null) {
            long currentTimeMillis = System.currentTimeMillis();
            Object obj2 = this.locks.get(mmapId);
            if (obj2 == null) {
                synchronized (this.locks) {
                    obj = this.locks.get(mmapId);
                    if (obj == null) {
                        obj = new Object();
                        this.locks.put(mmapId, obj);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                obj2 = obj;
            }
            synchronized (obj2) {
                k3 = k(mmapKey);
                if (k3 == null) {
                    MMKV a06 = MMKV.a0(mmapKey, mode);
                    Intrinsics.checkNotNullExpressionValue(a06, "MMKV.mmkvWithID(mmapKey, mode)");
                    k3 = new CloseableMMKV(mmapId, a06);
                    q(mmapKey, k3);
                    z16 = true;
                } else {
                    z16 = false;
                }
                Unit unit2 = Unit.INSTANCE;
            }
            QMMKV.logWarn("mmkvcache retrieveMMKV null, createNewOne:" + z16 + " cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms " + mmapKey + " = " + k3.hashCode());
            k16 = k3;
        }
        Intrinsics.checkNotNull(k16);
        return k16;
    }

    @Override // com.tencent.mobileqq.qmmkv.v2.j
    @NotNull
    public e c(@NotNull String mmapId, int mode, boolean withAccount) {
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        return b(mmapId, d(mmapId, withAccount), mode);
    }

    @NotNull
    public abstract String d(@NotNull String mmapId, boolean withAccount);

    @Override // com.tencent.mobileqq.qmmkv.v2.j
    public boolean e(@NotNull String mmapId, boolean boundToAccount) {
        Intrinsics.checkNotNullParameter(mmapId, "mmapId");
        return a(mmapId, d(mmapId, boundToAccount));
    }

    protected boolean v(@NotNull String mmapKey, @NotNull e kv5, int priority, long prioritySize) {
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qmmkv.v2.f
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final boolean f(@NotNull String mmapKey, @NotNull e item, int priority, long prioritySize) {
        boolean z16;
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        Intrinsics.checkNotNullParameter(item, "item");
        if (v(mmapKey, item, priority, prioritySize)) {
            if (item instanceof c) {
                z16 = ((c) item).a();
            } else {
                z16 = true;
            }
            if (!z16) {
                y(mmapKey, item, priority, prioritySize);
                return z16;
            }
            return z16;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(@NotNull String mmapKey, @NotNull e kv5) {
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        QMMKV.logError("mmkvcache evict failed cause of not closed. " + mmapKey + " = " + kv5.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(@NotNull String mmapKey, @NotNull e kv5, int priority, long prioritySize) {
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        QMMKV.logError("mmkvcache evict failed cause of not closed. " + mmapKey + " = " + kv5.hashCode() + " [" + priority + ", " + prioritySize + ']');
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qmmkv.v2.f
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void p(@NotNull String mmapKey, @NotNull e kv5, int priority, boolean isTrimElseRemove) {
        Intrinsics.checkNotNullParameter(mmapKey, "mmapKey");
        Intrinsics.checkNotNullParameter(kv5, "kv");
        QMMKV.logInfo("mmkvcache onItemEvicted isTrimElseRemove:" + isTrimElseRemove + TokenParser.SP + mmapKey + " = " + kv5.hashCode());
    }
}
