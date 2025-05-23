package com.tencent.mobileqq.guild.feed.util.framework.emitter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/framework/emitter/BackEventEmitter;", "Lcom/tencent/mobileqq/guild/feed/util/framework/emitter/a;", "Lcom/tencent/mobileqq/guild/feed/util/framework/emitter/b;", "", "onBackEvent", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class BackEventEmitter extends a<b> implements b {
    @Override // com.tencent.mobileqq.guild.feed.util.framework.emitter.b
    public boolean onBackEvent() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        d(new Function1<b, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.util.framework.emitter.BackEventEmitter$onBackEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Ref.BooleanRef.this.element = it.onBackEvent();
                return Boolean.valueOf(Ref.BooleanRef.this.element);
            }
        });
        return booleanRef.element;
    }
}
