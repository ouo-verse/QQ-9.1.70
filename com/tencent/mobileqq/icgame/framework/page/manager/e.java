package com.tencent.mobileqq.icgame.framework.page.manager;

import com.tencent.mobileqq.icgame.framework.exception.QQLiveException;
import com.tencent.mobileqq.icgame.framework.page.PageStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/icgame/framework/page/manager/e;", "", "Lcom/tencent/mobileqq/icgame/framework/page/PageStatus;", "nextStatus", "", "a", "", "b", "Lcom/tencent/mobileqq/icgame/framework/page/PageStatus;", "pageStatus", "<init>", "()V", "ic-game-base-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PageStatus pageStatus = PageStatus.NONE;

    public final void a(@NotNull PageStatus nextStatus) {
        PageStatus pageStatus;
        Intrinsics.checkNotNullParameter(nextStatus, "nextStatus");
        PageStatus pageStatus2 = PageStatus.INIT_CONFIG;
        if (nextStatus == pageStatus2 && this.pageStatus == PageStatus.NONE) {
            this.pageStatus = nextStatus;
            return;
        }
        PageStatus pageStatus3 = PageStatus.INIT_COMPONENT;
        if (nextStatus == pageStatus3 && this.pageStatus == pageStatus2) {
            this.pageStatus = nextStatus;
            return;
        }
        if (nextStatus == PageStatus.UN_INIT && ((pageStatus = this.pageStatus) == pageStatus2 || pageStatus == pageStatus3)) {
            this.pageStatus = nextStatus;
            return;
        }
        throw new QQLiveException("Switch PageStatus Error! cur:" + this.pageStatus + " next:" + nextStatus);
    }

    public final boolean b() {
        if (this.pageStatus == PageStatus.UN_INIT) {
            return true;
        }
        return false;
    }
}
