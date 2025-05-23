package com.tencent.biz.qqcircle.immersive.feed.live;

import android.widget.TextView;
import com.tencent.qqlive.common.api.IAegisLogApi;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/feed/live/c;", "", "Lfeedcloud/FeedCloudMeta$StFeed;", "data", "", "c", "", "a", "b", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "liveTitleTv", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLog", "<init>", "(Landroid/widget/TextView;Lcom/tencent/qqlive/common/api/IAegisLogApi;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView liveTitleTv;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    public c(@NotNull TextView liveTitleTv, @NotNull IAegisLogApi aegisLog) {
        Intrinsics.checkNotNullParameter(liveTitleTv, "liveTitleTv");
        Intrinsics.checkNotNullParameter(aegisLog, "aegisLog");
        this.liveTitleTv = liveTitleTv;
        this.aegisLog = aegisLog;
    }

    private final int a() {
        return 2;
    }

    private final void c(FeedCloudMeta$StFeed data) {
        boolean z16;
        String str = data.live.room.roomTitle.get();
        String str2 = data.poster.nick.get();
        int a16 = a();
        this.aegisLog.i("FeedLiveTitleController", "updateLiveTitleText, titleStyle " + a16 + ", liveTitle " + str);
        TextView textView = this.liveTitleTv;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = str2 + "\u6b63\u5728\u76f4\u64ad";
        }
        textView.setText(str);
        this.liveTitleTv.setVisibility(0);
    }

    public final void b(@NotNull FeedCloudMeta$StFeed data) {
        Intrinsics.checkNotNullParameter(data, "data");
        c(data);
    }
}
