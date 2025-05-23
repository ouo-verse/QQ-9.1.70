package com.qzone.reborn.feedx.util;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/feedx/util/ag;", "", "", "count", "Ljava/lang/Runnable;", "runnable", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ag {

    /* renamed from: a, reason: collision with root package name */
    public static final ag f55738a = new ag();

    ag() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, Runnable runnable, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        f55738a.b(i3 - 1, runnable, recyclerView);
    }

    public final void b(final int count, final Runnable runnable, final RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (count != 0 && recyclerView != null) {
            if (recyclerView.isComputingLayout()) {
                recyclerView.postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.util.af
                    @Override // java.lang.Runnable
                    public final void run() {
                        ag.c(count, runnable, recyclerView);
                    }
                }, 20L);
                return;
            } else {
                runnable.run();
                return;
            }
        }
        RFWLog.i("QZoneRecyclerViewSafeUpdateUtil", RFWLog.USR, "safeNotify return count = " + count);
    }
}
