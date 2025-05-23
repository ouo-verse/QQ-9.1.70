package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.mobileqq.guild.api.IGuildKuiklyApi;
import com.tencent.mobileqq.guild.kuikly.GameGuildView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildKuiklyApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildKuiklyApi;", "Lcom/tencent/kuikly/core/render/android/b;", "renderExport", "", "registerExternalRenderView", "registerExternalModule", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildKuiklyApiImpl implements IGuildKuiklyApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildKuiklyApi
    public void registerExternalModule(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        renderExport.a("GameGuildKuiklyModule", new Function0<i01.a>() { // from class: com.tencent.mobileqq.guild.api.impl.GuildKuiklyApiImpl$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i01.a invoke() {
                return new com.tencent.mobileqq.guild.kuikly.c();
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildKuiklyApi
    public void registerExternalRenderView(@NotNull com.tencent.kuikly.core.render.android.b renderExport) {
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        b.a.a(renderExport, "GameGuildView", new Function1<Context, i01.c>() { // from class: com.tencent.mobileqq.guild.api.impl.GuildKuiklyApiImpl$registerExternalRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final i01.c invoke(@NotNull Context it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new GameGuildView(it);
            }
        }, null, 4, null);
    }
}
