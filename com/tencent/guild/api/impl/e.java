package com.tencent.guild.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qqnt.kernel.api.ad;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/api/impl/e;", "Lcom/tencent/qqnt/kernel/api/ad;", "Lmqq/app/AppRuntime;", "appRuntime", "", "a", "c", "<init>", "()V", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e implements ad {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        if (at.c()) {
            ch.R0(IFeedDraftServiceV2.class);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.ad
    public void a(@Nullable AppRuntime appRuntime) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.guild.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                e.d();
            }
        }, 16, null, false, 30000L);
    }

    @Override // com.tencent.qqnt.kernel.api.ad
    public void c() {
    }
}
