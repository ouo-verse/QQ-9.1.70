package com.tencent.mobileqq.guild.setting.guildmanage.riskmember;

import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.data.GroupSelectType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/e;", "", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/data/GroupSelectType;", "groupSelectType", "", "b", "", "tinyId", "", "isChecked", "c", "", "nickName", "d", "guildId", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface e {
    void a(@NotNull String guildId, long tinyId);

    void b(@NotNull GroupSelectType groupSelectType);

    void c(long tinyId, boolean isChecked);

    void d(long tinyId, @NotNull String nickName);
}
