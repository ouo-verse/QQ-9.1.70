package com.tencent.mobileqq.guild.feed.publish;

import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.util.Consumer;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.at.utils.AtUserHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.data.GuildSimpleContact;
import com.tencent.mobileqq.guild.event.partevent.GuildPartCheckResultEvent;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment;
import com.tencent.mobileqq.guild.feed.jsbridge.methods.publish.helper.GuildUploadHelper;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishInitBean;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCreateTextLinkEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildDraftTaskResponseEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildEditTextLinkEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedThirdVideoLinkEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildOnPhotoSelectedEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishFeedTaskRebindInfoEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRedoEvent;
import com.tencent.mobileqq.guild.feed.publish.webview.GuildFeedPublishTitleBarView;
import com.tencent.mobileqq.guild.feed.publish.widget.GuildFeedPublishHorizontalScrollView;
import com.tencent.mobileqq.guild.feed.publish.widget.GuildFeedPublishLinkInsertPop;
import com.tencent.mobileqq.guild.feed.publish.widget.b;
import com.tencent.mobileqq.guild.feed.util.GuildFeedKeyboardUtils;
import com.tencent.mobileqq.guild.feed.util.ak;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.feed.video.GuidePopBuilder;
import com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.peak.PeakConstants;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes13.dex */
public class GuildFeedPublishWebViewFragment extends GuildFeedBaseWebViewFragment implements in1.e, b.a, com.tencent.mobileqq.guild.theme.d {
    private View C;
    private GuildFeedPublishLinkInsertPop D;
    private com.tencent.mobileqq.guild.window.s E;
    private FrameLayout F;
    private com.tencent.mobileqq.guild.feed.publish.widget.f G;
    private com.tencent.mobileqq.guild.feed.publish.widget.g H;
    private com.tencent.mobileqq.guild.feed.video.h I;
    private jn1.a J;
    private ViewGroup K;
    private View L;
    private View M;
    private bn1.c N;
    private View P;
    private View Q;
    private ImageView R;
    private ImageView S;
    private ImageView T;
    private ImageView U;
    private ImageView V;
    private ImageView W;
    private ImageView X;
    private View Y;
    private ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private ImageView f222838a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f222839b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f222840c0;

    /* renamed from: d0, reason: collision with root package name */
    private View f222841d0;

    /* renamed from: e0, reason: collision with root package name */
    private GuildFeedPublishHorizontalScrollView f222842e0;

    /* renamed from: f0, reason: collision with root package name */
    Drawable f222843f0;

    /* renamed from: g0, reason: collision with root package name */
    Drawable f222844g0;

    /* renamed from: j0, reason: collision with root package name */
    private int f222847j0;

    /* renamed from: h0, reason: collision with root package name */
    private Handler f222845h0 = new Handler(Looper.getMainLooper());

    /* renamed from: i0, reason: collision with root package name */
    private boolean f222846i0 = false;

    /* renamed from: k0, reason: collision with root package name */
    private String f222848k0 = "0";

