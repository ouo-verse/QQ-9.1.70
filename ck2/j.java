package ck2;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.peak.PeakConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lck2/j;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f31048a = new j();

    j() {
    }

    public final boolean a(@Nullable Activity activity) {
        boolean z16;
        boolean z17;
        Intent intent;
        if (activity != null && (intent = activity.getIntent()) != null && intent.getIntExtra(PeakConstants.KEY_PIC_TO_EDIT_FROM, 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intent intent2 = activity.getIntent();
            if (intent2 != null && intent2.getBooleanExtra(PeakConstants.IS_SEND_TO_AIO, false)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }
}
