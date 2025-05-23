package com.tencent.qqnt.aio.api;

import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J(\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J(\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H&J \u0010\u0016\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/api/h;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "target", "f", "", "peerUid", "", "chatType", "redDot", "", "g", "i", "redDotId", "c", tl.h.F, "", "d", AdMetricTag.Report.TYPE, "a", "e", "b", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface h {
    void a(int reportType, @NotNull String peerUid, int chatType, @NotNull String redDotId);

    void b(@NotNull View redDot);

    void c(@NotNull String peerUid, int chatType, @NotNull String redDotId, @NotNull View redDot);

    boolean d(@NotNull View redDot);

    void e(@NotNull String peerUid, int chatType, @NotNull View redDot);

    @NotNull
    View f(@NotNull Context context, @NotNull View target);

    void g(@NotNull String peerUid, int chatType, @NotNull View redDot);

    void h(@NotNull View redDot);

    @NotNull
    View i(@NotNull Context context, @NotNull View target);
}
