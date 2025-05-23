package com.tencent.ecommerce.biz.guild.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J;\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\fH&J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/guild/api/IECGuildApi;", "", "getMixBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "url", "", "joinChannel", "", "context", "Landroid/content/Context;", "param", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "code", "openArticlePage", "openChannelPage", "openSubChannelPage", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECGuildApi {
    @NotNull
    Drawable getMixBackgroundDrawable(@NotNull String url);

    void joinChannel(@NotNull Context context, @NotNull String param, @NotNull Function1<? super Integer, Unit> callback);

    void openArticlePage(@NotNull Context context, @NotNull String param);

    void openChannelPage(@NotNull Context context, @NotNull String param);

    void openSubChannelPage(@NotNull Context context, @NotNull String param);
}
