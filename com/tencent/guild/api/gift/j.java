package com.tencent.guild.api.gift;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\nH&J\b\u0010\u0011\u001a\u00020\nH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/api/gift/j;", "", "Landroid/view/View;", "getView", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/guild/api/gift/i;", "guildGiftListener", "", "b", "", "guildId", "tinyId", "a", "pauseAnim", "resumeAnim", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface j {
    void a(@NotNull String guildId, @NotNull String tinyId);

    void b(@NotNull com.tencent.aio.data.msglist.a msgItem, @Nullable com.tencent.aio.api.runtime.a aioContext, @Nullable i guildGiftListener);

    @NotNull
    View getView();

    void pauseAnim();

    void resumeAnim();
}
