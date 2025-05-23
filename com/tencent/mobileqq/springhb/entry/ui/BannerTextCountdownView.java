package com.tencent.mobileqq.springhb.entry.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tR\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/ui/BannerTextCountdownView;", "Landroid/widget/TextView;", "", "timeSecond", "", "d", "countDownCostMs", "", "e", "", "pause", "f", "", "Ljava/lang/CharSequence;", "c", "()Ljava/lang/CharSequence;", "setDefaultText", "(Ljava/lang/CharSequence;)V", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setCountDownPreText", "(Ljava/lang/String;)V", "countDownPreText", "J", "getInterval", "()J", "setInterval", "(J)V", WidgetCacheConstellationData.INTERVAL, "Landroid/os/CountDownTimer;", h.F, "Landroid/os/CountDownTimer;", "timerCountDown", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes18.dex */
public final class BannerTextCountdownView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence defaultText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String countDownPreText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long interval;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CountDownTimer timerCountDown;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/springhb/entry/ui/BannerTextCountdownView$a;", "", "", "DEFAULT_INTERVAL", "J", "", "LOG_INTERVAL", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.entry.ui.BannerTextCountdownView$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/springhb/entry/ui/BannerTextCountdownView$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends CountDownTimer {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BannerTextCountdownView f289153a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(long j3, BannerTextCountdownView bannerTextCountdownView, long j16) {
            super(j3, j16);
            this.f289153a = bannerTextCountdownView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), bannerTextCountdownView, Long.valueOf(j16));
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            BannerTextCountdownView bannerTextCountdownView = this.f289153a;
            bannerTextCountdownView.setText(bannerTextCountdownView.c());
            QLog.i("SpringHb_BannerTextCountdownView", 1, "onFinish");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, millisUntilFinished);
                return;
            }
            long j3 = 1000;
            if (millisUntilFinished % j3 == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            long j16 = (millisUntilFinished / j3) + i3;
            BannerTextCountdownView bannerTextCountdownView = this.f289153a;
            bannerTextCountdownView.setText(bannerTextCountdownView.b() + this.f289153a.d(j16));
            if (j16 % 10 == 0) {
                QLog.i("SpringHb_BannerTextCountdownView", 1, "countDownText:" + ((Object) this.f289153a.getText()));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerTextCountdownView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(long timeSecond) {
        long j3 = 60;
        long j16 = timeSecond / j3;
        long j17 = timeSecond % j3;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j16), Long.valueOf(j17)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public static /* synthetic */ void g(BannerTextCountdownView bannerTextCountdownView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        bannerTextCountdownView.f(z16);
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.countDownPreText;
    }

    @NotNull
    public final CharSequence c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.defaultText;
    }

    public final void e(long countDownCostMs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, countDownCostMs);
            return;
        }
        QLog.i("SpringHb_BannerTextCountdownView", 1, "startCountDown countDownCostMs:" + countDownCostMs + " countDownPreText:" + this.countDownPreText);
        f(true);
        this.timerCountDown = new b(countDownCostMs, this, this.interval).start();
    }

    public final void f(boolean pause) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, pause);
            return;
        }
        CountDownTimer countDownTimer = this.timerCountDown;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timerCountDown = null;
        if (!pause && !Intrinsics.areEqual(getText(), this.defaultText)) {
            setText(this.defaultText);
        }
        QLog.i("SpringHb_BannerTextCountdownView", 1, "stopCountDown pause:" + pause);
    }

    public final void setCountDownPreText(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.countDownPreText = str;
        }
    }

    public final void setDefaultText(@NotNull CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) charSequence);
        } else {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.defaultText = charSequence;
        }
    }

    public final void setInterval(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.interval = j3;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerTextCountdownView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ BannerTextCountdownView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BannerTextCountdownView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.defaultText = "";
        this.countDownPreText = "";
        this.interval = 1000L;
    }
}
