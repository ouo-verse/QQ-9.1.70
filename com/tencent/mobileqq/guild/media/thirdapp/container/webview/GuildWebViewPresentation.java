package com.tencent.mobileqq.guild.media.thirdapp.container.webview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMediaWebIPCClient;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001)B!\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildWebViewPresentation;", "Lcom/tencent/mobileqq/remoteweb/view/g;", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "", "G", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "E", UserInfo.SEX_FEMALE, "Landroid/view/View;", "containerView", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/remoteweb/view/e;", "v", "d", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "view", "", "r", "Landroid/os/Bundle;", "J", "Landroid/os/Bundle;", "extraInfo", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/f;", "K", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/f;", "action", "", "L", "Ljava/lang/String;", "curPageId", "Landroid/content/Context;", "context", "Landroid/view/Display;", "display", "<init>", "(Landroid/content/Context;Landroid/view/Display;Landroid/os/Bundle;)V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildWebViewPresentation extends com.tencent.mobileqq.remoteweb.view.g {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Bundle extraInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.media.thirdapp.container.intent.f action;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final String curPageId;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/thirdapp/container/webview/GuildWebViewPresentation$b", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/f;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "intent", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements com.tencent.mobileqq.guild.media.thirdapp.container.intent.f {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.f
        public void a(@NotNull ContainerMsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            GuildWebViewPresentation.this.E(intent);
        }
    }

    public /* synthetic */ GuildWebViewPresentation(Context context, Display display, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, display, (i3 & 4) != 0 ? new Bundle() : bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(ContainerMsgIntent intent) {
        boolean z16;
        int i3;
        boolean z17 = true;
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildWebViewPresentation", 1, "[handleIntent] " + intent);
        if (intent instanceof ToolProcessIntent.ResizeWebIntent) {
            int i16 = 0;
            if (this.curPageId.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || !Intrinsics.areEqual(this.curPageId, ((ToolProcessIntent.ResizeWebIntent) intent).getUniqueKey())) {
                z17 = false;
            }
            if (!z17) {
                return;
            }
            ToolProcessIntent.ResizeWebIntent resizeWebIntent = (ToolProcessIntent.ResizeWebIntent) intent;
            if (resizeWebIntent.getWidth() > 0) {
                this.extraInfo.putInt("guild_webview_width", resizeWebIntent.getWidth());
            }
            if (resizeWebIntent.getHeight() > 0) {
                this.extraInfo.putInt("guild_webview_height", resizeWebIntent.getHeight());
            }
            TouchWebView y16 = y();
            if (y16 != null) {
                G(y16);
            }
            if (resizeWebIntent.getNeedRebuildDisplay()) {
                i3 = resizeWebIntent.getWidth();
            } else {
                i3 = 0;
            }
            if (resizeWebIntent.getNeedRebuildDisplay()) {
                i16 = resizeWebIntent.getHeight();
            }
            RemoteWebRenderIPCClient.h0(RemoteWebRenderIPCClient.INSTANCE.a(), resizeWebIntent.getUniqueKey(), resizeWebIntent.getSurface(), i3, i16, null, 16, null);
            GuildMediaWebIPCClient.INSTANCE.a().m(ToolProcessIntent.CloseLoadingIntent.INSTANCE);
        }
    }

    private final void F() {
        this.action = new b();
        GuildMediaWebIPCClient a16 = GuildMediaWebIPCClient.INSTANCE.a();
        com.tencent.mobileqq.guild.media.thirdapp.container.intent.f fVar = this.action;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
            fVar = null;
        }
        a16.f(fVar);
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(getContext());
        }
    }

    private final void G(TouchWebView webView) {
        ViewGroup.LayoutParams layoutParams = webView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int i3 = this.extraInfo.getInt("key_web_view_width");
        int i16 = this.extraInfo.getInt("key_web_view_height");
        int i17 = this.extraInfo.getInt("guild_webview_width");
        int i18 = this.extraInfo.getInt("guild_webview_height");
        int max = Math.max(0, i3 - i17);
        int max2 = Math.max(0, i16 - i18);
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildWebViewPresentation", 1, "[resizeWeb] display(" + i3 + ", " + i16 + "), content(" + i17 + ", " + i18 + ")");
        ((FrameLayout.LayoutParams) layoutParams).setMargins(0, 0, max, max2);
        if (webView.getParent() != null) {
            webView.requestLayout();
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g
    public void A(@NotNull TouchWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        super.A(webView);
        G(webView);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    @Nullable
    public View c(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        GuildMediaWebIPCClient.INSTANCE.a().register();
        return super.c(containerView);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void d() {
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildWebViewPresentation", 1, "[destroy]");
        GuildMediaWebIPCClient a16 = GuildMediaWebIPCClient.INSTANCE.a();
        com.tencent.mobileqq.guild.media.thirdapp.container.intent.f fVar = this.action;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
            fVar = null;
        }
        a16.l(fVar);
        super.d();
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public boolean r(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        GuildMediaWebIPCClient.Companion companion = GuildMediaWebIPCClient.INSTANCE;
        companion.a().register();
        companion.a().m(ToolProcessIntent.CloseLoadingIntent.INSTANCE);
        return super.r(view);
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g
    @NotNull
    public com.tencent.mobileqq.remoteweb.view.e v(@NotNull Activity activity, @NotNull TouchWebView webView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildWebViewPresentation", 1, "[createWebViewBuilder]");
        return new l(activity, webView, this.extraInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildWebViewPresentation(@NotNull Context context, @NotNull Display display, @NotNull Bundle extraInfo) {
        super(context, display, extraInfo);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.extraInfo = extraInfo;
        String string = extraInfo.getString("key_web_attach_web_page_id");
        this.curPageId = string == null ? "" : string;
        F();
    }
}
