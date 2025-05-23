package com.tencent.mobileqq.guild.window;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.avbiz.Constants;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a2\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004\u001a\u0006\u0010\u000b\u001a\u00020\u0006\u001a\u0006\u0010\f\u001a\u00020\u0006\u001a\u0006\u0010\r\u001a\u00020\u0006\u001a\u0006\u0010\u000e\u001a\u00020\t\u001a \u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a*\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004\u001a\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0002\u001a \u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0002\u001aT\u0010!\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u0006H\u0007\u001a&\u0010#\u001a\u00020\t2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020\u0006H\u0007\u001a\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002\u001a*\u0010&\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010%\u001a\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0010\u0010'\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002\u001a\u0006\u0010(\u001a\u00020\t\u001a\u0006\u0010)\u001a\u00020\t\u001a\u0018\u0010-\u001a\u00020\u00192\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u0019\u001a \u0010.\u001a\u00020\u00192\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0010\u00100\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0019\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "", "newThemeType", "", "showDefault", "oldThemeType", "", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "v", "B", "orientation", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "k", "screenWidth", "screenHeight", "i", "j", "Landroid/view/View;", "customView", "isHorizontal", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "fragView", "needAnim", "finishActivity", HippyTKDListViewAdapter.X, "showImmediately", "G", DomainData.DOMAIN_NAME, "floatParams", "D", tl.h.F, "o", "p", "Landroid/content/Context;", "context", "liveView", "f", "g", "childView", ReportConstant.COSTREPORT_PREFIX, "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "GuildFloatWindowUtils")
/* loaded from: classes7.dex */
public final class GuildFloatWindowUtils {
    public static final void A(View view, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
        List listOf;
        boolean z16;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Constants.Business.QQ_GUILD_LIVE_AUTHOR, Constants.Business.QQ_GUILD_LIVE_VIEWER});
        List list = listOf;
        int i3 = 1;
        boolean z17 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (com.tencent.mobileqq.guild.util.h.f((String) it.next())) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            QLog.w("GuildFloatWindowUtil", 1, "[showGuildLiveFloatWindow] hasAVFocus false!");
            GLiveChannelCore.f226698a.b("no av focus");
            return;
        }
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && topActivity.getRequestedOrientation() == 0) {
            z17 = true;
        }
        if (z17) {
            i3 = 2;
        }
        D(view, j(i3), iGProGuildInfo, iGProChannelInfo);
    }

    public static final boolean B(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Logger logger = Logger.f235387a;
        logger.d().i("GuildFloatWindowUtil", 1, "showGuildPlayFloatWindow");
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildPlayTogetherFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildPlayTogetherFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name)) {
            return false;
        }
        logger.d().i("GuildFloatWindowUtil", 1, "real showGuildPlayFloatWindow");
        FloatingScreenParams floatParams = new FloatingScreenParams.FloatingBuilder().setShapeType(4).setCustomSize(ViewUtils.dip2px(94.0f), ViewUtils.dip2px(94.0f)).setCanMove(true).setCanZoom(false).setWindowFlags(131072).build();
        View a16 = GuildPlayTogetherFloatWrapper.INSTANCE.a();
        String name2 = GuildPlayTogetherFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "GuildPlayTogetherFloatWrapper::class.java.name");
        Intrinsics.checkNotNullExpressionValue(floatParams, "floatParams");
        Bundle bundle = new Bundle();
        bundle.putBoolean(c.KEY_SHOW_IMMEDIATELY, z16);
        Unit unit = Unit.INSTANCE;
        boolean m3 = GuildFloatWindowManager.m(guildFloatWindowManager, a16, name2, floatParams, guildInfo, channelInfo, bundle, null, 64, null);
        if (m3 && i3 != 6 && i3 != 0) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.window.k
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFloatWindowUtils.C();
                }
            });
        }
        return m3;
    }

    public static final void C() {
        QQGuildUIUtil.T(80L);
    }

    public static final View D(View view, FloatingScreenParams floatingScreenParams, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo) {
        BaseApplication floatContext = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(floatContext, "floatContext");
        View f16 = f(floatContext, view);
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildLiveChannelFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildLiveChannelFloatWrapper::class.java.name");
        GuildFloatWindowManager.m(guildFloatWindowManager, f16, name, floatingScreenParams, iGProGuildInfo, iGProChannelInfo, null, null, 96, null);
        return f16;
    }

    public static final void E(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, int i3, boolean z16, int i16) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        if (com.tencent.mobileqq.guild.media.core.j.a().H0().A(false)) {
            G(guildInfo, channelInfo, z16);
            return;
        }
        if (i3 != 2) {
            if (i3 != 6) {
                t(guildInfo, channelInfo, z16);
            } else {
                B(guildInfo, channelInfo, z16, i16);
            }
        } else {
            v(guildInfo, channelInfo, z16);
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "showFloatWindow | type " + com.tencent.mobileqq.guild.media.core.j.c().T().getValue();
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildFloatWindowUtil", 1, (String) it.next(), null);
        }
    }

    public static /* synthetic */ void F(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, int i3, boolean z16, int i16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z16 = true;
        }
        if ((i17 & 16) != 0) {
            i16 = 0;
        }
        E(iGProGuildInfo, iGProChannelInfo, i3, z16, i16);
    }

    @JvmOverloads
    public static final void G(@Nullable IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, boolean z16) {
        View b16;
        FloatingScreenParams k3;
        com.tencent.mobileqq.guild.safety.j.d("GuildFloatWindowUtils", "showScreenShareFloatWindow | invoke");
        if (iGProGuildInfo != null && iGProChannelInfo != null) {
            if (!com.tencent.mobileqq.guild.media.core.j.a().H0().A(false)) {
                u(iGProGuildInfo, iGProChannelInfo, false, 4, null);
                return;
            }
            GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
            String name = GuildScreenShareFloatWrapper.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "GuildScreenShareFloatWrapper::class.java.name");
            if (guildFloatWindowManager.j(name)) {
                return;
            }
            int i3 = 1;
            if (com.tencent.mobileqq.guild.media.core.j.a().H0().C()) {
                b16 = LayoutInflater.from(BaseApplication.context).inflate(R.layout.f7p, (ViewGroup) null);
            } else {
                b16 = b.a.b(com.tencent.mobileqq.guild.media.core.j.a().H0(), false, 1, null);
            }
            if (b16 == null) {
                return;
            }
            com.tencent.mobileqq.guild.safety.j.d("GuildFloatWindowUtils", "showScreenShareFloatWindow | real show floatwindow");
            BaseApplication floatContext = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(floatContext, "floatContext");
            View g16 = g(floatContext, b16, iGProChannelInfo);
            com.tencent.mobileqq.guild.media.core.data.p m3 = com.tencent.mobileqq.guild.media.core.j.a().H0().m(false);
            if (m3 == null) {
                return;
            }
            int i16 = m3.f228106n;
            if (i16 == 0) {
                k3 = k(1);
            } else {
                if (i16 >= m3.f228107o) {
                    i3 = 2;
                }
                k3 = k(i3);
            }
            FloatingScreenParams floatingScreenParams = k3;
            String name2 = GuildScreenShareFloatWrapper.class.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "GuildScreenShareFloatWrapper::class.java.name");
            Bundle bundle = new Bundle();
            bundle.putBoolean(c.KEY_SHOW_IMMEDIATELY, z16);
            Unit unit = Unit.INSTANCE;
            GuildFloatWindowManager.m(guildFloatWindowManager, g16, name2, floatingScreenParams, iGProGuildInfo, iGProChannelInfo, bundle, null, 64, null);
        }
    }

    @NotNull
    public static final View f(@NotNull Context context, @Nullable View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(R.id.wmg);
        frameLayout.setBackgroundColor(-16777216);
        if (view != null) {
            s(view);
            view.setId(R.id.f165564wo4);
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
        return frameLayout;
    }

    @NotNull
    public static final View g(@NotNull Context context, @Nullable View view, @NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(R.id.wmg);
        relativeLayout.setBackgroundColor(-16777216);
        relativeLayout.setGravity(16);
        if (view != null) {
            s(view);
            view.setId(R.id.f165564wo4);
            relativeLayout.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.guild_screen_share_gradient_bg);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(46.0f));
        layoutParams.addRule(12);
        Unit unit = Unit.INSTANCE;
        relativeLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(context);
        imageView2.setBackgroundResource(R.drawable.guild_media_mic_on);
        imageView2.setId(R.id.wzf);
        int dpToPx = ViewUtils.dpToPx(23.0f);
        int dpToPx2 = ViewUtils.dpToPx(7.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams2.addRule(12);
        layoutParams2.addRule(9);
        layoutParams2.setMargins(ViewUtils.dpToPx(4.0f), 0, 0, dpToPx2);
        relativeLayout.addView(imageView2, layoutParams2);
        TextView textView = new TextView(context);
        if (com.tencent.mobileqq.guild.media.core.j.a().H0().C()) {
            textView.setText("\u5c4f\u5e55\u5171\u4eab\u4e2d...");
        } else {
            textView.setText(channelInfo.getChannelName());
        }
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        float ascent = dpToPx2 - (((textView.getPaint().getFontMetrics().descent - textView.getPaint().ascent()) - dpToPx) / 2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(12);
        layoutParams3.addRule(1, imageView2.getId());
        layoutParams3.setMargins(ViewUtils.dpToPx(3.0f), 0, 0, (int) ascent);
        relativeLayout.addView(textView, layoutParams3);
        return relativeLayout;
    }

    public static final void h(FragmentActivity fragmentActivity) {
        if (AppSetting.t(fragmentActivity) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isSplashActivity(fragmentActivity)) {
            fragmentActivity.onKeyDown(4, new KeyEvent(4, 4));
        } else {
            fragmentActivity.finish();
            fragmentActivity.overridePendingTransition(0, 0);
        }
    }

    private static final FloatingScreenParams i(int i3, int i16, int i17) {
        int roundToInt;
        int i18;
        int coerceAtLeast;
        int i19 = (int) (i3 * 0.56d);
        if (com.tencent.mobileqq.pad.c.e(QBaseActivity.sTopActivity)) {
            i19 /= 2;
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(i19 / 1.7777778f);
        if (i16 == 1) {
            roundToInt = (int) (i17 * 0.27d);
            i19 = (int) (roundToInt * 0.5625f);
            i18 = 2;
        } else {
            i18 = 1;
        }
        FloatingScreenParams floatParams = new FloatingScreenParams.FloatingBuilder().setShapeType(i18).setCustomSize(i19, roundToInt).setCanMove(true).setCanZoom(true).build();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i19, roundToInt);
        floatParams.setScreenLonger(coerceAtLeast);
        floatParams.setShapeType(i18);
        Intrinsics.checkNotNullExpressionValue(floatParams, "floatParams");
        return floatParams;
    }

    public static final FloatingScreenParams j(int i3) {
        return i(bv.b(BaseApplication.getContext()), i3, bv.a(BaseApplication.getContext()));
    }

    private static final FloatingScreenParams k(int i3) {
        int b16;
        int a16;
        if (BaseApplication.context.getResources().getConfiguration().orientation == 1) {
            b16 = bv.a(BaseApplication.getContext());
        } else {
            b16 = bv.b(BaseApplication.getContext());
        }
        if (BaseApplication.context.getResources().getConfiguration().orientation == 1) {
            a16 = bv.b(BaseApplication.getContext());
        } else {
            a16 = bv.a(BaseApplication.getContext());
        }
        return i(a16, i3, b16);
    }

    public static final boolean l() {
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildLiveChannelFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildLiveChannelFloatWrapper::class.java.name");
        boolean j3 = guildFloatWindowManager.j(name);
        QLog.i("GuildFloatWindowUtil", 1, "[isLiveFloatWindowShowing] ret: " + j3);
        return j3;
    }

    public static final boolean m() {
        boolean z16;
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildScreenShareFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildScreenShareFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name)) {
            QLog.i("GuildFloatWindowUtil", 1, "[isMediaFloatWindowShowing] screen share");
            z16 = true;
        } else {
            z16 = false;
        }
        String name2 = GuildAudioChannelFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "GuildAudioChannelFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name2)) {
            QLog.i("GuildFloatWindowUtil", 1, "[isMediaFloatWindowShowing] normal audio room");
            z16 = true;
        }
        String name3 = GuildGameFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "GuildGameFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name3)) {
            QLog.i("GuildFloatWindowUtil", 1, "[isMediaFloatWindowShowing] game room");
            z16 = true;
        }
        String name4 = GuildPlayTogetherFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "GuildPlayTogetherFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name4)) {
            QLog.i("GuildFloatWindowUtil", 1, "[isMediaFloatWindowShowing] play room");
            z16 = true;
        }
        QLog.i("GuildFloatWindowUtil", 1, "[isMediaFloatWindowShowing] ret: " + z16);
        return z16;
    }

    private static final boolean n(FragmentActivity fragmentActivity) {
        if (fragmentActivity.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public static final void o() {
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildAudioChannelFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildAudioChannelFloatWrapper::class.java.name");
        guildFloatWindowManager.g(name);
    }

    public static final void p() {
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildLiveChannelFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildLiveChannelFloatWrapper::class.java.name");
        guildFloatWindowManager.g(name);
    }

    public static final void q() {
        if (MobileQQ.sProcessId != 1) {
            QLog.d("GuildFloatWindowUtil", 1, "\u975e\u4e3b\u8fdb\u7a0b");
            return;
        }
        if (!((IGuildUserService) ch.S0(IGuildUserService.class, "")).isGuildUser()) {
            QLog.d("GuildFloatWindowUtil", 1, "\u975e\u9891\u9053\u7528\u6237");
            return;
        }
        if (r()) {
            com.tencent.mobileqq.guild.media.core.j.a().D("", com.dataline.util.j.d("\u5c0f\u4e16\u754c\u64ad\u653e\u89c6\u9891\uff0c\u9000\u51fa\u97f3\u89c6\u9891\u60ac\u6d6e\u7a97"));
            return;
        }
        if (l()) {
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            if (gLiveChannelCore.s().getAnchorIsSelf() && gLiveChannelCore.r().d()) {
                return;
            }
            p();
            String d16 = com.dataline.util.j.d("\u5c0f\u4e16\u754c\u64ad\u653e\u89c6\u9891\uff0c\u9000\u51fa\u76f4\u64ad\u60ac\u6d6e\u7a97");
            Intrinsics.checkNotNullExpressionValue(d16, "replaceToDynamicNameText(\"\u5c0f\u4e16\u754c\u64ad\u653e\u89c6\u9891\uff0c\u9000\u51fa\u76f4\u64ad\u60ac\u6d6e\u7a97\")");
            gLiveChannelCore.b(d16);
        }
    }

    public static final boolean r() {
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildScreenShareFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildScreenShareFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name)) {
            GuildScreenShareFloatWrapper.INSTANCE.a();
            return true;
        }
        String name2 = GuildAudioChannelFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "GuildAudioChannelFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name2)) {
            GuildAudioChannelFloatWrapper.INSTANCE.b();
            return true;
        }
        String name3 = GuildGameFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "GuildGameFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name3)) {
            GuildGameFloatWrapper.INSTANCE.b();
            return true;
        }
        String name4 = GuildPlayTogetherFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "GuildPlayTogetherFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name4)) {
            GuildPlayTogetherFloatWrapper.INSTANCE.b();
            return true;
        }
        return false;
    }

    public static final void s(@Nullable View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (ClassCastException e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
        }
    }

    public static final boolean t(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Logger logger = Logger.f235387a;
        logger.d().i("GuildFloatWindowUtil", 1, "showGuildAudioFloatWindow");
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildAudioChannelFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildAudioChannelFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name)) {
            return false;
        }
        logger.d().i("GuildFloatWindowUtil", 1, "real showGuildAudioFloatWindow");
        FloatingScreenParams floatParams = new FloatingScreenParams.FloatingBuilder().setShapeType(4).setCustomSize(ViewUtils.dip2px(94.0f), ViewUtils.dip2px(94.0f)).setCanMove(true).setCanZoom(false).setWindowFlags(131072).build();
        View a16 = GuildAudioChannelFloatWrapper.INSTANCE.a();
        String name2 = GuildAudioChannelFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "GuildAudioChannelFloatWrapper::class.java.name");
        Intrinsics.checkNotNullExpressionValue(floatParams, "floatParams");
        Bundle bundle = new Bundle();
        bundle.putBoolean(c.KEY_SHOW_IMMEDIATELY, z16);
        Unit unit = Unit.INSTANCE;
        return GuildFloatWindowManager.m(guildFloatWindowManager, a16, name2, floatParams, guildInfo, channelInfo, bundle, null, 64, null);
    }

    public static /* synthetic */ boolean u(IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        return t(iGProGuildInfo, iGProChannelInfo, z16);
    }

    public static final boolean v(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        Logger logger = Logger.f235387a;
        logger.d().i("GuildFloatWindowUtil", 1, "showGuildGameFloatWindow");
        GuildFloatWindowManager guildFloatWindowManager = GuildFloatWindowManager.f236656d;
        String name = GuildGameFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildGameFloatWrapper::class.java.name");
        if (guildFloatWindowManager.j(name)) {
            return false;
        }
        logger.d().i("GuildFloatWindowUtil", 1, "real showGuildGameFloatWindow");
        FloatingScreenParams floatParams = new FloatingScreenParams.FloatingBuilder().setShapeType(4).setCustomSize(ViewUtils.dip2px(94.0f), ViewUtils.dip2px(94.0f)).setCanMove(true).setCanZoom(false).setWindowFlags(131072).build();
        View a16 = GuildGameFloatWrapper.INSTANCE.a();
        String name2 = GuildGameFloatWrapper.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "GuildGameFloatWrapper::class.java.name");
        Intrinsics.checkNotNullExpressionValue(floatParams, "floatParams");
        Bundle bundle = new Bundle();
        bundle.putBoolean(c.KEY_SHOW_IMMEDIATELY, z16);
        Unit unit = Unit.INSTANCE;
        return GuildFloatWindowManager.m(guildFloatWindowManager, a16, name2, floatParams, guildInfo, channelInfo, bundle, null, 64, null);
    }

    @JvmOverloads
    public static final void w(@Nullable View view, @Nullable IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, boolean z16, @Nullable FragmentActivity fragmentActivity, @Nullable View view2, boolean z17) {
        z(view, iGProGuildInfo, iGProChannelInfo, z16, fragmentActivity, view2, z17, false, 128, null);
    }

    @JvmOverloads
    public static final void x(@Nullable final View view, @Nullable final IGProGuildInfo iGProGuildInfo, @Nullable final IGProChannelInfo iGProChannelInfo, boolean z16, @Nullable final FragmentActivity fragmentActivity, @Nullable View view2, boolean z17, final boolean z18) {
        int roundToInt;
        final int i3 = 1;
        if (iGProChannelInfo != null && iGProGuildInfo != null) {
            if (l()) {
                return;
            }
            if (z16) {
                i3 = 2;
            }
            if (view != null && fragmentActivity != null && view2 != null && !fragmentActivity.isDestroyed()) {
                if (Build.VERSION.SDK_INT >= 26 && ((!Intrinsics.areEqual(GLiveChannelCore.f226698a.t().J().getValue(), Boolean.TRUE) || !n(fragmentActivity)) && z17 && y(view))) {
                    float a16 = (int) (bv.a(BaseApplication.getContext()) * 0.27d);
                    roundToInt = MathKt__MathJVMKt.roundToInt(a16 / 1.7777778f);
                    GuildFloatWindowAnimKt.c(view, new Function0<View>() { // from class: com.tencent.mobileqq.guild.window.GuildFloatWindowUtils$showGuildLiveFloatWindow$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final View invoke() {
                            FloatingScreenParams j3;
                            View D;
                            View view3 = view;
                            j3 = GuildFloatWindowUtils.j(i3);
                            D = GuildFloatWindowUtils.D(view3, j3, iGProGuildInfo, iGProChannelInfo);
                            return D;
                        }
                    }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.window.GuildFloatWindowUtils$showGuildLiveFloatWindow$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            if (z18) {
                                GuildFloatWindowUtils.h(fragmentActivity);
                            }
                        }
                    }, view2, a16 * 0.94f, roundToInt * 0.94f);
                    return;
                } else {
                    D(view, j(i3), iGProGuildInfo, iGProChannelInfo);
                    if (z18) {
                        h(fragmentActivity);
                        return;
                    }
                    return;
                }
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.window.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFloatWindowUtils.A(view, iGProGuildInfo, iGProChannelInfo);
                }
            });
            return;
        }
        QLog.d("GuildFloatWindowUtil", 1, "showGuildLiveFloatWindow info is null");
    }

    private static final boolean y(View view) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (!(childAt instanceof SurfaceView)) {
            return false;
        }
        return ((SurfaceView) childAt).getHolder().getSurface().isValid();
    }

    public static /* synthetic */ void z(View view, IGProGuildInfo iGProGuildInfo, IGProChannelInfo iGProChannelInfo, boolean z16, FragmentActivity fragmentActivity, View view2, boolean z17, boolean z18, int i3, Object obj) {
        boolean z19;
        if ((i3 & 128) != 0) {
            z19 = true;
        } else {
            z19 = z18;
        }
        x(view, iGProGuildInfo, iGProChannelInfo, z16, fragmentActivity, view2, z17, z19);
    }
}