    /* renamed from: l0, reason: collision with root package name */
    private boolean f222849l0 = false;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f222850m0 = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a implements com.tencent.mobileqq.guild.feed.publish.widget.k {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.widget.k
        public void a() {
            GuildFeedPublishWebViewFragment.this.f222841d0.setVisibility(0);
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.widget.k
        public void b() {
            GuildFeedPublishWebViewFragment.this.f222841d0.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Ai(GuildFeedPublishLinkInsertPop.b bVar) {
        QLog.i("GuildFeedPublishWebViewFragment", 4, "onSubmit content=" + bVar.getContent());
        bl.c().a(new GuildEditTextLinkEvent(bVar.getContent(), bVar.getDsc()));
        this.D.dismiss();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Bi(Serializable[] serializableArr, String str, HashMap hashMap) {
        serializableArr[0] = (Serializable) hashMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Ci(final Serializable[] serializableArr, final String str, GuildFeedPublishInitBean guildFeedPublishInitBean) {
        ax.J(guildFeedPublishInitBean.getAttrs(), new Consumer() { // from class: com.tencent.mobileqq.guild.feed.publish.b
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                GuildFeedPublishWebViewFragment.Bi(serializableArr, str, (HashMap) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Di(GuildFeedPublishLinkInsertPop.b bVar) {
        QLog.i("GuildFeedPublishWebViewFragment", 4, "onSubmit content=" + bVar.getContent());
        bl.c().a(new GuildCreateTextLinkEvent(bVar.getContent(), bVar.getDsc()));
        this.D.dismiss();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Ei(GuildFeedPublishLinkInsertPop.b bVar) {
        QLog.i("GuildFeedPublishWebViewFragment", 4, "onSubmit content=" + bVar);
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(getContext(), getContext().getString(R.string.cib), 0).show();
            return null;
        }
        bl.c().a(new GuildFeedThirdVideoLinkEvent(bVar.getContent(), 1));
        this.D.dismiss();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Fi(com.tencent.mobileqq.guild.feed.publish.widget.l lVar) {
        lVar.context = getContext();
        lVar.k(R.string.f143680mq);
        lVar.n("pg_sgrp_forum_editor");
        lVar.m(true);
        lVar.l(0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Uh(GuidePopBuilder.ArrowDirect.OnTop));
        lVar.j(arrayList);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit Gi(com.tencent.mobileqq.guild.feed.publish.widget.l lVar) {
        lVar.context = getContext();
        lVar.k(R.string.f143690mr);
        lVar.n("pg_sgrp_forum_editor");
        lVar.l(R.string.f145750sb);
        lVar.m(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Wh(GuidePopBuilder.ArrowDirect.OnTop));
        lVar.j(arrayList);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Hi(Consumer consumer, GuildFeedBaseInitBean guildFeedBaseInitBean) {
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).asyncCallGetSimpleDataMethod("async_check_channel_post_permission", Qi(consumer), guildFeedBaseInitBean.getGuildId(), guildFeedBaseInitBean.getChannelId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ii(jn1.e eVar) {
        Th(eVar.h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ji(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QQToast.makeText(getHostActivity(), getString(R.string.f144700ph), 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ki(EIPCResult eIPCResult, Consumer consumer) {
        if (this.isDestroyed) {
            return;
        }
        if (!eIPCResult.isSuccess()) {
            consumer.accept(Boolean.TRUE);
            return;
        }
        Bundle bundle = eIPCResult.data;
        if (bundle == null) {
            QLog.e("GuildFeedPublishWebViewFragment", 1, "[onCheckChannelPostPermission]: result is null, " + this.mInitBean);
            consumer.accept(Boolean.FALSE);
            return;
        }
        boolean z16 = bundle.getBoolean("can_post_in_channel");
        boolean z17 = eIPCResult.data.getBoolean("is_hidden_channel_selected");
        boolean z18 = eIPCResult.data.getBoolean("is_required_to_select_not_hidden_channel", false);
        boolean z19 = eIPCResult.data.getBoolean("there_is_any_speakable_not_hidden_channel");
        boolean z26 = eIPCResult.data.getBoolean("hidden_channel_id");
        if (!z16 && !getInitBean().isEditPublish()) {
            if (!getInitBean().isEditPublish() && z18 && z17) {
                if (z19) {
                    Wi(this.M);
                    return;
                } else {
                    yl1.n.z(0, R.string.f144700ph);
                    return;
                }
            }
            if (!z26) {
                yl1.n.z(1, R.string.f144900q1);
                return;
            } else {
                yl1.n.A(1, "\u5728\u8be5\u7248\u5757\u6682\u65e0\u53d1\u5e16\u6743\u9650");
                return;
            }
        }
        consumer.accept(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Li(final Consumer consumer, final EIPCResult eIPCResult) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishWebViewFragment.this.Ki(eIPCResult, consumer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mi() {
        Bundle Ph = Ph();
        Ph.putInt("key_need_check_speak_permission_type", 2);
        Ph.putInt("part_panel_biz_type", 2);
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "action_sync_show_part_select_panel", Ph);
    }

    private void Nh() {
        this.G = new com.tencent.mobileqq.guild.feed.publish.widget.f(getContext(), this.F, this);
    }

    private boolean Ni() {
        return false;
    }

    private void Oh() {
        this.H = new com.tencent.mobileqq.guild.feed.publish.widget.g(getContext(), this.F, this);
    }

    private void Oi(String str) {
        this.mIsSelfMute = false;
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", this.mInitBean.getGuildId());
        bundle.putString("key_channel_id", str);
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "async_register_mute_observer", bundle, null);
    }

    private Bundle Ph() {
        String str;
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", getInitBean().getGuildId());
        bundle.putInt("key_channel_type", 7);
        bn1.c cVar = this.N;
        if (cVar != null) {
            str = cVar.f28687a;
        } else {
            str = "";
        }
        bundle.putString("key_channel_id", str);
        return bundle;
    }

    private void Pi(final jn1.e eVar) {
        if (eVar.a()) {
            if (Ni()) {
                Xi(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedPublishWebViewFragment.this.Ii(eVar);
                    }
                });
            } else {
                Th(eVar.h());
            }
        }
    }

    private int Qh(View view) {
        return ScreenUtil.SCREEN_WIDTH - Rh(view);
    }

    private EIPCResultCallback Qi(final Consumer<Boolean> consumer) {
        return new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.feed.publish.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GuildFeedPublishWebViewFragment.this.Li(consumer, eIPCResult);
            }
        };
    }

    private int Rh(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int measuredWidth = iArr[0] - (view.getMeasuredWidth() / 2);
        QLog.i("GuildFeedPublishWebViewFragment", 1, "calPosX x=${locations[0]} y=${locations[1]} posX=$posX");
        return measuredWidth;
    }

    private void Ri(bn1.c cVar) {
        int i3;
        if (!Objects.equals(this.mInitBean.getChannelId(), cVar.f28687a)) {
            String h16 = GuildUploadHelper.i().h();
            if (TextUtils.isEmpty(h16)) {
                GuildUploadHelper.i().f();
                h16 = GuildUploadHelper.i().h();
            }
            GuildPublishFeedTaskRebindInfoEvent guildPublishFeedTaskRebindInfoEvent = new GuildPublishFeedTaskRebindInfoEvent(h16);
            guildPublishFeedTaskRebindInfoEvent.setContact(new GuildSimpleContact(this.mInitBean.getGuildId(), cVar.f28687a));
            if (cVar.f28688b == 1) {
                i3 = 15;
            } else {
                i3 = 16;
            }
            guildPublishFeedTaskRebindInfoEvent.setBusinessType(i3);
            bl.c().b(guildPublishFeedTaskRebindInfoEvent, true);
        }
    }

    private int Sh(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[1];
        QLog.i("GuildFeedPublishWebViewFragment", 1, "calPosY x=${locations[0]} y=${locations[1]} posY=$posY");
        return i3;
    }

    private void Si() {
        VideoReport.setElementId(this.T, "em_sgrp_otherapp_video");
        VideoReport.setElementExposePolicy(this.T, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this.T, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.T, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", this.T, null);
    }

    private void Th(boolean z16) {
        QLog.i("GuildFeedPublishWebViewFragment", 1, "createGuideProcessorAndGuideIfNeed isShowVideoInsertItem=" + z16);
    }

    private void Ti() {
        VideoReport.setElementId(this.T, "em_sgrp_otherapp_video");
        VideoReport.setElementExposePolicy(this.T, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this.T, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.T, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", this.T, null);
    }

    private com.tencent.mobileqq.guild.feed.video.f Uh(final GuidePopBuilder.ArrowDirect arrowDirect) {
        return new GuidePopBuilder().a(new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit xi5;
                xi5 = GuildFeedPublishWebViewFragment.this.xi(arrowDirect, (GuidePopBuilder) obj);
                return xi5;
            }
        });
    }

    private void Ui() {
        com.tencent.mobileqq.guild.feed.publish.widget.f fVar = this.G;
        if (fVar != null) {
            fVar.m();
        }
    }

    private GuidePopBuilder.c Vh(View view) {
        GuidePopBuilder.c cVar = new GuidePopBuilder.c();
        cVar.b(51);
        cVar.c(view);
        cVar.e(Sh(view));
        cVar.d(Rh(view));
        return cVar;
    }

    private void Vi() {
        com.tencent.mobileqq.guild.feed.publish.widget.g gVar = this.H;
        if (gVar != null) {
            gVar.m();
        }
    }

    private com.tencent.mobileqq.guild.feed.video.f Wh(final GuidePopBuilder.ArrowDirect arrowDirect) {
        return new GuidePopBuilder().a(new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit zi5;
                zi5 = GuildFeedPublishWebViewFragment.this.zi(arrowDirect, (GuidePopBuilder) obj);
                return zi5;
            }
        });
    }

    private void Wi(View view) {
        li();
        view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.q
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishWebViewFragment.this.Mi();
            }
        }, 50L);
        VideoReport.setElementId(view, "em_sgrp_choose_section");
        VideoReport.reportEvent("clck", view, null);
    }

    private void Xi(final Runnable runnable) {
        this.f222845h0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.GuildFeedPublishWebViewFragment.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.i("GuildFeedPublishWebViewFragment", 4, "startScrollAnim");
                GuildFeedPublishWebViewFragment.this.f222842e0.smoothScrollBy(wn0.a.f445842a.b(100), 0);
                GuildFeedPublishWebViewFragment.this.f222845h0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.GuildFeedPublishWebViewFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GuildFeedPublishWebViewFragment.this.f222842e0.smoothScrollTo(0, 0);
                        runnable.run();
                    }
                }, 800L);
            }
        }, 400L);
    }

    private Serializable Yh(final String str) {
        final Serializable[] serializableArr = new Serializable[1];
        ax.J(getInitBean(), new Consumer() { // from class: com.tencent.mobileqq.guild.feed.publish.t
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                GuildFeedPublishWebViewFragment.Ci(serializableArr, str, (GuildFeedPublishInitBean) obj);
            }
        });
        return serializableArr[0];
    }

    private void Yi() {
        int i3;
        int a16 = this.J.a();
        int a17 = this.J.a();
        if (a16 <= 0 && a17 <= 0 && this.f222848k0.equals("0")) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i3 != this.f222847j0) {
            this.f222847j0 = i3;
            VideoReport.setPageParams(this.contentView, "sgrp_is_edit_status", Integer.valueOf(i3));
        }
    }

    private void Zi(String str, boolean z16) {
        TextView textView = (TextView) this.C.findViewById(R.id.f82694hk);
        ImageView imageView = (ImageView) this.C.findViewById(R.id.f225303z);
        if (!TextUtils.isEmpty(str) && !z16) {
            textView.setText(str);
            imageView.setVisibility(8);
            textView.setPadding(0, 0, 0, 0);
            textView.setTextColor(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(textView.getContext(), R.color.qui_common_text_link));
            return;
        }
        textView.setText(getString(R.string.f144810ps));
        textView.setTextColor(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(textView.getContext(), R.color.qui_common_text_primary));
        imageView.setVisibility(0);
        textView.setPadding(0, 0, wn0.a.f445842a.b(16), 0);
    }

    private void ai() {
        Z4();
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", getInitBean().getGuildId());
        bundle.putString("key_channel_id", getInitBean().getChannelId());
        bundle.putString(com.tencent.mobileqq.guild.feed.b.f218126l, "pg_sgrp_forum_editor");
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_show_guild_at", bundle);
    }

    private void aj(jn1.a aVar) {
        boolean f16 = aVar.f();
        jn1.a aVar2 = this.J;
        if (aVar2 != null && f16 == aVar2.f()) {
            return;
        }
        ((GuildFeedPublishTitleBarView) getUIStyleHandler().C).j0(f16);
    }

    private void bi() {
        Vi();
        ji();
    }

    private void bj() {
        this.W.setVisibility(8);
    }

    private void ci() {
        Z4();
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", getInitBean().getGuildId());
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_show_guild_hashtag", bundle);
    }

    private void cj(View view, String str) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("imp", view, null);
    }

