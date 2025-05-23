package mqq.util;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lmqq/util/AIOLocalActivityUtils;", "", "()V", "LOCAL_ACTIVITY_CLASSNAME", "", "isLifecycleBlackListActivity", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "mqq_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class AIOLocalActivityUtils {

    @NotNull
    public static final AIOLocalActivityUtils INSTANCE = new AIOLocalActivityUtils();

    @NotNull
    private static final String LOCAL_ACTIVITY_CLASSNAME = "com.tencent.qqnt.aio.localactivity.AIOLocalActivity";

    AIOLocalActivityUtils() {
    }

    public final boolean isLifecycleBlackListActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return TextUtils.equals(LOCAL_ACTIVITY_CLASSNAME, activity.getClass().getName());
    }
}
