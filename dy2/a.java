package dy2;

import android.app.Activity;
import android.content.res.Resources;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0010"}, d2 = {"Ldy2/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "degree", "", "c", "", "b", "d", "a", "I", "maxBrightness", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f395204a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int maxBrightness = -1;

    a() {
    }

    private final int b() {
        int i3 = maxBrightness;
        if (i3 != -1) {
            return i3;
        }
        try {
            Resources system = Resources.getSystem();
            int identifier = system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android");
            if (identifier != 0) {
                int integer = system.getInteger(identifier);
                maxBrightness = integer;
                return integer;
            }
            return 255;
        } catch (Exception unused) {
            return 255;
        }
    }

    private final void c(Activity activity, float degree) {
        if (!activity.isFinishing()) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = degree;
            window.setAttributes(attributes);
        }
    }

    public final float a(@NotNull Activity activity) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        float f16 = activity.getWindow().getAttributes().screenBrightness;
        double d16 = f16;
        boolean z17 = true;
        if (0.0d <= d16 && d16 <= 1.0d) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            try {
                f16 = Settings.System.getInt(activity.getContentResolver(), "screen_brightness", 127) / b();
            } catch (Exception unused) {
            }
        }
        double d17 = f16;
        if (0.0d > d17 || d17 > 1.0d) {
            z17 = false;
        }
        if (!z17) {
            return 0.5f;
        }
        return f16;
    }

    public final void d(@NotNull Activity activity, float degree) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        c(activity, degree);
    }
}
