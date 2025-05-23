package com.tencent.mobileqq.guild.feed.part;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.component.imagebanner.ImageBanner;
import com.tencent.mobileqq.guild.component.multitouchimg.MultiTouchImageView;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryFloatLayerIconEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedGalleryShareViewEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishState;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.part.u;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import oj1.OnMoreIconMessage;
import oj1.OnPageSelectMessage;
import oj1.OnUpdateMediaPath;

/* compiled from: P */
/* loaded from: classes13.dex */
public class u extends f implements oj1.a {
    private mj1.c C;
    private View D;
    private TextView E;
    private View F;
    private View G;
    private TextView H;
    private ProgressBar I;
    private View J;

    /* renamed from: h, reason: collision with root package name */
    private ImageBanner f222611h;

    /* renamed from: m, reason: collision with root package name */
    private GuildFeedGalleryInitBean f222613m;

    /* renamed from: i, reason: collision with root package name */
    private int f222612i = Integer.MIN_VALUE;
    private Handler K = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            u.this.ga();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProStImage f222615d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f222616e;

        b(GProStImage gProStImage, String str) {
            this.f222615d = gProStImage;
            this.f222616e = str;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i3;
            float animatedFraction = (float) (valueAnimator.getAnimatedFraction() * 0.98d);
            u.this.I.setProgress((int) (100.0f * animatedFraction));
            GProStImage gProStImage = this.f222615d;
            if (gProStImage != null) {
                i3 = gProStImage.origSize;
            } else {
                i3 = 0;
            }
            u.this.H.setText(u.this.H.getResources().getString(R.string.f144210o6, com.tencent.mobileqq.guild.feed.util.ag.c((int) (i3 * animatedFraction)), this.f222616e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GProStImage f222618d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f222619e;

        c(GProStImage gProStImage, String str) {
            this.f222618d = gProStImage;
            this.f222619e = str;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i3;
            float animatedFraction = valueAnimator.getAnimatedFraction();
            u.this.I.setProgress((int) (100.0f * animatedFraction));
            GProStImage gProStImage = this.f222618d;
            if (gProStImage != null) {
                i3 = gProStImage.origSize;
            } else {
                i3 = 0;
            }
            u.this.H.setText(u.this.H.getResources().getString(R.string.f144210o6, com.tencent.mobileqq.guild.feed.util.ag.c((int) (i3 * animatedFraction)), this.f222619e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d implements com.tencent.mobileqq.guild.component.multitouchimg.p {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.component.multitouchimg.p
        public void onViewTap(View view, float f16, float f17) {
            u.this.broadcastMessage("message_page_close", new oj1.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class e extends ViewPager2.OnPageChangeCallback {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p0(int i3) {
            u uVar = u.this;
            uVar.broadcastMessage("message_page_select", new OnPageSelectMessage(uVar.C.getRealPosition(i3), u.this.C.k0()));
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i3) {
            super.onPageScrollStateChanged(i3);
            if (i3 == 0) {
                boolean z16 = true;
                u.this.broadcastMessage("message_page_more_icon", new OnMoreIconMessage(true));
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                if (!u.this.C.s0() || !u.this.f222613m.isShowFloatLayerIcon()) {
                    z16 = false;
                }
                simpleEventBus.dispatchEvent(new GuildFeedGalleryFloatLayerIconEvent(z16));
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i3, float f16, int i16) {
            super.onPageScrolled(i3, f16, i16);
            if (f16 > 0.2d) {
                u.this.broadcastMessage("message_page_more_icon", new OnMoreIconMessage(false));
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryFloatLayerIconEvent(false));
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int i3) {
            super.onPageSelected(i3);
            if (u.this.C == null) {
                return;
            }
            if (i3 != u.this.f222612i && u.this.f222612i >= 0) {
                u uVar = u.this;
                uVar.na(uVar.f222612i);
                u.this.C.C0(i3);
            }
            u.this.C.z0(i3);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.v
                @Override // java.lang.Runnable
                public final void run() {
                    u.e.this.p0(i3);
                }
            });
            u.this.f222612i = i3;
            u.this.ia(i3);
            GProStImage image = u.this.f222613m.getRichMediaDataList().get(u.this.f222611h.N()).getImage();
            boolean z16 = false;
            if (image != null && u.this.E != null) {
                u.this.E.setText(u.this.E.getResources().getString(R.string.f14863104, com.tencent.mobileqq.guild.feed.util.ag.c(image.origSize)));
                u.this.G.setVisibility(8);
            }
            u.this.la(true);
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            if (u.this.C.s0() && u.this.f222613m.isShowFloatLayerIcon()) {
                z16 = true;
            }
            simpleEventBus.dispatchEvent(new GuildFeedGalleryFloatLayerIconEvent(z16));
        }
    }

    private boolean T9() {
        mj1.c cVar = this.C;
        if (cVar != null && !cVar.s0()) {
            return true;
        }
        return false;
    }

    private Object U9() {
        ImageBanner imageBanner;
        mj1.c cVar = this.C;
        if (cVar != null && (imageBanner = this.f222611h) != null) {
            return cVar.u0(imageBanner.N());
        }
        return null;
    }

    private GProStFeed V9() {
        if (this.f222613m.getFeed() != null) {
            return this.f222613m.getFeed();
        }
        GProStFeed gProStFeed = new GProStFeed();
        if (!TextUtils.isEmpty(this.f222613m.getFeedId())) {
            gProStFeed.idd = this.f222613m.getFeedId();
        }
        if (!TextUtils.isEmpty(this.f222613m.getFeedTitle())) {
            GProStRichTextContent gProStRichTextContent = new GProStRichTextContent();
            gProStRichTextContent.textContent.text = this.f222613m.getFeedTitle();
            gProStFeed.title.contents.add(gProStRichTextContent);
        }
        if (!TextUtils.isEmpty(this.f222613m.getPosterId())) {
            gProStFeed.poster.idd = this.f222613m.getPosterId();
        }
        if (!TextUtils.isEmpty(this.f222613m.getPosterNick())) {
            gProStFeed.poster.nick = this.f222613m.getPosterNick();
        }
        if (!TextUtils.isEmpty(this.f222613m.getPosterAvatar())) {
            gProStFeed.poster.icon.iconUrl = this.f222613m.getPosterAvatar();
        }
        return gProStFeed;
    }

    @Nullable
    private QPublicTransFragmentActivity W9() {
        Context context = getContext();
        if (context instanceof QPublicTransFragmentActivity) {
            return (QPublicTransFragmentActivity) getContext();
        }
        if (context instanceof GuildActivityWrapper) {
            FragmentActivity base = ((GuildActivityWrapper) context).getBase();
            if (base instanceof QPublicTransFragmentActivity) {
                return (QPublicTransFragmentActivity) base;
            }
        }
        return null;
    }

    private GuildFeedRichMediaData X9(int i3) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.f222613m;
        if (guildFeedGalleryInitBean != null && guildFeedGalleryInitBean.getRichMediaDataList() != null && i3 < this.f222613m.getRichMediaDataList().size() && i3 >= 0) {
            return this.f222613m.getRichMediaDataList().get(i3);
        }
        return null;
    }

    private void Y9() {
        GuildFeedPublishInfo guildFeedPublishInfo;
        boolean z16;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.f222613m;
        if (guildFeedGalleryInitBean != null) {
            guildFeedPublishInfo = guildFeedGalleryInitBean.getGuildFeedPublishInfo();
        } else {
            guildFeedPublishInfo = null;
        }
        int i3 = 0;
        if (guildFeedPublishInfo != null && guildFeedPublishInfo.isLocalFeed()) {
            boolean z17 = true;
            if (guildFeedPublishInfo.getMainStatus() == GuildFeedPublishState.STATE_PUBLISHING) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (guildFeedPublishInfo.getMainStatus() != GuildFeedPublishState.STATE_PUBLISH_FAIL) {
                z17 = false;
            }
            if (bn.h(z16, z17)) {
                return;
            }
        }
        Object broadcastGetMessage = broadcastGetMessage("ACTION_GET_CURRENT_GALLERY_DATA", null);
        if ((broadcastGetMessage instanceof GuildFeedRichMediaData) && this.f222613m != null) {
            GuildFeedGalleryShareViewEvent guildFeedGalleryShareViewEvent = new GuildFeedGalleryShareViewEvent();
            guildFeedGalleryShareViewEvent.setSource(GuildSharePageSource.FEED_DETAIL);
            com.tencent.mobileqq.guild.feed.share.c cVar = new com.tencent.mobileqq.guild.feed.share.c();
            if (getContext() != null) {
                i3 = getContext().hashCode();
            }
            cVar.k(i3);
            cVar.o((GuildFeedRichMediaData) broadcastGetMessage);
            cVar.l(this.f222613m.getFeed());
            cVar.n(this.f222613m.getGuildId());
            cVar.j(this.f222613m.getChannelId());
            cVar.q(this.f222613m.getPosterId());
            cVar.m(this.f222613m.getFromPage());
            guildFeedGalleryShareViewEvent.setGalleryShareInfo(cVar);
            guildFeedGalleryShareViewEvent.setGalleryInitBean(this.f222613m);
            SimpleEventBus.getInstance().dispatchEvent(guildFeedGalleryShareViewEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z9(int i3) {
        QLog.i("GuildFeedGalleryPagePart", 1, "[setOnItemLongClickListener] -> position = " + i3);
        if (this.f222613m.isLongPressPopMoreDialog()) {
            Y9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.G.setVisibility(8);
        la(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ba() {
        int i3;
        if (this.G.getVisibility() != 0) {
            return;
        }
        la(true);
        this.G.setVisibility(8);
        this.I.clearAnimation();
        na(this.f222612i);
        GProStImage image = this.f222613m.getRichMediaDataList().get(this.f222611h.N()).getImage();
        if (image != null) {
            i3 = image.origSize;
        } else {
            i3 = 0;
        }
        this.I.animate().setDuration(100L).setUpdateListener(new c(image, com.tencent.mobileqq.guild.feed.util.ag.c(i3))).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void da(MultiTouchImageView multiTouchImageView) {
        if (multiTouchImageView != null) {
            multiTouchImageView.setScale(1.0f, true);
        }
    }

    private void ea(View view) {
        VideoReport.setElementId(view, "em_sgrp_forum_viewer_more_original");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementParams(view, new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        int i3;
        int max = Math.max(this.f222611h.N(), 0);
        GuildFeedRichMediaData X9 = X9(max);
        if (X9 == null) {
            QLog.e("GuildFeedGalleryPagePart", 1, "onLoadOriginalClick currData == nul");
            return;
        }
        X9.setLoadOriginal();
        this.C.A0(this.f222613m.getFeed(), this.f222613m.getRichMediaDataList(), max);
        this.C.notifyItemChanged(max, new Object());
        this.D.setVisibility(8);
        this.F.setVisibility(8);
        this.G.setVisibility(0);
        this.I.setProgress(0);
        GProStImage image = this.f222613m.getRichMediaDataList().get(max).getImage();
        if (image != null) {
            i3 = image.origSize;
        } else {
            i3 = 0;
        }
        String c16 = com.tencent.mobileqq.guild.feed.util.ag.c(i3);
        TextView textView = this.H;
        textView.setText(textView.getResources().getString(R.string.f144210o6, "0" + c16.substring(c16.length() - 1), c16));
        this.I.setTag(Integer.valueOf(max));
        this.I.animate().setDuration(1000L).setUpdateListener(new b(image, c16)).start();
    }

    private void ha() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.t
            @Override // java.lang.Runnable
            public final void run() {
                u.this.ba();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(final int i3) {
        if (this.D == null) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.q
                @Override // java.lang.Runnable
                public final void run() {
                    u.this.ca(i3);
                }
            }, 100L);
        } else {
            ca(i3);
        }
    }

    private void initBanner() {
        if (this.f222611h == null) {
            QLog.e("GuildFeedGalleryPagePart", 1, "[initBanner] -> mBanner == null ");
            return;
        }
        List<GuildFeedRichMediaData> richMediaDataList = this.f222613m.getRichMediaDataList();
        int enterPos = this.f222613m.getEnterPos();
        this.f222612i = enterPos;
        mj1.c cVar = new mj1.c();
        this.C = cVar;
        cVar.setEnableLoop(false);
        this.C.B0(new d());
        this.C.A0(V9(), richMediaDataList, enterPos);
        this.f222611h.setAdapter(this.C);
        this.f222611h.i0(new e());
        this.f222611h.setOnItemLongClickListener(new ImageBanner.e() { // from class: com.tencent.mobileqq.guild.feed.part.r
            @Override // com.tencent.mobileqq.guild.component.imagebanner.ImageBanner.e
            public final void onItemLongClick(int i3) {
                u.this.Z9(i3);
            }
        });
        this.f222611h.setCurrentItem(enterPos, false);
        this.f222611h.S().setOverScrollMode(2);
    }

    private void initPageBean() {
        Intent intent;
        if (getActivity() != null && (intent = getActivity().getIntent()) != null && intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
            if (!(serializableExtra instanceof GuildFeedGalleryInitBean)) {
                return;
            }
            this.f222613m = (GuildFeedGalleryInitBean) serializableExtra;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ja, reason: merged with bridge method [inline-methods] */
    public void ca(int i3) {
        GuildFeedRichMediaData X9 = X9(i3);
        int i16 = 8;
        if (X9 != null && X9.getType() != 1 && !X9.getImage().isGif && X9.getImage().isOrig) {
            Option option = new Option();
            option.setUrl(bm.c(X9.getImage()));
            QLog.d("GuildFeedGalleryPagePart", 1, "pos: " + i3 + " | is_orig: " + X9.getImage().isOrig);
            if (X9.getImage().isOrig && X9.getImage().origSize > 0) {
                if (new File(com.tencent.mobileqq.guild.picload.e.a().c(option)).exists()) {
                    this.D.setVisibility(8);
                } else {
                    View view = this.D;
                    if (!X9.isLoadOriginal()) {
                        i16 = 0;
                    }
                    view.setVisibility(i16);
                }
            } else {
                this.D.setVisibility(8);
            }
            if (this.D.getVisibility() == 0) {
                GProStImage image = this.f222613m.getRichMediaDataList().get(Math.max(this.f222611h.N(), 0)).getImage();
                TextView textView = this.E;
                textView.setText(textView.getResources().getString(R.string.f14863104, com.tencent.mobileqq.guild.feed.util.ag.c(image.origSize)));
                return;
            }
            return;
        }
        this.D.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z16) {
        if (z16) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
        QPublicTransFragmentActivity W9 = W9();
        if (W9 != null) {
            boolean z17 = W9.getIntent().getExtras().getBoolean(com.tencent.mobileqq.guild.feed.b.D, true);
            QLog.i("GuildFeedGalleryPagePart", 2, "showIcon showIcon=" + z17 + " curShownImageType=" + T9());
            if (!z17 && T9()) {
                this.F.setVisibility(8);
            }
        }
    }

    private void ma(String str) {
        GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) U9();
        if (guildFeedRichMediaData.getType() != 0) {
            return;
        }
        guildFeedRichMediaData.getImage().picUrl = str;
        this.C.notifyItemChanged(this.f222611h.N());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(int i3) {
        final MultiTouchImageView t06 = this.C.t0(i3);
        this.K.removeCallbacksAndMessages(null);
        this.K.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.s
            @Override // java.lang.Runnable
            public final void run() {
                u.da(MultiTouchImageView.this);
            }
        }, 200L);
    }

    @Override // oj1.a
    public void G2() {
        ha();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedGalleryPagePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        if ("ACTION_GET_CURRENT_GALLERY_DATA".equals(str)) {
            return U9();
        }
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        if (TextUtils.equals(str, "message_page_update_media_path")) {
            ma(((OnUpdateMediaPath) obj).getNewPath());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        this.F.setVisibility(8);
        this.G.setVisibility(8);
        this.H.setVisibility(8);
        this.I.setVisibility(8);
        this.J.setVisibility(8);
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f222611h = (ImageBanner) view.findViewById(R.id.wio);
        this.F = view.findViewById(R.id.wk6);
        initBanner();
        this.D = view.findViewById(R.id.wow);
        this.E = (TextView) view.findViewById(R.id.wov);
        this.G = view.findViewById(R.id.g1y);
        this.H = (TextView) view.findViewById(R.id.g27);
        this.I = (ProgressBar) view.findViewById(R.id.g1o);
        View findViewById = view.findViewById(R.id.f28540j8);
        this.J = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.part.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                u.this.aa(view2);
            }
        });
        this.D.setOnClickListener(new a());
        ea(this.D);
        ia(this.f222613m.getEnterPos());
        RFWIocAbilityProvider.g().registerIoc(getPartRootView(), this, oj1.a.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        initPageBean();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), oj1.a.class);
        this.K.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        mj1.c cVar = this.C;
        if (cVar != null) {
            cVar.y0();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        mj1.c cVar = this.C;
        if (cVar != null) {
            cVar.w0(this.f222612i);
        }
    }
}
