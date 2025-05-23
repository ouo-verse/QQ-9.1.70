package com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation;
import com.tencent.mobileqq.remoteweb.view.g;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/GuildFeedFullScreenPresentation;", "Lcom/tencent/mobileqq/remoteweb/view/g;", "Landroid/view/View;", "containerView", "c", "view", "", "r", "", "url", "Landroid/os/Bundle;", "urlExtraInfo", "", DomainData.DOMAIN_NAME, "D", "J", "Landroid/os/Bundle;", "extraInfo", "Landroid/content/Context;", "context", "Landroid/view/Display;", "display", "<init>", "(Landroid/content/Context;Landroid/view/Display;Landroid/os/Bundle;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedFullScreenPresentation extends g {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Bundle extraInfo;

    public /* synthetic */ GuildFeedFullScreenPresentation(Context context, Display display, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, display, (i3 & 4) != 0 ? new Bundle() : bundle);
    }

    public final void D(@Nullable View view) {
        h().removeAllViews();
        i().e(view);
        if (view != null) {
            h().addView(view);
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    @Nullable
    public View c(@NotNull View containerView) {
        com.tencent.mobileqq.remoteweb.view.b z16;
        BaseRemoteViewPresentation e16;
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        String string = this.extraInfo.getString("key_linked_web_page_id");
        if (string == null || (z16 = RemoteWebRenderIPCClient.INSTANCE.a().z(string)) == null || (e16 = z16.e()) == null || !(e16 instanceof GuildFeedWebViewPresentation)) {
            return null;
        }
        GuildFeedWebViewPresentation guildFeedWebViewPresentation = (GuildFeedWebViewPresentation) e16;
        guildFeedWebViewPresentation.K(x());
        return guildFeedWebViewPresentation.getFullScreenView();
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void n(@NotNull String url, @NotNull Bundle urlExtraInfo) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(urlExtraInfo, "urlExtraInfo");
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public boolean r(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedFullScreenPresentation(@NotNull Context context, @NotNull Display display, @NotNull Bundle extraInfo) {
        super(context, display, extraInfo);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.extraInfo = extraInfo;
    }
}
