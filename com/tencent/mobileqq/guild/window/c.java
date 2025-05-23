package com.tencent.mobileqq.guild.window;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.util.CommonMMKVUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b)\b&\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001#B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b[\u0010\\J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0003H$J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0006H$J\b\u0010\u001a\u001a\u00020\u0006H$J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\u0006\u0010&\u001a\u00020\u000bJ\u0010\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016R\"\u00100\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00104\u001a\u00020\u000b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010+\u001a\u0004\b2\u0010-\"\u0004\b3\u0010/R\"\u0010<\u001a\u0002058\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010C\u001a\u00020\u00178\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010+R\"\u0010L\u001a\u00020\u001f8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010S\u001a\u00020!8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010Z\u001a\u00020\u00158\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/guild/window/c;", "Lcom/tencent/mobileqq/qqfloatingwindow/a;", "Lcom/tencent/mobileqq/guild/window/p;", "Lkotlin/Pair;", "", "q0", "", "B0", "Lcom/tencent/mobileqq/qqfloatingwindow/FloatingScreenParams;", "floatParams", "C0", "", "w0", "Landroid/content/Context;", "context", "B", "Landroid/view/View;", "customView", "j", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "quitWindowFloat", "", "u0", "Landroid/view/ViewGroup;", "p0", "A0", "y0", "innerRoundCorners", "outerRoundCorners", "setRoundCorners", "updateFloatingView", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "a", "b", "initStatusReceiver", "x0", "Landroid/os/Bundle;", "extra", "c", "e", "Z", "getMNeedShowOutsideQQ", "()Z", "H0", "(Z)V", "mNeedShowOutsideQQ", "f", "getMNoBgAndCorner", "I0", "mNoBgAndCorner", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "s0", "()Landroid/widget/ImageView;", "F0", "(Landroid/widget/ImageView;)V", "mFloatCloseBtn", "i", "Landroid/view/ViewGroup;", "getMContentView", "()Landroid/view/ViewGroup;", "E0", "(Landroid/view/ViewGroup;)V", "mContentView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mShowImmediately", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "t0", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "G0", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "mGuildInfo", "D", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "r0", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "D0", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;)V", "mChannelInfo", "E", "Ljava/lang/String;", "v0", "()Ljava/lang/String;", "J0", "(Ljava/lang/String;)V", "tag", "<init>", "(Landroid/content/Context;)V", "Companion", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class c extends com.tencent.mobileqq.qqfloatingwindow.a implements p {
    public static final long CHECK_DELAY_MILLIS = 3000;

    @NotNull
    public static final String KEY_SHOW_IMMEDIATELY = "key_show_immediately";

    /* renamed from: C, reason: from kotlin metadata */
    protected IGProGuildInfo mGuildInfo;

    /* renamed from: D, reason: from kotlin metadata */
    protected IGProChannelInfo mChannelInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String tag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedShowOutsideQQ;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mNoBgAndCorner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected ImageView mFloatCloseBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected ViewGroup mContentView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mShowImmediately;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/window/c$b", "Lgh2/f;", "", "c", "a", "", "canPlay", "d", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements gh2.f {
        b() {
        }

        @Override // gh2.f
        public void a() {
            Logger logger = Logger.f235387a;
            logger.d().i(c.this.getTag(), 1, "onWindowHide:");
            c.this.U(false);
        }

        @Override // gh2.f
        public void b() {
            Logger logger = Logger.f235387a;
            logger.d().i(c.this.getTag(), 1, "onWindowDismiss");
        }

        @Override // gh2.f
        public void c() {
            Logger logger = Logger.f235387a;
            logger.d().i(c.this.getTag(), 1, "onWindowPause:");
        }

        @Override // gh2.f
        public void d(boolean canPlay) {
            Logger logger = Logger.f235387a;
            String tag = c.this.getTag();
            logger.d().i(tag, 1, "onWindowShow: canPlay[" + canPlay + "]");
            if (!c.this.t() && c.this.u() != 0) {
                c.this.U(true);
            }
        }

        @Override // gh2.f
        public /* synthetic */ void e() {
            gh2.e.a(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mNeedShowOutsideQQ = true;
        this.mShowImmediately = true;
        this.tag = "GuildBaseFloatWrapper";
    }

    private final void B0() {
        if (!t() && p()) {
            Pair<String, String> u06 = u0();
            String component1 = u06.component1();
            String component2 = u06.component2();
            SharedPreferences.Editor edit = CommonMMKVUtils.fromSpAdapter(FloatingScreenParams.QQFS_SP_NAME).edit();
            edit.putInt(component1, r());
            edit.putInt(component2, s());
            edit.apply();
        }
    }

    private final void C0(FloatingScreenParams floatParams) {
        Pair<Integer, Integer> q06 = q0();
        int intValue = q06.component1().intValue();
        int intValue2 = q06.component2().intValue();
        if (intValue != Integer.MIN_VALUE && intValue2 != Integer.MIN_VALUE) {
            Intrinsics.checkNotNull(floatParams);
            floatParams.setFloatingCenterX(intValue);
            floatParams.setFloatingCenterY(intValue2);
        }
    }

    private final Pair<Integer, Integer> q0() {
        Pair<String, String> u06 = u0();
        String component1 = u06.component1();
        String component2 = u06.component2();
        SharedPreferences fromSpAdapter = CommonMMKVUtils.fromSpAdapter(FloatingScreenParams.QQFS_SP_NAME);
        return new Pair<>(Integer.valueOf(fromSpAdapter.getInt(component1, Integer.MIN_VALUE)), Integer.valueOf(fromSpAdapter.getInt(component2, Integer.MIN_VALUE)));
    }

    private final boolean w0() {
        return !GuildFloatWindowManager.f236656d.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Foreground.getActivityCount() == 0) {
            boolean w06 = this$0.w0();
            Logger logger = Logger.f235387a;
            String str = this$0.tag;
            logger.d().i(str, 1, "onForceCloseFloatWindow: (delayed) shouldExit=" + w06);
            if (w06) {
                this$0.y0();
            }
        }
    }

    protected abstract void A0();

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public void B(@Nullable Context context) {
        super.B(context);
        View A = A(tp1.a.d());
        Intrinsics.checkNotNull(A, "null cannot be cast to non-null type android.widget.ImageView");
        F0((ImageView) A);
    }

    protected final void D0(@NotNull IGProChannelInfo iGProChannelInfo) {
        Intrinsics.checkNotNullParameter(iGProChannelInfo, "<set-?>");
        this.mChannelInfo = iGProChannelInfo;
    }

    protected final void E0(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.mContentView = viewGroup;
    }

    protected final void F0(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.mFloatCloseBtn = imageView;
    }

    protected final void G0(@NotNull IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(iGProGuildInfo, "<set-?>");
        this.mGuildInfo = iGProGuildInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void H0(boolean z16) {
        this.mNeedShowOutsideQQ = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I0(boolean z16) {
        this.mNoBgAndCorner = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tag = str;
    }

    @Override // com.tencent.mobileqq.guild.window.p
    public void a(@NotNull IGProGuildInfo guildInfo, @NotNull IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        G0(guildInfo);
        D0(channelInfo);
    }

    @Override // com.tencent.mobileqq.guild.window.p
    public boolean b() {
        Logger logger = Logger.f235387a;
        logger.d().i(this.tag, 1, "onForceCloseFloatWindow: force close, check later");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.window.b
            @Override // java.lang.Runnable
            public final void run() {
                c.z0(c.this);
            }
        }, 3000L);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.window.p
    public void c(@NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.mShowImmediately = extra.getBoolean(KEY_SHOW_IMMEDIATELY, true);
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.a
    public void initStatusReceiver() {
        if (this.mNeedShowOutsideQQ) {
            return;
        }
        g(-1, new b());
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a
    public int j(@Nullable FloatingScreenParams floatParams, @NotNull View customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        Logger logger = Logger.f235387a;
        String str = this.tag;
        logger.d().i(str, 1, "enterWindowFloat: " + floatParams);
        C0(floatParams);
        ViewGroup viewGroup = (ViewGroup) customView;
        E0(viewGroup);
        int j3 = super.j(floatParams, customView);
        I();
        if (!this.mShowImmediately) {
            U(false);
        }
        p0(viewGroup);
        return j3;
    }

    protected void p0(@NotNull ViewGroup customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void quitWindowFloat(int closeReason) {
        Logger logger = Logger.f235387a;
        String str = this.tag;
        logger.d().i(str, 1, "quitWindowFloat: " + closeReason);
        B0();
        A0();
        super.quitWindowFloat(closeReason);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final IGProChannelInfo r0() {
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        if (iGProChannelInfo != null) {
            return iGProChannelInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ImageView s0() {
        ImageView imageView = this.mFloatCloseBtn;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mFloatCloseBtn");
        return null;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void setRoundCorners(int innerRoundCorners, int outerRoundCorners) {
        if (!this.mNoBgAndCorner) {
            super.setRoundCorners(innerRoundCorners, outerRoundCorners);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final IGProGuildInfo t0() {
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        if (iGProGuildInfo != null) {
            return iGProGuildInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
        return null;
    }

    @NotNull
    protected abstract Pair<String, String> u0();

    @Override // com.tencent.mobileqq.qqfloatingwindow.a, fh2.b
    public void updateFloatingView() {
        if (this.mNoBgAndCorner) {
            T(0, 0, 0, 0);
        }
        U(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: v0, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    public final boolean x0() {
        return QBaseActivity.mAppForground;
    }

    protected abstract void y0();
}
