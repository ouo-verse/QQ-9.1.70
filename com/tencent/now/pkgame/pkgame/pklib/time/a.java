package com.tencent.now.pkgame.pkgame.pklib.time;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import rx.Observable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\b\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/pklib/time/a;", "", "", "b", "Lrx/Observable;", "", "a", "", "release", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface a {
    @NotNull
    Observable<Long> a();

    /* renamed from: b */
    int getPunishmentTimeSec();

    void release();
}
