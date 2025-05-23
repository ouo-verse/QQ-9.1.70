package com.tencent.mobileqq.guild.mainframe.centerpanel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.mainframe.GuildSecondaryFragment;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.k;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import rr1.g;
import rr1.h;
import rr1.i;

/* loaded from: classes14.dex */
public class GuildCenterPanelController extends k {
    public Runnable C;
    private rr1.a D;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f227293e;

    /* renamed from: f, reason: collision with root package name */
    private List<gs1.a> f227294f;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private b f227295h;

    /* renamed from: i, reason: collision with root package name */
    private Intent f227296i;

    /* renamed from: m, reason: collision with root package name */
    private int f227297m;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface ChildFrameType {
    }

    /* loaded from: classes14.dex */
    class a extends rr1.a {
        a() {
        }

        @Override // rr1.a
        public void c(i iVar) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.MF.Center.GuildCenterPanelController", 2, "onNotify = " + iVar.toString());
            }
            GuildCenterPanelController.this.J(iVar);
            int f16 = iVar.f();
            if (f16 == 1) {
                GuildCenterPanelController.this.A(iVar);
            } else if (f16 == 3) {
                TraceUtils traceUtils = TraceUtils.f235403a;
                TraceUtils.j("aioOpenAnimation", GuildCenterPanelController.this.f227297m);
                GuildCenterPanelController.this.B(iVar);
            }
        }
    }

    /* loaded from: classes14.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f227299a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f227300b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f227301c = "";

        public String toString() {
            return "GuildSelKey{childFrameType=" + this.f227299a + ", guildId='" + this.f227300b + "', channelId='" + this.f227301c + "'}";
        }
    }

    public GuildCenterPanelController(com.tencent.mobileqq.guild.mainframe.i iVar) {
        super(iVar);
        this.f227294f = new ArrayList();
        this.f227295h = new b();
        this.f227296i = new Intent();
        this.f227297m = 0;
        this.C = null;
        this.D = new a();
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(i iVar) {
        if (iVar.g() == 1 || iVar.g() == 3) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onNotify move begin. " + iVar.toString());
            }
            M(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(i iVar) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onNotify move end. " + iVar.toString());
        }
        if (iVar.g() == 1 || iVar.g() == 3 || iVar.g() == 2) {
            if (iVar.c() != 1 && iVar.c() != 2) {
                if (iVar.c() == 3) {
                    this.f227293e.setBackground(null);
                }
            } else {
                M(false);
            }
        }
        if (iVar.g() == 1 && iVar.c() == 1 && iVar.a() == 3) {
            b bVar = this.f227295h;
            I(bVar.f227300b, bVar.f227301c);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: rr1.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildCenterPanelController.this.D();
            }
        }, 200L);
        if (iVar.c() != 2 && iVar.c() != 3) {
            if (iVar.c() == 1) {
                SceneTracker.f258213d.m("GuildChatFragment");
                return;
            }
            return;
        }
        SceneTracker.f258213d.traceEnd("GuildChatFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        this.f227466d.d1().p(this.f227295h.f227299a, this.f227296i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(int i3, Intent intent) {
        QLog.i("Guild.MF.Center.GuildCenterPanelController", 1, "delay invoke openGuildCenterPanelInternal");
        G(i3, intent);
    }

    private void G(int i3, @Nullable Intent intent) {
        gs1.a s16;
        QLog.i("Guild.MF.Center.GuildCenterPanelController", 1, "openGuildCenterPanel frameType = " + i3 + " mCurShowFrameType = " + this.f227295h.f227299a);
        if (i3 == 0) {
            r();
            return;
        }
        FrameLayout frameLayout = this.f227293e;
        if (frameLayout == null) {
            QLog.w("Guild.MF.Center.GuildCenterPanelController", 1, "openGuildCenterPanel view is null");
            return;
        }
        frameLayout.setVisibility(0);
        this.f227296i = intent;
        if (i3 == this.f227295h.f227299a && (s16 = s(i3)) != null && !s16.i(intent)) {
            QLog.i("Guild.MF.Center.GuildCenterPanelController", 1, "openGuildCenterPanel canOpenWhenHasShow false");
            return;
        }
        for (gs1.a aVar : this.f227294f) {
            if (aVar.k() != i3) {
                aVar.l();
            }
        }
        this.f227466d.N().d(intent);
        b bVar = this.f227295h;
        bVar.f227299a = i3;
        if (intent != null) {
            GuildJumpDebugUtils.a("GUILD_JUMP", "GuildCenterPanelController openGuildCenterPanel: data = ", intent);
            this.f227295h.f227300b = intent.getStringExtra("guild_id");
            this.f227295h.f227301c = intent.getStringExtra("uin");
            Bundle bundleExtra = intent.getBundleExtra("goto_guildtab_actionextra");
            if (TextUtils.isEmpty(this.f227295h.f227301c) && bundleExtra != null) {
                this.f227295h.f227301c = bundleExtra.getString("uin");
            }
            if (TextUtils.isEmpty(this.f227295h.f227300b) && bundleExtra != null) {
                this.f227295h.f227300b = bundleExtra.getString("guild_id");
            }
        } else {
            bVar.f227300b = "";
            bVar.f227301c = "";
        }
        if (i3 == 6) {
            i3 = 1;
        }
        gs1.a s17 = s(i3);
        if (s17 != null) {
            s17.n(intent);
        }
    }

    private void H() {
        this.f227294f.add(new com.tencent.mobileqq.guild.mainframe.centerpanel.a(this.f227466d));
        this.f227294f.add(new h(this.f227466d));
        this.f227294f.add(new c(this.f227466d));
        this.f227294f.add(new rr1.c(this.f227466d));
        this.f227294f.add(new g(this.f227466d));
        this.f227294f.add((gs1.a) ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).getFeedNoticeCenterPanelController(this.f227466d));
    }

    private void I(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_gesture_method", 2);
        hashMap.put("sgrp_channel_id", str);
        hashMap.put("sgrp_sub_channel_id", str2);
        VideoReport.reportEvent("sgrp_slide_gesture", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(i iVar) {
        if (iVar.f() == 3) {
            DragFrameLayout e16 = this.f227466d.e();
            if (iVar.c() == 1) {
                e16.setImportantForAccessibility(4);
            } else {
                e16.setImportantForAccessibility(0);
            }
        }
    }

    private void K(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 4, "showByAnim showType = " + i3 + QLog.getStackTraceString(new RuntimeException("showByAnim")));
        } else if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "showByAnim showType = " + i3);
        }
        this.f227466d.N().c(i3);
    }

    private void L(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "showByPos showType = " + i3);
        }
        this.f227466d.N().g(i3);
    }

    private void M(boolean z16) {
        if (QQGuildUIUtil.A(this.f227466d.getActivity())) {
            return;
        }
        ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).tabWidgetAnim(this.f227466d.getActivity(), z16);
    }

    private gs1.a s(int i3) {
        for (gs1.a aVar : this.f227294f) {
            if (aVar.k() == i3) {
                return aVar;
            }
        }
        return null;
    }

    public boolean C() {
        if (this.f227466d.N().e() == 2) {
            return true;
        }
        return false;
    }

    public void F(final int i3, @Nullable final Intent intent) {
        this.C = null;
        if (AppSetting.t(this.f227466d.getActivity())) {
            if (this.f227466d.P()) {
                G(i3, intent);
            } else {
                this.C = new Runnable() { // from class: rr1.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildCenterPanelController.this.E(i3, intent);
                    }
                };
            }
            GuildSecondaryFragment.zh(this.f227466d);
            return;
        }
        G(i3, intent);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void a(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        Iterator<gs1.a> it = this.f227294f.iterator();
        while (it.hasNext()) {
            it.next().a(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void b(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onAfterAccountChanged isSwitchAccount = " + z16);
        }
        Iterator<gs1.a> it = this.f227294f.iterator();
        while (it.hasNext()) {
            it.next().b(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k
    public void h(View view) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "initView");
        }
        if (view instanceof FrameLayout) {
            this.f227293e = (FrameLayout) view;
            Iterator<gs1.a> it = this.f227294f.iterator();
            while (it.hasNext()) {
                it.next().m(this.f227293e);
            }
            return;
        }
        QLog.e("Guild.MF.Center.GuildCenterPanelController", 2, "initView view error !");
    }

    public boolean o() {
        return this.f227466d.N().f();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onActivityResult requestCode = " + i3 + " resultCode = " + i16);
        }
        Iterator<gs1.a> it = this.f227294f.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public boolean onBackPressed() {
        boolean z16 = false;
        for (gs1.a aVar : this.f227294f) {
            if (aVar.onBackPressed()) {
                QLog.d("Guild.MF.Center.GuildCenterPanelController", 1, "onBackPressed frame class = " + aVar.getClass());
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onBackPressed result = " + z16);
        }
        if (!z16 && q()) {
            K(2);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onBackPressed end result = " + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onBeforeAccountChanged() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onBeforeAccountChanged");
        }
        Iterator<gs1.a> it = this.f227294f.iterator();
        while (it.hasNext()) {
            it.next().onBeforeAccountChanged();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onCreate() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onCreate");
        }
        Iterator<gs1.a> it = this.f227294f.iterator();
        while (it.hasNext()) {
            it.next().onCreate();
        }
        this.f227466d.N().addGestureListener(this.D);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        Iterator<gs1.a> it = this.f227294f.iterator();
        while (it.hasNext()) {
            it.next().onDestroy();
        }
        this.f227466d.N().removeGestureListener(this.D);
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onResume(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onResume tabChange = " + z16);
        }
        Iterator<gs1.a> it = this.f227294f.iterator();
        while (it.hasNext()) {
            it.next().onResume(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStart() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "onStart");
        }
        Iterator<gs1.a> it = this.f227294f.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onStop() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, DKHippyEvent.EVENT_STOP);
        }
        Iterator<gs1.a> it = this.f227294f.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    @Override // com.tencent.mobileqq.guild.mainframe.k, com.tencent.mobileqq.guild.mainframe.t
    public void onTabChanged(boolean z16) {
        if (!z16) {
            r();
        }
    }

    public boolean p() {
        return this.f227466d.N().j();
    }

    public boolean q() {
        return this.f227466d.N().l();
    }

    public void r() {
        int i3 = 1;
        if (this.f227293e == null) {
            QLog.w("Guild.MF.Center.GuildCenterPanelController", 1, "closeGuildCenterPanel view is null");
            return;
        }
        if (this.f227295h.f227299a == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "closeGuildCenterPanel already close");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "closeGuildAttachContainer curType=" + this.f227295h.f227299a);
        }
        int i16 = this.f227295h.f227299a;
        this.f227295h = new b();
        this.f227466d.d1().p(0, null);
        y(2);
        this.f227293e.setVisibility(8);
        if (i16 != 6) {
            i3 = i16;
        }
        gs1.a s16 = s(i3);
        if (s16 != null) {
            s16.l();
        }
    }

    public int t() {
        return this.f227295h.f227299a;
    }

    public String u() {
        return this.f227295h.f227300b;
    }

    public AIOContact v() {
        com.tencent.mobileqq.guild.mainframe.centerpanel.a w3 = w();
        if (w3 != null) {
            return w3.r();
        }
        return null;
    }

    public com.tencent.mobileqq.guild.mainframe.centerpanel.a w() {
        for (gs1.a aVar : this.f227294f) {
            if (aVar instanceof com.tencent.mobileqq.guild.mainframe.centerpanel.a) {
                return (com.tencent.mobileqq.guild.mainframe.centerpanel.a) aVar;
            }
        }
        return null;
    }

    public b x() {
        return this.f227295h;
    }

    public void y(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "guildCenterPanelInOrOut showType = " + i3);
        }
        L(i3);
    }

    public void z(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Center.GuildCenterPanelController", 2, "guildCenterPanelInOrOutByAnim showType = " + i3);
        }
        this.f227297m = TraceUtils.g("aioOpenAnimation");
        g12.b.f401087a.a(GuildHistogramScene.GUILD_AIO_ENTER_TO_ANIM_TIME_COST, "");
        K(i3);
    }
}
