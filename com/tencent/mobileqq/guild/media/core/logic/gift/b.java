package com.tencent.mobileqq.guild.media.core.logic.gift;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J.\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00040\tH&J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/gift/b;", "", "Lcom/tencent/mobileqq/app/QBaseFragment;", "qBaseFragment", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "guildId", "channelId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/api/RoleGroupUserUIData;", "callback", "H", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "B", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface b {
    void B(int requestCode, int resultCode, @Nullable Intent data);

    void H(@NotNull String guildId, @NotNull String channelId, @NotNull Function1<? super RoleGroupUserUIData, Unit> callback);

    void q(@NotNull QBaseFragment qBaseFragment);
}
