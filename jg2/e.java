package jg2;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.tencent.ecommerce.biz.vibration.api.IECVibrationApi;
import com.tencent.ecommerce.biz.vibration.api.VibrationMode;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Ljg2/e;", "Lcom/tencent/ecommerce/biz/vibration/api/IECVibrationApi;", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/vibration/api/VibrationMode;", "mode", "", "b", "vibrate", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e implements IECVibrationApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f409901a;

        static {
            int[] iArr = new int[VibrationMode.values().length];
            try {
                iArr[VibrationMode.HEAVY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VibrationMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[VibrationMode.MEDIUM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[VibrationMode.WARNING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[VibrationMode.LIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[VibrationMode.SUCCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f409901a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(e this$0, Context context, VibrationMode mode) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(mode, "$mode");
        this$0.b(context, mode);
    }

    @Override // com.tencent.ecommerce.biz.vibration.api.IECVibrationApi
    public void vibrate(final Context context, final VibrationMode mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mode, "mode");
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: jg2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.c(e.this, context, mode);
            }
        });
    }

    private final void b(Context context, VibrationMode mode) {
        VibrationEffect createWaveform;
        VibrationEffect createPredefined;
        try {
            Object systemService = MobileQQ.sMobileQQ.getApplicationContext().getSystemService("vibrator");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
            Vibrator vibrator = (Vibrator) systemService;
            int i3 = Build.VERSION.SDK_INT;
            int i16 = 2;
            if (i3 >= 29) {
                switch (b.f409901a[mode.ordinal()]) {
                    case 1:
                    case 2:
                        i16 = 1;
                        break;
                    case 3:
                    case 4:
                        i16 = 0;
                        break;
                    case 5:
                    case 6:
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                createPredefined = VibrationEffect.createPredefined(i16);
                vibrator.vibrate(createPredefined);
                return;
            }
            long j3 = 10;
            if (i3 >= 26) {
                switch (b.f409901a[mode.ordinal()]) {
                    case 1:
                    case 2:
                        createWaveform = VibrationEffect.createWaveform(new long[]{20, 10}, new int[]{255, 63}, -1);
                        break;
                    case 3:
                    case 4:
                        createWaveform = VibrationEffect.createWaveform(new long[]{20, 10}, new int[]{127, 63}, -1);
                        break;
                    case 5:
                    case 6:
                        createWaveform = VibrationEffect.createWaveform(new long[]{20}, new int[]{127}, -1);
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                vibrator.vibrate(createWaveform);
                return;
            }
            switch (b.f409901a[mode.ordinal()]) {
                case 1:
                case 2:
                    j3 = 50;
                    break;
                case 3:
                case 4:
                    j3 = 20;
                    break;
                case 5:
                case 6:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            vibrator.vibrate(j3);
        } catch (Exception e16) {
            QLog.e("ECVibrationApi", 1, "vibrate failed, err=" + e16);
        }
    }
}
