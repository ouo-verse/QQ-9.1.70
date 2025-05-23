package com.tencent.mobileqq.guild.widget.navigation.chatlist;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildLayoutApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.share.util.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;
import uu1.e;
import vp1.cf;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u00022\u00020\u0003:\u00012J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0004H\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/navigation/chatlist/GuildNavigationBarController;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/guild/api/IGuildLayoutApi$a;", "Landroid/view/View$OnClickListener;", "", "c", "d", "b", "e", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "progress", "J", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "Lvp1/cf;", "Lvp1/cf;", "binding", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/guild/widget/navigation/chatlist/GuildNavigationBarAnimationController;", "f", "Lcom/tencent/mobileqq/guild/widget/navigation/chatlist/GuildNavigationBarAnimationController;", "guildNavigationBarAnimationController", "Lcom/tencent/mobileqq/guild/widget/navigation/chatlist/a;", h.F, "Lcom/tencent/mobileqq/guild/widget/navigation/chatlist/a;", "bannerController", "", "i", "Ljava/lang/String;", "guildId", "Landroid/content/Context;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/nt/misc/api/INetworkStateApi$a;", "connectStateListener", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "D", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpServiceObserver", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNavigationBarController implements LifecycleObserver, IGuildLayoutApi.a, View.OnClickListener {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final INetworkStateApi.a connectStateListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpServiceObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cf binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildNavigationBarAnimationController guildNavigationBarAnimationController;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a bannerController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/navigation/chatlist/GuildNavigationBarController$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.navigation.chatlist.GuildNavigationBarController$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    private final void b() {
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).removeConnectStateListener(this.connectStateListener);
        this.lifecycleOwner.getLifecycle().removeObserver(this);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).deleteObserver(this.gpServiceObserver);
    }

    private final void c() {
        VideoReport.reportEvent("imp", this.binding.f442690b, null);
        VideoReport.reportEvent("imp", this.binding.f442689a.getBinding().f442150k, null);
        VideoReport.reportEvent("imp", this.binding.f442689a.getBinding().f442142c, null);
    }

    private final void d() {
        VideoReport.reportEvent("imp_end", this.binding.f442690b, null);
        VideoReport.reportEvent("imp_end", this.binding.f442689a.getBinding().f442150k, null);
        VideoReport.reportEvent("imp_end", this.binding.f442689a.getBinding().f442142c, null);
    }

    private final void e() {
        boolean z16;
        Activity activity;
        if (this.guildId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[showShareDialog] guildId == null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("TitleBarAboveBannerLayout", 1, (String) it.next(), null);
            }
            return;
        }
        Context context = this.context;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("[showShareDialog] activity == null");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("TitleBarAboveBannerLayout", 1, (String) it5.next(), null);
            }
            return;
        }
        IGProGuildInfo j3 = e.j(this.guildId);
        if (j3 == null) {
            Logger logger3 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("[showShareDialog] guildInfo == null");
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("TitleBarAboveBannerLayout", 1, (String) it6.next(), null);
            }
            return;
        }
        m mVar = new m(activity, j3, null, GuildSharePageSource.GUILD_PROFILE);
        c.c(mVar, 1);
        mVar.z();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildLayoutApi.d
    public void J(float progress) {
        this.guildNavigationBarAnimationController.b(progress);
        this.bannerController.b(progress);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (FastClickUtils.isFastDoubleClick("GuildNavigatorController onClick")) {
            Logger.f235387a.d().w("GuildNavigatorController", 1, "onClick isFastDoubleClick");
        } else if (v3.getId() == R.id.f84164li) {
            e();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Logger.f235387a.d().d("GuildNavigatorController", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        b();
        this.bannerController.a();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.binding.f442689a.getOnlineMemberController().e();
        d();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        this.binding.f442689a.getOnlineMemberController().f();
        c();
    }
}
