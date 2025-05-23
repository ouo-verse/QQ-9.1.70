package com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.GuildFeedWebViewPresentation$fullScreenListener$2;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.remoteweb.RemoteWebViewEvent;
import com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation;
import com.tencent.mobileqq.remoteweb.view.g;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B!\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/GuildFeedWebViewPresentation;", "Lcom/tencent/mobileqq/remoteweb/view/g;", "Landroid/view/View;", "view", "", "J", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/biz/ui/TouchWebView;", "webView", "Lcom/tencent/mobileqq/remoteweb/view/e;", "v", "d", "I", "", "linkedId", "K", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "extraInfo", "Landroid/view/View;", "fullScreenView", "L", "Ljava/lang/String;", "linkedWebPageId", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/d;", "M", "Lkotlin/Lazy;", "H", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/d;", "fullScreenListener", "Landroid/content/Context;", "context", "Landroid/view/Display;", "display", "<init>", "(Landroid/content/Context;Landroid/view/Display;Landroid/os/Bundle;)V", "N", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedWebViewPresentation extends g {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Bundle extraInfo;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View fullScreenView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String linkedWebPageId;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy fullScreenListener;

    public /* synthetic */ GuildFeedWebViewPresentation(Context context, Display display, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, display, (i3 & 4) != 0 ? new Bundle() : bundle);
    }

    private final d H() {
        return (d) this.fullScreenListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(View view) {
        BaseRemoteViewPresentation baseRemoteViewPresentation;
        String str = this.linkedWebPageId;
        if (str != null) {
            com.tencent.mobileqq.remoteweb.view.b z16 = RemoteWebRenderIPCClient.INSTANCE.a().z(str);
            if (z16 != null) {
                baseRemoteViewPresentation = z16.e();
            } else {
                baseRemoteViewPresentation = null;
            }
            if (baseRemoteViewPresentation instanceof GuildFeedFullScreenPresentation) {
                ((GuildFeedFullScreenPresentation) baseRemoteViewPresentation).D(view);
            }
        }
    }

    @Nullable
    /* renamed from: I, reason: from getter */
    public final View getFullScreenView() {
        return this.fullScreenView;
    }

    public final void K(@NotNull String linkedId) {
        Intrinsics.checkNotNullParameter(linkedId, "linkedId");
        this.linkedWebPageId = linkedId;
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g, com.tencent.mobileqq.remoteweb.view.BaseRemoteViewPresentation
    public void d() {
        QLog.i("GuildFeedWebViewPresentation", 1, "[destroy] " + x() + ", this:" + hashCode());
        super.d();
        if (z() instanceof e) {
            com.tencent.mobileqq.remoteweb.view.e z16 = z();
            Intrinsics.checkNotNull(z16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.GuildFeedWebViewBuilder");
            ((e) z16).a();
        }
    }

    @Override // com.tencent.mobileqq.remoteweb.view.g
    @NotNull
    public com.tencent.mobileqq.remoteweb.view.e v(@NotNull Activity activity, @NotNull TouchWebView webView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webView, "webView");
        e eVar = new e(activity, webView, this.extraInfo);
        eVar.b(H());
        return eVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedWebViewPresentation(@NotNull Context context, @NotNull Display display, @NotNull Bundle extraInfo) {
        super(context, display, extraInfo);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(display, "display");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.extraInfo = extraInfo;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedWebViewPresentation$fullScreenListener$2.a>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.GuildFeedWebViewPresentation$fullScreenListener$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/GuildFeedWebViewPresentation$fullScreenListener$2$a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/thirdvideo/d;", "Landroid/view/View;", "view", "", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements d {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildFeedWebViewPresentation f221681a;

                a(GuildFeedWebViewPresentation guildFeedWebViewPresentation) {
                    this.f221681a = guildFeedWebViewPresentation;
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.d
                public void a() {
                    TouchWebView y16;
                    String x16;
                    String x17;
                    y16 = this.f221681a.y();
                    if (y16 != null) {
                        GuildFeedWebViewPresentation guildFeedWebViewPresentation = this.f221681a;
                        x16 = guildFeedWebViewPresentation.x();
                        QLog.i("GuildFeedWebViewPresentation", 1, "[onExitFullScreen] " + x16 + ", this:" + hashCode());
                        guildFeedWebViewPresentation.fullScreenView = null;
                        guildFeedWebViewPresentation.J(null);
                        RemoteWebRenderIPCClient a16 = RemoteWebRenderIPCClient.INSTANCE.a();
                        x17 = guildFeedWebViewPresentation.x();
                        RemoteWebViewEvent remoteWebViewEvent = RemoteWebViewEvent.ON_FULL_SCREEN_EVENT;
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(RemoteWebViewEvent.OPEN_FULL_SCREEN, false);
                        Unit unit = Unit.INSTANCE;
                        a16.S(x17, remoteWebViewEvent, bundle);
                    }
                }

                @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.thirdvideo.d
                public void b(@Nullable View view) {
                    String x16;
                    String x17;
                    if (view != null) {
                        GuildFeedWebViewPresentation guildFeedWebViewPresentation = this.f221681a;
                        x16 = guildFeedWebViewPresentation.x();
                        QLog.i("GuildFeedWebViewPresentation", 1, "[onEnterFullScreen] " + x16 + ", this:" + hashCode());
                        guildFeedWebViewPresentation.fullScreenView = view;
                        guildFeedWebViewPresentation.J(view);
                        RemoteWebRenderIPCClient a16 = RemoteWebRenderIPCClient.INSTANCE.a();
                        x17 = guildFeedWebViewPresentation.x();
                        RemoteWebViewEvent remoteWebViewEvent = RemoteWebViewEvent.ON_FULL_SCREEN_EVENT;
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(RemoteWebViewEvent.OPEN_FULL_SCREEN, true);
                        Unit unit = Unit.INSTANCE;
                        a16.S(x17, remoteWebViewEvent, bundle);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedWebViewPresentation.this);
            }
        });
        this.fullScreenListener = lazy;
    }
}
