package com.tencent.mobileqq.gamecenter.kuikly.api.impl;

import android.content.Context;
import com.tencent.mobileqq.gamecenter.kuikly.GuildBizCardKuiklyView;
import com.tencent.mobileqq.gamecenter.kuikly.api.IQQKuiklyViewCreatorApi;
import dd1.b;
import i01.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/kuikly/api/impl/QQKuiklyViewCreatorApiImpl;", "Lcom/tencent/mobileqq/gamecenter/kuikly/api/IQQKuiklyViewCreatorApi;", "Landroid/content/Context;", "context", "Ldd1/b;", "createGuildBizCardView", "", "renderExport", "", "registerExternalModule", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class QQKuiklyViewCreatorApiImpl implements IQQKuiklyViewCreatorApi {
    @Override // com.tencent.mobileqq.gamecenter.kuikly.api.IQQKuiklyViewCreatorApi
    @NotNull
    public b createGuildBizCardView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new GuildBizCardKuiklyView(context, null, 0, 6, null);
    }

    @Override // com.tencent.mobileqq.gamecenter.kuikly.api.IQQKuiklyViewCreatorApi
    public void registerExternalModule(@NotNull Object renderExport) {
        com.tencent.kuikly.core.render.android.b bVar;
        Intrinsics.checkNotNullParameter(renderExport, "renderExport");
        if (renderExport instanceof com.tencent.kuikly.core.render.android.b) {
            bVar = (com.tencent.kuikly.core.render.android.b) renderExport;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.a("GuildDTReportModule", new Function0<a>() { // from class: com.tencent.mobileqq.gamecenter.kuikly.api.impl.QQKuiklyViewCreatorApiImpl$registerExternalModule$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final a invoke() {
                    return new dd1.a();
                }
            });
        }
    }
}
