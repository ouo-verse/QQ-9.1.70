package com.tencent.mobileqq.guild.media.core.logic.gift;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.guild.gift.module.ShowPanelTab;
import com.tencent.mobileqq.guild.gift.module.k;
import com.tencent.mobileqq.guild.gift.module.m;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH&J+\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH&\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0014\u001a\u00020\u0013H&J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0016\u0010\u001c\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H&J\u0016\u0010\u001d\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H&J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH&J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001eH&\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/gift/a;", "", "", "init", "Landroidx/lifecycle/Lifecycle;", "pageLifecycle", "Landroid/view/ViewGroup;", "bannerViewGroup", "fullViewGroup", "b", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/gift/module/ShowPanelTab;", "type", "K", "", "receiverTinyId", "J", "(Ljava/lang/Long;Landroidx/fragment/app/FragmentActivity;Lcom/tencent/mobileqq/guild/gift/module/ShowPanelTab;)V", "", "v", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lcom/tencent/mobileqq/guild/gift/module/d;", "callback", "a", "Lcom/tencent/mobileqq/guild/gift/module/k;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "listener", h.F, "g", "Lcom/tencent/mobileqq/guild/gift/module/m;", "e", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.media.core.logic.gift.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static final class C7832a {
        public static /* synthetic */ void a(a aVar, FragmentActivity fragmentActivity, ShowPanelTab showPanelTab, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    showPanelTab = ShowPanelTab.Default;
                }
                aVar.K(fragmentActivity, showPanelTab);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPanel");
        }
    }

    void J(@Nullable Long receiverTinyId, @NotNull FragmentActivity activity, @NotNull ShowPanelTab type);

    void K(@NotNull FragmentActivity activity, @NotNull ShowPanelTab type);

    void a(int materialId, @NotNull com.tencent.mobileqq.guild.gift.module.d callback);

    void b(@NotNull Lifecycle pageLifecycle, @Nullable ViewGroup bannerViewGroup, @Nullable ViewGroup fullViewGroup);

    void e(@NotNull m listener);

    void f(@NotNull m listener);

    void g(@NotNull k<IGProSendGiftEventData> listener);

    void h(@NotNull k<IGProSendGiftEventData> listener);

    void init();

    int v();
}
