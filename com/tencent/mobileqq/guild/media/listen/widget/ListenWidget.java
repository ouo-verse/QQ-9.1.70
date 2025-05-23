package com.tencent.mobileqq.guild.media.listen.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.component.marquee.MarqueeTextView;
import com.tencent.mobileqq.guild.main.topchannel.widget.GuildTopLinearGradientView;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.m;
import com.tencent.mobileqq.guild.media.listen.presenter.MusicInfo;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Y2\u00020\u0001:\u0002Z[B'\b\u0007\u0012\u0006\u0010S\u001a\u00020R\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010T\u0012\b\b\u0002\u0010V\u001a\u00020\u0015\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\tJ\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001eR\u001c\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010'\u001a\n !*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010&R\u001c\u0010(\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010#R\u001c\u0010,\u001a\n !*\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010/\u001a\n !*\u0004\u0018\u00010-0-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010.R\u001c\u00102\u001a\n !*\u0004\u0018\u000100008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00101R\u001c\u00104\u001a\n !*\u0004\u0018\u000100008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00101R\u001c\u00108\u001a\n !*\u0004\u0018\u000105058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001c\u0010:\u001a\n !*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010&R\u001c\u0010<\u001a\n !*\u0004\u0018\u000105058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00107R\u0017\u0010@\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b=\u0010#\u001a\u0004\b>\u0010?R\u0017\u0010E\u001a\u00020A8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\b*\u0010DR\u0017\u0010H\u001a\u00020A8\u0006\u00a2\u0006\f\n\u0004\bF\u0010C\u001a\u0004\bG\u0010DR\u0017\u0010K\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\bI\u0010#\u001a\u0004\bJ\u0010?R\u0017\u0010N\u001a\u00020A8\u0006\u00a2\u0006\f\n\u0004\bL\u0010C\u001a\u0004\bM\u0010DR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget;", "Landroid/widget/FrameLayout;", "", "coverUrl", "", DomainData.DOMAIN_NAME, "Landroid/graphics/Bitmap;", "resource", "f", "", "isPlaying", "o", "musicDisplayName", "p", "", "curTime", "totalTime", "setPlayTime", "Lcom/tencent/mobileqq/guild/media/listen/presenter/i;", "musicInfo", "setExInfo", "", WidgetCacheConstellationData.NUM, "setPlayNum", "text", "setLyricText", "isVisible", "setMusicActionView", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "i", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "d", "Landroid/widget/ImageView;", "imageView", "Lcom/tencent/mobileqq/guild/component/marquee/MarqueeTextView;", "Lcom/tencent/mobileqq/guild/component/marquee/MarqueeTextView;", "musicName", "particleAnim", "Lcom/airbnb/lottie/LottieAnimationView;", h.F, "Lcom/airbnb/lottie/LottieAnimationView;", "voiceLottie", "Lcom/tencent/mobileqq/guild/main/topchannel/widget/GuildTopLinearGradientView;", "Lcom/tencent/mobileqq/guild/main/topchannel/widget/GuildTopLinearGradientView;", "gradientBg", "Lcom/tencent/mobileqq/guild/media/listen/widget/GuildListenRadialGradientView;", "Lcom/tencent/mobileqq/guild/media/listen/widget/GuildListenRadialGradientView;", "animView", BdhLogUtil.LogTag.Tag_Conn, "animView2", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "timeView", "E", "lyricWidget", UserInfo.SEX_FEMALE, "orderTv", "G", "l", "()Landroid/widget/ImageView;", "quietMusic", "Landroid/view/View;", "H", "Landroid/view/View;", "()Landroid/view/View;", "orderLl", "I", "k", "pauseOrResumeBtnLl", "J", "j", "pauseOrResumeBtn", "K", "g", "nextPlayBtnLl", "L", "Ljava/lang/String;", "musicCoverUrl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ListenWidget extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final GuildListenRadialGradientView animView2;

    /* renamed from: D, reason: from kotlin metadata */
    private final TextView timeView;

    /* renamed from: E, reason: from kotlin metadata */
    private final MarqueeTextView lyricWidget;

    /* renamed from: F, reason: from kotlin metadata */
    private final TextView orderTv;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ImageView quietMusic;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final View orderLl;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final View pauseOrResumeBtnLl;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ImageView pauseOrResumeBtn;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final View nextPlayBtnLl;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String musicCoverUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ImageView imageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final MarqueeTextView musicName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView particleAnim;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final LottieAnimationView voiceLottie;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final GuildTopLinearGradientView gradientBg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final GuildListenRadialGradientView animView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IDynamicParams {
        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String event) {
            HashMap hashMap = new HashMap();
            if (m.k(j.c())) {
                hashMap.put("sgrp_user_type_list", "1");
            } else {
                hashMap.put("sgrp_user_type_list", "0");
            }
            return hashMap;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/listen/widget/ListenWidget$c", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GuildPicStateListener {
        c() {
            super(true);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            try {
                Bitmap resultBitMap = option.getResultBitMap();
                if (resultBitMap != null) {
                    ListenWidget.this.imageView.setImageBitmap(ListenWidget.this.f(resultBitMap));
                } else {
                    ListenWidget.this.imageView.setImageResource(R.drawable.guild_listen_default_cover);
                }
            } catch (OutOfMemoryError e16) {
                QLog.e("QGMC.MediaListen.ListenWidget", 1, "setMusicCover oom: " + e16);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ListenWidget(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ListenWidget this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickDynamicParams(this$0, "em_pg_sgrp_avchannel_musicplayer", new b());
        VideoReport.setElementEndExposePolicy(this$0, EndExposurePolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap f(Bitmap resource) {
        int width = resource.getWidth();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap circleBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleBitmap);
        float f16 = width / 2;
        canvas.drawCircle(f16, f16, f16, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(resource, 0.0f, 0.0f, paint);
        Intrinsics.checkNotNullExpressionValue(circleBitmap, "circleBitmap");
        return circleBitmap;
    }

    private final void n(String coverUrl) {
        if (Intrinsics.areEqual(this.musicCoverUrl, coverUrl)) {
            return;
        }
        this.musicCoverUrl = coverUrl;
        if (StringUtil.isEmpty(coverUrl)) {
            try {
                this.imageView.setImageResource(R.drawable.guild_listen_default_cover);
                return;
            } catch (OutOfMemoryError e16) {
                QLog.e("QGMC.MediaListen.ListenWidget", 1, "setMusicCover oom: " + e16);
                return;
            }
        }
        e.a().f(new Option().setUrl(this.musicCoverUrl), new c());
    }

    public final void e() {
        this.imageView.clearAnimation();
        this.animView.clearAnimation();
        this.animView2.clearAnimation();
        this.voiceLottie.pauseAnimation();
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final View getNextPlayBtnLl() {
        return this.nextPlayBtnLl;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final View getOrderLl() {
        return this.orderLl;
    }

    @NotNull
    public final Map<String, String> i() {
        HashMap hashMap = new HashMap();
        if (m.k(j.c())) {
            hashMap.put("sgrp_user_type_list", "1");
        } else {
            hashMap.put("sgrp_user_type_list", "0");
        }
        return hashMap;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final ImageView getPauseOrResumeBtn() {
        return this.pauseOrResumeBtn;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final View getPauseOrResumeBtnLl() {
        return this.pauseOrResumeBtnLl;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final ImageView getQuietMusic() {
        return this.quietMusic;
    }

    public final boolean m() {
        if (this.animView.getAnimation() != null) {
            return true;
        }
        return false;
    }

    public final void o(boolean isPlaying) {
        if (this.imageView.getAnimation() != null) {
            return;
        }
        if (isPlaying) {
            ImageView imageView = this.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
            ys1.c.d(imageView);
            this.voiceLottie.playAnimation();
        }
        if (this.animView.getAnimation() != null) {
            return;
        }
        measure(-2, -2);
        float measuredWidth = getMeasuredWidth();
        GuildListenRadialGradientView guildListenRadialGradientView = this.animView;
        TranslateAnimation translateAnimation = new TranslateAnimation(1.0f, measuredWidth, 1.0f, -(guildListenRadialGradientView.getLayoutParams().height * 2));
        translateAnimation.setDuration(8000L);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        translateAnimation.setInterpolator(new LinearInterpolator());
        guildListenRadialGradientView.startAnimation(translateAnimation);
        GuildListenRadialGradientView guildListenRadialGradientView2 = this.animView2;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1.0f, -measuredWidth, 1.0f, guildListenRadialGradientView2.getLayoutParams().height * 2);
        translateAnimation2.setDuration(8000L);
        translateAnimation2.setRepeatCount(-1);
        translateAnimation2.setRepeatMode(1);
        translateAnimation2.setInterpolator(new LinearInterpolator());
        guildListenRadialGradientView2.startAnimation(translateAnimation2);
        this.musicName.i();
        this.lyricWidget.i();
    }

    public final void p(@NotNull String musicDisplayName) {
        Intrinsics.checkNotNullParameter(musicDisplayName, "musicDisplayName");
        this.imageView.clearAnimation();
        this.voiceLottie.pauseAnimation();
        this.musicName.setText(getContext().getString(R.string.f14973133) + musicDisplayName);
        this.musicName.j();
        this.lyricWidget.j();
    }

    public final void setExInfo(@NotNull MusicInfo musicInfo) {
        Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
        n(musicInfo.getCoverUrl());
        setPlayNum(musicInfo.getOrderSongNum());
        this.musicName.setText(musicInfo.getMusicDisplayName());
        this.gradientBg.setColor(musicInfo.getBgStartColor(), musicInfo.getBgEndColor());
        this.animView.setColor(musicInfo.getBgStartColor(), musicInfo.getBgStartColor() & 16777215);
        this.animView2.setColor(musicInfo.getBgStartColor(), musicInfo.getBgStartColor() & 16777215);
    }

    public final void setLyricText(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.lyricWidget.setText(text);
    }

    public final void setMusicActionView(int isVisible) {
        this.pauseOrResumeBtnLl.setVisibility(isVisible);
        this.nextPlayBtnLl.setVisibility(isVisible);
    }

    public final void setPlayNum(int num) {
        if (num > 99) {
            this.orderTv.setText(getContext().getString(R.string.f1495912p));
        } else if (num < 0) {
            this.orderTv.setText(getContext().getString(R.string.f1496012q, 0));
        } else {
            this.orderTv.setText(getContext().getString(R.string.f1496012q, Integer.valueOf(num)));
        }
    }

    public final void setPlayTime(long curTime, long totalTime) {
        long j3 = 1000;
        long j16 = totalTime / j3;
        long j17 = 60;
        int i3 = (int) (j16 / j17);
        int i16 = (int) (j16 % j17);
        long j18 = curTime / j3;
        int i17 = (int) (j18 / j17);
        int i18 = (int) (j18 % j17);
        String str = "";
        if (i17 < 10) {
            str = "0";
        }
        String str2 = (str + i17) + ":";
        if (i18 < 10) {
            str2 = str2 + "0";
        }
        String str3 = (str2 + i18) + "/";
        if (i3 < 10) {
            str3 = str3 + "0";
        }
        String str4 = (str3 + i3) + ":";
        if (i16 < 10) {
            str4 = str4 + "0";
        }
        this.timeView.setText(str4 + i16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ListenWidget(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ListenWidget(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ListenWidget(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.f168125ey2, this);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.widget.b
            @Override // java.lang.Runnable
            public final void run() {
                ListenWidget.b(ListenWidget.this);
            }
        });
        this.imageView = (ImageView) findViewById(R.id.f166358zk3);
        this.musicName = (MarqueeTextView) findViewById(R.id.zkb);
        ImageView imageView = (ImageView) findViewById(R.id.f2260046);
        imageView.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable("https://downv6.qq.com/innovate/guild/media_game/guild_media_listen_particle.png", new ApngOptions()));
        this.particleAnim = imageView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) findViewById(R.id.zk9);
        lottieAnimationView.setAnimation(context.getString(R.string.f1496212s));
        this.voiceLottie = lottieAnimationView;
        this.gradientBg = (GuildTopLinearGradientView) findViewById(R.id.vrx);
        this.animView = (GuildListenRadialGradientView) findViewById(R.id.spl);
        this.animView2 = (GuildListenRadialGradientView) findViewById(R.id.spm);
        this.timeView = (TextView) findViewById(R.id.zkf);
        this.lyricWidget = (MarqueeTextView) findViewById(R.id.zk_);
        this.orderTv = (TextView) findViewById(R.id.f2148015);
        View findViewById = findViewById(R.id.yjz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.listen_quiet)");
        this.quietMusic = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.f2145012);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickDynamicParams(findViewById2, "em_pg_sgrp_avchannel_musicplayer_addsong", new b());
        VideoReport.setElementEndExposePolicy(findViewById2, EndExposurePolicy.REPORT_ALL);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(R.id.\u2026ePolicy.REPORT_ALL)\n    }");
        this.orderLl = findViewById2;
        View findViewById3 = findViewById(R.id.ymy);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ll_1)");
        this.pauseOrResumeBtnLl = findViewById3;
        View findViewById4 = findViewById(R.id.yjy);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.listen_pause_resume)");
        this.pauseOrResumeBtn = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.ymz);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.ll_2)");
        this.nextPlayBtnLl = findViewById5;
    }
}
