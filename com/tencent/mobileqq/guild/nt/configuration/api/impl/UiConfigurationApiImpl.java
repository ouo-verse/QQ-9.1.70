package com.tencent.mobileqq.guild.nt.configuration.api.impl;

import com.tencent.mobileqq.guild.nt.configuration.api.IUiConfigurationApi;
import com.tencent.mobileqq.qqemoticon.api.IChatTextSizeApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/configuration/api/impl/UiConfigurationApiImpl;", "Lcom/tencent/mobileqq/guild/nt/configuration/api/IUiConfigurationApi;", "()V", "chatTextSizeApi", "Lcom/tencent/mobileqq/qqemoticon/api/IChatTextSizeApi;", "getChatTextSizeApi", "()Lcom/tencent/mobileqq/qqemoticon/api/IChatTextSizeApi;", "chatTextSizeApi$delegate", "Lkotlin/Lazy;", "emojiTextSizeDp", "", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class UiConfigurationApiImpl implements IUiConfigurationApi {

    /* renamed from: chatTextSizeApi$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy chatTextSizeApi;

    public UiConfigurationApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IChatTextSizeApi>() { // from class: com.tencent.mobileqq.guild.nt.configuration.api.impl.UiConfigurationApiImpl$chatTextSizeApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IChatTextSizeApi invoke() {
                QRouteApi api = QRoute.api(IChatTextSizeApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IChatTextSizeApi::class.java)");
                return (IChatTextSizeApi) api;
            }
        });
        this.chatTextSizeApi = lazy;
    }

    private final IChatTextSizeApi getChatTextSizeApi() {
        return (IChatTextSizeApi) this.chatTextSizeApi.getValue();
    }

    @Override // com.tencent.mobileqq.guild.nt.configuration.api.IUiConfigurationApi
    public int emojiTextSizeDp() {
        return getChatTextSizeApi().getChatTextSizeWithDP();
    }
}
