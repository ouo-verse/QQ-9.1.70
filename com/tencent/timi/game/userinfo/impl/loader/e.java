package com.tencent.timi.game.userinfo.impl.loader;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.userinfo.impl.loader.e;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b!\u0010\"J*\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0004J\b\u0010\r\u001a\u00020\fH\u0016J&\u0010\u0011\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fH&R&\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/timi/game/userinfo/impl/loader/e;", "CallBacakData", "", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "uids", "", "f", "", "", h.F, "", "e", "requestList", "Lcom/tencent/timi/game/utils/IResultListener;", "callback", "g", "a", "Ljava/util/HashSet;", "leftNeedRequestUid", "", "b", "Z", "requesting", "", "c", "I", "getMaxNumber", "()I", "setMaxNumber", "(I)V", "maxNumber", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class e<CallBacakData> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean requesting;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashSet<Long> leftNeedRequestUid = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int maxNumber = 20;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/userinfo/impl/loader/e$a", "Lcom/tencent/timi/game/utils/IResultListener;", "result", "", "onSuccess", "(Ljava/lang/Object;)V", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<CallBacakData> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e<CallBacakData> f380207a;

        a(e<CallBacakData> eVar) {
            this.f380207a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.requesting = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(e this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.requesting = false;
            if (this$0.leftNeedRequestUid.size() > 0) {
                this$0.h(new ArrayList(this$0.leftNeedRequestUid));
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            l.i(this.f380207a.e(), "updateData - onError");
            final e<CallBacakData> eVar = this.f380207a;
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.timi.game.userinfo.impl.loader.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.d(e.this);
                }
            });
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onSuccess(@Nullable CallBacakData result) {
            l.i(this.f380207a.e(), "updateData - onSuccess");
            final e<CallBacakData> eVar = this.f380207a;
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.timi.game.userinfo.impl.loader.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.e(e.this);
                }
            });
        }
    }

    private final List<Long> f(HashSet<Long> uids) {
        Iterable<IndexedValue> withIndex;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (uids != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : uids) {
                if (((Number) obj).longValue() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
            withIndex = CollectionsKt___CollectionsKt.withIndex(arrayList2);
            if (withIndex != null) {
                for (IndexedValue indexedValue : withIndex) {
                    if (indexedValue.getIndex() < this.maxNumber) {
                        arrayList.add(indexedValue.getValue());
                    }
                }
            }
        }
        if (uids != null) {
            uids.removeAll(arrayList);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(List list, final e this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                long longValue = ((Number) obj).longValue();
                if (!this$0.leftNeedRequestUid.contains(Long.valueOf(longValue)) && longValue != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this$0.leftNeedRequestUid.add(Long.valueOf(((Number) it.next()).longValue()));
            }
        }
        if (this$0.requesting) {
            return;
        }
        this$0.requesting = true;
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.timi.game.userinfo.impl.loader.b
            @Override // java.lang.Runnable
            public final void run() {
                e.j(e.this);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<Long> f16 = this$0.f(this$0.leftNeedRequestUid);
        if (f16.size() == 0) {
            this$0.requesting = false;
            return;
        }
        l.i(this$0.e(), "updateData - start " + f16.size());
        this$0.g(f16, new a(this$0));
    }

    @NotNull
    public abstract String e();

    public abstract void g(@NotNull List<Long> requestList, @Nullable IResultListener<CallBacakData> callback);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(@Nullable final List<Long> uids) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.timi.game.userinfo.impl.loader.a
            @Override // java.lang.Runnable
            public final void run() {
                e.i(uids, this);
            }
        });
    }
}