    private void ei() {
        bl.c().a(new GuildRedoEvent(true));
    }

    private void fi() {
        int i3;
        int i16;
        int i17;
        Z4();
        jn1.a aVar = this.J;
        if (aVar != null) {
            i3 = aVar.b();
        } else {
            i3 = 20;
        }
        jn1.a aVar2 = this.J;
        if (aVar2 != null) {
            i16 = aVar2.c();
        } else {
            i16 = 1;
        }
        jn1.a aVar3 = this.J;
        if (aVar3 != null) {
            i17 = aVar3.d();
        } else {
            i17 = 1200;
        }
        int i18 = i17;
        jn1.a aVar4 = this.J;
        if (aVar4 != null) {
            i3 -= aVar4.a();
            i16 -= this.J.e();
        }
        int max = Math.max(i3, 0);
        int max2 = Math.max(i16, 0);
        Bundle bundle = new Bundle();
        bundle.putString("key_for_album_guild_id", getInitBean().getGuildId());
        bundle.putString("key_for_album_channel_id", getInitBean().getChannelId());
        GuildFeedLauncher.F(getHostActivity(), bundle, max, max2, i18, false, false, false);
    }

    private void gi(Intent intent) {
        List<Object> mediaInfoList = ((IGuildFeedMediaApi) QRoute.api(IGuildFeedMediaApi.class)).getMediaInfoList(intent);
        if (com.tencent.mobileqq.utils.bl.b(mediaInfoList)) {
            hj1.b.a("GuildFeedPublishWebViewFragment", "handleSelectPhotosResult: has not selected photos.");
            ak.b();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : mediaInfoList) {
            if (obj instanceof LocalMediaInfo) {
                arrayList.add((LocalMediaInfo) obj);
            }
        }
        bl.c().a(new GuildOnPhotoSelectedEvent(arrayList, intent.getBooleanExtra(PeakConstants.GUILD_ALBUM_QUALITY, false)));
    }

