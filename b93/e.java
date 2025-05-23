package b93;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00052\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lb93/e;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "d", "c", "b", "Lcom/tencent/mobileqq/wink/event/WinkFinishActivityEvent;", "event", "a", "", "traceId", "", "e", "Z", "needFinish", "isFront", "Lcom/tencent/mobileqq/wink/event/WinkFinishActivityEvent;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean needFinish;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isFront;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WinkFinishActivityEvent event;

    private final void d(Activity activity) {
        Intent data;
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            try {
                WinkFinishActivityEvent winkFinishActivityEvent = this.event;
                if (winkFinishActivityEvent != null && (data = winkFinishActivityEvent.getData()) != null) {
                    activity.setResult(winkFinishActivityEvent.getResultCode(), data);
                }
                activity.finish();
            } catch (Exception e16) {
                QLog.e("WinkFinishHelper", 1, "[finish]", e16);
            }
        }
    }

    public final void a(@Nullable Activity activity, @NotNull WinkFinishActivityEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!event.getIsForceFinish() && WinkContext.INSTANCE.d().m().f()) {
            QLog.i("WinkFinishHelper", 1, "[doFinish] not force finish and intercept");
            return;
        }
        this.event = event;
        if (event.getIsDirectFinish()) {
            QLog.i("WinkFinishHelper", 1, "[doFinish] direct finish");
            d(activity);
            this.needFinish = false;
        } else if (this.isFront) {
            QLog.i("WinkFinishHelper", 1, "[doFinish] front, need finish");
            this.needFinish = true;
        } else {
            QLog.i("WinkFinishHelper", 1, "[doFinish] not front, no need finish");
            this.needFinish = false;
            d(activity);
        }
    }

    public final void b(@Nullable Activity activity) {
        QLog.i("WinkFinishHelper", 1, "[doOnPause] needFinish=" + this.needFinish);
        this.isFront = false;
        if (this.needFinish) {
            d(activity);
        }
        this.needFinish = false;
    }

    public final void c() {
        this.isFront = true;
    }

    public final boolean e(@NotNull WinkFinishActivityEvent event, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (event.getData() == null || TextUtils.isEmpty(event.getData().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID)) || Intrinsics.areEqual(event.getData().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID), traceId)) {
            return true;
        }
        QLog.i("WinkFinishHelper", 1, "isWinkExitFromEvent, data: " + event.getData().getExtras() + ", traceID: " + traceId);
        return false;
    }
}
