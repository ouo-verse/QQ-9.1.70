package com.tencent.mobileqq.guild.live.livemanager.gift;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.guild.gift.module.k;
import com.tencent.mobileqq.guild.gift.module.m;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\b\u001a\u00020\u0002H&J$\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u000fH'J\u0016\u0010\u001a\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&J\u0016\u0010\u001b\u001a\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H&J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001cH&J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001cH&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/live/livemanager/gift/h;", "", "", "init", "destroy", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "hidePanel", "Landroidx/lifecycle/Lifecycle;", "pageLifecycle", "Landroid/view/ViewGroup;", "bannerViewGroup", "fullViewGroup", "b", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/mobileqq/guild/gift/module/d;", "callback", "a", "giftId", "", "getGiftResFilePathByGiftId", "Lcom/tencent/mobileqq/guild/gift/module/k;", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "listener", tl.h.F, "g", "Lcom/tencent/mobileqq/guild/gift/module/m;", "e", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface h {
    void a(int materialId, @NotNull com.tencent.mobileqq.guild.gift.module.d callback);

    void b(@NotNull Lifecycle pageLifecycle, @Nullable ViewGroup bannerViewGroup, @Nullable ViewGroup fullViewGroup);

    void destroy();

    void e(@NotNull m listener);

    void f(@NotNull m listener);

    void g(@NotNull k<GiftMessage> listener);

    @Deprecated(message = "\u540c\u6b65\u51fd\u6570\uff0c\u9996\u6b21\u65f6\u57fa\u672c\u8fd4\u56de\u4e3anull\uff0c\u8bf7\u5207\u6362\u4e3agetGiftResFilePathByMaterialId\uff01")
    @Nullable
    String getGiftResFilePathByGiftId(int giftId);

    void h(@NotNull k<GiftMessage> listener);

    void hidePanel();

    void i(@Nullable FragmentActivity activity);

    void init();
}
