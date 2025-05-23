package com.tencent.sqshow.zootopia.nativeui.view.experience;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.t;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.be;
import uv4.au;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\u0004H\u0014J\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/experience/ExperienceCountdownView;", "Landroid/widget/LinearLayout;", "", IOnlineStatusService.REMAIN_TIME, "", "j", "", "i", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "e", NodeProps.ON_DETACHED_FROM_WINDOW, tl.h.F, "Ln74/be;", "d", "Ln74/be;", "viewBinding", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "countDownTimer", "Landroidx/lifecycle/Observer;", "Luv4/au;", "f", "Landroidx/lifecycle/Observer;", "colorConfigObserver", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ExperienceCountdownView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final be viewBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Observer<au> colorConfigObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/experience/ExperienceCountdownView$a", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ExperienceCountdownView f371861a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j3, ExperienceCountdownView experienceCountdownView) {
            super(j3, 1000L);
            this.f371861a = experienceCountdownView;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f371861a.viewBinding.f418823c.setText("\u67d3\u8272\u5df2\u5230\u671f");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            this.f371861a.viewBinding.f418823c.setText(this.f371861a.i(millisUntilFinished));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExperienceCountdownView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(com.tencent.sqshow.zootopia.nativeui.data.j channel, ExperienceCountdownView this$0, View view) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(channel, "$channel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ga4.j jVar = ga4.j.f401682a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        a16 = jVar.a(8, channel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
        a16.show();
        ZplanViewReportHelper mReporter = channel.getReporter().getMReporter();
        View root = this$0.viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        ZplanViewReportHelper.f(mReporter, root, "em_zplan_dye_fade_renewal", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ExperienceCountdownView this$0, au auVar) {
        qu4.f fVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j3 = ((auVar == null || (fVar = auVar.f440232a) == null) ? 0L : fVar.f429591b) * 1000;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (j3 < serverTimeMillis) {
            this$0.viewBinding.f418823c.setText("\u67d3\u8272\u5df2\u5230\u671f");
            return;
        }
        long j16 = j3 - serverTimeMillis;
        this$0.viewBinding.f418823c.setText(this$0.i(j16));
        if (j16 < 86400000) {
            this$0.j(j16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence i(long remainTime) {
        String string = getContext().getString(R.string.xld, t.f373300a.c(remainTime / 1000));
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026rd_countdown, timeByHour)");
        return string;
    }

    private final void j(long remainTime) {
        if (this.countDownTimer == null) {
            this.countDownTimer = new a(remainTime, this);
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public final void e(final com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        LifecycleOwner lifecycleOwner = channel.getLifecycleOwner();
        if (lifecycleOwner != null) {
            m.f371882a.a().observe(lifecycleOwner, this.colorConfigObserver);
        }
        View root = this.viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        aa.d(root, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExperienceCountdownView.f(com.tencent.sqshow.zootopia.nativeui.data.j.this, this, view);
            }
        });
        ZplanViewReportHelper mReporter = channel.getReporter().getMReporter();
        View root2 = this.viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "viewBinding.root");
        mReporter.g(root2, "em_zplan_dye_fade_renewal", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    public final void h() {
        m.f371882a.a().removeObserver(this.colorConfigObserver);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public /* synthetic */ ExperienceCountdownView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExperienceCountdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        be f16 = be.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.viewBinding = f16;
        this.colorConfigObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ExperienceCountdownView.g(ExperienceCountdownView.this, (au) obj);
            }
        };
        setBackgroundResource(R.drawable.h3x);
    }
}
