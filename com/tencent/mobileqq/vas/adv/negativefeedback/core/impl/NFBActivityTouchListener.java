package com.tencent.mobileqq.vas.adv.negativefeedback.core.impl;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.adv.negativefeedback.bean.NFBSessionInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mz2.b;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0019\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/negativefeedback/core/impl/NFBActivityTouchListener;", "", "", "event", "", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/MotionEvent;", "b", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/bean/NFBSessionInfo;", "a", "Lcom/tencent/mobileqq/vas/adv/negativefeedback/bean/NFBSessionInfo;", "sessionInfo", "", "I", "mDownX", "mDownY", "", "d", "Z", "mIsMoved", "e", "mClickCount", "f", "mSlideCount", "<init>", "(Lcom/tencent/mobileqq/vas/adv/negativefeedback/bean/NFBSessionInfo;)V", "g", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class NFBActivityTouchListener {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Lazy<Integer> f308117h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NFBSessionInfo sessionInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mDownX;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mDownY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMoved;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mClickCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mSlideCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/negativefeedback/core/impl/NFBActivityTouchListener$a;", "", "", "MOVE_SLOT$delegate", "Lkotlin/Lazy;", "b", "()I", "MOVE_SLOT", "MAX_CLICK_COUNT", "I", "MAX_SLIDE_COUNT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.negativefeedback.core.impl.NFBActivityTouchListener$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b() {
            return ((Number) NFBActivityTouchListener.f308117h.getValue()).intValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Integer> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.core.impl.NFBActivityTouchListener$Companion$MOVE_SLOT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewConfiguration.get(MobileQQ.sMobileQQ).getScaledTouchSlop());
            }
        });
        f308117h = lazy;
    }

    public NFBActivityTouchListener(@NotNull NFBSessionInfo sessionInfo) {
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        this.sessionInfo = sessionInfo;
    }

    private final void c(String event) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_END_DURATION_TIME, "0"), TuplesKt.to("delta_time", String.valueOf(System.currentTimeMillis() - this.sessionInfo.getStartTime())));
        b.f417903a.e(this.sessionInfo.c(), event, this.sessionInfo.getSessionId(), mapOf, this.sessionInfo.d());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        if (java.lang.Math.abs(((int) r8.getRawY()) - r6.mDownY) < r1.b()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
    
        if (java.lang.Math.abs(((int) r8.getRawY()) - r6.mDownY) < r4.b()) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(@NotNull Activity activity, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (QLog.isColorLevel()) {
                            QLog.d("NFBActivityTouchListener", 1, "FB rootView else onTouch: " + event);
                            return;
                        }
                        return;
                    }
                } else {
                    if (!this.mIsMoved) {
                        int abs = Math.abs(((int) event.getRawX()) - this.mDownX);
                        Companion companion = INSTANCE;
                        if (abs < companion.b()) {
                        }
                    }
                    z16 = true;
                    this.mIsMoved = z16;
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("NFBActivityTouchListener", 4, "FB rootView ACTION_UP|ACTION_CANCEL: " + event);
            }
            if (!this.mIsMoved) {
                int abs2 = Math.abs(((int) event.getRawX()) - this.mDownX);
                Companion companion2 = INSTANCE;
                if (abs2 < companion2.b()) {
                }
            }
            z16 = true;
            this.mIsMoved = z16;
            if (z16 && this.mSlideCount < 2) {
                c("pg_sld");
                this.mSlideCount++;
                return;
            }
            if (!z16 && this.mClickCount < 2) {
                c("pg_clk");
                this.mClickCount++;
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("NFBActivityTouchListener", 1, "FB report intercept, isMoved: " + this.mIsMoved + ", slideCount: " + this.mSlideCount + ", clickCount: " + this.mClickCount);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("NFBActivityTouchListener", 1, "FB rootView ACTION_DOWN: " + event);
        }
        this.mDownX = (int) event.getRawX();
        this.mDownY = (int) event.getRawY();
        this.mIsMoved = false;
    }
}
