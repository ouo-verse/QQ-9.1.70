package com.tencent.mobileqq.guild.gift.module;

import com.tencent.ams.dsdk.core.DKConfiguration;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H'\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/module/h;", "", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/mobileqq/guild/gift/module/d;", "callback", "", "a", "giftId", "", "getGiftResFilePathByGiftId", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface h {
    void a(int materialId, @NotNull d callback);

    @Deprecated(message = "\u8bf7\u5c3d\u91cf\u4f7f\u7528getMaterialIdByGiftId")
    @Nullable
    String getGiftResFilePathByGiftId(int giftId);
}
