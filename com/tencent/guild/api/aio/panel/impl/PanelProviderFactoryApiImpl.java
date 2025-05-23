package com.tencent.guild.api.aio.panel.impl;

import com.tencent.aio.part.root.panel.mvx.config.b;
import com.tencent.guild.api.aio.panel.IPanelProviderFactoryApi;
import com.tencent.mobileqq.emosm.emocompat.QQEmoticonPanelProvider;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import zq0.AioPanelParam;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/api/aio/panel/impl/PanelProviderFactoryApiImpl;", "Lcom/tencent/guild/api/aio/panel/IPanelProviderFactoryApi;", "Lzq0/b;", "params", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "getEmotionPanelProvider", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class PanelProviderFactoryApiImpl implements IPanelProviderFactoryApi {

    @NotNull
    public static final String TAG = "PanelProviderFactory";

    @Override // com.tencent.guild.api.aio.panel.IPanelProviderFactoryApi
    @NotNull
    public b getEmotionPanelProvider(@NotNull AioPanelParam params) {
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i(TAG, 4, "createEmotionPanelProvider");
        return new QQEmoticonPanelProvider(params);
    }
}
