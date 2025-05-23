package com.tencent.sqshow.zootopia.taskcenter.bubble;

import android.os.CountDownTimer;
import android.view.View;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.f;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/bubble/ZPlanBubbleRedDotController;", "", "", "time", "", "c", "Landroid/view/View;", "view", "totalTime", "", "d", "firstEnterTime", "firstTimeGap", "collTimeGap", "", "b", "<init>", "()V", "a", "DismissType", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanBubbleRedDotController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static CountDownTimer f373010b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/bubble/ZPlanBubbleRedDotController$DismissType;", "", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes34.dex */
    public @interface DismissType {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.f373011a;
        public static final String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
        public static final int TYPE_AUTO = 2;
        public static final int TYPE_CLICK = 1;
        public static final int TYPE_DEFAULT = -1;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/bubble/ZPlanBubbleRedDotController$DismissType$a;", "", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.taskcenter.bubble.ZPlanBubbleRedDotController$DismissType$a, reason: from kotlin metadata */
        /* loaded from: classes34.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f373011a = new Companion();

            Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\b\u0010\u0005\u001a\u00020\u0004H\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0004H\u0007R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/sqshow/zootopia/taskcenter/bubble/ZPlanBubbleRedDotController$a;", "", "", "d", "", "c", "type", "", "g", "time", "f", "Landroid/os/CountDownTimer;", SemanticAttributes.FaasTriggerValues.TIMER, "Landroid/os/CountDownTimer;", "e", "()Landroid/os/CountDownTimer;", "setTimer", "(Landroid/os/CountDownTimer;)V", "", "BUBBLE_DISMISS_TYPE", "Ljava/lang/String;", "INTERVALS", "J", "MIN_10", "MIN_5", "TAG", "TIME_BUBBLE_DISMISS", "TIME_FIRST_ENTER_PORTAL", "TOTAL_TIME", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.taskcenter.bubble.ZPlanBubbleRedDotController$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final long c() {
            return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getLong("time_bubble_dismiss", 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final int d() {
            return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getInt("bubble_dismiss_type", -1);
        }

        public final CountDownTimer e() {
            return ZPlanBubbleRedDotController.f373010b;
        }

        @JvmStatic
        public final void f(long time) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setLong("time_bubble_dismiss", time);
        }

        @JvmStatic
        public final void g(int type) {
            ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setInt("bubble_dismiss_type", type);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/sqshow/zootopia/taskcenter/bubble/ZPlanBubbleRedDotController$b", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f373012a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(View view, long j3) {
            super(j3, 1000L);
            this.f373012a = view;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (this.f373012a.getVisibility() == 0) {
                Companion companion = ZPlanBubbleRedDotController.INSTANCE;
                companion.g(2);
                companion.f(System.currentTimeMillis());
                this.f373012a.setVisibility(4);
                QLog.d("ZPlanRedDotView_ZPlanBubbleRedDotController", 1, "onFinish, hide view:" + this.f373012a);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            if (this.f373012a.getVisibility() != 0) {
                CountDownTimer e16 = ZPlanBubbleRedDotController.INSTANCE.e();
                if (e16 != null) {
                    e16.cancel();
                }
                QLog.d("ZPlanRedDotView_ZPlanBubbleRedDotController", 1, "setupAutoDismiss, view is invisible, cancel, millisUntilFinished:" + millisUntilFinished);
            }
            QLog.d("ZPlanRedDotView_ZPlanBubbleRedDotController", 1, "setupAutoDismiss, countDown, millisUntilFinished:" + millisUntilFinished);
        }
    }

    private final String c(long time) {
        return f.f373268a.a(time, DismissType.TIME_FORMAT);
    }

    public final void d(View view, long totalTime) {
        Intrinsics.checkNotNullParameter(view, "view");
        CountDownTimer countDownTimer = f373010b;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (totalTime != 0 && view.getVisibility() == 0) {
            f373010b = new b(view, 1000 * totalTime);
            QLog.d("ZPlanRedDotView_ZPlanBubbleRedDotController", 1, "setupAutoDismiss, countDown, time:" + totalTime);
            CountDownTimer countDownTimer2 = f373010b;
            if (countDownTimer2 != null) {
                countDownTimer2.start();
                return;
            }
            return;
        }
        QLog.d("ZPlanRedDotView_ZPlanBubbleRedDotController", 1, "setupAutoDismiss, dismiss time:" + totalTime + ", don't dismiss, or view is invisible, return");
    }

    public final boolean b(long firstEnterTime, long firstTimeGap, long collTimeGap) {
        if (firstTimeGap == 0 && collTimeGap == 0) {
            QLog.d("ZPlanRedDotView_ZPlanBubbleRedDotController", 1, "canShowBubble, collTimeGap time:" + collTimeGap + ", return true");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (firstTimeGap > 0 && currentTimeMillis - (firstEnterTime * 1000) < firstTimeGap * 1000) {
            QLog.d("ZPlanRedDotView_ZPlanBubbleRedDotController", 1, "currentTime\uff1a" + c(currentTimeMillis) + ", firstEnterTime: " + c(firstEnterTime) + ", firstEnterTimeGap:" + firstEnterTime + ", cannot show bubble");
            return false;
        }
        Companion companion = INSTANCE;
        int d16 = companion.d();
        long c16 = companion.c();
        if (d16 == 2 && collTimeGap > 0 && currentTimeMillis - c16 < collTimeGap * 1000) {
            QLog.d("ZPlanRedDotView_ZPlanBubbleRedDotController", 1, "clickType(1:click, 2:auto): " + d16 + ", currentTime\uff1a" + c(currentTimeMillis) + ", dismissTime: " + c(c16) + ", cannot show bubble");
            return false;
        }
        QLog.d("ZPlanRedDotView_ZPlanBubbleRedDotController", 1, "currentTime\uff1a" + c(currentTimeMillis) + ", firstEnterTime: " + c(firstEnterTime) + ", clickType(1:click, 2:auto): " + d16 + ", dismissTime: " + c(c16) + ", firstEnterTime:" + c(firstEnterTime * 1000) + ", local can show");
        return true;
    }
}
