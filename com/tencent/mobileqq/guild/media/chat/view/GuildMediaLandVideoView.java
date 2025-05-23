package com.tencent.mobileqq.guild.media.chat.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.chat.widget.GuildMediaAnchorInfoBar;
import com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.logic.AudioNotifyHelper;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.immersive.GuildMediaImmersiveEvent;
import com.tencent.mobileqq.guild.media.widget.GuildMediaCountDownTimerView;
import com.tencent.mobileqq.guild.media.widget.GuildMediaVideoLayout;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001BB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J$\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00190\u0018j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0019`\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u001eH\u0016R\u0016\u0010$\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010#R\u0016\u00100\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00102\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010#R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/guild/media/chat/view/GuildMediaLandVideoView;", "Lcom/tencent/mobileqq/guild/media/content/GuildMediaContentFragmentBase;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/media/immersive/GuildMediaImmersiveEvent;", "", "initView", "Bh", "Dh", "Gh", OcrConfig.CHINESE, "Ch", "event", "Ah", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "", "J2", "C0", "rh", "E", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaVideoLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaVideoLayout;", "mVideoLayout", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "mToFloatingWndBtn", "H", "mToFloatingWndBtnFl", "I", "mOrientationBtn", "J", "mButtonsLayout", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar;", "K", "Lcom/tencent/mobileqq/guild/media/chat/widget/GuildMediaAnchorInfoBar;", "mAnchorInfoBar", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView;", "L", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaCountDownTimerView;", "mAudioQueueTimer", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "M", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mMediaRoomObserver", "<init>", "()V", "N", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaLandVideoView extends GuildMediaContentFragmentBase implements SimpleEventReceiver<GuildMediaImmersiveEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildMediaVideoLayout mVideoLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mToFloatingWndBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private View mToFloatingWndBtnFl;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mOrientationBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private View mButtonsLayout;

    /* renamed from: K, reason: from kotlin metadata */
    private GuildMediaAnchorInfoBar mAnchorInfoBar;

    /* renamed from: L, reason: from kotlin metadata */
    private GuildMediaCountDownTimerView mAudioQueueTimer;

    /* renamed from: M, reason: from kotlin metadata */
    private y mMediaRoomObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/chat/view/GuildMediaLandVideoView$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "userId", "", "available", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void z(@Nullable String userId, boolean available) {
            QLog.i("QGMC.GuildMediaLandVideoView", 1, "[onUserVideoAvailable] userId: " + userId + ", " + available);
            if (!available) {
                GuildMediaLandVideoView.this.ph().a2().postValue(Boolean.FALSE);
            }
        }
    }

    private final void Ah(GuildMediaImmersiveEvent event) {
        int i3;
        TranslateAnimation translateAnimation;
        TranslateAnimation translateAnimation2;
        QLog.i("QGMC.GuildMediaLandVideoView", 1, "[handleImmersiveEvent] " + event.getToEnterImmersiveState());
        boolean toEnterImmersiveState = event.getToEnterImmersiveState();
        if (toEnterImmersiveState) {
            i3 = 8;
        } else if (!toEnterImmersiveState) {
            i3 = 0;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        View view = this.mButtonsLayout;
        GuildMediaCountDownTimerView guildMediaCountDownTimerView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mButtonsLayout");
            view = null;
        }
        view.setVisibility(i3);
        GuildMediaCountDownTimerView guildMediaCountDownTimerView2 = this.mAudioQueueTimer;
        if (guildMediaCountDownTimerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioQueueTimer");
            guildMediaCountDownTimerView2 = null;
        }
        guildMediaCountDownTimerView2.setVisibility(i3);
        Context context = getContext();
        if (context != null) {
            float dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f158984ch4);
            GuildMediaAnchorInfoBar guildMediaAnchorInfoBar = this.mAnchorInfoBar;
            if (guildMediaAnchorInfoBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAnchorInfoBar");
                guildMediaAnchorInfoBar = null;
            }
            float measuredHeight = dimensionPixelSize + guildMediaAnchorInfoBar.getMeasuredHeight();
            boolean toEnterImmersiveState2 = event.getToEnterImmersiveState();
            if (toEnterImmersiveState2) {
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, measuredHeight);
                translateAnimation.setDuration(800L);
            } else if (!toEnterImmersiveState2) {
                translateAnimation = new TranslateAnimation(0.0f, 0.0f, measuredHeight, 0.0f);
                translateAnimation.setDuration(300L);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            translateAnimation.setFillAfter(true);
            GuildMediaAnchorInfoBar guildMediaAnchorInfoBar2 = this.mAnchorInfoBar;
            if (guildMediaAnchorInfoBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAnchorInfoBar");
                guildMediaAnchorInfoBar2 = null;
            }
            guildMediaAnchorInfoBar2.startAnimation(translateAnimation);
            context.getResources().getDimensionPixelSize(R.dimen.ciq);
            GuildMediaCountDownTimerView guildMediaCountDownTimerView3 = this.mAudioQueueTimer;
            if (guildMediaCountDownTimerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioQueueTimer");
                guildMediaCountDownTimerView3 = null;
            }
            guildMediaCountDownTimerView3.getMeasuredHeight();
            boolean toEnterImmersiveState3 = event.getToEnterImmersiveState();
            if (toEnterImmersiveState3) {
                translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -measuredHeight);
                translateAnimation2.setDuration(800L);
            } else if (!toEnterImmersiveState3) {
                translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, -measuredHeight, 0.0f);
                translateAnimation2.setDuration(300L);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            translateAnimation2.setFillAfter(true);
            GuildMediaCountDownTimerView guildMediaCountDownTimerView4 = this.mAudioQueueTimer;
            if (guildMediaCountDownTimerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioQueueTimer");
            } else {
                guildMediaCountDownTimerView = guildMediaCountDownTimerView4;
            }
            guildMediaCountDownTimerView.startAnimation(translateAnimation2);
        }
    }

    private final void Bh() {
        p h16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().h();
        if (h16 != null) {
            GuildMediaAnchorInfoBar guildMediaAnchorInfoBar = this.mAnchorInfoBar;
            if (guildMediaAnchorInfoBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAnchorInfoBar");
                guildMediaAnchorInfoBar = null;
            }
            guildMediaAnchorInfoBar.k(h16);
        }
    }

    private final void Ch() {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_user_screenshare_owner", 2);
        ImageView imageView = this.mOrientationBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOrientationBtn");
            imageView = null;
        }
        ch.T0(imageView, "em_sgrp_avchannel_switchpicture", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL, hashMap);
    }

    private final void Dh() {
        QLog.i("QGMC.GuildMediaLandVideoView", 1, "[initObserver] ");
        this.mMediaRoomObserver = new b();
        AudioNotifyHelper l06 = com.tencent.mobileqq.guild.media.core.j.a().l0();
        y yVar = this.mMediaRoomObserver;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRoomObserver");
            yVar = null;
        }
        l06.b(yVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(GuildMediaLandVideoView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGMC.GuildMediaLandVideoView", 1, "[initView] toFloatWnd button clicked");
        this$0.ph().P1().setValue(Boolean.TRUE);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(GuildMediaLandVideoView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QGMC.GuildMediaLandVideoView", 1, "[initView] toPortrait button clicked");
        this$0.ph().a2().postValue(Boolean.FALSE);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Gh() {
        QLog.i("QGMC.GuildMediaLandVideoView", 1, "[unInitObserver] ");
        AudioNotifyHelper l06 = com.tencent.mobileqq.guild.media.core.j.a().l0();
        y yVar = this.mMediaRoomObserver;
        if (yVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMediaRoomObserver");
            yVar = null;
        }
        l06.B(yVar);
    }

    private final void initView() {
        zh();
        ImageView imageView = this.mToFloatingWndBtn;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToFloatingWndBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.view.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildMediaLandVideoView.Eh(GuildMediaLandVideoView.this, view2);
            }
        });
        ImageView imageView2 = this.mOrientationBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOrientationBtn");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.chat.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildMediaLandVideoView.Fh(GuildMediaLandVideoView.this, view2);
            }
        });
        ph().c2().postValue(Boolean.valueOf(C0()));
        if (Intrinsics.areEqual(MediaChannelCore.INSTANCE.a().o0().getStartParams().getSourceType(), "functional_qq_little_world_feed")) {
            View view2 = this.mToFloatingWndBtnFl;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mToFloatingWndBtnFl");
            } else {
                view = view2;
            }
            view.setVisibility(8);
        }
        Bh();
        Ch();
    }

    private final void zh() {
        p h16 = com.tencent.mobileqq.guild.media.core.j.c().getUserInfoList().h();
        QLog.i("QGMC.GuildMediaLandVideoView", 1, "[addVideoView] anchorInfo: " + h16);
        if (h16 != null) {
            us1.b H0 = com.tencent.mobileqq.guild.media.core.j.a().H0();
            GuildMediaVideoLayout guildMediaVideoLayout = this.mVideoLayout;
            if (guildMediaVideoLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVideoLayout");
                guildMediaVideoLayout = null;
            }
            String str = h16.f228093a;
            Intrinsics.checkNotNullExpressionValue(str, "anchorInfo.id");
            guildMediaVideoLayout.c0(b.a.a(H0, str, false, 2, null));
        }
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean C0() {
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase, com.tencent.mobileqq.guild.media.content.i
    public boolean J2() {
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildMediaImmersiveEvent>> getEventClass() {
        ArrayList<Class<GuildMediaImmersiveEvent>> arrayList = new ArrayList<>();
        arrayList.add(GuildMediaImmersiveEvent.class);
        return arrayList;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ezc, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026d_view, container, false)");
        this.mRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        GuildMediaCountDownTimerView guildMediaCountDownTimerView = this.mAudioQueueTimer;
        if (guildMediaCountDownTimerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioQueueTimer");
            guildMediaCountDownTimerView = null;
        }
        guildMediaCountDownTimerView.g();
        Gh();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        super.onDestroyView();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (!(event instanceof GuildMediaImmersiveEvent)) {
            return;
        }
        Ah((GuildMediaImmersiveEvent) event);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        View view2 = this.mRootView;
        GuildMediaCountDownTimerView guildMediaCountDownTimerView = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById = view2.findViewById(R.id.z0a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.media_video_layout)");
        this.mVideoLayout = (GuildMediaVideoLayout) findViewById;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.vb6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.floating_btn)");
        this.mToFloatingWndBtn = (ImageView) findViewById2;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById3 = view4.findViewById(R.id.vav);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.float_btn_fl)");
        this.mToFloatingWndBtnFl = findViewById3;
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        View findViewById4 = view5.findViewById(R.id.f26480dn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.portrait_btn)");
        this.mOrientationBtn = (ImageView) findViewById4;
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view6 = null;
        }
        View findViewById5 = view6.findViewById(R.id.tkj);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.buttons_layout)");
        this.mButtonsLayout = findViewById5;
        View view7 = this.mRootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view7 = null;
        }
        View findViewById6 = view7.findViewById(R.id.so7);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.anchor_info_bar)");
        this.mAnchorInfoBar = (GuildMediaAnchorInfoBar) findViewById6;
        View view8 = this.mRootView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view8 = null;
        }
        View findViewById7 = view8.findViewById(R.id.wpv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R\u2026ld_media_countdown_timer)");
        GuildMediaCountDownTimerView guildMediaCountDownTimerView2 = (GuildMediaCountDownTimerView) findViewById7;
        this.mAudioQueueTimer = guildMediaCountDownTimerView2;
        if (guildMediaCountDownTimerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioQueueTimer");
        } else {
            guildMediaCountDownTimerView = guildMediaCountDownTimerView2;
        }
        guildMediaCountDownTimerView.f();
        initView();
        Dh();
    }

    @Override // com.tencent.mobileqq.guild.media.content.GuildMediaContentFragmentBase
    public boolean rh() {
        return true;
    }
}
