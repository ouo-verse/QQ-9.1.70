package com.tencent.mobileqq.guild.feed.util.framework.emitter;

import android.content.res.Configuration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/framework/emitter/ConfigurationChangedEmitter;", "Lcom/tencent/mobileqq/guild/feed/util/framework/emitter/a;", "Lcom/tencent/input/base/tool/emitter/a;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ConfigurationChangedEmitter extends a<com.tencent.input.base.tool.emitter.a> implements com.tencent.input.base.tool.emitter.a {
    @Override // com.tencent.input.base.tool.emitter.a
    public void onConfigurationChanged(@NotNull final Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        d(new Function1<com.tencent.input.base.tool.emitter.a, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.util.framework.emitter.ConfigurationChangedEmitter$onConfigurationChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull com.tencent.input.base.tool.emitter.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onConfigurationChanged(newConfig);
                return Boolean.FALSE;
            }
        });
    }
}
