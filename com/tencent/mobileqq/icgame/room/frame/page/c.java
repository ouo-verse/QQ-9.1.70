package com.tencent.mobileqq.icgame.room.frame.page;

import com.tencent.mobileqq.icgame.base.room.multipage.api.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/frame/page/c;", "Lau0/c;", "", "getCurrentIndex", "offset", "", "a", "", "Lau0/b;", "Ljava/util/List;", "scrollOffsetChangedCallbackList", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/icgame/base/room/multipage/api/a;", "b", "Lmqq/util/WeakReference;", "framePageRef", "framePage", "<init>", "(Lcom/tencent/mobileqq/icgame/base/room/multipage/api/a;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c implements au0.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<au0.b> scrollOffsetChangedCallbackList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<com.tencent.mobileqq.icgame.base.room.multipage.api.a> framePageRef;

    public c(@NotNull com.tencent.mobileqq.icgame.base.room.multipage.api.a framePage) {
        Intrinsics.checkNotNullParameter(framePage, "framePage");
        this.scrollOffsetChangedCallbackList = new ArrayList();
        this.framePageRef = new WeakReference<>(framePage);
    }

    public final void a(int offset) {
        Iterator<T> it = this.scrollOffsetChangedCallbackList.iterator();
        while (it.hasNext()) {
            ((au0.b) it.next()).a(offset);
        }
    }

    @Override // au0.c
    public int getCurrentIndex() {
        com.tencent.mobileqq.icgame.base.room.multipage.api.a aVar;
        d n06;
        WeakReference<com.tencent.mobileqq.icgame.base.room.multipage.api.a> weakReference = this.framePageRef;
        if (weakReference != null && (aVar = weakReference.get()) != null && (n06 = aVar.n0()) != null) {
            return n06.getCurrentItem();
        }
        return -1;
    }
}
