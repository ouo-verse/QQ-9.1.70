package com.tencent.guild.aio.component.combinestyle;

import android.app.Activity;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/aa;", "", "", "roleColor", "tinyId", "", "N0", "msgItemNickName", "getNickName", "Landroid/app/Activity;", "getActivity", "resId", "", UserInfo.SEX_FEMALE, "k0", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface aa {
    void F(int resId);

    int N0(@Nullable String roleColor, @NotNull String tinyId);

    @NotNull
    Activity getActivity();

    @NotNull
    String getNickName(@NotNull String msgItemNickName);

    void k0();
}
