package com.tencent.mobileqq.qwallet.hb.panel;

import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$Promotion;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "", "", "hbType", "", "i0", "(Ljava/lang/Integer;)V", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", SkinResFactory.SKIN_THEME_APK_SAVE_DIR, "k0", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$Promotion;", "promotion", "a0", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", "tabData", "M", "Lcom/tencent/mobileqq/activity/aio/p;", "getSessionInfo", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface a {
    void M(@NotNull PanelTabData tabData);

    void a0(@NotNull RedPackSkin$Promotion promotion);

    @Nullable
    p getSessionInfo();

    void i0(@Nullable Integer hbType);

    void k0(@NotNull RedPackSkin$RecommendSkin skin);
}
