package com.tencent.mobileqq.guild.setting.guildmanage.name;

import android.app.Dialog;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/name/QQGuildNameSettingFragment;", "", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {
    public static final void a(@NotNull QQGuildNameSettingFragment qQGuildNameSettingFragment) {
        Intrinsics.checkNotNullParameter(qQGuildNameSettingFragment, "<this>");
        Dialog dialog = qQGuildNameSettingFragment.Z;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(qQGuildNameSettingFragment.getContext(), 1, false);
        qQGuildNameSettingFragment.Z = showOnlyLoadingImageDialog;
        if (showOnlyLoadingImageDialog != null) {
            showOnlyLoadingImageDialog.show();
        }
    }
}
