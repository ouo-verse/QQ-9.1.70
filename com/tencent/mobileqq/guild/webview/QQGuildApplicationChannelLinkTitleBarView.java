package com.tencent.mobileqq.guild.webview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.channel.create.dialog.GuildLinkSubChannelExaminingHintDialog;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.ipc.methods.au;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.guild.util.y;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCResult;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.k;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001$B\u000f\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/webview/QQGuildApplicationChannelLinkTitleBarView;", "Lcom/tencent/mobileqq/webview/swift/SwiftIphoneTitleBarUI;", "Landroidx/lifecycle/LifecycleObserver;", "", "r0", "k0", "", "guildId", "channelId", "q0", "s0", "Landroidx/lifecycle/Lifecycle;", "p0", "o0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", com.tencent.luggage.wxa.c8.c.f123400v, BdhLogUtil.LogTag.Tag_Req, "", NodeProps.VISIBLE, "X", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/client/GuildClientParams;", "Lcom/tencent/mobileqq/guild/client/GuildClientParams;", "params", "Landroid/view/View;", "t0", "Landroid/view/View;", "customTitleLayout", "Lcom/tencent/mobileqq/webview/swift/component/v;", "uiStyleHandler", "<init>", "(Lcom/tencent/mobileqq/webview/swift/component/v;)V", "u0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildApplicationChannelLinkTitleBarView extends SwiftIphoneTitleBarUI implements LifecycleObserver {

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildClientParams params;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private View customTitleLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQGuildApplicationChannelLinkTitleBarView(@NotNull v uiStyleHandler) {
        super(uiStyleHandler);
        Intrinsics.checkNotNullParameter(uiStyleHandler, "uiStyleHandler");
    }

    private final void k0() {
        boolean z16;
        int i3;
        View view = this.customTitleLayout;
        int i16 = 0;
        if (view != null) {
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customTitleLayout");
                view = null;
            }
            view.setVisibility(0);
            return;
        }
        final GuildClientParams guildClientParams = (GuildClientParams) this.f314045d.E.getIntent().getParcelableExtra("extra_guild_client_params");
        if (guildClientParams == null) {
            s.f("WebLog_SwiftIphoneTitleBarUI", "", new IllegalArgumentException("GuildClientParams\u53c2\u6570\u4e3anull"));
            return;
        }
        this.params = guildClientParams;
        k g16 = k.g(LayoutInflater.from(this.f314045d.V.getContext()), this.M, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026), titleContainer, false)");
        this.M.addView(g16.getRoot());
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        this.customTitleLayout = root;
        g16.f443026b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.webview.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQGuildApplicationChannelLinkTitleBarView.l0(QQGuildApplicationChannelLinkTitleBarView.this, view2);
            }
        });
        String E = guildClientParams.E();
        Intrinsics.checkNotNullExpressionValue(E, "params.guildAvatarUrl");
        RoundImageView roundImageView = g16.f443030f;
        Intrinsics.checkNotNullExpressionValue(roundImageView, "binding.guildAvatar");
        com.tencent.mobileqq.guild.picload.e.a().e(com.tencent.mobileqq.guild.util.v.d(E, roundImageView, null, null, 12, null));
        g16.f443027c.setText(guildClientParams.v());
        int C = guildClientParams.C();
        LinearLayout root2 = g16.f443029e.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.examiningHint.root");
        boolean z17 = true;
        if (C == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        root2.setVisibility(i3);
        g16.f443029e.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.webview.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQGuildApplicationChannelLinkTitleBarView.m0(QQGuildApplicationChannelLinkTitleBarView.this, view2);
            }
        });
        g16.f443028d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.webview.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QQGuildApplicationChannelLinkTitleBarView.n0(QQGuildApplicationChannelLinkTitleBarView.this, guildClientParams, view2);
            }
        });
        ImageView imageView = g16.f443028d;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.detailImage");
        if (C != 0) {
            z17 = false;
        }
        if (!z17) {
            i16 = 8;
        }
        imageView.setVisibility(i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(QQGuildApplicationChannelLinkTitleBarView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f314045d.E.finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(QQGuildApplicationChannelLinkTitleBarView this$0, View view) {
        FragmentActivity fragmentActivity;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.f314045d.E;
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            GuildLinkSubChannelExaminingHintDialog.Companion companion = GuildLinkSubChannelExaminingHintDialog.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            companion.a(supportFragmentManager);
        } else {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            if (this$0.f314045d.E == null) {
                str = "null";
            } else {
                str = "not instance of FragmentActivity";
            }
            String str2 = "mUIStyleHandler.mHostActivity is " + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("WebLog_SwiftIphoneTitleBarUI", 1, (String) it.next(), null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(QQGuildApplicationChannelLinkTitleBarView this$0, GuildClientParams guildClientParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String G = guildClientParams.G();
        Intrinsics.checkNotNullExpressionValue(G, "params.guildId");
        String u16 = guildClientParams.u();
        Intrinsics.checkNotNullExpressionValue(u16, "params.channelId");
        this$0.q0(G, u16);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o0() {
        boolean z16;
        GuildClientParams guildClientParams = this.params;
        if (guildClientParams == null || guildClientParams.C() != 0) {
            return;
        }
        String u16 = guildClientParams.u();
        boolean z17 = false;
        if (u16 != null && u16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger.f235387a.d().i("WebLog_SwiftIphoneTitleBarUI", 1, "channelId: " + u16 + ", null or empty channel be deleted");
            Activity activity = this.f314045d.E;
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        EIPCResult g16 = y.g(com.tencent.mobileqq.guild.ipc.methods.c.class, u16);
        if (g16.isSuccess()) {
            Bundle bundle = g16.data;
            if (bundle != null && !bundle.getBoolean("extra_exist")) {
                z17 = true;
            }
            if (z17) {
                Logger.f235387a.d().i("WebLog_SwiftIphoneTitleBarUI", 1, "channelId: " + u16 + ", channel be deleted");
                Activity activity2 = this.f314045d.E;
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        }
    }

    private final Lifecycle p0() {
        FragmentActivity fragmentActivity;
        Activity activity = this.f314045d.E;
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null) {
            return null;
        }
        return fragmentActivity.getLifecycle();
    }

    private final void q0(String guildId, String channelId) {
        if (this.f314045d.E == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("mUIStyleHandler.mHostActivity is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("WebLog_SwiftIphoneTitleBarUI", 1, (String) it.next(), null);
            }
            return;
        }
        if (ch.s0()) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelDetailFragment(null, this.f314045d.E, guildId, channelId, 0);
        } else {
            y.g(au.class, guildId, channelId);
        }
    }

    private final void r0() {
        ViewGroup titleContainer = this.M;
        Intrinsics.checkNotNullExpressionValue(titleContainer, "titleContainer");
        Iterator<View> it = ViewGroupKt.getChildren(titleContainer).iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
    }

    private final void s0() {
        int parseColor;
        GuildThemeManager guildThemeManager = GuildThemeManager.f235286a;
        boolean z16 = !guildThemeManager.b();
        Window window = this.f314045d.E.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "mUIStyleHandler.mHostActivity.window");
        GuildThemeManager.i(z16, window);
        if (guildThemeManager.b()) {
            parseColor = Color.parseColor("#26262B");
        } else {
            parseColor = Color.parseColor("#F7F8FB");
        }
        if (!this.f314047e.f314641x) {
            ViewGroup viewGroup = this.M;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(parseColor);
            }
            WebViewProvider webViewProvider = this.f314045d.P;
            if (webViewProvider != null && webViewProvider.getWebTitleBarInterface().a3() != null) {
                this.f314045d.P.getWebTitleBarInterface().a3().setBackgroundColor(parseColor);
                ImmersiveUtils.clearCoverForStatus(this.f314045d.E.getWindow(), true);
                this.f314045d.E.getWindow().setStatusBarColor(parseColor);
                ImmersiveUtils.setStatusTextColor(true, this.f314045d.E.getWindow());
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void R(int alpha) {
        super.R(255);
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public boolean X(boolean visible) {
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void l() {
        s0();
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void m() {
        Activity activity = this.f314045d.E;
        if (activity != null) {
            b.b(activity);
        }
        ViewGroup viewGroup = this.M;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        WebViewProgressBar webViewProgressBar = this.f314045d.T;
        if (webViewProgressBar != null) {
            webViewProgressBar.setVisibility(8);
        }
        Lifecycle p06 = p0();
        if (p06 != null) {
            p06.addObserver(this);
        }
        r0();
        k0();
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void onDestroy() {
        super.onDestroy();
        Lifecycle p06 = p0();
        if (p06 != null) {
            p06.removeObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        o0();
    }
}
