package com.tencent.mobileqq.guild.feed.util;

import com.tencent.frame.panelcontainer.f;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/bf;", "", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "", "E", "Lcom/tencent/mvi/base/route/k;", "I", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface bf {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static void a(@NotNull bf bfVar, @NotNull MsgIntent event) {
            Intrinsics.checkNotNullParameter(event, "event");
        }

        @NotNull
        public static com.tencent.mvi.base.route.k b(@NotNull bf bfVar, @NotNull MsgIntent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new f.a();
        }
    }

    void E(@NotNull MsgIntent event);

    @NotNull
    com.tencent.mvi.base.route.k I(@NotNull MsgIntent event);
}
