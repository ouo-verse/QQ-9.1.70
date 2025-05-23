package com.tencent.guild.aio.panel.provider;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.config.c;
import com.tencent.guild.api.wallet.IGuildWalletApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J#\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/panel/provider/b;", "Lcom/tencent/aio/part/root/panel/mvx/config/b;", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "hidePanel", "showPanel", "", "e", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "c", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "d", "Lcom/tencent/aio/part/root/panel/mvx/config/c;", "panelParam", "Landroid/view/View;", "panelView", "<init>", "(Lcom/tencent/aio/part/root/panel/mvx/config/c;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.part.root.panel.mvx.config.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c panelParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View panelView;

    public b(@NotNull c panelParam) {
        Intrinsics.checkNotNullParameter(panelParam, "panelParam");
        this.panelParam = panelParam;
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    @NotNull
    public View a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Fragment c16 = this.panelParam.a().c();
        AIOParam g16 = this.panelParam.a().g();
        Intrinsics.checkNotNullExpressionValue(g16, "panelParam.mAIOContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = this.panelParam.a().g();
        Intrinsics.checkNotNullExpressionValue(g18, "panelParam.mAIOContext.aioParam");
        String b16 = com.tencent.guild.aio.util.a.b(g18);
        IGuildWalletApi iGuildWalletApi = (IGuildWalletApi) QRoute.api(IGuildWalletApi.class);
        FragmentActivity requireActivity = c16.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        View createRedPacketPanel = iGuildWalletApi.createRedPacketPanel(requireActivity, this.panelParam.a(), g17, b16);
        ViewTreeViewModelStoreOwner.set(createRedPacketPanel, c16);
        ViewTreeLifecycleOwner.set(createRedPacketPanel, c16);
        this.panelView = createRedPacketPanel;
        return createRedPacketPanel;
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    public void c() {
        super.c();
        View view = this.panelView;
        if (view == null) {
            return;
        }
        ((IGuildWalletApi) QRoute.api(IGuildWalletApi.class)).onPanelVisibilityChanged(view, false);
    }

    @Override // com.tencent.aio.part.root.panel.mvx.config.b
    public void e(@Nullable Integer hidePanel, @Nullable Integer showPanel) {
        super.e(hidePanel, showPanel);
        View view = this.panelView;
        if (view == null) {
            return;
        }
        if (showPanel != null && 1004 == showPanel.intValue()) {
            ((IGuildWalletApi) QRoute.api(IGuildWalletApi.class)).onPanelVisibilityChanged(view, true);
        } else if (hidePanel != null && 1004 == hidePanel.intValue()) {
            ((IGuildWalletApi) QRoute.api(IGuildWalletApi.class)).onPanelVisibilityChanged(view, false);
        }
    }
}
