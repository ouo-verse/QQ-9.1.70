package com.tencent.mobileqq.guild.mainframe;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildMainFrameLayout;
import com.tencent.mobileqq.guild.mainframe.view.GuildRoundRectLayout;
import com.tencent.mobileqq.guild.profile.me.aa;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ax;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\t*\u0001#\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 H\u0016R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildSecondaryFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/pad/g;", "", "Ah", "xh", "wh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "", "qOnBackPressed", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onStart", DKHippyEvent.EVENT_STOP, "hidden", "onHiddenChanged", "qOnNewIntent", "", "from", "d5", "com/tencent/mobileqq/guild/mainframe/GuildSecondaryFragment$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/GuildSecondaryFragment$b;", "absGestureListener", "<init>", "()V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSecondaryFragment extends ReportAndroidXFragment implements com.tencent.mobileqq.pad.g {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static WeakReference<ax> E = new WeakReference<>(null);

    @NotNull
    private static WeakReference<i> F = new WeakReference<>(null);
    private static boolean G;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b absGestureListener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R(\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/GuildSecondaryFragment$a;", "", "Lcom/tencent/mobileqq/guild/mainframe/i;", "context", "", "e", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "d", "Lvp1/ax;", "value", "c", "()Lvp1/ax;", tl.h.F, "(Lvp1/ax;)V", "viewBinding", "b", "()Lcom/tencent/mobileqq/guild/mainframe/i;", "g", "(Lcom/tencent/mobileqq/guild/mainframe/i;)V", "mainViewContext", "", "hasSecondaryScreenArea", "Z", "a", "()Z", "f", "(Z)V", "", "TAG", "Ljava/lang/String;", "Lmqq/util/WeakReference;", "mainViewContextRef", "Lmqq/util/WeakReference;", "viewBindingRef", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.GuildSecondaryFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return GuildSecondaryFragment.G;
        }

        @Nullable
        public final i b() {
            return (i) GuildSecondaryFragment.F.get();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        public final ax c() {
            return (ax) GuildSecondaryFragment.E.get();
        }

        @JvmStatic
        public final void d(int showType) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.MF.GuildSecondaryFragment", 2, "open showType: " + showType + " ");
            }
            ax c16 = c();
            if (c16 == null) {
                Logger.b bVar = new Logger.b();
                bVar.a().add("viewBinding is null, unbelievable");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.MF.GuildSecondaryFragment", 1, (String) it.next(), null);
                }
                return;
            }
            c16.f442332b.setTranslationX(0.0f);
            c16.f442333c.setTranslationX(0.0f);
            if (showType != 0) {
                if (showType != 1) {
                    if (showType != 2) {
                        FrameLayout frameLayout = c16.f442332b;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.chatframe");
                        frameLayout.setVisibility(8);
                        GuildRoundRectLayout guildRoundRectLayout = c16.f442333c;
                        Intrinsics.checkNotNullExpressionValue(guildRoundRectLayout, "binding.endPage");
                        guildRoundRectLayout.setVisibility(8);
                        return;
                    }
                    FrameLayout frameLayout2 = c16.f442332b;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.chatframe");
                    frameLayout2.setVisibility(8);
                    GuildRoundRectLayout guildRoundRectLayout2 = c16.f442333c;
                    Intrinsics.checkNotNullExpressionValue(guildRoundRectLayout2, "binding.endPage");
                    guildRoundRectLayout2.setVisibility(8);
                    return;
                }
                FrameLayout frameLayout3 = c16.f442332b;
                Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.chatframe");
                frameLayout3.setVisibility(0);
                GuildRoundRectLayout guildRoundRectLayout3 = c16.f442333c;
                Intrinsics.checkNotNullExpressionValue(guildRoundRectLayout3, "binding.endPage");
                guildRoundRectLayout3.setVisibility(8);
                return;
            }
            FrameLayout frameLayout4 = c16.f442332b;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.chatframe");
            frameLayout4.setVisibility(8);
            GuildRoundRectLayout guildRoundRectLayout4 = c16.f442333c;
            Intrinsics.checkNotNullExpressionValue(guildRoundRectLayout4, "binding.endPage");
            guildRoundRectLayout4.setVisibility(0);
        }

        @JvmStatic
        public final void e(@NotNull i context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Logger logger = Logger.f235387a;
            logger.d().i("Guild.MF.GuildSecondaryFragment", 1, "launch GuildSecondaryFragment");
            GuildMainFrameLayout guildMainFrameLayout = null;
            if (context.getActivity() != null && !context.getActivity().isDestroyed()) {
                if (c() == null) {
                    logger.d().i("Guild.MF.GuildSecondaryFragment", 1, "viewBinding is null");
                }
                if (!context.P() && QQGuildUIUtil.A(context.getActivity())) {
                    ax c16 = c();
                    if (c16 != null) {
                        guildMainFrameLayout = c16.getRoot();
                    }
                    if (guildMainFrameLayout != null) {
                        guildMainFrameLayout.setVisibility(4);
                    }
                }
                com.tencent.mobileqq.pad.i.e(context.getActivity(), new Bundle(), GuildSecondaryFragment.class, new com.tencent.mobileqq.pad.b().g(true).e(false).h(LaunchMode.singleTask).i(true).a());
                return;
            }
            Logger.b bVar = new Logger.b();
            bVar.a().add("activity is null or destroyed, can't start fragment");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.GuildSecondaryFragment", 1, (String) it.next(), null);
            }
        }

        public final void f(boolean z16) {
            GuildSecondaryFragment.G = z16;
        }

        public final void g(@Nullable i iVar) {
            if (iVar != GuildSecondaryFragment.F.get()) {
                GuildSecondaryFragment.F = new WeakReference(iVar);
            }
        }

        public final void h(@Nullable ax axVar) {
            if (axVar != GuildSecondaryFragment.E.get()) {
                GuildSecondaryFragment.E = new WeakReference(axVar);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/mainframe/GuildSecondaryFragment$b", "Lrr1/a;", "Lrr1/i;", "notifyData", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends rr1.a {
        b() {
        }

        @Override // rr1.a
        public void c(@NotNull rr1.i notifyData) {
            Intrinsics.checkNotNullParameter(notifyData, "notifyData");
            super.c(notifyData);
            if (notifyData.f() == 3 && notifyData.c() == 3) {
                Companion companion = GuildSecondaryFragment.INSTANCE;
                if (companion.a()) {
                    Logger.f235387a.d().d("Guild.MF.GuildSecondaryFragment", 1, "onNotify, trigger onBackEvent to exit GuildSecondaryFragment");
                    companion.f(false);
                    GuildSecondaryFragment.this.Ah();
                    FragmentActivity activity = GuildSecondaryFragment.this.getActivity();
                    if (activity != null) {
                        com.tencent.mobileqq.pad.m.a(activity);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah() {
        GuildMainFrameLayout root;
        ViewGroup rootView;
        Companion companion = INSTANCE;
        ax c16 = companion.c();
        if (c16 != null && (root = c16.getRoot()) != null) {
            aa.a(root);
            i b16 = companion.b();
            if (b16 != null && (rootView = b16.getRootView()) != null) {
                rootView.addView(root);
            }
        }
    }

    private final void wh() {
        sr1.d N;
        i b16 = INSTANCE.b();
        if (b16 != null && (N = b16.N()) != null) {
            N.removeGestureListener(this.absGestureListener);
            N.addGestureListener(this.absGestureListener);
        }
    }

    private final void xh() {
        Runnable runnable;
        sr1.d dVar;
        sr1.g gVar;
        GuildCenterPanelController guildCenterPanelController;
        GuildCenterPanelController Z0;
        GuildMainFrameLayout root;
        ViewGroup viewGroup;
        G = true;
        Companion companion = INSTANCE;
        ax c16 = companion.c();
        if (c16 != null && (root = c16.getRoot()) != null && !Intrinsics.areEqual(root.getParent(), getView())) {
            aa.a(root);
            View view = getView();
            if (view instanceof ViewGroup) {
                viewGroup = (ViewGroup) view;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.addView(root);
            }
            root.setVisibility(0);
        }
        i b16 = companion.b();
        if (b16 != null && (Z0 = b16.Z0()) != null) {
            runnable = Z0.C;
        } else {
            runnable = null;
        }
        if (runnable != null) {
            i b17 = companion.b();
            if (b17 != null) {
                guildCenterPanelController = b17.Z0();
            } else {
                guildCenterPanelController = null;
            }
            if (guildCenterPanelController != null) {
                guildCenterPanelController.C = null;
            }
            runnable.run();
        }
        i b18 = companion.b();
        if (b18 != null) {
            dVar = b18.N();
        } else {
            dVar = null;
        }
        if (dVar instanceof sr1.g) {
            gVar = (sr1.g) dVar;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            Runnable runnable2 = gVar.f434328e;
            if (runnable2 != null) {
                runnable2.run();
            }
            gVar.f434328e = null;
        }
    }

    @JvmStatic
    public static final void yh(int i3) {
        INSTANCE.d(i3);
    }

    @JvmStatic
    public static final void zh(@NotNull i iVar) {
        INSTANCE.e(iVar);
    }

    @Override // com.tencent.mobileqq.pad.g
    public void d5(int from) {
        GuildCenterPanelController Z0;
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "hideFrom");
        G = false;
        i b16 = INSTANCE.b();
        if (b16 != null && (Z0 = b16.Z0()) != null) {
            Z0.y(2);
        }
        Ah();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Logger.f235387a.d().d("Guild.MF.GuildSecondaryFragment", 1, "onConfigurationChanged");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        G = true;
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "onCreate " + hashCode());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Logger logger = Logger.f235387a;
        logger.d().i("Guild.MF.GuildSecondaryFragment", 1, "onCreateView " + hashCode());
        ax c16 = INSTANCE.c();
        if (c16 != null) {
            wh();
            GuildMainFrameLayout root = c16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "it.root");
            aa.a(root);
            frameLayout = new FrameLayout(c16.getRoot().getContext());
            GuildMainFrameLayout root2 = c16.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "it.root");
            root2.setVisibility(0);
            frameLayout.addView(c16.getRoot());
        } else {
            logger.d().i("Guild.MF.GuildSecondaryFragment", 1, "onCreateView return null " + hashCode());
            frameLayout = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        G = false;
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "onDestroy " + hashCode());
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        sr1.d N;
        GuildMainFrameLayout root;
        sr1.d N2;
        super.onDestroyView();
        boolean z16 = true;
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "onDestroyView " + hashCode());
        Companion companion = INSTANCE;
        i b16 = companion.b();
        if (b16 != null && (N2 = b16.N()) != null) {
            N2.removeGestureListener(this.absGestureListener);
        }
        ax c16 = companion.c();
        if (c16 != null && (root = c16.getRoot()) != null) {
            aa.a(root);
        }
        i b17 = companion.b();
        if (b17 == null || (N = b17.N()) == null || N.e() != 2) {
            z16 = false;
        }
        if (z16) {
            Ah();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "onHiddenChanged: " + hidden);
        if (!hidden) {
            xh();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "onResume");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "onStart");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, DKHippyEvent.EVENT_STOP);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "onViewCreated " + hashCode());
        xh();
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        boolean z16;
        GuildCenterPanelController Z0;
        i b16 = INSTANCE.b();
        if (b16 != null && (Z0 = b16.Z0()) != null) {
            z16 = Z0.onBackPressed();
        } else {
            z16 = false;
        }
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "qOnBackPressed(" + z16 + ") " + hashCode());
        if (!z16) {
            G = false;
            Ah();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                com.tencent.mobileqq.pad.m.a(activity);
            }
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        Logger.f235387a.d().i("Guild.MF.GuildSecondaryFragment", 1, "qOnNewIntent " + hashCode());
        wh();
        if (!isHidden()) {
            xh();
        }
    }
}