    private void handleEmoji() {
        Ui();
        ki();
    }

    private void hi() {
        bl.c().a(new GuildRedoEvent(false));
    }

    private void ii(String str, boolean z16) {
        si();
        Si();
        this.D.l0(new GuildFeedPublishLinkInsertPop.b(str, "", z16), new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Ei;
                Ei = GuildFeedPublishWebViewFragment.this.Ei((GuildFeedPublishLinkInsertPop.b) obj);
                return Ei;
            }
        }, null);
    }

    private void ji() {
        com.tencent.mobileqq.guild.feed.publish.widget.f fVar = this.G;
        if (fVar != null) {
            fVar.c();
        }
    }

    private void ki() {
        com.tencent.mobileqq.guild.feed.publish.widget.g gVar = this.H;
        if (gVar != null) {
            gVar.c();
        }
    }

    private void li() {
        GuildFeedKeyboardUtils.a(getContentView());
    }

    private void mi() {
        Context context = getContext();
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_aio_toolbar_normal);
        Drawable w3 = GuildUIUtils.w(context, R.drawable.guild_feed_publish_redo_icon_enabled, valueOf);
        Drawable w16 = GuildUIUtils.w(getContext(), R.drawable.guild_feed_publish_redo_icon_enabled, valueOf);
        w16.setAlpha(77);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, w3);
        stateListDrawable.addState(new int[0], w16);
        this.f222838a0.setImageDrawable(stateListDrawable);
        this.f222838a0.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), R.animator.f155134n));
    }

    private void ni() {
        Context context = getContext();
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_aio_toolbar_normal);
        Drawable w3 = GuildUIUtils.w(context, R.drawable.guild_feed_publish_undo_icon_enabled, valueOf);
        Drawable w16 = GuildUIUtils.w(getContext(), R.drawable.guild_feed_publish_undo_icon_enabled, valueOf);
        w16.setAlpha(77);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, w3);
        stateListDrawable.addState(new int[0], w16);
        this.Z.setImageDrawable(stateListDrawable);
        this.Z.setStateListAnimator(AnimatorInflater.loadStateListAnimator(getContext(), R.animator.f155134n));
    }

    private void oi() {
        com.tencent.mobileqq.guild.window.s sVar = new com.tencent.mobileqq.guild.window.s(getContentView());
        this.E = sVar;
        sVar.g(this.G);
        this.E.g(this.H);
    }

    private void pageDtReport() {
        String str;
        HashMap hashMap = new HashMap();
        if (getInitBean().getBusinessType() == 7) {
            hashMap.put("group_id", this.mInitBean.getTroopUin());
            hashMap.put("group_uin_type", Integer.valueOf(this.mInitBean.getTroopRole()));
            str = "pg_group_sgrp_forum_editor";
        } else {
            hashMap.put("sgrp_user_type", this.mInitBean.getUserType());
            hashMap.put("sgrp_duration_flag", 1);
            str = "pg_sgrp_forum_editor";
        }
        VideoReport.addToDetectionWhitelist((QBaseActivity) getActivity());
        VideoReport.setPageId(this.contentView, str);
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("sgrp_channel_id", this.mInitBean.getGuildId());
        hashMap.put("sgrp_sub_channel_id", this.mInitBean.getChannelId());
        hashMap.put("sgrp_is_edit_status", 0);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageParams(this.contentView, new PageParams(hashMap));
        VideoReport.ignorePageInOutEvent(this.contentView, true);
        VideoReport.reportPgIn(this.contentView);
    }

    private void pi() {
        GuildFeedPublishLinkInsertPop guildFeedPublishLinkInsertPop = this.D;
        if (guildFeedPublishLinkInsertPop != null) {
            this.E.k(guildFeedPublishLinkInsertPop);
            this.D.dismiss();
        }
        GuildFeedPublishLinkInsertPop a16 = new com.tencent.mobileqq.guild.feed.publish.widget.l().a(new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Fi;
                Fi = GuildFeedPublishWebViewFragment.this.Fi((com.tencent.mobileqq.guild.feed.publish.widget.l) obj);
                return Fi;
            }
        });
        this.D = a16;
        this.E.g(a16);
    }

    private void qi() {
        boolean z16;
        int i3;
        Serializable Yh = Yh("is_part_not_selected");
        if (Yh != null && !Objects.equals(1, Yh)) {
            z16 = false;
        } else {
            z16 = true;
        }
        String channelId = getInitBean().getChannelId();
        if (z16) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.N = new bn1.c(channelId, i3, getInitBean().getChannelName(), Boolean.TRUE);
        Zi(getInitBean().getChannelName(), z16);
        Bundle Ph = Ph();
        Ph.putBoolean("key_need_filter_hide_channel", true);
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "action_sync_check_part_list_empty", Ph);
    }

    private void reportDtPageOut() {
        VideoReport.reportEvent("imp_end", this.R, null);
        VideoReport.reportEvent("imp_end", this.S, null);
        VideoReport.reportEvent("imp_end", this.U, null);
        VideoReport.reportEvent("imp_end", this.W, null);
        VideoReport.reportEvent("imp_end", this.X, null);
        VideoReport.reportEvent("imp_end", this.f222839b0, null);
        VideoReport.reportEvent("imp_end", this.f222840c0, null);
        VideoReport.reportPgOut(this.contentView);
    }

    private void ri() {
        this.f222842e0.setHorizontalScrollChangeListener(new a());
    }

    private void si() {
        GuildFeedPublishLinkInsertPop guildFeedPublishLinkInsertPop = this.D;
        if (guildFeedPublishLinkInsertPop != null) {
            this.E.k(guildFeedPublishLinkInsertPop);
            this.D.dismiss();
        }
        GuildFeedPublishLinkInsertPop a16 = new com.tencent.mobileqq.guild.feed.publish.widget.l().a(new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.s
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Gi;
                Gi = GuildFeedPublishWebViewFragment.this.Gi((com.tencent.mobileqq.guild.feed.publish.widget.l) obj);
                return Gi;
            }
        });
        this.D = a16;
        this.E.g(a16);
    }

    private void ti() {
        cj(this.R, "em_sgrp_forum_editor_picture");
        cj(this.S, "em_sgrp_forum_editor_format");
        cj(this.U, "em_sgrp_forum_editor_emotion");
        cj(this.W, "em_sgrp_forum_editor_at");
        cj(this.X, "em_sgrp_forum_editor_link");
        cj(this.f222839b0, "em_sgrp_role_cancel_button");
        cj(this.f222840c0, "em_sgrp_forum_editor_send");
        cj(this.M, "em_sgrp_choose_section");
    }

    private void ui() {
        ImageView imageView = this.R;
        Context context = getContext();
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_aio_toolbar_normal);
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_publish_photo_icon_normal, valueOf));
        this.W.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_publish_at_icon_normal, valueOf));
        this.U.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_publish_emoji_icon_normal, valueOf));
        this.T.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_publish_video_icon_normal, valueOf));
        this.S.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_publish_font_icon_normal, valueOf));
        this.X.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_publish_link_icon_normal, valueOf));
        this.Q.setBackgroundColor(getContext().getResources().getColor(R.color.qui_common_border_standard));
        ni();
        mi();
    }

    private boolean vi() {
        if (this.C.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void wi(String str) {
        QLog.i("GuildFeedPublishWebViewFragment", 1, "onNormalLinkGuide Click");
        di(str, "", false);
        com.tencent.mobileqq.guild.feed.video.h hVar = this.I;
        if (hVar != null) {
            hVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit xi(GuidePopBuilder.ArrowDirect arrowDirect, GuidePopBuilder guidePopBuilder) {
        guidePopBuilder.j(arrowDirect);
        guidePopBuilder.n(getString(R.string.f144870py));
        guidePopBuilder.q(Vh(this.X));
        guidePopBuilder.k(Qh(this.X));
        guidePopBuilder.p(new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ax.H((String) obj));
            }
        });
        guidePopBuilder.l(new GuidePopBuilder.b() { // from class: com.tencent.mobileqq.guild.feed.publish.g
            @Override // com.tencent.mobileqq.guild.feed.video.GuidePopBuilder.b
            public final void G0(String str) {
                GuildFeedPublishWebViewFragment.this.wi(str);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yi(String str) {
        QLog.i("GuildFeedPublishWebViewFragment", 1, "onVideoLinkGuide Click");
        ii(str, false);
        com.tencent.mobileqq.guild.feed.video.h hVar = this.I;
        if (hVar != null) {
            hVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit zi(GuidePopBuilder.ArrowDirect arrowDirect, GuidePopBuilder guidePopBuilder) {
        guidePopBuilder.j(arrowDirect);
        guidePopBuilder.n(getString(R.string.f144930q4));
        guidePopBuilder.q(Vh(this.T));
        guidePopBuilder.k(Qh(this.T));
        guidePopBuilder.l(new GuidePopBuilder.b() { // from class: com.tencent.mobileqq.guild.feed.publish.i
            @Override // com.tencent.mobileqq.guild.feed.video.GuidePopBuilder.b
            public final void G0(String str) {
                GuildFeedPublishWebViewFragment.this.yi(str);
            }
        });
        final com.tencent.mobileqq.guild.feed.video.a aVar = com.tencent.mobileqq.guild.feed.video.a.f223983a;
        Objects.requireNonNull(aVar);
        guidePopBuilder.p(new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(com.tencent.mobileqq.guild.feed.video.a.this.b((String) obj));
            }
        });
        Objects.requireNonNull(aVar);
        guidePopBuilder.r(new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return com.tencent.mobileqq.guild.feed.video.a.this.a((String) obj);
            }
        });
        return null;
    }

    @Override // in1.e
    public void Jb(jn1.e eVar) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        boolean a16 = eVar.a();
        View view = this.C;
        int i28 = 0;
        if (a16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        ImageView imageView = this.R;
        if (eVar.f()) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        ImageView imageView2 = this.S;
        if (eVar.d()) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        imageView2.setVisibility(i17);
        ImageView imageView3 = this.U;
        if (eVar.c()) {
            i18 = 0;
        } else {
            i18 = 8;
        }
        imageView3.setVisibility(i18);
        this.V.setVisibility(8);
        ImageView imageView4 = this.W;
        if (eVar.b()) {
            i19 = 0;
        } else {
            i19 = 8;
        }
        imageView4.setVisibility(i19);
        ImageView imageView5 = this.X;
        if (eVar.e()) {
            i26 = 0;
        } else {
            i26 = 8;
        }
        imageView5.setVisibility(i26);
        View view2 = this.Y;
        if (eVar.g()) {
            i27 = 0;
        } else {
            i27 = 8;
        }
        view2.setVisibility(i27);
        ImageView imageView6 = this.T;
        if (!eVar.h()) {
            i28 = 8;
        }
        imageView6.setVisibility(i28);
        if (!this.f222846i0 && a16 && eVar.h()) {
            Ti();
            this.f222846i0 = true;
        }
        if (getInitBean().getBusinessType() == 7) {
            bj();
        }
        com.tencent.mobileqq.guild.feed.publish.widget.f fVar = this.G;
        if (fVar != null) {
            fVar.i();
        }
        com.tencent.mobileqq.guild.feed.publish.widget.g gVar = this.H;
        if (gVar != null) {
            gVar.i();
        }
        Pi(eVar);
    }

    @Override // in1.e
    public void Mb(bn1.c cVar) {
        boolean z16 = true;
        if (this.mInitBean != null && cVar != null) {
            if (!cVar.f28690d.booleanValue()) {
                QQToast.makeText(getHostActivity(), getString(R.string.f144690pg), 0).show();
                return;
            }
            if (!Objects.equals(this.mInitBean.getChannelId(), cVar.f28687a)) {
                Oi(cVar.f28687a);
            }
            this.N = cVar;
            String str = cVar.f28689c;
            if (cVar.f28688b != 2) {
                z16 = false;
            }
            Zi(str, z16);
            Ri(cVar);
            this.mInitBean.setChannelId(cVar.f28687a);
            return;
        }
        QLog.e("GuildFeedPublishWebViewFragment", 1, "bean = " + this.mInitBean + " part = " + cVar);
    }

    @Override // in1.e
    public boolean P3() {
        return this.mIsSelfMute;
    }

    @Override // in1.e
    public void T8(boolean z16) {
        int i3;
        this.f222840c0.setTextColor(((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(this.f222840c0.getContext(), R.color.qui_button_text_primary_default));
        TextView textView = this.f222840c0;
        if (z16) {
            i3 = R.drawable.guild_feed_publish_feed_back_selector;
        } else {
            i3 = R.drawable.guild_feed_publish_feed_back_disable;
        }
        textView.setBackgroundResource(i3);
    }

    public void Xh(long j3) {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.publish.GuildFeedPublishWebViewFragment.3
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedPublishWebViewFragment.this.showKeyboard();
            }
        }, j3);
    }

    @Override // in1.e
    public void Z4() {
        li();
        ji();
        ki();
    }

    @Override // pk1.b
    /* renamed from: Zh, reason: merged with bridge method [inline-methods] */
    public GuildFeedPublishInitBean getInitBean() {
        return (GuildFeedPublishInitBean) this.mInitBean;
    }

    @Override // in1.e
    public void a2(jn1.a aVar) {
        aj(aVar);
        this.J = aVar;
        Yi();
        QLog.i("GuildFeedPublishWebViewFragment", 1, "notifyEditorExtInfo  extInfo = " + aVar.toString());
    }

    @Override // in1.e
    public void ac(String str, boolean z16) {
        Z4();
        if (getContext() == null) {
            return;
        }
        new com.tencent.mobileqq.guild.feed.publish.widget.e(getContext(), str, getInitBean().isEditDraft(), z16, getInitBean().getGuildId()).show();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected void addEventClass(ArrayList arrayList) {
        super.addEventClass(arrayList);
        arrayList.add(GuildPartCheckResultEvent.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, pk1.b
    public boolean available() {
        return super.available();
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.widget.b.a
    public void cc(com.tencent.mobileqq.guild.feed.publish.widget.b bVar, boolean z16) {
        Drawable drawable;
        Drawable drawable2 = this.f222843f0;
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_aio_toolbar_normal);
        if (drawable2 == null) {
            this.f222843f0 = GuildUIUtils.w(getContext(), R.drawable.guild_feed_publish_emoji_icon_normal, valueOf);
        }
        if (this.f222844g0 == null) {
            this.f222844g0 = GuildUIUtils.w(getContext(), R.drawable.guild_feed_publish_keyboard_icon_normal, valueOf);
        }
        if (bVar == this.G) {
            this.U.setSelected(z16);
            ImageView imageView = this.U;
            if (z16) {
                drawable = this.f222844g0;
            } else {
                drawable = this.f222843f0;
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        if (bVar == this.H) {
            this.S.setSelected(z16);
        }
    }

    public void di(String str, String str2, boolean z16) {
        pi();
        Z4();
        this.D.l0(new GuildFeedPublishLinkInsertPop.b(str, str2, z16), new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Di;
                Di = GuildFeedPublishWebViewFragment.this.Di((GuildFeedPublishLinkInsertPop.b) obj);
                return Di;
            }
        }, null);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        super.doOnActivityResult(i3, i16, intent);
        QLog.d("GuildFeedPublishWebViewFragment", 2, "doOnActivityResult requestCode=" + i3 + ", resultCode=" + i16);
        if (i16 == 0) {
            Xh(300L);
        }
        if (i16 == -1 && i3 == 10014) {
            gi(intent);
            Xh(300L);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void doOnConfigurationChanged(Configuration configuration) {
        super.doOnConfigurationChanged(configuration);
        QLog.i("GuildFeedPublishWebViewFragment", 1, "doOnConfigurationChanged");
        GuildFeedPublishLinkInsertPop guildFeedPublishLinkInsertPop = this.D;
        if (guildFeedPublishLinkInsertPop != null) {
            guildFeedPublishLinkInsertPop.dismiss();
        }
        com.tencent.mobileqq.guild.feed.video.h hVar = this.I;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // in1.e
    public void ee(jn1.c cVar) {
        com.tencent.mobileqq.guild.feed.publish.widget.g gVar = this.H;
        if (gVar != null) {
            gVar.A(cVar);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected boolean enableWebViewLongClick() {
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, lj1.a
    public void finish() {
        super.finish();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    @ColorInt
    protected int getBackgroundColorId() {
        if (getContext() != null) {
            return ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(getContext(), R.color.qui_common_bg_bottom_light);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    @ColorInt
    protected int getBackgroundNightColorId() {
        if (getContext() != null) {
            return ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(getContext(), R.color.qui_common_bg_bottom_light);
        }
        return 0;
    }

    @Override // in1.e
    public void i7(boolean z16) {
        this.f222838a0.setEnabled(z16);
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected void initData() {
        pageDtReport();
        ti();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected void initView() {
        hj1.b.a("GuildFeedPublishWebViewFragment", "initView:");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f2x, (ViewGroup) null);
        this.C = inflate;
        inflate.setVisibility(4);
        getContentView().c().addView(this.C);
        this.K = (ViewGroup) this.C.findViewById(R.id.ynl);
        this.P = this.C.findViewById(R.id.f165509wd4);
        this.Q = this.C.findViewById(R.id.wd5);
        this.R = (ImageView) this.C.findViewById(R.id.y6r);
        this.T = (ImageView) this.C.findViewById(R.id.y_m);
        this.S = (ImageView) this.C.findViewById(R.id.y3e);
        this.U = (ImageView) this.C.findViewById(R.id.y2p);
        this.V = (ImageView) this.C.findViewById(R.id.f165933y43);
        this.W = (ImageView) this.C.findViewById(R.id.y0_);
        this.X = (ImageView) this.C.findViewById(R.id.y5a);
        this.Y = this.C.findViewById(R.id.yqb);
        this.Z = (ImageView) this.C.findViewById(R.id.dyq);
        this.f222838a0 = (ImageView) this.C.findViewById(R.id.f165962y82);
        this.f222841d0 = this.C.findViewById(R.id.wd6);
        this.f222842e0 = (GuildFeedPublishHorizontalScrollView) this.C.findViewById(R.id.f99405pp);
        this.f222839b0 = getSwiftTitleUI().f314054i;
        this.f222840c0 = getSwiftTitleUI().C;
        getSwiftTitleUI().M.setBackgroundColor(getResource().getColor(R.color.qui_common_bg_nav_secondary));
        this.F = (FrameLayout) this.C.findViewById(R.id.f165442w11);
        Nh();
        Oh();
        this.L = this.C.findViewById(R.id.f165310vh2);
        this.M = this.C.findViewById(R.id.f82414gt);
        if (this.mInitBean.getBusinessType() == 7) {
            this.L.setVisibility(8);
        } else {
            this.L.setVisibility(0);
            qi();
        }
        this.f222841d0.setBackground(GuildUIUtils.j(getResource().getColor(R.color.ajr), getResource().getColor(R.color.qui_common_bg_middle_light), GradientDrawable.Orientation.LEFT_RIGHT, 0));
        this.F.setOnClickListener(this);
        this.R.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.U.setOnClickListener(this);
        this.V.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
        this.Z.setOnClickListener(this);
        this.f222838a0.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.Z.setEnabled(false);
        this.f222838a0.setEnabled(false);
        ri();
        GuildThemeManager.g(this);
        oi();
        if (getInitBean().getBusinessType() == 7) {
            bj();
        }
        ui();
    }

    @Override // in1.e
    public void k7(boolean z16) {
        this.Z.setEnabled(z16);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.widget.b.a
    public boolean kh(com.tencent.mobileqq.guild.feed.publish.widget.b bVar) {
        if (!vi()) {
            return false;
        }
        if (bVar == this.G) {
            if (this.U.getVisibility() != 0) {
                return false;
            }
            return true;
        }
        if (bVar == this.H && this.S.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.y2p || id5 == R.id.y3e || !((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick(view)) {
            if (id5 == R.id.f165933y43) {
                ci();
            } else if (id5 == R.id.y0_) {
                ai();
            } else if (id5 == R.id.y5a) {
                di("", "", true);
            } else if (id5 == R.id.y2p) {
                handleEmoji();
            } else if (id5 == R.id.y6r) {
                fi();
            } else if (id5 == R.id.dyq) {
                hi();
            } else if (id5 == R.id.f165962y82) {
                ei();
            } else if (id5 == R.id.y3e) {
                bi();
            } else if (id5 == R.id.y_m) {
                ii("", true);
            } else if (id5 == R.id.f82414gt) {
                Wi(view);
            }
            super.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.tencent.mobileqq.guild.window.s sVar = this.E;
        if (sVar != null) {
            sVar.j();
        }
        GuildThemeManager.j(this);
        bl.c().b(new GuildPublishViewDestroyEvent(GuildUploadHelper.i().h()), true);
        reportDtPageOut();
        AtUserHelper.b();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        li();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        boolean z16;
        int i3;
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildPartCheckResultEvent) {
            int i16 = 8;
            if (getInitBean().isEditPublish()) {
                this.L.setVisibility(8);
                this.P.setVisibility(0);
                return;
            }
            GuildPartCheckResultEvent guildPartCheckResultEvent = (GuildPartCheckResultEvent) simpleBaseEvent;
            boolean z17 = !guildPartCheckResultEvent.isEmpty;
            boolean z18 = guildPartCheckResultEvent.hasComChannelCanSpeak;
            if (guildPartCheckResultEvent.isOpenChannelSelected && z17) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f222849l0 = z16;
            this.f222850m0 = z18;
            QLog.i("GuildFeedPublishWebViewFragment", 1, "[onReceiveEvent] GuildPartCheckResultEvent isVisible = " + z17);
            View view = this.L;
            if (z17) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
            View view2 = this.P;
            if (!z17) {
                i16 = 0;
            }
            view2.setVisibility(i16);
            if (z18) {
                this.M.setAlpha(1.0f);
                this.M.setOnClickListener(this);
            } else {
                this.M.setAlpha(0.3f);
                this.M.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.publish.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        GuildFeedPublishWebViewFragment.this.Ji(view3);
                    }
                });
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        GuildFeedPublishLinkInsertPop guildFeedPublishLinkInsertPop = this.D;
        if (guildFeedPublishLinkInsertPop != null && guildFeedPublishLinkInsertPop.isShowing()) {
            this.D.onResume();
        }
    }

    @Override // in1.e
    public void rd(GuildDraftTaskResponseEvent guildDraftTaskResponseEvent) {
        Z4();
        new com.tencent.mobileqq.guild.feed.publish.widget.c(getContext(), guildDraftTaskResponseEvent, getInitBean().getGuildId()).show();
    }

    @Override // in1.e
    public void showGuildHashtag() {
        ci();
    }

    @Override // in1.e
    public void showKeyboard() {
        InputMethodManager inputMethodManager;
        if (getContext() != null && (inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
            inputMethodManager.showSoftInput(getContentView().findFocus(), 0);
        }
    }

    @Override // in1.e
    public void t3(final Consumer<Boolean> consumer) {
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean == null) {
            consumer.accept(Boolean.TRUE);
        } else if (guildFeedBaseInitBean.getBusinessType() == 7) {
            consumer.accept(Boolean.TRUE);
        } else {
            ax.J(this.mInitBean, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.publish.o
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    GuildFeedPublishWebViewFragment.this.Hi(consumer, (GuildFeedBaseInitBean) obj);
                }
            });
        }
    }

    @Override // in1.e
    public void vg(String str) {
        di(str, "", false);
    }

    @Override // in1.e
    public void yb() {
        ai();
    }

    @Override // in1.e
    public void yf(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        GuildFeedPublishLinkInsertPop.b bVar = new GuildFeedPublishLinkInsertPop.b(str, str2, false);
        pi();
        this.D.l0(bVar, new Function1() { // from class: com.tencent.mobileqq.guild.feed.publish.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Ai;
                Ai = GuildFeedPublishWebViewFragment.this.Ai((GuildFeedPublishLinkInsertPop.b) obj);
                return Ai;
            }
        }, null);
    }

    @Override // in1.e
    public void z9(String str) {
        String str2;
        ((GuildFeedPublishTitleBarView) getUIStyleHandler().C).i0(str);
        String[] split = str.split("/");
        if (split.length == 2) {
            str2 = split[0];
        } else {
            str2 = "0";
        }
        this.f222848k0 = str2;
        Yi();
    }

    @Override // in1.e
    public void Z6() {
    }

    @Override // com.tencent.mobileqq.guild.theme.d
    public void onThemeChanged() {
    }
}
